package com.androidnetworking.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.androidnetworking.error.ANError;
import com.androidnetworking.internal.ANImageLoader;

/* loaded from: classes.dex */
public class ANImageView extends AppCompatImageView {
    private int mDefaultImageId;
    private int mErrorImageId;
    private ANImageLoader.ImageContainer mImageContainer;
    private String mUrl;

    /* renamed from: com.androidnetworking.widget.ANImageView$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements ANImageLoader.ImageListener {
        final /* synthetic */ boolean val$isInLayoutPass;

        public AnonymousClass1(boolean z) {
            this.val$isInLayoutPass = z;
        }

        @Override // com.androidnetworking.internal.ANImageLoader.ImageListener
        public void onError(ANError aNError) {
            if (ANImageView.this.mErrorImageId != 0) {
                ANImageView aNImageView = ANImageView.this;
                aNImageView.setImageResource(aNImageView.mErrorImageId);
            }
        }

        @Override // com.androidnetworking.internal.ANImageLoader.ImageListener
        public void onResponse(final ANImageLoader.ImageContainer imageContainer, boolean z) {
            if (z && this.val$isInLayoutPass) {
                ANImageView.this.post(new Runnable() { // from class: com.androidnetworking.widget.ANImageView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1.this.onResponse(imageContainer, false);
                    }
                });
                return;
            }
            if (imageContainer.getBitmap() != null) {
                ANImageView.this.setImageBitmap(imageContainer.getBitmap());
            } else if (ANImageView.this.mDefaultImageId != 0) {
                ANImageView aNImageView = ANImageView.this;
                aNImageView.setImageResource(aNImageView.mDefaultImageId);
            }
        }
    }

    public ANImageView(Context context) {
        this(context, null);
    }

    private void setDefaultImageOrNull() {
        int i = this.mDefaultImageId;
        if (i != 0) {
            setImageResource(i);
        } else {
            setImageBitmap(null);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void loadImageIfNecessary(boolean r9) {
        /*
            r8 = this;
            int r0 = r8.getWidth()
            int r1 = r8.getHeight()
            android.widget.ImageView$ScaleType r7 = r8.getScaleType()
            android.view.ViewGroup$LayoutParams r2 = r8.getLayoutParams()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L2a
            android.view.ViewGroup$LayoutParams r2 = r8.getLayoutParams()
            int r2 = r2.width
            r5 = -2
            if (r2 != r5) goto L1f
            r2 = 1
            goto L20
        L1f:
            r2 = 0
        L20:
            android.view.ViewGroup$LayoutParams r6 = r8.getLayoutParams()
            int r6 = r6.height
            if (r6 != r5) goto L2b
            r5 = 1
            goto L2c
        L2a:
            r2 = 0
        L2b:
            r5 = 0
        L2c:
            if (r2 == 0) goto L31
            if (r5 == 0) goto L31
            goto L32
        L31:
            r3 = 0
        L32:
            if (r0 != 0) goto L39
            if (r1 != 0) goto L39
            if (r3 != 0) goto L39
            return
        L39:
            java.lang.String r3 = r8.mUrl
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L4f
            com.androidnetworking.internal.ANImageLoader$ImageContainer r9 = r8.mImageContainer
            if (r9 == 0) goto L4b
            r9.cancelRequest()
            r9 = 0
            r8.mImageContainer = r9
        L4b:
            r8.setDefaultImageOrNull()
            return
        L4f:
            com.androidnetworking.internal.ANImageLoader$ImageContainer r3 = r8.mImageContainer
            if (r3 == 0) goto L70
            java.lang.String r3 = r3.getRequestUrl()
            if (r3 == 0) goto L70
            com.androidnetworking.internal.ANImageLoader$ImageContainer r3 = r8.mImageContainer
            java.lang.String r3 = r3.getRequestUrl()
            java.lang.String r6 = r8.mUrl
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L68
            return
        L68:
            com.androidnetworking.internal.ANImageLoader$ImageContainer r3 = r8.mImageContainer
            r3.cancelRequest()
            r8.setDefaultImageOrNull()
        L70:
            if (r2 == 0) goto L73
            r0 = 0
        L73:
            if (r5 == 0) goto L77
            r6 = 0
            goto L78
        L77:
            r6 = r1
        L78:
            com.androidnetworking.internal.ANImageLoader r2 = com.androidnetworking.internal.ANImageLoader.getInstance()
            java.lang.String r3 = r8.mUrl
            com.androidnetworking.widget.ANImageView$1 r4 = new com.androidnetworking.widget.ANImageView$1
            r4.<init>(r9)
            r5 = r0
            com.androidnetworking.internal.ANImageLoader$ImageContainer r9 = r2.get(r3, r4, r5, r6, r7)
            r8.mImageContainer = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.androidnetworking.widget.ANImageView.loadImageIfNecessary(boolean):void");
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        ANImageLoader.ImageContainer imageContainer = this.mImageContainer;
        if (imageContainer != null) {
            imageContainer.cancelRequest();
            setImageBitmap(null);
            this.mImageContainer = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        loadImageIfNecessary(true);
    }

    public void setDefaultImageResId(int i) {
        this.mDefaultImageId = i;
    }

    public void setErrorImageResId(int i) {
        this.mErrorImageId = i;
    }

    public void setImageUrl(String str) {
        this.mUrl = str;
        loadImageIfNecessary(false);
    }

    public ANImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ANImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
