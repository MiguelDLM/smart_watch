package com.realsil.sdk.dfu.s;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes11.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f19601a;
    public List<C0916a> b;

    /* renamed from: com.realsil.sdk.dfu.s.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0916a {

        /* renamed from: a, reason: collision with root package name */
        public int f19602a;
        public byte b;

        public C0916a(int i, byte b) {
            this.f19602a = i;
            this.b = b;
        }

        public String toString() {
            return String.format("imageId=0x%04X, status=0x%02X", Integer.valueOf(this.f19602a), Byte.valueOf(this.b));
        }
    }

    public a(int i, List<C0916a> list) {
        this.f19601a = i;
        this.b = list;
    }

    public static a a(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (bArr != null && bArr.length >= 3) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int remaining = wrap.remaining() / 3;
            while (i < remaining) {
                int i2 = i + 1;
                arrayList.add(new C0916a((((short) (wrap.get(i2) & 255)) << 8) | ((short) (wrap.get(i) & 255)), wrap.get(i + 2)));
                i = i2;
            }
            return new a(remaining, arrayList);
        }
        return new a(0, arrayList);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CheckSha256Rsp{");
        sb.append(String.format(Locale.US, "\n\tnumber=%d", Integer.valueOf(this.f19601a)));
        List<C0916a> list = this.b;
        if (list != null && list.size() > 0) {
            for (C0916a c0916a : this.b) {
                sb.append("\n\t");
                sb.append(c0916a.toString());
            }
        }
        sb.append("\n}");
        return sb.toString();
    }

    public C0916a a(int i) {
        List<C0916a> list = this.b;
        if (list != null && list.size() > 0) {
            for (C0916a c0916a : this.b) {
                if (c0916a.f19602a == i) {
                    return c0916a;
                }
            }
            return new C0916a(i, (byte) 0);
        }
        return new C0916a(i, (byte) 0);
    }

    public boolean a() {
        List<C0916a> list = this.b;
        if (list == null || list.size() <= 0) {
            return false;
        }
        Iterator<C0916a> it = this.b.iterator();
        while (it.hasNext()) {
            byte b = it.next().b;
            if (b != 1 && b != 3) {
                return false;
            }
        }
        return true;
    }
}
