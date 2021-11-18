package com.coderscampus;

import java.util.List;

import com.coderscampus.filtering.NewWay;
import com.coderscampus.filtering.OldWay;

public class StreamsExampleApp {

    public static void main(String[] args) {
        List<String> names = List.of("Andrew", "Betty", "Charlie", "Darla", "Eddy", "Franca", 
                "George", "Hanna", "Ivan", "Juliette");
        List<String> filteredNames = OldWay.filterResults(names, "ar");

        System.out.println("1. Names that contain 'ar' returns: " + filteredNames);

        filteredNames = NewWay.filterResults(names, "ar");
        
        System.out.println("2. Names that contain 'ar' returns: " + filteredNames);
    }
}
