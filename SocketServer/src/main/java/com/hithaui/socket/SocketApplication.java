package com.hithaui.socket;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.Transport;
import com.corundumstudio.socketio.listener.DataListener;

public class SocketApplication {
	public static void startSocketApplication() {
		Configuration configuration = new Configuration();
		configuration.setHostname("localhost");
		configuration.setPort(8081);
		configuration.setTransports(Transport.POLLING);
		
		
		final SocketIOServer server = new SocketIOServer(configuration);
		
		server.addEventListener("message", Object.class, new DataListener<Object>() {
			@Override
			public void onData(SocketIOClient client, Object data, AckRequest ackSender) throws Exception {
				// TODO Auto-generated method stub
				
			}
		});
		
		server.addEventListener("message", Object.class, (client, data, ackSender) -> {
			System.out.println(data);
		});
		
		
		server.start();
		
	}
}
