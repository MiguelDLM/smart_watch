package com.kwad.sdk.core.report;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public abstract class d implements l<e> {
    private static boolean ayK = false;
    protected c ayL;

    public d(c cVar) {
        a(cVar);
    }

    private void a(c cVar) {
        this.ayL = cVar;
    }

    private synchronized void c(e eVar) {
        if (ayK) {
            Log.d(getTag(), "deleteAction action = " + eVar);
        }
        try {
            this.ayL.getReadableDatabase().delete(Fq(), "actionId=?", new String[]{eVar.actionId});
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }

    public abstract String Fq();

    public abstract String Fr();

    @Override // com.kwad.sdk.core.report.l
    public final synchronized List<e> Fs() {
        Cursor cursor = null;
        try {
            try {
                String Fr = Fr();
                if (!TextUtils.isEmpty(Fr)) {
                    cursor = this.ayL.getReadableDatabase().rawQuery(Fr, null);
                }
                if (cursor != null) {
                    ArrayList<e> arrayList = new ArrayList();
                    while (cursor.moveToNext()) {
                        try {
                            arrayList.add(g(cursor));
                        } catch (Exception e) {
                            com.kwad.sdk.core.e.c.printStackTrace(e);
                        }
                    }
                    if (ayK) {
                        Log.d(getTag(), "read size= " + arrayList.size());
                        for (e eVar : arrayList) {
                            Log.d(getTag(), "read action=" + eVar);
                        }
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return arrayList;
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.e.c.printStackTrace(e2);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return new ArrayList();
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            throw th;
        }
    }

    @Override // com.kwad.sdk.core.report.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final synchronized void j(e eVar) {
        ContentValues contentValues;
        if (ayK) {
            Log.d(getTag(), "write = " + eVar);
        }
        try {
            contentValues = new ContentValues();
            contentValues.put("actionId", eVar.actionId);
            contentValues.put("aLog", eVar.toJson().toString());
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
        try {
            this.ayL.getReadableDatabase().insert(Fq(), null, contentValues);
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
        }
    }

    public abstract e g(@NonNull Cursor cursor);

    public abstract String getTag();

    @Override // com.kwad.sdk.core.report.l
    public final synchronized long size() {
        long j;
        Cursor cursor = null;
        try {
            try {
                cursor = this.ayL.getReadableDatabase().rawQuery("select count(*) from " + Fq(), null);
                cursor.moveToFirst();
                j = cursor.getLong(0);
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                j = 0;
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
        return j;
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized void x(List<e> list) {
        if (ayK) {
            Log.d(getTag(), "delete size= " + list.size());
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.ayL.getReadableDatabase();
                sQLiteDatabase.beginTransaction();
                Iterator<e> it = list.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
                sQLiteDatabase.setTransactionSuccessful();
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e) {
                    com.kwad.sdk.core.e.c.printStackTrace(e);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.e.c.printStackTrace(e2);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e3) {
                        com.kwad.sdk.core.e.c.printStackTrace(e3);
                    }
                }
            }
        } finally {
        }
    }
}
