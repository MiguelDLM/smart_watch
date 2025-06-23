package com.jieli.jl_bt_ota.tool;

import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.jieli.jl_bt_ota.constant.Command;
import com.jieli.jl_bt_ota.interfaces.command.ICmdHandler;
import com.jieli.jl_bt_ota.model.base.BasePacket;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.model.cmdHandler.RcspCmdHandler;
import com.jieli.jl_bt_ota.model.parameter.tws.NotifyAdvInfoParam;
import com.jieli.jl_bt_ota.model.response.TargetInfoResponse;
import com.jieli.jl_bt_ota.util.CHexConver;
import com.jieli.jl_bt_ota.util.CommonUtil;
import com.jieli.jl_bt_ota.util.JL_Log;
import com.kuaishou.weapon.p0.t;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes10.dex */
public class ParseHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17769a = "ParseHelper";
    private static final byte b = -2;
    private static final byte c = -36;
    private static final byte d = -70;
    private static final byte e = -17;
    private static byte[] g;
    private static int h;
    private static final byte[] f = {-2, -36, -70};
    private static final char[] i = "0123456789ABCDEF".toCharArray();

    private static int a(byte[] bArr, int i2, int i3) {
        int length = bArr.length;
        while (i2 < length) {
            if (bArr[i2] == -2) {
                int i4 = length - i2;
                byte[] bArr2 = f;
                if (i4 < bArr2.length) {
                    b(bArr, i2, i4);
                    return -1;
                }
                int length2 = bArr2.length;
                byte[] bArr3 = new byte[length2];
                System.arraycopy(bArr, i2, bArr3, 0, length2);
                if (!Arrays.equals(bArr3, bArr2)) {
                    continue;
                } else {
                    if (i4 <= bArr2.length + 4) {
                        b(bArr, i2, i4);
                        return -1;
                    }
                    int length3 = bArr2.length + i2;
                    byte[] bArr4 = new byte[2];
                    System.arraycopy(bArr, length3 + 2, bArr4, 0, 2);
                    int bytesToInt = CHexConver.bytesToInt(bArr4[0], bArr4[1]);
                    if (bytesToInt > i3 - 8) {
                        JL_Log.e(f17769a, "findPacketData", CommonUtil.formatString("data length[%d] over MAX_RECEIVE_MTU[%d], cast away", Integer.valueOf(bytesToInt), Integer.valueOf(i3)));
                    } else {
                        if (i4 <= bArr2.length + 4 + bytesToInt) {
                            int i5 = length - length3;
                            byte[] bArr5 = new byte[i5];
                            System.arraycopy(bArr, length3, bArr5, 0, i5);
                            int a2 = a(bArr5, 0, i3);
                            String str = f17769a;
                            JL_Log.i(str, "findPacketData", "check left data, index = " + a2);
                            if (a2 < bArr2.length) {
                                b(bArr, i2, i4);
                                return -1;
                            }
                            int i6 = length3 + a2;
                            JL_Log.w(str, "findPacketData", "found headIndex = " + i6);
                            return i6;
                        }
                        if (bArr[length3 + 4 + bytesToInt] == -17) {
                            return length3;
                        }
                    }
                    i2 = length3 - 1;
                }
            }
            i2++;
        }
        return -1;
    }

    private static byte[] b(byte[] bArr) {
        int length = bArr.length;
        int i2 = h;
        if (i2 > 0) {
            byte[] bArr2 = new byte[i2 + length];
            System.arraycopy(g, 0, bArr2, 0, i2);
            System.arraycopy(bArr, 0, bArr2, h, length);
            h = 0;
            return bArr2;
        }
        return (byte[]) bArr.clone();
    }

    private static BasePacket c(byte[] bArr) {
        int i2;
        if (bArr != null && bArr.length >= 4) {
            byte[] booleanArrayBig = CHexConver.getBooleanArrayBig(bArr[0]);
            int byteToInt = CHexConver.byteToInt(bArr[1]);
            int bytesToInt = CHexConver.bytesToInt(bArr, 2, 2);
            BasePacket basePacket = new BasePacket();
            int byteToInt2 = CHexConver.byteToInt(booleanArrayBig[7]);
            int byteToInt3 = CHexConver.byteToInt(booleanArrayBig[6]);
            basePacket.setType(byteToInt2);
            basePacket.setHasResponse(byteToInt3);
            basePacket.setOpCode(byteToInt);
            basePacket.setParamLen(bytesToInt);
            if (bytesToInt > 0) {
                if (byteToInt2 == 0) {
                    basePacket.setStatus(CHexConver.byteToInt(bArr[4]));
                    i2 = 5;
                } else {
                    i2 = 4;
                }
                basePacket.setOpCodeSn(CHexConver.byteToInt(bArr[i2]));
                int i3 = i2 + 1;
                if (byteToInt == 1) {
                    basePacket.setXmOpCode(CHexConver.byteToInt(bArr[i3]));
                    i3 = i2 + 2;
                }
                int i4 = bytesToInt - (i3 - 4);
                byte[] bArr2 = new byte[i4];
                System.arraycopy(bArr, i3, bArr2, 0, i4);
                basePacket.setParamData(bArr2);
                JL_Log.d(f17769a, "parsePacketData", CommonUtil.formatString("packet type : %d, opCode : %d, sn :%d", Integer.valueOf(basePacket.getType()), Integer.valueOf(basePacket.getOpCode()), Integer.valueOf(basePacket.getOpCodeSn())));
                return basePacket;
            }
            return basePacket;
        }
        return null;
    }

    public static BasePacket convert2BasePacket(CommandBase commandBase, int i2) {
        boolean z;
        if (commandBase == null) {
            return null;
        }
        int i3 = 0;
        if (i2 == 1) {
            z = true;
        } else {
            z = false;
        }
        int type = commandBase.getType();
        int i4 = 2;
        if (z && (type == 2 || type == 3)) {
            i3 = 1;
        }
        BasePacket status = new BasePacket().setType(i2).setHasResponse(i3).setOpCode(commandBase.getId()).setOpCodeSn(commandBase.getOpCodeSn()).setStatus(commandBase.getStatus());
        if (z) {
            i4 = 1;
        }
        if (commandBase.getParam() != null) {
            if (status.getOpCode() == 1) {
                status.setXmOpCode(commandBase.getParam().getXmOpCode());
                i4++;
            }
            byte[] paramData = commandBase.getParam().getParamData();
            if (paramData != null && paramData.length > 0) {
                status.setParamData(paramData);
                i4 += paramData.length;
            }
        }
        status.setParamLen(i4);
        return status;
    }

    public static CommandBase convert2Command(BasePacket basePacket, CommandBase commandBase) {
        if (basePacket != null) {
            CommandBase a2 = a(basePacket, commandBase);
            if (a2 != null) {
                return a2;
            }
            return new RcspCmdHandler().parseDataToCmd(basePacket, commandBase);
        }
        return null;
    }

    public static int convertVersionByString(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        JL_Log.i(f17769a, "convertVersionByString", "version = " + str);
        String[] split = str.replace(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "").replace(t.c, "").split("\\.");
        int length = split.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < split.length; i2++) {
            String str2 = split[i2];
            if (TextUtils.isDigitsOnly(str2)) {
                iArr[i2] = Integer.parseInt(str2);
            }
        }
        if (length != 4) {
            return 0;
        }
        byte[] booleanArray = CHexConver.getBooleanArray((byte) iArr[0]);
        byte[] booleanArray2 = CHexConver.getBooleanArray((byte) iArr[1]);
        byte[] bArr = new byte[8];
        System.arraycopy(booleanArray, 4, bArr, 0, 4);
        System.arraycopy(booleanArray2, 4, bArr, 4, 4);
        byte a2 = (byte) a(bArr);
        byte[] booleanArray3 = CHexConver.getBooleanArray((byte) iArr[2]);
        byte[] booleanArray4 = CHexConver.getBooleanArray((byte) iArr[3]);
        byte[] bArr2 = new byte[8];
        System.arraycopy(booleanArray3, 4, bArr2, 0, 4);
        System.arraycopy(booleanArray4, 4, bArr2, 4, 4);
        byte a3 = (byte) a(bArr2);
        JL_Log.i(f17769a, "convertVersionByString", "versionCode : 0, heightValue : " + CHexConver.byte2HexStr(bArr) + ", lowValue : " + CHexConver.byte2HexStr(bArr2));
        return CHexConver.bytesToInt(a2, a3);
    }

    public static ArrayList<BasePacket> findPacketData(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
        return findPacketData(i2, bArr);
    }

    public static String hexDataCovetToAddress(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null && bArr.length == 6) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                char[] cArr = i;
                sb.append(cArr[(bArr[i2] & 255) >> 4]);
                sb.append(cArr[bArr[i2] & 15]);
                if (i2 != bArr.length - 1) {
                    sb.append(":");
                }
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] packSendBasePacket(com.jieli.jl_bt_ota.model.base.BasePacket r16) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_bt_ota.tool.ParseHelper.packSendBasePacket(com.jieli.jl_bt_ota.model.base.BasePacket):byte[]");
    }

    public static void parseNotifyADVInfo(NotifyAdvInfoParam notifyAdvInfoParam, BasePacket basePacket) {
        byte[] paramData;
        boolean z;
        boolean z2;
        boolean z3;
        if (basePacket != null && (paramData = basePacket.getParamData()) != null && paramData.length >= 18) {
            byte[] bArr = new byte[2];
            System.arraycopy(paramData, 0, bArr, 0, 2);
            int bytesToInt = CHexConver.bytesToInt(bArr[0], bArr[1]);
            System.arraycopy(paramData, 2, bArr, 0, 2);
            int bytesToInt2 = CHexConver.bytesToInt(bArr[0], bArr[1]);
            System.arraycopy(paramData, 4, bArr, 0, 2);
            int bytesToInt3 = CHexConver.bytesToInt(bArr[0], bArr[1]);
            byte b2 = paramData[6];
            byte[] bArr2 = new byte[6];
            System.arraycopy(paramData, 7, bArr2, 0, 6);
            String hexDataCovetToAddress = hexDataCovetToAddress(bArr2);
            int byteToInt = CHexConver.byteToInt(paramData[13]);
            byte b3 = paramData[14];
            int i2 = (b3 >> 7) & 1;
            int i3 = b3 & Byte.MAX_VALUE;
            byte b4 = paramData[15];
            int i4 = (b4 >> 7) & 1;
            int i5 = b4 & Byte.MAX_VALUE;
            byte b5 = paramData[16];
            int i6 = (b5 >> 7) & 1;
            int i7 = b5 & Byte.MAX_VALUE;
            byte b6 = paramData[17];
            NotifyAdvInfoParam action = notifyAdvInfoParam.setVid(bytesToInt).setUid(bytesToInt2).setPid(bytesToInt3).setDeviceType((b2 >> 4) & 255).setVersion(b2 & 15).setEdrAddr(hexDataCovetToAddress).setAction(byteToInt);
            if (i2 == 1) {
                z = true;
            } else {
                z = false;
            }
            NotifyAdvInfoParam leftDeviceQuantity = action.setLeftCharging(z).setLeftDeviceQuantity(i3);
            if (i4 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            NotifyAdvInfoParam rightDeviceQuantity = leftDeviceQuantity.setRightCharging(z2).setRightDeviceQuantity(i5);
            if (i6 == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            rightDeviceQuantity.setDeviceCharging(z3).setChargingBinQuantity(i7).setSeq(CHexConver.byteToInt(b6));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void parseTargetInfo(TargetInfoResponse targetInfoResponse, BasePacket basePacket) {
        int byteToInt;
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        String str2;
        boolean z4;
        boolean z5;
        int bytesToInt;
        byte[] paramData = basePacket.getParamData();
        if (paramData != null && paramData.length > 0) {
            int length = paramData.length;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 2;
                if (i3 <= length) {
                    byteToInt = CHexConver.byteToInt(paramData[i2]);
                    if (byteToInt > 0 && byteToInt < length) {
                        int byteToInt2 = CHexConver.byteToInt(paramData[i2 + 1]);
                        int i4 = byteToInt - 1;
                        byte[] bArr = new byte[i4];
                        if (i4 > 0 && i4 + i2 + 2 <= length) {
                            System.arraycopy(paramData, i3, bArr, 0, i4);
                            int i5 = i2 + byteToInt + 1;
                            JL_Log.d(f17769a, "parseTargetInfo", "type= " + byteToInt2 + "\t data=" + CHexConver.byte2HexStr(bArr, i4));
                            if (byteToInt2 != 0) {
                                if (byteToInt2 != 1) {
                                    if (byteToInt2 != 2) {
                                        if (byteToInt2 != 16) {
                                            if (byteToInt2 != 17) {
                                                if (byteToInt2 != 19) {
                                                    if (byteToInt2 != 31) {
                                                        switch (byteToInt2) {
                                                            case 4:
                                                                if (i4 >= 5) {
                                                                    byte[] bArr2 = new byte[4];
                                                                    System.arraycopy(bArr, 0, bArr2, 0, 4);
                                                                    targetInfoResponse.setFunctionMask(CHexConver.bytesToInt(bArr2)).setCurFunction(bArr[4]);
                                                                    break;
                                                                }
                                                                break;
                                                            case 5:
                                                                if (i4 >= 2) {
                                                                    int bytesToInt2 = CHexConver.bytesToInt(bArr[0], bArr[1]);
                                                                    targetInfoResponse.setVersionCode(bytesToInt2).setVersionName("V_" + ((bytesToInt2 >> 12) & 15) + FileUtils.FILE_EXTENSION_SEPARATOR + ((bytesToInt2 >> 8) & 15) + FileUtils.FILE_EXTENSION_SEPARATOR + ((bytesToInt2 >> 4) & 15) + FileUtils.FILE_EXTENSION_SEPARATOR + (bytesToInt2 & 15));
                                                                    break;
                                                                }
                                                                break;
                                                            case 6:
                                                                targetInfoResponse.setSdkType(CHexConver.byteToInt(bArr[0]));
                                                                break;
                                                            case 7:
                                                                if (i4 == 2) {
                                                                    byte[] booleanArray = CHexConver.getBooleanArray(bArr[0]);
                                                                    byte[] booleanArray2 = CHexConver.getBooleanArray(bArr[1]);
                                                                    StringBuilder sb = new StringBuilder();
                                                                    byte[] bArr3 = new byte[8];
                                                                    System.arraycopy(booleanArray, 0, bArr3, 4, 4);
                                                                    sb.append(a(bArr3));
                                                                    sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
                                                                    System.arraycopy(booleanArray, 4, bArr3, 4, 4);
                                                                    sb.append(a(bArr3));
                                                                    sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
                                                                    System.arraycopy(booleanArray2, 0, bArr3, 4, 4);
                                                                    sb.append(a(bArr3));
                                                                    sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
                                                                    System.arraycopy(booleanArray2, 4, bArr3, 4, 4);
                                                                    sb.append(a(bArr3));
                                                                    targetInfoResponse.setUbootVersionName(sb.toString()).setUbootVersionCode(CHexConver.bytesToInt(bArr[0], bArr[1]));
                                                                    break;
                                                                } else {
                                                                    String replace = new String(bArr).replace(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "").replace(t.c, "");
                                                                    targetInfoResponse.setUbootVersionName(replace);
                                                                    char[] charArray = replace.replace(FileUtils.FILE_EXTENSION_SEPARATOR, "").toCharArray();
                                                                    if (charArray.length >= 4) {
                                                                        targetInfoResponse.setUbootVersionCode(CHexConver.bytesToInt(CHexConver.decodeHexChar(charArray[0], charArray[1]), CHexConver.decodeHexChar(charArray[2], charArray[3])));
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                            case 8:
                                                                if (CHexConver.byteToInt(bArr[0]) == 1) {
                                                                    z4 = true;
                                                                } else {
                                                                    z4 = false;
                                                                }
                                                                targetInfoResponse.setSupportDoubleBackup(z4);
                                                                if (i4 >= 2) {
                                                                    if (CHexConver.byteToInt(bArr[1]) == 1) {
                                                                        z5 = true;
                                                                    } else {
                                                                        z5 = false;
                                                                    }
                                                                    targetInfoResponse.setNeedBootLoader(z5);
                                                                }
                                                                if (i4 >= 3) {
                                                                    targetInfoResponse.setSingleBackupOtaWay(CHexConver.byteToInt(bArr[2]));
                                                                    break;
                                                                }
                                                                break;
                                                            case 9:
                                                                targetInfoResponse.setMandatoryUpgradeFlag(CHexConver.byteToInt(bArr[0]));
                                                                if (i4 >= 2) {
                                                                    targetInfoResponse.setRequestOtaFlag(CHexConver.byteToInt(bArr[1]));
                                                                }
                                                                if (i4 >= 3) {
                                                                    targetInfoResponse.setExpandMode(CHexConver.byteToInt(bArr[2]));
                                                                    break;
                                                                }
                                                                break;
                                                            case 10:
                                                                if (i4 >= 4) {
                                                                    targetInfoResponse.setVid(CHexConver.bytesToInt(bArr[0], bArr[1])).setPid(CHexConver.bytesToInt(bArr[2], bArr[3]));
                                                                    if (i4 >= 6) {
                                                                        targetInfoResponse.setUid(CHexConver.bytesToInt(bArr[4], bArr[5]));
                                                                        break;
                                                                    } else {
                                                                        targetInfoResponse.setUid(targetInfoResponse.getVid());
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                            case 11:
                                                                try {
                                                                    str2 = new String(bArr);
                                                                } catch (Exception e2) {
                                                                    e2.printStackTrace();
                                                                    str2 = null;
                                                                }
                                                                targetInfoResponse.setAuthKey(str2);
                                                                break;
                                                            case 12:
                                                                try {
                                                                    str = new String(bArr);
                                                                } catch (Exception e3) {
                                                                    e3.printStackTrace();
                                                                    str = null;
                                                                }
                                                                targetInfoResponse.setProjectCode(str);
                                                                break;
                                                            case 13:
                                                                if (i4 >= 2) {
                                                                    int bytesToInt3 = CHexConver.bytesToInt(bArr[0], bArr[1]);
                                                                    if (bytesToInt3 > 0) {
                                                                        targetInfoResponse.setCommunicationMtu(bytesToInt3).setReceiveMtu(bytesToInt3);
                                                                    }
                                                                    if (i4 >= 4 && (bytesToInt = CHexConver.bytesToInt(bArr[2], bArr[3])) > 0) {
                                                                        targetInfoResponse.setReceiveMtu(bytesToInt3);
                                                                        targetInfoResponse.setCommunicationMtu(bytesToInt);
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                            case 14:
                                                                targetInfoResponse.setAllowConnectFlag(CHexConver.byteToInt(bArr[0]));
                                                                break;
                                                        }
                                                    } else {
                                                        try {
                                                            targetInfoResponse.setCustomVersionMsg(new String(bArr));
                                                        } catch (Exception e4) {
                                                            e4.printStackTrace();
                                                        }
                                                    }
                                                } else {
                                                    byte b2 = bArr[0];
                                                    if ((b2 & 1) == 1) {
                                                        z2 = true;
                                                    } else {
                                                        z2 = false;
                                                    }
                                                    TargetInfoResponse supportMD5 = targetInfoResponse.setSupportMD5(z2);
                                                    if (((b2 >> 1) & 1) == 1) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    supportMD5.setGameMode(z3);
                                                }
                                            } else {
                                                if (bArr[0] == 1) {
                                                    z = true;
                                                } else {
                                                    z = false;
                                                }
                                                targetInfoResponse.setBleOnly(z);
                                                if (i4 > 6) {
                                                    byte[] bArr4 = new byte[6];
                                                    System.arraycopy(bArr, 1, bArr4, 0, 6);
                                                    targetInfoResponse.setBleAddr(hexDataCovetToAddress(bArr4));
                                                }
                                            }
                                        } else {
                                            try {
                                                targetInfoResponse.setName(new String(bArr));
                                            } catch (Exception e5) {
                                                e5.printStackTrace();
                                            }
                                        }
                                    } else if (i4 >= 6) {
                                        byte[] bArr5 = new byte[6];
                                        System.arraycopy(bArr, 0, bArr5, 0, 6);
                                        targetInfoResponse.setEdrAddr(hexDataCovetToAddress(bArr5));
                                        if (i4 >= 8) {
                                            targetInfoResponse.setEdrProfile(bArr[6]).setEdrStatus(bArr[7]);
                                        }
                                    }
                                } else if (i4 >= 3) {
                                    targetInfoResponse.setQuantity(CHexConver.byteToInt(bArr[0])).setVolume(bArr[1]).setMaxVol(bArr[2]);
                                    if (i4 > 4) {
                                        targetInfoResponse.setLowPowerLimit(CHexConver.byteToInt(bArr[4]));
                                    }
                                }
                            } else {
                                byte b3 = bArr[0];
                                targetInfoResponse.setProtocolVersion("V_" + ((b3 >> 4) & 15) + FileUtils.FILE_EXTENSION_SEPARATOR + (b3 & 15));
                            }
                            i2 = i5;
                        } else if (i4 == 0) {
                            JL_Log.w(f17769a, "parseTargetInfo", "dataBuf is empty.");
                            i2 = i3;
                        } else {
                            JL_Log.w(f17769a, "parseTargetInfo", "over limit.");
                            return;
                        }
                    }
                } else {
                    JL_Log.i(f17769a, "parseTargetInfo", "" + targetInfoResponse);
                    return;
                }
            }
            JL_Log.e(f17769a, "parseTargetInfo", CommonUtil.formatString("data length[%d] over paramDataLen[%d], cast away", Integer.valueOf(byteToInt), Integer.valueOf(length)));
        }
    }

    public static ArrayList<BasePacket> findPacketData(int i2, byte[] bArr) {
        if (i2 == 0 || bArr == null || bArr.length == 0) {
            return null;
        }
        ArrayList<BasePacket> arrayList = new ArrayList<>();
        byte[] b2 = b(bArr);
        int length = b2.length;
        JL_Log.d(f17769a, "findPacketData", "data : " + CHexConver.byte2HexStr(b2));
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            int a2 = a(b2, i3, i2);
            if (a2 < f.length) {
                JL_Log.w(f17769a, "findPacketData", "not find head data : ");
                break;
            }
            JL_Log.i(f17769a, "findPacketData", "prefixIndex = " + a2);
            int bytesToInt = CHexConver.bytesToInt(b2, a2 + 2, 2);
            int i4 = bytesToInt + 4;
            byte[] bArr2 = new byte[i4];
            System.arraycopy(b2, a2, bArr2, 0, i4);
            BasePacket c2 = c(bArr2);
            if (c2 != null) {
                arrayList.add(c2);
            }
            i3 = a2 + 4 + bytesToInt + 1;
        }
        return arrayList;
    }

    private static void b(byte[] bArr, int i2, int i3) {
        if (bArr == null || bArr.length <= 0 || i2 < 0 || i3 <= 0 || i2 + i3 > bArr.length) {
            return;
        }
        byte[] bArr2 = new byte[i3];
        g = bArr2;
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        h = i3;
    }

    private static CommandBase a(BasePacket basePacket, CommandBase commandBase) {
        Map<Integer, ICmdHandler> validCommandList;
        ICmdHandler iCmdHandler;
        if (basePacket == null || (validCommandList = Command.getValidCommandList()) == null || (iCmdHandler = validCommandList.get(Integer.valueOf(basePacket.getOpCode()))) == null) {
            return null;
        }
        return iCmdHandler.parseDataToCmd(basePacket, commandBase);
    }

    private static int a(byte[] bArr) {
        if (bArr == null || bArr.length != 8) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.append(b2 & 255);
        }
        try {
            return Integer.valueOf(sb.toString(), 2).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
