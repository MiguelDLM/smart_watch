package com.kwad.framework.filedownloader.b;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.kwad.framework.filedownloader.b.a;
import com.kwad.framework.filedownloader.f.f;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class d implements com.kwad.framework.filedownloader.b.a {
    private static boolean agn = false;
    private final e ago = new e(com.kwad.framework.filedownloader.f.c.xp());
    private SQLiteDatabase agp;

    /* loaded from: classes11.dex */
    public class a implements a.InterfaceC0824a {
        private final SparseArray<com.kwad.framework.filedownloader.d.c> agd;
        private final SparseArray<List<com.kwad.framework.filedownloader.d.a>> age;
        private final SparseArray<com.kwad.framework.filedownloader.d.c> agq = new SparseArray<>();
        private b agr;

        public a(SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray, SparseArray<List<com.kwad.framework.filedownloader.d.a>> sparseArray2) {
            this.agd = sparseArray;
            this.age = sparseArray2;
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0824a
        public final void a(int i, com.kwad.framework.filedownloader.d.c cVar) {
            this.agq.put(i, cVar);
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0824a
        public final void c(com.kwad.framework.filedownloader.d.c cVar) {
            SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray = this.agd;
            if (sparseArray != null) {
                synchronized (sparseArray) {
                    this.agd.put(cVar.getId(), cVar);
                }
            }
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwad.framework.filedownloader.d.c> iterator() {
            b bVar = new b();
            this.agr = bVar;
            return bVar;
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0824a
        public final void vK() {
            b bVar = this.agr;
            if (bVar != null) {
                bVar.vK();
            }
            try {
                SQLiteDatabase vL = d.this.vL();
                if (vL == null) {
                    return;
                }
                int size = this.agq.size();
                try {
                    if (size < 0) {
                        return;
                    }
                    try {
                        vL.beginTransaction();
                        for (int i = 0; i < size; i++) {
                            int keyAt = this.agq.keyAt(i);
                            com.kwad.framework.filedownloader.d.c cVar = this.agq.get(keyAt);
                            vL.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(keyAt)});
                            vL.insert("ksad_file_download", null, cVar.wN());
                            if (cVar.wS() > 1) {
                                List<com.kwad.framework.filedownloader.d.a> bl = d.this.bl(keyAt);
                                if (bl.size() > 0) {
                                    vL.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(keyAt)});
                                    for (com.kwad.framework.filedownloader.d.a aVar : bl) {
                                        aVar.setId(cVar.getId());
                                        vL.insert("ksad_file_download_connection", null, aVar.wN());
                                    }
                                }
                            }
                        }
                        SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray = this.agd;
                        if (sparseArray != null && this.age != null) {
                            synchronized (sparseArray) {
                                try {
                                    int size2 = this.agd.size();
                                    for (int i2 = 0; i2 < size2; i2++) {
                                        int id = this.agd.valueAt(i2).getId();
                                        List<com.kwad.framework.filedownloader.d.a> bl2 = d.this.bl(id);
                                        if (bl2 != null && bl2.size() > 0) {
                                            synchronized (this.age) {
                                                this.age.put(id, bl2);
                                            }
                                        }
                                    }
                                } finally {
                                }
                            }
                        }
                        vL.setTransactionSuccessful();
                        try {
                            vL.endTransaction();
                        } catch (Exception e) {
                            d.printStackTrace(e);
                        }
                    } catch (SQLiteException e2) {
                        d.this.a(e2);
                        try {
                            vL.endTransaction();
                        } catch (Exception e3) {
                            d.printStackTrace(e3);
                        }
                    } catch (Exception e4) {
                        d.printStackTrace(e4);
                        try {
                            vL.endTransaction();
                        } catch (Exception e5) {
                            d.printStackTrace(e5);
                        }
                    }
                } finally {
                    try {
                        vL.endTransaction();
                    } catch (Exception e6) {
                        d.printStackTrace(e6);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements Iterator<com.kwad.framework.filedownloader.d.c> {
        private Cursor agt;
        private final List<Integer> agu = new ArrayList();
        private int agv;

        public b() {
            try {
                this.agt = d.this.vL().rawQuery("SELECT * FROM ksad_file_download", null);
            } catch (SQLiteException e) {
                d.this.a(e);
            } catch (Exception e2) {
                d.printStackTrace(e2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Iterator
        /* renamed from: vM, reason: merged with bridge method [inline-methods] */
        public com.kwad.framework.filedownloader.d.c next() {
            com.kwad.framework.filedownloader.d.c d = d.d(this.agt);
            this.agv = d.getId();
            return d;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            try {
                Cursor cursor = this.agt;
                if (cursor == null) {
                    return false;
                }
                return cursor.moveToNext();
            } catch (Throwable th) {
                d.printStackTrace(th);
                return false;
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.agu.add(Integer.valueOf(this.agv));
        }

        public final void vK() {
            Cursor cursor = this.agt;
            if (cursor == null) {
                return;
            }
            cursor.close();
            if (!this.agu.isEmpty()) {
                String join = TextUtils.join(", ", this.agu);
                if (com.kwad.framework.filedownloader.f.d.ajb) {
                    com.kwad.framework.filedownloader.f.d.c(this, "delete %s", join);
                }
                try {
                    SQLiteDatabase vL = d.this.vL();
                    vL.execSQL(f.b("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", "_id", join));
                    vL.execSQL(f.b("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", join));
                } catch (SQLiteException e) {
                    d.this.a(e);
                } catch (Exception e2) {
                    d.printStackTrace(e2);
                }
            }
        }
    }

    private void d(com.kwad.framework.filedownloader.d.c cVar) {
        try {
            vL().insert("ksad_file_download", null, cVar.wN());
        } catch (SQLiteException e) {
            cVar.br(e.toString());
            cVar.d((byte) -1);
            a(cVar.getId(), e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    private static void h(Throwable th) {
        if (th != null) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printStackTrace(Throwable th) {
        h(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SQLiteDatabase vL() {
        if (this.agp == null) {
            this.agp = this.ago.getWritableDatabase();
        }
        return this.agp;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
            return;
        }
        if (bk(cVar.getId()) != null) {
            try {
                vL().update("ksad_file_download", cVar.wN(), "_id = ? ", new String[]{String.valueOf(cVar.getId())});
                return;
            } catch (SQLiteException e) {
                cVar.br(e.toString());
                cVar.d((byte) -1);
                a(cVar.getId(), e);
                return;
            } catch (Exception e2) {
                printStackTrace(e2);
                return;
            }
        }
        d(cVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bj(int i) {
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0033: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:52), block:B:28:0x0033 */
    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bk(int i) {
        Cursor cursor;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                try {
                    try {
                        cursor = vL().rawQuery(f.b("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", "_id"), new String[]{Integer.toString(i)});
                    } catch (SQLiteException e) {
                        e = e;
                        cursor = null;
                        a(i, e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable2 = closeable;
                    com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                    throw th;
                }
            } catch (SQLiteException e2) {
                e = e2;
            }
            try {
                if (cursor.moveToNext()) {
                    com.kwad.framework.filedownloader.d.c d = d(cursor);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return d;
                }
            } catch (SQLiteException e3) {
                e = e3;
                a(i, e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return null;
            } catch (Exception e4) {
                e = e4;
                printStackTrace(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return null;
            }
        } catch (Exception e5) {
            e = e5;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        return null;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    @SuppressLint({"Range"})
    public final List<com.kwad.framework.filedownloader.d.a> bl(int i) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = vL().rawQuery(f.b("SELECT * FROM %s WHERE %s = ?", "ksad_file_download_connection", "id"), new String[]{Integer.toString(i)});
                while (cursor.moveToNext()) {
                    com.kwad.framework.filedownloader.d.a aVar = new com.kwad.framework.filedownloader.d.a();
                    aVar.setId(i);
                    aVar.setIndex(cursor.getInt(cursor.getColumnIndex("connectionIndex")));
                    aVar.setStartOffset(cursor.getLong(cursor.getColumnIndex("startOffset")));
                    aVar.Q(cursor.getLong(cursor.getColumnIndex("currentOffset")));
                    aVar.R(cursor.getLong(cursor.getColumnIndex("endOffset")));
                    arrayList.add(aVar);
                }
            } catch (SQLiteException e) {
                a(i, e);
            } catch (Exception e2) {
                printStackTrace(e2);
            }
            return arrayList;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bm(int i) {
        try {
            vL().execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i);
        } catch (SQLiteException e) {
            printStackTrace(e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bn(int i) {
        try {
            if (vL().delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i)}) == 0) {
                return false;
            }
            return true;
        } catch (SQLiteException e) {
            printStackTrace(e);
            return false;
        } catch (Exception e2) {
            printStackTrace(e2);
            return false;
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bo(int i) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i, long j) {
        bn(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        try {
            vL().delete("ksad_file_download", null, null);
        } catch (SQLiteException e) {
            a(e);
        }
        try {
            vL().delete("ksad_file_download_connection", null, null);
        } catch (SQLiteException e2) {
            a(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void s(int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i2));
        try {
            vL().update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0824a vJ() {
        return new a(null, null);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        if (aVar != null) {
            try {
                vL().insert("ksad_file_download_connection", null, aVar.wN());
            } catch (SQLiteException e) {
                a(aVar.getId(), e);
            } catch (Exception e2) {
                printStackTrace(e2);
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, int i2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j));
        try {
            vL().update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) -2);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Range"})
    public static com.kwad.framework.filedownloader.d.c d(Cursor cursor) {
        com.kwad.framework.filedownloader.d.c cVar = new com.kwad.framework.filedownloader.d.c();
        if (cursor == null) {
            return cVar;
        }
        cVar.setId(cursor.getInt(cursor.getColumnIndex("_id")));
        cVar.setUrl(cursor.getString(cursor.getColumnIndex("url")));
        cVar.d(cursor.getString(cursor.getColumnIndex("path")), cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) == 1);
        cVar.d((byte) cursor.getShort(cursor.getColumnIndex("status")));
        cVar.S(cursor.getLong(cursor.getColumnIndex("sofar")));
        cVar.U(cursor.getLong(cursor.getColumnIndex("total")));
        cVar.br(cursor.getString(cursor.getColumnIndex("errMsg")));
        cVar.bq(cursor.getString(cursor.getColumnIndex("etag")));
        cVar.bs(cursor.getString(cursor.getColumnIndex("filename")));
        cVar.bD(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return cVar;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 3);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, String str, long j, long j2, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j));
        contentValues.put("total", Long.valueOf(j2));
        contentValues.put("etag", str);
        contentValues.put("connectionCount", Integer.valueOf(i2));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 2);
        contentValues.put("total", Long.valueOf(j));
        contentValues.put("etag", str);
        contentValues.put("filename", str2);
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) -1);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) 5);
        a(i, contentValues);
    }

    public final a.InterfaceC0824a a(SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray, SparseArray<List<com.kwad.framework.filedownloader.d.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }

    private void a(int i, ContentValues contentValues) {
        try {
            vL().update("ksad_file_download", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SQLiteException sQLiteException) {
        a(-1, sQLiteException);
    }

    private void a(int i, @Nullable SQLiteException sQLiteException) {
        if (sQLiteException instanceof SQLiteFullException) {
            if (i != -1) {
                bn(i);
                bm(i);
            }
            h(sQLiteException);
            agn = true;
            return;
        }
        printStackTrace(sQLiteException);
    }
}
