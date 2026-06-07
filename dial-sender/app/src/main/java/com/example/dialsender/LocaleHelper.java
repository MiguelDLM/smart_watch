package com.example.dialsender;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import java.util.Locale;

public class LocaleHelper {

    private static final String PREF_NAME = "dial_sender_prefs";
    private static final String KEY = "app_language";
    private static final String DEFAULT = "es";

    public static String getSavedLanguage(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
                .getString(KEY, DEFAULT);
    }

    public static void saveLanguage(Context context, String lang) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
                .edit().putString(KEY, lang).apply();
    }

    /** Wrap a base Context with the user-selected locale. Call from attachBaseContext. */
    public static Context wrap(Context base) {
        String lang = base.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
                .getString(KEY, DEFAULT);
        return applyLocale(base, lang);
    }

    public static Context applyLocale(Context context, String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration(context.getResources().getConfiguration());
        config.setLocale(locale);
        return context.createConfigurationContext(config);
    }
}
