package com.androidnetworking.gsonparserfactory;

import com.androidnetworking.interfaces.Parser;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import okhttp3.ResponseBody;

/* loaded from: classes.dex */
final class GsonResponseBodyParser<T> implements Parser<ResponseBody, T> {
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    public GsonResponseBodyParser(Gson gson, TypeAdapter<T> typeAdapter) {
        this.gson = gson;
        this.adapter = typeAdapter;
    }

    @Override // com.androidnetworking.interfaces.Parser
    public T convert(ResponseBody responseBody) throws IOException {
        try {
            return this.adapter.read2(this.gson.newJsonReader(responseBody.charStream()));
        } finally {
            responseBody.close();
        }
    }
}
