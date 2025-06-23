package com.jieli.bluetooth_connect.util;

import android.text.TextUtils;
import com.jieli.bluetooth_connect.bean.BluetoothOption;
import com.jieli.bluetooth_connect.bean.ble.BleScanMessage;
import com.jieli.bt.decryption.HashDecryption;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes10.dex */
public class ParseDataUtil {
    private static final String TAG = "ParseDataUtil";
    private static final char[] mChars = "0123456789ABCDEF".toCharArray();

    public static String hexDataCovetToAddress(byte[] data) {
        StringBuilder sb = new StringBuilder();
        if (data != null && data.length == 6) {
            for (int i = 0; i < data.length; i++) {
                char[] cArr = mChars;
                sb.append(cArr[(data[i] & 255) >> 4]);
                sb.append(cArr[data[i] & 15]);
                if (i != data.length - 1) {
                    sb.append(":");
                }
            }
        }
        return sb.toString();
    }

    public static BleScanMessage isFilterBleDevice(BluetoothOption option, byte[] scanData) {
        char c;
        if (option == null || scanData == null || scanData.length <= 0) {
            return null;
        }
        int length = scanData.length;
        int i = 0;
        while (true) {
            int i2 = i + 2;
            if (i2 > length) {
                return null;
            }
            int byteToInt = CHexConverter.byteToInt(scanData[i]);
            if (byteToInt == 0) {
                i++;
            } else {
                if (byteToInt < 1 || byteToInt >= length - i) {
                    return null;
                }
                int i3 = i + 1;
                if (CHexConverter.byteToInt(scanData[i3]) == 255) {
                    if (i3 + byteToInt > length) {
                        JL_Log.e(TAG, "isFilterBleDevice", "totalLen is error.");
                        return null;
                    }
                    int i4 = byteToInt - 1;
                    byte[] bArr = new byte[i4];
                    System.arraycopy(scanData, i2, bArr, 0, i4);
                    if (i4 <= 2) {
                        return null;
                    }
                    byte[] bArr2 = new byte[2];
                    System.arraycopy(bArr, 0, bArr2, 0, 2);
                    int bytesToInt = CHexConverter.bytesToInt(bArr2[1], bArr2[0]);
                    int i5 = byteToInt - 3;
                    byte[] bArr3 = new byte[i5];
                    System.arraycopy(bArr, 2, bArr3, 0, i5);
                    BleScanMessage parseWithOTAFlagFilter = parseWithOTAFlagFilter(bArr, option.getOtaScanFilterData());
                    if (parseWithOTAFlagFilter == null) {
                        int bleScanStrategy = option.getBleScanStrategy();
                        if (bleScanStrategy != 1) {
                            if (bleScanStrategy != 2) {
                                if (bleScanStrategy == 3) {
                                    parseWithOTAFlagFilter = parseBleScanMsg(3, bArr3, bArr);
                                    c = 3;
                                }
                            } else {
                                parseWithOTAFlagFilter = parseBleScanMsg(2, bArr3, bArr);
                            }
                            c = 2;
                        } else {
                            parseWithOTAFlagFilter = parseBleScanMsg(3, bArr3, bArr);
                            if (parseWithOTAFlagFilter == null) {
                                parseWithOTAFlagFilter = parseBleScanMsg(2, bArr3, bArr);
                                c = 2;
                            }
                            c = 3;
                        }
                        if (parseWithOTAFlagFilter == null) {
                            return null;
                        }
                        if (c != 2) {
                            if (c != 3) {
                                return null;
                            }
                        } else {
                            parseWithOTAFlagFilter.setVid(bytesToInt);
                            String flagContent = parseWithOTAFlagFilter.getFlagContent();
                            if (TextUtils.isEmpty(flagContent) || !flagContent.equals(option.getScanFilterData())) {
                                return null;
                            }
                        }
                    }
                    return parseWithOTAFlagFilter;
                }
                i += byteToInt + 1;
            }
        }
    }

