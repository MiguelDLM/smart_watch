package com.jd.ad.sdk.dl.cache.multiprocess;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.jad_hu.jad_bo;
import com.jd.ad.sdk.jad_kx.jad_an;
import com.jd.ad.sdk.jad_sf.jad_bo;
import com.jd.ad.sdk.jad_vi.jad_cp;
import com.jd.ad.sdk.jad_vi.jad_dq;
import com.jd.ad.sdk.jad_vi.jad_fs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class JADMultiProvider extends ContentProvider {
    public static jad_bo jad_an;
    public static jad_cp jad_bo;
    public static jad_an jad_cp;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        String[] split;
        if (uri != null) {
            String jad_an2 = com.jd.ad.sdk.jad_re.jad_an.jad_an(uri);
            if (!TextUtils.isEmpty(jad_an2)) {
                jad_an2.getClass();
                char c = 65535;
                switch (jad_an2.hashCode()) {
                    case 1418758266:
                        if (jad_an2.equals("db_preload_ad")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2080050073:
                        if (jad_an2.equals("db_event")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2144498451:
                        if (jad_an2.equals("sp_jadyunsdk")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        try {
                            if (!TextUtils.isEmpty(str) && strArr != null) {
                                jad_bo();
                                jad_cp.jad_an(str, strArr);
                                break;
                            }
                        } catch (Exception e) {
                            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.MULTIPLE_PROCESS_PRELOAD_AD_DELETE_ERROR;
                            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
                            break;
                        }
                        break;
                    case 1:
                        try {
                            if (!TextUtils.isEmpty(str) && strArr != null) {
                                jad_an();
                                jad_bo.jad_an(str, strArr);
                                break;
                            }
                        } catch (Exception e2) {
                            com.jd.ad.sdk.jad_uh.jad_an jad_anVar2 = com.jd.ad.sdk.jad_uh.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_DELETE_EVENT_ERROR;
                            jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(e2.getMessage()));
                            break;
                        }
                        break;
                    case 2:
                        try {
                            if (!TextUtils.isEmpty(uri.getPath()) && (split = uri.getPath().split("/")) != null && split.length > 4) {
                                jad_bo.jad_an.jad_an.jad_an(split[3]);
                                break;
                            }
                        } catch (Exception e3) {
                            com.jd.ad.sdk.jad_uh.jad_an jad_anVar3 = com.jd.ad.sdk.jad_uh.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_DELETE_SP_ERROR;
                            jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(e3.getMessage()));
                            break;
                        }
                        break;
                }
            }
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        String[] split;
        String str;
        String str2;
        try {
            if (!TextUtils.isEmpty(uri.getPath()) && (split = uri.getPath().split("/")) != null) {
                if (split.length < 2) {
                    str = "";
                } else {
                    str = split[1];
                }
                if (split.length < 3) {
                    str2 = "";
                } else {
                    str2 = split[2];
                }
                if (!TextUtils.isEmpty(str) && str.equals("sp_jadyunsdk")) {
                    if (str2.equals("get")) {
                        if (split.length >= 5) {
                            return (String) jad_bo.jad_an.jad_an.jad_an(split[4], String.class);
                        }
                    } else if (str2.equals("contain") && split.length >= 4) {
                        return String.valueOf(jad_bo.jad_an.jad_an.jad_an(split[3], false));
                    }
                }
            }
        } catch (Exception e) {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_GET_TYPE_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
        return "";
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        String jad_an2 = com.jd.ad.sdk.jad_re.jad_an.jad_an(uri);
        if (!TextUtils.isEmpty(jad_an2) && jad_an2.equals("sp_jadyunsdk") && contentValues != null) {
            try {
                jad_bo.jad_an.jad_an.jad_an((String) contentValues.get("key"), contentValues.get("value"));
                return null;
            } catch (Exception e) {
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_INSERT_SP_ERROR;
                jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
                return null;
            }
        }
        return null;
    }

    public final void jad_an() {
        jad_cp jad_cpVar;
        if (jad_bo == null) {
            Application jad_an2 = com.jd.ad.sdk.jad_do.jad_bo.jad_an();
            synchronized (jad_cp.class) {
                try {
                    if (jad_cp.jad_bo == null) {
                        jad_cp.jad_bo = new jad_cp(jad_an2, "jaddb.db", 2);
                    }
                    jad_cpVar = jad_cp.jad_bo;
                } catch (Throwable th) {
                    throw th;
                }
            }
            jad_bo = jad_cpVar;
            jad_cpVar.jad_cp();
        }
    }

    public final void jad_bo() {
        if (jad_cp == null) {
            jad_an jad_dq = jad_an.jad_dq();
            jad_cp = jad_dq;
            jad_dq.jad_cp();
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String[] split = uri.getPath().split("/");
        if (split != null) {
            if (split.length < 2) {
                str3 = "";
            } else {
                str3 = split[1];
            }
            if (split.length < 3) {
                str4 = "";
            } else {
                str4 = split[2];
            }
            if (!TextUtils.isEmpty(str3)) {
                str3.getClass();
                char c = 65535;
                switch (str3.hashCode()) {
                    case 1297219447:
                        if (str3.equals("db_dynamic_render")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 1418758266:
                        if (str3.equals("db_preload_ad")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2080050073:
                        if (str3.equals("db_event")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        if (!TextUtils.isEmpty(str4)) {
                            str4.getClass();
                            if (str4.equals("query")) {
                                try {
                                    if (split.length < 4) {
                                        str5 = "";
                                    } else {
                                        str5 = split[3];
                                    }
                                    if (jad_an == null) {
                                        com.jd.ad.sdk.jad_hu.jad_bo jad_an2 = com.jd.ad.sdk.jad_hu.jad_bo.jad_an(com.jd.ad.sdk.jad_do.jad_bo.jad_an(), "jaddb.db", 2);
                                        jad_an = jad_an2;
                                        jad_an2.jad_cp();
                                    }
                                    List<com.jd.ad.sdk.jad_hu.jad_cp> jad_an3 = jad_an.jad_an(str5);
                                    MatrixCursor matrixCursor = new MatrixCursor(new String[]{"_id", "templateID", "templateUpdateTimeStamp", "templateJSON", "timeStampInterval"});
                                    ArrayList arrayList = (ArrayList) jad_an3;
                                    if (arrayList.size() > 0) {
                                        Iterator it = arrayList.iterator();
                                        while (it.hasNext()) {
                                            com.jd.ad.sdk.jad_hu.jad_cp jad_cpVar = (com.jd.ad.sdk.jad_hu.jad_cp) it.next();
                                            if (jad_cpVar != null) {
                                                matrixCursor.addRow(new Object[]{Integer.valueOf(jad_cpVar.jad_an), Integer.valueOf(jad_cpVar.jad_cp), jad_cpVar.jad_dq, jad_cpVar.jad_er, jad_cpVar.jad_fs});
                                            }
                                        }
                                    }
                                    return matrixCursor;
                                } catch (Exception e) {
                                    com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_QUERY_TEMPLATE_ERROR;
                                    jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
                                    break;
                                }
                            }
                        }
                        break;
                    case 1:
                        if (!TextUtils.isEmpty(str4)) {
                            str4.getClass();
                            if (str4.equals("query")) {
                                try {
                                    jad_bo();
                                    if (split.length < 4) {
                                        str6 = "";
                                    } else {
                                        str6 = split[3];
                                    }
                                    if (!TextUtils.isEmpty(str6)) {
                                        return jad_cp.jad_bo(str6);
                                    }
                                    return jad_cp.jad_er();
                                } catch (Exception e2) {
                                    com.jd.ad.sdk.jad_uh.jad_an jad_anVar2 = com.jd.ad.sdk.jad_uh.jad_an.MULTIPLE_PROCESS_PRELOAD_AD_QUERY_ERROR;
                                    jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(e2.getMessage()));
                                    return null;
                                }
                            }
                        }
                        break;
                    case 2:
                        if (!TextUtils.isEmpty(str4) && "query".equals(str4)) {
                            try {
                                if (split.length < 4) {
                                    str7 = "";
                                } else {
                                    str7 = split[3];
                                }
                                jad_an();
                                return jad_bo.jad_an(str7);
                            } catch (Exception e3) {
                                com.jd.ad.sdk.jad_uh.jad_an jad_anVar3 = com.jd.ad.sdk.jad_uh.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_QUERY_EVENT_ERROR;
                                jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(e3.getMessage()));
                                return null;
                            }
                        }
                        break;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        int i;
        String jad_an2 = com.jd.ad.sdk.jad_re.jad_an.jad_an(uri);
        if (!TextUtils.isEmpty(jad_an2)) {
            jad_an2.getClass();
            char c = 65535;
            switch (jad_an2.hashCode()) {
                case 1297219447:
                    if (jad_an2.equals("db_dynamic_render")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1418758266:
                    if (jad_an2.equals("db_preload_ad")) {
                        c = 1;
                        break;
                    }
                    break;
                case 2080050073:
                    if (jad_an2.equals("db_event")) {
                        c = 2;
                        break;
                    }
                    break;
                case 2144498451:
                    if (jad_an2.equals("sp_jadyunsdk")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (contentValues != null) {
                        try {
                            com.jd.ad.sdk.jad_hu.jad_cp jad_cpVar = new com.jd.ad.sdk.jad_hu.jad_cp(contentValues.getAsInteger("_id").intValue(), contentValues.getAsString("appIdPid"), contentValues.getAsInteger("templateID").intValue(), contentValues.getAsString("templateUpdateTimeStamp"), contentValues.getAsString("templateJSON"), contentValues.getAsString("timeStampInterval"));
                            if (jad_an == null) {
                                com.jd.ad.sdk.jad_hu.jad_bo jad_an3 = com.jd.ad.sdk.jad_hu.jad_bo.jad_an(com.jd.ad.sdk.jad_do.jad_bo.jad_an(), "jaddb.db", 2);
                                jad_an = jad_an3;
                                jad_an3.jad_cp();
                            }
                            com.jd.ad.sdk.jad_hu.jad_bo jad_boVar = jad_an;
                            if (jad_boVar != null) {
                                jad_boVar.jad_an(jad_cpVar);
                                break;
                            }
                        } catch (Exception e) {
                            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_UPDATE_TEMPLATE_ERROR;
                            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
                            break;
                        }
                    }
                    break;
                case 1:
                    if (contentValues != null) {
                        try {
                            jad_bo();
                            if (jad_cp != null) {
                                if (contentValues.containsKey("_id")) {
                                    i = contentValues.getAsInteger("_id").intValue();
                                } else {
                                    i = 0;
                                }
                                jad_cp.jad_an(new com.jd.ad.sdk.jad_kx.jad_cp(i, contentValues.getAsString("appIdSlotId"), contentValues.getAsString("rId"), ANEProxy.jb(contentValues.getAsString("preloadAdJson")), contentValues.getAsString("preloadAdCacheTimeStamp")));
                                break;
                            }
                        } catch (Exception e2) {
                            com.jd.ad.sdk.jad_uh.jad_an jad_anVar2 = com.jd.ad.sdk.jad_uh.jad_an.MULTIPLE_PROCESS_PRELOAD_AD_UPDATE_ERROR;
                            jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(e2.getMessage()));
                            break;
                        }
                    }
                    break;
                case 2:
                    if (contentValues != null) {
                        try {
                            String asString = contentValues.getAsString(NotificationCompat.CATEGORY_EVENT);
                            String asString2 = contentValues.getAsString(ContentProviderManager.PLUGIN_PROCESS_NAME);
                            int intValue = contentValues.getAsInteger("key").intValue();
                            if (!TextUtils.isEmpty(asString2) && !TextUtils.isEmpty(asString)) {
                                new JSONObject(asString);
                                jad_dq jad_dqVar = new jad_dq(intValue, asString);
                                jad_an();
                                jad_bo.jad_an(jad_dqVar, asString2);
                                break;
                            }
                        } catch (Exception e3) {
                            com.jd.ad.sdk.jad_uh.jad_an jad_anVar3 = com.jd.ad.sdk.jad_uh.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_UPDATE_EVENT_ERROR;
                            jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(e3.getMessage()));
                            break;
                        }
                    }
                    break;
                case 3:
                    insert(uri, contentValues);
                    break;
            }
        }
        return 0;
    }
}
