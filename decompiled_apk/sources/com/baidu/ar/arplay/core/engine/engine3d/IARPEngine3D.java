package com.baidu.ar.arplay.core.engine.engine3d;

import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public interface IARPEngine3D {
    IARPScene getCurrentScene();

    void initWorldAxis();

    void sceneRotateToCamera();

    void sceneWorldPositionToOrigin();

    void setBlendShape(HashMap<String, Double> hashMap);

    void setSkeletionData(HashMap<String, List<Double>> hashMap);

    void updateNodeUniform(String str, HashMap<String, Object> hashMap);
}