    private static BleScanMessage parseBleScanMsg(int filterWay, byte[] data, byte[] manufacturerData) {
        if (filterWay != 2) {
            if (filterWay != 3) {
                return null;
            }
            return parseWithHashFilter(manufacturerData);
        }
        return parseWithFlagFilter(data);
    }

    public static BleScanMessage parseOTAFlagFilterWithBroad(byte[] advData, String filterFlag) {
        BleScanMessage bleScanMessage = null;
        if (advData != null && advData.length > 2) {
            int i = 0;
            while (true) {
                int i2 = i + 2;
                if (i2 <= advData.length) {
                    int byteToInt = CHexConverter.byteToInt(advData[i]);
                    if (byteToInt == 0) {
                        i++;
                    } else {
                        if (byteToInt < 1) {
                            break;
                        }
                        int i3 = i + 1;
                        if (i3 + byteToInt >= advData.length) {
                            break;
                        }
                        if (CHexConverter.byteToInt(advData[i3]) == 255) {
                            int i4 = byteToInt - 1;
                            byte[] bArr = new byte[i4];
                            System.arraycopy(advData, i2, bArr, 0, i4);
                            bleScanMessage = parseWithOTAFlagFilter(bArr, filterFlag);
                            if (bleScanMessage != null) {
                                break;
                            }
                        }
                        i += byteToInt + 1;
                    }
                } else {
                    break;
                }
            }
        }
        return bleScanMessage;
    }

    private static BleScanMessage parseTwsADV(byte[] data, BleScanMessage message) {
        if (data == null || message == null) {
            return null;
        }
        int deviceType = message.getDeviceType();
        if (deviceType != 0) {
            if (deviceType != 1) {
                if (deviceType != 2) {
                    if (deviceType != 3) {
                        if (deviceType != 4) {
                            if (deviceType != 5) {
                                return null;
                            }
                            return parseWithWatch(data, message);
                        }
                    } else {
                        return parseWithTwsVer2(data, message);
                    }
                }
            } else {
                return parseWithChargingBin(data, message);
            }
        }
        return parseWithTwsVer1(data, message);
    }

