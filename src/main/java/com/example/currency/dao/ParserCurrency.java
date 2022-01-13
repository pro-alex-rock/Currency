package com.example.currency.dao;

import com.example.currency.dto.CurrencyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ConfigurationProperties(prefix = "spring.application")
@Service
public class ParserCurrency implements Parser {
    private static final Logger logger = LoggerFactory.getLogger(ParserCurrency.class);

    @Value("${spring.application.URL}")
    private String URL;
    private final RestTemplate restTemplate;

    public ParserCurrency(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        logger.info("The ParserCurrency initialized.");
    }

    @Override
    public List<CurrencyDto> getCurrency() {
        CurrencyDto[] currencies = Objects.requireNonNull(restTemplate.getForObject(URL, CurrencyDto[].class));
        logger.info("received data from resource. Got: {}", (Object) currencies);
        return Arrays.stream(currencies).collect(Collectors.toList());
    }
}
