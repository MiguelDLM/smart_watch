package com.baidu.ar;

import android.content.Context;
import android.view.OrientationEventListener;

/* loaded from: classes7.dex */
public class ac extends OrientationEventListener {
    private a fE;
    private a fF;
    private boolean fG;
    private int fH;
    private int fI;

    /* loaded from: classes7.dex */
    public enum a {
        SCREEN_ORIENTATION_PORTRAIT,
        SCREEN_ORIENTATION_LANDSCAPE,
        SCREEN_ORIENTATION_REVERSE_PORTRAIT,
        SCREEN_ORIENTATION_REVERSE_LANDSCAPE,
        SCREEN_ORIENTATION_NOT_DEFINED
    }

    public ac(Context context) {
        super(context);
        this.fG = false;
        this.fI = 0;
    }

    private int aJ() {
        a aVar = this.fE;
        if (aVar == a.SCREEN_ORIENTATION_LANDSCAPE) {
            return 90;
        }
        if (aVar == a.SCREEN_ORIENTATION_REVERSE_LANDSCAPE) {
            return -90;
        }
        return aVar == a.SCREEN_ORIENTATION_REVERSE_PORTRAIT ? 180 : 0;
    }

    public void calibrationTouchAngle() {
        this.fH = aJ();
    }

    public void e(int i) {
        this.fI = i;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        a aVar;
        a aVar2;
        if (i < 0) {
            aVar = a.SCREEN_ORIENTATION_NOT_DEFINED;
        } else {
            int i2 = this.fI;
            if (i2 == 1) {
                int i3 = ((i + 360) + this.fH) % 360;
                if (i3 <= 45 || i3 > 315) {
                    aVar2 = a.SCREEN_ORIENTATION_PORTRAIT;
                } else if (i3 > 45 && i3 <= 135) {
                    aVar2 = a.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                } else {
                    if (i3 <= 135 || i3 > 225) {
                        if (i3 > 225 && i3 <= 315) {
                            aVar2 = a.SCREEN_ORIENTATION_LANDSCAPE;
                        }
                        if (this.fG && i2 == 1) {
                            this.fG = true;
                            this.fE = this.fF;
                            calibrationTouchAngle();
                            return;
                        }
                        return;
                    }
                    aVar2 = a.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                }
                this.fF = aVar2;
                if (this.fG) {
                    return;
                } else {
                    return;
                }
            }
            if (i2 != 0) {
                return;
            }
            if (i <= 45 || i > 315) {
                aVar = a.SCREEN_ORIENTATION_PORTRAIT;
            } else if (i > 45 && i <= 135) {
                aVar = a.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
            } else if (i > 135 && i <= 225) {
                aVar = a.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
            } else if (i <= 225 || i > 315) {
                return;
            } else {
                aVar = a.SCREEN_ORIENTATION_LANDSCAPE;
            }
        }
        this.fF = aVar;
    }

    public void release() {
        try {
            disable();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        this.fI = 0;
    }

    public void start() {
        try {
            enable();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