    private static BleScanMessage parseWithChargingBin(byte[] data, BleScanMessage message) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (message == null || message.getVersion() > 1 || (message.getVersion() == 0 && data.length != 29)) {
            return null;
        }
        if (data.length < 16) {
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(data);
        wrap.get(new byte[7]);
        byte[] bArr = new byte[6];
        ByteBuffer byteBuffer = wrap.get(bArr);
        String hexDataCovetToAddress = hexDataCovetToAddress(bArr);
        byte b = byteBuffer.get();
        int i = (b >> 7) & 1;
        int i2 = (b >> 6) & 1;
        int i3 = b & 15;
        byte b2 = byteBuffer.get();
        int i4 = (b2 >> 7) & 1;
        int i5 = b2 & Byte.MAX_VALUE;
        byte b3 = byteBuffer.get();
        int i6 = (b3 >> 7) & 1;
        int i7 = b3 & Byte.MAX_VALUE;
        byte b4 = byteBuffer.get();
        int i8 = (b4 >> 7) & 1;
        int i9 = b4 & Byte.MAX_VALUE;
        int byteToInt = CHexConverter.byteToInt(byteBuffer.get());
        if (message.getVersion() == 0) {
            int i10 = (byteBuffer.get() >> 7) & 1;
            byte[] bArr2 = new byte[8];
            byteBuffer.get(new byte[2]).get(bArr2).rewind();
            byte[] bArr3 = new byte[16];
            System.arraycopy(data, 0, bArr3, 0, 16);
            byte[] bArr4 = {b, b2, b3, b4};
            byte[] bArr5 = new byte[16];
            HashDecryption.decrypt(bArr3, 16, bArr4, 4, bArr5);
            byte[] bArr6 = new byte[8];
            int i11 = 0;
            while (i11 < 8) {
                int i12 = i11 + 1;
                bArr6[i11] = bArr5[i11 + i12];
                i11 = i12;
            }
            if (Arrays.equals(bArr2, bArr6)) {
                BleScanMessage edrStatus = message.setEdrAddr(hexDataCovetToAddress).setSeq(byteToInt).setTwsFlag(i).setChargingBinStatus(i2).setAction(i3).setEdrStatus(i3);
                if (i4 == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                BleScanMessage leftDeviceQuantity = edrStatus.setLeftCharging(z4).setLeftDeviceQuantity(i5);
                if (i6 == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                BleScanMessage rightDeviceQuantity = leftDeviceQuantity.setRightCharging(z5).setRightDeviceQuantity(i7);
                if (i8 == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                rightDeviceQuantity.setDeviceCharging(z6).setChargingBinQuantity(i9).setChargingBinMode(i10).setHash(bArr2);
                return message;
            }
            return null;
        }
        byteBuffer.rewind();
        BleScanMessage edrStatus2 = message.setEdrAddr(hexDataCovetToAddress).setSeq(byteToInt).setTwsFlag(i).setChargingBinStatus(i2).setAction(i3).setEdrStatus(i3);
        if (i4 == 1) {
            z = true;
        } else {
            z = false;
        }
        BleScanMessage leftDeviceQuantity2 = edrStatus2.setLeftCharging(z).setLeftDeviceQuantity(i5);
        if (i6 == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        BleScanMessage rightDeviceQuantity2 = leftDeviceQuantity2.setRightCharging(z2).setRightDeviceQuantity(i7);
        if (i8 == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        rightDeviceQuantity2.setDeviceCharging(z3).setChargingBinQuantity(i9);
        return message;
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x00b0, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.jieli.bluetooth_connect.bean.ble.BleScanMessage parseWithFlagFilter(byte[] r12) {
        /*
            r0 = 0
            if (r12 == 0) goto Lb0
            int r1 = r12.length
            if (r1 <= 0) goto Lb0
            int r1 = r12.length
            r2 = 0
            r4 = r0
            r3 = 0
        La:
            int r5 = r3 + 2
            if (r5 > r1) goto Laf
            r6 = r12[r3]
            int r6 = com.jieli.bluetooth_connect.util.CHexConverter.byteToInt(r6)
            if (r6 <= 0) goto Laf
            int r7 = r3 + 1
            r7 = r12[r7]
            int r7 = com.jieli.bluetooth_connect.util.CHexConverter.byteToInt(r7)
            int r8 = r6 + (-1)
            byte[] r9 = new byte[r8]
            if (r8 <= 0) goto Lae
            int r10 = r8 + r3
            r11 = 2
            int r10 = r10 + r11
            if (r10 > r1) goto Lae
            java.lang.System.arraycopy(r12, r5, r9, r2, r8)
            int r6 = r6 + 1
            int r3 = r3 + r6
            if (r4 != 0) goto L37
            com.jieli.bluetooth_connect.bean.ble.BleScanMessage r4 = new com.jieli.bluetooth_connect.bean.ble.BleScanMessage
            r4.<init>()
        L37:
            if (r7 == 0) goto La4
            r5 = 1
            if (r7 == r5) goto L97
            if (r7 == r11) goto L92
            r6 = 3
            if (r7 == r6) goto L76
            r6 = 4
            if (r7 == r6) goto L45
            goto La
        L45:
            r6 = 6
            if (r8 < r6) goto La
            byte[] r7 = new byte[r6]
            java.lang.System.arraycopy(r9, r2, r7, r2, r6)
            java.lang.String r7 = hexDataCovetToAddress(r7)
            r4.setEdrAddr(r7)
            r7 = 7
            if (r8 < r7) goto La
            r6 = r9[r6]
            int r6 = com.jieli.bluetooth_connect.util.CHexConverter.byteToInt(r6)
            r4.setEdrStatus(r6)
            r6 = 8
            if (r8 < r6) goto La
            r6 = r9[r7]
            int r7 = r6 >> 7
            r7 = r7 & r5
            r6 = r6 & 127(0x7f, float:1.78E-43)
            if (r7 != r5) goto L6e
            goto L6f
        L6e:
            r5 = 0
        L6f:
            r4.setLeftCharging(r5)
            r4.setLeftDeviceQuantity(r6)
            goto La
        L76:
            if (r8 < r6) goto La
            r6 = r9[r5]
            r7 = r9[r2]
            int r6 = com.jieli.bluetooth_connect.util.CHexConverter.bytesToInt(r6, r7)
            r4.setPid(r6)
            r6 = r9[r11]
            int r6 = com.jieli.bluetooth_connect.util.CHexConverter.byteToInt(r6)
            if (r6 != r5) goto L8c
            goto L8d
        L8c:
            r5 = 0
        L8d:
            r4.setShowDialog(r5)
            goto La
        L92:
            r4.setPhoneVirtualAddress(r9)
            goto La
        L97:
            if (r8 != r5) goto La
            r5 = r9[r2]
            int r5 = com.jieli.bluetooth_connect.util.CHexConverter.byteToInt(r5)
            r4.setPairedFlag(r5)
            goto La
        La4:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r9)
            r4.setFlagContent(r5)
            goto La
        Lae:
            return r0
        Laf:
            r0 = r4
        Lb0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.bluetooth_connect.util.ParseDataUtil.parseWithFlagFilter(byte[]):com.jieli.bluetooth_connect.bean.ble.BleScanMessage");
    }

    private static BleScanMessage parseWithHashFilter(byte[] data) {
        if (data != null && data.length >= 7) {
            byte[] bArr = new byte[2];
            ByteBuffer byteBuffer = ByteBuffer.wrap(data).get(bArr);
            int bytesToInt = CHexConverter.bytesToInt(bArr[1], bArr[0]);
            ByteBuffer byteBuffer2 = byteBuffer.get(bArr);
            int bytesToInt2 = CHexConverter.bytesToInt(bArr[1], bArr[0]);
            ByteBuffer byteBuffer3 = byteBuffer2.get(bArr);
            int bytesToInt3 = CHexConverter.bytesToInt(bArr[1], bArr[0]);
            byte b = byteBuffer3.get();
            BleScanMessage showDialog = new BleScanMessage().setVid(bytesToInt).setUid(bytesToInt2).setPid(bytesToInt3).setDeviceType((b >> 4) & 255).setVersion(b & 15).setShowDialog(true);
            if (data.length > 7) {
                return parseTwsADV(data, showDialog);
            }
        }
        return null;
    }

    public static BleScanMessage parseWithOTAFlagFilter(byte[] manufacturerData, String filterFlag) {
        if (manufacturerData == null || filterFlag == null || filterFlag.length() == 0 || manufacturerData.length <= filterFlag.getBytes().length + 2) {
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(manufacturerData);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        short s = wrap.getShort();
        byte[] bArr = new byte[filterFlag.getBytes().length];
        ByteBuffer byteBuffer = wrap.get(bArr);
        if (!Arrays.equals(reverseBuf(bArr), filterFlag.getBytes())) {
            return null;
        }
        int byteToInt = CHexConverter.byteToInt(byteBuffer.get());
        JL_Log.d(TAG, "parseWithOTAFlagFilter", "version :" + byteToInt);
        if (byteToInt != 0) {
            if (byteToInt != 1) {
                JL_Log.i(TAG, "parseWithOTAFlagFilter", "Not support version : " + byteToInt);
                return null;
            }
            byte[] bArr2 = new byte[6];
            ByteBuffer byteBuffer2 = byteBuffer.get(bArr2);
            String hexDataCovetToAddress = hexDataCovetToAddress(reverseBuf(bArr2));
            short s2 = byteBuffer2.getShort();
            short s3 = byteBuffer2.getShort();
            byte b = byteBuffer2.get();
            int byteToInt2 = CHexConverter.byteToInt(byteBuffer2.get());
            byte[] bArr3 = new byte[byteBuffer2.remaining()];
            byteBuffer2.get(bArr3);
            return new BleScanMessage().setOTA(true).setOtaADVVersion(byteToInt).setOtaBleAddress(hexDataCovetToAddress).setVid(s).setUid(s2).setPid(s3).setDeviceType((b >> 4) & 255).setVersion(b & 15).setLeftDeviceQuantity(byteToInt2).setOtaADVReserve(bArr3);
        }
        byte[] bArr4 = new byte[6];
        ByteBuffer byteBuffer3 = byteBuffer.get(bArr4);
        String hexDataCovetToAddress2 = hexDataCovetToAddress(reverseBuf(bArr4));
        byte[] bArr5 = new byte[byteBuffer3.remaining()];
        byteBuffer3.get(bArr5);
        return new BleScanMessage().setOTA(true).setVid(s).setOtaADVVersion(byteToInt).setOtaBleAddress(hexDataCovetToAddress2).setOtaADVReserve(bArr5);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00ac A[LOOP:0: B:16:0x00aa->B:17:0x00ac, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012b A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.jieli.bluetooth_connect.bean.ble.BleScanMessage parseWithTwsVer1(byte[] r22, com.jieli.bluetooth_connect.bean.ble.BleScanMessage r23) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.bluetooth_connect.util.ParseDataUtil.parseWithTwsVer1(byte[], com.jieli.bluetooth_connect.bean.ble.BleScanMessage):com.jieli.bluetooth_connect.bean.ble.BleScanMessage");
    }

    private static BleScanMessage parseWithTwsVer2(byte[] data, BleScanMessage message) {
        boolean z;
        boolean z2;
        if (data.length < 10) {
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(data);
        wrap.get(new byte[7]);
        byte b = wrap.get();
        boolean z3 = true;
        int i = (b >> 7) & 1;
        int i2 = b & Byte.MAX_VALUE;
        byte b2 = wrap.get();
        int i3 = (b2 >> 7) & 1;
        int i4 = b2 & Byte.MAX_VALUE;
        byte b3 = wrap.get();
        int i5 = (b3 >> 7) & 1;
        int i6 = (b3 >> 6) & 1;
        int i7 = (b3 >> 5) & 1;
        int i8 = b3 & 15;
        BleScanMessage mainDevFlag = message.setTwsFlag(i5).setMainDevFlag(i6);
        if (i7 == 1) {
            z = true;
        } else {
            z = false;
        }
        BleScanMessage action = mainDevFlag.setEnableConnect(z).setAction(i8);
        if (i == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        BleScanMessage leftDeviceQuantity = action.setLeftCharging(z2).setLeftDeviceQuantity(i2);
        if (i3 != 1) {
            z3 = false;
        }
        leftDeviceQuantity.setRightCharging(z3).setRightDeviceQuantity(i4);
        return message;
    }

    private static BleScanMessage parseWithWatch(byte[] data, BleScanMessage message) {
        if (data.length < 14) {
            return null;
        }
        byte[] bArr = new byte[6];
        System.arraycopy(data, 7, bArr, 0, 6);
        message.setEdrAddr(hexDataCovetToAddress(bArr));
        int i = data[13];
        message.setConnectWay((i >> 7) & 1);
        message.setAction(i & 15);
        return message;
    }

    private static byte[] reverseBuf(byte[] data) {
        if (data != null && data.length > 1) {
            byte[] bArr = new byte[data.length];
            for (int i = 0; i < data.length; i++) {
                bArr[i] = data[(data.length - i) - 1];
            }
            return bArr;
        }
        return data;
    }
}
