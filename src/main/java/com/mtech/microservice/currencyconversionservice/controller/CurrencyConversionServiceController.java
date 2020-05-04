package com.mtech.microservice.currencyconversionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mtech.microservice.currencyconversionservice.feign.CurrencyExchangeServiceProxy;
import com.mtech.microservice.currencyexchangeservice.entity.CurrencyEntity;

@RestController
public class CurrencyConversionServiceController {
	
	@Autowired
	CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	
	@GetMapping("/currencyConversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyEntity getConvertedDetails(@PathVariable String from,@PathVariable String to,@PathVariable int quantity)
	{
		CurrencyEntity currencyEntity=currencyExchangeServiceProxy.getExchangeRate(from, to);
		return currencyEntity;
	}

}
