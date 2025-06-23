package com.jieli.jl_filebrowse.tool;

import android.os.Handler;
import com.jieli.jl_filebrowse.interfaces.lrc.LrcReadObserver;
import com.jieli.jl_rcsp.tool.callback.BaseCallbackManager;

/* loaded from: classes10.dex */
public class LrcReadObserverHelper extends BaseCallbackManager<LrcReadObserver> implements LrcReadObserver {
    public LrcReadObserverHelper(Handler handler) {
        super(handler);
    }

    @Override // com.jieli.jl_filebrowse.interfaces.lrc.LrcReadObserver
    public void onLrcReadFailed(final int i) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: x0OIX00oO.xxIXOIIO
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((LrcReadObserver) obj).onLrcReadFailed(i);
            }
        });
    }

    @Override // com.jieli.jl_filebrowse.interfaces.lrc.LrcReadObserver
    public void onLrcReadStart() {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: x0OIX00oO.Oxx0IOOO
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((LrcReadObserver) obj).onLrcReadStart();
            }
        });
    }

    @Override // com.jieli.jl_filebrowse.interfaces.lrc.LrcReadObserver
    public void onLrcReadStop(final String str) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: x0OIX00oO.II0XooXoX
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((LrcReadObserver) obj).onLrcReadStop(str);
            }
        });
    }
}
