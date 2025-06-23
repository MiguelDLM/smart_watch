package com.baidu.ar;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class dr {

    /* loaded from: classes7.dex */
    public static class a {
        private String pG;
        private boolean pH;
        private String type;

        public static a f(JSONObject jSONObject) {
            a aVar = null;
            if (jSONObject == null) {
                return null;
            }
            try {
                a aVar2 = new a();
                try {
                    if (jSONObject.has("content")) {
                        aVar2.aj(jSONObject.getString("content"));
                    }
                    if (jSONObject.has("completed")) {
                        aVar2.v(jSONObject.getBoolean("completed"));
                    }
                    if (jSONObject.has("type")) {
                        aVar2.setType(jSONObject.getString("type"));
                    }
                    return aVar2;
                } catch (Exception e) {
                    e = e;
                    aVar = aVar2;
                    e.printStackTrace();
                    return aVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }

        public void aj(String str) {
            this.pG = str;
        }

        public String getContent() {
            return this.pG;
        }

        public String getType() {
            return this.type;
        }

        public boolean isCompleted() {
            return this.pH;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void v(boolean z) {
            this.pH = z;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        private String id;
        private boolean pI;
        private boolean pJ;
        private int pK;
        private c pL;

        /* loaded from: classes7.dex */
        public static class a {
            private String pM;
            private HashMap<String, Double> pN;

            public static a h(JSONObject jSONObject) {
                a aVar;
                a aVar2 = null;
                if (jSONObject == null) {
                    return null;
                }
                try {
                    aVar = new a();
                } catch (Exception e) {
                    e = e;
                }
                try {
                    if (jSONObject.has(MimeTypes.BASE_TYPE_AUDIO)) {
                        aVar.ak(jSONObject.getString(MimeTypes.BASE_TYPE_AUDIO));
                    }
                    if (jSONObject.has("values")) {
                        HashMap<String, Double> hashMap = new HashMap<>();
                        JSONObject jSONObject2 = jSONObject.getJSONObject("values");
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, Double.valueOf(jSONObject2.getDouble(next)));
                        }
                        aVar.h(hashMap);
                    }
                    return aVar;
                } catch (Exception e2) {
                    e = e2;
                    aVar2 = aVar;
                    e.printStackTrace();
                    return aVar2;
                }
            }

            public void ak(String str) {
                this.pM = str;
            }

            public String de() {
                return this.pM;
            }

            public HashMap<String, Double> df() {
                return this.pN;
            }

            public void h(HashMap<String, Double> hashMap) {
                this.pN = hashMap;
            }
        }

        /* renamed from: com.baidu.ar.dr$b$b, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0119b {
            private a pO;

            public static C0119b i(JSONObject jSONObject) {
                C0119b c0119b = null;
                if (jSONObject == null) {
                    return null;
                }
                try {
                    C0119b c0119b2 = new C0119b();
                    try {
                        if (jSONObject.has("agent")) {
                            c0119b2.a(a.h(jSONObject.getJSONObject("agent")));
                        }
                        return c0119b2;
                    } catch (Exception e) {
                        e = e;
                        c0119b = c0119b2;
                        e.printStackTrace();
                        return c0119b;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }

            public void a(a aVar) {
                this.pO = aVar;
            }

            public a dg() {
                return this.pO;
            }
        }

        /* loaded from: classes7.dex */
        public static class c {
            private C0119b pP;

            public static c j(JSONObject jSONObject) {
                c cVar = null;
                if (jSONObject == null) {
                    return null;
                }
                try {
                    c cVar2 = new c();
                    try {
                        if (jSONObject.has("animation")) {
                            cVar2.a(C0119b.i(jSONObject.getJSONObject("animation")));
                        }
                        return cVar2;
                    } catch (Exception e) {
                        e = e;
                        cVar = cVar2;
                        e.printStackTrace();
                        return cVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }

            public void a(C0119b c0119b) {
                this.pP = c0119b;
            }

            public C0119b dh() {
                return this.pP;
            }
        }

        public static b g(JSONObject jSONObject) {
            b bVar = null;
            if (jSONObject == null) {
                return null;
            }
            try {
                b bVar2 = new b();
                try {
                    if (jSONObject.has("id")) {
                        bVar2.setId(jSONObject.getString("id"));
                    }
                    if (jSONObject.has("initial")) {
                        bVar2.w(jSONObject.getBoolean("initial"));
                    }
                    if (jSONObject.has("last")) {
                        bVar2.x(jSONObject.getBoolean("last"));
                    }
                    if (jSONObject.has("frame_size")) {
                        bVar2.setFrameSize(jSONObject.getInt("frame_size"));
                    }
                    if (jSONObject.has(TypedValues.AttributesType.S_FRAME)) {
                        bVar2.a(c.j(jSONObject.getJSONObject(TypedValues.AttributesType.S_FRAME)));
                    }
                    return bVar2;
                } catch (Exception e) {
                    e = e;
                    bVar = bVar2;
                    e.printStackTrace();
                    return bVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }

        public void a(c cVar) {
            this.pL = cVar;
        }

        public boolean dc() {
            return this.pI;
        }

        public c dd() {
            return this.pL;
        }

        public int getFrameSize() {
            return this.pK;
        }

        public boolean isLast() {
            return this.pJ;
        }

        public void setFrameSize(int i) {
            this.pK = i;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void w(boolean z) {
            this.pI = z;
        }

        public void x(boolean z) {
            this.pJ = z;
        }
    }
}
