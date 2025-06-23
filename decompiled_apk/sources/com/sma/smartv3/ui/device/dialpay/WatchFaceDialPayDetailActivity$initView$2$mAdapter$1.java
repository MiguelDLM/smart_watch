package com.sma.smartv3.ui.device.dialpay;

import OXOo.OOXIXo;
import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.WatchFaceCategoryV2;
import com.sma.smartv3.view.ProgressButtonV2;
import com.sma.smartv3.view.SquareImageView;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class WatchFaceDialPayDetailActivity$initView$2$mAdapter$1 extends CommonAdapter<WatchFaceCategoryV2> {
    final /* synthetic */ WatchFaceDialPayDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFaceDialPayDetailActivity$initView$2$mAdapter$1(WatchFaceDialPayDetailActivity watchFaceDialPayDetailActivity, Activity activity, List<WatchFaceCategoryV2> list) {
        super(activity, R.layout.item_dial_f3_v2, list);
        this.this$0 = watchFaceDialPayDetailActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(WatchFaceDialPayDetailActivity this$0, WatchFaceCategoryV2 item, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(item, "$item");
        if (this$0.isSync()) {
            ToastUtils.showLong(R.string.syncing_remind);
            return;
        }
        this$0.setMArg0(item.getPreviewUrl());
        this$0.setMArg1(item.getId());
        this$0.setMArg3(null);
        this$0.initData();
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OOXIXo ViewHolder viewHolder, @OOXIXo final WatchFaceCategoryV2 item, int i) {
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        IIX0o.x0xO0oo(item, "item");
        Glide.with((FragmentActivity) this.this$0).load(item.getPreviewUrl()).into((SquareImageView) viewHolder.getView(R.id.iv));
        ProgressButtonV2 progressButtonV2 = (ProgressButtonV2) viewHolder.getView(R.id.pb);
        IIX0o.ooOOo0oXI(progressButtonV2);
        oIX0oI.XO(progressButtonV2, item.getDollar(), item.getAmount(), item.getDollarDis(), item.getAmountDis(), item.getLimitFreeFlag(), item.getMemberAttr(), item.getPayStatus());
        if (this.this$0.mDialIds.contains(Integer.valueOf(item.getId()))) {
            ProgressButtonV2.XO(progressButtonV2, R.string.synced, true, 0, false, 0, null, 60, null);
        }
        View view = viewHolder.itemView;
        final WatchFaceDialPayDetailActivity watchFaceDialPayDetailActivity = this.this$0;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dialpay.oxoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WatchFaceDialPayDetailActivity$initView$2$mAdapter$1.convert$lambda$0(WatchFaceDialPayDetailActivity.this, item, view2);
            }
        });
    }
}
