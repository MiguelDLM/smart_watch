package com.sma.smartv3.ui.device.watchface.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.ResourcesIdInfo;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nTimeElementFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeElementFragment.kt\ncom/sma/smartv3/ui/device/watchface/fragment/TimeElementFragment$initView$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,79:1\n1864#2,3:80\n*S KotlinDebug\n*F\n+ 1 TimeElementFragment.kt\ncom/sma/smartv3/ui/device/watchface/fragment/TimeElementFragment$initView$2\n*L\n52#1:80,3\n*E\n"})
/* loaded from: classes12.dex */
public final class TimeElementFragment$initView$2 extends CommonAdapter<ResourcesIdInfo> {
    final /* synthetic */ TimeElementFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeElementFragment$initView$2(TimeElementFragment timeElementFragment, FragmentActivity fragmentActivity, List<ResourcesIdInfo> list) {
        super(fragmentActivity, R.layout.item_watchface_element_color_select, list);
        this.this$0 = timeElementFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$1(TimeElementFragment$initView$2 this$0, int i, TimeElementFragment this$1, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(this$1, "this$1");
        Iterable mDatas = ((CommonAdapter) this$0).mDatas;
        IIX0o.oO(mDatas, "mDatas");
        int i2 = 0;
        int i3 = 0;
        for (Object obj : mDatas) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            ResourcesIdInfo resourcesIdInfo = (ResourcesIdInfo) obj;
            if (i3 == i) {
                resourcesIdInfo.setSelect(!resourcesIdInfo.isSelect());
            } else {
                resourcesIdInfo.setSelect(false);
            }
            i3 = i4;
        }
        boolean isSelect = ((ResourcesIdInfo) ((CommonAdapter) this$0).mDatas.get(i)).isSelect();
        ImageView dialSelectStatus0 = this$1.getDialSelectStatus0();
        if (!isSelect) {
            i2 = 8;
        }
        dialSelectStatus0.setVisibility(i2);
        this$1.getCallback().oIX0oI(Integer.valueOf(i), isSelect);
        this$0.notifyDataSetChanged();
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo ResourcesIdInfo resourcesIdInfo, final int i) {
        IIX0o.x0xO0oo(holder, "holder");
        IIX0o.x0xO0oo(resourcesIdInfo, "resourcesIdInfo");
        ((ImageView) holder.getView(R.id.colorIv)).setImageResource(resourcesIdInfo.getResId());
        ((ImageView) holder.getView(R.id.selectStatus)).setVisibility(resourcesIdInfo.isSelect() ? 0 : 8);
        RelativeLayout relativeLayout = (RelativeLayout) holder.getView(R.id.rv);
        final TimeElementFragment timeElementFragment = this.this$0;
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.watchface.fragment.oOoXoXO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimeElementFragment$initView$2.convert$lambda$1(TimeElementFragment$initView$2.this, i, timeElementFragment, view);
            }
        });
    }
}
