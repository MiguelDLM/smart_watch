package com.baidu.navisdk.ugc.eventdetails.control;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.cmdrequest.j;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.http.center.i;
import com.facebook.appevents.UserDataStore;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class d {

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            if (g.UGC.d() && message.arg1 == 0) {
                try {
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), ((JSONObject) ((j) message.obj).b).toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.ugc.eventdetails.control.c {
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;
        final /* synthetic */ boolean h;
        final /* synthetic */ String i;

        public b(String str, String str2, String str3, int i, int i2, boolean z, String str4) {
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = i;
            this.g = i2;
            this.h = z;
            this.i = str4;
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.control.c
        public void a() throws UnsupportedEncodingException {
            this.b.add(new i("event_id", this.c));
            this.f8061a.append("event_id=");
            this.f8061a.append(URLEncoder.encode(this.c, "utf-8"));
            if (!TextUtils.isEmpty(this.d)) {
                this.b.add(new i("bduss", this.d));
                this.f8061a.append("&bduss=");
                this.f8061a.append(URLEncoder.encode(this.d, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.e)) {
                this.b.add(new i("groupid", this.e));
                this.f8061a.append("&groupid=");
                this.f8061a.append(URLEncoder.encode(this.e, "utf-8"));
            }
            String str = this.f + "";
            this.b.add(new i("vote_type", str));
            this.f8061a.append("&vote_type=");
            this.f8061a.append(URLEncoder.encode(str, "utf-8"));
            String str2 = this.g + "";
            this.b.add(new i("vote_way", str2));
            this.f8061a.append("&vote_way=");
            this.f8061a.append(URLEncoder.encode(str2, "utf-8"));
            String a2 = com.baidu.navisdk.ugc.https.d.a(this.h);
            if (TextUtils.isEmpty(a2)) {
                a2 = "";
            }
            this.b.add(new i("user_point", a2));
            this.f8061a.append("&user_point=");
            this.f8061a.append(URLEncoder.encode(a2, "utf-8"));
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            this.b.add(new i(UserDataStore.STATE, valueOf));
            this.f8061a.append("&st=");
            this.f8061a.append(URLEncoder.encode(valueOf, "utf-8"));
            if (!TextUtils.isEmpty(this.i)) {
                this.b.add(new i("business_trigger", "" + this.i));
                this.f8061a.append("&business_trigger=");
                this.f8061a.append(URLEncoder.encode(this.i, "utf-8"));
            }
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public String getUrl() {
            return com.baidu.navisdk.util.http.b.d().b("UgcEventFeedback");
        }
    }

    /* loaded from: classes8.dex */
    public class c extends com.baidu.navisdk.ugc.eventdetails.control.c {
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ int e;
        final /* synthetic */ int f;
        final /* synthetic */ String g;
        final /* synthetic */ String h;
        final /* synthetic */ String i;
        final /* synthetic */ String j;
        final /* synthetic */ int k;

        public c(String str, String str2, int i, int i2, String str3, String str4, String str5, String str6, int i3) {
            this.c = str;
            this.d = str2;
            this.e = i;
            this.f = i2;
            this.g = str3;
            this.h = str4;
            this.i = str5;
            this.j = str6;
            this.k = i3;
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.control.c
        public void a() throws UnsupportedEncodingException {
            this.b.add(new i("event_id", this.c));
            this.f8061a.append("event_id=");
            this.f8061a.append(URLEncoder.encode(this.c, "utf-8"));
            if (!TextUtils.isEmpty(this.d)) {
                this.b.add(new i("bduss", this.d));
                this.f8061a.append("&bduss=");
                this.f8061a.append(URLEncoder.encode(this.d, "utf-8"));
            }
            String str = this.e + "";
            this.b.add(new i("vote_type", str));
            this.f8061a.append("&vote_type=");
            this.f8061a.append(URLEncoder.encode(str, "utf-8"));
            String str2 = this.f + "";
            this.b.add(new i("vote_way", str2));
            this.f8061a.append("&vote_way=");
            this.f8061a.append(URLEncoder.encode(str2, "utf-8"));
            String a2 = com.baidu.navisdk.ugc.https.d.a(true);
            if (TextUtils.isEmpty(a2)) {
                a2 = "";
            }
            this.b.add(new i("user_point", a2));
            this.f8061a.append("&user_point=");
            this.f8061a.append(URLEncoder.encode(a2, "utf-8"));
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            this.b.add(new i(UserDataStore.STATE, valueOf));
            this.f8061a.append("&st=");
            this.f8061a.append(URLEncoder.encode(valueOf, "utf-8"));
            if (!TextUtils.isEmpty(this.g)) {
                this.b.add(new i("action_speed", this.g));
                this.f8061a.append("&action_speed=");
                this.f8061a.append(URLEncoder.encode(this.g, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.h)) {
                this.b.add(new i("yaw_linkid", this.h));
                this.f8061a.append("&yaw_linkid=");
                this.f8061a.append(URLEncoder.encode(this.h, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.i)) {
                this.b.add(new i("yaw_point", this.i));
                this.f8061a.append("&yaw_point=");
                this.f8061a.append(URLEncoder.encode(this.i, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.j)) {
                this.b.add(new i("sub_type", this.j));
                this.f8061a.append("&sub_type=");
                this.f8061a.append(URLEncoder.encode(this.j, "utf-8"));
            }
            String str3 = this.k + "";
            this.b.add(new i(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, str3));
            this.f8061a.append("&action_type=");
            this.f8061a.append(URLEncoder.encode(str3, "utf-8"));
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public String getUrl() {
            return com.baidu.navisdk.util.http.b.d().b("UgcEventFeedback");
        }
    }

    public static void a(String str, String str2, String str3, Handler handler, int i, boolean z) {
        a(str, str2, 1, null, str3, handler, i, z, 0);
    }

    public static void a(String str, int i) {
        a(str, i, null, 1, 0);
    }

    public static void a(String str, int i, Handler handler, int i2, int i3) {
        if (handler == null) {
            handler = new a("DynamicEventVerify");
        }
        a(str, null, i, com.baidu.navisdk.framework.b.e() == null ? "" : com.baidu.navisdk.framework.b.e(), null, handler, i2, true, i3);
    }

    public static void a(String str, int i, String str2, String str3, Handler handler, int i2, boolean z) {
        a(str, null, i, str2, str3, handler, i2, z, 0);
    }

    private static void a(String str, String str2, int i, String str3, String str4, Handler handler, int i2, boolean z, int i3) {
        g gVar = g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetailsHttp", "asyncRCEventFeedback - eventId :" + str + ", voteType : " + i + ", bduss : " + str3 + ", handler : " + handler + ", what :" + i2);
        }
        new b(str, str3, str2, i, i3, z, str4).a(handler, i2);
    }

    public static void a(Bundle bundle, Handler handler, int i) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetailsHttp", "verify request come in bundle : " + bundle.toString());
        }
        new c(bundle.getString("eventId"), com.baidu.navisdk.framework.b.e() == null ? "" : com.baidu.navisdk.framework.b.e(), bundle.getInt("voteType"), bundle.getInt("voteWay"), bundle.getString("yawSpeed"), bundle.getString("yawLink"), bundle.getString("yawPoint"), bundle.getString("reason"), bundle.getInt(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE)).a(handler, i);
    }
}
