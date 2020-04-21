package com.tribehired.test.external.dto;

import java.io.Serializable;

public class PostDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 184257878121650815L;

	private Long userId;
	private Long id;
	private String title;
	private String body;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
