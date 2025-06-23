package com.jd.ad.sdk.jad_jt;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.multi.BuildConfig;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class jad_hu {
    public static JSONArray jad_an(JADSlot jADSlot) {
        JSONArray jad_bo;
        JSONArray jSONArray = new JSONArray();
        Object[] objArr = new String[0];
        if (!TextUtils.isEmpty(jADSlot.getSlotID())) {
            objArr = jADSlot.getSlotID().split(",");
        }
        for (Object obj : objArr) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", UUIDUtils.uuid());
            jSONObject.put("tagid", obj);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.WIDTH, jADSlot.getAdImageWidth());
            jSONObject2.put(IAdInterListener.AdReqParam.HEIGHT, jADSlot.getAdImageHeight());
            jSONObject2.put("count", 1);
            jSONObject2.put("imgnum", 1);
            jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, jSONObject2);
            jSONObject.put("isdeeplink", true);
            jSONObject.put(ClientCookie.SECURE_ATTR, 1);
            if (jADSlot.getDynamicRenderTemplateHelper() != null && (jad_bo = jADSlot.getDynamicRenderTemplateHelper().jad_bo()) != null && jad_bo.length() > 0) {
                jSONObject.put("template_list", jADSlot.getDynamicRenderTemplateHelper().jad_bo());
            }
            jSONObject.put("render_form", jADSlot.isFromNativeAd() ? 1 : 0);
            jSONObject.put("display_scene", jADSlot.getDisplayScene());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static byte[] jad_bo(@NonNull JADSlot jADSlot) {
        String str;
        int i;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", jADSlot.getRequestId());
            jSONObject.put("version", "4.0");
            jSONObject.put("imp", jad_an(jADSlot));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", JADYunSdk.getAppId());
            jSONObject2.put("bundle", com.jd.ad.sdk.jad_ob.jad_hu.jad_an(com.jd.ad.sdk.jad_do.jad_bo.jad_an()));
            jSONObject2.put("sdkversion", BuildConfig.VERSION_NAME);
            jSONObject.put("app", jSONObject2);
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, jad_an(com.jd.ad.sdk.jad_do.jad_bo.jad_an()));
            jSONObject.put("anti", jad_an());
        } catch (Exception e) {
            String str2 = "";
            if (jADSlot == null) {
                str = "";
            } else {
                str = jADSlot.getRequestId();
            }
            int i2 = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_JSON_ERROR.jad_an;
            if (jADSlot != null) {
                str2 = jADSlot.getSlotID();
            }
            int i3 = 0;
            if (jADSlot != null) {
                i = jADSlot.getAdType();
            } else {
                i = 0;
            }
            String jad_an = com.jd.ad.sdk.jad_uh.jad_an.GW_REQUEST_OTHER_ERROR.jad_an(e.getMessage());
            JSONObject jSONObject3 = new JSONObject();
            JsonUtils.put(jSONObject3, "pid", str2);
            JsonUtils.put(jSONObject3, "adt", Integer.valueOf(i));
            JsonUtils.put(jSONObject3, "error", jad_an);
            String jSONObject4 = jSONObject3.toString();
            if (jADSlot != null) {
                i3 = jADSlot.getSen();
            }
            com.jd.ad.sdk.jad_vi.jad_fs.jad_an(str, 3, i2, jSONObject4, i3);
        }
        StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Gateway API Request: ");
        jad_an2.append(jSONObject.toString());
        Logger.d(jad_an2.toString());
        String jSONObject5 = jSONObject.toString();
        com.jd.ad.sdk.jad_na.jad_an jad_an3 = com.jd.ad.sdk.jad_pc.jad_an.jad_an();
        if (jad_an3 == null || !"1".equals(jad_an3.jad_bo)) {
            jSONObject5 = ANEProxy.jd(jSONObject.toString());
            if (TextUtils.isEmpty(jSONObject5)) {
                return null;
            }
        }
        return jSONObject5.getBytes(Charset.forName("UTF-8"));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:18:0x005f
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0069 A[Catch: Exception -> 0x005f, TryCatch #1 {Exception -> 0x005f, blocks: (B:12:0x0050, B:100:0x0057, B:102:0x0061, B:104:0x0069, B:105:0x006e), top: B:11:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x006e A[Catch: Exception -> 0x005f, TRY_LEAVE, TryCatch #1 {Exception -> 0x005f, blocks: (B:12:0x0050, B:100:0x0057, B:102:0x0061, B:104:0x0069, B:105:0x006e), top: B:11:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0091 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0235 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0236 A[Catch: Exception -> 0x0253, TryCatch #10 {Exception -> 0x0253, blocks: (B:41:0x022f, B:50:0x0236, B:53:0x023f, B:55:0x0247, B:56:0x024c), top: B:40:0x022f }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0247 A[Catch: Exception -> 0x0253, TryCatch #10 {Exception -> 0x0253, blocks: (B:41:0x022f, B:50:0x0236, B:53:0x023f, B:55:0x0247, B:56:0x024c), top: B:40:0x022f }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x024c A[Catch: Exception -> 0x0253, TRY_LEAVE, TryCatch #10 {Exception -> 0x0253, blocks: (B:41:0x022f, B:50:0x0236, B:53:0x023f, B:55:0x0247, B:56:0x024c), top: B:40:0x022f }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a6 A[Catch: Exception -> 0x01ae, TryCatch #2 {Exception -> 0x01ae, blocks: (B:33:0x019f, B:58:0x01a6, B:60:0x01b0, B:62:0x01b8, B:63:0x01bd), top: B:32:0x019f }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01b8 A[Catch: Exception -> 0x01ae, TryCatch #2 {Exception -> 0x01ae, blocks: (B:33:0x019f, B:58:0x01a6, B:60:0x01b0, B:62:0x01b8, B:63:0x01bd), top: B:32:0x019f }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01bd A[Catch: Exception -> 0x01ae, TRY_LEAVE, TryCatch #2 {Exception -> 0x01ae, blocks: (B:33:0x019f, B:58:0x01a6, B:60:0x01b0, B:62:0x01b8, B:63:0x01bd), top: B:32:0x019f }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ca A[Catch: Exception -> 0x00d2, TryCatch #11 {Exception -> 0x00d2, blocks: (B:27:0x00c3, B:70:0x00ca, B:72:0x00d4, B:74:0x00dc, B:75:0x00e1, B:83:0x00eb), top: B:26:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00dc A[Catch: Exception -> 0x00d2, TryCatch #11 {Exception -> 0x00d2, blocks: (B:27:0x00c3, B:70:0x00ca, B:72:0x00d4, B:74:0x00dc, B:75:0x00e1, B:83:0x00eb), top: B:26:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e1 A[Catch: Exception -> 0x00d2, TryCatch #11 {Exception -> 0x00d2, blocks: (B:27:0x00c3, B:70:0x00ca, B:72:0x00d4, B:74:0x00dc, B:75:0x00e1, B:83:0x00eb), top: B:26:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0092 A[Catch: Exception -> 0x009a, TryCatch #6 {Exception -> 0x009a, blocks: (B:20:0x008b, B:87:0x0092, B:89:0x009c, B:91:0x00a4, B:92:0x00a9), top: B:19:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00a4 A[Catch: Exception -> 0x009a, TryCatch #6 {Exception -> 0x009a, blocks: (B:20:0x008b, B:87:0x0092, B:89:0x009c, B:91:0x00a4, B:92:0x00a9), top: B:19:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00a9 A[Catch: Exception -> 0x009a, TRY_LEAVE, TryCatch #6 {Exception -> 0x009a, blocks: (B:20:0x008b, B:87:0x0092, B:89:0x009c, B:91:0x00a4, B:92:0x00a9), top: B:19:0x008b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String jad_an() {
        /*
            Method dump skipped, instructions count: 639
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_jt.jad_hu.jad_an():java.lang.String");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:158:0x04b4
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX WARN: Removed duplicated region for block: B:110:0x04d6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0510 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x055a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x055b A[Catch: Exception -> 0x0561, TRY_LEAVE, TryCatch #17 {Exception -> 0x0561, blocks: (B:121:0x0552, B:127:0x055b), top: B:120:0x0552 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0511 A[Catch: Exception -> 0x0542, TryCatch #35 {Exception -> 0x0542, blocks: (B:116:0x050a, B:130:0x0511, B:134:0x051c, B:137:0x0534), top: B:115:0x050a }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0520 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x04d7 A[Catch: NumberFormatException -> 0x04df, TryCatch #22 {NumberFormatException -> 0x04df, blocks: (B:108:0x04d0, B:145:0x04d7, B:147:0x04e1, B:149:0x04e9, B:150:0x04ee), top: B:107:0x04d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04e9 A[Catch: NumberFormatException -> 0x04df, TryCatch #22 {NumberFormatException -> 0x04df, blocks: (B:108:0x04d0, B:145:0x04d7, B:147:0x04e1, B:149:0x04e9, B:150:0x04ee), top: B:107:0x04d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04ee A[Catch: NumberFormatException -> 0x04df, TRY_LEAVE, TryCatch #22 {NumberFormatException -> 0x04df, blocks: (B:108:0x04d0, B:145:0x04d7, B:147:0x04e1, B:149:0x04e9, B:150:0x04ee), top: B:107:0x04d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04aa A[Catch: Exception -> 0x04a7, TRY_LEAVE, TryCatch #14 {Exception -> 0x04a7, blocks: (B:101:0x04a1, B:159:0x04aa), top: B:100:0x04a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0475 A[Catch: Exception -> 0x0499, TryCatch #11 {Exception -> 0x0499, blocks: (B:95:0x046e, B:175:0x0475, B:177:0x047f, B:179:0x0487, B:183:0x048e), top: B:94:0x046e }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0487 A[Catch: Exception -> 0x0499, TryCatch #11 {Exception -> 0x0499, blocks: (B:95:0x046e, B:175:0x0475, B:177:0x047f, B:179:0x0487, B:183:0x048e), top: B:94:0x046e }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x048e A[Catch: Exception -> 0x0499, TRY_LEAVE, TryCatch #11 {Exception -> 0x0499, blocks: (B:95:0x046e, B:175:0x0475, B:177:0x047f, B:179:0x0487, B:183:0x048e), top: B:94:0x046e }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x041b A[Catch: Exception -> 0x0466, TryCatch #16 {Exception -> 0x0466, blocks: (B:89:0x0414, B:189:0x041b, B:192:0x0424, B:194:0x042e), top: B:88:0x0414 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x042e A[Catch: Exception -> 0x0466, TRY_LEAVE, TryCatch #16 {Exception -> 0x0466, blocks: (B:89:0x0414, B:189:0x041b, B:192:0x0424, B:194:0x042e), top: B:88:0x0414 }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03d7 A[Catch: Exception -> 0x0407, TRY_LEAVE, TryCatch #30 {Exception -> 0x0407, blocks: (B:83:0x03d0, B:198:0x03d7, B:204:0x0400, B:209:0x03fb, B:202:0x03e2), top: B:82:0x03d0, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0382 A[Catch: Exception -> 0x037f, TryCatch #25 {Exception -> 0x037f, blocks: (B:77:0x0379, B:211:0x0382, B:214:0x038b, B:216:0x0393, B:217:0x03a0, B:219:0x03a8, B:220:0x03b0), top: B:76:0x0379 }] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0393 A[Catch: Exception -> 0x037f, TryCatch #25 {Exception -> 0x037f, blocks: (B:77:0x0379, B:211:0x0382, B:214:0x038b, B:216:0x0393, B:217:0x03a0, B:219:0x03a8, B:220:0x03b0), top: B:76:0x0379 }] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03a0 A[Catch: Exception -> 0x037f, TryCatch #25 {Exception -> 0x037f, blocks: (B:77:0x0379, B:211:0x0382, B:214:0x038b, B:216:0x0393, B:217:0x03a0, B:219:0x03a8, B:220:0x03b0), top: B:76:0x0379 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0353 A[Catch: Exception -> 0x0373, TryCatch #5 {Exception -> 0x0373, blocks: (B:72:0x034b, B:231:0x0353, B:233:0x035b, B:237:0x0366), top: B:71:0x034b }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0325 A[Catch: Exception -> 0x0341, TryCatch #36 {Exception -> 0x0341, blocks: (B:64:0x031b, B:246:0x0325, B:248:0x032d, B:252:0x0338), top: B:63:0x031b }] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x02dc A[Catch: Exception -> 0x0313, TryCatch #24 {Exception -> 0x0313, blocks: (B:58:0x02d3, B:258:0x02dc, B:260:0x02e4, B:265:0x02ed), top: B:57:0x02d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:271:0x02af A[Catch: Exception -> 0x02c9, TryCatch #20 {Exception -> 0x02c9, blocks: (B:53:0x02a5, B:271:0x02af, B:273:0x02b7, B:277:0x02be), top: B:52:0x02a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x028d A[Catch: Exception -> 0x029d, TryCatch #9 {Exception -> 0x029d, blocks: (B:47:0x0286, B:283:0x028d, B:286:0x0296), top: B:46:0x0286 }] */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0237 A[Catch: Exception -> 0x0254, TryCatch #23 {Exception -> 0x0254, blocks: (B:36:0x0230, B:292:0x0237, B:294:0x0241, B:296:0x0249, B:300:0x0256), top: B:35:0x0230 }] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0249 A[Catch: Exception -> 0x0254, TryCatch #23 {Exception -> 0x0254, blocks: (B:36:0x0230, B:292:0x0237, B:294:0x0241, B:296:0x0249, B:300:0x0256), top: B:35:0x0230 }] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0256 A[Catch: Exception -> 0x0254, TRY_LEAVE, TryCatch #23 {Exception -> 0x0254, blocks: (B:36:0x0230, B:292:0x0237, B:294:0x0241, B:296:0x0249, B:300:0x0256), top: B:35:0x0230 }] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0212 A[Catch: Exception -> 0x0228, TryCatch #12 {Exception -> 0x0228, blocks: (B:30:0x0207, B:307:0x0212, B:310:0x021d), top: B:29:0x0207 }] */
    /* JADX WARN: Removed duplicated region for block: B:313:0x01dc A[Catch: Exception -> 0x01f4, TryCatch #4 {Exception -> 0x01f4, blocks: (B:25:0x01d2, B:313:0x01dc, B:315:0x01e4, B:319:0x01eb), top: B:24:0x01d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:326:0x019a A[Catch: Exception -> 0x01a9, TryCatch #1 {Exception -> 0x01a9, blocks: (B:19:0x018e, B:326:0x019a, B:328:0x01a2, B:329:0x01ac), top: B:18:0x018e }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0236 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0273 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x028c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03d6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x041a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0474 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject jad_an(android.content.Context r20) {
        /*
            Method dump skipped, instructions count: 1390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_jt.jad_hu.jad_an(android.content.Context):org.json.JSONObject");
    }

    public static String jad_an(com.jd.ad.sdk.jad_na.jad_cp jad_cpVar, String str) {
        if (jad_cpVar == null) {
            return "";
        }
        com.jd.ad.sdk.jad_wj.jad_an jad_an = com.jd.ad.sdk.jad_mz.jad_jt.jad_an(str);
        if (jad_an != null && jad_an.jad_cp == 4) {
            String str2 = jad_cpVar.jad_an.jad_bo;
            Logger.w("The url is currently in a non-online environment ", new Object[0]);
            return str2;
        }
        Logger.i("The url is currently in a online environment ", new Object[0]);
        return jad_cpVar.jad_an.jad_an;
    }
}
