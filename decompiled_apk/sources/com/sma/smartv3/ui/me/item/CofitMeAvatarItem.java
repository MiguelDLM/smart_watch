package com.sma.smartv3.ui.me.item;

import OXOo.OOXIXo;
import android.view.View;
import com.angcyo.dsladapter.DslViewHolder;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.x0xO0oo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes11.dex */
public final class CofitMeAvatarItem extends MainAvatarItem {
    private View ivVip;

    @Override // com.sma.smartv3.ui.me.item.MainAvatarItem, com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        super.bindView(itemHolder);
        View v = itemHolder.v(R.id.iv_avatar_vip);
        IIX0o.ooOOo0oXI(v);
        this.ivVip = v;
    }

    @Override // com.sma.smartv3.ui.me.item.MainAvatarItem, com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        int i;
        super.initView();
        View view = this.ivVip;
        if (view == null) {
            IIX0o.XOxIOxOx("ivVip");
            view = null;
        }
        if (ProjectManager.f19822oIX0oI.IxIo()) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
    }

    @Override // com.sma.smartv3.ui.me.item.MainAvatarItem, com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.co_fit_me_item_avatar;
    }

    @XO0.XO(tag = x0xO0oo.f24656xOoOIoI)
    public final void onUserMemberChange(@OOXIXo Object data) {
        int i;
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onUserMemberChange");
        View view = this.ivVip;
        if (view == null) {
            IIX0o.XOxIOxOx("ivVip");
            view = null;
        }
        if (ProjectManager.f19822oIX0oI.IxIo()) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
    }
}
