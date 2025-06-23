package com.jieli.jl_rcsp.util;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Build;
import android.text.TextUtils;
import com.jieli.jl_rcsp.model.LtvBean;
import com.jieli.jl_rcsp.model.device.AttrBean;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* loaded from: classes10.dex */
public class RcspUtil {
    public static byte[] addressCovertToByteArray(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(":")) {
            return null;
        }
        String replace = str.replace(":", "");
        int length = replace.length() / 2;
        byte[] bArr = new byte[length];
        if (length != 6) {
            return null;
        }
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int i3 = i2 + 2;
            if (i3 <= replace.length()) {
                try {
                    bArr[i] = (byte) Integer.valueOf(replace.substring(i2, i3), 16).intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return bArr;
    }

    public static byte[] attrs2Bytes(List<AttrBean> list) {
        ByteBuffer allocate = ByteBuffer.allocate(list.size() * 128);
        for (AttrBean attrBean : list) {
            allocate.put((byte) (attrBean.getAttrData().length + 1)).put(attrBean.getType()).put(attrBean.getAttrData());
        }
        byte[] bArr = new byte[allocate.position()];
        allocate.flip();
        allocate.get(bArr);
        return bArr;
    }

    public static int changeConnectStatus(int i) {
        if (i != 1) {
            return i != 2 ? 0 : 1;
        }
        return 3;
    }

    public static boolean checkMaskHasBit(int i, byte b) {
        if (b > 32) {
            return false;
        }
        byte intToByte = CHexConver.intToByte((int) Math.pow(2.0d, CHexConver.byteToInt(b)));
        if ((i & intToByte) != intToByte) {
            return false;
        }
        return true;
    }

    public static boolean deviceEquals(BluetoothDevice bluetoothDevice, BluetoothDevice bluetoothDevice2) {
        if (bluetoothDevice != null && bluetoothDevice2 != null && bluetoothDevice.getAddress().equals(bluetoothDevice2.getAddress())) {
            return true;
        }
        return false;
    }

    public static int formatBleMtu(int i) {
        if (i < 20) {
            i = 20;
        }
        if (i > 509) {
            return 509;
        }
        return i;
    }

    public static String formatString(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    public static byte[] getData(String str, int i) {
        if (str == null || i <= 0) {
            return null;
        }
        return getData(str.getBytes(), i);
    }

    public static BluetoothDevice getRemoteDevice(String str) {
        BluetoothAdapter defaultAdapter;
        if (!BluetoothAdapter.checkBluetoothAddress(str) || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null) {
            return null;
        }
        try {
            return defaultAdapter.getRemoteDevice(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long intToTime(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, ((i >> 26) & 63) + 2010);
        calendar.set(2, ((i >> 22) & 15) - 1);
        calendar.set(5, (i >> 17) & 31);
        calendar.set(11, (i >> 12) & 31);
        calendar.set(12, (i >> 6) & 63);
        calendar.set(13, i & 63);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static byte[] packLTVPacket(int i, byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int i2 = length + 1;
            byte[] bArr2 = new byte[length + 2];
            bArr2[0] = CHexConver.intToByte(i2);
            bArr2[1] = CHexConver.intToByte(i);
            System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
            return bArr2;
        }
        return null;
    }

    public static byte[] packLTVPacket2(int i, byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int i2 = length + 1;
            byte[] bArr2 = new byte[length + 3];
            byte[] int2byte2 = CHexConver.int2byte2(i2);
            System.arraycopy(int2byte2, 0, bArr2, 0, int2byte2.length);
            bArr2[2] = CHexConver.intToByte(i);
            System.arraycopy(bArr, 0, bArr2, 3, bArr.length);
            return bArr2;
        }
        return null;
    }

    public static List<LtvBean> parseLTVData(byte[] bArr) {
        if (bArr != null && bArr.length > 1) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < bArr.length) {
                int i2 = bArr[i];
                int i3 = i + 1;
                if (i3 + i2 > bArr.length) {
                    break;
                }
                int byteToInt = CHexConver.byteToInt(bArr[i3]);
                int i4 = i + 2;
                int i5 = i2 - 1;
                byte[] bArr2 = new byte[i5];
                System.arraycopy(bArr, i4, bArr2, 0, i5);
                i = i4 + i5;
                arrayList.add(new LtvBean(i2, byteToInt, bArr2));
            }
            return arrayList;
        }
        return new ArrayList();
    }

    @SuppressLint({"MissingPermission"})
    public static String printBtDeviceInfo(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null) {
            if (Build.VERSION.SDK_INT > 30) {
                return bluetoothDevice.toString();
            }
            return formatString("device:{ name : %s,type : %d, address : %s }", bluetoothDevice.getName(), Integer.valueOf(bluetoothDevice.getType()), bluetoothDevice.getAddress());
        }
        return "null";
    }

    public static int time2Int(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(1) - 2010;
        int i2 = calendar.get(2) + 1;
        return (calendar.get(5) << 17) | (i << 26) | (i2 << 22) | (calendar.get(11) << 12) | (calendar.get(12) << 6) | calendar.get(13);
    }

    public static byte[] getData(byte[] bArr, int i) {
        if (bArr == null || i <= 0) {
            return null;
        }
        if (bArr.length <= i) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }
}
