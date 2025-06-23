package com.baidu.ar.vps.marker;

import XIXIX.OOXIXo;
import android.content.Context;
import android.opengl.Matrix;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.ARType;
import com.baidu.ar.arplay.representation.Vector4f;
import com.baidu.ar.callback.ICallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.fx;
import com.baidu.ar.ib;
import com.baidu.ar.kf;
import com.baidu.ar.kg;
import com.baidu.ar.kk;
import com.baidu.ar.kr;
import com.baidu.ar.marker.IMarkerDataProvider;
import com.baidu.ar.marker.IMarkerLocationTimeCallBack;
import com.baidu.ar.marker.IMarkerStateListener;
import com.baidu.ar.marker.IMarkerTracker;
import com.baidu.ar.marker.MarkerARAlgoController;
import com.baidu.ar.marker.MarkerARAlgoJniClient;
import com.baidu.ar.marker.MarkerErrorCode;
import com.baidu.ar.marker.OnTrackerSessionCallback;
import com.baidu.ar.marker.TrackerType;
import com.baidu.ar.marker.model.LocationMarkerData;
import com.baidu.ar.marker.model.TranslationPrior;
import com.baidu.ar.mj;
import com.baidu.ar.mv;
import com.baidu.ar.nb;
import com.baidu.ar.nc;
import com.baidu.ar.nj;
import com.baidu.ar.np;
import com.baidu.ar.remoteres.IDuMixResLoadTask;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class VisualManager implements nj.b {
    private static final int CAMERA_FPS_COUNT = 30;
    private static final String MANAGER_CLASS_NAME = "com.baidu.ar.remoteres.DuMixResManager";
    private static final String QA_TAG = "QA_DEBUG";
    private static final String TAG = "VisualManager";
    private IMarkerLocationTimeCallBack iMarkerLocationTimeCallBack;
    private fx iMarkerPositionCallback;
    private IMarkerStateListener iMarkerStateListener;
    private IMarkerTracker iMarkerTracker;
    private boolean mAlgoIsCreate;
    private String mBuildingId;
    private Context mContext;
    private ib mDuMixResManager;
    private int mExtractFrameIndex;
    private float[] mGrative;
    private boolean mIsTrackingResult;
    private double[] mLocationLocGpsData;
    private long mLocationSdkCreateTime;
    private long mLocationSingleSuccessTime;
    private double[] mMagnet;
    private a mMarkerAlgoDataTrans;
    private nj mMarkerRequestController;
    private int mNavigationVersion;
    private OnTrackerSessionCallback mOnTrackerSessionCallback;
    private boolean mPreTrackingResult;
    private boolean mPreTrackingStatisticsIntercept;
    private int mPreviewHeight;
    private int mPreviewWidth;
    private String mSession;
    private TrackerType mTrackerType;
    private nb mVisualLocatingServiceLocatingListener;
    private MarkerARAlgoJniClient.a onAlgoSoLoadedComplteCallback;
    private int mGetLocationResultCode = 0;
    private float[] mLocationTransforms = null;
    private int qaFrameCnt = 1;
    private StringBuffer mQATimeStr = new StringBuffer();
    private int mQACreateSessionCnt = 0;
    private int mQALocateFrameCnt = 0;

    /* loaded from: classes7.dex */
    public class a implements IMarkerDataProvider {
        private final WeakReference<VisualManager> Hd;

        public a(VisualManager visualManager) {
            this.Hd = new WeakReference<>(visualManager);
        }

        @Override // com.baidu.ar.marker.IMarkerDataProvider
        public float[] getGPS() {
            return new float[]{(float) VisualManager.this.mLocationLocGpsData[0], (float) VisualManager.this.mLocationLocGpsData[1], 0.0f};
        }

        @Override // com.baidu.ar.marker.IMarkerDataProvider
        public float[] getGravityDirection() {
            return this.Hd.get().getGrative();
        }

        @Override // com.baidu.ar.marker.IMarkerDataProvider
        public String getSessionId() {
            return this.Hd.get().getSession();
        }

        @Override // com.baidu.ar.marker.IMarkerDataProvider
        public String getUserId() {
            String iB = mv.iB();
            if (TextUtils.isEmpty(iB)) {
                return new kk(VisualManager.this.mContext).hg().toString();
            }
            mv.cz(iB);
            return iB;
        }

        @Override // com.baidu.ar.marker.IMarkerDataProvider
        public String getVersion() {
            return String.valueOf(kg.getVersionName());
        }

        @Override // com.baidu.ar.marker.IMarkerDataProvider
        public void queryFrameResult(int i, String str) {
            if (VisualManager.this.iMarkerStateListener != null) {
                VisualManager.this.iMarkerStateListener.onError(i, str);
            }
        }

        @Override // com.baidu.ar.marker.IMarkerDataProvider
        public void setLocationData(boolean z, Object obj) {
            if (VisualManager.this.iMarkerPositionCallback != null && z) {
                VisualManager.this.iMarkerPositionCallback.onVpasLocationSuccess();
            }
            if (!VisualManager.this.mIsTrackingResult) {
                VisualManager.this.mQATimeStr.append("positionFromJNI " + VisualManager.this.mQALocateFrameCnt + " " + z + " " + System.currentTimeMillis());
                VisualManager.this.mQATimeStr.append("\n");
            }
            if (this.Hd.get() != null && !VisualManager.this.mIsTrackingResult && z) {
                List<LocationMarkerData> list = (List) obj;
                if (VisualManager.this.mVisualLocatingServiceLocatingListener != null) {
                    VisualManager.this.mVisualLocatingServiceLocatingListener.a(z, VisualManager.this.mSession, list);
                }
                this.Hd.get().setLocationData(z, list);
                HashMap hashMap = new HashMap();
                hashMap.put(StatisticConstants.VPS_SERVICE_TYPE, String.valueOf(VisualManager.this.mNavigationVersion));
                hashMap.put("building_id", VisualManager.this.mBuildingId);
                hashMap.put(StatisticConstants.VPS_SUCCESS_NUM, String.valueOf(list.size()));
                StatisticApi.onEvent(StatisticConstants.VPS_INDOOR_SUCCESS_RESULT, hashMap);
                nc.iJ();
                kf.b(VisualManager.TAG, "pre positioning success");
                if (VisualManager.this.iMarkerLocationTimeCallBack != null) {
                    VisualManager.this.iMarkerLocationTimeCallBack.onQaRecordTimeInfo(VisualManager.this.mQATimeStr);
                }
                VisualManager.this.mQATimeStr.setLength(0);
            }
            if (VisualManager.this.mIsTrackingResult || !z) {
                return;
            }
            VisualManager.this.mIsTrackingResult = true;
            VisualManager.this.mPreTrackingResult = true;
            long currentTimeMillis = System.currentTimeMillis();
            VisualManager.this.mLocationSingleSuccessTime = currentTimeMillis;
            long abs = Math.abs(currentTimeMillis - VisualManager.this.mLocationSdkCreateTime);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(StatisticConstants.VPS_SERVICE_TYPE, String.valueOf(VisualManager.this.mNavigationVersion));
            double d = abs / 1000.0d;
            hashMap2.put(StatisticConstants.VPS_GET_LOC_DURATION, String.valueOf(d));
            hashMap2.put("session_id", String.valueOf(VisualManager.this.mSession));
            hashMap2.put("building_id", VisualManager.this.mBuildingId);
            StatisticApi.onEvent(StatisticConstants.VPS_INDOOR_GET_LOC_DURATION, hashMap2);
            kf.b(VisualManager.TAG, "pre positioning duration：" + d);
        }

        @Override // com.baidu.ar.marker.IMarkerDataProvider
        public void setLocationPoints(int i, double[] dArr) {
            VisualManager.this.mGetLocationResultCode = i;
            if (VisualManager.this.iMarkerPositionCallback != null) {
                VisualManager.this.iMarkerPositionCallback.onVpasTrackingState(i);
            }
            if (VisualManager.this.mIsTrackingResult) {
                if (VisualManager.this.iMarkerStateListener != null) {
                    VisualManager.this.iMarkerStateListener.onCoordinateResult(i, dArr);
                }
            } else if (VisualManager.this.extractCoordinate() && i == -86) {
                VisualManager.this.mLocationSdkCreateTime = System.currentTimeMillis();
                if (VisualManager.this.iMarkerTracker != null) {
                    VisualManager.this.iMarkerTracker.onTrackReset();
                }
            } else if (!VisualManager.this.mPreTrackingStatisticsIntercept) {
                kf.b(VisualManager.TAG, "pre positioning");
                VisualManager.this.mPreTrackingStatisticsIntercept = true;
                VisualManager.this.mLocationSdkCreateTime = System.currentTimeMillis();
            }
            if (dArr == null) {
                return;
            }
            if (i == 0 && VisualManager.this.mVisualLocatingServiceLocatingListener != null) {
                mj mjVar = new mj();
                mjVar.FG = (float) dArr[12];
                mjVar.FH = (float) dArr[13];
                VisualManager.this.mVisualLocatingServiceLocatingListener.a(VisualManager.this.mSession, mjVar);
            }
            float f = (float) dArr[9];
            float f2 = (float) dArr[10];
            float f3 = (float) dArr[11];
            float[] fArr = {(float) dArr[0], (float) dArr[1], (float) dArr[2], 0.0f, (float) dArr[3], (float) dArr[4], (float) dArr[5], 0.0f, (float) dArr[6], (float) dArr[7], (float) dArr[8], 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
            float[] fArr2 = new float[16];
            System.arraycopy(fArr, 0, fArr2, 0, 16);
            float[] fArr3 = new float[16];
            Matrix.setIdentityM(fArr3, 0);
            Matrix.rotateM(fArr3, 0, 90.0f, 0.0f, 0.0f, 1.0f);
            float[] fArr4 = new float[16];
            Matrix.multiplyMM(fArr4, 0, fArr, 0, fArr3, 0);
            float[] fArr5 = new float[16];
            Matrix.setIdentityM(fArr5, 0);
            Matrix.scaleM(fArr5, 0, -1.0f, 1.0f, 1.0f);
            float[] fArr6 = new float[16];
            Matrix.multiplyMM(fArr6, 0, fArr4, 0, fArr5, 0);
            float[] fArr7 = new float[16];
            Matrix.setIdentityM(fArr7, 0);
            Matrix.scaleM(fArr7, 0, 1.0f, 1.0f, -1.0f);
            float[] fArr8 = new float[16];
            Matrix.multiplyMM(fArr8, 0, fArr6, 0, fArr7, 0);
            float[] fArr9 = {fArr8[0], fArr8[1], fArr8[2], 0.0f, fArr8[4], fArr8[5], fArr8[6], 0.0f, fArr8[8], fArr8[9], fArr8[10], 0.0f, f, f2, f3, 1.0f};
            if (VisualManager.this.mVisualLocatingServiceLocatingListener != null) {
                VisualManager.this.mVisualLocatingServiceLocatingListener.a(VisualManager.this.mSession, VisualManager.this.getCompass(fArr2));
                VisualManager.this.mVisualLocatingServiceLocatingListener.B(fArr9);
                kf.b("invertFloats", "" + Arrays.toString(fArr9));
            }
        }

        @Override // com.baidu.ar.marker.IMarkerDataProvider
        public void setLocationTransforms(float[] fArr) {
            this.Hd.get().setLocationTransforms(fArr);
        }

        @Override // com.baidu.ar.marker.IMarkerDataProvider
        public void setVpasState(int i, int i2, float f) {
            if (VisualManager.this.iMarkerPositionCallback != null) {
                VisualManager.this.iMarkerPositionCallback.onVpasAlgoStatePrint(i, i2, f);
            }
        }

        @Override // com.baidu.ar.marker.IMarkerDataProvider
        public void setVpsLocation(float f, float f2) {
        }

        @Override // com.baidu.ar.marker.IMarkerDataProvider
        public void transDataFromJNI(byte[] bArr) {
            if (VisualManager.this.iMarkerPositionCallback != null) {
                VisualManager.this.iMarkerPositionCallback.onVpasSendFrame();
            }
            Log.d(VisualManager.QA_TAG, "start send frame " + VisualManager.this.qaFrameCnt + " to server");
            if (this.Hd.get() == null || this.Hd.get().mMarkerRequestController == null) {
                return;
            }
            if (VisualManager.this.mIsTrackingResult) {
                this.Hd.get().mMarkerRequestController.b(bArr, this.Hd.get());
                return;
            }
            VisualManager.access$1808(VisualManager.this);
            VisualManager.this.mQATimeStr.append("positionToServer " + VisualManager.this.mQALocateFrameCnt + " start " + System.currentTimeMillis());
            VisualManager.this.mQATimeStr.append("\n");
            this.Hd.get().mMarkerRequestController.a(bArr, this.Hd.get());
        }
    }

    public VisualManager(Context context, int i, int i2, int i3) {
        this.mContext = context;
        this.mNavigationVersion = i3;
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
    }

    public static /* synthetic */ int access$1808(VisualManager visualManager) {
        int i = visualManager.mQALocateFrameCnt;
        visualManager.mQALocateFrameCnt = i + 1;
        return i;
    }

    private void beMiddleEndTime() {
        if (this.mLocationSingleSuccessTime > 0) {
            long abs = Math.abs(System.currentTimeMillis() - this.mLocationSingleSuccessTime);
            HashMap hashMap = new HashMap();
            hashMap.put(StatisticConstants.VPS_SERVICE_TYPE, String.valueOf(this.mNavigationVersion));
            double d = abs / 1000.0d;
            hashMap.put(StatisticConstants.VPS_NAVIGATE_DURATION, String.valueOf(d));
            hashMap.put("session_id", String.valueOf(this.mSession));
            hashMap.put("building_id", this.mBuildingId);
            StatisticApi.onEvent(StatisticConstants.VPS_INDOOR_NAVIGATE_DURATION, hashMap);
            this.mLocationSingleSuccessTime = 0L;
            kf.b(TAG, "pre positioning ->tracking end：" + d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MarkerARAlgoJniClient.a createSoLoadedCallback(final TrackerType trackerType) {
        return new MarkerARAlgoJniClient.a() { // from class: com.baidu.ar.vps.marker.VisualManager.4
            @Override // com.baidu.ar.marker.MarkerARAlgoJniClient.a
            public void em() {
                VisualManager.this.initMarkerByTrackerType(trackerType);
            }

            @Override // com.baidu.ar.marker.MarkerARAlgoJniClient.a
            public void en() {
                if (VisualManager.this.iMarkerPositionCallback != null) {
                    VisualManager.this.iMarkerPositionCallback.onCreateVpasAlgoFail();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean extractCoordinate() {
        int i = this.mExtractFrameIndex + 1;
        this.mExtractFrameIndex = i;
        if (i != 30) {
            return false;
        }
        this.mExtractFrameIndex = 0;
        return true;
    }

    private void fromBeginToEndTime() {
        if (this.mLocationSdkCreateTime <= 0 || !this.mPreTrackingResult) {
            return;
        }
        long abs = Math.abs(System.currentTimeMillis() - this.mLocationSdkCreateTime);
        HashMap hashMap = new HashMap();
        hashMap.put(StatisticConstants.VPS_SERVICE_TYPE, String.valueOf(this.mNavigationVersion));
        double d = abs / 1000.0d;
        hashMap.put(StatisticConstants.VPS_SUB_INDOOR_SERVICE_DURATION, String.valueOf(d));
        hashMap.put("session_id", String.valueOf(this.mSession));
        hashMap.put("building_id", this.mBuildingId);
        StatisticApi.onEvent(StatisticConstants.VPS_INDOOR_SERVICE_DURATION, hashMap);
        kf.b(TAG, "positioning end：" + d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double getCompass(float[] fArr) {
        float[] locationTransforms;
        if (getLocationTransforms() == null || (locationTransforms = getLocationTransforms()) == null) {
            return OOXIXo.f3760XO;
        }
        float[] fArr2 = {locationTransforms[0], locationTransforms[1], locationTransforms[2], 0.0f, locationTransforms[3], locationTransforms[4], locationTransforms[5], 0.0f, locationTransforms[6], locationTransforms[7], locationTransforms[8], 0.0f, locationTransforms[9], locationTransforms[10], locationTransforms[11], 1.0f};
        Vector4f vector4f = new Vector4f(110.0f, 40.0f, 0.0f, 1.0f);
        Vector4f vector4f2 = new Vector4f(110.0f, 41.0f, 0.0f, 1.0f);
        Matrix.multiplyMV(new float[4], 0, fArr2, 0, vector4f.toArray(), 0);
        Matrix.multiplyMV(new float[4], 0, fArr2, 0, vector4f2.toArray(), 0);
        double a2 = OOXIXo.f3760XO - (np.a(r1[1] - r3[1], r1[0] - r3[0]) - 180.0d);
        Matrix.multiplyMV(new float[4], 0, fArr, 0, new Vector4f(0.0f, -1.0f, 0.0f, 1.0f).toArray(), 0);
        double a3 = (np.a(r0[0], r0[1]) - 180.0d) + a2;
        return a3 < OOXIXo.f3760XO ? a3 + 360.0d : a3 > 360.0d ? a3 - 360.0d : a3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] getGrative() {
        return this.mGrative;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSession() {
        return this.mSession;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocationData(boolean z, List<LocationMarkerData> list) {
        OnTrackerSessionCallback onTrackerSessionCallback;
        IMarkerStateListener iMarkerStateListener = this.iMarkerStateListener;
        if (iMarkerStateListener != null) {
            iMarkerStateListener.onLocationResult(z, list);
        }
        if (z && list.size() == 1 && (onTrackerSessionCallback = this.mOnTrackerSessionCallback) != null) {
            onTrackerSessionCallback.onSessionCallback(list.get(0).session);
        }
        fx fxVar = this.iMarkerPositionCallback;
        if (fxVar != null) {
            fxVar.onPositionSuccess(list.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocationTransforms(float[] fArr) {
        this.mLocationTransforms = fArr;
        float[] fArr2 = {fArr[0], fArr[1], fArr[2], 0.0f, fArr[3], fArr[4], fArr[5], 0.0f, fArr[6], fArr[7], fArr[8], 0.0f, fArr[9], fArr[10], fArr[11], 1.0f};
        nb nbVar = this.mVisualLocatingServiceLocatingListener;
        if (nbVar != null) {
            nbVar.C(fArr2);
        }
    }

    private void setSession(String str) {
        this.mSession = str;
    }

    public void algoClose() {
        IMarkerTracker iMarkerTracker = this.iMarkerTracker;
        if (iMarkerTracker != null) {
            iMarkerTracker.onTrackPause();
        }
    }

    public boolean algoIsReady() {
        IMarkerTracker iMarkerTracker = this.iMarkerTracker;
        if (iMarkerTracker == null) {
            return false;
        }
        return iMarkerTracker.getAlgoState();
    }

    public void algoOpen() {
        IMarkerTracker iMarkerTracker = this.iMarkerTracker;
        if (iMarkerTracker != null) {
            iMarkerTracker.onTrackResume();
        }
    }

    public void choiceOneCoordinate(LocationMarkerData locationMarkerData) {
        if (this.iMarkerTracker == null || locationMarkerData == null) {
            return;
        }
        OnTrackerSessionCallback onTrackerSessionCallback = this.mOnTrackerSessionCallback;
        if (onTrackerSessionCallback != null) {
            onTrackerSessionCallback.onSessionCallback(locationMarkerData.session);
        }
        this.iMarkerTracker.chooseMap(locationMarkerData.position);
    }

    public void createSession(final TrackerType trackerType) {
        nc.iG();
        this.mQACreateSessionCnt++;
        if (this.mMarkerRequestController == null) {
            this.mMarkerRequestController = new nj();
        }
        final long currentTimeMillis = System.currentTimeMillis();
        Log.d(QA_TAG, "create session at " + currentTimeMillis);
        this.mMarkerRequestController.a(this.mLocationLocGpsData, this.mBuildingId, this.mPreviewWidth, this.mPreviewHeight, new nj.a() { // from class: com.baidu.ar.vps.marker.VisualManager.3
            @Override // com.baidu.ar.nj.a
            public void a(boolean z, String str, String str2, float[] fArr, String str3) {
                if (z && !TextUtils.isEmpty(str2)) {
                    VisualManager.this.mSession = str2;
                    nc.iH();
                    Log.d(VisualManager.QA_TAG, "start server session successfully at " + System.currentTimeMillis());
                    if (VisualManager.this.iMarkerTracker == null) {
                        VisualManager visualManager = VisualManager.this;
                        visualManager.iMarkerTracker = new MarkerARAlgoController(visualManager.mPreviewWidth, VisualManager.this.mPreviewHeight, fArr, str3, 30, VisualManager.this.mContext.getFilesDir().getAbsolutePath());
                        VisualManager visualManager2 = VisualManager.this;
                        visualManager2.onAlgoSoLoadedComplteCallback = visualManager2.createSoLoadedCallback(trackerType);
                    }
                    VisualManager.this.iMarkerTracker.loadAlgoSo(VisualManager.this.onAlgoSoLoadedComplteCallback);
                    if (VisualManager.this.mMarkerAlgoDataTrans == null) {
                        VisualManager visualManager3 = VisualManager.this;
                        visualManager3.mMarkerAlgoDataTrans = new a(visualManager3);
                    }
                    VisualManager.this.iMarkerTracker.setDataProvider(VisualManager.this.mMarkerAlgoDataTrans);
                }
                if (VisualManager.this.iMarkerPositionCallback != null && !z) {
                    VisualManager.this.iMarkerPositionCallback.onCreateSessionFail();
                }
                if (VisualManager.this.iMarkerStateListener != null) {
                    VisualManager.this.iMarkerStateListener.onSessionCreated(z, str);
                    VisualManager.this.mQATimeStr.append("createsession " + VisualManager.this.mQACreateSessionCnt + " start " + currentTimeMillis);
                    VisualManager.this.mQATimeStr.append("\n");
                    StringBuffer stringBuffer = VisualManager.this.mQATimeStr;
                    StringBuilder sb = new StringBuilder();
                    sb.append("createsession ");
                    sb.append(VisualManager.this.mQACreateSessionCnt);
                    sb.append(" ");
                    sb.append(z ? "success" : "failed");
                    sb.append(" ");
                    sb.append(System.currentTimeMillis());
                    stringBuffer.append(sb.toString());
                    VisualManager.this.mQATimeStr.append("\n");
                    Log.d(VisualManager.QA_TAG, "start client session successfully at " + System.currentTimeMillis());
                }
            }
        });
    }

    public float[] getLocationTransforms() {
        return this.mLocationTransforms;
    }

    public void initMarkerByTrackerType(TrackerType trackerType) {
        IMarkerTracker iMarkerTracker = this.iMarkerTracker;
        if (iMarkerTracker == null) {
            return;
        }
        try {
            this.mTrackerType = trackerType;
            boolean z = iMarkerTracker.init(trackerType) == 0;
            this.mAlgoIsCreate = z;
            if (z) {
                nc.iI();
            }
            fx fxVar = this.iMarkerPositionCallback;
            if (fxVar == null || this.mAlgoIsCreate) {
                return;
            }
            fxVar.onCreateVpasAlgoFail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMarkerSO(final TrackerType trackerType) {
        if (this.mDuMixResManager == null) {
            this.mDuMixResManager = (ib) kr.a(MANAGER_CLASS_NAME, new Class[]{Context.class}, new Object[]{this.mContext});
        }
        ib ibVar = this.mDuMixResManager;
        if (ibVar == null) {
            createSession(trackerType);
        } else {
            ibVar.downloadARRes(ARType.MARKER, new ICallback() { // from class: com.baidu.ar.vps.marker.VisualManager.1
                @Override // com.baidu.ar.callback.ICallback
                public void run() {
                    VisualManager.this.createSession(trackerType);
                }
            });
            this.mDuMixResManager.setErrorCallback(new ICallbackWith<IDuMixResLoadTask>() { // from class: com.baidu.ar.vps.marker.VisualManager.2
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void run(IDuMixResLoadTask iDuMixResLoadTask) {
                    Log.e(VisualManager.TAG, "ErrorCallback:" + iDuMixResLoadTask.getError());
                    if (VisualManager.this.iMarkerStateListener != null) {
                        VisualManager.this.iMarkerStateListener.onError(MarkerErrorCode.ERROR_DOWNLOAD_SO, "download so error!!!");
                    }
                }
            });
        }
    }

    public void onPause() {
        IMarkerTracker iMarkerTracker = this.iMarkerTracker;
        if (iMarkerTracker != null) {
            iMarkerTracker.onTrackPause();
        }
        beMiddleEndTime();
    }

    public void onResume() {
        IMarkerTracker iMarkerTracker = this.iMarkerTracker;
        if (iMarkerTracker != null) {
            iMarkerTracker.onTrackResume();
        }
    }

    @Override // com.baidu.ar.nj.b
    public void onUploadProtobufResult(byte[] bArr, boolean z) {
        Log.d(QA_TAG, "get server frame " + this.qaFrameCnt + " to server");
        this.qaFrameCnt = this.qaFrameCnt + 1;
        if (this.mGetLocationResultCode == -86) {
            Log.e(TAG, "current result is invalid");
            return;
        }
        if (bArr == null || bArr.length <= 0) {
            IMarkerStateListener iMarkerStateListener = this.iMarkerStateListener;
            if (iMarkerStateListener != null) {
                iMarkerStateListener.onError(MarkerErrorCode.ERROR_UPLOAD_PROTOBUF, "Server Inner Algo Error !!!");
                return;
            }
            return;
        }
        boolean z2 = this.mIsTrackingResult;
        if (!z2 && !z2) {
            this.mQATimeStr.append("positionFromServer " + this.mQALocateFrameCnt + " end " + System.currentTimeMillis());
            this.mQATimeStr.append("\n");
        }
        IMarkerTracker iMarkerTracker = this.iMarkerTracker;
        if (iMarkerTracker != null) {
            if (!z && !this.mPreTrackingResult) {
                iMarkerTracker.transProtoDataJNIFromServer(null);
                return;
            }
            if (!this.mIsTrackingResult) {
                this.mQATimeStr.append("positionToJNI " + this.mQALocateFrameCnt + " start " + System.currentTimeMillis());
                this.mQATimeStr.append("\n");
            }
            this.iMarkerTracker.transProtoDataJNIFromServer(bArr);
        }
    }

    public void release() {
        beMiddleEndTime();
        fromBeginToEndTime();
        this.mMarkerAlgoDataTrans = null;
        if (this.mIsTrackingResult) {
            this.mPreTrackingStatisticsIntercept = false;
        }
        this.mIsTrackingResult = false;
        this.mPreTrackingResult = false;
        IMarkerTracker iMarkerTracker = this.iMarkerTracker;
        if (iMarkerTracker != null) {
            iMarkerTracker.onTrackRelease();
            this.iMarkerTracker = null;
        }
        nj njVar = this.mMarkerRequestController;
        if (njVar != null) {
            njVar.iQ();
            this.mMarkerRequestController = null;
        }
    }

    public void releaseAlgo() {
        release();
    }

    public void resetAlgo() {
        if (this.mIsTrackingResult) {
            this.mPreTrackingStatisticsIntercept = false;
        }
        this.mIsTrackingResult = false;
        this.mPreTrackingResult = false;
        IMarkerTracker iMarkerTracker = this.iMarkerTracker;
        if (iMarkerTracker != null) {
            iMarkerTracker.onTrackReset();
        }
    }

    public void setBaiduMapCuid(String str) {
        mv.cz(str);
    }

    public void setCameraParams(float[] fArr, float[] fArr2, int i, double[] dArr) {
        IMarkerTracker iMarkerTracker = this.iMarkerTracker;
        if (iMarkerTracker != null) {
            iMarkerTracker.setCameraParams(fArr, fArr2, i, dArr);
        }
    }

    public void setMapIndoorParams(double[] dArr, String str) {
        if (dArr != null) {
            this.mLocationLocGpsData = new double[]{dArr[0], dArr[1]};
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mBuildingId = str;
    }

    public void setMarkerLocationTimeCallBack(IMarkerLocationTimeCallBack iMarkerLocationTimeCallBack) {
        this.iMarkerLocationTimeCallBack = iMarkerLocationTimeCallBack;
    }

    public void setMarkerStateListener(IMarkerStateListener iMarkerStateListener) {
        this.iMarkerStateListener = iMarkerStateListener;
    }

    public void setTrackerSessionCallback(OnTrackerSessionCallback onTrackerSessionCallback) {
        this.mOnTrackerSessionCallback = onTrackerSessionCallback;
    }

    public void setVisualLocatingServiceLocatingListener(nb nbVar) {
        this.mVisualLocatingServiceLocatingListener = nbVar;
    }

    public void setYUVFile(byte[] bArr, int i, int i2, float[] fArr, float[] fArr2) {
        IMarkerTracker iMarkerTracker = this.iMarkerTracker;
        if (iMarkerTracker == null || fArr == null || !this.mAlgoIsCreate || bArr == null || i < 0 || bArr.length <= 0) {
            return;
        }
        iMarkerTracker.onTrack(bArr, i, i2, fArr, fArr2);
    }

    public void setiMarkerPositionCallback(fx fxVar) {
        this.iMarkerPositionCallback = fxVar;
    }

    public void updateGrative(float[] fArr) {
        this.mGrative = fArr;
    }

    public void updateTranslationPrior(TranslationPrior translationPrior) {
        IMarkerTracker iMarkerTracker = this.iMarkerTracker;
        if (iMarkerTracker != null) {
            iMarkerTracker.updateTranslationPrior(translationPrior);
        }
    }
}
