package com.baidu.ar.arplay.core.engine.engine3d;

/* loaded from: classes7.dex */
public interface IARPScene {
    IARPCamera getActiveCamera();

    String getName(long j);

    IARPNode getNodeByName(String str);

    IARPNode getRootNode();

    void relocate();

    float[] sceneProject(float[] fArr);

    void setInternal(long j);

    void setOffScreenGuideWork(boolean z);

    boolean setVisible(boolean z);
}
