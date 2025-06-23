package com.baidu.navisdk.ui.util;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/* loaded from: classes8.dex */
public class i extends ContextWrapper {

    /* loaded from: classes8.dex */
    public class a extends ContextWrapper {
        public a(Context context) {
            super(context);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            if (str.equals("window")) {
                return new b(i.this, (WindowManager) getBaseContext().getSystemService("window"));
            }
            return super.getSystemService(str);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements WindowManager {

        /* renamed from: a, reason: collision with root package name */
        private WindowManager f9205a;

        public b(i iVar, WindowManager windowManager) {
            this.f9205a = windowManager;
        }

        @Override // android.view.ViewManager
        public void addView(View view, ViewGroup.LayoutParams layoutParams) {
            try {
                this.f9205a.addView(view, layoutParams);
            } catch (WindowManager.BadTokenException e) {
                e.printStackTrace();
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.view.WindowManager
        public Display getDefaultDisplay() {
            return this.f9205a.getDefaultDisplay();
        }

        @Override // android.view.ViewManager
        public void removeView(View view) {
            this.f9205a.removeView(view);
        }

        @Override // android.view.WindowManager
        public void removeViewImmediate(View view) {
            this.f9205a.removeViewImmediate(view);
        }

        @Override // android.view.ViewManager
        public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
            this.f9205a.updateViewLayout(view, layoutParams);
        }
    }

    public i(Context context) {
        super(context);
    }

    public static boolean a() {
        int i = Build.VERSION.SDK_INT;
        if (i == 25) {
            return true;
        }
        if (i != 26) {
            return false;
        }
        String str = Build.MODEL;
        if ("SM-G9550".equals(str) || "SM-G9500".equals(str) || "SM-G9650".equals(str) || "MI 6".equals(str)) {
            return true;
        }
        return false;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return new a(getBaseContext());
    }
}
