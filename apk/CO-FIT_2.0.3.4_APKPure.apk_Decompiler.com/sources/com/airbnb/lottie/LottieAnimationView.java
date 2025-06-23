package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Paint;
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
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import xoXoI.oOoXoXO;
import xoXoI.xoIox;

public class LottieAnimationView extends AppCompatImageView {
    /* access modifiers changed from: private */
    public static final oOoXoXO<Throwable> DEFAULT_FAILURE_LISTENER = new oIX0oI();
    private static final String TAG = "LottieAnimationView";
    private String animationName;
    @RawRes
    private int animationResId;
    private boolean autoPlay = false;
    private int buildDrawingCacheDepth = 0;
    /* access modifiers changed from: private */
    public boolean cacheComposition = true;
    @Nullable
    private Oxx0IOOO composition;
    @Nullable
    private IXxxXO<Oxx0IOOO> compositionTask;
    /* access modifiers changed from: private */
    @Nullable
    public oOoXoXO<Throwable> failureListener;
    /* access modifiers changed from: private */
    @DrawableRes
    public int fallbackResource = 0;
    private boolean isInitialized;
    private final oOoXoXO<Oxx0IOOO> loadedListener = new II0xO0();
    private final xoIox lottieDrawable = new xoIox();
    private final Set<x0XOIxOo> lottieOnCompositionLoadedListeners = new HashSet();
    private boolean playAnimationWhenShown = false;
    private RenderMode renderMode = RenderMode.AUTOMATIC;
    private boolean wasAnimatingWhenDetached = false;
    private boolean wasAnimatingWhenNotShown = false;
    private final oOoXoXO<Throwable> wrappedFailureListener = new I0Io();

    public class I0Io implements oOoXoXO<Throwable> {
        public I0Io() {
        }

