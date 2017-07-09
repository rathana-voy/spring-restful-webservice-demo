package com.phearun.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phearun.model.filter.ArticleFilter;
import com.phearun.service.article.ArticleService;
import com.phearun.ultility.Paging;

@RestController
@RequestMapping("/api/v1")
public class ArticleRestController {

	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/article")
	public Map<String, Object> list(ArticleFilter filter, Paging paging){
		Map<String, Object> map = new HashMap<>();
		map.put("articles", articleService.findAllFilter(filter, paging));
		map.put("paging", paging);
		return map;
	}
	
	
}