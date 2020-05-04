package com.mtech.microservice.currencyconversionservice.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mtech.microservice.currencyexchangeservice.entity.CurrencyEntity;



@FeignClient(name="netflix-zuui-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	@GetMapping("/currency-exchange-service/currencyExchange/from/{from}/to/{to}")
	public CurrencyEntity getExchangeRate(@PathVariable("from") String from,@PathVariable("to") String to) ;
	

}
