package com.baidu.platform.comjni.bikenavi;

import android.os.Bundle;

/* loaded from: classes8.dex */
public class JNIGuidanceControl {
    public native byte[] GetProtobufResult(long j, int i);

    public native int SearchRoutePlan(long j, String str);

    public native int calcRoute(long j, int i, int i2, int i3, byte[] bArr);

    public native int calcRouteForRouteBook(long j, int i, int i2, byte[] bArr);

    public native boolean cancelCalcRoute(long j);

    public native boolean changePDRStrategyConfig(long j, Bundle bundle);

    public native void changeWalkDirectionStrategyConfig(long j, Bundle bundle);

    public native boolean checkPointNearbyRoute(long j, double d, double d2, int i);

    public native void enterFreeStatus(long j);

    public native void exchangeKeyForCarNavi(long j, String str, String str2);

    public native boolean getAllNaviNodes(long j, Bundle bundle);

    public native boolean getCarPoint(long j, int[] iArr, int[] iArr2);

    public native boolean getCarPointMC(long j, int[] iArr, int[] iArr2);

    public native void getConnectedPois(long j, Bundle bundle);

    public native int getCurCorrectDirection(long j);

    public native byte[] getCurPanoImage(long j);

    public native boolean getCurPanoramaRoute(long j, int i, int i2, int i3, int i4, Bundle bundle);

    public native boolean getCurViaPoiPanoImage(long j, Bundle bundle);

    public native void getFacePoiInfo(long j, Bundle bundle);

    public native boolean getFirstParagraph(long j, Bundle bundle);

    public native boolean getGPSMatchResult(long j, Bundle bundle);

    public native boolean getGuideParagraph(long j, int i, int i2, Bundle bundle);

    public native void getIndoorAllPoi(long j, Bundle bundle);

    public native void getLastLocationRouteInfo(long j, Bundle bundle);

    public native boolean getLeftNaviRouteBound(long j, Bundle bundle);

    public native void getMatchRouteInfo(long j, Bundle bundle);

    public native int getNavId(long j);

    public native boolean getNaviRouteBoundWithNoMargin(long j, Bundle bundle);

    public native boolean getNormalWalkSignDes(long j, Bundle bundle, Bundle bundle2);

    public native boolean getPDRUsingStatusInTurningCorner(long j);

    public native boolean getParagraphBound(long j, int i, Bundle bundle);

    public native void getPois(long j, Bundle bundle);

    public native byte[] getRouteDataBuffer(long j);

    public native boolean getRouteIDInfo(long j, Bundle bundle);

    public native boolean getRouteInfoItemPano(long j, int i, Bundle bundle);

    public native boolean getRouteResult(long j, int i, Bundle bundle);

    public native boolean getSimpleMapInfo(long j, Bundle bundle);

    public native boolean getTrafficFacilities(long j, Bundle bundle);

    public native boolean getTravelData(long j, Bundle bundle);

    public native String getUploadParamBundle(long j);

    public native boolean getViaNaviNodes(long j, Bundle bundle);

    public native String getWalkCountData(long j);

    public native boolean isBrowseStatus(long j);

    public native boolean isEngineIndoorNaviDefine(long j);

    public native void leaveFreeStatus(long j);

    public native void needShowPoiPanoImage(long j, boolean z);

    public native void pauseReRouteCalcRoute(long j);

    public native boolean pauseRouteGuide(long j);

    public native boolean playSound(long j, String str);

    public native boolean prepareRouteGuide(long j);

    public native void registerGetLaunchSystemTime(long j);

    public native boolean removeRoute(long j);

    public native void resumeReRouteCalcRoute(long j);

    public native boolean resumeRouteGuide(long j);

    public native boolean setARRouteResID(long j, int i, int i2);

    public native void setAvageSpeed(long j, float f);

    public native boolean setBrowseStatus(long j, boolean z);

    public native void setGPSDriftModeStatus(long j, boolean z);

    public native boolean setGpsTrackFile(long j, String str);

    public native boolean setGuidanceSpeed(long j, int i);

    public native void setGuideTextMaxWordCnt(long j, int i);

    public native void setInitalGPS(long j, double[] dArr, double[] dArr2, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, String[] strArr, String[] strArr2, int[] iArr, int[] iArr2);

    public native boolean setLocateMode(long j, int i);

    public native void setMapZoomLevel(long j, float f);

    public native boolean setNaviMode(long j, int i);

    public native boolean setNaviNodes(long j, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4);

    public native boolean setNaviScene(long j, int i);

    public native boolean setNaviType(long j, int i);

    public native boolean setNetStatistics(long j, String str);

    public native boolean setOperateStatus(long j, int i);

    public native boolean setOriNaviOverlooking(long j, int i);

    public native void setPDRModeStatus(long j, boolean z);

    public native void setPDRTurningCornerModeStatus(long j, boolean z);

    public native void setParagraphFocus(long j, int i);

    public native void setPhoneConfig(long j, Bundle bundle);

    public native boolean setRotateMode(long j, int i);

    public native void setTrackRecordValid(long j, boolean z);

    public native void setVdJsonString(long j, String str);

    public native boolean setVehiclePos(long j, int i, int i2, int i3, String str, String str2);

    public native void setYawByHMMStatus(long j, boolean z);

    public native void showArLayerInVPS(long j, boolean z);

    public native void showFloor(long j, String str, String str2);

    public native void showNPCModel(long j, boolean z);

    public native boolean startRouteGuide(long j);

    public native boolean startWalkRecord(long j, String str);

    public native boolean stopRouteGuide(long j);

    public native boolean stopWalkRecord(long j);

    public native void supportIndoorNavi(long j, boolean z);

    public native boolean triggerGPSDataChange(long j, double d, double d2, float f, float f2, float f3, float f4, String str, String str2, int i, int i2, int i3, int i4, int i5, float f5);

    public native boolean triggerNetStatusChange(long j, int i);

    public native boolean triggerPDRDataChange(long j, double d, double d2, float f, float f2, float f3, float f4, String str, String str2, int i, int i2, int i3, int i4, int i5, float f5);

    public native void triggerSensorVerification(long j, boolean z);

    public native void updateConfig(long j, boolean z);

    public native void updateSensor(long j, double d, double d2, double d3, double d4, double d5, double d6);

    public native int uploadOperationIntegral(long j, long j2, int i, String str, Bundle bundle);
}
