package androidx.work.impl;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import XO0OX.xoIox;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

public interface StartStopTokens {
    @OOXIXo
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ StartStopTokens create$default(Companion companion, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = true;
            }
            return companion.create(z);
        }

        @xoIox
        @x0XOIxOo
        @OOXIXo
        public final StartStopTokens create() {
            return create$default(this, false, 1, (Object) null);
        }

        @xoIox
        @x0XOIxOo
        @OOXIXo
        public final StartStopTokens create(boolean z) {
            StartStopTokensImpl startStopTokensImpl = new StartStopTokensImpl();
            return z ? new SynchronizedStartStopTokensImpl(startStopTokensImpl) : startStopTokensImpl;
        }
    }

    boolean contains(@OOXIXo WorkGenerationalId workGenerationalId);

    @oOoXoXO
    StartStopToken remove(@OOXIXo WorkGenerationalId workGenerationalId);

    @oOoXoXO
    StartStopToken remove(@OOXIXo WorkSpec workSpec);

    @OOXIXo
    List<StartStopToken> remove(@OOXIXo String str);

    @OOXIXo
    StartStopToken tokenFor(@OOXIXo WorkGenerationalId workGenerationalId);

    @OOXIXo
    StartStopToken tokenFor(@OOXIXo WorkSpec workSpec);
}
