package com.frcsprep.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CommonUtils {

    public List<Long>  convertCommaSeparatedStringToList(String string){
        System.out.println("printing string --> " +string);
        List<String> listOfString = new ArrayList<String>(Arrays.asList(string.split(" , ")));
        System.out.println("printing string list --> " +listOfString);
        List<Long> listofLong = Arrays.asList(string.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());

        return  listofLong;
    }

    public static <T, U> List<U>
    convertStringListToIntList(List<T> listOfString,
                               Function<T, U> function)
    {
        return listOfString.stream()
                .map(function)
                .collect(Collectors.toList());
    }

}
