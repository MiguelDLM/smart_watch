package com.baidu.tts;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.client.model.ModelFileInfo;
import com.baidu.tts.k1;

/* loaded from: classes8.dex */
public final class g1 implements k1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ModelFileBags f10094a;

    public g1(ModelFileBags modelFileBags) {
        this.f10094a = modelFileBags;
    }

    @Override // com.baidu.tts.k1.a
    public boolean a(SQLiteDatabase sQLiteDatabase) {
        try {
            SQLiteStatement compileStatement = sQLiteDatabase.compileStatement("insert into modelFile (id, length, md5, name, absPath) values (?, ?, ?, ?, ?)");
            for (ModelFileInfo modelFileInfo : this.f10094a.getModelFileInfos()) {
                String serverid = modelFileInfo.getServerid();
                String length = modelFileInfo.getLength();
                String md5 = modelFileInfo.getMd5();
                String name = modelFileInfo.getName();
                String absPath = modelFileInfo.getAbsPath();
                compileStatement.bindString(1, serverid);
                compileStatement.bindString(2, length);
                compileStatement.bindString(3, md5);
                compileStatement.bindString(4, name);
                compileStatement.bindString(5, absPath);
                compileStatement.executeInsert();
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
