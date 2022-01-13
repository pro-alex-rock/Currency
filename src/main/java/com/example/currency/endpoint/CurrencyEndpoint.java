package com.example.currency.endpoint;

import com.example.currency.service.CurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CurrencyEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private static final Logger logger = LoggerFactory.getLogger(CurrencyEndpoint.class);

    private final CurrencyService currencyService;

    public CurrencyEndpoint(CurrencyService currencyService) {
        this.currencyService = currencyService;
        logger.info("The CurrencyEndpoint initialized.");
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCurrencyRateRequest")
    @ResponsePayload
    public GetCurrencyRateResponse getCurrencyRate(@RequestPayload GetCurrencyRateRequest request) {
        GetCurrencyRateResponse response = new GetCurrencyRateResponse();
        response.setPairs(currencyService.getCurrencyRate(request.getCode()));
        logger.info("Came request to get status for all pairs");
        return response;
    }
}
