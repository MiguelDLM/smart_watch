package com.sma.smartv3.ui.device;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import com.angcyo.dsladapter.LibExKt;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bestmafen.androidbase.recycler.BaseRecyclerActivity;
import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.sma.smartv3.co_fit.R;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nAlbumActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AlbumActivity.kt\ncom/sma/smartv3/ui/device/AlbumActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,58:1\n87#2,7:59\n94#2,3:67\n70#2,7:70\n97#2:77\n1#3:66\n*S KotlinDebug\n*F\n+ 1 AlbumActivity.kt\ncom/sma/smartv3/ui/device/AlbumActivity\n*L\n40#1:59,7\n40#1:67,3\n40#1:70,7\n40#1:77\n40#1:66\n*E\n"})
/* loaded from: classes12.dex */
public final class AlbumActivity extends BaseRecyclerActivity<Uri> {
    private final int mItemWidth = ScreenUtils.getAppScreenWidth() / 3;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initItem$lambda$1$lambda$0(AlbumActivity this$0, int i, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", i);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this$0, (Class<?>) GalleryActivity.class);
        intent.putExtras(bundle);
        this$0.startActivity(intent);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    @OXOo.OOXIXo
    public List<Uri> initList() {
        return o00.oIX0oI();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.album);
        getMRecyclerView().setLayoutManager(new GridLayoutManager(getMContext(), 3));
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    public int itemLayoutId() {
        return R.layout.item_photo;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_album;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    @Override // com.bestmafen.androidbase.recycler.I0Io
    public void initItem(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo Uri item, final int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        ImageView imageView = (ImageView) holder.getView(R.id.iv);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(imageView);
        int i2 = this.mItemWidth;
        LibExKt.IIX0(imageView, i2, i2);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.Oxx0IOOO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlbumActivity.initItem$lambda$1$lambda$0(AlbumActivity.this, i, view);
            }
        });
        Glide.with((FragmentActivity) this).load(item).override(100, 100).into(imageView);
    }
}
