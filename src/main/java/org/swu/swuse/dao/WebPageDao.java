package org.swu.swuse.dao;

import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;

public interface WebPageDao {
	
	
	public Map<String,Object> search(SolrQuery solrQuery);
}
