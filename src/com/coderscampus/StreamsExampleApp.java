package com.coderscampus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import com.coderscampus.filtering.NewWay;
import com.coderscampus.filtering.OldWay;
import com.coderscampus.mapping.BankTransaction;
import com.coderscampus.mapping.NewWayMappingExample;
import com.coderscampus.mapping.OldWayMappingExample;

public class StreamsExampleApp {

    public static void main(String[] args) {
        // Filtering example
        List<String> names = List.of("Andrew", "Betty", "Charlie", "Darla", "Eddy", "Franca", 
                "George", "Hanna", "Ivan", "Juliette");
        
        // old way (without streams)
        List<String> filteredNames = OldWay.filterResults(names, "ar");
        System.out.println("1. Names that contain 'ar' returns: " + filteredNames);
        
        // new way (with streams)
        filteredNames = NewWay.filterResults(names, "ar");
        System.out.println("2. Names that contain 'ar' returns: " + filteredNames);
        ////////////////////
        
        
        // Mapping example
        List<BankTransaction> allTransactions = generateTransactions();
        
        Double sumOfRecentTransactions = OldWayMappingExample.getSumOfRecentTransactions(allTransactions);
        System.out.println("1. Sum of transactions: " + sumOfRecentTransactions);
        sumOfRecentTransactions = NewWayMappingExample.getSumOfRecentTransactions(allTransactions);
        System.out.println("2. Sum of transactions: " + sumOfRecentTransactions);
        //////////////////
        
    }

    private static List<BankTransaction> generateTransactions() {
        Random random = new Random();
        List<BankTransaction> allTransactions = new ArrayList<>();
        
        IntStream.range(1, 101)
                 .forEach(i -> {
                     int randomDay = random.nextInt(14) + 1;
                     LocalDate createdDate = LocalDate.now().minusDays(randomDay);
                     double randomAmount = Math.round(random.nextDouble() * 10000.0) / 100.0; 
                     
                     BankTransaction aNewTransaction = new BankTransaction();
                     aNewTransaction.setAmount(randomAmount);
                     aNewTransaction.setCreatedDate(createdDate);
                     aNewTransaction.setTransactionId(i);
                     allTransactions.add(aNewTransaction);
                 });
        return allTransactions;
    }
}
