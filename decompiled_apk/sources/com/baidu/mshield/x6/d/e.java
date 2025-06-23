package com.baidu.mshield.x6.d;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public Context f6433a;
    public com.baidu.mshield.x6.a.c b;
    public int c;
    public int d;

    public e(Context context, int i) {
        this(context, i, 0);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(56:12|(53:101|(3:105|106|(1:108))|20|(1:100)(1:24)|25|26|27|28|29|30|31|32|33|34|(1:36)|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|(3:55|56|57)|58|59|60|(1:62)(1:99)|63|(1:65)(2:94|95)|66|67|68|69|70|71|(1:73)|74|(2:79|75)|(2:82|(1:84))(1:89)|85|86|87|88)(55:16|(1:18)|20|(1:22)|100|25|26|27|28|29|30|31|32|33|34|(0)|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|(0)|58|59|60|(0)(0)|63|(0)(0)|66|67|68|69|70|71|(0)|74|(3:77|79|75)|90|(0)(0)|85|86|87|88)|19|20|(0)|100|25|26|27|28|29|30|31|32|33|34|(0)|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|(0)|58|59|60|(0)(0)|63|(0)(0)|66|67|68|69|70|71|(0)|74|(1:75)|90|(0)(0)|85|86|87|88) */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x00a1, code lost:
    
        if (android.text.TextUtils.isEmpty(r6) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x020d, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x020e, code lost:
    
        com.baidu.mshield.x6.e.f.a(r8);
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00af A[Catch: all -> 0x0013, TryCatch #1 {all -> 0x0013, blocks: (B:6:0x0004, B:8:0x000c, B:9:0x0011, B:12:0x0016, B:14:0x0078, B:16:0x007e, B:20:0x00a9, B:22:0x00af, B:25:0x00b7, B:27:0x00cb, B:29:0x00dc, B:31:0x00fe, B:33:0x010f, B:37:0x0126, B:39:0x012d, B:41:0x0147, B:43:0x0150, B:45:0x015e, B:47:0x016d, B:49:0x017e, B:51:0x018b, B:53:0x0198, B:55:0x01a9, B:57:0x01b3, B:58:0x01ba, B:60:0x01c5, B:63:0x01d0, B:65:0x01df, B:66:0x01fe, B:71:0x0213, B:74:0x021b, B:79:0x023a, B:82:0x0250, B:84:0x025b, B:85:0x026e, B:89:0x0268, B:93:0x020e, B:98:0x01fb, B:101:0x0085, B:103:0x008b, B:112:0x00a6, B:106:0x0091, B:108:0x009d, B:95:0x01e7, B:69:0x0206), top: B:5:0x0004, outer: #0, inners: #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a9 A[Catch: all -> 0x0013, TRY_LEAVE, TryCatch #1 {all -> 0x0013, blocks: (B:6:0x0004, B:8:0x000c, B:9:0x0011, B:12:0x0016, B:14:0x0078, B:16:0x007e, B:20:0x00a9, B:22:0x00af, B:25:0x00b7, B:27:0x00cb, B:29:0x00dc, B:31:0x00fe, B:33:0x010f, B:37:0x0126, B:39:0x012d, B:41:0x0147, B:43:0x0150, B:45:0x015e, B:47:0x016d, B:49:0x017e, B:51:0x018b, B:53:0x0198, B:55:0x01a9, B:57:0x01b3, B:58:0x01ba, B:60:0x01c5, B:63:0x01d0, B:65:0x01df, B:66:0x01fe, B:71:0x0213, B:74:0x021b, B:79:0x023a, B:82:0x0250, B:84:0x025b, B:85:0x026e, B:89:0x0268, B:93:0x020e, B:98:0x01fb, B:101:0x0085, B:103:0x008b, B:112:0x00a6, B:106:0x0091, B:108:0x009d, B:95:0x01e7, B:69:0x0206), top: B:5:0x0004, outer: #0, inners: #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01df A[Catch: all -> 0x0013, TRY_LEAVE, TryCatch #1 {all -> 0x0013, blocks: (B:6:0x0004, B:8:0x000c, B:9:0x0011, B:12:0x0016, B:14:0x0078, B:16:0x007e, B:20:0x00a9, B:22:0x00af, B:25:0x00b7, B:27:0x00cb, B:29:0x00dc, B:31:0x00fe, B:33:0x010f, B:37:0x0126, B:39:0x012d, B:41:0x0147, B:43:0x0150, B:45:0x015e, B:47:0x016d, B:49:0x017e, B:51:0x018b, B:53:0x0198, B:55:0x01a9, B:57:0x01b3, B:58:0x01ba, B:60:0x01c5, B:63:0x01d0, B:65:0x01df, B:66:0x01fe, B:71:0x0213, B:74:0x021b, B:79:0x023a, B:82:0x0250, B:84:0x025b, B:85:0x026e, B:89:0x0268, B:93:0x020e, B:98:0x01fb, B:101:0x0085, B:103:0x008b, B:112:0x00a6, B:106:0x0091, B:108:0x009d, B:95:0x01e7, B:69:0x0206), top: B:5:0x0004, outer: #0, inners: #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0250 A[Catch: all -> 0x0013, TryCatch #1 {all -> 0x0013, blocks: (B:6:0x0004, B:8:0x000c, B:9:0x0011, B:12:0x0016, B:14:0x0078, B:16:0x007e, B:20:0x00a9, B:22:0x00af, B:25:0x00b7, B:27:0x00cb, B:29:0x00dc, B:31:0x00fe, B:33:0x010f, B:37:0x0126, B:39:0x012d, B:41:0x0147, B:43:0x0150, B:45:0x015e, B:47:0x016d, B:49:0x017e, B:51:0x018b, B:53:0x0198, B:55:0x01a9, B:57:0x01b3, B:58:0x01ba, B:60:0x01c5, B:63:0x01d0, B:65:0x01df, B:66:0x01fe, B:71:0x0213, B:74:0x021b, B:79:0x023a, B:82:0x0250, B:84:0x025b, B:85:0x026e, B:89:0x0268, B:93:0x020e, B:98:0x01fb, B:101:0x0085, B:103:0x008b, B:112:0x00a6, B:106:0x0091, B:108:0x009d, B:95:0x01e7, B:69:0x0206), top: B:5:0x0004, outer: #0, inners: #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0268 A[Catch: all -> 0x0013, TryCatch #1 {all -> 0x0013, blocks: (B:6:0x0004, B:8:0x000c, B:9:0x0011, B:12:0x0016, B:14:0x0078, B:16:0x007e, B:20:0x00a9, B:22:0x00af, B:25:0x00b7, B:27:0x00cb, B:29:0x00dc, B:31:0x00fe, B:33:0x010f, B:37:0x0126, B:39:0x012d, B:41:0x0147, B:43:0x0150, B:45:0x015e, B:47:0x016d, B:49:0x017e, B:51:0x018b, B:53:0x0198, B:55:0x01a9, B:57:0x01b3, B:58:0x01ba, B:60:0x01c5, B:63:0x01d0, B:65:0x01df, B:66:0x01fe, B:71:0x0213, B:74:0x021b, B:79:0x023a, B:82:0x0250, B:84:0x025b, B:85:0x026e, B:89:0x0268, B:93:0x020e, B:98:0x01fb, B:101:0x0085, B:103:0x008b, B:112:0x00a6, B:106:0x0091, B:108:0x009d, B:95:0x01e7, B:69:0x0206), top: B:5:0x0004, outer: #0, inners: #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a() {
        /*
            Method dump skipped, instructions count: 633
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x6.d.e.a():void");
    }

    public e(Context context, int i, int i2) {
        this.f6433a = context;
        this.c = i;
        this.d = i2;
        this.b = new com.baidu.mshield.x6.a.c(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0103 A[Catch: all -> 0x0109, TryCatch #1 {all -> 0x0109, blocks: (B:15:0x007b, B:19:0x0086, B:23:0x009d, B:26:0x00d0, B:30:0x00fa, B:32:0x0103, B:35:0x010c, B:39:0x011b, B:41:0x015d, B:48:0x0067, B:54:0x0075, B:51:0x006c), top: B:47:0x0067, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010c A[Catch: all -> 0x0109, TRY_LEAVE, TryCatch #1 {all -> 0x0109, blocks: (B:15:0x007b, B:19:0x0086, B:23:0x009d, B:26:0x00d0, B:30:0x00fa, B:32:0x0103, B:35:0x010c, B:39:0x011b, B:41:0x015d, B:48:0x0067, B:54:0x0075, B:51:0x006c), top: B:47:0x0067, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(org.json.JSONObject r14) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x6.d.e.a(org.json.JSONObject):void");
    }

    public final String a(String str, boolean z) {
        int optInt;
        int optInt2;
        String optString;
        String optString2;
        String valueOf;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    optInt = optJSONObject.optInt("eid");
                    optInt2 = optJSONObject.optInt("pattern");
                    optString = optJSONObject.optString("item");
                    optString2 = optJSONObject.optString("value");
                } catch (Throwable th) {
                    com.baidu.mshield.x6.e.f.a(th);
                }
                if (optInt2 != 0) {
                    str2 = "";
                    if (optInt2 == 2 || optInt2 == 3) {
                        String[] split = optString.split("\\|");
                        String str3 = split[0];
                        String str4 = split[1];
                        str2 = split.length == 3 ? split[2] : "";
                        if (optInt2 == 2) {
                            if (z) {
                                valueOf = (String) com.baidu.xclient.gdid.a.a(25, optString, optString2, (Object) null);
                            } else {
                                valueOf = com.baidu.mshield.x6.e.j.a(str3, str4, str2, optString2);
                            }
                        } else if (z) {
                            valueOf = (String) com.baidu.xclient.gdid.a.a(26, optString, optString2, (Object) null);
                        } else {
                            valueOf = com.baidu.mshield.x6.e.j.b(str3, str4, str2, optString2);
                        }
                    }
                    jSONObject.put(String.valueOf(optInt), str2);
                } else if (z) {
                    valueOf = (String) com.baidu.xclient.gdid.a.a(24, optString, optString2, (Object) null);
                } else {
                    valueOf = String.valueOf(com.baidu.mshield.x6.e.f.a(optString));
                }
                str2 = valueOf;
                jSONObject.put(String.valueOf(optInt), str2);
            }
        } catch (Throwable th2) {
            com.baidu.mshield.x6.e.f.a(th2);
        }
        return jSONObject.toString();
    }
}
