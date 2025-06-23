package com.baidu.navcore.model;

import android.os.Build;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.routeguide.b;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.o0;
import java.io.File;

/* loaded from: classes7.dex */
public class a {
    private static a b;

    /* renamed from: a, reason: collision with root package name */
    private String f6464a = null;

    /* renamed from: com.baidu.navcore.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0152a implements o0.d {
        public C0152a() {
        }

        @Override // com.baidu.navisdk.util.common.o0.d
        public void a(int i, String[] strArr) {
        }

        @Override // com.baidu.navisdk.util.common.o0.d
        public void a(int i) {
            a.this.a(i);
        }
    }

    private a() {
        new RoutePlanNode();
    }

    public static a b() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    public boolean a(String str, String str2) {
        try {
            this.f6464a = str;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6464a);
            sb.append(File.separator);
            sb.append(str2);
            return true;
        } catch (Exception e) {
            if (!LogUtil.LOGGABLE) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public void a() {
        if (o0.b().a() == null) {
            o0.b().a(new C0152a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i) {
        if (Build.VERSION.SDK_INT < 23 || b.V().b() == null) {
            return false;
        }
        if (i == 3003) {
            o0.b().a(i, new String[]{"android.permission.RECORD_AUDIO"}, (o0.b) null);
            return true;
        }
        if (i != 3004) {
            return true;
        }
        o0.b().a(i, new String[]{"android.permission.CAMERA"}, (o0.b) null);
        return true;
    }
}
