package com.baidu.navisdk.cmdrequest.commandparser;

import android.os.Message;
import com.baidu.navisdk.cmdrequest.f;
import com.baidu.navisdk.cmdrequest.i;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class CmdGeneralFunc extends com.baidu.navisdk.cmdrequest.a {
    private static final HashMap<i, a> d = new HashMap<>();
    private a c = null;

    /* loaded from: classes7.dex */
    public interface a {
        f a();
    }

    @Override // com.baidu.navisdk.cmdrequest.a
    public f a() {
        a aVar = this.c;
        if (aVar == null) {
            return null;
        }
        return aVar.a();
    }

    @Override // com.baidu.navisdk.cmdrequest.a
    public void b(i iVar) {
        this.c = d.get(iVar);
    }

    @Override // com.baidu.navisdk.cmdrequest.a
    public void c() {
        i iVar = this.b;
        if (!iVar.f) {
            Message obtainMessage = iVar.e.obtainMessage(iVar.g);
            obtainMessage.arg1 = 0;
            obtainMessage.sendToTarget();
            this.b.f = true;
        }
    }

    @Override // com.baidu.navisdk.cmdrequest.a
    public void b() {
        i iVar = this.b;
        if (iVar.f) {
            return;
        }
        Message obtainMessage = iVar.e.obtainMessage(iVar.g);
        obtainMessage.arg1 = this.f6680a.f6693a;
        obtainMessage.sendToTarget();
        this.b.f = true;
    }
}
