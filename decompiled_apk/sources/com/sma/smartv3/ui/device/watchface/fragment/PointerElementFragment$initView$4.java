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

@XX({"SMAP\nPointerElementFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PointerElementFragment.kt\ncom/sma/smartv3/ui/device/watchface/fragment/PointerElementFragment$initView$4\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,120:1\n1864#2,3:121\n*S KotlinDebug\n*F\n+ 1 PointerElementFragment.kt\ncom/sma/smartv3/ui/device/watchface/fragment/PointerElementFragment$initView$4\n*L\n95#1:121,3\n*E\n"})
/* loaded from: classes12.dex */
public final class PointerElementFragment$initView$4 extends CommonAdapter<ResourcesIdInfo> {
    final /* synthetic */ PointerElementFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointerElementFragment$initView$4(PointerElementFragment pointerElementFragment, FragmentActivity fragmentActivity, int i, List<ResourcesIdInfo> list) {
        super(fragmentActivity, i, list);
        this.this$0 = pointerElementFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$1(PointerElementFragment$initView$4 this$0, PointerElementFragment this$1, int i, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(this$1, "this$1");
        Iterable mDatas = ((CommonAdapter) this$0).mDatas;
        IIX0o.oO(mDatas, "mDatas");
        int i2 = 0;
        for (Object obj : mDatas) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            ResourcesIdInfo resourcesIdInfo = (ResourcesIdInfo) obj;
            if (i2 == i) {
                resourcesIdInfo.setSelect(!resourcesIdInfo.isSelect());
            } else {
                resourcesIdInfo.setSelect(false);
            }
            i2 = i3;
        }
        this$1.getCallback().II0xO0(Integer.valueOf(i), ((ResourcesIdInfo) ((CommonAdapter) this$0).mDatas.get(i)).isSelect());
        this$0.notifyDataSetChanged();
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo ResourcesIdInfo resourcesIdInfo, final int i) {
        IIX0o.x0xO0oo(holder, "holder");
        IIX0o.x0xO0oo(resourcesIdInfo, "resourcesIdInfo");
        ((ImageView) holder.getView(R.id.pointerIv)).setImageResource(resourcesIdInfo.getResId());
        ((ImageView) holder.getView(R.id.selectStatus)).setVisibility(resourcesIdInfo.isSelect() ? 0 : 8);
        RelativeLayout relativeLayout = (RelativeLayout) holder.getView(R.id.rv);
        final PointerElementFragment pointerElementFragment = this.this$0;
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.watchface.fragment.xoIox
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PointerElementFragment$initView$4.convert$lambda$1(PointerElementFragment$initView$4.this, pointerElementFragment, i, view);
            }
        });
    }
}
