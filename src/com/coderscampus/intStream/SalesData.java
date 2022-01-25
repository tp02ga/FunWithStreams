package com.coderscampus.intStream;

import java.time.LocalDate;

public class SalesData {
    private LocalDate date;
    private Integer amount;

    public SalesData(LocalDate date, Integer amount) {
        super();
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "SalesData [date=" + date + ", amount=" + amount + "]";
    }
}
