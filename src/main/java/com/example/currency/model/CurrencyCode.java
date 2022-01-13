package com.example.currency.model;

public enum CurrencyCode {

    UAH(980),
    USD(840),
    EUR(978),
    GBP(826),
    JPY(392),
    CHF(756),
    CNY(156),
    RUB(643);

    private Integer value;

    CurrencyCode(Integer value) {
        this.value = value;
    }

    public static CurrencyCode findCurrency(Integer code) {
        for (CurrencyCode cd : CurrencyCode.values()) {
            if (code.equals(cd.value)) {
                return cd;
            }
        }
        return CurrencyCode.USD;
    }
}
