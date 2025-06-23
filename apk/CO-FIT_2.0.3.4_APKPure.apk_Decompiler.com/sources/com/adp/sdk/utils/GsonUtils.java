package com.adp.sdk.utils;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class GsonUtils {
    private static Gson gson = new Gson();

    public static class a extends TypeToken<List<Map<String, T>>> {
    }

    public static class b extends TypeToken<Map<String, T>> {
    }

    private GsonUtils() {
    }

    public static String GsonString(Object obj) {
        Gson gson2 = gson;
        if (gson2 != null) {
            return gson2.toJson(obj);
        }
        return null;
    }

    public static <T> T GsonToBean(String str, Class<T> cls) {
        Gson gson2 = gson;
        if (gson2 != null) {
            return gson2.fromJson(str, cls);
        }
        return null;
    }

    public static <T> List<Map<String, T>> GsonToListMaps(String str) {
        Gson gson2 = gson;
        if (gson2 != null) {
            return (List) gson2.fromJson(str, new a().getType());
        }
        return null;
    }

    public static <T> Map<String, T> GsonToMaps(String str) {
        Gson gson2 = gson;
        if (gson2 != null) {
            return (Map) gson2.fromJson(str, new b().getType());
        }
        return null;
    }

    public static String assertFileString(String str, Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static <T> List<T> gsonToList(String str, Class<T> cls) {
        Gson gson2 = new Gson();
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it = new JsonParser().parse(str).getAsJsonArray().iterator();
        while (it.hasNext()) {
            arrayList.add(gson2.fromJson(it.next(), cls));
        }
        return arrayList;
    }
}
