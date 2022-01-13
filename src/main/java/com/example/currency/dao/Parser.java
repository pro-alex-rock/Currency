package com.example.currency.dao;

import com.example.currency.dto.CurrencyDto;

import java.util.List;

public interface Parser {
    List<CurrencyDto> getCurrency();
}