package androidx.navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.MainThread;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;

/* loaded from: classes.dex */
public final class ActivityNavArgsLazyKt {
    @MainThread
    public static final /* synthetic */ <Args extends NavArgs> NavArgsLazy<Args> navArgs(final Activity activity) {
        IIX0o.x0xO0oo(activity, "<this>");
        IIX0o.OxI(4, "Args");
        return new NavArgsLazy<>(IO.oxoX(NavArgs.class), new Oox.oIX0oI<Bundle>() { // from class: androidx.navigation.ActivityNavArgsLazyKt$navArgs$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final Bundle invoke() {
                Bundle bundle;
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Activity activity2 = activity;
                    bundle = intent.getExtras();
                    if (bundle == null) {
                        throw new IllegalStateException("Activity " + activity2 + " has null extras in " + intent);
                    }
                } else {
                    bundle = null;
                }
                if (bundle != null) {
                    return bundle;
                }
                throw new IllegalStateException("Activity " + activity + " has a null Intent");
            }
        });
    }
}
