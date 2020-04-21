package com.tribehired.test.restful;

public enum RestfulURL {
	ALL_POSTS("https://jsonplaceholder.typicode.com/posts"),
	ALL_COMMENTS("https://jsonplaceholder.typicode.com/comments"),
	SINGLE_POST("https://jsonplaceholder.typicode.com/posts/{id}");

	private String url;

	private RestfulURL(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
