package xx0O;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import oO0.II0XooXoX;

/* loaded from: classes6.dex */
public class X0o0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Object[] f35272oIX0oI = new Object[2];

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final Class<?>[] f35269II0xO0 = {Context.class, AttributeSet.class};

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int[] f35268I0Io = {R.attr.onClick};

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String[] f35271oxoX = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final Map<String, Constructor<? extends View>> f35270X0o0xo = new II0XooXoX();

    /* loaded from: classes6.dex */
    public static class oIX0oI implements View.OnClickListener {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public Method f35273IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final String f35274Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public Context f35275Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final View f35276XO;

        public oIX0oI(@IXo.XO View view, @IXo.XO String str) {
            this.f35276XO = view;
            this.f35274Oo = str;
        }

        @IXo.XO
        public final void oIX0oI(@IXo.Oxx0IOOO Context context, @IXo.XO String str) {
            String str2;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f35274Oo, View.class)) != null) {
                        this.f35273IXxxXO = method;
                        this.f35275Oxx0xo = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                if (context instanceof ContextWrapper) {
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    context = null;
                }
            }
            int id = this.f35276XO.getId();
            if (id == -1) {
                str2 = "";
            } else {
                str2 = " with id '" + this.f35276XO.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f35274Oo + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f35276XO.getClass() + str2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@IXo.XO View view) {
            if (this.f35273IXxxXO == null) {
                oIX0oI(this.f35276XO.getContext(), this.f35274Oo);
            }
            try {
                this.f35273IXxxXO.invoke(this.f35275Oxx0xo, view);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    public final View I0Io(View view, String str, @IXo.XO Context context, @IXo.XO AttributeSet attributeSet) {
        View oxoX2 = oxoX(context, str, attributeSet);
        if (oxoX2 == null) {
            oxoX2 = X0o0xo(context, str, attributeSet);
        }
        if (oxoX2 == null) {
            oxoX2 = XO(context, str, attributeSet);
        }
        if (oxoX2 != null) {
            oIX0oI(oxoX2, attributeSet);
        }
        return oxoX2;
    }

    public final View II0xO0(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        String str3;
        Map<String, Constructor<? extends View>> map = f35270X0o0xo;
        Constructor<? extends View> constructor = map.get(str);
        if (constructor == null) {
            try {
                ClassLoader classLoader = context.getClassLoader();
                if (str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                constructor = classLoader.loadClass(str3).asSubclass(View.class).getConstructor(f35269II0xO0);
                map.put(str, constructor);
            } catch (Exception unused) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f35272oIX0oI);
    }

    public final View X0o0xo(Context context, String str, AttributeSet attributeSet) {
        Iterator<XO> it = IIXOxIxOo.I0Io.IXxxXO().Oo().iterator();
        View view = null;
        while (it.hasNext() && (view = it.next().oIX0oI(context, str, attributeSet)) == null) {
        }
        return view;
    }

    public View XO(Context context, String str, AttributeSet attributeSet) {
        if (ViewHierarchyConstants.VIEW_KEY.equals(str)) {
            str = attributeSet.getAttributeValue(null, O0IoXXOx.XO.f1157IXxxXO);
        }
        try {
            Object[] objArr = this.f35272oIX0oI;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                int i = 0;
                while (true) {
                    String[] strArr = f35271oxoX;
                    if (i >= strArr.length) {
                        return null;
                    }
                    View II0xO02 = II0xO0(context, str, strArr[i]);
                    if (II0xO02 != null) {
                        return II0xO02;
                    }
                    i++;
                }
            } else {
                return II0xO0(context, str, null);
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.f35272oIX0oI;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    public final void oIX0oI(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && Oo0xX.I0Io.oIX0oI(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f35268I0Io);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new oIX0oI(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final View oxoX(Context context, String str, AttributeSet attributeSet) {
        Iterator<XO> it = IIXOxIxOo.I0Io.IXxxXO().x0xO0oo().iterator();
        View view = null;
        while (it.hasNext() && (view = it.next().oIX0oI(context, str, attributeSet)) == null) {
        }
        return view;
    }
}
