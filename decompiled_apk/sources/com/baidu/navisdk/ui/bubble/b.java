package com.baidu.navisdk.ui.bubble;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f8351a;
    private int b;
    private View d;
    private CharSequence e;
    private e g;
    private int c = -1;
    private int f = 5000;
    private a h = new a(this);
    private int i = 1;

    /* loaded from: classes8.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private int f8352a;
        private int b;
        private int c = Integer.MIN_VALUE;
        private int d = Integer.MIN_VALUE;
        private int[] e;

        public a(b bVar) {
        }

        public void a(int i) {
            this.c = i;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public int e() {
            return this.f8352a;
        }

        public String toString() {
            return "ExtraParams{mWidth=" + this.f8352a + ", mHeight=" + this.b + ", mHorizontalOffset=" + this.c + ", mVerticalOffset=" + this.d + '}';
        }

        public int[] a() {
            return this.e;
        }

        public void b(int i) {
            this.d = i;
        }

        public void a(int[] iArr) {
            this.e = iArr;
        }
    }

    private String k() {
        if (LogUtil.LOGGABLE) {
            switch (this.c) {
                case 0:
                    return "TOP";
                case 1:
                    return "LEFT";
                case 2:
                    return "DOWN";
                case 3:
                    return "RIGHT";
                case 4:
                    return "TOP_LEFT";
                case 5:
                    return "TOP_RIGHT";
                case 6:
                    return "DOWN_LEFT";
                case 7:
                    return "DOWN_RIGHT";
                default:
                    return "INVALID";
            }
        }
        return null;
    }

    public View a() {
        return this.d;
    }

    public void b(int i) {
        this.c = i;
    }

    public void c(int i) {
        this.b = i;
    }

    public void d(int i) {
        this.f8351a = i;
    }

    @NonNull
    public a e() {
        return this.h;
    }

    public e f() {
        return this.g;
    }

    public int g() {
        return this.i;
    }

    public int h() {
        return this.b;
    }

    public int i() {
        return this.f8351a;
    }

    public boolean j() {
        if (this.c != -1 && !TextUtils.isEmpty(this.e) && this.d != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        Object k;
        StringBuilder sb = new StringBuilder();
        sb.append("Bubble{mType=");
        sb.append(this.f8351a);
        sb.append(", mPriority=");
        sb.append(this.b);
        sb.append(", mDirection=");
        if (TextUtils.isEmpty(k())) {
            k = Integer.valueOf(this.c);
        } else {
            k = k();
        }
        sb.append(k);
        sb.append(", mContent='");
        sb.append((Object) this.e);
        sb.append(", mAnchorView=");
        sb.append(this.d);
        sb.append(", mListener=");
        sb.append(this.g);
        sb.append(", mExtraParams=");
        sb.append(this.h);
        sb.append('}');
        return sb.toString();
    }

    public void a(View view) {
        this.d = view;
    }

    public int b() {
        return this.f;
    }

    public CharSequence c() {
        return this.e;
    }

    public int d() {
        return this.c;
    }

    public void a(CharSequence charSequence) {
        this.e = charSequence;
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(e eVar) {
        this.g = eVar;
    }

    public void a(@NonNull a aVar) {
        this.h = aVar;
    }
}
