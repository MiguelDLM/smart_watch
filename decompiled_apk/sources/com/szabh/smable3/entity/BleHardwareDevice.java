package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleHardwareInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleHardwareInfo.kt\ncom/szabh/smable3/entity/BleHardwareDevice\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,303:1\n11075#2:304\n11410#2,3:305\n*S KotlinDebug\n*F\n+ 1 BleHardwareInfo.kt\ncom/szabh/smable3/entity/BleHardwareDevice\n*L\n58#1:304\n58#1:305,3\n*E\n"})
/* loaded from: classes13.dex */
public final class BleHardwareDevice extends BleReadable {

    @OOXIXo
    private byte[] mCompatible;
    private int mCurrent;
    private int mLength;
    private int mType;

    /* loaded from: classes13.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BleHardwareDeviceType.values().length];
            try {
                iArr[BleHardwareDeviceType.CD_DEVICE_TYPE_LCD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BleHardwareDeviceType.CD_DEVICE_TYPE_HEARTRATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BleHardwareDeviceType.CD_DEVICE_TYPE_G_SENSOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BleHardwareDeviceType.CD_DEVICE_TYPE_GEOMAGNETISM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BleHardwareDeviceType.CD_DEVICE_TYPE_TP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BleHardwareDeviceType.CD_DEVICE_TYPE_AIR_PRESSURE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BleHardwareDevice() {
        this(0, 0, 0, null, 15, null);
    }

    public static /* synthetic */ BleHardwareDevice copy$default(BleHardwareDevice bleHardwareDevice, int i, int i2, int i3, byte[] bArr, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = bleHardwareDevice.mLength;
        }
        if ((i4 & 2) != 0) {
            i2 = bleHardwareDevice.mType;
        }
        if ((i4 & 4) != 0) {
            i3 = bleHardwareDevice.mCurrent;
        }
        if ((i4 & 8) != 0) {
            bArr = bleHardwareDevice.mCompatible;
        }
        return bleHardwareDevice.copy(i, i2, i3, bArr);
    }

    public final int component1() {
        return this.mLength;
    }

    public final int component2() {
        return this.mType;
    }

    public final int component3() {
        return this.mCurrent;
    }

    @OOXIXo
    public final byte[] component4() {
        return this.mCompatible;
    }

    @OOXIXo
    public final BleHardwareDevice copy(int i, int i2, int i3, @OOXIXo byte[] mCompatible) {
        IIX0o.x0xO0oo(mCompatible, "mCompatible");
        return new BleHardwareDevice(i, i2, i3, mCompatible);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleHardwareDevice)) {
            return false;
        }
        BleHardwareDevice bleHardwareDevice = (BleHardwareDevice) obj;
        return this.mLength == bleHardwareDevice.mLength && this.mType == bleHardwareDevice.mType && this.mCurrent == bleHardwareDevice.mCurrent && IIX0o.Oxx0IOOO(this.mCompatible, bleHardwareDevice.mCompatible);
    }

    @OOXIXo
    public final BleHardwareType getHardwareType(int i, int i2) {
        switch (WhenMappings.$EnumSwitchMapping$0[BleHardwareDeviceType.Companion.of(i).ordinal()]) {
            case 1:
                return BleHardwareLCDType.Companion.of(i2);
            case 2:
                return BleHardwareHeatrateType.Companion.of(i2);
            case 3:
                return BleHardwareGsensorType.Companion.of(i2);
            case 4:
                return BleHardwareGeomagnetismType.Companion.of(i2);
            case 5:
                return BleHardwareTPType.Companion.of(i2);
            case 6:
                return BleHardwareAirPressureType.Companion.of(i2);
            default:
                return BleHardwareLCDType.CD_LCD_TYPE_NONE;
        }
    }

    @OOXIXo
    public final byte[] getMCompatible() {
        return this.mCompatible;
    }

    public final int getMCurrent() {
        return this.mCurrent;
    }

    public final int getMLength() {
        return this.mLength;
    }

    public final int getMType() {
        return this.mType;
    }

    public int hashCode() {
        return (((((this.mLength * 31) + this.mType) * 31) + this.mCurrent) * 31) + Arrays.hashCode(this.mCompatible);
    }

    public final void setMCompatible(@OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<set-?>");
        this.mCompatible = bArr;
    }

    public final void setMCurrent(int i) {
        this.mCurrent = i;
    }

    public final void setMLength(int i) {
        this.mLength = i;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BleHardwareDevice(\nmLength=");
        sb.append(this.mLength);
        sb.append(", \nmType=");
        sb.append(BleHardwareDeviceType.Companion.of(this.mType));
        sb.append(", \nmCurrent=");
        sb.append(getHardwareType(this.mType, this.mCurrent));
        sb.append(", \nmCompatible=");
        byte[] bArr = this.mCompatible;
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b : bArr) {
            arrayList.add(getHardwareType(this.mType, b));
        }
        sb.append(arrayList);
        sb.append(")\n");
        return sb.toString();
    }

    public /* synthetic */ BleHardwareDevice(int i, int i2, int i3, byte[] bArr, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3, (i4 & 8) != 0 ? new byte[0] : bArr);
    }

    public BleHardwareDevice(int i, int i2, int i3, @OOXIXo byte[] mCompatible) {
        IIX0o.x0xO0oo(mCompatible, "mCompatible");
        this.mLength = i;
        this.mType = i2;
        this.mCurrent = i3;
        this.mCompatible = mCompatible;
    }
}
