package com.huawei.openalliance.ad.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.g;
import com.huawei.hms.ads.jf;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.hms.ads.uiengine.IRemoteViewDelegate;
import com.huawei.openalliance.ad.constant.bn;
import com.huawei.openalliance.ad.constant.cy;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bf;
import java.lang.ref.WeakReference;

/* loaded from: classes10.dex */
public class TemplateStubActivity extends d {
    private static final String Code = "TemplateStubActivity";
    private static AdContentData I;
    private boolean B = false;
    private IRemoteViewDelegate V;
    private View Z;

    /* loaded from: classes10.dex */
    public static class a extends IPPSUiEngineCallback.b {
        private WeakReference<TemplateStubActivity> V;

        public a(TemplateStubActivity templateStubActivity) {
            this.V = new WeakReference<>(templateStubActivity);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x005f, code lost:
        
            if (r6.equals("complete") == false) goto L4;
         */
        @Override // com.huawei.hms.ads.uiengine.IPPSUiEngineCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onCallResult(java.lang.String r6, android.os.Bundle r7) {
            /*
                Method dump skipped, instructions count: 332
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.activity.TemplateStubActivity.a.onCallResult(java.lang.String, android.os.Bundle):void");
        }
    }

    private void B() {
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onDestroy();
            }
        } catch (Throwable th) {
            fb.I(Code, "onDestroy failed: " + th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        finish();
        overridePendingTransition(0, R.anim.hiad_anim_fade_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                View view = (View) ObjectWrapper.unwrap(iRemoteViewDelegate.getView());
                this.Z = view;
                setContentView(view);
            }
        } catch (Throwable th) {
            fb.I(Code, "plugRemoteView " + th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.hiad_anim_fade_out);
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        SafeIntent safeIntent = new SafeIntent(getIntent());
        String stringExtra = safeIntent.getStringExtra("content");
        Code((AdContentData) aa.V(stringExtra, AdContentData.class, new Class[0]));
        if (bc.V(getApplicationContext())) {
            fb.V(Code, "screen locked");
            jf.Code(getApplicationContext()).Code(I, 1);
            finish();
        }
        IRemoteCreator Code2 = g.Code(getApplicationContext());
        if (Code2 == null) {
            jf.Code(getApplicationContext()).Code(I, 2);
            finish();
            return;
        }
        I();
        Code(safeIntent);
        Bundle bundle2 = new Bundle();
        bundle2.putString("filePath", safeIntent.getStringExtra("filePath"));
        bundle2.putString("content", stringExtra);
        try {
            IRemoteViewDelegate newRemoteViewDelegate = Code2.newRemoteViewDelegate(ObjectWrapper.wrap(this), safeIntent.getStringExtra(bn.f.F), null);
            this.V = newRemoteViewDelegate;
            newRemoteViewDelegate.onCreate(bundle2);
            this.V.setCallback(new a(this));
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.activity.TemplateStubActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    TemplateStubActivity.this.Z();
                    TemplateStubActivity.this.Code("start", null);
                    bc.Code(TemplateStubActivity.this.Z, TemplateStubActivity.this);
                    TemplateStubActivity.this.Z.startAnimation(AnimationUtils.loadAnimation(TemplateStubActivity.this.getApplicationContext(), R.anim.hiad_anim_fade_in));
                }
            });
        } catch (Throwable th) {
            fb.I(Code, "create remoteViewDelegate err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        fb.V(Code, "onDestroy");
        B();
        jf.Code(getApplicationContext()).V(I);
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onPause() {
        super.onPause();
        fb.V(Code, "onPause");
        this.B = true;
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onPause();
            }
        } catch (Throwable th) {
            fb.I(Code, "onPause " + th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onRestart() {
        super.onRestart();
        fb.V(Code, "onRestart, hasPause= %s", Boolean.valueOf(this.B));
        if (this.B) {
            finish();
        }
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onRestart();
            }
        } catch (Throwable th) {
            fb.I(Code, "onRestart " + th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onResume() {
        super.onResume();
        fb.V(Code, "onResume, hasPause= %s", Boolean.valueOf(this.B));
        if (this.B) {
            finish();
        }
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onResume();
            }
        } catch (Throwable th) {
            fb.I(Code, "onResume " + th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onStart() {
        super.onStart();
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onStart();
            }
        } catch (Throwable th) {
            fb.I(Code, "onStart " + th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onStop() {
        super.onStop();
        fb.V(Code, "onStop");
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onStop();
            }
        } catch (Throwable th) {
            fb.I(Code, "onStop " + th.getClass().getSimpleName());
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle Code(String str, Bundle bundle) {
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                return iRemoteViewDelegate.sendCommand(str, bundle);
            }
            return null;
        } catch (Throwable th) {
            fb.I(Code, "%s failed: %s ", str, th.getClass().getSimpleName());
            return null;
        }
    }

    private void I() {
        getWindow().setFlags(1024, 1024);
        int i = Build.VERSION.SDK_INT;
        getWindow().addFlags(C.BUFFER_FLAG_FIRST_SAMPLE);
        if (i >= 28) {
            try {
                if (1 == getResources().getConfiguration().orientation) {
                    WindowManager.LayoutParams attributes = getWindow().getAttributes();
                    attributes.layoutInDisplayCutoutMode = 1;
                    getWindow().setAttributes(attributes);
                }
            } catch (Throwable th) {
                Log.w(Code, "set CutoutMode error:" + th.getClass().getSimpleName());
            }
        }
    }

    private void Code(Intent intent) {
        int i;
        try {
            if (!intent.getBooleanExtra(bn.f.x, false)) {
                fb.I(Code, "not need reset");
                return;
            }
            Window window = getWindow();
            if (window == null) {
                fb.I(Code, "window is null");
                return;
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags = intent.getIntExtra(bn.f.y, window.getAttributes().flags);
            if (!cy.Code(getPackageName())) {
                attributes.flags |= 67108864;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                i = window.getAttributes().layoutInDisplayCutoutMode;
                attributes.layoutInDisplayCutoutMode = intent.getIntExtra(bn.f.z, i);
            }
            window.setAttributes(attributes);
            window.setNavigationBarColor(intent.getIntExtra(bn.f.A, window.getNavigationBarColor()));
            View decorView = window.getDecorView();
            if (decorView == null) {
                fb.I(Code, "decorView is null");
            } else {
                decorView.setSystemUiVisibility(intent.getIntExtra(bn.f.E, decorView.getSystemUiVisibility()));
            }
        } catch (Throwable th) {
            fb.I(Code, "inherit err: %s", th.getClass().getSimpleName());
        }
    }

    private static void Code(AdContentData adContentData) {
        I = adContentData;
    }
}
