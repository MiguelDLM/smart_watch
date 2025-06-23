package androidx.activity;

import OXOo.OOXIXo;
import android.app.Activity;
import android.app.PictureInPictureParams;
import android.graphics.Rect;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(26)
public final class Api26Impl {
    @OOXIXo
    public static final Api26Impl INSTANCE = new Api26Impl();

    private Api26Impl() {
    }

    public final void setPipParamsSourceRectHint(@OOXIXo Activity activity, @OOXIXo Rect rect) {
        IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
        IIX0o.x0xO0oo(rect, ViewHierarchyConstants.HINT_KEY);
        activity.setPictureInPictureParams(new PictureInPictureParams.Builder().setSourceRectHint(rect).build());
    }
}
