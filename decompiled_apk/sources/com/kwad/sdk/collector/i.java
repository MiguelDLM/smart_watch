package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public final class i {
    public static void a(Context context, AppStatusRules.Strategy strategy, long j) {
        if (context == null || strategy == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putLong(b(strategy), j).apply();
    }

    private static String b(AppStatusRules.Strategy strategy) {
        String name;
        if (strategy.getName() == null) {
            name = "defaultStrategy";
        } else {
            name = strategy.getName();
        }
        return "appstatus_strategy_pref_" + name;
    }

    public static List<AppStatusRules.Strategy> c(@Nullable AppStatusRules appStatusRules) {
        if (appStatusRules == null) {
            return new ArrayList();
        }
        return appStatusRules.obtainNamedStrategyList();
    }

    @NonNull
    public static AppStatusRules.Strategy d(@Nullable AppStatusRules appStatusRules) {
        if (appStatusRules == null) {
            return AppStatusRules.Strategy.LOCAL_DEFAULT;
        }
        return appStatusRules.obtainDefaultStrategy();
    }

    public static boolean a(Context context, @NonNull AppStatusRules.Strategy strategy) {
        if (context == null) {
            return false;
        }
        long j = context.getSharedPreferences("ksadsdk_pref", 0).getLong(b(strategy), -1L);
        if (j < 0) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long minLaunchIntervalWithMS = strategy.getMinLaunchIntervalWithMS();
        return minLaunchIntervalWithMS <= 0 || j + minLaunchIntervalWithMS < currentTimeMillis;
    }
}
