package com.szabh.smable3.component;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.ai.speech.realtime.Util;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.bestmafen.baseble.data.ByteArrayExtKt;
import com.garmin.fit.OxXXx0X;
import com.garmin.fit.X0xOO;
import com.iflytek.sparkchain.utils.constants.ErrorCode;
import com.realsil.sdk.dfu.DfuConstants;
import com.realsil.sdk.dfu.image.constants.SubBinId;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes13.dex */
public final class MessageFactory {
    public static final int HEADER_NACK = 32;
    public static final int HEADER_REPLY = 16;
    private static final int HEADER_VERSION = 1;
    public static final int LENGTH_BEFORE_CMD = 6;
    private static final int LENGTH_BEFORE_CRC = 4;
    public static final int LENGTH_BEFORE_DATA = 9;
    public static final int LENGTH_BEFORE_LENGTH = 2;
    private static final int LENGTH_COMMAND = 1;
    private static final int LENGTH_CRC = 2;
    private static final int LENGTH_HEADER = 1;
    private static final int LENGTH_KEY = 1;
    private static final int LENGTH_KEY_FLAG = 1;
    private static final int LENGTH_MAGIC = 1;
    public static final int LENGTH_PAYLOAD_LENGTH = 2;
    private static final byte MAGIC = -85;

    @OOXIXo
    private static final String TAG = "MessageFactory";

    @OOXIXo
    public static final MessageFactory INSTANCE = new MessageFactory();

    @OOXIXo
    private static final int[] CRC16_TABLE = {0, 49345, 49537, X0xOO.f13583O0o0, 49921, 960, ScreenUtil.SCREEN_SIZE_Y_LARGE, 49729, 50689, 1728, ScreenUtil.DEFAULT_HEIGHT, 51009, 1280, 50625, 50305, 1088, 52225, 3264, 3456, 52545, 3840, 53185, 52865, OxXXx0X.f13272xx0O, SubBinId.Bbpro.FACTORY_IAMGE, 51905, 52097, 2880, 51457, OxXXx0X.f13084X0IOOI, 2176, 51265, 55297, 6336, 6528, 55617, 6912, 56257, 55937, 6720, 7680, 57025, 57217, 8000, 56577, 7616, 7296, 56385, Util.BYTES_PER_FRAME, 54465, 54657, 5440, 55041, 6080, 5760, 54849, 53761, 4800, 4992, 54081, 4352, 53697, 53377, 4160, 61441, 12480, 12672, 61761, 13056, 62401, 62081, 12864, 13824, 63169, 63361, 14144, 62721, 13760, 13440, 62529, 15360, 64705, 64897, 15680, 65281, 16320, 16000, 65089, 64001, 15040, 15232, 64321, 14592, 63937, 63617, 14400, 10240, 59585, 59777, 10560, 60161, ErrorCode.MSP_ERROR_AUTH_NO_LICENSE, 10880, 59969, 60929, 11968, 12160, 61249, 11520, 60865, 60545, 11328, 58369, 9408, 9600, 58689, 9984, 59329, 59009, 9792, 8704, 58049, 58241, 9024, 57601, 8640, 8320, 57409, 40961, 24768, 24960, 41281, 25344, 41921, 41601, 25152, 26112, 42689, 42881, 26432, 42241, 26048, 25728, 42049, 27648, 44225, 44417, 27968, 44801, 28608, 28288, 44609, 43521, 27328, 27520, 43841, 26880, 43457, 43137, 26688, 30720, 47297, 47489, 31040, 47873, 31680, 31360, 47681, 48641, 32448, 32640, 48961, DfuConstants.MAX_CONNECTION_LOCK_TIMEOUT, 48577, 48257, 31808, 46081, 29888, 30080, 46401, 30464, 47041, 46721, 30272, 29184, 45761, 45953, 29504, 45313, 29120, 28800, 45121, 20480, 37057, 37249, 20800, 37633, 21440, 21120, 37441, 38401, 22208, 22400, 38721, 21760, 38337, 38017, 21568, 39937, 23744, 23936, 40257, 24320, 40897, 40577, 24128, 23040, 39617, 39809, 23360, 39169, 22976, 22656, 38977, 34817, 18624, 18816, 35137, 19200, 35777, 35457, 19008, 19968, 36545, 36737, 20288, 36097, 19904, 19584, 35905, 17408, 33985, 34177, 17728, 34561, 18368, 18048, 34369, 33281, 17088, 17280, 33601, 16640, 33217, 32897, 16448};

