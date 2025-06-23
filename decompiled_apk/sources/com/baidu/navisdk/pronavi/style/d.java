package com.baidu.navisdk.pronavi.style;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.text.TextUtils;
import android.view.animation.Animation;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.StringRes;
import java.util.HashMap;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public abstract class d {

    /* loaded from: classes7.dex */
    public static final class a extends d {

        /* renamed from: a, reason: collision with root package name */
        @oOoXoXO
        private HashMap<String, Integer> f7818a;

        @oOoXoXO
        private HashMap<String, Integer> b;
        private int c;
        private int d;
        private int e;
        private int f;

        /* renamed from: com.baidu.navisdk.pronavi.style.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0333a {

            /* renamed from: a, reason: collision with root package name */
            @DrawableRes
            private int f7819a;

            @DrawableRes
            private int b;

            @ColorRes
            private int c;

            @StringRes
            private int d;
            private HashMap<String, Integer> e;
            private HashMap<String, Integer> f;

            @OOXIXo
            private final String g;
            private final HashMap<String, ? super d> h;

            @OOXIXo
            private final com.baidu.navisdk.pronavi.style.e i;

            public C0333a(@OOXIXo String key, @OOXIXo HashMap<String, ? super d> itemStyleMap, @OOXIXo com.baidu.navisdk.pronavi.style.e styleBuild) {
                IIX0o.x0xO0oo(key, "key");
                IIX0o.x0xO0oo(itemStyleMap, "itemStyleMap");
                IIX0o.x0xO0oo(styleBuild, "styleBuild");
                this.g = key;
                this.h = itemStyleMap;
                this.i = styleBuild;
            }

            @OOXIXo
            public final C0333a a(@DrawableRes int i) {
                this.f7819a = i;
                return this;
            }

            @OOXIXo
            public final C0333a b(@DrawableRes int i) {
                this.b = i;
                return this;
            }

            @OOXIXo
            public final C0333a c(@ColorRes int i) {
                this.c = i;
                return this;
            }

            @OOXIXo
            public final C0333a d(@StringRes int i) {
                this.d = i;
                return this;
            }

            @OOXIXo
            public final C0333a a(@oOoXoXO String str, @ColorRes int i) {
                if (TextUtils.isEmpty(str)) {
                    return this;
                }
                if (this.f == null) {
                    this.f = new HashMap<>(4, 1.0f);
                }
                HashMap<String, Integer> hashMap = this.f;
                IIX0o.ooOOo0oXI(hashMap);
                IIX0o.ooOOo0oXI(str);
                hashMap.put(str, Integer.valueOf(i));
                return this;
            }

            @OOXIXo
            public final C0333a b(@oOoXoXO String str, @DrawableRes int i) {
                if (TextUtils.isEmpty(str)) {
                    return this;
                }
                if (this.e == null) {
                    this.e = new HashMap<>(4, 1.0f);
                }
                HashMap<String, Integer> hashMap = this.e;
                IIX0o.ooOOo0oXI(hashMap);
                IIX0o.ooOOo0oXI(str);
                hashMap.put(str, Integer.valueOf(i));
                return this;
            }

            @OOXIXo
            public final com.baidu.navisdk.pronavi.style.e a() {
                a aVar = new a(this.g, this.f7819a, this.b, this.c, this.d);
                aVar.a(this.e);
                aVar.b(this.f);
                this.h.put(this.g, aVar);
                return this.i;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@OOXIXo String key, @DrawableRes int i, @DrawableRes int i2, @ColorRes int i3, @StringRes int i4) {
            super(key, null);
            IIX0o.x0xO0oo(key, "key");
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        public final int a() {
            return this.c;
        }

        @oOoXoXO
        public final HashMap<String, Integer> b() {
            return this.f7818a;
        }

        public final int c() {
            return this.d;
        }

        public final int d() {
            return this.e;
        }

        @oOoXoXO
        public final HashMap<String, Integer> e() {
            return this.b;
        }

        public final int f() {
            return this.f;
        }

        public final void a(@oOoXoXO HashMap<String, Integer> hashMap) {
            if (hashMap == null || hashMap.isEmpty()) {
                return;
            }
            HashMap<String, Integer> hashMap2 = this.f7818a;
            if (hashMap2 == null) {
                this.f7818a = new HashMap<>(hashMap.size(), 1.0f);
            } else {
                IIX0o.ooOOo0oXI(hashMap2);
                hashMap2.clear();
            }
            HashMap<String, Integer> hashMap3 = this.f7818a;
            IIX0o.ooOOo0oXI(hashMap3);
            hashMap3.putAll(hashMap);
        }

        public final void b(@oOoXoXO HashMap<String, Integer> hashMap) {
            if (hashMap == null || hashMap.isEmpty()) {
                return;
            }
            HashMap<String, Integer> hashMap2 = this.b;
            if (hashMap2 == null) {
                this.b = new HashMap<>(hashMap.size(), 1.0f);
            } else {
                IIX0o.ooOOo0oXI(hashMap2);
                hashMap2.clear();
            }
            HashMap<String, Integer> hashMap3 = this.b;
            IIX0o.ooOOo0oXI(hashMap3);
            hashMap3.putAll(hashMap);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends d {

        /* renamed from: a, reason: collision with root package name */
        private int f7820a;
        private int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@OOXIXo String key, @IntRange(from = 0, to = 255) int i, int i2) {
            super(key, null);
            IIX0o.x0xO0oo(key, "key");
            this.f7820a = i;
            this.b = i2;
        }

        public final int a() {
            return this.f7820a;
        }

        public final int b() {
            return this.b;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends d {

        /* renamed from: a, reason: collision with root package name */
        @oOoXoXO
        private final Animation f7821a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@OOXIXo String key, @oOoXoXO Animation animation) {
            super(key, null);
            IIX0o.x0xO0oo(key, "key");
            this.f7821a = animation;
        }

        @oOoXoXO
        public final Animation a() {
            return this.f7821a;
        }
    }

    /* renamed from: com.baidu.navisdk.pronavi.style.d$d, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0334d extends d {

        /* renamed from: a, reason: collision with root package name */
        private int f7822a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0334d(@OOXIXo String key, @DrawableRes int i) {
            super(key, null);
            IIX0o.x0xO0oo(key, "key");
            this.f7822a = i;
        }

        public final int a() {
            return this.f7822a;
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends d {

        /* renamed from: a, reason: collision with root package name */
        private int f7823a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@OOXIXo String key, @ColorRes int i) {
            super(key, null);
            IIX0o.x0xO0oo(key, "key");
            this.f7823a = i;
        }

        public final int a() {
            return this.f7823a;
        }
    }

    /* loaded from: classes7.dex */
    public static final class f extends d {

        /* renamed from: a, reason: collision with root package name */
        private int f7824a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@OOXIXo String key, @DrawableRes int i) {
            super(key, null);
            IIX0o.x0xO0oo(key, "key");
            this.f7824a = i;
        }

        public final int a() {
            return this.f7824a;
        }
    }

    /* loaded from: classes7.dex */
    public static final class g extends d {

        /* renamed from: a, reason: collision with root package name */
        private final int f7825a;
        private final int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(@OOXIXo String key, @ColorInt int i, int i2) {
            super(key, null);
            IIX0o.x0xO0oo(key, "key");
            this.f7825a = i;
            this.b = i2;
        }

        public final int a() {
            return this.f7825a;
        }

        public final int b() {
            return this.b;
        }
    }

    /* loaded from: classes7.dex */
    public static final class h extends d {

        /* renamed from: a, reason: collision with root package name */
        private int f7826a;

        public final int a() {
            return this.f7826a;
        }
    }

    /* loaded from: classes7.dex */
    public static final class i extends d {

        /* renamed from: a, reason: collision with root package name */
        private int f7827a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(@OOXIXo String key, @ColorRes int i) {
            super(key, null);
            IIX0o.x0xO0oo(key, "key");
            this.f7827a = i;
        }

        public final int a() {
            return this.f7827a;
        }
    }

    private d(String str) {
    }

    public /* synthetic */ d(String str, IIXOooo iIXOooo) {
        this(str);
    }
}
