package com.facebook.internal.logging.dumpsys;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.io.PrintWriter;

/* loaded from: classes8.dex */
public interface EndToEndDumper {

    @OOXIXo
    public static final Companion Companion = Companion.$$INSTANCE;

    /* loaded from: classes8.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @oOoXoXO
        private static EndToEndDumper instance;

        private Companion() {
        }

        @oOoXoXO
        public final EndToEndDumper getInstance() {
            return instance;
        }

        public final void setInstance(@oOoXoXO EndToEndDumper endToEndDumper) {
            instance = endToEndDumper;
        }
    }

    boolean maybeDump(@OOXIXo String str, @OOXIXo PrintWriter printWriter, @oOoXoXO String[] strArr);
}
