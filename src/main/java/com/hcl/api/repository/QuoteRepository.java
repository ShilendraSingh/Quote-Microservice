package com.hcl.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.api.entity.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {

}
