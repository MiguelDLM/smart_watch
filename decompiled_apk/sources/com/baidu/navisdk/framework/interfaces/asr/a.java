package com.baidu.navisdk.framework.interfaces.asr;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6809a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public boolean g;
    public boolean h;
    public String i;
    public boolean j;

    /* renamed from: com.baidu.navisdk.framework.interfaces.asr.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0199a {

        /* renamed from: a, reason: collision with root package name */
        private a f6810a = new a();

        public C0199a a(String str) {
            this.f6810a.d = str;
            return this;
        }

        public C0199a b(String str) {
            this.f6810a.e = str;
            return this;
        }

        public C0199a c(boolean z) {
            this.f6810a.f = z;
            return this;
        }

        public C0199a d(boolean z) {
            this.f6810a.j = z;
            return this;
        }

        public C0199a e(boolean z) {
            this.f6810a.f6809a = z;
            return this;
        }

        public C0199a a(boolean z) {
            this.f6810a.h = z;
            return this;
        }

        public C0199a b(boolean z) {
            this.f6810a.g = z;
            return this;
        }

        public a a() {
            return this.f6810a;
        }
    }

    public String toString() {
        return "VoiceIntentResponse{success=" + this.f6809a + ", errorMsg='" + this.b + "', displayString='" + this.c + "', ttsString='" + this.d + "', uploadInfo='" + this.e + "', needVoiceInput=" + this.f + ", needSecond=" + this.g + ", isSceneAid=" + this.h + ", speechId=" + this.i + ", serverResponse=" + this.j + '}';
    }
}
