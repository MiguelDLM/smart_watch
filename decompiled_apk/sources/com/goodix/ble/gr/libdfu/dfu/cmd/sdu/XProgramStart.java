package com.goodix.ble.gr.libdfu.dfu.cmd.sdu;

import com.goodix.ble.gr.libdfu.dfu.entity.ImgInfo;
import com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx;
import com.goodix.ble.libcomx.util.HexBuilder;

/* loaded from: classes9.dex */
public class XProgramStart implements IFrameSdu4Tx {
    private static final int f = 1;
    private static final int g = 4;
    private static final int h = 4;

    /* renamed from: a, reason: collision with root package name */
    private boolean f16083a;
    private boolean b = false;
    private ImgInfo c;
    private int d;
    private int e;

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public int getSduSize() {
        if (this.b) {
            return 9;
        }
        ImgInfo imgInfo = this.c;
        if (imgInfo == null) {
            return 1;
        }
        return imgInfo.getSerializeSize() + 1;
    }

    public void programExtFlash(int i, int i2) {
        programResourceToFlash(true, i, i2);
    }

    public void programInnerFlash(ImgInfo imgInfo) {
        this.b = false;
        this.f16083a = false;
        this.c = imgInfo;
    }

    public void programResourceToFlash(boolean z, int i, int i2) {
        this.b = true;
        this.f16083a = z;
        this.d = i;
        this.e = i2;
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public void serialize(HexBuilder hexBuilder) {
        if (this.b) {
            hexBuilder.put(this.f16083a ? 1 : 0, 1);
            hexBuilder.put(this.d, 4);
            hexBuilder.put(this.e, 4);
        } else {
            hexBuilder.put(0, 1);
            ImgInfo imgInfo = this.c;
            if (imgInfo != null) {
                imgInfo.serialize(hexBuilder);
            }
        }
    }
}
