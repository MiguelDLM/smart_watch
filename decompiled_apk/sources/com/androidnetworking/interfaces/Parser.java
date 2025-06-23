package com.androidnetworking.interfaces;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* loaded from: classes.dex */
public interface Parser<F, T> {

    /* loaded from: classes.dex */
    public static abstract class Factory {
        public Object getObject(String str, Type type) {
            return null;
        }

        public String getString(Object obj) {
            return null;
        }

        public HashMap<String, String> getStringMap(Object obj) {
            return null;
        }

        public Parser<?, RequestBody> requestBodyParser(Type type) {
            return null;
        }

        public Parser<ResponseBody, ?> responseBodyParser(Type type) {
            return null;
        }
    }

    T convert(F f) throws IOException;
}
