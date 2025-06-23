package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class SkinAppCompatDelegateImpl extends AppCompatDelegateImpl {
    private static Map<Activity, WeakReference<AppCompatDelegate>> sDelegateMap = new WeakHashMap();

    private SkinAppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    public static AppCompatDelegate get(Activity activity, AppCompatCallback appCompatCallback) {
        AppCompatDelegate appCompatDelegate;
        WeakReference weakReference = sDelegateMap.get(activity);
        if (weakReference == null) {
            appCompatDelegate = null;
        } else {
            appCompatDelegate = (AppCompatDelegate) weakReference.get();
        }
        if (appCompatDelegate != null) {
            return appCompatDelegate;
        }
        SkinAppCompatDelegateImpl skinAppCompatDelegateImpl = new SkinAppCompatDelegateImpl(activity, activity.getWindow(), appCompatCallback);
        sDelegateMap.put(activity, new WeakReference(skinAppCompatDelegateImpl));
        return skinAppCompatDelegateImpl;
    }

    public /* bridge */ /* synthetic */ void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addContentView(view, layoutParams);
    }

    public /* bridge */ /* synthetic */ boolean applyDayNight() {
        return super.applyDayNight();
    }

    @CallSuper
    @NonNull
    public /* bridge */ /* synthetic */ Context attachBaseContext2(@NonNull Context context) {
        return super.attachBaseContext2(context);
    }

    public /* bridge */ /* synthetic */ View createView(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return super.createView(view, str, context, attributeSet);
    }

    @Nullable
    public /* bridge */ /* synthetic */ View findViewById(@IdRes int i) {
        return super.findViewById(i);
    }

    public /* bridge */ /* synthetic */ Context getContextForDelegate() {
        return super.getContextForDelegate();
    }

    public /* bridge */ /* synthetic */ int getLocalNightMode() {
        return super.getLocalNightMode();
    }

    public /* bridge */ /* synthetic */ MenuInflater getMenuInflater() {
        return super.getMenuInflater();
    }

    public /* bridge */ /* synthetic */ ActionBar getSupportActionBar() {
        return super.getSupportActionBar();
    }

    public /* bridge */ /* synthetic */ boolean hasWindowFeature(int i) {
        return super.hasWindowFeature(i);
    }

    public void installViewFactory() {
    }

    public /* bridge */ /* synthetic */ void invalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }

    public /* bridge */ /* synthetic */ boolean isHandleNativeActionModesEnabled() {
        return super.isHandleNativeActionModesEnabled();
    }

    public /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public /* bridge */ /* synthetic */ void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    public /* bridge */ /* synthetic */ boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        return super.onMenuItemSelected(menuBuilder, menuItem);
    }

    public /* bridge */ /* synthetic */ void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
        super.onMenuModeChange(menuBuilder);
    }

    public /* bridge */ /* synthetic */ void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    public /* bridge */ /* synthetic */ void onPostResume() {
        super.onPostResume();
    }

    public /* bridge */ /* synthetic */ void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public /* bridge */ /* synthetic */ void onStart() {
        super.onStart();
    }

    public /* bridge */ /* synthetic */ void onStop() {
        super.onStop();
    }

    public /* bridge */ /* synthetic */ boolean requestWindowFeature(int i) {
        return super.requestWindowFeature(i);
    }

    public /* bridge */ /* synthetic */ void setContentView(int i) {
        super.setContentView(i);
    }

    public /* bridge */ /* synthetic */ void setHandleNativeActionModesEnabled(boolean z) {
        super.setHandleNativeActionModesEnabled(z);
    }

    public /* bridge */ /* synthetic */ void setLocalNightMode(int i) {
        super.setLocalNightMode(i);
    }

    @RequiresApi(33)
    public /* bridge */ /* synthetic */ void setOnBackInvokedDispatcher(@Nullable OnBackInvokedDispatcher onBackInvokedDispatcher) {
        super.setOnBackInvokedDispatcher(onBackInvokedDispatcher);
    }

    public /* bridge */ /* synthetic */ void setSupportActionBar(Toolbar toolbar) {
        super.setSupportActionBar(toolbar);
    }

    public /* bridge */ /* synthetic */ void setTheme(@StyleRes int i) {
        super.setTheme(i);
    }

    public /* bridge */ /* synthetic */ ActionMode startSupportActionMode(@NonNull ActionMode.Callback callback) {
        return super.startSupportActionMode(callback);
    }

    public /* bridge */ /* synthetic */ void setContentView(View view) {
        super.setContentView(view);
    }

    public /* bridge */ /* synthetic */ void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
    }
}
