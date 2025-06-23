package com.sma.smartv3.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.maps.SupportMapFragment;
import com.sma.smartv3.co_fit.R;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class CustomSupportMapFragment extends SupportMapFragment {

    @OXOo.oOoXoXO
    private oIX0oI mListener;

    /* loaded from: classes12.dex */
    public final class TouchableWrapper extends FrameLayout {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TouchableWrapper(@OXOo.oOoXoXO Context context) {
            super(context);
            IIX0o.ooOOo0oXI(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(@OXOo.OOXIXo MotionEvent event) {
            IIX0o.x0xO0oo(event, "event");
            int action = event.getAction();
            if (action == 0) {
                oIX0oI oix0oi = CustomSupportMapFragment.this.mListener;
                IIX0o.ooOOo0oXI(oix0oi);
                oix0oi.oIX0oI();
            } else if (action == 1) {
                oIX0oI oix0oi2 = CustomSupportMapFragment.this.mListener;
                IIX0o.ooOOo0oXI(oix0oi2);
                oix0oi2.oIX0oI();
            }
            return super.dispatchTouchEvent(event);
        }
    }

    /* loaded from: classes12.dex */
    public interface oIX0oI {
        void oIX0oI();
    }

    @Override // com.google.android.gms.maps.SupportMapFragment, androidx.fragment.app.Fragment
    @OXOo.OOXIXo
    public View onCreateView(@OXOo.OOXIXo LayoutInflater inflater, @OXOo.oOoXoXO ViewGroup viewGroup, @OXOo.oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, viewGroup, bundle);
        IIX0o.oO(onCreateView, "onCreateView(...)");
        TouchableWrapper touchableWrapper = new TouchableWrapper(getActivity());
        touchableWrapper.setBackgroundColor(getResources().getColor(R.color.transparent));
        ((ViewGroup) onCreateView).addView(touchableWrapper, new ViewGroup.LayoutParams(-1, -1));
        return onCreateView;
    }

    public final void setListener(@OXOo.oOoXoXO oIX0oI oix0oi) {
        this.mListener = oix0oi;
    }
}
