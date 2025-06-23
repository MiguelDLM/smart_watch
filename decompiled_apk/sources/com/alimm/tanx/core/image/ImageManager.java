package com.alimm.tanx.core.image;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.alimm.tanx.core.TanxCoreInstanceConfig;
import com.alimm.tanx.core.image.util.ImageConfig;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: classes.dex */
public class ImageManager implements NotConfused {
    private static volatile ILoader loader;

    public static ILoader getLoader() {
        if (loader == null) {
            loader = TanxCoreInstanceConfig.getInstance().getImageLoader();
        }
        return loader;
    }

    public static boolean isValidContextForGlide(Context context) {
        if (context == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        if (activity.isDestroyed() || activity.isFinishing()) {
            return false;
        }
        return true;
    }

    public static void setLoader(ILoader iLoader) {
        String str;
        if (iLoader == null) {
            str = "loader==null";
        } else {
            str = "loader!=null";
        }
        Log.d("ImageManager", str);
        loader = iLoader;
    }

    public static ImageConfig.Builder with(Context context) {
        if (isValidContextForGlide(context)) {
            return new ImageConfig.Builder(context);
        }
        return new ImageConfig.Builder(context.getApplicationContext());
    }
}
