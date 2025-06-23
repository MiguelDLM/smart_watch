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
import oO.OxxIIOOXO;

public class xoIox extends Drawable implements Drawable.Callback, Animatable {

    /* renamed from: IoOoX  reason: collision with root package name */
    public static final int f1077IoOoX = 1;

    /* renamed from: Xx000oIo  reason: collision with root package name */
    public static final int f1078Xx000oIo = -1;

    /* renamed from: oOXoIIIo  reason: collision with root package name */
    public static final int f1079oOXoIIIo = 2;

    /* renamed from: IIX0o  reason: collision with root package name */
    public boolean f1080IIX0o;

    /* renamed from: IIXOooo  reason: collision with root package name */
    public final ArrayList<Oxx0xo> f1081IIXOooo;

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final IIXOooo.Oxx0IOOO f1082IXxxXO;
    @Nullable

    /* renamed from: O0xOxO  reason: collision with root package name */
    public oxoX f1083O0xOxO;

    /* renamed from: Oo  reason: collision with root package name */
    public Oxx0IOOO f1084Oo;
    @Nullable

    /* renamed from: OxI  reason: collision with root package name */
    public String f1085OxI;

    /* renamed from: Oxx0xo  reason: collision with root package name */
    public float f1086Oxx0xo;

    /* renamed from: OxxIIOOXO  reason: collision with root package name */
    public boolean f1087OxxIIOOXO;
    @Nullable

    /* renamed from: X0IIOO  reason: collision with root package name */
    public oO.oI0IIXIo f1088X0IIOO;
    @Nullable

    /* renamed from: XI0IXoo  reason: collision with root package name */
    public I0Io f1089XI0IXoo;
    @Nullable

    /* renamed from: XIxXXX0x0  reason: collision with root package name */
    public IIXOooo f1090XIxXXX0x0;

    /* renamed from: XO  reason: collision with root package name */
    public final Matrix f1091XO = new Matrix();
    @Nullable

    /* renamed from: XxX0x0xxx  reason: collision with root package name */
    public com.airbnb.lottie.model.layer.II0xO0 f1092XxX0x0xxx;
    @Nullable

    /* renamed from: o00  reason: collision with root package name */
    public OxxIIOOXO f1093o00;

    /* renamed from: oI0IIXIo  reason: collision with root package name */
    public boolean f1094oI0IIXIo;

    /* renamed from: oo  reason: collision with root package name */
    public boolean f1095oo;

    /* renamed from: oo0xXOI0I  reason: collision with root package name */
    public boolean f1096oo0xXOI0I;

    /* renamed from: ooXIXxIX  reason: collision with root package name */
    public boolean f1097ooXIXxIX;

    /* renamed from: xI  reason: collision with root package name */
    public boolean f1098xI;

    /* renamed from: xXxxox0I  reason: collision with root package name */
    public int f1099xXxxox0I;

    /* renamed from: xoXoI  reason: collision with root package name */
    public final ValueAnimator.AnimatorUpdateListener f1100xoXoI;

    /* renamed from: xxX  reason: collision with root package name */
    public boolean f1101xxX;

    public class I0Io implements Oxx0xo {

        /* renamed from: II0xO0  reason: collision with root package name */
        public final /* synthetic */ int f1103II0xO0;

        /* renamed from: oIX0oI  reason: collision with root package name */
        public final /* synthetic */ int f1104oIX0oI;

        public I0Io(int i, int i2) {
            this.f1104oIX0oI = i;
            this.f1103II0xO0 = i2;
        }

        public void oIX0oI(Oxx0IOOO oxx0IOOO) {
            xoIox.this.OO(this.f1104oIX0oI, this.f1103II0xO0);
        }
    }

    public class II0XooXoX extends xoXoI.xoIox<T> {

        /* renamed from: oxoX  reason: collision with root package name */
        public final /* synthetic */ xoXoI.oOoXoXO f1106oxoX;

        public II0XooXoX(xoXoI.oOoXoXO oooxoxo) {
            this.f1106oxoX = oooxoxo;
        }

        public T oIX0oI(xoXoI.II0xO0<T> iI0xO0) {
            return this.f1106oxoX.oIX0oI(iI0xO0);
        }
    }

    public class II0xO0 implements Oxx0xo {

