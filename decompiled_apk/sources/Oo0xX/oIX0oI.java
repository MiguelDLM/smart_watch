package Oo0xX;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Field;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes6.dex */
public final class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static boolean f2040I0Io = false;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static Field f2041II0xO0 = null;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f2042oIX0oI = "LayoutInflaterCompatHC";

    /* renamed from: Oo0xX.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class LayoutInflaterFactory2C0041oIX0oI implements LayoutInflater.Factory2 {

        /* renamed from: XO, reason: collision with root package name */
        public final II0xO0 f2043XO;

        public LayoutInflaterFactory2C0041oIX0oI(II0xO0 iI0xO0) {
            this.f2043XO = iI0xO0;
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f2043XO.onCreateView(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.f2043XO + ooOOo0oXI.f33074oOoXoXO;
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.f2043XO.onCreateView(view, str, context, attributeSet);
        }
    }

    @Deprecated
    public static void I0Io(LayoutInflater layoutInflater, II0xO0 iI0xO0) {
        LayoutInflaterFactory2C0041oIX0oI layoutInflaterFactory2C0041oIX0oI;
        if (iI0xO0 != null) {
            layoutInflaterFactory2C0041oIX0oI = new LayoutInflaterFactory2C0041oIX0oI(iI0xO0);
        } else {
            layoutInflaterFactory2C0041oIX0oI = null;
        }
        layoutInflater.setFactory2(layoutInflaterFactory2C0041oIX0oI);
    }

    @Deprecated
    public static II0xO0 II0xO0(LayoutInflater layoutInflater) {
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof LayoutInflaterFactory2C0041oIX0oI) {
            return ((LayoutInflaterFactory2C0041oIX0oI) factory).f2043XO;
        }
        return null;
    }

    public static void oIX0oI(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f2040I0Io) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                f2041II0xO0 = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e(f2042oIX0oI, "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f2040I0Io = true;
        }
        Field field = f2041II0xO0;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e(f2042oIX0oI, "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    public static void oxoX(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
    }
}
