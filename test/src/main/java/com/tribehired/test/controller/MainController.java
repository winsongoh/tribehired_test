package com.tribehired.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tribehired.test.internal.dto.ResultFilteredCommentDTO;
import com.tribehired.test.internal.dto.ResultPostDTO;
import com.tribehired.test.service.PostService;

@RestController
@RequestMapping(value = "/post")
public class MainController {

	@Autowired
	PostService postService;

	@GetMapping("/top")
	public ResultPostDTO getTopPost() {

		return postService.getMostComment();
	}

	@GetMapping("/comment/search")
	public List<ResultFilteredCommentDTO> searchComment(@RequestParam(required = false) Long postId,
			@RequestParam(required = false) Long id, @RequestParam(required = false) String name,
			@RequestParam(required = false) String email, @RequestParam(required = false) String body) {
		return postService.getFilteredComment(postId, id, name, email, body);
	}

}
