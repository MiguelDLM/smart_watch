package com.sma.smartv3.ui.device.watchface;

import OXOo.OOXIXo;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.blankj.utilcode.util.FileUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.ImageViewRound;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class WatchFaceCustomActivity$initBgView$2 extends CommonAdapter<String> {
    final /* synthetic */ WatchFaceCustomActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFaceCustomActivity$initBgView$2(WatchFaceCustomActivity watchFaceCustomActivity, int i, List<String> list) {
        super(watchFaceCustomActivity, i, list);
        this.this$0 = watchFaceCustomActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(WatchFaceCustomActivity this$0, int i, View view) {
        List list;
        IIX0o.x0xO0oo(this$0, "this$0");
        list = this$0.mBgFiles;
        list.remove(i);
        this$0.showRvBg();
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(@OOXIXo ViewHolder holder, @OOXIXo String path, final int i) {
        IIX0o.x0xO0oo(holder, "holder");
        IIX0o.x0xO0oo(path, "path");
        ImageViewRound imageViewRound = (ImageViewRound) holder.getView(R.id.iv);
        if (FileUtils.isFileExists(path)) {
            imageViewRound.setImageURI(Uri.fromFile(new File(path)));
        }
        ImageView imageView = (ImageView) holder.getView(R.id.iv_status);
        final WatchFaceCustomActivity watchFaceCustomActivity = this.this$0;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.watchface.X0o0xo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WatchFaceCustomActivity$initBgView$2.convert$lambda$0(WatchFaceCustomActivity.this, i, view);
            }
        });
    }
}
