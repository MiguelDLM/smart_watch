package com.alibaba.aliagentsdk.domain;

import java.util.HashMap;

public class Sid {
    public static final String CCM = "CCM";
    public static final String FGS = "FGS";
    public static final String FND = "FND";
    public static final String GTD = "GTD";
    public static HashMap<String, String> map;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        map = hashMap;
        hashMap.put(FGS, FGS);
        map.put(GTD, GTD);
        map.put(FND, FND);
        map.put(CCM, CCM);
    }
}
