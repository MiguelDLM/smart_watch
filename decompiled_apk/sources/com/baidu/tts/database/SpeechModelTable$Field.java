package com.baidu.tts.database;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.tts.emstatistics.TtsStatsUploadBag;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;

/* loaded from: classes8.dex */
public enum SpeechModelTable$Field {
    ID("id", "integer primary key"),
    TEXT_DATA_ID("text_data_id", TypedValues.Custom.S_INT),
    SPEECH_DATA_ID("speech_data_id", TypedValues.Custom.S_INT),
    SPEECH_EXT_DATA_ID("speech_ext_data_id", TypedValues.Custom.S_INT),
    TAC_SUBGAN_SPEAKER_ATTR("tac_subgan_speaker_attr", "varchar(256)"),
    NAME("name", "varchar(256) not null default unnamed"),
    VERSION_MIN("version_min", TypedValues.Custom.S_INT),
    VERSION_MAX("version_max", TypedValues.Custom.S_INT),
    LANGUAGE("language", "varchar(20)"),
    GENDER("gender", "varchar(20)"),
    SPEAKER(TtsStatsUploadBag.KEY_SPEAKER, "varchar(256)"),
    DOMAIN(ClientCookie.DOMAIN_ATTR, "varchar(50)"),
    QUALITY("quality", "varchar(50)");


    /* renamed from: a, reason: collision with root package name */
    public final String f10076a;
    public final String b;

    SpeechModelTable$Field(String str, String str2) {
        this.f10076a = str;
        this.b = str2;
    }

    public String getColumnName() {
        return this.f10076a;
    }

    public String getDataType() {
        return this.b;
    }
}
