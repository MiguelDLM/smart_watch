package com.jd.ad.sdk.jad_ob;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.jd.ad.sdk.jad_sf.jad_an;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class jad_cp {
    public final jad_bo jad_an = new jad_bo();
    public SensorManager jad_bo;
    public JSONObject jad_cp;

    /* loaded from: classes10.dex */
    public class jad_bo implements SensorEventListener {
        public jad_bo() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 4) {
                try {
                    jad_cp.this.jad_cp.put("x", sensorEvent.values[0]);
                    jad_cp.this.jad_cp.put("y", sensorEvent.values[1]);
                    jad_cp.this.jad_cp.put("z", sensorEvent.values[2]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                jad_cp jad_cpVar = jad_cp.this;
                SensorManager sensorManager = jad_cpVar.jad_bo;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(jad_cpVar.jad_an);
                    jad_cpVar.jad_bo = null;
                }
                com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
                jad_anVar.jad_bo("obtainGyroSensorValue", jad_cp.this.jad_cp.toString());
                jad_anVar.jad_bo("lastRequestGyroTime", Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    /* renamed from: com.jd.ad.sdk.jad_ob.jad_cp$jad_cp, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0705jad_cp {
        public static final jad_cp jad_an = new jad_cp();
    }

    public jad_cp() {
        JSONObject jSONObject = new JSONObject();
        this.jad_cp = jSONObject;
        if (jSONObject.length() == 0) {
            try {
                this.jad_cp.put("x", 0);
                this.jad_cp.put("y", 0);
                this.jad_cp.put("z", 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
    
        if (r0 > 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject jad_an(android.content.Context r7) {
        /*
            r6 = this;
            com.jd.ad.sdk.jad_na.jad_cp r0 = com.jd.ad.sdk.jad_pc.jad_an.jad_cp()
            if (r0 == 0) goto Lf
            long r0 = r0.jad_er
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto Lf
            goto L11
        Lf:
            r0 = 1800(0x708, double:8.893E-321)
        L11:
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            com.jd.ad.sdk.jad_sf.jad_an r2 = com.jd.ad.sdk.jad_sf.jad_an.jad_bo.jad_an
            r2.getClass()
            java.lang.String r3 = "lastRequestGyroTime"
            java.lang.Object r2 = r2.jad_bo(r3)
            if (r2 == 0) goto L2d
            boolean r3 = r2 instanceof java.lang.Long
            if (r3 == 0) goto L2d
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            goto L2f
        L2d:
            r2 = -1
        L2f:
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            long r2 = java.lang.Math.abs(r4)
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 <= 0) goto L89
            if (r7 != 0) goto L3f
            goto L89
        L3f:
            r0 = 0
            java.lang.String r1 = "sensor"
            java.lang.Object r7 = r7.getSystemService(r1)     // Catch: java.lang.Exception -> L58 java.lang.SecurityException -> L5a
            android.hardware.SensorManager r7 = (android.hardware.SensorManager) r7     // Catch: java.lang.Exception -> L58 java.lang.SecurityException -> L5a
            r6.jad_bo = r7     // Catch: java.lang.Exception -> L58 java.lang.SecurityException -> L5a
            if (r7 == 0) goto L89
            com.jd.ad.sdk.jad_ob.jad_cp$jad_bo r1 = r6.jad_an     // Catch: java.lang.Exception -> L58 java.lang.SecurityException -> L5a
            r2 = 4
            android.hardware.Sensor r2 = r7.getDefaultSensor(r2)     // Catch: java.lang.Exception -> L58 java.lang.SecurityException -> L5a
            r3 = 3
            r7.registerListener(r1, r2, r3)     // Catch: java.lang.Exception -> L58 java.lang.SecurityException -> L5a
            goto L89
        L58:
            r7 = move-exception
            goto L5c
        L5a:
            r7 = move-exception
            goto L73
        L5c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Exception while register shake listener: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.jd.ad.sdk.logger.Logger.w(r7, r0)
            goto L89
        L73:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Exception while call system service: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.jd.ad.sdk.logger.Logger.w(r7, r0)
        L89:
            com.jd.ad.sdk.jad_sf.jad_an r7 = com.jd.ad.sdk.jad_sf.jad_an.jad_bo.jad_an
            java.lang.String r0 = "obtainGyroSensorValue"
            java.lang.Object r7 = r7.jad_bo(r0)
            java.lang.String r7 = (java.lang.String) r7
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto La8
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L9f
            r0.<init>(r7)     // Catch: org.json.JSONException -> L9f
            goto La4
        L9f:
            r7 = move-exception
            r7.printStackTrace()
            r0 = 0
        La4:
            if (r0 == 0) goto La8
            r6.jad_cp = r0
        La8:
            org.json.JSONObject r7 = r6.jad_cp
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_ob.jad_cp.jad_an(android.content.Context):org.json.JSONObject");
    }
}
