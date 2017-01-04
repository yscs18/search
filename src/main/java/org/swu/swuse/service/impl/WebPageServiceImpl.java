package org.swu.swuse.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Service;
import org.swu.swuse.meta.WebPage;
import org.swu.swuse.service.WebPageService;

/**
 * 搜索服务实现类
 * 
 * @author zhanjingbo
 *
 */

@Service
public class WebPageServiceImpl implements WebPageService {

	@Resource
	private SolrServer solrServer;

	private static final int pageSize = 15;

	@Override
	public Map<String, Object> search(String keywords, int page) {

		SolrQuery solrQuery = new SolrQuery();
		solrQuery.set("q", "search:" + keywords);

		solrQuery.setHighlight(true);
		solrQuery.addHighlightField("page_title");
		solrQuery.addHighlightField("page_text");
		solrQuery.setHighlightSimplePre("<span style=\"color:red\">");
		solrQuery.setHighlightSimplePost("</span>");

		solrQuery.setStart(page * pageSize);
		solrQuery.setRows(pageSize);

		return this.searchInSolr(solrQuery);
	}

	private Map<String, Object> searchInSolr(SolrQuery solrQuery) {

		Map<String, Object> result = new HashMap<>();
		List<WebPage> webPages = new ArrayList<>();

		QueryResponse solrResponse = null;

		try {
			solrResponse = solrServer.query(solrQuery);

			SolrDocumentList solrDocumentList = solrResponse.getResults();
			result.put("count", solrDocumentList.getNumFound());
			Map<String, Map<String, List<String>>> highlights = solrResponse.getHighlighting();

			for (SolrDocument solrDocument : solrDocumentList) {
				WebPage webpage = new WebPage();
				webpage.setId((int) solrDocument.get("id"));
				webpage.setUrl(solrDocument.get("page_url").toString());

				if (highlights.get(Integer.toString(webpage.getId())) != null) {

					Map<String, List<String>> fileds = highlights.get(Integer.toString(webpage.getId()));

					if (fileds.get("page_text") != null) {
						webpage.setText(fileds.get("page_text").get(0));
					} else {
						webpage.setText(solrDocument.get("page_text").toString());
					}
					if (fileds.get("page_title") != null) {
						webpage.setTitle(fileds.get("page_title").get(0));
					} else {
						webpage.setTitle(solrDocument.get("page_title").toString());
					}
				} else {
					webpage.setTitle(solrDocument.get("page_title").toString());
					webpage.setText(solrDocument.get("page_text").toString());
				}

				webPages.add(webpage);
			}

		} catch (SolrServerException e) {
			e.printStackTrace();
		}

		result.put("webPages", webPages);

		return result;
	}

}
