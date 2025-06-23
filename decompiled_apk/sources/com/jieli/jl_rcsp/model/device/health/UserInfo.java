package com.jieli.jl_rcsp.model.device.health;

import com.jieli.jl_rcsp.model.device.AttrBean;
import com.jieli.jl_rcsp.util.CHexConver;
import java.nio.ByteBuffer;

/* loaded from: classes10.dex */
public class UserInfo implements IHealthSettingToAttr {
    public static final int SEX_MAN = 1;
    public static final int SEX_WOMAN = 0;
    private byte birthDay;
    private byte birthMonth;
    private int birthYear;
    private short height;
    private byte sex;
    private short weight;

    public UserInfo(byte[] bArr) {
        parseData(bArr);
    }

    private void parseData(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            int i = 2;
            if (bArr.length >= 2) {
                this.height = CHexConver.bytesToShort(bArr[0], bArr[1]);
            } else {
                i = 0;
            }
            int i2 = i + 2;
            if (bArr.length >= i2) {
                this.weight = CHexConver.bytesToShort(bArr[i], bArr[i + 1]);
                i = i2;
            }
            int i3 = i + 2;
            if (bArr.length >= i3) {
                this.birthYear = CHexConver.bytesToInt(bArr[i], bArr[i + 1]);
                i = i3;
            }
            int i4 = i + 1;
            if (bArr.length >= i4) {
                this.birthMonth = bArr[i];
                i = i4;
            }
            int i5 = i + 1;
            if (bArr.length >= i5) {
                this.birthDay = bArr[i];
                i = i5;
            }
            if (bArr.length >= i + 1) {
                this.sex = bArr[i];
            }
        }
    }

    private byte[] toData() {
        return ByteBuffer.allocate(9).putShort(this.height).putShort(this.weight).putShort((short) this.birthYear).put(this.birthMonth).put(this.birthDay).put(this.sex).array();
    }

    public byte getBirthDay() {
        return this.birthDay;
    }

    public byte getBirthMonth() {
        return this.birthMonth;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    public short getHeight() {
        return this.height;
    }

    public byte getSex() {
        return this.sex;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public int getType() {
        return 9;
    }

    public short getWeight() {
        return this.weight;
    }

    public UserInfo setBirthDay(byte b) {
        this.birthDay = b;
        return this;
    }

    public UserInfo setBirthMonth(byte b) {
        this.birthMonth = b;
        return this;
    }

    public UserInfo setBirthYear(int i) {
        this.birthYear = i;
        return this;
    }

    public UserInfo setHeight(short s) {
        this.height = s;
        return this;
    }

    public UserInfo setSex(byte b) {
        this.sex = b;
        return this;
    }

    public UserInfo setWeight(short s) {
        this.weight = s;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public AttrBean toAttr() {
        return new AttrBean().setType((byte) getType()).setAttrData(toData());
    }

    public String toString() {
        return "UserInfo{height=" + ((int) this.height) + ", weight=" + ((int) this.weight) + ", year=" + this.birthYear + ", month=" + ((int) this.birthMonth) + ", day=" + ((int) this.birthDay) + ", sex=" + ((int) this.sex) + '}';
    }
}
