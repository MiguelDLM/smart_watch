package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class NewerGuideDialog extends Dialog {
    private static final int HIGHT_VIEW_ID = 1;
    private RelativeLayout mContent;
    private Activity mContext;
    private ImageView mInfoImageView;

    public NewerGuideDialog(Activity activity) {
        super(activity, R.style.BNDialog);
        View inflate = JarUtils.inflate(activity, R.layout.nsdk_layout_newer_guide_dialog, null);
        setContentView(inflate);
        this.mContent = (RelativeLayout) inflate.findViewById(R.id.content);
        this.mInfoImageView = (ImageView) inflate.findViewById(R.id.infor_imageview);
        getWindow().setLayout(-1, -1);
        this.mContext = activity;
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.NewerGuideDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewerGuideDialog.this.dissmss();
            }
        });
    }

    public NewerGuideDialog addHighLightView(View view, int i, boolean z) {
        try {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(view.getLayoutParams());
            Rect rect2 = new Rect();
            this.mContext.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            LogUtil.e("NewER", "status bar height2=" + rect2.top);
            marginLayoutParams.setMargins(rect.left, rect.top - rect2.top, 0, 0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(marginLayoutParams);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            ImageView imageView = new ImageView(this.mContext);
            Bitmap createBitmap = Bitmap.createBitmap(rect.right - rect.left, rect.bottom - rect.top, Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(createBitmap));
            imageView.setImageBitmap(createBitmap);
            imageView.setId(1);
            RelativeLayout relativeLayout = this.mContent;
            if (relativeLayout != null) {
                relativeLayout.addView(imageView, layoutParams);
            }
            this.mInfoImageView.setBackgroundDrawable(JarUtils.getResources().getDrawable(i));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            if (z) {
                layoutParams2.addRule(3, 1);
            } else {
                layoutParams2.addRule(2, 1);
            }
            layoutParams2.addRule(5, 1);
            this.mInfoImageView.setLayoutParams(layoutParams2);
            RelativeLayout relativeLayout2 = this.mContent;
            if (relativeLayout2 != null) {
                relativeLayout2.requestLayout();
                this.mContent.invalidate();
            }
        } catch (Exception unused) {
        }
        return this;
    }

    public void dissmss() {
        dismiss();
    }
}
