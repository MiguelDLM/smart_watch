package com.baidu.navisdk.ugc.report.ui.innavi;

import android.text.TextUtils;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.external.e;
import com.baidu.navisdk.ugc.https.c;
import com.baidu.navisdk.ugc.report.data.datarepository.a;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.f;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public abstract class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private int f8273a;
    private boolean b;

    /* renamed from: com.baidu.navisdk.ugc.report.ui.innavi.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0392a extends f<JSONObject, Void> {
        public C0392a(String str, JSONObject jSONObject) {
            super(str, jSONObject);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public Void execute() {
            a.this.b((JSONObject) this.inData);
            return null;
        }
    }

    public a(int i) {
        this(i, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        com.baidu.navisdk.ugc.report.data.datarepository.a aVar = new com.baidu.navisdk.ugc.report.data.datarepository.a();
        aVar.c = new a.C0391a(aVar);
        if (jSONObject != null) {
            try {
                aVar.f8244a = jSONObject.optString("tips");
                aVar.b = jSONObject.optString("title");
                JSONObject optJSONObject = jSONObject.optJSONObject("help_info");
                aVar.c.f8245a = optJSONObject.optString("show_copy");
                aVar.c.b = optJSONObject.optString("broadcast_copy");
                aVar.c.c = optJSONObject.optString("help_num");
                if (this.b && this.f8273a == 4) {
                    aVar.f8244a = aVar.b;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(aVar.f8244a)) {
            aVar.f8244a = JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_success);
        }
        if (TextUtils.isEmpty(aVar.b)) {
            aVar.b = b.h(R.string.ugc_string_rg_common_notification_report_success_maintitle);
        }
        if (TextUtils.isEmpty(aVar.c.f8245a)) {
            aVar.c.f8245a = "上报成功，感谢您的反馈";
        }
        if (TextUtils.isEmpty(aVar.c.b)) {
            aVar.c.b = "上报成功，感谢您的反馈";
        }
        e b = com.baidu.navisdk.ugc.external.a.c().b();
        if (b != null) {
            if (this.f8273a == 2) {
                b.a(aVar);
                return;
            } else {
                b.a(aVar.b, aVar.f8244a);
                return;
            }
        }
        if (this.f8273a == 3) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), aVar.b);
        } else {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), aVar.f8244a);
        }
    }

    public a(int i, String str) {
        this(i, false, str);
    }

    @Override // com.baidu.navisdk.ugc.https.c
    public void a(JSONObject jSONObject) {
        g gVar = g.ASR;
        if (gVar.d()) {
            gVar.e("UgcNavingReportResultCallback", "onUgcInfoReportUpLoadSuccess data = " + jSONObject);
        }
        com.baidu.navisdk.util.worker.c.a().a(new C0392a("UgcNavingReportResultCallback", jSONObject), new com.baidu.navisdk.util.worker.e(10, 0), 300L);
    }

    public a(int i, boolean z, String str) {
        this.f8273a = i;
        this.b = z;
    }

    @Override // com.baidu.navisdk.ugc.https.c
    public void a(String str) {
        g gVar = g.ASR;
        if (gVar.d()) {
            gVar.e("UgcNavingReportResultCallback", "onUgcInfoReportUpLoadFail reason = " + str);
        }
        if (!TextUtils.isEmpty(str)) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), str);
        } else {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_fail));
        }
        e b = com.baidu.navisdk.ugc.external.a.c().b();
        if (b != null) {
            b.a(str);
        }
    }
}
