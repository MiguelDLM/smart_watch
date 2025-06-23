package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleFactoryTest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleFactoryTest.kt\ncom/szabh/smable3/entity/BleFactoryTest\n+ 2 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable$Companion\n+ 3 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable\n*L\n1#1,342:1\n277#2,5:343\n277#2,5:368\n222#3,4:348\n222#3,4:352\n222#3,4:356\n222#3,4:360\n222#3,4:364\n222#3,4:373\n222#3,4:377\n*S KotlinDebug\n*F\n+ 1 BleFactoryTest.kt\ncom/szabh/smable3/entity/BleFactoryTest\n*L\n29#1:343,5\n53#1:368,5\n33#1:348,4\n37#1:352,4\n41#1:356,4\n45#1:360,4\n49#1:364,4\n58#1:373,4\n66#1:377,4\n*E\n"})
/* loaded from: classes13.dex */
public final class BleFactoryTest extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int STATUS_FAILED = 1;
    public static final int STATUS_SUCCESS = 0;

    @OOXIXo
    private Object mResponse;

    @OOXIXo
    private FactoryTestType mType;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes13.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FactoryTestType.values().length];
            try {
                iArr[FactoryTestType.ENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FactoryTestType.FIRMWARE_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FactoryTestType.UI_VERSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FactoryTestType.GSENSOR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FactoryTestType.TUYA_INFO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FactoryTestType.KEY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FactoryTestType.STEWING_RESULT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[FactoryTestType.HARDWARE_INFO.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[FactoryTestType.HR_LEAK.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[FactoryTestType.HR_BIO.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleFactoryTest() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleFactoryTest copy$default(BleFactoryTest bleFactoryTest, FactoryTestType factoryTestType, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            factoryTestType = bleFactoryTest.mType;
        }
        if ((i & 2) != 0) {
            obj = bleFactoryTest.mResponse;
        }
        return bleFactoryTest.copy(factoryTestType, obj);
    }

    @OOXIXo
    public final FactoryTestType component1() {
        return this.mType;
    }

    @OOXIXo
    public final Object component2() {
        return this.mResponse;
    }

    @OOXIXo
    public final BleFactoryTest copy(@OOXIXo FactoryTestType mType, @OOXIXo Object mResponse) {
        IIX0o.x0xO0oo(mType, "mType");
        IIX0o.x0xO0oo(mResponse, "mResponse");
        return new BleFactoryTest(mType, mResponse);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        BleReadable bleReadable;
        Object obj;
        super.decode();
        FactoryTestType of = FactoryTestType.Companion.of(readUInt8());
        this.mType = of;
        switch (WhenMappings.$EnumSwitchMapping$0[of.ordinal()]) {
            case 1:
                byte[] mBytes = getMBytes();
                IIX0o.ooOOo0oXI(mBytes);
                int length = mBytes.length;
                Object newInstance = BleTestSupportData.class.newInstance();
                bleReadable = (BleReadable) newInstance;
                bleReadable.setMBytes(ooOOo0oXI.xxOXOOoIX(mBytes, 1, length));
                bleReadable.decode();
                IIX0o.oO(newInstance, "also(...)");
                obj = bleReadable;
                break;
            case 2:
            case 3:
                BleReadable bleReadable2 = (BleReadable) BleVersion.class.newInstance();
                bleReadable2.setMBytes(readBytes(3));
                bleReadable2.decode();
                IIX0o.ooOOo0oXI(bleReadable2);
                obj = bleReadable2;
                break;
            case 4:
                BleReadable bleReadable3 = (BleReadable) BleGsensorData.class.newInstance();
                bleReadable3.setMBytes(readBytes(7));
                bleReadable3.decode();
                IIX0o.ooOOo0oXI(bleReadable3);
                obj = bleReadable3;
                break;
            case 5:
                BleReadable bleReadable4 = (BleReadable) BleTuyaKey.class.newInstance();
                bleReadable4.setMBytes(readBytes(61));
                bleReadable4.decode();
                IIX0o.ooOOo0oXI(bleReadable4);
                obj = bleReadable4;
                break;
            case 6:
                BleReadable bleReadable5 = (BleReadable) BleTestKeyData.class.newInstance();
                bleReadable5.setMBytes(readBytes(2));
                bleReadable5.decode();
                IIX0o.ooOOo0oXI(bleReadable5);
                obj = bleReadable5;
                break;
            case 7:
                BleReadable bleReadable6 = (BleReadable) BleStewingData.class.newInstance();
                bleReadable6.setMBytes(readBytes(13));
                bleReadable6.decode();
                IIX0o.ooOOo0oXI(bleReadable6);
                obj = bleReadable6;
                break;
            case 8:
                byte[] mBytes2 = getMBytes();
                IIX0o.ooOOo0oXI(mBytes2);
                int length2 = mBytes2.length;
                Object newInstance2 = BleHardwareInfo.class.newInstance();
                bleReadable = (BleReadable) newInstance2;
                bleReadable.setMBytes(ooOOo0oXI.xxOXOOoIX(mBytes2, 1, length2));
                bleReadable.decode();
                IIX0o.oO(newInstance2, "also(...)");
                obj = bleReadable;
                break;
            case 9:
                byte[] mBytes3 = getMBytes();
                IIX0o.ooOOo0oXI(mBytes3);
                if (mBytes3.length > 2) {
                    BleReadable bleReadable7 = (BleReadable) BleHrLeakData.class.newInstance();
                    bleReadable7.setMBytes(readBytes(4));
                    bleReadable7.decode();
                    IIX0o.ooOOo0oXI(bleReadable7);
                    obj = bleReadable7;
                    break;
                } else {
                    obj = Integer.valueOf(readInt8());
                    break;
                }
            case 10:
                byte[] mBytes4 = getMBytes();
                IIX0o.ooOOo0oXI(mBytes4);
                if (mBytes4.length > 2) {
                    BleReadable bleReadable8 = (BleReadable) BleVcareCalcData.class.newInstance();
                    bleReadable8.setMBytes(readBytes(5));
                    bleReadable8.decode();
                    IIX0o.ooOOo0oXI(bleReadable8);
                    obj = bleReadable8;
                    break;
                } else {
                    obj = Integer.valueOf(readInt8());
                    break;
                }
            default:
                obj = Integer.valueOf(readUInt8());
                break;
        }
        this.mResponse = obj;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mType.getType());
        Object obj = this.mResponse;
        if (obj instanceof Integer) {
            IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlin.Int");
            writeInt8(((Integer) obj).intValue());
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleFactoryTest)) {
            return false;
        }
        BleFactoryTest bleFactoryTest = (BleFactoryTest) obj;
        return this.mType == bleFactoryTest.mType && IIX0o.Oxx0IOOO(this.mResponse, bleFactoryTest.mResponse);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 2;
    }

    @OOXIXo
    public final Object getMResponse() {
        return this.mResponse;
    }

    @OOXIXo
    public final FactoryTestType getMType() {
        return this.mType;
    }

    public int hashCode() {
        return (this.mType.hashCode() * 31) + this.mResponse.hashCode();
    }

    public final void setMResponse(@OOXIXo Object obj) {
        IIX0o.x0xO0oo(obj, "<set-?>");
        this.mResponse = obj;
    }

    public final void setMType(@OOXIXo FactoryTestType factoryTestType) {
        IIX0o.x0xO0oo(factoryTestType, "<set-?>");
        this.mType = factoryTestType;
    }

    @OOXIXo
    public String toString() {
        return "BleFactoryTest(mType=" + this.mType + ", mResponse=" + this.mResponse + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleFactoryTest(FactoryTestType factoryTestType, Object obj, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? FactoryTestType.ENTER : factoryTestType, (i & 2) != 0 ? new Object() : obj);
    }

    public BleFactoryTest(@OOXIXo FactoryTestType mType, @OOXIXo Object mResponse) {
        IIX0o.x0xO0oo(mType, "mType");
        IIX0o.x0xO0oo(mResponse, "mResponse");
        this.mType = mType;
        this.mResponse = mResponse;
    }
}
