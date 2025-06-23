package com.baidu.navisdk.module.plate.checker;

import com.facebook.internal.NativeProtocol;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class e extends a {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<Integer, String> f7390a;

    public e() {
        this.f7390a = null;
        HashMap<Integer, String> hashMap = new HashMap<>();
        this.f7390a = hashMap;
        hashMap.put(Integer.valueOf(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY), "");
        this.f7390a.put(Integer.valueOf(NativeProtocol.MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST), "");
        this.f7390a.put(Integer.valueOf(NativeProtocol.MESSAGE_GET_PROTOCOL_VERSIONS_REPLY), "首位应为字母");
        this.f7390a.put(65540, "禁用字母");
        this.f7390a.put(131073, "请合规填写");
        this.f7390a.put(Integer.valueOf(NativeProtocol.MESSAGE_GET_INSTALL_DATA_REPLY), "");
    }

    private int b(String str) {
        if (str != null && str.length() > 0) {
            if (str.length() >= 2) {
                char charAt = str.charAt(1);
                if (charAt >= 'A' && charAt <= 'Z') {
                    if (charAt == 'I') {
                        return 65540;
                    }
                } else {
                    return NativeProtocol.MESSAGE_GET_PROTOCOL_VERSIONS_REPLY;
                }
            }
            if (str.length() == 8) {
                if ("ABCDE".indexOf(str.charAt(2)) != -1) {
                    return 0;
                }
                return 131073;
            }
            if (str.length() >= 7) {
                return 0;
            }
            return NativeProtocol.MESSAGE_GET_INSTALL_DATA_REPLY;
        }
        return NativeProtocol.MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST;
    }

    @Override // com.baidu.navisdk.module.plate.checker.c
    public final f a(String str, String str2, String str3) {
        f fVar = new f();
        fVar.b(str3);
        fVar.c(str2);
        fVar.a(b(str3));
        fVar.a(this.f7390a.get(Integer.valueOf(fVar.b())));
        return fVar;
    }
}
