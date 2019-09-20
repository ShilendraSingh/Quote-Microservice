package com.hcl.api.service;

import org.springframework.stereotype.Service;

import com.hcl.api.dto.QuoteResponsedto;

@Service
public interface QuoteService {

	public QuoteResponsedto getstockPrice(Integer stockId);
	

}
