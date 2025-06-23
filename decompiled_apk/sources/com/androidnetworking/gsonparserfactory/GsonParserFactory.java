package com.androidnetworking.gsonparserfactory;

import com.androidnetworking.interfaces.Parser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* loaded from: classes.dex */
public final class GsonParserFactory extends Parser.Factory {
    private final Gson gson;

    public GsonParserFactory() {
        this.gson = new Gson();
    }

    @Override // com.androidnetworking.interfaces.Parser.Factory
    public Object getObject(String str, Type type) {
        try {
            return this.gson.fromJson(str, type);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.androidnetworking.interfaces.Parser.Factory
    public String getString(Object obj) {
        try {
            return this.gson.toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.androidnetworking.interfaces.Parser.Factory
    public HashMap<String, String> getStringMap(Object obj) {
        try {
            Type type = new TypeToken<HashMap<String, String>>() { // from class: com.androidnetworking.gsonparserfactory.GsonParserFactory.1
            }.getType();
            Gson gson = this.gson;
            return (HashMap) gson.fromJson(gson.toJson(obj), type);
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    @Override // com.androidnetworking.interfaces.Parser.Factory
    public Parser<?, RequestBody> requestBodyParser(Type type) {
        return new GsonRequestBodyParser(this.gson, this.gson.getAdapter(TypeToken.get(type)));
    }

    @Override // com.androidnetworking.interfaces.Parser.Factory
    public Parser<ResponseBody, ?> responseBodyParser(Type type) {
        return new GsonResponseBodyParser(this.gson, this.gson.getAdapter(TypeToken.get(type)));
    }

    public GsonParserFactory(Gson gson) {
        this.gson = gson;
    }
}
