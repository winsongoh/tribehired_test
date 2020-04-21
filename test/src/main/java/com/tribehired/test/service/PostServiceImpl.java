package com.tribehired.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tribehired.test.external.dto.CommentDTO;
import com.tribehired.test.external.dto.PostDTO;
import com.tribehired.test.internal.dto.ResultFilteredCommentDTO;
import com.tribehired.test.internal.dto.ResultPostDTO;
import com.tribehired.test.restful.RestService;
import com.tribehired.test.restful.RestfulURL;

@Service
public class PostServiceImpl implements PostService {

	private final Gson gson = new Gson();

	@Autowired
	RestService restService;

	@Override
	public ResultPostDTO getMostComment() {
		// Get all comments
		String response = restService.execute(RestfulURL.ALL_COMMENTS.getUrl());
		List<CommentDTO> commentDTOList = gson.fromJson(response, new TypeToken<List<CommentDTO>>() {
		}.getType());

		// Find most comment post
		Map<Long, Long> mostCommentCount = commentDTOList.stream()
				.collect(Collectors.groupingBy(CommentDTO::getPostId, Collectors.counting()));

		Map.Entry<Long, Long> topPost = null;
		for (Map.Entry<Long, Long> entry : mostCommentCount.entrySet()) {
			if (topPost == null || entry.getValue().compareTo(topPost.getValue()) > 0) {
				topPost = entry;
			}
		}

		// Get post details
		String postResponse = restService.execute(RestfulURL.SINGLE_POST.getUrl(), topPost.getValue());
		PostDTO postDTO = gson.fromJson(postResponse, PostDTO.class);

		// Compose response
		ResultPostDTO resultDTO = new ResultPostDTO();
		resultDTO.setPostId(postDTO.getId());
		resultDTO.setPostTitle(postDTO.getTitle());
		resultDTO.setPostBody(postDTO.getBody());
		resultDTO.setTotalNumberOfComments(topPost.getValue());
		return resultDTO;
	}

	@Override
	public List<ResultFilteredCommentDTO> getFilteredComment(Long postId, Long id, String name, String email,
			String body) {
		// Get all comments
		String response = restService.execute(RestfulURL.ALL_COMMENTS.getUrl());
		List<CommentDTO> commentDTOList = gson.fromJson(response, new TypeToken<List<CommentDTO>>() {
		}.getType());

		// Filter comment by keyword
		if (postId != null) {
			commentDTOList = commentDTOList.stream().filter(x -> x.getPostId() == postId).collect(Collectors.toList());
		}

		if (id != null) {
			commentDTOList = commentDTOList.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
		}

		if (StringUtils.hasText(name)) {
			commentDTOList = commentDTOList.stream().filter(x -> x.getName().contains(name))
					.collect(Collectors.toList());
		}

		if (StringUtils.hasText(email)) {
			commentDTOList = commentDTOList.stream().filter(x -> x.getEmail().contains(email))
					.collect(Collectors.toList());
		}

		if (StringUtils.hasText(body)) {
			commentDTOList = commentDTOList.stream().filter(x -> x.getBody().contains(body))
					.collect(Collectors.toList());
		}

		// Compose response
		List<ResultFilteredCommentDTO> resultList = new ArrayList<ResultFilteredCommentDTO>();
		for (CommentDTO dto : commentDTOList) {
			ResultFilteredCommentDTO commentDTO = new ResultFilteredCommentDTO();
			commentDTO.setId(dto.getId());
			commentDTO.setPostId(dto.getPostId());
			commentDTO.setName(dto.getName());
			commentDTO.setEmail(dto.getEmail());
			commentDTO.setBody(dto.getBody());
			resultList.add(commentDTO);
		}

		return resultList;
	}

}
