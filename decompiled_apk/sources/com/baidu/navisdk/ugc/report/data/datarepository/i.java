package com.baidu.navisdk.ugc.report.data.datarepository;

import com.baidu.mobads.sdk.internal.bn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private boolean f8259a;
    private ArrayList<c> b;

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final i f8260a = new i();
    }

    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private int f8261a;
        private String[] b;

        public String toString() {
            return "UgcSugDefaultPromptData{type=" + this.f8261a + ", tags=" + Arrays.toString(this.b) + '}';
        }

        public boolean b() {
            String[] strArr = this.b;
            return strArr == null || strArr.length <= 0;
        }

        public String[] a() {
            return this.b;
        }
    }

    public static i c() {
        return b.f8260a;
    }

    public String[] a(int i) {
        ArrayList<c> arrayList = this.b;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<c> it = this.b.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && !next.b() && i == next.f8261a) {
                    return next.a();
                }
            }
        }
        return null;
    }

    public boolean b() {
        return this.f8259a;
    }

    public String toString() {
        return "UgcSugDefaultPromptRepository{isOpenDefaultPrompt=" + this.f8259a + ", mDefaultPromptDataList=" + this.b + '}';
    }

    private i() {
        this.f8259a = false;
    }

    public boolean a() {
        ArrayList<c> arrayList = this.b;
        return arrayList == null || arrayList.isEmpty();
    }

    public boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            this.f8259a = jSONObject.optInt("is_open", 0) == 1;
            JSONArray jSONArray = jSONObject.getJSONArray("sugs");
            if (jSONArray != null) {
                int length = jSONArray.length();
                if (this.b == null) {
                    this.b = new ArrayList<>(length);
                }
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        c cVar = new c();
                        cVar.f8261a = jSONObject2.optInt("type", -1);
                        JSONArray jSONArray2 = jSONObject2.getJSONArray(bn.l);
                        int length2 = jSONArray2.length();
                        cVar.b = new String[length2];
                        for (int i2 = 0; i2 < length2; i2++) {
                            cVar.b[i2] = jSONArray2.getString(i2);
                        }
                        this.b.add(cVar);
                    }
                }
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
                if (gVar.d() && this.b != null) {
                    gVar.e("UgcModule_SugUgcSugDefaultPromptRepo", toString());
                }
            }
            return true;
        } catch (Exception e) {
            if (com.baidu.navisdk.util.common.g.UGC.d()) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
