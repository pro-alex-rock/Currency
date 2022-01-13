package com.example.currency.model;

import com.example.currency.dto.CurrencyDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MapperTest {

    private final Mapper mapper = new Mapper();

    @Test
    public void givenNullAndShouldThrowRuntimeException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> mapper.toCurrencyPair(null));
        assertEquals("CurrencyDto cannot be empty!", exception.getMessage());
    }

    @Test
    public void shouldMappingDtoFail() {
        Pair actualPair = new Pair();
        actualPair.setCurrencyCodeA(CurrencyCode.EUR);
        actualPair.setCurrencyCodeB(CurrencyCode.UAH);
        actualPair.setDate(LocalDate.of(2022, 1, 12));
        actualPair.setRateBuy(8.00);
        actualPair.setRateSell(8.02);
        actualPair.setRateCross(1.0000);

        CurrencyDto currencyDtoActual = new CurrencyDto();
        currencyDtoActual.setCurrencyCodeA(826);
        currencyDtoActual.setCurrencyCodeB(392);
        currencyDtoActual.setDate(LocalDate.of(2022, 2, 12));
        currencyDtoActual.setRateBuy(5.00);
        currencyDtoActual.setRateSell(27.02);
        currencyDtoActual.setRateCross(30.0000);
        Pair expectedPair = mapper.toCurrencyPair(currencyDtoActual);

        assertNotEquals(expectedPair.getCurrencyCodeA(), actualPair.getCurrencyCodeA());
        assertNotEquals(expectedPair.getCurrencyCodeB(), actualPair.getCurrencyCodeB());
        assertNotEquals(expectedPair.getDate(), actualPair.getDate());
        assertNotEquals(expectedPair.getRateBuy(), actualPair.getRateBuy());
        assertNotEquals(expectedPair.getRateSell(), actualPair.getRateSell());
        assertNotEquals(expectedPair.getRateCross(), actualPair.getRateCross());
    }

    @Test
    public void shouldMappingDtoSuccess() {
        Pair actualPair = new Pair();
        actualPair.setCurrencyCodeA(CurrencyCode.EUR);
        actualPair.setCurrencyCodeB(CurrencyCode.UAH);
        actualPair.setDate(LocalDate.of(2022, 01, 12));
        actualPair.setRateBuy(8.00);
        actualPair.setRateSell(8.02);
        actualPair.setRateCross(1.0000);

        CurrencyDto currencyDtoActual = new CurrencyDto();
        currencyDtoActual.setCurrencyCodeA(978);
        currencyDtoActual.setCurrencyCodeB(980);
        currencyDtoActual.setDate(LocalDate.of(2022, 01, 12));
        currencyDtoActual.setRateBuy(8.00);
        currencyDtoActual.setRateSell(8.02);
        currencyDtoActual.setRateCross(1.0000);
        Pair expectedPair = mapper.toCurrencyPair(currencyDtoActual);

        assertEquals(expectedPair.getCurrencyCodeA(), actualPair.getCurrencyCodeA());
        assertEquals(expectedPair.getCurrencyCodeB(), actualPair.getCurrencyCodeB());
        assertEquals(expectedPair.getDate(), actualPair.getDate());
        assertEquals(expectedPair.getRateBuy(), actualPair.getRateBuy());
        assertEquals(expectedPair.getRateSell(), actualPair.getRateSell());
        assertEquals(expectedPair.getRateCross(), actualPair.getRateCross());
    }
}