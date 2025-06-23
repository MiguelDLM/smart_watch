package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Hashtable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class l extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LBSAuthManager f5593a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(LBSAuthManager lBSAuthManager, Looper looper) {
        super(looper);
        this.f5593a = lBSAuthManager;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Hashtable hashtable;
        b.a("handleMessage !!");
        if (message.what == 0) {
            this.f5593a.a((JSONObject) message.obj);
        }
        String string = message.getData().getString("listenerKey");
        hashtable = LBSAuthManager.j;
        LBSAuthManagerListener lBSAuthManagerListener = (LBSAuthManagerListener) hashtable.get(string);
        b.a("handleMessage listener = " + lBSAuthManagerListener);
        if (lBSAuthManagerListener != null) {
            lBSAuthManagerListener.onAuthResult(message.what, message.obj.toString());
        }
    }
}
