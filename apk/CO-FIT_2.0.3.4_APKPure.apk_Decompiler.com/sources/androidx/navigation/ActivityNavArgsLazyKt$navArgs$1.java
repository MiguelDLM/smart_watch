package androidx.navigation;

import Oox.oIX0oI;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import kotlin.jvm.internal.Lambda;

public final class ActivityNavArgsLazyKt$navArgs$1 extends Lambda implements oIX0oI<Bundle> {
    final /* synthetic */ Activity $this_navArgs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityNavArgsLazyKt$navArgs$1(Activity activity) {
        super(0);
        this.$this_navArgs = activity;
    }

    public final Bundle invoke() {
        Bundle bundle;
        Intent intent = this.$this_navArgs.getIntent();
        if (intent != null) {
            Activity activity = this.$this_navArgs;
            bundle = intent.getExtras();
            if (bundle == null) {
                throw new IllegalStateException("Activity " + activity + " has null extras in " + intent);
            }
        } else {
            bundle = null;
        }
        if (bundle != null) {
            return bundle;
        }
        throw new IllegalStateException("Activity " + this.$this_navArgs + " has a null Intent");
    }
}
