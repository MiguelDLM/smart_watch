package com.ss.android.downloadlib.activity;

import O0IoXXOx.XO;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import com.huawei.openalliance.ad.constant.bb;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadad.api.a.b;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.a.e;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.addownload.n;
import com.ss.android.downloadlib.g.h;
import com.ss.android.downloadlib.g.j;
import com.ss.android.downloadlib.g.m;
import com.ss.android.downloadlib.guide.install.a;
import com.ss.android.downloadlib.i;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static a d;

    /* renamed from: a, reason: collision with root package name */
    protected Intent f25951a = null;
    private boolean b;
    private b c;

    public static void a(String str, String[] strArr) {
        Intent intent = new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    public static void b(String str, com.ss.android.downloadad.api.a.a aVar) {
        Intent c = c(aVar);
        c.addFlags(268435456);
        c.putExtra("type", 11);
        c.putExtra(bb.G, str);
        if (k.a() != null) {
            k.a().startActivity(c);
        }
    }

    private static Intent c(@NonNull com.ss.android.downloadad.api.a.a aVar) {
        return new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        b();
        this.f25951a = getIntent();
        k.b(this);
        a();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f25951a = intent;
        k.b(this);
        a();
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        k.f().a(this, i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onStop() {
        b bVar;
        DownloadInfo b;
        super.onStop();
        if (this.b && (bVar = this.c) != null) {
            if (!TextUtils.isEmpty(bVar.af())) {
                b = i.a(k.a()).a(this.c.af(), null, true);
            } else {
                b = i.a(k.a()).b(this.c.a());
            }
            if (b != null && b.getCurBytes() >= b.getTotalBytes() && !isFinishing()) {
                finish();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c() {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.activity.TTDelegateActivity.c():void");
    }

    public static void b(String str, long j, String str2) {
        Intent intent = new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 14);
        intent.putExtra(bb.G, str);
        intent.putExtra("model_id", j);
        intent.putExtra("market_app_id", str2);
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    public static void a(String str, com.ss.android.downloadad.api.a.a aVar) {
        Intent c = c(aVar);
        c.addFlags(268435456);
        c.putExtra("type", 2);
        c.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
        if (k.a() != null) {
            k.a().startActivity(c);
        }
    }

    public static void a(com.ss.android.downloadad.api.a.a aVar) {
        Intent c = c(aVar);
        c.addFlags(268435456);
        c.putExtra("type", 4);
        c.putExtra("model_id", aVar.b());
        if (k.a() != null) {
            k.a().startActivity(c);
        }
    }

    public static void b(@NonNull com.ss.android.downloadad.api.a.a aVar) {
        a(aVar, 5, "", "", "", "");
    }

    public static void b(@NonNull com.ss.android.downloadad.api.a.a aVar, String str, String str2, String str3) {
        a(aVar, 7, str, str2, str3, "");
    }

    public static void b(@NonNull com.ss.android.downloadad.api.a.a aVar, String str, String str2, String str3, String str4) {
        a(aVar, 20, str, str2, str3, str4);
    }

    private void b() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    public static void a(com.ss.android.downloadad.api.a.a aVar, a aVar2) {
        Intent c = c(aVar);
        c.addFlags(268435456);
        c.putExtra("type", 9);
        d = aVar2;
        if (k.a() != null) {
            k.a().startActivity(c);
        }
    }

    private void b(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            t tVar = new t() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1
                private WeakReference<Activity> c;

                {
                    this.c = new WeakReference<>(TTDelegateActivity.this);
                }

                @Override // com.ss.android.download.api.config.t
                public void a() {
                    j.a(str);
                    c.a(this.c.get());
                }

                @Override // com.ss.android.download.api.config.t
                public void a(String str2) {
                    j.a(str, str2);
                    c.a(this.c.get());
                }
            };
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    k.f().a(this, strArr, tVar);
                    return;
                } catch (Exception e) {
                    k.u().a(e, "requestPermission");
                    tVar.a();
                    return;
                }
            }
            tVar.a();
            return;
        }
        c.a((Activity) this);
    }

    public static void a(long j) {
        Intent intent = new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j);
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    private void b(String str) {
        Intent g = m.g(this, str);
        if (g == null) {
            return;
        }
        try {
            try {
                g.addFlags(268435456);
                g.putExtra("start_only_for_android", true);
                startActivity(g);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            c.a((Activity) this);
        }
    }

    public static void a(String str, long j, String str2, @NonNull JSONObject jSONObject) {
        Intent intent = new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 12);
        intent.putExtra(bb.G, str);
        intent.putExtra("model_id", j);
        intent.putExtra(XO.f1160OOXIXo, str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    private void b(long j) {
        final b d2 = f.a().d(j);
        if (d2 == null) {
            com.ss.android.downloadlib.e.c.a().a("showOpenAppDialogInner nativeModel null");
            c.a((Activity) this);
        } else {
            k.d().b(new b.a(this).a("已安装完成").b(String.format("%1$s已安装完成，是否立即打开？", TextUtils.isEmpty(d2.N()) ? "刚刚下载的应用" : d2.N())).c("打开").d("取消").a(false).a(m.d(this, d2.e())).a(new b.InterfaceC1035b() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
                @Override // com.ss.android.download.api.model.b.InterfaceC1035b
                public void a(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.b.a.b(d2);
                    TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                    if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                        dialogInterface.dismiss();
                    }
                    c.a((Activity) TTDelegateActivity.this);
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC1035b
                public void b(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.d.a.a().b("market_openapp_cancel", d2);
                    TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                    if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                        dialogInterface.dismiss();
                    }
                    c.a((Activity) TTDelegateActivity.this);
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC1035b
                public void c(DialogInterface dialogInterface) {
                    c.a((Activity) TTDelegateActivity.this);
                }
            }).a(2).a());
            com.ss.android.downloadlib.d.a.a().b("market_openapp_window_show", d2);
        }
    }

    public static void a(String str, long j, String str2) {
        Intent intent = new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 13);
        intent.putExtra(bb.G, str);
        intent.putExtra("model_id", j);
        intent.putExtra("need_comment", str2);
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    public static void a(String str, long j) {
        Intent intent = new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 15);
        intent.putExtra(bb.G, str);
        intent.putExtra("model_id", j);
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    private void c(long j) {
        new com.ss.android.downloadlib.addownload.compliance.a(this, j).show();
    }

    public static void a(@NonNull com.ss.android.downloadad.api.a.a aVar, String str) {
        a(aVar, 19, "", "", "", str);
    }

    public static void a(@NonNull com.ss.android.downloadad.api.a.a aVar, String str, String str2, String str3) {
        a(aVar, 8, str, str2, str3, "");
    }

    public static void a(@NonNull com.ss.android.downloadad.api.a.a aVar, String str, String str2, String str3, String str4) {
        a(aVar, 21, str, str2, str3, str4);
    }

    private static void a(@NonNull com.ss.android.downloadad.api.a.a aVar, int i, String str, String str2, String str3, String str4) {
        Intent c = c(aVar);
        c.addFlags(268435456);
        c.putExtra("type", i);
        if (!TextUtils.isEmpty(str2)) {
            c.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            c.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            c.putExtra("delete_button_text", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            c.putExtra("message_text", str);
        }
        c.putExtra("model_id", aVar.b());
        if (k.a() != null) {
            k.a().startActivity(c);
        }
    }

    public void a() {
        Intent intent = this.f25951a;
        if (intent == null) {
            return;
        }
        switch (intent.getIntExtra("type", 0)) {
            case 1:
                b(this.f25951a.getStringExtra("permission_id_key"), this.f25951a.getStringArrayExtra("permission_content_key"));
                break;
            case 2:
                a(this.f25951a.getStringExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL));
                break;
            case 3:
            case 6:
            case 16:
            case 17:
            case 18:
            default:
                c.a((Activity) this);
                break;
            case 4:
                b(this.f25951a.getLongExtra("model_id", 0L));
                break;
            case 5:
                a(this.f25951a.getLongExtra("model_id", 0L), "");
                break;
            case 7:
            case 8:
            case 20:
            case 21:
                c();
                break;
            case 9:
                a aVar = d;
                if (aVar != null) {
                    aVar.a();
                }
                c.a((Activity) this);
                break;
            case 10:
                c(this.f25951a.getLongExtra("app_info_id", 0L));
                break;
            case 11:
                b(this.f25951a.getStringExtra(bb.G));
                break;
            case 12:
                h.a(this, this.f25951a.getStringExtra(bb.G), this.f25951a.getLongExtra("model_id", 0L), this.f25951a.getStringExtra(XO.f1160OOXIXo), this.f25951a.getStringExtra("ext_json"));
                c.a((Activity) this);
                break;
            case 13:
                h.a(this, this.f25951a.getStringExtra(bb.G), this.f25951a.getLongExtra("model_id", 0L), this.f25951a.getStringExtra("need_comment"));
                c.a((Activity) this);
                break;
            case 14:
                h.b(this, this.f25951a.getStringExtra(bb.G), this.f25951a.getLongExtra("model_id", 0L), this.f25951a.getStringExtra("market_app_id"));
                c.a((Activity) this);
                break;
            case 15:
                h.a(this, this.f25951a.getStringExtra(bb.G), this.f25951a.getLongExtra("model_id", 0L));
                c.a((Activity) this);
                break;
            case 19:
                a(this.f25951a.getLongExtra("model_id", 0L), this.f25951a.getStringExtra("delete_button_text"));
                break;
        }
        this.f25951a = null;
    }

    private void a(long j, String str) {
        if (n.a() == null) {
            return;
        }
        com.ss.android.downloadad.api.a.b d2 = f.a().d(j);
        if (d2 != null) {
            DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(d2.s());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - d2.T()));
                jSONObject.putOpt("click_download_size", Long.valueOf(d2.U()));
                if (downloadInfo != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_current_bytes", Integer.valueOf((int) (downloadInfo.getCurBytes() / 1048576)));
                    jSONObject.putOpt("download_total_bytes", Integer.valueOf((int) (downloadInfo.getTotalBytes() / 1048576)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_dialog_show", jSONObject, d2);
            } else {
                com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_dialog_show", jSONObject, d2);
            }
        }
        e.a a2 = new e.a(this).a(false).a(n.a());
        if (!TextUtils.isEmpty(str)) {
            a2.d(str).a(n.b());
        }
        a2.a().show();
        this.b = true;
        this.c = d2;
    }

    private void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                c.a((Activity) this);
                return;
            }
            try {
                Uri parse = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
                intent.addFlags(268435456);
                if (com.ss.android.socialbase.downloader.g.a.c().a("fix_app_link_flag")) {
                    intent.addFlags(67108864);
                }
                intent.putExtra("start_only_for_android", true);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
            c.a((Activity) this);
        } catch (Throwable th) {
            c.a((Activity) this);
            throw th;
        }
    }
}
