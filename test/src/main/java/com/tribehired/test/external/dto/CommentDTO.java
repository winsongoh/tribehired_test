package com.tribehired.test.external.dto;

import java.io.Serializable;

public class CommentDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3231094858937731875L;

	private Long postId;
	private Long id;
	private String name;
	private String email;
	private String body;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
