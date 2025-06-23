package com.jieli.jl_filebrowse.interfaces;

import com.jieli.jl_filebrowse.bean.PathData;

/* loaded from: classes10.dex */
public interface FileBrowseOperator {
    boolean dataHasPacket();

    void deleteFile(int i, byte b, int i2, boolean z, boolean z2, OperatCallback operatCallback);

    void formatDevice(int i, OperatCallback operatCallback);

    void sendPathDataCmd(PathData pathData, byte[] bArr, OperatCallback operatCallback);
}
