package com.jieli.jl_rcsp.model.device.health;

import android.text.TextUtils;
import com.jieli.jl_rcsp.model.device.AttrBean;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class FallDetection implements IHealthSettingToAttr {
    public static final byte MODE_BRIGHT = 0;
    public static final byte MODE_CALL = 2;
    public static final byte MODE_SHAKE = 1;
    private String contact;
    private boolean enable;
    private byte mode;

    public FallDetection(byte[] bArr) {
        parseData(bArr);
    }

    private void parseData(byte[] bArr) {
        boolean z;
        if (bArr != null && bArr.length != 0) {
            int i = 0;
            int i2 = 1;
            if (CHexConver.byteToInt(bArr[0]) == 1) {
                z = true;
            } else {
                z = false;
            }
            this.enable = z;
            if (bArr.length >= 2) {
                this.mode = bArr[1];
                i2 = 2;
            }
            this.contact = "";
            int i3 = i2 + 1;
            if (bArr.length >= i3) {
                i = Math.min(CHexConver.byteToInt(bArr[i2]), bArr.length - i3);
                i2 = i3;
            }
            if (i > 0 && bArr.length >= i2 + i) {
                this.contact = new String(bArr, i2, i).trim();
            }
        }
    }

    private byte[] toData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{this.enable ? (byte) 1 : (byte) 0, this.mode});
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (this.mode == 2 && !TextUtils.isEmpty(this.contact)) {
            try {
                byteArrayOutputStream.write(this.contact.getBytes().length);
                byteArrayOutputStream.write(this.contact.getBytes());
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String getContact() {
        return this.contact;
    }

    public byte getMode() {
        return this.mode;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public int getType() {
        return 7;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public FallDetection setContact(String str) {
        this.contact = str;
        return this;
    }

    public FallDetection setEnable(boolean z) {
        this.enable = z;
        return this;
    }

    public FallDetection setMode(byte b) {
        this.mode = b;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public AttrBean toAttr() {
        return new AttrBean().setAttrData(toData()).setType((byte) getType());
    }

    public String toString() {
        return "FallDetection{contact='" + this.contact + "', enable=" + this.enable + ", mode=" + ((int) this.mode) + '}';
    }
}
