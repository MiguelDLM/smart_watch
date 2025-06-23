package com.baidu.navisdk.context;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.navisdk.util.common.b0;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: com.baidu.navisdk.context.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0188a extends LayoutInflater {

        /* renamed from: a, reason: collision with root package name */
        private static final String[] f6759a = {"android.widget.", "android.webkit.", "android.app."};

        public C0188a(Context context) {
            super(context);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context context) {
            return new C0188a(context);
        }

        @Override // android.view.LayoutInflater
        public View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
            View createView;
            for (String str2 : f6759a) {
                try {
                    createView = createView(str, str2, attributeSet);
                } catch (ClassNotFoundException unused) {
                }
                if (createView != null) {
                    return createView;
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    public abstract Context a();

    public abstract void a(@NonNull String... strArr);

    public abstract b0 b();

    public abstract void b(@NonNull String... strArr);

    public final boolean c() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }
}
