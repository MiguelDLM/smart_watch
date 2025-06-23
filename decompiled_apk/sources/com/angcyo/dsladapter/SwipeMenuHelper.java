package com.angcyo.dsladapter;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.core.math.MathUtils;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSwipeMenuHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SwipeMenuHelper.kt\ncom/angcyo/dsladapter/SwipeMenuHelper\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 LibEx.kt\ncom/angcyo/dsladapter/LibExKt\n*L\n1#1,635:1\n13579#2,2:636\n486#3,14:638\n*S KotlinDebug\n*F\n+ 1 SwipeMenuHelper.kt\ncom/angcyo/dsladapter/SwipeMenuHelper\n*L\n432#1:636,2\n615#1:638,14\n*E\n"})
/* loaded from: classes7.dex */
public final class SwipeMenuHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    public static final int SWIPE_MENU_TYPE_DEFAULT = 1;
    public static final int SWIPE_MENU_TYPE_FLOWING = 2;

    @OXOo.oOoXoXO
    private RecyclerView.ViewHolder _downViewHolder;

    @OXOo.oOoXoXO
    private DragCallbackHelper _dragCallbackHelper;

    @OXOo.oOoXoXO
    private Field _dragCallbackHelperTouchField;
    private float _lastDistanceX;
    private float _lastDistanceY;

    @OXOo.oOoXoXO
    private ValueAnimator _lastValueAnimator;
    private float _lastVelocityX;
    private float _lastVelocityY;
    private boolean _needHandleTouch;

    @OXOo.oOoXoXO
    private RecyclerView _recyclerView;
    private float _scrollX;
    private float _scrollY;
    private int _slop;
    private int _swipeFlags;

    @OXOo.oOoXoXO
    private RecyclerView.ViewHolder _swipeMenuViewHolder;

    @OXOo.oOoXoXO
    private GestureDetectorCompat gestureDetectorCompat;

    @OXOo.OOXIXo
    private final GestureDetector.SimpleOnGestureListener itemTouchHelperGestureListener;

    @OXOo.OOXIXo
    private final RecyclerView.OnItemTouchListener mOnItemTouchListener;

    @OXOo.OOXIXo
    private com.angcyo.dsladapter.internal.x0xO0oo swipeMenuCallback;

    @XX({"SMAP\nLibEx.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LibEx.kt\ncom/angcyo/dsladapter/LibExKt$addListener$listener$1\n+ 2 LibEx.kt\ncom/angcyo/dsladapter/LibExKt$addListener$4\n+ 3 SwipeMenuHelper.kt\ncom/angcyo/dsladapter/SwipeMenuHelper\n+ 4 LibEx.kt\ncom/angcyo/dsladapter/LibExKt$addListener$2\n*L\n1#1,930:1\n490#2:931\n616#3,10:932\n488#4:942\n*E\n"})
    /* loaded from: classes7.dex */
    public static final class I0Io implements Animator.AnimatorListener {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ SwipeMenuHelper f5302IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ float f5303Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f5304Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ float f5305XO;

        public I0Io(float f, float f2, SwipeMenuHelper swipeMenuHelper, RecyclerView.ViewHolder viewHolder, SwipeMenuHelper swipeMenuHelper2) {
            this.f5305XO = f;
            this.f5303Oo = f2;
            this.f5302IXxxXO = swipeMenuHelper;
            this.f5304Oxx0xo = viewHolder;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@OXOo.OOXIXo Animator animator) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(animator, "animator");
            this.f5302IXxxXO.set_lastValueAnimator(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@OXOo.OOXIXo Animator animator) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(animator, "animator");
            if (this.f5305XO == 0.0f && this.f5303Oo == 0.0f) {
                this.f5302IXxxXO.set_swipeMenuViewHolder(null);
            } else {
                this.f5302IXxxXO.set_swipeMenuViewHolder(this.f5304Oxx0xo);
            }
            this.f5302IXxxXO.set_lastValueAnimator(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@OXOo.OOXIXo Animator animator) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@OXOo.OOXIXo Animator animator) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(animator, "animator");
        }
    }

    /* loaded from: classes7.dex */
    public static final class II0xO0 extends GestureDetector.SimpleOnGestureListener {
        public II0xO0() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(@OXOo.OOXIXo MotionEvent e) {
            RecyclerView.Adapter adapter;
            DslAdapterItem dslAdapterItem;
            kotlin.jvm.internal.IIX0o.x0xO0oo(e, "e");
            RecyclerView.ViewHolder findSwipedView = SwipeMenuHelper.this.findSwipedView(e);
            if (findSwipedView == null) {
                SwipeMenuHelper.this.set_needHandleTouch(false);
                SwipeMenuHelper swipeMenuHelper = SwipeMenuHelper.this;
                swipeMenuHelper.closeSwipeMenu(swipeMenuHelper.get_swipeMenuViewHolder());
            } else {
                SwipeMenuHelper swipeMenuHelper2 = SwipeMenuHelper.this;
                RecyclerView recyclerView = swipeMenuHelper2.get_recyclerView();
                if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null && (adapter instanceof DslAdapter) && (dslAdapterItem = ((DslAdapter) adapter).get(findSwipedView.getAdapterPosition(), true, false)) != null && !kotlin.jvm.internal.IIX0o.Oxx0IOOO(dslAdapterItem.get_itemSwipeMenuHelper(), swipeMenuHelper2)) {
                    dslAdapterItem.set_itemSwipeMenuHelper(swipeMenuHelper2);
                }
                ValueAnimator valueAnimator = swipeMenuHelper2.get_lastValueAnimator();
                if ((valueAnimator != null && valueAnimator.isRunning()) || (swipeMenuHelper2.get_downViewHolder() != null && !kotlin.jvm.internal.IIX0o.Oxx0IOOO(swipeMenuHelper2.get_downViewHolder(), findSwipedView))) {
                    swipeMenuHelper2.set_needHandleTouch(false);
                } else {
                    swipeMenuHelper2.set_downViewHolder(findSwipedView);
                    if (swipeMenuHelper2.get_swipeMenuViewHolder() != null && !kotlin.jvm.internal.IIX0o.Oxx0IOOO(swipeMenuHelper2.get_downViewHolder(), swipeMenuHelper2.get_swipeMenuViewHolder())) {
                        swipeMenuHelper2.set_needHandleTouch(false);
                        swipeMenuHelper2.closeSwipeMenu(swipeMenuHelper2.get_swipeMenuViewHolder());
                    }
                }
            }
            return super.onDown(e);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@OXOo.OOXIXo MotionEvent e1, @OXOo.OOXIXo MotionEvent e2, float f, float f2) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(e1, "e1");
            kotlin.jvm.internal.IIX0o.x0xO0oo(e2, "e2");
            SwipeMenuHelper.this.set_lastVelocityX(f);
            SwipeMenuHelper.this.set_lastVelocityY(f2);
            return super.onFling(e1, e2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@OXOo.OOXIXo MotionEvent e1, @OXOo.OOXIXo MotionEvent e2, float f, float f2) {
            int i;
            ViewParent parent;
            ViewParent parent2;
            kotlin.jvm.internal.IIX0o.x0xO0oo(e1, "e1");
            kotlin.jvm.internal.IIX0o.x0xO0oo(e2, "e2");
            float abs = Math.abs(f);
            float abs2 = Math.abs(f2);
            if (abs >= SwipeMenuHelper.this.get_slop() || abs2 >= SwipeMenuHelper.this.get_slop()) {
                DragCallbackHelper dragCallbackHelper = SwipeMenuHelper.this.get_dragCallbackHelper();
                if (dragCallbackHelper != null) {
                    dragCallbackHelper.set_shouldReactToLongPress(false);
                }
                SwipeMenuHelper.this._cancelDragHelper(e1);
                if (abs > abs2) {
                    SwipeMenuHelper.this.set_lastDistanceX(f);
                } else {
                    SwipeMenuHelper.this.set_lastDistanceY(f2);
                }
            }
            SwipeMenuHelper.this.set_lastVelocityX(0.0f);
            SwipeMenuHelper.this.set_lastVelocityY(0.0f);
            RecyclerView.ViewHolder viewHolder = SwipeMenuHelper.this.get_downViewHolder();
            RecyclerView recyclerView = SwipeMenuHelper.this.get_recyclerView();
            if (recyclerView != null && viewHolder != null) {
                int II0xO02 = SwipeMenuHelper.this.getSwipeMenuCallback().II0xO0(recyclerView, viewHolder);
                if (II0xO02 <= 0) {
                    SwipeMenuHelper.this.set_needHandleTouch(false);
                } else {
                    if (abs > abs2) {
                        i = 12;
                    } else {
                        i = 3;
                    }
                    if (SwipeMenuHelper.this.get_swipeFlags() == 0) {
                        SwipeMenuHelper.this.set_swipeFlags(i);
                    }
                    float oxoX2 = SwipeMenuHelper.this.getSwipeMenuCallback().oxoX(recyclerView, viewHolder);
                    float I0Io2 = SwipeMenuHelper.this.getSwipeMenuCallback().I0Io(recyclerView, viewHolder);
                    SwipeMenuHelper swipeMenuHelper = SwipeMenuHelper.this;
                    swipeMenuHelper.set_scrollX(swipeMenuHelper.get_scrollX() - f);
                    SwipeMenuHelper swipeMenuHelper2 = SwipeMenuHelper.this;
                    swipeMenuHelper2.set_scrollX(MathUtils.clamp(swipeMenuHelper2.get_scrollX(), -oxoX2, oxoX2));
                    SwipeMenuHelper swipeMenuHelper3 = SwipeMenuHelper.this;
                    swipeMenuHelper3.set_scrollY(swipeMenuHelper3.get_scrollY() - f2);
                    SwipeMenuHelper swipeMenuHelper4 = SwipeMenuHelper.this;
                    swipeMenuHelper4.set_scrollY(MathUtils.clamp(swipeMenuHelper4.get_scrollY(), -I0Io2, I0Io2));
                    if (SwipeMenuHelper.this.get_swipeFlags() == 12) {
                        if (!LibExKt.XX0(II0xO02, 4) && !LibExKt.XX0(II0xO02, 8)) {
                            SwipeMenuHelper.this.set_swipeFlags(0);
                            SwipeMenuHelper.this.set_needHandleTouch(false);
                            SwipeMenuHelper.this.set_scrollX(0.0f);
                            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(SwipeMenuHelper.this.get_swipeMenuViewHolder(), SwipeMenuHelper.this.get_downViewHolder())) {
                                SwipeMenuHelper swipeMenuHelper5 = SwipeMenuHelper.this;
                                swipeMenuHelper5.closeSwipeMenu(swipeMenuHelper5.get_swipeMenuViewHolder());
                                return SwipeMenuHelper.this.get_needHandleTouch();
                            }
                            SwipeMenuHelper.this.set_scrollY(0.0f);
                        } else {
                            SwipeMenuHelper.this.set_scrollY(0.0f);
                            if (SwipeMenuHelper.this.get_scrollX() < 0.0f && (II0xO02 & 4) == 0) {
                                SwipeMenuHelper.this.set_scrollX(0.0f);
                            } else if (SwipeMenuHelper.this.get_scrollX() > 0.0f && (II0xO02 & 8) == 0) {
                                SwipeMenuHelper.this.set_scrollX(0.0f);
                            } else {
                                RecyclerView recyclerView2 = SwipeMenuHelper.this.get_recyclerView();
                                if (recyclerView2 != null && (parent2 = recyclerView2.getParent()) != null) {
                                    parent2.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    } else if (!LibExKt.XX0(II0xO02, 1) && !LibExKt.XX0(II0xO02, 2)) {
                        SwipeMenuHelper.this.set_swipeFlags(0);
                        SwipeMenuHelper.this.set_needHandleTouch(false);
                        SwipeMenuHelper.this.set_scrollY(0.0f);
                        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(SwipeMenuHelper.this.get_swipeMenuViewHolder(), SwipeMenuHelper.this.get_downViewHolder())) {
                            SwipeMenuHelper swipeMenuHelper6 = SwipeMenuHelper.this;
                            swipeMenuHelper6.closeSwipeMenu(swipeMenuHelper6.get_swipeMenuViewHolder());
                            return SwipeMenuHelper.this.get_needHandleTouch();
                        }
                        SwipeMenuHelper.this.set_scrollX(0.0f);
                    } else {
                        SwipeMenuHelper.this.set_scrollX(0.0f);
                        if (SwipeMenuHelper.this.get_scrollY() < 0.0f && (II0xO02 & 2) == 0) {
                            SwipeMenuHelper.this.set_scrollY(0.0f);
                        } else if (SwipeMenuHelper.this.get_scrollY() > 0.0f && (II0xO02 & 1) == 0) {
                            SwipeMenuHelper.this.set_scrollY(0.0f);
                        } else {
                            RecyclerView recyclerView3 = SwipeMenuHelper.this.get_recyclerView();
                            if (recyclerView3 != null && (parent = recyclerView3.getParent()) != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                    SwipeMenuHelper.this.getSwipeMenuCallback().Oxx0IOOO(recyclerView, viewHolder, SwipeMenuHelper.this.get_scrollX(), SwipeMenuHelper.this.get_scrollY());
                }
            } else {
                SwipeMenuHelper.this.set_needHandleTouch(false);
            }
            return SwipeMenuHelper.this.get_needHandleTouch();
        }
    }

    /* loaded from: classes7.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public final void II0xO0(@OXOo.OOXIXo SwipeMenuHelper helper) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(helper, "helper");
            helper.attachToRecyclerView(null);
        }

        @OXOo.OOXIXo
        public final SwipeMenuHelper oIX0oI(@OXOo.oOoXoXO RecyclerView recyclerView) {
            SwipeMenuHelper swipeMenuHelper = new SwipeMenuHelper(new com.angcyo.dsladapter.internal.x0xO0oo());
            swipeMenuHelper.attachToRecyclerView(recyclerView);
            return swipeMenuHelper;
        }

        public oIX0oI() {
        }
    }

    public SwipeMenuHelper(@OXOo.OOXIXo com.angcyo.dsladapter.internal.x0xO0oo swipeMenuCallback) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(swipeMenuCallback, "swipeMenuCallback");
        this.swipeMenuCallback = swipeMenuCallback;
        this._needHandleTouch = true;
        this.mOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: com.angcyo.dsladapter.SwipeMenuHelper$mOnItemTouchListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(@OXOo.OOXIXo RecyclerView rv, @OXOo.OOXIXo MotionEvent e) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(rv, "rv");
                kotlin.jvm.internal.IIX0o.x0xO0oo(e, "e");
                int actionMasked = e.getActionMasked();
                Boolean bool = null;
                if (actionMasked == 0) {
                    SwipeMenuHelper.this._resetScrollValue();
                    GestureDetectorCompat gestureDetectorCompat = SwipeMenuHelper.this.getGestureDetectorCompat();
                    if (gestureDetectorCompat != null) {
                        bool = Boolean.valueOf(gestureDetectorCompat.onTouchEvent(e));
                    }
                } else if (SwipeMenuHelper.this.get_needHandleTouch()) {
                    GestureDetectorCompat gestureDetectorCompat2 = SwipeMenuHelper.this.getGestureDetectorCompat();
                    if (gestureDetectorCompat2 != null) {
                        bool = Boolean.valueOf(gestureDetectorCompat2.onTouchEvent(e));
                    }
                } else {
                    if (actionMasked == 1 || actionMasked == 3) {
                        touchFinish();
                    }
                    bool = Boolean.FALSE;
                }
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onRequestDisallowInterceptTouchEvent(boolean z) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onTouchEvent(@OXOo.OOXIXo RecyclerView rv, @OXOo.OOXIXo MotionEvent e) {
                GestureDetectorCompat gestureDetectorCompat;
                kotlin.jvm.internal.IIX0o.x0xO0oo(rv, "rv");
                kotlin.jvm.internal.IIX0o.x0xO0oo(e, "e");
                if (SwipeMenuHelper.this.get_needHandleTouch() && (gestureDetectorCompat = SwipeMenuHelper.this.getGestureDetectorCompat()) != null) {
                    gestureDetectorCompat.onTouchEvent(e);
                }
                int actionMasked = e.getActionMasked();
                if (actionMasked == 1 || actionMasked == 3) {
                    touchFinish();
                }
            }

            public final void touchFinish() {
                ViewParent parent;
                DragCallbackHelper dragCallbackHelper = SwipeMenuHelper.this.get_dragCallbackHelper();
                if (dragCallbackHelper != null) {
                    dragCallbackHelper.set_shouldReactToLongPress(true);
                }
                if (SwipeMenuHelper.this.get_needHandleTouch()) {
                    RecyclerView.ViewHolder viewHolder = SwipeMenuHelper.this.get_downViewHolder();
                    RecyclerView recyclerView = SwipeMenuHelper.this.get_recyclerView();
                    if (recyclerView != null && viewHolder != null) {
                        int II0xO02 = SwipeMenuHelper.this.getSwipeMenuCallback().II0xO0(recyclerView, viewHolder);
                        float X0o0xo2 = SwipeMenuHelper.this.getSwipeMenuCallback().X0o0xo(recyclerView, viewHolder);
                        float oxoX2 = SwipeMenuHelper.this.getSwipeMenuCallback().oxoX(recyclerView, viewHolder);
                        float I0Io2 = SwipeMenuHelper.this.getSwipeMenuCallback().I0Io(recyclerView, viewHolder);
                        float f = oxoX2 * X0o0xo2;
                        float f2 = X0o0xo2 * I0Io2;
                        float XO2 = SwipeMenuHelper.this.getSwipeMenuCallback().XO(recyclerView, viewHolder, SwipeMenuHelper.this.get_lastVelocityX());
                        float XO3 = SwipeMenuHelper.this.getSwipeMenuCallback().XO(recyclerView, viewHolder, SwipeMenuHelper.this.get_lastVelocityY());
                        if (SwipeMenuHelper.this.get_swipeFlags() == 12) {
                            if (SwipeMenuHelper.this.get_lastVelocityX() != 0.0f && Math.abs(SwipeMenuHelper.this.get_lastVelocityX()) >= XO2) {
                                if (SwipeMenuHelper.this.get_scrollX() < 0.0f && SwipeMenuHelper.this.get_lastVelocityX() < 0.0f && LibExKt.XX0(II0xO02, 4)) {
                                    SwipeMenuHelper.this.scrollSwipeMenuTo(viewHolder, -oxoX2, 0.0f);
                                } else if (SwipeMenuHelper.this.get_scrollX() > 0.0f && SwipeMenuHelper.this.get_lastVelocityX() > 0.0f && LibExKt.XX0(II0xO02, 8)) {
                                    SwipeMenuHelper.this.scrollSwipeMenuTo(viewHolder, oxoX2, 0.0f);
                                } else {
                                    SwipeMenuHelper.this.closeSwipeMenu(viewHolder);
                                }
                            } else if (SwipeMenuHelper.this.get_scrollX() < 0.0f) {
                                if ((SwipeMenuHelper.this.get_lastDistanceX() > 0.0f && Math.abs(SwipeMenuHelper.this.get_scrollX()) >= f) || (SwipeMenuHelper.this.get_lastDistanceX() < 0.0f && SwipeMenuHelper.this.get_scrollX() + oxoX2 < f)) {
                                    SwipeMenuHelper.this.scrollSwipeMenuTo(viewHolder, -oxoX2, 0.0f);
                                } else {
                                    SwipeMenuHelper.this.closeSwipeMenu(viewHolder);
                                }
                            } else if (SwipeMenuHelper.this.get_scrollX() > 0.0f) {
                                if ((SwipeMenuHelper.this.get_lastDistanceX() < 0.0f && Math.abs(SwipeMenuHelper.this.get_scrollX()) >= f) || (SwipeMenuHelper.this.get_lastDistanceX() > 0.0f && oxoX2 - SwipeMenuHelper.this.get_scrollX() < f)) {
                                    SwipeMenuHelper.this.scrollSwipeMenuTo(viewHolder, oxoX2, 0.0f);
                                } else {
                                    SwipeMenuHelper.this.closeSwipeMenu(viewHolder);
                                }
                            }
                        } else if (SwipeMenuHelper.this.get_swipeFlags() == 3) {
                            if (SwipeMenuHelper.this.get_lastVelocityY() != 0.0f && Math.abs(SwipeMenuHelper.this.get_lastVelocityY()) >= XO3) {
                                if (SwipeMenuHelper.this.get_scrollY() < 0.0f && SwipeMenuHelper.this.get_lastVelocityY() < 0.0f && LibExKt.XX0(II0xO02, 2)) {
                                    SwipeMenuHelper.this.scrollSwipeMenuTo(viewHolder, 0.0f, I0Io2);
                                } else if (SwipeMenuHelper.this.get_scrollY() > 0.0f && SwipeMenuHelper.this.get_lastVelocityY() > 0.0f && LibExKt.XX0(II0xO02, 1)) {
                                    SwipeMenuHelper.this.scrollSwipeMenuTo(viewHolder, 0.0f, -I0Io2);
                                } else {
                                    SwipeMenuHelper.this.closeSwipeMenu(viewHolder);
                                }
                            } else if (SwipeMenuHelper.this.get_scrollY() < 0.0f) {
                                if ((SwipeMenuHelper.this.get_lastDistanceY() > 0.0f && Math.abs(SwipeMenuHelper.this.get_scrollY()) >= f2) || (SwipeMenuHelper.this.get_lastDistanceY() < 0.0f && SwipeMenuHelper.this.get_scrollY() + I0Io2 < f2)) {
                                    SwipeMenuHelper.this.scrollSwipeMenuTo(viewHolder, 0.0f, -I0Io2);
                                } else {
                                    SwipeMenuHelper.this.closeSwipeMenu(viewHolder);
                                }
                            } else if (SwipeMenuHelper.this.get_scrollY() > 0.0f) {
                                if ((SwipeMenuHelper.this.get_lastDistanceY() < 0.0f && Math.abs(SwipeMenuHelper.this.get_scrollY()) >= f2) || (SwipeMenuHelper.this.get_lastDistanceY() > 0.0f && I0Io2 - SwipeMenuHelper.this.get_scrollY() < f2)) {
                                    SwipeMenuHelper.this.scrollSwipeMenuTo(viewHolder, 0.0f, I0Io2);
                                } else {
                                    SwipeMenuHelper.this.closeSwipeMenu(viewHolder);
                                }
                            }
                        }
                    }
                }
                SwipeMenuHelper.this.set_downViewHolder(null);
                SwipeMenuHelper.this.set_needHandleTouch(true);
                SwipeMenuHelper.this.set_swipeFlags(0);
                RecyclerView recyclerView2 = SwipeMenuHelper.this.get_recyclerView();
                if (recyclerView2 != null && (parent = recyclerView2.getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        };
        this.itemTouchHelperGestureListener = new II0xO0();
    }

    public static /* synthetic */ void closeSwipeMenu$default(SwipeMenuHelper swipeMenuHelper, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
        if ((i & 1) != 0) {
            viewHolder = swipeMenuHelper._swipeMenuViewHolder;
        }
        swipeMenuHelper.closeSwipeMenu(viewHolder);
    }

    private final void destroyCallbacks() {
        RecyclerView recyclerView = this._recyclerView;
        if (recyclerView != null) {
            recyclerView.removeItemDecoration(this);
            recyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
            recyclerView.removeOnChildAttachStateChangeListener(this);
            stopGestureDetection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView.ViewHolder findSwipedView(MotionEvent motionEvent) {
        RecyclerView recyclerView;
        View findChildView = findChildView(motionEvent);
        if (findChildView == null || (recyclerView = this._recyclerView) == null) {
            return null;
        }
        return recyclerView.getChildViewHolder(findChildView);
    }

    public static /* synthetic */ void scrollSwipeMenuTo$default(SwipeMenuHelper swipeMenuHelper, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        swipeMenuHelper.scrollSwipeMenuTo(viewHolder, f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scrollSwipeMenuTo$lambda$16$lambda$13(float f, float f2, float f3, float f4, SwipeMenuHelper this$0, RecyclerView.ViewHolder viewHolder, ValueAnimator it) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "$viewHolder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
        Object animatedValue = it.getAnimatedValue();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        float f5 = f + ((f2 - f) * floatValue);
        float f6 = f3 + ((f4 - f3) * floatValue);
        this$0._scrollX = f5;
        this$0._scrollY = f6;
        com.angcyo.dsladapter.internal.x0xO0oo x0xo0oo = this$0.swipeMenuCallback;
        RecyclerView recyclerView = this$0._recyclerView;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(recyclerView);
        x0xo0oo.Oxx0IOOO(recyclerView, viewHolder, f5, f6);
    }

    private final void setupCallbacks() {
        RecyclerView recyclerView = this._recyclerView;
        if (recyclerView != null) {
            this._slop = ViewConfiguration.get(recyclerView.getContext()).getScaledTouchSlop();
            recyclerView.addItemDecoration(this);
            recyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
            recyclerView.addOnChildAttachStateChangeListener(this);
            startGestureDetection();
        }
    }

    private final void startGestureDetection() {
        RecyclerView recyclerView = this._recyclerView;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(recyclerView);
        GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(recyclerView.getContext(), this.itemTouchHelperGestureListener);
        this.gestureDetectorCompat = gestureDetectorCompat;
        gestureDetectorCompat.setIsLongpressEnabled(false);
    }

    private final void stopGestureDetection() {
        this.gestureDetectorCompat = null;
    }

    public final void _cancelDragHelper(@OXOo.OOXIXo MotionEvent e1) {
        ItemTouchHelper itemTouchHelper;
        kotlin.jvm.internal.IIX0o.x0xO0oo(e1, "e1");
        DragCallbackHelper dragCallbackHelper = this._dragCallbackHelper;
        if (dragCallbackHelper != null && (itemTouchHelper = dragCallbackHelper.get_itemTouchHelper()) != null) {
            if (this._dragCallbackHelperTouchField == null) {
                Field[] declaredFields = itemTouchHelper.getClass().getDeclaredFields();
                kotlin.jvm.internal.IIX0o.oO(declaredFields, "javaClass.declaredFields");
                for (Field field : declaredFields) {
                    if (field.getType().isAssignableFrom(RecyclerView.OnItemTouchListener.class)) {
                        this._dragCallbackHelperTouchField = field;
                    }
                }
            }
            Field field2 = this._dragCallbackHelperTouchField;
            if (field2 != null) {
                field2.setAccessible(true);
                Object obj = field2.get(itemTouchHelper);
                kotlin.jvm.internal.IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.OnItemTouchListener");
                RecyclerView.OnItemTouchListener onItemTouchListener = (RecyclerView.OnItemTouchListener) obj;
                RecyclerView recyclerView = this._recyclerView;
                if (recyclerView != null) {
                    MotionEvent obtain = MotionEvent.obtain(e1);
                    obtain.setAction(3);
                    onItemTouchListener.onInterceptTouchEvent(recyclerView, obtain);
                    obtain.recycle();
                }
            }
        }
    }

    public final void _resetScrollValue() {
        this._lastVelocityX = 0.0f;
        this._lastVelocityY = 0.0f;
        this._lastDistanceX = 0.0f;
        this._lastDistanceY = 0.0f;
        this._swipeFlags = 0;
    }

    public final void attachToRecyclerView(@OXOo.oOoXoXO RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this._recyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this._recyclerView = recyclerView;
        if (recyclerView != null) {
            setupCallbacks();
        }
    }

    public final void closeSwipeMenu(@OXOo.oOoXoXO RecyclerView.ViewHolder viewHolder) {
        if (viewHolder != null) {
            scrollSwipeMenuTo(viewHolder, 0.0f, 0.0f);
        }
    }

    @OXOo.oOoXoXO
    public final View findChildView(@OXOo.OOXIXo MotionEvent event) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(event, "event");
        float x = event.getX();
        float y = event.getY();
        RecyclerView recyclerView = this._recyclerView;
        if (recyclerView != null) {
            return recyclerView.findChildViewUnder(x, y);
        }
        return null;
    }

    @OXOo.oOoXoXO
    public final GestureDetectorCompat getGestureDetectorCompat() {
        return this.gestureDetectorCompat;
    }

    @OXOo.OOXIXo
    public final GestureDetector.SimpleOnGestureListener getItemTouchHelperGestureListener() {
        return this.itemTouchHelperGestureListener;
    }

    @OXOo.OOXIXo
    public final RecyclerView.OnItemTouchListener getMOnItemTouchListener() {
        return this.mOnItemTouchListener;
    }

    @OXOo.OOXIXo
    public final com.angcyo.dsladapter.internal.x0xO0oo getSwipeMenuCallback() {
        return this.swipeMenuCallback;
    }

    @OXOo.oOoXoXO
    public final RecyclerView.ViewHolder get_downViewHolder() {
        return this._downViewHolder;
    }

    @OXOo.oOoXoXO
    public final DragCallbackHelper get_dragCallbackHelper() {
        return this._dragCallbackHelper;
    }

    @OXOo.oOoXoXO
    public final Field get_dragCallbackHelperTouchField() {
        return this._dragCallbackHelperTouchField;
    }

    public final float get_lastDistanceX() {
        return this._lastDistanceX;
    }

    public final float get_lastDistanceY() {
        return this._lastDistanceY;
    }

    @OXOo.oOoXoXO
    public final ValueAnimator get_lastValueAnimator() {
        return this._lastValueAnimator;
    }

    public final float get_lastVelocityX() {
        return this._lastVelocityX;
    }

    public final float get_lastVelocityY() {
        return this._lastVelocityY;
    }

    public final boolean get_needHandleTouch() {
        return this._needHandleTouch;
    }

    @OXOo.oOoXoXO
    public final RecyclerView get_recyclerView() {
        return this._recyclerView;
    }

    public final float get_scrollX() {
        return this._scrollX;
    }

    public final float get_scrollY() {
        return this._scrollY;
    }

    public final int get_slop() {
        return this._slop;
    }

    public final int get_swipeFlags() {
        return this._swipeFlags;
    }

    @OXOo.oOoXoXO
    public final RecyclerView.ViewHolder get_swipeMenuViewHolder() {
        return this._swipeMenuViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(@OXOo.OOXIXo View view) {
        DslAdapterItem dslAdapterItem;
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        RecyclerView recyclerView = this._recyclerView;
        if (recyclerView != null) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
            if (childViewHolder != null) {
                kotlin.jvm.internal.IIX0o.oO(childViewHolder, "getChildViewHolder(view)");
                if ((adapter instanceof DslAdapter) && (dslAdapterItem = ((DslAdapter) adapter).get(childViewHolder.getAdapterPosition(), true, false)) != null) {
                    dslAdapterItem.set_itemSwipeMenuHelper(this);
                    com.angcyo.dsladapter.internal.x0xO0oo x0xo0oo = this.swipeMenuCallback;
                    RecyclerView recyclerView2 = this._recyclerView;
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(recyclerView2);
                    x0xo0oo.Oxx0IOOO(recyclerView2, childViewHolder, 0.0f, 0.0f);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(@OXOo.OOXIXo View view) {
        DslAdapterItem dslAdapterItem;
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        RecyclerView recyclerView = this._recyclerView;
        if (recyclerView != null) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
            if (childViewHolder != null) {
                kotlin.jvm.internal.IIX0o.oO(childViewHolder, "getChildViewHolder(view)");
                if ((adapter instanceof DslAdapter) && (dslAdapterItem = ((DslAdapter) adapter).get(childViewHolder.getAdapterPosition(), true, false)) != null) {
                    dslAdapterItem.set_itemSwipeMenuHelper(null);
                }
                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(childViewHolder, this._swipeMenuViewHolder)) {
                    _resetScrollValue();
                    this._scrollX = 0.0f;
                    this._scrollY = 0.0f;
                    com.angcyo.dsladapter.internal.x0xO0oo x0xo0oo = this.swipeMenuCallback;
                    RecyclerView recyclerView2 = this._recyclerView;
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(recyclerView2);
                    x0xo0oo.Oxx0IOOO(recyclerView2, childViewHolder, 0.0f, 0.0f);
                    this._swipeMenuViewHolder = null;
                }
                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(childViewHolder, this._downViewHolder)) {
                    this._downViewHolder = null;
                }
            }
        }
    }

    public final void openSwipeMenu(@OXOo.OOXIXo RecyclerView.ViewHolder viewHolder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
        RecyclerView.ViewHolder viewHolder2 = this._swipeMenuViewHolder;
        if (viewHolder2 != null && !kotlin.jvm.internal.IIX0o.Oxx0IOOO(viewHolder2, viewHolder)) {
            closeSwipeMenu$default(this, null, 1, null);
            return;
        }
        RecyclerView recyclerView = this._recyclerView;
        if (recyclerView != null) {
            int oxoX2 = this.swipeMenuCallback.oxoX(recyclerView, viewHolder);
            if (LibExKt.XX0(this.swipeMenuCallback.II0xO0(recyclerView, viewHolder), 4)) {
                scrollSwipeMenuTo(viewHolder, -oxoX2, 0.0f);
            }
        }
    }

    public final void scrollSwipeMenuTo(@OXOo.OOXIXo final RecyclerView.ViewHolder viewHolder, final float f, final float f2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
        ValueAnimator valueAnimator = this._lastValueAnimator;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && this._recyclerView != null) {
            final float f3 = this._scrollX;
            final float f4 = this._scrollY;
            if (f != 0.0f || f2 == 0.0f) {
                this._swipeMenuViewHolder = viewHolder;
            }
            ValueAnimator valueAnimator2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.angcyo.dsladapter.XOxIOxOx
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    SwipeMenuHelper.scrollSwipeMenuTo$lambda$16$lambda$13(f3, f, f4, f2, this, viewHolder, valueAnimator3);
                }
            });
            kotlin.jvm.internal.IIX0o.oO(valueAnimator2, "valueAnimator");
            valueAnimator2.addListener(new I0Io(f, f2, this, viewHolder, this));
            valueAnimator2.setDuration(250L);
            valueAnimator2.start();
            this._lastValueAnimator = valueAnimator2;
        }
    }

    public final void setGestureDetectorCompat(@OXOo.oOoXoXO GestureDetectorCompat gestureDetectorCompat) {
        this.gestureDetectorCompat = gestureDetectorCompat;
    }

    public final void setSwipeMenuCallback(@OXOo.OOXIXo com.angcyo.dsladapter.internal.x0xO0oo x0xo0oo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0xo0oo, "<set-?>");
        this.swipeMenuCallback = x0xo0oo;
    }

    public final void set_downViewHolder(@OXOo.oOoXoXO RecyclerView.ViewHolder viewHolder) {
        this._downViewHolder = viewHolder;
    }

    public final void set_dragCallbackHelper(@OXOo.oOoXoXO DragCallbackHelper dragCallbackHelper) {
        this._dragCallbackHelper = dragCallbackHelper;
    }

    public final void set_dragCallbackHelperTouchField(@OXOo.oOoXoXO Field field) {
        this._dragCallbackHelperTouchField = field;
    }

    public final void set_lastDistanceX(float f) {
        this._lastDistanceX = f;
    }

    public final void set_lastDistanceY(float f) {
        this._lastDistanceY = f;
    }

    public final void set_lastValueAnimator(@OXOo.oOoXoXO ValueAnimator valueAnimator) {
        this._lastValueAnimator = valueAnimator;
    }

    public final void set_lastVelocityX(float f) {
        this._lastVelocityX = f;
    }

    public final void set_lastVelocityY(float f) {
        this._lastVelocityY = f;
    }

    public final void set_needHandleTouch(boolean z) {
        this._needHandleTouch = z;
    }

    public final void set_recyclerView(@OXOo.oOoXoXO RecyclerView recyclerView) {
        this._recyclerView = recyclerView;
    }

    public final void set_scrollX(float f) {
        this._scrollX = f;
    }

    public final void set_scrollY(float f) {
        this._scrollY = f;
    }

    public final void set_slop(int i) {
        this._slop = i;
    }

    public final void set_swipeFlags(int i) {
        this._swipeFlags = i;
    }

    public final void set_swipeMenuViewHolder(@OXOo.oOoXoXO RecyclerView.ViewHolder viewHolder) {
        this._swipeMenuViewHolder = viewHolder;
    }

    public final void toggleSwipeMenu(@OXOo.OOXIXo RecyclerView.ViewHolder viewHolder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(this._swipeMenuViewHolder, viewHolder)) {
            closeSwipeMenu(viewHolder);
            return;
        }
        RecyclerView.ViewHolder viewHolder2 = this._swipeMenuViewHolder;
        if (viewHolder2 != null && !kotlin.jvm.internal.IIX0o.Oxx0IOOO(viewHolder2, viewHolder)) {
            closeSwipeMenu(this._swipeMenuViewHolder);
        } else {
            openSwipeMenu(viewHolder);
        }
    }
}
