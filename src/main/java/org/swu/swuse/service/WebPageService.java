package org.swu.swuse.service;

import java.util.Map;

public interface WebPageService {
	public Map<String, Object> search(String keywords, int page);
}
