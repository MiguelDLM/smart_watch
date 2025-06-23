package com.baidu.ar;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLSurfaceView;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.R;
import com.baidu.ar.arrender.Texture;
import com.baidu.ar.baidumap.CaseStateListener;
import com.baidu.ar.baidumap.MapDuMix;
import com.baidu.ar.baidumap.MapDuMixCallback;
import com.baidu.ar.baidumap.MapDuMixParams;
import com.baidu.ar.baidumap.bean.CommandDate;
import com.baidu.ar.baidumap.bean.CommandType;
import com.baidu.ar.baidumap.bean.NavigationLuaField;
import com.baidu.ar.bean.ARCameraInputSize;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.bean.NavigationNpc;
import com.baidu.ar.camera.CameraManager;
import com.baidu.ar.content.ARResourceManager;
import com.baidu.ar.i;
import com.baidu.ar.k;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.marker.IMakerAxisCallback;
import com.baidu.ar.marker.IMarkerLocationTimeCallBack;
import com.baidu.ar.marker.IMarkerStateListener;
import com.baidu.ar.marker.OnCoordinateBoundListener;
import com.baidu.ar.marker.OnEulerAngleCallback;
import com.baidu.ar.marker.OnTrackerSessionCallback;
import com.baidu.ar.marker.PositioningModuleAddListener;
import com.baidu.ar.marker.model.Segments;
import com.baidu.ar.marker.model.TranslationPrior;
import com.baidu.ar.nm;
import com.baidu.ar.photo.PhotoCallback;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.util.DeviceSupportAbility;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.garmin.fit.xOxOoo;
import com.sma.smartv3.ble.ProductManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class NavigationController implements OnFrmeTrackingStateCallback, CaseStateListener, fx, k.a, LuaMsgListener {
    private static Map<NavigationType, ARCameraInputSize> cJ;
    private String cE;
    private boolean cL;
    private com.baidu.ar.a cN;
    private k cO;
    private OnEulerAngleCallback cP;
    private VpasManager cQ;
    private IMarkerLocationTimeCallBack cR;
    private boolean cT;
    private boolean cU;
    private boolean cV;
    private boolean cW;
    private OnFrmeTrackingStateCallback cY;
    private OnReciveLatLngFormLuaListener cZ;
    private GLSurfaceView d;
    private long dA;
    private boolean dB;
    private long dC;
    private List<double[]> dF;
    private i dG;
    private TranslationPrior dI;
    private OnReciveCrossStreetFormLuaListener da;
    private OnReciveTunnelFormLuaListener db;
    private OnReciveFootBridgeFormLuaListener dc;
    private OnReciveLuaListener dd;
    private OnSetupComplete de;
    private OnCoordinateBoundListener df;
    private OnRecive2DMapPlaneListener dg;
    private OnReciveShakeListener dh;
    private float[] di;
    private int dj;
    private long dk;
    private boolean dl;
    private boolean dm;
    private boolean dn;

    /* renamed from: do, reason: not valid java name */
    private boolean f0do;
    private int dq;
    private NavigationType dr;
    private PositioningModuleAddListener ds;
    private boolean du;
    private kc dv;
    private ImageView dw;
    private TextView dx;
    private boolean dy;
    private a dz;
    private boolean isNight;
    private MapDuMix l;
    private Context mContext;
    public IMakerAxisCallback mIMakerAxisZCallback;
    public IMarkerStateListener mIMarkerStateListener;
    private int cK = 0;
    private int cM = -1;
    private MapDuMixParams p = new MapDuMixParams();
    public boolean mMapDuMixSetuped = false;
    private int cB = 1280;
    private int cC = CameraManager.DEFAULTHEIGHT;
    private int cS = 1;
    private List<Segments> cX = new ArrayList();
    private int dp = -1;
    private nm dt = null;
    private boolean dD = true;
    private boolean dE = true;
    private boolean dH = false;
    private boolean dJ = true;
    private long dK = System.currentTimeMillis();

    /* loaded from: classes7.dex */
    public interface a {
    }

    static {
        HashMap hashMap = new HashMap();
        cJ = hashMap;
        hashMap.put(NavigationType.ARCore, new ARCameraInputSize(1280, CameraManager.DEFAULTHEIGHT));
        cJ.put(NavigationType.AREngine, new ARCameraInputSize(1440, ScreenUtil.DEFAULT_WIDTH));
        cJ.put(NavigationType.ARIMU, new ARCameraInputSize(1280, CameraManager.DEFAULTHEIGHT));
        cJ.put(NavigationType.ARPedometer, new ARCameraInputSize(1280, CameraManager.DEFAULTHEIGHT));
        cJ.put(NavigationType.None, new ARCameraInputSize(1280, CameraManager.DEFAULTHEIGHT));
    }

    private void aa() {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.release();
            this.l = null;
        }
    }

    private void ad() {
        MapDuMix mapDuMix;
        if (!this.mMapDuMixSetuped || this.cX.size() <= 0 || (mapDuMix = this.l) == null || !this.du) {
            return;
        }
        mapDuMix.getMarkerManager().postNavigationRoute(this.cX);
    }

    private void ae() {
        PositioningModuleAddListener positioningModuleAddListener = this.ds;
        if (positioningModuleAddListener == null || this.cW || !this.du) {
            return;
        }
        boolean z = this.cT && this.cU && this.cV;
        this.cW = z;
        if (z) {
            positioningModuleAddListener.addPositioningResult(z);
        }
    }

    private void af() {
        this.cW = false;
        this.cV = false;
    }

    private void ag() {
        if (this.cM == 4 && this.l != null && this.cL) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("event_name", NavigationLuaField.NAVI_LUA_NAVIGATION_VPAS_MSG);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(NavigationLuaField.NAVI_LUA_LAUNCH_NAVI_MODE_MSG, 1);
            hashMap.put("event_data", hashMap2);
            this.l.sendMsg2Lua(hashMap);
        }
    }

    private void ah() {
        kc kcVar = this.dv;
        if (kcVar != null) {
            kcVar.gY();
        }
        this.l.getMarkerManager().createSession();
    }

    private void ai() {
        if (this.l == null || !this.cL) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", NavigationLuaField.NAVI_LUA_NPC_RUNTIME_STATE_UPDATE_MSG);
        hashMap.put("event_data", NavigationLuaField.NAVI_LUA_NPC_LAUNCH_TIME);
        this.l.sendMsg2Lua(hashMap);
    }

    private void f(boolean z) {
        if (this.l == null || !this.cL) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", NavigationLuaField.NAVI_LUA_NPC_LAUNCH_STATE_UPDATE_MSG);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(NavigationLuaField.NAVI_LUA_NPC_LAUNCH_STATE, z ? NavigationLuaField.NAVI_LUA_NPC_FIRST_LAUNCH : NavigationLuaField.NAVI_LUA_NPC_RE_LAUNCH);
        hashMap.put("event_data", hashMap2);
        this.l.sendMsg2Lua(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startMarker() {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.startMarker();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopMarker() {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.stopMarker();
        }
    }

    public void choseFloor() {
        kc kcVar = this.dv;
        if (kcVar != null) {
            kcVar.choseFloor();
        }
    }

    public void clearCase() {
        IMarkerStateListener iMarkerStateListener;
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            this.cL = false;
            mapDuMix.clearCase();
            this.dA = System.currentTimeMillis();
            this.dy = false;
            if (this.cM != 4 || (iMarkerStateListener = this.mIMarkerStateListener) == null) {
                return;
            }
            iMarkerStateListener.onCoordinateResult(-1, null);
        }
    }

    public void clearNavigationRoute() {
        kf.b("DuMixController", "clearNavigationRoute");
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.getMarkerManager().clearNavigationRoute();
        } else {
            Log.e("DuMixController", "clearNavigationRoute mMapDuMix = null");
        }
    }

    public float[] convertLatLngFromPosition(float f, float f2) {
        return this.l.getMarkerManager().convertLatLngFromPosition(f, f2);
    }

    public float[] convertPositionFromLatlng(float[] fArr) {
        return this.l.getMarkerManager().convertPositionFromLatlng(fArr);
    }

    public ViewGroup createGLSurfaceViewWithSize(Context context, NavigationType navigationType, boolean z) {
        kf.b("DuMixController", "createGLSurfaceViewWithSize()");
        if (context == null) {
            Log.e("DuMixController", "createGLSurfaceViewWithContext error!!");
            return null;
        }
        nc.iF();
        this.dA = System.currentTimeMillis();
        this.du = z;
        this.dr = navigationType;
        if (cJ.containsKey(navigationType)) {
            this.cB = cJ.get(navigationType).getWidth();
            this.cC = cJ.get(navigationType).getHeight();
        }
        ViewGroup viewGroup = (ViewGroup) View.inflate(context, R.layout.bdar_vpas_ui, null);
        this.mContext = context;
        this.d = (GLSurfaceView) viewGroup.findViewById(R.id.bdar_surface);
        DuMixARConfig.setAppId("6");
        DuMixARConfig.setAPIKey("43fb0bbd611ce4bff83ab5688bb2e0d1");
        DuMixARConfig.setSecretKey("");
        this.d.setEGLContextClientVersion(2);
        if (navigationType == NavigationType.ARCore || navigationType == NavigationType.AREngine) {
            k kVar = new k();
            this.cO = kVar;
            kVar.a(this);
            this.cO.b(this.cB, this.cC);
            this.d.setRenderer(this.cO);
            this.d.setRenderMode(0);
            com.baidu.ar.a aVar = new com.baidu.ar.a();
            this.cN = aVar;
            aVar.a(this.mContext, this.cB, this.cC, navigationType, z);
            this.cN.a(this.d);
            this.cN.setTrackingStateCallback(this);
            this.f0do = true;
        } else if (navigationType == NavigationType.ARIMU || navigationType == NavigationType.ARPedometer) {
            if (this.dG == null) {
                this.dG = new i(this.mContext, this.l, this);
            }
            this.dG.b(this.cB, this.cC);
            this.dG.a(this.d, this.p, new i.a() { // from class: com.baidu.ar.NavigationController.5
                @Override // com.baidu.ar.i.a
                public void a(MapDuMix mapDuMix) {
                    NavigationController.this.l = mapDuMix;
                }
            });
        }
        this.dw = (ImageView) viewGroup.findViewById(R.id.bdar_image_close);
        TextView textView = (TextView) viewGroup.findViewById(R.id.bdar_txt_center);
        this.dx = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.NavigationController.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationController.this.l.resume();
            }
        });
        if (this.dv == null) {
            kc a2 = kc.a(context, viewGroup, z);
            this.dv = a2;
            a2.a(new View.OnClickListener() { // from class: com.baidu.ar.NavigationController.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NavigationController.this.l == null || NavigationController.this.l.getMarkerManager() == null) {
                        return;
                    }
                    NavigationController.this.l.getMarkerManager().createSession();
                }
            });
            this.dv.b(new View.OnClickListener() { // from class: com.baidu.ar.NavigationController.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NavigationController.this.l == null || NavigationController.this.l.getMarkerManager() == null) {
                        return;
                    }
                    NavigationController.this.l.getMarkerManager().createSession();
                }
            });
            this.dv.a(new ka() { // from class: com.baidu.ar.NavigationController.9
            });
        }
        return viewGroup;
    }

    public MapDuMixCallback createMapDuMixCallback() {
        return new MapDuMixCallback() { // from class: com.baidu.ar.NavigationController.10
            @Override // com.baidu.ar.baidumap.MapDuMixCallback
            public void onError() {
            }

            @Override // com.baidu.ar.baidumap.MapDuMixCallback
            public void onRelease(boolean z) {
                NavigationController.this.stopMarker();
            }

            @Override // com.baidu.ar.baidumap.MapDuMixCallback
            public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
                kf.c("DuMixController", "MapDuMixCallback onSetup() result = " + z);
                NavigationController.this.startMarker();
                NavigationController navigationController = NavigationController.this;
                navigationController.mMapDuMixSetuped = true;
                if (navigationController.l == null || duMixInput == null) {
                    Log.e("DuMixController", "onSetup mMapDuMix = null");
                    return;
                }
                NavigationController.this.l.setCaseStateListener(NavigationController.this);
                NavigationController.this.l.getMarkerManager().setMarkerARSetupCallback(new fz() { // from class: com.baidu.ar.NavigationController.10.1
                    @Override // com.baidu.ar.fz
                    public void aj() {
                        if (NavigationController.this.de != null) {
                            NavigationController.this.de.onSetup();
                        }
                        if (NavigationController.this.df != null) {
                            NavigationController.this.l.getMarkerManager().setCoordinateBoundListener(NavigationController.this.df);
                        }
                        if (NavigationController.this.dv == null || !NavigationController.this.dv.gL()) {
                            return;
                        }
                        NavigationController.this.l.getMarkerManager().openDataRecorde();
                    }
                });
                if (!NavigationController.this.du) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("cuid", ARConfig.getCUID());
                    StatisticApi.onEvent(StatisticConstants.VPS_INDOOR_SDK_RECALL_SUCCESS, hashMap);
                }
                if (NavigationController.this.dv != null) {
                    NavigationController.this.dv.V(9);
                    String str = "profile_sdk_init_time: " + (Math.abs(System.currentTimeMillis() - NavigationController.this.dA) / 1000.0d);
                    Log.e("DuMixController", str);
                    NavigationController.this.dv.cf(str);
                }
                if (NavigationController.this.l.getMarkerManager() != null) {
                    NavigationController navigationController2 = NavigationController.this;
                    if (navigationController2.mIMarkerStateListener != null) {
                        navigationController2.l.getMarkerManager().setMarkerStateListener(NavigationController.this.mIMarkerStateListener);
                    }
                    if (NavigationController.this.cR != null) {
                        NavigationController.this.l.getMarkerManager().setLocationTimeCallBack(NavigationController.this.cR);
                    }
                    NavigationController navigationController3 = NavigationController.this;
                    if (navigationController3.mIMakerAxisZCallback != null) {
                        navigationController3.l.getMarkerManager().setAxisCallback(NavigationController.this.mIMakerAxisZCallback);
                    }
                    NavigationController.this.l.getMarkerManager().setPositionCallback(NavigationController.this);
                    NavigationController.this.l.getMarkerManager().setTrackerSessionCallback(new OnTrackerSessionCallback() { // from class: com.baidu.ar.NavigationController.10.2
                        @Override // com.baidu.ar.marker.OnTrackerSessionCallback
                        public void onSessionCallback(String str2) {
                            NavigationController.this.l.getVpsResBySessionId(str2, null);
                        }
                    });
                }
                if ((NavigationController.this.dr == NavigationType.ARCore || NavigationController.this.dr == NavigationType.AREngine) && NavigationController.this.cN != null) {
                    NavigationController.this.cN.a(NavigationController.this.l.getGLRenderer());
                    NavigationController.this.l.getMarkerManager().setEulerAngleCallback(NavigationController.this.cP);
                    NavigationController.this.cN.a(NavigationController.this.l.getMarkerManager());
                }
                NavigationController.this.d(true);
            }
        };
    }

    public void doCommand(CommandType commandType, CommandDate commandDate) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.doCommand(commandType, commandDate);
        }
    }

    public void farwayElevator() {
        kc kcVar = this.dv;
        if (kcVar != null) {
            kcVar.gW();
            ah();
        }
    }

    public MapDuMix getMapDuMixInstance() {
        if (this.l == null) {
            this.p.setUseTextureIO(true);
            this.p.setHeight(this.cC);
            this.p.setWidth(this.cB);
            MapDuMix mapDuMix = MapDuMix.getInstance(this.mContext, this.p);
            this.l = mapDuMix;
            mapDuMix.addLuaMsgListener(this);
        }
        return this.l;
    }

    @Override // com.baidu.ar.lua.LuaMsgListener
    public List<String> getMsgKeyListened() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("event_name");
        return arrayList;
    }

    public VpasManager getVpasManager() {
        if (this.cQ == null) {
            this.cQ = new VpasManager(this);
        }
        return this.cQ;
    }

    public void isDebug(boolean z) {
        i iVar = this.dG;
        if (iVar != null) {
            iVar.setDebug(z);
        }
    }

    public void loadCase(String str) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.loadCase(str, "vpas_debug_arkey");
        }
    }

    public void nearElevator() {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix == null || this.dv == null) {
            return;
        }
        mapDuMix.getMarkerManager().clearRoute();
        this.dv.ac(true);
        this.l.getMarkerManager().releaseMarker();
    }

    @Override // com.baidu.ar.baidumap.CaseStateListener
    public void onCaseCreated(boolean z, String str, String str2) {
        this.cL = z;
        if (z) {
            nc.iK();
        }
        String str3 = "profile_resource_load_time: " + (Math.abs(System.currentTimeMillis() - this.dA) / 1000.0d);
        Log.e("DuMixController", str3);
        ad();
        c(z);
        kc kcVar = this.dv;
        if (kcVar != null) {
            kcVar.onResuourceCreated();
            this.dv.cf(str3);
        }
        IMarkerStateListener iMarkerStateListener = this.mIMarkerStateListener;
        if (iMarkerStateListener != null) {
            iMarkerStateListener.onResuourceCreated();
        }
        int i = this.cM;
        if (i == 1) {
            Map<String, String> iL = nc.iL();
            iL.put("cuid", ARConfig.getCUID());
            iL.put("building_id", this.p.getBuildingId());
            StatisticApi.onEvent(StatisticConstants.EVENT_AR_VPAS_INDOOR_KEYPOINTS, iL);
            if (!this.dy || this.cS == 1) {
                clearCase();
            }
        } else if (i == 5 && this.isNight) {
            ai();
        }
        float[] fArr = this.di;
        if (fArr != null) {
            updateLocation(fArr, this.dj, this.dl);
        }
        if (this.dF != null) {
            kc kcVar2 = this.dv;
            if (kcVar2 != null) {
                kcVar2.cf("ar inner cache post routes");
            }
            postRoute(this.dF);
            this.dF = null;
        }
        f(this.dE);
        ag();
        updateMeters(this.dq);
    }

    @Override // com.baidu.ar.baidumap.CaseStateListener
    public void onCaseDestroy() {
        IMarkerStateListener iMarkerStateListener;
        kf.c("DuMixController", "onCaseDestroy");
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null && mapDuMix.getMarkerManager() != null && !this.du) {
            this.l.getMarkerManager().releaseMarker();
            kc kcVar = this.dv;
            if (kcVar != null) {
                if (!kcVar.gX()) {
                    ah();
                }
                this.dv.onCaseDestroy();
            }
        }
        if (this.du || (iMarkerStateListener = this.mIMarkerStateListener) == null) {
            return;
        }
        iMarkerStateListener.onResuourceCreated();
    }

    @Override // com.baidu.ar.fx
    public void onCreateSessionFail() {
        kc kcVar = this.dv;
        if (kcVar != null) {
            kcVar.onCreateSessionFail();
        }
    }

    @Override // com.baidu.ar.fx
    public void onCreateVpasAlgoFail() {
        kc kcVar = this.dv;
        if (kcVar != null) {
            kcVar.onCreateVpasAlgoFail();
        }
    }

    public void onDestroy() {
        String str;
        kf.b("DuMixController", "onDestroy()");
        long j = this.dk;
        if (j > 0) {
            long abs = ((float) Math.abs(j - System.currentTimeMillis())) / 1000.0f;
            HashMap hashMap = new HashMap();
            int i = this.cM;
            if (i == 3) {
                str = "3DOF";
            } else if (i == 5) {
                str = "6DOF-NPC";
            } else if (i == 6) {
                str = "3DOF-NPC";
            } else {
                if (i == 2) {
                    str = "6DOF";
                }
                hashMap.put("duration", String.valueOf(abs));
                hashMap.put("cuid", ARConfig.getCUID());
                StatisticApi.onEvent(StatisticConstants.NAVIGATION_DURATION, hashMap);
            }
            hashMap.put("type", str);
            hashMap.put("duration", String.valueOf(abs));
            hashMap.put("cuid", ARConfig.getCUID());
            StatisticApi.onEvent(StatisticConstants.NAVIGATION_DURATION, hashMap);
        }
        this.cM = -1;
        com.baidu.ar.a aVar = this.cN;
        if (aVar != null) {
            aVar.release();
            this.cN = null;
        }
        aa();
        k kVar = this.cO;
        if (kVar != null) {
            kVar.release();
            this.cO = null;
        }
        kc kcVar = this.dv;
        if (kcVar != null) {
            kcVar.gE();
            this.dv = null;
        }
        i iVar = this.dG;
        if (iVar != null) {
            iVar.Z();
        }
        this.mContext = null;
        this.mIMakerAxisZCallback = null;
        this.mIMarkerStateListener = null;
        this.cR = null;
    }

    @Override // com.baidu.ar.baidumap.CaseDownloadListener
    public void onDownloadFinish(boolean z, String str, String str2, int i, String str3) {
    }

    @Override // com.baidu.ar.baidumap.CaseDownloadListener
    public void onDownloadProgress(int i, String str) {
    }

    @Override // com.baidu.ar.k.a
    public void onDrawFrame() {
        k kVar;
        try {
            com.baidu.ar.a aVar = this.cN;
            if (aVar != null && (kVar = this.cO) != null) {
                if (this.mMapDuMixSetuped) {
                    int i = this.cK;
                    if (i < 5) {
                        aVar.onRenderStarted(System.currentTimeMillis());
                        this.cN.onFrameAvailable(null);
                        this.cK++;
                    } else if (i == 5) {
                        kVar.g(true);
                    }
                } else {
                    aVar.onRenderStarted(System.currentTimeMillis());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.ar.lua.LuaMsgListener
    public void onLuaMessage(HashMap<String, Object> hashMap) {
        HashMap hashMap2;
        HashMap<String, Object> hashMap3;
        OnReciveShakeListener onReciveShakeListener;
        HashMap<String, Object> hashMap4;
        HashMap hashMap5;
        kc kcVar;
        OnReciveCrossStreetFormLuaListener onReciveCrossStreetFormLuaListener;
        OnReciveCrossStreetFormLuaListener onReciveCrossStreetFormLuaListener2;
        OnReciveLuaListener onReciveLuaListener = this.dd;
        if (onReciveLuaListener != null) {
            onReciveLuaListener.onReciveMsg(hashMap);
        }
        if (hashMap.containsKey("event_name")) {
            String str = (String) hashMap.get("event_name");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if ("__ar_navi_cross_street_show".equals(str) && (onReciveCrossStreetFormLuaListener2 = this.da) != null) {
                onReciveCrossStreetFormLuaListener2.onReciveCrossStreetShow(hashMap);
            }
            if ("__ar_navi_cross_street_hide".equals(str) && (onReciveCrossStreetFormLuaListener = this.da) != null) {
                onReciveCrossStreetFormLuaListener.onReciveCrossStreetHide(hashMap);
            }
            if ("__log_route_shape_point".equals(str)) {
                HashMap<String, Object> hashMap6 = (HashMap) hashMap.get("event_data");
                OnReciveLatLngFormLuaListener onReciveLatLngFormLuaListener = this.cZ;
                if (onReciveLatLngFormLuaListener != null) {
                    onReciveLatLngFormLuaListener.onReciveLatLngData(hashMap6);
                }
            }
            if ("__ar_navi_foot_bridge".equals(str)) {
                HashMap<String, Object> hashMap7 = (HashMap) hashMap.get("event_data");
                OnReciveFootBridgeFormLuaListener onReciveFootBridgeFormLuaListener = this.dc;
                if (onReciveFootBridgeFormLuaListener != null) {
                    onReciveFootBridgeFormLuaListener.onReciveFootBridge(hashMap7);
                }
            }
            if ("__ar_navi_tunnel".equals(str)) {
                HashMap<String, Object> hashMap8 = (HashMap) hashMap.get("event_data");
                OnReciveTunnelFormLuaListener onReciveTunnelFormLuaListener = this.db;
                if (onReciveTunnelFormLuaListener != null) {
                    onReciveTunnelFormLuaListener.onReciveTunnel(hashMap8);
                }
            }
            if (NavigationLuaField.NAVI_LUA_NPC_UI_UPDATE_MSG.equals(str) && (hashMap5 = (HashMap) hashMap.get("event_data")) != null && hashMap5.keySet().size() > 0) {
                String str2 = (String) hashMap5.get(NavigationLuaField.NAVI_LUA_NPC_BG_PATH_MSG);
                String str3 = (String) hashMap5.get(NavigationLuaField.NAVI_LUA_NPC_NPC_ICON_MSG);
                String str4 = (String) hashMap5.get(NavigationLuaField.NAVI_LUA_NPC_DIR_ICON_MSG);
                String str5 = (String) hashMap5.get(NavigationLuaField.NAVI_LUA_NPC_NPC_TXT_MSG);
                ARResourceManager aRResourceManager = new ARResourceManager(this.mContext);
                StringBuilder sb = new StringBuilder();
                sb.append(aRResourceManager.getCaseDirPath(this.cE));
                String str6 = File.separator;
                sb.append(str6);
                String sb2 = sb.toString();
                NavigationNpc navigationNpc = new NavigationNpc();
                navigationNpc.setDirPath(sb2 + str6 + str4);
                navigationNpc.setBGPath(sb2 + str6 + str2);
                navigationNpc.setIconPath(sb2 + str6 + str3);
                navigationNpc.setTitleTxt(str5);
                int i = this.cM;
                if ((i == 5 || i == 6) && (kcVar = this.dv) != null) {
                    kcVar.a(true, navigationNpc);
                }
            }
            if (NavigationLuaField.NAVI_LUA_NPC_2D_MAP_STATE_UPDATE_MSG.equals(str) && (hashMap4 = (HashMap) hashMap.get("event_data")) != null && hashMap4.keySet().size() > 0) {
                if ("open".equals((String) hashMap4.get(NavigationLuaField.NAVI_LUA_NPC_NEW_STATE))) {
                    OnRecive2DMapPlaneListener onRecive2DMapPlaneListener = this.dg;
                    if (onRecive2DMapPlaneListener != null) {
                        onRecive2DMapPlaneListener.on2DMapPlaneShow(hashMap4);
                    }
                } else {
                    OnRecive2DMapPlaneListener onRecive2DMapPlaneListener2 = this.dg;
                    if (onRecive2DMapPlaneListener2 != null) {
                        onRecive2DMapPlaneListener2.on2DMapPlaneHide(hashMap4);
                    }
                }
            }
            if (NavigationLuaField.NAVI_LUA_NPC_MESSAGE_NATIVE_SHAKE_MSG.equals(str) && (hashMap3 = (HashMap) hashMap.get("event_data")) != null && hashMap3.keySet().size() > 0 && NavigationLuaField.NAVI_LUA_NPC_SHAKE.equals((String) hashMap3.get("message")) && (onReciveShakeListener = this.dh) != null) {
                onReciveShakeListener.onShake(hashMap3);
            }
            if (!NavigationLuaField.NAVI_LUA_NPC_MESSAGE_DISTANCE_BY_USER.equals(str) || (hashMap2 = (HashMap) hashMap.get("event_data")) == null || hashMap2.keySet().size() <= 0) {
                return;
            }
            float floatValue = ((Float) hashMap2.get(xOxOoo.f15470o00)).floatValue();
            kc kcVar2 = this.dv;
            if (kcVar2 != null) {
                kcVar2.e(floatValue);
            }
        }
    }

    public void onPause() {
        this.dn = true;
        kf.b("DuMixController", "onPause()");
        com.baidu.ar.a aVar = this.cN;
        if (aVar != null) {
            aVar.pause();
        }
        this.dE = false;
        kc kcVar = this.dv;
        if (kcVar != null) {
            kcVar.onPause();
        }
        this.dD = true;
        i iVar = this.dG;
        if (iVar != null) {
            iVar.onPause();
        }
        af();
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            if (this.du) {
                mapDuMix.getMarkerManager().resetNavigationController();
                this.l.cancelAll();
            }
            clearCase();
            this.dp = 0;
            this.l.pause();
        }
    }

    @Override // com.baidu.ar.fx
    public void onPositionSuccess(int i) {
        kc kcVar = this.dv;
        if (kcVar != null) {
            kcVar.W(i);
        }
        this.dy = true;
    }

    @Override // com.baidu.ar.baidumap.CaseDownloadListener
    public void onRefused() {
        kf.cl("onRefused");
    }

    public void onResume() {
        kc kcVar;
        NavigationConfiguration navigationConfiguration;
        if (this.dn) {
            this.dm = true;
        }
        kf.b("DuMixController", "nav onResume()");
        com.baidu.ar.a aVar = this.cN;
        if (aVar != null) {
            aVar.resume();
        }
        i iVar = this.dG;
        if (iVar != null) {
            iVar.onResume();
        }
        kc kcVar2 = this.dv;
        if (kcVar2 != null) {
            kcVar2.onResume();
        }
        if (this.l == null) {
            return;
        }
        nc.iF();
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.resume();
        }
        int i = this.cM;
        if (i == 2) {
            HashMap hashMap = new HashMap();
            hashMap.put("cuid", ARConfig.getCUID());
            hashMap.put("type", "6DOF");
            StatisticApi.onEvent(StatisticConstants.NAVIGATION_RESUME, hashMap);
            if (this.dp != 0) {
                return;
            }
            this.dp = 1;
            runWithInitConfiguration(NavigationConfiguration.VIO, this.ds);
        } else {
            if (i == 5) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("cuid", ARConfig.getCUID());
                hashMap2.put("type", "6DOF-NPC");
                StatisticApi.onEvent(StatisticConstants.NAVIGATION_RESUME, hashMap2);
                if (this.dp != 0) {
                    return;
                }
                this.dp = 1;
                navigationConfiguration = NavigationConfiguration.NPC_VIO;
            } else {
                if (i != 6) {
                    if (i == 3) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("type", "3DOF");
                        hashMap3.put("cuid", ARConfig.getCUID());
                        StatisticApi.onEvent(StatisticConstants.NAVIGATION_RESUME, hashMap3);
                        runWithInitConfiguration(NavigationConfiguration.IMU, this.ds);
                        return;
                    }
                    if ((i != 1 && i != 4) || (kcVar = this.dv) == null || kcVar.gX()) {
                        return;
                    }
                    this.l.getMarkerManager().createSession();
                    return;
                }
                HashMap hashMap4 = new HashMap();
                hashMap4.put("cuid", ARConfig.getCUID());
                hashMap4.put("type", "3DOF-NPC");
                StatisticApi.onEvent(StatisticConstants.NAVIGATION_RESUME, hashMap4);
                if (this.dp != 0) {
                    return;
                }
                this.dp = 1;
                navigationConfiguration = NavigationConfiguration.NPC_IMU;
            }
            runWithInitConfiguration(navigationConfiguration, this.ds, this.cE);
        }
        this.dp = -1;
    }

    @Override // com.baidu.ar.k.a
    public void onSurfaceChanged(int i, int i2) {
        Log.d("DuMixController", "onSurfaceChanged width * height = " + i + " * " + i2);
        getMapDuMixInstance().changeOutputSize(i, i2);
    }

    @Override // com.baidu.ar.k.a
    public void onSurfaceCreated(Texture texture) {
        Log.d("DuMixController", "surfaceCreated cameraTexture.getId() = " + texture.getId());
        com.baidu.ar.a aVar = this.cN;
        if (aVar != null) {
            aVar.a(texture);
        }
    }

    public boolean onTouch(MotionEvent motionEvent) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            return mapDuMix.onTouch(null, motionEvent);
        }
        return false;
    }

    @Override // com.baidu.ar.OnFrmeTrackingStateCallback
    public void onTrackingState(int i) {
        OnFrmeTrackingStateCallback onFrmeTrackingStateCallback = this.cY;
        if (onFrmeTrackingStateCallback != null) {
            onFrmeTrackingStateCallback.onTrackingState(i);
        }
        updateTrackingState(i);
    }

    @Override // com.baidu.ar.fx
    public void onVpasAlgoStatePrint(int i, int i2, float f) {
        kc kcVar = this.dv;
        if (kcVar != null) {
            kcVar.onVpasAlgoStatePrint(i, i2, f);
        }
    }

    @Override // com.baidu.ar.fx
    public void onVpasLocationSuccess() {
        kc kcVar = this.dv;
        if (kcVar != null) {
            kcVar.hc();
        }
    }

    @Override // com.baidu.ar.fx
    public void onVpasSendFrame() {
        kc kcVar = this.dv;
        if (kcVar != null) {
            kcVar.gI();
        }
    }

    @Override // com.baidu.ar.fx
    public void onVpasTrackingState(int i) {
        kc kcVar = this.dv;
        if (kcVar != null) {
            int i2 = this.cM;
            if (i2 == 2 || i2 == 5) {
                kcVar.onVpasTrackingState(i);
            }
        }
    }

    public void postNavigationRoute(List<Segments> list) {
        String str;
        if (this.l == null) {
            Log.e("DuMixController", "loadCase mMapDuMix = null");
            return;
        }
        if (list != null && list.size() > 0) {
            this.cX.clear();
            this.cX.addAll(list);
        }
        this.l.getMarkerManager().postNavigationRoute(list);
        kc kcVar = this.dv;
        if (kcVar != null) {
            kcVar.Z(true);
        }
        if (this.dH) {
            int i = this.cM;
            if (i == 3 || i == 2 || i == 5 || i == 6) {
                this.dH = false;
                HashMap hashMap = new HashMap();
                hashMap.put("duration", String.valueOf(Math.abs(System.currentTimeMillis() - this.dC) / 1000.0d));
                int i2 = this.cM;
                if (i2 == 5) {
                    str = "6DOF-NPC";
                } else if (i2 == 6) {
                    str = "3DOF-NPC";
                } else {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            str = "3DOF";
                        }
                        StatisticApi.onEvent(StatisticConstants.EVENT_AR_VPAS_NAVI_INIT_SUCCESS, hashMap);
                    }
                    str = "6DOF";
                }
                hashMap.put("type", str);
                StatisticApi.onEvent(StatisticConstants.EVENT_AR_VPAS_NAVI_INIT_SUCCESS, hashMap);
            }
        }
    }

    public boolean postRoute(List<double[]> list) {
        kc kcVar = this.dv;
        if (kcVar != null) {
            kcVar.Z(true);
            this.dv.cf("BaiduMap invoke Post Route!");
        }
        if (this.l != null && this.cL && getVpasManager() != null) {
            getVpasManager().postRouteByList(list);
            return true;
        }
        kf.c("DuMixController", "postRoute: isCaseCreated is false need to cache!!");
        this.dF = list;
        return false;
    }

    public void reLocationByResourceUnLoad() {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.getMarkerManager().releaseMarker();
            ah();
            kc kcVar = this.dv;
            if (kcVar != null) {
                kcVar.choseFloor();
            }
        }
    }

    public boolean resourceIsCreate() {
        return this.cL;
    }

    public void runWithInitConfiguration(NavigationConfiguration navigationConfiguration, PositioningModuleAddListener positioningModuleAddListener) {
        runWithInitConfiguration(navigationConfiguration, positioningModuleAddListener, null);
    }

    public void senMessageToAR(Map<String, Object> map) {
        Map map2;
        if (map != null) {
            try {
                if (map.keySet().size() > 0) {
                    String str = (String) map.get("message_name");
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if ("update_presenttime".equals(str)) {
                        String str2 = (String) map.get("message_value");
                        if (!TextUtils.isEmpty(str2)) {
                            if (NavigationLuaField.NAVI_LUA_NPC_LAUNCH_NIGHT.equals(str2)) {
                                this.isNight = true;
                                ai();
                            } else {
                                this.isNight = false;
                                kf.b("DuMixController", "night model");
                            }
                        }
                    }
                    if (!"right_button_position".equals(str) || (map2 = (Map) map.get("message_value")) == null || map2.keySet().size() <= 0) {
                        return;
                    }
                    int intValue = ((Integer) map2.get(BNMapController.BNMapConfigParams.KEY_SCREEN_WIDTH)).intValue();
                    int intValue2 = ((Integer) map2.get(BNMapController.BNMapConfigParams.KEY_SCREEN_HEIGHT)).intValue();
                    int intValue3 = ((Integer) map2.get("button_x")).intValue();
                    int intValue4 = ((Integer) map2.get("button_y")).intValue();
                    kc kcVar = this.dv;
                    if (kcVar != null) {
                        kcVar.d(intValue, intValue2, intValue3, intValue4);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                kf.b("DuMixController", th.getMessage());
            }
        }
    }

    public void setARRenderFpsCallback(a aVar) {
        this.dz = aVar;
    }

    public void setBlueToothOpen(boolean z) {
        this.dJ = z;
    }

    public void setEulerAngleCalback(OnEulerAngleCallback onEulerAngleCallback) {
        this.cP = onEulerAngleCallback;
    }

    public void setFrameAvailableListener(IMockFrameAvailable iMockFrameAvailable) {
        i iVar = this.dG;
        if (iVar != null) {
            iVar.setFrameAvailableListener(iMockFrameAvailable);
        }
    }

    public void setIMUSourceTypeIsLocal() {
        kc kcVar = this.dv;
        if (kcVar != null) {
            kcVar.Y(false);
        }
    }

    public void setLocationTimeCallBack(IMarkerLocationTimeCallBack iMarkerLocationTimeCallBack) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null && mapDuMix.getMarkerManager() != null) {
            this.l.getMarkerManager().setLocationTimeCallBack(iMarkerLocationTimeCallBack);
        }
        this.cR = iMarkerLocationTimeCallBack;
    }

    public void setMapIndoorParams(double[] dArr, String str, String str2) {
        this.p.setInitGPSInfo(dArr);
        this.p.setBuildingId(str);
        this.p.setCuid(str2);
    }

    public void setMarkerAxisCallback(IMakerAxisCallback iMakerAxisCallback) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix == null || mapDuMix.getMarkerManager() == null) {
            this.mIMakerAxisZCallback = iMakerAxisCallback;
        } else {
            this.l.getMarkerManager().setAxisCallback(iMakerAxisCallback);
        }
    }

    public void setMarkerStateListener(IMarkerStateListener iMarkerStateListener) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null && mapDuMix.getMarkerManager() != null) {
            this.l.getMarkerManager().setMarkerStateListener(iMarkerStateListener);
        }
        this.mIMarkerStateListener = iMarkerStateListener;
        if (this.du || iMarkerStateListener == null) {
            return;
        }
        iMarkerStateListener.onResuourceCreated();
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        this.dw.setOnClickListener(onClickListener);
    }

    public void setOnRecive2DMapPlaneListener(OnRecive2DMapPlaneListener onRecive2DMapPlaneListener) {
        this.dg = onRecive2DMapPlaneListener;
    }

    public void setOnReciveCrossStreetFormLuaListener(OnReciveCrossStreetFormLuaListener onReciveCrossStreetFormLuaListener) {
        this.da = onReciveCrossStreetFormLuaListener;
    }

    public void setOnReciveFootBridgeFormLuaListener(OnReciveFootBridgeFormLuaListener onReciveFootBridgeFormLuaListener) {
        this.dc = onReciveFootBridgeFormLuaListener;
    }

    public void setOnReciveLatLngFormLuaListener(OnReciveLatLngFormLuaListener onReciveLatLngFormLuaListener) {
        this.cZ = onReciveLatLngFormLuaListener;
    }

    public void setOnReciveLuaListener(OnReciveLuaListener onReciveLuaListener) {
        this.dd = onReciveLuaListener;
    }

    public void setOnReciveShakeListener(OnReciveShakeListener onReciveShakeListener) {
        this.dh = onReciveShakeListener;
    }

    public void setOnReciveTunnelFormLuaListener(OnReciveTunnelFormLuaListener onReciveTunnelFormLuaListener) {
        this.db = onReciveTunnelFormLuaListener;
    }

    public void setOnSetupComplete(OnSetupComplete onSetupComplete) {
        this.de = onSetupComplete;
    }

    public void setTrackingStateCallback(OnFrmeTrackingStateCallback onFrmeTrackingStateCallback) {
        this.cY = onFrmeTrackingStateCallback;
    }

    public void startReverseTransformCalculation(int i, final OnReverseTransformCalculationListener onReverseTransformCalculationListener, OnCoordinateBoundListener onCoordinateBoundListener) {
        this.df = onCoordinateBoundListener;
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null && mapDuMix.getMarkerManager() != null) {
            this.l.getMarkerManager().setCoordinateBoundListener(this.df);
        }
        nm nmVar = this.dt;
        if (nmVar != null) {
            nmVar.iR();
            this.dt = null;
        }
        nm nmVar2 = new nm(i);
        this.dt = nmVar2;
        nmVar2.a(new nm.a() { // from class: com.baidu.ar.NavigationController.1
            @Override // com.baidu.ar.nm.a
            public void onTick() {
                if (NavigationController.this.l == null || NavigationController.this.l.getMarkerManager() == null) {
                    return;
                }
                float[] geolocationByTransform = NavigationController.this.l.getMarkerManager().getGeolocationByTransform();
                OnReverseTransformCalculationListener onReverseTransformCalculationListener2 = onReverseTransformCalculationListener;
                if (onReverseTransformCalculationListener2 != null) {
                    onReverseTransformCalculationListener2.onCalculation(geolocationByTransform[0], geolocationByTransform[1]);
                }
            }
        });
        this.dt.startTimer();
    }

    public void stopReverseTransformCalculation() {
        nm nmVar = this.dt;
        if (nmVar != null) {
            nmVar.iR();
            this.dt = null;
        }
    }

    public void takePicture(String str, PhotoCallback photoCallback) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null) {
            mapDuMix.takePicture(str, photoCallback);
        }
    }

    public void test() {
        this.l.getMarkerManager().test();
    }

    public void testResetButtonPixel(int i, int i2, int i3, int i4) {
        kc kcVar = this.dv;
        if (kcVar != null) {
            kcVar.d(i, i2, i3, i4);
        }
    }

    public boolean tryBindingCoordinate() {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix == null || mapDuMix.getMarkerManager() == null) {
            return false;
        }
        return this.l.getMarkerManager().bindingCoordinate();
    }

    public void updateAccelerometer(float[] fArr) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix == null || mapDuMix.getMarkerManager() == null || fArr == null || fArr.length <= 0) {
            return;
        }
        this.l.getMarkerManager().updateMockAccelerometer(fArr[0], fArr[1], fArr[2]);
    }

    public void updateAuxiliaryLPositions(TranslationPrior translationPrior) {
        kf.c("DuMixController", "postRoute");
        MapDuMix mapDuMix = this.l;
        if (mapDuMix == null || mapDuMix.getMarkerManager() == null || translationPrior == null) {
            return;
        }
        translationPrior.setTime(System.currentTimeMillis());
        translationPrior.setConfidence(1.0f);
        this.dI = translationPrior;
        translationPrior.setType(this.dJ ? 4 : 0);
        this.l.getMarkerManager().updateTranslationPrior(this.dI);
        kc kcVar = this.dv;
        if (kcVar != null) {
            kcVar.updateAuxiliaryLPositions(this.dI);
        }
    }

    public void updateHeading(float f, float f2) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix == null || mapDuMix.getMarkerManager() == null) {
            return;
        }
        this.l.getMarkerManager().updateHeading(f, f2);
    }

    public void updateImuMatrix(float[] fArr) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix == null || mapDuMix.getMarkerManager() == null) {
            return;
        }
        this.l.getMarkerManager().updateImuData(fArr);
    }

    public void updateLocation(float[] fArr, int i, boolean z) {
        kf.b("DuMixController", "updateLocation");
        if (fArr != null) {
            this.di = new float[]{fArr[0], fArr[1]};
            this.dj = i;
            this.dl = z;
        }
        MapDuMix mapDuMix = this.l;
        if (mapDuMix != null && mapDuMix.getMarkerManager() != null) {
            this.l.getMarkerManager().updateLocation(fArr, i, z);
        }
        kc kcVar = this.dv;
        if (kcVar != null) {
            kcVar.hd();
        }
    }

    public void updateMeters(int i) {
        kf.b("DuMixController", "updateMeters");
        this.dq = i;
        MapDuMix mapDuMix = this.l;
        if (mapDuMix == null || i <= 0) {
            return;
        }
        mapDuMix.getMarkerManager().updateMeters(i);
    }

    public void updateTrackingState(int i) {
        kc kcVar;
        kc kcVar2 = this.dv;
        if (kcVar2 != null) {
            kcVar2.aa(i == 0);
        }
        int i2 = this.cS;
        if (i2 != i) {
            if (i2 == 0 && i == 1 && (kcVar = this.dv) != null && this.cM == 5) {
                kcVar.a(false, (NavigationNpc) null);
            }
            if (this.cS == 1 && i == 0) {
                int i3 = this.cM;
                if (i3 == 2 || i3 == 5) {
                    if (!this.dm && !this.dn && !this.f0do && tryBindingCoordinate()) {
                        ad();
                    }
                    this.dm = false;
                    this.dn = false;
                    this.f0do = false;
                }
            } else {
                clearNavigationRoute();
            }
            this.cS = i;
        }
    }

    public void updateTrans() {
        TranslationPrior translationPrior = new TranslationPrior();
        translationPrior.setBuildingId("1");
        translationPrior.setFloorID(ProductManager.f20640xo0x);
        translationPrior.setType(4);
        translationPrior.setConfidence(1.0f);
        translationPrior.setPrecision(1.0f);
        float[] fArr = new float[12];
        fArr[0] = 116.326324f;
        fArr[1] = 39.7882f;
        translationPrior.setCoordinate(fArr);
        updateAuxiliaryLPositions(translationPrior);
    }

    public void updateTransformData(int i, float[] fArr) {
        MapDuMix mapDuMix = this.l;
        if (mapDuMix == null || mapDuMix.getMarkerManager() == null) {
            return;
        }
        this.l.getMarkerManager().updateTransformData(i, fArr);
    }

    public void updateUIByClearRoute() {
        kc kcVar = this.dv;
        if (kcVar == null || !this.dB) {
            return;
        }
        kcVar.clearRoute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        this.cU = z;
        ae();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z) {
        this.cV = z;
        ae();
    }

    @Override // com.baidu.ar.k.a
    public void onSurfaceCreated(Texture texture, SurfaceTexture surfaceTexture, int i, int i2) {
        Log.d("DuMixController", "surfaceCreated cameraTexture.getId() = " + texture.getId());
        a(texture, surfaceTexture, i, i2);
        Log.d("DuMixController", " setupMapDuMix width:" + i + ", height:" + i2);
    }

    public void runWithInitConfiguration(final NavigationConfiguration navigationConfiguration, PositioningModuleAddListener positioningModuleAddListener, String str) {
        MapDuMix mapDuMix;
        kc kcVar;
        MapDuMix mapDuMix2;
        String navigation3DofARKey;
        MapDuMix mapDuMix3;
        MapDuMix mapDuMix4;
        this.dH = true;
        NavigationType selectedNavigationType = DeviceSupportAbility.getSelectedNavigationType();
        NavigationConfiguration navigationConfiguration2 = NavigationConfiguration.VPAS;
        if (navigationConfiguration == navigationConfiguration2 && selectedNavigationType == NavigationType.ARPedometer) {
            navigationConfiguration = NavigationConfiguration.ARPedometer;
        }
        if ((navigationConfiguration == null || (mapDuMix4 = this.l) == null || mapDuMix4.getMarkerManager() == null) && positioningModuleAddListener != null) {
            positioningModuleAddListener.addPositioningResult(false);
            return;
        }
        this.cE = str;
        this.ds = positioningModuleAddListener;
        this.dk = System.currentTimeMillis();
        if (this.di != null && (mapDuMix3 = this.l) != null) {
            mapDuMix3.getMarkerManager().updateLocation(this.di, this.dj, this.dl);
        }
        if (!this.dD) {
            if (!this.du || (mapDuMix = this.l) == null) {
                return;
            }
            if (navigationConfiguration == NavigationConfiguration.NPC_VIO) {
                this.cM = 5;
                if (TextUtils.isEmpty(this.cE)) {
                    mapDuMix2 = this.l;
                    navigation3DofARKey = ARConfig.getNavigation6DofARKey();
                    mapDuMix2.loadCase(navigation3DofARKey);
                    return;
                }
                mapDuMix2 = this.l;
                navigation3DofARKey = this.cE;
                mapDuMix2.loadCase(navigation3DofARKey);
                return;
            }
            if (navigationConfiguration == NavigationConfiguration.VIO) {
                this.cM = 2;
                mapDuMix.loadCase(ARConfig.getNavigation6DofARKey());
                kcVar = this.dv;
                if (kcVar == null) {
                    return;
                }
            } else {
                if (navigationConfiguration == NavigationConfiguration.NPC_IMU) {
                    this.cM = 6;
                    if (TextUtils.isEmpty(this.cE)) {
                        mapDuMix2 = this.l;
                        navigation3DofARKey = ARConfig.getNavigation3DofARKey();
                        mapDuMix2.loadCase(navigation3DofARKey);
                        return;
                    }
                    mapDuMix2 = this.l;
                    navigation3DofARKey = this.cE;
                    mapDuMix2.loadCase(navigation3DofARKey);
                    return;
                }
                if (navigationConfiguration != NavigationConfiguration.IMU) {
                    return;
                }
                this.cM = 3;
                mapDuMix.loadCase(ARConfig.getNavigation3DofARKey());
                kcVar = this.dv;
                if (kcVar == null) {
                    return;
                }
            }
            kcVar.a(false, (NavigationNpc) null);
            return;
        }
        this.dD = false;
        NavigationConfiguration navigationConfiguration3 = NavigationConfiguration.VIO;
        if (navigationConfiguration == navigationConfiguration3 || navigationConfiguration == NavigationConfiguration.NPC_VIO) {
            long currentTimeMillis = System.currentTimeMillis();
            this.dA = currentTimeMillis;
            this.dC = currentTimeMillis;
            HashMap hashMap = new HashMap();
            hashMap.put("type", navigationConfiguration == navigationConfiguration3 ? "6DOF" : "6DOF-NPC");
            hashMap.put("cuid", ARConfig.getCUID());
            StatisticApi.onEvent(StatisticConstants.NAVIGATION_START, hashMap);
            this.cM = 2;
            if (navigationConfiguration == NavigationConfiguration.NPC_VIO) {
                this.cM = 5;
            }
            MapDuMix mapDuMix5 = this.l;
            if (mapDuMix5 != null) {
                mapDuMix5.getMarkerManager().runAREngineWithNavigation(new PositioningModuleAddListener() { // from class: com.baidu.ar.NavigationController.11
                    @Override // com.baidu.ar.marker.PositioningModuleAddListener
                    public void addPositioningResult(boolean z) {
                        MapDuMix mapDuMix6;
                        String navigation6DofARKey;
                        if (NavigationController.this.ds != null) {
                            NavigationController.this.ds.addPositioningResult(z);
                            Log.e("DuMixController", "Run VIO Callback Yes! And Result is:" + z);
                        }
                        if (NavigationController.this.dv != null) {
                            NavigationController.this.dv.ad(z);
                        }
                        if (navigationConfiguration == NavigationConfiguration.NPC_VIO) {
                            if (NavigationController.this.l != null) {
                                if (TextUtils.isEmpty(NavigationController.this.cE)) {
                                    mapDuMix6 = NavigationController.this.l;
                                    navigation6DofARKey = ARConfig.getNavigation6DofARKey();
                                } else {
                                    mapDuMix6 = NavigationController.this.l;
                                    navigation6DofARKey = NavigationController.this.cE;
                                }
                                mapDuMix6.loadCase(navigation6DofARKey);
                            }
                            if (z) {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("type", "6DOF-NPC");
                                hashMap2.put("cuid", ARConfig.getCUID());
                                StatisticApi.onEvent(StatisticConstants.NAVIGATION_START_SUCCESS, hashMap2);
                            }
                        } else if (NavigationController.this.l != null) {
                            NavigationController.this.l.loadCase(ARConfig.getNavigation6DofARKey());
                            if (NavigationController.this.dv != null) {
                                NavigationController.this.dv.a(false, (NavigationNpc) null);
                            }
                        }
                        if (z) {
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("cuid", ARConfig.getCUID());
                            if (navigationConfiguration == NavigationConfiguration.VIO) {
                                hashMap3.put("type", "6DOF");
                            } else {
                                hashMap3.put("type", "6DOF-NPC");
                            }
                            StatisticApi.onEvent(StatisticConstants.NAVIGATION_START_SUCCESS, hashMap3);
                        }
                    }
                });
                return;
            }
            return;
        }
        if (navigationConfiguration == navigationConfiguration2) {
            this.cM = 1;
            this.dA = System.currentTimeMillis();
            this.l.getMarkerManager().runVpasWithNavigation(new PositioningModuleAddListener() { // from class: com.baidu.ar.NavigationController.2
                @Override // com.baidu.ar.marker.PositioningModuleAddListener
                public void addPositioningResult(boolean z) {
                    NavigationController.this.dB = z;
                    Log.e("DuMixController", "Run Vpas Callback Yes! And Result is:" + z);
                    NavigationController.this.e(true);
                    if (NavigationController.this.dv != null) {
                        NavigationController.this.dv.ad(z);
                    }
                    if (NavigationController.this.ds != null) {
                        NavigationController.this.ds.addPositioningResult(z);
                    }
                }
            });
            return;
        }
        NavigationConfiguration navigationConfiguration4 = NavigationConfiguration.IMU;
        if (navigationConfiguration == navigationConfiguration4 || navigationConfiguration == NavigationConfiguration.NPC_IMU) {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.dA = currentTimeMillis2;
            this.dC = currentTimeMillis2;
            HashMap hashMap2 = new HashMap();
            hashMap2.put("type", navigationConfiguration == navigationConfiguration4 ? "3DOF" : "3DOF-NPC");
            hashMap2.put("cuid", ARConfig.getCUID());
            StatisticApi.onEvent(StatisticConstants.NAVIGATION_START, hashMap2);
            this.ds = positioningModuleAddListener;
            this.l.getMarkerManager().runImuWithNavigation(new PositioningModuleAddListener() { // from class: com.baidu.ar.NavigationController.3
                @Override // com.baidu.ar.marker.PositioningModuleAddListener
                public void addPositioningResult(boolean z) {
                    NavigationController.this.e(z);
                    if (NavigationController.this.dv != null) {
                        NavigationController.this.dv.ad(z);
                    }
                    if (navigationConfiguration == NavigationConfiguration.NPC_IMU) {
                        if (z) {
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("type", "3DOF-NPC");
                            hashMap3.put("cuid", ARConfig.getCUID());
                            StatisticApi.onEvent(StatisticConstants.NAVIGATION_START_SUCCESS, hashMap3);
                        }
                        NavigationController.this.cM = 6;
                        if (NavigationController.this.dG != null) {
                            NavigationController.this.dG.b(NavigationController.this.cE, z);
                        }
                    } else {
                        NavigationController.this.cM = 3;
                        if (NavigationController.this.l != null) {
                            NavigationController.this.l.loadCase(ARConfig.getNavigation3DofARKey());
                            if (NavigationController.this.dv != null) {
                                NavigationController.this.dv.a(false, (NavigationNpc) null);
                            }
                        }
                    }
                    if (z) {
                        HashMap hashMap4 = new HashMap();
                        if (navigationConfiguration == NavigationConfiguration.IMU) {
                            hashMap4.put("type", "3DOF");
                        } else {
                            hashMap4.put("type", "3DOF-NPC");
                        }
                        hashMap4.put("cuid", ARConfig.getCUID());
                        StatisticApi.onEvent(StatisticConstants.NAVIGATION_START_SUCCESS, hashMap4);
                    }
                }
            });
            return;
        }
        if (navigationConfiguration == NavigationConfiguration.ARPedometer) {
            this.dA = System.currentTimeMillis();
            if (!this.du) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("type", "ARPEDOMETER");
                hashMap3.put("cuid", ARConfig.getCUID());
                StatisticApi.onEvent(StatisticConstants.NAVIGATION_START, hashMap3);
            }
            this.cM = 4;
            this.ds = positioningModuleAddListener;
            kc kcVar2 = this.dv;
            if (kcVar2 != null) {
                kcVar2.gV();
            }
            PositioningModuleAddListener positioningModuleAddListener2 = this.ds;
            if (positioningModuleAddListener2 != null) {
                positioningModuleAddListener2.addPositioningResult(true);
            }
            this.l.getMarkerManager().runPedometerWithNavigation(new PositioningModuleAddListener() { // from class: com.baidu.ar.NavigationController.4
                @Override // com.baidu.ar.marker.PositioningModuleAddListener
                public void addPositioningResult(boolean z) {
                    NavigationController.this.e(z);
                    if (z && !NavigationController.this.du) {
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("type", "ARPEDOMETER");
                        hashMap4.put("cuid", ARConfig.getCUID());
                        StatisticApi.onEvent(StatisticConstants.NAVIGATION_START_SUCCESS, hashMap4);
                    }
                    if (NavigationController.this.dv != null) {
                        NavigationController.this.dv.ad(z);
                    }
                }
            });
        }
    }

    private void c(boolean z) {
        this.cT = z;
        ae();
    }

    private void a(Texture texture, SurfaceTexture surfaceTexture, int i, int i2) {
        this.p.setShareContext(EGL14.eglGetCurrentContext());
        this.p.setUseTextureIO(true);
        DuMixInput duMixInput = new DuMixInput(texture, this.cB, this.cC);
        duMixInput.setCameraInput(true);
        duMixInput.setFrontCamera(false);
        surfaceTexture.setOnFrameAvailableListener(this.cN);
        DuMixOutput duMixOutput = new DuMixOutput(surfaceTexture, i, i2);
        getMapDuMixInstance();
        this.l.addFrameRenderListener(this.cN);
        this.l.setup(duMixInput, duMixOutput, createMapDuMixCallback());
        this.l.addLuaMsgListener(this);
    }
}
