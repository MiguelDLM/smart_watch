package com.ss.android.socialbase.downloader.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.b.c;
import com.ss.android.socialbase.downloader.downloader.t;
import com.ss.android.socialbase.downloader.f.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;

/* loaded from: classes13.dex */
public class e extends c.a implements t {
    private static volatile SQLiteDatabase b;

    /* renamed from: a, reason: collision with root package name */
    b f26215a;
    private g c;
    private g d;
    private g e;
    private volatile boolean f;

    public e() {
        this(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (b == null) {
            synchronized (e.class) {
                try {
                    if (b == null) {
                        b = a.a().getWritableDatabase();
                        this.c = new g(b, "downloader", com.ss.android.socialbase.downloader.constants.c.f26239a, com.ss.android.socialbase.downloader.constants.c.b);
                        this.d = new g(b, "downloadChunk", com.ss.android.socialbase.downloader.constants.c.c, com.ss.android.socialbase.downloader.constants.c.d);
                        this.e = new g(b, "segments", com.ss.android.socialbase.downloader.constants.c.e, com.ss.android.socialbase.downloader.constants.c.f);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                } finally {
                }
            }
        }
    }

    private void i() {
        b.beginTransaction();
    }

    private void j() {
        try {
            if (b == null || !b.inTransaction()) {
                return;
            }
            b.endTransaction();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k() {
        try {
            i();
            b.delete("downloader", null, null);
            b.delete("downloadChunk", null, null);
            b.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> b() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> c(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> d(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean e() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean f(final int i) {
        com.ss.android.socialbase.downloader.downloader.c.c(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.11
            @Override // java.lang.Runnable
            public void run() {
                e.this.e(i);
                e.this.d(i);
                e.this.m(i);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo g(int i) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public Map<Long, i> l(int i) {
        Cursor cursor;
        String str;
        h();
        if (b != null) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                cursor = b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "segments", "_id"), new String[]{Integer.toString(i)});
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.i.f.a(cursor);
                    return null;
                } catch (Throwable th3) {
                    com.ss.android.socialbase.downloader.i.f.a(cursor);
                    throw th3;
                }
            }
            try {
                if (cursor.moveToNext()) {
                    int columnIndex = cursor.getColumnIndex("info");
                    if (columnIndex >= 0) {
                        str = cursor.getString(columnIndex);
                    } else {
                        str = null;
                    }
                    HashMap hashMap = new HashMap();
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        i iVar = new i(jSONArray.getJSONObject(i2));
                        hashMap.put(Long.valueOf(iVar.c()), iVar);
                    }
                    com.ss.android.socialbase.downloader.i.f.a(cursor);
                    return hashMap;
                }
                com.ss.android.socialbase.downloader.i.f.a(cursor);
            } catch (Throwable th4) {
                th = th4;
                th.printStackTrace();
                com.ss.android.socialbase.downloader.i.f.a(cursor);
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void m(int i) {
        h();
        if (b == null) {
            return;
        }
        try {
            a(i, this.e.b());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public e(boolean z) {
        this.f26215a = null;
        if (z) {
            this.f = false;
            a();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> b(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean e(int i) {
        g gVar;
        h();
        if (b != null && (gVar = this.c) != null) {
            try {
                a(i, gVar.b());
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo i(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<com.ss.android.socialbase.downloader.model.b> c(int i) {
        ArrayList arrayList = new ArrayList();
        h();
        if (b != null) {
            Cursor cursor = null;
            try {
                cursor = b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", "_id"), new String[]{Integer.toString(i)});
                while (cursor.moveToNext()) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.b(cursor));
                }
                com.ss.android.socialbase.downloader.i.f.a(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.i.f.a(cursor);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.i.f.a(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void d(final int i) {
        h();
        if (b == null || this.d == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.c(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.a(i, e.this.d.b());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo j(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-7));
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo b(int i) {
        Cursor cursor;
        h();
        if (b != null) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                cursor = b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "_id"), new String[]{Integer.toString(i)});
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.i.f.a(cursor);
                    return null;
                } catch (Throwable th3) {
                    com.ss.android.socialbase.downloader.i.f.a(cursor);
                    throw th3;
                }
            }
            try {
                if (cursor.moveToNext()) {
                    DownloadInfo downloadInfo = new DownloadInfo(cursor);
                    com.ss.android.socialbase.downloader.i.f.a(cursor);
                    return downloadInfo;
                }
                com.ss.android.socialbase.downloader.i.f.a(cursor);
            } catch (Throwable th4) {
                th = th4;
                th.printStackTrace();
                com.ss.android.socialbase.downloader.i.f.a(cursor);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        try {
            if (!a(downloadInfo.getId())) {
                c(downloadInfo);
            } else {
                g gVar = this.c;
                if (gVar == null) {
                    return;
                }
                try {
                    b(downloadInfo, gVar.c());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } finally {
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo e(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-4));
        contentValues.put("curBytes", Long.valueOf(j));
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public ArrayList<i> n(int i) {
        Map<Long, i> l = l(i);
        if (l == null || l.isEmpty()) {
            return null;
        }
        return new ArrayList<>(l.values());
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo h(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 5);
        contentValues.put("isFirstDownload", (Integer) 0);
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a() {
        a(new SparseArray<>(), new SparseArray<>(), (d) null);
    }

    private void c(final DownloadInfo downloadInfo) {
        h();
        if (b == null || this.c == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.c(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e eVar = e.this;
                    eVar.a(downloadInfo, eVar.c.a());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void a(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2, final d dVar) {
        try {
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.1
                /* JADX WARN: Code restructure failed: missing block: B:140:0x027f, code lost:
                
                    if (r0 == null) goto L86;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:146:0x0288, code lost:
                
                    if (r0 == null) goto L86;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:185:0x0344, code lost:
                
                    if (r0 == null) goto L170;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:186:0x0346, code lost:
                
                    r0.a();
                    r18.d.f = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:187:0x034e, code lost:
                
                    r18.d.a(r2, r3);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:188:0x0360, code lost:
                
                    throw r0;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:194:0x035d, code lost:
                
                    if (r0 == null) goto L170;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:89:0x01aa, code lost:
                
                    if (r0 != null) goto L85;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:90:0x01ac, code lost:
                
                    r0.a();
                    r18.d.f = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:91:0x01b4, code lost:
                
                    r18.d.a(r2, r3);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:92:0x028c, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:98:0x01c4, code lost:
                
                    if (r0 == null) goto L86;
                 */
                /* JADX WARN: Removed duplicated region for block: B:34:0x00de A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:47:0x00ce A[SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 891
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.b.e.AnonymousClass1.run():void");
                }
            };
            ExecutorService r = com.ss.android.socialbase.downloader.downloader.c.r();
            if (r != null) {
                r.execute(runnable);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo d(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-2));
        contentValues.put("curBytes", Long.valueOf(j));
        a(i, contentValues);
        return null;
    }

    private void b(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.bindLong(downloadInfo.getBindValueCount() + 1, downloadInfo.getId());
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void c() {
        h();
        if (b == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.c(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.k();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        try {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    com.ss.android.socialbase.downloader.i.f.b(downloadInfo);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean d() {
        return this.f;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo c(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-3));
        contentValues.put("curBytes", Long.valueOf(j));
        contentValues.put("isFirstDownload", (Integer) 0);
        contentValues.put("isFirstSuccess", (Integer) 0);
        a(i, contentValues);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || b == null) {
            return;
        }
        synchronized (b) {
            try {
                i();
                if (!list.isEmpty()) {
                    if (com.ss.android.socialbase.downloader.g.a.c().a("clear_invalid_task_error")) {
                        String[] strArr = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            strArr[i] = String.valueOf(list.get(i));
                        }
                        String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                        b.delete("downloader", str, strArr);
                        b.delete("downloadChunk", str, strArr);
                    } else {
                        String join = TextUtils.join(", ", list2);
                        b.delete("downloader", "_id IN (?)", new String[]{join});
                        b.delete("downloadChunk", "_id IN (?)", new String[]{join});
                    }
                }
                for (int i2 = 0; i2 < size; i2++) {
                    int keyAt = sparseArray.keyAt(i2);
                    DownloadInfo downloadInfo = sparseArray.get(keyAt);
                    b.delete("downloader", "_id = ?", new String[]{String.valueOf(keyAt)});
                    b.insert("downloader", null, downloadInfo.toContentValues());
                    if (downloadInfo.getChunkCount() > 1) {
                        List<com.ss.android.socialbase.downloader.model.b> c = c(keyAt);
                        if (c.size() > 0) {
                            b.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(keyAt)});
                            for (com.ss.android.socialbase.downloader.model.b bVar : c) {
                                bVar.b(downloadInfo.getId());
                                b.insert("downloadChunk", null, bVar.a());
                            }
                        }
                    }
                }
                if (sparseArray2 != null && sparseArray3 != null) {
                    int size2 = sparseArray2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        int id = sparseArray2.valueAt(i3).getId();
                        List<com.ss.android.socialbase.downloader.model.b> a2 = com.ss.android.socialbase.downloader.i.f.a(c(id));
                        if (a2 != null && a2.size() > 0) {
                            sparseArray3.put(id, a2);
                        }
                    }
                }
                b.setTransactionSuccessful();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo b(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        contentValues.put("curBytes", Long.valueOf(j));
        if (j > 0) {
            contentValues.put("isFirstDownload", (Integer) 0);
        }
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        try {
            d(i);
            if (list != null) {
                for (com.ss.android.socialbase.downloader.model.b bVar : list) {
                    if (bVar != null) {
                        a(bVar);
                        if (bVar.f()) {
                            Iterator<com.ss.android.socialbase.downloader.model.b> it = bVar.g().iterator();
                            while (it.hasNext()) {
                                a(it.next());
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, ContentValues contentValues) {
        int i2 = 10;
        while (b.isDbLockedByCurrentThread() && i2 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        try {
            b.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean a(int i) {
        try {
            return b(i) != null;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> a(String str) {
        h();
        ArrayList arrayList = new ArrayList();
        if (b != null) {
            Cursor cursor = null;
            try {
                cursor = b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "url"), new String[]{str});
                if (cursor.moveToNext()) {
                    arrayList.add(new DownloadInfo(cursor));
                }
                com.ss.android.socialbase.downloader.i.f.a(cursor);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    com.ss.android.socialbase.downloader.i.f.a(cursor);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.i.f.a(cursor);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i);
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(final com.ss.android.socialbase.downloader.model.b bVar) {
        h();
        if (b == null || this.d == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.c(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.a(bVar, e.this.d.a());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.ss.android.socialbase.downloader.model.b bVar, SQLiteStatement sQLiteStatement) {
        if (bVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                bVar.a(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(final int i, final int i2, final long j) {
        h();
        if (i == 0 || i2 < 0 || j < 0 || b == null || this.d == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.c(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.a(i, i2, j, e.this.d.c());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(final int i, final int i2, final int i3, final long j) {
        h();
        if (i == 0 || i2 < 0 || i3 < 0 || j < 0 || b == null || this.d == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.c(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.a(i, i2, i3, j, e.this.d.c());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(final int i, final int i2, final int i3, final int i4) {
        h();
        if (i == 0 || i3 < 0 || i4 == i2 || i4 < 0 || b == null || this.d == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.c(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.a(i, i2, i3, i4, e.this.d.c());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("chunkIndex", Integer.valueOf(i4));
                b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i, int i2) {
        h();
        if (b == null) {
            return null;
        }
        int i3 = 10;
        while (b.isDbLockedByCurrentThread() && i3 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("chunkCount", Integer.valueOf(i2));
        b.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean a(final DownloadInfo downloadInfo) {
        h();
        if (downloadInfo == null || b == null) {
            return false;
        }
        com.ss.android.socialbase.downloader.downloader.c.c(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.10
            @Override // java.lang.Runnable
            public void run() {
                e.this.d(downloadInfo);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 3);
        contentValues.put("totalBytes", Long.valueOf(j));
        contentValues.put("eTag", str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("name", str2);
        }
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        contentValues.put("curBytes", Long.valueOf(j));
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean a(int i, Map<Long, i> map) {
        long currentTimeMillis = System.currentTimeMillis();
        h();
        if (b == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Long l : map.keySet()) {
                l.longValue();
                jSONArray.put(map.get(l).k());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Log.d("SqlDownloadCache", "json=" + jSONArray);
        SQLiteStatement d = this.e.d();
        synchronized (d) {
            d.clearBindings();
            d.bindLong(1, i);
            d.bindString(2, jSONArray.toString());
            d.execute();
        }
        com.ss.android.socialbase.downloader.c.a.b("SqlDownloadCache", "updateSegments cost=" + com.ss.android.socialbase.downloader.i.f.c(currentTimeMillis));
        return false;
    }

    private void a(final int i, final ContentValues contentValues) {
        h();
        if (b == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.c(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.b(i, contentValues);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(b bVar) {
        this.f26215a = bVar;
    }

    public void a(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2) {
        try {
            HashMap a2 = com.ss.android.socialbase.downloader.i.f.a(sparseArray);
            HashMap a3 = com.ss.android.socialbase.downloader.i.f.a(sparseArray2);
            b bVar = this.f26215a;
            if (bVar != null) {
                bVar.a(a2, a3);
            }
        } catch (Throwable unused) {
        }
    }
}
