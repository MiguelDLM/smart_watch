package com.sma.smartv3.ui.me.item;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.View;
import android.widget.LinearLayout;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.x0xO0oo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes11.dex */
public class MainMiddleItem extends BaseDslItem {
    private LinearLayout btContactUs;
    private LinearLayout btFAQ;
    private LinearLayout btHelp;
    private LinearLayout btTalk;
    private final boolean initEvent = true;

    @oOoXoXO
    private View.OnClickListener mOnClick;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.btHelp);
        IIX0o.ooOOo0oXI(v);
        this.btHelp = (LinearLayout) v;
        View v2 = itemHolder.v(R.id.btTalk);
        IIX0o.ooOOo0oXI(v2);
        this.btTalk = (LinearLayout) v2;
        View v3 = itemHolder.v(R.id.btContactUs);
        IIX0o.ooOOo0oXI(v3);
        this.btContactUs = (LinearLayout) v3;
        View v4 = itemHolder.v(R.id.btFAQ);
        IIX0o.ooOOo0oXI(v4);
        this.btFAQ = (LinearLayout) v4;
        itemHolder.click(R.id.btGoal, this.mOnClick);
        itemHolder.click(R.id.btHelp, this.mOnClick);
        itemHolder.click(R.id.btTalk, this.mOnClick);
        itemHolder.click(R.id.btFAQ, this.mOnClick);
        itemHolder.click(R.id.btContactUs, this.mOnClick);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @oOoXoXO
    public final View.OnClickListener getMOnClick() {
        return this.mOnClick;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        int i;
        int i2;
        int i3;
        LinearLayout linearLayout = this.btHelp;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            IIX0o.XOxIOxOx("btHelp");
            linearLayout = null;
        }
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        int i4 = 8;
        if (projectManager.xoxXI()) {
            i = 0;
        } else {
            i = 8;
        }
        linearLayout.setVisibility(i);
        LinearLayout linearLayout3 = this.btTalk;
        if (linearLayout3 == null) {
            IIX0o.XOxIOxOx("btTalk");
            linearLayout3 = null;
        }
        if (projectManager.ox()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        linearLayout3.setVisibility(i2);
        LinearLayout linearLayout4 = this.btContactUs;
        if (linearLayout4 == null) {
            IIX0o.XOxIOxOx("btContactUs");
            linearLayout4 = null;
        }
        if (projectManager.I0X0x0oIo()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        linearLayout4.setVisibility(i3);
        LinearLayout linearLayout5 = this.btFAQ;
        if (linearLayout5 == null) {
            IIX0o.XOxIOxOx("btFAQ");
        } else {
            linearLayout2 = linearLayout5;
        }
        if (projectManager.XoI0Ixx0()) {
            i4 = 0;
        }
        linearLayout2.setVisibility(i4);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.me_item_middle;
    }

    @XO0.XO(tag = x0xO0oo.f24572IO)
    public final void onBindStateChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        initView();
    }

    public final void setMOnClick(@oOoXoXO View.OnClickListener onClickListener) {
        this.mOnClick = onClickListener;
    }
}
