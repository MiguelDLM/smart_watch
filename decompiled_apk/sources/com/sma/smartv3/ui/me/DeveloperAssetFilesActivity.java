package com.sma.smartv3.ui.me;

import android.R;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import com.bestmafen.androidbase.list.BaseListActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;

/* loaded from: classes11.dex */
public final class DeveloperAssetFilesActivity extends BaseListActivity<String> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void initItem$lambda$1$lambda$0(DeveloperAssetFilesActivity this$0, String item, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "$item");
        this$0.setResult(-1, new Intent().putExtra("text", item));
        this$0.finish();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    @OXOo.OOXIXo
    public List<String> initList() {
        List<String> X0XOOO;
        AssetManager assets = getAssets();
        String mArg0 = getMArg0();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(mArg0);
        String[] list = assets.list(mArg0);
        if (list == null || (X0XOOO = ArraysKt___ArraysKt.X0XOOO(list)) == null) {
            return new ArrayList();
        }
        return X0XOOO;
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    public int itemLayoutId() {
        return R.layout.simple_list_item_1;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return com.sma.smartv3.co_fit.R.layout.activity_developer_asset_files;
    }

    @Override // com.bestmafen.androidbase.list.I0Io
    public void initItem(@OXOo.OOXIXo XIOOI.I0Io holder, @OXOo.OOXIXo final String item, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        holder.o00(R.id.text1, item);
        holder.oO(R.id.text1, new View.OnClickListener() { // from class: com.sma.smartv3.ui.me.IIX0o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeveloperAssetFilesActivity.initItem$lambda$1$lambda$0(DeveloperAssetFilesActivity.this, item, view);
            }
        });
    }
}
