package oIxOXo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes6.dex */
public final class II0xO0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f31740II0XooXoX = "II0xO0";

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final String f31742OOXIXo = "appcompat_skip_skip";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final String f31747oOoXoXO = "android.graphics.drawable.VectorDrawable";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static II0xO0 f31748ooOOo0oXI = null;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final boolean f31752xxIXOIIO = false;

    /* renamed from: I0Io, reason: collision with root package name */
    public SparseArray<String> f31753I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public ArrayMap<String, I0Io> f31754II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f31755Oxx0IOOO;

    /* renamed from: XO, reason: collision with root package name */
    public TypedValue f31757XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public WeakHashMap<Context, SparseArray<ColorStateList>> f31758oIX0oI;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final PorterDuff.Mode f31751xoIox = PorterDuff.Mode.SRC_IN;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final C1125II0xO0 f31749x0XOIxOo = new C1125II0xO0(6);

    /* renamed from: oO, reason: collision with root package name */
    public static final int[] f31746oO = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int[] f31750x0xO0oo = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

    /* renamed from: Oo, reason: collision with root package name */
    public static final int[] f31743Oo = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int[] f31741IXxxXO = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int[] f31744Oxx0xo = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int[] f31745oI0IIXIo = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material};

    /* renamed from: oxoX, reason: collision with root package name */
    public final Object f31759oxoX = new Object();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> f31756X0o0xo = new WeakHashMap<>(0);

    /* loaded from: classes6.dex */
    public interface I0Io {
        Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme);
    }

    /* renamed from: oIxOXo.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1125II0xO0 extends LruCache<Integer, PorterDuffColorFilter> {
        public C1125II0xO0(int i) {
            super(i);
        }

        public static int generateCacheKey(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter get(int i, PorterDuff.Mode mode) {
            return get(Integer.valueOf(generateCacheKey(i, mode)));
        }

        public PorterDuffColorFilter put(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(generateCacheKey(i, mode)), porterDuffColorFilter);
        }
    }

    @RequiresApi(11)
    @TargetApi(11)
    /* loaded from: classes6.dex */
    public static class oIX0oI implements I0Io {
        @Override // oIxOXo.II0xO0.I0Io
        @SuppressLint({"NewApi"})
        public Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class oxoX implements I0Io {
        @Override // oIxOXo.II0xO0.I0Io
        @SuppressLint({"NewApi"})
        public Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return VectorDrawableCompat.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    public static PorterDuff.Mode IIXOooo(int i) {
        if (i == R.drawable.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    public static PorterDuffColorFilter Oxx0xo(int i, PorterDuff.Mode mode) {
        C1125II0xO0 c1125II0xO0 = f31749x0XOIxOo;
        PorterDuffColorFilter porterDuffColorFilter = c1125II0xO0.get(i, mode);
        if (porterDuffColorFilter == null) {
            PorterDuffColorFilter porterDuffColorFilter2 = new PorterDuffColorFilter(i, mode);
            c1125II0xO0.put(i, mode, porterDuffColorFilter2);
            return porterDuffColorFilter2;
        }
        return porterDuffColorFilter;
    }

    public static void XI0IXoo(Drawable drawable, int i, PorterDuff.Mode mode) {
        if (oIxOXo.I0Io.oIX0oI(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f31751xoIox;
        }
        drawable.setColorFilter(Oxx0xo(i, mode));
    }

    public static boolean o00(@NonNull Drawable drawable) {
        if (!(drawable instanceof VectorDrawableCompat) && !"android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            return false;
        }
        return true;
    }

    public static II0xO0 oO() {
        if (f31748ooOOo0oXI == null) {
            II0xO0 iI0xO0 = new II0xO0();
            f31748ooOOo0oXI = iI0xO0;
            xoXoI(iI0xO0);
        }
        return f31748ooOOo0oXI;
    }

    public static boolean oxoX(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static PorterDuffColorFilter x0XOIxOo(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList != null && mode != null) {
            return Oxx0xo(colorStateList.getColorForState(iArr, 0), mode);
        }
        return null;
    }

    public static void xoXoI(@NonNull II0xO0 iI0xO0) {
        if (Build.VERSION.SDK_INT < 24) {
            iI0xO0.oIX0oI("vector", new oxoX());
            iI0xO0.oIX0oI("animated-vector", new oIX0oI());
        }
    }

    public static long xxIXOIIO(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean xxX(@androidx.annotation.NonNull android.content.Context r6, @androidx.annotation.DrawableRes int r7, @androidx.annotation.NonNull android.graphics.drawable.Drawable r8) {
        /*
            android.graphics.PorterDuff$Mode r0 = oIxOXo.II0xO0.f31751xoIox
            int[] r1 = oIxOXo.II0xO0.f31746oO
            boolean r1 = oxoX(r1, r7)
            r2 = 1
            r3 = 0
            r4 = -1
            if (r1 == 0) goto L13
            int r7 = androidx.appcompat.R.attr.colorControlNormal
        Lf:
            r1 = r0
        L10:
            r0 = -1
            r5 = 1
            goto L4e
        L13:
            int[] r1 = oIxOXo.II0xO0.f31743Oo
            boolean r1 = oxoX(r1, r7)
            if (r1 == 0) goto L1e
            int r7 = androidx.appcompat.R.attr.colorControlActivated
            goto Lf
        L1e:
            int[] r1 = oIxOXo.II0xO0.f31741IXxxXO
            boolean r1 = oxoX(r1, r7)
            r5 = 16842801(0x1010031, float:2.3693695E-38)
            if (r1 == 0) goto L30
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
        L2b:
            r1 = r0
            r7 = 16842801(0x1010031, float:2.3693695E-38)
            goto L10
        L30:
            int r1 = androidx.appcompat.R.drawable.abc_list_divider_mtrl_alpha
            if (r7 != r1) goto L45
            r7 = 1109603123(0x42233333, float:40.8)
            int r7 = java.lang.Math.round(r7)
            r1 = 16842800(0x1010030, float:2.3693693E-38)
            r1 = r0
            r5 = 1
            r0 = r7
            r7 = 16842800(0x1010030, float:2.3693693E-38)
            goto L4e
        L45:
            int r1 = androidx.appcompat.R.drawable.abc_dialog_material_background
            if (r7 != r1) goto L4a
            goto L2b
        L4a:
            r1 = r0
            r7 = 0
            r0 = -1
            r5 = 0
        L4e:
            if (r5 == 0) goto L6b
            boolean r3 = oIxOXo.I0Io.oIX0oI(r8)
            if (r3 == 0) goto L5a
            android.graphics.drawable.Drawable r8 = r8.mutate()
        L5a:
            int r6 = oIxOXo.X0o0xo.oxoX(r6, r7)
            android.graphics.PorterDuffColorFilter r6 = Oxx0xo(r6, r1)
            r8.setColorFilter(r6)
            if (r0 == r4) goto L6a
            r8.setAlpha(r0)
        L6a:
            return r2
        L6b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: oIxOXo.II0xO0.xxX(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    public final void I0Io(@NonNull Context context, @DrawableRes int i, @NonNull ColorStateList colorStateList) {
        if (this.f31758oIX0oI == null) {
            this.f31758oIX0oI = new WeakHashMap<>();
        }
        SparseArray<ColorStateList> sparseArray = this.f31758oIX0oI.get(context);
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.f31758oIX0oI.put(context, sparseArray);
        }
        sparseArray.append(i, colorStateList);
    }

    public final ColorStateList II0XooXoX(@NonNull Context context, @ColorInt int i) {
        int oxoX2 = X0o0xo.oxoX(context, R.attr.colorControlHighlight);
        return new ColorStateList(new int[][]{X0o0xo.f31765II0xO0, X0o0xo.f31766OOXIXo, X0o0xo.f31768X0o0xo, X0o0xo.f31771oO}, new int[]{X0o0xo.oIX0oI(context, R.attr.colorButtonNormal), ColorUtils.compositeColors(oxoX2, i), ColorUtils.compositeColors(oxoX2, i), i});
    }

    public final boolean II0xO0(@NonNull Context context, long j, @NonNull Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            synchronized (this.f31759oxoX) {
                try {
                    LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.f31756X0o0xo.get(context);
                    if (longSparseArray == null) {
                        longSparseArray = new LongSparseArray<>();
                        this.f31756X0o0xo.put(context, longSparseArray);
                    }
                    longSparseArray.put(j, new WeakReference<>(constantState));
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
        return false;
    }

    public Drawable IXxxXO(@NonNull Context context, @DrawableRes int i, boolean z) {
        X0o0xo(context);
        Drawable OxI2 = OxI(context, i);
        if (OxI2 == null) {
            OxI2 = oOoXoXO(context, i);
        }
        if (OxI2 == null) {
            OxI2 = oIxOXo.oxoX.Oxx0IOOO(context, i);
        }
        if (OxI2 != null) {
            OxI2 = XIxXXX0x0(context, i, z, OxI2);
        }
        if (OxI2 != null) {
            oIxOXo.I0Io.II0xO0(OxI2);
        }
        return OxI2;
    }

    public void O0xOxO(@NonNull Context context) {
        synchronized (this.f31759oxoX) {
            try {
                LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.f31756X0o0xo.get(context);
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final ColorStateList OOXIXo(@NonNull Context context) {
        return II0XooXoX(context, X0o0xo.oxoX(context, R.attr.colorButtonNormal));
    }

    public Drawable Oo(@NonNull Context context, @DrawableRes int i) {
        return IXxxXO(context, i, false);
    }

    public final Drawable OxI(@NonNull Context context, @DrawableRes int i) {
        int next;
        ArrayMap<String, I0Io> arrayMap = this.f31754II0xO0;
        if (arrayMap == null || arrayMap.isEmpty()) {
            return null;
        }
        SparseArray<String> sparseArray = this.f31753I0Io;
        if (sparseArray != null) {
            String str = sparseArray.get(i);
            if (f31742OOXIXo.equals(str) || (str != null && this.f31754II0xO0.get(str) == null)) {
                return null;
            }
        } else {
            this.f31753I0Io = new SparseArray<>();
        }
        if (this.f31757XO == null) {
            this.f31757XO = new TypedValue();
        }
        TypedValue typedValue = this.f31757XO;
        oIxOXo.oxoX.Oxx0xo(context, i, typedValue, true);
        long xxIXOIIO2 = xxIXOIIO(typedValue);
        Drawable x0xO0oo2 = x0xO0oo(context, xxIXOIIO2);
        if (x0xO0oo2 != null) {
            return x0xO0oo2;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser oI0IIXIo2 = oIxOXo.oxoX.oI0IIXIo(context, i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(oI0IIXIo2);
                do {
                    next = oI0IIXIo2.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next == 2) {
                    String name = oI0IIXIo2.getName();
                    this.f31753I0Io.append(i, name);
                    I0Io i0Io = this.f31754II0xO0.get(name);
                    if (i0Io != null) {
                        x0xO0oo2 = i0Io.createFromXmlInner(context, oI0IIXIo2, asAttributeSet, null);
                    }
                    if (x0xO0oo2 != null) {
                        x0xO0oo2.setChangingConfigurations(typedValue.changingConfigurations);
                        II0xO0(context, xxIXOIIO2, x0xO0oo2);
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception e) {
                Log.e(f31740II0XooXoX, "Exception while inflating drawable", e);
            }
        }
        if (x0xO0oo2 == null) {
            this.f31753I0Io.append(i, f31742OOXIXo);
        }
        return x0xO0oo2;
    }

    public final ColorStateList Oxx0IOOO(@NonNull Context context) {
        return II0XooXoX(context, 0);
    }

    public final ColorStateList OxxIIOOXO(@NonNull Context context, @DrawableRes int i) {
        SparseArray<ColorStateList> sparseArray;
        WeakHashMap<Context, SparseArray<ColorStateList>> weakHashMap = this.f31758oIX0oI;
        if (weakHashMap == null || (sparseArray = weakHashMap.get(context)) == null) {
            return null;
        }
        return sparseArray.get(i);
    }

    public final void X0IIOO(@NonNull String str, @NonNull I0Io i0Io) {
        ArrayMap<String, I0Io> arrayMap = this.f31754II0xO0;
        if (arrayMap != null && arrayMap.get(str) == i0Io) {
            this.f31754II0xO0.remove(str);
        }
    }

    public final void X0o0xo(@NonNull Context context) {
        if (this.f31755Oxx0IOOO) {
            return;
        }
        this.f31755Oxx0IOOO = true;
    }

    public final Drawable XIxXXX0x0(@NonNull Context context, @DrawableRes int i, boolean z, @NonNull Drawable drawable) {
        ColorStateList oI0IIXIo2 = oI0IIXIo(context, i);
        if (oI0IIXIo2 != null) {
            if (oIxOXo.I0Io.oIX0oI(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable wrap = DrawableCompat.wrap(drawable);
            DrawableCompat.setTintList(wrap, oI0IIXIo2);
            PorterDuff.Mode IIXOooo2 = IIXOooo(i);
            if (IIXOooo2 != null) {
                DrawableCompat.setTintMode(wrap, IIXOooo2);
                return wrap;
            }
            return wrap;
        }
        if (i == R.drawable.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.background);
            int i2 = R.attr.colorControlNormal;
            int oxoX2 = X0o0xo.oxoX(context, i2);
            PorterDuff.Mode mode = f31751xoIox;
            XI0IXoo(findDrawableByLayerId, oxoX2, mode);
            XI0IXoo(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), X0o0xo.oxoX(context, i2), mode);
            XI0IXoo(layerDrawable.findDrawableByLayerId(android.R.id.progress), X0o0xo.oxoX(context, R.attr.colorControlActivated), mode);
            return drawable;
        }
        if (i != R.drawable.abc_ratingbar_material && i != R.drawable.abc_ratingbar_indicator_material && i != R.drawable.abc_ratingbar_small_material) {
            if (!xxX(context, i, drawable) && z) {
                return null;
            }
            return drawable;
        }
        LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
        Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(android.R.id.background);
        int oIX0oI2 = X0o0xo.oIX0oI(context, R.attr.colorControlNormal);
        PorterDuff.Mode mode2 = f31751xoIox;
        XI0IXoo(findDrawableByLayerId2, oIX0oI2, mode2);
        Drawable findDrawableByLayerId3 = layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress);
        int i3 = R.attr.colorControlActivated;
        XI0IXoo(findDrawableByLayerId3, X0o0xo.oxoX(context, i3), mode2);
        XI0IXoo(layerDrawable2.findDrawableByLayerId(android.R.id.progress), X0o0xo.oxoX(context, i3), mode2);
        return drawable;
    }

    public void XO() {
        this.f31756X0o0xo.clear();
        SparseArray<String> sparseArray = this.f31753I0Io;
        if (sparseArray != null) {
            sparseArray.clear();
        }
        WeakHashMap<Context, SparseArray<ColorStateList>> weakHashMap = this.f31758oIX0oI;
        if (weakHashMap != null) {
            weakHashMap.clear();
        }
        f31749x0XOIxOo.evictAll();
    }

    public ColorStateList oI0IIXIo(@NonNull Context context, @DrawableRes int i) {
        ColorStateList OxxIIOOXO2 = OxxIIOOXO(context, i);
        if (OxxIIOOXO2 == null) {
            if (i == R.drawable.abc_edit_text_material) {
                OxxIIOOXO2 = oIxOXo.oxoX.X0o0xo(context, R.color.abc_tint_edittext);
            } else if (i == R.drawable.abc_switch_track_mtrl_alpha) {
                OxxIIOOXO2 = oIxOXo.oxoX.X0o0xo(context, R.color.abc_tint_switch_track);
            } else if (i == R.drawable.abc_switch_thumb_material) {
                OxxIIOOXO2 = ooOOo0oXI(context);
            } else if (i == R.drawable.abc_btn_default_mtrl_shape) {
                OxxIIOOXO2 = OOXIXo(context);
            } else if (i == R.drawable.abc_btn_borderless_material) {
                OxxIIOOXO2 = Oxx0IOOO(context);
            } else if (i == R.drawable.abc_btn_colored_material) {
                OxxIIOOXO2 = xoIox(context);
            } else if (i != R.drawable.abc_spinner_mtrl_am_alpha && i != R.drawable.abc_spinner_textfield_background_material) {
                if (oxoX(f31750x0xO0oo, i)) {
                    OxxIIOOXO2 = X0o0xo.XO(context, R.attr.colorControlNormal);
                } else if (oxoX(f31744Oxx0xo, i)) {
                    OxxIIOOXO2 = oIxOXo.oxoX.X0o0xo(context, R.color.abc_tint_default);
                } else if (oxoX(f31745oI0IIXIo, i)) {
                    OxxIIOOXO2 = oIxOXo.oxoX.X0o0xo(context, R.color.abc_tint_btn_checkable);
                } else if (i == R.drawable.abc_seekbar_thumb_material) {
                    OxxIIOOXO2 = oIxOXo.oxoX.X0o0xo(context, R.color.abc_tint_seek_thumb);
                }
            } else {
                OxxIIOOXO2 = oIxOXo.oxoX.X0o0xo(context, R.color.abc_tint_spinner);
            }
            if (OxxIIOOXO2 != null) {
                I0Io(context, i, OxxIIOOXO2);
            }
        }
        return OxxIIOOXO2;
    }

    public final void oIX0oI(@NonNull String str, @NonNull I0Io i0Io) {
        if (this.f31754II0xO0 == null) {
            this.f31754II0xO0 = new ArrayMap<>();
        }
        this.f31754II0xO0.put(str, i0Io);
    }

    public final Drawable oOoXoXO(@NonNull Context context, @DrawableRes int i) {
        if (this.f31757XO == null) {
            this.f31757XO = new TypedValue();
        }
        TypedValue typedValue = this.f31757XO;
        oIxOXo.oxoX.Oxx0xo(context, i, typedValue, true);
        long xxIXOIIO2 = xxIXOIIO(typedValue);
        Drawable x0xO0oo2 = x0xO0oo(context, xxIXOIIO2);
        if (x0xO0oo2 != null) {
            return x0xO0oo2;
        }
        if (i == R.drawable.abc_cab_background_top_material) {
            x0xO0oo2 = new LayerDrawable(new Drawable[]{Oo(context, R.drawable.abc_cab_background_internal_bg), Oo(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
        }
        if (x0xO0oo2 != null) {
            x0xO0oo2.setChangingConfigurations(typedValue.changingConfigurations);
            II0xO0(context, xxIXOIIO2, x0xO0oo2);
        }
        return x0xO0oo2;
    }

    public final ColorStateList ooOOo0oXI(Context context) {
        int[][] iArr = new int[3];
        int[] iArr2 = new int[3];
        int i = R.attr.colorSwitchThumbNormal;
        ColorStateList XO2 = X0o0xo.XO(context, i);
        if (XO2 != null && XO2.isStateful()) {
            int[] iArr3 = X0o0xo.f31765II0xO0;
            iArr[0] = iArr3;
            iArr2[0] = XO2.getColorForState(iArr3, 0);
            iArr[1] = X0o0xo.f31772oOoXoXO;
            iArr2[1] = X0o0xo.oxoX(context, R.attr.colorControlActivated);
            iArr[2] = X0o0xo.f31771oO;
            iArr2[2] = XO2.getDefaultColor();
        } else {
            iArr[0] = X0o0xo.f31765II0xO0;
            iArr2[0] = X0o0xo.oIX0oI(context, i);
            iArr[1] = X0o0xo.f31772oOoXoXO;
            iArr2[1] = X0o0xo.oxoX(context, R.attr.colorControlActivated);
            iArr[2] = X0o0xo.f31771oO;
            iArr2[2] = X0o0xo.oxoX(context, i);
        }
        return new ColorStateList(iArr, iArr2);
    }

    public final Drawable x0xO0oo(@NonNull Context context, long j) {
        synchronized (this.f31759oxoX) {
            try {
                LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.f31756X0o0xo.get(context);
                if (longSparseArray == null) {
                    return null;
                }
                WeakReference<Drawable.ConstantState> weakReference = longSparseArray.get(j);
                if (weakReference != null) {
                    Drawable.ConstantState constantState = weakReference.get();
                    if (constantState != null) {
                        return constantState.newDrawable(context.getResources());
                    }
                    longSparseArray.delete(j);
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final ColorStateList xoIox(@NonNull Context context) {
        return II0XooXoX(context, X0o0xo.oxoX(context, R.attr.colorAccent));
    }
}
