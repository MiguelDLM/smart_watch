package com.baidu.navisdk.asr.i;

/* loaded from: classes7.dex */
public interface c {

    /* loaded from: classes7.dex */
    public enum a {
        START,
        LISTEN,
        RELISTEN,
        RECOGNIZE,
        PLAY,
        STOP,
        CANCEL,
        FINISH
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a();

        void a(boolean z);

        void onStop();
    }
}
