package com.baidu.tts;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelInfo;
import com.baidu.tts.k1;

/* loaded from: classes8.dex */
public final class h1 implements k1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ModelBags f10100a;

    public h1(ModelBags modelBags) {
        this.f10100a = modelBags;
    }

    @Override // com.baidu.tts.k1.a
    public boolean a(SQLiteDatabase sQLiteDatabase) {
        try {
            SQLiteStatement compileStatement = sQLiteDatabase.compileStatement("insert into speechModel (name, version_min, version_max, language, gender, speaker, domain, quality, text_data_id, speech_data_id, speech_ext_data_id, tac_subgan_speaker_attr, id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            for (ModelInfo modelInfo : this.f10100a.getModelInfos()) {
                String name = modelInfo.getName();
                String versionMin = modelInfo.getVersionMin();
                String versionMax = modelInfo.getVersionMax();
                String language = modelInfo.getLanguage();
                String gender = modelInfo.getGender();
                String speaker = modelInfo.getSpeaker();
                String domain = modelInfo.getDomain();
                String quality = modelInfo.getQuality();
                String textDataId = modelInfo.getTextDataId();
                String speechDataId = modelInfo.getSpeechDataId();
                String speechExtDataId = modelInfo.getSpeechExtDataId();
                String tacSubganSpeakerAttr = modelInfo.getTacSubganSpeakerAttr();
                String serverId = modelInfo.getServerId();
                compileStatement.bindString(1, name);
                compileStatement.bindString(2, versionMin);
                compileStatement.bindString(3, versionMax);
                compileStatement.bindString(4, language);
                compileStatement.bindString(5, gender);
                compileStatement.bindString(6, speaker);
                compileStatement.bindString(7, domain);
                compileStatement.bindString(8, quality);
                compileStatement.bindString(9, textDataId);
                compileStatement.bindString(10, speechDataId);
                compileStatement.bindString(11, speechExtDataId);
                compileStatement.bindString(12, tacSubganSpeakerAttr);
                compileStatement.bindString(13, serverId);
                compileStatement.executeInsert();
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
