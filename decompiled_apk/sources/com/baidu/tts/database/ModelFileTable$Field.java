package com.baidu.tts.database;

/* loaded from: classes8.dex */
public enum ModelFileTable$Field {
    ID("id", "integer primary key"),
    LENGTH("length", "bigint"),
    MD5("md5", "varchar(32)"),
    NAME("name", "varchar(256) not null default unnamed"),
    ABS_PATH("absPath", "varchar");


    /* renamed from: a, reason: collision with root package name */
    public final String f10075a;
    public final String b;

    ModelFileTable$Field(String str, String str2) {
        this.f10075a = str;
        this.b = str2;
    }

    public String getColumnName() {
        return this.f10075a;
    }

    public String getDataType() {
        return this.b;
    }
}
