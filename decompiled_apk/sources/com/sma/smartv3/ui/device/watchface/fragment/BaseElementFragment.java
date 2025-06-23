package com.sma.smartv3.ui.device.watchface.fragment;

import android.view.View;
import com.bestmafen.androidbase.base.BaseFragment;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public abstract class BaseElementFragment extends BaseFragment {

    @OXOo.oOoXoXO
    private View.OnClickListener mOnViewClickListener;

    @OXOo.oOoXoXO
    public final View.OnClickListener getMOnViewClickListener() {
        return this.mOnViewClickListener;
    }

    public abstract void reset();

    public final void setMOnViewClickListener(@OXOo.oOoXoXO View.OnClickListener onClickListener) {
        this.mOnViewClickListener = onClickListener;
    }

    public final void setOnViewClickListener(@OXOo.OOXIXo View.OnClickListener listener) {
        IIX0o.x0xO0oo(listener, "listener");
        this.mOnViewClickListener = listener;
    }
}
