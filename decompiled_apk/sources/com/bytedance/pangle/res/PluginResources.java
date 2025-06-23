package com.bytedance.pangle.res;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.j;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;

@Keep
/* loaded from: classes8.dex */
public class PluginResources extends Resources {
    public String pluginPkg;

    public PluginResources(Resources resources, String str) {
        super(appendHostRes(resources), resources.getDisplayMetrics(), Zeus.getAppApplication().getResources().getConfiguration());
        this.pluginPkg = str;
    }

    public static AssetManager appendHostRes(Resources resources) {
        String a2 = g.a(Zeus.getAppApplication());
        String b = g.b(Zeus.getAppApplication());
        List<String> b2 = j.b();
        a aVar = new a();
        AssetManager assets = resources.getAssets();
        AssetManager assets2 = Zeus.getAppApplication().getAssets();
        HashSet hashSet = new HashSet(j.a(assets));
        List<String> a3 = j.a(assets2);
        for (String str : b2) {
            if (!hashSet.contains(str)) {
                assets = aVar.a(assets, str, true);
            }
        }
        for (String str2 : a3) {
            if (!isOtherPlugin(str2, a2, b) && !hashSet.contains(str2) && !b2.contains(str2)) {
                assets = aVar.a(assets, str2, false);
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_RESOURCES, "pluginAssets = " + j.b(assets));
        return assets;
    }

    private Resources.NotFoundException handleException(Resources.NotFoundException notFoundException) {
        return new Resources.NotFoundException(("Resources#Assets: " + j.b(getAssets())) + "," + notFoundException.getMessage());
    }

    private static boolean isOtherPlugin(String str, String str2, String str3) {
        String packageResourcePath = Zeus.getAppApplication().getPackageResourcePath();
        if (!TextUtils.isEmpty(str3)) {
            packageResourcePath = packageResourcePath.replaceFirst(str2, str3);
            str = str.replaceFirst(str2, str3);
        }
        ZeusLogger.d(ZeusLogger.TAG_RESOURCES, str + " " + packageResourcePath + " " + str2 + " " + str3);
        if (TextUtils.equals(str, packageResourcePath) || str.contains("/tinker/patch-")) {
            return false;
        }
        if (TextUtils.isEmpty(str2) || !str.contains(str2)) {
            if (TextUtils.isEmpty(str3) || !str.contains(str3)) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // android.content.res.Resources
    @NonNull
    public XmlResourceParser getAnimation(int i) {
        try {
            return super.getAnimation(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i) {
        try {
            return super.getBoolean(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public int getColor(int i) {
        try {
            return super.getColor(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public ColorStateList getColorStateList(int i) {
        try {
            return super.getColorStateList(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public float getDimension(int i) {
        try {
            return super.getDimension(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i) {
        try {
            return super.getDimensionPixelOffset(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i) {
        try {
            return super.getDimensionPixelSize(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        try {
            return super.getDrawable(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @Nullable
    public Drawable getDrawableForDensity(int i, int i2) {
        try {
            return super.getDrawableForDensity(i, i2);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public float getFloat(int i) {
        try {
            return super.getFloat(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public Typeface getFont(int i) {
        try {
            return super.getFont(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        try {
            return super.getFraction(i, i2, i3);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public int[] getIntArray(int i) {
        try {
            return super.getIntArray(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public int getInteger(int i) {
        try {
            return super.getInteger(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public XmlResourceParser getLayout(int i) {
        try {
            return super.getLayout(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i) {
        try {
            return super.getMovie(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getQuantityString(int i, int i2, Object... objArr) {
        try {
            return super.getQuantityString(i, i2, objArr);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public CharSequence getQuantityText(int i, int i2) {
        try {
            return super.getQuantityText(i, i2);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i) {
        try {
            return super.getResourceEntryName(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i) {
        try {
            return super.getResourceName(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i) {
        try {
            return super.getResourcePackageName(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i) {
        try {
            return super.getResourceTypeName(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getString(int i) {
        try {
            return super.getString(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String[] getStringArray(int i) {
        try {
            return super.getStringArray(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public CharSequence getText(int i) {
        try {
            return super.getText(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public CharSequence[] getTextArray(int i) {
        try {
            return super.getTextArray(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public void getValue(int i, TypedValue typedValue, boolean z) {
        try {
            super.getValue(i, typedValue, z);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) {
        try {
            super.getValueForDensity(i, i2, typedValue, z);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public XmlResourceParser getXml(int i) {
        try {
            return super.getXml(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public TypedArray obtainTypedArray(int i) {
        try {
            return super.obtainTypedArray(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public InputStream openRawResource(int i) {
        try {
            return super.openRawResource(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i) {
        try {
            return super.openRawResourceFd(i);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public int getColor(int i, @Nullable Resources.Theme theme) {
        try {
            return super.getColor(i, theme);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public ColorStateList getColorStateList(int i, @Nullable Resources.Theme theme) {
        try {
            return super.getColorStateList(i, theme);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i, @Nullable Resources.Theme theme) {
        try {
            return super.getDrawable(i, theme);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @Nullable
    public Drawable getDrawableForDensity(int i, int i2, @Nullable Resources.Theme theme) {
        try {
            return super.getDrawableForDensity(i, i2, theme);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getQuantityString(int i, int i2) {
        try {
            return super.getQuantityString(i, i2);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getString(int i, Object... objArr) {
        try {
            return super.getString(i, objArr);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i, CharSequence charSequence) {
        try {
            return super.getText(i, charSequence);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) {
        try {
            super.getValue(str, typedValue, z);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public InputStream openRawResource(int i, TypedValue typedValue) {
        try {
            return super.openRawResource(i, typedValue);
        } catch (Resources.NotFoundException e) {
            throw handleException(e);
        }
    }
}
