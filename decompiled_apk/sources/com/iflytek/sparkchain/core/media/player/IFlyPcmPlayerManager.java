package com.iflytek.sparkchain.core.media.player;

import com.iflytek.sparkchain.media.PcmPlayerHelper;

@Deprecated
/* loaded from: classes10.dex */
public class IFlyPcmPlayerManager extends PcmPlayerHelper {

    /* loaded from: classes10.dex */
    public static class Holder {
        private static IFlyPcmPlayerManager instance = new IFlyPcmPlayerManager();

        private Holder() {
        }
    }

    private IFlyPcmPlayerManager() {
    }

    public static IFlyPcmPlayerManager getInst() {
        return Holder.instance;
    }
}
