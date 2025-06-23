package com.baidu.navisdk.module.newguide.settings.drag;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes7.dex */
public abstract class b implements RecyclerView.OnItemTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private GestureDetectorCompat f7258a;
    private RecyclerView b;

    /* renamed from: com.baidu.navisdk.module.newguide.settings.drag.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0254b extends GestureDetector.SimpleOnGestureListener {
        private C0254b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View findChildViewUnder = b.this.b.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (findChildViewUnder != null) {
                b.this.b(b.this.b.getChildViewHolder(findChildViewUnder));
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            View findChildViewUnder = b.this.b.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (findChildViewUnder != null) {
                b.this.a(b.this.b.getChildViewHolder(findChildViewUnder));
                return true;
            }
            return true;
        }
    }

    public b(RecyclerView recyclerView) {
        this.b = recyclerView;
        this.f7258a = new GestureDetectorCompat(recyclerView.getContext(), new C0254b());
    }

    public abstract void a(RecyclerView.ViewHolder viewHolder);

    public void b(RecyclerView.ViewHolder viewHolder) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f7258a.onTouchEvent(motionEvent);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f7258a.onTouchEvent(motionEvent);
    }
}
