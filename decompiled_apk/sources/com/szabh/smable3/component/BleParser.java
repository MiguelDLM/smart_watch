package com.szabh.smable3.component;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.ByteArrayExtKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes13.dex */
public final class BleParser implements x0o.oIX0oI {

    @OOXIXo
    private static final String LOG_HEADER = "BleParser";

    @OOXIXo
    public static final BleParser INSTANCE = new BleParser();

    @OOXIXo
    private static byte[] mData = new byte[0];
    private static int mReceived = -1;

    private BleParser() {
    }

    @Override // x0o.oIX0oI
    @oOoXoXO
    public byte[] onReceive(@OOXIXo byte[] data) {
        IIX0o.x0xO0oo(data, "data");
        try {
            if (mReceived == -1) {
                if (data[0] != -85) {
                    OI0.oIX0oI.f1507oIX0oI.XO("BleParser -> First packet data error : " + ByteArrayExtKt.getMHexString(data));
                    return null;
                }
                mData = new byte[ByteArrayExtKt.getInt$default(data, 2, 2, null, 4, null) + 6];
                mReceived = 0;
            }
            int i = mReceived;
            byte[] bArr = mData;
            if (i < bArr.length) {
                System.arraycopy(data, 0, bArr, i, data.length);
                mReceived += data.length;
                OI0.oIX0oI.f1507oIX0oI.XO("BleParser -> data length=" + mData.length + ", received=" + mReceived);
                int i2 = mReceived;
                byte[] bArr2 = mData;
                if (i2 >= bArr2.length) {
                    mReceived = -1;
                    return bArr2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            reset();
        }
        return null;
    }

    @Override // x0o.oIX0oI
    public void reset() {
        mData = new byte[0];
        mReceived = -1;
    }
}
