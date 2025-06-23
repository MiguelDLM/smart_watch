package com.kwad.sdk.api.loader;

import com.kwad.sdk.api.loader.a;
import java.util.Objects;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class k {
    public static int anM;

    /* loaded from: classes11.dex */
    public static class a {
        private int anN;
        private int anO;
        private String anP;
        private String anQ;
        private long anR;
        private int anS;
        private String anT;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a ah(long j) {
            this.anR = j;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bX(int i) {
            this.anN = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bY(int i) {
            this.anO = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bZ(int i) {
            this.anS = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cm(String str) {
            this.anP = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cn(String str) {
            this.anQ = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a co(String str) {
            this.anT = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("load_status", Integer.valueOf(this.anN));
                jSONObject.putOpt("update_count", Integer.valueOf(this.anO));
                jSONObject.putOpt("dynamic_version", this.anP);
                jSONObject.putOpt("download_url", this.anQ);
                jSONObject.putOpt("duration_ms", Long.valueOf(this.anR));
                jSONObject.putOpt("error_code", Integer.valueOf(this.anS));
                jSONObject.putOpt("error_msg", this.anT);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public final String toString() {
            return "MonitorInfo{load_status=" + this.anN + ", update_count=" + this.anO + ", dynamic_version='" + this.anP + "', download_url='" + this.anQ + "', duration_ms=" + this.anR + ", error_code=" + this.anS + ", error_msg='" + this.anT + "'}";
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static void a(a.C0838a c0838a) {
        anM++;
        a(1, c0838a, 0L, 0, "");
    }

    public static void b(a.C0838a c0838a) {
        a(5, c0838a, 0L, 0, "");
    }

    public static void b(a.C0838a c0838a, long j) {
        a(6, c0838a, j, 0, "");
    }

    public static void a(a.C0838a c0838a, long j) {
        a(2, c0838a, j, 0, "");
    }

    public static void b(a.C0838a c0838a, int i, String str) {
        a(7, c0838a, 0L, i, str);
    }

    public static void a(a.C0838a c0838a, long j, String str) {
        a(3, c0838a, j, 0, str);
    }

    public static void a(a.C0838a c0838a, int i, String str) {
        a(4, c0838a, 0L, i, str);
    }

    private static void a(int i, a.C0838a c0838a, long j, int i2, String str) {
        byte b = 0;
        if (c0838a == null) {
            return;
        }
        try {
            JSONObject json = new a(b).bX(i).bY(anM).cm(c0838a.sdkVersion).cn(c0838a.amZ).ah(j).bZ(i2).co(str).toJson();
            Objects.toString(json);
            com.kwad.sdk.api.c.f("reportDynamicUpdate", json);
        } catch (Throwable unused) {
        }
    }
}
