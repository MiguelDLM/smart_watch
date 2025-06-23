package com.realsil.sdk.core.bluetooth.utils;

import android.os.ParcelUuid;
import androidx.annotation.NonNull;
import com.realsil.sdk.core.a.a;
import com.szabh.smable3.entity.BleWatchFaceId;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

/* loaded from: classes11.dex */
public final class BluetoothUuid {
    public static final ParcelUuid[] A2DP_SINK_PROFILE_UUIDS;
    public static final ParcelUuid[] A2DP_SRC_PROFILE_UUIDS;
    public static final ParcelUuid ADV_AUDIO_DIST;
    public static final ParcelUuid AUDIO_SINK;
    public static final ParcelUuid AUDIO_SOURCE;
    public static final ParcelUuid AVRCP_CONTROLLER;
    public static final ParcelUuid AVRCP_TARGET;
    public static final ParcelUuid BASE_UUID;
    public static final ParcelUuid BNEP;
    public static final ParcelUuid HANDSFREE;
    public static final ParcelUuid HANDSFREE_AG;
    public static final ParcelUuid[] HEADSET_PROFILE_UUIDS;
    public static final ParcelUuid HID;
    public static final ParcelUuid[] HID_PROFILE_UUIDS;
    public static final ParcelUuid HOGP;
    public static final ParcelUuid HSP;
    public static final ParcelUuid HSP_AG;
    public static final ParcelUuid MAP;
    public static final ParcelUuid MAS;
    public static final ParcelUuid MNS;
    public static final ParcelUuid NAP;
    public static final ParcelUuid[] NAP_PROFILE_UUIDS;
    public static final ParcelUuid OBEX_OBJECT_PUSH;
    public static final ParcelUuid[] OPP_PROFILE_UUIDS;
    public static final ParcelUuid PANU;
    public static final ParcelUuid[] PANU_PROFILE_UUIDS;
    public static final ParcelUuid PBAP_PCE;
    public static final ParcelUuid PBAP_PSE;
    public static final ParcelUuid[] RESERVED_UUIDS;
    public static final int UUID_BYTES_128_BIT = 16;
    public static final int UUID_BYTES_16_BIT = 2;
    public static final int UUID_BYTES_32_BIT = 4;

    static {
        ParcelUuid fromString = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
        AUDIO_SINK = fromString;
        ParcelUuid fromString2 = ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
        AUDIO_SOURCE = fromString2;
        ParcelUuid fromString3 = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
        ADV_AUDIO_DIST = fromString3;
        ParcelUuid fromString4 = ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
        HSP = fromString4;
        HSP_AG = ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
        ParcelUuid fromString5 = ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
        HANDSFREE = fromString5;
        HANDSFREE_AG = ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
        ParcelUuid fromString6 = ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
        AVRCP_CONTROLLER = fromString6;
        ParcelUuid fromString7 = ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
        AVRCP_TARGET = fromString7;
        ParcelUuid fromString8 = ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
        OBEX_OBJECT_PUSH = fromString8;
        ParcelUuid fromString9 = ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");
        HID = fromString9;
        HOGP = ParcelUuid.fromString("00001812-0000-1000-8000-00805f9b34fb");
        ParcelUuid fromString10 = ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
        PANU = fromString10;
        ParcelUuid fromString11 = ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
        NAP = fromString11;
        BNEP = ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
        PBAP_PCE = ParcelUuid.fromString("0000112e-0000-1000-8000-00805F9B34FB");
        PBAP_PSE = ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
        ParcelUuid fromString12 = ParcelUuid.fromString("00001134-0000-1000-8000-00805F9B34FB");
        MAP = fromString12;
        ParcelUuid fromString13 = ParcelUuid.fromString("00001133-0000-1000-8000-00805F9B34FB");
        MNS = fromString13;
        ParcelUuid fromString14 = ParcelUuid.fromString("00001132-0000-1000-8000-00805F9B34FB");
        MAS = fromString14;
        BASE_UUID = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
        HEADSET_PROFILE_UUIDS = new ParcelUuid[]{fromString4, fromString5};
        A2DP_SINK_PROFILE_UUIDS = new ParcelUuid[]{fromString, fromString3};
        A2DP_SRC_PROFILE_UUIDS = new ParcelUuid[]{fromString2};
        OPP_PROFILE_UUIDS = new ParcelUuid[]{fromString8};
        HID_PROFILE_UUIDS = new ParcelUuid[]{fromString9};
        PANU_PROFILE_UUIDS = new ParcelUuid[]{fromString10};
        NAP_PROFILE_UUIDS = new ParcelUuid[]{fromString11};
        RESERVED_UUIDS = new ParcelUuid[]{fromString, fromString2, fromString3, fromString4, fromString5, fromString6, fromString7, fromString8, fromString10, fromString11, fromString12, fromString13, fromString14};
    }

