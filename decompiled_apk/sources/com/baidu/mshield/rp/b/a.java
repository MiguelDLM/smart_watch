package com.baidu.mshield.rp.b;

import XXO0.oIX0oI;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import com.baidu.mapsdkplatform.comapi.f;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mshield.ac.F;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.kwad.sdk.m.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f6379a;
    public C0145a b;
    public SQLiteDatabase c;
    public Context d;

    /* renamed from: com.baidu.mshield.rp.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0145a extends SQLiteOpenHelper {
        public C0145a(a aVar, Context context) {
            super(context, "msre.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table if not exists r(a integer primary key autoincrement, b text, c integer, e integer,f integer,h text, g integer, i integer, j text, d long);");
            sQLiteDatabase.execSQL("create table if not exists c(a integer primary key autoincrement, b text); ");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    public a(Context context) {
        this.d = context;
        this.b = new C0145a(this, context);
        com.baidu.mshield.sharedpreferences.a.a(context);
        d();
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            try {
                if (f6379a == null) {
                    f6379a = new a(context);
                }
                aVar = f6379a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public boolean b(String str) {
        boolean z = true;
        Cursor cursor = null;
        try {
            try {
                cursor = this.c.query("c", null, "b=?", new String[]{str}, null, null, null);
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        z = false;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
            }
        } catch (Throwable th2) {
            try {
                com.baidu.mshield.utility.a.a(th2);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th3) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th4) {
                        com.baidu.mshield.utility.a.a(th4);
                    }
                }
                throw th3;
            }
        }
        return z;
    }

    public int c() {
        com.baidu.mshield.sharedpreferences.a a2 = com.baidu.mshield.sharedpreferences.a.a(this.d);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            return this.c.delete("r", "(d <= ? or (d < (" + currentTimeMillis + HelpFormatter.DEFAULT_OPT_PREFIX + f.f6163a + "*3600000) and " + f.f6163a + "!= 0)) and b != '1001001'and i != 5 ", new String[]{String.valueOf(currentTimeMillis - (a2.y() * 86400000))});
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return -1;
        }
    }

    public final void d() {
        try {
            this.c = this.b.getWritableDatabase();
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public List<com.baidu.mshield.rp.c.a> a() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = this.c.query("r", null, "i=5", null, null, null, "d desc", "100");
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        com.baidu.mshield.rp.c.a aVar = new com.baidu.mshield.rp.c.a();
                        aVar.f6380a = cursor.getInt(cursor.getColumnIndex("a"));
                        aVar.b = cursor.getString(cursor.getColumnIndex("b"));
                        aVar.c = cursor.getInt(cursor.getColumnIndex("c"));
                        aVar.e = cursor.getLong(cursor.getColumnIndex("d"));
                        aVar.f = cursor.getInt(cursor.getColumnIndex("g"));
                        aVar.g = cursor.getInt(cursor.getColumnIndex(e.TAG));
                        aVar.h = cursor.getInt(cursor.getColumnIndex(f.f6163a));
                        aVar.i = cursor.getInt(cursor.getColumnIndex("i"));
                        aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                        String string = cursor.getString(cursor.getColumnIndex(IAdInterListener.AdReqParam.HEIGHT));
                        try {
                            string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                        } catch (Exception e) {
                            com.baidu.mshield.utility.a.a(e);
                        }
                        aVar.d = string;
                        arrayList.add(aVar);
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                try {
                    com.baidu.mshield.utility.a.a(th);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th2) {
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable th3) {
                            com.baidu.mshield.utility.a.a(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            com.baidu.mshield.utility.a.a(th4);
        }
        return arrayList;
    }

    public List<com.baidu.mshield.rp.c.a> b(int i) {
        String str;
        Cursor cursor;
        Cursor query;
        ArrayList arrayList = new ArrayList();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.mshield.sharedpreferences.a a2 = com.baidu.mshield.sharedpreferences.a.a(this.d);
            int x = a2.x() * 3600000;
            if (i == 2) {
                str = "(d <= (" + currentTimeMillis + HelpFormatter.DEFAULT_OPT_PREFIX + e.TAG + "*3600000) or " + e.TAG + "=0 )";
            } else {
                str = "(d <= (" + currentTimeMillis + HelpFormatter.DEFAULT_OPT_PREFIX + e.TAG + "*3600000) or " + e.TAG + "=0 ) and (g!=2 or d<=" + (currentTimeMillis - x) + oIX0oI.I0Io.f4095I0Io;
            }
            String str2 = str;
            try {
                try {
                    if (i == 2) {
                        query = this.c.query("r", null, str2, null, null, null, "d desc", Integer.toString(100));
                    } else {
                        query = this.c.query("r", null, str2, null, null, null, "d desc", Integer.toString(a2.z()));
                    }
                    cursor = query;
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                com.baidu.mshield.rp.c.a aVar = new com.baidu.mshield.rp.c.a();
                                aVar.f6380a = cursor.getInt(cursor.getColumnIndex("a"));
                                aVar.b = cursor.getString(cursor.getColumnIndex("b"));
                                aVar.c = cursor.getInt(cursor.getColumnIndex("c"));
                                aVar.e = cursor.getLong(cursor.getColumnIndex("d"));
                                aVar.f = cursor.getInt(cursor.getColumnIndex("g"));
                                aVar.g = cursor.getInt(cursor.getColumnIndex(e.TAG));
                                aVar.h = cursor.getInt(cursor.getColumnIndex(f.f6163a));
                                aVar.i = cursor.getInt(cursor.getColumnIndex("i"));
                                aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                                String string = cursor.getString(cursor.getColumnIndex(IAdInterListener.AdReqParam.HEIGHT));
                                try {
                                    string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                                } catch (Exception e) {
                                    com.baidu.mshield.utility.a.a(e);
                                }
                                aVar.d = string;
                                arrayList.add(aVar);
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    com.baidu.mshield.utility.a.a(th);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return arrayList;
                                } finally {
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th3) {
                com.baidu.mshield.utility.a.a(th3);
            }
        } catch (Throwable th4) {
            com.baidu.mshield.utility.a.a(th4);
        }
        return arrayList;
    }

    public long a(com.baidu.mshield.rp.c.a aVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("b", aVar.b);
            contentValues.put("c", Integer.valueOf(aVar.c));
            contentValues.put("d", Long.valueOf(aVar.e));
            contentValues.put(e.TAG, Integer.valueOf(aVar.g));
            contentValues.put("g", Integer.valueOf(aVar.f));
            contentValues.put(f.f6163a, Integer.valueOf(aVar.h));
            contentValues.put("i", Integer.valueOf(aVar.i));
            contentValues.put("j", aVar.j);
            String str = aVar.d;
            try {
                str = Base64.encodeToString(F.getInstance().ae(str.getBytes(), "xVOTuxgN3lkRN2v4".getBytes("utf-8")), 0);
            } catch (Exception e) {
                com.baidu.mshield.utility.a.a(e);
            }
            contentValues.put(IAdInterListener.AdReqParam.HEIGHT, str);
            try {
                return this.c.insert("r", null, contentValues);
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
                return -1L;
            }
        } catch (Throwable th2) {
            com.baidu.mshield.utility.a.a(th2);
        }
    }

    public long a(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("b", str);
        try {
            return this.c.insert("c", null, contentValues);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return -1L;
        }
    }

    public int b() {
        Cursor cursor = null;
        int i = 0;
        try {
            try {
                cursor = this.c.query("r", null, null, null, null, null, null, null);
                if (cursor != null) {
                    i = cursor.getCount();
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
            }
        } catch (Throwable th2) {
            try {
                com.baidu.mshield.utility.a.a(th2);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th3) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th4) {
                        com.baidu.mshield.utility.a.a(th4);
                    }
                }
                throw th3;
            }
        }
        return i;
    }

    public int a(int i) {
        try {
            return this.c.delete("r", "a=?", new String[]{i + ""});
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return -1;
        }
    }

    public int a(List<Integer> list) {
        int i = -1;
        try {
            this.c.beginTransaction();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                i = a(it.next().intValue());
                if (i <= 0) {
                    com.baidu.mshield.rp.e.a.f6383a = System.currentTimeMillis();
                }
            }
            this.c.setTransactionSuccessful();
            try {
                this.c.endTransaction();
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
                com.baidu.mshield.rp.e.a.f6383a = System.currentTimeMillis();
            }
        } catch (Throwable th2) {
            try {
                com.baidu.mshield.utility.a.a(th2);
                com.baidu.mshield.rp.e.a.f6383a = System.currentTimeMillis();
            } finally {
                try {
                    this.c.endTransaction();
                } catch (Throwable th3) {
                    com.baidu.mshield.utility.a.a(th3);
                    com.baidu.mshield.rp.e.a.f6383a = System.currentTimeMillis();
                }
            }
        }
        return i;
    }

    public List<com.baidu.mshield.rp.c.a> a(boolean z, int i) {
        String str;
        Cursor cursor;
        Cursor query;
        ArrayList arrayList = new ArrayList();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (z) {
                str = "(d < (" + currentTimeMillis + HelpFormatter.DEFAULT_OPT_PREFIX + f.f6163a + "*3600000) and " + f.f6163a + "!= 0)";
            } else {
                str = "d<=" + (currentTimeMillis - 259200000);
            }
            String str2 = str;
            try {
                try {
                    if (i == 2) {
                        query = this.c.query("r", null, str2, null, null, null, "d desc", "100");
                    } else {
                        int z2 = com.baidu.mshield.sharedpreferences.a.a(this.d).z();
                        com.baidu.mshield.b.c.a.b("sj-trigger report 3g limit" + Integer.toString(z2));
                        query = this.c.query("r", null, str2, null, null, null, "d desc", Integer.toString(z2));
                    }
                    cursor = query;
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                com.baidu.mshield.rp.c.a aVar = new com.baidu.mshield.rp.c.a();
                                aVar.f6380a = cursor.getInt(cursor.getColumnIndex("a"));
                                aVar.b = cursor.getString(cursor.getColumnIndex("b"));
                                aVar.c = cursor.getInt(cursor.getColumnIndex("c"));
                                aVar.e = cursor.getLong(cursor.getColumnIndex("d"));
                                aVar.f = cursor.getInt(cursor.getColumnIndex("g"));
                                aVar.g = cursor.getInt(cursor.getColumnIndex(e.TAG));
                                aVar.h = cursor.getInt(cursor.getColumnIndex(f.f6163a));
                                aVar.i = cursor.getInt(cursor.getColumnIndex("i"));
                                aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                                String string = cursor.getString(cursor.getColumnIndex(IAdInterListener.AdReqParam.HEIGHT));
                                try {
                                    string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                                } catch (Exception e) {
                                    com.baidu.mshield.utility.a.a(e);
                                }
                                aVar.d = string;
                                arrayList.add(aVar);
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    com.baidu.mshield.utility.a.a(th);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return arrayList;
                                } finally {
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th3) {
                com.baidu.mshield.utility.a.a(th3);
            }
        } catch (Throwable th4) {
            com.baidu.mshield.utility.a.a(th4);
        }
        return arrayList;
    }
}
