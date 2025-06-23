package com.jd.ad.sdk.jad_vi;

import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.jad_vi.jad_iv;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class jad_fs {
    public static void jad_an(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, int i9, int i10, int i11) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "tp", 1);
        JsonUtils.put(jSONObject, "adrid", str);
        JsonUtils.put(jSONObject, "pid", str2);
        JsonUtils.put(jSONObject, "pfid", Integer.valueOf(i));
        JsonUtils.put(jSONObject, "adt", Integer.valueOf(i2));
        JsonUtils.put(jSONObject, "sen", Integer.valueOf(i3));
        JsonUtils.put(jSONObject, "plwd", Integer.valueOf(i5));
        JsonUtils.put(jSONObject, "plht", Integer.valueOf(i4));
        JsonUtils.put(jSONObject, "tpid", Integer.valueOf(i6));
        JsonUtils.put(jSONObject, "rem", Integer.valueOf(i7));
        JsonUtils.put(jSONObject, "tcbr", Long.valueOf(j));
        JsonUtils.put(jSONObject, "dstp", Integer.valueOf(i8));
        JsonUtils.put(jSONObject, "srtp", Integer.valueOf(i9));
        JsonUtils.put(jSONObject, "ipl", Integer.valueOf(i10));
        JsonUtils.put(jSONObject, "toti", Integer.valueOf(i11));
        jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    public static void jad_an(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, int i6, long j2, int i7, int i8, int i9, int i10, int i11, int i12) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "tp", 2);
        JsonUtils.put(jSONObject, "adrid", str);
        JsonUtils.put(jSONObject, "pid", str2);
        JsonUtils.put(jSONObject, "pfid", Integer.valueOf(i));
        JsonUtils.put(jSONObject, "adt", Integer.valueOf(i2));
        JsonUtils.put(jSONObject, "tpid", Integer.valueOf(i3));
        JsonUtils.put(jSONObject, "sen", Integer.valueOf(i4));
        JsonUtils.put(jSONObject, "rem", Integer.valueOf(i5));
        JsonUtils.put(jSONObject, "sddu", Long.valueOf(j));
        JsonUtils.put(jSONObject, "alct", Integer.valueOf(i6));
        JsonUtils.put(jSONObject, "alct", Integer.valueOf(i6));
        JsonUtils.put(jSONObject, "jdad", Long.valueOf(j2));
        JsonUtils.put(jSONObject, "adat", Integer.valueOf(i7));
        JsonUtils.put(jSONObject, "catp", Integer.valueOf(i8));
        JsonUtils.put(jSONObject, "msst", Integer.valueOf(i9));
        JsonUtils.put(jSONObject, "dstp", Integer.valueOf(i10));
        JsonUtils.put(jSONObject, "srtp", Integer.valueOf(i11));
        JsonUtils.put(jSONObject, "ipl", Integer.valueOf(i12));
        jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    public static void jad_an(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, long j, long j2, int i7, int i8, int i9, int i10, JSONObject jSONObject, int i11, int i12, int i13) {
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.put(jSONObject2, "tp", 3);
        JsonUtils.put(jSONObject2, "adrid", str);
        JsonUtils.put(jSONObject2, "pid", str2);
        JsonUtils.put(jSONObject2, "pfid", Integer.valueOf(i));
        JsonUtils.put(jSONObject2, "adt", Integer.valueOf(i2));
        JsonUtils.put(jSONObject2, "exid", UUIDUtils.uuid());
        JsonUtils.put(jSONObject2, "tpid", Integer.valueOf(i3));
        JsonUtils.put(jSONObject2, "sen", Integer.valueOf(i4));
        JsonUtils.put(jSONObject2, "rem", Integer.valueOf(i5));
        JsonUtils.put(jSONObject2, "imm", Integer.valueOf(i6));
        JsonUtils.put(jSONObject2, "sedu", Long.valueOf(j));
        JsonUtils.put(jSONObject2, "dedu", Long.valueOf(j2));
        JsonUtils.put(jSONObject2, "sspt", Integer.valueOf(i7));
        JsonUtils.put(jSONObject2, "scav", Integer.valueOf(i8));
        JsonUtils.put(jSONObject2, "adat", Integer.valueOf(i9));
        JsonUtils.put(jSONObject2, "catp", Integer.valueOf(i10));
        JsonUtils.put(jSONObject2, "cons", jSONObject);
        JsonUtils.put(jSONObject2, "dstp", Integer.valueOf(i11));
        JsonUtils.put(jSONObject2, "srtp", Integer.valueOf(i12));
        JsonUtils.put(jSONObject2, "ipl", Integer.valueOf(i13));
        jad_iv.jad_cp.jad_an.jad_bo(jSONObject2);
    }

    public static void jad_an(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, long j, long j2, long j3, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "tp", 4);
        JsonUtils.put(jSONObject, "adrid", str);
        JsonUtils.put(jSONObject, "pid", str2);
        JsonUtils.put(jSONObject, "pfid", Integer.valueOf(i));
        JsonUtils.put(jSONObject, "adt", Integer.valueOf(i2));
        JsonUtils.put(jSONObject, "clid", UUIDUtils.uuid());
        JsonUtils.put(jSONObject, "tpid", Integer.valueOf(i3));
        JsonUtils.put(jSONObject, "clf", Integer.valueOf(CommonConstants.ClickFrom.AD.ordinal()));
        JsonUtils.put(jSONObject, "sen", Integer.valueOf(i4));
        JsonUtils.put(jSONObject, "rem", Integer.valueOf(i5));
        JsonUtils.put(jSONObject, "dety", Integer.valueOf(i6));
        JsonUtils.put(jSONObject, "scdu", Long.valueOf(j));
        JsonUtils.put(jSONObject, "dcdu", Long.valueOf(j2));
        JsonUtils.put(jSONObject, "ecdu", Long.valueOf(j3));
        JsonUtils.put(jSONObject, "sspt", Integer.valueOf(i7));
        JsonUtils.put(jSONObject, "scav", Integer.valueOf(i8));
        JsonUtils.put(jSONObject, "adat", Integer.valueOf(i9));
        JsonUtils.put(jSONObject, "atst", Integer.valueOf(i10));
        JsonUtils.put(jSONObject, "catp", Integer.valueOf(i11));
        JsonUtils.put(jSONObject, "dstp", Integer.valueOf(i12));
        JsonUtils.put(jSONObject, "srtp", Integer.valueOf(i13));
        JsonUtils.put(jSONObject, "ipl", Integer.valueOf(i14));
        jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    public static void jad_an(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, long j, long j2, long j3, int i7, int i8, int i9, int i10, int i11, int i12) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "tp", 4);
        JsonUtils.put(jSONObject, "adrid", str);
        JsonUtils.put(jSONObject, "pid", str2);
        JsonUtils.put(jSONObject, "pfid", Integer.valueOf(i));
        JsonUtils.put(jSONObject, "adt", Integer.valueOf(i2));
        JsonUtils.put(jSONObject, "clid", UUIDUtils.uuid());
        JsonUtils.put(jSONObject, "tpid", Integer.valueOf(i3));
        JsonUtils.put(jSONObject, "clf", Integer.valueOf(i9));
        JsonUtils.put(jSONObject, "sen", Integer.valueOf(i4));
        JsonUtils.put(jSONObject, "rem", Integer.valueOf(i5));
        JsonUtils.put(jSONObject, "dety", Integer.valueOf(i6));
        JsonUtils.put(jSONObject, "scdu", Long.valueOf(j));
        JsonUtils.put(jSONObject, "dcdu", Long.valueOf(j2));
        JsonUtils.put(jSONObject, "ecdu", Long.valueOf(j3));
        JsonUtils.put(jSONObject, "sspt", Integer.valueOf(i7));
        JsonUtils.put(jSONObject, "scav", Integer.valueOf(i8));
        JsonUtils.put(jSONObject, "dstp", Integer.valueOf(i10));
        JsonUtils.put(jSONObject, "srtp", Integer.valueOf(i11));
        JsonUtils.put(jSONObject, "ipl", Integer.valueOf(i12));
        jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    public static void jad_an(String str, int i, String str2) {
        jad_an(str, 5, i, str2, 0);
    }

    public static void jad_an(String str, int i, int i2, String str2, int i3) {
        if (com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_NET_IS_UNAVAILABLE_ERROR.jad_an(new String[0]).equals(str2)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "tp", 5);
        if (i != 2 && i != 3) {
            JsonUtils.put(jSONObject, "rid", "");
        } else {
            JsonUtils.put(jSONObject, "rid", str);
        }
        JsonUtils.put(jSONObject, "extp", Integer.valueOf(i));
        JsonUtils.put(jSONObject, "ercd", Integer.valueOf(i2));
        JsonUtils.put(jSONObject, "erin", str2);
        if (i == 3) {
            JsonUtils.put(jSONObject, "sen", Integer.valueOf(i3));
        } else {
            JsonUtils.put(jSONObject, "sen", 0);
        }
        jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    public static void jad_an(String str) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "tp", 6);
        JsonUtils.put(jSONObject, "iid", str);
        JsonUtils.put(jSONObject, "init", 2);
        JsonUtils.put(jSONObject, "idu", 0);
        jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    public static void jad_an(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "tp", 6);
        JsonUtils.put(jSONObject, "iid", str);
        JsonUtils.put(jSONObject, "init", 3);
        JsonUtils.put(jSONObject, "idu", Long.valueOf(j));
        jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }
}
