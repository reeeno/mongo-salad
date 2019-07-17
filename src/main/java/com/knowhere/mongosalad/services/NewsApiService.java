package com.knowhere.mongosalad.services;

import com.knowhere.mongosalad.model.NewsApi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;

@Service
public class NewsApiService {
    private Logger logger = LogManager.getLogger(NewsApiService.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${newsapi.url}")
    private String newsApiUrl;

    @Value("${newsapi.apikey}")
    private String newsApiKey;

    @Value("${newsapi.sources}")
    private String newsApiSources;

    private static final String NEWSAPI_QUERY_PARAM = "q";
    private static final String NEWSAPI_API_KEY_PARAM = "apiKey";
    private static final String NEWSAPI_FROM_PRARAM = "from";
    private static final String NEWSAPI_TO_PARAM = "to";
    private static final String NEWSAPI_SOURCES_PARAM = "sources";
    private static final String NEWSAPI_PAGE_SIZE_PARAM = "pageSize";
    private static final String NEWSAPI_PAGE_PARAM = "page";

    public NewsApi readDataFromNewsApi(String from, String to, String... q) throws UnsupportedEncodingException {
        String query = q.length > 0 ? q[0] : "";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(newsApiUrl)
                .queryParam(NEWSAPI_API_KEY_PARAM, newsApiKey)
                .queryParam(NEWSAPI_FROM_PRARAM, from)
                .queryParam(NEWSAPI_TO_PARAM, to)
                .queryParam(NEWSAPI_SOURCES_PARAM, newsApiSources)
                .queryParam(NEWSAPI_PAGE_SIZE_PARAM, 100)
                .queryParam(NEWSAPI_PAGE_PARAM, 1)
                .queryParam(NEWSAPI_QUERY_PARAM, query);
        logger.info(builder.toUriString());
        ResponseEntity<NewsApi> newsApiResponse = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                new HttpEntity<>(),
                NewsApi.class
        );
        return newsApiResponse.getBody();

    }
}
