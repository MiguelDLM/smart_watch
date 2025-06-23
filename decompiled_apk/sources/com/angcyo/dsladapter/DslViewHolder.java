package com.angcyo.dsladapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.internal.ThrottleClickListener;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nDslViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DslViewHolder.kt\ncom/angcyo/dsladapter/DslViewHolder\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,771:1\n13600#2,2:772\n13600#2,2:774\n13600#2,2:776\n*S KotlinDebug\n*F\n+ 1 DslViewHolder.kt\ncom/angcyo/dsladapter/DslViewHolder\n*L\n113#1:772,2\n167#1:774,2\n194#1:776,2\n*E\n"})
@MainThread
/* loaded from: classes7.dex */
public class DslViewHolder extends RecyclerView.ViewHolder {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    private static int DEFAULT_INITIAL_CAPACITY = 32;
    public static final int EVENT_TYPE_CLICK = 1;
    public static final int EVENT_TYPE_LONG_PRESS = 2;

    @OXOo.oOoXoXO
    private Runnable _onceRunnbale;
    private int flag;
    private boolean isBindView;

    @OXOo.OOXIXo
    private final SparseArray<WeakReference<View>> sparseArray;

    /* loaded from: classes7.dex */
    public static final class I0Io implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ DslViewHolder f5210Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Oox.oIX0oI<oXIO0o0XI> f5211XO;

