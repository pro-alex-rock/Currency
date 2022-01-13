package com.example.currency.service;


import com.example.currency.dto.CurrencyDto;
import com.example.currency.model.Mapper;
import com.example.currency.model.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyService {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyService.class);

    private final Parser parser;
    private final Mapper mapper;

    public CurrencyService(Parser parser, Mapper mapper) {
        this.parser = parser;
        this.mapper = mapper;
        logger.info("The CurrencyService initialized.");
    }

    public List<Pair> getCurrencyRate(String code) {
        if (code == null || code.equals("")) {
            return getPairs();
        } else {
            return List.of(getPair(code));
        }
    }

    private List<Pair> getPairs() {
        List<CurrencyDto> currency = parser.getCurrency();
        List<Pair> pairs = currency.stream().map(mapper::toCurrencyPair)
                .filter(a -> (a.getRateBuy() != null && a.getRateSell() != null))
                .collect(Collectors.toList());
        logger.info("Converted all CurrenciesDto to CurrencyPairs");
        return pairs;
    }

    public Pair getPair(String code) {
        Pair pair = getPairs().stream().filter(c -> (code.toUpperCase())
                .equals(c.getCurrencyCodeA().name())).findFirst().get();
        logger.info("Got pair {} by request.", pair);
        return pair;
    }
}
