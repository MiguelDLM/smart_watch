package com.baidu.navisdk.cmdrequest.commandparser;

import android.os.Message;
import com.baidu.navisdk.cmdrequest.HttpPostDataBase;
import com.baidu.navisdk.cmdrequest.f;
import com.baidu.navisdk.cmdrequest.i;
import com.baidu.navisdk.cmdrequest.j;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.http.center.l;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class CmdGeneralHttpPostDataFunc extends HttpPostDataBase {
    public static final String e = "CmdGeneralHttpPostDataFunc";
    private static final HashMap<i, a> f = new HashMap<>();
    private a d = null;

    /* loaded from: classes7.dex */
    public interface a {
        List<l> a();

        String b();

        File c();

        int getRequestType();

        String getUrl();

        boolean parseResponseJSON(JSONObject jSONObject);
    }

    public static void a(i iVar, a aVar) {
        f.put(iVar, aVar);
    }

    @Override // com.baidu.navisdk.cmdrequest.a
    public void b(i iVar) {
        this.d = f.get(iVar);
    }

    @Override // com.baidu.navisdk.cmdrequest.HttpPostDataBase, com.baidu.navisdk.cmdrequest.a
    public void c() {
        if (!this.b.f) {
            LogUtil.e(e, "exec() handleSuccess");
            i iVar = this.b;
            Message obtainMessage = iVar.e.obtainMessage(iVar.g);
            obtainMessage.arg1 = 0;
            obtainMessage.obj = new j(this.b, this.c);
            obtainMessage.sendToTarget();
            this.b.f = true;
        }
    }

    @Override // com.baidu.navisdk.cmdrequest.HttpPostDataBase
    public List<l> d() {
        a aVar = this.d;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    @Override // com.baidu.navisdk.cmdrequest.HttpPostDataBase
    public File e() {
        a aVar = this.d;
        if (aVar != null) {
            return aVar.c();
        }
        return null;
    }

    @Override // com.baidu.navisdk.cmdrequest.HttpPostDataBase
    public String f() {
        a aVar = this.d;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    @Override // com.baidu.navisdk.cmdrequest.HttpPostDataBase
    public String g() {
        a aVar = this.d;
        if (aVar != null) {
            return aVar.getUrl();
        }
        return null;
    }

    @Override // com.baidu.navisdk.cmdrequest.HttpPostDataBase
    public void h() {
        a aVar = this.d;
        if (aVar != null) {
            aVar.parseResponseJSON(this.c);
        }
    }

    @Override // com.baidu.navisdk.cmdrequest.HttpPostDataBase, com.baidu.navisdk.cmdrequest.a
    public f a() {
        a aVar = this.d;
        if (aVar == null || aVar.getRequestType() == 1) {
            return super.a();
        }
        return null;
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
