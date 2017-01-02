package org.swu.swuse.web.controller;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 * 
 * @author zhanjingbo
 *
 */
@Controller
public class IndexController {

	@Resource
	private HttpSolrServer httpSolrServer;

	@RequestMapping("/")
	public String index() throws Exception {
		return "index";
	}

}
