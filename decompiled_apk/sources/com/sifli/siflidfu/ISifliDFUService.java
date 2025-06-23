package com.sifli.siflidfu;

import android.content.Context;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public interface ISifliDFUService {
    boolean isBusy();

    void startActionDFUNand(Context context, String str, ArrayList<DFUImagePath> arrayList, int i, int i2);

    void startActionDFUNor(Context context, String str, ArrayList<DFUImagePath> arrayList, int i, int i2);

    void startActionDFUNorExt(Context context, String str, ArrayList<DFUImagePath> arrayList, int i, int i2);
}
