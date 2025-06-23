package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

/* loaded from: classes.dex */
public interface StartStopTokens {

    @OXOo.OOXIXo
    public static final Companion Companion = Companion.$$INSTANCE;

    /* loaded from: classes.dex */
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

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        @XO0OX.xoIox
        public final StartStopTokens create() {
            return create$default(this, false, 1, null);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        @XO0OX.xoIox
        public final StartStopTokens create(boolean z) {
            StartStopTokensImpl startStopTokensImpl = new StartStopTokensImpl();
            return z ? new SynchronizedStartStopTokensImpl(startStopTokensImpl) : startStopTokensImpl;
        }
    }

    boolean contains(@OXOo.OOXIXo WorkGenerationalId workGenerationalId);

    @OXOo.oOoXoXO
    StartStopToken remove(@OXOo.OOXIXo WorkGenerationalId workGenerationalId);

    @OXOo.oOoXoXO
    StartStopToken remove(@OXOo.OOXIXo WorkSpec workSpec);

    @OXOo.OOXIXo
    List<StartStopToken> remove(@OXOo.OOXIXo String str);

    @OXOo.OOXIXo
    StartStopToken tokenFor(@OXOo.OOXIXo WorkGenerationalId workGenerationalId);

    @OXOo.OOXIXo
    StartStopToken tokenFor(@OXOo.OOXIXo WorkSpec workSpec);
}
