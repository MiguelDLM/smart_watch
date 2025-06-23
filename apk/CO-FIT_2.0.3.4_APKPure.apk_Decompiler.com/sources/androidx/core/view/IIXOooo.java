package androidx.core.view;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class IIXOooo implements View.OnTouchListener {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ DragStartHelper f368XO;

    public /* synthetic */ IIXOooo(DragStartHelper dragStartHelper) {
        this.f368XO = dragStartHelper;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f368XO.onTouch(view, motionEvent);
    }
}
