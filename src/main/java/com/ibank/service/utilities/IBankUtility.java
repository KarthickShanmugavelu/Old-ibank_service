package com.ibank.service.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class IBankUtility {

    public static String getQueryFromFile(String filePath){
        StringBuilder sb = new StringBuilder();
        try(BufferedReader in = new BufferedReader(new InputStreamReader(IBankUtility.class.getClassLoader().getResourceAsStream(filePath), StandardCharsets.UTF_8))){
            String str;
            while((str=in.readLine())!=null){
                sb.append(str).append(" ");
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
