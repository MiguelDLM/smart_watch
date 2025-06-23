package com.baidu.mapframework.nirvana.schedule;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapframework.nirvana.monitor.NirvanaMonitor;
import com.baidu.mapframework.nirvana.schedule.UITaskType;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class LifecycleManager {
    public static final String TAG = NirvanaMonitor.class.getSimpleName();
    private String b;

    /* renamed from: a, reason: collision with root package name */
    private volatile long f6114a = 0;
    private volatile HashMap<String, UIState> c = new HashMap<>();

    /* renamed from: com.baidu.mapframework.nirvana.schedule.LifecycleManager$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6115a;

        static {
            int[] iArr = new int[UITaskType.UIType.values().length];
            f6115a = iArr;
            try {
                iArr[UITaskType.UIType.PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6115a[UITaskType.UIType.SCENE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface Lifecycle {
        boolean isActive();
    }

    /* loaded from: classes7.dex */
    public class PageLifecycle implements Lifecycle {

        /* renamed from: a, reason: collision with root package name */
        private final long f6116a;

        public /* synthetic */ PageLifecycle(LifecycleManager lifecycleManager, long j, AnonymousClass1 anonymousClass1) {
            this(j);
        }

        @Override // com.baidu.mapframework.nirvana.schedule.LifecycleManager.Lifecycle
        public boolean isActive() {
            if (LifecycleManager.this.f6114a == this.f6116a) {
                return true;
            }
            return false;
        }

        private PageLifecycle(long j) {
            this.f6116a = j;
        }
    }

    /* loaded from: classes7.dex */
    public class SceneLifecycle implements Lifecycle {

        /* renamed from: a, reason: collision with root package name */
        private final String f6117a;

        public /* synthetic */ SceneLifecycle(LifecycleManager lifecycleManager, String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        @Override // com.baidu.mapframework.nirvana.schedule.LifecycleManager.Lifecycle
        public boolean isActive() {
            UIState uIState = (UIState) LifecycleManager.this.c.get(this.f6117a);
            if (uIState != null && uIState == UIState.ACTIVE) {
                return true;
            }
            return false;
        }

        private SceneLifecycle(String str) {
            this.f6117a = str;
        }
    }

    /* loaded from: classes7.dex */
    public enum UIState {
        ACTIVE,
        DESTROYED
    }

    public synchronized void onUIStateChange(UITaskType.UIType uIType, String str, UIState uIState) {
        Log.d(TAG, "onUIStateChange: " + uIType + " " + str + " " + uIState);
        int i = AnonymousClass1.f6115a[uIType.ordinal()];
        if (i != 1) {
            if (i != 2) {
            }
        } else {
            this.b = str;
            this.f6114a++;
        }
        this.c.put(str, uIState);
    }

    public synchronized Lifecycle a(UITaskType.UIType uIType, String str) {
        int i = AnonymousClass1.f6115a[uIType.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return new SceneLifecycle(this, str, anonymousClass1);
        }
        if (TextUtils.equals(str, this.b)) {
            return new PageLifecycle(this, this.f6114a, anonymousClass1);
        }
        return new PageLifecycle(this, -1L, anonymousClass1);
    }
}
