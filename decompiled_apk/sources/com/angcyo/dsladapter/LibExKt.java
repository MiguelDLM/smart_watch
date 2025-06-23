package com.angcyo.dsladapter;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.LayoutRes;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nLibEx.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LibEx.kt\ncom/angcyo/dsladapter/LibExKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,930:1\n1#2:931\n1855#3,2:932\n1855#3,2:934\n1855#3,2:936\n*S KotlinDebug\n*F\n+ 1 LibEx.kt\ncom/angcyo/dsladapter/LibExKt\n*L\n653#1:932,2\n802#1:934,2\n902#1:936,2\n*E\n"})
/* loaded from: classes7.dex */
public final class LibExKt {

    /* renamed from: I0Io */
    public static final int f5276I0Io = -1;

    /* renamed from: Oxx0IOOO */
    public static final int f5279Oxx0IOOO = 12;

    /* renamed from: X0o0xo */
    public static final int f5280X0o0xo = 15;

    /* renamed from: XO */
    public static final int f5281XO = 3;

    /* renamed from: oxoX */
    public static final int f5283oxoX = 0;

    /* renamed from: oIX0oI */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f5282oIX0oI = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Float>() { // from class: com.angcyo.dsladapter.LibExKt$dp$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final Float invoke() {
            DisplayMetrics displayMetrics;
            Resources system = Resources.getSystem();
            return Float.valueOf((system == null || (displayMetrics = system.getDisplayMetrics()) == null) ? 0.0f : displayMetrics.density);
        }
    });

    /* renamed from: II0xO0 */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f5278II0xO0 = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Integer>() { // from class: com.angcyo.dsladapter.LibExKt$dpi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final Integer invoke() {
            DisplayMetrics displayMetrics;
            Resources system = Resources.getSystem();
            return Integer.valueOf((system == null || (displayMetrics = system.getDisplayMetrics()) == null) ? 0 : (int) displayMetrics.density);
        }
    });

    /* renamed from: II0XooXoX */
    public static final int f5277II0XooXoX = Integer.MIN_VALUE;

    @XX({"SMAP\nLibEx.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LibEx.kt\ncom/angcyo/dsladapter/LibExKt$addListener$listener$1\n*L\n1#1,930:1\n*E\n"})
    /* loaded from: classes7.dex */
    public static final class oIX0oI implements Animator.AnimatorListener {

        /* renamed from: IXxxXO */
        public final /* synthetic */ Oox.oOoXoXO<Animator, oXIO0o0XI> f5284IXxxXO;

        /* renamed from: Oo */
        public final /* synthetic */ Oox.oOoXoXO<Animator, oXIO0o0XI> f5285Oo;

        /* renamed from: Oxx0xo */
        public final /* synthetic */ Oox.oOoXoXO<Animator, oXIO0o0XI> f5286Oxx0xo;

        /* renamed from: XO */
        public final /* synthetic */ Oox.oOoXoXO<Animator, oXIO0o0XI> f5287XO;

        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI(Oox.oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo, Oox.oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo2, Oox.oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo3, Oox.oOoXoXO<? super Animator, oXIO0o0XI> oooxoxo4) {
            this.f5287XO = oooxoxo;
            this.f5285Oo = oooxoxo2;
            this.f5284IXxxXO = oooxoxo3;
            this.f5286Oxx0xo = oooxoxo4;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@OXOo.OOXIXo Animator animator) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(animator, "animator");
            this.f5284IXxxXO.invoke(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@OXOo.OOXIXo Animator animator) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(animator, "animator");
            this.f5285Oo.invoke(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@OXOo.OOXIXo Animator animator) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(animator, "animator");
            this.f5287XO.invoke(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@OXOo.OOXIXo Animator animator) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(animator, "animator");
            this.f5286Oxx0xo.invoke(animator);
        }
    }

    public static /* synthetic */ View I0(ViewGroup viewGroup, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return OOXIxO0(viewGroup, i, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final DslViewHolder I0Io(@OXOo.OOXIXo ViewGroup viewGroup, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, @OXOo.OOXIXo List<? extends Object> payloads) {
        int i2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewGroup, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "dslAdapterItem");
        kotlin.jvm.internal.IIX0o.x0xO0oo(payloads, "payloads");
        viewGroup.setOnHierarchyChangeListener(new com.angcyo.dsladapter.internal.Oxx0IOOO(null, 1, 0 == true ? 1 : 0));
        boolean z = !dslAdapterItem.getItemHidden();
        View I0X0x0oIo2 = I0X0x0oIo(viewGroup, dslAdapterItem.getItemLayoutId(), false);
        DslViewHolder dslViewHolder = new DslViewHolder(I0X0x0oIo2, 0, 2, null);
        I0X0x0oIo2.setTag(dslViewHolder);
        oXIO0o0XI(I0X0x0oIo2, dslViewHolder);
        xOOOX(I0X0x0oIo2, dslAdapterItem);
        if (i < 0) {
            i = viewGroup.getChildCount();
        }
        x0OIX00oO(I0X0x0oIo2, z);
        dslAdapterItem.getItemBind().invoke(dslViewHolder, Integer.valueOf(i), dslAdapterItem, payloads);
        boolean z2 = viewGroup instanceof LinearLayout;
        if (z2) {
            LinearLayout linearLayout = (LinearLayout) viewGroup;
            if (linearLayout.getOrientation() == 1) {
                if (dslAdapterItem.getItemTopInsert() > 0) {
                    View view = new View(linearLayout.getContext());
                    XIXIX(view, dslAdapterItem);
                    x0OIX00oO(view, z);
                    view.setBackgroundColor(dslAdapterItem.getItemDecorationColor());
                    i2 = i + 1;
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dslAdapterItem.getItemTopInsert());
                    layoutParams.leftMargin = dslAdapterItem.getItemLeftOffset();
                    layoutParams.rightMargin = dslAdapterItem.getItemRightOffset();
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    viewGroup.addView(view, i, layoutParams);
                    i = i2;
                }
            } else if (dslAdapterItem.getItemLeftInsert() > 0) {
                View view2 = new View(linearLayout.getContext());
                XIXIX(view2, dslAdapterItem);
                x0OIX00oO(view2, z);
                view2.setBackgroundColor(dslAdapterItem.getItemDecorationColor());
                i2 = i + 1;
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dslAdapterItem.getItemTopInsert(), -1);
                layoutParams2.topMargin = dslAdapterItem.getItemTopOffset();
                layoutParams2.bottomMargin = dslAdapterItem.getItemBottomOffset();
                oXIO0o0XI oxio0o0xi2 = oXIO0o0XI.f29392oIX0oI;
                viewGroup.addView(view2, i, layoutParams2);
                i = i2;
            }
        }
        int i3 = i + 1;
        viewGroup.addView(I0X0x0oIo2, i);
        if (z2) {
            LinearLayout linearLayout2 = (LinearLayout) viewGroup;
            if (linearLayout2.getOrientation() == 1) {
                if (dslAdapterItem.getItemBottomInsert() > 0) {
                    View view3 = new View(linearLayout2.getContext());
                    XIXIX(view3, dslAdapterItem);
                    x0OIX00oO(view3, z);
                    view3.setBackgroundColor(dslAdapterItem.getItemDecorationColor());
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, dslAdapterItem.getItemBottomInsert());
                    layoutParams3.leftMargin = dslAdapterItem.getItemLeftOffset();
                    layoutParams3.rightMargin = dslAdapterItem.getItemRightOffset();
                    oXIO0o0XI oxio0o0xi3 = oXIO0o0XI.f29392oIX0oI;
                    viewGroup.addView(view3, i3, layoutParams3);
                }
            } else if (dslAdapterItem.getItemRightInsert() > 0) {
                View view4 = new View(linearLayout2.getContext());
                XIXIX(view4, dslAdapterItem);
                x0OIX00oO(view4, z);
                view4.setBackgroundColor(dslAdapterItem.getItemDecorationColor());
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(dslAdapterItem.getItemRightInsert(), -1);
                layoutParams4.topMargin = dslAdapterItem.getItemTopOffset();
                layoutParams4.bottomMargin = dslAdapterItem.getItemBottomOffset();
                oXIO0o0XI oxio0o0xi4 = oXIO0o0XI.f29392oIX0oI;
                viewGroup.addView(view4, i3, layoutParams4);
            }
        }
        return dslViewHolder;
    }

    @OXOo.OOXIXo
    public static final View I0X0x0oIo(@OXOo.OOXIXo ViewGroup viewGroup, @LayoutRes int i, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewGroup, "<this>");
        if (i == -1) {
            return viewGroup;
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, z);
        kotlin.jvm.internal.IIX0o.oO(inflate, "from(context).inflate(la…utId, this, attachToRoot)");
        return inflate;
    }

    public static final boolean I0oOIX() {
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(Looper.getMainLooper(), Looper.myLooper());
    }

    @OXOo.oOoXoXO
    public static final DslViewHolder I0oOoX(@OXOo.OOXIXo Fragment fragment) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fragment, "<this>");
        View view = fragment.getView();
        if (view != null) {
            return IIXOooo(view);
        }
        return null;
    }

    @OXOo.oOoXoXO
    public static final Animator II0XooXoX(@OXOo.OOXIXo Context context, @AnimatorRes int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        if (i != -1 && i != 0) {
            try {
                return AnimatorInflater.loadAnimator(context, i);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static final <T> int II0xO0(@OXOo.OOXIXo List<T> list, T t, T t2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        int indexOf = list.indexOf(t);
        if (indexOf == -1) {
            return -1;
        }
        list.add(indexOf, t2);
        return indexOf;
    }

    public static final void IIX0(@OXOo.OOXIXo View view, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    public static final void IIX0o(@OXOo.OOXIXo ViewGroup viewGroup, boolean z, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super View, oXIO0o0XI> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewGroup, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "map");
        OxI(viewGroup, z, map);
    }

    @OXOo.OOXIXo
    public static final DslViewHolder IIXOooo(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "<this>");
        Object tag = view.getTag(R.id.lib_tag_dsl_view_holder);
        if (tag instanceof DslViewHolder) {
            return (DslViewHolder) tag;
        }
        Object tag2 = view.getTag();
        if (tag2 instanceof DslViewHolder) {
            return (DslViewHolder) tag2;
        }
        DslViewHolder dslViewHolder = new DslViewHolder(view, 0, 2, null);
        oXIO0o0XI(view, dslViewHolder);
        return dslViewHolder;
    }

    public static final <T> boolean IIxOXoOo0(@OXOo.OOXIXo List<T> list, T t, @OXOo.oOoXoXO T t2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        int indexOf = list.indexOf(t);
        if (indexOf != -1) {
            if (t2 == null) {
                return list.remove(t);
            }
            list.set(indexOf, t2);
            return true;
        }
        return false;
    }

    public static final int IO() {
        return f5277II0XooXoX;
    }

    public static final void IXxxXO(@OXOo.OOXIXo View view, boolean z, boolean z2, boolean z3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "<this>");
        if (z) {
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        }
        if (z2) {
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
        }
        if (z3) {
            view.setAlpha(1.0f);
        }
    }

    @OXOo.oOoXoXO
    public static final DslAdapter Io(@OXOo.OOXIXo RecyclerView recyclerView) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "<this>");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter instanceof DslAdapter) {
            return (DslAdapter) adapter;
        }
        return null;
    }

    public static final void IoIOOxIIo(@OXOo.OOXIXo ViewGroup viewGroup, @OXOo.OOXIXo final List<? extends Object> payloads) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewGroup, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(payloads, "payloads");
        ooXIXxIX(viewGroup, false, new Oox.x0xO0oo<Integer, View, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.LibExKt$updateAllDslItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, View view) {
                invoke(num.intValue(), view);
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i, @OXOo.OOXIXo View child) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(child, "child");
                DslAdapterItem O02 = LibExKt.O0(child);
                if (O02 != null) {
                    O02.getItemBind().invoke(LibExKt.IIXOooo(child), Integer.valueOf(i), O02, payloads);
                }
            }
        }, 1, null);
    }

    @OXOo.oOoXoXO
    public static final View IoOoX(@OXOo.OOXIXo ViewGroup viewGroup, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewGroup, "<this>");
        if (i >= 0 && i < viewGroup.getChildCount()) {
            return viewGroup.getChildAt(i);
        }
        return null;
    }

    public static /* synthetic */ int IoOoo(View view, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return OO(view, i);
    }

    public static /* synthetic */ MotionEvent Ioxxx(int i, float f, float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f2 = 0.0f;
        }
        return XIo0oOXIx(i, f, f2);
    }

    @OXOo.oOoXoXO
    public static final DslAdapterItem O0(@OXOo.oOoXoXO View view) {
        if (view == null) {
            return null;
        }
        Object tag = view.getTag(R.id.lib_tag_dsl_adapter_item);
        if (!(tag instanceof DslAdapterItem)) {
            return null;
        }
        return (DslAdapterItem) tag;
    }

    public static final void O00XxXI(@OXOo.OOXIXo ViewGroup viewGroup, @OXOo.OOXIXo final Oox.x0xO0oo<? super Integer, ? super DslAdapterItem, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewGroup, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        final ArrayList arrayList = new ArrayList();
        ooXIXxIX(viewGroup, false, new Oox.x0xO0oo<Integer, View, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.LibExKt$removeAllDslItem$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, View view) {
                invoke(num.intValue(), view);
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i, @OXOo.OOXIXo View child) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(child, "child");
                if (predicate.invoke(Integer.valueOf(i), LibExKt.O0(child)).booleanValue()) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
        }, 1, null);
        kotlin.collections.X0IIOO.oXX0IoI(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            viewGroup.removeViewAt(((Number) it.next()).intValue());
        }
    }

    public static final void O0X(@OXOo.OOXIXo View view, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        view.setLayoutParams(layoutParams);
    }

    public static final boolean O0Xx(@OXOo.oOoXoXO List<? extends Object> list) {
        int i;
        Object obj;
        boolean z;
        if (list != null) {
            i = list.size();
        } else {
            i = -1;
        }
        boolean z2 = false;
        if (i > 0) {
            return false;
        }
        if (list == null) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (obj != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj == null) {
            z2 = true;
        }
        return z2;
    }

    public static /* synthetic */ void O0xOxO(ViewGroup viewGroup, boolean z, Oox.x0xO0oo x0xo0oo, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        OxI(viewGroup, z, x0xo0oo);
    }

    public static /* synthetic */ Rect OI0(View view, Rect rect, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = new Rect();
        }
        return x0o(view, rect);
    }

    public static /* synthetic */ void OIOoIIOIx(ViewGroup viewGroup, DslAdapterItem dslAdapterItem, int i, List list, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            list = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        OoO(viewGroup, dslAdapterItem, i, list);
    }

    public static final int OO(@OXOo.oOoXoXO View view, int i) {
        if (view != null) {
            return view.getMeasuredHeight();
        }
        return i;
    }

    public static final void OO0x0xX(@OXOo.OOXIXo Field field) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(field, "field");
        if ((!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers()) || Modifier.isFinal(field.getModifiers())) && !field.isAccessible()) {
            field.setAccessible(true);
        }
    }

    public static /* synthetic */ DslViewHolder OOXIXo(ViewGroup viewGroup, DslAdapterItem dslAdapterItem, int i, List list, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            list = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return xxIXOIIO(viewGroup, dslAdapterItem, i, list);
    }

    @OXOo.OOXIXo
    public static final View OOXIxO0(@OXOo.OOXIXo ViewGroup viewGroup, @LayoutRes int i, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewGroup, "<this>");
        if (viewGroup.getChildCount() > 0 && i != -1) {
            viewGroup.removeAllViews();
        }
        return I0X0x0oIo(viewGroup, i, z);
    }

    public static final void OX00O0xII(@OXOo.OOXIXo View view, @OXOo.OOXIXo Animator animator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(animator, "animator");
        view.setTag(R.id.lib_tag_animator, new WeakReference(animator));
    }

    public static final void Oo(@OXOo.OOXIXo Rect rect) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(rect, "<this>");
        rect.set(0, 0, 0, 0);
    }

    public static final void OoO(@OXOo.OOXIXo ViewGroup viewGroup, @OXOo.OOXIXo final DslAdapterItem item, int i, @OXOo.OOXIXo final List<? extends Object> payloads) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewGroup, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        kotlin.jvm.internal.IIX0o.x0xO0oo(payloads, "payloads");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        ooXIXxIX(viewGroup, false, new Oox.x0xO0oo<Integer, View, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.LibExKt$updateOrInsertDslItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, View view) {
                invoke(num.intValue(), view);
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i2, @OXOo.OOXIXo View child) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(child, "child");
                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(DslAdapterItem.this, LibExKt.O0(child))) {
                    booleanRef.element = true;
                    DslAdapterItem.this.getItemBind().invoke(LibExKt.IIXOooo(child), Integer.valueOf(i2), DslAdapterItem.this, payloads);
                }
            }
        }, 1, null);
        if (!booleanRef.element) {
            I0Io(viewGroup, item, i, payloads);
        }
    }

    public static final int Ox0O(@OXOo.oOoXoXO List<?> list) {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public static final void OxI(@OXOo.OOXIXo ViewGroup viewGroup, boolean z, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super View, oXIO0o0XI> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewGroup, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "map");
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            Integer valueOf = Integer.valueOf(i);
            kotlin.jvm.internal.IIX0o.oO(childAt, "childAt");
            map.invoke(valueOf, childAt);
            if (z && (childAt instanceof ViewGroup)) {
                OxI((ViewGroup) childAt, true, map);
            }
        }
    }

    @OXOo.oOoXoXO
    public static final Animation Oxx0IOOO(@OXOo.OOXIXo Context context, @AnimRes int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        if (i != -1 && i != 0) {
            try {
                return AnimationUtils.loadAnimation(context, i);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static /* synthetic */ void Oxx0xo(View view, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            z3 = true;
        }
        IXxxXO(view, z, z2, z3);
    }

    @OXOo.OOXIXo
    public static final GridLayoutManager.SpanSizeLookup OxxIIOOXO(@OXOo.OOXIXo GridLayoutManager gridLayoutManager, @OXOo.OOXIXo final DslAdapter dslAdapter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(gridLayoutManager, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "dslAdapter");
        final int spanCount = gridLayoutManager.getSpanCount();
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() { // from class: com.angcyo.dsladapter.LibExKt$dslSpanSizeLookup$spanSizeLookup$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                if (DslAdapter.this.isAdapterStatus()) {
                    return spanCount;
                }
                DslAdapterItem itemData$default = DslAdapter.getItemData$default(DslAdapter.this, i, false, 2, null);
                if (itemData$default != null) {
                    int i2 = spanCount;
                    if (itemData$default.getItemSpanCount() == -1) {
                        return i2;
                    }
                    return itemData$default.getItemSpanCount();
                }
                return 1;
            }
        };
        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
        return spanSizeLookup;
    }

    @OXOo.oOoXoXO
    public static final Object X00IoxXI(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo Class<?> cls, @OXOo.OOXIXo String member) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cls, "cls");
        kotlin.jvm.internal.IIX0o.x0xO0oo(member, "member");
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                try {
                    Field memberField = cls.getDeclaredField(member);
                    kotlin.jvm.internal.IIX0o.oO(memberField, "memberField");
                    OO0x0xX(memberField);
                    return memberField.get(obj);
                } catch (NoSuchFieldException unused) {
                }
            } catch (Exception unused2) {
                return null;
            }
        }
        return null;
    }

    public static final void X0IIOO(@OXOo.OOXIXo RecyclerView recyclerView, @OXOo.oOoXoXO View view, @OXOo.OOXIXo Oox.IXxxXO<? super DslViewHolder, ? super DslViewHolder, ? super DslViewHolder, oXIO0o0XI> callback) {
        DslViewHolder dslViewHolder;
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(callback, "callback");
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            RecyclerView.ViewHolder findContainingViewHolder = recyclerView.findContainingViewHolder(childAt);
            if (findContainingViewHolder != null) {
                DslViewHolder dslViewHolder2 = null;
                if (i >= 1) {
                    dslViewHolder = (DslViewHolder) recyclerView.findContainingViewHolder(recyclerView.getChildAt(i - 1));
                } else {
                    dslViewHolder = null;
                }
                if (i < childCount - 1) {
                    dslViewHolder2 = (DslViewHolder) recyclerView.findContainingViewHolder(recyclerView.getChildAt(i + 1));
                }
                if (view != null) {
                    if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(view, childAt)) {
                        callback.invoke(dslViewHolder, (DslViewHolder) findContainingViewHolder, dslViewHolder2);
                        return;
                    }
                } else {
                    callback.invoke(dslViewHolder, (DslViewHolder) findContainingViewHolder, dslViewHolder2);
                }
            }
        }
    }

    @OXOo.OOXIXo
    public static final Animator.AnimatorListener X0o0xo(@OXOo.OOXIXo Animator animator, @OXOo.OOXIXo Oox.oOoXoXO<? super Animator, oXIO0o0XI> onEnd, @OXOo.OOXIXo Oox.oOoXoXO<? super Animator, oXIO0o0XI> onStart, @OXOo.OOXIXo Oox.oOoXoXO<? super Animator, oXIO0o0XI> onCancel, @OXOo.OOXIXo Oox.oOoXoXO<? super Animator, oXIO0o0XI> onRepeat) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(animator, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(onEnd, "onEnd");
        kotlin.jvm.internal.IIX0o.x0xO0oo(onStart, "onStart");
        kotlin.jvm.internal.IIX0o.x0xO0oo(onCancel, "onCancel");
        kotlin.jvm.internal.IIX0o.x0xO0oo(onRepeat, "onRepeat");
        oIX0oI oix0oi = new oIX0oI(onRepeat, onEnd, onCancel, onStart);
        animator.addListener(oix0oi);
        return oix0oi;
    }

    public static /* synthetic */ void XI0IXoo(RecyclerView recyclerView, View view, Oox.IXxxXO iXxxXO, int i, Object obj) {
        if ((i & 1) != 0) {
            view = null;
        }
        X0IIOO(recyclerView, view, iXxxXO);
    }

    public static final void XI0oooXX(@OXOo.OOXIXo ViewGroup viewGroup, @OXOo.oOoXoXO final DslAdapterItem dslAdapterItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewGroup, "<this>");
        O00XxXI(viewGroup, new Oox.x0xO0oo<Integer, DslAdapterItem, Boolean>() { // from class: com.angcyo.dsladapter.LibExKt$removeDslItem$1
            {
                super(2);
            }

            @OXOo.OOXIXo
            public final Boolean invoke(int i, @OXOo.oOoXoXO DslAdapterItem dslAdapterItem2) {
                return Boolean.valueOf(kotlin.jvm.internal.IIX0o.Oxx0IOOO(dslAdapterItem2, DslAdapterItem.this));
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num, DslAdapterItem dslAdapterItem2) {
                return invoke(num.intValue(), dslAdapterItem2);
            }
        });
    }

    public static final void XIXIX(@OXOo.oOoXoXO View view, @OXOo.oOoXoXO DslAdapterItem dslAdapterItem) {
        Object obj;
        if (view != null) {
            int i = R.id.lib_tag_dsl_item_decoration;
            if (dslAdapterItem == null || (obj = dslAdapterItem.getItemTag()) == null) {
                if (dslAdapterItem != null) {
                    obj = Integer.valueOf(dslAdapterItem.hashCode());
                } else {
                    obj = null;
                }
            }
            view.setTag(i, String.valueOf(obj));
        }
    }

    public static /* synthetic */ void XIXIxO(ViewGroup viewGroup, DslAdapterItem dslAdapterItem, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        o0oIxOo(viewGroup, dslAdapterItem, list);
    }

    @OXOo.OOXIXo
    public static final MotionEvent XIo0oOXIx(int i, float f, float f2) {
        MotionEvent obtain = MotionEvent.obtain(o0xxxXXxX(), o0xxxXXxX(), i, f, f2, 0);
        kotlin.jvm.internal.IIX0o.oO(obtain, "obtain(\n        nowTime(…       y,\n        0\n    )");
        return obtain;
    }

    @OXOo.oOoXoXO
    public static final <T> T XIxXXX0x0(@OXOo.oOoXoXO T t, @OXOo.OOXIXo Oox.oIX0oI<oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        if (t == null) {
            action.invoke();
        }
        return t;
    }

    public static /* synthetic */ Animator.AnimatorListener XO(Animator animator, Oox.oOoXoXO onEnd, Oox.oOoXoXO onStart, Oox.oOoXoXO onCancel, Oox.oOoXoXO onRepeat, int i, Object obj) {
        if ((i & 1) != 0) {
            onEnd = new Oox.oOoXoXO<Animator, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.LibExKt$addListener$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo Animator it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Animator animator2) {
                    invoke2(animator2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        if ((i & 2) != 0) {
            onStart = new Oox.oOoXoXO<Animator, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.LibExKt$addListener$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo Animator it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Animator animator2) {
                    invoke2(animator2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        if ((i & 4) != 0) {
            onCancel = new Oox.oOoXoXO<Animator, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.LibExKt$addListener$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo Animator it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Animator animator2) {
                    invoke2(animator2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        if ((i & 8) != 0) {
            onRepeat = new Oox.oOoXoXO<Animator, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.LibExKt$addListener$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo Animator it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Animator animator2) {
                    invoke2(animator2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(animator, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(onEnd, "onEnd");
        kotlin.jvm.internal.IIX0o.x0xO0oo(onStart, "onStart");
        kotlin.jvm.internal.IIX0o.x0xO0oo(onCancel, "onCancel");
        kotlin.jvm.internal.IIX0o.x0xO0oo(onRepeat, "onRepeat");
        oIX0oI oix0oi = new oIX0oI(onRepeat, onEnd, onCancel, onStart);
        animator.addListener(oix0oi);
        return oix0oi;
    }

    public static /* synthetic */ Rect XOxIOxOx(View view, int i, int i2, Rect rect, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            rect = new Rect();
        }
        return xII(view, i, i2, rect);
    }

    @OXOo.oOoXoXO
    public static final DslViewHolder XX(@OXOo.OOXIXo android.app.Fragment fragment) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fragment, "<this>");
        View view = fragment.getView();
        if (view != null) {
            return IIXOooo(view);
        }
        return null;
    }

    public static final boolean XX0(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return false;
        }
        return (i == 0 && i2 == 0) || (((i > 0 && i2 > 0) || (i < 0 && i2 < 0)) && (i & i2) == i2);
    }

    public static final void XX0xXo(@OXOo.OOXIXo Object[] anys, @OXOo.OOXIXo Oox.oOoXoXO<? super Object[], oXIO0o0XI> doIt) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(anys, "anys");
        kotlin.jvm.internal.IIX0o.x0xO0oo(doIt, "doIt");
        for (Object obj : anys) {
            if (obj == null) {
                return;
            }
        }
        doIt.invoke(anys);
    }

    public static /* synthetic */ void XXoOx0(View view, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        x0OIX00oO(view, z);
    }

    public static final void Xo0(@OXOo.oOoXoXO View view, boolean z) {
        int i;
        if (view != null) {
            if (z) {
                i = 4;
            } else {
                i = 0;
            }
            view.setVisibility(i);
        }
    }

    public static /* synthetic */ void XoI0Ixx0(View view, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        Xo0(view, z);
    }

    public static /* synthetic */ void XoX(View view, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        oxxXoxO(view, z);
    }

    public static final <T> int Xx000oIo(T t) {
        return ((Number) f5278II0xO0.getValue()).intValue();
    }

    @OXOo.OOXIXo
    public static final List<DslAdapterItem> XxX0x0xxx(@OXOo.OOXIXo ViewGroup viewGroup, final boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewGroup, "<this>");
        final ArrayList arrayList = new ArrayList();
        ooXIXxIX(viewGroup, false, new Oox.x0xO0oo<Integer, View, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.LibExKt$findDslItemList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, View view) {
                invoke(num.intValue(), view);
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i, @OXOo.OOXIXo View child) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(child, "child");
                DslAdapterItem O02 = LibExKt.O0(child);
                if (O02 != null) {
                    boolean z2 = z;
                    List<DslAdapterItem> list = arrayList;
                    if (z2) {
                        if (LibExKt.xoxXI(child)) {
                            list.add(O02);
                            return;
                        }
                        return;
                    }
                    list.add(O02);
                }
            }
        }, 1, null);
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final DslViewHolder o0(@OXOo.OOXIXo Activity activity) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "<this>");
        View decorView = activity.getWindow().getDecorView();
        kotlin.jvm.internal.IIX0o.oO(decorView, "window.decorView");
        return IIXOooo(decorView);
    }

    public static /* synthetic */ void o00(ViewGroup viewGroup, boolean z, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        xoXoI(viewGroup, z, oooxoxo);
    }

    public static final void o0oIxOo(@OXOo.OOXIXo ViewGroup viewGroup, @OXOo.OOXIXo final DslAdapterItem item, @OXOo.OOXIXo final List<? extends Object> payloads) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewGroup, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        kotlin.jvm.internal.IIX0o.x0xO0oo(payloads, "payloads");
        ooXIXxIX(viewGroup, false, new Oox.x0xO0oo<Integer, View, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.LibExKt$updateDslItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, View view) {
                invoke(num.intValue(), view);
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i, @OXOo.OOXIXo View child) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(child, "child");
                DslAdapterItem O02 = LibExKt.O0(child);
                if (O02 != null) {
                    DslAdapterItem dslAdapterItem = DslAdapterItem.this;
                    List<? extends Object> list = payloads;
                    if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(dslAdapterItem, O02)) {
                        O02.getItemBind().invoke(LibExKt.IIXOooo(child), Integer.valueOf(i), O02, list);
                    }
                }
            }
        }, 1, null);
    }

    public static final long o0xxxXXxX() {
        return System.currentTimeMillis();
    }

    @OXOo.OOXIXo
    public static final GridLayoutManager.SpanSizeLookup oI0IIXIo(@OXOo.OOXIXo GridLayoutManager gridLayoutManager, @OXOo.OOXIXo final RecyclerView recyclerView) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(gridLayoutManager, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
        final int spanCount = gridLayoutManager.getSpanCount();
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() { // from class: com.angcyo.dsladapter.LibExKt$dslSpanSizeLookup$spanSizeLookup$2
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                DslAdapter dslAdapter;
                DslAdapterItem itemData$default;
                RecyclerView.Adapter adapter = RecyclerView.this.getAdapter();
                if (adapter instanceof DslAdapter) {
                    dslAdapter = (DslAdapter) adapter;
                } else {
                    dslAdapter = null;
                }
                if (dslAdapter != null && dslAdapter.isAdapterStatus()) {
                    return spanCount;
                }
                if (dslAdapter == null || (itemData$default = DslAdapter.getItemData$default(dslAdapter, i, false, 2, null)) == null) {
                    return 1;
                }
                int i2 = spanCount;
                if (itemData$default.getItemSpanCount() == -1) {
                    return i2;
                }
                return itemData$default.getItemSpanCount();
            }
        };
        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
        return spanSizeLookup;
    }

    public static final <T> int oIX0oI(@OXOo.OOXIXo List<T> list, T t, T t2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        int indexOf = list.indexOf(t);
        if (indexOf == -1) {
            return -1;
        }
        int i = indexOf + 1;
        list.add(i, t2);
        return i;
    }

    public static final void oO(@OXOo.OOXIXo View view) {
        Animator animator;
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "<this>");
        Object tag = view.getTag(R.id.lib_tag_animator);
        if (tag instanceof WeakReference) {
            Object obj = ((WeakReference) tag).get();
            if (obj instanceof Animator) {
                animator = (Animator) obj;
            }
            animator = null;
        } else {
            if (tag instanceof Animator) {
                animator = (Animator) tag;
            }
            animator = null;
        }
        if (animator != null) {
            animator.cancel();
        }
    }

    public static final <T> float oOXoIIIo(T t) {
        return ((Number) f5282oIX0oI.getValue()).floatValue();
    }

    public static final void oOo(@OXOo.OOXIXo View view, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    public static /* synthetic */ void oOoXoXO(ViewGroup viewGroup, List list, int i, List list2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            list2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        xoIox(viewGroup, list, i, list2);
    }

    public static /* synthetic */ View oX(ViewGroup viewGroup, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return I0X0x0oIo(viewGroup, i, z);
    }

    public static final void oXIO0o0XI(@OXOo.oOoXoXO View view, @OXOo.oOoXoXO DslViewHolder dslViewHolder) {
        if (view != null) {
            view.setTag(R.id.lib_tag_dsl_view_holder, dslViewHolder);
        }
    }

    @OXOo.oOoXoXO
    public static final View oo(@OXOo.OOXIXo View view, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "<this>");
        if (view instanceof ViewGroup) {
            return IoOoX((ViewGroup) view, i);
        }
        return view;
    }

    public static /* synthetic */ void oo0xXOI0I(View view, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        xI(view, z);
    }

    @OXOo.oOoXoXO
    public static final DslViewHolder ooOOo0oXI(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.oOoXoXO View view, int i, @OXOo.OOXIXo List<? extends Object> payloads) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(payloads, "payloads");
        if (view == null) {
            return null;
        }
        DslViewHolder dslViewHolder = new DslViewHolder(view, 0, 2, null);
        view.setTag(dslViewHolder);
        oXIO0o0XI(view, dslViewHolder);
        xOOOX(view, dslAdapterItem);
        dslAdapterItem.getItemBind().invoke(dslViewHolder, Integer.valueOf(i), dslAdapterItem, payloads);
        return dslViewHolder;
    }

    public static final void ooOx(@OXOo.OOXIXo ViewGroup viewGroup, @OXOo.OOXIXo DslAdapterItem item) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewGroup, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        xoO0xx0(viewGroup, kotlin.collections.oI0IIXIo.OOXIXo(item));
    }

    public static /* synthetic */ void ooXIXxIX(ViewGroup viewGroup, boolean z, Oox.x0xO0oo x0xo0oo, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        IIX0o(viewGroup, z, x0xo0oo);
    }

    public static /* synthetic */ void ox(ViewGroup viewGroup, Oox.x0xO0oo x0xo0oo, int i, Object obj) {
        if ((i & 1) != 0) {
            x0xo0oo = new Oox.x0xO0oo<Integer, DslAdapterItem, Boolean>() { // from class: com.angcyo.dsladapter.LibExKt$removeAllDslItem$1
                @OXOo.OOXIXo
                public final Boolean invoke(int i2, @OXOo.oOoXoXO DslAdapterItem dslAdapterItem) {
                    return Boolean.valueOf(dslAdapterItem != null);
                }

                @Override // Oox.x0xO0oo
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, DslAdapterItem dslAdapterItem) {
                    return invoke(num.intValue(), dslAdapterItem);
                }
            };
        }
        O00XxXI(viewGroup, x0xo0oo);
    }

    public static /* synthetic */ void oxIIX0o(ViewGroup viewGroup, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        IoIOOxIIo(viewGroup, list);
    }

    @OXOo.OOXIXo
    public static final GridLayoutManager oxXx0IX(@OXOo.OOXIXo Context context, @OXOo.OOXIXo DslAdapter dslAdapter, int i, int i2, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "dslAdapter");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, i, i2, z);
        OxxIIOOXO(gridLayoutManager, dslAdapter);
        return gridLayoutManager;
    }

    public static /* synthetic */ DslViewHolder oxoX(ViewGroup viewGroup, DslAdapterItem dslAdapterItem, int i, List list, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            list = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return I0Io(viewGroup, dslAdapterItem, i, list);
    }

    public static final void oxxXoxO(@OXOo.oOoXoXO View view, boolean z) {
        int i;
        if (view != null) {
            if (z) {
                i = 8;
            } else {
                i = 0;
            }
            view.setVisibility(i);
        }
    }

    public static final void x0OIX00oO(@OXOo.oOoXoXO View view, boolean z) {
        int i;
        if (view != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    public static /* synthetic */ DslViewHolder x0XOIxOo(DslAdapterItem dslAdapterItem, View view, int i, List list, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            list = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return ooOOo0oXI(dslAdapterItem, view, i, list);
    }

    @OXOo.OOXIXo
    public static final Rect x0o(@OXOo.OOXIXo View view, @OXOo.OOXIXo Rect result) {
        Activity activity;
        int i;
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(result, "result");
        Context context = view.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.getWindow().getDecorView().getGlobalVisibleRect(result);
            if (result.width() > result.height()) {
                i = xxIO(activity);
                return xII(view, i, 0, result);
            }
        }
        i = 0;
        return xII(view, i, 0, result);
    }

    public static /* synthetic */ int x0xO(View view, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return xoIxX(view, i);
    }

    @OXOo.OOXIXo
    public static final String x0xO0oo(@OXOo.OOXIXo Object obj) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(obj, "<this>");
        if (obj instanceof Class) {
            String name = ((Class) obj).getName();
            kotlin.jvm.internal.IIX0o.oO(name, "name");
            return name;
        }
        String name2 = obj.getClass().getName();
        kotlin.jvm.internal.IIX0o.oO(name2, "this.javaClass.name");
        return name2;
    }

    public static final void xI(@OXOo.OOXIXo View view, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            if (z != layoutParams2.isFullSpan()) {
                layoutParams2.setFullSpan(true);
                view.setLayoutParams(layoutParams);
            }
        }
    }

    public static final float xI0oxI00(@OXOo.OOXIXo Paint paint) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(paint, "<this>");
        return paint.descent() - paint.ascent();
    }

    @OXOo.OOXIXo
    public static final Rect xII(@OXOo.OOXIXo View view, int i, int i2, @OXOo.OOXIXo Rect result) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(result, "result");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0] + i;
        int i4 = iArr[1] + i2;
        result.set(i3, i4, view.getMeasuredWidth() + i3, view.getMeasuredHeight() + i4);
        return result;
    }

    public static final void xOOOX(@OXOo.oOoXoXO View view, @OXOo.oOoXoXO DslAdapterItem dslAdapterItem) {
        if (view != null) {
            view.setTag(R.id.lib_tag_dsl_adapter_item, dslAdapterItem);
        }
    }

    @OXOo.OOXIXo
    public static final String xOoOIoI(@OXOo.OOXIXo Object obj) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(obj, "<this>");
        return obj.getClass().getSimpleName() + HexStringBuilder.COMMENT_BEGIN_CHAR + xXOx(obj) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public static final void xX0IIXIx0(@OXOo.OOXIXo View view, @OXOo.oOoXoXO Drawable drawable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "<this>");
        ViewCompat.setBackground(view, drawable);
    }

    @OXOo.oOoXoXO
    public static final String xXOx(@OXOo.oOoXoXO Object obj) {
        if (obj != null) {
            return Integer.toHexString(obj.hashCode());
        }
        return null;
    }

    public static /* synthetic */ List xXxxox0I(ViewGroup viewGroup, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return XxX0x0xxx(viewGroup, z);
    }

    public static /* synthetic */ GridLayoutManager xo0x(Context context, DslAdapter dslAdapter, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 4;
        }
        if ((i3 & 8) != 0) {
            i2 = 1;
        }
        if ((i3 & 16) != 0) {
            z = false;
        }
        return oxXx0IX(context, dslAdapter, i, i2, z);
    }

    public static final void xoIox(@OXOo.OOXIXo ViewGroup viewGroup, @OXOo.OOXIXo List<? extends DslAdapterItem> items, int i, @OXOo.OOXIXo List<? extends Object> payloads) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewGroup, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(items, "items");
        kotlin.jvm.internal.IIX0o.x0xO0oo(payloads, "payloads");
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            xxIXOIIO(viewGroup, (DslAdapterItem) it.next(), i, payloads);
            if (i >= 0) {
                i++;
            }
        }
    }

    public static final int xoIxX(@OXOo.oOoXoXO View view, int i) {
        if (view != null) {
            return view.getMeasuredWidth();
        }
        return i;
    }

    public static final void xoO0xx0(@OXOo.OOXIXo ViewGroup viewGroup, @OXOo.OOXIXo List<? extends DslAdapterItem> items) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewGroup, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(items, "items");
        int childCount = viewGroup.getChildCount();
        int size = items.size();
        ArrayList arrayList = new ArrayList();
        int min = Math.min(childCount, size);
        for (int i = 0; i < min; i++) {
            View childView = viewGroup.getChildAt(i);
            DslAdapterItem dslAdapterItem = items.get(i);
            Object tag = childView.getTag(R.id.tag);
            if ((tag instanceof Integer) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(tag, Integer.valueOf(dslAdapterItem.getItemLayoutId()))) {
                kotlin.jvm.internal.IIX0o.oO(childView, "childView");
                dslAdapterItem.getItemBind().invoke(IIXOooo(childView), Integer.valueOf(i), dslAdapterItem, CollectionsKt__CollectionsKt.ooXIXxIX());
            } else {
                arrayList.add(Integer.valueOf(i));
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            DslAdapterItem dslAdapterItem2 = items.get(intValue);
            viewGroup.removeViewAt(intValue);
            oxoX(viewGroup, dslAdapterItem2, intValue, null, 4, null);
        }
        for (int i2 = size; i2 < childCount; i2++) {
            viewGroup.removeViewAt(i2);
        }
        while (childCount < size) {
            oxoX(viewGroup, items.get(childCount), 0, null, 6, null);
            childCount++;
        }
    }

    public static final void xoXoI(@OXOo.OOXIXo ViewGroup viewGroup, boolean z, @OXOo.OOXIXo final Oox.oOoXoXO<? super View, oXIO0o0XI> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewGroup, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "map");
        OxI(viewGroup, z, new Oox.x0xO0oo<Integer, View, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.LibExKt$each$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, View view) {
                invoke(num.intValue(), view);
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i, @OXOo.OOXIXo View child) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(child, "child");
                map.invoke(child);
            }
        });
    }

    public static final boolean xoxXI(@OXOo.oOoXoXO View view) {
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @OXOo.oOoXoXO
    public static final DslViewHolder xx0X0(@OXOo.oOoXoXO View view) {
        if (view == null) {
            return null;
        }
        Object tag = view.getTag(R.id.lib_tag_dsl_view_holder);
        if (tag instanceof DslViewHolder) {
            return (DslViewHolder) tag;
        }
        Object tag2 = view.getTag();
        if (!(tag2 instanceof DslViewHolder)) {
            return null;
        }
        return (DslViewHolder) tag2;
    }

    public static final int xxIO(@OXOo.OOXIXo Context context) {
        int i;
        int i2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        if (context instanceof Activity) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            Activity activity = (Activity) context;
            activity.getWindow().getDecorView().getGlobalVisibleRect(rect);
            activity.getWindow().findViewById(android.R.id.content).getGlobalVisibleRect(rect2);
            if (rect.width() > rect.height()) {
                i = rect.width();
                i2 = rect2.width();
            } else {
                i = rect.bottom;
                i2 = rect2.bottom;
            }
            return i - i2;
        }
        return 0;
    }

    @OXOo.OOXIXo
    public static final DslViewHolder xxIXOIIO(@OXOo.OOXIXo ViewGroup viewGroup, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, @OXOo.OOXIXo List<? extends Object> payloads) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(viewGroup, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "dslAdapterItem");
        kotlin.jvm.internal.IIX0o.x0xO0oo(payloads, "payloads");
        return I0Io(viewGroup, dslAdapterItem, i, payloads);
    }

    public static /* synthetic */ Object xxX(Object obj, Oox.oIX0oI oix0oi, int i, Object obj2) {
        if ((i & 1) != 0) {
            oix0oi = new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.angcyo.dsladapter.LibExKt$elseNull$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                    invoke2();
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        return XIxXXX0x0(obj, oix0oi);
    }
}
