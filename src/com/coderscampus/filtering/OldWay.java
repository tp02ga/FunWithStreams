package com.coderscampus.filtering;

import java.util.ArrayList;
import java.util.List;

public class OldWay {

    public static List<String> filterResults(List<String> names, String filterParam) {
        List<String> filteredList = new ArrayList<>();
        
        for (String name : names) {
            if (name.contains(filterParam)) {
                filteredList.add(name);
            }
        }
        return filteredList;
    }
}
