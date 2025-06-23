package com.kwad.sdk.contentalliance.a.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;

/* loaded from: classes11.dex */
public final class b {
    public AdTemplate adTemplate;
    public com.kwad.sdk.contentalliance.a.a.a apW;
    public boolean isNoCache;
    public String manifest;
    public VideoPlayerStatus videoPlayerStatus;
    public String videoUrl;

    /* loaded from: classes11.dex */
    public static class a {
        private AdTemplate adTemplate;
        private com.kwad.sdk.contentalliance.a.a.a apW;
        private boolean isNoCache = false;
        private String manifest;
        private VideoPlayerStatus videoPlayerStatus;
        private String videoUrl;

        public a(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        public final b BJ() {
            return new b(this, (byte) 0);
        }

        public final a bl(boolean z) {
            this.isNoCache = z;
            return this;
        }

        public final a da(String str) {
            this.videoUrl = str;
            return this;
        }

        public final a db(String str) {
            this.manifest = str;
            return this;
        }

        public final a a(VideoPlayerStatus videoPlayerStatus) {
            this.videoPlayerStatus = videoPlayerStatus;
            return this;
        }

        public final a b(@NonNull com.kwad.sdk.contentalliance.a.a.a aVar) {
            this.apW = aVar;
            return this;
        }

        public a(String str) {
            this.videoUrl = str;
        }
    }

    public /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }

    private b(a aVar) {
        this.apW = new com.kwad.sdk.contentalliance.a.a.a();
        this.isNoCache = false;
        this.adTemplate = aVar.adTemplate;
        this.videoUrl = aVar.videoUrl;
        this.manifest = aVar.manifest;
        this.videoPlayerStatus = aVar.videoPlayerStatus;
        if (aVar.apW != null) {
            this.apW.photoId = aVar.apW.photoId;
            this.apW.clickTime = aVar.apW.clickTime;
            this.apW.adStyle = aVar.apW.adStyle;
            this.apW.contentType = aVar.apW.contentType;
        }
        this.isNoCache = aVar.isNoCache;
    }
}