        /* renamed from: I0Io  reason: collision with root package name */
        public final /* synthetic */ boolean f1107I0Io;

        /* renamed from: II0xO0  reason: collision with root package name */
        public final /* synthetic */ String f1108II0xO0;

        /* renamed from: oIX0oI  reason: collision with root package name */
        public final /* synthetic */ String f1109oIX0oI;

        public II0xO0(String str, String str2, boolean z) {
            this.f1109oIX0oI = str;
            this.f1108II0xO0 = str2;
            this.f1107I0Io = z;
        }

        public void oIX0oI(Oxx0IOOO oxx0IOOO) {
            xoIox.this.xoIxX(this.f1109oIX0oI, this.f1108II0xO0, this.f1107I0Io);
        }
    }

    public class IXxxXO implements Oxx0xo {

        /* renamed from: oIX0oI  reason: collision with root package name */
        public final /* synthetic */ String f1112oIX0oI;

        public IXxxXO(String str) {
            this.f1112oIX0oI = str;
        }

        public void oIX0oI(Oxx0IOOO oxx0IOOO) {
            xoIox.this.I0oOIX(this.f1112oIX0oI);
        }
    }

    public class OOXIXo implements Oxx0xo {
        public OOXIXo() {
        }

        public void oIX0oI(Oxx0IOOO oxx0IOOO) {
            xoIox.this.oxXx0IX();
        }
    }

    public class Oxx0IOOO implements Oxx0xo {

        /* renamed from: I0Io  reason: collision with root package name */
        public final /* synthetic */ xoXoI.xoIox f1114I0Io;

        /* renamed from: II0xO0  reason: collision with root package name */
        public final /* synthetic */ Object f1115II0xO0;

        /* renamed from: oIX0oI  reason: collision with root package name */
        public final /* synthetic */ x0xO0oo.oxoX f1116oIX0oI;

        public Oxx0IOOO(x0xO0oo.oxoX oxox, Object obj, xoXoI.xoIox xoiox) {
            this.f1116oIX0oI = oxox;
            this.f1115II0xO0 = obj;
            this.f1114I0Io = xoiox;
        }

        public void oIX0oI(Oxx0IOOO oxx0IOOO) {
            xoIox.this.XO(this.f1116oIX0oI, this.f1115II0xO0, this.f1114I0Io);
        }
    }

    public interface Oxx0xo {
        void oIX0oI(Oxx0IOOO oxx0IOOO);
    }

    public class X0o0xo implements Oxx0xo {

        /* renamed from: oIX0oI  reason: collision with root package name */
        public final /* synthetic */ int f1119oIX0oI;

        public X0o0xo(int i) {
            this.f1119oIX0oI = i;
        }

        public void oIX0oI(Oxx0IOOO oxx0IOOO) {
            xoIox.this.oX(this.f1119oIX0oI);
        }
    }

    public class XO implements Oxx0xo {

        /* renamed from: oIX0oI  reason: collision with root package name */
        public final /* synthetic */ float f1121oIX0oI;

        public XO(float f) {
            this.f1121oIX0oI = f;
        }

