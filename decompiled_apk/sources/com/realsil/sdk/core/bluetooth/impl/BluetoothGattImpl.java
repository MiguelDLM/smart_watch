package com.realsil.sdk.core.bluetooth.impl;

import XXO0.oIX0oI;
import android.bluetooth.BluetoothGatt;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.realsil.sdk.core.a.a;
import com.realsil.sdk.core.logger.ZLogger;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes11.dex */
public class BluetoothGattImpl {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<Integer, String> f19499a;
    public static HashMap<Integer, String> b;
    public static HashMap<Integer, String> c;

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        f19499a = hashMap;
        hashMap.put(0, "UNKNOW");
        f19499a.put(1, "READ");
        f19499a.put(2, "READ_ENCRYPTED");
        f19499a.put(4, "READ_ENCRYPTED_MITM");
        f19499a.put(16, "WRITE");
        f19499a.put(32, "WRITE_ENCRYPTED");
        f19499a.put(64, "WRITE_ENCRYPTED_MITM");
        f19499a.put(128, "WRITE_SIGNED");
        f19499a.put(256, "WRITE_SIGNED_MITM");
        HashMap<Integer, String> hashMap2 = new HashMap<>();
        b = hashMap2;
        hashMap2.put(1, "BROADCAST");
        b.put(128, "EXTENDED_PROPS");
        b.put(32, "INDICATE");
        b.put(16, "NOTIFY");
        b.put(2, "READ");
        b.put(64, "SIGNED_WRITE");
        b.put(8, "WRITE");
        b.put(4, "WRITE_NO_RESPONSE");
        HashMap<Integer, String> hashMap3 = new HashMap<>();
        c = hashMap3;
        hashMap3.put(0, "UNKNOW");
        c.put(1, "READ");
        c.put(2, "READ_ENCRYPTED");
        c.put(4, "READ_ENCRYPTED_MITM");
        c.put(16, "WRITE");
        c.put(32, "WRITE_ENCRYPTED");
        c.put(64, "WRITE_ENCRYPTED_MITM");
        c.put(128, "WRITE_SIGNED");
        c.put(256, "WRITE_SIGNED_MITM");
    }

    public static String a(HashMap<Integer, String> hashMap, int i) {
        String str = hashMap.get(Integer.valueOf(i));
        if (TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < 32; i2++) {
                int i3 = 1 << i2;
                if ((i & i3) > 0) {
                    arrayList.add(Integer.valueOf(i3));
                }
            }
            String str2 = "";
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                StringBuilder a2 = a.a(str2);
                a2.append(hashMap.get(arrayList.get(i4)));
                a2.append("|");
                str2 = a2.toString();
            }
            return str2;
        }
        return str;
    }

    public static String getCharPermission(int i) {
        return a(f19499a, i);
    }

    public static String getCharPropertie(int i) {
        return a(b, i);
    }

    public static String getDescPermission(int i) {
        return a(c, i);
    }

    public static List<String> parseProperty(int i) {
        ArrayList arrayList = new ArrayList();
        if ((i & 1) == 1) {
            arrayList.add("BROADCAST");
        }
        if ((i & 2) == 2) {
            arrayList.add("READ");
        }
        if ((i & 4) == 4) {
            arrayList.add("WRITE_NO_RESPONSE");
        }
        if ((i & 8) == 8) {
            arrayList.add("WRITE");
        }
        if ((i & 16) == 16) {
            arrayList.add("NOTIFY");
        }
        if ((i & 32) == 32) {
            arrayList.add("INDICATE");
        }
        return arrayList;
    }

    public static String parseProperty2(int i) {
        StringBuilder sb = new StringBuilder();
        List<String> parseProperty = parseProperty(i);
        if (parseProperty.size() > 0) {
            for (String str : parseProperty) {
                if (sb.length() > 0) {
                    sb.append("|");
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }

    @RequiresApi(api = 18)
    public static boolean refresh(BluetoothGatt bluetoothGatt) {
        try {
            return ((Boolean) bluetoothGatt.getClass().getMethod("refresh", null).invoke(bluetoothGatt, null)).booleanValue();
        } catch (Exception e) {
            StringBuilder a2 = a.a("refreshing device failed: ");
            a2.append(e.toString());
            ZLogger.w(a2.toString());
            return false;
        }
    }

    @RequiresApi(api = 18)
    public static boolean refreshDeviceCache(BluetoothGatt bluetoothGatt, boolean z) {
        if (!z && bluetoothGatt.getDevice().getBondState() != 10) {
            return false;
        }
        return refresh(bluetoothGatt);
    }

    public boolean requestLeConnectionUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3, int i4, int i5, int i6) {
        try {
            Class<?> cls = bluetoothGatt.getClass();
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("requestLeConnectionUpdate", cls2, cls2, cls2, cls2, cls2, cls2);
            ZLogger.d("requestLeConnectionUpdate() - min=(" + i + oIX0oI.I0Io.f4095I0Io + (i * 1.25d) + "msec, max=(" + i2 + oIX0oI.I0Io.f4095I0Io + (i2 * 1.25d) + "msec, latency=" + i3 + ", timeout=" + i4 + "msec, min_ce=" + i5 + ", max_ce=" + i6);
            return ((Boolean) method.invoke(bluetoothGatt, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i4))).booleanValue();
        } catch (Exception e) {
            StringBuilder a2 = a.a("refreshing device failed: ");
            a2.append(e.toString());
            ZLogger.w(a2.toString());
            return false;
        }
    }
}
