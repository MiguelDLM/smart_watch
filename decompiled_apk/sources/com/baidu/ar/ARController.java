package com.baidu.ar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.arrender.FrameRenderListener;
import com.baidu.ar.arrender.IARRenderer;
import com.baidu.ar.baidumap.CaseDownloadListener;
import com.baidu.ar.baidumap.CaseStateListener;
import com.baidu.ar.baidumap.MapDuMix;
import com.baidu.ar.baidumap.MapDuMixCallback;
import com.baidu.ar.baidumap.MapDuMixParams;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.base.RequestController;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.bean.BrowserBean;
import com.baidu.ar.bean.DuMixRes;
import com.baidu.ar.bean.Watermark;
import com.baidu.ar.content.IARCaseInfo;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.obr.OBRConfig;
import com.baidu.ar.record.RecordCallback;
import com.baidu.ar.recorder.MovieRecorderCallback;
import com.baidu.ar.resloader.ArCaseDownloadListener;
import com.baidu.ar.vps.IARInnerLocationTransService;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class ARController implements MapDuMix.a {
    private DuMixSource h;
    private DuMixTarget i;
    private ARCallback j;
    private gm k;
    private MapDuMix l;
    private AudioManager m;
    private Context mContext;
    private boolean n = false;
    private RequestController o;
    private MapDuMixParams p;

    public ARController(Context context) {
        this.mContext = context;
        MapDuMixParams mapDuMixParams = new MapDuMixParams();
        this.p = mapDuMixParams;
        this.l = MapDuMix.getInstance(context, mapDuMixParams);
    }

    public static boolean isContainMusic(String str) {
        DuMixRes aX;
        if (TextUtils.isEmpty(str) || !ProjectParams.isHuaweiProject() || (aX = gp.aX(b(str))) == null) {
            return false;
        }
        return aX.isContainMusic();
    }

    public static boolean isSupportFrontCamera(String str) {
        DuMixRes aX;
        if (TextUtils.isEmpty(str) || (aX = gp.aX(b(str))) == null) {
            return false;
        }
        return aX.isSupportFrontCamera();
    }

    public void addFrameRenderListener(FrameRenderListener frameRenderListener) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.addFrameRenderListener(frameRenderListener);
        }
    }

    public void cancelDownloadCase(String str) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.cancelCaseDownload(str);
        }
    }

    public void changeCase(DuMixSource duMixSource) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.loadCase(duMixSource.getResFilePath(), duMixSource.getArKey());
        }
    }

    public void changeCloudArState(int i) {
    }

    public void checkCaseUpdate(String str, final ArCaseDownloadListener arCaseDownloadListener) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.checkCaseUpdate(str, new cv() { // from class: com.baidu.ar.ARController.7
                @Override // com.baidu.ar.cv
                public void a(String str2, boolean z, float f) {
                    ArCaseDownloadListener arCaseDownloadListener2 = arCaseDownloadListener;
                    if (arCaseDownloadListener2 != null) {
                        arCaseDownloadListener2.onCaseUpdate(z, f);
                    }
                }
            });
        }
    }

    public void closeVolume() {
        boolean isStreamMute;
        Context context;
        if (this.m == null && (context = this.mContext) != null) {
            this.m = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        }
        AudioManager audioManager = this.m;
        if (audioManager != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                isStreamMute = audioManager.isStreamMute(3);
                this.n = isStreamMute;
            }
            if (this.n) {
                return;
            }
            this.m.adjustStreamVolume(3, -100, 0);
        }
    }

    public void createSession(String str, boolean z) {
        Log.i("ARController", "createSession");
    }

    public void deleteResourceByArKey(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("ar key is null!");
        }
        String f = ke.f(this.mContext, str);
        if (!z) {
            km.a(new File(f), false);
            return;
        }
        ArrayList<File> i = km.i(new File(f));
        String a2 = a(str);
        for (File file : i) {
            if (!file.getAbsolutePath().equals(a2)) {
                km.f(file);
            }
        }
    }

    public void downloadCase(String str, final ArCaseDownloadListener arCaseDownloadListener) {
        if (this.l == null) {
            this.l = MapDuMix.getInstance(this.mContext, this.p);
        }
        this.l.downloadCase(str, new CaseDownloadListener() { // from class: com.baidu.ar.ARController.6
            @Override // com.baidu.ar.baidumap.CaseDownloadListener
            public void onDownloadFinish(boolean z, String str2, String str3, int i, String str4) {
                ArCaseDownloadListener arCaseDownloadListener2 = arCaseDownloadListener;
                if (arCaseDownloadListener2 != null) {
                    arCaseDownloadListener2.onFinish(str2, z, str4);
                }
                ARController.this.outputStateMessage(9004, "");
                if (z) {
                    return;
                }
                ARController.this.outputStateMessage(30001, "");
            }

            @Override // com.baidu.ar.baidumap.CaseDownloadListener
            public void onDownloadProgress(int i, String str2) {
                ArCaseDownloadListener arCaseDownloadListener2 = arCaseDownloadListener;
                if (arCaseDownloadListener2 != null) {
                    arCaseDownloadListener2.onProgress(str2, i);
                }
            }

            @Override // com.baidu.ar.baidumap.CaseDownloadListener
            public void onRefused() {
                ARController.this.outputStateMessage(30001, "");
            }
        });
    }

    public IARRenderer getARRenderer() {
        return this.l.getARRenderer();
    }

    public DuMixTarget getDuMixTarget() {
        return this.i;
    }

    public MapDuMix getMapDuMix() {
        return this.l;
    }

    public RequestController getRequestController() {
        return this.o;
    }

    public String getResourcePathByArKey(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("ar key is null!");
        }
        return ke.h(this.mContext, str).substring(0, r3.length() - 3);
    }

    public void loadLocalCase(String str, int i) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.loadCase(str, "");
        }
    }

    public void onAppear() {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.resumeScene();
        }
    }

    public void onCameraPreviewFrame(byte[] bArr, int i, int i2) {
        DuMixSource duMixSource;
        kf.c("ARController", "onCameraPreviewFrame width * height = " + i + " * " + i2);
        if (this.l == null || (duMixSource = this.h) == null || duMixSource.getBusinessType() != BusinessType.NPC) {
            return;
        }
        this.l.render(System.currentTimeMillis());
    }

    @Override // com.baidu.ar.baidumap.MapDuMix.a
    public void onCaseQueryResult(IARCaseInfo iARCaseInfo) {
        if (this.j != null) {
            ARResource aRResource = new ARResource();
            aRResource.setRefused(iARCaseInfo.isRefused());
            aRResource.setCodeDownloadUrl(iARCaseInfo.getResourceUrl());
            aRResource.setType(iARCaseInfo.getARType());
            aRResource.setFunctionMap(iARCaseInfo.getFeatures());
            this.j.onCaseCreated(aRResource);
        }
    }

    public void onClickCameraButton() {
        kf.c("ARController", "onClickCameraButton");
    }

    public void onCover() {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.pauseScene();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            return mapDuMix.onTouch(null, motionEvent);
        }
        return false;
    }

    public void openVolume() {
        Context context;
        if (this.m == null && (context = this.mContext) != null) {
            this.m = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        }
        AudioManager audioManager = this.m;
        if (audioManager != null) {
            audioManager.adjustStreamVolume(3, 100, 0);
        }
    }

    public void orientationChange(int i) {
        kf.u("ARController", "orientationChange orientation = " + i);
    }

    public void outputStateMessage(int i, Object obj) {
        ARCallback aRCallback = this.j;
        if (aRCallback != null) {
            aRCallback.onStateChange(i, obj);
        }
    }

    public void pause() {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.pause();
        }
    }

    public void reSetup(SurfaceTexture surfaceTexture, int i, int i2) {
        kf.c("ARController", "reSetup width * height = " + i + " * " + i2);
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.changeOutputObject(surfaceTexture, i, i2);
        }
    }

    public void release() {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.release();
            this.l = null;
        }
        gm gmVar = this.k;
        if (gmVar != null) {
            gmVar.release();
            this.k = null;
        }
        this.m = null;
    }

    public void resume() {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.resume();
        }
    }

    public void sendMessage2Lua(String str) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.sendLuaScript2Engine(str);
        }
    }

    public void setDownloadComplete() {
        this.l.setDownloadComplete();
    }

    public void setEulerAngle(float f, float f2, float f3) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.setEulerAngle(f, f2, f3);
        }
    }

    public void setFieldOfView(float f) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.setFieldOfView(f);
        }
    }

    public void setLocationTransService(IARInnerLocationTransService iARInnerLocationTransService) {
    }

    public void setRecgArRetry() {
    }

    public void setRecordMark(Bitmap bitmap, Point point) {
        setRecordMark(bitmap, point, 1.0f);
    }

    public void setRotation(float f, float f2, float f3) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.setRotation(f, f2, f3);
        }
    }

    public void setup(DuMixSource duMixSource, DuMixTarget duMixTarget, ARCallback aRCallback) {
        kf.c("ARController", "setup start!!!");
        this.h = duMixSource;
        this.i = duMixTarget;
        this.j = aRCallback;
        DuMixInput duMixInput = new DuMixInput();
        duMixInput.setInputSurface(duMixSource.getCameraSource());
        duMixInput.setInputWidth(duMixSource.getSourceWidth());
        duMixInput.setInputHeight(duMixSource.getSourceHeight());
        duMixInput.setCameraInput(true);
        duMixInput.setFrontCamera(duMixSource.isFrontCamera());
        DuMixOutput duMixOutput = new DuMixOutput();
        if (duMixTarget.getSurfaceHolder() != null) {
            duMixOutput.setOutputSurface(duMixTarget.getSurfaceHolder());
        } else {
            duMixOutput.setOutputSurface(duMixTarget.getDrawTarget());
        }
        duMixOutput.setOutputWidth(duMixTarget.getTargetWidth());
        duMixOutput.setOutputHeight(duMixTarget.getTargetHeight());
        if (this.o == null) {
            this.o = new RequestController(this.mContext, this, duMixSource);
        }
        this.l.setCaseStateListener(b());
        this.l.setDefinedLuaListener(a());
        this.l.addLuaMsgListener(new LuaMsgListener() { // from class: com.baidu.ar.ARController.1
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                return Arrays.asList("id", "event_id", ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, "state", "event_name");
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                ARController.this.a(hashMap);
                if (ARController.this.j != null) {
                    ARController.this.j.onLuaMessage(hashMap);
                }
            }
        });
        this.l.setup(duMixInput, duMixOutput, a(duMixSource));
        this.l.setCaseQueryResourcecallback(this);
    }

    public void startRecord(String str, long j, final MovieRecorderCallback movieRecorderCallback) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.startRecord(str, j, new RecordCallback() { // from class: com.baidu.ar.ARController.5
                @Override // com.baidu.ar.record.RecordCallback
                public void onRecorderComplete(boolean z, String str2) {
                    movieRecorderCallback.onRecorderComplete(z, str2);
                }

                @Override // com.baidu.ar.record.RecordCallback
                public void onRecorderProcess(int i) {
                    movieRecorderCallback.onRecorderProcess(i);
                }

                @Override // com.baidu.ar.record.RecordCallback
                public void onRecorderStart(boolean z) {
                    movieRecorderCallback.onRecorderStart(z);
                }
            });
        }
    }

    public void stopRecord() {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.stopRecord();
        }
    }

    public void switchCamera(boolean z) {
        kf.c("ARController", "switchCamera front = " + z);
    }

    public void switchCase(String str, int i) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.loadCase(str, ARType.valueOf(i));
        }
    }

    public void takePicture(TakePictureCallback2 takePictureCallback2) {
    }

    public void vpsGetCaseList() {
    }

    public void vpsGpsExceptionToast(String str) {
    }

    public ARController(Context context, OBRConfig oBRConfig) {
        this.mContext = context;
        MapDuMixParams mapDuMixParams = new MapDuMixParams();
        this.p = mapDuMixParams;
        mapDuMixParams.setOBRConfig(oBRConfig);
        this.l = MapDuMix.getInstance(context, this.p);
    }

    private DefinedLuaListener a() {
        return new DefinedLuaListener() { // from class: com.baidu.ar.ARController.2
            @Override // com.baidu.ar.DefinedLuaListener
            public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
                BrowserBean browserBean = new BrowserBean();
                browserBean.setBrowserType(i);
                browserBean.setBrowserUrl(str);
                ARController.this.outputStateMessage(MsgField.MSG_OPEN_URL, browserBean);
            }

            @Override // com.baidu.ar.DefinedLuaListener
            public void onRequireSwitchCamera(int i) {
            }
        };
    }

    private CaseStateListener b() {
        return new CaseStateListener() { // from class: com.baidu.ar.ARController.4
            @Override // com.baidu.ar.baidumap.CaseStateListener
            public void onCaseCreated(boolean z, String str, String str2) {
                if (z) {
                    ARController.this.outputStateMessage(MsgField.IMSG_MODEL_LOADED, "");
                }
            }

            @Override // com.baidu.ar.baidumap.CaseStateListener
            public void onCaseDestroy() {
            }

            @Override // com.baidu.ar.baidumap.CaseDownloadListener
            public void onDownloadFinish(boolean z, String str, String str2, int i, String str3) {
                if (z) {
                    return;
                }
                ARController.this.outputStateMessage(MsgField.MSG_NO_NETWORK_FOR_DOWNLOAD_RES, "");
            }

            @Override // com.baidu.ar.baidumap.CaseDownloadListener
            public void onDownloadProgress(int i, String str) {
            }

            @Override // com.baidu.ar.baidumap.CaseDownloadListener
            public void onRefused() {
                ARController.this.outputStateMessage(30001, "");
            }
        };
    }

    public boolean sendMessage2Lua(HashMap<String, Object> hashMap) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            return mapDuMix.sendMsg2Lua(hashMap);
        }
        return false;
    }

    public void setRecordMark(Bitmap bitmap, Point point, float f) {
        if (this.l != null) {
            Watermark watermark = new Watermark(bitmap, point);
            watermark.setScale(f);
            this.l.setRecordWatermark(watermark);
        }
    }

    public void takePicture(String str, TakePictureCallback takePictureCallback) {
    }

    private MapDuMixCallback a(final DuMixSource duMixSource) {
        return new MapDuMixCallback() { // from class: com.baidu.ar.ARController.3
            @Override // com.baidu.ar.baidumap.MapDuMixCallback
            public void onError() {
                ARController.this.outputStateMessage(MsgField.MSG_NO_NETWORK_FOR_DOWNLOAD_RES, "network error!!!");
                if (ARController.this.j != null) {
                    ARController.this.j.onStateError(2303, "");
                }
            }

            @Override // com.baidu.ar.baidumap.MapDuMixCallback
            public void onRelease(boolean z) {
                if (ARController.this.j != null) {
                    ARController.this.j.onRelease(z);
                }
            }

            @Override // com.baidu.ar.baidumap.MapDuMixCallback
            public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
                DuMixSource duMixSource2;
                if (z && ARController.this.h != null && !ARController.this.h.isNeedDrawBackground() && ARController.this.l != null) {
                    ARController.this.l.getARRenderer().setRenderBlendInput(false);
                }
                ARController.this.outputStateMessage(z ? 1201 : 1202, "");
                if (!z || (duMixSource2 = duMixSource) == null || TextUtils.isEmpty(duMixSource2.getArKey())) {
                    ARController.this.outputStateMessage(MsgField.MSG_NO_NETWORK_FOR_START_QUERY_RES, "");
                } else {
                    ARController.this.outputStateMessage(9003, "");
                    if (!kq.p(ARController.this.mContext)) {
                        kf.b("ARController", "No network");
                        ARController.this.outputStateMessage(MsgField.MSG_NO_NETWORK_FOR_START_QUERY_RES, "");
                        return;
                    } else if (kq.q(ARController.this.mContext) && ARController.this.l != null) {
                        ARController.this.l.loadCase(duMixSource.getArKey(), ARType.valueOf(duMixSource.getArType()));
                    } else if (kq.s(ARController.this.mContext)) {
                        ARController aRController = ARController.this;
                        aRController.outputStateMessage(MsgField.MSG_MOBILE_NETWORK_FOR_START_QUERY_RES, aRController.o);
                    }
                }
                if (ARController.this.j != null) {
                    ARController.this.j.onSetup(z);
                }
            }
        };
    }

    private static String b(String str) {
        return km.cm(ke.ch(str));
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("ar key is null!");
        }
        long j = 0;
        String str2 = "";
        for (File file : km.i(new File(ke.f(this.mContext, str)))) {
            if (j < file.lastModified()) {
                j = file.lastModified();
                str2 = file.getAbsolutePath();
            }
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map) {
        int i;
        if (map == null) {
            return;
        }
        if (map.containsKey("event_name")) {
            if ("vps_recreate_session".equals(map.get("event_name"))) {
                i = MsgField.MSG_SESSION_INVALID;
            } else if ("vps_hide_sdk_btn".equals(map.get("event_name"))) {
                i = MsgField.MSG_HIDE_UI_BTN;
            }
            outputStateMessage(i, "");
        }
        if (map.containsKey("id") && ((Integer) map.get("id")).intValue() == 10301) {
            outputStateMessage(1006, "");
        }
    }
}
