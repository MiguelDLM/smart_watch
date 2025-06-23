package com.baidu.ar.arplay.core.engine3d;

import android.util.Log;
import com.baidu.ar.arplay.core.engine.engine3d.IARPCamera;
import com.baidu.ar.arplay.core.engine.engine3d.IARPNode;
import com.baidu.ar.arplay.core.engine.engine3d.IARPScene;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class ARPScene implements IARPScene {
    private HashMap<String, ARPNode> mNodeCache;
    private long mScenePtr = -1;

    public ARPScene() {
        init();
    }

    private IARPNode arpNodeFromInternalNode(long j) {
        String nativeGetNodeName = nativeGetNodeName(j);
        ARPNode aRPNode = this.mNodeCache.get(nativeGetNodeName);
        if (aRPNode != null) {
            return aRPNode;
        }
        ARPNode aRPNode2 = new ARPNode();
        aRPNode2.bindInternal(j);
        this.mNodeCache.put(nativeGetNodeName, aRPNode2);
        return aRPNode2;
    }

    private void init() {
        this.mNodeCache = new HashMap<>();
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public IARPCamera getActiveCamera() {
        long nativeGetActiveCamera = nativeGetActiveCamera(this.mScenePtr);
        ARPCamera defaultCamera = ARPCamera.getDefaultCamera();
        defaultCamera.bindInternal(nativeGetActiveCamera);
        return defaultCamera;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public String getName(long j) {
        return nativeGetName(j);
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public IARPNode getNodeByName(String str) {
        long j = this.mScenePtr;
        if (j != -1) {
            return arpNodeFromInternalNode(nativeGetNodeByName(j, str));
        }
        Log.e(ARPScene.class.getSimpleName(), "node addr is error");
        return null;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public IARPNode getRootNode() {
        long j = this.mScenePtr;
        if (j != -1) {
            return arpNodeFromInternalNode(nativeGetRootNode(j));
        }
        Log.e(ARPScene.class.getSimpleName(), "node addr is error");
        return null;
    }

    public native long nativeGetActiveCamera(long j);

    public native String nativeGetName(long j);

    public native long nativeGetNodeByName(long j, String str);

    public native String nativeGetNodeName(long j);

    public native long nativeGetRootNode(long j);

    public native void nativeRelocate(long j);

    public native float[] nativeSceneProject(long j, float[] fArr);

    public native void nativeSetOffScreenGuideWork(long j, boolean z);

    public native void nativeSetVisible(long j, boolean z);

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public void relocate() {
        long j = this.mScenePtr;
        if (j == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
        } else {
            nativeRelocate(j);
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public float[] sceneProject(float[] fArr) {
        long j = this.mScenePtr;
        if (j != -1) {
            return nativeSceneProject(j, fArr);
        }
        Log.e(ARPScene.class.getSimpleName(), "node addr is error");
        return null;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public void setInternal(long j) {
        this.mScenePtr = j;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public void setOffScreenGuideWork(boolean z) {
        long j = this.mScenePtr;
        if (j == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
        } else {
            nativeSetOffScreenGuideWork(j, z);
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public boolean setVisible(boolean z) {
        long j = this.mScenePtr;
        if (j == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
            return false;
        }
        nativeSetVisible(j, z);
        return true;
    }
}
