package com.baidu.platform.comapi.map;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes8.dex */
public class am extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    private MapController f9634a;
    private OnLongPressListener b;
    private volatile Set<GestureDetector.SimpleOnGestureListener> c = new CopyOnWriteArraySet();
    private Object d = new Object();

    public void a(MapController mapController) {
        this.f9634a = mapController;
    }

    public void b(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        synchronized (this.d) {
            this.c.remove(simpleOnGestureListener);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        synchronized (this.d) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.c;
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
        MapController mapController = this.f9634a;
        if (mapController != null) {
            mapController.handleDoubleDownClick(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        MapController mapController;
        synchronized (this.d) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.c;
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
        if (motionEvent.getAction() == 1 && (mapController = this.f9634a) != null) {
            mapController.handleDoubleTouch(motionEvent);
        }
        return super.onDoubleTapEvent(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        synchronized (this.d) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.c;
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
        synchronized (this.d) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.c;
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
        MapController mapController = this.f9634a;
        if (mapController == null) {
            return false;
        }
        if (mapController.getMapControlMode() == MapController.MapControlMode.STREET) {
            this.f9634a.handleTouchUp(motionEvent2);
        }
        return this.f9634a.handleFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        OnLongPressListener onLongPressListener;
        synchronized (this.d) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.c;
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
        MapController mapController = this.f9634a;
        if (mapController != null && !mapController.isEnableDMoveZoom() && !this.f9634a.isNaviMode() && (onLongPressListener = this.b) != null) {
            onLongPressListener.onLongPress(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this.d) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.c;
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
        synchronized (this.d) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.c;
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
        synchronized (this.d) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.c;
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
        MapController mapController = this.f9634a;
        if (mapController != null && mapController.handleTouchSingleClick(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        synchronized (this.d) {
            try {
                Set<GestureDetector.SimpleOnGestureListener> set = this.c;
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

    public OnLongPressListener a() {
        return this.b;
    }

    public void a(OnLongPressListener onLongPressListener) {
        this.b = onLongPressListener;
    }

    public void a(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        synchronized (this.d) {
            this.c.add(simpleOnGestureListener);
        }
    }
}
