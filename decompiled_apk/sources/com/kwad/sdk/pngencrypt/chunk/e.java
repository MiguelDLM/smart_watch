package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public class e {
    final com.kwad.sdk.pngencrypt.k aLs;
    List<PngChunk> aNl = new ArrayList();
    boolean aNm = false;

    public e(com.kwad.sdk.pngencrypt.k kVar) {
        this.aLs = kVar;
    }

    private static List<PngChunk> a(List<PngChunk> list, final String str, final String str2) {
        if (str2 == null) {
            return b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.1
                @Override // com.kwad.sdk.pngencrypt.chunk.c
                public final boolean a(PngChunk pngChunk) {
                    return pngChunk.ahY.equals(str);
                }
            });
        }
        return b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.2
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                if (!pngChunk.ahY.equals(str)) {
                    return false;
                }
                if ((pngChunk instanceof t) && !((t) pngChunk).getKey().equals(str2)) {
                    return false;
                }
                if ((pngChunk instanceof n) && !((n) pngChunk).Le().equals(str2)) {
                    return false;
                }
                return true;
            }
        });
    }

    public final List<PngChunk> KV() {
        return this.aNl;
    }

    public final List<? extends PngChunk> al(String str, String str2) {
        return a(this.aNl, str, str2);
    }

    public String toString() {
        return "ChunkList: read: " + this.aNl.size();
    }

    public final void a(PngChunk pngChunk, int i) {
        pngChunk.dO(i);
        this.aNl.add(pngChunk);
        if (pngChunk.ahY.equals("PLTE")) {
            this.aNm = true;
        }
    }
}
