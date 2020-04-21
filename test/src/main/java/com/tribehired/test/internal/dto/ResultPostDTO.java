package com.tribehired.test.internal.dto;

public class ResultPostDTO {
	private Long postId;
	private String postTitle;
	private String postBody;
	private Long totalNumberOfComments;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostBody() {
		return postBody;
	}

	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}

	public Long getTotalNumberOfComments() {
		return totalNumberOfComments;
	}

	public void setTotalNumberOfComments(Long totalNumberOfComments) {
		this.totalNumberOfComments = totalNumberOfComments;
	}

}
