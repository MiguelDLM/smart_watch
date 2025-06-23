package com.jieli.jl_rcsp.task;

import android.content.Context;
import android.net.Uri;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.task.TransferTask;
import com.jieli.jl_rcsp.util.JLFileIOUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes10.dex */
public class UriTransferTask extends TransferTask {
    public final Context g;
    public final String h;
    public final String i;

    public UriTransferTask(Context context, RcspOpImpl rcspOpImpl, String str, String str2, TransferTask.Param param) {
        super(rcspOpImpl, "", param);
        setPath(context.getExternalCacheDir() + File.separator + str2);
        this.h = str;
        this.i = str2;
        this.g = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        try {
            InputStream openInputStream = this.g.getContentResolver().openInputStream(Uri.parse(this.h));
            JLFileIOUtil.isToFile(getPath(), openInputStream);
            openInputStream.close();
            if (!isRun()) {
                super.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            onError(4097, "Failed to read file . uri = " + this.h);
        }
    }

    @Override // com.jieli.jl_rcsp.task.TransferTask
    public void release() {
        super.release();
        File file = new File(getPath());
        if (file.exists()) {
            file.delete();
        }
    }

    @Override // com.jieli.jl_rcsp.task.TransferTask, com.jieli.jl_rcsp.task.ITask
    public void start() {
        if (!new File(getPath()).exists()) {
            this.executor.execute(new Runnable() { // from class: com.jieli.jl_rcsp.task.xoIox
                @Override // java.lang.Runnable
                public final void run() {
                    UriTransferTask.this.l();
                }
            });
        } else {
            super.start();
        }
    }
}
