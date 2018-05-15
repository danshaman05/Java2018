package Server;

import java.net.InetAddress;

public class Client {
	
	public InetAddress address;
	public int port;

	public boolean alive;
	public long timeLastRecieved;
	
	public Client(InetAddress address, int port) {
		this.address = address;
		this.port = port;
		
		alive = true;
		this.timeLastRecieved = System.currentTimeMillis();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + port;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (port != other.port)
			return false;
		return true;
	}
	
	
}
