package com.tribehired.test.service;

import java.util.List;

import com.tribehired.test.internal.dto.ResultFilteredCommentDTO;
import com.tribehired.test.internal.dto.ResultPostDTO;

public interface PostService {
	public ResultPostDTO getMostComment();

	public List<ResultFilteredCommentDTO> getFilteredComment(final Long postId, final Long id, final String name,
			final String email, final String body);
}
