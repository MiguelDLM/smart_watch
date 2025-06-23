package xxOXOOoIX;

import O0IxXx.IXxxXO;
import O0IxXx.ooOOo0oXI;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes11.dex */
public class oIX0oI extends SQLiteOpenHelper implements I0Io {

    /* renamed from: XO, reason: collision with root package name */
    public static final String[] f35523XO = {"_id", "url", "length", "mime"};

    public oIX0oI(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        ooOOo0oXI.oIX0oI(context);
    }

    public final ContentValues I0Io(IXxxXO iXxxXO) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", iXxxXO.f1223oIX0oI);
        contentValues.put("length", Long.valueOf(iXxxXO.f1222II0xO0));
        contentValues.put("mime", iXxxXO.f1221I0Io);
        return contentValues;
    }

    public final IXxxXO II0xO0(Cursor cursor) {
        return new IXxxXO(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    @Override // xxOXOOoIX.I0Io
    public IXxxXO a(String str) {
        Throwable th;
        Cursor cursor;
        ooOOo0oXI.oIX0oI(str);
        IXxxXO iXxxXO = null;
        try {
            cursor = getReadableDatabase().query("SourceInfo", f35523XO, "url=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        iXxxXO = II0xO0(cursor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return iXxxXO;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // xxOXOOoIX.I0Io
    public void oIX0oI(String str, IXxxXO iXxxXO) {
        boolean z = false;
        ooOOo0oXI.X0o0xo(str, iXxxXO);
        if (a(str) != null) {
            z = true;
        }
        ContentValues I0Io2 = I0Io(iXxxXO);
        if (z) {
            getWritableDatabase().update("SourceInfo", I0Io2, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, I0Io2);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        ooOOo0oXI.oIX0oI(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }
}
