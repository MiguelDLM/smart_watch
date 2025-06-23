package com.baidu.ar.arplay.core.engine.engine3d;

import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arplay.representation.Vector4f;

/* loaded from: classes7.dex */
public interface IARPNode {
    void bindInternal(long j);

    IARPNode getChildARPNode(String str);

    Vector3f getEulerAnges();

    Matrixf4x4 getInitialTransform();

    String getName();

    IARPNode getParentARPNode();

    Vector3f getPosition();

    Vector3f getRotateWorldAxis();

    Vector4f getRotation();

    Vector3f getScale();

    Matrixf4x4 getTransform();

    Vector3f getWorldPosition();

    void setEulerAnges(Vector3f vector3f);

    void setName(String str);

    void setPosition(Vector3f vector3f);

    void setRotateWorldAxis(Vector3f vector3f);

    void setRotation(Vector4f vector4f);

    void setTransform(Matrixf4x4 matrixf4x4);

    void setWorldPosition(Vector3f vector3f);

    void updateUniform(String str, Object obj);
}
