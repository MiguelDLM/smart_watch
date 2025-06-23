package com.baidu.ar.baidumap;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.ar.ARType;
import com.baidu.ar.DefaultParams;
import com.baidu.ar.DefinedLuaListener;
import com.baidu.ar.DuMixCallback;
import com.baidu.ar.DuMixController;
import com.baidu.ar.DuMixErrorType;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.ability.AbilityType;
import com.baidu.ar.arrender.FrameRenderListener;
import com.baidu.ar.arrender.IARRenderer;
import com.baidu.ar.arrender.IGLRenderer;
import com.baidu.ar.baidumap.bean.CommandDate;
import com.baidu.ar.baidumap.bean.CommandType;
import com.baidu.ar.baidumap.bean.VpasResource;
import com.baidu.ar.bean.Watermark;
import com.baidu.ar.by;
import com.baidu.ar.bz;
import com.baidu.ar.ca;
import com.baidu.ar.cb;
import com.baidu.ar.content.IARCaseInfo;
import com.baidu.ar.cv;
import com.baidu.ar.kf;
import com.baidu.ar.km;
import com.baidu.ar.kr;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.marker.IMarker;
import com.baidu.ar.photo.PhotoCallback;
import com.baidu.ar.record.IRecord;
import com.baidu.ar.record.RecordCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class MapDuMix implements CaseDownloadListener, IMapDuMix, LuaMsgListener, IRecord {
    private static volatile MapDuMix lQ;
    private DuMixController lF;
    private MapDuMixCallback lJ;
    private ILocationService lK;
    private bz lL;
    private String lM;
    private a lN;
    private VpasResource lO;
    private boolean lP;
    private CaseStateListener lx;
    private Context mContext;
    private MapDuMixParams p;
    private by v;

    /* loaded from: classes7.dex */
    public interface a {
        void onCaseQueryResult(IARCaseInfo iARCaseInfo);
    }

    private MapDuMix(Context context, MapDuMixParams mapDuMixParams) {
        boolean b = b(context, "libdumixar.so");
        this.lP = b;
        if (!b) {
            kf.b("MapDuMix", "MapDuMix create error!!! As libEglCore.so not exists!!!");
            return;
        }
        this.mContext = context.getApplicationContext();
        a(mapDuMixParams);
        f(this.mContext);
    }

    private by.a cn() {
        return new by.a() { // from class: com.baidu.ar.baidumap.MapDuMix.1
            @Override // com.baidu.ar.by.a
            public void b(IARCaseInfo iARCaseInfo) {
                if (MapDuMix.this.lN != null) {
                    MapDuMix.this.lN.onCaseQueryResult(iARCaseInfo);
                }
                if (iARCaseInfo == null || TextUtils.isEmpty(iARCaseInfo.getArCasePath()) || MapDuMix.this.lF == null) {
                    return;
                }
                if (km.n(new File(iARCaseInfo.getArCasePath()))) {
                    MapDuMix.this.lF.loadCase(ARType.valueOf(iARCaseInfo.getARType()), iARCaseInfo.getArCasePath(), iARCaseInfo.getARKey());
                } else {
                    MapDuMix.this.loadCase(iARCaseInfo.getARKey());
                }
            }
        };
    }

    private DuMixCallback co() {
        return new DuMixCallback() { // from class: com.baidu.ar.baidumap.MapDuMix.3
            @Override // com.baidu.ar.DuMixCallback
            public void onCaseCreate(boolean z, String str, String str2) {
                if (MapDuMix.this.lx != null) {
                    MapDuMix.this.lx.onCaseCreated(z, str2, str);
                    if (z && MapDuMix.this.lO != null && MapDuMix.this.lO.getNavigationRes() != null && MapDuMix.this.lO.getNavigationRes().getNavigationContents() != null) {
                        MapDuMix mapDuMix = MapDuMix.this;
                        mapDuMix.d(mapDuMix.lO.getNavigationRes().getNavigationContents());
                    }
                }
                if (z) {
                    cb.o(2);
                }
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onCaseDestroy() {
                if (MapDuMix.this.lx != null) {
                    MapDuMix.this.lx.onCaseDestroy();
                }
                cb.clear();
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
                kf.b("MapDuMix", "onError" + duMixErrorType + ", errorMessage:" + str);
                if ((duMixErrorType == DuMixErrorType.LibraryError || duMixErrorType == DuMixErrorType.LoadCaseError) && MapDuMix.this.lJ != null) {
                    MapDuMix.this.lJ.onError();
                }
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onRelease() {
                if (MapDuMix.this.lJ != null) {
                    MapDuMix.this.lJ.onRelease(true);
                }
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
                if (MapDuMix.this.lJ != null) {
                    MapDuMix.this.lJ.onSetup(z, duMixInput, duMixOutput);
                }
            }
        };
    }

    public static MapDuMix getInstance(Context context, MapDuMixParams mapDuMixParams) {
        if (lQ == null) {
            synchronized (MapDuMix.class) {
                try {
                    if (lQ == null) {
                        lQ = new MapDuMix(context, mapDuMixParams);
                    }
                } finally {
                }
            }
        }
        return lQ;
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void addFrameRenderListener(FrameRenderListener frameRenderListener) {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.addFrameRenderListener(frameRenderListener);
        }
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public boolean addLuaMsgListener(LuaMsgListener luaMsgListener) {
        DuMixController duMixController = this.lF;
        if (duMixController == null) {
            return false;
        }
        duMixController.addLuaMsgListener(luaMsgListener);
        this.lF.addLuaMsgListener(this);
        return false;
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void cancelAll() {
        by byVar = this.v;
        if (byVar != null) {
            byVar.cancel();
        }
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void cancelCaseDownload(String str) {
        by byVar = this.v;
        if (byVar != null) {
            byVar.O(str);
        }
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void changeOutputObject(Object obj, int i, int i2) {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.changeOutputObject(obj, i, i2);
        }
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void changeOutputSize(int i, int i2) {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.changeOutputSize(i, i2);
        }
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void checkCaseUpdate(String str, cv cvVar) {
        by byVar = this.v;
        if (byVar != null) {
            byVar.checkCaseUpdate(str, cvVar);
        }
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void clearCase() {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.clearCase();
        }
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void doCommand(CommandType commandType, CommandDate commandDate) {
        bz bzVar = this.lL;
        if (bzVar != null) {
            bzVar.doCommand(commandType, commandDate);
        }
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void downloadCase(String str, CaseDownloadListener caseDownloadListener) {
        f(this.mContext);
        by byVar = this.v;
        if (byVar != null) {
            byVar.downloadCase(str, caseDownloadListener);
        }
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public IARRenderer getARRenderer() {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            return duMixController.getARRenderer();
        }
        return null;
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public IGLRenderer getGLRenderer() {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            return duMixController.getGLRenderer();
        }
        return null;
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public IMarker getMarkerManager() {
        DuMixController duMixController = this.lF;
        if (duMixController == null || duMixController.getARProxyManager() == null) {
            return null;
        }
        return this.lF.getARProxyManager().getMarkerAR();
    }

    @Override // com.baidu.ar.lua.LuaMsgListener
    public List<String> getMsgKeyListened() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("event_name");
        return arrayList;
    }

    public void getVpasResByBuildingId(Context context, String str, ca caVar) {
        bz bzVar = this.lL;
        if (bzVar != null) {
            bzVar.a(context, str, caVar);
        }
    }

    public void getVpsResBySessionId(String str, final OnNavigationInfoCallback onNavigationInfoCallback) {
        bz bzVar = this.lL;
        if (bzVar != null) {
            bzVar.a(str, new ca() { // from class: com.baidu.ar.baidumap.MapDuMix.2
                @Override // com.baidu.ar.ca
                public void a(boolean z, String str2, VpasResource vpasResource) {
                    OnNavigationInfoCallback onNavigationInfoCallback2 = onNavigationInfoCallback;
                    if (onNavigationInfoCallback2 != null) {
                        onNavigationInfoCallback2.onNavInfoResult(z, str2, vpasResource);
                    }
                    if (vpasResource == null || vpasResource.getNavigationRes() == null) {
                        return;
                    }
                    MapDuMix.this.loadCase("10328131");
                    MapDuMix.this.lO = vpasResource;
                }
            });
        }
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void loadCase(String str) {
        String str2;
        if ((cb.cp() || (str2 = this.lM) == null || !str2.equals(str)) && this.v != null) {
            if (!TextUtils.isEmpty(this.lM)) {
                this.v.O(this.lM);
            }
            this.lM = str;
            this.v.N(str);
            cb.o(1);
        }
    }

    @Override // com.baidu.ar.baidumap.CaseDownloadListener
    public void onDownloadFinish(boolean z, String str, String str2, int i, String str3) {
        if (z && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            f(str, "../../bar_" + str + "/ar");
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", "__vpas_content_res_download_failed");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("arkey", str);
        hashMap.put("event_data", hashMap2);
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.sendMsg2Lua(hashMap);
        }
    }

    @Override // com.baidu.ar.baidumap.CaseDownloadListener
    public void onDownloadProgress(int i, String str) {
        kf.b("MapDuMix", "onDownloadProgress:" + i);
    }

    @Override // com.baidu.ar.lua.LuaMsgListener
    public void onLuaMessage(HashMap<String, Object> hashMap) {
        if (hashMap == null || hashMap.keySet().size() < 1 || !hashMap.containsKey("event_name") || !"__vpas_content_prepare_res".equals((String) hashMap.get("event_name"))) {
            return;
        }
        float floatValue = ((Float) ((HashMap) hashMap.get("event_data")).get("arkey")).floatValue();
        by byVar = this.v;
        if (byVar != null) {
            byVar.downloadCase(String.valueOf((int) floatValue), this);
        }
    }

    @Override // com.baidu.ar.baidumap.CaseDownloadListener
    public void onRefused() {
        kf.c("MapDuMix", "onRefused");
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            return duMixController.onTouch(view, motionEvent);
        }
        return false;
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void pause() {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.pause();
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void pauseRecord() {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.pauseRecord();
        }
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void pauseScene() {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.pauseScene();
        }
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void release() {
        by byVar = this.v;
        if (byVar != null) {
            byVar.release();
            this.v = null;
        }
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.release();
            this.lF = null;
        }
        bz bzVar = this.lL;
        if (bzVar != null) {
            bzVar.release();
            this.lL = null;
        }
        this.mContext = null;
        lQ = null;
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void removeFrameRenderListener(FrameRenderListener frameRenderListener) {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.removeFrameRenderListener(frameRenderListener);
        }
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public boolean removeLuaMsgListener(LuaMsgListener luaMsgListener) {
        DuMixController duMixController = this.lF;
        if (duMixController == null) {
            return false;
        }
        duMixController.removeLuaMsgListener(luaMsgListener);
        return false;
    }

    public void render(long j) {
        DuMixController duMixController = this.lF;
        if (duMixController == null || duMixController.getARRenderer() == null) {
            return;
        }
        this.lF.getARRenderer().render(j);
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void resume() {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.resume();
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void resumeRecord() {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.resumeRecord();
        }
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void resumeScene() {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.resumeScene();
        }
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public boolean sendLuaScript2Engine(String str) {
        DuMixController duMixController = this.lF;
        if (duMixController == null) {
            return false;
        }
        duMixController.sendLuaScript2Engine(str);
        return false;
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public boolean sendMsg2Lua(HashMap<String, Object> hashMap) {
        DuMixController duMixController = this.lF;
        if (duMixController == null) {
            return false;
        }
        duMixController.sendMsg2Lua(hashMap);
        return false;
    }

    public void setCaseQueryResourcecallback(a aVar) {
        this.lN = aVar;
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void setCaseStateListener(CaseStateListener caseStateListener) {
        this.lx = caseStateListener;
        by byVar = this.v;
        if (byVar != null) {
            byVar.setCaseStateListener(caseStateListener);
        }
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.setDefinedLuaListener(definedLuaListener);
        }
    }

    public void setDownloadComplete() {
        this.lF.setDownloadComplete();
    }

    public void setEulerAngle(float f, float f2, float f3) {
        DuMixController duMixController = this.lF;
        if (duMixController == null || duMixController.getARRenderer() == null) {
            return;
        }
        this.lF.getARRenderer().setRootNodeEulerAngle(f, f2, f3);
    }

    public void setFieldOfView(float f) {
        DuMixController duMixController = this.lF;
        if (duMixController == null || duMixController.getARRenderer() == null) {
            return;
        }
        this.lF.getARRenderer().setFieldOfView(f);
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void setLocationService(ILocationService iLocationService) {
        this.lK = iLocationService;
    }

    @Override // com.baidu.ar.record.IRecord
    public void setRecordWatermark(Watermark watermark) {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.setRecordWatermark(watermark);
        }
    }

    public void setRotation(float f, float f2, float f3) {
        DuMixController duMixController = this.lF;
        if (duMixController == null || duMixController.getARRenderer() == null) {
            return;
        }
        this.lF.getARRenderer().setRootNodeRotation(f, f2, f3);
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void setup(DuMixInput duMixInput, DuMixOutput duMixOutput, MapDuMixCallback mapDuMixCallback) {
        this.lJ = mapDuMixCallback;
        if (!this.lP) {
            mapDuMixCallback.onError();
            return;
        }
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.setup(duMixInput, duMixOutput, co());
        }
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public boolean startAbility(AbilityType abilityType, HashMap<String, Object> hashMap) {
        DuMixController duMixController = this.lF;
        if (duMixController == null || abilityType == null) {
            return false;
        }
        return duMixController.startAbility(abilityType, hashMap);
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void startMarker() {
        if (this.lF == null || this.p == null) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        if (this.p.getInitGPSInfo() != null) {
            hashMap.put("lat", Double.valueOf(this.p.getInitGPSInfo()[0]));
            hashMap.put("lng", Double.valueOf(this.p.getInitGPSInfo()[1]));
        }
        if (!TextUtils.isEmpty(this.p.getBuildingId())) {
            hashMap.put("building_id", this.p.getBuildingId());
        }
        MapDuMixParams mapDuMixParams = this.p;
        if (mapDuMixParams != null && !TextUtils.isEmpty(mapDuMixParams.getCuid())) {
            hashMap.put("cuid", this.p.getCuid());
        }
        hashMap.put("camera_input_width", Integer.valueOf(this.p.getWidth()));
        hashMap.put("camera_input_height", Integer.valueOf(this.p.getHeight()));
        this.lF.startAbility(AbilityType.VPAS_MARKER, hashMap);
    }

    @Override // com.baidu.ar.record.IRecord
    public void startRecord(String str, long j, RecordCallback recordCallback) {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.startRecord(str, j, recordCallback);
        }
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public boolean stopAbility(AbilityType abilityType) {
        DuMixController duMixController = this.lF;
        if (duMixController == null || abilityType == null) {
            return false;
        }
        return duMixController.stopAbility(abilityType);
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void stopMarker() {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.stopAbility(AbilityType.VPAS_MARKER);
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void stopRecord() {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.stopRecord();
        }
    }

    public void takePicture(String str, PhotoCallback photoCallback) {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.takePicture(str, photoCallback);
        }
    }

    private boolean b(Context context, String str) {
        if (kr.a("com.baidu.ar.remoteres.RemoteResLoader", context.getClassLoader())) {
            return new File(DuMixController.getSoDownLoadDir(context), str).exists();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<HashMap<String, Object>> list) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", "__update_vpas_content_map");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("content_map", list);
        hashMap.put("event_data", hashMap2);
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.sendMsg2Lua(hashMap);
        }
    }

    private void f(Context context) {
        if (this.v != null || context == null) {
            return;
        }
        by byVar = new by(context);
        this.v = byVar;
        byVar.setCaseStateListener(this.lx);
        this.v.a(cn());
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void loadCase(String str, ARType aRType) {
        if (this.v != null) {
            if (!TextUtils.isEmpty(this.lM)) {
                this.v.O(this.lM);
            }
            this.lM = str;
            this.v.N(str);
        }
    }

    private void a(MapDuMixParams mapDuMixParams) {
        this.p = mapDuMixParams;
        DefaultParams defaultParams = new DefaultParams();
        defaultParams.setRenderPipeline("filter_pipeline = function()\n\n    fm = ae.FilterManager:get_instance();\n\n    engine_filter = fm:create_filter(\"EngineFilter\", \"globalEngineFilter\", true);\n    fm:update_property_int(engine_filter, \"is_enable\", 1);\n    fm:reset_pipeline();\n\n    fm:connect_filter_to_camera(engine_filter);\n    fm:connect_filter_to_output(engine_filter);\n\nend\n\nfilter_pipeline()\n\n");
        defaultParams.setUseBeautyFilter(false);
        defaultParams.setUseFaceFilter(false);
        defaultParams.setUseMakeupFilter(false);
        defaultParams.setUseTextureIO(mapDuMixParams.isUseTextureIO());
        defaultParams.setShareContext(mapDuMixParams.getShareContext());
        defaultParams.setUseInputSizeInEngine(false);
        defaultParams.setRecordAutoCrop(true);
        defaultParams.setOBRConfig(mapDuMixParams.getOBRConfig());
        DuMixController duMixController = DuMixController.getInstance(this.mContext, defaultParams);
        this.lF = duMixController;
        this.lL = new bz(duMixController, mapDuMixParams);
    }

    private void f(String str, String str2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", "__vpas_content_res_ready");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("arkey", str);
        hashMap2.put("resource_path", str2);
        hashMap.put("event_data", hashMap2);
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.sendMsg2Lua(hashMap);
        }
    }

    @Override // com.baidu.ar.baidumap.IMapDuMix
    public void loadCase(String str, String str2) {
        DuMixController duMixController = this.lF;
        if (duMixController != null) {
            duMixController.loadCase(str, str2);
        }
    }
}
