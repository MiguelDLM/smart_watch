package com.sma.smartv3.otherdevice.charge;

import android.view.View;
import android.widget.ImageView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.ResourcesIdInfo;
import com.sma.smartv3.view.ImageViewRound;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes12.dex */
public final class ChargeMainActivity$initScreensaver$3 extends CommonAdapter<ResourcesIdInfo> {
    final /* synthetic */ ChargeMainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChargeMainActivity$initScreensaver$3(ChargeMainActivity chargeMainActivity, List<ResourcesIdInfo> list) {
        super(chargeMainActivity, R.layout.item_charge_screensaver_select, list);
        this.this$0 = chargeMainActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(ChargeMainActivity$initScreensaver$3 this$0, ResourcesIdInfo resourcesIdInfo, ChargeMainActivity this$1, int i, View view) {
        ImageViewRound ivScreensaver;
        List mScreensaverPics;
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(resourcesIdInfo, "$resourcesIdInfo");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$1, "this$1");
        Iterator it = ((CommonAdapter) this$0).mDatas.iterator();
        while (it.hasNext()) {
            ((ResourcesIdInfo) it.next()).setSelect(false);
        }
        resourcesIdInfo.setSelect(true);
        ivScreensaver = this$1.getIvScreensaver();
        mScreensaverPics = this$1.getMScreensaverPics();
        ivScreensaver.setImageResource(((ResourcesIdInfo) mScreensaverPics.get(i)).getResId());
        this$1.syncScreensaver();
        this$0.notifyDataSetChanged();
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo final ResourcesIdInfo resourcesIdInfo, final int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(resourcesIdInfo, "resourcesIdInfo");
        ((ImageView) holder.getView(R.id.selectStatus)).setVisibility(resourcesIdInfo.isSelect() ? 0 : 8);
        ((ImageView) holder.getView(R.id.iv)).setImageResource(resourcesIdInfo.getResId());
        ImageView imageView = (ImageView) holder.getView(R.id.iv);
        final ChargeMainActivity chargeMainActivity = this.this$0;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.otherdevice.charge.IoOoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChargeMainActivity$initScreensaver$3.convert$lambda$0(ChargeMainActivity$initScreensaver$3.this, resourcesIdInfo, chargeMainActivity, i, view);
            }
        });
    }
}
