package com.baidu.ar.arplay.core.engine.rotate;

import android.content.Context;
import android.view.OrientationEventListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class OrientationManager extends OrientationEventListener {
    private Orientation mCurrentOrientation;
    private List<OrientationListener> mListeners;
    private static Orientation sGlobalOrientation = Orientation.UNKNOWN;
    private static boolean isScreenOrientationLandscape = false;

    /* loaded from: classes7.dex */
    public interface OrientationListener {
        void onRotateOrientation(Orientation orientation);
    }

    public OrientationManager(Context context) {
        super(context);
        this.mCurrentOrientation = Orientation.PORTRAIT;
        this.mListeners = new ArrayList();
    }

    public static Orientation calcOrientation(int i, Orientation orientation) {
        if (isScreenOrientationLandscape) {
            i = (i + 90) % 360;
        }
        Orientation certainOrientation = certainOrientation(i);
        if (certainOrientation != null) {
            return certainOrientation;
        }
        Orientation[] probablyOrientation = probablyOrientation(i);
        return (orientation == probablyOrientation[0] || orientation == probablyOrientation[1]) ? orientation : nearOrientation(i);
    }

    private static Orientation certainOrientation(int i) {
        if ((i >= 0 && i <= 10) || (i >= 350 && i <= 359)) {
            return Orientation.PORTRAIT;
        }
        if (i >= 80 && i <= 100) {
            return Orientation.LANDSCAPE;
        }
        if (i >= 170 && i <= 190) {
            return Orientation.PORTRAIT_REVERSE;
        }
        if (i < 260 || i > 280) {
            return null;
        }
        return Orientation.LANDSCAPE_REVERSE;
    }

    public static Orientation getGlobalOrientation() {
        return sGlobalOrientation;
    }

    private static Orientation nearOrientation(int i) {
        return ((i < 0 || i > 45) && (i < 315 || i >= 360)) ? (i <= 45 || i >= 135) ? (i < 135 || i > 225) ? (i <= 225 || i >= 315) ? Orientation.PORTRAIT : Orientation.LANDSCAPE_REVERSE : Orientation.PORTRAIT_REVERSE : Orientation.LANDSCAPE : Orientation.PORTRAIT;
    }

    private static Orientation[] probablyOrientation(int i) {
        return (i <= 0 || i >= 90) ? (i <= 90 || i >= 180) ? (i <= 180 || i >= 270) ? new Orientation[]{Orientation.LANDSCAPE_REVERSE, Orientation.PORTRAIT} : new Orientation[]{Orientation.PORTRAIT_REVERSE, Orientation.LANDSCAPE_REVERSE} : new Orientation[]{Orientation.LANDSCAPE, Orientation.PORTRAIT} : new Orientation[]{Orientation.PORTRAIT, Orientation.LANDSCAPE};
    }

    public static void setGlobalOrientation(Orientation orientation) {
        sGlobalOrientation = orientation;
    }

    public void addOrientationListener(OrientationListener orientationListener) {
        if (orientationListener == null || this.mListeners.contains(orientationListener)) {
            return;
        }
        this.mListeners.add(orientationListener);
    }

    public void destroy() {
        sGlobalOrientation = Orientation.UNKNOWN;
        this.mListeners.clear();
    }

    @Override // android.view.OrientationEventListener
    public void disable() {
        try {
            super.disable();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.OrientationEventListener
    public void enable() {
        try {
            super.enable();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void notifyOrientationChanged() {
        notifyOrientationChanged(this.mCurrentOrientation);
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        Orientation calcOrientation;
        if (i == -1 || (calcOrientation = calcOrientation(i, this.mCurrentOrientation)) == null) {
            return;
        }
        if (sGlobalOrientation == Orientation.UNKNOWN) {
            sGlobalOrientation = calcOrientation;
        }
        if (this.mCurrentOrientation != calcOrientation) {
            this.mCurrentOrientation = calcOrientation;
            notifyOrientationChanged(calcOrientation);
        }
    }

    public void removeOrientationListener(OrientationListener orientationListener) {
        if (orientationListener == null || !this.mListeners.contains(orientationListener)) {
            return;
        }
        this.mListeners.remove(orientationListener);
    }

    public void setScreenOrientationLandscape(boolean z) {
        isScreenOrientationLandscape = z;
    }

    public void notifyOrientationChanged(Orientation orientation) {
        setGlobalOrientation(orientation);
        Iterator<OrientationListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onRotateOrientation(orientation);
        }
    }
}
