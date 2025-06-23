package androidx.work.impl;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.WorkDatabase;

public final /* synthetic */ class II0XooXoX implements SupportSQLiteOpenHelper.Factory {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ Context f514oIX0oI;

    public /* synthetic */ II0XooXoX(Context context) {
        this.f514oIX0oI = context;
    }

    public final SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return WorkDatabase.Companion.create$lambda$0(this.f514oIX0oI, configuration);
    }
}
