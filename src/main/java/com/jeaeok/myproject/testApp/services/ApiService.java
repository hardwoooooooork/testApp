package com.jeaeok.myproject.testApp.services;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.jeaeok.myproject.testApp.configs.AuthenticationFacade;
import com.jeaeok.myproject.testApp.domain.HotKeyWord;
import com.jeaeok.myproject.testApp.domain.Keyword;
import com.jeaeok.myproject.testApp.repositories.KeywordRepository;

@Service
public class ApiService {

	@Autowired
	private KeywordRepository keywordRepository;
	@Autowired
    private AuthenticationFacade authenticationFacade;
	@Autowired
	private UserService userService;
	
	@PersistenceContext
	private EntityManager entityManager;


	
	private static final Logger log = LoggerFactory.getLogger(ApiService.class);
	
	
	
	@Value("${kakao.local_api_url}")
	private String KAKAO_API_URL;
	@Value("${kakao.api_key}")
	private String API_KEY;
	
	/**
	 * 카카오 키워드 검색
	 * @param keyword
	 * @return
	 */
	public String searchKeyword(Keyword keyword) {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization","KakaoAK "+ API_KEY);
		headers.add("charset", "utf-8");
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		UriComponentsBuilder builder = 
				UriComponentsBuilder.fromHttpUrl(KAKAO_API_URL)
				;
		
		if( keyword.getX() != null && !"".equals(keyword.getX()) ) {
			builder.queryParam("x", keyword.getX());
		}
		if( keyword.getY() != null && !"".equals(keyword.getY()) ) {
			builder.queryParam("y", keyword.getY());
		}
		if( keyword.getRadius() != null && keyword.getRadius() != 0 ) {
			builder.queryParam("radius", keyword.getRadius());
		}
		if( keyword.getRect() != null && !"".equals(keyword.getRect()) ) {
			builder.queryParam("rect", keyword.getRect());
		}
		if( keyword.getPage() != null  ) {
			builder.queryParam("page", keyword.getPage());
		}
		if( keyword.getSize() != null  ) {
			builder.queryParam("size", keyword.getSize());
		}else {
			keyword.setSize(5);
			builder.queryParam("size", keyword.getSize());
		}
		if( keyword.getSort() != null && !"".equals(keyword.getSort()) ) {
			builder.queryParam("sort", keyword.getSort());
		}
		if( keyword.getCategory_group_code() != null && !"".equals(keyword.getCategory_group_code()) ) {
			builder.queryParam("category_group_code", keyword.getCategory_group_code());
		}
		if( keyword.getQuery() != null && !"".equals(keyword.getQuery()) ) {
			builder.queryParam("query", keyword.getQuery());
		}
		
		
		builder.encode(StandardCharsets.UTF_8)		
		;
		
		
		String result = null;		
		URI endUri =  builder.build().encode().toUri();
		try {
			ResponseEntity<String> response  = restTemplate.exchange(endUri, HttpMethod.GET, entity, String.class);
			result = response.getBody();
			String userId = authenticationFacade.getAuthentication().getName();
			keyword.setUser(userService.getUser(userId));

			keywordRepository.save(keyword);
		} catch (Exception e) {
			log.error("error : {}",e.getCause());
			result = "error message";
		}
		
		
		
		return result;
	}

	public List<HotKeyWord> getHotKeywordList() {
		List<HotKeyWord> result = new ArrayList<>();
		Query nativeQuery  = entityManager
			.createNativeQuery("SELECT QUERY , COUNT(QUERY) AS COUNT FROM KEYWORD  group by QUERY ORDER BY COUNT DESC LIMIT 10");
		 List<Object[]> results = nativeQuery.getResultList();
		
		HotKeyWord tmpKeyWord;
		for (Object[] quety : results) {
			tmpKeyWord =  new HotKeyWord();
		    String name = (String) quety[0];
		    int count = ((Number) quety[1]).intValue();
		    tmpKeyWord.setQuery(name);
		    tmpKeyWord.setCount(count);
		    result.add(tmpKeyWord);
		}
		
		return result;
	}

}
