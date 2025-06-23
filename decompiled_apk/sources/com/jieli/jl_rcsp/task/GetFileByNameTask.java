package com.jieli.jl_rcsp.task;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.model.command.file_op.ReadFileFromDeviceCmd;

/* loaded from: classes10.dex */
public class GetFileByNameTask extends GetFileTask {
    public final Param n;

    /* loaded from: classes10.dex */
    public static class Param {

        /* renamed from: a, reason: collision with root package name */
        public String f17935a;
        public boolean b;
        public int c;
        public int devHandler;
        public String name;

        public Param(int i, String str, String str2) {
            this(i, str, str2, false);
        }

        public Param(int i, String str, String str2, boolean z) {
            this.devHandler = i;
            this.name = str;
            this.f17935a = str2;
            this.b = z;
        }
    }

    public GetFileByNameTask(RcspOpImpl rcspOpImpl, Param param) throws RuntimeException {
        super(rcspOpImpl, a(param));
        this.n = param;
    }

    public static String a(Param param) throws RuntimeException {
        if (param != null) {
            return param.f17935a;
        }
        throw new RuntimeException("GetFileByNameTask.Param can not be null");
    }

    @Override // com.jieli.jl_rcsp.task.GetFileTask
    public ReadFileFromDeviceCmd.Param createParam(BluetoothDevice bluetoothDevice) {
        if (this.mRcspOp.getDeviceInfo(bluetoothDevice) != null && !this.mRcspOp.getDeviceInfo(bluetoothDevice).isGetFileByNameWithDev()) {
            this.useCrc = false;
            int i = this.n.c;
            Param param = this.n;
            return new ReadFileFromDeviceCmd.StartWithNameParam(i, param.name, param.b);
        }
        Param param2 = this.n;
        int i2 = param2.devHandler;
        if (i2 != -1) {
            int i3 = param2.c;
            Param param3 = this.n;
            return new ReadFileFromDeviceCmd.StartWithDevAndNameParam(i2, i3, param3.name, param3.b);
        }
        throw new RuntimeException("please set devHandler");
    }

    public void setName(String str) {
        Param param = this.n;
        if (param != null) {
            param.name = str;
        }
    }
}
