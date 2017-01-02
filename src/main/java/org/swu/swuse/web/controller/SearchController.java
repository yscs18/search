package org.swu.swuse.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.swu.swuse.meta.WebPage;
import org.swu.swuse.service.WebPageService;

@Controller
public class SearchController {

	@Resource
	private WebPageService webPageService;

	@RequestMapping("/s")
	public ModelAndView search(String k, int page) {

		ModelAndView mav = new ModelAndView();
		if (k.equals("")) {
			mav.setViewName("index");
			return mav;
		}

		mav.addObject("k", k);
		Map<String, Object> result = webPageService.search(k, page);

		List<WebPage> webPages = (List<WebPage>) result.get("webPages");
		mav.addObject("webPages", webPages);
		long count = (long) result.get("count");
		mav.addObject("count", Math.ceil(count / 15.0) - 1);
		mav.addObject("nowPage", page);

		mav.setViewName("list");

		return mav;
	}

	@RequestMapping("/p")
	public Map<String, Object> pagination(String k, int nowPage, int count, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();

		String url = request.getContextPath() + "/s?k=" + k + "&page=";
		result.put("className", "am-pagination-centered");
		result.put("theme", "default");

		Map<String, Object> content = new HashMap<>();
		content.put("firstTitle", "首页");
		content.put("firstLink", url + "0");
		content.put("lastTitle", "末页");
		content.put("lastLink", url + count);

		List<Map<String, Object>> pages = new ArrayList<>();
		int start = Integer.max(nowPage - 2, 0);
		int end = Integer.min(count, nowPage + 2);

		for (int i = start; i <= end; i++) {
			Map<String, Object> page = new HashMap<>();
			page.put("title", i + 1);
			page.put("link", url + i);
			if (i == nowPage) {
				page.put("className", "am-active");
			}
			pages.add(page);
		}
		content.put("page", pages);
		result.put("content", content);
		return result;
	}
}
