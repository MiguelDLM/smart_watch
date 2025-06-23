package com.kwad.components.core.r.a;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.b.a;
import com.kwad.components.core.c.f;
import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
/* loaded from: classes11.dex */
public class a extends com.kwad.components.core.l.b<b> {
    private static final ConcurrentMap<Integer, Map<String, Object>> To = new ConcurrentHashMap();
    private static final AtomicInteger Tp = new AtomicInteger(1);
    private StyleTemplate Th;
    private String Ti;
    private boolean Tj;
    private l Tk;
    private k Tl;
    private com.kwad.components.core.r.b.b Tm;
    private int Tn;
    private AdResultData mAdResultData;
    private AdBaseFrameLayout mRootContainer;
    private com.kwad.components.core.b.a mTitleBarHelper;

    public static void a(int i, String str, Object obj) {
        ConcurrentMap<Integer, Map<String, Object>> concurrentMap = To;
        Map<String, Object> map = concurrentMap.get(Integer.valueOf(i));
        if (map == null) {
            map = new HashMap<>();
            concurrentMap.put(Integer.valueOf(i), map);
        }
        map.put(str, obj);
    }

    private static void aK(int i) {
        Map<String, Object> map = To.get(Integer.valueOf(i));
        if (map != null) {
            map.clear();
        }
    }

    private Object az(String str) {
        return o(this.Tn, str);
    }

    private static Object o(int i, String str) {
        Map<String, Object> map = To.get(Integer.valueOf(i));
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(FeedDownloadActivity.class, a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.l.b
    /* renamed from: rs, reason: merged with bridge method [inline-methods] */
    public b onCreateCallerContext() {
        b bVar = new b(this);
        bVar.d(this.mAdResultData);
        bVar.Th = this.Th;
        bVar.mRootContainer = this.mRootContainer;
        bVar.Tk = this.Tk;
        bVar.Tl = this.Tl;
        return bVar;
    }

    public static int rt() {
        return Tp.incrementAndGet();
    }

    @Override // com.kwad.components.core.proxy.c
    public boolean checkIntentData(@Nullable Intent intent) {
        this.Tn = getIntent().getIntExtra("tk_id", 0);
        String stringExtra = getIntent().getStringExtra("tk_style_template");
        k kVar = (k) az("tk_view_holder");
        if (TextUtils.isEmpty(stringExtra) && kVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                StyleTemplate styleTemplate = new StyleTemplate();
                styleTemplate.parseJson(new JSONObject(stringExtra));
                this.Th = styleTemplate;
            } catch (Throwable th) {
                c.printStackTrace(th);
                return false;
            }
        }
        if (kVar != null) {
            this.Tl = kVar;
        }
        int intExtra = getIntent().getIntExtra("ad_result_cache_idx", 0);
        AdResultData d = f.ne().d(intExtra, true);
        this.mAdResultData = d;
        if (intExtra > 0 && d == null) {
            return false;
        }
        return true;
    }

    @Override // com.kwad.components.core.proxy.c
    public int getLayoutId() {
        return R.layout.ksad_tk_page;
    }

    @Override // com.kwad.components.core.proxy.c
    public String getPageName() {
        return "TKActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.c
    public void initData() {
        this.Tj = getIntent().getBooleanExtra("show_navigationBar", true);
        this.Ti = getIntent().getStringExtra("title");
        this.Tk = (l) az("native_intent");
    }

    @Override // com.kwad.components.core.proxy.c
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_tk_root_container);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ksad_js_container);
        if (!this.Tj && frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            frameLayout.setLayoutParams(layoutParams);
        }
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a((ViewGroup) findViewById(R.id.ksad_kwad_web_title_bar));
        this.mTitleBarHelper = aVar;
        aVar.a(new a.InterfaceC0777a() { // from class: com.kwad.components.core.r.a.a.1
            @Override // com.kwad.components.core.b.a.InterfaceC0777a
            public final void u(View view) {
                a.this.finish();
            }

            @Override // com.kwad.components.core.b.a.InterfaceC0777a
            public final void v(View view) {
            }
        });
        this.mTitleBarHelper.a(new com.kwad.components.core.b.b(this.Ti));
        this.mTitleBarHelper.ah(false);
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        com.kwad.components.core.r.b.b bVar = this.Tm;
        if (bVar != null && bVar.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.kwad.components.core.l.b
    public Presenter onCreatePresenter() {
        if (this.Th != null) {
            return new com.kwad.components.core.r.b.a();
        }
        if (this.Tm == null) {
            this.Tm = new com.kwad.components.core.r.b.b();
        }
        return this.Tm;
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            aK(this.Tn);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }
}
