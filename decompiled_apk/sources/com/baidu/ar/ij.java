package com.baidu.ar;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class ij implements Cloneable {
    private static volatile boolean tz = false;
    private static final Object yK = new Object();
    private static ij yL;
    private static int yM;
    private ij yJ = null;
    private JSONObject yI = new JSONObject();

    private ij(String str) {
        bA(str);
        setTimestamp(System.currentTimeMillis());
    }

    public static String b(ij ijVar) {
        JSONObject jSONObject;
        if (ijVar == null || (jSONObject = ijVar.yI) == null) {
            return null;
        }
        return jSONObject.toString();
    }

    public static ij bG(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str.trim());
                ij bz = bz(jSONObject.getString("event_id"));
                bz.yI = jSONObject;
                return bz;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static ij bz(String str) {
        if (!tz) {
            synchronized (yK) {
                try {
                    ij ijVar = yL;
                    if (ijVar != null) {
                        yL = ijVar.yJ;
                        ijVar.yJ = null;
                        yM--;
                        if (ijVar.yI == null) {
                            ijVar.yI = new JSONObject();
                        }
                        ijVar.bA(str);
                        ijVar.setTimestamp(System.currentTimeMillis());
                        return ijVar;
                    }
                } finally {
                }
            }
        }
        return new ij(str);
    }

    private void fR() {
        this.yI = null;
        int i = yM;
        if (i < 500) {
            this.yJ = yL;
            yL = this;
            yM = i + 1;
        }
    }

    public static void release() {
        if (tz) {
            return;
        }
        synchronized (yK) {
            tz = true;
            yL = null;
            yM = 0;
        }
    }

    public JSONObject a(Collection<String> collection) {
        return a((JSONObject) null, collection);
    }

    public void bA(String str) {
        try {
            this.yI.putOpt("event_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String bB(String str) {
        return this.yI.optString(str);
    }

    public Object bC(String str) {
        return this.yI.opt(str);
    }

    public long bD(String str) {
        Object bC = bC(str);
        if (bC instanceof Number) {
            return ((Number) bC).longValue();
        }
        return 0L;
    }

    public boolean bE(String str) {
        return this.yI.has(str);
    }

    public void bF(String str) {
        this.yI.remove(str);
    }

    public void c(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.yI.putOpt(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONObject cZ() {
        return a((JSONObject) null, (Collection<String>) null);
    }

    public String fS() {
        return this.yI.optString("event_id");
    }

    public String fT() {
        String b = b(this);
        if (b == null) {
            return null;
        }
        return kp.co(b);
    }

    /* renamed from: fU, reason: merged with bridge method [inline-methods] */
    public ij clone() {
        ij bz = bz("");
        try {
            bz.yI = new JSONObject(this.yI.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bz;
    }

    public long getTimestamp() {
        return this.yI.optLong("time");
    }

    public Iterator<String> keys() {
        return this.yI.keys();
    }

    public void setTimestamp(long j) {
        try {
            this.yI.putOpt("time", Long.valueOf(j));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONObject a(JSONObject jSONObject, Collection<String> collection) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            Iterator<String> keys = this.yI.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (collection != null && collection.contains(next)) {
                }
                jSONObject.put(next, this.yI.get(next));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static void a(ij ijVar) {
        if (tz) {
            return;
        }
        synchronized (yK) {
            ijVar.fR();
        }
    }

    public void a(String str, Object obj) {
        try {
            this.yI.putOpt(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void a(ij... ijVarArr) {
        if (tz) {
            return;
        }
        synchronized (yK) {
            if (ijVarArr != null) {
                try {
                    for (ij ijVar : ijVarArr) {
                        ijVar.fR();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
