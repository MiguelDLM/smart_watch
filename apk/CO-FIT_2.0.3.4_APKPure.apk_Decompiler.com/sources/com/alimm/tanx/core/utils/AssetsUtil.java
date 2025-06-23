package com.alimm.tanx.core.utils;

import android.content.Context;
import android.content.res.AssetManager;

public class AssetsUtil implements NotConfused {
    public static AssetManager getApplicationAssets(Context context) {
        if (context != null) {
            return context.getApplicationContext().getAssets();
        }
        return null;
    }
}
