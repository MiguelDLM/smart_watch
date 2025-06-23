package com.baidu.ar;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.baidu.ar.arrender.FrameRenderListener;
import com.baidu.ar.arrender.IGLRenderer;
import com.baidu.ar.arrender.Texture;
import com.baidu.ar.marker.IMarker;
import com.baidu.ar.marker.MarkerFrameInfo;
import com.baidu.ar.mc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class a implements SurfaceTexture.OnFrameAvailableListener, FrameRenderListener, mc.a {

    /* renamed from: a, reason: collision with root package name */
    private HandlerThread f5560a;
    private IGLRenderer b;
    private IMarker c;
    private GLSurfaceView d;
    private OnFrmeTrackingStateCallback e;
    private mc f;
    private Context mContext;
    private Handler mHandler;

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        GLSurfaceView gLSurfaceView = this.d;
        if (gLSurfaceView != null) {
            gLSurfaceView.requestRender();
        }
    }

    @Override // com.baidu.ar.arrender.FrameRenderListener
    public void onRenderFinished(long j) {
        Log.d("AREngineManager", "onRenderFinished timestamp = " + j);
    }

    @Override // com.baidu.ar.arrender.FrameRenderListener
    public void onRenderStarted(long j) {
        Log.d("AREngineManager", "onRenderStarted timestamp = " + j);
        mc mcVar = this.f;
        if (mcVar != null) {
            mcVar.ik();
        }
    }

    public void pause() {
        Log.d("AREngineManager", "pause()!!!");
        mc mcVar = this.f;
        if (mcVar != null) {
            mcVar.pause();
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void release() {
        Log.d("AREngineManager", "release()!!!");
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        HandlerThread handlerThread = this.f5560a;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f5560a = null;
        }
        mc mcVar = this.f;
        if (mcVar != null) {
            mcVar.release();
        }
        this.b = null;
        this.d = null;
    }

    public void resume() {
        Log.d("AREngineManager", "resume()!!!");
        mc mcVar = this.f;
        if (mcVar != null) {
            mcVar.ij();
        }
        if (this.mHandler != null) {
            Message message = new Message();
            message.what = 1001;
            this.mHandler.sendMessage(message);
        }
    }

    public void setTrackingStateCallback(OnFrmeTrackingStateCallback onFrmeTrackingStateCallback) {
        this.e = onFrmeTrackingStateCallback;
    }

    @Override // com.baidu.ar.mc.a
    public void a(int i, float[] fArr, float f, float[] fArr2, float[] fArr3) {
        if (this.c == null) {
            return;
        }
        MarkerFrameInfo markerFrameInfo = new MarkerFrameInfo();
        markerFrameInfo.setFps(30);
        markerFrameInfo.setPoseMat(fArr2);
        markerFrameInfo.setOrignalTransform(fArr3);
        markerFrameInfo.setTrackingState(i);
        markerFrameInfo.setIntrinsics(fArr);
        markerFrameInfo.setScaleY(f);
        markerFrameInfo.setDistort(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        markerFrameInfo.setMagnet(new double[]{-1.0d, -1.0d, -1.0d});
        this.c.setAvailableFrame(markerFrameInfo);
        OnFrmeTrackingStateCallback onFrmeTrackingStateCallback = this.e;
        if (onFrmeTrackingStateCallback != null) {
            onFrmeTrackingStateCallback.onTrackingState(i);
        }
    }

    public void a(Context context, int i, int i2, NavigationType navigationType, boolean z) {
        mc mdVar;
        this.mContext = context;
        kf.c("AREngineManager", "setup width * height = " + i + " * " + i2);
        if (navigationType == NavigationType.AREngine) {
            mdVar = new me((Activity) context);
        } else if (navigationType != NavigationType.ARCore) {
            return;
        } else {
            mdVar = new md((Activity) context);
        }
        this.f = mdVar;
        this.f.a(this);
        this.f.ah(z);
        HandlerThread handlerThread = new HandlerThread("AREngineManager");
        this.f5560a = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.f5560a.getLooper()) { // from class: com.baidu.ar.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 1001) {
                    return;
                }
                if (a.this.mHandler != null) {
                    a.this.mHandler.removeMessages(1001);
                    Message message2 = new Message();
                    message2.what = 1001;
                    a.this.mHandler.sendMessageDelayed(message2, 33L);
                }
                if (a.this.b != null) {
                    a.this.b.render();
                }
                if (a.this.d != null) {
                    a.this.d.requestRender();
                }
            }
        };
    }

    public void a(GLSurfaceView gLSurfaceView) {
        this.d = gLSurfaceView;
    }

    public void a(IGLRenderer iGLRenderer) {
        this.b = iGLRenderer;
    }

    public void a(Texture texture) {
        Log.d("AREngineManager", "setCameraTexture() texture.getId() = " + texture.getId());
        mc mcVar = this.f;
        if (mcVar != null) {
            mcVar.b(texture);
        }
    }

    public void a(IMarker iMarker) {
        this.c = iMarker;
    }
}
