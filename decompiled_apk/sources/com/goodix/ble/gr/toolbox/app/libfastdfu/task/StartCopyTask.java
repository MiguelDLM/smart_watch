package com.goodix.ble.gr.toolbox.app.libfastdfu.task;

import com.goodix.ble.gr.libdfu.dfu.entity.ImgInfo;
import com.goodix.ble.libble.v2.gb.procedure.GBGattProcedureWrite;
import com.goodix.ble.libcomx.event.EventDisposer;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.ITaskResult;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.util.HexBuilder;

/* loaded from: classes9.dex */
public class StartCopyTask extends Task implements IEventListener<ITaskResult> {
    private static final int d = 8;

    /* renamed from: a, reason: collision with root package name */
    private final FastDfuProfile f16138a;
    private final EventDisposer b = new EventDisposer();
    private final HexBuilder c;

    public StartCopyTask(FastDfuProfile fastDfuProfile, ImgInfo imgInfo, int i, int i2) {
        this.f16138a = fastDfuProfile;
        HexBuilder hexBuilder = new HexBuilder(imgInfo.getSerializeSize() + 13);
        this.c = hexBuilder;
        hexBuilder.put(1196379972, 4);
        hexBuilder.put(8, 1);
        imgInfo.serialize(hexBuilder);
        hexBuilder.put(i, 4);
        hexBuilder.put(i2, 4);
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        GBGattProcedureWrite writeByCommand = this.f16138a.getFdsCmd().writeByCommand(this.c.getBuffer(), false);
        writeByCommand.evtFinished().subEvent().setExecutor(getExecutor()).setDisposer(this.b).register2(this);
        writeByCommand.start(this, null);
        return 0;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        super.onCleanup();
        this.b.disposeAll(this);
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, ITaskResult iTaskResult) {
        finished(iTaskResult.getCode(), iTaskResult.getError());
    }
}
