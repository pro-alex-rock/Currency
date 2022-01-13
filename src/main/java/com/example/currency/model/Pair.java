package com.example.currency.model;

import java.time.LocalDate;
import java.util.Objects;

public class Pair {

    private CurrencyCode currencyCodeA;
    private CurrencyCode currencyCodeB;
    private LocalDate date;
    private Double rateBuy = 0.00;
    private Double rateSell = 0.00;
    private Double rateCross = 0.0000;

    public Pair() {
    }

    public Pair(CurrencyCode currencyCodeA, CurrencyCode currencyCodeB, LocalDate date, Double rateBuy, Double rateSell, Double rateCross) {
        this.currencyCodeA = currencyCodeA;
        this.currencyCodeB = currencyCodeB;
        this.date = date;
        this.rateBuy = rateBuy;
        this.rateSell = rateSell;
        this.rateCross = rateCross;
    }

    public Pair(CurrencyCode currencyCodeA, CurrencyCode currencyCodeB, LocalDate date, Double rateBuy, Double rateSell) {
        this.currencyCodeA = currencyCodeA;
        this.currencyCodeB = currencyCodeB;
        this.date = date;
        this.rateBuy = rateBuy;
        this.rateSell = rateSell;
    }

    public Pair(CurrencyCode currencyCodeA, CurrencyCode currencyCodeB, LocalDate date, Double rateCross) {
        this.currencyCodeA = currencyCodeA;
        this.currencyCodeB = currencyCodeB;
        this.date = date;
        this.rateCross = rateCross;
    }

    public CurrencyCode getCurrencyCodeA() {
        return currencyCodeA;
    }

    public void setCurrencyCodeA(CurrencyCode currencyCodeA) {
        this.currencyCodeA = currencyCodeA;
    }

    public CurrencyCode getCurrencyCodeB() {
        return currencyCodeB;
    }

    public void setCurrencyCodeB(CurrencyCode currencyCodeB) {
        this.currencyCodeB = currencyCodeB;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getRateBuy() {
        return rateBuy;
    }

    public void setRateBuy(Double rateBuy) {
        this.rateBuy = rateBuy;
    }

    public Double getRateSell() {
        return rateSell;
    }

    public void setRateSell(Double rateSell) {
        this.rateSell = rateSell;
    }

    public Double getRateCross() {
        return rateCross;
    }

    public void setRateCross(Double rateCross) {
        this.rateCross = rateCross;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return getCurrencyCodeA() == pair.getCurrencyCodeA() &&
                getCurrencyCodeB() == pair.getCurrencyCodeB() &&
                getDate().equals(pair.getDate()) &&
                Objects.equals(getRateBuy(), pair.getRateBuy()) &&
                Objects.equals(getRateSell(), pair.getRateSell()) &&
                Objects.equals(getRateCross(), pair.getRateCross());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCurrencyCodeA(), getCurrencyCodeB(), getDate(), getRateBuy(), getRateSell(), getRateCross());
    }

    @Override
    public String toString() {
        return "Pair{" +
                "currencyCodeA=" + currencyCodeA +
                ", currencyCodeB=" + currencyCodeB +
                ", date=" + date +
                ", rateBuy=" + rateBuy +
                ", rateSell=" + rateSell +
                ", rateCross=" + rateCross +
                '}';
    }
}