        public void oIX0oI(Oxx0IOOO oxx0IOOO) {
            xoIox.this.o0xxxXXxX(this.f1121oIX0oI);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface oI0IIXIo {
    }

    public class oIX0oI implements Oxx0xo {

        /* renamed from: oIX0oI  reason: collision with root package name */
        public final /* synthetic */ String f1123oIX0oI;

        public oIX0oI(String str) {
            this.f1123oIX0oI = str;
        }

        public void oIX0oI(Oxx0IOOO oxx0IOOO) {
            xoIox.this.IoOoo(this.f1123oIX0oI);
        }
    }

    public class oO implements Oxx0xo {

        /* renamed from: oIX0oI  reason: collision with root package name */
        public final /* synthetic */ float f1125oIX0oI;

        public oO(float f) {
            this.f1125oIX0oI = f;
        }

        public void oIX0oI(Oxx0IOOO oxx0IOOO) {
            xoIox.this.xoxXI(this.f1125oIX0oI);
        }
    }

    public class oOoXoXO implements Oxx0xo {

        /* renamed from: oIX0oI  reason: collision with root package name */
        public final /* synthetic */ int f1127oIX0oI;

        public oOoXoXO(int i) {
            this.f1127oIX0oI = i;
        }

        public void oIX0oI(Oxx0IOOO oxx0IOOO) {
            xoIox.this.OO0x0xX(this.f1127oIX0oI);
        }
    }

    public class ooOOo0oXI implements Oxx0xo {

        /* renamed from: oIX0oI  reason: collision with root package name */
        public final /* synthetic */ float f1129oIX0oI;

        public ooOOo0oXI(float f) {
            this.f1129oIX0oI = f;
        }

        public void oIX0oI(Oxx0IOOO oxx0IOOO) {
            xoIox.this.Ioxxx(this.f1129oIX0oI);
        }
    }

    public class oxoX implements Oxx0xo {

        /* renamed from: II0xO0  reason: collision with root package name */
        public final /* synthetic */ float f1131II0xO0;

        /* renamed from: oIX0oI  reason: collision with root package name */
        public final /* synthetic */ float f1132oIX0oI;

        public oxoX(float f, float f2) {
            this.f1132oIX0oI = f;
            this.f1131II0xO0 = f2;
        }

        public void oIX0oI(Oxx0IOOO oxx0IOOO) {
            xoIox.this.x0xO(this.f1132oIX0oI, this.f1131II0xO0);
        }
    }

    public class x0XOIxOo implements Oxx0xo {

        /* renamed from: oIX0oI  reason: collision with root package name */
        public final /* synthetic */ int f1134oIX0oI;

        public x0XOIxOo(int i) {
            this.f1134oIX0oI = i;
        }

        public void oIX0oI(Oxx0IOOO oxx0IOOO) {
            xoIox.this.O0Xx(this.f1134oIX0oI);
        }
    }

    public class x0xO0oo implements Oxx0xo {

        /* renamed from: oIX0oI  reason: collision with root package name */
        public final /* synthetic */ String f1136oIX0oI;

        public x0xO0oo(String str) {
            this.f1136oIX0oI = str;
        }

        public void oIX0oI(Oxx0IOOO oxx0IOOO) {
            xoIox.this.XIo0oOXIx(this.f1136oIX0oI);
        }
    }

    /* renamed from: com.airbnb.lottie.xoIox$xoIox  reason: collision with other inner class name */
    public class C0018xoIox implements Oxx0xo {
        public C0018xoIox() {
        }

        public void oIX0oI(Oxx0IOOO oxx0IOOO) {
            xoIox.this.OI0();
        }
    }

    public class xxIXOIIO implements ValueAnimator.AnimatorUpdateListener {
        public xxIXOIIO() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (xoIox.this.f1092XxX0x0xxx != null) {
                xoIox.this.f1092XxX0x0xxx.ooXIXxIX(xoIox.this.f1082IXxxXO.II0XooXoX());
            }
        }
    }

    public xoIox() {
        IIXOooo.Oxx0IOOO oxx0IOOO = new IIXOooo.Oxx0IOOO();
        this.f1082IXxxXO = oxx0IOOO;
        this.f1086Oxx0xo = 1.0f;
        this.f1094oI0IIXIo = true;
        this.f1087OxxIIOOXO = false;
        this.f1081IIXOooo = new ArrayList<>();
        xxIXOIIO xxixoiio = new xxIXOIIO();
        this.f1100xoXoI = xxixoiio;
        this.f1099xXxxox0I = 255;
        this.f1096oo0xXOI0I = true;
        this.f1095oo = false;
        oxx0IOOO.addUpdateListener(xxixoiio);
    }

    public void I0(Boolean bool) {
        this.f1094oI0IIXIo = bool.booleanValue();
    }

    public void I0Io(Animator.AnimatorListener animatorListener) {
        this.f1082IXxxXO.addListener(animatorListener);
    }

    public void I0X0x0oIo(I0Io i0Io) {
        this.f1089XI0IXoo = i0Io;
        oO.oI0IIXIo oi0iixio = this.f1088X0IIOO;
        if (oi0iixio != null) {
            oi0iixio.oxoX(i0Io);
        }
    }

    public void I0oOIX(String str) {
        Oxx0IOOO oxx0IOOO = this.f1084Oo;
        if (oxx0IOOO == null) {
            this.f1081IIXOooo.add(new IXxxXO(str));
            return;
        }
        x0xO0oo.Oxx0IOOO OOXIXo2 = oxx0IOOO.OOXIXo(str);
        if (OOXIXo2 != null) {
            O0Xx((int) (OOXIXo2.f1423II0xO0 + OOXIXo2.f1422I0Io));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + FileUtils.FILE_EXTENSION_SEPARATOR);
    }

