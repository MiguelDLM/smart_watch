package com.androidnetworking.utils;

import com.androidnetworking.gsonparserfactory.GsonParserFactory;
import com.androidnetworking.interfaces.Parser;
import com.google.gson.Gson;

/* loaded from: classes.dex */
public class ParseUtil {
    private static Parser.Factory mParserFactory;

    public static Parser.Factory getParserFactory() {
        if (mParserFactory == null) {
            mParserFactory = new GsonParserFactory(new Gson());
        }
        return mParserFactory;
    }

    public static void setParserFactory(Parser.Factory factory) {
        mParserFactory = factory;
    }

    public static void shutDown() {
        mParserFactory = null;
    }
}
