package com.baidu.navisdk.ugc.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.e0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.File;
import java.util.LinkedList;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedList<String> f8344a = new LinkedList<>();
    private Context b;
    private String c;
    private int d;
    private com.baidu.navisdk.ugc.listener.c e;
    private boolean f;

    public b(Context context, boolean z) {
        this.d = 5;
        this.f = z;
        this.b = context;
        this.d = c();
        int a2 = e0.a(context).a("ugc_video_size", 0);
        for (int i = 0; i < a2; i++) {
            String a3 = e0.a(context).a("ugc_video_url" + i, "");
            if (!TextUtils.isEmpty(a3)) {
                this.f8344a.addFirst(a3);
            }
        }
    }

    private void b(Activity activity) {
        if (activity == null) {
            return;
        }
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_PlayVideo", "playOnlineVideoByUrl lastPlayedURl:" + this.c);
        }
        Bundle bundle = new Bundle();
        bundle.putString("url", this.c);
        bundle.putString("cacheDir", "ugcvideo");
        bundle.putInt("requestCode", 4107);
        if (com.baidu.navisdk.module.page.a.b().a(9, bundle, activity)) {
            b();
            com.baidu.navisdk.ugc.listener.c cVar = this.e;
            if (cVar != null) {
                cVar.a(true);
            }
        }
    }

    private int c() {
        return 5;
    }

    private void d() {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_PlayVideo", "releaseAudio isComeFromNavigating: " + this.f);
        }
        if (this.f) {
            TTSPlayerControl.resumeVoiceTTSOutput();
        }
        com.baidu.navisdk.ugc.utils.e.f8333a.a(com.baidu.navisdk.framework.a.c().a());
    }

    public boolean a(int i) {
        return i == 4107 || i == 4106;
    }

    public void a(Activity activity, String str) {
        if (!TextUtils.isEmpty(str) && activity != null) {
            String a2 = com.baidu.navisdk.framework.b.a(str, "ugcvideo");
            if (TextUtils.isEmpty(a2)) {
                a(activity);
                return;
            }
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_PlayVideo", "playVideo url:" + str);
            }
            File file = new File(a2);
            this.c = str;
            if (!file.exists() && !this.f8344a.contains(str)) {
                a(activity);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("path", a2);
            bundle.putString("cacheDir", "ugcvideo");
            bundle.putInt("requestCode", 4106);
            if (com.baidu.navisdk.module.page.a.b().a(9, bundle, activity)) {
                b();
                com.baidu.navisdk.ugc.listener.c cVar = this.e;
                if (cVar != null) {
                    cVar.a(true);
                    return;
                }
                return;
            }
            return;
        }
        TipTool.onCreateToastDialog(this.b, "当前视频无法播放");
    }

    private void b(int i) {
        if (i == 1001) {
            if (this.f8344a.size() > this.d) {
                String last = this.f8344a.getLast();
                if (!TextUtils.isEmpty(last)) {
                    try {
                        File file = new File(com.baidu.navisdk.framework.b.a(last, "ugcvideo"));
                        if (file.exists()) {
                            file.delete();
                            this.f8344a.removeLast();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            this.f8344a.addFirst(this.c);
        }
        if (this.e != null) {
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_PlayVideo", "processOnlineVideoResult: " + i);
            }
            this.e.a(false);
        }
    }

    private void a(Activity activity) {
        if (!y.d(this.b)) {
            if (this.e != null) {
                g gVar = g.UGC;
                if (gVar.d()) {
                    gVar.e("UgcModule_PlayVideo", "playOnlineVideo isNetworkAvailable");
                }
                this.e.a(false);
            }
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_fail_badwet));
            return;
        }
        b(activity);
    }

    private void b() {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_PlayVideo", "focusAudio isComeFromNavigating: " + this.f);
        }
        if (this.f) {
            TTSPlayerControl.stopVoiceTTSOutput();
            TTSPlayerControl.pauseVoiceTTSOutput();
        }
        com.baidu.navisdk.ugc.utils.e.f8333a.b(com.baidu.navisdk.framework.a.c().a());
    }

    public void a() {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_PlayVideo", "onDestroy");
        }
        d();
        SharedPreferences.Editor edit = e0.a(this.b).a().edit();
        int size = this.f8344a.size();
        edit.putInt("ugc_video_size", size);
        for (int i = 0; i < size; i++) {
            edit.putString("ugc_video_url" + i, this.f8344a.get(i));
        }
        edit.apply();
        this.e = null;
        this.b = null;
    }

    private void a(Activity activity, int i) {
        if (i == 1002) {
            a(activity);
            return;
        }
        if (this.e != null) {
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_PlayVideo", "processLocalVideoResult: " + i);
            }
            this.e.a(false);
        }
    }

    public void a(Activity activity, int i, int i2, Intent intent) {
        d();
        if (i == 4106) {
            a(activity, i2);
        } else {
            if (i != 4107) {
                return;
            }
            b(i2);
        }
    }

    public void a(com.baidu.navisdk.ugc.listener.c cVar) {
        this.e = cVar;
    }
}
