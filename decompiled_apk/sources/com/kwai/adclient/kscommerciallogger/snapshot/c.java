package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class c {
    private final String aVv;
    private final LinkedList<d> aVw;
    private int aVx;
    private final int aVy;
    private long aVz;

    public c(String str) {
        this(str, 10);
    }

    public final synchronized long Pd() {
        return this.aVz;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.aVv.equals(((c) obj).aVv);
        }
        return false;
    }

    public final String getName() {
        return this.aVv;
    }

    public int hashCode() {
        return Objects.hash(this.aVv);
    }

    public synchronized d hw(String str) {
        d dVar;
        try {
            if (this.aVw.size() >= this.aVy) {
                this.aVw.removeFirst();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_");
            int i = this.aVx;
            this.aVx = i + 1;
            sb.append(i);
            dVar = new d(sb.toString());
            this.aVw.addLast(dVar);
            this.aVz = System.currentTimeMillis();
        } catch (Throwable th) {
            throw th;
        }
        return dVar;
    }

    public synchronized JSONObject hx(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<d> it = this.aVw.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().Pc());
                }
                jSONObject.put("session_id", str);
                jSONObject.put("segment_name", this.aVv);
                jSONObject.put("spans", jSONArray);
                this.aVz = System.currentTimeMillis();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject;
    }

    public c(String str, int i) {
        this.aVv = str == null ? "" : str;
        this.aVw = new LinkedList<>();
        this.aVy = Math.min(i, 30);
        this.aVz = System.currentTimeMillis();
    }
}
