package com.jieli.jl_rcsp.model.device;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class AlarmBean {
    private int bellCluster;
    private String bellName;
    private byte bellType;
    private byte devIndex;
    private byte hour;
    private byte index;
    private byte min;
    private String name;
    private boolean open;
    private byte repeatMode;
    private String reserved;
    private int version;

    public static AttrBean toAttrbean(AlarmBean alarmBean, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(alarmBean);
        return toAttrbean(arrayList, z);
    }

    public AlarmBean copy() {
        return new AlarmBean().setIndex(getIndex()).setHour(getHour()).setMin(getMin()).setName(getName()).setRepeatMode(getRepeatMode()).setReserved(getReserved()).setBellType(this.bellType).setBellName(this.bellName).setBellCluster(this.bellCluster).setVersion(this.version).setDevIndex(this.devIndex).setOpen(isOpen());
    }

    public int getBellCluster() {
        return this.bellCluster;
    }

    public String getBellName() {
        return this.bellName;
    }

    public byte getBellType() {
        return this.bellType;
    }

    public byte getDevIndex() {
        return this.devIndex;
    }

    public byte getHour() {
        return this.hour;
    }

    public byte getIndex() {
        return this.index;
    }

    public byte getMin() {
        return this.min;
    }

    public String getName() {
        String str = this.name;
        if (str == null) {
            return "";
        }
        return str;
    }

    public byte getRepeatMode() {
        return this.repeatMode;
    }

    public String getReserved() {
        return this.reserved;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean isOpen() {
        return this.open;
    }

    public AlarmBean setBellCluster(int i) {
        this.bellCluster = i;
        return this;
    }

    public AlarmBean setBellName(String str) {
        this.bellName = str;
        return this;
    }

    public AlarmBean setBellType(byte b) {
        this.bellType = b;
        return this;
    }

    public AlarmBean setDevIndex(byte b) {
        this.devIndex = b;
        return this;
    }

    public AlarmBean setHour(byte b) {
        this.hour = b;
        return this;
    }

    public AlarmBean setIndex(byte b) {
        this.index = b;
        return this;
    }

    public AlarmBean setMin(byte b) {
        this.min = b;
        return this;
    }

    public AlarmBean setName(String str) {
        this.name = str;
        return this;
    }

    public AlarmBean setOpen(boolean z) {
        this.open = z;
        return this;
    }

    public AlarmBean setRepeatMode(byte b) {
        this.repeatMode = b;
        return this;
    }

    public AlarmBean setReserved(String str) {
        this.reserved = str;
        return this;
    }

    public AlarmBean setVersion(int i) {
        this.version = i;
        return this;
    }

    public String toString() {
        return "AlarmBean{index=" + ((int) this.index) + ", name='" + this.name + "', hour=" + ((int) this.hour) + ", min=" + ((int) this.min) + ", repeatMode=" + ((int) this.repeatMode) + ", reserved='" + this.reserved + "', open=" + this.open + ", bellType=" + ((int) this.bellType) + ", bellCluster=" + this.bellCluster + ", bellName='" + this.bellName + "', devIndex='" + ((int) this.devIndex) + "', version='" + this.version + "'}";
    }

    public static AttrBean toAttrbean(List<AlarmBean> list, boolean z) {
        byte[] bArr;
        AttrBean attrBean = new AttrBean();
        attrBean.setType((byte) 1);
        int i = 2;
        if (z) {
            bArr = new byte[list.size() + 2];
            bArr[0] = 1;
            bArr[1] = (byte) list.size();
            Iterator<AlarmBean> it = list.iterator();
            while (it.hasNext()) {
                bArr[i] = it.next().getIndex();
                i++;
            }
        } else {
            ArrayList arrayList = new ArrayList();
            for (AlarmBean alarmBean : list) {
                arrayList.add(Byte.valueOf(alarmBean.getIndex()));
                arrayList.add(Byte.valueOf(alarmBean.isOpen() ? (byte) 1 : (byte) 0));
                arrayList.add(Byte.valueOf(alarmBean.getRepeatMode()));
                arrayList.add(Byte.valueOf(alarmBean.getHour()));
                arrayList.add(Byte.valueOf(alarmBean.getMin()));
                byte[] bytes = alarmBean.getName().getBytes();
                arrayList.add(Byte.valueOf((byte) bytes.length));
                for (byte b : bytes) {
                    arrayList.add(Byte.valueOf(b));
                }
                if (alarmBean.version == 1) {
                    arrayList.add(Byte.valueOf(alarmBean.bellType));
                    arrayList.add(Byte.valueOf(alarmBean.devIndex));
                    arrayList.add(Byte.valueOf((byte) (alarmBean.bellCluster >> 24)));
                    arrayList.add(Byte.valueOf((byte) ((alarmBean.bellCluster >> 16) & 255)));
                    arrayList.add(Byte.valueOf((byte) ((alarmBean.bellCluster >> 8) & 255)));
                    arrayList.add(Byte.valueOf((byte) (alarmBean.bellCluster & 255)));
                    byte[] bytes2 = alarmBean.getBellName().getBytes();
                    arrayList.add(Byte.valueOf((byte) bytes2.length));
                    for (byte b2 : bytes2) {
                        arrayList.add(Byte.valueOf(b2));
                    }
                }
            }
            byte[] bArr2 = new byte[arrayList.size() + 2];
            bArr2[0] = 0;
            bArr2[1] = (byte) list.size();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                bArr2[i2 + 2] = ((Byte) arrayList.get(i2)).byteValue();
            }
            bArr = bArr2;
        }
        attrBean.setAttrData(bArr);
        return attrBean;
    }
}
