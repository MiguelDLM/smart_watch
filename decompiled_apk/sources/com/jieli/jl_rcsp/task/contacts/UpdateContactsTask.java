package com.jieli.jl_rcsp.task.contacts;

import android.content.Context;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.task.ITask;
import com.jieli.jl_rcsp.task.TaskBase;
import java.io.File;
import java.util.List;

/* loaded from: classes10.dex */
public class UpdateContactsTask extends TaskBase {
    public final String b;
    public final List<DeviceContacts> c;
    public ITask d;

    public UpdateContactsTask(RcspOpImpl rcspOpImpl, String str, List<DeviceContacts> list) throws RuntimeException {
        super(rcspOpImpl);
        if (list != null) {
            this.b = str;
            this.c = list;
            return;
        }
        throw new RuntimeException("contacts can not be null.");
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void cancel(byte b) {
        if (!isRun()) {
            return;
        }
        ITask iTask = this.d;
        if (iTask == null) {
            callbackCancel(b);
        } else {
            iTask.cancel(b);
        }
    }

    @Override // com.jieli.jl_rcsp.task.TaskBase, com.jieli.jl_rcsp.task.ITask
    public boolean isRun() {
        ITask iTask = this.d;
        if (iTask == null) {
            return super.isRun();
        }
        return iTask.isRun();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // com.jieli.jl_rcsp.task.ITask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void start() {
        /*
            r5 = this;
            boolean r0 = r5.isRun()
            if (r0 == 0) goto L10
            java.lang.String r0 = r5.tag
            java.lang.String r1 = "start"
            java.lang.String r2 = "Task is in progress."
            com.jieli.jl_rcsp.util.JL_Log.w(r0, r1, r2)
            return
        L10:
            com.jieli.jl_rcsp.impl.RcspOpImpl r0 = r5.mRcspOp
            com.jieli.jl_rcsp.model.device.DeviceInfo r0 = r0.getDeviceInfo()
            if (r0 != 0) goto L1e
            r0 = 8192(0x2000, float:1.148E-41)
            r5.callbackError(r0)
            return
        L1e:
            boolean r0 = r0.isContactsTransferBySmallFile()
            if (r0 == 0) goto L31
            com.jieli.jl_rcsp.task.contacts.UpdateContactsBySmallFileTask r0 = new com.jieli.jl_rcsp.task.contacts.UpdateContactsBySmallFileTask
            com.jieli.jl_rcsp.impl.RcspOpImpl r1 = r5.mRcspOp
            java.util.List<com.jieli.jl_rcsp.task.contacts.DeviceContacts> r2 = r5.c
            r0.<init>(r1, r2)
            r5.d = r0
            goto Lb1
        L31:
            com.jieli.jl_filebrowse.bean.SDCardBean r0 = com.jieli.jl_filebrowse.util.DeviceChoseUtil.getTargetDevFlash2First()
            if (r0 != 0) goto L3d
            r0 = 16384(0x4000, float:2.2959E-41)
            r5.callbackError(r0)
            return
        L3d:
            com.jieli.jl_rcsp.task.TransferTask$Param r1 = new com.jieli.jl_rcsp.task.TransferTask$Param
            r1.<init>()
            int r2 = r0.getDevHandler()
            r1.devHandler = r2
            int r0 = r0.getType()
            r2 = 2
            if (r0 != r2) goto L51
            r0 = 1
            goto L52
        L51:
            r0 = 0
        L52:
            r1.useFlash = r0
            r0 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L88 java.io.IOException -> L8a
            java.lang.String r3 = r5.b     // Catch: java.lang.Throwable -> L88 java.io.IOException -> L8a
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L88 java.io.IOException -> L8a
            java.util.List<com.jieli.jl_rcsp.task.contacts.DeviceContacts> r0 = r5.c     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            byte[] r0 = com.jieli.jl_rcsp.task.contacts.DeviceContacts.toData(r0)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            int r3 = r0.length     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            if (r3 != 0) goto L6e
            r0 = 20
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            goto L6e
        L6a:
            r0 = move-exception
            goto L82
        L6c:
            r0 = move-exception
            goto L85
        L6e:
            r2.write(r0)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            com.jieli.jl_rcsp.task.CallTransferTask r0 = new com.jieli.jl_rcsp.task.CallTransferTask     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            com.jieli.jl_rcsp.impl.RcspOpImpl r3 = r5.mRcspOp     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            java.lang.String r4 = r5.b     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            r0.<init>(r3, r4, r1)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            r5.d = r0     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6c
            r2.close()     // Catch: java.io.IOException -> L80
            goto Lb1
        L80:
            r0 = move-exception
            goto Lae
        L82:
            r1 = r0
            r0 = r2
            goto Lc0
        L85:
            r1 = r0
            r0 = r2
            goto L8b
        L88:
            r1 = move-exception
            goto Lc0
        L8a:
            r1 = move-exception
        L8b:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L88
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L88
            r2.<init>()     // Catch: java.lang.Throwable -> L88
            java.lang.String r3 = "IO Exception = "
            r2.append(r3)     // Catch: java.lang.Throwable -> L88
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L88
            r2.append(r1)     // Catch: java.lang.Throwable -> L88
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L88
            r2 = 16389(0x4005, float:2.2966E-41)
            r5.callbackError(r2, r1)     // Catch: java.lang.Throwable -> L88
            if (r0 == 0) goto Lb1
            r0.close()     // Catch: java.io.IOException -> L80
            goto Lb1
        Lae:
            r0.printStackTrace()
        Lb1:
            com.jieli.jl_rcsp.task.ITask r0 = r5.d
            if (r0 == 0) goto Lbf
            com.jieli.jl_rcsp.task.TaskListener r1 = r5.listener
            r0.setListener(r1)
            com.jieli.jl_rcsp.task.ITask r0 = r5.d
            r0.start()
        Lbf:
            return
        Lc0:
            if (r0 == 0) goto Lca
            r0.close()     // Catch: java.io.IOException -> Lc6
            goto Lca
        Lc6:
            r0 = move-exception
            r0.printStackTrace()
        Lca:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_rcsp.task.contacts.UpdateContactsTask.start():void");
    }

    @Deprecated
    public UpdateContactsTask(RcspOpImpl rcspOpImpl, Context context, List<DeviceContacts> list) throws RuntimeException {
        super(rcspOpImpl);
        if (list != null) {
            if (context == null) {
                this.b = null;
            } else {
                this.b = context.getExternalCacheDir() + File.separator + "CALL.TXT";
            }
            this.c = list;
            return;
        }
        throw new RuntimeException("contacts can not be null.");
    }
}
