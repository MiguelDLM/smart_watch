package com.baidu.navisdk.ui.flip;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: classes8.dex */
public final class a extends Animation {

    /* renamed from: a, reason: collision with root package name */
    private float f8409a;
    private float b;

    @OOXIXo
    private Camera c = new Camera();
    private boolean d;
    private float e;
    private float f;

    public a(boolean z, float f, float f2) {
        this.d = z;
        this.e = f;
        this.f = f2;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, @oOoXoXO Transformation transformation) {
        Matrix matrix;
        super.applyTransformation(f, transformation);
        float f2 = this.e;
        float f3 = f2 + ((this.f - f2) * f);
        if (transformation != null) {
            matrix = transformation.getMatrix();
        } else {
            matrix = null;
        }
        this.c.save();
        if (this.d) {
            this.c.rotateY(f3);
        } else {
            this.c.rotateX(f3);
        }
        this.c.getMatrix(matrix);
        this.c.restore();
        if (matrix != null) {
            matrix.preTranslate(-this.f8409a, -this.b);
        }
        if (matrix != null) {
            matrix.postTranslate(this.f8409a, this.b);
        }
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.f8409a = i / 2;
        this.b = i2 / 2;
    }
}
