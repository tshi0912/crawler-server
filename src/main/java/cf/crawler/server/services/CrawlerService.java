package cf.crawler.server.services;

import java.net.URL;

import cf.crawler.server.tos.ImageUnit;

public interface CrawlerService {
	
	ImageUnit[] getImageUnits(URL url);
	
}
