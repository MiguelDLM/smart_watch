package com.bytedance.pangle.e;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public final class e implements f.a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile IBinder f10539a;
    private static volatile Object b;

    /* loaded from: classes8.dex */
    public interface a {
    }

    /* loaded from: classes8.dex */
    public static class b extends ResultReceiver {

        /* renamed from: a, reason: collision with root package name */
        private a f10540a;

        public b() {
            super(null);
            this.f10540a = null;
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i, Bundle bundle) {
            super.onReceiveResult(i, bundle);
        }
    }

    private static void a(String[] strArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeFileDescriptor(FileDescriptor.in);
        obtain.writeFileDescriptor(FileDescriptor.out);
        obtain.writeFileDescriptor(FileDescriptor.err);
        obtain.writeStringArray(strArr);
        obtain.writeStrongBinder(null);
        new b().writeToParcel(obtain, 0);
        try {
            f10539a.transact(1598246212, obtain, obtain2, 0);
            obtain2.readException();
        } catch (Exception unused) {
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            throw th;
        }
        obtain.recycle();
        obtain2.recycle();
    }

    private static Object a(Field field, Object obj) {
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object obj2 = field.get(obj);
            field.setAccessible(false);
            return obj2;
        } catch (Exception unused) {
            return null;
        }
    }

    private static Object a(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        try {
            return MethodUtils.invokeMethod(obj, str, objArr, clsArr);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.pangle.e.f.a
    public final boolean a(String str, int i) {
        IBinder asBinder;
        boolean z = false;
        if (f10539a == null) {
            PackageManager packageManager = Zeus.getAppApplication().getPackageManager();
            Field field = packageManager == null ? null : FieldUtils.getField(packageManager.getClass(), "mPM");
            if (field != null) {
                Object a2 = a(field, packageManager);
                b = a2;
                if ((a2 instanceof IInterface) && (asBinder = ((IInterface) b).asBinder()) != null) {
                    f10539a = asBinder;
                }
            }
        }
        if (str != null) {
            String b2 = com.bytedance.pangle.d.c.b(str, i);
            String e = com.bytedance.pangle.d.c.e(str, i);
            try {
                com.bytedance.pangle.util.h.a(b2, e);
            } catch (Exception unused) {
            }
            String packageName = Zeus.getAppApplication().getPackageName();
            String a3 = com.bytedance.pangle.e.b.a();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 == 30) {
                if (b != null && packageName != null && e != null && a3 != null) {
                    a(b, "notifyDexLoad", new Object[]{packageName, Collections.singletonMap(e, "PCL[]"), a3}, new Class[]{String.class, Map.class, String.class});
                }
            } else if (i2 == 29 && b != null && packageName != null && e != null && a3 != null) {
                a(b, "notifyDexLoad", new Object[]{packageName, Collections.singletonList("dalvik.system.DexClassLoader"), Collections.singletonList(e), a3}, new Class[]{String.class, List.class, List.class, String.class});
            }
        }
        String e2 = com.bytedance.pangle.d.c.e(str, i);
        String str2 = com.bytedance.pangle.d.c.h(str, i) + File.separator + com.bytedance.pangle.e.b.a(e2);
        int i3 = 1;
        while (true) {
            if (i3 > 3) {
                break;
            }
            a(new String[]{"compile", "-m", RouteGuideParams.RGKey.AssistInfo.Speed, "-f", "--secondary-dex", Zeus.getAppApplication().getPackageName()});
            if (com.bytedance.pangle.e.b.a(str2)) {
                z = true;
                break;
            }
            i3++;
        }
        if (str != null) {
            try {
                com.bytedance.pangle.util.g.a(com.bytedance.pangle.d.c.g(str, i), com.bytedance.pangle.d.c.f(str, i));
            } catch (Exception unused2) {
            }
            try {
                File file = new File(com.bytedance.pangle.d.c.e(str, i));
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception unused3) {
            }
            a(new String[]{"reconcile-secondary-dex-files", Zeus.getAppApplication().getPackageName()});
        }
        return z;
    }
}
