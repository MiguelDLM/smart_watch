package com.baidu.navisdk.comapi.trajectory;

import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.google.android.exoplayer2.PlaybackException;

/* loaded from: classes7.dex */
public enum j {
    /* JADX INFO: Fake field, exist only in values array */
    TRAJECTORY_FROM_INVALID(-1),
    TRAJECTORY_FROM_NAVI(2),
    TRAJECTORY_FROM_EDOG(3),
    TRAJECTORY_FROM_SDK_NAVI(4),
    /* JADX INFO: Fake field, exist only in values array */
    TRAJECTORY_FROM_SDK_EDOG(5),
    /* JADX INFO: Fake field, exist only in values array */
    TRAJECTORY_FROM_LIGHT(6),
    TRAJECTORY_FROM_ROUTE_CAR(8),
    /* JADX INFO: Fake field, exist only in values array */
    TRAJECTORY_FROM_COMMUTE_ROUTE(3008),
    TRAJECTORY_FROM_COMMUTE_GUIDE(3002),
    TRAJECTORY_FROM_MOTOR_ROUTE(4008),
    /* JADX INFO: Fake field, exist only in values array */
    TRAJECTORY_FROM_MOTOR_GUIDE(4002),
    TRAJECTORY_FROM_TRUCK_ROUTE(5008),
    /* JADX INFO: Fake field, exist only in values array */
    TRAJECTORY_FROM_SPEEDY_GUIDE(5002),
    /* JADX INFO: Fake field, exist only in values array */
    TRAJECTORY_FROM_SPEEDY_ROUTE(PlaybackException.ERROR_CODE_DRM_LICENSE_EXPIRED),
    /* JADX INFO: Fake field, exist only in values array */
    TRAJECTORY_FROM_SPEEDY_GUIDE(6002),
    TRAJECTORY_FROM_EDOG_TRUCK_CHALLENGE_MODE(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE);


    /* renamed from: a, reason: collision with root package name */
    private final int f6750a;

    j(int i) {
        this.f6750a = i;
    }

    public final int a() {
        return this.f6750a;
    }
}
