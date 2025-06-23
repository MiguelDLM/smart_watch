package com.goodix.ble.gr.libdfu.task.sub;

import com.goodix.ble.gr.libdfu.define.MemoryLayout;
import com.goodix.ble.gr.libdfu.dfu.entity.BootInfo;
import com.goodix.ble.gr.libdfu.dfu.entity.ImgInfo;
import java.util.List;

/* loaded from: classes9.dex */
public class GetCurrentBootInfoTask extends GetImgListTask {
    @Override // com.goodix.ble.gr.libdfu.task.sub.GetImgListTask, com.goodix.ble.libcomx.task.Task
    public int doWork() {
        this.targetMemory = MemoryLayout.BOOT_INFO;
        return super.doWork();
    }

    public BootInfo getBootInfo() {
        List<ImgInfo> list = getImgInfoList().getList();
        if (list != null && list.size() > 0) {
            return list.get(0).getBootInfo();
        }
        return new BootInfo();
    }
}
