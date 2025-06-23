package xoX;

import XxXX.X0o0xo;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes13.dex */
public class ooOOo0oXI extends SQLiteOpenHelper {

    /* renamed from: Oo, reason: collision with root package name */
    public static ooOOo0oXI f35114Oo;

    /* renamed from: XO, reason: collision with root package name */
    public static final String[] f35115XO = {"key"};

    public ooOOo0oXI(Context context) {
        super(context, "sdk_report.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    public static synchronized ooOOo0oXI II0xO0() {
        ooOOo0oXI ooooo0oxi;
        synchronized (ooOOo0oXI.class) {
            try {
                if (f35114Oo == null) {
                    f35114Oo = new ooOOo0oXI(X0o0xo.oIX0oI());
                }
                ooooo0oxi = f35114Oo;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ooooo0oxi;
    }

    public synchronized void I0Io(String str, List<Serializable> list) {
        ObjectOutputStream objectOutputStream;
        int size = list.size();
        if (size == 0) {
            return;
        }
        if (size > 20) {
            size = 20;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        oxoX(str);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return;
        }
        try {
            writableDatabase.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                for (int i = 0; i < size; i++) {
                    Serializable serializable = list.get(i);
                    if (serializable != null) {
                        contentValues.put("type", str);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
                        ObjectOutputStream objectOutputStream2 = null;
                        try {
                            try {
                                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                            } catch (IOException unused) {
                            }
                            try {
                                objectOutputStream.writeObject(serializable);
                                objectOutputStream.close();
                            } catch (IOException unused2) {
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                byteArrayOutputStream.close();
                            } catch (Throwable th) {
                                th = th;
                                objectOutputStream2 = objectOutputStream;
                                if (objectOutputStream2 != null) {
                                    try {
                                        objectOutputStream2.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (IOException unused4) {
                                    throw th;
                                }
                            }
                        } catch (IOException unused5) {
                            objectOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException unused6) {
                            contentValues.put("blob", byteArrayOutputStream.toByteArray());
                            writableDatabase.insert("via_cgi_report", null, contentValues);
                        }
                    }
                    contentValues.clear();
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Exception unused7) {
                xx0.xxIXOIIO.II0XooXoX("openSDK_LOG.ReportDatabaseHelper", "saveReportItemToDB has exception.");
                writableDatabase.endTransaction();
            }
            writableDatabase.close();
        } catch (Throwable th3) {
            writableDatabase.endTransaction();
            writableDatabase.close();
            throw th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0083 A[Catch: all -> 0x0057, Exception -> 0x005a, TRY_ENTER, TryCatch #13 {Exception -> 0x005a, all -> 0x0057, blocks: (B:22:0x0030, B:24:0x0036, B:25:0x0039, B:31:0x0053, B:33:0x005d, B:35:0x0083, B:36:0x0086, B:67:0x006f, B:60:0x0072, B:61:0x0075, B:53:0x0078, B:48:0x007b), top: B:21:0x0030 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.List<java.io.Serializable> oIX0oI(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L92
            r0.<init>()     // Catch: java.lang.Throwable -> L92
            java.util.List r0 = java.util.Collections.synchronizedList(r0)     // Catch: java.lang.Throwable -> L92
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L92
            if (r1 == 0) goto L12
            monitor-exit(r11)
            return r0
        L12:
            android.database.sqlite.SQLiteDatabase r1 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L92
            if (r1 != 0) goto L1a
            monitor-exit(r11)
            return r0
        L1a:
            r10 = 0
            java.lang.String r3 = "via_cgi_report"
            java.lang.String r5 = "type = ?"
            java.lang.String[] r6 = new java.lang.String[]{r12}     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            r8 = 0
            r9 = 0
            r4 = 0
            r7 = 0
            r2 = r1
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            if (r12 == 0) goto L8c
            int r2 = r12.getCount()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            if (r2 <= 0) goto L8c
            r12.moveToFirst()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
        L39:
            java.lang.String r2 = "blob"
            int r2 = r12.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            byte[] r2 = r12.getBlob(r2)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.Object r4 = r2.readObject()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L66
            java.io.Serializable r4 = (java.io.Serializable) r4     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L66
            r2.close()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a java.io.IOException -> L5d
            goto L5d
        L57:
            r0 = move-exception
            r10 = r12
            goto Laa
        L5a:
            r2 = move-exception
            r10 = r12
            goto L9b
        L5d:
            r3.close()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a java.io.IOException -> L61
            goto L81
        L61:
            goto L81
        L63:
            r4 = move-exception
            r10 = r2
            goto L6d
        L66:
            goto L76
        L68:
            r4 = move-exception
            goto L6d
        L6a:
            r2 = r10
            goto L76
        L6d:
            if (r10 == 0) goto L72
            r10.close()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a java.io.IOException -> L72
        L72:
            r3.close()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a java.io.IOException -> L75
        L75:
            throw r4     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
        L76:
            if (r2 == 0) goto L7b
            r2.close()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a java.io.IOException -> L7b
        L7b:
            r3.close()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a java.io.IOException -> L7f
            goto L80
        L7f:
        L80:
            r4 = r10
        L81:
            if (r4 == 0) goto L86
            r0.add(r4)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
        L86:
            boolean r2 = r12.moveToNext()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            if (r2 != 0) goto L39
        L8c:
            if (r12 == 0) goto L94
            r12.close()     // Catch: java.lang.Throwable -> L92
            goto L94
        L92:
            r12 = move-exception
            goto Lb3
        L94:
            r1.close()     // Catch: java.lang.Throwable -> L92
            goto La8
        L98:
            r0 = move-exception
            goto Laa
        L9a:
            r2 = move-exception
        L9b:
            java.lang.String r12 = "openSDK_LOG.ReportDatabaseHelper"
            java.lang.String r3 = "getReportItemFromDB has exception."
            xx0.xxIXOIIO.xxIXOIIO(r12, r3, r2)     // Catch: java.lang.Throwable -> L98
            if (r10 == 0) goto L94
            r10.close()     // Catch: java.lang.Throwable -> L92
            goto L94
        La8:
            monitor-exit(r11)
            return r0
        Laa:
            if (r10 == 0) goto Laf
            r10.close()     // Catch: java.lang.Throwable -> L92
        Laf:
            r1.close()     // Catch: java.lang.Throwable -> L92
            throw r0     // Catch: java.lang.Throwable -> L92
        Lb3:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L92
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: xoX.ooOOo0oXI.oIX0oI(java.lang.String):java.util.List");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
        onCreate(sQLiteDatabase);
    }

    public synchronized void oxoX(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            if (writableDatabase == null) {
                return;
            }
            try {
                writableDatabase.delete("via_cgi_report", "type = ?", new String[]{str});
            } catch (Exception e) {
                xx0.xxIXOIIO.xxIXOIIO("openSDK_LOG.ReportDatabaseHelper", "clearReportItem has exception.", e);
            }
        } finally {
            writableDatabase.close();
        }
    }
}
