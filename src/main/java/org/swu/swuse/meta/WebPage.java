package org.swu.swuse.meta;

/**
 * 搜索结果抽象类 表示数据库中的网页数据
 * 
 * @author zhanjingbo
 *
 */

public class WebPage {
	private int id;
	private String url;
	private String title;
	private String text;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
