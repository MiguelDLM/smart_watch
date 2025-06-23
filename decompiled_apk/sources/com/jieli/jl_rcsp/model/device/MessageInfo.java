package com.jieli.jl_rcsp.model.device;

import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class MessageInfo {
    public static final int LIMIT_PACKAGE = 240;
    public static final int LIMIT_PACKAGE_NAME = 31;
    public static final int LIMIT_TITLE = 36;
    public static final int LIMIT_TOTAL_LEN = 512;
    private final byte[] appPackageName;
    private final byte[] content;
    private final int flag;
    private final byte[] timestamp;
    private final byte[] title;

    public MessageInfo(String str, int i, String str2, String str3, long j) {
        this.appPackageName = RcspUtil.getData(str, 31);
        this.flag = i;
        this.title = RcspUtil.getData(str2, 36);
        this.content = RcspUtil.getData(str3, 424);
        this.timestamp = CHexConver.intToBigBytes(RcspUtil.time2Int(j));
    }

    public byte[] beanToData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(RcspUtil.packLTVPacket2(0, this.timestamp));
            byteArrayOutputStream.write(RcspUtil.packLTVPacket2(1, this.appPackageName));
            byteArrayOutputStream.write(RcspUtil.packLTVPacket2(2, new byte[]{(byte) this.flag}));
            byte[] bArr = this.title;
            if (bArr != null) {
                byteArrayOutputStream.write(RcspUtil.packLTVPacket2(3, bArr));
            }
            byte[] bArr2 = this.content;
            if (bArr2 != null) {
                byteArrayOutputStream.write(RcspUtil.packLTVPacket2(4, bArr2));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] getAppPackageName() {
        return this.appPackageName;
    }

    public byte[] getContent() {
        return this.content;
    }

    public int getFlag() {
        return this.flag;
    }

    public byte[] getTimestamp() {
        return this.timestamp;
    }

    public byte[] getTitle() {
        return this.title;
    }
}
