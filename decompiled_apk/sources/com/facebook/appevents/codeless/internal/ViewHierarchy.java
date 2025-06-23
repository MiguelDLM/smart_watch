package com.facebook.appevents.codeless.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.annotation.RestrictTo;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class ViewHierarchy {

    @OOXIXo
    private static final String CLASS_RCTROOTVIEW = "com.facebook.react.ReactRootView";

    @OOXIXo
    private static final String CLASS_RCTVIEWGROUP = "com.facebook.react.views.view.ReactViewGroup";

    @OOXIXo
    private static final String CLASS_TOUCHTARGETHELPER = "com.facebook.react.uimanager.TouchTargetHelper";
    private static final int ICON_MAX_EDGE_LENGTH = 44;

    @OOXIXo
    private static final String METHOD_FIND_TOUCHTARGET_VIEW = "findTouchTargetView";

    @oOoXoXO
    private static Method methodFindTouchTargetView;

    @OOXIXo
    public static final ViewHierarchy INSTANCE = new ViewHierarchy();

    @oOoXoXO
    private static final String TAG = ViewHierarchy.class.getCanonicalName();

    @OOXIXo
    private static WeakReference<View> RCTRootViewReference = new WeakReference<>(null);

    private ViewHierarchy() {
    }

    @x0XOIxOo
    @oOoXoXO
    public static final View findRCTRootView(@oOoXoXO View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        while (view != null) {
            try {
                if (INSTANCE.isRCTRootView(view)) {
                    return view;
                }
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            }
        }
        return null;
    }

    @x0XOIxOo
    @OOXIXo
    public static final List<View> getChildrenOfView(@oOoXoXO View view) {
        int childCount;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if ((view instanceof ViewGroup) && (childCount = ((ViewGroup) view).getChildCount()) > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    arrayList.add(((ViewGroup) view).getChildAt(i));
                    if (i2 >= childCount) {
                        break;
                    }
                    i = i2;
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004b A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:6:0x000a, B:9:0x0017, B:11:0x001d, B:12:0x001f, B:14:0x0025, B:15:0x0027, B:17:0x002b, B:19:0x0031, B:21:0x0037, B:22:0x0047, B:24:0x004b, B:27:0x003a, B:29:0x003e, B:31:0x004e, B:33:0x0052, B:36:0x0057, B:38:0x005b, B:40:0x005f, B:42:0x0063, B:44:0x0066, B:46:0x006a), top: B:5:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @XO0OX.x0XOIxOo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int getClassTypeBitmask(@OXOo.OOXIXo android.view.View r5) {
        /*
            java.lang.Class<com.facebook.appevents.codeless.internal.ViewHierarchy> r0 = com.facebook.appevents.codeless.internal.ViewHierarchy.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto La
            return r2
        La:
            java.lang.String r1 = "view"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r1)     // Catch: java.lang.Throwable -> L45
            boolean r1 = r5 instanceof android.widget.ImageView     // Catch: java.lang.Throwable -> L45
            if (r1 == 0) goto L16
            r1 = 2
            goto L17
        L16:
            r1 = 0
        L17:
            boolean r3 = r5.isClickable()     // Catch: java.lang.Throwable -> L45
            if (r3 == 0) goto L1f
            r1 = r1 | 32
        L1f:
            boolean r3 = isAdapterViewItem(r5)     // Catch: java.lang.Throwable -> L45
            if (r3 == 0) goto L27
            r1 = r1 | 512(0x200, float:7.17E-43)
        L27:
            boolean r3 = r5 instanceof android.widget.TextView     // Catch: java.lang.Throwable -> L45
            if (r3 == 0) goto L4e
            r3 = r1 | 1025(0x401, float:1.436E-42)
            boolean r4 = r5 instanceof android.widget.Button     // Catch: java.lang.Throwable -> L45
            if (r4 == 0) goto L43
            r3 = r1 | 1029(0x405, float:1.442E-42)
            boolean r4 = r5 instanceof android.widget.Switch     // Catch: java.lang.Throwable -> L45
            if (r4 == 0) goto L3a
            r1 = r1 | 9221(0x2405, float:1.2921E-41)
            goto L47
        L3a:
            boolean r4 = r5 instanceof android.widget.CheckBox     // Catch: java.lang.Throwable -> L45
            if (r4 == 0) goto L43
            r3 = 33797(0x8405, float:4.736E-41)
            r1 = r1 | r3
            goto L47
        L43:
            r1 = r3
            goto L47
        L45:
            r5 = move-exception
            goto L80
        L47:
            boolean r5 = r5 instanceof android.widget.EditText     // Catch: java.lang.Throwable -> L45
            if (r5 == 0) goto L7f
            r1 = r1 | 2048(0x800, float:2.87E-42)
            goto L7f
        L4e:
            boolean r3 = r5 instanceof android.widget.Spinner     // Catch: java.lang.Throwable -> L45
            if (r3 != 0) goto L7d
            boolean r3 = r5 instanceof android.widget.DatePicker     // Catch: java.lang.Throwable -> L45
            if (r3 == 0) goto L57
            goto L7d
        L57:
            boolean r3 = r5 instanceof android.widget.RatingBar     // Catch: java.lang.Throwable -> L45
            if (r3 == 0) goto L5f
            r5 = 65536(0x10000, float:9.1835E-41)
            r1 = r1 | r5
            goto L7f
        L5f:
            boolean r3 = r5 instanceof android.widget.RadioGroup     // Catch: java.lang.Throwable -> L45
            if (r3 == 0) goto L66
            r1 = r1 | 16384(0x4000, float:2.2959E-41)
            goto L7f
        L66:
            boolean r3 = r5 instanceof android.view.ViewGroup     // Catch: java.lang.Throwable -> L45
            if (r3 == 0) goto L7f
            com.facebook.appevents.codeless.internal.ViewHierarchy r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE     // Catch: java.lang.Throwable -> L45
            java.lang.ref.WeakReference<android.view.View> r4 = com.facebook.appevents.codeless.internal.ViewHierarchy.RCTRootViewReference     // Catch: java.lang.Throwable -> L45
            java.lang.Object r4 = r4.get()     // Catch: java.lang.Throwable -> L45
            android.view.View r4 = (android.view.View) r4     // Catch: java.lang.Throwable -> L45
            boolean r5 = r3.isRCTButton(r5, r4)     // Catch: java.lang.Throwable -> L45
            if (r5 == 0) goto L7f
            r1 = r1 | 64
            goto L7f
        L7d:
            r1 = r1 | 4096(0x1000, float:5.74E-42)
        L7f:
            return r1
        L80:
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r5, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.ViewHierarchy.getClassTypeBitmask(android.view.View):int");
    }

    @x0XOIxOo
    @OOXIXo
    public static final JSONObject getDictionaryOfView(@OOXIXo View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(view, "view");
            if (IIX0o.Oxx0IOOO(view.getClass().getName(), CLASS_RCTROOTVIEW)) {
                RCTRootViewReference = new WeakReference<>(view);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                updateBasicInfoOfView(view, jSONObject);
                JSONArray jSONArray = new JSONArray();
                List<View> childrenOfView = getChildrenOfView(view);
                int size = childrenOfView.size() - 1;
                if (size >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        jSONArray.put(getDictionaryOfView(childrenOfView.get(i)));
                        if (i2 > size) {
                            break;
                        }
                        i = i2;
                    }
                }
                jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, jSONArray);
            } catch (JSONException e) {
                Log.e(TAG, "Failed to create JSONObject for view.", e);
            }
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    private final JSONObject getDimensionOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("top", view.getTop());
                jSONObject.put("left", view.getLeft());
                jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, view.getWidth());
                jSONObject.put("height", view.getHeight());
                jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_X_KEY, view.getScrollX());
                jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_Y_KEY, view.getScrollY());
                jSONObject.put("visibility", view.getVisibility());
            } catch (JSONException e) {
                Log.e(TAG, "Failed to create JSONObject for dimension.", e);
            }
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Class<?> getExistingClass(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @x0XOIxOo
    @oOoXoXO
    public static final View.OnClickListener getExistingOnClickListener(@oOoXoXO View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            Field declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            IIX0o.oO(declaredField, "forName(\"android.view.View\").getDeclaredField(\"mListenerInfo\")");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(view);
            if (obj == null) {
                return null;
            }
            Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
            IIX0o.oO(declaredField2, "forName(\"android.view.View\\$ListenerInfo\").getDeclaredField(\"mOnClickListener\")");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 != null) {
                return (View.OnClickListener) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnClickListener");
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    @x0XOIxOo
    @oOoXoXO
    public static final View.OnTouchListener getExistingOnTouchListener(@oOoXoXO View view) {
        try {
            if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
                return null;
            }
            try {
                Field declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
                IIX0o.oO(declaredField, "forName(\"android.view.View\").getDeclaredField(\"mListenerInfo\")");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(view);
                if (obj == null) {
                    return null;
                }
                Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener");
                IIX0o.oO(declaredField2, "forName(\"android.view.View\\$ListenerInfo\").getDeclaredField(\"mOnTouchListener\")");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                if (obj2 != null) {
                    return (View.OnTouchListener) obj2;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnTouchListener");
            } catch (ClassNotFoundException e) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, e);
                return null;
            } catch (IllegalAccessException e2) {
                Utility utility2 = Utility.INSTANCE;
                Utility.logd(TAG, e2);
                return null;
            } catch (NoSuchFieldException e3) {
                Utility utility3 = Utility.INSTANCE;
                Utility.logd(TAG, e3);
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final String getHintOfView(@oOoXoXO View view) {
        CharSequence charSequence;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            if (view instanceof EditText) {
                charSequence = ((EditText) view).getHint();
            } else if (view instanceof TextView) {
                charSequence = ((TextView) view).getHint();
            } else {
                charSequence = null;
            }
            if (charSequence == null) {
                return "";
            }
            String obj = charSequence.toString();
            if (obj == null) {
                return "";
            }
            return obj;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    @x0XOIxOo
    @oOoXoXO
    public static final ViewGroup getParentOfView(@oOoXoXO View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class) || view == null) {
            return null;
        }
        try {
            ViewParent parent = view.getParent();
            if (!(parent instanceof ViewGroup)) {
                return null;
            }
            return (ViewGroup) parent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final String getTextOfView(@oOoXoXO View view) {
        CharSequence valueOf;
        Object selectedItem;
        String str;
        int i = 0;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return null;
        }
        try {
            if (view instanceof TextView) {
                valueOf = ((TextView) view).getText();
                if (view instanceof Switch) {
                    if (((Switch) view).isChecked()) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    valueOf = str;
                }
            } else if (view instanceof Spinner) {
                if (((Spinner) view).getCount() > 0 && (selectedItem = ((Spinner) view).getSelectedItem()) != null) {
                    valueOf = selectedItem.toString();
                }
                valueOf = null;
            } else if (view instanceof DatePicker) {
                int year = ((DatePicker) view).getYear();
                int month = ((DatePicker) view).getMonth();
                int dayOfMonth = ((DatePicker) view).getDayOfMonth();
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                valueOf = String.format("%04d-%02d-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(dayOfMonth)}, 3));
                IIX0o.oO(valueOf, "java.lang.String.format(format, *args)");
            } else if (view instanceof TimePicker) {
                Integer currentHour = ((TimePicker) view).getCurrentHour();
                IIX0o.oO(currentHour, "view.currentHour");
                int intValue = currentHour.intValue();
                Integer currentMinute = ((TimePicker) view).getCurrentMinute();
                IIX0o.oO(currentMinute, "view.currentMinute");
                int intValue2 = currentMinute.intValue();
                oxxXoxO oxxxoxo2 = oxxXoxO.f29356oIX0oI;
                valueOf = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(intValue), Integer.valueOf(intValue2)}, 2));
                IIX0o.oO(valueOf, "java.lang.String.format(format, *args)");
            } else if (view instanceof RadioGroup) {
                int checkedRadioButtonId = ((RadioGroup) view).getCheckedRadioButtonId();
                int childCount = ((RadioGroup) view).getChildCount();
                if (childCount > 0) {
                    while (true) {
                        int i2 = i + 1;
                        View childAt = ((RadioGroup) view).getChildAt(i);
                        if (childAt.getId() == checkedRadioButtonId && (childAt instanceof RadioButton)) {
                            valueOf = ((RadioButton) childAt).getText();
                            break;
                        }
                        if (i2 >= childCount) {
                            break;
                        }
                        i = i2;
                    }
                }
                valueOf = null;
            } else {
                if (view instanceof RatingBar) {
                    valueOf = String.valueOf(((RatingBar) view).getRating());
                }
                valueOf = null;
            }
            if (valueOf == null) {
                return "";
            }
            String obj = valueOf.toString();
            if (obj == null) {
                return "";
            }
            return obj;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return null;
        }
    }

    private final View getTouchReactView(float[] fArr, View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            initTouchTargetHelperMethods();
            Method method = methodFindTouchTargetView;
            if (method != null && view != null) {
                try {
                    try {
                        if (method != null) {
                            Object invoke = method.invoke(null, fArr, view);
                            if (invoke != null) {
                                View view2 = (View) invoke;
                                if (view2.getId() > 0) {
                                    Object parent = view2.getParent();
                                    if (parent != null) {
                                        return (View) parent;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                            }
                        } else {
                            throw new IllegalStateException("Required value was null.");
                        }
                    } catch (InvocationTargetException e) {
                        Utility utility = Utility.INSTANCE;
                        Utility.logd(TAG, e);
                    }
                } catch (IllegalAccessException e2) {
                    Utility utility2 = Utility.INSTANCE;
                    Utility.logd(TAG, e2);
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final float[] getViewLocationOnScreen(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            view.getLocationOnScreen(new int[2]);
            return new float[]{r3[0], r3[1]};
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final void initTouchTargetHelperMethods() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (methodFindTouchTargetView != null) {
                return;
            }
            try {
                Class<?> cls = Class.forName(CLASS_TOUCHTARGETHELPER);
                IIX0o.oO(cls, "forName(CLASS_TOUCHTARGETHELPER)");
                Method declaredMethod = cls.getDeclaredMethod(METHOD_FIND_TOUCHTARGET_VIEW, float[].class, ViewGroup.class);
                methodFindTouchTargetView = declaredMethod;
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    return;
                }
                throw new IllegalStateException("Required value was null.");
            } catch (ClassNotFoundException e) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, e);
            } catch (NoSuchMethodException e2) {
                Utility utility2 = Utility.INSTANCE;
                Utility.logd(TAG, e2);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @x0XOIxOo
    private static final boolean isAdapterViewItem(View view) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return false;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof AdapterView) {
                return true;
            }
            ViewHierarchy viewHierarchy = INSTANCE;
            Class<?> existingClass = viewHierarchy.getExistingClass("android.support.v4.view.NestedScrollingChild");
            if (existingClass != null && existingClass.isInstance(parent)) {
                return true;
            }
            Class<?> existingClass2 = viewHierarchy.getExistingClass("androidx.core.view.NestedScrollingChild");
            if (existingClass2 == null) {
                return false;
            }
            if (!existingClass2.isInstance(parent)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
            return false;
        }
    }

    private final boolean isRCTRootView(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return IIX0o.Oxx0IOOO(view.getClass().getName(), CLASS_RCTROOTVIEW);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    @x0XOIxOo
    public static final void setOnClickListener(@OOXIXo View view, @oOoXoXO View.OnClickListener onClickListener) {
        Field field;
        Field field2;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(view, "view");
            Object obj = null;
            try {
                try {
                    field = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
                } catch (ClassNotFoundException | NoSuchFieldException unused) {
                    field = null;
                }
                try {
                    field2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
                } catch (ClassNotFoundException | NoSuchFieldException unused2) {
                    field2 = null;
                    if (field == null) {
                    }
                    view.setOnClickListener(onClickListener);
                }
                if (field == null && field2 != null) {
                    field.setAccessible(true);
                    field2.setAccessible(true);
                    try {
                        field.setAccessible(true);
                        obj = field.get(view);
                    } catch (IllegalAccessException unused3) {
                    }
                    if (obj == null) {
                        view.setOnClickListener(onClickListener);
                        return;
                    } else {
                        field2.set(obj, onClickListener);
                        return;
                    }
                }
                view.setOnClickListener(onClickListener);
            } catch (Exception unused4) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
        }
    }

    @x0XOIxOo
    public static final void updateAppearanceOfView(@OOXIXo View view, @OOXIXo JSONObject json, float f) {
        Bitmap bitmap;
        Typeface typeface;
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(view, "view");
            IIX0o.x0xO0oo(json, "json");
            try {
                JSONObject jSONObject = new JSONObject();
                if ((view instanceof TextView) && (typeface = ((TextView) view).getTypeface()) != null) {
                    jSONObject.put(ViewHierarchyConstants.TEXT_SIZE, ((TextView) view).getTextSize());
                    jSONObject.put(ViewHierarchyConstants.TEXT_IS_BOLD, typeface.isBold());
                    jSONObject.put(ViewHierarchyConstants.TEXT_IS_ITALIC, typeface.isItalic());
                    json.put(ViewHierarchyConstants.TEXT_STYLE, jSONObject);
                }
                if (view instanceof ImageView) {
                    Drawable drawable = ((ImageView) view).getDrawable();
                    if (drawable instanceof BitmapDrawable) {
                        float f2 = 44;
                        if (view.getHeight() / f <= f2 && view.getWidth() / f <= f2 && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                            json.put(ViewHierarchyConstants.ICON_BITMAP, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                        }
                    }
                }
            } catch (JSONException e) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
        }
    }

    @x0XOIxOo
    public static final void updateBasicInfoOfView(@OOXIXo View view, @OOXIXo JSONObject json) {
        if (CrashShieldHandler.isObjectCrashing(ViewHierarchy.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(view, "view");
            IIX0o.x0xO0oo(json, "json");
            try {
                String textOfView = getTextOfView(view);
                String hintOfView = getHintOfView(view);
                Object tag = view.getTag();
                CharSequence contentDescription = view.getContentDescription();
                json.put(ViewHierarchyConstants.CLASS_NAME_KEY, view.getClass().getCanonicalName());
                json.put(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY, getClassTypeBitmask(view));
                json.put("id", view.getId());
                SensitiveUserDataUtils sensitiveUserDataUtils = SensitiveUserDataUtils.INSTANCE;
                if (!SensitiveUserDataUtils.isSensitiveUserData(view)) {
                    Utility utility = Utility.INSTANCE;
                    json.put("text", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(textOfView), ""));
                } else {
                    json.put("text", "");
                    json.put(ViewHierarchyConstants.IS_USER_INPUT_KEY, true);
                }
                Utility utility2 = Utility.INSTANCE;
                json.put(ViewHierarchyConstants.HINT_KEY, Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(hintOfView), ""));
                if (tag != null) {
                    json.put("tag", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(tag.toString()), ""));
                }
                if (contentDescription != null) {
                    json.put("description", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(contentDescription.toString()), ""));
                }
                json.put("dimension", INSTANCE.getDimensionOfView(view));
            } catch (JSONException e) {
                Utility utility3 = Utility.INSTANCE;
                Utility.logd(TAG, e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewHierarchy.class);
        }
    }

    public final boolean isRCTButton(@OOXIXo View view, @oOoXoXO View view2) {
        View touchReactView;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            IIX0o.x0xO0oo(view, "view");
            String name = view.getClass().getName();
            IIX0o.oO(name, "view.javaClass.name");
            if (!IIX0o.Oxx0IOOO(name, CLASS_RCTVIEWGROUP) || (touchReactView = getTouchReactView(getViewLocationOnScreen(view), view2)) == null) {
                return false;
            }
            if (touchReactView.getId() != view.getId()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
