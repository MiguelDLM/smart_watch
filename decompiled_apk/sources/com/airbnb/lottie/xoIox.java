package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class xoIox extends Drawable implements Drawable.Callback, Animatable {

    /* renamed from: IoOoX, reason: collision with root package name */
    public static final int f5071IoOoX = 1;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public static final int f5072Xx000oIo = -1;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public static final int f5073oOXoIIIo = 2;

    /* renamed from: IIX0o, reason: collision with root package name */
    public boolean f5074IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public final ArrayList<Oxx0xo> f5075IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final IIXOooo.Oxx0IOOO f5076IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    @Nullable
    public com.airbnb.lottie.oxoX f5077O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public com.airbnb.lottie.Oxx0IOOO f5078Oo;

    /* renamed from: OxI, reason: collision with root package name */
    @Nullable
    public String f5079OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public float f5080Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f5081OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    @Nullable
    public oO.oI0IIXIo f5082X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    @Nullable
    public com.airbnb.lottie.I0Io f5083XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    @Nullable
    public IIXOooo f5084XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public final Matrix f5085XO = new Matrix();

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    @Nullable
    public com.airbnb.lottie.model.layer.II0xO0 f5086XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    @Nullable
    public oO.OxxIIOOXO f5087o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f5088oI0IIXIo;

    /* renamed from: oo, reason: collision with root package name */
    public boolean f5089oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public boolean f5090oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public boolean f5091ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public boolean f5092xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public int f5093xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public final ValueAnimator.AnimatorUpdateListener f5094xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public boolean f5095xxX;

    /* loaded from: classes.dex */
    public class I0Io implements Oxx0xo {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ int f5097II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ int f5098oIX0oI;

        public I0Io(int i, int i2) {
            this.f5098oIX0oI = i;
            this.f5097II0xO0 = i2;
        }

        @Override // com.airbnb.lottie.xoIox.Oxx0xo
        public void oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
            xoIox.this.OO(this.f5098oIX0oI, this.f5097II0xO0);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class II0XooXoX<T> extends xoXoI.xoIox<T> {

        /* renamed from: oxoX, reason: collision with root package name */
        public final /* synthetic */ xoXoI.oOoXoXO f5100oxoX;

        public II0XooXoX(xoXoI.oOoXoXO oooxoxo) {
            this.f5100oxoX = oooxoxo;
        }

        @Override // xoXoI.xoIox
        public T oIX0oI(xoXoI.II0xO0<T> iI0xO0) {
            return (T) this.f5100oxoX.oIX0oI(iI0xO0);
        }
    }

    /* loaded from: classes.dex */
    public class II0xO0 implements Oxx0xo {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ boolean f5101I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ String f5102II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ String f5103oIX0oI;

        public II0xO0(String str, String str2, boolean z) {
            this.f5103oIX0oI = str;
            this.f5102II0xO0 = str2;
            this.f5101I0Io = z;
        }

        @Override // com.airbnb.lottie.xoIox.Oxx0xo
        public void oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
            xoIox.this.xoIxX(this.f5103oIX0oI, this.f5102II0xO0, this.f5101I0Io);
        }
    }

    /* loaded from: classes.dex */
    public class IXxxXO implements Oxx0xo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ String f5106oIX0oI;

        public IXxxXO(String str) {
            this.f5106oIX0oI = str;
        }

        @Override // com.airbnb.lottie.xoIox.Oxx0xo
        public void oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
            xoIox.this.I0oOIX(this.f5106oIX0oI);
        }
    }

    /* loaded from: classes.dex */
    public class OOXIXo implements Oxx0xo {
        public OOXIXo() {
        }

        @Override // com.airbnb.lottie.xoIox.Oxx0xo
        public void oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
            xoIox.this.oxXx0IX();
        }
    }

    /* loaded from: classes.dex */
    public class Oxx0IOOO implements Oxx0xo {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ xoXoI.xoIox f5108I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ Object f5109II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ x0xO0oo.oxoX f5110oIX0oI;

        public Oxx0IOOO(x0xO0oo.oxoX oxox, Object obj, xoXoI.xoIox xoiox) {
            this.f5110oIX0oI = oxox;
            this.f5109II0xO0 = obj;
            this.f5108I0Io = xoiox;
        }

        @Override // com.airbnb.lottie.xoIox.Oxx0xo
        public void oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
            xoIox.this.XO(this.f5110oIX0oI, this.f5109II0xO0, this.f5108I0Io);
        }
    }

    /* loaded from: classes.dex */
    public interface Oxx0xo {
        void oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO);
    }

    /* loaded from: classes.dex */
    public class X0o0xo implements Oxx0xo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ int f5113oIX0oI;

        public X0o0xo(int i) {
            this.f5113oIX0oI = i;
        }

        @Override // com.airbnb.lottie.xoIox.Oxx0xo
        public void oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
            xoIox.this.oX(this.f5113oIX0oI);
        }
    }

    /* loaded from: classes.dex */
    public class XO implements Oxx0xo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ float f5115oIX0oI;

        public XO(float f) {
            this.f5115oIX0oI = f;
        }

        @Override // com.airbnb.lottie.xoIox.Oxx0xo
        public void oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
            xoIox.this.o0xxxXXxX(this.f5115oIX0oI);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface oI0IIXIo {
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements Oxx0xo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ String f5117oIX0oI;

        public oIX0oI(String str) {
            this.f5117oIX0oI = str;
        }

        @Override // com.airbnb.lottie.xoIox.Oxx0xo
        public void oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
            xoIox.this.IoOoo(this.f5117oIX0oI);
        }
    }

    /* loaded from: classes.dex */
    public class oO implements Oxx0xo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ float f5119oIX0oI;

        public oO(float f) {
            this.f5119oIX0oI = f;
        }

        @Override // com.airbnb.lottie.xoIox.Oxx0xo
        public void oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
            xoIox.this.xoxXI(this.f5119oIX0oI);
        }
    }

    /* loaded from: classes.dex */
    public class oOoXoXO implements Oxx0xo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ int f5121oIX0oI;

        public oOoXoXO(int i) {
            this.f5121oIX0oI = i;
        }

        @Override // com.airbnb.lottie.xoIox.Oxx0xo
        public void oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
            xoIox.this.OO0x0xX(this.f5121oIX0oI);
        }
    }

    /* loaded from: classes.dex */
    public class ooOOo0oXI implements Oxx0xo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ float f5123oIX0oI;

        public ooOOo0oXI(float f) {
            this.f5123oIX0oI = f;
        }

        @Override // com.airbnb.lottie.xoIox.Oxx0xo
        public void oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
            xoIox.this.Ioxxx(this.f5123oIX0oI);
        }
    }

    /* loaded from: classes.dex */
    public class oxoX implements Oxx0xo {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ float f5125II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ float f5126oIX0oI;

        public oxoX(float f, float f2) {
            this.f5126oIX0oI = f;
            this.f5125II0xO0 = f2;
        }

        @Override // com.airbnb.lottie.xoIox.Oxx0xo
        public void oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
            xoIox.this.x0xO(this.f5126oIX0oI, this.f5125II0xO0);
        }
    }

    /* loaded from: classes.dex */
    public class x0XOIxOo implements Oxx0xo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ int f5128oIX0oI;

        public x0XOIxOo(int i) {
            this.f5128oIX0oI = i;
        }

        @Override // com.airbnb.lottie.xoIox.Oxx0xo
        public void oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
            xoIox.this.O0Xx(this.f5128oIX0oI);
        }
    }

    /* loaded from: classes.dex */
    public class x0xO0oo implements Oxx0xo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ String f5130oIX0oI;

        public x0xO0oo(String str) {
            this.f5130oIX0oI = str;
        }

        @Override // com.airbnb.lottie.xoIox.Oxx0xo
        public void oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
            xoIox.this.XIo0oOXIx(this.f5130oIX0oI);
        }
    }

    /* renamed from: com.airbnb.lottie.xoIox$xoIox, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0098xoIox implements Oxx0xo {
        public C0098xoIox() {
        }

        @Override // com.airbnb.lottie.xoIox.Oxx0xo
        public void oIX0oI(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
            xoIox.this.OI0();
        }
    }

    /* loaded from: classes.dex */
    public class xxIXOIIO implements ValueAnimator.AnimatorUpdateListener {
        public xxIXOIIO() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (xoIox.this.f5086XxX0x0xxx != null) {
                xoIox.this.f5086XxX0x0xxx.ooXIXxIX(xoIox.this.f5076IXxxXO.II0XooXoX());
            }
        }
    }

    public xoIox() {
        IIXOooo.Oxx0IOOO oxx0IOOO = new IIXOooo.Oxx0IOOO();
        this.f5076IXxxXO = oxx0IOOO;
        this.f5080Oxx0xo = 1.0f;
        this.f5088oI0IIXIo = true;
        this.f5081OxxIIOOXO = false;
        this.f5075IIXOooo = new ArrayList<>();
        xxIXOIIO xxixoiio = new xxIXOIIO();
        this.f5094xoXoI = xxixoiio;
        this.f5093xXxxox0I = 255;
        this.f5090oo0xXOI0I = true;
        this.f5089oo = false;
        oxx0IOOO.addUpdateListener(xxixoiio);
    }

    public void I0(Boolean bool) {
        this.f5088oI0IIXIo = bool.booleanValue();
    }

    public void I0Io(Animator.AnimatorListener animatorListener) {
        this.f5076IXxxXO.addListener(animatorListener);
    }

    public void I0X0x0oIo(com.airbnb.lottie.I0Io i0Io) {
        this.f5083XI0IXoo = i0Io;
        oO.oI0IIXIo oi0iixio = this.f5082X0IIOO;
        if (oi0iixio != null) {
            oi0iixio.oxoX(i0Io);
        }
    }

    public void I0oOIX(String str) {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f5078Oo;
        if (oxx0IOOO == null) {
            this.f5075IIXOooo.add(new IXxxXO(str));
            return;
        }
        x0xO0oo.Oxx0IOOO OOXIXo2 = oxx0IOOO.OOXIXo(str);
        if (OOXIXo2 != null) {
            O0Xx((int) (OOXIXo2.f34086II0xO0 + OOXIXo2.f34085I0Io));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + FileUtils.FILE_EXTENSION_SEPARATOR);
    }

    @RequiresApi(api = 19)
    public void I0oOoX(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f5076IXxxXO.removePauseListener(animatorPauseListener);
    }

    public final float II0XooXoX(Rect rect) {
        return rect.width() / rect.height();
    }

    public int IIX0o() {
        return this.f5076IXxxXO.getRepeatMode();
    }

    public final oO.oI0IIXIo IIXOooo() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f5082X0IIOO == null) {
            this.f5082X0IIOO = new oO.oI0IIXIo(getCallback(), this.f5083XI0IXoo);
        }
        return this.f5082X0IIOO;
    }

    public void IIxOXoOo0(float f) {
        this.f5076IXxxXO.X0IIOO(f);
    }

    public boolean IO() {
        if (this.f5076IXxxXO.getRepeatCount() == -1) {
            return true;
        }
        return false;
    }

    public boolean IXxxXO() {
        return this.f5095xxX;
    }

    public void Io() {
        this.f5076IXxxXO.removeAllListeners();
    }

    public boolean IoOoX() {
        com.airbnb.lottie.model.layer.II0xO0 iI0xO0 = this.f5086XxX0x0xxx;
        if (iI0xO0 != null && iI0xO0.oo()) {
            return true;
        }
        return false;
    }

    public void IoOoo(String str) {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f5078Oo;
        if (oxx0IOOO == null) {
            this.f5075IIXOooo.add(new oIX0oI(str));
            return;
        }
        x0xO0oo.Oxx0IOOO OOXIXo2 = oxx0IOOO.OOXIXo(str);
        if (OOXIXo2 != null) {
            int i = (int) OOXIXo2.f34086II0xO0;
            OO(i, ((int) OOXIXo2.f34085I0Io) + i);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + FileUtils.FILE_EXTENSION_SEPARATOR);
        }
    }

    public void Ioxxx(float f) {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f5078Oo;
        if (oxx0IOOO == null) {
            this.f5075IIXOooo.add(new ooOOo0oXI(f));
        } else {
            OO0x0xX((int) IIXOooo.xxIXOIIO.OOXIXo(oxx0IOOO.x0xO0oo(), this.f5078Oo.XO(), f));
        }
    }

    public void O00XxXI(int i) {
        this.f5076IXxxXO.setRepeatCount(i);
    }

    public void O0Xx(int i) {
        if (this.f5078Oo == null) {
            this.f5075IIXOooo.add(new x0XOIxOo(i));
        } else {
            this.f5076IXxxXO.o00(i + 0.99f);
        }
    }

    @Nullable
    public String O0xOxO() {
        return this.f5079OxI;
    }

    @MainThread
    public void OI0() {
        float X0IIOO2;
        if (this.f5086XxX0x0xxx == null) {
            this.f5075IIXOooo.add(new C0098xoIox());
            return;
        }
        if (this.f5088oI0IIXIo || xXxxox0I() == 0) {
            this.f5076IXxxXO.x0xO0oo();
        }
        if (!this.f5088oI0IIXIo) {
            if (xI() < 0.0f) {
                X0IIOO2 = XIxXXX0x0();
            } else {
                X0IIOO2 = X0IIOO();
            }
            oX((int) X0IIOO2);
            this.f5076IXxxXO.Oxx0IOOO();
        }
    }

    public void OO(int i, int i2) {
        if (this.f5078Oo == null) {
            this.f5075IIXOooo.add(new I0Io(i, i2));
        } else {
            this.f5076IXxxXO.OxI(i, i2 + 0.99f);
        }
    }

    public void OO0x0xX(int i) {
        if (this.f5078Oo == null) {
            this.f5075IIXOooo.add(new oOoXoXO(i));
        } else {
            this.f5076IXxxXO.O0xOxO(i);
        }
    }

    public void OOXIXo() {
        this.f5075IIXOooo.clear();
        this.f5076IXxxXO.cancel();
    }

    public void OOXIxO0(float f) {
        this.f5080Oxx0xo = f;
    }

    public boolean OX00O0xII() {
        if (this.f5084XIxXXX0x0 == null && this.f5078Oo.I0Io().size() > 0) {
            return true;
        }
        return false;
    }

    public void Oo(boolean z) {
        if (this.f5095xxX == z) {
            return;
        }
        this.f5095xxX = z;
        if (this.f5078Oo != null) {
            xoIox();
        }
    }

    public final oO.OxxIIOOXO OxI() {
        if (getCallback() == null) {
            return null;
        }
        oO.OxxIIOOXO oxxIIOOXO = this.f5087o00;
        if (oxxIIOOXO != null && !oxxIIOOXO.II0xO0(OxxIIOOXO())) {
            this.f5087o00 = null;
        }
        if (this.f5087o00 == null) {
            this.f5087o00 = new oO.OxxIIOOXO(getCallback(), this.f5079OxI, this.f5077O0xOxO, this.f5078Oo.xxIXOIIO());
        }
        return this.f5087o00;
    }

    public <T> void Oxx0IOOO(x0xO0oo.oxoX oxox, T t, xoXoI.oOoXoXO<T> oooxoxo) {
        XO(oxox, t, new II0XooXoX(oooxoxo));
    }

    @MainThread
    public void Oxx0xo() {
        this.f5075IIXOooo.clear();
        this.f5076IXxxXO.Oxx0IOOO();
    }

    @Nullable
    public final Context OxxIIOOXO() {
        Drawable.Callback callback = getCallback();
        if (callback == null || !(callback instanceof View)) {
            return null;
        }
        return ((View) callback).getContext();
    }

    public boolean X00IoxXI() {
        return this.f5092xI;
    }

    public float X0IIOO() {
        return this.f5076IXxxXO.OOXIXo();
    }

    public void X0o0xo(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f5076IXxxXO.addUpdateListener(animatorUpdateListener);
    }

    public final float XI0IXoo(@NonNull Canvas canvas) {
        return Math.min(canvas.getWidth() / this.f5078Oo.II0xO0().width(), canvas.getHeight() / this.f5078Oo.II0xO0().height());
    }

    public void XI0oooXX(boolean z) {
        this.f5081OxxIIOOXO = z;
    }

    public void XIo0oOXIx(String str) {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f5078Oo;
        if (oxx0IOOO == null) {
            this.f5075IIXOooo.add(new x0xO0oo(str));
            return;
        }
        x0xO0oo.Oxx0IOOO OOXIXo2 = oxx0IOOO.OOXIXo(str);
        if (OOXIXo2 != null) {
            OO0x0xX((int) OOXIXo2.f34086II0xO0);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + FileUtils.FILE_EXTENSION_SEPARATOR);
    }

    public float XIxXXX0x0() {
        return this.f5076IXxxXO.oOoXoXO();
    }

    public <T> void XO(x0xO0oo.oxoX oxox, T t, xoXoI.xoIox<T> xoiox) {
        com.airbnb.lottie.model.layer.II0xO0 iI0xO0 = this.f5086XxX0x0xxx;
        if (iI0xO0 == null) {
            this.f5075IIXOooo.add(new Oxx0IOOO(oxox, t, xoiox));
            return;
        }
        boolean z = true;
        if (oxox == x0xO0oo.oxoX.f34093I0Io) {
            iI0xO0.XO(t, xoiox);
        } else if (oxox.oxoX() != null) {
            oxox.oxoX().XO(t, xoiox);
        } else {
            List<x0xO0oo.oxoX> XoX2 = XoX(oxox);
            for (int i = 0; i < XoX2.size(); i++) {
                XoX2.get(i).oxoX().XO(t, xoiox);
            }
            z = true ^ XoX2.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t == com.airbnb.lottie.oO.f4974XIxXXX0x0) {
                o0xxxXXxX(XxX0x0xxx());
            }
        }
    }

    public void XOxIOxOx() {
        this.f5075IIXOooo.clear();
        this.f5076IXxxXO.oO();
    }

    public void XX(Animator.AnimatorListener animatorListener) {
        this.f5076IXxxXO.removeListener(animatorListener);
    }

    public boolean XX0(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
        if (this.f5078Oo == oxx0IOOO) {
            return false;
        }
        this.f5089oo = false;
        oOoXoXO();
        this.f5078Oo = oxx0IOOO;
        xoIox();
        this.f5076IXxxXO.IIXOooo(oxx0IOOO);
        o0xxxXXxX(this.f5076IXxxXO.getAnimatedFraction());
        OOXIxO0(this.f5080Oxx0xo);
        Iterator it = new ArrayList(this.f5075IIXOooo).iterator();
        while (it.hasNext()) {
            Oxx0xo oxx0xo = (Oxx0xo) it.next();
            if (oxx0xo != null) {
                oxx0xo.oIX0oI(oxx0IOOO);
            }
            it.remove();
        }
        this.f5075IIXOooo.clear();
        oxx0IOOO.o00(this.f5074IIX0o);
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
            return true;
        }
        return true;
    }

    public void XX0xXo(boolean z) {
        this.f5074IIX0o = z;
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f5078Oo;
        if (oxx0IOOO != null) {
            oxx0IOOO.o00(z);
        }
    }

    public void Xo0(com.airbnb.lottie.oxoX oxox) {
        this.f5077O0xOxO = oxox;
        oO.OxxIIOOXO oxxIIOOXO = this.f5087o00;
        if (oxxIIOOXO != null) {
            oxxIIOOXO.oxoX(oxox);
        }
    }

    public void XoI0Ixx0(@Nullable String str) {
        this.f5079OxI = str;
    }

    public List<x0xO0oo.oxoX> XoX(x0xO0oo.oxoX oxox) {
        if (this.f5086XxX0x0xxx == null) {
            IIXOooo.XO.X0o0xo("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f5086XxX0x0xxx.Oxx0IOOO(oxox, 0, arrayList, new x0xO0oo.oxoX(new String[0]));
        return arrayList;
    }

    public boolean Xx000oIo() {
        IIXOooo.Oxx0IOOO oxx0IOOO = this.f5076IXxxXO;
        if (oxx0IOOO == null) {
            return false;
        }
        return oxx0IOOO.isRunning();
    }

    @FloatRange(from = XIXIX.OOXIXo.f3760XO, to = 1.0d)
    public float XxX0x0xxx() {
        return this.f5076IXxxXO.II0XooXoX();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.f5089oo = false;
        com.airbnb.lottie.X0o0xo.oIX0oI("Drawable#draw");
        if (this.f5081OxxIIOOXO) {
            try {
                x0XOIxOo(canvas);
            } catch (Throwable th) {
                IIXOooo.XO.I0Io("Lottie crashed in draw!", th);
            }
        } else {
            x0XOIxOo(canvas);
        }
        com.airbnb.lottie.X0o0xo.II0xO0("Drawable#draw");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f5093xXxxox0I;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f5078Oo == null) {
            return -1;
        }
        return (int) (r0.II0xO0().height() * ooXIXxIX());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f5078Oo == null) {
            return -1;
        }
        return (int) (r0.II0xO0().width() * ooXIXxIX());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.f5089oo) {
            return;
        }
        this.f5089oo = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return Xx000oIo();
    }

    public void o0() {
        this.f5076IXxxXO.removeAllUpdateListeners();
        this.f5076IXxxXO.addUpdateListener(this.f5094xoXoI);
    }

    @Nullable
    public Bitmap o00(String str) {
        oO.OxxIIOOXO OxI2 = OxI();
        if (OxI2 != null) {
            return OxI2.oIX0oI(str);
        }
        return null;
    }

    public void o0xxxXXxX(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.f5078Oo == null) {
            this.f5075IIXOooo.add(new XO(f));
            return;
        }
        com.airbnb.lottie.X0o0xo.oIX0oI("Drawable#setProgress");
        this.f5076IXxxXO.xoXoI(IIXOooo.xxIXOIIO.OOXIXo(this.f5078Oo.x0xO0oo(), this.f5078Oo.XO(), f));
        com.airbnb.lottie.X0o0xo.II0xO0("Drawable#setProgress");
    }

    public com.airbnb.lottie.Oxx0IOOO oI0IIXIo() {
        return this.f5078Oo;
    }

    public final void oO(Canvas canvas) {
        float f;
        if (this.f5086XxX0x0xxx == null) {
            return;
        }
        Rect bounds = getBounds();
        float width = bounds.width() / this.f5078Oo.II0xO0().width();
        float height = bounds.height() / this.f5078Oo.II0xO0().height();
        int i = -1;
        if (this.f5090oo0xXOI0I) {
            float min = Math.min(width, height);
            if (min < 1.0f) {
                f = 1.0f / min;
                width /= f;
                height /= f;
            } else {
                f = 1.0f;
            }
            if (f > 1.0f) {
                i = canvas.save();
                float width2 = bounds.width() / 2.0f;
                float height2 = bounds.height() / 2.0f;
                float f2 = width2 * min;
                float f3 = min * height2;
                canvas.translate(width2 - f2, height2 - f3);
                canvas.scale(f, f, f2, f3);
            }
        }
        this.f5085XO.reset();
        this.f5085XO.preScale(width, height);
        this.f5086XxX0x0xxx.I0Io(canvas, this.f5085XO, this.f5093xXxxox0I);
        if (i > 0) {
            canvas.restoreToCount(i);
        }
    }

    public boolean oOXoIIIo() {
        com.airbnb.lottie.model.layer.II0xO0 iI0xO0 = this.f5086XxX0x0xxx;
        if (iI0xO0 != null && iI0xO0.IoOoX()) {
            return true;
        }
        return false;
    }

    public void oOoXoXO() {
        if (this.f5076IXxxXO.isRunning()) {
            this.f5076IXxxXO.cancel();
        }
        this.f5078Oo = null;
        this.f5086XxX0x0xxx = null;
        this.f5087o00 = null;
        this.f5076IXxxXO.XO();
        invalidateSelf();
    }

    public void oX(int i) {
        if (this.f5078Oo == null) {
            this.f5075IIXOooo.add(new X0o0xo(i));
        } else {
            this.f5076IXxxXO.xoXoI(i);
        }
    }

    @Nullable
    public Typeface oo(String str, String str2) {
        oO.oI0IIXIo IIXOooo2 = IIXOooo();
        if (IIXOooo2 != null) {
            return IIXOooo2.II0xO0(str, str2);
        }
        return null;
    }

    @Nullable
    public IIXOooo oo0xXOI0I() {
        return this.f5084XIxXXX0x0;
    }

    public void ooOOo0oXI() {
        this.f5090oo0xXOI0I = false;
    }

    public void ooOx(IIXOooo iIXOooo) {
        this.f5084XIxXXX0x0 = iIXOooo;
    }

    public float ooXIXxIX() {
        return this.f5080Oxx0xo;
    }

    public void ox(int i) {
        this.f5076IXxxXO.setRepeatMode(i);
    }

    @MainThread
    public void oxXx0IX() {
        float X0IIOO2;
        if (this.f5086XxX0x0xxx == null) {
            this.f5075IIXOooo.add(new OOXIXo());
            return;
        }
        if (this.f5088oI0IIXIo || xXxxox0I() == 0) {
            this.f5076IXxxXO.oI0IIXIo();
        }
        if (!this.f5088oI0IIXIo) {
            if (xI() < 0.0f) {
                X0IIOO2 = XIxXXX0x0();
            } else {
                X0IIOO2 = X0IIOO();
            }
            oX((int) X0IIOO2);
            this.f5076IXxxXO.Oxx0IOOO();
        }
    }

    @RequiresApi(api = 19)
    public void oxoX(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f5076IXxxXO.addPauseListener(animatorPauseListener);
    }

    public void oxxXoxO(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f5076IXxxXO.removeUpdateListener(animatorUpdateListener);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.f5093xXxxox0I = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IIXOooo.XO.X0o0xo("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && !((View) callback).isInEditMode()) {
            OI0();
        }
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        Oxx0xo();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public final void x0XOIxOo(@NonNull Canvas canvas) {
        if (!xxIXOIIO()) {
            oO(canvas);
        } else {
            x0xO0oo(canvas);
        }
    }

    @Deprecated
    public void x0o(boolean z) {
        int i;
        IIXOooo.Oxx0IOOO oxx0IOOO = this.f5076IXxxXO;
        if (z) {
            i = -1;
        } else {
            i = 0;
        }
        oxx0IOOO.setRepeatCount(i);
    }

    public void x0xO(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f5078Oo;
        if (oxx0IOOO == null) {
            this.f5075IIXOooo.add(new oxoX(f, f2));
        } else {
            OO((int) IIXOooo.xxIXOIIO.OOXIXo(oxx0IOOO.x0xO0oo(), this.f5078Oo.XO(), f), (int) IIXOooo.xxIXOIIO.OOXIXo(this.f5078Oo.x0xO0oo(), this.f5078Oo.XO(), f2));
        }
    }

    public final void x0xO0oo(Canvas canvas) {
        float f;
        int i;
        if (this.f5086XxX0x0xxx == null) {
            return;
        }
        float f2 = this.f5080Oxx0xo;
        float XI0IXoo2 = XI0IXoo(canvas);
        if (f2 > XI0IXoo2) {
            f = this.f5080Oxx0xo / XI0IXoo2;
        } else {
            XI0IXoo2 = f2;
            f = 1.0f;
        }
        if (f > 1.0f) {
            i = canvas.save();
            float width = this.f5078Oo.II0xO0().width() / 2.0f;
            float height = this.f5078Oo.II0xO0().height() / 2.0f;
            float f3 = width * XI0IXoo2;
            float f4 = height * XI0IXoo2;
            canvas.translate((ooXIXxIX() * width) - f3, (ooXIXxIX() * height) - f4);
            canvas.scale(f, f, f3, f4);
        } else {
            i = -1;
        }
        this.f5085XO.reset();
        this.f5085XO.preScale(XI0IXoo2, XI0IXoo2);
        this.f5086XxX0x0xxx.I0Io(canvas, this.f5085XO, this.f5093xXxxox0I);
        if (i > 0) {
            canvas.restoreToCount(i);
        }
    }

    public float xI() {
        return this.f5076IXxxXO.ooOOo0oXI();
    }

    public boolean xII() {
        return this.f5095xxX;
    }

    public void xXOx(boolean z) {
        this.f5092xI = z;
    }

    public int xXxxox0I() {
        return this.f5076IXxxXO.getRepeatCount();
    }

    public void xo0x() {
        this.f5076IXxxXO.OxxIIOOXO();
    }

    public final void xoIox() {
        com.airbnb.lottie.model.layer.II0xO0 iI0xO0 = new com.airbnb.lottie.model.layer.II0xO0(this, OxxIIOOXO.oI0IIXIo.oIX0oI(this.f5078Oo), this.f5078Oo.xoIox(), this.f5078Oo);
        this.f5086XxX0x0xxx = iI0xO0;
        if (this.f5091ooXIXxIX) {
            iI0xO0.xXxxox0I(true);
        }
    }

    public void xoIxX(String str, String str2, boolean z) {
        float f;
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f5078Oo;
        if (oxx0IOOO == null) {
            this.f5075IIXOooo.add(new II0xO0(str, str2, z));
            return;
        }
        x0xO0oo.Oxx0IOOO OOXIXo2 = oxx0IOOO.OOXIXo(str);
        if (OOXIXo2 != null) {
            int i = (int) OOXIXo2.f34086II0xO0;
            x0xO0oo.Oxx0IOOO OOXIXo3 = this.f5078Oo.OOXIXo(str2);
            if (OOXIXo3 != null) {
                float f2 = OOXIXo3.f34086II0xO0;
                if (z) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                OO(i, (int) (f2 + f));
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + FileUtils.FILE_EXTENSION_SEPARATOR);
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + FileUtils.FILE_EXTENSION_SEPARATOR);
    }

    @Nullable
    public Bitmap xoO0xx0(String str, @Nullable Bitmap bitmap) {
        oO.OxxIIOOXO OxI2 = OxI();
        if (OxI2 == null) {
            IIXOooo.XO.X0o0xo("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap X0o0xo2 = OxI2.X0o0xo(str, bitmap);
        invalidateSelf();
        return X0o0xo2;
    }

    public int xoXoI() {
        return (int) this.f5076IXxxXO.xxIXOIIO();
    }

    public void xoxXI(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f5078Oo;
        if (oxx0IOOO == null) {
            this.f5075IIXOooo.add(new oO(f));
        } else {
            O0Xx((int) IIXOooo.xxIXOIIO.OOXIXo(oxx0IOOO.x0xO0oo(), this.f5078Oo.XO(), f));
        }
    }

    public void xxIO(boolean z) {
        if (this.f5091ooXIXxIX == z) {
            return;
        }
        this.f5091ooXIXxIX = z;
        com.airbnb.lottie.model.layer.II0xO0 iI0xO0 = this.f5086XxX0x0xxx;
        if (iI0xO0 != null) {
            iI0xO0.xXxxox0I(z);
        }
    }

    public final boolean xxIXOIIO() {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f5078Oo;
        if (oxx0IOOO == null || getBounds().isEmpty() || II0XooXoX(getBounds()) == II0XooXoX(oxx0IOOO.II0xO0())) {
            return true;
        }
        return false;
    }

    @Nullable
    public com.airbnb.lottie.oI0IIXIo xxX() {
        com.airbnb.lottie.Oxx0IOOO oxx0IOOO = this.f5078Oo;
        if (oxx0IOOO != null) {
            return oxx0IOOO.x0XOIxOo();
        }
        return null;
    }
}
