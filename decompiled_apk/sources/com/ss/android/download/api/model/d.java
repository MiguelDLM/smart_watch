package com.ss.android.download.api.model;

/* loaded from: classes11.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private String f25934a;
    private String b;

    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f25935a;
        private String b;

        public a a(String str) {
            this.f25935a = str;
            return this;
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    public d(a aVar) {
        this.f25934a = aVar.f25935a;
        this.b = aVar.b;
    }

    public String a() {
        return this.f25934a;
    }
}
