package com.coderscampus.mapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OldWayMappingExample {

    /**
     * Return the sum of all the bank transactions that occurred in the last 7 days.
     */
    public static Double getSumOfRecentTransactions(List<BankTransaction> bankTransactions) {
        List<BankTransaction> recentTransactions = new ArrayList<>();
        LocalDate sevenDaysAgo = LocalDate.now().minusDays(7L);

        // only consider transactions from the last 7 days
        for (BankTransaction transaction : bankTransactions) {
            if (transaction.getCreatedDate().isAfter(sevenDaysAgo)) {
                recentTransactions.add(transaction);
            }
        }

        Double sum = 0.0;

        // add up all the transaction amounts for recent transactions
        for (BankTransaction recentTransaction : recentTransactions) {
            sum += recentTransaction.getAmount();
        }

        return Math.round(sum * 100.0) / 100.0;
    }
}
