package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleAppStore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleAppStore.kt\ncom/szabh/smable3/entity/BleAppInfo\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,174:1\n222#2,4:175\n222#2,4:179\n*S KotlinDebug\n*F\n+ 1 BleAppStore.kt\ncom/szabh/smable3/entity/BleAppInfo\n*L\n67#1:175,4\n72#1:179,4\n*E\n"})
/* loaded from: classes13.dex */
public final class BleAppInfo extends BleReadable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    public static final String PACKAGE_ALIPAY = "built-in.alipay";

    @OOXIXo
    public static final String PACKAGE_CALCULATOR = "built-in.Calculator";

    @OOXIXo
    public static final String PACKAGE_CARD_WALLET = "built-in.Card_Wallet";

    @OOXIXo
    public static final String PACKAGE_GAME_2048 = "built-in.game_2048";

    @OOXIXo
    public static final String PACKAGE_GAME_PLAN = "built-in.game_plan";

    @OOXIXo
    public static final String PACKAGE_GAME_TTT = "built-in.game_ttt";

    @OOXIXo
    public static final String PACKAGE_NAVIGATION = "built-in.navigation";

    @OOXIXo
    public static final String PACKAGE_STOCK = "built-in.stock";

    @OOXIXo
    public static final String PACKAGE_WORLD_CLOCK = "built-in.world_clock";

    @OOXIXo
    private String mApiVersion;
    private int mHide;
    private int mIsGame;

    @OOXIXo
    private String mName;

    @OOXIXo
    private String mPackage;
    private int mSize;

    @OOXIXo
    private String mVersion;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleAppInfo() {
        this(null, null, null, 0, 0, 0, null, 127, null);
    }

    public static /* synthetic */ BleAppInfo copy$default(BleAppInfo bleAppInfo, String str, String str2, String str3, int i, int i2, int i3, String str4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = bleAppInfo.mPackage;
        }
        if ((i4 & 2) != 0) {
            str2 = bleAppInfo.mVersion;
        }
        String str5 = str2;
        if ((i4 & 4) != 0) {
            str3 = bleAppInfo.mName;
        }
        String str6 = str3;
        if ((i4 & 8) != 0) {
            i = bleAppInfo.mSize;
        }
        int i5 = i;
        if ((i4 & 16) != 0) {
            i2 = bleAppInfo.mHide;
        }
        int i6 = i2;
        if ((i4 & 32) != 0) {
            i3 = bleAppInfo.mIsGame;
        }
        int i7 = i3;
        if ((i4 & 64) != 0) {
            str4 = bleAppInfo.mApiVersion;
        }
        return bleAppInfo.copy(str, str5, str6, i5, i6, i7, str4);
    }

    @OOXIXo
    public final String component1() {
        return this.mPackage;
    }

    @OOXIXo
    public final String component2() {
        return this.mVersion;
    }

    @OOXIXo
    public final String component3() {
        return this.mName;
    }

    public final int component4() {
        return this.mSize;
    }

    public final int component5() {
        return this.mHide;
    }

    public final int component6() {
        return this.mIsGame;
    }

    @OOXIXo
    public final String component7() {
        return this.mApiVersion;
    }

    @OOXIXo
    public final BleAppInfo copy(@OOXIXo String mPackage, @OOXIXo String mVersion, @OOXIXo String mName, int i, int i2, int i3, @OOXIXo String mApiVersion) {
        IIX0o.x0xO0oo(mPackage, "mPackage");
        IIX0o.x0xO0oo(mVersion, "mVersion");
        IIX0o.x0xO0oo(mName, "mName");
        IIX0o.x0xO0oo(mApiVersion, "mApiVersion");
        return new BleAppInfo(mPackage, mVersion, mName, i, i2, i3, mApiVersion);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mPackage = BleReadable.readString$default(this, 24, null, 2, null);
        BleReadable bleReadable = (BleReadable) BleAppVersion.class.newInstance();
        bleReadable.setMBytes(readBytes(4));
        bleReadable.decode();
        IIX0o.ooOOo0oXI(bleReadable);
        this.mVersion = ((BleAppVersion) bleReadable).getMVersion();
        this.mName = BleReadable.readString$default(this, 32, null, 2, null);
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mSize = readInt32(LITTLE_ENDIAN);
        this.mHide = readInt8();
        this.mIsGame = readInt8();
        BleReadable bleReadable2 = (BleReadable) BleAppVersion.class.newInstance();
        bleReadable2.setMBytes(readBytes(4));
        bleReadable2.decode();
        IIX0o.ooOOo0oXI(bleReadable2);
        this.mApiVersion = ((BleAppVersion) bleReadable2).getMVersion();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleAppInfo)) {
            return false;
        }
        BleAppInfo bleAppInfo = (BleAppInfo) obj;
        return IIX0o.Oxx0IOOO(this.mPackage, bleAppInfo.mPackage) && IIX0o.Oxx0IOOO(this.mVersion, bleAppInfo.mVersion) && IIX0o.Oxx0IOOO(this.mName, bleAppInfo.mName) && this.mSize == bleAppInfo.mSize && this.mHide == bleAppInfo.mHide && this.mIsGame == bleAppInfo.mIsGame && IIX0o.Oxx0IOOO(this.mApiVersion, bleAppInfo.mApiVersion);
    }

    @OOXIXo
    public final String getMApiVersion() {
        return this.mApiVersion;
    }

    public final int getMHide() {
        return this.mHide;
    }

    public final int getMIsGame() {
        return this.mIsGame;
    }

    @OOXIXo
    public final String getMName() {
        return this.mName;
    }

    @OOXIXo
    public final String getMPackage() {
        return this.mPackage;
    }

    public final int getMSize() {
        return this.mSize;
    }

    @OOXIXo
    public final String getMVersion() {
        return this.mVersion;
    }

    public int hashCode() {
        return (((((((((((this.mPackage.hashCode() * 31) + this.mVersion.hashCode()) * 31) + this.mName.hashCode()) * 31) + this.mSize) * 31) + this.mHide) * 31) + this.mIsGame) * 31) + this.mApiVersion.hashCode();
    }

    public final void setMApiVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mApiVersion = str;
    }

    public final void setMHide(int i) {
        this.mHide = i;
    }

    public final void setMIsGame(int i) {
        this.mIsGame = i;
    }

    public final void setMName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mName = str;
    }

    public final void setMPackage(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mPackage = str;
    }

    public final void setMSize(int i) {
        this.mSize = i;
    }

    public final void setMVersion(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mVersion = str;
    }

    @OOXIXo
    public String toString() {
        return "BleAppInfo(mPackage=" + this.mPackage + ", mVersion=" + this.mVersion + ", mName=" + this.mName + ", mSize=" + this.mSize + ", mHide=" + this.mHide + ", mApiVersion=" + this.mApiVersion + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleAppInfo(String str, String str2, String str3, int i, int i2, int i3, String str4, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? "" : str3, (i4 & 8) != 0 ? 0 : i, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? 0 : i3, (i4 & 64) != 0 ? "" : str4);
    }

    public BleAppInfo(@OOXIXo String mPackage, @OOXIXo String mVersion, @OOXIXo String mName, int i, int i2, int i3, @OOXIXo String mApiVersion) {
        IIX0o.x0xO0oo(mPackage, "mPackage");
        IIX0o.x0xO0oo(mVersion, "mVersion");
        IIX0o.x0xO0oo(mName, "mName");
        IIX0o.x0xO0oo(mApiVersion, "mApiVersion");
        this.mPackage = mPackage;
        this.mVersion = mVersion;
        this.mName = mName;
        this.mSize = i;
        this.mHide = i2;
        this.mIsGame = i3;
        this.mApiVersion = mApiVersion;
    }
}
