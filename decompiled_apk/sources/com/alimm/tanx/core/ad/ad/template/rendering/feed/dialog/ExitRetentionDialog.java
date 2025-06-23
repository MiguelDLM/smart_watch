package com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.image.ImageManager;
import com.alimm.tanx.core.image.util.ImageConfig;
import com.alimm.tanx.core.image.util.ScaleMode;
import com.alimm.tanx.core.image.util.ShapeMode;
import com.alimm.tanx.core.image.util.TanxDrawable;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: classes.dex */
public class ExitRetentionDialog extends tanxc_do implements View.OnClickListener, NotConfused {
    private static String TAG = "ExitRetentionDialog";
    private String backImgUrl;
    private Button btnContinue;
    private ClickCallBack clickCallBack;
    private ImageView ivBack;
    private ImageView ivClose;
    private TextView tvExit;

    /* loaded from: classes.dex */
    public interface ClickCallBack {
        void continueClick();

        void exitClick();
    }

    public ExitRetentionDialog(@NonNull Context context, int i) {
        super(context, i);
        this.backImgUrl = "https://gw.alicdn.com/imgextra/i3/O1CN01yRRocx28JI2PSwyrX_!!6000000007911-0-tps-1080-1320.jpg_q90.jpg";
        setContentView(R.layout.dialog_exit_retention);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        initView();
        initClick();
    }

    private void initClick() {
        this.ivClose.setOnClickListener(this);
        this.tvExit.setOnClickListener(this);
        this.btnContinue.setOnClickListener(this);
    }

    private void initView() {
        float f;
        this.ivClose = (ImageView) findViewById(R.id.iv_close);
        this.tvExit = (TextView) findViewById(R.id.tv_exit);
        this.ivBack = (ImageView) findViewById(R.id.iv_back);
        this.btnContinue = (Button) findViewById(R.id.btn_continue);
        try {
            f = this.ivBack.getResources().getDimension(R.dimen.error_pop_radius);
        } catch (Exception e) {
            LogUtils.e(TAG, e);
            f = 30.0f;
        }
        final ImageConfig build = ImageManager.with(this.ivBack.getContext()).url(this.backImgUrl).shapeMode(ShapeMode.RECT_ROUND).scaleMode(ScaleMode.FIT_CENTER).radius((int) f).build();
        ImageManager.getLoader().load(build, new ImageConfig.ImageBitmapCallback() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.ExitRetentionDialog.1
            @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
            public void onFailure(String str) {
            }

            @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
            public void onSuccess(Bitmap bitmap) {
                ExitRetentionDialog.this.ivBack.setImageBitmap(bitmap);
                ExitRetentionDialog.this.ivBack.setImageDrawable(new TanxDrawable(bitmap, build.getImageConfig()));
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ClickCallBack clickCallBack;
        ClickCallBack clickCallBack2;
        int id = view.getId();
        if (id == R.id.tv_exit && (clickCallBack2 = this.clickCallBack) != null) {
            clickCallBack2.exitClick();
        }
        if (id == R.id.btn_continue && (clickCallBack = this.clickCallBack) != null) {
            clickCallBack.continueClick();
        }
        dismiss();
    }

    public void setClickCallBack(ClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }
}
