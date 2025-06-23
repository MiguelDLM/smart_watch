package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleIPCWifiInfo extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int MODE_AP = 0;
    public static final int MODE_P2P = 1;
    public static final int MODE_STA = 2;
    public static final int STATE_IPC_CLOSE = 0;
    public static final int STATE_IPC_OPENING = 1;
    public static final int STATE_IPC_OPEN_SUCCESSFULLY = 2;
    public static final int STATE_IPC_WIFI_OPENING = 3;
    public static final int STATE_IPC_WIFI_OPEN_SUCCESSFULLY = 4;
    public static final int STATE_WIFI_OPEN_FAILED = 128;
    public static final int TYPE_IP = 3;
    public static final int TYPE_SUPPORT = 6;
    public static final int TYPE_WIFI_MODE = 5;
    public static final int TYPE_WIFI_NAME = 1;
    public static final int TYPE_WIFI_PASSWORD = 2;
    public static final int TYPE_WIFI_STATE = 4;

    @OOXIXo
    private String mIP;
    private int mMode;
    private int mState;
    private int mSupportP2P;

    @OOXIXo
    private String mWifiName;

    @OOXIXo
    private String mWifiPassword;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleIPCWifiInfo() {
        this(null, null, null, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ BleIPCWifiInfo copy$default(BleIPCWifiInfo bleIPCWifiInfo, String str, String str2, String str3, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = bleIPCWifiInfo.mWifiName;
        }
        if ((i4 & 2) != 0) {
            str2 = bleIPCWifiInfo.mWifiPassword;
        }
        String str4 = str2;
        if ((i4 & 4) != 0) {
            str3 = bleIPCWifiInfo.mIP;
        }
        String str5 = str3;
        if ((i4 & 8) != 0) {
            i = bleIPCWifiInfo.mState;
        }
        int i5 = i;
        if ((i4 & 16) != 0) {
            i2 = bleIPCWifiInfo.mMode;
        }
        int i6 = i2;
        if ((i4 & 32) != 0) {
            i3 = bleIPCWifiInfo.mSupportP2P;
        }
        return bleIPCWifiInfo.copy(str, str4, str5, i5, i6, i3);
    }

    @OOXIXo
    public final String component1() {
        return this.mWifiName;
    }

    @OOXIXo
    public final String component2() {
        return this.mWifiPassword;
    }

    @OOXIXo
    public final String component3() {
        return this.mIP;
    }

    public final int component4() {
        return this.mState;
    }

    public final int component5() {
        return this.mMode;
    }

    public final int component6() {
        return this.mSupportP2P;
    }

    @OOXIXo
    public final BleIPCWifiInfo copy(@OOXIXo String mWifiName, @OOXIXo String mWifiPassword, @OOXIXo String mIP, int i, int i2, int i3) {
        IIX0o.x0xO0oo(mWifiName, "mWifiName");
        IIX0o.x0xO0oo(mWifiPassword, "mWifiPassword");
        IIX0o.x0xO0oo(mIP, "mIP");
        return new BleIPCWifiInfo(mWifiName, mWifiPassword, mIP, i, i2, i3);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        char readUInt8 = readUInt8();
        do {
            char readUInt82 = readUInt8();
            switch (readUInt8) {
                case 1:
                    this.mWifiName = BleReadable.readString$default(this, readUInt82, null, 2, null);
                    readUInt8 = readUInt8();
                    break;
                case 2:
                    this.mWifiPassword = BleReadable.readString$default(this, readUInt82, null, 2, null);
                    readUInt8 = readUInt8();
                    break;
                case 3:
                    this.mIP = BleReadable.readString$default(this, readUInt82, null, 2, null);
                    readUInt8 = readUInt8();
                    break;
                case 4:
                    this.mState = readUInt8();
                    readUInt8 = readUInt8();
                    break;
                case 5:
                    this.mMode = readUInt8();
                    readUInt8 = readUInt8();
                    break;
                case 6:
                    this.mSupportP2P = readUInt8();
                    readUInt8 = readUInt8();
                    break;
                default:
                    readUInt8 = readUInt8();
                    break;
            }
        } while (readUInt8 > 0);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleIPCWifiInfo)) {
            return false;
        }
        BleIPCWifiInfo bleIPCWifiInfo = (BleIPCWifiInfo) obj;
        return IIX0o.Oxx0IOOO(this.mWifiName, bleIPCWifiInfo.mWifiName) && IIX0o.Oxx0IOOO(this.mWifiPassword, bleIPCWifiInfo.mWifiPassword) && IIX0o.Oxx0IOOO(this.mIP, bleIPCWifiInfo.mIP) && this.mState == bleIPCWifiInfo.mState && this.mMode == bleIPCWifiInfo.mMode && this.mSupportP2P == bleIPCWifiInfo.mSupportP2P;
    }

    @OOXIXo
    public final String getMIP() {
        return this.mIP;
    }

    public final int getMMode() {
        return this.mMode;
    }

    public final int getMState() {
        return this.mState;
    }

    public final int getMSupportP2P() {
        return this.mSupportP2P;
    }

    @OOXIXo
    public final String getMWifiName() {
        return this.mWifiName;
    }

    @OOXIXo
    public final String getMWifiPassword() {
        return this.mWifiPassword;
    }

    public int hashCode() {
        return (((((((((this.mWifiName.hashCode() * 31) + this.mWifiPassword.hashCode()) * 31) + this.mIP.hashCode()) * 31) + this.mState) * 31) + this.mMode) * 31) + this.mSupportP2P;
    }

    public final void setMIP(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mIP = str;
    }

    public final void setMMode(int i) {
        this.mMode = i;
    }

    public final void setMState(int i) {
        this.mState = i;
    }

    public final void setMSupportP2P(int i) {
        this.mSupportP2P = i;
    }

    public final void setMWifiName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mWifiName = str;
    }

    public final void setMWifiPassword(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mWifiPassword = str;
    }

    @OOXIXo
    public String toString() {
        return "BleIPCWifiInfo(mWifiName=" + this.mWifiName + ", mWifiPassword=" + this.mWifiPassword + ", mIP=" + this.mIP + ", mState=" + this.mState + ", mMode=" + this.mMode + ", mSupportP2P=" + this.mSupportP2P + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleIPCWifiInfo(String str, String str2, String str3, int i, int i2, int i3, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) == 0 ? str3 : "", (i4 & 8) != 0 ? 0 : i, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? 0 : i3);
    }

    public BleIPCWifiInfo(@OOXIXo String mWifiName, @OOXIXo String mWifiPassword, @OOXIXo String mIP, int i, int i2, int i3) {
        IIX0o.x0xO0oo(mWifiName, "mWifiName");
        IIX0o.x0xO0oo(mWifiPassword, "mWifiPassword");
        IIX0o.x0xO0oo(mIP, "mIP");
        this.mWifiName = mWifiName;
        this.mWifiPassword = mWifiPassword;
        this.mIP = mIP;
        this.mState = i;
        this.mMode = i2;
        this.mSupportP2P = i3;
    }
}
