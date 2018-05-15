package Server;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Server {

	private DatagramSocket socket;
	private Set<Client> clients = new HashSet<Client>();
	
	public Server(int port) {
		try {
			socket = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		start();
	}
	
	private void send(final Client client, final byte[] data) {
		DatagramPacket packet = new DatagramPacket(data, data.length, client.address, client.port);
		try {
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		while (true) {
			byte[] data = new byte[256];
			
			DatagramPacket packet = new DatagramPacket(data, data.length);
			try {
				socket.receive(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			processPacket(packet);
		}
		
	}
			
	private void processPacket(final DatagramPacket packet) {
		new Thread() {
			public void run() {
				Client sender = new Client(packet.getAddress(), packet.getPort());
				long currentTime = System.currentTimeMillis();

				if (!clients.contains(sender)) {
					sender.timeLastRecieved = currentTime;
					clients.add(sender);
					System.out.println("New client connect from: " + sender.address);
				}

				Iterator<Client> iterator = clients.iterator();
				while (iterator.hasNext()) {
					Client client = iterator.next();

					if (!client.equals(sender)) {
						send(client, packet.getData());
					}
				}
			}
		}.start();
	}
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: java Server [port]");
			return;
		}
		
		int port = Integer.parseInt(args[0]);
		new Server(port);
	}
}
