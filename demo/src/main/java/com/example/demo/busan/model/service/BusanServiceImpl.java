package com.example.demo.busan.model.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.busan.model.dao.CommentMapper;
import com.example.demo.busan.model.dto.Comment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BusanServiceImpl implements BusanService {

	private final String SERVICE_KEY = "scPtfDcubHnmICsvSbBfelpKNaDtoF3yo4h3TDa%2BPkjUtDr4KfjvhaHoZhNKCBNDr%2F3Ht8eRT7HVBewcCRHCIA%3D%3D";
	private final CommentMapper commentMapper;
	
	
	private String apiRequest(String uriPath) {
		URI uri = null;
		
		try {
			uri = new URI(uriPath);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		String apiResponseData = new RestTemplate().getForObject(uri, String.class);
		
		return apiResponseData;
	}
	
	@Override
	public String requestGetBusan(int pageNo) {
		
		if(pageNo < 1) { pageNo = 1; }
		
		StringBuilder sb = new StringBuilder();
		sb.append("http://apis.data.go.kr/6260000/FoodService/getFoodKr");
		sb.append("?serviceKey=" + SERVICE_KEY);
		sb.append("&pageNo=" + pageNo);
		sb.append("&numOfRows=9");
		sb.append("&resultType=json");
		
		
//		log.info("Api 확인 {}", apiResponseData); 잘 나온다.
		
		return apiRequest(sb.toString());
	}

	@Override
	public String requestGetBusanDetail(int pk) {
		
		if(pk < 1) { return null; }
		
		StringBuilder sb = new StringBuilder();
		sb.append("http://apis.data.go.kr/6260000/FoodService/getFoodKr");
		sb.append("?serviceKey=" + SERVICE_KEY);
		sb.append("&pageNo=1");
		sb.append("&numOfRows=1");
		sb.append("&resultType=json");
		sb.append("&UC_SEQ=" + pk);
		
		return apiRequest(sb.toString());
	}

	@Override
	public void saveComment(Comment comment) {
		commentMapper.saveComment(comment);
	}

	@Override
	public List<Comment> selectCommentList(Long seq) {
		return commentMapper.selectCommentList(seq);
	}

}
