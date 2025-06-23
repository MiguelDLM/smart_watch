package com.sma.smartv3.view.swipelist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;

/* loaded from: classes12.dex */
public class DragListView extends SwipeListView {

    /* renamed from: IIX0o, reason: collision with root package name */
    public Runnable f25739IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f25740IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f25741IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public II0xO0 f25742O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f25743Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public int f25744OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f25745Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f25746OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public boolean f25747X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public Bitmap f25748XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public View f25749XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public long f25750XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public int f25751o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f25752oI0IIXIo;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public float f25753ooXIXxIX;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public boolean f25754xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f25755xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public int f25756xxX;

    /* loaded from: classes12.dex */
    public static abstract class I0Io implements II0xO0 {
        @Override // com.sma.smartv3.view.swipelist.DragListView.II0xO0
        public void II0xO0(int srcPosition, int position, View srcItemView, View itemView) {
            int height;
            if (srcItemView != null) {
                if (srcPosition > position) {
                    height = -srcItemView.getHeight();
                } else {
                    height = srcItemView.getHeight();
                }
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, height, 0.0f);
                translateAnimation.setDuration(200L);
                srcItemView.clearAnimation();
                srcItemView.startAnimation(translateAnimation);
                srcItemView.setVisibility(0);
            }
            if (itemView != null) {
                itemView.setVisibility(4);
            }
        }

        @Override // com.sma.smartv3.view.swipelist.DragListView.II0xO0
        public void Oxx0IOOO(int position, View itemView) {
            itemView.setVisibility(4);
        }

