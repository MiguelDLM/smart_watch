package com.kwad.components.ad.j;

import com.iflytek.sparkchain.utils.constants.ErrorCode;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.h;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: classes11.dex */
public class c implements h.a {
    private static volatile c HT;

    private c() {
    }

    public static c mD() {
        if (HT == null) {
            synchronized (c.class) {
                try {
                    if (HT == null) {
                        HT = new c();
                    }
                } finally {
                }
            }
        }
        return HT;
    }

    @Override // com.kwad.sdk.core.network.h.a
    public final void a(f fVar, int i) {
        SceneImpl scene;
        int i2;
        if ((fVar instanceof com.kwad.components.core.request.a) && i != e.awK.errorCode && (scene = fVar.getScene()) != null) {
            long posId = scene.getPosId();
            if (i == e.awF.errorCode) {
                i2 = ErrorCode.ERROR_COMPONENT_NOT_INSTALLED;
            } else if (i == e.awJ.errorCode) {
                i2 = ErrorCode.ERROR_ENGINE_INIT_FAIL;
            } else if (i > 0 && i < 1000) {
                i2 = ErrorCode.ERROR_ENGINE_NOT_SUPPORTED;
            } else {
                i2 = ErrorCode.ERROR_ENGINE_CALL_FAIL;
            }
            com.kwad.components.core.o.a.qI().a(posId, i2);
        }
    }

    public final void init() {
        h.Ex().a(this);
    }
}