        /* renamed from: oIX0oI */
        public void onResult(Throwable th) {
            oOoXoXO oooxoxo;
            if (LottieAnimationView.this.fallbackResource != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.fallbackResource);
            }
            if (LottieAnimationView.this.failureListener == null) {
                oooxoxo = LottieAnimationView.DEFAULT_FAILURE_LISTENER;
            } else {
                oooxoxo = LottieAnimationView.this.failureListener;
            }
            oooxoxo.onResult(th);
        }
    }

    public class II0xO0 implements oOoXoXO<Oxx0IOOO> {
        public II0xO0() {
        }

        /* renamed from: oIX0oI */
        public void onResult(Oxx0IOOO oxx0IOOO) {
            LottieAnimationView.this.setComposition(oxx0IOOO);
        }
    }

    public static /* synthetic */ class Oxx0IOOO {

        /* renamed from: oIX0oI  reason: collision with root package name */
        public static final /* synthetic */ int[] f786oIX0oI;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.airbnb.lottie.RenderMode[] r0 = com.airbnb.lottie.RenderMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f786oIX0oI = r0
                com.airbnb.lottie.RenderMode r1 = com.airbnb.lottie.RenderMode.HARDWARE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f786oIX0oI     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.RenderMode r1 = com.airbnb.lottie.RenderMode.SOFTWARE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f786oIX0oI     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.RenderMode r1 = com.airbnb.lottie.RenderMode.AUTOMATIC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.Oxx0IOOO.<clinit>():void");
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new oIX0oI();

        /* renamed from: IIXOooo  reason: collision with root package name */
        public int f787IIXOooo;

        /* renamed from: IXxxXO  reason: collision with root package name */
        public float f788IXxxXO;

        /* renamed from: Oo  reason: collision with root package name */
        public int f789Oo;

        /* renamed from: Oxx0xo  reason: collision with root package name */
        public boolean f790Oxx0xo;

        /* renamed from: OxxIIOOXO  reason: collision with root package name */
        public int f791OxxIIOOXO;

        /* renamed from: XO  reason: collision with root package name */
        public String f792XO;

        /* renamed from: oI0IIXIo  reason: collision with root package name */
        public String f793oI0IIXIo;

        public class oIX0oI implements Parcelable.Creator<SavedState> {
            /* renamed from: II0xO0 */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            /* renamed from: oIX0oI */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (oIX0oI) null);
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, oIX0oI oix0oi) {
            this(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f792XO);
            parcel.writeFloat(this.f788IXxxXO);
            parcel.writeInt(this.f790Oxx0xo ? 1 : 0);
            parcel.writeString(this.f793oI0IIXIo);
            parcel.writeInt(this.f791OxxIIOOXO);
            parcel.writeInt(this.f787IIXOooo);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f792XO = parcel.readString();
            this.f788IXxxXO = parcel.readFloat();
            this.f790Oxx0xo = parcel.readInt() != 1 ? false : true;
            this.f793oI0IIXIo = parcel.readString();
            this.f791OxxIIOOXO = parcel.readInt();
            this.f787IIXOooo = parcel.readInt();
        }
    }

    public class X0o0xo implements Callable<x0xO0oo<Oxx0IOOO>> {

        /* renamed from: XO  reason: collision with root package name */
        public final /* synthetic */ String f795XO;

        public X0o0xo(String str) {
            this.f795XO = str;
        }

        /* renamed from: oIX0oI */
        public x0xO0oo<Oxx0IOOO> call() {
            if (LottieAnimationView.this.cacheComposition) {
                return II0XooXoX.Oxx0IOOO(LottieAnimationView.this.getContext(), this.f795XO);
            }
            return II0XooXoX.II0XooXoX(LottieAnimationView.this.getContext(), this.f795XO, (String) null);
        }
    }

    public class XO extends xoIox<T> {

        /* renamed from: oxoX  reason: collision with root package name */
        public final /* synthetic */ oOoXoXO f797oxoX;

        public XO(oOoXoXO oooxoxo) {
            this.f797oxoX = oooxoxo;
        }

        public T oIX0oI(xoXoI.II0xO0<T> iI0xO0) {
            return this.f797oxoX.oIX0oI(iI0xO0);
        }
    }

    public class oIX0oI implements oOoXoXO<Throwable> {
        /* renamed from: oIX0oI */
        public void onResult(Throwable th) {
            if (IIXOooo.xoIox.OOXIXo(th)) {
                IIXOooo.XO.XO("Unable to load composition.", th);
                return;
            }
            throw new IllegalStateException("Unable to parse composition", th);
        }
    }

    public class oxoX implements Callable<x0xO0oo<Oxx0IOOO>> {

        /* renamed from: XO  reason: collision with root package name */
        public final /* synthetic */ int f799XO;

        public oxoX(int i) {
            this.f799XO = i;
        }

        /* renamed from: oIX0oI */
        public x0xO0oo<Oxx0IOOO> call() {
            if (LottieAnimationView.this.cacheComposition) {
                return II0XooXoX.OxxIIOOXO(LottieAnimationView.this.getContext(), this.f799XO);
            }
            return II0XooXoX.IIXOooo(LottieAnimationView.this.getContext(), this.f799XO, (String) null);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        init((AttributeSet) null, R.attr.lottieAnimationViewStyle);
    }

    private void cancelLoaderTask() {
        IXxxXO<Oxx0IOOO> iXxxXO = this.compositionTask;
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
        Oxx0IOOO oxx0IOOO;
        Oxx0IOOO oxx0IOOO2;
        int i;
        int i2 = Oxx0IOOO.f786oIX0oI[this.renderMode.ordinal()];
        int i3 = 2;
        if (i2 != 1 && (i2 == 2 || i2 != 3 || (((oxx0IOOO = this.composition) != null && oxx0IOOO.IXxxXO() && Build.VERSION.SDK_INT < 28) || (((oxx0IOOO2 = this.composition) != null && oxx0IOOO2.ooOOo0oXI() > 4) || (i = Build.VERSION.SDK_INT) == 24 || i == 25)))) {
            i3 = 1;
        }
        if (i3 != getLayerType()) {
            setLayerType(i3, (Paint) null);
        }
    }

    private IXxxXO<Oxx0IOOO> fromAssets(String str) {
        if (isInEditMode()) {
            return new IXxxXO<>(new X0o0xo(str), true);
        }
        if (this.cacheComposition) {
            return II0XooXoX.X0o0xo(getContext(), str);
        }
        return II0XooXoX.XO(getContext(), str, (String) null);
    }

    private IXxxXO<Oxx0IOOO> fromRawRes(@RawRes int i) {
        if (isInEditMode()) {
            return new IXxxXO<>(new oxoX(i), true);
        }
        if (this.cacheComposition) {
            return II0XooXoX.Oxx0xo(getContext(), i);
        }
        return II0XooXoX.oI0IIXIo(getContext(), i, (String) null);
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
        if (!hasValue || !hasValue2) {
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
                OxxIIOOXO oxxIIOOXO = new OxxIIOOXO(AppCompatResources.getColorStateList(getContext(), obtainStyledAttributes.getResourceId(i8, -1)).getDefaultColor());
                addValueCallback(new x0xO0oo.oxoX("**"), oO.f982XxX0x0xxx, new xoIox(oxxIIOOXO));
            }
            int i9 = R.styleable.LottieAnimationView_lottie_scale;
            if (obtainStyledAttributes.hasValue(i9)) {
                this.lottieDrawable.OOXIxO0(obtainStyledAttributes.getFloat(i9, 1.0f));
            }
            int i10 = R.styleable.LottieAnimationView_lottie_renderMode;
            if (obtainStyledAttributes.hasValue(i10)) {
                RenderMode renderMode2 = RenderMode.AUTOMATIC;
                int i11 = obtainStyledAttributes.getInt(i10, renderMode2.ordinal());
                if (i11 >= RenderMode.values().length) {
                    i11 = renderMode2.ordinal();
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
            return;
        }
        throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
    }

    private void setCompositionTask(IXxxXO<Oxx0IOOO> iXxxXO) {
        clearComposition();
        cancelLoaderTask();
        this.compositionTask = iXxxXO.XO(this.loadedListener).X0o0xo(this.wrappedFailureListener);
    }

    private void setLottieDrawable() {
        boolean isAnimating = isAnimating();
        setImageDrawable((Drawable) null);
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
        Oxx0IOOO oxx0IOOO = this.composition;
        if (oxx0IOOO != null) {
            x0xoixoo.oIX0oI(oxx0IOOO);
        }
        return this.lottieOnCompositionLoadedListeners.add(x0xoixoo);
    }

    public <T> void addValueCallback(x0xO0oo.oxoX oxox, T t, xoIox<T> xoiox) {
        this.lottieDrawable.XO(oxox, t, xoiox);
    }

    public void buildDrawingCache(boolean z) {
        X0o0xo.oIX0oI("buildDrawingCache");
        this.buildDrawingCacheDepth++;
        super.buildDrawingCache(z);
        if (this.buildDrawingCacheDepth == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(RenderMode.HARDWARE);
        }
        this.buildDrawingCacheDepth--;
        X0o0xo.II0xO0("buildDrawingCache");
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
    public Oxx0IOOO getComposition() {
        return this.composition;
    }

    public long getDuration() {
        Oxx0IOOO oxx0IOOO = this.composition;
        if (oxx0IOOO != null) {
            return (long) oxx0IOOO.oxoX();
        }
        return 0;
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

    @FloatRange(from = 0.0d, to = 1.0d)
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

    public void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.wasAnimatingWhenDetached = true;
        }
        super.onDetachedFromWindow();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.f792XO;
        this.animationName = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.animationName);
        }
        int i = savedState.f789Oo;
        this.animationResId = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.f788IXxxXO);
        if (savedState.f790Oxx0xo) {
            playAnimation();
        }
        this.lottieDrawable.XoI0Ixx0(savedState.f793oI0IIXIo);
        setRepeatMode(savedState.f791OxxIIOOXO);
        setRepeatCount(savedState.f787IIXOooo);
    }

    public Parcelable onSaveInstanceState() {
        boolean z;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f792XO = this.animationName;
        savedState.f789Oo = this.animationResId;
        savedState.f788IXxxXO = this.lottieDrawable.XxX0x0xxx();
        if (this.lottieDrawable.Xx000oIo() || (!ViewCompat.isAttachedToWindow(this) && this.wasAnimatingWhenDetached)) {
            z = true;
        } else {
            z = false;
        }
        savedState.f790Oxx0xo = z;
        savedState.f793oI0IIXIo = this.lottieDrawable.O0xOxO();
        savedState.f791OxxIIOOXO = this.lottieDrawable.IIX0o();
        savedState.f787IIXOooo = this.lottieDrawable.xXxxox0I();
        return savedState;
    }

    public void onVisibilityChanged(@NonNull View view, int i) {
        if (this.isInitialized) {
            if (isShown()) {
                if (this.wasAnimatingWhenNotShown) {
                    resumeAnimation();
                } else if (this.playAnimationWhenShown) {
                    playAnimation();
                }
                this.wasAnimatingWhenNotShown = false;
                this.playAnimationWhenShown = false;
            } else if (isAnimating()) {
                pauseAnimation();
                this.wasAnimatingWhenNotShown = true;
            }
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
            return;
        }
        this.playAnimationWhenShown = true;
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
            return;
        }
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = true;
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
        setAnimationFromJson(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.cacheComposition ? II0XooXoX.xoXoI(getContext(), str) : II0XooXoX.o00(getContext(), str, (String) null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.lottieDrawable.xXOx(z);
    }

    public void setCacheComposition(boolean z) {
        this.cacheComposition = z;
    }

    public void setComposition(@NonNull Oxx0IOOO oxx0IOOO) {
        if (X0o0xo.f830oIX0oI) {
            String str = TAG;
            Log.v(str, "Set Composition \n" + oxx0IOOO);
        }
        this.lottieDrawable.setCallback(this);
        this.composition = oxx0IOOO;
        boolean XX02 = this.lottieDrawable.XX0(oxx0IOOO);
        enableOrDisableHardwareLayer();
        if (getDrawable() != this.lottieDrawable || XX02) {
            if (!XX02) {
                setLottieDrawable();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            for (x0XOIxOo oIX0oI2 : this.lottieOnCompositionLoadedListeners) {
                oIX0oI2.oIX0oI(oxx0IOOO);
            }
        }
    }

    public void setFailureListener(@Nullable oOoXoXO<Throwable> oooxoxo) {
        this.failureListener = oooxoxo;
    }

    public void setFallbackResource(@DrawableRes int i) {
        this.fallbackResource = i;
    }

    public void setFontAssetDelegate(I0Io i0Io) {
        this.lottieDrawable.I0X0x0oIo(i0Io);
    }

    public void setFrame(int i) {
        this.lottieDrawable.oX(i);
    }

    public void setImageAssetDelegate(oxoX oxox) {
        this.lottieDrawable.Xo0(oxox);
    }

    public void setImageAssetsFolder(String str) {
        this.lottieDrawable.XoI0Ixx0(str);
    }

    public void setImageBitmap(Bitmap bitmap) {
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable) {
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

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

    public void setRenderMode(RenderMode renderMode2) {
        this.renderMode = renderMode2;
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

    public <T> void addValueCallback(x0xO0oo.oxoX oxox, T t, oOoXoXO<T> oooxoxo) {
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
        init(attributeSet, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i);
    }
}
