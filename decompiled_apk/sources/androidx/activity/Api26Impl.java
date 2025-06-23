package androidx.activity;

import android.app.Activity;
import android.app.PictureInPictureParams;
import android.graphics.Rect;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(26)
/* loaded from: classes.dex */
public final class Api26Impl {

    @OXOo.OOXIXo
    public static final Api26Impl INSTANCE = new Api26Impl();

    private Api26Impl() {
    }

    public final void setPipParamsSourceRectHint(@OXOo.OOXIXo Activity activity, @OXOo.OOXIXo Rect hint) {
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(hint, "hint");
        activity.setPictureInPictureParams(new PictureInPictureParams.Builder().setSourceRectHint(hint).build());
    }
}
