package com.baidu.mapsdkplatform.comapi.map.a;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.baidu.mapapi.map.BM3DModelOptions;
import com.baidu.mapapi.map.track.TraceAnimationListener;
import com.baidu.mapapi.map.track.TraceOptions;
import com.baidu.mapapi.map.track.TraceOverlay;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.af;
import com.baidu.platform.comapi.map.ap;
import com.baidu.platform.comapi.map.aq;
import com.baidu.platform.comapi.util.i;
import com.baidu.platform.comapi.util.j;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.a.a f6170a;
    private com.baidu.mapsdkplatform.comapi.map.c b;
    private int c;
    private TraceAnimationListener d;
    private b f;
    private MapSurfaceView g;
    private MapTextureView h;
    private a e = new a();
    private volatile boolean i = false;

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes7.dex */
    public class a extends i {
        public a() {
            super(Looper.getMainLooper());
        }

        @Override // com.baidu.platform.comapi.util.i
        public void a(Message message) {
            int i = message.what;
            if (i == 65302) {
                int i2 = message.arg1;
                if (i2 > 0 && i2 <= 1000 && c.this.d != null) {
                    c.this.d.onTraceAnimationUpdate(message.arg1 / 10);
                }
                if (message.arg2 == 1 && c.this.d != null) {
                    c.this.d.onTraceAnimationFinish();
                    return;
                }
                return;
            }
            if (i == 65303 && c.this.d != null) {
                c.this.d.onTraceUpdatePosition(CoordUtil.mc2ll(new GeoPoint(message.arg2 / 100.0f, message.arg1 / 100.0f)));
            }
        }
    }

    public c(MapSurfaceView mapSurfaceView) {
        this.c = 1;
        if (mapSurfaceView == null) {
            return;
        }
        this.f6170a = new com.baidu.mapsdkplatform.comapi.map.a.a();
        this.g = mapSurfaceView;
        this.b = mapSurfaceView.getBaseMap();
        mapSurfaceView.addOverlay(this.f6170a);
        this.f6170a.SetOverlayShow(true);
        this.c = 1;
    }

    private List<GeoPoint> d(TraceOverlay traceOverlay) {
        if (traceOverlay == null || traceOverlay.getPoints() == null) {
            return null;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : traceOverlay.getPoints()) {
            arrayList.add(CoordUtil.ll2mc(latLng));
            builder.include(latLng);
        }
        return arrayList;
    }

    private int[] e(TraceOverlay traceOverlay) {
        if (traceOverlay != null && traceOverlay.getColors() != null) {
            return traceOverlay.getColors();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(TraceOverlay traceOverlay) {
        if (this.f6170a == null || traceOverlay == null) {
            return;
        }
        boolean isAnimate = traceOverlay.isAnimate();
        this.f6170a.a(isAnimate, traceOverlay.getAnimationTime(), traceOverlay.getAnimationDuration(), traceOverlay.getAnimationType());
        this.f6170a.a(traceOverlay.isRotateWhenTrack());
        af afVar = new af(new ap().a(-15794282).b(14));
        afVar.a(d(traceOverlay));
        if (traceOverlay.isUseColorArray()) {
            afVar.a(traceOverlay.isUseColorArray());
            int[] e = e(traceOverlay);
            for (int i = 0; i < e.length; i++) {
                int i2 = e[i];
                e[i] = ((i2 >> 16) & 255) | ((-16777216) & i2) | ((i2 & 255) << 16) | (65280 & i2);
            }
            afVar.a(e);
        }
        afVar.a(new aq().d(-1).a(traceOverlay.getColor()).b(traceOverlay.getWidth()));
        afVar.c = traceOverlay.isTrackMove();
        afVar.d = traceOverlay.isPointMove();
        afVar.e = !traceOverlay.isDataReduction();
        afVar.f = !traceOverlay.isDataSmooth();
        afVar.j = traceOverlay.isTrackBloom();
        afVar.k = traceOverlay.getBloomSpeed();
        afVar.a(isAnimate, traceOverlay.getAnimationTime(), traceOverlay.getAnimationType());
        if (traceOverlay.getIcon() != null) {
            afVar.h = false;
            this.f6170a.setParam(a(traceOverlay.getIcon().getBitmap()));
        }
        BM3DModelOptions icon3D = traceOverlay.getIcon3D();
        if (icon3D != null) {
            afVar.h = true;
            this.f6170a.setParam(a(icon3D));
        }
        this.f6170a.a(afVar);
    }

    public void a() {
        this.f = new d(this);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_PROGRESS, this.e);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_POSITION, this.e);
    }

    public void b() {
        com.baidu.mapsdkplatform.comapi.map.a.a aVar = this.f6170a;
        if (aVar == null) {
            return;
        }
        aVar.clear();
        this.f6170a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TraceOverlay traceOverlay) {
        if (traceOverlay == null || this.f6170a == null) {
            return;
        }
        if (traceOverlay.isStatusChanged()) {
            this.f6170a.b(traceOverlay.isOnPause());
            this.f6170a.c(true);
            j.b().execute(new f(this));
        } else {
            this.f6170a.clear();
            j.b().execute(new g(this, traceOverlay));
        }
    }

    public TraceOverlay a(TraceOptions traceOptions) {
        if (traceOptions == null) {
            return null;
        }
        TraceOverlay overlay = traceOptions.getOverlay();
        overlay.mListener = this.f;
        j.b().execute(new e(this, overlay));
        return overlay;
    }

    public boolean d() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TraceOverlay traceOverlay) {
        if (traceOverlay != null && this.f6170a != null) {
            c();
        }
        return false;
    }

    public c(MapTextureView mapTextureView) {
        this.c = 1;
        if (mapTextureView == null) {
            return;
        }
        this.f6170a = new com.baidu.mapsdkplatform.comapi.map.a.a();
        this.h = mapTextureView;
        this.b = mapTextureView.getBaseMap();
        mapTextureView.addOverlay(this.f6170a);
        this.f6170a.SetOverlayShow(true);
        this.c = 2;
    }

    public void a(TraceAnimationListener traceAnimationListener) {
        this.d = traceAnimationListener;
    }

    private Bundle a(Bitmap bitmap) {
        MessageDigest messageDigest = null;
        if (bitmap == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(RouteGuideParams.RGKey.ExpandMap.ImageWidth, bitmap.getWidth());
        bundle.putInt(RouteGuideParams.RGKey.ExpandMap.ImageHeight, bitmap.getHeight());
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
        bitmap.copyPixelsToBuffer(allocate);
        byte[] array = allocate.array();
        bundle.putByteArray("image_data", array);
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (messageDigest != null) {
            messageDigest.update(array, 0, array.length);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder("");
            for (byte b : digest) {
                sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            bundle.putString("image_hashcode", sb.toString());
        }
        return bundle;
    }

    private Bundle a(BM3DModelOptions bM3DModelOptions) {
        if (bM3DModelOptions == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("icon_3D", 1);
        bundle.putInt(TTDownloadField.TT_MODEL_TYPE, bM3DModelOptions.getBM3DModelType().ordinal());
        bundle.putString("modelPath", bM3DModelOptions.getModelPath());
        bundle.putString("modelName", bM3DModelOptions.getModelName());
        bundle.putFloat("scale", bM3DModelOptions.getScale());
        bundle.putBoolean("zoomFixed", bM3DModelOptions.isZoomFixed());
        bundle.putInt("yawAxis", bM3DModelOptions.getYawAxis());
        bundle.putFloat("rotateX", bM3DModelOptions.getRotateX());
        bundle.putFloat("rotateY", bM3DModelOptions.getRotateY());
        bundle.putFloat("rotateZ", bM3DModelOptions.getRotateZ());
        bundle.putFloat("offsetX", bM3DModelOptions.getOffsetX());
        bundle.putFloat("offsetY", bM3DModelOptions.getOffsetY());
        bundle.putFloat("offsetZ", bM3DModelOptions.getOffsetZ());
        if (bM3DModelOptions.isSkeletonAnimationEnable()) {
            bundle.putInt("animationIndex", bM3DModelOptions.getAnimationIndex());
            bundle.putBoolean("animationIsEnable", bM3DModelOptions.isSkeletonAnimationEnable());
            bundle.putInt("animationRepeatCount", bM3DModelOptions.getAnimationRepeatCount());
            bundle.putFloat("animationSpeed", bM3DModelOptions.getAnimationSpeed());
        }
        return bundle;
    }

    public void c() {
        MapTextureView mapTextureView;
        MapSurfaceView mapSurfaceView;
        MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_PROGRESS, this.e);
        MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.V_WM_TRACK_MOVE_POSITION, this.e);
        int i = this.c;
        if (i == 1 && (mapSurfaceView = this.g) != null) {
            mapSurfaceView.removeOverlay(this.f6170a);
        } else if (i == 2 && (mapTextureView = this.h) != null) {
            mapTextureView.removeOverlay(this.f6170a);
        }
        if (this.d != null) {
            this.d = null;
        }
        this.i = true;
    }
}
