package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes11.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Context f25930a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public Drawable g;
    public InterfaceC1035b h;
    public View i;
    public int j;

    /* loaded from: classes11.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public View f25931a;
        public int b;
        private Context c;
        private String d;
        private String e;
        private String f;
        private String g;
        private boolean h;
        private Drawable i;
        private InterfaceC1035b j;

        public a(Context context) {
            this.c = context;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a b(String str) {
            this.e = str;
            return this;
        }

        public a c(String str) {
            this.f = str;
            return this;
        }

        public a d(String str) {
            this.g = str;
            return this;
        }

        public a a(boolean z) {
            this.h = z;
            return this;
        }

        public a a(Drawable drawable) {
            this.i = drawable;
            return this;
        }

        public a a(InterfaceC1035b interfaceC1035b) {
            this.j = interfaceC1035b;
            return this;
        }

        public a a(int i) {
            this.b = i;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.ss.android.download.api.model.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC1035b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    private b(a aVar) {
        this.f = true;
        this.f25930a = aVar.c;
        this.b = aVar.d;
        this.c = aVar.e;
        this.d = aVar.f;
        this.e = aVar.g;
        this.f = aVar.h;
        this.g = aVar.i;
        this.h = aVar.j;
        this.i = aVar.f25931a;
        this.j = aVar.b;
    }
}
