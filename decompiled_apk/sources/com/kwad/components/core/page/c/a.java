package com.kwad.components.core.page.c;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.EMachine;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes11.dex */
public final class a extends Presenter {
    private int OZ;
    private FeedVideoView Pa;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        final com.kwad.components.core.page.recycle.e eVar = (com.kwad.components.core.page.recycle.e) Kf();
        KsAdVideoPlayConfig build = new KsAdVideoPlayConfig.Builder().videoSoundEnable(eVar.adTemplate.mIsAudioEnable).build();
        FeedVideoView feedVideoView = (FeedVideoView) getRootView();
        this.Pa = feedVideoView;
        feedVideoView.b(com.kwad.sdk.core.response.b.c.dD(eVar.adTemplate));
        this.Pa.a(build, eVar.La);
        this.Pa.setVisibility(0);
        final AdInfo dS = com.kwad.sdk.core.response.b.e.dS(eVar.adTemplate);
        this.Pa.setOnEndBtnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    if (com.kwad.sdk.core.response.b.a.aE(dS)) {
                        if (eVar.La != null) {
                            com.kwad.components.core.e.d.a.a(new a.C0788a(a.this.getActivity()).ao(false).ap(false).at(true).ar(eVar.adTemplate).ar(false));
                            com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 50, a.this.Pa.getTouchCoords());
                            return;
                        }
                        return;
                    }
                    RecyclerView recyclerView = eVar.QC;
                    if (recyclerView != null && recyclerView.getAdapter() != null && eVar.QC.getAdapter().getItemCount() > 1) {
                        eVar.QC.scrollToPosition(1);
                        com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 50, a.this.Pa.getTouchCoords());
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        if (com.kwad.sdk.core.response.b.a.ap(dS)) {
            this.Pa.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    try {
                        if (com.kwad.sdk.core.response.b.a.aE(dS)) {
                            if (eVar.La != null) {
                                com.kwad.components.core.e.d.a.a(new a.C0788a(a.this.getActivity()).ao(false).ap(false).at(true).ar(eVar.adTemplate).ar(false));
                                com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, EMachine.EM_MANIK, a.this.Pa.getTouchCoords());
                                return;
                            }
                            return;
                        }
                        RecyclerView recyclerView = eVar.QC;
                        if (recyclerView != null && recyclerView.getAdapter() != null && eVar.QC.getAdapter().getItemCount() > 1) {
                            eVar.QC.scrollToPosition(1);
                            com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, EMachine.EM_MANIK, a.this.Pa.getTouchCoords());
                        }
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }
            });
        }
        this.Pa.setWindowFullScreenListener(new FeedVideoView.a() { // from class: com.kwad.components.core.page.c.a.3
            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void pP() {
                RecyclerView recyclerView = eVar.QC;
                if (recyclerView != null) {
                    a.this.OZ = recyclerView.computeVerticalScrollOffset();
                }
            }

            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void pQ() {
                RecyclerView recyclerView = eVar.QC;
                if (recyclerView != null) {
                    recyclerView.scrollToPosition(a.this.OZ);
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Pa.release();
    }
}
