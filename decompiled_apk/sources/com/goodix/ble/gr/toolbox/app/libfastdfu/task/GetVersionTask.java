package com.goodix.ble.gr.toolbox.app.libfastdfu.task;

import com.goodix.ble.libcomx.event.EventDisposer;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.task.TaskParameter;
import com.goodix.ble.libcomx.util.HexBuilder;

/* loaded from: classes9.dex */
public class GetVersionTask extends Task implements IEventListener<byte[]> {
    private static final int c = 11;

    /* renamed from: a, reason: collision with root package name */
    @TaskParameter
    private FastDfuProfile f16137a;
    private final EventDisposer b = new EventDisposer();
    public int version = 1;

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        this.f16137a.getFdsCmd().evtNotify().subEvent().setExecutor(getExecutor()).setDisposer(this.b).register2(this);
        HexBuilder hexBuilder = new HexBuilder(5);
        hexBuilder.put(1196379972, 4);
        hexBuilder.put(11, 1);
        this.f16137a.getFdsCmd().writeByCommand(hexBuilder.getBuffer(), false).start(this, null);
        return 1000;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        super.onCleanup();
        this.b.disposeAll(this);
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onTaskExpired() {
        FastDfuProfile fastDfuProfile = this.f16137a;
        this.version = 1;
        fastDfuProfile.version = 1;
        finishedWithDone();
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, byte[] bArr) {
        if (bArr[0] == 11) {
            FastDfuProfile fastDfuProfile = this.f16137a;
            int i2 = bArr[1] & 255;
            this.version = i2;
            fastDfuProfile.version = i2;
            finishedWithDone();
        }
    }
}
