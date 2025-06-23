package com.jieli.jl_rcsp.util;

import com.jieli.jl_rcsp.model.LtvBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class DataUtil {
    public static List<LtvBean> parseLTVData2(byte[] bArr) {
        if (bArr != null && bArr.length > 2) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i + 1 < bArr.length) {
                int bytesToInt = CHexConver.bytesToInt(bArr, i, 2);
                int i2 = i + 2;
                if (i2 + bytesToInt > bArr.length) {
                    break;
                }
                int byteToInt = CHexConver.byteToInt(bArr[i2]);
                int i3 = i + 3;
                int i4 = bytesToInt - 1;
                byte[] bArr2 = new byte[i4];
                System.arraycopy(bArr, i3, bArr2, 0, i4);
                i = i3 + i4;
                arrayList.add(new LtvBean(bytesToInt, byteToInt, bArr2));
            }
            return arrayList;
        }
        return new ArrayList();
    }
}
