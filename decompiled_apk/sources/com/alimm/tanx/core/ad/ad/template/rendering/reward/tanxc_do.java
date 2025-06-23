package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import com.alimm.tanx.core.view.player.core.PlayerBufferingState;
import com.alimm.tanx.core.view.player.core.PlayerState;

/* loaded from: classes.dex */
public class tanxc_do {
    public static String tanxc_do(PlayerState playerState) {
        if (playerState != PlayerState.IDLE && playerState != PlayerState.INITIALIZED && playerState != PlayerState.PREPARING) {
            if (playerState == PlayerState.PREPARED) {
                return "ready";
            }
            if (playerState == PlayerState.STARTED) {
                return "playing";
            }
            if (playerState == PlayerState.PAUSED || playerState == PlayerState.STOPPED) {
                return "pausing";
            }
            if (playerState == PlayerState.ERROR) {
                return "error";
            }
            if (playerState != PlayerState.COMPLETED && playerState != PlayerState.END) {
                return "unknown";
            }
            return "end";
        }
        return "preparing";
    }

    public static String tanxc_do(PlayerBufferingState playerBufferingState) {
        if (playerBufferingState == PlayerBufferingState.BUFFERING_START) {
            return "buffering";
        }
        return "playing";
    }
}
