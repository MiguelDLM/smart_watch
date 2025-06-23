package com.baidu.navisdk.jni.nativeif;

import android.graphics.Rect;
import android.os.Bundle;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.model.RGLineItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class JNIGuidanceControl {
    public static final int CONNECT_STATUS_CONNECT = 2;
    public static final int CONNECT_STATUS_DISCONNECT = 1;
    public static final int CONNECT_STATUS_POS = 3;
    public static final int LOCATE_MODE_GPS = 1;
    public static final int LOCATE_MODE_MANUAL_DEMO_GPS = 4;
    public static final int LOCATE_MODE_NEMA_DEMO_GPS = 3;
    public static final int LOCATE_MODE_ROUTE_DEMO_GPS = 2;
    public static final int NET_STATUS_NO_NET = 1;
    public static final int NET_STATUS_WIFI = 2;
    public static final int NET_STATUS_WWAN = 3;
    private static volatile JNIGuidanceControl mJNIGuidance;

    /* loaded from: classes7.dex */
    public static class AvoidRoute_Map_Status {
        public static final int AvoidRoute_Map_Status_AllView = 1;
        public static final int AvoidRoute_Map_Status_Follow = 0;
        public static final int AvoidRoute_Map_Status_Invalid = -1;
    }

    /* loaded from: classes7.dex */
    public interface CommuteVoiceMode {
        public static final int ELE_EYE_DISABLE = 2;
        public static final int ELE_EYE_ENABLE = 0;
        public static final int TURN_DISABLE = 1;
        public static final int TURN_ENABLE = 0;
        public static final int VOICE_DISABLE = 4;
        public static final int VOICE_ENABLE = 0;
    }

    /* loaded from: classes7.dex */
    public interface CoordinateType {
        public static final int GCJ = 2;
        public static final int INVALID = 0;
        public static final int WGS84 = 1;
    }

    /* loaded from: classes7.dex */
    public static class GPSData {
        float mAccuracy;
        float mAltitude;
        float mBearing;
        int mLatitude;
        int mLongtitude;
        float mSpeed;
    }

    /* loaded from: classes7.dex */
    public static class Ground_Mode {
        public static final int Mode_BackGround = 1;
        public static final int Mode_ForeGround = 2;
        public static final int Mode_Invalid = 0;
    }

    /* loaded from: classes7.dex */
    public interface NEGuidanceNetMode {
        public static final int NE_Guidance_Net_Mode_Invalid = -1;
        public static final int NE_Guidance_Net_Mode_OffLine = 0;
        public static final int NE_Guidance_Net_Mode_OffLinePriority = 2;
        public static final int NE_Guidance_Net_Mode_OnLine = 1;
        public static final int NE_Guidance_Net_Mode_OnLinePriority = 3;
    }

    /* loaded from: classes7.dex */
    public interface NEPreinstallControlType {
        public static final int Hw_Viaduct = 0;
    }

    /* loaded from: classes7.dex */
    public class NaviRouteStyle {
        public static final int layerFullViewStyle = 3;
        public static final int layerITSNaviViewStyle = 4;
        public static final int layerNaviViewStyle = 1;
        public static final int layerNodeViewStyle = 2;
        public static final int layerPointSelectStyle = 5;

        public NaviRouteStyle() {
        }
    }

    /* loaded from: classes7.dex */
    public static class RouteChooseShowStatus {
        public static final int Appear = 1;
        public static final int AppearCancel = 2;
        public static final int Cancel = 4;
        public static final int Confirm = 3;
        public static final int Invalid = -1;
        public static final int NoAppear = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface RouteDataPriorityDisplayEnum {
        public static final int AUTO = 0;
        public static final int LIGHT = 2;
        public static final int MOSS = 1;
    }

    /* loaded from: classes7.dex */
    public interface RoutePlanActivityMode {
        public static final int ACTIVITY_MODE_INVALID = 0;
        public static final int ACTIVITY_MODE_WINTER_OLYMPICS = 1;
    }

    /* loaded from: classes7.dex */
    public interface TTSSource {
        public static final int CAR = 0;
        public static final int CYCLE_NAVI = 3;
        public static final int MOSS = 8;
        public static final int MOTOR = 6;
        public static final int RUN_NAVI = 5;
        public static final int SCENIC_SPOT = 4;
        public static final int TRUCK = 7;
        public static final int UN_KNOWN = -1;
        public static final int WALK_NAVI = 2;
        public static final int XD = 1;
    }

    /* loaded from: classes7.dex */
    public interface VDRSwitchType {
        public static final int Abtest = 2;
        public static final int Cloud = 1;
        public static final int Invalid = 0;
        public static final int ParkingArea = 3;
    }

    /* loaded from: classes7.dex */
    public interface VdrRetEnum {
        public static final int INVALID = 0;
        public static final int NoNewPOS = 2;
        public static final int SUCCESS = 1;
    }

    public static JNIGuidanceControl getInstance() {
        if (mJNIGuidance == null) {
            synchronized (JNIGuidanceControl.class) {
                try {
                    if (mJNIGuidance == null) {
                        mJNIGuidance = new JNIGuidanceControl();
                    }
                } finally {
                }
            }
        }
        return mJNIGuidance;
    }

    public native boolean AddPushRemind();

    public native int CalcOtherRoute(int i, int i2);

    public native int CalcOtherRouteNew(String str, int i, int i2, int i3, int i4, String str2, Bundle bundle);

    public native int CalcRoute(int i, int i2, int i3, int i4, int i5, boolean z, String str, int i6, int i7, boolean z2, String str2, String str3, String str4, int i8, int i9, String str5, float f, Bundle bundle);

    public native String CalcRouteUrlForWisdomTravel(RoutePlanNode routePlanNode, ArrayList<RoutePlanNode> arrayList, String str, String str2, int i, long j);

    public native int CalcRouteWithPB(int i, int i2, int i3, Bundle bundle, int i4, int i5);

    public native boolean CalcSpecPoiRouteInfo(ArrayList<RoutePlanNode> arrayList, int i, int i2, int i3, int i4, String str, Bundle bundle);

    @Deprecated
    public native int CancelFormOtherRoute();

    public native boolean ClearFutureRoute();

    public native boolean ClearRouteBuffer();

    public native void EnableRoadCondition(boolean z);

    public native boolean GetAssistRemainDist(Bundle bundle);

    public native boolean GetAttentionResult(int i, Bundle bundle);

    public native boolean GetAvoidInfo(int i);

    public native String GetAvoidTips(int i);

    public native boolean GetCarPoint(int[] iArr, int[] iArr2);

    public native float GetCarProgress();

    public native double GetCarRotateAngle();

    public native List<Bundle> GetCityPavementUgc();

    public native boolean GetCurRoadName(Bundle bundle);

    public native long GetCurrentRouteDrvieDistance();

    public native String GetDataStrategyArgs();

    public native boolean GetDestStreetViewInfo(Bundle bundle);

    public native boolean GetDestsRemained(int[] iArr);

    public native boolean GetDirectBoardInfo(Bundle bundle);

    public native boolean GetDriveInfo(int i, Bundle bundle);

    public native boolean GetExitDirectionBoardInfo(Bundle bundle);

    public native boolean GetExitFastway(Bundle bundle);

    public native boolean GetHUDData(Bundle bundle);

    public native int GetHUDSDKCameraInfo(ArrayList<Bundle> arrayList);

    public native int GetHUDSDKRouteInfo(ArrayList<Bundle> arrayList, ArrayList<Bundle> arrayList2, ArrayList<Bundle> arrayList3);

    public native boolean GetHighWayInfo(Bundle bundle);

    public native boolean GetInHighWay(Bundle bundle);

    public native boolean GetLocalRouteInfo(Bundle bundle);

    public native int GetLocateMode();

    public native boolean GetMapVehiclePos(Bundle bundle);

    public native boolean GetNaviRouteBound(Bundle bundle);

    public native boolean GetPassportInfo(ArrayList<Bundle> arrayList);

    public native byte[] GetRasterExpandMapImage(String str, int i);

    public native boolean GetRasterExpandMapInfo(Bundle bundle);

    public native List<Bundle> GetRoadCondition();

    public native String GetRoadEventText();

    public native void GetRouteBoundRect(ArrayList<Bundle> arrayList);

    public native int GetRouteCnt();

    public native int GetRouteInfo(int i, Bundle bundle);

    public native boolean GetRouteInfoInUniform(int i, int i2, Bundle bundle);

    public native int GetRoutePlanNodeList(ArrayList<Bundle> arrayList);

    public native boolean GetRoutePlanResultMapProtoBuf(Bundle bundle, int i);

    public native String GetRoutePlanSessionIDAndMrsl(String str, String str2);

    public native int GetRoutePlanSubResult(ArrayList<Bundle> arrayList, Bundle bundle);

    public native int GetRouteSessionIDAndMrsl(Bundle bundle);

    public native boolean GetRouteTollMode(int i, int i2);

    public native int GetShowPreferenceTap();

    public native boolean GetSimpleMapInfo(Bundle bundle);

    public native boolean GetStartPos(int[] iArr, int[] iArr2);

    public native String GetTRURlParam();

    public native ArrayList<Bundle> GetTruckRouteUgcInfo();

    public native boolean GetVectorExpandMapInfo(Bundle bundle);

    public native boolean GetVehicleInfo(Bundle bundle);

    public native boolean GetViaPoint(int i, Bundle bundle);

    public native boolean IsBrowseStatus();

    public native boolean IsDestHitWanDa(boolean z);

    public native boolean IsMapLoggerOpen();

    public native boolean LightCalcRoute(int i, int i2);

    public native boolean MakeParkingSpeak(String str, int i);

    public native boolean ManualPlaySound();

    public native boolean MeetingPreloadRoute(RoutePlanNode routePlanNode, ArrayList<RoutePlanNode> arrayList, int i, Bundle bundle);

    public native boolean PauseRouteGuide();

    public native boolean RefreshRoute(int i);

    public native boolean ResumeRouteGuide();

    public native boolean SelectRoute(int i);

    public native int SelectRouteWithMd5(String str);

    public native int SelectRouteWithMrsl(String str);

    public native boolean SetBrowseStatus(boolean z);

    public native void SetCalcRouteNetMode(int i);

    public native void SetCommuteVoiceMode(int i);

    public native boolean SetCruiseSetting(Bundle bundle);

    public native boolean SetDestsPosNav(ArrayList<RoutePlanNode> arrayList);

    public native boolean SetDestsPosNavComeFrom(ArrayList<RoutePlanNode> arrayList, int i);

    public native void SetElecCameraSpeak(boolean z);

    public native void SetFullViewState(boolean z);

    public native boolean SetGpsTrackFile(String str);

    public native void SetGuideEndType(int i);

    public native boolean SetHUDRouteGuideType(int i);

    public native void SetIsChangeBackgroun(int i);

    public native boolean SetIsMrslRoute(boolean z, String str);

    public native boolean SetLocalRouteCarInfo(String str, String str2, int i, int i2, String str3, int i3);

    public native boolean SetLocalRouteCarInfoFromBundle(int i, int i2, Bundle bundle);

    public native boolean SetLocateMode(int i);

    public native void SetMapLoggerOpen(boolean z);

    public native boolean SetNaviCaclResultSpeak(int i);

    public native boolean SetNaviPVStat(boolean z);

    public native void SetOtherCameraSpeak(boolean z);

    public native void SetOverspeedSpeak(boolean z);

    public native boolean SetRasterExpandMapInfoStatus(int i, int i2);

    public native void SetRoadConditionSpeak(boolean z);

    public native boolean SetRotateMode(int i);

    public native boolean SetRoutePlanStatistcsUrl(String str);

    public native void SetRouteSpec(boolean z);

    public native void SetSaftyDriveSpeak(boolean z);

    public native void SetSpeedCameraSpeak(boolean z);

    public native int SetStartPosNav(RoutePlanNode routePlanNode);

    public native int SetStartPosNavComeFrom(RoutePlanNode routePlanNode, int i);

    public native void SetStraightDirectSpeak(boolean z);

    public native void SetStraightSpeak(boolean z);

    public native boolean SetTrackData(Bundle bundle);

    public native boolean SetUserMapScale(int i);

    public native void SetVoiceMode(int i, long j);

    public native boolean StartAttentionRoute();

    public native boolean StartDrivingCar();

    public native boolean StartRouteCruise();

    public native boolean StartRouteGuide(boolean z, int i);

    public native boolean StopAttentionRoute();

    public native boolean StopDrivingCar();

    public native boolean StopRouteCruise();

    public native boolean StopRouteGuide();

    public native boolean SwitchingToAvoidRoute(Boolean bool, int i);

    public native boolean TriggerGPSDataChange(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4, long j, int i5, int i6, String str);

    public native boolean TriggerGPSDataChangeGCJ(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4, long j);

    public native boolean TriggerGPSStarChange();

    public native void TriggerGPSStatus(int i);

    public native boolean TriggerNetStatusChange(int i);

    public native boolean TriggerStartLocationData(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4, long j, String str);

    public native boolean TriggerStartLocationDataGCJ(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4, long j, String str);

    public native boolean TriggerStartSensorData(float f, float f2, float f3);

    public native boolean UpdateCloudTrafficInfo(int i, String str);

    public native void UpdateNmea(String str);

    public native boolean UpdateRouteRoadCondation(int i);

    public native void UpdateSensor(double d, double d2, double d3, double d4, double d5, double d6);

    public native boolean UpdateSpecVoiceText(String str, boolean z);

    public native void ZoomToFullView(int i);

    public native boolean ZoomToFullViewFromCurrent(Rect rect, boolean z, int i, int i2);

    public native boolean ZoomToRouteBound();

    public native boolean ZoomToRouteNodeBound(int i);

    public native boolean cancelCalcRoute(int i, boolean z, int i2);

    public native boolean checkUgcEvent(String str, Bundle bundle);

    public native boolean convertServicePbToCarsPb(RoutePlanNode routePlanNode, ArrayList<RoutePlanNode> arrayList, Bundle bundle, Bundle bundle2);

    public native String deleteStyleTag(String str);

    public native void enableExpandmapDownload(boolean z);

    public native int getACEABTag();

    public native boolean getActivityMode(int i);

    public native boolean getCarInfoForAnimation(double[] dArr);

    public native boolean getChargeStationBubbles(int i, ArrayList<Bundle> arrayList);

    public native boolean getChargeStationById(int i, String str, Bundle bundle);

    public native int getChargeStationCount(int i);

    public native boolean getCommuteNotifyInfo(Bundle bundle);

    public native boolean getCommuteRouteTabDynamicData(Bundle bundle);

    public native boolean getConcernRoadData(Bundle bundle);

    public native float getCurAdjustedGPSSpeed();

    public native String getCurRoadConditionText();

    public native long getCurRoutePlanInstanceID();

    public native boolean getCurrentRouteDriveData(Bundle bundle);

    public native int getCurrentRouteGPCnt();

    public native boolean getDataMiningPoiArray(ArrayList<Bundle> arrayList);

    public native List<Bundle> getDemonstrationAreaInfo();

    public native boolean getDestRecommendPoi(Bundle bundle);

    public native String getDistanceInCarPage(int i);

    public native String getETAInCarPage(int i);

    public native boolean getEndPageReportResult(Bundle bundle);

    public native boolean getFirstRouteGuideInfo(Bundle bundle);

    public native boolean getGuideEndReportResult(Bundle bundle);

    public native boolean getHdLaneDataInfo(Bundle bundle);

    public native boolean getHdMapData(Bundle bundle);

    public native boolean getIndoorCrossFloorYawInfo(Bundle bundle);

    public native RGLineItem[] getLaneInfo(RGLaneInfoModel rGLaneInfoModel);

    public native String getLastGuideBroadcast();

    public native List<Bundle> getLeftRoadEventForYaw();

    public int getMatchResultForVDR(Bundle bundle) {
        return getMatchResultForVDR(bundle, false);
    }

    public native int getMatchResultForVDR(Bundle bundle, boolean z);

    public native boolean getNaviResultFeedbackData(Bundle bundle);

    public native boolean getNeTransRouteInfo(int i, ArrayList<Bundle> arrayList, Bundle bundle, int i2);

    public native String getNearestGPVoice();

    public native String getNextTurnPoint();

    public native boolean getNotificationYBarMsg(Bundle bundle, ArrayList<Bundle> arrayList);

    public native int getOffsetRouteIndex(int i, boolean z);

    public native boolean getRawPBStream(Bundle bundle);

    public native boolean getRcPredictionYellowAndPanel(Bundle bundle);

    public native boolean getRemainRouteInfo(Bundle bundle);

    public native boolean getRoadConditionAndJamInfo(Bundle bundle);

    public native boolean getRoadConditionText4LightGuide(Bundle bundle);

    public native ArrayList<Bundle> getRouteGuideInfo(int i);

    public native ArrayList<Bundle> getRouteInfoForWisdomTravel(Bundle bundle, int i);

    public native int getRouteLabelType(int i);

    public native boolean getRouteLinkData(ArrayList<Bundle> arrayList);

    public native long getRoutePlanNetWorkTime(Bundle bundle);

    public native int getRoutePlanResultKeyWordList(ArrayList<Bundle> arrayList, ArrayList<Bundle> arrayList2, Bundle bundle);

    public native int getSelectRouteIdx();

    public native boolean getShapePointsByLink(int i, int i2, int i3, ArrayList<Bundle> arrayList);

    public native boolean getSubscribeListData(ArrayList<Bundle> arrayList);

    public native String getTruckSDKYawStamp();

    public native String getTunnelDataForVdr(int i);

    public native boolean getUgcInfoById(long j, Bundle bundle);

    public native int getVDRSwitchStatus(int i);

    public native int getValidRouteCnt();

    public native int getViaCnt();

    public native boolean getViaListRemainInfo(Bundle bundle);

    public native int getVoiceModeBitCount();

    public native long getVoiceModeValue(int i);

    public native String getXDRoadInfo();

    public native String insertStyleTag(int i, String str, String str2, String str3);

    public native boolean isBuildRouteReady(boolean z, String str);

    public native boolean isCurDriveRouteOnline();

    public native boolean isCurScreenDark();

    public native boolean isExistLocalRPData(GeoPoint geoPoint, ArrayList<GeoPoint> arrayList);

    public native String isRouteGuideCloud();

    public native boolean judgeRouteInfoAllReady(int i);

    public native boolean loadUrlAddrConfigParams(String str, String str2);

    public native int naviSwitchingCalcRoute(int i);

    public native void notifyDuerDisappear();

    public native boolean onlineChangeRoute(int i);

    public native boolean removeRoute(int i);

    public native int requestExtTabData(int i, Bundle bundle, Bundle bundle2);

    public native int requestExtTabType(int i, Bundle bundle);

    public native boolean resetUrlAddrConfigParams(String str);

    public native boolean setAcceleration(Bundle bundle);

    public native boolean setActivityMode(int i, boolean z);

    @Deprecated
    public native boolean setAvoidRouteMapStatus(int i);

    public native boolean setBeiDouStatus(boolean z);

    public native void setCloudControlCommand(String str);

    public native boolean setCommonRoadHDLaneBoardEnabled(boolean z);

    public native boolean setCommonRoadHDLaneMapMode(boolean z);

    public native boolean setEngTTSActive(boolean z);

    public native boolean setExpandMapHideType(int i);

    public native boolean setExpandMapStatics(boolean z, int i);

    public native boolean setExtUrlParam(Bundle bundle);

    public native boolean setFuncConfigParams(boolean z, int[] iArr, int i);

    public native boolean setGetPointsFrequency(int i);

    public native boolean setGravity(Bundle bundle);

    public native boolean setGroundMode(int i);

    public native void setHUDEnabled(boolean z);

    public native boolean setHdLaneMapMode(boolean z);

    public native boolean setIndoorParkStatus(int i);

    public native boolean setInfoInUniform(int i, int i2, Bundle bundle);

    public native boolean setIsMMPlus(boolean z);

    public native boolean setIsSendNaviDelayMsg(boolean z);

    public native boolean setLightMossPreferMode(int i);

    public native boolean setMagnetism(Bundle bundle);

    public native boolean setMultiRoutePlanUserSetting(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4);

    public native boolean setNaviMode(int i, int i2);

    public native boolean setNaviPageStatus(int i, int i2);

    public native boolean setPreinstallControl(int i, boolean z);

    public native boolean setRcPredictionRatio(float f, boolean z);

    public native boolean setRouteAnimation(int i, boolean z);

    public native void setRouteDemoSpeed(int i);

    public native boolean setRoutePlanTokenParam(String str);

    @Deprecated
    public native boolean setRoutePlanUserSetting(int i, int i2);

    public native boolean setSdkDestPosNav(ArrayList<RoutePlanNode> arrayList);

    public native boolean setShowRouteChoose(int i, int i2, int i3);

    public native boolean setSpecVoiceTaskId(String str, boolean z);

    public native boolean setSpecVoiceTaskIdWithSampleRate(String str, boolean z, int i);

    public native void setStartPosLocInfo(String str);

    public native boolean setStartVDRFailed();

    public native boolean setTTSPlayEnd();

    public native boolean setTracfficLightSwitch(Bundle bundle);

    public native boolean setTripMode(int i);

    public native boolean setUncalMagnetism(Bundle bundle);

    public native boolean setUserCarNaviStatus(boolean z);

    public native boolean setUserChooseRouteBit(int i);

    public native boolean setViewSegmentStatus(boolean z);

    public native void setVoicePlayResult(boolean z, int i);

    public native boolean setYBarTypeAndPriorityArray(int i, int[] iArr, int[] iArr2, int[] iArr3);

    public native boolean startRcPrediction();

    public native boolean stopRcPrediction();

    public native boolean switch2AlternativeRoute(int i);

    public native long switchNaviTabByInstanceId(long j);

    public native boolean triggerDataMiningPoiReq(String str);

    public native boolean triggerFastRouteStatus(int i);

    public native boolean triggerGPSStarInfoChange(int i, int i2, ArrayList<Bundle> arrayList);

    public native boolean triggerPressureChange(float f);

    public native boolean triggerRecordSensorData(float f, float f2, float f3, int i);

    public native boolean triggerSensorAngle(double d, double d2);

    public native boolean triggerVDRDataChangeWithJson(String str);

    public native boolean triggerVmsrResult(int i);

    public native long uidCodecDecode(String str);

    public native String uidCodecEncode(long j);
}
