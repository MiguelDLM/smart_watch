package com.facebook.appevents.codeless.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.util.Log;
import java.lang.reflect.Method;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class UnityReflection {

    @OOXIXo
    private static final String CAPTURE_VIEW_HIERARCHY_METHOD = "CaptureViewHierarchy";

    @OOXIXo
    private static final String EVENT_MAPPING_METHOD = "OnReceiveMapping";

    @OOXIXo
    private static final String FB_UNITY_GAME_OBJECT = "UnityFacebookSDKPlugin";

    @OOXIXo
    public static final UnityReflection INSTANCE = new UnityReflection();

    @oOoXoXO
    private static final String TAG = UnityReflection.class.getCanonicalName();

    @OOXIXo
    private static final String UNITY_PLAYER_CLASS = "com.unity3d.player.UnityPlayer";

    @OOXIXo
    private static final String UNITY_SEND_MESSAGE_METHOD = "UnitySendMessage";
    private static Class<?> unityPlayer;

    private UnityReflection() {
    }

    @x0XOIxOo
    public static final void captureViewHierarchy() {
        sendMessage(FB_UNITY_GAME_OBJECT, CAPTURE_VIEW_HIERARCHY_METHOD, "");
    }

    private final Class<?> getUnityPlayerClass() {
        Class<?> cls = Class.forName(UNITY_PLAYER_CLASS);
        IIX0o.oO(cls, "forName(UNITY_PLAYER_CLASS)");
        return cls;
    }

    @x0XOIxOo
    public static final void sendEventMapping(@oOoXoXO String str) {
        sendMessage(FB_UNITY_GAME_OBJECT, EVENT_MAPPING_METHOD, str);
    }

    @x0XOIxOo
    public static final void sendMessage(@oOoXoXO String str, @oOoXoXO String str2, @oOoXoXO String str3) {
        try {
            if (unityPlayer == null) {
                unityPlayer = INSTANCE.getUnityPlayerClass();
            }
            Class<?> cls = unityPlayer;
            if (cls != null) {
                Method method = cls.getMethod(UNITY_SEND_MESSAGE_METHOD, String.class, String.class, String.class);
                IIX0o.oO(method, "unityPlayer.getMethod(\n              UNITY_SEND_MESSAGE_METHOD, String::class.java, String::class.java, String::class.java)");
                Class<?> cls2 = unityPlayer;
                if (cls2 != null) {
                    method.invoke(cls2, str, str2, str3);
                    return;
                } else {
                    IIX0o.XOxIOxOx("unityPlayer");
                    throw null;
                }
            }
            IIX0o.XOxIOxOx("unityPlayer");
            throw null;
        } catch (Exception e) {
            Log.e(TAG, "Failed to send message to Unity", e);
        }
    }
}
