package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    private static final oOoXoXO<Throwable> DEFAULT_FAILURE_LISTENER = new oIX0oI();
    private static final String TAG = "LottieAnimationView";
    private String animationName;

    @RawRes
    private int animationResId;
    private boolean autoPlay;
    private int buildDrawingCacheDepth;
    private boolean cacheComposition;

    @Nullable
    private com.airbnb.lottie.Oxx0IOOO composition;

    @Nullable
    private IXxxXO<com.airbnb.lottie.Oxx0IOOO> compositionTask;

    @Nullable
    private oOoXoXO<Throwable> failureListener;

    @DrawableRes
    private int fallbackResource;
    private boolean isInitialized;
    private final oOoXoXO<com.airbnb.lottie.Oxx0IOOO> loadedListener;
    private final xoIox lottieDrawable;
    private final Set<x0XOIxOo> lottieOnCompositionLoadedListeners;
    private boolean playAnimationWhenShown;
    private RenderMode renderMode;
    private boolean wasAnimatingWhenDetached;
    private boolean wasAnimatingWhenNotShown;
    private final oOoXoXO<Throwable> wrappedFailureListener;

    /* loaded from: classes.dex */
    public class I0Io implements oOoXoXO<Throwable> {
        public I0Io() {
        }

        @Override // com.airbnb.lottie.oOoXoXO
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            if (LottieAnimationView.this.fallbackResource != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.fallbackResource);
            }
            (LottieAnimationView.this.failureListener == null ? LottieAnimationView.DEFAULT_FAILURE_LISTENER : LottieAnimationView.this.failureListener).onResult(th);
        }
    }

    /* loaded from: classes.dex */
    public class II0xO0 implements oOoXoXO<com.airbnb.lottie.Oxx0IOOO> {
        public II0xO0() {
        }

        @Override // com.airbnb.lottie.oOoXoXO
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public void onResult(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
            LottieAnimationView.this.setComposition(oxx0IOOO);
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class Oxx0IOOO {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f4780oIX0oI;

        static {
            int[] iArr = new int[RenderMode.values().length];
            f4780oIX0oI = iArr;
            try {
                iArr[RenderMode.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4780oIX0oI[RenderMode.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4780oIX0oI[RenderMode.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new oIX0oI();

        /* renamed from: IIXOooo, reason: collision with root package name */
        public int f4781IIXOooo;

        /* renamed from: IXxxXO, reason: collision with root package name */
        public float f4782IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public int f4783Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public boolean f4784Oxx0xo;

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        public int f4785OxxIIOOXO;

        /* renamed from: XO, reason: collision with root package name */
        public String f4786XO;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public String f4787oI0IIXIo;

        /* loaded from: classes.dex */
        public class oIX0oI implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, oIX0oI oix0oi) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f4786XO);
            parcel.writeFloat(this.f4782IXxxXO);
            parcel.writeInt(this.f4784Oxx0xo ? 1 : 0);
            parcel.writeString(this.f4787oI0IIXIo);
            parcel.writeInt(this.f4785OxxIIOOXO);
            parcel.writeInt(this.f4781IIXOooo);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f4786XO = parcel.readString();
            this.f4782IXxxXO = parcel.readFloat();
            this.f4784Oxx0xo = parcel.readInt() == 1;
            this.f4787oI0IIXIo = parcel.readString();
            this.f4785OxxIIOOXO = parcel.readInt();
            this.f4781IIXOooo = parcel.readInt();
        }
    }

    /* loaded from: classes.dex */
    public class X0o0xo implements Callable<x0xO0oo<com.airbnb.lottie.Oxx0IOOO>> {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ String f4789XO;

        public X0o0xo(String str) {
            this.f4789XO = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public x0xO0oo<com.airbnb.lottie.Oxx0IOOO> call() {
            if (LottieAnimationView.this.cacheComposition) {
                return II0XooXoX.Oxx0IOOO(LottieAnimationView.this.getContext(), this.f4789XO);
            }
            return II0XooXoX.II0XooXoX(LottieAnimationView.this.getContext(), this.f4789XO, null);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class XO<T> extends xoXoI.xoIox<T> {

        /* renamed from: oxoX, reason: collision with root package name */
        public final /* synthetic */ xoXoI.oOoXoXO f4791oxoX;

        public XO(xoXoI.oOoXoXO oooxoxo) {
            this.f4791oxoX = oooxoxo;
        }

        @Override // xoXoI.xoIox
        public T oIX0oI(xoXoI.II0xO0<T> iI0xO0) {
            return (T) this.f4791oxoX.oIX0oI(iI0xO0);
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements oOoXoXO<Throwable> {
        @Override // com.airbnb.lottie.oOoXoXO
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            if (IIXOooo.xoIox.OOXIXo(th)) {
                IIXOooo.XO.XO("Unable to load composition.", th);
                return;
            }
            throw new IllegalStateException("Unable to parse composition", th);
        }
    }

    /* loaded from: classes.dex */
    public class oxoX implements Callable<x0xO0oo<com.airbnb.lottie.Oxx0IOOO>> {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ int f4793XO;

        public oxoX(int i) {
            this.f4793XO = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public x0xO0oo<com.airbnb.lottie.Oxx0IOOO> call() {
            if (LottieAnimationView.this.cacheComposition) {
                return II0XooXoX.OxxIIOOXO(LottieAnimationView.this.getContext(), this.f4793XO);
            }
            return II0XooXoX.IIXOooo(LottieAnimationView.this.getContext(), this.f4793XO, null);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.loadedListener = new II0xO0();
        this.wrappedFailureListener = new I0Io();
        this.fallbackResource = 0;
        this.lottieDrawable = new xoIox();
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.renderMode = RenderMode.AUTOMATIC;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.buildDrawingCacheDepth = 0;
        init(null, R.attr.lottieAnimationViewStyle);
    }

    private void cancelLoaderTask() {
        IXxxXO<com.airbnb.lottie.Oxx0IOOO> iXxxXO = this.compositionTask;
        if (iXxxXO != null) {
            iXxxXO.OOXIXo(this.loadedListener);
            this.compositionTask.xoIox(this.wrappedFailureListener);
        }
    }

    private void clearComposition() {
        this.composition = null;
        this.lottieDrawable.oOoXoXO();
    }

    private void enableOrDisableHardwareLayer() {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO;
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO2;
        int i;
        int i2 = Oxx0IOOO.f4780oIX0oI[this.renderMode.ordinal()];
        int i3 = 2;
        if (i2 != 1 && (i2 == 2 || i2 != 3 || (((oxx0IOOO = this.composition) != null && oxx0IOOO.IXxxXO() && Build.VERSION.SDK_INT < 28) || (((oxx0IOOO2 = this.composition) != null && oxx0IOOO2.ooOOo0oXI() > 4) || (i = Build.VERSION.SDK_INT) == 24 || i == 25)))) {
            i3 = 1;
        }
        if (i3 != getLayerType()) {
            setLayerType(i3, null);
        }
    }

    private IXxxXO<com.airbnb.lottie.Oxx0IOOO> fromAssets(String str) {
        if (isInEditMode()) {
            return new IXxxXO<>(new X0o0xo(str), true);
        }
        if (this.cacheComposition) {
            return II0XooXoX.X0o0xo(getContext(), str);
        }
        return II0XooXoX.XO(getContext(), str, null);
    }

    private IXxxXO<com.airbnb.lottie.Oxx0IOOO> fromRawRes(@RawRes int i) {
        if (isInEditMode()) {
            return new IXxxXO<>(new oxoX(i), true);
        }
        if (this.cacheComposition) {
            return II0XooXoX.Oxx0xo(getContext(), i);
        }
        return II0XooXoX.oI0IIXIo(getContext(), i, null);
    }

    private void init(@Nullable AttributeSet attributeSet, @AttrRes int i) {
        String string;
        boolean z = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView, i, 0);
        this.cacheComposition = obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
        int i2 = R.styleable.LottieAnimationView_lottie_rawRes;
        boolean hasValue = obtainStyledAttributes.hasValue(i2);
        int i3 = R.styleable.LottieAnimationView_lottie_fileName;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i3);
        int i4 = R.styleable.LottieAnimationView_lottie_url;
        boolean hasValue3 = obtainStyledAttributes.hasValue(i4);
        if (hasValue && hasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (hasValue) {
            int resourceId = obtainStyledAttributes.getResourceId(i2, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (hasValue2) {
            String string2 = obtainStyledAttributes.getString(i3);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (hasValue3 && (string = obtainStyledAttributes.getString(i4)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(obtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.wasAnimatingWhenDetached = true;
            this.autoPlay = true;
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.lottieDrawable.O00XxXI(-1);
        }
        int i5 = R.styleable.LottieAnimationView_lottie_repeatMode;
        if (obtainStyledAttributes.hasValue(i5)) {
            setRepeatMode(obtainStyledAttributes.getInt(i5, 1));
        }
        int i6 = R.styleable.LottieAnimationView_lottie_repeatCount;
        if (obtainStyledAttributes.hasValue(i6)) {
            setRepeatCount(obtainStyledAttributes.getInt(i6, -1));
        }
        int i7 = R.styleable.LottieAnimationView_lottie_speed;
        if (obtainStyledAttributes.hasValue(i7)) {
            setSpeed(obtainStyledAttributes.getFloat(i7, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        int i8 = R.styleable.LottieAnimationView_lottie_colorFilter;
        if (obtainStyledAttributes.hasValue(i8)) {
            addValueCallback(new x0xO0oo.oxoX("**"), (x0xO0oo.oxoX) oO.f4976XxX0x0xxx, (xoXoI.xoIox<x0xO0oo.oxoX>) new xoXoI.xoIox(new OxxIIOOXO(AppCompatResources.getColorStateList(getContext(), obtainStyledAttributes.getResourceId(i8, -1)).getDefaultColor())));
        }
        int i9 = R.styleable.LottieAnimationView_lottie_scale;
        if (obtainStyledAttributes.hasValue(i9)) {
            this.lottieDrawable.OOXIxO0(obtainStyledAttributes.getFloat(i9, 1.0f));
        }
        int i10 = R.styleable.LottieAnimationView_lottie_renderMode;
        if (obtainStyledAttributes.hasValue(i10)) {
            RenderMode renderMode = RenderMode.AUTOMATIC;
            int i11 = obtainStyledAttributes.getInt(i10, renderMode.ordinal());
            if (i11 >= RenderMode.values().length) {
                i11 = renderMode.ordinal();
            }
            setRenderMode(RenderMode.values()[i11]);
        }
        obtainStyledAttributes.recycle();
        xoIox xoiox = this.lottieDrawable;
        if (IIXOooo.xoIox.XO(getContext()) != 0.0f) {
            z = true;
        }
        xoiox.I0(Boolean.valueOf(z));
        enableOrDisableHardwareLayer();
        this.isInitialized = true;
    }

    private void setCompositionTask(IXxxXO<com.airbnb.lottie.Oxx0IOOO> iXxxXO) {
        clearComposition();
        cancelLoaderTask();
        this.compositionTask = iXxxXO.XO(this.loadedListener).X0o0xo(this.wrappedFailureListener);
    }

    private void setLottieDrawable() {
        boolean isAnimating = isAnimating();
        setImageDrawable(null);
        setImageDrawable(this.lottieDrawable);
        if (isAnimating) {
            this.lottieDrawable.oxXx0IX();
        }
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.I0Io(animatorListener);
    }

    @RequiresApi(api = 19)
    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.lottieDrawable.oxoX(animatorPauseListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.X0o0xo(animatorUpdateListener);
    }

    public boolean addLottieOnCompositionLoadedListener(@NonNull x0XOIxOo x0xoixoo) {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.composition;
        if (oxx0IOOO != null) {
            x0xoixoo.oIX0oI(oxx0IOOO);
        }
        return this.lottieOnCompositionLoadedListeners.add(x0xoixoo);
    }

    public <T> void addValueCallback(x0xO0oo.oxoX oxox, T t, xoXoI.xoIox<T> xoiox) {
        this.lottieDrawable.XO(oxox, t, xoiox);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        com.airbnb.lottie.X0o0xo.oIX0oI("buildDrawingCache");
        this.buildDrawingCacheDepth++;
        super.buildDrawingCache(z);
        if (this.buildDrawingCacheDepth == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(RenderMode.HARDWARE);
        }
        this.buildDrawingCacheDepth--;
        com.airbnb.lottie.X0o0xo.II0xO0("buildDrawingCache");
    }

    @MainThread
    public void cancelAnimation() {
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        this.lottieDrawable.OOXIXo();
        enableOrDisableHardwareLayer();
    }

    public void disableExtraScaleModeInFitXY() {
        this.lottieDrawable.ooOOo0oXI();
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        this.lottieDrawable.Oo(z);
    }

    @Nullable
    public com.airbnb.lottie.Oxx0IOOO getComposition() {
        return this.composition;
    }

    public long getDuration() {
        if (this.composition != null) {
            return r0.oxoX();
        }
        return 0L;
    }

    public int getFrame() {
        return this.lottieDrawable.xoXoI();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.lottieDrawable.O0xOxO();
    }

    public float getMaxFrame() {
        return this.lottieDrawable.X0IIOO();
    }

    public float getMinFrame() {
        return this.lottieDrawable.XIxXXX0x0();
    }

    @Nullable
    public oI0IIXIo getPerformanceTracker() {
        return this.lottieDrawable.xxX();
    }

    @FloatRange(from = XIXIX.OOXIXo.f3760XO, to = 1.0d)
    public float getProgress() {
        return this.lottieDrawable.XxX0x0xxx();
    }

    public int getRepeatCount() {
        return this.lottieDrawable.xXxxox0I();
    }

    public int getRepeatMode() {
        return this.lottieDrawable.IIX0o();
    }

    public float getScale() {
        return this.lottieDrawable.ooXIXxIX();
    }

    public float getSpeed() {
        return this.lottieDrawable.xI();
    }

    public boolean hasMasks() {
        return this.lottieDrawable.IoOoX();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.oOXoIIIo();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        xoIox xoiox = this.lottieDrawable;
        if (drawable2 == xoiox) {
            super.invalidateDrawable(xoiox);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean isAnimating() {
        return this.lottieDrawable.Xx000oIo();
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.xII();
    }

    @Deprecated
    public void loop(boolean z) {
        int i;
        xoIox xoiox = this.lottieDrawable;
        if (z) {
            i = -1;
        } else {
            i = 0;
        }
        xoiox.O00XxXI(i);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && (this.autoPlay || this.wasAnimatingWhenDetached)) {
            playAnimation();
            this.autoPlay = false;
            this.wasAnimatingWhenDetached = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.wasAnimatingWhenDetached = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.f4786XO;
        this.animationName = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.animationName);
        }
        int i = savedState.f4783Oo;
        this.animationResId = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.f4782IXxxXO);
        if (savedState.f4784Oxx0xo) {
            playAnimation();
        }
        this.lottieDrawable.XoI0Ixx0(savedState.f4787oI0IIXIo);
        setRepeatMode(savedState.f4785OxxIIOOXO);
        setRepeatCount(savedState.f4781IIXOooo);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4786XO = this.animationName;
        savedState.f4783Oo = this.animationResId;
        savedState.f4782IXxxXO = this.lottieDrawable.XxX0x0xxx();
        if (!this.lottieDrawable.Xx000oIo() && (ViewCompat.isAttachedToWindow(this) || !this.wasAnimatingWhenDetached)) {
            z = false;
        } else {
            z = true;
        }
        savedState.f4784Oxx0xo = z;
        savedState.f4787oI0IIXIo = this.lottieDrawable.O0xOxO();
        savedState.f4785OxxIIOOXO = this.lottieDrawable.IIX0o();
        savedState.f4781IIXOooo = this.lottieDrawable.xXxxox0I();
        return savedState;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        if (!this.isInitialized) {
            return;
        }
        if (isShown()) {
            if (this.wasAnimatingWhenNotShown) {
                resumeAnimation();
            } else if (this.playAnimationWhenShown) {
                playAnimation();
            }
            this.wasAnimatingWhenNotShown = false;
            this.playAnimationWhenShown = false;
            return;
        }
        if (isAnimating()) {
            pauseAnimation();
            this.wasAnimatingWhenNotShown = true;
        }
    }

    @MainThread
    public void pauseAnimation() {
        this.autoPlay = false;
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        this.lottieDrawable.XOxIOxOx();
        enableOrDisableHardwareLayer();
    }

    @MainThread
    public void playAnimation() {
        if (isShown()) {
            this.lottieDrawable.OI0();
            enableOrDisableHardwareLayer();
        } else {
            this.playAnimationWhenShown = true;
        }
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.Io();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.o0();
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.XX(animatorListener);
    }

    @RequiresApi(api = 19)
    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.lottieDrawable.I0oOoX(animatorPauseListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(@NonNull x0XOIxOo x0xoixoo) {
        return this.lottieOnCompositionLoadedListeners.remove(x0xoixoo);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.oxxXoxO(animatorUpdateListener);
    }

    public List<x0xO0oo.oxoX> resolveKeyPath(x0xO0oo.oxoX oxox) {
        return this.lottieDrawable.XoX(oxox);
    }

    @MainThread
    public void resumeAnimation() {
        if (isShown()) {
            this.lottieDrawable.oxXx0IX();
            enableOrDisableHardwareLayer();
        } else {
            this.playAnimationWhenShown = false;
            this.wasAnimatingWhenNotShown = true;
        }
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.xo0x();
    }

    public void setAnimation(@RawRes int i) {
        this.animationResId = i;
        this.animationName = null;
        setCompositionTask(fromRawRes(i));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.cacheComposition ? II0XooXoX.xoXoI(getContext(), str) : II0XooXoX.o00(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.lottieDrawable.xXOx(z);
    }

    public void setCacheComposition(boolean z) {
        this.cacheComposition = z;
    }

    public void setComposition(@NonNull com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
        if (com.airbnb.lottie.X0o0xo.f4824oIX0oI) {
            Log.v(TAG, "Set Composition \n" + oxx0IOOO);
        }
        this.lottieDrawable.setCallback(this);
        this.composition = oxx0IOOO;
        boolean XX02 = this.lottieDrawable.XX0(oxx0IOOO);
        enableOrDisableHardwareLayer();
        if (getDrawable() == this.lottieDrawable && !XX02) {
            return;
        }
        if (!XX02) {
            setLottieDrawable();
        }
        onVisibilityChanged(this, getVisibility());
        requestLayout();
        Iterator<x0XOIxOo> it = this.lottieOnCompositionLoadedListeners.iterator();
        while (it.hasNext()) {
            it.next().oIX0oI(oxx0IOOO);
        }
    }

    public void setFailureListener(@Nullable oOoXoXO<Throwable> oooxoxo) {
        this.failureListener = oooxoxo;
    }

    public void setFallbackResource(@DrawableRes int i) {
        this.fallbackResource = i;
    }

    public void setFontAssetDelegate(com.airbnb.lottie.I0Io i0Io) {
        this.lottieDrawable.I0X0x0oIo(i0Io);
    }

    public void setFrame(int i) {
        this.lottieDrawable.oX(i);
    }

    public void setImageAssetDelegate(com.airbnb.lottie.oxoX oxox) {
        this.lottieDrawable.Xo0(oxox);
    }

    public void setImageAssetsFolder(String str) {
        this.lottieDrawable.XoI0Ixx0(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        cancelLoaderTask();
        super.setImageResource(i);
    }

    public void setMaxFrame(int i) {
        this.lottieDrawable.O0Xx(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.lottieDrawable.xoxXI(f);
    }

    public void setMinAndMaxFrame(String str) {
        this.lottieDrawable.IoOoo(str);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.lottieDrawable.x0xO(f, f2);
    }

    public void setMinFrame(int i) {
        this.lottieDrawable.OO0x0xX(i);
    }

    public void setMinProgress(float f) {
        this.lottieDrawable.Ioxxx(f);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.lottieDrawable.xxIO(z);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.lottieDrawable.XX0xXo(z);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.lottieDrawable.o0xxxXXxX(f);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.renderMode = renderMode;
        enableOrDisableHardwareLayer();
    }

    public void setRepeatCount(int i) {
        this.lottieDrawable.O00XxXI(i);
    }

    public void setRepeatMode(int i) {
        this.lottieDrawable.ox(i);
    }

    public void setSafeMode(boolean z) {
        this.lottieDrawable.XI0oooXX(z);
    }

    public void setScale(float f) {
        this.lottieDrawable.OOXIxO0(f);
        if (getDrawable() == this.lottieDrawable) {
            setLottieDrawable();
        }
    }

    public void setSpeed(float f) {
        this.lottieDrawable.IIxOXoOo0(f);
    }

    public void setTextDelegate(IIXOooo iIXOooo) {
        this.lottieDrawable.ooOx(iIXOooo);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        xoIox xoiox = this.lottieDrawable;
        if (drawable == xoiox && xoiox.Xx000oIo()) {
            cancelAnimation();
        } else if (drawable instanceof xoIox) {
            xoIox xoiox2 = (xoIox) drawable;
            if (xoiox2.Xx000oIo()) {
                xoiox2.OOXIXo();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        return this.lottieDrawable.xoO0xx0(str, bitmap);
    }

    public <T> void addValueCallback(x0xO0oo.oxoX oxox, T t, xoXoI.oOoXoXO<T> oooxoxo) {
        this.lottieDrawable.XO(oxox, t, new XO(oooxoxo));
    }

    public void setAnimationFromJson(String str, @Nullable String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setMaxFrame(String str) {
        this.lottieDrawable.I0oOIX(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z) {
        this.lottieDrawable.xoIxX(str, str2, z);
    }

    public void setMinFrame(String str) {
        this.lottieDrawable.XIo0oOXIx(str);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.lottieDrawable.OO(i, i2);
    }

    public void setAnimation(String str) {
        this.animationName = str;
        this.animationResId = 0;
        setCompositionTask(fromAssets(str));
    }

    public void setAnimationFromUrl(String str, @Nullable String str2) {
        setCompositionTask(II0XooXoX.o00(getContext(), str, str2));
    }

    public void setAnimation(InputStream inputStream, @Nullable String str) {
        setCompositionTask(II0XooXoX.xoIox(inputStream, str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.loadedListener = new II0xO0();
        this.wrappedFailureListener = new I0Io();
        this.fallbackResource = 0;
        this.lottieDrawable = new xoIox();
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.renderMode = RenderMode.AUTOMATIC;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.buildDrawingCacheDepth = 0;
        init(attributeSet, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.loadedListener = new II0xO0();
        this.wrappedFailureListener = new I0Io();
        this.fallbackResource = 0;
        this.lottieDrawable = new xoIox();
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.renderMode = RenderMode.AUTOMATIC;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.buildDrawingCacheDepth = 0;
        init(attributeSet, i);
    }
}
