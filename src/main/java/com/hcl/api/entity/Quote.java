package com.hcl.api.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class Quote implements Serializable {
	
	
	private static final long serialVersionUID = -8550434783447456158L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private Integer stockId;
	private Integer stockquantity;
	private Double stockUnitPrice;
	private Double totalStockPrice;
	
	
	
}