        public I0Io(Oox.oIX0oI<oXIO0o0XI> oix0oi, DslViewHolder dslViewHolder) {
            this.f5211XO = oix0oi;
            this.f5210Oo = dslViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5211XO.invoke();
            this.f5210Oo.removeCallbacks(this);
        }
    }

    /* loaded from: classes7.dex */
    public static final class II0xO0 implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ DslViewHolder f5212Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Oox.oIX0oI<oXIO0o0XI> f5213XO;

        public II0xO0(Oox.oIX0oI<oXIO0o0XI> oix0oi, DslViewHolder dslViewHolder) {
            this.f5213XO = oix0oi;
            this.f5212Oo = dslViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5213XO.invoke();
            this.f5212Oo.removeCallbacks(this);
        }
    }

    /* loaded from: classes7.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public final void II0xO0(int i) {
            DslViewHolder.DEFAULT_INITIAL_CAPACITY = i;
        }

        public final int oIX0oI() {
            return DslViewHolder.DEFAULT_INITIAL_CAPACITY;
        }

        public oIX0oI() {
        }
    }

    /* loaded from: classes7.dex */
    public static final class oxoX implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ DslViewHolder f5214Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Oox.oIX0oI<oXIO0o0XI> f5215XO;

        public oxoX(Oox.oIX0oI<oXIO0o0XI> oix0oi, DslViewHolder dslViewHolder) {
            this.f5215XO = oix0oi;
            this.f5214Oo = dslViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5215XO.invoke();
            this.f5214Oo.removeCallbacks(this);
        }
    }

    public /* synthetic */ DslViewHolder(View view, int i, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(view, (i2 & 2) != 0 ? DEFAULT_INITIAL_CAPACITY : i);
    }

    public static /* synthetic */ CompoundButton check$default(DslViewHolder dslViewHolder, int i, boolean z, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: check");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        return dslViewHolder.check(i, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void check$lambda$10(Oox.x0xO0oo tmp0, CompoundButton compoundButton, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tmp0, "$tmp0");
        tmp0.invoke(compoundButton, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void check$lambda$20$lambda$19(Oox.x0xO0oo tmp0, CompoundButton compoundButton, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tmp0, "$tmp0");
        tmp0.invoke(compoundButton, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void click$lambda$0(Oox.oOoXoXO listener, View it) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "$listener");
        kotlin.jvm.internal.IIX0o.oO(it, "it");
        listener.invoke(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void click$lambda$1(Oox.oOoXoXO listener, View it) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "$listener");
        kotlin.jvm.internal.IIX0o.oO(it, "it");
        listener.invoke(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void click$lambda$6(Oox.oOoXoXO listener, View it) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "$listener");
        kotlin.jvm.internal.IIX0o.oO(it, "it");
        listener.invoke(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clickAndInit$lambda$16$lambda$15(Oox.oOoXoXO click, Oox.oOoXoXO init, View it) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(click, "$click");
        kotlin.jvm.internal.IIX0o.x0xO0oo(init, "$init");
        kotlin.jvm.internal.IIX0o.oO(it, "it");
        click.invoke(it);
        init.invoke(it);
    }

    public static /* synthetic */ void clickChild$default(DslViewHolder dslViewHolder, int i, boolean z, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            dslViewHolder.clickChild(i, z, oooxoxo);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clickChild");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clickItem$lambda$4(Oox.oOoXoXO listener, View it) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "$listener");
        kotlin.jvm.internal.IIX0o.oO(it, "it");
        listener.invoke(it);
    }

    public static /* synthetic */ DslViewHolder enable$default(DslViewHolder dslViewHolder, int i, Boolean bool, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enable");
        }
        if ((i2 & 2) != 0) {
            bool = Boolean.TRUE;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return dslViewHolder.enable(i, bool, z);
    }

    public static /* synthetic */ void focused$default(DslViewHolder dslViewHolder, View view, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                view = dslViewHolder.itemView;
            }
            dslViewHolder.focused(view);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: focused");
    }

    public static /* synthetic */ DslViewHolder goneIndex$default(DslViewHolder dslViewHolder, int i, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            return dslViewHolder.goneIndex(i, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: goneIndex");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean longClick$lambda$8(Oox.oOoXoXO listener, View v) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "$listener");
        kotlin.jvm.internal.IIX0o.oO(v, "v");
        listener.invoke(v);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean longClick$lambda$9(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean longClickItem$lambda$7(Oox.oOoXoXO listener, View v) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "$listener");
        kotlin.jvm.internal.IIX0o.oO(v, "v");
        listener.invoke(v);
        return true;
    }

    public static /* synthetic */ void longTouch$default(DslViewHolder dslViewHolder, int i, boolean z, Oox.IXxxXO iXxxXO, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: longTouch");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        dslViewHolder.longTouch(i, z, (Oox.IXxxXO<? super View, ? super MotionEvent, ? super Integer, Boolean>) iXxxXO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Integer] */
    public static final void longTouch$lambda$14$lambda$12(View view, Ref.ObjectRef eventType, Oox.IXxxXO block, boolean z, Ref.ObjectRef longRunnable) {
        Integer num;
        kotlin.jvm.internal.IIX0o.x0xO0oo(eventType, "$eventType");
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "$block");
        kotlin.jvm.internal.IIX0o.x0xO0oo(longRunnable, "$longRunnable");
        if (view.isPressed()) {
            T t = eventType.element;
            if (t == 0 || ((num = (Integer) t) != null && num.intValue() == 2)) {
                eventType.element = 2;
                MotionEvent Ioxxx2 = LibExKt.Ioxxx(2, 0.0f, 0.0f, 6, null);
                block.invoke(view, Ioxxx2, eventType.element);
                Ioxxx2.recycle();
                if (z) {
                    view.postDelayed((Runnable) longRunnable.element, ViewConfiguration.getLongPressTimeout());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v9, types: [T, java.lang.Integer] */
    public static final boolean longTouch$lambda$14$lambda$13(View view, Ref.ObjectRef longRunnable, Ref.ObjectRef eventType, Oox.IXxxXO block, View view2, MotionEvent event) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(longRunnable, "$longRunnable");
        kotlin.jvm.internal.IIX0o.x0xO0oo(eventType, "$eventType");
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "$block");
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                view.setPressed(false);
                if (eventType.element == 0) {
                    eventType.element = 1;
                }
                view.removeCallbacks((Runnable) longRunnable.element);
            }
        } else {
            view.setPressed(true);
            view.postDelayed((Runnable) longRunnable.element, ViewConfiguration.getLongPressTimeout());
        }
        Integer num = (Integer) eventType.element;
        if (num != null && num.intValue() == 1) {
            kotlin.jvm.internal.IIX0o.oO(event, "event");
            block.invoke(view, event, 1);
        } else {
            kotlin.jvm.internal.IIX0o.oO(event, "event");
            block.invoke(view, event, null);
        }
        int actionMasked2 = event.getActionMasked();
        if (actionMasked2 == 1 || actionMasked2 == 3) {
            eventType.element = null;
        }
        return true;
    }

    public static /* synthetic */ void postDelay$default(DslViewHolder dslViewHolder, long j, Oox.oIX0oI oix0oi, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = 0;
            }
            dslViewHolder.postDelay(j, (Oox.oIX0oI<oXIO0o0XI>) oix0oi);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postDelay");
    }

    public static /* synthetic */ void postOnce$default(DslViewHolder dslViewHolder, long j, Oox.oIX0oI oix0oi, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = 0;
            }
            dslViewHolder.postOnce(j, oix0oi);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postOnce");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postOnce$lambda$17(Oox.oIX0oI runnable, DslViewHolder this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(runnable, "$runnable");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        runnable.invoke();
        this$0.removeCallbacks(this$0._onceRunnbale);
    }

    public static /* synthetic */ void replace$default(DslViewHolder dslViewHolder, int i, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replace");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        dslViewHolder.replace(i, z);
    }

    public static /* synthetic */ DslViewHolder selected$default(DslViewHolder dslViewHolder, int i, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selected");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        return dslViewHolder.selected(i, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void selectorClick$default(DslViewHolder dslViewHolder, int i, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                oooxoxo = new Oox.oOoXoXO<Boolean, Boolean>() { // from class: com.angcyo.dsladapter.DslViewHolder$selectorClick$1
                    @OXOo.OOXIXo
                    public final Boolean invoke(boolean z) {
                        return Boolean.FALSE;
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                        return invoke(bool.booleanValue());
                    }
                };
            }
            dslViewHolder.selectorClick(i, oooxoxo);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectorClick");
    }

    public static /* synthetic */ void throttleClick$default(DslViewHolder dslViewHolder, int i, long j, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: throttleClick");
        }
        if ((i2 & 2) != 0) {
            j = ThrottleClickListener.f5397oI0IIXIo.oIX0oI();
        }
        dslViewHolder.throttleClick(i, j, (Oox.oOoXoXO<? super View, oXIO0o0XI>) oooxoxo);
    }

    public static /* synthetic */ void throttleClickItem$default(DslViewHolder dslViewHolder, long j, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = ThrottleClickListener.f5397oI0IIXIo.oIX0oI();
            }
            dslViewHolder.throttleClickItem(j, (Oox.oOoXoXO<? super View, oXIO0o0XI>) oooxoxo);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: throttleClickItem");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean touch$lambda$11(Oox.x0xO0oo tmp0, View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(view, motionEvent)).booleanValue();
    }

    @OXOo.oOoXoXO
    public final CompoundButton cb(@IdRes int i) {
        return (CompoundButton) v(i);
    }

    @OXOo.oOoXoXO
    public final CompoundButton check(@IdRes int i, boolean z, @OXOo.OOXIXo final Oox.x0xO0oo<? super CompoundButton, ? super Boolean, oXIO0o0XI> listener) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "listener");
        CompoundButton compoundButton = (CompoundButton) v(i);
        if (compoundButton != null) {
            compoundButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.angcyo.dsladapter.oO
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton2, boolean z2) {
                    DslViewHolder.check$lambda$10(Oox.x0xO0oo.this, compoundButton2, z2);
                }
            });
            compoundButton.setChecked(z);
        }
        return compoundButton;
    }

    public final void clear() {
        this.sparseArray.clear();
    }

    public final void click(@IdRes int i, @OXOo.oOoXoXO View.OnClickListener onClickListener) {
        View v = v(i);
        if (v != null) {
            v.setOnClickListener(onClickListener);
        }
    }

    public final void clickAndInit(@IdRes int i, @OXOo.OOXIXo final Oox.oOoXoXO<? super View, oXIO0o0XI> init, @OXOo.OOXIXo final Oox.oOoXoXO<? super View, oXIO0o0XI> click) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(init, "init");
        kotlin.jvm.internal.IIX0o.x0xO0oo(click, "click");
        View v = v(i);
        if (v != null) {
            init.invoke(v);
            v.setOnClickListener(new View.OnClickListener() { // from class: com.angcyo.dsladapter.IIXOooo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DslViewHolder.clickAndInit$lambda$16$lambda$15(Oox.oOoXoXO.this, init, view);
                }
            });
        }
    }

    public final void clickCallView(@OXOo.oOoXoXO View view) {
        if (view != null) {
            view.callOnClick();
        }
    }

    public final void clickChild(@IdRes int i, boolean z, @OXOo.OOXIXo final Oox.oOoXoXO<? super View, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        View view = view(i);
        if (view instanceof ViewGroup) {
            LibExKt.xoXoI((ViewGroup) view, z, new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslViewHolder$clickChild$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view2) {
                    invoke2(view2);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo View it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    DslViewHolder.this.click(it, action);
                }
            });
        } else {
            click(view, action);
        }
    }

    public final void clickItem(@OXOo.oOoXoXO View.OnClickListener onClickListener) {
        click(this.itemView, onClickListener);
    }

    public final void clickView(@OXOo.oOoXoXO View view) {
        if (view != null) {
            view.performClick();
        }
    }

    @OXOo.OOXIXo
    public final DslViewHolder enable(@IdRes int i, @OXOo.oOoXoXO Boolean bool, boolean z) {
        enable(v(i), bool, z);
        return this;
    }

    @OXOo.oOoXoXO
    public final EditText et(@IdRes int i) {
        return (EditText) v(i);
    }

    @OXOo.oOoXoXO
    public final EditText ev(@IdRes int i) {
        return (EditText) v(i);
    }

    @OXOo.oOoXoXO
    public final <T extends View> T focus(@IdRes int i) {
        T t = (T) v(i);
        if (t != null) {
            focused(t);
            return t;
        }
        return null;
    }

    public final void focusView(@IdRes int i) {
        focus(i);
    }

    public final void focused(@IdRes int i) {
        focusView(i);
    }

    public final Context getContext() {
        return this.itemView.getContext();
    }

    public final int getFlag() {
        return this.flag;
    }

    @OXOo.OOXIXo
    public final SparseArray<WeakReference<View>> getSparseArray() {
        return this.sparseArray;
    }

    @OXOo.oOoXoXO
    public final Runnable get_onceRunnbale() {
        return this._onceRunnbale;
    }

    @OXOo.OOXIXo
    public final DslViewHolder gone(@IdRes int i) {
        return gone(v(i));
    }

    @OXOo.OOXIXo
    public final DslViewHolder goneIndex(int i, boolean z) {
        View childAt;
        View itemView = this.itemView;
        kotlin.jvm.internal.IIX0o.oO(itemView, "itemView");
        if ((itemView instanceof ViewGroup) && (childAt = ((ViewGroup) itemView).getChildAt(i)) != null) {
            gone(childAt, z);
        }
        return this;
    }

    @OXOo.oOoXoXO
    public final ViewGroup group(@IdRes int i) {
        return (ViewGroup) v(i);
    }

    @OXOo.oOoXoXO
    public final ImageView img(@IdRes int i) {
        return (ImageView) v(i);
    }

    @OXOo.OOXIXo
    public final DslViewHolder invisible(@IdRes int i, boolean z) {
        View v = v(i);
        if (v == null) {
            return this;
        }
        if (z) {
            invisible(v);
        } else {
            visible(v);
        }
        return this;
    }

    public final boolean isBindView() {
        return this.isBindView;
    }

    public final boolean isChecked(@IdRes int i) {
        CompoundButton cb = cb(i);
        if (cb == null || !cb.isChecked()) {
            return false;
        }
        return true;
    }

    public final boolean isEnabled(@IdRes int i) {
        View view = view(i);
        if (view == null || !view.isEnabled()) {
            return false;
        }
        return true;
    }

    public final boolean isInRecyclerView() {
        return this.itemView.getParent() instanceof RecyclerView;
    }

    public final boolean isSelected(@IdRes int i) {
        View view = view(i);
        if (view == null || !view.isSelected()) {
            return false;
        }
        return true;
    }

    public final boolean isVisible(@IdRes int i) {
        View v = v(i);
        if (v == null || v.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public final void longClick(@IdRes int i, @OXOo.OOXIXo final Oox.oOoXoXO<? super View, oXIO0o0XI> listener) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "listener");
        View view = view(i);
        if (view != null) {
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.angcyo.dsladapter.O0xOxO
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    boolean longClick$lambda$8;
                    longClick$lambda$8 = DslViewHolder.longClick$lambda$8(Oox.oOoXoXO.this, view2);
                    return longClick$lambda$8;
                }
            });
        }
    }

    public final void longClickItem(@OXOo.OOXIXo final Oox.oOoXoXO<? super View, oXIO0o0XI> listener) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "listener");
        this.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.angcyo.dsladapter.Oxx0xo
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean longClickItem$lambda$7;
                longClickItem$lambda$7 = DslViewHolder.longClickItem$lambda$7(Oox.oOoXoXO.this, view);
                return longClickItem$lambda$7;
            }
        });
    }

    public final void longTouch(@IdRes int i, boolean z, @OXOo.OOXIXo Oox.IXxxXO<? super View, ? super MotionEvent, ? super Integer, Boolean> block) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "block");
        longTouch(v(i), z, block);
    }

    public final void post(@OXOo.OOXIXo Runnable runnable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(runnable, "runnable");
        this.itemView.post(runnable);
    }

    public final void postDelay(@OXOo.OOXIXo Runnable runnable, long j) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(runnable, "runnable");
        this.itemView.postDelayed(runnable, j);
    }

    public final void postOnAnimation(@OXOo.OOXIXo Oox.oIX0oI<oXIO0o0XI> runnable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(runnable, "runnable");
        this.itemView.postOnAnimation(new I0Io(runnable, this));
    }

    public final void postOnce(long j, @OXOo.OOXIXo final Oox.oIX0oI<oXIO0o0XI> runnable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(runnable, "runnable");
        removeCallbacks(this._onceRunnbale);
        Runnable runnable2 = new Runnable() { // from class: com.angcyo.dsladapter.XIxXXX0x0
            @Override // java.lang.Runnable
            public final void run() {
                DslViewHolder.postOnce$lambda$17(Oox.oIX0oI.this, this);
            }
        };
        this._onceRunnbale = runnable2;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(runnable2);
        postDelay(runnable2, j);
    }

    public final void removeCallbacks(@OXOo.oOoXoXO Runnable runnable) {
        this.itemView.removeCallbacks(runnable);
    }

    public final void replace(@LayoutRes int i, boolean z) {
        replace(this.itemView, i, z);
    }

    @OXOo.oOoXoXO
    public final RecyclerView rv(@IdRes int i) {
        return (RecyclerView) v(i);
    }

    @OXOo.OOXIXo
    public final DslViewHolder selected(@IdRes int i, boolean z) {
        selected(v(i), z);
        return this;
    }

    public final void selectorClick(@IdRes int i, @OXOo.OOXIXo final Oox.oOoXoXO<? super Boolean, Boolean> listener) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "listener");
        click(i, new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslViewHolder$selectorClick$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                invoke2(view);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo View it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                boolean z = !it.isSelected();
                if (listener.invoke(Boolean.valueOf(z)).booleanValue()) {
                    return;
                }
                it.setSelected(z);
            }
        });
    }

    public final void setBindView(boolean z) {
        this.isBindView = z;
    }

    public final void setFlag(int i) {
        this.flag = i;
    }

    public final void set_onceRunnbale(@OXOo.oOoXoXO Runnable runnable) {
        this._onceRunnbale = runnable;
    }

    @OXOo.oOoXoXO
    public final Object tag(@IdRes int i, int i2, @OXOo.oOoXoXO Object obj) {
        Object obj2;
        View view = view(i);
        if (view != null) {
            obj2 = view.getTag(i2);
        } else {
            obj2 = null;
        }
        if (view != null) {
            view.setTag(i2, obj);
        }
        return obj2;
    }

    public final void throttleClick(@IdRes int i, long j, @OXOo.OOXIXo Oox.oOoXoXO<? super View, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        click(i, new ThrottleClickListener(j, null, action, 2, null));
    }

    public final void throttleClickItem(@OXOo.OOXIXo Oox.oOoXoXO<? super View, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        click(this.itemView, new ThrottleClickListener(0L, null, action, 3, null));
    }

    public final void touch(@IdRes int i, @OXOo.OOXIXo Oox.x0xO0oo<? super View, ? super MotionEvent, Boolean> block) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "block");
        touch(v(i), block);
    }

    @OXOo.oOoXoXO
    public final TextView tv(@IdRes int i) {
        return (TextView) v(i);
    }

    @OXOo.oOoXoXO
    public final <T extends View> T v(@IdRes int i) {
        View view;
        WeakReference<View> weakReference = this.sparseArray.get(i);
        if (weakReference == null) {
            view = this.itemView.findViewById(i);
            this.sparseArray.put(i, new WeakReference<>(view));
        } else {
            view = weakReference.get();
            if (view == null) {
                view = this.itemView.findViewById(i);
                this.sparseArray.put(i, new WeakReference<>(view));
            }
        }
        try {
            if (!(view instanceof View)) {
                view = null;
            }
            return (T) view;
        } catch (Exception e) {
            L.f5267oIX0oI.oo0xXOI0I(e);
            return null;
        }
    }

    @OXOo.oOoXoXO
    public final View view(@IdRes int i) {
        return v(i);
    }

    @OXOo.oOoXoXO
    public final View visible(@IdRes int i) {
        return visible(v(i));
    }

    public static /* synthetic */ CompoundButton check$default(DslViewHolder dslViewHolder, int i, boolean z, boolean z2, Oox.x0xO0oo x0xo0oo, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: check");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        return dslViewHolder.check(i, z, z2, x0xo0oo);
    }

    public static /* synthetic */ void longTouch$default(DslViewHolder dslViewHolder, View view, boolean z, Oox.IXxxXO iXxxXO, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: longTouch");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        dslViewHolder.longTouch(view, z, (Oox.IXxxXO<? super View, ? super MotionEvent, ? super Integer, Boolean>) iXxxXO);
    }

    public static /* synthetic */ void replace$default(DslViewHolder dslViewHolder, int i, int i2, boolean z, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replace");
        }
        if ((i3 & 4) != 0) {
            z = true;
        }
        dslViewHolder.replace(i, i2, z);
    }

    public static /* synthetic */ void selected$default(DslViewHolder dslViewHolder, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selected");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        dslViewHolder.selected(z);
    }

    public final void clickCallView(@IdRes int i) {
        View view = view(i);
        if (view != null) {
            view.callOnClick();
        }
    }

    public final void clickItem(@OXOo.OOXIXo final Oox.oOoXoXO<? super View, oXIO0o0XI> listener) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "listener");
        click(this.itemView, new View.OnClickListener() { // from class: com.angcyo.dsladapter.oI0IIXIo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DslViewHolder.clickItem$lambda$4(Oox.oOoXoXO.this, view);
            }
        });
    }

    public final void clickView(@IdRes int i) {
        View view = view(i);
        if (view != null) {
            view.performClick();
        }
    }

    public final void focused(@OXOo.oOoXoXO View view) {
        if (view != null) {
            view.setFocusable(true);
        }
        if (view != null) {
            view.setFocusableInTouchMode(true);
        }
        if (view != null) {
            view.requestFocus();
        }
    }

    @OXOo.OOXIXo
    public final DslViewHolder gone(@OXOo.OOXIXo View view, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (z) {
            gone(view);
        } else {
            visible(view);
        }
        return this;
    }

    @OXOo.oOoXoXO
    public final ViewGroup group(@OXOo.oOoXoXO View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    public final void longClick(@IdRes int i, @OXOo.oOoXoXO View.OnLongClickListener onLongClickListener) {
        View view = view(i);
        if (view != null) {
            view.setOnLongClickListener(onLongClickListener);
        }
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [T, com.angcyo.dsladapter.X0IIOO] */
    @SuppressLint({"ClickableViewAccessibility"})
    public final void longTouch(@OXOo.oOoXoXO final View view, final boolean z, @OXOo.OOXIXo final Oox.IXxxXO<? super View, ? super MotionEvent, ? super Integer, Boolean> block) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "block");
        if (view != null) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = new Runnable() { // from class: com.angcyo.dsladapter.X0IIOO
                @Override // java.lang.Runnable
                public final void run() {
                    DslViewHolder.longTouch$lambda$14$lambda$12(view, objectRef, block, z, objectRef2);
                }
            };
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.angcyo.dsladapter.XI0IXoo
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean longTouch$lambda$14$lambda$13;
                    longTouch$lambda$14$lambda$13 = DslViewHolder.longTouch$lambda$14$lambda$13(view, objectRef2, objectRef, block, view2, motionEvent);
                    return longTouch$lambda$14$lambda$13;
                }
            });
        }
    }

    public final void post(@OXOo.OOXIXo Oox.oIX0oI<oXIO0o0XI> runnable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(runnable, "runnable");
        postDelay(0L, runnable);
    }

    public final void postDelay(long j, @OXOo.OOXIXo Runnable runnable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(runnable, "runnable");
        postDelay(runnable, j);
    }

    public final void replace(@IdRes int i, @LayoutRes int i2, boolean z) {
        replace(view(i), i2, z);
    }

    public final void throttleClick(@OXOo.OOXIXo @IdRes int[] ids, long j, @OXOo.OOXIXo Oox.oOoXoXO<? super View, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(ids, "ids");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        ThrottleClickListener throttleClickListener = new ThrottleClickListener(j, null, action, 2, null);
        for (int i : ids) {
            click(i, throttleClickListener);
        }
    }

    public final void throttleClickItem(long j, @OXOo.OOXIXo Oox.oOoXoXO<? super View, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        click(this.itemView, new ThrottleClickListener(j, null, action, 2, null));
    }

    public final void touch(@OXOo.oOoXoXO View view, @OXOo.OOXIXo final Oox.x0xO0oo<? super View, ? super MotionEvent, Boolean> block) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "block");
        if (view != null) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.angcyo.dsladapter.x0xO0oo
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean z;
                    z = DslViewHolder.touch$lambda$11(Oox.x0xO0oo.this, view2, motionEvent);
                    return z;
                }
            });
        }
    }

    @OXOo.OOXIXo
    public final DslViewHolder visible(@IdRes int i, boolean z) {
        View v = v(i);
        if (v == null) {
            return this;
        }
        if (z) {
            visible(v);
        } else {
            gone(v);
        }
        return this;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DslViewHolder(@OXOo.OOXIXo View itemView, int i) {
        super(itemView);
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemView, "itemView");
        this.sparseArray = new SparseArray<>(i);
    }

    public static /* synthetic */ void enable$default(DslViewHolder dslViewHolder, View view, Boolean bool, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enable");
        }
        if ((i & 4) != 0) {
            z = true;
        }
        dslViewHolder.enable(view, bool, z);
    }

    public static /* synthetic */ void replace$default(DslViewHolder dslViewHolder, View view, int i, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replace");
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        dslViewHolder.replace(view, i, z);
    }

    public static /* synthetic */ void selected$default(DslViewHolder dslViewHolder, View view, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selected");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        dslViewHolder.selected(view, z);
    }

    public static /* synthetic */ void throttleClick$default(DslViewHolder dslViewHolder, int[] iArr, long j, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: throttleClick");
        }
        if ((i & 2) != 0) {
            j = ThrottleClickListener.f5397oI0IIXIo.oIX0oI();
        }
        dslViewHolder.throttleClick(iArr, j, (Oox.oOoXoXO<? super View, oXIO0o0XI>) oooxoxo);
    }

    public final void click(@IdRes int i, @OXOo.OOXIXo final Oox.oOoXoXO<? super View, oXIO0o0XI> listener) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "listener");
        click(i, new View.OnClickListener() { // from class: com.angcyo.dsladapter.OxI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DslViewHolder.click$lambda$0(Oox.oOoXoXO.this, view);
            }
        });
    }

    public final void enable(@OXOo.oOoXoXO View view, @OXOo.oOoXoXO Boolean bool, boolean z) {
        boolean booleanValue;
        if (view == null) {
            return;
        }
        if (bool == null) {
            Object tag = view.getTag(R.id.lib_tag_enable);
            if (!(tag instanceof Boolean)) {
                return;
            } else {
                booleanValue = ((Boolean) tag).booleanValue();
            }
        } else {
            booleanValue = bool.booleanValue();
        }
        if ((view instanceof ViewGroup) && z) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                enable(viewGroup.getChildAt(i), Boolean.valueOf(booleanValue), true);
            }
        }
        if (view.isEnabled() != booleanValue) {
            view.setTag(R.id.lib_tag_enable, Boolean.valueOf(view.isEnabled()));
            view.setEnabled(booleanValue);
        }
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            if (editText.isEnabled()) {
                editText.clearFocus();
            } else {
                editText.clearFocus();
            }
        }
    }

    public final void longClick(@OXOo.oOoXoXO View view, @OXOo.oOoXoXO final View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.angcyo.dsladapter.IXxxXO
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    boolean longClick$lambda$9;
                    longClick$lambda$9 = DslViewHolder.longClick$lambda$9(onClickListener, view2);
                    return longClick$lambda$9;
                }
            });
        }
    }

    public final void postDelay(long j, @OXOo.OOXIXo Oox.oIX0oI<oXIO0o0XI> runnable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(runnable, "runnable");
        postDelay(new II0xO0(runnable, this), j);
    }

    public final void replace(@OXOo.oOoXoXO View view, @LayoutRes int i, boolean z) {
        if (view instanceof ViewGroup) {
            clear();
            LibExKt.OOXIxO0((ViewGroup) view, i, z);
        }
    }

    public final void selected(boolean z) {
        selected(this.itemView, z);
    }

    public final void throttleClickItem(@OXOo.OOXIXo int[] ids, @OXOo.OOXIXo Oox.oOoXoXO<? super View, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(ids, "ids");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        ThrottleClickListener throttleClickListener = new ThrottleClickListener(0L, null, action, 3, null);
        click(this.itemView, throttleClickListener);
        for (int i : ids) {
            click(i, throttleClickListener);
        }
    }

    @OXOo.oOoXoXO
    public final CompoundButton check(@IdRes int i, boolean z, boolean z2) {
        CompoundButton compoundButton = (CompoundButton) v(i);
        if (compoundButton == null) {
            return null;
        }
        if (z2) {
            compoundButton.setChecked(z);
            return compoundButton;
        }
        try {
            Object X00IoxXI2 = LibExKt.X00IoxXI(compoundButton, CompoundButton.class, "mOnCheckedChangeListener");
            compoundButton.setOnCheckedChangeListener(null);
            compoundButton.setChecked(z);
            compoundButton.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) X00IoxXI2);
            return compoundButton;
        } catch (Exception e) {
            e.printStackTrace();
            return compoundButton;
        }
    }

    public final void click(@OXOo.OOXIXo @IdRes int[] ids, @OXOo.OOXIXo final Oox.oOoXoXO<? super View, oXIO0o0XI> listener) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(ids, "ids");
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "listener");
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.angcyo.dsladapter.xoXoI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DslViewHolder.click$lambda$1(Oox.oOoXoXO.this, view);
            }
        };
        for (int i : ids) {
            click(i, onClickListener);
        }
    }

    @OXOo.OOXIXo
    public final DslViewHolder gone(@IdRes int i, boolean z) {
        if (z) {
            gone(v(i));
        } else {
            visible(i);
        }
        return this;
    }

    @OXOo.oOoXoXO
    public final View invisible(@IdRes int i) {
        return invisible(v(i));
    }

    public final void longClick(@OXOo.oOoXoXO View view, @OXOo.oOoXoXO View.OnLongClickListener onLongClickListener) {
        if (view != null) {
            view.setOnLongClickListener(onLongClickListener);
        }
    }

    public final void selected(@OXOo.oOoXoXO View view, boolean z) {
        if (view == null) {
            return;
        }
        if (view.isSelected() != z) {
            view.setSelected(z);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                selected(viewGroup.getChildAt(i), z);
            }
        }
    }

    @OXOo.oOoXoXO
    public final View invisible(@OXOo.oOoXoXO View view) {
        if (view != null && view.getVisibility() != 4) {
            view.clearAnimation();
            view.setVisibility(4);
        }
        return view;
    }

    @OXOo.oOoXoXO
    public final View visible(@OXOo.oOoXoXO View view) {
        if (view != null && view.getVisibility() != 0) {
            view.setVisibility(0);
        }
        return view;
    }

    public final void gone(@OXOo.OOXIXo @IdRes int... resId) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(resId, "resId");
        for (int i : resId) {
            gone(i);
        }
    }

    public final void click(@OXOo.oOoXoXO View view, @OXOo.oOoXoXO View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public final void click(@OXOo.oOoXoXO View view, @OXOo.OOXIXo final Oox.oOoXoXO<? super View, oXIO0o0XI> listener) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "listener");
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.angcyo.dsladapter.OxxIIOOXO
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DslViewHolder.click$lambda$6(Oox.oOoXoXO.this, view2);
                }
            });
        }
    }

    @OXOo.OOXIXo
    public final DslViewHolder gone(@OXOo.oOoXoXO View view) {
        if (view != null && view.getVisibility() != 8) {
            view.clearAnimation();
            view.setVisibility(8);
        }
        return this;
    }

    @OXOo.oOoXoXO
    public final CompoundButton check(@IdRes int i, boolean z, boolean z2, @OXOo.OOXIXo final Oox.x0xO0oo<? super CompoundButton, ? super Boolean, oXIO0o0XI> onCheckedChanged) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(onCheckedChanged, "onCheckedChanged");
        CompoundButton compoundButton = (CompoundButton) v(i);
        if (compoundButton == null) {
            return null;
        }
        compoundButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.angcyo.dsladapter.o00
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton2, boolean z3) {
                DslViewHolder.check$lambda$20$lambda$19(Oox.x0xO0oo.this, compoundButton2, z3);
            }
        });
        if (z2) {
            compoundButton.setChecked(z);
            return compoundButton;
        }
        try {
            Object X00IoxXI2 = LibExKt.X00IoxXI(compoundButton, CompoundButton.class, "mOnCheckedChangeListener");
            compoundButton.setOnCheckedChangeListener(null);
            compoundButton.setChecked(z);
            compoundButton.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) X00IoxXI2);
            return compoundButton;
        } catch (Exception e) {
            e.printStackTrace();
            return compoundButton;
        }
    }
}
