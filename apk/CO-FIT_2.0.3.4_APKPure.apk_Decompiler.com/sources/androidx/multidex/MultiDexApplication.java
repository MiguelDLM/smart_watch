package androidx.multidex;

import android.app.Application;
import android.content.Context;

public class MultiDexApplication extends Application {
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }
}
