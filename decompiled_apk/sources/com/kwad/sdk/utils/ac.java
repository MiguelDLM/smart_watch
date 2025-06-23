package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

/* loaded from: classes11.dex */
public final class ac {
    @WorkerThread
    public static String a(String str, a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            return str.replace("__WIDTH__", ea(aVar.getWidth())).replace("__HEIGHT__", ea(aVar.getHeight())).replace("__DOWN_X__", ea(aVar.MD())).replace("__DOWN_Y__", ea(aVar.ME())).replace("__UP_X__", ea(aVar.MF())).replace("__UP_Y__", ea(aVar.MG()));
        }
        return str;
    }

    public static String am(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.replace("__SCREEN_WIDTH__", String.valueOf(k.getScreenWidth(context))).replace("__SCREEN_HEIGHT__", String.valueOf(k.getScreenHeight(context))).replace("__DEVICE_WIDTH__", String.valueOf(k.cg(context))).replace("__DEVICE_HEIGHT__", String.valueOf(k.ch(context)));
    }

    public static String c(@Nullable Context context, String str, boolean z) {
        return str.replace("__TS__", String.valueOf(bl.v(context, z)));
    }

    private static String ea(int i) {
        if (i >= 0) {
            return String.valueOf(i);
        }
        return "-999";
    }

    /* loaded from: classes11.dex */
    public static class a {
        private int aQo;
        private int aQp;
        private int aQq;
        private int aQr;
        private int mHeight;
        private int mWidth;

        public a() {
            this.mWidth = -1;
            this.mHeight = -1;
            this.aQo = -1;
            this.aQp = -1;
            this.aQq = -1;
            this.aQr = -1;
        }

        public final int MD() {
            return this.aQo;
        }

        public final int ME() {
            return this.aQp;
        }

        public final int MF() {
            return this.aQq;
        }

        public final int MG() {
            return this.aQr;
        }

        public final void f(float f, float f2) {
            this.aQo = (int) f;
            this.aQp = (int) f2;
        }

        public final void g(float f, float f2) {
            this.aQq = (int) f;
            this.aQr = (int) f2;
        }

        public final int getHeight() {
            return this.mHeight;
        }

        public final int getWidth() {
            return this.mWidth;
        }

        public final String toString() {
            return "TouchCoords{mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mDownX=" + this.aQo + ", mDownY=" + this.aQp + ", mUpX=" + this.aQq + ", mUpY=" + this.aQr + '}';
        }

        public final void z(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
        }

        public a(int i, int i2) {
            this.aQo = -1;
            this.aQp = -1;
            this.aQq = -1;
            this.aQr = -1;
            this.mWidth = i;
            this.mHeight = i2;
        }
    }
}
