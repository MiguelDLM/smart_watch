package com.baidu.ar.arplay.core.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.EGLContext;
import android.view.Surface;
import com.baidu.ar.ao;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public interface IARPRenderer {
    String addOutputSurface(Surface surface, int i, int i2);

    String addOutputSurface(Surface surface, int i, int i2, PixelRotation pixelRotation);

    String addOutputSurface(Surface surface, int i, int i2, PixelRotation pixelRotation, OutputFillMode outputFillMode);

    String addOutputTarget(int i, int i2, int i3, int i4);

    String addOutputTarget(int i, int i2, int i3, int i4, PixelRotation pixelRotation);

    String addOutputTarget(int i, int i2, int i3, int i4, PixelRotation pixelRotation, OutputFillMode outputFillMode);

    void bindTargetSurface(Surface surface);

    void cancelAysncRenderTask(Runnable runnable);

    void clearAllAsyncRenderTask();

    void clearCaptureData();

    void connectCameraWithTarget();

    void createInputSource(PixelRotation pixelRotation, ao aoVar);

    void createInputSourceNoCache(PixelRotation pixelRotation, ao aoVar);

    void createNoInputSource();

    void createPixelReaderByPreFilterID(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener);

    void createSyncInputSource(PixelRotation pixelRotation, ao aoVar);

    long createTexture(int i, int i2, int i3);

    void destroyAllPixelReader();

    void destroyPixelReaderByPreFilterID(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener);

    void destroyTexture(long j);

    void getSnapShot(TakePictureCallback takePictureCallback, int i, int i2, int i3);

    void getSnapShot(TakePictureCallback takePictureCallback, int i, int i2, int i3, Rect rect);

    int getTextureId(long j);

    boolean isFrontCamera();

    void onFrameRenderFinished(long j);

    void onFrameRenderStarted(long j);

    void onSnapShotFinished(Bitmap bitmap, long j);

    boolean pixelReadCallback(ByteBuffer byteBuffer, long j, int i, int i2, int i3, int i4, int i5, String str, int i6, int i7);

    void purgeMemory();

    void removeAllOutputTarget();

    void removeOutputTargetByAddr(String str);

    void render(long j);

    void runAsyncOnRenderContext(Runnable runnable);

    void runLuaScriptStr(String str);

    void runSyncOnIOContext(Runnable runnable);

    void runSyncOnRenderContext(Runnable runnable);

    void setAlgoPts(long j);

    void setCameraFace(boolean z);

    void setCaptureData(int i);

    void setContext(SoftReference<Context> softReference);

    void setInputMatrix(float[] fArr);

    void setInputTexture(int i, int i2, int i3, int i4);

    void setIsDumpAlgoPixel(boolean z);

    void setIsRender(boolean z);

    void setOnNeedCacheFrameListener(OnNeedCacheFrameListener onNeedCacheFrameListener);

    void setOnRenderFinishedListener(OnRenderFinishedListener onRenderFinishedListener);

    void setOnRenderStartedListener(OnRenderStartedListener onRenderStartedListener);

    void setPixelReaderRotation(PixelReadParams pixelReadParams, PixelRotation pixelRotation);

    void setPixelReaderRotation(PixelRotation pixelRotation);

    void setSourceSyncProperty(boolean z);

    boolean setUpEGLEnv(EGLContext eGLContext);

    void swapBuffer();

    void updateOutputSurfaceRotation(String str, PixelRotation pixelRotation);

    void uploadPixelToTextureFromPath(long j, String str);
}
