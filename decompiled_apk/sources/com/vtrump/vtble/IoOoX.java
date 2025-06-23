package com.vtrump.vtble;

import android.util.Log;
import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class IoOoX extends VTDevice {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @NonNull
    public oIX0oI f27257oI0IIXIo;

    /* loaded from: classes13.dex */
    public static abstract class oIX0oI {
        public abstract void oIX0oI(String str);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void OI0(byte[] r14) {
        /*
            r13 = this;
            java.lang.String r0 = "success"
            java.lang.String r1 = "data"
            java.lang.String r2 = "code"
            java.lang.String r3 = "msg"
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: org.json.JSONException -> L4d
            r4.<init>()     // Catch: org.json.JSONException -> L4d
            r5 = 0
            r4.put(r2, r5)     // Catch: org.json.JSONException -> L4d
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: org.json.JSONException -> L4d
            r6.<init>()     // Catch: org.json.JSONException -> L4d
            r4.put(r1, r6)     // Catch: org.json.JSONException -> L4d
            r4.put(r3, r0)     // Catch: org.json.JSONException -> L4d
            r7 = r14[r5]     // Catch: org.json.JSONException -> L4d
            r8 = 238(0xee, float:3.34E-43)
            r9 = 2
            r10 = 1
            switch(r7) {
                case -127: goto L99;
                case -126: goto L92;
                case -125: goto L28;
                default: goto L26;
            }     // Catch: org.json.JSONException -> L4d
        L26:
            goto Lcd
        L28:
            r4.put(r2, r5)     // Catch: org.json.JSONException -> L4d
            r4.put(r3, r0)     // Catch: org.json.JSONException -> L4d
            org.json.JSONObject r0 = r13.o0()     // Catch: org.json.JSONException -> L4d
            r2 = 4
            r3 = r14[r2]     // Catch: org.json.JSONException -> L4d
            java.lang.String r5 = "isHeartRate"
            r6 = 7
            if (r3 == r10) goto L51
            java.lang.String r7 = "isBloodPressure"
            if (r3 == r9) goto L50
            java.lang.String r8 = "isBloodOxygen"
            if (r3 == r2) goto L4b
            if (r3 == r6) goto L45
            goto L54
        L45:
            r0.put(r5, r10)     // Catch: org.json.JSONException -> L4d
            r0.put(r7, r10)     // Catch: org.json.JSONException -> L4d
        L4b:
            r5 = r8
            goto L51
        L4d:
            r14 = move-exception
            goto Ld7
        L50:
            r5 = r7
        L51:
            r0.put(r5, r10)     // Catch: org.json.JSONException -> L4d
        L54:
            r2 = 5
            r2 = r14[r2]     // Catch: org.json.JSONException -> L4d
            if (r2 != r10) goto L5e
            java.lang.String r2 = "isOTA"
            r0.put(r2, r10)     // Catch: org.json.JSONException -> L4d
        L5e:
            r2 = 6
            r2 = r14[r2]     // Catch: org.json.JSONException -> L4d
            if (r2 != r10) goto L68
            java.lang.String r2 = "isWeather"
            r0.put(r2, r10)     // Catch: org.json.JSONException -> L4d
        L68:
            java.lang.String r2 = "alarmCount"
            r3 = r14[r6]     // Catch: org.json.JSONException -> L4d
            r0.put(r2, r3)     // Catch: org.json.JSONException -> L4d
            r2 = 8
            r2 = r14[r2]     // Catch: org.json.JSONException -> L4d
            if (r2 != r10) goto L7a
            java.lang.String r2 = "isRemider"
            r0.put(r2, r10)     // Catch: org.json.JSONException -> L4d
        L7a:
            r2 = 9
            r3 = r14[r2]     // Catch: org.json.JSONException -> L4d
            if (r3 != r10) goto L85
            java.lang.String r3 = "isStep"
            r0.put(r3, r10)     // Catch: org.json.JSONException -> L4d
        L85:
            r14 = r14[r2]     // Catch: org.json.JSONException -> L4d
            if (r14 != r9) goto L8e
            java.lang.String r14 = "isSleep"
            r0.put(r14, r10)     // Catch: org.json.JSONException -> L4d
        L8e:
            r4.put(r1, r0)     // Catch: org.json.JSONException -> L4d
            goto Lcd
        L92:
            r14 = r14[r9]     // Catch: org.json.JSONException -> L4d
            if (r14 != r8) goto Lcd
            java.lang.String r0 = "param error"
            goto Lca
        L99:
            r14 = r14[r10]     // Catch: org.json.JSONException -> L4d
            java.lang.String r7 = "respStatus"
            r9 = 129(0x81, float:1.81E-43)
            java.lang.String r11 = "respCode"
            java.lang.String r12 = "opCode"
            if (r14 != 0) goto Lb7
            r4.put(r2, r5)     // Catch: org.json.JSONException -> L4d
            r6.put(r12, r10)     // Catch: org.json.JSONException -> L4d
            r6.put(r11, r9)     // Catch: org.json.JSONException -> L4d
            r6.put(r7, r5)     // Catch: org.json.JSONException -> L4d
            r4.put(r1, r6)     // Catch: org.json.JSONException -> L4d
            goto Lca
        Lb7:
            r14 = 2001(0x7d1, float:2.804E-42)
            r4.put(r2, r14)     // Catch: org.json.JSONException -> L4d
            r6.put(r12, r10)     // Catch: org.json.JSONException -> L4d
            r6.put(r11, r9)     // Catch: org.json.JSONException -> L4d
            r6.put(r7, r8)     // Catch: org.json.JSONException -> L4d
            r4.put(r1, r6)     // Catch: org.json.JSONException -> L4d
            java.lang.String r0 = "failue"
        Lca:
            r4.put(r3, r0)     // Catch: org.json.JSONException -> L4d
        Lcd:
            com.vtrump.vtble.IoOoX$oIX0oI r14 = r13.f27257oI0IIXIo     // Catch: org.json.JSONException -> L4d
            java.lang.String r0 = r4.toString()     // Catch: org.json.JSONException -> L4d
            r14.oIX0oI(r0)     // Catch: org.json.JSONException -> L4d
            goto Lda
        Ld7:
            r14.printStackTrace()
        Lda:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vtrump.vtble.IoOoX.OI0(byte[]):void");
    }

    public void Io() {
        X0o0xo(IXxxXO.f27210oI0IIXIo, IXxxXO.f27182OxxIIOOXO, true);
    }

    public final JSONObject o0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isHeartRate", false);
            jSONObject.put("isBloodPressure", false);
            jSONObject.put("isBloodOxygen", false);
            jSONObject.put("isOTA", false);
            jSONObject.put("isWeather", false);
            jSONObject.put("isRemider", false);
            jSONObject.put("isStep", false);
            jSONObject.put("isSleep", false);
            jSONObject.put("alarmCount", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.vtrump.vtble.VTDevice
    public void oOoXoXO(String str, String str2, byte[] bArr) {
        super.oOoXoXO(str, str2, bArr);
        Log.d("play_boy", "Dev-->Phone: " + xxX.IIXOooo(bArr));
        OI0(bArr);
    }
}
