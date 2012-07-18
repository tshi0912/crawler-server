package cf.crawler.server.handlers;

import cf.crawler.server.tos.Ack;

public class ServerHandler {

	Ack handleMessage(){
		return new Ack(Ack.SUCCESS);
	}
	
}
