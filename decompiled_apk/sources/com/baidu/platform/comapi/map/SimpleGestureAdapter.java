package com.baidu.platform.comapi.map;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes8.dex */
public class SimpleGestureAdapter extends GestureDetector.SimpleOnGestureListener {
    private MapController mMapController;
    private OnLongPressListener mOnLongPressListener;
    private volatile Set<GestureDetector.SimpleOnGestureListener> mUserListeners = new CopyOnWriteArraySet();
    private Object lock = new Object();

    public void addSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        synchronized (this.lock) {
            this.mUserListeners.add(simpleOnGestureListener);
        }
    }

    public OnLongPressListener getOnLongPressListener() {
        return this.mOnLongPressListener;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        synchronized (this.lock) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.mUserListeners;
                if (set != null) {
                    Iterator<GestureDetector.SimpleOnGestureListener> it = set.iterator();
                    while (it.hasNext()) {
                        it.next().onDoubleTap(motionEvent);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        MapController mapController = this.mMapController;
        if (mapController != null) {
            mapController.handleDoubleDownClick(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        MapController mapController;
        synchronized (this.lock) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.mUserListeners;
                if (set != null) {
                    Iterator<GestureDetector.SimpleOnGestureListener> it = set.iterator();
                    while (it.hasNext()) {
                        it.next().onDoubleTapEvent(motionEvent);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (motionEvent.getAction() == 1 && (mapController = this.mMapController) != null) {
            mapController.handleDoubleTouch(motionEvent);
        }
        return super.onDoubleTapEvent(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        synchronized (this.lock) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.mUserListeners;
                if (set != null) {
                    Iterator<GestureDetector.SimpleOnGestureListener> it = set.iterator();
                    while (it.hasNext()) {
                        it.next().onDown(motionEvent);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return super.onDown(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this.lock) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.mUserListeners;
                if (set != null) {
                    Iterator<GestureDetector.SimpleOnGestureListener> it = set.iterator();
                    while (it.hasNext()) {
                        it.next().onFling(motionEvent, motionEvent2, f, f2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        MapController mapController = this.mMapController;
        if (mapController == null) {
            return false;
        }
        if (mapController.getMapControlMode() == MapController.MapControlMode.STREET) {
            this.mMapController.handleTouchUp(motionEvent2);
        }
        return this.mMapController.handleFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        OnLongPressListener onLongPressListener;
        synchronized (this.lock) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.mUserListeners;
                if (set != null) {
                    for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                        if (simpleOnGestureListener != null) {
                            simpleOnGestureListener.onLongPress(motionEvent);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        MapController mapController = this.mMapController;
        if (mapController != null && !mapController.isEnableDMoveZoom() && !this.mMapController.isNaviMode() && (onLongPressListener = this.mOnLongPressListener) != null) {
            onLongPressListener.onLongPress(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this.lock) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.mUserListeners;
                if (set != null) {
                    Iterator<GestureDetector.SimpleOnGestureListener> it = set.iterator();
                    while (it.hasNext()) {
                        it.next().onScroll(motionEvent, motionEvent2, f, f2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        synchronized (this.lock) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.mUserListeners;
                if (set != null) {
                    for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                        if (simpleOnGestureListener != null) {
                            simpleOnGestureListener.onShowPress(motionEvent);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        super.onShowPress(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        synchronized (this.lock) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.mUserListeners;
                if (set != null) {
                    for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                        if (simpleOnGestureListener != null) {
                            simpleOnGestureListener.onSingleTapConfirmed(motionEvent);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        MapController mapController = this.mMapController;
        if (mapController != null && mapController.handleTouchSingleClick(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        synchronized (this.lock) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.mUserListeners;
                if (set != null) {
                    Iterator<GestureDetector.SimpleOnGestureListener> it = set.iterator();
                    while (it.hasNext()) {
                        it.next().onSingleTapUp(motionEvent);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return super.onSingleTapUp(motionEvent);
    }

    public void removeSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        synchronized (this.lock) {
            this.mUserListeners.remove(simpleOnGestureListener);
        }
    }

    public void setMapController(MapController mapController) {
        this.mMapController = mapController;
    }

    public void setOnLongPressListener(OnLongPressListener onLongPressListener) {
        this.mOnLongPressListener = onLongPressListener;
    }
}