        @Override // com.sma.smartv3.view.swipelist.DragListView.II0xO0
        public void oIX0oI(int position, View itemView, int itemViewY, int releaseX, int releaseY) {
            itemView.setVisibility(0);
            if (Math.abs(itemViewY - itemView.getTop()) > itemView.getHeight() / 5) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                alphaAnimation.setDuration(150L);
                itemView.clearAnimation();
                itemView.startAnimation(alphaAnimation);
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface II0xO0 {
        boolean I0Io(View itemView, int x, int y);

        void II0xO0(int srcPosition, int position, View srcItemView, View itemView);

        void Oxx0IOOO(int position, View itemView);

        void X0o0xo(View itemView);

        boolean XO(int srcPosition, int position);

        void oIX0oI(int position, View itemView, int itemViewY, int releaseX, int releaseY);

        Bitmap oxoX(View itemView, Bitmap bitmap);
    }

    /* loaded from: classes12.dex */
    public class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DragListView.this.f25754xXxxox0I = false;
            if (DragListView.this.f25748XI0IXoo != null) {
                DragListView.this.f25750XxX0x0xxx = System.currentTimeMillis();
                DragListView dragListView = DragListView.this;
                dragListView.xxIXOIIO((int) dragListView.f25753ooXIXxIX);
                DragListView.this.invalidate();
            }
        }
    }

    public DragListView(Context context) {
        this(context, null);
    }

    public int II0XooXoX(Context context, float dp) {
        return (int) ((context.getResources().getDisplayMetrics().density * dp) + 0.5f);
    }

    public void Oxx0IOOO(final int y) {
        int i;
        View childAt;
        if (y < this.f25745Oxx0xo) {
            if (y <= this.f25751o00 - this.f25756xxX) {
                i = II0XooXoX(getContext(), 6.0f);
            }
            i = 0;
        } else {
            if (y > this.f25752oI0IIXIo && y >= this.f25751o00 + this.f25756xxX) {
                i = -II0XooXoX(getContext(), 6.0f);
            }
            i = 0;
        }
        if (i != 0 && (childAt = getChildAt(this.f25741IXxxXO - getFirstVisiblePosition())) != null) {
            setSelectionFromTop(this.f25741IXxxXO, childAt.getTop() + i);
            if (!this.f25754xXxxox0I) {
                this.f25754xXxxox0I = true;
                long currentTimeMillis = System.currentTimeMillis() - this.f25750XxX0x0xxx;
                Runnable runnable = this.f25739IIX0o;
                long j = 15;
                if (currentTimeMillis <= 15) {
                    j = 15 - currentTimeMillis;
                }
                postDelayed(runnable, j);
            }
        }
    }

    public final void XO(int y) {
        II0xO0 iI0xO0;
        int i = this.f25741IXxxXO;
        int i2 = this.f25743Oo;
        if (i != i2 && (iI0xO0 = this.f25742O0xOxO) != null && iI0xO0.XO(i2, i)) {
            View view = this.f25749XIxXXX0x0;
            View childAt = getChildAt(this.f25741IXxxXO - getFirstVisiblePosition());
            this.f25749XIxXXX0x0 = childAt;
            this.f25742O0xOxO.II0xO0(this.f25743Oo, this.f25741IXxxXO, view, childAt);
            this.f25743Oo = this.f25741IXxxXO;
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Bitmap bitmap = this.f25748XI0IXoo;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(this.f25748XI0IXoo, 0.0f, this.f25740IIXOooo - this.f25744OxI, (Paint) null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
    
        if (r0 != 4) goto L46;
     */
    @Override // com.sma.smartv3.view.swipelist.SwipeListView, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.view.swipelist.DragListView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int II0XooXoX2 = II0XooXoX(getContext(), 80.0f);
        this.f25745Oxx0xo = II0XooXoX2;
        this.f25752oI0IIXIo = h - II0XooXoX2;
    }

    public void setDragItemListener(II0xO0 listener) {
        this.f25742O0xOxO = listener;
    }

    public void xoIox() {
        Bitmap bitmap = this.f25748XI0IXoo;
        if (bitmap != null) {
            bitmap.recycle();
            this.f25748XI0IXoo = null;
            II0xO0 iI0xO0 = this.f25742O0xOxO;
            if (iI0xO0 != null) {
                int i = this.f25741IXxxXO;
                View view = this.f25749XIxXXX0x0;
                int i2 = this.f25740IIXOooo;
                iI0xO0.oIX0oI(i, view, i2 - this.f25744OxI, this.f25746OxxIIOOXO, i2);
            }
        }
        if (this.f25749XIxXXX0x0 != null) {
            this.f25749XIxXXX0x0 = null;
        }
        this.f25754xXxxox0I = false;
        removeCallbacks(this.f25739IIX0o);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xxIXOIIO(int r9) {
        /*
            r8 = this;
            int r0 = r8.getWidth()
            int r0 = r0 / 2
            int r0 = r8.pointToPosition(r0, r9)
            r1 = -1
            if (r0 != r1) goto L11
            r8.Oxx0IOOO(r9)
            return
        L11:
            int r2 = r8.f25743Oo
            r3 = 1
            if (r2 <= r0) goto L18
            r4 = -1
            goto L19
        L18:
            r4 = 1
        L19:
            if (r4 <= 0) goto L1e
            if (r2 > r0) goto L6c
            goto L20
        L1e:
            if (r2 < r0) goto L6c
        L20:
            int r5 = r8.getFirstVisiblePosition()
            int r5 = r2 - r5
            int r6 = r8.getChildCount()
            if (r5 >= r6) goto L6a
            if (r5 >= 0) goto L2f
            goto L6a
        L2f:
            android.view.View r5 = r8.getChildAt(r5)
            int r5 = r5.getTop()
            r6 = 0
            int r7 = r8.pointToPosition(r6, r5)
            if (r7 == r1) goto L40
            r8.f25741IXxxXO = r7
        L40:
            android.view.View r7 = r8.getChildAt(r6)
            int r7 = r7.getTop()
            if (r5 >= r7) goto L4d
            r8.f25741IXxxXO = r6
            goto L67
        L4d:
            int r6 = r8.getChildCount()
            int r6 = r6 - r3
            android.view.View r6 = r8.getChildAt(r6)
            int r6 = r6.getBottom()
            if (r5 <= r6) goto L67
            android.widget.ListAdapter r6 = r8.getAdapter()
            int r6 = r6.getCount()
            int r6 = r6 - r3
            r8.f25741IXxxXO = r6
        L67:
            r8.XO(r5)
        L6a:
            int r2 = r2 + r4
            goto L19
        L6c:
            r8.Oxx0IOOO(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.view.swipelist.DragListView.xxIXOIIO(int):void");
    }

    public DragListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f25747X0IIOO = false;
        this.f25754xXxxox0I = false;
        this.f25739IIX0o = new oIX0oI();
        setLayerType(1, null);
        this.f25756xxX = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
