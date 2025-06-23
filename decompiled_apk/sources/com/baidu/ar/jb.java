package com.baidu.ar;

import XIXIX.OOXIXo;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class jb {
    public String zG;
    public double zH;
    public long zI;
    public long zJ;
    public long zK;
    public BlockingQueue<a> zL = new LinkedBlockingQueue();

    /* loaded from: classes7.dex */
    public static class a {
        public int zM;
        public long zN;
        public long zO;
        public BlockingQueue<C0121a> zP = new LinkedBlockingQueue();

        /* renamed from: com.baidu.ar.jb$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0121a {
            public int count;
            public String name;
            public String zQ;
            public long zR;
        }
    }

    public JSONObject gf() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("case_id", this.zG);
            jSONObject.put("cpu_rate", String.valueOf(this.zH));
            jSONObject.put("cpu_tc", String.valueOf(this.zI));
            jSONObject.put("mem_total", String.valueOf(this.zJ));
            jSONObject.put("mem_used", String.valueOf(this.zK));
            JSONArray jSONArray = new JSONArray();
            for (a aVar : this.zL) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("frame_index", aVar.zM);
                    jSONObject2.put("frame_in", aVar.zN);
                    jSONObject2.put("frame_out", aVar.zO);
                    JSONArray jSONArray2 = new JSONArray();
                    for (a.C0121a c0121a : aVar.zP) {
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("name", c0121a.name);
                            jSONObject3.put("func", c0121a.zQ);
                            jSONObject3.put("time_cost", c0121a.zR);
                            jSONObject3.put("count", c0121a.count);
                            jSONArray2.put(jSONObject3);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    jSONObject2.put("algo_data", jSONArray2);
                    jSONArray.put(jSONObject2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            jSONObject.put("frame_data", jSONArray);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject;
    }

    public void gg() {
        this.zG = null;
        this.zH = OOXIXo.f3760XO;
        this.zI = 0L;
        this.zJ = 0L;
        this.zK = 0L;
        this.zL = new LinkedBlockingQueue();
    }
}
