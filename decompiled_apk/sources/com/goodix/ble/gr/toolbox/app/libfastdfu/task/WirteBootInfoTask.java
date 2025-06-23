package com.goodix.ble.gr.toolbox.app.libfastdfu.task;

import com.goodix.ble.gr.libdfu.dfu.entity.ImgInfo;
import com.goodix.ble.libble.v2.gb.procedure.GBGattProcedureWrite;
import com.goodix.ble.libcomx.event.EventDisposer;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.ITaskResult;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.util.HexBuilder;

/* loaded from: classes9.dex */
public class WirteBootInfoTask extends Task implements IEventListener<ITaskResult> {
    private static final int d = 4;

    /* renamed from: a, reason: collision with root package name */
    private FastDfuProfile f16139a;
    private EventDisposer b = new EventDisposer();
    private HexBuilder c;

    public WirteBootInfoTask(FastDfuProfile fastDfuProfile, ImgInfo imgInfo) {
        this.f16139a = fastDfuProfile;
        HexBuilder hexBuilder = new HexBuilder(imgInfo.getSerializeSize() + 5);
        this.c = hexBuilder;
        hexBuilder.put(1196379972, 4);
        this.c.put(4, 1);
        imgInfo.serialize(this.c);
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        GBGattProcedureWrite writeByCommand = this.f16139a.getFdsCmd().writeByCommand(this.c.getBuffer(), false);
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
