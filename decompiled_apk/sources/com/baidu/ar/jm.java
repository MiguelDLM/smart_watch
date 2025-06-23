package com.baidu.ar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.ar.arplay.representation.Number3D;
import com.baidu.ar.jp;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class jm {
    private static Bitmap a(BitmapFactory.Options options, boolean z, String str) {
        float f;
        int i;
        int i2;
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        float f2 = ((i3 * 1.0f) / i4) * 1.0f;
        if (z) {
            i = 500;
            f = i3 / 500;
            i2 = (int) (500 / f2);
        } else {
            f = i4 / 900;
            i = (int) (900 * f2);
            i2 = 900;
        }
        options.outWidth = i;
        options.outHeight = i2;
        options.inSampleSize = (int) f;
        return BitmapFactory.decodeFile(str, options);
    }

    public static jp bP(String str) {
        File file = new File(str, "res/default.json");
        File file2 = new File(str, "targets.json");
        jp bQ = file.exists() ? bQ(file.getAbsolutePath()) : null;
        return (bQ == null && file2.exists()) ? bR(file2.getAbsolutePath()) : bQ;
    }

    private static jp bQ(String str) {
        String cm = km.cm(str);
        jp jpVar = null;
        if (TextUtils.isEmpty(cm)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(cm);
            if (!jSONObject.has("ar_configs")) {
                return null;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("ar_configs");
            if (jSONArray.length() == 0) {
                return null;
            }
            JSONObject jSONObject2 = (JSONObject) jSONArray.get(0);
            if (!jSONObject2.has("ar_target")) {
                return null;
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject("ar_target");
            jp jpVar2 = new jp();
            try {
                if (jSONObject3.has("targets")) {
                    JSONArray jSONArray2 = jSONObject3.getJSONArray("targets");
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray2.length(); i++) {
                        try {
                            arrayList.add(a((JSONObject) jSONArray2.get(i), str));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    jpVar2.l(arrayList);
                }
                if (jSONObject3.has("UI")) {
                    jpVar2.a(m(jSONObject3.getJSONObject("UI")));
                }
                if (jSONObject.has(NotificationCompat.CATEGORY_SERVICE)) {
                    jpVar2.a(n(jSONObject.getJSONObject(NotificationCompat.CATEGORY_SERVICE)));
                }
                return jpVar2;
            } catch (Exception e2) {
                e = e2;
                jpVar = jpVar2;
                e.printStackTrace();
                return jpVar;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static jp bR(String str) {
        String cm = km.cm(str);
        if (TextUtils.isEmpty(cm)) {
            return null;
        }
        try {
            jp jpVar = new jp();
            JSONObject jSONObject = new JSONObject(cm);
            if (jSONObject.has("targets")) {
                JSONArray jSONArray = jSONObject.getJSONArray("targets");
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        arrayList.add(a((JSONObject) jSONArray.get(i), str));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                jpVar.l(arrayList);
            }
            if (jSONObject.has("UI")) {
                jpVar.a(m(jSONObject.getJSONObject("UI")));
            }
            if (jSONObject.has(NotificationCompat.CATEGORY_SERVICE)) {
                jpVar.a(n(jSONObject.getJSONObject(NotificationCompat.CATEGORY_SERVICE)));
            }
            return jpVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static Number3D bS(String str) {
        Number3D number3D = new Number3D();
        try {
            String[] split = str.split(",");
            number3D.setAll(Float.valueOf(split[0]).floatValue(), Float.valueOf(split[1]).floatValue(), Float.valueOf(split[2]).floatValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return number3D;
    }

    private static jo m(JSONObject jSONObject) {
        int parseInt;
        jo joVar = new jo();
        try {
            if (jSONObject.has("udt_tip_simple")) {
                joVar.bU(jSONObject.getString("udt_tip_simple"));
            }
            if (jSONObject.has("udt_tip_detail")) {
                joVar.bV(jSONObject.getString("udt_tip_detail"));
            }
            if (jSONObject.has(ViewHierarchyConstants.HINT_KEY)) {
                joVar.bW(jSONObject.getString(ViewHierarchyConstants.HINT_KEY));
            }
            if (jSONObject.has("too_far_hint")) {
                joVar.bX(jSONObject.getString("too_far_hint"));
            }
            if (jSONObject.has("too_near_hint")) {
                joVar.bY(jSONObject.getString("too_near_hint"));
            }
            if (jSONObject.has("not_find_hint")) {
                joVar.bZ(jSONObject.getString("not_find_hint"));
            }
            if (jSONObject.has("far_threshold")) {
                joVar.b(Float.parseFloat(jSONObject.getString("far_threshold")));
            }
            if (jSONObject.has("near_threshold")) {
                joVar.c(Float.parseFloat(jSONObject.getString("near_threshold")));
            }
            if (jSONObject.has("case_type") && (parseInt = Integer.parseInt(jSONObject.getString("case_type"))) >= 0 && parseInt < jp.a.values().length) {
                joVar.a(jp.a.values()[parseInt]);
            }
            if (jSONObject.has("udt_mode")) {
                joVar.R(Integer.parseInt(jSONObject.getString("udt_mode")));
            }
            if (jSONObject.has("help_url")) {
                joVar.ca(jSONObject.getString("help_url"));
            }
            if (jSONObject.has("help_url_show_once")) {
                joVar.Q(Integer.parseInt(jSONObject.getString("help_url_show_once")));
            }
            if (jSONObject.has("help_url_show_once")) {
                joVar.Q(Integer.parseInt(jSONObject.getString("help_url_show_once")));
            }
            if (jSONObject.has("slam_texture_tip")) {
                joVar.cb(jSONObject.getString("slam_texture_tip"));
            }
            if (jSONObject.has("help_url")) {
                joVar.cc(jSONObject.getString("help_url"));
            }
            if (jSONObject.has("slam_device_orientation_tip")) {
                joVar.cd(jSONObject.getString("slam_device_orientation_tip"));
            }
            if (jSONObject.has("image_target_path")) {
                joVar.ce(jSONObject.getString("image_target_path"));
            }
            if (jSONObject.has("hide_shot_immediately")) {
                joVar.S(jSONObject.getInt("hide_shot_immediately"));
            }
            if (jSONObject.has("show_tips_by_case")) {
                joVar.T(jSONObject.getInt("show_tips_by_case"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return joVar;
    }

    public static jq n(JSONObject jSONObject) {
        jq jqVar = new jq();
        try {
            if (jSONObject.has("open_track_service")) {
                jqVar.U(jSONObject.getInt("open_track_service"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jqVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005b A[Catch: Exception -> 0x004b, TRY_LEAVE, TryCatch #0 {Exception -> 0x004b, blocks: (B:4:0x0003, B:9:0x000a, B:12:0x0019, B:16:0x0044, B:18:0x005b, B:25:0x0051), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap a(com.baidu.ar.jp r5, java.lang.String r6) {
        /*
            r0 = 0
            if (r5 == 0) goto L65
            com.baidu.ar.jo r1 = r5.gu()     // Catch: java.lang.Exception -> L4b
            if (r1 != 0) goto La
            goto L65
        La:
            com.baidu.ar.jo r5 = r5.gu()     // Catch: java.lang.Exception -> L4b
            java.lang.String r5 = r5.gs()     // Catch: java.lang.Exception -> L4b
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L4b
            if (r1 == 0) goto L19
            return r0
        L19:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L4b
            r1.<init>()     // Catch: java.lang.Exception -> L4b
            r1.append(r6)     // Catch: java.lang.Exception -> L4b
            java.lang.String r6 = java.io.File.separator     // Catch: java.lang.Exception -> L4b
            r1.append(r6)     // Catch: java.lang.Exception -> L4b
            r1.append(r5)     // Catch: java.lang.Exception -> L4b
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Exception -> L4b
            android.graphics.BitmapFactory$Options r6 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Exception -> L4b
            r6.<init>()     // Catch: java.lang.Exception -> L4b
            r1 = 1
            r6.inJustDecodeBounds = r1     // Catch: java.lang.Exception -> L4b
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r5, r6)     // Catch: java.lang.Exception -> L4b
            int r2 = r6.outWidth     // Catch: java.lang.Exception -> L4b
            int r3 = r6.outHeight     // Catch: java.lang.Exception -> L4b
            r4 = 0
            if (r3 <= r2) goto L4d
            r2 = 900(0x384, float:1.261E-42)
            if (r3 <= r2) goto L58
            r6.inJustDecodeBounds = r4     // Catch: java.lang.Exception -> L4b
            android.graphics.Bitmap r0 = a(r6, r4, r5)     // Catch: java.lang.Exception -> L4b
            goto L59
        L4b:
            r5 = move-exception
            goto L62
        L4d:
            r3 = 500(0x1f4, float:7.0E-43)
            if (r2 <= r3) goto L58
            r6.inJustDecodeBounds = r4     // Catch: java.lang.Exception -> L4b
            android.graphics.Bitmap r0 = a(r6, r1, r5)     // Catch: java.lang.Exception -> L4b
            goto L59
        L58:
            r1 = 0
        L59:
            if (r1 != 0) goto L65
            r6.inJustDecodeBounds = r4     // Catch: java.lang.Exception -> L4b
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r5, r6)     // Catch: java.lang.Exception -> L4b
            goto L65
        L62:
            r5.printStackTrace()
        L65:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.jm.a(com.baidu.ar.jp, java.lang.String):android.graphics.Bitmap");
    }

    private static jn a(JSONObject jSONObject, String str) {
        jn jnVar = new jn();
        try {
            if (str.length() > 0) {
                jnVar.setPath(str.substring(0, str.lastIndexOf(47)));
            }
            if (jSONObject.has("id")) {
                jnVar.setId(jSONObject.getString("id"));
            }
            if (jSONObject.has("name")) {
                jnVar.setName(jSONObject.getString("name"));
            }
            if (jSONObject.has("model_path")) {
                jnVar.bT(jSONObject.getString("model_path"));
            }
            if (jSONObject.has("template_width")) {
                jnVar.O(jSONObject.getInt("template_width"));
            }
            if (jSONObject.has("template_height")) {
                jnVar.P(jSONObject.getInt("template_height"));
            }
            if (jSONObject.has("target_width")) {
                jnVar.setTargetWidth(jSONObject.getInt("target_width"));
            }
            if (jSONObject.has("target_height")) {
                jnVar.setTargetHeight(jSONObject.getInt("target_height"));
            }
            if (jSONObject.has("centre_pos")) {
                jnVar.a(bS(jSONObject.getString("centre_pos")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jnVar;
    }
}
