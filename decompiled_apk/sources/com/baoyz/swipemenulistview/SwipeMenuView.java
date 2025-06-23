package com.baoyz.swipemenulistview;

import IIX0o.II0xO0;
import IIX0o.oxoX;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class SwipeMenuView extends LinearLayout implements View.OnClickListener {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public II0xO0 f10281IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public SwipeMenuLayout f10282Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public oIX0oI f10283Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public SwipeMenuListView f10284XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f10285oI0IIXIo;

    /* loaded from: classes8.dex */
    public interface oIX0oI {
        void oIX0oI(SwipeMenuView swipeMenuView, II0xO0 iI0xO0, int i);
    }

    public SwipeMenuView(II0xO0 iI0xO0, SwipeMenuListView swipeMenuListView) {
        super(iI0xO0.II0xO0());
        this.f10284XO = swipeMenuListView;
        this.f10281IXxxXO = iI0xO0;
        Iterator<oxoX> it = iI0xO0.oxoX().iterator();
        int i = 0;
        while (it.hasNext()) {
            oIX0oI(it.next(), i);
            i++;
        }
    }

    public final TextView I0Io(oxoX oxox) {
        TextView textView = new TextView(getContext());
        textView.setText(oxox.oxoX());
        textView.setGravity(17);
        textView.setTextSize(oxox.XO());
        textView.setTextColor(oxox.X0o0xo());
        return textView;
    }

    public final ImageView II0xO0(oxoX oxox) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(oxox.II0xO0());
        return imageView;
    }

    public oIX0oI getOnSwipeItemClickListener() {
        return this.f10283Oxx0xo;
    }

    public int getPosition() {
        return this.f10285oI0IIXIo;
    }

    public final void oIX0oI(oxoX oxox, int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(oxox.Oxx0IOOO(), -1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setId(i);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundDrawable(oxox.oIX0oI());
        linearLayout.setOnClickListener(this);
        addView(linearLayout);
        if (oxox.II0xO0() != null) {
            linearLayout.addView(II0xO0(oxox));
        }
        if (!TextUtils.isEmpty(oxox.oxoX())) {
            linearLayout.addView(I0Io(oxox));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f10283Oxx0xo != null && this.f10282Oo.Oxx0IOOO()) {
            this.f10283Oxx0xo.oIX0oI(this, this.f10281IXxxXO, view.getId());
        }
    }

    public void setLayout(SwipeMenuLayout swipeMenuLayout) {
        this.f10282Oo = swipeMenuLayout;
    }

    public void setOnSwipeItemClickListener(oIX0oI oix0oi) {
        this.f10283Oxx0xo = oix0oi;
    }

    public void setPosition(int i) {
        this.f10285oI0IIXIo = i;
    }
}
