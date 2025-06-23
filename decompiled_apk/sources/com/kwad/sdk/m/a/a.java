package com.kwad.sdk.m.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@KsJson
/* loaded from: classes11.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public static final String TAG = "Ranger_" + a.class.getSimpleName();
    public String aOA;
    public String aOB;
    public boolean aOC;

    @NonNull
    public String aOD;
    public b aOE;
    public a aOF;
    public Object aOz;

    @KsJson
    /* renamed from: com.kwad.sdk.m.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0870a extends com.kwad.sdk.core.response.a.a {
        public String aOG;
        public String aOH;
        public String aOI;
        public List<String> aOJ;
        public List<C0870a> aOK = new ArrayList();
        public Object aOL;
        public List<Object> aOM;
        public String className;
        public String fieldName;

        private Object Lo() {
            Object obj = null;
            try {
            } catch (Exception e) {
                c.d(a.TAG, Log.getStackTraceString(e));
            }
            if (TextUtils.isEmpty(this.className)) {
                c.w(a.TAG, "SpecialParam className is null");
                return null;
            }
            obj = s.gF(this.className);
            c.d(a.TAG, "Class.forName(className):" + this.className + " value:" + obj);
            List<C0870a> list = this.aOK;
            if (list != null && !list.isEmpty()) {
                for (C0870a c0870a : this.aOK) {
                    c0870a.aOL = obj;
                    c.d(a.TAG, "param.ob:" + c0870a.aOL);
                    try {
                        s.a(c0870a.aOL, c0870a.fieldName, c0870a.getValue());
                    } catch (Exception e2) {
                        c.d(a.TAG, Log.getStackTraceString(e2));
                    }
                }
            }
            c.d(a.TAG, "return value in special:" + obj);
            return obj;
        }

        private Object Lp() {
            if (TextUtils.isEmpty(this.aOI)) {
                return an(this.aOG, this.aOH);
            }
            this.aOM = new ArrayList();
            Iterator<String> it = this.aOJ.iterator();
            while (it.hasNext()) {
                Object an = an(this.aOI, it.next());
                if (an != null) {
                    this.aOM.add(an);
                }
            }
            return this.aOM;
        }

        private static Object an(String str, String str2) {
            Object obj = null;
            try {
                Class<?> cls = Class.forName(str);
                if (cls == Integer.class) {
                    obj = Integer.valueOf(Integer.parseInt(str2));
                } else if (cls == Long.class) {
                    obj = Long.valueOf(Long.parseLong(str2));
                } else if (cls == Float.class) {
                    obj = Float.valueOf(Float.parseFloat(str2));
                } else if (cls == Boolean.class) {
                    obj = Boolean.valueOf(Boolean.parseBoolean(str2));
                } else if (cls == Double.class) {
                    obj = Double.valueOf(Double.parseDouble(str2));
                } else {
                    if (cls != String.class) {
                        str2 = null;
                    }
                    obj = str2;
                }
            } catch (Exception e) {
                c.w(a.TAG, Log.getStackTraceString(e));
            }
            return obj;
        }

        public final Object getValue() {
            if (TextUtils.isEmpty(this.aOG) && TextUtils.isEmpty(this.aOI)) {
                return Lo();
            }
            return Lp();
        }
    }

    @KsJson
    /* loaded from: classes11.dex */
    public static class b extends com.kwad.sdk.core.response.a.a {
        public boolean aON;
        public List<C0870a> aOO;
        public Object[] aOP;
        public String name;

        public final boolean Ln() {
            if (TextUtils.isEmpty(this.name)) {
                List<C0870a> list = this.aOO;
                if ((list == null || list.isEmpty()) && this.aOP == null) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public final Object[] Lq() {
            List<C0870a> list = this.aOO;
            if (list != null && !list.isEmpty()) {
                Object[] objArr = new Object[this.aOO.size()];
                for (int i = 0; i < this.aOO.size(); i++) {
                    objArr[i] = this.aOO.get(i).getValue();
                }
                return objArr;
            }
            return null;
        }
    }

    public final boolean Ln() {
        if (this.aOz == null && TextUtils.isEmpty(this.aOA) && TextUtils.isEmpty(this.aOB) && TextUtils.isEmpty(this.aOD)) {
            b bVar = this.aOE;
            if (bVar == null || bVar.Ln()) {
                a aVar = this.aOF;
                if (aVar == null || aVar.Ln()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
