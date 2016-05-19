package com.lucas.antevere.brechlivre.service;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class CacheService {
    public static String Get(Callable<String> callback, String... args){
        args = Reorder(args);


        return "";
    }

    public static void Set(String ... args){
        args = Reorder(args);

    }

    private static String[] Reorder(String[] args){
        Arrays.sort(args);
        return args;
    }
}
