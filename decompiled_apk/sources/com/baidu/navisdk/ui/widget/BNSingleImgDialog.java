package com.baidu.navisdk.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.imageloader.ImageLoader;

/* loaded from: classes8.dex */
public class BNSingleImgDialog extends Dialog {
    private ImageView mClose;
    private DialogInterface.OnClickListener mCloseClickListener;
    private ImageView mImage;
    private DialogInterface.OnClickListener mImgClickListener;
    private View mRootView;

    /* loaded from: classes8.dex */
    public static class Builder {
        private DialogInterface.OnCancelListener mCancelListener;
        private boolean mCancelable;
        private DialogInterface.OnClickListener mCloseClickListener;
        private final Context mContext;
        private DialogInterface.OnDismissListener mDismissListener;
        private String mImageUrl;
        private DialogInterface.OnClickListener mImgClickListener;
        private Drawable mPlaceHolderDrawable;
        private int mPlaceHolderDrawableId;
        private DialogInterface.OnShowListener mShowListener;
        private final int mTheme;

        public Builder(Context context) {
            this.mCancelable = true;
            this.mContext = context;
            this.mTheme = R.style.BNSingleImgDialog;
        }

        public BNSingleImgDialog create() {
            BNSingleImgDialog bNSingleImgDialog = new BNSingleImgDialog(this.mContext, this.mTheme);
            Drawable drawable = this.mPlaceHolderDrawable;
            if (drawable != null) {
                bNSingleImgDialog.setImage(this.mImageUrl, drawable);
            } else {
                int i = this.mPlaceHolderDrawableId;
                if (i > 0) {
                    bNSingleImgDialog.setImage(this.mImageUrl, i);
                } else {
                    bNSingleImgDialog.setImage(this.mImageUrl, (Drawable) null);
                }
            }
            bNSingleImgDialog.setImgClickListener(this.mImgClickListener);
            bNSingleImgDialog.setCloseClickListener(this.mCloseClickListener);
            bNSingleImgDialog.setOnShowListener(this.mShowListener);
            bNSingleImgDialog.setOnDismissListener(this.mDismissListener);
            bNSingleImgDialog.setOnCancelListener(this.mCancelListener);
            bNSingleImgDialog.setCancelable(this.mCancelable);
            return bNSingleImgDialog;
        }

        public Builder setCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.mCancelListener = onCancelListener;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.mCancelable = z;
            return this;
        }

        public Builder setCloseClickListener(DialogInterface.OnClickListener onClickListener) {
            this.mCloseClickListener = onClickListener;
            return this;
        }

        public Builder setDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.mDismissListener = onDismissListener;
            return this;
        }

        public Builder setImage(String str) {
            this.mImageUrl = str;
            return this;
        }

        public Builder setImagePlaceHolder(int i) {
            this.mPlaceHolderDrawableId = i;
            return this;
        }

        public Builder setImgClickListener(DialogInterface.OnClickListener onClickListener) {
            this.mImgClickListener = onClickListener;
            return this;
        }

        public Builder setShowListener(DialogInterface.OnShowListener onShowListener) {
            this.mShowListener = onShowListener;
            return this;
        }

        public BNSingleImgDialog show() {
            BNSingleImgDialog create = create();
            create.show();
            return create;
        }

        public Builder setImagePlaceHolder(Drawable drawable) {
            this.mPlaceHolderDrawable = drawable;
            return this;
        }

        public Builder(Context context, int i) {
            this.mCancelable = true;
            this.mContext = context;
            this.mTheme = i;
        }
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.nsdk_layout_single_image_dialog, (ViewGroup) null);
        this.mRootView = inflate;
        if (inflate != null) {
            this.mImage = (ImageView) inflate.findViewById(R.id.dialog_img);
            this.mClose = (ImageView) this.mRootView.findViewById(R.id.dialog_close);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View view = this.mRootView;
        if (view != null) {
            setContentView(view, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        ImageView imageView = this.mImage;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.BNSingleImgDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BNSingleImgDialog.this.mImgClickListener != null) {
                        BNSingleImgDialog.this.mImgClickListener.onClick(BNSingleImgDialog.this, -1);
                    }
                    BNSingleImgDialog.this.dismiss();
                }
            });
        }
        ImageView imageView2 = this.mClose;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.BNSingleImgDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BNSingleImgDialog.this.mCloseClickListener != null) {
                        BNSingleImgDialog.this.mCloseClickListener.onClick(BNSingleImgDialog.this, -2);
                    }
                    BNSingleImgDialog.this.dismiss();
                }
            });
        }
    }

    public void setCloseClickListener(DialogInterface.OnClickListener onClickListener) {
        this.mCloseClickListener = onClickListener;
    }

    public void setImage(String str, int i) {
        ImageLoader.with(getContext()).load(str).placeHolder(i).error(i).into(this.mImage);
    }

    public void setImgClickListener(DialogInterface.OnClickListener onClickListener) {
        this.mImgClickListener = onClickListener;
    }

    private BNSingleImgDialog(@NonNull Context context, int i) {
        super(context, i);
        initView(context);
    }

    public void setImage(String str, Drawable drawable) {
        ImageLoader.with(getContext()).load(str).placeHolder(drawable).error(drawable).into(this.mImage);
    }
}
