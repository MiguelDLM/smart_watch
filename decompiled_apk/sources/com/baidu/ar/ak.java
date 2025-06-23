package com.baidu.ar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/* loaded from: classes7.dex */
public class ak {
    private b gH;
    private e gR;
    private e gS;
    private e gT;
    private e gU;
    private boolean gI = true;
    private boolean gJ = false;
    private boolean gK = false;
    private boolean isScreenOrientationLandscape = false;
    private int gL = 0;
    private int gM = 0;
    private c gN = c.EStatSingFingerCandidate;
    private e gO = null;
    private Map<Integer, Vector<Float>> gP = new HashMap();
    private boolean gQ = true;
    private double gV = -1.0d;
    private boolean gW = true;
    private boolean gX = false;
    private d gY = d.ESWIPE_RIGHT;
    private al gG = new al();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ar.ak$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] gZ;

        static {
            int[] iArr = new int[c.values().length];
            gZ = iArr;
            try {
                iArr[c.EStatSingFingerCandidate.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                gZ[c.EStatTwoFingersCandidate.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                gZ[c.EStatScroll.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                gZ[c.EStatSwipe.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                gZ[c.EStatTwoFingersScroll.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                gZ[c.EStatPinchAndUnpinch.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                gZ[c.EStatTwoFingersRotate.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                gZ[c.EStatLongPress.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                gZ[c.EScrollAfterLongPress.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                gZ[c.EStatPinch.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                gZ[c.EStatUnPinch.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                gZ[c.EStatUnknown.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public enum a {
        EGESTURE_CLICK,
        EGESTURE_DOUBLE_CLICK,
        EGESTURE_LONG_PRESS,
        EGESTURE_SWIPE,
        EGESTURE_SINGLE_FINGER_SCROLL,
        EGESTURE_TWO_FINGER_SCROLL,
        EGESTURE_TWO_FINGER_PINCH,
        EGESTURE_TWO_FINGER_UNPINCH,
        EGESTURE_TWO_FINGER_ROTATE,
        EGESTURE_CLEAR
    }

    /* loaded from: classes7.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            super.handleMessage(message);
            if (ak.this.gK) {
                return;
            }
            int i = message.what;
            if (i != 1) {
                if (i == 2 && (obj = message.obj) != null) {
                    e eVar = (e) obj;
                    ak.this.a(eVar.time, eVar.id, eVar.x, eVar.y);
                    return;
                }
                return;
            }
            if (ak.this.gN == c.EStatSingFingerCandidate && ak.this.gQ) {
                ak.this.gN = c.EStatLongPress;
                ak.this.b(System.currentTimeMillis(), ak.this.gR.id, ak.this.gR.x, ak.this.gR.y);
            }
        }
    }

    /* loaded from: classes7.dex */
    public enum c {
        EStatSingFingerCandidate,
        EStatTwoFingersCandidate,
        EStatLongPress,
        EStatScroll,
        EStatSwipe,
        EStatTwoFingersScroll,
        EStatPinch,
        EStatUnPinch,
        EScrollAfterLongPress,
        EStatPinchAndUnpinch,
        EStatTwoFingersRotate,
        EStatUnknown
    }

    /* loaded from: classes7.dex */
    public enum d {
        ESWIPE_RIGHT,
        ESWIPE_LEFT,
        ESWIPE_UP,
        ESWIPE_DOWN
    }

    /* loaded from: classes7.dex */
    public class e {
        int id;
        long time;
        float x;
        float y;

        private e() {
            this.id = -1;
            this.x = -1.0f;
            this.y = -1.0f;
            this.time = -1L;
        }

        public void a(MotionEvent motionEvent, int i) {
            this.id = motionEvent.getPointerId(i);
            this.x = motionEvent.getX(i);
            this.y = motionEvent.getY(i);
            this.time = motionEvent.getEventTime();
        }

        public String toString() {
            return "fingerId: " + this.id + " && x,y: " + this.x + "," + this.y + " && time: " + this.time;
        }

        public /* synthetic */ e(ak akVar, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public enum f {
        ETOUCH_BEGIN,
        ETOUCH_MOVE,
        ETOUCH_END,
        ETOUCH_CANCEL
    }

    public ak(Looper looper) {
        AnonymousClass1 anonymousClass1 = null;
        this.gR = new e(this, anonymousClass1);
        this.gS = new e(this, anonymousClass1);
        this.gT = new e(this, anonymousClass1);
        this.gU = new e(this, anonymousClass1);
        this.gH = new b(looper);
        onResume();
    }

    private double a(double d2, double d3, double d4, double d5) {
        double atan2 = Math.atan2(d5, d4) - Math.atan2(d3, d2);
        return atan2 > 3.141592653589793d ? atan2 - 6.283185307179586d : atan2 < -3.141592653589793d ? atan2 + 6.283185307179586d : atan2;
    }

    private void aR() {
        a(a.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
    }

    private void aS() {
        ARPEngine.getInstance().onGestureUpdateWithScaleFinish(a.EGESTURE_CLEAR.ordinal(), -1L, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f, true);
    }

    private void aT() {
        if (this.gH.hasMessages(2)) {
            this.gH.removeMessages(2);
            e eVar = this.gO;
            if (eVar != null) {
                a(eVar.time, eVar.id, eVar.x, eVar.y);
                this.gO = null;
            }
        }
    }

    private void c(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            d(motionEvent);
            return;
        }
        if (actionMasked == 1) {
            f(motionEvent);
        } else if (actionMasked == 2) {
            e(motionEvent);
        } else {
            if (actionMasked != 5) {
                return;
            }
            g(motionEvent);
        }
    }

    private void clearStatus() {
        this.gN = c.EStatSingFingerCandidate;
        this.gQ = true;
        this.gV = -1.0d;
        this.gH.removeMessages(1);
        if (this.gH.hasMessages(2)) {
            return;
        }
        aR();
    }

    private void e(MotionEvent motionEvent) {
        e eVar = this.gR;
        double a2 = a(eVar.x, eVar.y, motionEvent.getX(), motionEvent.getY());
        Log.d("ARPTouchInput", "touchMoveInSingleFingerCandidate() distance = " + a2);
        if (a2 < 20.0d) {
            if (motionEvent.getEventTime() - motionEvent.getDownTime() > 600) {
                this.gN = c.EStatLongPress;
                b(motionEvent.getDownTime(), this.gR.id, motionEvent.getX(), motionEvent.getY());
                this.gH.removeMessages(1);
            }
        } else if (a2 < 50.0d) {
            this.gQ = false;
        } else {
            aT();
            this.gN = c.EStatScroll;
            a(motionEvent.getEventTime(), this.gR.id, motionEvent.getX(), motionEvent.getY(), q(motionEvent), r(motionEvent));
            this.gH.removeMessages(1);
        }
        this.gS.a(motionEvent, 0);
    }

    private void g(MotionEvent motionEvent) {
        c cVar;
        Log.d("ARPTouchInput", "touchPointerDownInSingleFingerCandidate() mFirstFingnerInClickArea = " + this.gQ);
        if (this.gQ) {
            this.gT.a(motionEvent, motionEvent.getActionIndex());
            a(this.gT, this.gU);
            cVar = c.EStatTwoFingersCandidate;
        } else {
            cVar = c.EStatUnknown;
        }
        this.gN = cVar;
        aT();
    }

    private void h(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (2 != motionEvent.getActionMasked()) {
            this.gN = c.EStatUnknown;
            return;
        }
        float u = u(motionEvent);
        float v = v(motionEvent);
        float w = w(motionEvent);
        float x = x(motionEvent);
        e eVar = this.gR;
        double a2 = a(eVar.x, eVar.y, u, v);
        e eVar2 = this.gT;
        double a3 = a(eVar2.x, eVar2.y, w, x);
        if ((a2 > 50.0d || a3 > 50.0d) && a2 > 20.0d && a3 > 20.0d) {
            e eVar3 = this.gR;
            float f4 = eVar3.x;
            float f5 = eVar3.y;
            e eVar4 = this.gT;
            double a4 = a(f4, f5, u, v, eVar4.x, eVar4.y, w, x);
            if (a4 < 0.7853981633974483d) {
                this.gN = c.EStatTwoFingersScroll;
                a(motionEvent.getDownTime(), this.gR.id, u, v, q(motionEvent), r(motionEvent), this.gT.id, w, x, s(motionEvent), t(motionEvent));
                Log.d("ARPTouchInput", "EStatTwoFingersScroll");
                f2 = w;
                f3 = x;
            } else {
                if (a4 > 3.141592653589793d || a4 <= 1.5707963267948966d) {
                    f2 = w;
                    f3 = x;
                    this.gN = c.EStatPinchAndUnpinch;
                } else {
                    e eVar5 = this.gR;
                    float f6 = eVar5.x;
                    e eVar6 = this.gT;
                    float f7 = (eVar6.x + f6) / 2.0f;
                    float f8 = eVar5.y;
                    float f9 = (eVar6.y + f8) / 2.0f;
                    double a5 = a(f7, f9, f6, f8, f6, f8, u, v);
                    e eVar7 = this.gT;
                    float f10 = eVar7.x;
                    float f11 = eVar7.y;
                    double a6 = a(f7, f9, f10, f11, f10, f11, w, x);
                    if (Math.abs(a5 - 1.5707963267948966d) < 0.6283185307179586d || Math.abs(a6 - 1.5707963267948966d) < 0.6283185307179586d) {
                        f2 = w;
                        f3 = x;
                        this.gN = c.EStatTwoFingersRotate;
                    } else {
                        this.gN = c.EStatPinchAndUnpinch;
                        f2 = w;
                        f3 = x;
                    }
                }
                this.gV = a(u, v, f2, f3);
            }
        } else {
            f3 = x;
            f2 = w;
        }
        e eVar8 = this.gS;
        eVar8.x = u;
        eVar8.y = v;
        eVar8.time = motionEvent.getEventTime();
        e eVar9 = this.gU;
        eVar9.x = f2;
        eVar9.y = f3;
        eVar9.time = motionEvent.getEventTime();
    }

    private void i(MotionEvent motionEvent) {
        try {
            if (5 == motionEvent.getActionMasked()) {
                e eVar = this.gR;
                eVar.a(motionEvent, eVar.id);
                a(this.gR, this.gS);
                this.gT.a(motionEvent, motionEvent.getActionIndex());
                a(this.gT, this.gU);
                this.gN = c.EStatTwoFingersCandidate;
                al alVar = this.gG;
                if (alVar == null || !alVar.aY()) {
                    return;
                }
                aR();
                return;
            }
            if (6 != motionEvent.getActionMasked()) {
                if (1 == motionEvent.getActionMasked()) {
                    clearStatus();
                    return;
                }
                if (2 == motionEvent.getActionMasked()) {
                    if (motionEvent.getEventTime() - this.gS.time >= 1) {
                        float u = u(motionEvent);
                        float v = v(motionEvent);
                        a(motionEvent.getEventTime(), this.gR.id, u, v, q(motionEvent), r(motionEvent));
                        e eVar2 = this.gS;
                        float f2 = u - eVar2.x;
                        float f3 = v - eVar2.y;
                        float eventTime = f2 / ((float) (motionEvent.getEventTime() - this.gS.time));
                        float eventTime2 = f3 / ((float) (motionEvent.getEventTime() - this.gS.time));
                        al alVar2 = this.gG;
                        if (alVar2 != null && alVar2.ba()) {
                            if (Math.abs(f2) > Math.abs(f3) && Math.abs(f2) > 100.0d && Math.abs(eventTime) > 20.0d) {
                                this.gY = f2 > 0.0f ? d.ESWIPE_RIGHT : d.ESWIPE_LEFT;
                            } else if (Math.abs(f3) > Math.abs(f2) && Math.abs(f3) > 100.0d && Math.abs(eventTime2) > 20.0d) {
                                this.gY = f3 > 0.0f ? d.ESWIPE_DOWN : d.ESWIPE_UP;
                            }
                            this.gN = c.EStatSwipe;
                        }
                        e eVar3 = this.gS;
                        eVar3.x = u;
                        eVar3.y = v;
                        eVar3.time = motionEvent.getEventTime();
                        return;
                    }
                    return;
                }
            }
            this.gN = c.EStatUnknown;
        } catch (Exception unused) {
            Log.e("ARPTouchInput", "Monkey event.getX Exception");
        }
    }

    private void j(MotionEvent motionEvent) {
        if (1 == motionEvent.getActionMasked()) {
            a(motionEvent.getEventTime(), this.gR.id, this.gY.ordinal());
        }
    }

    private void k(MotionEvent motionEvent) {
        if (5 != motionEvent.getActionMasked()) {
            if (6 == motionEvent.getActionMasked()) {
                this.gN = c.EStatScroll;
                int action = (motionEvent.getAction() & 65280) >>> 8;
                e eVar = this.gR;
                if (action == eVar.id) {
                    a(this.gT, eVar);
                    a(this.gU, this.gS);
                }
                aR();
                return;
            }
            if (2 == motionEvent.getActionMasked()) {
                if (motionEvent.getEventTime() - this.gS.time < 1 || motionEvent.getEventTime() - this.gU.time < 1) {
                    return;
                }
                float u = u(motionEvent);
                float v = v(motionEvent);
                float w = w(motionEvent);
                float x = x(motionEvent);
                a(motionEvent.getEventTime(), this.gR.id, u, v, q(motionEvent), r(motionEvent), this.gT.id, w, x, s(motionEvent), t(motionEvent));
                e eVar2 = this.gR;
                eVar2.x = u;
                eVar2.y = v;
                this.gS.time = motionEvent.getEventTime();
                e eVar3 = this.gU;
                eVar3.x = w;
                eVar3.y = x;
                eVar3.time = motionEvent.getEventTime();
                return;
            }
        }
        this.gN = c.EStatUnknown;
    }

    private void l(MotionEvent motionEvent) {
        if (5 == motionEvent.getActionMasked()) {
            this.gN = c.EStatUnknown;
            this.gW = true;
            return;
        }
        if (6 == motionEvent.getActionMasked()) {
            this.gN = c.EStatScroll;
            int action = (motionEvent.getAction() & 65280) >>> 8;
            e eVar = this.gR;
            if (action == eVar.id) {
                eVar.id = this.gT.id;
            }
            this.gW = true;
            aS();
            return;
        }
        if (2 != motionEvent.getActionMasked()) {
            this.gN = c.EStatUnknown;
            return;
        }
        if (motionEvent.getEventTime() - this.gS.time < 1 || motionEvent.getEventTime() - this.gU.time < 1) {
            return;
        }
        float u = u(motionEvent);
        float v = v(motionEvent);
        float w = w(motionEvent);
        float x = x(motionEvent);
        double a2 = a(u, v, w, x);
        a(motionEvent.getEventTime(), this.gR.id, u, v, q(motionEvent), r(motionEvent), this.gT.id, w, x, s(motionEvent), t(motionEvent), a2 < this.gV);
        this.gV = a2;
        e eVar2 = this.gR;
        eVar2.x = u;
        eVar2.y = v;
        this.gS.time = motionEvent.getEventTime();
        e eVar3 = this.gU;
        eVar3.x = w;
        eVar3.y = x;
        eVar3.time = motionEvent.getEventTime();
    }

    private void m(MotionEvent motionEvent) {
        if (2 != motionEvent.getActionMasked()) {
            if (1 == motionEvent.getActionMasked()) {
                clearStatus();
                return;
            } else {
                this.gN = c.EStatUnknown;
                return;
            }
        }
        float u = u(motionEvent);
        float v = v(motionEvent);
        float w = w(motionEvent);
        float x = x(motionEvent);
        float f2 = this.gU.x;
        e eVar = this.gR;
        a(motionEvent.getEventTime(), this.gR.id, u, v, this.gT.id, w, x, (float) a(f2 - eVar.x, r0.y - eVar.y, w - u, x - v));
        e eVar2 = this.gR;
        eVar2.x = u;
        eVar2.y = v;
        this.gS.time = motionEvent.getEventTime();
        e eVar3 = this.gU;
        eVar3.x = w;
        eVar3.y = x;
        eVar3.time = motionEvent.getEventTime();
    }

    private void n(MotionEvent motionEvent) {
        if (2 != motionEvent.getActionMasked()) {
            if (1 == motionEvent.getActionMasked()) {
                clearStatus();
                return;
            } else {
                this.gN = c.EStatUnknown;
                return;
            }
        }
        e eVar = this.gR;
        if (a(eVar.x, eVar.y, motionEvent.getX(), motionEvent.getY()) > 50.0d) {
            this.gN = c.EScrollAfterLongPress;
            a(motionEvent.getEventTime(), this.gR.id, motionEvent.getX(), motionEvent.getY(), q(motionEvent), r(motionEvent));
            this.gR.x = u(motionEvent);
            this.gR.y = v(motionEvent);
            this.gS.time = motionEvent.getEventTime();
        }
    }

    private void o(MotionEvent motionEvent) {
        if (2 != motionEvent.getActionMasked()) {
            if (1 == motionEvent.getActionMasked()) {
                clearStatus();
                return;
            } else {
                this.gN = c.EStatUnknown;
                return;
            }
        }
        a(motionEvent.getEventTime(), this.gR.id, motionEvent.getX(), motionEvent.getY(), q(motionEvent), r(motionEvent));
        this.gR.x = u(motionEvent);
        this.gR.y = v(motionEvent);
        this.gS.time = motionEvent.getEventTime();
    }

    private void p(MotionEvent motionEvent) {
        if (1 == motionEvent.getActionMasked()) {
            clearStatus();
        }
    }

    private float q(MotionEvent motionEvent) {
        return (motionEvent.getX(motionEvent.findPointerIndex(this.gR.id)) - this.gR.x) / ((float) (motionEvent.getEventTime() - this.gS.time));
    }

    private float r(MotionEvent motionEvent) {
        return (motionEvent.getY(motionEvent.findPointerIndex(this.gR.id)) - this.gR.y) / ((float) (motionEvent.getEventTime() - this.gS.time));
    }

    private float s(MotionEvent motionEvent) {
        return (motionEvent.getX(motionEvent.findPointerIndex(this.gT.id)) - this.gU.x) / ((float) (motionEvent.getEventTime() - this.gU.time));
    }

    private float t(MotionEvent motionEvent) {
        return (motionEvent.getY(motionEvent.findPointerIndex(this.gT.id)) - this.gU.y) / ((float) (motionEvent.getEventTime() - this.gU.time));
    }

    private float u(MotionEvent motionEvent) {
        return motionEvent.getX(motionEvent.findPointerIndex(this.gR.id));
    }

    private float v(MotionEvent motionEvent) {
        return motionEvent.getY(motionEvent.findPointerIndex(this.gR.id));
    }

    private float w(MotionEvent motionEvent) {
        return motionEvent.getX(motionEvent.findPointerIndex(this.gT.id));
    }

    private float x(MotionEvent motionEvent) {
        return motionEvent.getY(motionEvent.findPointerIndex(this.gT.id));
    }

    public void f(int i, int i2) {
        Log.d("ARPTouchInput", "setScreenWidthHight width * height = " + i + " * " + i2);
        if (this.isScreenOrientationLandscape) {
            this.gL = i2;
            this.gM = i;
        } else {
            this.gL = i;
            this.gM = i2;
        }
    }

    public void onPause() {
        al alVar = this.gG;
        if (alVar != null) {
            alVar.onPause();
        }
    }

    public final void onResume() {
        al alVar = this.gG;
        if (alVar != null) {
            alVar.onResume();
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.gJ && this.gI && !this.gK) {
            a(motionEvent);
            b(motionEvent);
            return;
        }
        Log.e("ARPTouchInput", "onTouchEvent mEnginSoLoaded = " + this.gJ + " && mUserTouchEnable = " + this.gI + " && mReleased = " + this.gK);
    }

    public void release() {
        this.gK = true;
        b bVar = this.gH;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
            this.gG = null;
        }
        al alVar = this.gG;
        if (alVar != null) {
            alVar.release();
            this.gG = null;
        }
    }

    public void setScreenOrientationLandscape(boolean z) {
        Log.d("ARPTouchInput", "setScreenOrientationLandscape landscape = " + z);
        this.isScreenOrientationLandscape = z;
    }

    private double a(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        return Math.sqrt((f6 * f6) + (f7 * f7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, int i, float f2, float f3) {
        al alVar = this.gG;
        if (alVar == null || !alVar.aX()) {
            return;
        }
        a(a.EGESTURE_LONG_PRESS.ordinal(), j, i, f2, f3, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
    }

    private void d(MotionEvent motionEvent) {
        e eVar;
        this.gR.a(motionEvent, motionEvent.getActionIndex());
        a(this.gR, this.gS);
        Log.d("ARPTouchInput", "touchDownInSingleFingerCandidate() mFirstFingerTouch = " + this.gR.toString());
        if (this.gH.hasMessages(2) && (eVar = this.gO) != null) {
            float f2 = eVar.x;
            float f3 = eVar.y;
            e eVar2 = this.gR;
            if (a(f2, f3, eVar2.x, eVar2.y) > 100.0d) {
                aT();
            }
        }
        this.gH.sendEmptyMessageDelayed(1, 600L);
    }

    private void f(MotionEvent motionEvent) {
        e eVar = this.gR;
        if (a(eVar.x, eVar.y, motionEvent.getX(), motionEvent.getY()) < 20.0d && motionEvent.getEventTime() - motionEvent.getDownTime() < 300) {
            al alVar = this.gG;
            if (alVar != null && alVar.aW()) {
                if (this.gH.hasMessages(2)) {
                    this.gH.removeMessages(2);
                } else {
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    e eVar2 = new e(this, null);
                    eVar2.a(motionEvent, 0);
                    obtain.obj = eVar2;
                    this.gO = eVar2;
                    this.gH.sendMessageDelayed(obtain, 400L);
                }
            }
            a(motionEvent.getDownTime(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY());
        }
        clearStatus();
    }

    public void l(boolean z) {
        this.gJ = z;
    }

    public void m(boolean z) {
        this.gI = z;
    }

    private double a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        Log.d("ARPTouchInput", String.format("vx1 %1.3f vy1 %1.3f vx2 %1.3f vy2 %1.3f", Float.valueOf(f4 - f2), Float.valueOf(f5 - f3), Float.valueOf(f8 - f6), Float.valueOf(f9 - f7)));
        double sqrt = ((r7 * r11) + (r8 * r12)) / (Math.sqrt((r7 * r7) + (r8 * r8)) * Math.sqrt((r11 * r11) + (r12 * r12)));
        try {
            sqrt = Double.parseDouble(new DecimalFormat("#.00").format(sqrt));
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
        double acos = Math.acos(sqrt);
        Log.d("ARPTouchInput", String.format("angle is %1.3f", Double.valueOf(Math.toDegrees(acos))));
        return acos;
    }

    private void b(MotionEvent motionEvent) {
        switch (AnonymousClass1.gZ[this.gN.ordinal()]) {
            case 1:
                c(motionEvent);
                return;
            case 2:
                h(motionEvent);
                return;
            case 3:
                i(motionEvent);
                return;
            case 4:
                j(motionEvent);
                return;
            case 5:
                k(motionEvent);
                return;
            case 6:
                l(motionEvent);
                return;
            case 7:
                m(motionEvent);
                return;
            case 8:
                n(motionEvent);
                return;
            case 9:
                o(motionEvent);
                return;
            case 10:
            case 11:
            case 12:
                p(motionEvent);
                return;
            default:
                return;
        }
    }

    private void a(int i, float f2, float f3, float f4, float f5, long j, int i2, float f6) {
        float f7;
        float f8;
        float f9;
        float f10;
        int i3;
        int i4;
        if (this.isScreenOrientationLandscape) {
            f7 = this.gL - f3;
            f9 = f4;
            f8 = -f5;
            f10 = f2;
        } else {
            f7 = f2;
            f8 = f4;
            f9 = f5;
            f10 = f3;
        }
        float[] windowSize = ARPEngine.getInstance().getWindowSize();
        if (windowSize.length == 2) {
            float f11 = windowSize[0];
            if (f11 > 0.0f) {
                float f12 = windowSize[1];
                if (f12 > 0.0f && (i3 = this.gL) > 0 && (i4 = this.gM) > 0) {
                    float f13 = f11 / i3;
                    float f14 = f12 / i4;
                    f7 *= f13;
                    f8 *= f13;
                    f10 *= f14;
                    f9 *= f14;
                }
            }
        }
        ARPEngine.getInstance().onTouchUpdate(i, f7, f10, f8, f9, j, i2, f6);
    }

    private void a(int i, long j, int i2, float f2, float f3, float f4, float f5, int i3, float f6, float f7, float f8, float f9, int i4, float f10) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22;
        int i5;
        int i6;
        if (this.isScreenOrientationLandscape) {
            int i7 = this.gL;
            f11 = i7 - f3;
            f14 = f6;
            f13 = i7 - f7;
            f12 = f2;
        } else {
            f11 = f2;
            f12 = f3;
            f13 = f6;
            f14 = f7;
        }
        float[] windowSize = ARPEngine.getInstance().getWindowSize();
        if (windowSize.length == 2) {
            float f23 = windowSize[0];
            if (f23 > 0.0f) {
                float f24 = windowSize[1];
                if (f24 > 0.0f && (i5 = this.gL) > 0 && (i6 = this.gM) > 0) {
                    float f25 = f23 / i5;
                    float f26 = f24 / i6;
                    f19 = f12 * f26;
                    f20 = f11 * f25;
                    f21 = f13 * f25;
                    f22 = f14 * f26;
                    f18 = f26 * f9;
                    f17 = f25 * f8;
                    f15 = f4 * f25;
                    f16 = f5 * f26;
                    ARPEngine.getInstance().onGestureUpdate(i, j, i2, f20, f19, f15, f16, i3, f21, f22, f17, f18, i4, f10);
                }
            }
        }
        f15 = f4;
        f16 = f5;
        f17 = f8;
        f18 = f9;
        f19 = f12;
        f20 = f11;
        f21 = f13;
        f22 = f14;
        ARPEngine.getInstance().onGestureUpdate(i, j, i2, f20, f19, f15, f16, i3, f21, f22, f17, f18, i4, f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, int i, float f2, float f3) {
        al alVar = this.gG;
        if (alVar == null || !alVar.aV()) {
            return;
        }
        a(a.EGESTURE_CLICK.ordinal(), j, i, f2, f3, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
        aR();
    }

    private void a(long j, int i, float f2, float f3, float f4, float f5) {
        al alVar = this.gG;
        if (alVar == null || !alVar.aY()) {
            return;
        }
        a(a.EGESTURE_SINGLE_FINGER_SCROLL.ordinal(), j, i, f2, f3, f4, f5, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, 0.0f);
    }

    private void a(long j, int i, float f2, float f3, float f4, float f5, int i2, float f6, float f7, float f8, float f9) {
        al alVar = this.gG;
        if (alVar == null || !alVar.aZ()) {
            return;
        }
        a(a.EGESTURE_TWO_FINGER_SCROLL.ordinal(), j, i, f2, f3, f4, f5, i2, f6, f7, f8, f9, -1, 0.0f);
    }

    private void a(long j, int i, float f2, float f3, float f4, float f5, int i2, float f6, float f7, float f8, float f9, boolean z) {
        al alVar = this.gG;
        if (alVar == null || !alVar.bb()) {
            return;
        }
        if (!this.gW) {
            if ((z && !this.gX) || (!z && this.gX)) {
                aR();
            }
            this.gX = z;
        }
        int ordinal = a.EGESTURE_TWO_FINGER_UNPINCH.ordinal();
        if (z) {
            ordinal = a.EGESTURE_TWO_FINGER_PINCH.ordinal();
        }
        a(ordinal, j, i, f2, f3, f4, f5, i2, f6, f7, f8, f9, -1, 0.0f);
        if (this.gW) {
            this.gX = z;
        }
    }

    private void a(long j, int i, float f2, float f3, int i2, float f4, float f5, float f6) {
        al alVar = this.gG;
        if (alVar == null || !alVar.bc()) {
            return;
        }
        a(a.EGESTURE_TWO_FINGER_ROTATE.ordinal(), j, i, f2, f3, -1.0f, -1.0f, i2, f4, f5, -1.0f, -1.0f, -1, f6);
    }

    private void a(long j, int i, int i2) {
        al alVar = this.gG;
        if (alVar == null || !alVar.ba()) {
            return;
        }
        a(a.EGESTURE_SWIPE.ordinal(), j, i, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, i2, 0.0f);
        clearStatus();
    }

    private void a(MotionEvent motionEvent) {
        f fVar;
        float f2;
        float f3;
        int i;
        int i2;
        if (motionEvent.getPointerCount() <= 0) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float x = motionEvent.getX(actionIndex);
        float y = motionEvent.getY(actionIndex);
        long eventTime = motionEvent.getEventTime();
        float pressure = motionEvent.getPressure(actionIndex);
        float f4 = 0.0f;
        float f5 = 0.0f;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int pointerCount = motionEvent.getPointerCount();
                    int i3 = 0;
                    while (i3 < pointerCount) {
                        int pointerId2 = motionEvent.getPointerId(i3);
                        float x2 = motionEvent.getX(i3);
                        float y2 = motionEvent.getY(i3);
                        if (this.gP.containsKey(Integer.valueOf(pointerId2))) {
                            Vector<Float> vector = this.gP.get(Integer.valueOf(pointerId2));
                            f2 = x2 - vector.firstElement().floatValue();
                            f3 = y2 - vector.lastElement().floatValue();
                            vector.setElementAt(Float.valueOf(x2), 0);
                            vector.setElementAt(Float.valueOf(y2), 1);
                        } else {
                            f2 = 0.0f;
                            f3 = 0.0f;
                        }
                        if (Math.abs(f2) > 0.1f || Math.abs(f3) > 0.1f) {
                            i = i3;
                            i2 = pointerCount;
                            a(pointerId2, x2, y2, f2, f3, eventTime, f.ETOUCH_MOVE.ordinal(), motionEvent.getPressure(i3));
                        } else {
                            i = i3;
                            i2 = pointerCount;
                        }
                        i3 = i + 1;
                        pointerCount = i2;
                    }
                    return;
                }
                if (actionMasked == 3) {
                    if (this.gP.containsKey(Integer.valueOf(pointerId))) {
                        Vector<Float> vector2 = this.gP.get(Integer.valueOf(pointerId));
                        float floatValue = x - vector2.elementAt(0).floatValue();
                        float floatValue2 = y - vector2.elementAt(1).floatValue();
                        this.gP.remove(Integer.valueOf(pointerId));
                        f5 = floatValue2;
                        f4 = floatValue;
                    }
                    fVar = f.ETOUCH_CANCEL;
                    a(pointerId, x, y, f4, f5, eventTime, fVar.ordinal(), pressure);
                }
                if (actionMasked != 5) {
                    if (actionMasked != 6) {
                        return;
                    }
                }
            }
            if (this.gP.containsKey(Integer.valueOf(pointerId))) {
                Vector<Float> vector3 = this.gP.get(Integer.valueOf(pointerId));
                float floatValue3 = x - vector3.elementAt(0).floatValue();
                float floatValue4 = y - vector3.elementAt(1).floatValue();
                this.gP.remove(Integer.valueOf(pointerId));
                f5 = floatValue4;
                f4 = floatValue3;
            }
            fVar = f.ETOUCH_END;
            a(pointerId, x, y, f4, f5, eventTime, fVar.ordinal(), pressure);
        }
        Vector<Float> vector4 = new Vector<>(2);
        vector4.add(Float.valueOf(x));
        vector4.add(Float.valueOf(y));
        this.gP.put(Integer.valueOf(pointerId), vector4);
        fVar = f.ETOUCH_BEGIN;
        a(pointerId, x, y, f4, f5, eventTime, fVar.ordinal(), pressure);
    }

    private void a(e eVar, e eVar2) {
        eVar2.id = eVar.id;
        eVar2.x = eVar.x;
        eVar2.y = eVar.y;
        eVar2.time = eVar.time;
    }
}
