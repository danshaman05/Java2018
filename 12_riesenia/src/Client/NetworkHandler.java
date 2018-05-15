package Client;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

public class NetworkHandler {
	
	DatagramSocket socket;
	InetAddress serverAddress;
	int port;
	
	boolean running = false;
	
	public NetworkHandler() {
		try {
			socket = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public void setServerAddress(String serverAddress) {
		try {
			this.serverAddress = InetAddress.getByName(serverAddress);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setServerPort(String serverPort) {
		port = Integer.parseInt(serverPort);
	}
	
	public void start() {
		running = true;
		new Thread() {
			public void run() {
				while (running) {
					byte[] data = new byte[256];
					DatagramPacket packet = new DatagramPacket(data, data.length);
					try {
						socket.receive(packet);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					processPacket(packet);
				}
			}
		}.start();
	}
	
	public void processPacket(DatagramPacket packet) {
		new Thread() {
			public void run() {
				byte[] data = packet.getData();

				byte[] x = new byte[Double.SIZE / 8];
				byte[] y = new byte[Double.SIZE / 8];
				System.arraycopy(data, 0, x, 0, Double.SIZE / 8);
				System.arraycopy(data, Double.SIZE / 8, y, 0, Double.SIZE / 8);
				
				double pos_x = ByteBuffer.wrap(x).asDoubleBuffer().get();
				double pos_y = ByteBuffer.wrap(y).asDoubleBuffer().get();
				System.out.println(pos_x + " " + pos_y);
			}
		}.start();
	}
	
	public void stop() {
		running = false;
	}
	
	public void send(byte[] data) {
		DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, port);
		try {
			socket.send(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendPlayer(Player player) {
		byte[] x = ByteBuffer.allocate(Double.SIZE / 8).putDouble(player.x).array();
		byte[] y = ByteBuffer.allocate(Double.SIZE / 8).putDouble(player.y).array();
		
		byte[] position = new byte[x.length + y.length];
		System.arraycopy(x, 0, position, 0, x.length);
		System.arraycopy(y, 0, position, x.length, y.length);

		send(position);
	}

}
