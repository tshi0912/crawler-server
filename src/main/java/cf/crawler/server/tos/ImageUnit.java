package cf.crawler.server.tos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ImageUnit implements Serializable {
	
	private String title;
	private String alt;
	private String href;
	private double[] size;
	private String from;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public double[] getSize() {
		return size;
	}
	public void setSize(double[] size) {
		this.size = size;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
}
