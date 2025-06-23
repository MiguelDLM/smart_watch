package com.jd.ad.sdk.jad_ir;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class jad_dq implements jad_fs {
    public final ThreadLocal<String> jad_an = new ThreadLocal<>();
    public final CopyOnWriteArrayList<jad_bo> jad_bo = new CopyOnWriteArrayList<>();

    @Override // com.jd.ad.sdk.jad_ir.jad_fs
    public jad_fs jad_an(String str) {
        if (str != null) {
            this.jad_an.set(str);
        }
        return this;
    }

    @Override // com.jd.ad.sdk.jad_ir.jad_fs
    public void jad_bo(@Nullable String str) {
        if (jad_jt.jad_an((CharSequence) str)) {
            jad_an("Empty/Null json content");
            return;
        }
        try {
            String trim = str.trim();
            if (trim.startsWith("{")) {
                jad_an((Object) new JSONObject(trim).toString(2));
            } else if (trim.startsWith("[")) {
                jad_an((Object) new JSONArray(trim).toString(2));
            } else {
                jad_an(6, (Throwable) null, "Invalid Json", new Object[0]);
            }
        } catch (JSONException unused) {
            jad_an(6, (Throwable) null, "Invalid Json", new Object[0]);
        }
    }

    @Override // com.jd.ad.sdk.jad_ir.jad_fs
    public void jad_cp(@NonNull String str, @Nullable Object... objArr) {
        jad_an(2, (Throwable) null, str, objArr);
    }

    @Override // com.jd.ad.sdk.jad_ir.jad_fs
    public void jad_dq(@NonNull String str, @Nullable Object... objArr) {
        jad_an(5, (Throwable) null, str, objArr);
    }

    @Override // com.jd.ad.sdk.jad_ir.jad_fs
    public void jad_er(@NonNull String str, @Nullable Object... objArr) {
        jad_an(3, (Throwable) null, str, objArr);
    }

    @Override // com.jd.ad.sdk.jad_ir.jad_fs
    public void jad_an() {
        this.jad_bo.clear();
    }

    @Override // com.jd.ad.sdk.jad_ir.jad_fs
    public void jad_cp(@Nullable String str) {
        if (jad_jt.jad_an((CharSequence) str)) {
            jad_an("Empty/Null xml content");
            return;
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.transform(streamSource, streamResult);
            jad_an((Object) streamResult.getWriter().toString().replaceFirst(">", ">\n"));
        } catch (TransformerException unused) {
            jad_an(6, (Throwable) null, "Invalid xml", new Object[0]);
        }
    }

    @Override // com.jd.ad.sdk.jad_ir.jad_fs
    public synchronized void jad_an(int i, @Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        if (th != null && str2 != null) {
            try {
                str2 = str2 + " : " + jad_jt.jad_an(th);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (th != null && str2 == null) {
            str2 = jad_jt.jad_an(th);
        }
        if (jad_jt.jad_an((CharSequence) str2)) {
            str2 = "Empty/NULL log message";
        }
        Iterator<jad_bo> it = this.jad_bo.iterator();
        while (it.hasNext()) {
            jad_bo next = it.next();
            if (next != null && next.isLoggable(i, str)) {
                next.log(i, str, str2);
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_ir.jad_fs
    public void jad_an(@NonNull String str, @Nullable Object... objArr) {
        jad_an(7, (Throwable) null, str, objArr);
    }

    @Override // com.jd.ad.sdk.jad_ir.jad_fs
    public void jad_an(@Nullable Throwable th, @NonNull String str, @Nullable Object... objArr) {
        jad_an(6, th, str, objArr);
    }

    @Override // com.jd.ad.sdk.jad_ir.jad_fs
    public void jad_bo(@NonNull String str, @Nullable Object... objArr) {
        jad_an(4, (Throwable) null, str, objArr);
    }

    @Override // com.jd.ad.sdk.jad_ir.jad_fs
    public void jad_an(@NonNull jad_bo jad_boVar) {
        this.jad_bo.add(jad_boVar);
    }

    @Override // com.jd.ad.sdk.jad_ir.jad_fs
    public void jad_an(@Nullable Object obj) {
        String obj2;
        if (obj == null) {
            obj2 = "null";
        } else {
            obj2 = !obj.getClass().isArray() ? obj.toString() : obj instanceof boolean[] ? Arrays.toString((boolean[]) obj) : obj instanceof byte[] ? Arrays.toString((byte[]) obj) : obj instanceof char[] ? Arrays.toString((char[]) obj) : obj instanceof short[] ? Arrays.toString((short[]) obj) : obj instanceof int[] ? Arrays.toString((int[]) obj) : obj instanceof long[] ? Arrays.toString((long[]) obj) : obj instanceof float[] ? Arrays.toString((float[]) obj) : obj instanceof double[] ? Arrays.toString((double[]) obj) : obj instanceof Object[] ? Arrays.deepToString((Object[]) obj) : "Couldn't find a correct type for the object";
        }
        jad_an(3, (Throwable) null, obj2, new Object[0]);
    }

    public final synchronized void jad_an(int i, @Nullable Throwable th, @NonNull String str, @Nullable Object... objArr) {
        try {
            str.getClass();
            String str2 = this.jad_an.get();
            if (str2 != null) {
                this.jad_an.remove();
            } else {
                str2 = null;
            }
            if (objArr != null && objArr.length != 0) {
                str = String.format(str, objArr);
            }
            jad_an(i, str2, str, th);
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
