package com.kwad.sdk.n;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.InputStream;

/* loaded from: classes11.dex */
public final class h extends Resources {
    private final Resources aUk;

    public h(Resources resources, Resources resources2) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.aUk = resources2;
    }

    private static boolean az(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.startsWith("ksad_") && "com.kwad.dy.sdk".equals(str2)) {
            return false;
        }
        return true;
    }

    private static boolean eu(int i) {
        if (!(HexStringBuilder.DEFAULT_PREFIX + Integer.toHexString(i)).startsWith("0x60")) {
            return true;
        }
        return false;
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getAnimation(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getAnimation id: 0x#" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getAnimation(i);
        }
        return super.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public final boolean getBoolean(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getBoolean id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getBoolean(i);
        }
        return super.getBoolean(i);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final int getColor(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getColor id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getColor(i);
        }
        return super.getColor(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    @RequiresApi(api = 23)
    public final ColorStateList getColorStateList(int i, @Nullable Resources.Theme theme) {
        ColorStateList colorStateList;
        try {
            com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getColorStateList: 0x#" + Integer.toHexString(i));
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.e("KSDY/KSResource", Log.getStackTraceString(e));
        }
        if (eu(i)) {
            colorStateList = this.aUk.getColorStateList(i, theme);
            return colorStateList;
        }
        return super.getColorStateList(i, theme);
    }

    @Override // android.content.res.Resources
    public final float getDimension(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDimension id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getDimension(i);
        }
        return super.getDimension(i);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelOffset(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDimensionPixelOffset id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getDimensionPixelOffset(i);
        }
        return super.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelSize(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDimensionPixelSize id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getDimensionPixelSize(i);
        }
        return super.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public final DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Drawable getDrawable(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getDrawable(i);
        }
        return super.getDrawable(i);
    }

    @Override // android.content.res.Resources
    @Nullable
    @Deprecated
    public final Drawable getDrawableForDensity(int i, int i2) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDrawableForDensity id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getDrawableForDensity(i, i2);
        }
        return super.getDrawableForDensity(i, i2);
    }

    @Override // android.content.res.Resources
    @RequiresApi(api = 29)
    public final float getFloat(int i) {
        float f;
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getFloat id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            f = this.aUk.getFloat(i);
            return f;
        }
        return super.getFloat(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    @RequiresApi(api = 26)
    public final Typeface getFont(int i) {
        Typeface font;
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getFont id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            font = this.aUk.getFont(i);
            return font;
        }
        return super.getFont(i);
    }

    @Override // android.content.res.Resources
    public final float getFraction(int i, int i2, int i3) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getFraction id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getFraction(i, i2, i3);
        }
        return super.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    public final int getIdentifier(String str, String str2, String str3) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getIdentifier id: 0x# name:" + str + " :defPackage" + str3);
        if (az(str, str3)) {
            return this.aUk.getIdentifier(str, str2, str3);
        }
        return super.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final int[] getIntArray(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getIntArray id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getIntArray(i);
        }
        return super.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public final int getInteger(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getInteger id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getInteger(i);
        }
        return super.getInteger(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getLayout(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getLayout id: 0x#" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getLayout(i);
        }
        return super.getLayout(i);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Movie getMovie(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getMovie id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getMovie(i);
        }
        return super.getMovie(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getQuantityString(int i, int i2) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getQuantityString id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getQuantityString(i, i2);
        }
        return super.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence getQuantityText(int i, int i2) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getQuantityText id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getQuantityText(i, i2);
        }
        return super.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public final String getResourceEntryName(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getResourceEntryName id: 0x#" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getResourceEntryName(i);
        }
        return super.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public final String getResourceName(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getResourceName id: 0x#" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getResourceName(i);
        }
        return super.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public final String getResourcePackageName(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getResourcePackageName id: 0x#" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getResourcePackageName(i);
        }
        return super.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public final String getResourceTypeName(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getResourceTypeName id: 0x#" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getResourceTypeName(i);
        }
        return super.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getString(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getString id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getString(i);
        }
        return super.getString(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String[] getStringArray(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getStringArray id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getStringArray(i);
        }
        return super.getStringArray(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence getText(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getText id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getText(i);
        }
        return super.getText(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence[] getTextArray(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getTextArray id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getTextArray(i);
        }
        return super.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public final void getValue(int i, TypedValue typedValue, boolean z) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getValue id: 0x#" + Integer.toHexString(i));
        if (eu(i)) {
            this.aUk.getValue(i, typedValue, z);
        } else {
            super.getValue(i, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public final void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getValueForDensity id: 0x#" + Integer.toHexString(i));
        if (eu(i)) {
            this.aUk.getValueForDensity(i, i2, typedValue, z);
        } else {
            super.getValueForDensity(i, i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getXml(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getXml id: 0x#" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getXml(i);
        }
        return super.getXml(i);
    }

    @Override // android.content.res.Resources
    public final TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return super.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final TypedArray obtainTypedArray(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "obtainTypedArray id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.obtainTypedArray(i);
        }
        return super.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final InputStream openRawResource(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "openRawResource id: 0x#" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.openRawResource(i);
        }
        return super.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public final AssetFileDescriptor openRawResourceFd(int i) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "openRawResourceFd id: 0x#" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.openRawResourceFd(i);
        }
        return super.openRawResourceFd(i);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        super.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        super.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public final void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
    }

    @Override // android.content.res.Resources
    @RequiresApi(api = 23)
    public final int getColor(int i, @Nullable Resources.Theme theme) {
        int color;
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getMovie id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            color = this.aUk.getColor(i, theme);
            return color;
        }
        return super.getColor(i, theme);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawable(int i, @Nullable Resources.Theme theme) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getDrawable(i);
        }
        return super.getDrawable(i, theme);
    }

    @Override // android.content.res.Resources
    @Nullable
    @RequiresApi(api = 21)
    public final Drawable getDrawableForDensity(int i, int i2, @Nullable Resources.Theme theme) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getDrawableForDensity(i, i2, theme);
        }
        return super.getDrawableForDensity(i, i2, theme);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getQuantityString(int i, int i2, Object... objArr) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getQuantityString id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getQuantityString(i, i2, objArr);
        }
        return super.getQuantityString(i, i2, objArr);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getString(int i, Object... objArr) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getString id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getString(i, objArr);
        }
        return super.getString(i, objArr);
    }

    @Override // android.content.res.Resources
    public final CharSequence getText(int i, CharSequence charSequence) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getText id: #0x" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.getText(i, charSequence);
        }
        return super.getText(i, charSequence);
    }

    @Override // android.content.res.Resources
    public final void getValue(String str, TypedValue typedValue, boolean z) {
        int identifier = getIdentifier(str, TypedValues.Custom.S_STRING, null);
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getValue id: 0x#" + Integer.toHexString(identifier));
        if (eu(identifier)) {
            this.aUk.getValue(str, typedValue, z);
        } else {
            super.getValue(str, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public final InputStream openRawResource(int i, TypedValue typedValue) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "openRawResource id: 0x#" + Integer.toHexString(i));
        if (eu(i)) {
            return this.aUk.openRawResource(i, typedValue);
        }
        return super.openRawResource(i, typedValue);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final ColorStateList getColorStateList(int i) {
        try {
            com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getColorStateList: 0x#" + Integer.toHexString(i));
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.e("KSDY/KSResource", Log.getStackTraceString(e));
        }
        if (eu(i)) {
            return this.aUk.getColorStateList(i);
        }
        return super.getColorStateList(i);
    }
}
