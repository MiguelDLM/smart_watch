package com.baidu.mapapi.map;

import android.text.TextUtils;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes7.dex */
public final class BM3DModelOptions extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    private String f5787a;
    private String b;
    private LatLng c;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private int p;
    private float d = 1.0f;
    private boolean e = false;
    private boolean l = true;
    public ModelYawAxis yawAxis = ModelYawAxis.Z;
    private BM3DModelType m = BM3DModelType.BM3DModelTypeObj;
    private boolean n = false;
    private int o = 0;
    private float q = 1.0f;

    /* loaded from: classes7.dex */
    public enum BM3DModelType {
        BM3DModelTypeObj,
        BM3DModelTypeglTF
    }

    /* loaded from: classes7.dex */
    public enum ModelYawAxis {
        Z,
        X,
        Y
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        BM3DModel bM3DModel = new BM3DModel();
        if (!TextUtils.isEmpty(this.f5787a)) {
            bM3DModel.f5786a = this.f5787a;
            if (!TextUtils.isEmpty(this.b)) {
                bM3DModel.b = this.b;
                LatLng latLng = this.c;
                if (latLng != null) {
                    bM3DModel.c = latLng;
                    bM3DModel.d = this.d;
                    bM3DModel.e = this.e;
                    bM3DModel.f = this.f;
                    bM3DModel.g = this.g;
                    bM3DModel.h = this.h;
                    bM3DModel.i = this.i;
                    bM3DModel.j = this.j;
                    bM3DModel.k = this.k;
                    bM3DModel.M = this.l;
                    bM3DModel.l = this.m;
                    bM3DModel.o = this.p;
                    bM3DModel.m = this.n;
                    bM3DModel.n = this.o;
                    bM3DModel.p = this.q;
                    return bM3DModel;
                }
                throw new IllegalArgumentException("BDMapSDKException: BM3DModel mPosition can not be null");
            }
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel mModelName can not be null");
        }
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
    }

    public BM3DModelOptions animationIndex(int i) {
        this.p = i;
        return this;
    }

    public BM3DModelOptions animationRepeatCount(int i) {
        this.o = i;
        return this;
    }

    public BM3DModelOptions animationSpeed(float f) {
        this.q = f;
        return this;
    }

    public int getAnimationIndex() {
        return this.p;
    }

    public int getAnimationRepeatCount() {
        return this.o;
    }

    public float getAnimationSpeed() {
        return this.q;
    }

    public BM3DModelType getBM3DModelType() {
        return this.m;
    }

    public String getModelName() {
        return this.b;
    }

    public String getModelPath() {
        return this.f5787a;
    }

    public float getOffsetX() {
        return this.i;
    }

    public float getOffsetY() {
        return this.j;
    }

    public float getOffsetZ() {
        return this.k;
    }

    public LatLng getPosition() {
        return this.c;
    }

    public float getRotateX() {
        return this.f;
    }

    public float getRotateY() {
        return this.g;
    }

    public float getRotateZ() {
        return this.h;
    }

    public float getScale() {
        return this.d;
    }

    public int getYawAxis() {
        return this.yawAxis.ordinal();
    }

    public boolean isSkeletonAnimationEnable() {
        return this.n;
    }

    public boolean isVisible() {
        return this.l;
    }

    public boolean isZoomFixed() {
        return this.e;
    }

    public BM3DModelOptions setBM3DModelType(BM3DModelType bM3DModelType) {
        this.m = bM3DModelType;
        return this;
    }

    public BM3DModelOptions setModelName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b = str;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelName can not be null");
    }

    public BM3DModelOptions setModelPath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f5787a = str;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
    }

    public BM3DModelOptions setOffset(float f, float f2, float f3) {
        this.i = f;
        this.j = f2;
        this.k = f3;
        return this;
    }

    public BM3DModelOptions setPosition(LatLng latLng) {
        if (latLng != null) {
            this.c = latLng;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel position can not be null");
    }

    public BM3DModelOptions setRotate(float f, float f2, float f3) {
        this.f = f;
        this.g = f2;
        this.h = f3;
        return this;
    }

    public BM3DModelOptions setScale(float f) {
        this.d = f;
        return this;
    }

    public BM3DModelOptions setSkeletonAnimationEnable(boolean z) {
        this.n = z;
        return this;
    }

    public BM3DModelOptions setYawAxis(ModelYawAxis modelYawAxis) {
        this.yawAxis = modelYawAxis;
        return this;
    }

    public BM3DModelOptions setZoomFixed(boolean z) {
        this.e = z;
        return this;
    }

    public BM3DModelOptions visible(boolean z) {
        this.l = z;
        return this;
    }
}
