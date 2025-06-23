package com.sma.smartv3.ui.device.dialpay.item;

import OXOo.OOXIXo;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.blankj.utilcode.util.SPUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.OnlineWatchFaceV2;
import com.sma.smartv3.model.WatchFaceCategoryV2;
import com.sma.smartv3.ui.device.dialpay.DialMoveActivity;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nDialClassItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DialClassItem.kt\ncom/sma/smartv3/ui/device/dialpay/item/DialClassItem$bindView$mAdapter$1\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,66:1\n37#2,2:67\n86#3,2:69\n*S KotlinDebug\n*F\n+ 1 DialClassItem.kt\ncom/sma/smartv3/ui/device/dialpay/item/DialClassItem$bindView$mAdapter$1\n*L\n49#1:67,2\n49#1:69,2\n*E\n"})
/* loaded from: classes12.dex */
public final class DialClassItem$bindView$mAdapter$1 extends CommonAdapter<OnlineWatchFaceV2> {
    public DialClassItem$bindView$mAdapter$1(Context context, List<OnlineWatchFaceV2> list) {
        super(context, R.layout.item_horizontal_dial_class, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(OnlineWatchFaceV2 item, DialClassItem$bindView$mAdapter$1 this$0, View view) {
        IIX0o.x0xO0oo(item, "$item");
        IIX0o.x0xO0oo(this$0, "this$0");
        SPUtils I0Io2 = Xo0.f24349oIX0oI.I0Io();
        WatchFaceCategoryV2[] watchFaceList = item.getWatchFaceList();
        IIX0o.ooOOo0oXI(watchFaceList);
        I0Io2.put(XoI0Ixx0.f24485xXOx + '_' + WatchFaceCategoryV2[].class.getName(), new Gson().toJson(ArraysKt___ArraysKt.XOXXox0(watchFaceList).toArray(new WatchFaceCategoryV2[0])));
        Intent intent = new Intent(((CommonAdapter) this$0).mContext, (Class<?>) DialMoveActivity.class);
        intent.putExtra("mArg0", item.getTypeName());
        intent.putExtra("mArg1", Integer.parseInt(item.getTypeId()));
        ((CommonAdapter) this$0).mContext.startActivity(intent);
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OOXIXo ViewHolder viewHolder, @OOXIXo final OnlineWatchFaceV2 item, int i) {
        IIX0o.x0xO0oo(viewHolder, "viewHolder");
        IIX0o.x0xO0oo(item, "item");
        viewHolder.setText(R.id.item_dial_class_tv, item.getTypeName());
        Glide.with(((CommonAdapter) this).mContext).load(item.getTypeCssClass()).into((ImageView) viewHolder.getView(R.id.item_dial_class_iv));
        viewHolder.setOnClickListener(R.id.item_dial_class_ll, new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dialpay.item.II0xO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialClassItem$bindView$mAdapter$1.convert$lambda$0(OnlineWatchFaceV2.this, this, view);
            }
        });
    }
}