    private MessageFactory() {
    }

    private final int calculateCrc16(byte[] bArr, int i) {
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            i2 = queryCrc16(i2, bArr[i]);
            i++;
        }
        return i2;
    }

    public static /* synthetic */ byte[] create$default(MessageFactory messageFactory, int i, BleKey bleKey, BleKeyFlag bleKeyFlag, byte[] bArr, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            bleKeyFlag = BleKeyFlag.UPDATE;
        }
        if ((i2 & 8) != 0) {
            bArr = null;
        }
        return messageFactory.create(i, bleKey, bleKeyFlag, bArr);
    }

    private final int queryCrc16(int i, byte b) {
        return CRC16_TABLE[(i ^ b) & 255] ^ (i >>> 8);
    }

    @OOXIXo
    public final byte[] create(int i, @OOXIXo BleKey bleKey, @OOXIXo BleKeyFlag keyFlag, @oOoXoXO byte[] bArr) {
        int i2;
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(keyFlag, "keyFlag");
        if (bArr != null) {
            i2 = bArr.length;
        } else {
            i2 = 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i2 + 9);
        allocate.put(MAGIC);
        allocate.put((byte) (i | 1));
        allocate.putShort((short) (i2 + 3));
        allocate.putShort((short) 0);
        allocate.put(bleKey.getMCommandRawValue());
        allocate.put(bleKey.getMKeyRawValue());
        allocate.put((byte) keyFlag.getMBleKeyFlag());
        if (bArr != null) {
            allocate.put(bArr);
        }
        byte[] array = allocate.array();
        IIX0o.ooOOo0oXI(array);
        int calculateCrc16 = calculateCrc16(array, 6);
        array[4] = (byte) (calculateCrc16 >> 8);
        array[5] = (byte) calculateCrc16;
        return array;
    }

    public final boolean isReply(@OOXIXo byte[] bytes) {
        IIX0o.x0xO0oo(bytes, "bytes");
        if ((bytes[1] & 16) > 0) {
            return true;
        }
        return false;
    }

    public final boolean isValid(@OOXIXo byte[] bytes) {
        IIX0o.x0xO0oo(bytes, "bytes");
        if (bytes.length < 9) {
            OI0.oIX0oI.f1507oIX0oI.Oxx0IOOO("MessageFactory isValid -> size is not enough");
            return false;
        }
        if ((bytes[1] & 32) > 0) {
            OI0.oIX0oI.f1507oIX0oI.Oxx0IOOO("MessageFactory isValid -> is nack");
            return false;
        }
        int calculateCrc16 = calculateCrc16(bytes, 6);
        int int$default = ByteArrayExtKt.getInt$default(bytes, 4, 2, null, 4, null);
        if (calculateCrc16 != int$default) {
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append("MessageFactory isValid -> crc is wrong, crcShouldBe=");
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format("0x%04X", Arrays.copyOf(new Object[]{Integer.valueOf(calculateCrc16)}, 1));
            IIX0o.oO(format, "format(...)");
            sb.append(format);
            sb.append(", crcReceived=");
            String format2 = String.format("0x%04X", Arrays.copyOf(new Object[]{Integer.valueOf(int$default)}, 1));
            IIX0o.oO(format2, "format(...)");
            sb.append(format2);
            oix0oi.Oxx0IOOO(sb.toString());
        }
        if (calculateCrc16 == int$default) {
            return true;
        }
        return false;
    }
}
