package com.sma.smartv3.ui.me;

import android.R;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public final class DeveloperOtaSelectBleNameActivity$initView$1 extends CommonAdapter<String> {
    final /* synthetic */ DeveloperOtaSelectBleNameActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeveloperOtaSelectBleNameActivity$initView$1(DeveloperOtaSelectBleNameActivity developerOtaSelectBleNameActivity, ArrayList<String> arrayList) {
        super(developerOtaSelectBleNameActivity, R.layout.simple_list_item_1, arrayList);
        this.this$0 = developerOtaSelectBleNameActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$1$lambda$0(DeveloperOtaSelectBleNameActivity this$0, String item, View view) {
        TextView tvSelect;
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "$item");
        if (this$0.getRecyclerView().getVisibility() == 0) {
            this$0.getRecyclerView().setVisibility(8);
            this$0.getSelect_group_ll().setVisibility(0);
        }
        tvSelect = this$0.getTvSelect();
        tvSelect.setText(item);
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.this$0.searchList.size();
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OXOo.OOXIXo ViewHolder viewHolder, @OXOo.OOXIXo final String item, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        final DeveloperOtaSelectBleNameActivity developerOtaSelectBleNameActivity = this.this$0;
        viewHolder.setText(R.id.text1, item);
        viewHolder.setOnClickListener(R.id.text1, new View.OnClickListener() { // from class: com.sma.smartv3.ui.me.xxIO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeveloperOtaSelectBleNameActivity$initView$1.convert$lambda$1$lambda$0(DeveloperOtaSelectBleNameActivity.this, item, view);
            }
        });
    }
}
