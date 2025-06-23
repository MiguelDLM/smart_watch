package com.jd.ad.sdk.jad_kv;

import XXO0.oIX0oI;
import androidx.annotation.Nullable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.jd.ad.sdk.logger.Logger;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public final class jad_sf extends Exception {
    public static final StackTraceElement[] jad_fs = new StackTraceElement[0];
    public final List<Throwable> jad_an;
    public com.jd.ad.sdk.jad_hs.jad_hu jad_bo;
    public com.jd.ad.sdk.jad_hs.jad_an jad_cp;
    public Class<?> jad_dq;
    public String jad_er;

    /* loaded from: classes10.dex */
    public static final class jad_an implements Appendable {
        public final Appendable jad_an;
        public boolean jad_bo = true;

        public jad_an(Appendable appendable) {
            this.jad_an = appendable;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c) {
            if (this.jad_bo) {
                this.jad_bo = false;
                this.jad_an.append("  ");
            }
            this.jad_bo = c == '\n';
            this.jad_an.append(c);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence) {
            if (charSequence == null) {
                charSequence = "";
            }
            return append(charSequence, 0, charSequence.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence, int i, int i2) {
            if (charSequence == null) {
                charSequence = "";
            }
            boolean z = false;
            if (this.jad_bo) {
                this.jad_bo = false;
                this.jad_an.append("  ");
            }
            if (charSequence.length() > 0 && charSequence.charAt(i2 - 1) == '\n') {
                z = true;
            }
            this.jad_bo = z;
            this.jad_an.append(charSequence, i, i2);
            return this;
        }
    }

    public jad_sf(String str, List<Throwable> list) {
        this.jad_er = str;
        setStackTrace(jad_fs);
        this.jad_an = list;
    }

    public static void jad_an(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    public static void jad_bo(List<Throwable> list, Appendable appendable) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i);
            if (th instanceof jad_sf) {
                ((jad_sf) th).jad_an(appendable);
            } else {
                jad_an(th, appendable);
            }
            i = i2;
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str;
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.jad_er);
        String str4 = "";
        if (this.jad_dq == null) {
            str = "";
        } else {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an(", ");
            jad_an2.append(this.jad_dq);
            str = jad_an2.toString();
        }
        sb.append(str);
        if (this.jad_cp == null) {
            str2 = "";
        } else {
            StringBuilder jad_an3 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an(", ");
            jad_an3.append(this.jad_cp);
            str2 = jad_an3.toString();
        }
        sb.append(str2);
        if (this.jad_bo != null) {
            StringBuilder jad_an4 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an(", ");
            jad_an4.append(this.jad_bo);
            str4 = jad_an4.toString();
        }
        sb.append(str4);
        ArrayList arrayList = new ArrayList();
        jad_an(this, arrayList);
        if (arrayList.isEmpty()) {
            return sb.toString();
        }
        if (arrayList.size() == 1) {
            str3 = "\nThere was 1 root cause:";
        } else {
            sb.append("\nThere were ");
            sb.append(arrayList.size());
            str3 = " root causes:";
        }
        sb.append(str3);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Throwable th = (Throwable) it.next();
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append(HexStringBuilder.COMMENT_BEGIN_CHAR);
            sb.append(th.getMessage());
            sb.append(HexStringBuilder.COMMENT_END_CHAR);
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        jad_an(printStream);
    }

    public static void jad_an(List<Throwable> list, Appendable appendable) {
        try {
            jad_bo(list, appendable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        jad_an(printWriter);
    }

    public final void jad_an(Throwable th, List<Throwable> list) {
        if (!(th instanceof jad_sf)) {
            list.add(th);
            return;
        }
        Iterator<Throwable> it = ((jad_sf) th).jad_an.iterator();
        while (it.hasNext()) {
            jad_an(it.next(), list);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        jad_an(System.err);
    }

    public void jad_an(String str) {
        ArrayList arrayList = new ArrayList();
        jad_an(this, arrayList);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Root cause (");
            int i2 = i + 1;
            jad_an2.append(i2);
            jad_an2.append(" of ");
            jad_an2.append(size);
            jad_an2.append(oIX0oI.I0Io.f4095I0Io);
            Logger.i(str, jad_an2.toString(), arrayList.get(i));
            i = i2;
        }
    }

    public final void jad_an(Appendable appendable) {
        jad_an(this, appendable);
        jad_an(this.jad_an, new jad_an(appendable));
    }
}
