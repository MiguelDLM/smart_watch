package com.jd.ad.sdk.jad_re;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.text.TextUtils;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.jad_kx.jad_cp;
import com.jd.ad.sdk.jad_ob.jad_hu;
import com.jd.ad.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_an {
    public static List<String> jad_an = new ArrayList();
    public static List<String> jad_bo = new ArrayList();

    /* renamed from: com.jd.ad.sdk.jad_re.jad_an$jad_an, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class RunnableC0713jad_an implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            synchronized (jad_an.class) {
                jad_an.jad_an(jad_an.jad_an);
            }
        }
    }

    public static String jad_an(Uri uri) {
        String[] split;
        if (uri != null) {
            try {
                if (!TextUtils.isEmpty(uri.getPath()) && (split = uri.getPath().split("/")) != null && split.length >= 2) {
                    return split[1];
                }
                return "";
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static String jad_bo() {
        StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("content://");
        jad_an2.append(jad_hu.jad_an(com.jd.ad.sdk.jad_do.jad_bo.jad_an()));
        jad_an2.append(".JADMultiProvider");
        jad_an2.append("/");
        return jad_an2.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bf, code lost:
    
        if (r8.isClosed() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00df, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00dd, code lost:
    
        if (r8.isClosed() == false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<com.jd.ad.sdk.jad_hu.jad_cp> jad_bo(java.lang.String r16) {
        /*
            java.lang.String r0 = "/"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.content.ContentResolver r2 = jad_an()
            if (r2 != 0) goto Le
            return r1
        Le:
            r8 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            r3.<init>()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r4 = jad_bo()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            r3.append(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r4 = "db_dynamic_render"
            r3.append(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            r3.append(r0)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r4 = "query"
            r3.append(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            r3.append(r0)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            r0 = r16
            r3.append(r0)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            if (r8 == 0) goto Lb9
            int r2 = r8.getCount()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            if (r2 <= 0) goto Lb9
            r8.moveToFirst()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            r4 = 2592000000(0x9a7ec800, double:1.280618154E-314)
            long r2 = r2 - r4
        L55:
            boolean r4 = r8.isAfterLast()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            if (r4 != 0) goto Lb6
            java.lang.String r4 = "_id"
            int r4 = r8.getColumnIndex(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            int r10 = r8.getInt(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r4 = "templateID"
            int r4 = r8.getColumnIndex(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            int r12 = r8.getInt(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r4 = "templateUpdateTimeStamp"
            int r4 = r8.getColumnIndex(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r13 = r8.getString(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r4 = "templateJSON"
            int r4 = r8.getColumnIndex(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r14 = r8.getString(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r4 = "timeStampInterval"
            int r4 = r8.getColumnIndex(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r15 = r8.getString(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            boolean r4 = android.text.TextUtils.isEmpty(r14)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            if (r4 != 0) goto Lb2
            int r4 = r1.size()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            r5 = 1
            if (r4 <= r5) goto La7
            long r4 = java.lang.Long.parseLong(r15)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 >= 0) goto La7
            goto Lb2
        La3:
            r0 = move-exception
            goto Le3
        La5:
            r0 = move-exception
            goto Lc2
        La7:
            com.jd.ad.sdk.jad_hu.jad_cp r4 = new com.jd.ad.sdk.jad_hu.jad_cp     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            r9 = r4
            r11 = r16
            r9.<init>(r10, r11, r12, r13, r14, r15)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            r1.add(r4)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
        Lb2:
            r8.moveToNext()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            goto L55
        Lb6:
            r8.close()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
        Lb9:
            if (r8 == 0) goto Le2
            boolean r0 = r8.isClosed()
            if (r0 != 0) goto Le2
            goto Ldf
        Lc2:
            java.lang.String r2 = ""
            com.jd.ad.sdk.jad_uh.jad_an r3 = com.jd.ad.sdk.jad_uh.jad_an.MULTIPLE_PROCESS_TEMPLATE_QUERY_ERROR     // Catch: java.lang.Throwable -> La3
            int r4 = r3.jad_an     // Catch: java.lang.Throwable -> La3
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> La3
            java.lang.String[] r0 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> La3
            java.lang.String r0 = r3.jad_an(r0)     // Catch: java.lang.Throwable -> La3
            com.jd.ad.sdk.jad_vi.jad_fs.jad_an(r2, r4, r0)     // Catch: java.lang.Throwable -> La3
            if (r8 == 0) goto Le2
            boolean r0 = r8.isClosed()
            if (r0 != 0) goto Le2
        Ldf:
            r8.close()
        Le2:
            return r1
        Le3:
            if (r8 == 0) goto Lee
            boolean r1 = r8.isClosed()
            if (r1 != 0) goto Lee
            r8.close()
        Lee:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_re.jad_an.jad_bo(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d8, code lost:
    
        if (r2.isClosed() == false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized java.util.List<com.jd.ad.sdk.jad_kx.jad_cp> jad_an(java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_re.jad_an.jad_an(java.lang.String):java.util.List");
    }

    public static synchronized void jad_an(List<String> list) {
        ContentResolver jad_an2;
        synchronized (jad_an.class) {
            String str = jad_bo() + "db_preload_ad/remove";
            if (list == null || list.size() == 0) {
                return;
            }
            try {
                jad_an2 = jad_an();
            } catch (Throwable th) {
                Logger.w("Exception while clearing preload ad data list:", th.getMessage());
            }
            if (jad_an2 == null) {
                return;
            }
            Uri parse = Uri.parse(str);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jad_an2.delete(parse, "rId=?", new String[]{it.next()});
            }
        }
    }

    public static ContentValues jad_an(jad_cp jad_cpVar) {
        ContentValues contentValues;
        try {
            contentValues = new ContentValues();
        } catch (Exception e) {
            e = e;
            contentValues = null;
        }
        try {
            contentValues.put("appIdSlotId", jad_cpVar.jad_cp);
            contentValues.put("rId", jad_cpVar.jad_bo);
            contentValues.put("preloadAdJson", ANEProxy.ja(jad_cpVar.jad_dq));
            contentValues.put("preloadAdCacheTimeStamp", jad_cpVar.jad_er);
        } catch (Exception e2) {
            e = e2;
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while add preload data:");
            jad_an2.append(e.getMessage());
            Logger.w(jad_an2.toString(), new Object[0]);
            return contentValues;
        }
        return contentValues;
    }

    public static ContentResolver jad_an() {
        try {
            Application jad_an2 = com.jd.ad.sdk.jad_do.jad_bo.jad_an();
            if (jad_an2 != null) {
                return jad_an2.getContentResolver();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
