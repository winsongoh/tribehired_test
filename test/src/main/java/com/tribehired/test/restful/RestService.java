package com.tribehired.test.restful;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

	private final RestTemplate restTemplate;

	public RestService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public String execute(final String url) {
		return restTemplate.getForObject(url, String.class);
	}

	public String execute(final String url, final Long id) {
		return restTemplate.getForObject(url, String.class, id);
	}

}
