package com.jd.ad.sdk.jad_ir;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes10.dex */
public class jad_er implements com.jd.ad.sdk.jad_ir.jad_an {
    public final int jad_an;
    public final int jad_bo;
    public final boolean jad_cp;
    public final boolean jad_dq;

    @NonNull
    public final jad_cp jad_er;

    @Nullable
    public final String jad_fs;

    /* loaded from: classes10.dex */
    public static class jad_an {

        @Nullable
        public jad_cp jad_er;
        public int jad_an = 2;
        public int jad_bo = 0;
        public boolean jad_cp = true;
        public boolean jad_dq = true;

        @Nullable
        public String jad_fs = "PRETTY_LOGGER";

        @NonNull
        public jad_an jad_an(int i) {
            this.jad_an = i;
            return this;
        }

        @NonNull
        public jad_an jad_bo(int i) {
            this.jad_bo = i;
            return this;
        }

        @NonNull
        public jad_an jad_an(@Nullable String str) {
            this.jad_fs = str;
            return this;
        }

        @NonNull
        public jad_an jad_bo(boolean z) {
            this.jad_cp = z;
            return this;
        }

        @NonNull
        public jad_an jad_an(boolean z) {
            this.jad_dq = z;
            return this;
        }

        @NonNull
        public jad_er jad_an() {
            if (this.jad_er == null) {
                this.jad_er = new jad_cp();
            }
            return new jad_er(this);
        }
    }

    public jad_er(@NonNull jad_an jad_anVar) {
        jad_jt.jad_an(jad_anVar);
        this.jad_an = jad_anVar.jad_an;
        this.jad_bo = jad_anVar.jad_bo;
        this.jad_cp = jad_anVar.jad_cp;
        this.jad_dq = jad_anVar.jad_dq;
        this.jad_er = jad_anVar.jad_er;
        this.jad_fs = jad_anVar.jad_fs;
    }

    public final void jad_an(int i, @Nullable String str, @NonNull String str2) {
        str2.getClass();
        this.jad_er.getClass();
        if (str == null) {
            str = "NO_TAG";
        }
        Log.println(i, str, str2);
    }

    public final void jad_bo(int i, @Nullable String str, @NonNull String str2) {
        String str3;
        switch (i) {
            case 2:
                str3 = " ℹ️ ";
                break;
            case 3:
                str3 = " ⚒️ ";
                break;
            case 4:
                str3 = " ✅ ";
                break;
            case 5:
                str3 = " ⚠️ ";
                break;
            case 6:
                str3 = " ❌ ";
                break;
            case 7:
                str3 = " 🆘 ";
                break;
            default:
                str3 = " ";
                break;
        }
        if (this.jad_dq) {
            str3 = (char) 9474 + str3;
        }
        for (String str4 : str2.split(System.getProperty("line.separator"))) {
            jad_an(i, str, str3 + str4);
        }
    }

    @NonNull
    public static jad_an jad_an() {
        return new jad_an();
    }
}
