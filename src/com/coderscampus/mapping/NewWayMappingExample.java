package com.coderscampus.mapping;

import java.time.LocalDate;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class NewWayMappingExample {

    /**
     * Return the sum of all the bank transactions that occurred in the last 7 days.
     */
    public static Double getSumOfRecentTransactions(List<BankTransaction> bankTransactions) {
        LocalDate sevenDays = LocalDate.now().minusDays(7L);
        DoubleSummaryStatistics summaryStatistics = bankTransactions.stream()
                        .filter(bankTransaction -> bankTransaction.getCreatedDate().isAfter(sevenDays))
                        .map(bankTransaction -> bankTransaction.getAmount())
                        .collect(Collectors.summarizingDouble(amount -> amount));
        return summaryStatistics.getSum();
    }
}
