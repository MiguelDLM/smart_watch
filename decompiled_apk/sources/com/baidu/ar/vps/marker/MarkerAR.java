package com.baidu.ar.vps.marker;

import XIXIX.OOXIXo;
import android.opengl.Matrix;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arplay.representation.Vector4f;
import com.baidu.ar.dc;
import com.baidu.ar.df;
import com.baidu.ar.dk;
import com.baidu.ar.fd;
import com.baidu.ar.fh;
import com.baidu.ar.fi;
import com.baidu.ar.fk;
import com.baidu.ar.fx;
import com.baidu.ar.fz;
import com.baidu.ar.kf;
import com.baidu.ar.kr;
import com.baidu.ar.marker.IMakerAxisCallback;
import com.baidu.ar.marker.IMarker;
import com.baidu.ar.marker.IMarkerLocationTimeCallBack;
import com.baidu.ar.marker.IMarkerStateListener;
import com.baidu.ar.marker.MarkerFrameInfo;
import com.baidu.ar.marker.OnCoordinateBoundListener;
import com.baidu.ar.marker.OnEulerAngleCallback;
import com.baidu.ar.marker.OnTrackerSessionCallback;
import com.baidu.ar.marker.PositioningModuleAddListener;
import com.baidu.ar.marker.TrackerType;
import com.baidu.ar.marker.model.Existance;
import com.baidu.ar.marker.model.LocationMarkerData;
import com.baidu.ar.marker.model.Segments;
import com.baidu.ar.marker.model.TranslationPrior;
import com.baidu.ar.mf;
import com.baidu.ar.mj;
import com.baidu.ar.mk;
import com.baidu.ar.mm;
import com.baidu.ar.mo;
import com.baidu.ar.ms;
import com.baidu.ar.mw;
import com.baidu.ar.mx;
import com.baidu.ar.my;
import com.baidu.ar.mz;
import com.baidu.ar.na;
import com.baidu.ar.nd;
import com.baidu.ar.ne;
import com.baidu.ar.ng;
import com.baidu.ar.nh;
import com.baidu.ar.nk;
import com.baidu.ar.nl;
import com.baidu.ar.nm;
import com.baidu.ar.no;
import com.baidu.ar.np;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class MarkerAR extends com.baidu.ar.d implements IMarker, ms, nm.a {
    private nh FX;
    private IMarkerStateListener FY;
    private ng FZ;
    private IMakerAxisCallback Ga;
    private float Gc;
    private nk Gd;
    private nl Ge;
    private mx Gf;
    private mw Gg;
    private na Gh;
    private boolean Gi;
    private boolean Gk;
    private boolean Gn;
    private float[] Gp;
    private boolean Gq;
    private float[] Gr;
    private TrackerType Gw;
    private b Gx;
    private boolean Gy;
    boolean Gz;
    private OnEulerAngleCallback cP;
    private OnCoordinateBoundListener df;
    private boolean dl;
    private PositioningModuleAddListener ds;
    private IMarkerLocationTimeCallBack iMarkerLocationTimeCallBack;
    private fx iMarkerPositionCallback;
    private OnTrackerSessionCallback mOnTrackerSessionCallback;
    private fi sW;
    private fz tQ;
    private int vG;
    private float Gb = 0.0f;
    private HashMap<String, Object> ag = null;
    private float[] Gj = new float[16];
    private float[] Gl = null;
    private int Gm = -1;
    private mk Go = new mk();
    private nm Gs = new nm(10000);
    private nm Gt = new nm(30000);
    private List<Segments> Gu = new ArrayList();
    private int Gv = -1;

    /* loaded from: classes7.dex */
    public class a implements ne {
        private nh FX;

        public a(nh nhVar) {
            this.FX = nhVar;
        }

        @Override // com.baidu.ar.ne
        public void d(float f, float f2, float f3) {
            nh nhVar = this.FX;
            if (nhVar != null) {
                nhVar.e(f, f2, f3);
            }
            if (MarkerAR.this.FZ != null) {
                MarkerAR.this.FZ.E(new float[]{f, f2, f3});
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements fi {
        private nk GB;

        public b(nk nkVar) {
            this.GB = nkVar;
        }

        public void clear() {
            this.GB = null;
        }

        @Override // com.baidu.ar.fi
        public void onImuUpdate(fh fhVar) {
            nk nkVar = this.GB;
            if (nkVar != null && fhVar != null) {
                nkVar.F(fhVar.getMatrix());
            }
            if (MarkerAR.this.FZ == null || fhVar == null) {
                return;
            }
            MarkerAR.this.FZ.D(fhVar.getMatrix());
        }
    }

    /* loaded from: classes7.dex */
    public class c implements fi {
        private nh FX;

        public c(nh nhVar) {
            this.FX = nhVar;
        }

        @Override // com.baidu.ar.fi
        public void onImuUpdate(fh fhVar) {
            nh nhVar = this.FX;
            if (nhVar != null) {
                nhVar.d(fhVar.getMatrix(), fhVar.dV());
            }
            if (MarkerAR.this.FZ == null || fhVar == null) {
                return;
            }
            MarkerAR.this.FZ.D(fhVar.getMatrix());
        }
    }

    /* loaded from: classes7.dex */
    public class d implements nm.a {
        private d() {
        }

        @Override // com.baidu.ar.nm.a
        public void onTick() {
            if (MarkerAR.this.Gp != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(StatisticConstants.NAVIGATION_SHOW_LAT, String.valueOf(MarkerAR.this.Gp[0]));
                hashMap.put(StatisticConstants.NAVIGATION_SHOW_LNG, String.valueOf(MarkerAR.this.Gp[1]));
                if (MarkerAR.this.Gr != null) {
                    hashMap.put(StatisticConstants.NAVIGATION_SHOW_POSE, Arrays.toString(MarkerAR.this.Gr));
                }
                if (MarkerAR.this.Gv == 3) {
                    hashMap.put("type", "3DOF");
                }
                StatisticApi.onEvent(StatisticConstants.NAVIGATION_SHOW_TRAVEL, hashMap);
                MarkerAR.this.Gq = false;
            }
        }
    }

    private void iA() {
        mw mwVar;
        nl nlVar;
        if (this.Gi || this.Gz || !this.Gk || (mwVar = this.Gg) == null || !mwVar.iq() || !this.Gg.im() || (nlVar = this.Ge) == null || !nlVar.is()) {
            return;
        }
        boolean bindingCoordinate = bindingCoordinate();
        this.Gz = true;
        PositioningModuleAddListener positioningModuleAddListener = this.ds;
        if (positioningModuleAddListener != null) {
            positioningModuleAddListener.addPositioningResult(bindingCoordinate);
        }
    }

    private void ix() {
        if (this.Gf == null) {
            mx mxVar = new mx();
            this.Gf = mxVar;
            mxVar.a(this);
            Matrix.setIdentityM(this.Gj, 0);
        }
    }

    private void iy() {
        mw mwVar;
        if (this.Gv != 3 || this.Gi || (mwVar = this.Gg) == null || !mwVar.im()) {
            return;
        }
        boolean iD = this.Gf.iD();
        PositioningModuleAddListener positioningModuleAddListener = this.ds;
        if (positioningModuleAddListener != null) {
            positioningModuleAddListener.addPositioningResult(iD);
        }
        this.Gi = iD;
    }

    private void iz() {
        bindingCoordinate();
        if (this.Gu.size() > 0) {
            postNavigationRoute(this.Gu);
        }
    }

    private void u(HashMap<String, Object> hashMap) {
        String str;
        if (hashMap != null) {
            double[] dArr = new double[2];
            String str2 = null;
            try {
                dArr[0] = ((Double) hashMap.get("lat")).doubleValue();
                dArr[1] = ((Double) hashMap.get("lng")).doubleValue();
            } catch (Exception unused) {
                kf.b("MarkerAR", "initMarker gpsInfo error!!!");
                dArr = null;
            }
            try {
                str = (String) hashMap.get("building_id");
            } catch (Exception unused2) {
                kf.b("MarkerAR", "initMarker buildingId error!!!");
                str = null;
            }
            this.FX.iP().setMapIndoorParams(dArr, str);
            try {
                str2 = (String) hashMap.get("cuid");
            } catch (Exception unused3) {
                kf.b("MarkerAR", "initMarker cuid error!!!");
            }
            this.FX.iP().setBaiduMapCuid(str2);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public boolean bindingCoordinate() {
        mx mxVar = this.Gf;
        if (mxVar == null) {
            return false;
        }
        boolean iD = mxVar.iD();
        this.Gi = iD;
        return iD;
    }

    @Override // com.baidu.ar.marker.IMarker
    public void choiceOneCoordinate(LocationMarkerData locationMarkerData) {
        nh nhVar = this.FX;
        if (nhVar == null || nhVar.iP() == null) {
            return;
        }
        this.FX.iP().choiceOneCoordinate(locationMarkerData);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void clearNavigationRoute() {
        if (this.Gn) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("event_name", "__reset_navigation_route");
            d(hashMap);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void clearRoute() {
        if (this.Gn) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("event_name", "__remove_navi_route");
            d(hashMap);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public float[] convertLatLngFromPosition(float f, float f2) {
        return this.Gf.A(new float[]{f, f2, 0.0f, 1.0f});
    }

    @Override // com.baidu.ar.marker.IMarker
    public float[] convertPositionFromLatlng(float[] fArr) {
        return this.Gf.r(new float[]{fArr[0], fArr[1]});
    }

    @Override // com.baidu.ar.marker.IMarker
    public void createSession() {
        nh nhVar = this.FX;
        if (nhVar == null || nhVar.iP() == null) {
            return;
        }
        this.FX.iP().createSession(this.Gw);
    }

    @Override // com.baidu.ar.marker.IMarker
    public float[] getGeolocationByTransform() {
        mx mxVar = this.Gf;
        return (mxVar == null || mxVar.iC() == null) ? new float[2] : new float[]{this.Gf.iC().GU.FH, this.Gf.iC().GU.FG};
    }

    @Override // com.baidu.ar.marker.IMarker
    public void hideFinalPoint() {
        if (this.Gn) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("event_name", "__hide_final_point");
            d(hashMap);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void hideNavigationContent() {
        if (this.Gn) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("event_name", "__vpas_content_res_hide");
            d(hashMap);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void initMarkerByTrackerType(TrackerType trackerType) {
        nh nhVar = this.FX;
        if (nhVar == null || nhVar.iP() == null) {
            return;
        }
        this.FX.iP().initMarkerByTrackerType(trackerType);
    }

    @Override // com.baidu.ar.marker.IMarker
    public float[] location2ScreenPoint(float[] fArr) {
        return t() != null ? t().location2ScreenPoint(fArr) : new float[0];
    }

    @Override // com.baidu.ar.d
    public void onCaseCreate(String str) {
        super.onCaseCreate(str);
        this.Gn = true;
    }

    @Override // com.baidu.ar.d
    public void onCaseDestroy() {
        this.Gn = false;
        super.onCaseDestroy();
    }

    @Override // com.baidu.ar.nm.a
    public void onTick() {
    }

    @Override // com.baidu.ar.marker.IMarker
    public void openDataMock() {
        this.Gy = true;
    }

    @Override // com.baidu.ar.marker.IMarker
    public void openDataRecorde() {
        if (kr.a("com.baidu.ar.maprecord.NavigationRecoderController", getContext().getClassLoader())) {
            int intValue = ((Integer) this.ag.get("camera_input_width")).intValue();
            int intValue2 = ((Integer) this.ag.get("camera_input_height")).intValue();
            if (this.FZ == null) {
                this.FZ = new ng(getContext(), intValue, intValue2);
            }
            ng ngVar = this.FZ;
            if (ngVar != null) {
                a(ngVar, (df) null);
            }
        }
    }

    @Override // com.baidu.ar.d, com.baidu.ar.cloud.ICloudIR
    public void pause() {
        super.pause();
        nh nhVar = this.FX;
        if (nhVar != null) {
            nhVar.pause();
            nd.iM().onStop();
        }
        ng ngVar = this.FZ;
        if (ngVar != null) {
            ngVar.pause();
            this.FZ = null;
        }
        this.Gz = false;
        this.Gi = false;
        nl nlVar = this.Ge;
        if (nlVar != null) {
            nlVar.reset();
        }
        b bVar = this.Gx;
        if (bVar != null) {
            bVar.clear();
            this.Gx = null;
        }
        this.Ge = null;
        this.Gg = null;
        mx mxVar = this.Gf;
        if (mxVar != null) {
            mxVar.clear();
        }
        a(this.sW);
    }

    @Override // com.baidu.ar.ms
    public void positioningServiceDidUpdateGeoHeading(float f, float f2) {
        IMarkerStateListener iMarkerStateListener = this.FY;
        if (iMarkerStateListener != null) {
            iMarkerStateListener.compassResult(f);
        }
    }

    @Override // com.baidu.ar.ms
    public void positioningServiceDidUpdateGeoLocalTransform() {
        OnCoordinateBoundListener onCoordinateBoundListener = this.df;
        if (onCoordinateBoundListener != null) {
            onCoordinateBoundListener.onCoordinateBound();
        }
    }

    @Override // com.baidu.ar.ms
    public void positioningServiceDidUpdateLocalTransform(float[] fArr) {
        if (fArr == null || fArr.length <= 0) {
            return;
        }
        if (!this.Gq) {
            this.Gq = true;
            this.Gr = new float[16];
            for (int i = 0; i < fArr.length; i++) {
                this.Gr[i] = fArr[i];
            }
        }
        Matrixf4x4 matrixf4x4 = new Matrixf4x4();
        matrixf4x4.setMatrixValues(fArr);
        if (t() != null && this.Gn) {
            t().updateTransforms(matrixf4x4);
            ng ngVar = this.FZ;
            if (ngVar != null) {
                ngVar.z(matrixf4x4.matrix);
            }
        }
        float f = fArr[12];
        float f2 = fArr[13];
        float f3 = fArr[14];
        this.Gb = f3;
        int i2 = this.vG + 1;
        this.vG = i2;
        if (i2 >= 30) {
            this.vG = 0;
            b(new Vector3f(f, f2, f3));
        }
    }

    @Override // com.baidu.ar.ms
    public void positioningServiceDidupdateGeoLocation(mz mzVar) {
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postARRoute(List<Vector3f> list) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            hashMap.put(String.valueOf(i), list.get(i));
        }
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("event_name", "__add_navi_route");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("ctrl_points", hashMap);
        hashMap3.put("ctrl_points_count", Integer.valueOf(hashMap.size()));
        hashMap2.put("event_data", hashMap3);
        d(hashMap2);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postArrow(float f, float f2, float f3, float f4, int i) {
        Vector3f vector3f = new Vector3f();
        vector3f.setX(f);
        vector3f.setY(f2);
        vector3f.setZ(this.Gb - f4);
        Vector3f vector3f2 = new Vector3f();
        vector3f2.setX(0.5f);
        vector3f2.setY(0.5f);
        vector3f2.setZ(0.5f);
        a("__add_navi_arrow", vector3f, vector3f2, np.a(f, f2, i), "" + System.currentTimeMillis());
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postFinalArrow(String str, double[] dArr) {
        if (this.FX.iP().getLocationTransforms() == null) {
            return;
        }
        float[] a2 = a(new float[]{(float) dArr[0], (float) dArr[1], 0.0f, 1.0f}, new double[]{r15[0], r15[1], r15[2], OOXIXo.f3760XO, r15[3], r15[4], r15[5], OOXIXo.f3760XO, r15[6], r15[7], r15[8], OOXIXo.f3760XO, r15[9], r15[10], r15[11], 1.0d});
        Vector3f vector3f = new Vector3f();
        vector3f.setX(a2[0]);
        vector3f.setY(a2[1]);
        vector3f.setZ(this.Gb - 1.0f);
        Vector3f vector3f2 = new Vector3f();
        vector3f2.setX(0.5f);
        vector3f2.setY(0.5f);
        vector3f2.setZ(0.5f);
        a("__show_final_point", vector3f, vector3f2, new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), str);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postLiftDown(double[] dArr, float f) {
        a(dArr, f, "__show_navi_lift_down");
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postLiftUp(double[] dArr, float f) {
        a(dArr, f, "__show_navi_lift_up");
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postNavigationRoute(List<Segments> list) {
        MarkerAR markerAR = this;
        List<Segments> list2 = list;
        if (list2 == null || list.size() <= 0 || markerAR.Gf == null || !markerAR.Gn) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        new ArrayList();
        markerAR.Gu = list2;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < list.size()) {
            Segments segments = list2.get(i);
            List<double[]> points = segments.getPoints();
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            int i2 = 0;
            while (i2 < points.size()) {
                ArrayList arrayList3 = arrayList;
                int i3 = i;
                float[] r = markerAR.Gf.r(new float[]{(float) points.get(i2)[0], (float) points.get(i2)[1]});
                if (r == null) {
                    return;
                }
                arrayList2.add(new Vector3f(r[0], r[1], 0.0f));
                try {
                    JSONArray jSONArray3 = new JSONArray();
                    jSONArray3.put((float) points.get(i2)[0]);
                    jSONArray3.put((float) points.get(i2)[1]);
                    jSONArray2.put(jSONArray3);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                i2++;
                arrayList = arrayList3;
                i = i3;
            }
            ArrayList arrayList4 = arrayList;
            int i4 = i;
            Existance existance = segments.getExistance();
            int pointsCount = segments.getPointsCount();
            HashMap hashMap = new HashMap();
            hashMap.put("points_count", Integer.valueOf(pointsCount));
            hashMap.put("points", arrayList2);
            float[] r2 = markerAR.Gf.r(new float[]{(float) existance.getLatlng()[0], (float) existance.getLatlng()[1]});
            HashMap hashMap2 = new HashMap();
            hashMap2.put("location", new Vector3f(r2[0], r2[1], 0.0f));
            hashMap2.put("type", existance.getType());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("points", jSONArray2);
                jSONObject.put("pointsCount", pointsCount);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (!TextUtils.isEmpty(existance.getDirectionType())) {
                hashMap2.put("direction_type", existance.getDirectionType());
            }
            if (!TextUtils.isEmpty(existance.getStreetName())) {
                hashMap2.put("street_name", existance.getStreetName());
            }
            hashMap.put("existance", hashMap2);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("type", existance.getType());
                if (!TextUtils.isEmpty(existance.getDirectionType())) {
                    jSONObject2.put("direction_type", existance.getDirectionType());
                }
                jSONObject2.put("street_name", existance.getStreetName());
                JSONArray jSONArray4 = new JSONArray();
                jSONArray4.put(existance.getLatlng()[0]);
                jSONArray4.put(existance.getLatlng()[1]);
                jSONObject2.put("latlng", jSONArray4);
                jSONObject.put("existance", jSONObject2);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            jSONArray.put(jSONObject);
            arrayList4.add(hashMap);
            Log.e("MarkerAR", segments.toString());
            i = i4 + 1;
            list2 = list;
            arrayList = arrayList4;
            markerAR = this;
        }
        MarkerAR markerAR2 = markerAR;
        ArrayList arrayList5 = arrayList;
        ng ngVar = markerAR2.FZ;
        if (ngVar != null) {
            ngVar.cA(jSONArray.toString());
        }
        HashMap hashMap3 = new HashMap();
        hashMap3.put("segment_count", "" + arrayList5.size());
        hashMap3.put("segments", arrayList5);
        HashMap hashMap4 = new HashMap();
        hashMap4.put("route", hashMap3);
        HashMap<String, Object> hashMap5 = new HashMap<>();
        hashMap5.put("event_name", "__update_navigation_route");
        hashMap5.put("event_data", hashMap4);
        markerAR2.d(hashMap5);
        markerAR2.a(markerAR2.Gl, markerAR2.dl);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postRoute(List<double[]> list) {
        nh nhVar = this.FX;
        if (nhVar == null || !this.Gn) {
            return;
        }
        if (nhVar.iP().getLocationTransforms() == null) {
            return;
        }
        double[] dArr = {r8[0], r8[1], r8[2], OOXIXo.f3760XO, r8[3], r8[4], r8[5], OOXIXo.f3760XO, r8[6], r8[7], r8[8], OOXIXo.f3760XO, r8[9], r8[10], r8[11], 1.0d};
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            double[] dArr2 = list.get(i);
            try {
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put((float) dArr2[0]);
                jSONArray2.put((float) dArr2[1]);
                jSONArray.put(jSONArray2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            float[] a2 = a(new float[]{(float) dArr2[0], (float) dArr2[1], 0.0f, 1.0f}, dArr);
            Vector3f vector3f = new Vector3f();
            vector3f.setX(a2[0]);
            vector3f.setY(a2[1]);
            vector3f.setZ(0.0f);
            hashMap.put(String.valueOf(i), vector3f);
        }
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("event_name", "__add_navi_route");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("ctrl_points", hashMap);
        hashMap3.put("ctrl_points_count", Integer.valueOf(hashMap.size()));
        hashMap2.put("event_data", hashMap3);
        d(hashMap2);
        ng ngVar = this.FZ;
        if (ngVar != null) {
            ngVar.cA(jSONArray.toString());
        }
    }

    @Override // com.baidu.ar.d
    public void release() {
        nh nhVar = this.FX;
        if (nhVar != null) {
            nhVar.release();
            nd.iM().onStop();
            a(this.FX);
            this.FX = null;
        }
        b bVar = this.Gx;
        if (bVar != null) {
            bVar.clear();
            this.Gx = null;
        }
        ng ngVar = this.FZ;
        if (ngVar != null) {
            ngVar.pause();
            this.FZ.release();
            a(this.FZ);
            this.FZ = null;
        }
        this.FY = null;
        this.Ga = null;
        this.iMarkerLocationTimeCallBack = null;
        this.mOnTrackerSessionCallback = null;
        this.Ge = null;
        mx mxVar = this.Gf;
        if (mxVar != null) {
            mxVar.clear();
            this.Gh = null;
            this.Ge = null;
            this.mOnTrackerSessionCallback = null;
            this.Gf = null;
        }
        nm nmVar = this.Gs;
        if (nmVar != null) {
            nmVar.iR();
        }
        nm nmVar2 = this.Gt;
        if (nmVar2 != null) {
            nmVar2.iR();
        }
        super.release();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void releaseMarker() {
        nh nhVar = this.FX;
        if (nhVar == null || nhVar.iP() == null) {
            return;
        }
        this.FX.iP().releaseAlgo();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void removeAllArrow() {
        if (this.Gn) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("event_name", "__clear_navi_arrow");
            d(hashMap);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void removeArrowByArrowId(String str) {
        if (this.Gn) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("event_name", "__remove_navi_arrow");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("id", str);
            hashMap.put("event_data", hashMap2);
            d(hashMap);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void removeLiftDown() {
        if (this.Gn) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("event_name", "__hide_navi_lift_down");
            d(hashMap);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void removeLiftUp() {
        if (this.Gn) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("event_name", "__hide_navi_lift_up");
            d(hashMap);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void resetMarker() {
        nh nhVar = this.FX;
        if (nhVar == null || nhVar.iP() == null) {
            return;
        }
        this.FX.iP().resetAlgo();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void resetNavigationController() {
        mx mxVar = this.Gf;
        if (mxVar != null) {
            mxVar.clear();
        }
    }

    @Override // com.baidu.ar.d, com.baidu.ar.cloud.ICloudIR
    public void resume() {
        nh nhVar = this.FX;
        if (nhVar != null) {
            nhVar.resume();
            nd.iM().a(getContext(), new a(this.FX));
        }
        ix();
    }

    @Override // com.baidu.ar.marker.IMarker
    public void runAREngineWithNavigation(PositioningModuleAddListener positioningModuleAddListener) {
        this.ds = positioningModuleAddListener;
        if (this.Ge == null) {
            this.Ge = new nl("AREngine", my.Local6Dof.Fr);
        }
        this.Gv = 2;
        this.Ge.a(this.Gf);
        this.Ge.a(new mf() { // from class: com.baidu.ar.vps.marker.MarkerAR.1
            @Override // com.baidu.ar.mf
            public void il() {
                MarkerAR markerAR = MarkerAR.this;
                markerAR.Gk = markerAR.Gf.a((mo) MarkerAR.this.Ge);
                if (MarkerAR.this.Gk) {
                    MarkerAR.this.Gf.c(MarkerAR.this.Ge);
                    MarkerAR.this.Gf.b(MarkerAR.this.Ge);
                    MarkerAR.this.Gg = new mw("Geo", my.GeoHeading.Fr);
                    MarkerAR.this.Gg.a(MarkerAR.this.Gf);
                    MarkerAR.this.Gf.a((mm) MarkerAR.this.Gg);
                    MarkerAR.this.Gf.c(MarkerAR.this.Gg);
                    MarkerAR.this.Gf.b(MarkerAR.this.Gg);
                    if (MarkerAR.this.Gl != null) {
                        MarkerAR markerAR2 = MarkerAR.this;
                        markerAR2.updateLocation(markerAR2.Gl, MarkerAR.this.Gm, MarkerAR.this.dl);
                    }
                    if (MarkerAR.this.Gt != null) {
                        MarkerAR.this.Gt.a(new d());
                        MarkerAR.this.Gt.startTimer();
                    }
                }
            }
        });
    }

    @Override // com.baidu.ar.marker.IMarker
    public void runImuWithNavigation(PositioningModuleAddListener positioningModuleAddListener) {
        this.ds = positioningModuleAddListener;
        if (this.Gd == null) {
            this.Gd = new nk(getContext());
        }
        if (!this.Gy) {
            if (this.Gx == null) {
                this.Gx = new b(this.Gd);
            }
            b(this.Gx);
        }
        this.Gv = 3;
        this.Gd.a(this.Gf);
        this.Gd.a(new mf() { // from class: com.baidu.ar.vps.marker.MarkerAR.2
            @Override // com.baidu.ar.mf
            public void il() {
                MarkerAR markerAR = MarkerAR.this;
                markerAR.Gk = markerAR.Gf.a((mo) MarkerAR.this.Gd);
                if (MarkerAR.this.Gk) {
                    MarkerAR.this.Gf.c(MarkerAR.this.Gd);
                    MarkerAR.this.Gf.b(MarkerAR.this.Gd);
                    MarkerAR.this.Gg = new mw("Geo", my.GeoHeading.Fr);
                    MarkerAR.this.Gg.a(MarkerAR.this.Gf);
                    MarkerAR.this.Gf.a((mm) MarkerAR.this.Gg);
                    MarkerAR.this.Gf.c(MarkerAR.this.Gg);
                    MarkerAR.this.Gf.b(MarkerAR.this.Gg);
                }
                if (MarkerAR.this.Gl != null) {
                    MarkerAR markerAR2 = MarkerAR.this;
                    markerAR2.updateLocation(markerAR2.Gl, MarkerAR.this.Gm, MarkerAR.this.dl);
                }
                if (MarkerAR.this.Gt != null) {
                    MarkerAR.this.Gt.a(new d());
                    MarkerAR.this.Gt.startTimer();
                }
            }
        });
        ng ngVar = this.FZ;
        if (ngVar != null) {
            a(ngVar, (df) null);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void runPedometerWithNavigation(PositioningModuleAddListener positioningModuleAddListener) {
        if (this.Gh == null) {
            this.Gh = new na("Pedometer-Vpas", my.Local6Dof.Fr | my.GeoHeading.Fr | my.GeoLocation.Fr);
        }
        int intValue = ((Integer) this.ag.get("camera_input_width")).intValue();
        int intValue2 = ((Integer) this.ag.get("camera_input_height")).intValue();
        this.Gh.b(this.Gf);
        this.Gv = 1;
        if (this.FX == null && this.ag != null) {
            nh nhVar = new nh(getContext(), intValue, intValue2, this.FY, this.Gh);
            this.FX = nhVar;
            if (!this.Gy) {
                b(new c(nhVar));
                nd.iM().a(getContext(), new a(this.FX));
            }
            u(this.ag);
            this.FX.a(this.mOnTrackerSessionCallback);
            this.FX.a(this.iMarkerPositionCallback);
            this.FX.a(this.iMarkerLocationTimeCallBack);
            u(this.ag);
            nh nhVar2 = this.FX;
            TrackerType trackerType = TrackerType.STEP_ODOMETRY_ANDROID;
            nhVar2.a(trackerType);
            this.Gw = trackerType;
            a(this.FX, new df() { // from class: com.baidu.ar.vps.marker.MarkerAR.4
                @Override // com.baidu.ar.df
                public void a(dc dcVar) {
                    kf.cj("addDetector:onDetected");
                }

                @Override // com.baidu.ar.df
                public void b(dk dkVar) {
                    kf.cj("addDetector:onRelease");
                }

                @Override // com.baidu.ar.df
                public void a(dk dkVar) {
                    kf.cj("addDetector:onSetup");
                }
            });
        }
        if (positioningModuleAddListener != null) {
            positioningModuleAddListener.addPositioningResult(true);
        }
        ng ngVar = this.FZ;
        if (ngVar != null) {
            a(ngVar, (df) null);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void runVpasWithNavigation(PositioningModuleAddListener positioningModuleAddListener) {
        HashMap<String, Object> hashMap;
        if (this.Gh == null) {
            this.Gh = new na("Vpas", my.Local6Dof.Fr | my.GeoHeading.Fr | my.GeoLocation.Fr);
        }
        this.Gh.b(this.Gf);
        this.Gv = 1;
        if (this.FX == null && (hashMap = this.ag) != null) {
            this.FX = new nh(getContext(), ((Integer) hashMap.get("camera_input_width")).intValue(), ((Integer) this.ag.get("camera_input_height")).intValue(), this.FY, this.Gh);
            u(this.ag);
            nh nhVar = this.FX;
            TrackerType trackerType = TrackerType.VIO_ARCORE_DATA;
            nhVar.a(trackerType);
            this.Gw = trackerType;
            this.FX.a(this.mOnTrackerSessionCallback);
            this.FX.a(this.iMarkerLocationTimeCallBack);
            this.FX.a(this.iMarkerPositionCallback);
            a(this.FX, new df() { // from class: com.baidu.ar.vps.marker.MarkerAR.3
                @Override // com.baidu.ar.df
                public void a(dc dcVar) {
                    Log.e("MarkerAR", "onDetected");
                }

                @Override // com.baidu.ar.df
                public void b(dk dkVar) {
                    Log.e("MarkerAR", "onRelease");
                }

                @Override // com.baidu.ar.df
                public void a(dk dkVar) {
                    Log.e("MarkerAR", "onSetup");
                }
            });
        }
        if (positioningModuleAddListener != null) {
            positioningModuleAddListener.addPositioningResult(true);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setAvailableFrame(MarkerFrameInfo markerFrameInfo) {
        nh nhVar = this.FX;
        if (nhVar != null) {
            nhVar.a(markerFrameInfo);
        }
        if (markerFrameInfo != null) {
            i(markerFrameInfo.getScaleY());
            nl nlVar = this.Ge;
            if (nlVar != null) {
                float[] a2 = nlVar.a(markerFrameInfo.getTrackingState(), markerFrameInfo.getOrignalTransform());
                OnEulerAngleCallback onEulerAngleCallback = this.cP;
                if (onEulerAngleCallback != null) {
                    onEulerAngleCallback.onEulerAngleUpdate(a2);
                }
            }
            ng ngVar = this.FZ;
            if (ngVar != null) {
                ngVar.d(markerFrameInfo.getOrignalTransform(), markerFrameInfo.getTrackingState());
            }
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setAxisCallback(IMakerAxisCallback iMakerAxisCallback) {
        this.Ga = iMakerAxisCallback;
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setCoordinateBoundListener(OnCoordinateBoundListener onCoordinateBoundListener) {
        this.df = onCoordinateBoundListener;
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setEulerAngleCallback(OnEulerAngleCallback onEulerAngleCallback) {
        this.cP = onEulerAngleCallback;
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setLocationTimeCallBack(IMarkerLocationTimeCallBack iMarkerLocationTimeCallBack) {
        this.iMarkerLocationTimeCallBack = iMarkerLocationTimeCallBack;
        nh nhVar = this.FX;
        if (nhVar == null || nhVar.iP() == null) {
            return;
        }
        this.FX.iP().setMarkerLocationTimeCallBack(this.iMarkerLocationTimeCallBack);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setMarkerARSetupCallback(fz fzVar) {
        this.tQ = fzVar;
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setMarkerStateListener(IMarkerStateListener iMarkerStateListener) {
        this.FY = iMarkerStateListener;
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setPositionCallback(fx fxVar) {
        this.iMarkerPositionCallback = fxVar;
    }

    @Override // com.baidu.ar.marker.IMarker
    public void setTrackerSessionCallback(OnTrackerSessionCallback onTrackerSessionCallback) {
        this.mOnTrackerSessionCallback = onTrackerSessionCallback;
        nh nhVar = this.FX;
        if (nhVar != null) {
            nhVar.a(onTrackerSessionCallback);
        }
    }

    @Override // com.baidu.ar.d
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        this.ag = hashMap;
        ix();
        fz fzVar = this.tQ;
        if (fzVar != null) {
            fzVar.aj();
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void showNavigationContent() {
        if (this.Gn) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("event_name", "__vpas_content_res_show");
            d(hashMap);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void test() {
    }

    @Override // com.baidu.ar.marker.IMarker
    public void updateHeading(float f, float f2) {
        mw mwVar = this.Gg;
        if (mwVar != null) {
            mwVar.updateHeading(f, f2);
            if (this.Gi && this.Go.g(f2)) {
                iz();
            }
            iA();
            iy();
        }
        ng ngVar = this.FZ;
        if (ngVar != null) {
            ngVar.updateHeading(f, f2);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void updateImuData(float[] fArr) {
        nk nkVar = this.Gd;
        if (nkVar != null && fArr != null) {
            nkVar.F(fArr);
        }
        nh nhVar = this.FX;
        if (nhVar != null) {
            nhVar.d(fArr, null);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void updateLocation(float[] fArr, int i, boolean z) {
        if (fArr == null || fArr.length <= 0) {
            return;
        }
        this.Gl = fArr;
        this.Gm = i;
        this.dl = z;
        ng ngVar = this.FZ;
        if (ngVar != null) {
            ngVar.updateLocation(fArr, i, z);
        }
        this.Gp = new float[]{fArr[0], fArr[1]};
        if (this.Gg != null) {
            mz mzVar = new mz();
            mj mjVar = new mj();
            mjVar.FH = fArr[0];
            mjVar.FG = fArr[1];
            mzVar.GU = mjVar;
            this.Gg.a(mzVar);
            if (this.Gi && this.Go.a(fArr, i)) {
                iz();
            }
            if (this.Gf != null && this.Gi && this.Gn) {
                a(fArr, z);
            }
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void updateMeters(float f) {
        if (this.Gn) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("event_name", "__ar_navi_update_meters");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("meters", Float.valueOf(f));
            hashMap.put("event_data", hashMap2);
            d(hashMap);
        }
        ng ngVar = this.FZ;
        if (ngVar != null) {
            ngVar.updateMeters(f);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void updateMockAccelerometer(float f, float f2, float f3) {
        nh nhVar = this.FX;
        if (nhVar != null) {
            nhVar.e(f, f2, f3);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void updateTransformData(int i, float[] fArr) {
        nl nlVar = this.Ge;
        if (nlVar != null) {
            nlVar.a(i, fArr);
        }
    }

    @Override // com.baidu.ar.marker.IMarker
    public void updateTranslationPrior(TranslationPrior translationPrior) {
        nh nhVar = this.FX;
        if (nhVar == null || nhVar.iP() == null) {
            return;
        }
        this.FX.iP().updateTranslationPrior(translationPrior);
    }

    private void b(Vector3f vector3f) {
        if (this.Gn) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("event_name", "__vpas_update_user_position");
            HashMap hashMap2 = new HashMap();
            hashMap2.put(RequestParameters.POSITION, vector3f);
            hashMap.put("event_data", hashMap2);
            d(hashMap);
        }
    }

    private void i(float f) {
        if (f <= 0.0f) {
            return;
        }
        j(f);
    }

    private void j(float f) {
        this.Gc = f;
        if (!this.Gn || f <= 0.0f) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", "__update_fov");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("fov", Float.valueOf(f));
        hashMap.put("event_data", hashMap2);
        d(hashMap);
    }

    @Override // com.baidu.ar.marker.IMarker
    public void postArrow(String str, int i, double[] dArr, double[] dArr2, double[] dArr3, float f, float f2) {
        float[] locationTransforms = this.FX.iP().getLocationTransforms();
        this.Gh.it();
        if (locationTransforms == null) {
            return;
        }
        float[] fArr = {(float) dArr[0], (float) dArr[1], 0.0f, 1.0f};
        float[] fArr2 = {(float) dArr2[0], (float) dArr2[1], 0.0f, 1.0f};
        double[] dArr4 = {locationTransforms[0], locationTransforms[1], locationTransforms[2], OOXIXo.f3760XO, locationTransforms[3], locationTransforms[4], locationTransforms[5], OOXIXo.f3760XO, locationTransforms[6], locationTransforms[7], locationTransforms[8], OOXIXo.f3760XO, locationTransforms[9], locationTransforms[10], locationTransforms[11], 1.0d};
        float[] a2 = a(fArr, dArr4);
        float[] a3 = a(fArr2, dArr4);
        Vector3f vector3f = new Vector3f();
        vector3f.setX(a2[0]);
        vector3f.setY(a2[1]);
        vector3f.setZ(this.Gb - f2);
        Vector3f vector3f2 = new Vector3f();
        vector3f2.setX(f);
        vector3f2.setY(f);
        vector3f2.setZ(f);
        Vector4f a4 = np.a(a3[0] - a2[0], a3[1] - a2[1], i);
        a("__add_navi_arrow", vector3f, vector3f2, a4, str);
        kf.c("post", "positionVec:" + Arrays.toString(vector3f.toArray()) + ",rotationVec :" + Arrays.toString(a4.toArray()));
    }

    private void a(String str, Vector3f vector3f, Vector3f vector3f2, Vector4f vector4f) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(RequestParameters.POSITION, vector3f);
        hashMap2.put("scale", vector3f2);
        hashMap2.put("rotation", vector4f);
        hashMap.put("event_data", hashMap2);
        d(hashMap);
    }

    private void b(fi fiVar) {
        fk fkVar = new fk();
        fkVar.a(fd.WORLD);
        fkVar.C(0);
        fkVar.y(false);
        fkVar.z(true);
        fkVar.A(true);
        a(fkVar, fiVar);
    }

    private void a(String str, Vector3f vector3f, Vector3f vector3f2, Vector4f vector4f, String str2) {
        if (this.Gn) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("event_name", str);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(RequestParameters.POSITION, vector3f);
            hashMap2.put("scale", vector3f2);
            hashMap2.put("id", str2);
            hashMap2.put("rotation", vector4f);
            hashMap.put("event_data", hashMap2);
            d(hashMap);
        }
    }

    private void a(double[] dArr, float f, String str) {
        float[] locationTransforms;
        nh nhVar = this.FX;
        if (nhVar == null || dArr == null || dArr.length <= 0 || (locationTransforms = nhVar.iP().getLocationTransforms()) == null) {
            return;
        }
        float[] a2 = a(new float[]{(float) dArr[0], (float) dArr[1], 0.0f, 1.0f}, new double[]{locationTransforms[0], locationTransforms[1], locationTransforms[2], OOXIXo.f3760XO, locationTransforms[3], locationTransforms[4], locationTransforms[5], OOXIXo.f3760XO, locationTransforms[6], locationTransforms[7], locationTransforms[8], OOXIXo.f3760XO, locationTransforms[9], locationTransforms[10], locationTransforms[11], 1.0d});
        Vector3f vector3f = new Vector3f();
        vector3f.setX(a2[0]);
        vector3f.setY(a2[1]);
        vector3f.setZ(this.Gb - 1.0f);
        Vector3f vector3f2 = new Vector3f();
        vector3f2.setX(f);
        vector3f2.setY(f);
        vector3f2.setZ(f);
        a(str, vector3f, vector3f2, new Vector4f(0.0f, 0.0f, 0.0f, 1.0f));
    }

    private void a(float[] fArr, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", "__update_located_location");
        HashMap hashMap2 = new HashMap();
        float[] r = this.Gf.r(new float[]{fArr[0], fArr[1]});
        if (r == null) {
            return;
        }
        hashMap2.put("location", new Vector3f(r[0], r[1], 0.0f));
        hashMap2.put("on_route", Integer.valueOf(z ? 1 : 0));
        hashMap.put("event_data", hashMap2);
        d(hashMap);
    }

    private float[] a(float[] fArr, double[] dArr) {
        float[] fArr2 = new float[16];
        no.a(fArr2, 0, dArr, 0);
        float[] fArr3 = new float[4];
        Matrix.multiplyMV(fArr3, 0, fArr2, 0, fArr, 0);
        return new float[]{fArr3[0], fArr3[1]};
    }
}
