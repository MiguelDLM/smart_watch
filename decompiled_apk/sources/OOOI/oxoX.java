package OOOI;

import OXOo.OOXIXo;
import android.app.Activity;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.blankj.utilcode.util.BarUtils;
import com.sma.smartv3.co_fit.R;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public class oxoX extends I0Io {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oxoX(@OOXIXo Activity activity) {
        super(activity);
        IIX0o.x0xO0oo(activity, "activity");
        setClippingEnabled(false);
        oOoXoXO().setPadding(0, BarUtils.getStatusBarHeight(), 0, BarUtils.getNavBarHeight());
    }

    @Override // OOOI.I0Io
    public void OxxIIOOXO(@OOXIXo View anchor) {
        IIX0o.x0xO0oo(anchor, "anchor");
        super.OxxIIOOXO(anchor);
        oOXoIIIo.oIX0oI.I0Io(Oxx0IOOO(), 1.0f);
        oOoXoXO().setBackgroundResource(R.color.popup_root_bg_color);
        xxIXOIIO().startAnimation(AnimationUtils.loadAnimation(Oxx0IOOO(), R.anim.pop_bottom_show_2));
    }
}
