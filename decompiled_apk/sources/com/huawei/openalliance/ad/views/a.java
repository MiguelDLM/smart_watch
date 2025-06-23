package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.download.app.k;
import java.util.Locale;

/* loaded from: classes10.dex */
public class a {
    protected Drawable C;
    protected C0672a V = new C0672a();
    protected C0672a I = new C0672a();
    protected C0672a Z = new C0672a();
    protected C0672a B = new C0672a();

    /* renamed from: com.huawei.openalliance.ad.views.a$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[k.values().length];
            Code = iArr;
            try {
                iArr[k.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[k.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[k.INSTALLING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[k.INSTALLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Code[k.DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Code[k.INSTALL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0672a {
        protected Drawable Code;
        protected int I = 12;
        protected int V;
        protected Typeface Z;

        public Drawable Code() {
            return this.Code;
        }

        public void V(int i) {
            this.I = i;
        }

        public void Code(int i) {
            this.V = i;
        }

        public void Code(Typeface typeface) {
            this.Z = typeface;
        }

        public void Code(Drawable drawable) {
            this.Code = drawable;
        }
    }

    public a(Context context) {
        this.V.Code = context.getResources().getDrawable(R.drawable.hiad_app_down_btn_normal);
        this.V.V = context.getResources().getColor(R.color.hiad_down_normal_text);
        this.I.Code(Code(context, R.drawable.hiad_app_down_btn_processing));
        this.I.Code(context.getResources().getColor(R.color.hiad_app_down_processing_text));
        this.Z.Code(context.getResources().getDrawable(R.drawable.hiad_app_down_btn_installing));
        this.Z.Code(context.getResources().getColor(R.color.hiad_app_down_installing_text));
        this.C = context.getResources().getDrawable(R.drawable.hiad_app_down_cancel_btn);
    }

    public Drawable Code(Context context, int i) {
        Drawable drawable = context.getResources().getDrawable(i);
        if (Build.VERSION.SDK_INT >= 23 && TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            drawable.setLayoutDirection(1);
        }
        return drawable;
    }

    public C0672a Z() {
        return this.B;
    }

    public C0672a Code() {
        return this.V;
    }

    public C0672a Code(Context context, k kVar) {
        int i = AnonymousClass1.Code[kVar.ordinal()];
        return (i == 1 || i == 2) ? this.I : i != 3 ? Code() : this.Z;
    }
}
