package com.baidu.ar.arrender;

import android.content.Context;
import android.graphics.PointF;
import android.view.ViewGroup;
import com.baidu.ar.arplay.core.engine.ARPDataInteraction;
import com.baidu.ar.arplay.core.renderer.OnNeedCacheFrameListener;
import com.baidu.ar.arplay.core.renderer.TakePictureCallback;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.bh;
import com.baidu.ar.bi;
import com.baidu.ar.bk;
import com.baidu.ar.bl;
import com.baidu.ar.fd;
import com.baidu.ar.h;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public interface IARRenderer extends IRenderer {
    void addAlgoCache(int i, boolean z);

    void calibrationTouchAngle();

    void clearAlgoCache();

    void clearCaseLutFilter();

    void convertAlgo2ScreenPoint(PointF pointF, boolean z);

    void enableSyncFaceLandmark(boolean z);

    void enableSyncRender(boolean z);

    String getCurrentCasePath();

    Matrixf4x4 getInitialTransform();

    h getLuaApplicationState();

    void getSnapShot(TakePictureCallback takePictureCallback);

    void initWorldAxis();

    boolean isDriverdByARPVersion();

    float[] location2ScreenPoint(float[] fArr);

    void pauseScene();

    void removeAlgoCache(int i);

    void render(long j);

    void resumeScene();

    void sceneRelocate();

    void sceneRotateToCamera();

    void sceneWorldPositionToOrigin();

    boolean set3DModelVisible(boolean z);

    void setAlgoHandleData(long j, String str);

    void setAvatarGestureConfig();

    void setBlendShape(HashMap<String, Double> hashMap);

    void setCacheFrameListener(OnNeedCacheFrameListener onNeedCacheFrameListener);

    void setEnabledAbilities(List<String> list);

    void setEnvironmentDataPipKV(String str, Object obj);

    void setFieldOfView(float f);

    void setGLWebViewUseable(Context context, ViewGroup viewGroup);

    void setImuType(fd fdVar);

    void setInteractionCallback(ARPDataInteraction.b bVar);

    void setNativeWebViewUseable(Context context, ViewGroup viewGroup);

    void setOffScreenGuideWork(boolean z);

    void setRenderBlendInput(boolean z);

    void setRootNodeEulerAngle(float f, float f2, float f3);

    void setRootNodeRotation(float f, float f2, float f3);

    void setSkeletonData(HashMap<String, List<Double>> hashMap);

    void setSyncFrameTimestamp(long j);

    void setTouchEnable(boolean z);

    void updateDeviceOrientation();

    String updateFilterCase(String str);

    void updateFilterData(bh bhVar);

    void updateFilterNodeData(bi biVar);

    void updateRenderCameraData(bk bkVar);

    void updateRenderNodeData(bl blVar, boolean z);

    void updateTransforms(Matrixf4x4 matrixf4x4);
}
