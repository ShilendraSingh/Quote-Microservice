package com.hcl.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hcl.api.dto.QuoteResponsedto;
import com.hcl.api.service.QuoteService;

@RestController
@RequestMapping("/quote")
public class QuoteController {

	@Autowired
	private QuoteService quoteService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/totalStockPrice/{stockId}")
	public ResponseEntity<QuoteResponsedto> gettotalstockPrice(@PathVariable Integer stockId) {
		return new ResponseEntity<>(quoteService.getstockPrice(stockId),HttpStatus.OK);

	}
}
