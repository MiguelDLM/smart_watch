package com.baidu.navisdk.ui.routeguide.ace;

import OXOo.OOXIXo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    public static final h f8430a = new h();

    private h() {
    }

    public final int a(@OOXIXo String speed, int i) {
        IIX0o.x0xO0oo(speed, "speed");
        return (!IIX0o.Oxx0IOOO(HelpFormatter.DEFAULT_LONG_OPT_PREFIX, speed) && Integer.parseInt(speed) > i) ? 3 : 1;
    }

    public final int a(@OOXIXo String speed, int i, int i2, int i3) {
        IIX0o.x0xO0oo(speed, "speed");
        if (!IIX0o.Oxx0IOOO(HelpFormatter.DEFAULT_LONG_OPT_PREFIX, speed)) {
            int parseInt = Integer.parseInt(speed);
            if (i <= parseInt && i2 >= parseInt) {
                return 2;
            }
            if (Integer.parseInt(speed) > i3) {
                return 3;
            }
        }
        return 1;
    }
}