    public static boolean a(@NonNull UUID uuid) {
        if ((uuid.getMostSignificantBits() & (-281470681743361L)) == 0 && uuid.getLeastSignificantBits() == 0) {
            return true;
        }
        return false;
    }

    public static boolean containsAllUuids(ParcelUuid[] parcelUuidArr, ParcelUuid[] parcelUuidArr2) {
        if (parcelUuidArr == null && parcelUuidArr2 == null) {
            return true;
        }
        if (parcelUuidArr == null) {
            if (parcelUuidArr2.length == 0) {
                return true;
            }
            return false;
        }
        if (parcelUuidArr2 == null) {
            return true;
        }
        HashSet hashSet = new HashSet(Arrays.asList(parcelUuidArr));
        for (ParcelUuid parcelUuid : parcelUuidArr2) {
            if (!hashSet.contains(parcelUuid)) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsAnyUuid(ParcelUuid[] parcelUuidArr, ParcelUuid[] parcelUuidArr2) {
        if (parcelUuidArr == null && parcelUuidArr2 == null) {
            return true;
        }
        if (parcelUuidArr == null) {
            if (parcelUuidArr2.length == 0) {
                return true;
            }
            return false;
        }
        if (parcelUuidArr2 == null) {
            if (parcelUuidArr.length == 0) {
                return true;
            }
            return false;
        }
        HashSet hashSet = new HashSet(Arrays.asList(parcelUuidArr));
        for (ParcelUuid parcelUuid : parcelUuidArr2) {
            if (hashSet.contains(parcelUuid)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public static UUID fromShortValue(int i) {
        StringBuilder a2 = a.a("0000");
        a2.append(String.format("%04X", Integer.valueOf(i & 65535)));
        a2.append("-0000-1000-8000-00805F9B34FB");
        return UUID.fromString(a2.toString());
    }

    @NonNull
    public static UUID fromString(@NonNull String str) {
        try {
            return UUID.fromString(str);
        } catch (IllegalArgumentException unused) {
            return UUID.fromString("0000" + str + "-0000-1000-8000-00805F9B34FB");
        }
    }

    public static int getServiceIdentifierFromParcelUuid(ParcelUuid parcelUuid) {
        return (int) ((parcelUuid.getUuid().getMostSignificantBits() & 281470681743360L) >>> 32);
    }

    public static boolean is16BitUuid(ParcelUuid parcelUuid) {
        UUID uuid = parcelUuid.getUuid();
        if (uuid.getLeastSignificantBits() == BASE_UUID.getUuid().getLeastSignificantBits() && (uuid.getMostSignificantBits() & (-281470681743361L)) == 4096) {
            return true;
        }
        return false;
    }

    public static boolean is32BitUuid(ParcelUuid parcelUuid) {
        UUID uuid = parcelUuid.getUuid();
        if (uuid.getLeastSignificantBits() != BASE_UUID.getUuid().getLeastSignificantBits() || is16BitUuid(parcelUuid) || (uuid.getMostSignificantBits() & BleWatchFaceId.WATCHFACE_ID_INVALID) != 4096) {
            return false;
        }
        return true;
    }

    public static boolean isAdvAudioDist(ParcelUuid parcelUuid) {
        return parcelUuid.equals(ADV_AUDIO_DIST);
    }

    public static boolean isAudioSink(ParcelUuid parcelUuid) {
        return parcelUuid.equals(AUDIO_SINK);
    }

    public static boolean isAudioSource(ParcelUuid parcelUuid) {
        return parcelUuid.equals(AUDIO_SOURCE);
    }

    public static boolean isAvrcpController(ParcelUuid parcelUuid) {
        return parcelUuid.equals(AVRCP_CONTROLLER);
    }

    public static boolean isAvrcpTarget(ParcelUuid parcelUuid) {
        return parcelUuid.equals(AVRCP_TARGET);
    }

    public static boolean isBnep(ParcelUuid parcelUuid) {
        return parcelUuid.equals(BNEP);
    }

    public static boolean isHandsfree(ParcelUuid parcelUuid) {
        return parcelUuid.equals(HANDSFREE);
    }

    public static boolean isHeadset(ParcelUuid parcelUuid) {
        return parcelUuid.equals(HSP);
    }

    public static boolean isInputDevice(ParcelUuid parcelUuid) {
        return parcelUuid.equals(HID);
    }

    public static boolean isMap(ParcelUuid parcelUuid) {
        return parcelUuid.equals(MAP);
    }

    public static boolean isMas(ParcelUuid parcelUuid) {
        return parcelUuid.equals(MAS);
    }

    public static boolean isMns(ParcelUuid parcelUuid) {
        return parcelUuid.equals(MNS);
    }

    public static boolean isNap(ParcelUuid parcelUuid) {
        return parcelUuid.equals(NAP);
    }

    public static boolean isPanu(ParcelUuid parcelUuid) {
        return parcelUuid.equals(PANU);
    }

    public static boolean isUuidPresent(ParcelUuid[] parcelUuidArr, ParcelUuid parcelUuid) {
        if ((parcelUuidArr == null || parcelUuidArr.length == 0) && parcelUuid == null) {
            return true;
        }
        if (parcelUuidArr == null) {
            return false;
        }
        for (ParcelUuid parcelUuid2 : parcelUuidArr) {
            if (parcelUuid2.equals(parcelUuid)) {
                return true;
            }
        }
        return false;
    }

    public static boolean matches(@NonNull UUID uuid, @NonNull UUID uuid2) {
        if (!a(uuid) && !a(uuid2)) {
            return uuid.equals(uuid2);
        }
        if ((uuid.getMostSignificantBits() & 281470681743360L) == (uuid2.getMostSignificantBits() & 281470681743360L)) {
            return true;
        }
        return false;
    }

    @NonNull
    public static ParcelUuid parcelFromShortValue(int i) {
        StringBuilder a2 = a.a("0000");
        a2.append(String.format("%04X", Integer.valueOf(i & 65535)));
        a2.append("-0000-1000-8000-00805F9B34FB");
        return ParcelUuid.fromString(a2.toString());
    }

    public static ParcelUuid parseUuidFrom(byte[] bArr) {
        long j;
        if (bArr != null) {
            int length = bArr.length;
            if (length != 2 && length != 4 && length != 16) {
                throw new IllegalArgumentException("uuidBytes length invalid - " + length);
            }
            if (length == 16) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
            }
            if (length == 2) {
                j = (bArr[0] & 255) + ((bArr[1] & 255) << 8);
            } else {
                j = ((bArr[3] & 255) << 24) + (bArr[0] & 255) + ((bArr[1] & 255) << 8) + ((bArr[2] & 255) << 16);
            }
            ParcelUuid parcelUuid = BASE_UUID;
            return new ParcelUuid(new UUID(parcelUuid.getUuid().getMostSignificantBits() + (j << 32), parcelUuid.getUuid().getLeastSignificantBits()));
        }
        throw new IllegalArgumentException("uuidBytes cannot be null");
    }

    public static ParcelUuid parseUuidReverse(byte[] bArr) {
        long j;
        if (bArr != null) {
            int length = bArr.length;
            if (length != 2 && length != 4 && length != 16) {
                throw new IllegalArgumentException("uuidBytes length invalid - " + length);
            }
            if (length == 16) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
            }
            if (length == 2) {
                j = (bArr[1] & 255) + ((bArr[0] & 255) << 8);
            } else {
                j = ((bArr[0] & 255) << 24) + (bArr[3] & 255) + ((bArr[2] & 255) << 8) + ((bArr[1] & 255) << 16);
            }
            ParcelUuid parcelUuid = BASE_UUID;
            return new ParcelUuid(new UUID(parcelUuid.getUuid().getMostSignificantBits() + (j << 32), parcelUuid.getUuid().getLeastSignificantBits()));
        }
        throw new IllegalArgumentException("uuidBytes cannot be null");
    }

    public static int toShortValue(@NonNull UUID uuid) {
        return (int) ((uuid.getMostSignificantBits() >> 32) & 65535);
    }
}
