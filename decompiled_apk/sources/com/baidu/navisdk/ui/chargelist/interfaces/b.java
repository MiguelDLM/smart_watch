package com.baidu.navisdk.ui.chargelist.interfaces;

import OXOo.OOXIXo;
import com.baidu.navisdk.ui.chargelist.data.beans.e;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public interface b {

    /* loaded from: classes8.dex */
    public static final class a {
        public static void a(@OOXIXo b bVar) {
        }

        public static void a(@OOXIXo b bVar, @OOXIXo com.baidu.navisdk.ui.chargelist.data.beans.b chargeWrapper) {
            IIX0o.x0xO0oo(chargeWrapper, "chargeWrapper");
        }

        public static void a(@OOXIXo b bVar, @OOXIXo e stationWrapper) {
            IIX0o.x0xO0oo(stationWrapper, "stationWrapper");
        }
    }

    void a(@OOXIXo com.baidu.navisdk.ui.chargelist.data.beans.b bVar);

    void a(@OOXIXo e eVar);

    void b();

    void b(@OOXIXo com.baidu.navisdk.ui.chargelist.data.beans.b bVar);

    void b(@OOXIXo e eVar);

    void c(@OOXIXo e eVar);
}
