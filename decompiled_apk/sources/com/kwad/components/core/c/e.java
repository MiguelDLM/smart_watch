package com.kwad.components.core.c;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public class e implements i {
    private static volatile e JA;

    @Nullable
    private String JB;
    private int JC = 0;
    private int cacheSize = 1;
    private long JD = 1800;
    private boolean JE = false;

    private e() {
    }

    public static synchronized List<e> a(Cursor cursor) {
        synchronized (e.class) {
            if (cursor == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (cursor.moveToNext()) {
                try {
                    arrayList.add(b(cursor));
                } catch (Exception e) {
                    com.kwad.sdk.core.e.c.printStackTrace(e);
                }
            }
            return arrayList;
        }
    }

    public static e ak(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        long j = adTemplate.posId;
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        e eVar = new e(j);
        AdInfo.AdBaseInfo adBaseInfo = dS.adBaseInfo;
        eVar.JC = adBaseInfo.adCacheStrategy;
        eVar.JD = adBaseInfo.adCacheSecond;
        eVar.cacheSize = adBaseInfo.adCacheSize;
        boolean z = true;
        if (adBaseInfo.adCacheSwitch != 1) {
            z = false;
        }
        eVar.JE = z;
        return eVar;
    }

    private static synchronized e b(Cursor cursor) {
        e eVar;
        synchronized (e.class) {
            String string = cursor.getString(cursor.getColumnIndex("posId"));
            int i = cursor.getInt(cursor.getColumnIndex("strategyCode"));
            int i2 = cursor.getInt(cursor.getColumnIndex("cacheSize"));
            long j = cursor.getLong(cursor.getColumnIndex("cacheSecond"));
            boolean z = true;
            if (cursor.getInt(cursor.getColumnIndex("enable")) != 1) {
                z = false;
            }
            eVar = new e();
            eVar.JB = string;
            eVar.JC = i;
            eVar.cacheSize = i2;
            eVar.JD = j;
            eVar.JE = z;
        }
        return eVar;
    }

    @NonNull
    private static e mZ() {
        if (JA == null) {
            synchronized (e.class) {
                try {
                    if (JA == null) {
                        JA = new e();
                    }
                } finally {
                }
            }
        }
        return JA;
    }

    @NonNull
    @WorkerThread
    public static e s(long j) {
        e Y;
        if (a.mU() != null && (Y = a.mU().Y(String.valueOf(j))) != null) {
            return Y;
        }
        return mZ();
    }

    public final boolean isDefault() {
        return equals(mZ());
    }

    public final boolean isEnable() {
        return this.JE;
    }

    public final int na() {
        return this.JC;
    }

    public final int nb() {
        return this.cacheSize;
    }

    public final long nc() {
        return this.JD;
    }

    @Override // com.kwad.components.core.c.i
    public final ContentValues nd() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("posId", this.JB);
        contentValues.put("strategyCode", Integer.valueOf(this.JC));
        contentValues.put("cacheSize", Integer.valueOf(this.cacheSize));
        contentValues.put("cacheSecond", Long.valueOf(this.JD));
        contentValues.put("enable", Integer.valueOf(this.JE ? 1 : 0));
        return contentValues;
    }

    private e(long j) {
        this.JB = String.valueOf(j);
    }
}
