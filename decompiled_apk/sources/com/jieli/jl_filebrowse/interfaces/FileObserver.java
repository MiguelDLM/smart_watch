package com.jieli.jl_filebrowse.interfaces;

import com.jieli.jl_filebrowse.bean.FileStruct;
import com.jieli.jl_filebrowse.bean.SDCardBean;
import java.util.List;

/* loaded from: classes10.dex */
public interface FileObserver {
    void OnFlayCallback(boolean z);

    void onFileReadFailed(int i);

    void onFileReadStart();

    void onFileReadStop(boolean z);

    void onFileReceiver(List<FileStruct> list);

    void onSdCardStatusChange(List<SDCardBean> list);
}
