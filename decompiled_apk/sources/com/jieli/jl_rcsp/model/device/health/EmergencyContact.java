package com.jieli.jl_rcsp.model.device.health;

import android.text.TextUtils;
import com.jieli.jl_rcsp.model.device.AttrBean;
import com.jieli.jl_rcsp.util.CHexConver;
import java.nio.ByteBuffer;

/* loaded from: classes10.dex */
public class EmergencyContact implements IHealthSettingToAttr {
    private String number;
    private int phoneLen;

    public EmergencyContact(byte[] bArr) {
        parseData(bArr);
    }

    private void parseData(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            int byteToInt = CHexConver.byteToInt(bArr[0]);
            this.phoneLen = byteToInt;
            int min = Math.min(bArr.length - 1, byteToInt);
            this.phoneLen = min;
            if (bArr.length >= min + 1) {
                try {
                    this.number = new String(bArr, 1, min);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private byte[] toData() {
        if (TextUtils.isEmpty(this.number)) {
            return new byte[]{0};
        }
        byte[] bytes = this.number.getBytes();
        int length = bytes.length;
        ByteBuffer allocate = ByteBuffer.allocate(1 + length);
        allocate.put(CHexConver.intToByte(length));
        allocate.put(bytes);
        return allocate.array();
    }

    public String getNumber() {
        return this.number;
    }

    public int getPhoneLen() {
        return this.phoneLen;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public int getType() {
        return 12;
    }

    public EmergencyContact setNumber(String str) {
        this.number = str;
        return this;
    }

    public EmergencyContact setPhoneLen(int i) {
        this.phoneLen = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public AttrBean toAttr() {
        AttrBean attrBean = new AttrBean();
        attrBean.setAttrData(toData());
        attrBean.setType((byte) getType());
        return attrBean;
    }

    public String toString() {
        return "EmergencyContact{phoneLen=" + this.phoneLen + ", number='" + this.number + "'}";
    }
}
