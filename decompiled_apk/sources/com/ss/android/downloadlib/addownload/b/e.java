package com.ss.android.downloadlib.addownload.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class e implements com.ss.android.downloadad.api.a.a {

    /* renamed from: a, reason: collision with root package name */
    public long f25969a;
    public DownloadModel b;
    public DownloadEventConfig c;
    public DownloadController d;
    public com.ss.android.downloadad.api.a.b e;

    public e() {
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String a() {
        return this.b.getDownloadUrl();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long b() {
        return this.b.getId();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean c() {
        return this.b.isAd();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String d() {
        return this.b.getLogExtra();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String e() {
        return this.b.getPackageName();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String f() {
        if (this.b.getDeepLink() != null) {
            return this.b.getDeepLink().getOpenUrl();
        }
        return null;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject g() {
        return this.b.getExtra();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int h() {
        if (this.d.getDownloadMode() == 2) {
            return 2;
        }
        return this.b.getFunnelType();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String i() {
        return this.c.getRefer();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String j() {
        return this.c.getClickButtonTag();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject k() {
        return this.c.getParamsJson();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long l() {
        return this.b.getExtraValue();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean m() {
        return this.c.isEnableV3Event();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public List<String> n() {
        return this.b.getClickTrackUrl();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public Object o() {
        return this.c.getExtraEventObject();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject p() {
        return this.c.getExtraJson();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean q() {
        return this.d.enableNewActivity();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject r() {
        return this.b.getDownloadSettings();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int s() {
        return 0;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int t() {
        return this.c.getDownloadScene();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadModel u() {
        return this.b;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadEventConfig v() {
        return this.c;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadController w() {
        return this.d;
    }

    public boolean x() {
        DownloadModel downloadModel;
        if (this.f25969a == 0 || (downloadModel = this.b) == null || this.c == null || this.d == null) {
            return true;
        }
        if (downloadModel.isAd() && this.f25969a <= 0) {
            return true;
        }
        return false;
    }

    public boolean y() {
        if (x()) {
            return false;
        }
        if (this.b.isAd()) {
            DownloadModel downloadModel = this.b;
            if (!(downloadModel instanceof AdDownloadModel) || TextUtils.isEmpty(downloadModel.getLogExtra()) || !(this.c instanceof AdDownloadEventConfig) || !(this.d instanceof AdDownloadController)) {
                return false;
            }
            return true;
        }
        return this.b instanceof AdDownloadModel;
    }

    public e(long j, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        this.f25969a = j;
        this.b = downloadModel;
        this.c = downloadEventConfig;
        this.d = downloadController;
    }
}
