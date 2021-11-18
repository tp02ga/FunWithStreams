package com.coderscampus.filtering;

import java.util.List;
import java.util.stream.Collectors;

public class NewWay {

    public static List<String> filterResults(List<String> names, String filterParam) {
        
        return names.stream()
                    .filter(name -> name.contains(filterParam))
                    .collect(Collectors.toList());
    }

}
