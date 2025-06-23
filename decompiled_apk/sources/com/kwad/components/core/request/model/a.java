package com.kwad.components.core.request.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.i;
import com.kwad.sdk.commercial.d.d;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;

/* loaded from: classes11.dex */
public final class a {

    @NonNull
    public final ImpInfo MX;

    @NonNull
    public final com.kwad.components.core.request.c Sb;

    @Nullable
    public i Sc;

    @Nullable
    public List<String> Sd;
    public boolean Se;
    public boolean Sf;

    @Nullable
    public c Sg;
    private String Sh;

    /* renamed from: com.kwad.components.core.request.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0806a {
        public ImpInfo MX;
        public com.kwad.components.core.request.c Sb;
        public boolean Se;
        public boolean Sf;
        public i Si;

        public final C0806a a(@NonNull com.kwad.components.core.request.c cVar) {
            this.Sb = cVar;
            return this;
        }

        public final C0806a aI(boolean z) {
            this.Se = true;
            return this;
        }

        public final C0806a aJ(boolean z) {
            this.Sf = z;
            return this;
        }

        public final C0806a e(ImpInfo impInfo) {
            this.MX = impInfo;
            return this;
        }

        public final a ra() {
            if (com.kwad.components.ad.e.a.md.booleanValue() && (this.MX == null || this.Sb == null)) {
                throw new IllegalStateException("AdRequestParams build Illegal");
            }
            return new a(this, (byte) 0);
        }

        public final C0806a a(i iVar) {
            this.Si = iVar;
            return this;
        }
    }

    public /* synthetic */ a(C0806a c0806a, byte b) {
        this(c0806a);
    }

    public static void a(@NonNull a aVar, AdResultData adResultData, boolean z) {
        d.a(aVar.MX.adScene, aVar.qZ(), adResultData.getAdSource());
        if (adResultData.isAdResultDataEmpty()) {
            aVar.Sb.a(e.awK.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? e.awK.msg : adResultData.testErrorMsg, z);
        } else {
            aVar.Sb.a(adResultData, z);
        }
    }

    public final void ay(String str) {
        this.Sh = str;
    }

    public final int getAdNum() {
        SceneImpl sceneImpl = this.MX.adScene;
        if (sceneImpl != null) {
            return sceneImpl.getAdNum();
        }
        return 1;
    }

    public final int getAdStyle() {
        SceneImpl sceneImpl = this.MX.adScene;
        if (sceneImpl != null) {
            return sceneImpl.adStyle;
        }
        return 0;
    }

    public final long getPosId() {
        SceneImpl sceneImpl = this.MX.adScene;
        if (sceneImpl != null) {
            return sceneImpl.getPosId();
        }
        return -1L;
    }

    @Nullable
    public final i qY() {
        return this.Sc;
    }

    public final String qZ() {
        if (!TextUtils.isEmpty(this.Sh)) {
            return this.Sh;
        }
        return "network_only";
    }

    private a(C0806a c0806a) {
        this.MX = c0806a.MX;
        this.Sb = c0806a.Sb;
        this.Se = c0806a.Se;
        this.Sf = c0806a.Sf;
        this.Sc = c0806a.Si;
    }

    public static void a(@NonNull a aVar, int i, String str, boolean z) {
        aVar.Sb.a(i, str, z);
        d.a(aVar.getAdStyle(), i, str, aVar.qZ());
    }
}
