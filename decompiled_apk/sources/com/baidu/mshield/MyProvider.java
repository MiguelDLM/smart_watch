package com.baidu.mshield;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class MyProvider extends ContentProvider {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f6362a = false;

    public static boolean a() {
        return f6362a;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        try {
            String callingPackage = getCallingPackage();
            if ((callingPackage != null && !callingPackage.equals(getContext().getPackageName())) || TextUtils.isEmpty(str)) {
                return null;
            }
            Bundle bundle2 = new Bundle();
            if ("init".equals(str)) {
                bundle2.putString("result", MH.init(getContext(), a(bundle)));
                bundle2.putBoolean("handle_flag", true);
            } else if ("gzfi".equals(str)) {
                bundle2.putString("result", MH.gzfi(getContext(), bundle.getString("accountId", ""), bundle.getInt("scene", 0), bundle.getString("para", ""), a(bundle.getBundle("property"))));
                bundle2.putBoolean("handle_flag", true);
            } else if ("getRemoteZid".equals(str)) {
                String a2 = com.baidu.mshield.utility.c.a(getContext());
                if (!TextUtils.isEmpty(a2)) {
                    bundle2.putString("_zid", a2);
                    bundle2.putBoolean("handle_flag", true);
                }
            } else if ("setAgreePolicy".equals(str)) {
                com.baidu.mshield.core.a.a(bundle.getBoolean("_agree_policy"));
            } else if ("ud".equals(str)) {
                MH.ud(getContext(), a(bundle));
            } else if ("setAppStatus".equals(str)) {
                com.baidu.mshield.core.a.b(bundle.getBoolean("_app_status"));
            } else if ("CallPreferences".equals(str)) {
                Bundle a3 = com.baidu.mshield.sharedpreferences.a.a(getContext()).a(bundle);
                if (a3 == null) {
                    a3 = new Bundle();
                }
                bundle2 = a3;
                bundle2.putBoolean("handle_flag", true);
            }
            bundle2.putString("server_version", "4.2.2");
            return bundle2;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        f6362a = true;
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public final HashMap<String, String> a(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            if (bundle.size() > 0) {
                for (String str : bundle.keySet()) {
                    hashMap.put(str, bundle.getString(str));
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        return hashMap;
    }
}
