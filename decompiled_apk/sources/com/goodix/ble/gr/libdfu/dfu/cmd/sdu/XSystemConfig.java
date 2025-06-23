package com.goodix.ble.gr.libdfu.dfu.cmd.sdu;

import com.goodix.ble.gr.libdfu.dfu.entity.ImgInfo;
import com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx;
import com.goodix.ble.libcomx.util.HexBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public class XSystemConfig implements IFrameSdu4Tx {

    /* renamed from: a, reason: collision with root package name */
    private static final int f16086a = 1;
    private static final int b = 4;
    private static final int c = 2;
    public int address;
    public List<ImgInfo> imgInfos = new ArrayList();
    public int length;
    public boolean opUdate;

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public int getSduSize() {
        if (!this.opUdate) {
            return 7;
        }
        this.length = 0;
        Iterator<ImgInfo> it = this.imgInfos.iterator();
        while (it.hasNext()) {
            this.length += it.next().getSerializeSize();
        }
        return this.length + 7;
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public void serialize(HexBuilder hexBuilder) {
        hexBuilder.put(this.opUdate ? 1 : 0, 1);
        hexBuilder.put(this.address, 4);
        hexBuilder.put(this.length, 2);
        if (this.opUdate) {
            for (ImgInfo imgInfo : this.imgInfos) {
                if (hexBuilder.getRemainSize() >= imgInfo.getSerializeSize()) {
                    imgInfo.serialize(hexBuilder);
                } else {
                    return;
                }
            }
        }
    }
}