    @RequiresApi(api = 19)
    public void I0oOoX(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f1082IXxxXO.removePauseListener(animatorPauseListener);
    }

    public final float II0XooXoX(Rect rect) {
        return ((float) rect.width()) / ((float) rect.height());
    }

    public int IIX0o() {
        return this.f1082IXxxXO.getRepeatMode();
    }

    public final oO.oI0IIXIo IIXOooo() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f1088X0IIOO == null) {
            this.f1088X0IIOO = new oO.oI0IIXIo(getCallback(), this.f1089XI0IXoo);
        }
        return this.f1088X0IIOO;
    }

    public void IIxOXoOo0(float f) {
        this.f1082IXxxXO.X0IIOO(f);
    }

    public boolean IO() {
        if (this.f1082IXxxXO.getRepeatCount() == -1) {
            return true;
        }
        return false;
    }

    public boolean IXxxXO() {
        return this.f1101xxX;
    }

    public void Io() {
        this.f1082IXxxXO.removeAllListeners();
    }

    public boolean IoOoX() {
        com.airbnb.lottie.model.layer.II0xO0 iI0xO0 = this.f1092XxX0x0xxx;
        if (iI0xO0 == null || !iI0xO0.oo()) {
            return false;
        }
        return true;
    }

    public void IoOoo(String str) {
        Oxx0IOOO oxx0IOOO = this.f1084Oo;
        if (oxx0IOOO == null) {
            this.f1081IIXOooo.add(new oIX0oI(str));
            return;
        }
        x0xO0oo.Oxx0IOOO OOXIXo2 = oxx0IOOO.OOXIXo(str);
        if (OOXIXo2 != null) {
            int i = (int) OOXIXo2.f1423II0xO0;
            OO(i, ((int) OOXIXo2.f1422I0Io) + i);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + FileUtils.FILE_EXTENSION_SEPARATOR);
    }

    public void Ioxxx(float f) {
        Oxx0IOOO oxx0IOOO = this.f1084Oo;
        if (oxx0IOOO == null) {
            this.f1081IIXOooo.add(new ooOOo0oXI(f));
        } else {
            OO0x0xX((int) IIXOooo.xxIXOIIO.OOXIXo(oxx0IOOO.x0xO0oo(), this.f1084Oo.XO(), f));
        }
    }

    public void O00XxXI(int i) {
        this.f1082IXxxXO.setRepeatCount(i);
    }

    public void O0Xx(int i) {
        if (this.f1084Oo == null) {
            this.f1081IIXOooo.add(new x0XOIxOo(i));
        } else {
            this.f1082IXxxXO.o00(((float) i) + 0.99f);
        }
    }

    @Nullable
    public String O0xOxO() {
        return this.f1085OxI;
    }

    @MainThread
    public void OI0() {
        float f;
        if (this.f1092XxX0x0xxx == null) {
            this.f1081IIXOooo.add(new C0018xoIox());
            return;
        }
        if (this.f1094oI0IIXIo || xXxxox0I() == 0) {
            this.f1082IXxxXO.x0xO0oo();
        }
        if (!this.f1094oI0IIXIo) {
            if (xI() < 0.0f) {
                f = XIxXXX0x0();
            } else {
                f = X0IIOO();
            }
            oX((int) f);
            this.f1082IXxxXO.Oxx0IOOO();
        }
    }

    public void OO(int i, int i2) {
        if (this.f1084Oo == null) {
            this.f1081IIXOooo.add(new I0Io(i, i2));
        } else {
            this.f1082IXxxXO.OxI((float) i, ((float) i2) + 0.99f);
        }
    }

    public void OO0x0xX(int i) {
        if (this.f1084Oo == null) {
            this.f1081IIXOooo.add(new oOoXoXO(i));
        } else {
            this.f1082IXxxXO.O0xOxO(i);
        }
    }

    public void OOXIXo() {
        this.f1081IIXOooo.clear();
        this.f1082IXxxXO.cancel();
    }

    public void OOXIxO0(float f) {
        this.f1086Oxx0xo = f;
    }

    public boolean OX00O0xII() {
        if (this.f1090XIxXXX0x0 != null || this.f1084Oo.I0Io().size() <= 0) {
            return false;
        }
        return true;
    }

    public void Oo(boolean z) {
        if (this.f1101xxX != z) {
            this.f1101xxX = z;
            if (this.f1084Oo != null) {
                xoIox();
            }
        }
    }

    public final OxxIIOOXO OxI() {
        if (getCallback() == null) {
            return null;
        }
        OxxIIOOXO oxxIIOOXO = this.f1093o00;
        if (oxxIIOOXO != null && !oxxIIOOXO.II0xO0(OxxIIOOXO())) {
            this.f1093o00 = null;
        }
        if (this.f1093o00 == null) {
            this.f1093o00 = new OxxIIOOXO(getCallback(), this.f1085OxI, this.f1083O0xOxO, this.f1084Oo.xxIXOIIO());
        }
        return this.f1093o00;
    }

    public <T> void Oxx0IOOO(x0xO0oo.oxoX oxox, T t, xoXoI.oOoXoXO<T> oooxoxo) {
        XO(oxox, t, new II0XooXoX(oooxoxo));
    }

    @MainThread
    public void Oxx0xo() {
        this.f1081IIXOooo.clear();
        this.f1082IXxxXO.Oxx0IOOO();
    }

    @Nullable
    public final Context OxxIIOOXO() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public boolean X00IoxXI() {
        return this.f1098xI;
    }

    public float X0IIOO() {
        return this.f1082IXxxXO.OOXIXo();
    }

    public void X0o0xo(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f1082IXxxXO.addUpdateListener(animatorUpdateListener);
    }

    public final float XI0IXoo(@NonNull Canvas canvas) {
        return Math.min(((float) canvas.getWidth()) / ((float) this.f1084Oo.II0xO0().width()), ((float) canvas.getHeight()) / ((float) this.f1084Oo.II0xO0().height()));
    }

    public void XI0oooXX(boolean z) {
        this.f1087OxxIIOOXO = z;
    }

    public void XIo0oOXIx(String str) {
        Oxx0IOOO oxx0IOOO = this.f1084Oo;
        if (oxx0IOOO == null) {
            this.f1081IIXOooo.add(new x0xO0oo(str));
            return;
        }
        x0xO0oo.Oxx0IOOO OOXIXo2 = oxx0IOOO.OOXIXo(str);
        if (OOXIXo2 != null) {
            OO0x0xX((int) OOXIXo2.f1423II0xO0);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + FileUtils.FILE_EXTENSION_SEPARATOR);
    }

    public float XIxXXX0x0() {
        return this.f1082IXxxXO.oOoXoXO();
    }

    public <T> void XO(x0xO0oo.oxoX oxox, T t, xoXoI.xoIox<T> xoiox) {
        com.airbnb.lottie.model.layer.II0xO0 iI0xO0 = this.f1092XxX0x0xxx;
        if (iI0xO0 == null) {
            this.f1081IIXOooo.add(new Oxx0IOOO(oxox, t, xoiox));
            return;
        }
        boolean z = true;
        if (oxox == x0xO0oo.oxoX.f1430I0Io) {
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
            if (t == oO.f980XIxXXX0x0) {
                o0xxxXXxX(XxX0x0xxx());
            }
        }
    }

    public void XOxIOxOx() {
        this.f1081IIXOooo.clear();
        this.f1082IXxxXO.oO();
    }

    public void XX(Animator.AnimatorListener animatorListener) {
        this.f1082IXxxXO.removeListener(animatorListener);
    }

    public boolean XX0(Oxx0IOOO oxx0IOOO) {
        if (this.f1084Oo == oxx0IOOO) {
            return false;
        }
        this.f1095oo = false;
        oOoXoXO();
        this.f1084Oo = oxx0IOOO;
        xoIox();
        this.f1082IXxxXO.IIXOooo(oxx0IOOO);
        o0xxxXXxX(this.f1082IXxxXO.getAnimatedFraction());
        OOXIxO0(this.f1086Oxx0xo);
        Iterator it = new ArrayList(this.f1081IIXOooo).iterator();
        while (it.hasNext()) {
            Oxx0xo oxx0xo = (Oxx0xo) it.next();
            if (oxx0xo != null) {
                oxx0xo.oIX0oI(oxx0IOOO);
            }
            it.remove();
        }
        this.f1081IIXOooo.clear();
        oxx0IOOO.o00(this.f1080IIX0o);
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof ImageView)) {
            return true;
        }
        ImageView imageView = (ImageView) callback;
        imageView.setImageDrawable((Drawable) null);
        imageView.setImageDrawable(this);
        return true;
    }

    public void XX0xXo(boolean z) {
        this.f1080IIX0o = z;
        Oxx0IOOO oxx0IOOO = this.f1084Oo;
        if (oxx0IOOO != null) {
            oxx0IOOO.o00(z);
        }
    }

    public void Xo0(oxoX oxox) {
        this.f1083O0xOxO = oxox;
        OxxIIOOXO oxxIIOOXO = this.f1093o00;
        if (oxxIIOOXO != null) {
            oxxIIOOXO.oxoX(oxox);
        }
    }

    public void XoI0Ixx0(@Nullable String str) {
        this.f1085OxI = str;
    }

    public List<x0xO0oo.oxoX> XoX(x0xO0oo.oxoX oxox) {
        if (this.f1092XxX0x0xxx == null) {
            IIXOooo.XO.X0o0xo("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f1092XxX0x0xxx.Oxx0IOOO(oxox, 0, arrayList, new x0xO0oo.oxoX(new String[0]));
        return arrayList;
    }

    public boolean Xx000oIo() {
        IIXOooo.Oxx0IOOO oxx0IOOO = this.f1082IXxxXO;
        if (oxx0IOOO == null) {
            return false;
        }
        return oxx0IOOO.isRunning();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float XxX0x0xxx() {
        return this.f1082IXxxXO.II0XooXoX();
    }

    public void draw(@NonNull Canvas canvas) {
        this.f1095oo = false;
        X0o0xo.oIX0oI("Drawable#draw");
        if (this.f1087OxxIIOOXO) {
            try {
                x0XOIxOo(canvas);
            } catch (Throwable th) {
                IIXOooo.XO.I0Io("Lottie crashed in draw!", th);
            }
        } else {
            x0XOIxOo(canvas);
        }
        X0o0xo.II0xO0("Drawable#draw");
    }

    public int getAlpha() {
        return this.f1099xXxxox0I;
    }

    public int getIntrinsicHeight() {
        Oxx0IOOO oxx0IOOO = this.f1084Oo;
        if (oxx0IOOO == null) {
            return -1;
        }
        return (int) (((float) oxx0IOOO.II0xO0().height()) * ooXIXxIX());
    }

    public int getIntrinsicWidth() {
        Oxx0IOOO oxx0IOOO = this.f1084Oo;
        if (oxx0IOOO == null) {
            return -1;
        }
        return (int) (((float) oxx0IOOO.II0xO0().width()) * ooXIXxIX());
    }

    public int getOpacity() {
        return -3;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void invalidateSelf() {
        if (!this.f1095oo) {
            this.f1095oo = true;
            Drawable.Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public boolean isRunning() {
        return Xx000oIo();
    }

    public void o0() {
        this.f1082IXxxXO.removeAllUpdateListeners();
        this.f1082IXxxXO.addUpdateListener(this.f1100xoXoI);
    }

    @Nullable
    public Bitmap o00(String str) {
        OxxIIOOXO OxI2 = OxI();
        if (OxI2 != null) {
            return OxI2.oIX0oI(str);
        }
        return null;
    }

    public void o0xxxXXxX(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.f1084Oo == null) {
            this.f1081IIXOooo.add(new XO(f));
            return;
        }
        X0o0xo.oIX0oI("Drawable#setProgress");
        this.f1082IXxxXO.xoXoI(IIXOooo.xxIXOIIO.OOXIXo(this.f1084Oo.x0xO0oo(), this.f1084Oo.XO(), f));
        X0o0xo.II0xO0("Drawable#setProgress");
    }

    public Oxx0IOOO oI0IIXIo() {
        return this.f1084Oo;
    }

    public final void oO(Canvas canvas) {
        float f;
        if (this.f1092XxX0x0xxx != null) {
            Rect bounds = getBounds();
            float width = ((float) bounds.width()) / ((float) this.f1084Oo.II0xO0().width());
            float height = ((float) bounds.height()) / ((float) this.f1084Oo.II0xO0().height());
            int i = -1;
            if (this.f1096oo0xXOI0I) {
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
                    float width2 = ((float) bounds.width()) / 2.0f;
                    float height2 = ((float) bounds.height()) / 2.0f;
                    float f2 = width2 * min;
                    float f3 = min * height2;
                    canvas.translate(width2 - f2, height2 - f3);
                    canvas.scale(f, f, f2, f3);
                }
            }
            this.f1091XO.reset();
            this.f1091XO.preScale(width, height);
            this.f1092XxX0x0xxx.I0Io(canvas, this.f1091XO, this.f1099xXxxox0I);
            if (i > 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    public boolean oOXoIIIo() {
        com.airbnb.lottie.model.layer.II0xO0 iI0xO0 = this.f1092XxX0x0xxx;
        if (iI0xO0 == null || !iI0xO0.IoOoX()) {
            return false;
        }
        return true;
    }

    public void oOoXoXO() {
        if (this.f1082IXxxXO.isRunning()) {
            this.f1082IXxxXO.cancel();
        }
        this.f1084Oo = null;
        this.f1092XxX0x0xxx = null;
        this.f1093o00 = null;
        this.f1082IXxxXO.XO();
        invalidateSelf();
    }

    public void oX(int i) {
        if (this.f1084Oo == null) {
            this.f1081IIXOooo.add(new X0o0xo(i));
        } else {
            this.f1082IXxxXO.xoXoI((float) i);
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
        return this.f1090XIxXXX0x0;
    }

    public void ooOOo0oXI() {
        this.f1096oo0xXOI0I = false;
    }

    public void ooOx(IIXOooo iIXOooo) {
        this.f1090XIxXXX0x0 = iIXOooo;
    }

    public float ooXIXxIX() {
        return this.f1086Oxx0xo;
    }

    public void ox(int i) {
        this.f1082IXxxXO.setRepeatMode(i);
    }

    @MainThread
    public void oxXx0IX() {
        float f;
        if (this.f1092XxX0x0xxx == null) {
            this.f1081IIXOooo.add(new OOXIXo());
            return;
        }
        if (this.f1094oI0IIXIo || xXxxox0I() == 0) {
            this.f1082IXxxXO.oI0IIXIo();
        }
        if (!this.f1094oI0IIXIo) {
            if (xI() < 0.0f) {
                f = XIxXXX0x0();
            } else {
                f = X0IIOO();
            }
            oX((int) f);
            this.f1082IXxxXO.Oxx0IOOO();
        }
    }

    @RequiresApi(api = 19)
    public void oxoX(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f1082IXxxXO.addPauseListener(animatorPauseListener);
    }

    public void oxxXoxO(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f1082IXxxXO.removeUpdateListener(animatorUpdateListener);
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.f1099xXxxox0I = i;
        invalidateSelf();
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IIXOooo.XO.X0o0xo("Use addColorFilter instead.");
    }

    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && !((View) callback).isInEditMode()) {
            OI0();
        }
    }

    @MainThread
    public void stop() {
        Oxx0xo();
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
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
        IIXOooo.Oxx0IOOO oxx0IOOO = this.f1082IXxxXO;
        if (z) {
            i = -1;
        } else {
            i = 0;
        }
        oxx0IOOO.setRepeatCount(i);
    }

    public void x0xO(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Oxx0IOOO oxx0IOOO = this.f1084Oo;
        if (oxx0IOOO == null) {
            this.f1081IIXOooo.add(new oxoX(f, f2));
        } else {
            OO((int) IIXOooo.xxIXOIIO.OOXIXo(oxx0IOOO.x0xO0oo(), this.f1084Oo.XO(), f), (int) IIXOooo.xxIXOIIO.OOXIXo(this.f1084Oo.x0xO0oo(), this.f1084Oo.XO(), f2));
        }
    }

    public final void x0xO0oo(Canvas canvas) {
        float f;
        int i;
        if (this.f1092XxX0x0xxx != null) {
            float f2 = this.f1086Oxx0xo;
            float XI0IXoo2 = XI0IXoo(canvas);
            if (f2 > XI0IXoo2) {
                f = this.f1086Oxx0xo / XI0IXoo2;
            } else {
                XI0IXoo2 = f2;
                f = 1.0f;
            }
            if (f > 1.0f) {
                i = canvas.save();
                float width = ((float) this.f1084Oo.II0xO0().width()) / 2.0f;
                float height = ((float) this.f1084Oo.II0xO0().height()) / 2.0f;
                float f3 = width * XI0IXoo2;
                float f4 = height * XI0IXoo2;
                canvas.translate((ooXIXxIX() * width) - f3, (ooXIXxIX() * height) - f4);
                canvas.scale(f, f, f3, f4);
            } else {
                i = -1;
            }
            this.f1091XO.reset();
            this.f1091XO.preScale(XI0IXoo2, XI0IXoo2);
            this.f1092XxX0x0xxx.I0Io(canvas, this.f1091XO, this.f1099xXxxox0I);
            if (i > 0) {
                canvas.restoreToCount(i);
            }
        }
    }

    public float xI() {
        return this.f1082IXxxXO.ooOOo0oXI();
    }

    public boolean xII() {
        return this.f1101xxX;
    }

    public void xXOx(boolean z) {
        this.f1098xI = z;
    }

    public int xXxxox0I() {
        return this.f1082IXxxXO.getRepeatCount();
    }

    public void xo0x() {
        this.f1082IXxxXO.OxxIIOOXO();
    }

    public final void xoIox() {
        com.airbnb.lottie.model.layer.II0xO0 iI0xO0 = new com.airbnb.lottie.model.layer.II0xO0(this, OxxIIOOXO.oI0IIXIo.oIX0oI(this.f1084Oo), this.f1084Oo.xoIox(), this.f1084Oo);
        this.f1092XxX0x0xxx = iI0xO0;
        if (this.f1097ooXIXxIX) {
            iI0xO0.xXxxox0I(true);
        }
    }

    public void xoIxX(String str, String str2, boolean z) {
        float f;
        Oxx0IOOO oxx0IOOO = this.f1084Oo;
        if (oxx0IOOO == null) {
            this.f1081IIXOooo.add(new II0xO0(str, str2, z));
            return;
        }
        x0xO0oo.Oxx0IOOO OOXIXo2 = oxx0IOOO.OOXIXo(str);
        if (OOXIXo2 != null) {
            int i = (int) OOXIXo2.f1423II0xO0;
            x0xO0oo.Oxx0IOOO OOXIXo3 = this.f1084Oo.OOXIXo(str2);
            if (OOXIXo3 != null) {
                float f2 = OOXIXo3.f1423II0xO0;
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
        OxxIIOOXO OxI2 = OxI();
        if (OxI2 == null) {
            IIXOooo.XO.X0o0xo("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap X0o0xo2 = OxI2.X0o0xo(str, bitmap);
        invalidateSelf();
        return X0o0xo2;
    }

    public int xoXoI() {
        return (int) this.f1082IXxxXO.xxIXOIIO();
    }

    public void xoxXI(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        Oxx0IOOO oxx0IOOO = this.f1084Oo;
        if (oxx0IOOO == null) {
            this.f1081IIXOooo.add(new oO(f));
        } else {
            O0Xx((int) IIXOooo.xxIXOIIO.OOXIXo(oxx0IOOO.x0xO0oo(), this.f1084Oo.XO(), f));
        }
    }

    public void xxIO(boolean z) {
        if (this.f1097ooXIXxIX != z) {
            this.f1097ooXIXxIX = z;
            com.airbnb.lottie.model.layer.II0xO0 iI0xO0 = this.f1092XxX0x0xxx;
            if (iI0xO0 != null) {
                iI0xO0.xXxxox0I(z);
            }
        }
    }

    public final boolean xxIXOIIO() {
        Oxx0IOOO oxx0IOOO = this.f1084Oo;
        if (oxx0IOOO == null || getBounds().isEmpty() || II0XooXoX(getBounds()) == II0XooXoX(oxx0IOOO.II0xO0())) {
            return true;
        }
        return false;
    }

    @Nullable
    public oI0IIXIo xxX() {
        Oxx0IOOO oxx0IOOO = this.f1084Oo;
        if (oxx0IOOO != null) {
            return oxx0IOOO.x0XOIxOo();
        }
        return null;
    }
}
