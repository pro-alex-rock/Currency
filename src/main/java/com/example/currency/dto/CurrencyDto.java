package com.example.currency.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Objects;

public class CurrencyDto {

    @JsonProperty("currencyCodeA")
    private Integer currencyCodeA;
    @JsonProperty("currencyCodeB")
    private Integer currencyCodeB;
    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD")
    private LocalDate date;
    @JsonProperty(value = "rateBuy")
    private Double rateBuy;
    @JsonProperty(value = "rateSell")
    private Double rateSell;
    @JsonProperty(value = "rateCross")
    private Double rateCross;

    public CurrencyDto() {
    }

    public CurrencyDto(Integer currencyCodeA, Integer currencyCodeB, LocalDate date, Double rateBuy, Double rateSell, Double rateCross) {
        this.currencyCodeA = currencyCodeA;
        this.currencyCodeB = currencyCodeB;
        this.date = date;
        this.rateBuy = rateBuy;
        this.rateSell = rateSell;
        this.rateCross = rateCross;
    }

    public CurrencyDto(Integer currencyCodeA, Integer currencyCodeB, LocalDate date, Double rateBuy, Double rateSell) {
        this.currencyCodeA = currencyCodeA;
        this.currencyCodeB = currencyCodeB;
        this.date = date;
        this.rateBuy = rateBuy;
        this.rateSell = rateSell;
    }

    public CurrencyDto(Integer currencyCodeA, Integer currencyCodeB, LocalDate date, Double rateCross) {
        this.currencyCodeA = currencyCodeA;
        this.currencyCodeB = currencyCodeB;
        this.date = date;
        this.rateCross = rateCross;
    }

    @JsonProperty("currencyCodeA")
    public Integer getCurrencyCodeA() {
        return currencyCodeA;
    }

    @JsonProperty("currencyCodeA")
    public void setCurrencyCodeA(Integer currencyCodeA) {
        this.currencyCodeA = currencyCodeA;
    }

    @JsonProperty("currencyCodeB")
    public Integer getCurrencyCodeB() {
        return currencyCodeB;
    }

    @JsonProperty("currencyCodeB")
    public void setCurrencyCodeB(Integer currencyCodeB) {
        this.currencyCodeB = currencyCodeB;
    }

    @JsonProperty("date")
    public LocalDate getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @JsonProperty("rateBuy")
    public Double getRateBuy() {
        return rateBuy;
    }

    @JsonProperty("rateBuy")
    public void setRateBuy(Double rateBuy) {
        this.rateBuy = rateBuy;
    }

    @JsonProperty("rateSell")
    public Double getRateSell() {
        return rateSell;
    }

    @JsonProperty("rateSell")
    public void setRateSell(Double rateSell) {
        this.rateSell = rateSell;
    }

    @JsonProperty("rateCross")
    public Double getRateCross() {
        return rateCross;
    }

    @JsonProperty("rateCross")
    public void setRateCross(Double rateCross) {
        this.rateCross = rateCross;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrencyDto)) return false;
        CurrencyDto that = (CurrencyDto) o;
        return getCurrencyCodeA().equals(that.getCurrencyCodeA()) &&
                getCurrencyCodeB().equals(that.getCurrencyCodeB()) &&
                getDate().equals(that.getDate()) &&
                Objects.equals(getRateBuy(), that.getRateBuy()) &&
                Objects.equals(getRateSell(), that.getRateSell()) &&
                Objects.equals(getRateCross(), that.getRateCross());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCurrencyCodeA(), getCurrencyCodeB(), getDate(), getRateBuy(), getRateSell(), getRateCross());
    }

    @Override
    public String toString() {
        return "CurrencyDto{" +
                "currencyCodeA=" + currencyCodeA +
                ", currencyCodeB=" + currencyCodeB +
                ", date=" + date +
                ", rateBuy=" + rateBuy +
                ", rateSell=" + rateSell +
                ", rateCross=" + rateCross +
                '}';
    }
}
