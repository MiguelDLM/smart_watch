package com.sma.smartv3.ui.device.dialpay.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bumptech.glide.Glide;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.WatchFaceCategoryV2;
import com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nPayDialRecordingFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PayDialRecordingFragment.kt\ncom/sma/smartv3/ui/device/dialpay/fragment/PayDialRecordingFragment$recordingPurchaseHistory$1$mAdapter$1\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,210:1\n99#2,7:211\n106#2,3:219\n79#2,7:222\n109#2:229\n99#2,7:230\n106#2,3:238\n79#2,7:241\n109#2:248\n1#3:218\n1#3:237\n*S KotlinDebug\n*F\n+ 1 PayDialRecordingFragment.kt\ncom/sma/smartv3/ui/device/dialpay/fragment/PayDialRecordingFragment$recordingPurchaseHistory$1$mAdapter$1\n*L\n109#1:211,7\n109#1:219,3\n109#1:222,7\n109#1:229\n112#1:230,7\n112#1:238,3\n112#1:241,7\n112#1:248\n109#1:218\n112#1:237\n*E\n"})
/* loaded from: classes12.dex */
public final class PayDialRecordingFragment$recordingPurchaseHistory$1$mAdapter$1 extends CommonAdapter<WatchFaceCategoryV2> {
    final /* synthetic */ PayDialRecordingFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayDialRecordingFragment$recordingPurchaseHistory$1$mAdapter$1(PayDialRecordingFragment payDialRecordingFragment, Context context, List<WatchFaceCategoryV2> list) {
        super(context, R.layout.item_dial_f3_v3, list);
        this.this$0 = payDialRecordingFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$2$lambda$0(PayDialRecordingFragment this$0, WatchFaceCategoryV2 item, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(item, "$item");
        String previewUrl = item.getPreviewUrl();
        int id = item.getId();
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", previewUrl);
        bundle.putInt("mArg1", id);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", item);
        Intent intent = new Intent(this$0.getActivity(), (Class<?>) WatchFaceDialPayDetailActivity.class);
        intent.putExtras(bundle);
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$2$lambda$1(PayDialRecordingFragment this$0, WatchFaceCategoryV2 item, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(item, "$item");
        String previewUrl = item.getPreviewUrl();
        int id = item.getId();
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", previewUrl);
        bundle.putInt("mArg1", id);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", item);
        Intent intent = new Intent(this$0.getActivity(), (Class<?>) WatchFaceDialPayDetailActivity.class);
        intent.putExtras(bundle);
        this$0.startActivity(intent);
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OXOo.OOXIXo ViewHolder viewHolder, @OXOo.OOXIXo final WatchFaceCategoryV2 item, int i) {
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        IIX0o.x0xO0oo(item, "item");
        Context context = this.this$0.getContext();
        if (context != null) {
            final PayDialRecordingFragment payDialRecordingFragment = this.this$0;
            Glide.with(context).load(item.getPreviewUrl()).into((ImageView) viewHolder.getView(R.id.iv));
            ((TextView) viewHolder.getView(R.id.pb)).setText(com.sma.smartv3.ui.device.dialpay.oIX0oI.I0Io(item.getAmount(), null, 2, null));
            viewHolder.setOnClickListener(R.id.iv, new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.OOXIXo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PayDialRecordingFragment$recordingPurchaseHistory$1$mAdapter$1.convert$lambda$2$lambda$0(PayDialRecordingFragment.this, item, view);
                }
            });
            viewHolder.setOnClickListener(R.id.pb, new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.oOoXoXO
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PayDialRecordingFragment$recordingPurchaseHistory$1$mAdapter$1.convert$lambda$2$lambda$1(PayDialRecordingFragment.this, item, view);
                }
            });
        }
    }
}
