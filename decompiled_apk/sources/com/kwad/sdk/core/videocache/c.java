package com.kwad.sdk.core.videocache;

import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class c {
    public final File aCT;
    public final com.kwad.sdk.core.videocache.a.c aCU;
    public final com.kwad.sdk.core.videocache.a.a aCV;
    public final com.kwad.sdk.core.videocache.d.c aCW;
    public final com.kwad.sdk.core.videocache.b.b aCX;
    public final int aCY;
    public final int aCZ;

    public c(File file, com.kwad.sdk.core.videocache.a.c cVar, com.kwad.sdk.core.videocache.a.a aVar, com.kwad.sdk.core.videocache.d.c cVar2, com.kwad.sdk.core.videocache.b.b bVar, int i, int i2) {
        this.aCT = file;
        this.aCU = cVar;
        this.aCV = aVar;
        this.aCW = cVar2;
        this.aCX = bVar;
        this.aCY = i;
        this.aCZ = i2;
    }

    public final File eH(String str) {
        return new File(this.aCT, this.aCU.generate(str));
    }
}
