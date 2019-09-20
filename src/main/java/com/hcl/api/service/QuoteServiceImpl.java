package com.hcl.api.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.api.dto.OrderResponseDto;
import com.hcl.api.dto.QuoteResponsedto;
import com.hcl.api.repository.QuoteRepository;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository quoteRepository;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public QuoteResponsedto getstockPrice(Integer stockId) {

		QuoteResponsedto quoteResponsedto = new QuoteResponsedto();
		OrderResponseDto latestStockPriceRes = latestStockPrice(stockId);

		Double charges=latestStockPriceRes.getLatestPrice()*0.05;
		quoteResponsedto.setCharges(charges);
		quoteResponsedto.setTotalStockAmount(latestStockPriceRes.getLatestPrice());
		return quoteResponsedto;
	}

	public OrderResponseDto latestStockPrice(Integer stockId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		headers.add("contentType", "application/json");
		HttpEntity<String> entity = new HttpEntity<>(headers);

		String url = "http://localhost:9910/stock/stock/stockUnitPrice/" + stockId;
		// System.out.println("URL" + url);

		OrderResponseDto quoteResponsedto = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<OrderResponseDto>() {}).getBody();
//				getForEntity(url, OrderResponseDto.class).getBody();

		System.out.println("quoteResponsedto : "+quoteResponsedto);
		return quoteResponsedto;
	}
}
