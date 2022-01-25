package com.coderscampus.intStream;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import com.coderscampus.utils.RandomDataUtil;

public class IntStreamExample {

    @Test
    public void int_stream_example () {
        List<SalesData> salesData = generateSalesData(100);
        
        Optional<SalesData> max = salesData.stream()
                 .max(Comparator.comparing(SalesData::getAmount));
        
        Optional<SalesData> min = salesData.stream()
                .min(Comparator.comparing(SalesData::getAmount));
        
        IntSummaryStatistics stats = salesData.stream()
                 .mapToInt(SalesData::getAmount)
                 .summaryStatistics();
        
        System.out.println("Data based on " + stats.getCount() + " days of sales");
        System.out.println("Best sales date was: " + max.get());
        System.out.println("Worst sales date was: " + min.get());
        
        System.out.println("Average sales: " + stats.getAverage());
        System.out.println("Total sales: " + stats.getSum());
    }

    /**
     * This method will randomly populate a collection of SalesData objects, which
     * can then be used as part of the IntStream example to generate reports
     * 
     * @param numOfSales the total number of sales objects you wish to create
     */
    private List<SalesData> generateSalesData(int numOfSales) {
        List<SalesData> salesData = IntStream.range(0, numOfSales)
                 .boxed()
                 .map(i -> new SalesData(RandomDataUtil.generateDate(), RandomDataUtil.generateRandomNumber(1, 2000)))
                 .collect(Collectors.toList());
        return salesData;
                 
    }
}
