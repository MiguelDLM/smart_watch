package com.kwad.components.core.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.b.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.proxy.f;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class a extends f implements a.InterfaceC0777a, aq.b {
    private boolean Oz = true;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private AdBaseFrameLayout mRootContainer;
    private com.kwad.components.core.b.a mTitleBarHelper;
    private com.kwad.components.core.playable.a oM;

    private void b(Intent intent) {
        String stringExtra = intent.getStringExtra("key_template_json");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                this.mAdTemplate = new AdTemplate();
                this.mAdTemplate.parseJson(new JSONObject(stringExtra));
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            }
        }
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        com.kwad.sdk.service.b.a(BaseFragmentActivity.FragmentActivity8.class, a.class);
        Intent intent = new Intent(context, (Class<?>) BaseFragmentActivity.FragmentActivity8.class);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        context.startActivity(intent);
    }

    private void pA() {
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a(this.mRootContainer);
        this.mTitleBarHelper = aVar;
        aVar.a(this);
        this.mTitleBarHelper.a(new com.kwad.components.core.b.b(""));
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(BaseFragmentActivity.FragmentActivity8.class, a.class);
    }

    @Override // com.kwad.components.core.webview.jshandler.aq.b
    public final void a(aq.a aVar) {
        com.kwad.components.core.playable.a aVar2;
        com.kwad.sdk.core.e.c.d("AdPlayableActivityProxy", "updatePageStatus status: " + aVar);
        if (aVar.status == 1 && (aVar2 = this.oM) != null) {
            aVar2.e(PlayableSource.UNKNOWN_TRYPLAY_ENTRY_SOURCE);
        }
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "AdPlayableActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        try {
            super.onCreate(bundle);
            getActivity().setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
            setContentView(R.layout.ksad_activity_playable);
            b(getIntent());
            this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_playable_activity_root);
            KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.ksad_playable_webview);
            pA();
            com.kwad.components.core.playable.a aVar = new com.kwad.components.core.playable.a(ksAdWebView);
            this.oM = aVar;
            aVar.a(this.mAdTemplate, this.mRootContainer, this.mApkDownloadHelper);
            this.oM.a(this);
            this.oM.qE();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            this.oM.b(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onRestart() {
        super.onRestart();
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    @Override // com.kwad.components.core.b.a.InterfaceC0777a
    public final void u(View view) {
        onBackPressed();
    }

    @Override // com.kwad.components.core.b.a.InterfaceC0777a
    public final void v(View view) {
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cL(6), (JSONObject) null);
        finish();
    }
}
