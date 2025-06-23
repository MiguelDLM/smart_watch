package com.baidu.tts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.tts.database.FsFileInfoTable;
import com.baidu.tts.database.ModelFileTable$Field;
import com.baidu.tts.database.SpeechModelTable$Field;
import com.baidu.tts.tools.SqlTool;

/* loaded from: classes8.dex */
public class f1 extends SQLiteOpenHelper {
    public f1(Context context) {
        this(context, "ttsModel.db", null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(SqlTool.sqlCreateTable("speechModel", SpeechModelTable$Field.values()));
        sQLiteDatabase.execSQL(SqlTool.sqlCreateTable("modelFile", ModelFileTable$Field.values()));
        sQLiteDatabase.execSQL(SqlTool.sqlCreateTable("fsFileInfo", FsFileInfoTable.Field.values()));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(SqlTool.sqlDropTable("speechModel"));
        sQLiteDatabase.execSQL(SqlTool.sqlDropTable("modelFile"));
        sQLiteDatabase.execSQL(SqlTool.sqlDropTable("fsFileInfo"));
        onCreate(sQLiteDatabase);
    }

    public f1(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
    }
}
