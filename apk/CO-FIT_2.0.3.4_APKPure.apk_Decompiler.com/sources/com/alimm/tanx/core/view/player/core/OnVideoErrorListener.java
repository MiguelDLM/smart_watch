package com.alimm.tanx.core.view.player.core;

import com.alimm.tanx.core.request.TanxPlayerError;

public interface OnVideoErrorListener {
    boolean onError(ITanxPlayer iTanxPlayer, TanxPlayerError tanxPlayerError);
}
