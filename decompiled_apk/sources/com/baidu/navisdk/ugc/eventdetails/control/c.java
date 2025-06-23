package com.baidu.navisdk.ugc.eventdetails.control;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.http.center.i;
import com.baidu.navisdk.util.http.center.l;
import com.baidu.nplatform.comapi.MapItem;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import o0oIxXOx.oO;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public abstract class c implements CmdGeneralHttpRequestFunc.b {

    /* renamed from: a, reason: collision with root package name */
    protected StringBuffer f8061a = new StringBuffer();
    protected List<l> b = new ArrayList();

    public abstract void a() throws UnsupportedEncodingException;

    @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
    public void a(byte[] bArr) {
    }

    @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
    @SuppressLint({"DefaultLocale"})
    public List<l> getRequestParams() {
        try {
            this.b.add(new i(MapItem.KEY_ITEM_SID, String.valueOf(1)));
            this.f8061a.append("&sid=");
            this.f8061a.append(URLEncoder.encode(String.valueOf(1), "utf-8"));
            this.b.add(new i("cuid", a0.e()));
            this.f8061a.append("&cuid=");
            this.f8061a.append(URLEncoder.encode(a0.e(), "utf-8"));
            this.b.add(new i(oO.f31192XO, String.valueOf(0)));
            this.f8061a.append("&os=");
            this.f8061a.append(URLEncoder.encode(String.valueOf(0), "utf-8"));
            String valueOf = String.valueOf(a0.i());
            this.b.add(new i("osv", valueOf));
            this.f8061a.append("&osv=");
            this.f8061a.append(URLEncoder.encode(valueOf, "utf-8"));
            this.b.add(new i("sv", a0.k()));
            this.f8061a.append("&sv=");
            this.f8061a.append(URLEncoder.encode(a0.k(), "utf-8"));
            com.baidu.navisdk.util.http.a.a(this.b);
            a();
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetailsHttp", "getRequestParams: " + this.f8061a.toString());
            }
            this.b.add(new i(HttpConstants.SIGN, JNITrajectoryControl.sInstance.getUrlParamsSign(com.baidu.navisdk.module.cloudconfig.d.a(this.b))));
            return this.b;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
    public int getRequestType() {
        return 1;
    }

    @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
    public boolean parseResponseJSON(JSONObject jSONObject) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetailsHttp", "parseResponseJSON: " + jSONObject.toString());
            return true;
        }
        return true;
    }

    public void a(Handler handler, int i) {
        com.baidu.navisdk.cmdrequest.i iVar = new com.baidu.navisdk.cmdrequest.i(com.baidu.navisdk.cmdrequest.c.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, handler, i, 10000);
        CmdGeneralHttpRequestFunc.a(iVar, this);
        com.baidu.navisdk.cmdrequest.b.a().a(iVar);
    }
}
