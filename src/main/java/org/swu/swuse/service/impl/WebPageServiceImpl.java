package org.swu.swuse.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.stereotype.Service;
import org.swu.swuse.dao.WebPageDao;
import org.swu.swuse.service.WebPageService;

@Service
public class WebPageServiceImpl implements WebPageService {

	private static final int pageSize = 15;

	@Resource
	private WebPageDao webPageDao;

	@Override
	public Map<String,Object> search(String keywords, int page) {

		SolrQuery solrQuery = new SolrQuery();
		solrQuery.set("q", "search:" + keywords);

		solrQuery.setHighlight(true);
		solrQuery.addHighlightField("page_title");
		solrQuery.addHighlightField("page_text");
		solrQuery.setHighlightSimplePre("<span style=\"color:red\">");
		solrQuery.setHighlightSimplePost("</span>");

		solrQuery.setStart(page * pageSize);
		solrQuery.setRows(pageSize);

		return webPageDao.search(solrQuery);
	}

}
