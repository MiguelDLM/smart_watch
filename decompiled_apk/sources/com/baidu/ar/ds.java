package com.baidu.ar;

import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import javax.net.ssl.SSLParameters;

/* loaded from: classes7.dex */
public class ds extends nx {
    private du pQ;

    public ds(URI uri) {
        super(uri);
    }

    @Override // com.baidu.ar.nx
    public void a(int i, String str, boolean z) {
        du duVar = this.pQ;
        if (duVar != null) {
            duVar.a(i, str, z);
        }
    }

    @Override // com.baidu.ar.nx
    public void al(String str) {
        du duVar = this.pQ;
        if (duVar != null) {
            duVar.al(str);
        }
    }

    @Override // com.baidu.ar.nx
    public void b(Exception exc) {
        du duVar = this.pQ;
        if (duVar != null) {
            duVar.onError(1001, exc != null ? exc.getMessage() : "");
        }
    }

    public void release() {
        this.pQ = null;
    }

    public void a(du duVar) {
        this.pQ = duVar;
    }

    @Override // com.baidu.ar.nx
    public void a(ph phVar) {
        du duVar = this.pQ;
        if (duVar != null) {
            duVar.onOpen();
        }
    }

    @Override // com.baidu.ar.nx
    public void a(ByteBuffer byteBuffer) {
        String str;
        super.a(byteBuffer);
        try {
            str = StandardCharsets.UTF_8.newDecoder().decode(byteBuffer.asReadOnlyBuffer()).toString();
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        du duVar = this.pQ;
        if (duVar != null) {
            duVar.al(str);
        }
    }

    @Override // com.baidu.ar.nx
    public void a(SSLParameters sSLParameters) {
    }
}
