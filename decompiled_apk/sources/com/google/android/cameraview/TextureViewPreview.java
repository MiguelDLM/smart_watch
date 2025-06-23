package com.google.android.cameraview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(14)
/* loaded from: classes9.dex */
class TextureViewPreview extends PreviewImpl {
    private int mDisplayOrientation;
    private final TextureView mTextureView;

    public TextureViewPreview(Context context, ViewGroup viewGroup) {
        TextureView textureView = (TextureView) View.inflate(context, R.layout.texture_view, viewGroup).findViewById(R.id.texture_view);
        this.mTextureView = textureView;
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.google.android.cameraview.TextureViewPreview.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TextureViewPreview.this.setSize(i, i2);
                TextureViewPreview.this.configureTransform();
                TextureViewPreview.this.dispatchSurfaceChanged();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                TextureViewPreview.this.setSize(0, 0);
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                TextureViewPreview.this.setSize(i, i2);
                TextureViewPreview.this.configureTransform();
                TextureViewPreview.this.dispatchSurfaceChanged();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    public void configureTransform() {
        Matrix matrix;
        float[] fArr;
        Matrix matrix2 = new Matrix();
        int i = this.mDisplayOrientation;
        if (i % 180 == 90) {
            float width = getWidth();
            float height = getHeight();
            float[] fArr2 = {0.0f, 0.0f, width, 0.0f, 0.0f, height, width, height};
            if (this.mDisplayOrientation == 90) {
                fArr = new float[]{0.0f, height, 0.0f, 0.0f, width, height, width, 0.0f};
            } else {
                fArr = new float[]{width, 0.0f, width, height, 0.0f, 0.0f, 0.0f, height};
            }
            matrix = matrix2;
            matrix2.setPolyToPoly(fArr2, 0, fArr, 0, 4);
        } else {
            matrix = matrix2;
            if (i == 180) {
                matrix.postRotate(180.0f, getWidth() / 2, getHeight() / 2);
            }
        }
        this.mTextureView.setTransform(matrix);
    }

    @Override // com.google.android.cameraview.PreviewImpl
    public Class getOutputClass() {
        return SurfaceTexture.class;
    }

    @Override // com.google.android.cameraview.PreviewImpl
    public Surface getSurface() {
        return new Surface(this.mTextureView.getSurfaceTexture());
    }

    @Override // com.google.android.cameraview.PreviewImpl
    public View getView() {
        return this.mTextureView;
    }

    @Override // com.google.android.cameraview.PreviewImpl
    public boolean isReady() {
        if (this.mTextureView.getSurfaceTexture() != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.cameraview.PreviewImpl
    @TargetApi(15)
    public void setBufferSize(int i, int i2) {
        this.mTextureView.getSurfaceTexture().setDefaultBufferSize(i, i2);
    }

    @Override // com.google.android.cameraview.PreviewImpl
    public void setDisplayOrientation(int i) {
        this.mDisplayOrientation = i;
        configureTransform();
    }

    @Override // com.google.android.cameraview.PreviewImpl
    public SurfaceTexture getSurfaceTexture() {
        return this.mTextureView.getSurfaceTexture();
    }
}
