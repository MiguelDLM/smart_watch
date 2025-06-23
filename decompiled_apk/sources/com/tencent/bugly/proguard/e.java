package com.tencent.bugly.proguard;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public final class e extends d {
    static HashMap<String, byte[]> h;
    static HashMap<String, HashMap<String, byte[]>> i;
    protected g g;
    private int j;

    public e() {
        g gVar = new g();
        this.g = gVar;
        this.j = 0;
        gVar.f26609a = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.oIX0oI
    public final <T> void a(String str, T t) {
        if (!str.startsWith(FileUtils.FILE_EXTENSION_SEPARATOR)) {
            super.a(str, t);
            return;
        }
        throw new IllegalArgumentException("put name can not startwith . , now is ".concat(str));
    }

    @Override // com.tencent.bugly.proguard.d
    public final void b() {
        super.b();
        this.g.f26609a = (short) 3;
    }

    public final void c(String str) {
        this.g.f = str;
    }

    public final void c() {
        this.g.d = 1;
    }

    public final void b(String str) {
        this.g.e = str;
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.oIX0oI
    public final byte[] a() {
        g gVar = this.g;
        if (gVar.f26609a == 2) {
            if (!gVar.e.equals("")) {
                if (this.g.f.equals("")) {
                    throw new IllegalArgumentException("funcName can not is null");
                }
            } else {
                throw new IllegalArgumentException("servantName can not is null");
            }
        } else {
            if (gVar.e == null) {
                gVar.e = "";
            }
            if (gVar.f == null) {
                gVar.f = "";
            }
        }
        l lVar = new l(0);
        lVar.a(this.c);
        if (this.g.f26609a == 2) {
            lVar.a((Map) this.f26615a, 0);
        } else {
            lVar.a((Map) ((d) this).e, 0);
        }
        this.g.g = n.a(lVar.f26613a);
        l lVar2 = new l(0);
        lVar2.a(this.c);
        this.g.a(lVar2);
        byte[] a2 = n.a(lVar2.f26613a);
        int length = a2.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a2).flip();
        return allocate.array();
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.oIX0oI
    public final void a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                k kVar = new k(bArr, (byte) 0);
                kVar.a(this.c);
                this.g.a(kVar);
                g gVar = this.g;
                if (gVar.f26609a == 3) {
                    k kVar2 = new k(gVar.g);
                    kVar2.a(this.c);
                    if (h == null) {
                        HashMap<String, byte[]> hashMap = new HashMap<>();
                        h = hashMap;
                        hashMap.put("", new byte[0]);
                    }
                    ((d) this).e = kVar2.a((Map) h, 0, false);
                    return;
                }
                k kVar3 = new k(gVar.g);
                kVar3.a(this.c);
                if (i == null) {
                    i = new HashMap<>();
                    HashMap<String, byte[]> hashMap2 = new HashMap<>();
                    hashMap2.put("", new byte[0]);
                    i.put("", hashMap2);
                }
                this.f26615a = kVar3.a((Map) i, 0, false);
                this.b = new HashMap<>();
                return;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }
}
