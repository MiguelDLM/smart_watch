package com.baidu.ar.remoteres;

import com.baidu.ar.DuMixController;
import java.io.File;

/* loaded from: classes7.dex */
public interface IDuMixResProcessor {
    String getBusinessTag();

    boolean isLoaded();

    boolean isReady(File file, File file2);

    boolean load(DuMixController duMixController, File file, File file2);

    void setUseLocalLib();
}
