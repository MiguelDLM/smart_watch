package com.baidu.navisdk.comapi.routeguide;

import OX00o0X.oO;
import XIXIX.OOXIXo;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.ar.base.MsgField;
import com.baidu.navisdk.framework.interfaces.pronavi.i;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.model.RGLineItem;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.voicesquare.interfaces.VoiceInterfaceImplProxy;
import com.garmin.fit.OxXXx0X;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class BNRouteGuider {
    public static final int REMOVE_LOCATION = 1;
    public static final int START_LOCATION = 0;
    private static final String TAG = "RoutePlan";
    private static volatile BNRouteGuider mInstance;
    private final com.baidu.navisdk.util.worker.loop.a mGpsHandler;
    private com.baidu.navisdk.comapi.routeguide.b mGpsStatusListener;
    private JNIGuidanceControl mGuidanceControl;
    private com.baidu.navisdk.module.pronavi.msg.b mMessageDispatcher;
    private final com.baidu.navisdk.util.worker.loop.b mMsgHandler;
    private final Collection<com.baidu.navisdk.module.pronavi.message.f> mNaviListeners;
    private com.baidu.navisdk.module.pronavi.b mNaviSubStatus;
    private final Map<d, com.baidu.navisdk.comapi.routeguide.c> mRGInfoAdapterMap;
    private final Vector<g> mRGInfoListeners;
    private g mRGInfoLister;
    private e mRGSubStatusListener;
    private final Vector<c> mSubStatusListeners;
    private boolean mbIsNavigating = false;
    private int mOtherRequestId = -1;
    private boolean isOpenHdLaneMapMode = false;

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.b {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(4479);
            observe(4098);
            observe(4100);
            observe(4101);
            observe(4102);
            observe(4103);
            observe(4109);
            observe(4110);
            observe(4111);
            observe(4608);
            observe(4609);
            observe(4610);
            observe(4104);
            observe(4105);
            observe(4106);
            observe(4107);
            observe(4108);
            observe(4112);
            observe(4113);
            observe(4114);
            observe(4117);
            observe(4116);
            observe(4115);
            observe(4146);
            observe(4147);
            observe(4148);
            observe(4406);
            observe(4407);
            observe(4408);
            observe(4409);
            observe(4410);
            observe(4411);
            observe(4152);
            observe(4153);
            observe(MsgField.MSG_ON_PARSE_RESOURCE_JSON_ERROR);
            observe(4162);
            observe(OxXXx0X.xOOxX);
            observe(4172);
            observe(4171);
            observe(4179);
            observe(4180);
            observe(4181);
            observe(4182);
            observe(4204);
            observe(4192);
            observe(4211);
            observe(4212);
            observe(4213);
            observe(4214);
            observe(4215);
            observe(4217);
            observe(4614);
            observe(4615);
            observe(4617);
            observe(4618);
            observe(4619);
            observe(4396);
            observe(4397);
            observe(4399);
            observe(4398);
            observe(4404);
            observe(4386);
            observe(4387);
            observe(4405);
            observe(4219);
            observe(4388);
            observe(4389);
            observe(4390);
            observe(4391);
            observe(4413);
            observe(4414);
            observe(4415);
            observe(4416);
            observe(4417);
            observe(4419);
            observe(4420);
            observe(4383);
            observe(4384);
            observe(4385);
            observe(4425);
            observe(OxXXx0X.OXoIOx);
            observe(4428);
            observe(4429);
            observe(4431);
            observe(OxXXx0X.Xx0OXIoI);
            observe(4434);
            observe(4435);
            observe(4437);
            observe(4438);
            observe(4439);
            observe(4440);
            observe(4441);
            observe(OxXXx0X.o0Ixx);
            observe(4443);
            observe(oO.f1954oIX0oI);
            observe(4448);
            observe(OxXXx0X.x0x);
            observe(4450);
            observe(4451);
            observe(4457);
            observe(4458);
            observe(4459);
            observe(4464);
            observe(4465);
            observe(4466);
            observe(4467);
            observe(4470);
            observe(4474);
            observe(4473);
            observe(4469);
            observe(4475);
            observe(4481);
            observe(4483);
            observe(4482);
            observe(4485);
            observe(4484);
            observe(4623);
            observe(4496);
            observe(4498);
            observe(4499);
            observe(4500);
            observe(4501);
            observe(4502);
            observe(4503);
            observe(4504);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 911
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:64)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // com.baidu.navisdk.util.worker.loop.b
        public void onMessage(android.os.Message r10) {
            /*
                Method dump skipped, instructions count: 4972
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.comapi.routeguide.BNRouteGuider.a.onMessage(android.os.Message):void");
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.util.worker.loop.a {
        public b(BNRouteGuider bNRouteGuider, String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            i iVar;
            com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
            if (h != null) {
                iVar = h.C();
            } else {
                iVar = null;
            }
            int i = message.what;
            if (i == 0) {
                if (iVar != null) {
                    iVar.k();
                }
            } else if (i == 1 && iVar != null) {
                iVar.n();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(Message message);

        void b(Message message);

        void c(Message message);

        void d(Message message);

        void e(Message message);

        void f(Message message);

        void g(Message message);

        void h(Message message);
    }

    private BNRouteGuider() {
        this.mGuidanceControl = null;
        a aVar = new a("RG");
        this.mMsgHandler = aVar;
        this.mRGInfoListeners = new Vector<>(0);
        this.mRGInfoAdapterMap = new HashMap();
        this.mSubStatusListeners = new Vector<>(0);
        this.mNaviListeners = new ArrayList();
        this.mGpsHandler = new b(this, "RG-2");
        if (this.mGuidanceControl == null) {
            this.mGuidanceControl = JNIGuidanceControl.getInstance();
        }
        com.baidu.navisdk.vi.b.a(aVar);
    }

    public static /* synthetic */ g access$000(BNRouteGuider bNRouteGuider) {
        return bNRouteGuider.mRGInfoLister;
    }

    public static /* synthetic */ e access$100(BNRouteGuider bNRouteGuider) {
        return bNRouteGuider.mRGSubStatusListener;
    }

    public static /* synthetic */ com.baidu.navisdk.comapi.routeguide.b access$200(BNRouteGuider bNRouteGuider) {
        return bNRouteGuider.mGpsStatusListener;
    }

    public static /* synthetic */ void access$300(BNRouteGuider bNRouteGuider, Message message) {
        bNRouteGuider.notifyNaviStatusChange(message);
    }

    public static /* synthetic */ Vector access$400(BNRouteGuider bNRouteGuider) {
        return bNRouteGuider.mSubStatusListeners;
    }

    public static /* synthetic */ com.baidu.navisdk.module.pronavi.b access$500(BNRouteGuider bNRouteGuider) {
        return bNRouteGuider.mNaviSubStatus;
    }

    public static /* synthetic */ Vector access$600(BNRouteGuider bNRouteGuider) {
        return bNRouteGuider.mRGInfoListeners;
    }

    public static /* synthetic */ com.baidu.navisdk.module.pronavi.msg.b access$700(BNRouteGuider bNRouteGuider) {
        return bNRouteGuider.mMessageDispatcher;
    }

    public static void destory() {
        if (mInstance != null) {
            synchronized (BNRouteGuider.class) {
                try {
                    if (mInstance != null) {
                        mInstance.dispose();
                    }
                } finally {
                }
            }
        }
        mInstance = null;
    }

    private void dispose() {
        this.mGuidanceControl = null;
        com.baidu.navisdk.vi.b.b(this.mMsgHandler);
    }

    private String generateToStr(float f) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("gpsBias", f);
            return jSONObject.toString();
        } catch (JSONException e) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
            if (gVar.d()) {
                gVar.a("triggerStartLocationData generate json exception!", e);
            }
            return "";
        }
    }

    public static BNRouteGuider getInstance() {
        if (mInstance == null) {
            synchronized (BNRouteGuider.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new BNRouteGuider();
                    }
                } finally {
                }
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyNaviStatusChange(Message message) {
        e eVar = this.mRGSubStatusListener;
        if (eVar == null) {
            return;
        }
        int i = message.arg1;
        int i2 = 0;
        if (i != 12) {
            switch (i) {
                case 1:
                    eVar.d(message);
                    while (i2 < this.mSubStatusListeners.size()) {
                        c cVar = this.mSubStatusListeners.get(i2);
                        if (cVar == null) {
                            this.mSubStatusListeners.remove(i2);
                        } else {
                            cVar.d(message);
                            i2++;
                        }
                    }
                    break;
                case 2:
                    eVar.h(message);
                    while (i2 < this.mSubStatusListeners.size()) {
                        c cVar2 = this.mSubStatusListeners.get(i2);
                        if (cVar2 == null) {
                            this.mSubStatusListeners.remove(i2);
                        } else {
                            cVar2.h(message);
                            i2++;
                        }
                    }
                    break;
                case 3:
                    eVar.b(message);
                    while (i2 < this.mSubStatusListeners.size()) {
                        c cVar3 = this.mSubStatusListeners.get(i2);
                        if (cVar3 == null) {
                            this.mSubStatusListeners.remove(i2);
                        } else {
                            cVar3.b(message);
                            i2++;
                        }
                    }
                    break;
                case 4:
                    eVar.e(message);
                    while (i2 < this.mSubStatusListeners.size()) {
                        c cVar4 = this.mSubStatusListeners.get(i2);
                        if (cVar4 == null) {
                            this.mSubStatusListeners.remove(i2);
                        } else {
                            cVar4.e(message);
                            i2++;
                        }
                    }
                    break;
                case 5:
                    eVar.c(message);
                    while (i2 < this.mSubStatusListeners.size()) {
                        c cVar5 = this.mSubStatusListeners.get(i2);
                        if (cVar5 == null) {
                            this.mSubStatusListeners.remove(i2);
                        } else {
                            cVar5.c(message);
                            i2++;
                        }
                    }
                    break;
                case 6:
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
                    if (gVar.a()) {
                        gVar.a("From enginee: receive end guide command:msg.what = " + message.what + ", nMsgType=" + i);
                    }
                    eVar.a(message);
                    while (i2 < this.mSubStatusListeners.size()) {
                        c cVar6 = this.mSubStatusListeners.get(i2);
                        if (cVar6 == null) {
                            this.mSubStatusListeners.remove(i2);
                        } else {
                            cVar6.a(message);
                            i2++;
                        }
                    }
                    break;
            }
        } else {
            eVar.f(message);
            while (i2 < this.mSubStatusListeners.size()) {
                c cVar7 = this.mSubStatusListeners.get(i2);
                if (cVar7 == null) {
                    this.mSubStatusListeners.remove(i2);
                } else {
                    cVar7.f(message);
                    i2++;
                }
            }
        }
        eVar.i(message);
        com.baidu.navisdk.module.pronavi.b bVar = this.mNaviSubStatus;
        if (bVar != null) {
            bVar.b(message);
        }
    }

    private void startNaviLocate() {
        com.baidu.navisdk.util.common.g.ROUTE_GUIDE.e(TAG, "startNaviLocate");
        this.mGpsHandler.sendEmptyMessage(0);
    }

    private void stopNaviLocate() {
        com.baidu.navisdk.util.common.g.ROUTE_GUIDE.e(TAG, "stopNaviLocate");
        this.mGpsHandler.sendEmptyMessage(1);
    }

    public void EnableRoadCondition(boolean z) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            this.mGuidanceControl.EnableRoadCondition(z);
        }
    }

    public double GetCarRotateAngle() {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.GetCarRotateAngle();
        }
        return -1.0d;
    }

    public ArrayList<Bundle> GetTruckRouteUgcInfo() {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            try {
                return this.mGuidanceControl.GetTruckRouteUgcInfo();
            } catch (OutOfMemoryError unused) {
            }
        }
        return null;
    }

    public boolean SetCruiseSetting(Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
            if (gVar.d()) {
                gVar.e("SetCruiseSetting() --> bundle=" + bundle.toString());
            }
            return this.mGuidanceControl.SetCruiseSetting(bundle);
        }
        return false;
    }

    public void SetFullViewState(boolean z) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(TAG, "SetFullViewState: " + z);
            }
            this.mGuidanceControl.SetFullViewState(z);
        }
    }

    @Deprecated
    public void SetOtherCameraSpeak(boolean z) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            this.mGuidanceControl.SetOtherCameraSpeak(z);
        }
    }

    @Deprecated
    public void SetOverspeedSpeak(boolean z) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            this.mGuidanceControl.SetOverspeedSpeak(z);
        }
    }

    @Deprecated
    public void SetStraightSpeak(boolean z) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            this.mGuidanceControl.SetStraightSpeak(z);
        }
    }

    public void SetTrackData(Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            this.mGuidanceControl.SetTrackData(bundle);
        }
    }

    public void UpdateSensor(double d, double d2, double d3, double d4, double d5, double d6) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            this.mGuidanceControl.UpdateSensor(d, d2, d3, d4, d5, d6);
        }
    }

    public void ZoomToFullView(int i) {
        if (this.mGuidanceControl == null || !com.baidu.navisdk.module.init.a.a()) {
            return;
        }
        this.mGuidanceControl.ZoomToFullView(i);
    }

    public void addNaviListener(com.baidu.navisdk.module.pronavi.message.f fVar) {
        if (fVar != null && !this.mNaviListeners.contains(fVar)) {
            this.mNaviListeners.add(fVar);
        }
    }

    public void addRGInfoListeners(g gVar) {
        if (gVar == null || this.mRGInfoListeners.contains(gVar)) {
            return;
        }
        this.mRGInfoListeners.add(gVar);
    }

    public void addRGSubStatusListener(c cVar) {
        if (cVar == null) {
            return;
        }
        this.mSubStatusListeners.add(cVar);
    }

    public int calcOtherRoute(int i, int i2) {
        if (this.mGuidanceControl == null || !com.baidu.navisdk.module.init.a.a()) {
            return -1;
        }
        int CalcOtherRoute = this.mGuidanceControl.CalcOtherRoute(i, i2);
        this.mOtherRequestId = CalcOtherRoute;
        return CalcOtherRoute;
    }

    public boolean cancelOffline2OnlineRoute() {
        if (LogUtil.LOGGABLE) {
            com.baidu.navisdk.util.common.g.ROUTE_GUIDE.e(TAG, "cancelOffline2OnlineRoute --> mGuidanceControl = " + this.mGuidanceControl);
        }
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            try {
                return this.mGuidanceControl.cancelCalcRoute(this.mOtherRequestId, false, 1);
            } catch (Throwable th) {
                if (LogUtil.LOGGABLE) {
                    com.baidu.navisdk.util.common.g.ROUTE_GUIDE.e(TAG, "cancelOffline2OnlineRoute --> e = " + th);
                }
            }
        }
        return false;
    }

    public boolean cancelOtherRoute() {
        if (LogUtil.LOGGABLE) {
            com.baidu.navisdk.util.common.g.ROUTE_GUIDE.e(TAG, "cancelOtherRoute --> mGuidanceControl = " + this.mGuidanceControl);
        }
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            try {
                return this.mGuidanceControl.cancelCalcRoute(this.mOtherRequestId, false, 0);
            } catch (Throwable th) {
                if (LogUtil.LOGGABLE) {
                    com.baidu.navisdk.util.common.g.ROUTE_GUIDE.e(TAG, "cancelOtherRoute --> e = " + th);
                }
            }
        }
        return false;
    }

    public boolean checkUgcEvent(String str, Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.checkUgcEvent(str, bundle);
        }
        return false;
    }

    public int convertToMapRouteIndex(int i) {
        int i2;
        int offsetRouteIndex = JNIGuidanceControl.getInstance().getOffsetRouteIndex(i, true);
        if (offsetRouteIndex >= 0) {
            i2 = offsetRouteIndex;
        } else {
            i2 = i;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
        if (gVar.d()) {
            gVar.e("convertToMapRouteIndex() --> tabIndex = " + i + ", tempIndex = " + offsetRouteIndex + ", mapRouteIndex = " + i2);
        }
        return i2;
    }

    public int convertToTabIndex(int i) {
        int i2;
        int offsetRouteIndex = JNIGuidanceControl.getInstance().getOffsetRouteIndex(i, false);
        if (offsetRouteIndex >= 0) {
            i2 = offsetRouteIndex;
        } else {
            i2 = i;
        }
        if (LogUtil.LOGGABLE) {
            com.baidu.navisdk.util.common.g.ROUTE_GUIDE.e(TAG, "convertToTabIndex() --> mapRouteIndex = " + i + ", tempIndex = " + offsetRouteIndex + ", tabIndex = " + i2);
        }
        return i2;
    }

    public void enableExpandmapDownload(boolean z) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            this.mGuidanceControl.enableExpandmapDownload(z);
        }
    }

    public int getACEABTag() {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.getACEABTag();
        }
        return 0;
    }

    public boolean getActivityMode(int i) {
        boolean z;
        JNIGuidanceControl jNIGuidanceControl = this.mGuidanceControl;
        if (jNIGuidanceControl != null) {
            z = jNIGuidanceControl.getActivityMode(i);
        } else {
            z = false;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "getActivityMode: " + i + ", isEnable: " + z);
        }
        return z;
    }

    public int getAddDist() {
        Bundle bundle = new Bundle();
        getVehicleInfo(bundle);
        return bundle.getInt("vehicle_angle_add_dist");
    }

    public Bundle getAssistRemainDist() {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            Bundle bundle = new Bundle();
            this.mGuidanceControl.GetAssistRemainDist(bundle);
            return bundle;
        }
        return null;
    }

    public boolean getAttentionResult(int i, Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            boolean GetAttentionResult = this.mGuidanceControl.GetAttentionResult(i, bundle);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
            if (gVar.d()) {
                gVar.e("getAttentionResult() --> reqId=" + i + ",bundleOut = " + bundle);
            }
            return GetAttentionResult;
        }
        return false;
    }

    public boolean getCarInfoForAnim(GeoPoint geoPoint, double[] dArr) {
        if (LogUtil.LOGGABLE) {
            com.baidu.navisdk.util.common.g.ROUTE_GUIDE.e(TAG, "getCarInfoForAnim --> carGeoPt = " + geoPoint + ", angle =" + Arrays.toString(dArr) + ", mGuidanceControl = " + this.mGuidanceControl);
        }
        if (this.mGuidanceControl == null || !com.baidu.navisdk.module.init.a.a()) {
            return false;
        }
        double[] dArr2 = {OOXIXo.f3760XO, OOXIXo.f3760XO, OOXIXo.f3760XO};
        if (this.mGuidanceControl.getCarInfoForAnimation(dArr2)) {
            double d = dArr2[0];
            if (d != OOXIXo.f3760XO && dArr2[1] != OOXIXo.f3760XO) {
                geoPoint.setLongitudeE6((int) d);
                geoPoint.setLatitudeE6((int) dArr2[1]);
                dArr[0] = dArr2[2];
                return geoPoint.isValid();
            }
        }
        com.baidu.navisdk.util.common.g.ROUTE_GUIDE.e(TAG, "getCarInfoForAnimation ret false");
        geoPoint.setLongitudeE6(Integer.MIN_VALUE);
        geoPoint.setLatitudeE6(Integer.MIN_VALUE);
        dArr[0] = dArr2[2];
        return geoPoint.isValid();
    }

    public boolean getCarPoint(int[] iArr, int[] iArr2) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.GetCarPoint(iArr, iArr2);
        }
        return false;
    }

    public float getCarProgress() {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.GetCarProgress();
        }
        return -1.0f;
    }

    public List<Bundle> getCityPavementUgc() {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            try {
                return this.mGuidanceControl.GetCityPavementUgc();
            } catch (OutOfMemoryError unused) {
            }
        }
        return null;
    }

    public String getCurRoadConditionText() {
        JNIGuidanceControl jNIGuidanceControl = this.mGuidanceControl;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.getCurRoadConditionText();
        }
        return null;
    }

    public boolean getCurRoadName(Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.GetCurRoadName(bundle);
        }
        return false;
    }

    public long getCurrentRouteDrvieDistance() {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.GetCurrentRouteDrvieDistance();
        }
        return -1L;
    }

    public int getCurrentRouteGPCnt() {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.getCurrentRouteGPCnt();
        }
        return -1;
    }

    public List<Bundle> getDemonstrationAreaInfo() {
        JNIGuidanceControl jNIGuidanceControl = this.mGuidanceControl;
        if (jNIGuidanceControl == null) {
            return null;
        }
        return jNIGuidanceControl.getDemonstrationAreaInfo();
    }

    public Bundle getDestRecommendInfo() {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            Bundle bundle = new Bundle();
            this.mGuidanceControl.getDestRecommendPoi(bundle);
            return bundle;
        }
        return null;
    }

    public boolean getDestStreetViewInfo(Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.GetDestStreetViewInfo(bundle);
        }
        return false;
    }

    public boolean getDirectBoardInfo(Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.GetDirectBoardInfo(bundle);
        }
        return false;
    }

    public boolean getEndPageReportResult(Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.getEndPageReportResult(bundle);
        }
        return false;
    }

    public boolean getExitDirectionBoardInfo(Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.GetExitDirectionBoardInfo(bundle);
        }
        return false;
    }

    public boolean getExitFastway(Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.GetExitFastway(bundle);
        }
        return false;
    }

    public boolean getGuideEndReportResult(Bundle bundle) {
        JNIGuidanceControl jNIGuidanceControl = this.mGuidanceControl;
        if (jNIGuidanceControl == null) {
            return false;
        }
        return jNIGuidanceControl.getGuideEndReportResult(bundle);
    }

    public boolean getHUDData(Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.GetHUDData(bundle);
        }
        return false;
    }

    public boolean getHdLaneDataInfo(Bundle bundle) {
        JNIGuidanceControl jNIGuidanceControl;
        if (bundle != null && (jNIGuidanceControl = this.mGuidanceControl) != null) {
            return jNIGuidanceControl.getHdLaneDataInfo(bundle);
        }
        return false;
    }

    public boolean getHdMapData(Bundle bundle) {
        JNIGuidanceControl jNIGuidanceControl = this.mGuidanceControl;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.getHdMapData(bundle);
        }
        return false;
    }

    public boolean getHighWayInfo(Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.GetHighWayInfo(bundle);
        }
        return false;
    }

    public boolean getInHighWay(Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.GetInHighWay(bundle);
        }
        return false;
    }

    public RGLineItem[] getLaneInfo(RGLaneInfoModel rGLaneInfoModel) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.getLaneInfo(rGLaneInfoModel);
        }
        return null;
    }

    public String getLastTtsSpeech() {
        JNIGuidanceControl jNIGuidanceControl = this.mGuidanceControl;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.getLastGuideBroadcast();
        }
        return null;
    }

    public List<Bundle> getLeftRoadEventForYaw() {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            try {
                return this.mGuidanceControl.getLeftRoadEventForYaw();
            } catch (OutOfMemoryError unused) {
            }
        }
        return null;
    }

    public int getLocateMode() {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.GetLocateMode();
        }
        return -1;
    }

    public Object getNaviListenerMessage(int i, int i2, int i3, Object obj) {
        Object obj2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("getNaviListenerMessage messageCode = ");
            sb.append(i);
            sb.append(" object1 = ");
            if (obj != null) {
                obj2 = obj;
            } else {
                obj2 = "null";
            }
            sb.append(obj2);
            gVar.e(sb.toString());
        }
        Collection<com.baidu.navisdk.module.pronavi.message.f> collection = this.mNaviListeners;
        if (collection != null && collection.size() != 0) {
            for (com.baidu.navisdk.module.pronavi.message.f fVar : this.mNaviListeners) {
                if (fVar.a() != null && fVar.a().length > 0) {
                    for (int i4 = 0; i4 < fVar.a().length; i4++) {
                        if (fVar.a()[i4] == i) {
                            return fVar.b(new com.baidu.navisdk.module.pronavi.message.model.c(i, i2, i3, obj));
                        }
                    }
                }
            }
        }
        return null;
    }

    public boolean getNaviResultFeedbackData(Bundle bundle) {
        JNIGuidanceControl jNIGuidanceControl = this.mGuidanceControl;
        if (jNIGuidanceControl != null && bundle != null) {
            return jNIGuidanceControl.getNaviResultFeedbackData(bundle);
        }
        return false;
    }

    public String getNextManeuverSpeech() {
        JNIGuidanceControl jNIGuidanceControl = this.mGuidanceControl;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.getNextTurnPoint();
        }
        return null;
    }

    public int getOtherRequestId() {
        return this.mOtherRequestId;
    }

    public int getRREventType(String str, int i) {
        if (this.mGuidanceControl == null) {
            return -1;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("road_no", i);
        if (!this.mGuidanceControl.checkUgcEvent(str, bundle)) {
            return -1;
        }
        return bundle.getInt("eventType");
    }

    public byte[] getRasterExpandMapImage(String str, int i) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.GetRasterExpandMapImage(str, i);
        }
        return null;
    }

    public boolean getRasterExpandMapInfo(Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.GetRasterExpandMapInfo(bundle);
        }
        return false;
    }

    public int getRemainDist() {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            Bundle bundle = new Bundle();
            this.mGuidanceControl.getRemainRouteInfo(bundle);
            return bundle.getInt("remainDis");
        }
        return 0;
    }

    public boolean getRoadConditionAndJamInfo(Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            try {
                return this.mGuidanceControl.getRoadConditionAndJamInfo(bundle);
            } catch (Error e) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
                if (gVar.c()) {
                    gVar.c("getRoadConditionAndJamInfo error:" + e.getMessage());
                }
            }
        }
        return false;
    }

    public Bundle getRoadConditionText4LightGuide() {
        Bundle bundle = new Bundle();
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            this.mGuidanceControl.getRoadConditionText4LightGuide(bundle);
            return bundle;
        }
        return null;
    }

    public boolean getRouteDrivingInfo(Bundle bundle) {
        JNIGuidanceControl jNIGuidanceControl;
        if (bundle != null && (jNIGuidanceControl = this.mGuidanceControl) != null) {
            return jNIGuidanceControl.getCurrentRouteDriveData(bundle);
        }
        return false;
    }

    @Nullable
    public ArrayList<Bundle> getRouteGuideInfo(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
        if (gVar.d()) {
            gVar.e("getRouteGuideInfo routeIndex:" + i);
        }
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.getRouteGuideInfo(i);
        }
        return null;
    }

    public boolean getRouteInfoInUniform(int i, Bundle bundle) {
        return getRouteInfoInUniform(i, 0, bundle);
    }

    public boolean getSimpleMapInfo(Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.GetSimpleMapInfo(bundle);
        }
        return false;
    }

    public String getTruckSDKYawStamp() {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            String truckSDKYawStamp = this.mGuidanceControl.getTruckSDKYawStamp();
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "getTruckSDKYawStamp() --> stamp=" + truckSDKYawStamp);
            }
            return truckSDKYawStamp;
        }
        return null;
    }

    public String getTunnelDataForVdr(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
        if (gVar.d()) {
            gVar.e("getTunnelDataForVdr roadType:" + i);
        }
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.getTunnelDataForVdr(i);
        }
        return null;
    }

    public boolean getUgcInfoById(long j, Bundle bundle) {
        JNIGuidanceControl jNIGuidanceControl = this.mGuidanceControl;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.getUgcInfoById(j, bundle);
        }
        return false;
    }

    public boolean getVectorExpandMapInfo(Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            try {
                return this.mGuidanceControl.GetVectorExpandMapInfo(bundle);
            } catch (OutOfMemoryError unused) {
            }
        }
        return false;
    }

    public boolean getVehicleInfo(Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.GetVehicleInfo(bundle);
        }
        return false;
    }

    public boolean getViaListRemainInfo(Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.getViaListRemainInfo(bundle);
        }
        return false;
    }

    public boolean isBrowseStatus() {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.IsBrowseStatus();
        }
        return false;
    }

    public boolean isCurDriveRouteOnline() {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            boolean isCurDriveRouteOnline = this.mGuidanceControl.isCurDriveRouteOnline();
            if (LogUtil.LOGGABLE) {
                com.baidu.navisdk.util.common.g.ROUTE_GUIDE.e(TAG, "isCurDriveRouteOnline --> isCurDriveRouteOnline = " + isCurDriveRouteOnline);
            }
            return isCurDriveRouteOnline;
        }
        return false;
    }

    public boolean isDestHitWanDa(boolean z) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.IsDestHitWanDa(z);
        }
        return false;
    }

    public boolean isNavigating() {
        return this.mbIsNavigating;
    }

    public boolean isOpenHdLaneMapMode() {
        return this.isOpenHdLaneMapMode;
    }

    public boolean makeParkingSpeak(String str, int i) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.MakeParkingSpeak(str, i);
        }
        return false;
    }

    public void messageCallback(int i, int i2, int i3, Object obj) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("NaviListener callback messageCode ");
            sb.append(i);
            sb.append(" object1 = ");
            sb.append(obj != null ? obj : "null");
            gVar.e(sb.toString());
        }
        Collection<com.baidu.navisdk.module.pronavi.message.f> collection = this.mNaviListeners;
        if (collection == null || collection.size() == 0) {
            return;
        }
        for (com.baidu.navisdk.module.pronavi.message.f fVar : this.mNaviListeners) {
            if (fVar.a() != null && fVar.a().length > 0) {
                int i4 = 0;
                while (true) {
                    if (i4 >= fVar.a().length) {
                        break;
                    }
                    if (fVar.a()[i4] == i) {
                        fVar.a(new com.baidu.navisdk.module.pronavi.message.model.c(i, i2, i3, obj));
                        break;
                    }
                    i4++;
                }
            }
        }
    }

    public int naviSwitchingCalcRoute(int i) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            com.baidu.navisdk.util.common.g.ROUTE_GUIDE.e("RouteGuide", "naviSwitchingCalcRoute() type=" + i);
            return this.mGuidanceControl.naviSwitchingCalcRoute(i);
        }
        return 0;
    }

    public boolean notifyEndRouteGuide() {
        JNIGuidanceControl jNIGuidanceControl = this.mGuidanceControl;
        if (jNIGuidanceControl == null) {
            return false;
        }
        return jNIGuidanceControl.setUserCarNaviStatus(false);
    }

    public boolean notifyStartRouteGuide() {
        JNIGuidanceControl jNIGuidanceControl = this.mGuidanceControl;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.setUserCarNaviStatus(true);
        }
        return false;
    }

    public boolean onlineChangeRoute(int i) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.onlineChangeRoute(i);
        }
        return false;
    }

    public boolean pauseRouteGuide() {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.PauseRouteGuide();
        }
        return false;
    }

    public boolean payAttentionRoute(boolean z, String str, int i) {
        int i2;
        String E = com.baidu.navisdk.framework.b.E();
        Bundle bundle = new Bundle();
        if (LogUtil.LOGGABLE) {
            com.baidu.navisdk.util.common.g.ROUTE_GUIDE.e(TAG, "payAttentionRoute,baiduId:" + E + ",uniqueId:" + str + ",routeIndex:" + i + ",payAttention:" + z);
        }
        bundle.putString("baiduId", E);
        bundle.putInt("routeIndex", i);
        bundle.putString("uniqueId", str);
        if (z) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        return setInfoInUniform(4, i2, bundle);
    }

    public boolean praiseNavTrajectory(String str, boolean z) {
        int i;
        String E = com.baidu.navisdk.framework.b.E();
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        bundle.putString(Constant.MAP_KEY_UUID, str);
        if (!TextUtils.isEmpty(E)) {
            bundle.putString("baiduId", E);
        }
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        return setInfoInUniform(3, i, bundle);
    }

    public boolean refreshRoute(int i) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.RefreshRoute(i);
        }
        return false;
    }

    public void removeNaviListener(com.baidu.navisdk.module.pronavi.message.f fVar) {
        if (fVar != null) {
            this.mNaviListeners.remove(fVar);
        }
    }

    public void removeRGInfoListeners(g gVar) {
        if (gVar != null) {
            this.mRGInfoListeners.remove(gVar);
        }
    }

    public void removeRGSubStatusListener(c cVar) {
        if (cVar == null) {
            return;
        }
        this.mSubStatusListeners.remove(cVar);
    }

    public boolean removeRoute(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
        if (gVar.e()) {
            gVar.g("removeRoute type = " + i + ", mGuidanceControl = " + this.mGuidanceControl);
            gVar.f("removeRoute!");
        }
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("4.0.15.2");
            return this.mGuidanceControl.removeRoute(i);
        }
        return false;
    }

    public boolean resumeRouteGuide() {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.ResumeRouteGuide();
        }
        return false;
    }

    public boolean setActivityMode(int i, boolean z) {
        boolean z2;
        JNIGuidanceControl jNIGuidanceControl = this.mGuidanceControl;
        if (jNIGuidanceControl != null) {
            z2 = jNIGuidanceControl.setActivityMode(i, z);
        } else {
            z2 = false;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "setActivityMode: " + i + ", isEnable: " + z + ", ret: " + z2);
        }
        return z2;
    }

    public void setBlueToothStatus(boolean z, int i) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            if (LogUtil.LOGGABLE) {
                com.baidu.navisdk.util.common.g.ROUTE_GUIDE.e(TAG, "isConnected:" + z + ",sampleLevel:" + i);
            }
            VoiceInterfaceImplProxy o = com.baidu.navisdk.framework.interfaces.c.p().o();
            if (o != null) {
                o.setBlueToothStatus(z, i);
            }
        }
    }

    public boolean setBrowseStatus(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
        if (gVar.e()) {
            gVar.g("setBrowseStatus " + z);
        }
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.SetBrowseStatus(z);
        }
        return false;
    }

    public boolean setCommonRoadHDLaneBoardEnabled(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "setCommonRoadHDLaneBoardEnabled: " + z);
        }
        JNIGuidanceControl jNIGuidanceControl = this.mGuidanceControl;
        if (jNIGuidanceControl != null && jNIGuidanceControl.setCommonRoadHDLaneBoardEnabled(z)) {
            return true;
        }
        return false;
    }

    public boolean setCommonRoadHDLaneMapMode(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "setCommonRoadHDLaneMapMode: " + z);
        }
        JNIGuidanceControl jNIGuidanceControl = this.mGuidanceControl;
        if (jNIGuidanceControl != null && jNIGuidanceControl.setCommonRoadHDLaneMapMode(z)) {
            return true;
        }
        return false;
    }

    public boolean setCommuteVoiceMode(int i) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            if (LogUtil.LOGGABLE) {
                com.baidu.navisdk.util.common.g.ROUTE_GUIDE.e(TAG, "setCommuteVoiceMode,flag:" + i + ",hexStr:" + Integer.toHexString(i));
            }
            this.mGuidanceControl.SetCommuteVoiceMode(i);
            return true;
        }
        return false;
    }

    public boolean setElecCameraSpeak(boolean z) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            this.mGuidanceControl.SetElecCameraSpeak(z);
            return true;
        }
        return false;
    }

    public boolean setExpandHideType(int i) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            boolean expandMapHideType = this.mGuidanceControl.setExpandMapHideType(i);
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "setExpandHideType() --> hideType=" + i);
            }
            return expandMapHideType;
        }
        return false;
    }

    public boolean setExpandMapStatics(boolean z, int i) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            boolean expandMapStatics = this.mGuidanceControl.setExpandMapStatics(z, i);
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "setExpandMapStatics() --> show=" + z + ", statisitcsType=" + i + ", succeed = " + expandMapStatics);
            }
            return expandMapStatics;
        }
        return false;
    }

    public boolean setExtUrlParam(Bundle bundle) {
        JNIGuidanceControl jNIGuidanceControl;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "setExtUrlParam(), bundle = " + bundle);
        }
        if (bundle == null || (jNIGuidanceControl = this.mGuidanceControl) == null) {
            return false;
        }
        return jNIGuidanceControl.setExtUrlParam(bundle);
    }

    public void setGpsStatusListener(com.baidu.navisdk.comapi.routeguide.b bVar) {
        this.mGpsStatusListener = bVar;
    }

    public boolean setGpsTrackFile(String str) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.SetGpsTrackFile(str);
        }
        return false;
    }

    public void setGuideEndType(int i) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            this.mGuidanceControl.SetGuideEndType(i);
        }
    }

    public void setHUDEnabled(boolean z) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            this.mGuidanceControl.setHUDEnabled(z);
        }
    }

    public boolean setHdLaneMapMode(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "setHdLaneMapMode: " + z);
        }
        this.isOpenHdLaneMapMode = z;
        JNIGuidanceControl jNIGuidanceControl = this.mGuidanceControl;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.setHdLaneMapMode(z);
        }
        return false;
    }

    public boolean setInfoInUniform(int i, int i2, Bundle bundle) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.setInfoInUniform(i, i2, bundle);
        }
        return false;
    }

    public boolean setLightMossPreferMode(int i) {
        boolean z;
        JNIGuidanceControl jNIGuidanceControl = this.mGuidanceControl;
        if (jNIGuidanceControl != null) {
            z = jNIGuidanceControl.setLightMossPreferMode(i);
        } else {
            z = false;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
        if (gVar.d()) {
            gVar.e("setLightMossPreferMode --> mode=" + i + ",ret:" + z);
        }
        return z;
    }

    public boolean setLocateMode(int i) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.SetLocateMode(i);
        }
        return false;
    }

    public void setMessageDispatcher(com.baidu.navisdk.module.pronavi.msg.b bVar) {
        this.mMessageDispatcher = bVar;
    }

    public boolean setNaviMode(int i) {
        return setNaviMode(i, 0);
    }

    public void setOnRGInfoListener(g gVar) {
        this.mRGInfoLister = gVar;
    }

    public void setRGNaviSubStatus(com.baidu.navisdk.module.pronavi.b bVar) {
        this.mNaviSubStatus = bVar;
    }

    public void setRGSubStatusListener(e eVar) {
        this.mRGSubStatusListener = eVar;
    }

    public boolean setRasterExpandMapInfoStatus(int i, int i2) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.SetRasterExpandMapInfoStatus(i, i2);
        }
        return false;
    }

    public boolean setRoadConditionSpeak(boolean z) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            this.mGuidanceControl.SetRoadConditionSpeak(z);
            return true;
        }
        return false;
    }

    public boolean setRotateMode(int i) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.SetRotateMode(i);
        }
        return false;
    }

    public void setRouteDemoSpeed(int i) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            this.mGuidanceControl.setRouteDemoSpeed(i);
        }
    }

    @Deprecated
    public void setRouteGuideInfoListener(d dVar) {
        this.mRGInfoLister = new com.baidu.navisdk.comapi.routeguide.c(dVar);
    }

    public boolean setSaftyDriveSpeak(boolean z) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            this.mGuidanceControl.SetSaftyDriveSpeak(z);
            return true;
        }
        return false;
    }

    public boolean setSpeedCameraSpeak(boolean z) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            this.mGuidanceControl.SetSpeedCameraSpeak(z);
            return true;
        }
        return false;
    }

    public boolean setStraightDirectSpeak(boolean z) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            this.mGuidanceControl.SetStraightDirectSpeak(z);
            return true;
        }
        return false;
    }

    public boolean setUserChooseRouteBit(int i) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.setUserChooseRouteBit(i);
        }
        return false;
    }

    public boolean setUserMapScale(int i) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.SetUserMapScale(i);
        }
        return false;
    }

    public boolean setViewSegmentStatus(boolean z) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.setViewSegmentStatus(z);
        }
        return false;
    }

    public void setVoiceMode(int i) {
        setVoiceMode(i, 0L);
    }

    public boolean startRouteCruise() {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.StartRouteCruise();
        }
        return false;
    }

    public boolean startRouteGuide(boolean z, int i) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            com.baidu.navisdk.util.statistic.g.d().c();
            this.mbIsNavigating = true;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
            if (gVar.a()) {
                gVar.a("startRouteGuide:" + z + "," + i);
            }
            return this.mGuidanceControl.StartRouteGuide(z, i);
        }
        return false;
    }

    public boolean stopRouteCruise() {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.StopRouteCruise();
        }
        return false;
    }

    public boolean stopRouteGuide() {
        if (this.mGuidanceControl == null || !com.baidu.navisdk.module.init.a.a()) {
            return false;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
        if (gVar.a()) {
            gVar.a("stopRouteGuide");
        }
        this.mbIsNavigating = false;
        return this.mGuidanceControl.StopRouteGuide();
    }

    public boolean switchingToAvoidRoute(Boolean bool, int i) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.SwitchingToAvoidRoute(bool, i);
        }
        return false;
    }

    public boolean triggerDataMiningPoiReq(String str) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            JNIGuidanceControl jNIGuidanceControl = this.mGuidanceControl;
            if (str == null) {
                str = "";
            }
            return jNIGuidanceControl.triggerDataMiningPoiReq(str);
        }
        return false;
    }

    public boolean triggerGPSDataChange(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4, long j, int i5, int i6, String str) {
        if (this.mGuidanceControl == null || !com.baidu.navisdk.module.init.a.a()) {
            return false;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
        if (gVar.d()) {
            gVar.e("triggerGPSDataChange longitude:" + i + ", latitude:" + i2 + ", speed" + f + ", accuracy:" + f3 + " , locType :" + i4 + ", satellitesNum:" + i3 + ", coordinateType:" + i5 + ", gpsType:" + i6 + ", jsonData:" + str);
        }
        return this.mGuidanceControl.TriggerGPSDataChange(i, i2, f, f2, f3, f4, i3, i4, j, i5, i6, str);
    }

    public boolean triggerGPSDataChangeGCJ(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4, long j) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.TriggerGPSDataChangeGCJ(i, i2, f, f2, f3, f4, i3, i4, j);
        }
        return false;
    }

    public boolean triggerGPSStarInfoChange(int i, int i2, ArrayList<Bundle> arrayList) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            com.baidu.navisdk.util.common.g.ROUTE_GUIDE.e("RouteGuide", "triggerRecordSensorData() starVisibleCount=" + i + ", starUsedCount=" + i2);
            return this.mGuidanceControl.triggerGPSStarInfoChange(i, i2, arrayList);
        }
        return false;
    }

    public boolean triggerRecordSensorData(float f, float f2, float f3, int i) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.triggerRecordSensorData(f, f2, f3, i);
        }
        return false;
    }

    public boolean triggerStartLocationData(int i, int i2, float f, float f2, float f3, float f4, float f5, int i3, int i4, long j) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            String generateToStr = generateToStr(f5);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
            if (gVar.d()) {
                gVar.e(TAG, "triggerStartLocationData --> jsonStr = " + generateToStr);
            }
            return this.mGuidanceControl.TriggerStartLocationData(i, i2, f, f2, f3, f4, i3, i4, j, generateToStr);
        }
        return false;
    }

    public boolean triggerStartLocationDataGCJ(int i, int i2, float f, float f2, float f3, float f4, float f5, int i3, int i4, long j) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            String generateToStr = generateToStr(f5);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
            if (gVar.d()) {
                gVar.e(TAG, "triggerStartLocationData --> jsonStr = " + generateToStr);
            }
            return this.mGuidanceControl.TriggerStartLocationDataGCJ(i, i2, f, f2, f3, f4, i3, i4, j, generateToStr);
        }
        return false;
    }

    public void turnOffEnlargeRoadMap() {
        com.baidu.navisdk.util.worker.loop.b bVar = this.mMsgHandler;
        if (bVar != null) {
            bVar.ignore(4101);
            this.mMsgHandler.ignore(4102);
            this.mMsgHandler.ignore(4103);
            this.mMsgHandler.ignore(4109);
            this.mMsgHandler.ignore(4110);
            this.mMsgHandler.ignore(4111);
            this.mMsgHandler.ignore(4608);
            this.mMsgHandler.ignore(4609);
            this.mMsgHandler.ignore(4610);
            this.mMsgHandler.ignore(4179);
            this.mMsgHandler.ignore(4180);
            this.mMsgHandler.ignore(4181);
            this.mMsgHandler.ignore(4182);
            this.mMsgHandler.ignore(4204);
            this.mMsgHandler.ignore(4617);
            this.mMsgHandler.ignore(4618);
            this.mMsgHandler.ignore(4619);
        }
    }

    public void turnOnEnlargeRoadMap() {
        com.baidu.navisdk.util.worker.loop.b bVar = this.mMsgHandler;
        if (bVar != null) {
            bVar.observe(4101);
            this.mMsgHandler.observe(4102);
            this.mMsgHandler.observe(4103);
            this.mMsgHandler.observe(4109);
            this.mMsgHandler.observe(4110);
            this.mMsgHandler.observe(4111);
            this.mMsgHandler.observe(4608);
            this.mMsgHandler.observe(4609);
            this.mMsgHandler.observe(4610);
            this.mMsgHandler.observe(4179);
            this.mMsgHandler.observe(4180);
            this.mMsgHandler.observe(4181);
            this.mMsgHandler.observe(4182);
            this.mMsgHandler.observe(4204);
            this.mMsgHandler.observe(4617);
            this.mMsgHandler.observe(4618);
            this.mMsgHandler.observe(4619);
        }
    }

    public void updateInstantConfigParams(boolean z, int[] iArr, int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
        if (gVar.d()) {
            gVar.e(TAG, "updateInstantConfigParams --> isCloseInstant = " + z + ", pstLabelDis = " + Arrays.toString(iArr) + ", lastMile = " + i);
            gVar.f("updateInstantConfigParams");
        }
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            this.mGuidanceControl.setFuncConfigParams(z, iArr, i);
        }
    }

    public boolean updateSpecVoiceText(String str, boolean z) {
        if (this.mGuidanceControl != null && com.baidu.navisdk.module.init.a.a()) {
            return this.mGuidanceControl.UpdateSpecVoiceText(str, z);
        }
        return false;
    }

    public boolean getRouteInfoInUniform(int i, int i2, Bundle bundle) {
        if (this.mGuidanceControl == null || !com.baidu.navisdk.module.init.a.a()) {
            return false;
        }
        return this.mGuidanceControl.GetRouteInfoInUniform(i, i2, bundle);
    }

    public void removeRGInfoListeners(d dVar) {
        com.baidu.navisdk.comapi.routeguide.c cVar;
        if (dVar == null || !this.mRGInfoAdapterMap.containsKey(dVar) || (cVar = this.mRGInfoAdapterMap.get(dVar)) == null) {
            return;
        }
        this.mRGInfoListeners.remove(cVar);
        this.mRGInfoAdapterMap.remove(dVar);
    }

    public boolean setNaviMode(int i, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
        if (gVar.a()) {
            gVar.a("setNaviMode --> naviMode = " + i + ", subNaviMode = " + i2);
        }
        JNIGuidanceControl jNIGuidanceControl = this.mGuidanceControl;
        if (jNIGuidanceControl != null && jNIGuidanceControl.setNaviMode(i, i2)) {
            RouteGuideParams.setRouteGuideMode(i);
            return true;
        }
        if (!gVar.a()) {
            return false;
        }
        gVar.a("setNaviMode Fail");
        return false;
    }

    public void setVoiceMode(int i, long j) {
        if (this.mGuidanceControl == null || !com.baidu.navisdk.module.init.a.a()) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            com.baidu.navisdk.util.common.g.ROUTE_GUIDE.e(TAG, "setVoiceMode custom diyModeValue :" + j + ", " + i);
        }
        this.mGuidanceControl.SetVoiceMode(i, j);
    }

    public boolean ZoomToFullView(Rect rect, boolean z) {
        if (this.mGuidanceControl == null || !com.baidu.navisdk.module.init.a.a()) {
            return false;
        }
        return this.mGuidanceControl.ZoomToFullViewFromCurrent(rect, z, ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().getHeightPixels());
    }

    public void addRGInfoListeners(d dVar) {
        if (dVar == null || this.mRGInfoAdapterMap.containsKey(dVar)) {
            return;
        }
        com.baidu.navisdk.comapi.routeguide.c cVar = new com.baidu.navisdk.comapi.routeguide.c(dVar);
        this.mRGInfoAdapterMap.put(dVar, cVar);
        this.mRGInfoListeners.add(cVar);
    }

    public int calcOtherRoute(int i) {
        return calcOtherRoute(null, i, 2, 0, 0, null, null);
    }

    public int calcOtherRoute(String str, int i, int i2) {
        return calcOtherRoute(str, i, i2, 0, 0, null, null);
    }

    public int calcOtherRoute(String str, int i, int i2, Bundle bundle) {
        return calcOtherRoute(str, i, i2, 0, 0, null, bundle);
    }

    public int calcOtherRoute(String str, int i, int i2, int i3, int i4, String str2, Bundle bundle) {
        if (this.mGuidanceControl == null || !com.baidu.navisdk.module.init.a.a()) {
            return -1;
        }
        if (str == null) {
            str = "";
        }
        String str3 = str;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
        if (gVar.d()) {
            gVar.e(TAG, "calcOtherRoute placeName: " + str2);
        }
        int CalcOtherRouteNew = this.mGuidanceControl.CalcOtherRouteNew(str3, i, i2, i3, i4, str2, bundle);
        this.mOtherRequestId = CalcOtherRouteNew;
        return CalcOtherRouteNew;
    }

    public void messageCallback(int i, int i2, int i3, Object obj, Object obj2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("NaviListener callback messageCode ");
            sb.append(i);
            sb.append(" object1 = ");
            sb.append(obj != null ? obj : "null");
            sb.append(" object2 = ");
            sb.append(obj2 != null ? obj2 : "null");
            gVar.e(sb.toString());
        }
        Collection<com.baidu.navisdk.module.pronavi.message.f> collection = this.mNaviListeners;
        if (collection == null || collection.size() == 0) {
            return;
        }
        for (com.baidu.navisdk.module.pronavi.message.f fVar : this.mNaviListeners) {
            if (fVar.a() != null && fVar.a().length > 0) {
                int i4 = 0;
                while (true) {
                    if (i4 >= fVar.a().length) {
                        break;
                    }
                    if (fVar.a()[i4] == i) {
                        fVar.a(new com.baidu.navisdk.module.pronavi.message.model.c(i, i2, i3, obj, obj2));
                        break;
                    }
                    i4++;
                }
            }
        }
    }
}
