package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.Nullable;

/* loaded from: classes11.dex */
public final class p extends c {
    public static int Jr = 1;
    private static String aAg = "CREATE TABLE IF NOT EXISTS ksad_actions (actionId varchar(60) primary key, aLog TEXT)";

    public p(@Nullable Context context, int i) {
        super(context, "ksadrep.db", i, aAg);
    }
}
