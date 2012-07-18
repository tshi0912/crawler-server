package cf.crawler.server.services;

import java.net.URL;
import java.util.UUID;

import cf.crawler.server.tos.ImageUnit;

public class MockCrawlerServiceImpl implements CrawlerService {
	
	private int batchSize = 5;
	
	private static final String[] alts = new String[]{
			"Good Pics", "High Speed", "Tony's home", "You're kidding me",
			"Ops, error page", "Server can not found", "The Robo-Help", "Test Question Flunks",
			"All Too Often, a Sorry State of Affairs", "Down With Everything"
		};
	
	private static final String[] hrefBases = new String[]{
			"http://img.hb.aicdn.com/",
			"http://images.baidu.com/",
			"http://img.google.com/"
		};

	public ImageUnit[] getImageUnits(URL url) {
		int len = batchSize;
		ImageUnit[] ius = new ImageUnit[len];
		for(int i=0; i<len; i++){
			ImageUnit iu = new ImageUnit();
			int idx = (int) Math.floor(Math.random()*10%10);
			iu.setAlt(alts[idx]);
			idx = (int) Math.floor(Math.random()*3%3);
			String hrefBase = hrefBases[idx];
			String[] ds = hrefBase.split("\\.");
			String from = ds[1];
			iu.setFrom(from);
			iu.setHref(hrefBase+UUID.randomUUID().toString());
			ius[i] = iu;
		}
		return ius;
	}

	public int getBatchSize() {
		return batchSize;
	}
	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}
	
}
