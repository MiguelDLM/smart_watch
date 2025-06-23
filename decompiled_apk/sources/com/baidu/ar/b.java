package com.baidu.ar;

import com.baidu.ar.audio.IEasyAudio;

/* loaded from: classes7.dex */
public class b {
    public static fe c() {
        return (fe) kr.cq("com.baidu.ar.imu.IMUController");
    }

    public static ho d() {
        return (ho) kr.x("com.baidu.ar.recorder.MovieRecorder", "getInstance");
    }

    public static IEasyAudio e() {
        return (IEasyAudio) kr.x("com.baidu.ar.audio.EasyAudio", "getInstance");
    }
}
