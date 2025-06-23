package com.jieli.jl_filebrowse.interfaces;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_filebrowse.bean.FileChangeInfo;
import com.jieli.jl_filebrowse.bean.SDCardBean;
import java.util.List;

/* loaded from: classes10.dex */
public interface OnFileBrowseCallback {
    void OnFlayCallback(boolean z);

    void onBluetoothConnectionChange(BluetoothDevice bluetoothDevice, int i);

    void onFileDataReceive(byte[] bArr);

    void onFileReadFailed(int i);

    void onFileReadStart();

    void onFileReadStop(boolean z);

    void onFileStructureChange(FileChangeInfo fileChangeInfo);

    void onSdCardChange(List<SDCardBean> list);
}
