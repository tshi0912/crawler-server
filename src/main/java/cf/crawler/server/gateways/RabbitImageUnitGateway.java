package cf.crawler.server.gateways;

import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.core.support.RabbitGatewaySupport;
import org.springframework.beans.factory.annotation.Autowired;

import cf.crawler.server.services.CrawlerService;
import cf.crawler.server.tos.ImageUnit;

public class RabbitImageUnitGateway extends RabbitGatewaySupport 
	implements ImageUnitGateway {
	
	private static Log logger = LogFactory.getLog(RabbitImageUnitGateway.class); 

	@Autowired
	CrawlerService crawlerService;
	
	public void sendImageUnits() {
		sendImageUnits(null);
	}
	
	public void sendImageUnits(URL url) {
		ImageUnit[] ius = crawlerService.getImageUnits(url);
		if(ius==null || ius.length==0) {
			logger.info("Not found any image unit...");
			return;
		}
		
		logger.info("*** Sending Image Unit from " + ius[0].getFrom() + " ***");
		for(int i=0; i<ius.length;i++){
			if(ius[i]==null){
				if(logger.isDebugEnabled()){
					logger.debug(i + ": empty image unit, ignore!");
				}
				continue;
			}
			String routingKey = "feed.image."+ius[i].getFrom();
			getRabbitTemplate().convertAndSend(routingKey, ius[i]);
			if(logger.isDebugEnabled()){
				logger.debug(i + ": " + ius[i].getAlt() + 
						" - " + ius[i].getHref());
			}
		}
	}

}
