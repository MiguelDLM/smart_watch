package com.sma.smartv3.ui.device.dial;

import android.graphics.Bitmap;
import com.blankj.utilcode.util.ThreadUtils;
import java.util.ArrayList;

/* loaded from: classes12.dex */
public final class AIGCFragment$generateAIGC$1 implements xxxI.II0xO0<Bitmap> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ AIGCFragment f22136oIX0oI;

    public AIGCFragment$generateAIGC$1(AIGCFragment aIGCFragment) {
        this.f22136oIX0oI = aIGCFragment;
    }

    public static final void I0Io(Bitmap bitmap, AIGCFragment this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        ArrayList arrayList = new ArrayList();
        arrayList.add(bitmap);
        this$0.showPicsSparkChain(arrayList);
    }

    @Override // xxxI.II0xO0
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public void handleResponse(@OXOo.oOoXoXO final Bitmap bitmap) {
        if (bitmap != null) {
            final AIGCFragment aIGCFragment = this.f22136oIX0oI;
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.device.dial.xxIXOIIO
                @Override // java.lang.Runnable
                public final void run() {
                    AIGCFragment$generateAIGC$1.I0Io(bitmap, aIGCFragment);
                }
            });
        }
    }

    @Override // xxxI.II0xO0
    public void handleError(@OXOo.OOXIXo String error) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
    }
}
