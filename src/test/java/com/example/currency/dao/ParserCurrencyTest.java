package com.example.currency.dao;

import com.example.currency.dto.CurrencyDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
class ParserCurrencyITest {

    @Autowired
    private Parser parser;

    @Test
    public void shouldGetDataFromResourceAndParseSuccess() {
        List<CurrencyDto> currenciesExpected = parser.getCurrency();
        assertTrue(currenciesExpected.size() > 0);
        assertEquals(currenciesExpected.get(0).getCurrencyCodeB(), 980);
        assertEquals(currenciesExpected.get(5).getCurrencyCodeB(), 980);
    }
}