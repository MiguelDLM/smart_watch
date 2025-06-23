package com.octopus.ad.internal.animation;

import Ix00oIoI.XO;
import Ix00oIoI.oIX0oI;
import android.content.Context;
import android.widget.ViewAnimator;

/* loaded from: classes11.dex */
public class Animator extends ViewAnimator {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public TransitionDirection f18628IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public TransitionType f18629Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public long f18630Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public XO f18631XO;

    public Animator(Context context, TransitionType transitionType, TransitionDirection transitionDirection, long j) {
        super(context);
        this.f18631XO = null;
        this.f18629Oo = transitionType;
        this.f18628IXxxXO = transitionDirection;
        this.f18630Oxx0xo = j;
        this.f18631XO = oIX0oI.oIX0oI(transitionType, j, transitionDirection);
        oIX0oI();
    }

    @Override // android.view.View
    public void clearAnimation() {
        setInAnimation(null);
        setOutAnimation(null);
    }

    public TransitionDirection getTransitionDirection() {
        return this.f18628IXxxXO;
    }

    public long getTransitionDuration() {
        return this.f18630Oxx0xo;
    }

    public TransitionType getTransitionType() {
        return this.f18629Oo;
    }

    public void oIX0oI() {
        XO xo2 = this.f18631XO;
        if (xo2 != null) {
            setInAnimation(xo2.oIX0oI());
            setOutAnimation(this.f18631XO.II0xO0());
        }
    }

    public void setTransitionDirection(TransitionDirection transitionDirection) {
        if (this.f18628IXxxXO != transitionDirection) {
            this.f18628IXxxXO = transitionDirection;
            this.f18631XO = oIX0oI.oIX0oI(this.f18629Oo, this.f18630Oxx0xo, transitionDirection);
            oIX0oI();
        }
    }

    public void setTransitionDuration(long j) {
        if (this.f18630Oxx0xo != j) {
            this.f18630Oxx0xo = j;
            this.f18631XO = oIX0oI.oIX0oI(this.f18629Oo, j, this.f18628IXxxXO);
            oIX0oI();
        }
    }

    public void setTransitionType(TransitionType transitionType) {
        if (this.f18629Oo != transitionType) {
            this.f18629Oo = transitionType;
            this.f18631XO = oIX0oI.oIX0oI(transitionType, this.f18630Oxx0xo, this.f18628IXxxXO);
            oIX0oI();
        }
    }
}
