package com.bytedance.pangle.receiver;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final c f10598a;

    /* loaded from: classes8.dex */
    public static class a implements c {
        private a() {
        }

        private static Object b(Context context) {
            Field field;
            Object readField;
            try {
                Field field2 = FieldUtils.getField(Class.forName("android.app.LoadedApk"), "mReceiverResource");
                if (field2 != null && (field = FieldUtils.getField(Class.forName("android.app.ContextImpl"), "mPackageInfo")) != null && (readField = FieldUtils.readField(field, context)) != null) {
                    return FieldUtils.readField(field2, readField);
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // com.bytedance.pangle.receiver.b.c
        public boolean a(Context context) {
            Object b = b(context);
            Object a2 = a(b, "mWhiteList");
            if (!(a2 instanceof String[])) {
                if (b == null) {
                    return false;
                }
                FieldUtils.writeField(b, "mResourceConfig", (Object) null);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(context.getPackageName());
            Collections.addAll(arrayList, (String[]) a2);
            FieldUtils.writeField(b, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
            return true;
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static Object a(Context context, String str) {
            return a(b(context), str);
        }

        private static Object a(Object obj, String str) {
            if (obj == null) {
                return null;
            }
            try {
                return FieldUtils.readField(obj, str);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* renamed from: com.bytedance.pangle.receiver.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0562b extends e {
        private C0562b() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.b.e, com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(Context context) {
            return false;
        }

        public /* synthetic */ C0562b(byte b) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        boolean a(Context context);
    }

    /* loaded from: classes8.dex */
    public static class d extends a {
        private d() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(Context context) {
            Object a2 = a.a(context, "mWhiteList");
            if (a2 instanceof List) {
                ((List) a2).add(context.getPackageName());
                return true;
            }
            return false;
        }

        public /* synthetic */ d(byte b) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public static class e extends a {
        private e() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public boolean a(Context context) {
            Object a2 = a.a(context, "mWhiteListMap");
            if (!(a2 instanceof Map)) {
                return false;
            }
            Map map = (Map) a2;
            List list = (List) map.get(0);
            if (list == null) {
                list = new ArrayList();
                map.put(0, list);
            }
            list.add(context.getPackageName());
            return true;
        }

        public /* synthetic */ e(byte b) {
            this();
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        byte b = 0;
        if (i < 24) {
            f10598a = new a(b);
            return;
        }
        if (i < 26) {
            f10598a = new d(b);
        } else if (i < 28) {
            f10598a = new e(b);
        } else {
            f10598a = new C0562b(b);
        }
    }

    public static void a(Application application) {
        if (application != null) {
            try {
                if (TextUtils.equals(Build.BRAND.toLowerCase(), "huawei")) {
                    f10598a.a(application.getBaseContext());
                }
            } catch (Throwable unused) {
            }
        }
    }
}
