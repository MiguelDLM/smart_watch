package com.kwad.sdk.crash.online.monitor.block.report;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.report.d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class a extends d {
    public static int Jr = 1;
    private static volatile a aIc;

    private a(Context context) {
        super(new com.kwad.sdk.crash.online.monitor.block.a.a(context, Jr));
    }

    public static a bJ(Context context) {
        if (aIc == null) {
            synchronized (a.class) {
                try {
                    if (aIc == null) {
                        aIc = new a(context);
                    }
                } finally {
                }
            }
        }
        return aIc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.d
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public synchronized BlockReportAction g(@NonNull Cursor cursor) {
        try {
        } catch (JSONException e) {
            c.printStackTrace(e);
            return new BlockReportAction("");
        }
        return new BlockReportAction(new JSONObject(cursor.getString(0)));
    }

    @Override // com.kwad.sdk.core.report.d
    public final String Fq() {
        return "ksad_block_actions";
    }

    @Override // com.kwad.sdk.core.report.d
    public final String Fr() {
        return "select aLog from " + Fq();
    }

    @Override // com.kwad.sdk.core.report.d
    public final String getTag() {
        return "perfMonitor.BlockReportDBManager";
    }
}
