package com.jieli.jl_rcsp.model.parameter;

import android.text.TextUtils;
import com.jieli.jl_rcsp.model.command.nfc.NFCOperationCmd;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.io.ByteArrayOutputStream;

/* loaded from: classes10.dex */
public class ModifyNfcMsgParam extends NFCOperationCmd.ModifyMsgParam {
    private final String nickName;
    private final long updateTime;

    public ModifyNfcMsgParam(int i, short s, long j, String str) {
        super(i, s, getMask(j, str), getMaskData(j, str));
        this.updateTime = j;
        this.nickName = new String(RcspUtil.getData(str, 24));
    }

    private static int getMask(long j, String str) {
        int i;
        if (j > 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (!TextUtils.isEmpty(str)) {
            return i | 2;
        }
        return i;
    }

    private static byte[] getMaskData(long j, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (j > 0) {
            try {
                byteArrayOutputStream.write(CHexConver.intToBigBytes(RcspUtil.time2Int(j)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str)) {
            byte[] bArr = new byte[24];
            System.arraycopy(str.getBytes(), 0, bArr, 0, str.getBytes().length);
            JL_Log.i("ModifyNfcMsgParam", "getMaskData", "modify name : " + str + ", data = " + CHexConver.byte2HexStr(bArr));
            byteArrayOutputStream.write(bArr);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String getNickName() {
        return this.nickName;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }
}
