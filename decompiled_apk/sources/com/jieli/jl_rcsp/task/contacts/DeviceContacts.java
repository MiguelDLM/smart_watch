package com.jieli.jl_rcsp.task.contacts;

import android.text.TextUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class DeviceContacts {

    /* renamed from: a, reason: collision with root package name */
    public short f17963a;
    public String b;
    public String c;

    public DeviceContacts(short s, String str, String str2) {
        this.f17963a = s;
        this.b = str;
        this.c = str2;
    }

    public static List<DeviceContacts> fromData(short s, byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        if (bArr != null && bArr.length >= 40) {
            for (int i = 0; i <= bArr.length - 40; i += 40) {
                byte[] bArr2 = new byte[20];
                byte[] bArr3 = new byte[20];
                System.arraycopy(bArr, i, bArr2, 0, 20);
                System.arraycopy(bArr, i + 20, bArr3, 0, 20);
                arrayList.add(new DeviceContacts(s, new String(bArr2).trim(), new String(bArr3).trim()));
            }
        }
        return arrayList;
    }

    public static byte[] getTextData(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        byte[] bytes = str.getBytes();
        while (bytes.length > 20) {
            str = str.substring(0, str.length() - 1);
            bytes = str.getBytes();
        }
        return bytes;
    }

    public static String toString(List<DeviceContacts> list) {
        if (list != null && list.size() >= 1) {
            StringBuilder sb = new StringBuilder();
            Iterator<DeviceContacts> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next().toString());
            }
            return sb.toString();
        }
        return "no contacts";
    }

    public short getFileId() {
        return this.f17963a;
    }

    public String getMobile() {
        return this.c;
    }

    public String getName() {
        return this.b;
    }

    public void setMobile(String str) {
        this.c = str;
    }

    public void setName(String str) {
        this.b = str;
    }

    public byte[] toData() {
        byte[] textData = getTextData(this.b);
        byte[] textData2 = getTextData(this.c);
        return ByteBuffer.allocate(40).put(textData).put(new byte[20 - textData.length]).put(textData2).put(new byte[20 - textData2.length]).array();
    }

    public String toString() {
        return "DeviceContacts{fileId=" + ((int) this.f17963a) + ", name='" + this.b + "', mobile='" + this.c + "'}";
    }

    public static byte[] toData(List<DeviceContacts> list) {
        ByteBuffer allocate = ByteBuffer.allocate(list.size() * 40);
        Iterator<DeviceContacts> it = list.iterator();
        while (it.hasNext()) {
            allocate.put(it.next().toData());
        }
        return allocate.array();
    }
}
