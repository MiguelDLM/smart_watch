package com.sma.smartv3.ui.device;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import com.bestmafen.androidbase.list.BaseListActivity;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.QrcodeTypeInfo;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nQrcodeTypeInfosActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QrcodeTypeInfosActivity.kt\ncom/sma/smartv3/ui/device/QrcodeTypeInfosActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,47:1\n87#2,7:48\n94#2,3:56\n70#2,7:59\n97#2:66\n1#3:55\n*S KotlinDebug\n*F\n+ 1 QrcodeTypeInfosActivity.kt\ncom/sma/smartv3/ui/device/QrcodeTypeInfosActivity\n*L\n31#1:48,7\n31#1:56,3\n31#1:59,7\n31#1:66\n31#1:55\n*E\n"})
/* loaded from: classes12.dex */
public final class QrcodeTypeInfosActivity extends BaseListActivity<QrcodeTypeInfo> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(QrcodeTypeInfosActivity this$0, AdapterView adapterView, View view, int i, long j) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        QrcodeTypeInfo qrcodeTypeInfo = this$0.getMList().get(i);
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", qrcodeTypeInfo);
        Intent intent = new Intent(this$0, (Class<?>) QrcodeSyncActivity.class);
        intent.putExtras(bundle);
        this$0.startActivity(intent);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    @OXOo.OOXIXo
    public List<QrcodeTypeInfo> initList() {
        return ProductManager.f20544oIX0oI.XXXI(this, getMArg1());
    }

    @Override // com.bestmafen.androidbase.list.BaseListActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int i;
        super.initView();
        TextView textView = (TextView) findViewById(R.id.abh_title_center);
        if (getMArg1() == 1) {
            i = R.string.receipt_code;
        } else {
            i = R.string.my_card_code;
        }
        textView.setText(i);
        getMListView().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sma.smartv3.ui.device.IIOIX
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i2, long j) {
                QrcodeTypeInfosActivity.initView$lambda$0(QrcodeTypeInfosActivity.this, adapterView, view, i2, j);
            }
        });
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    public int itemLayoutId() {
        return R.layout.item_code_type;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_qrcode_type_infos;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    @Override // com.bestmafen.androidbase.list.I0Io
    public void initItem(@OXOo.OOXIXo XIOOI.I0Io holder, @OXOo.OOXIXo QrcodeTypeInfo item, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        ((ImageView) holder.X0o0xo(R.id.iv)).setImageResource(item.getIconResId());
        ((TextView) holder.X0o0xo(R.id.tv_left)).setText(item.getName());
    }
}
