package com.iflytek.sparkchain.plugins.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.iflytek.sparkchain.core.Auth;
import java.util.regex.Pattern;

/* loaded from: classes10.dex */
public class Utils {
    private static final String REGEX_EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    public static final String TAG = "SparkChain";

    public static boolean checkContactsPermission() {
        int checkSelfPermission;
        if (Build.VERSION.SDK_INT < 23) {
            return ContextCompat.checkSelfPermission(Auth.d().a(), "android.permission.READ_CONTACTS") == 0;
        }
        checkSelfPermission = Auth.d().a().checkSelfPermission("android.permission.READ_CONTACTS");
        return checkSelfPermission == 0;
    }

    public static String getContactsEmail(String str) {
        if (!checkContactsPermission()) {
            Log.w(TAG, "No Contact Permission!");
            return str;
        }
        ContentResolver contentResolver = Auth.d().a().getContentResolver();
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        if (contentResolver == null) {
            return str;
        }
        Cursor query = contentResolver.query(uri, null, null, null, null);
        if (query.getCount() > 0) {
            String str2 = str;
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("_id"));
                String string2 = query.getString(query.getColumnIndex("display_name"));
                Log.d(TAG, "nickname: " + string2 + " name: " + str);
                if (str.equals(string2) && Integer.parseInt(query.getString(query.getColumnIndex("has_phone_number"))) > 0) {
                    Cursor query2 = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = ?", new String[]{string}, null);
                    while (query2.moveToNext()) {
                        Cursor query3 = contentResolver.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, "contact_id = ?", new String[]{string}, null);
                        if (query3.moveToNext()) {
                            for (int i = 0; i < query3.getCount(); i++) {
                                str2 = query3.getString(query3.getColumnIndex("data1"));
                                Log.d(TAG, "address:  " + str2);
                            }
                        }
                        query3.close();
                        if (!str2.isEmpty()) {
                            break;
                        }
                    }
                    query2.close();
                    if (!str2.isEmpty()) {
                        break;
                    }
                }
            }
            str = str2;
        }
        query.close();
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
    
        if (r1 != null) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getContactsPhone(java.lang.String r12) {
        /*
            com.iflytek.sparkchain.core.Auth r0 = com.iflytek.sparkchain.core.Auth.d()
            android.content.Context r0 = r0.a()
            r1 = 0
            android.content.ContentResolver r2 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            android.net.Uri r3 = android.provider.ContactsContract.Contacts.CONTENT_URI     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r3 = r12
        L18:
            boolean r4 = r2.moveToNext()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            if (r4 == 0) goto L7f
            java.lang.String r4 = "_id"
            int r4 = r2.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            java.lang.String r4 = r2.getString(r4)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            java.lang.String r5 = "display_name"
            int r5 = r2.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            java.lang.String r5 = r2.getString(r5)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            boolean r5 = r12.equalsIgnoreCase(r5)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            if (r5 == 0) goto L18
            java.lang.String r5 = "has_phone_number"
            int r5 = r2.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            int r5 = r2.getInt(r5)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            if (r5 <= 0) goto L18
            android.content.ContentResolver r6 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            android.net.Uri r7 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            r5.<init>()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            java.lang.String r8 = "contact_id="
            r5.append(r8)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            r5.append(r4)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            java.lang.String r9 = r5.toString()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            r10 = 0
            r11 = 0
            r8 = 0
            android.database.Cursor r1 = r6.query(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            boolean r4 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            if (r4 == 0) goto L18
        L68:
            java.lang.String r4 = "data1"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            java.lang.String r3 = r1.getString(r4)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            boolean r4 = r1.moveToNext()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            if (r4 != 0) goto L68
            goto L18
        L79:
            r12 = move-exception
            r0 = r1
            r1 = r2
            goto Lb9
        L7d:
            r12 = move-exception
            goto L88
        L7f:
            r2.close()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            r2.close()
            if (r1 == 0) goto Lb7
            goto Lb4
        L88:
            r0 = r1
            r1 = r2
            goto L92
        L8b:
            r12 = move-exception
            r0 = r1
            goto Lb9
        L8e:
            r0 = move-exception
            r3 = r12
            r12 = r0
            r0 = r1
        L92:
            java.lang.String r2 = "SparkChain"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb8
            r4.<init>()     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r12 = r12.getMessage()     // Catch: java.lang.Throwable -> Lb8
            r4.append(r12)     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r12 = " "
            r4.append(r12)     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r12 = r4.toString()     // Catch: java.lang.Throwable -> Lb8
            android.util.Log.e(r2, r12)     // Catch: java.lang.Throwable -> Lb8
            if (r1 == 0) goto Lb1
            r1.close()
        Lb1:
            if (r0 == 0) goto Lb7
            r1 = r0
        Lb4:
            r1.close()
        Lb7:
            return r3
        Lb8:
            r12 = move-exception
        Lb9:
            if (r1 == 0) goto Lbe
            r1.close()
        Lbe:
            if (r0 == 0) goto Lc3
            r0.close()
        Lc3:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sparkchain.plugins.utils.Utils.getContactsPhone(java.lang.String):java.lang.String");
    }

    public static boolean isEmail(String str) {
        return isMatch("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", str);
    }

    public static boolean isMatch(String str, CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0 && Pattern.matches(str, charSequence);
    }
}
