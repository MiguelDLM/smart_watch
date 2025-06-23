package androidx.lifecycle;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import XO0OX.xxIXOIIO;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ReportFragment extends Fragment {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @OOXIXo
    private static final String REPORT_FRAGMENT_TAG = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
    @oOoXoXO
    private ActivityInitializationListener processListener;

    public interface ActivityInitializationListener {
        void onCreate();

        void onResume();

        void onStart();
    }

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        public static /* synthetic */ void get$annotations(Activity activity) {
        }

        @x0XOIxOo
        public final void dispatch$lifecycle_runtime_release(@OOXIXo Activity activity, @OOXIXo Lifecycle.Event event) {
            IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
            IIX0o.x0xO0oo(event, NotificationCompat.CATEGORY_EVENT);
            if (activity instanceof LifecycleRegistryOwner) {
                ((LifecycleRegistryOwner) activity).getLifecycle().handleLifecycleEvent(event);
            } else if (activity instanceof LifecycleOwner) {
                Lifecycle lifecycle = ((LifecycleOwner) activity).getLifecycle();
                if (lifecycle instanceof LifecycleRegistry) {
                    ((LifecycleRegistry) lifecycle).handleLifecycleEvent(event);
                }
            }
        }

        @OOXIXo
        @xxIXOIIO(name = "get")
        public final ReportFragment get(@OOXIXo Activity activity) {
            IIX0o.x0xO0oo(activity, "<this>");
            Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag(ReportFragment.REPORT_FRAGMENT_TAG);
            IIX0o.x0XOIxOo(findFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (ReportFragment) findFragmentByTag;
        }

        @x0XOIxOo
        public final void injectIfNeededIn(@OOXIXo Activity activity) {
            IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
            if (Build.VERSION.SDK_INT >= 29) {
                LifecycleCallbacks.Companion.registerIn(activity);
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag(ReportFragment.REPORT_FRAGMENT_TAG) == null) {
                fragmentManager.beginTransaction().add(new ReportFragment(), ReportFragment.REPORT_FRAGMENT_TAG).commit();
                fragmentManager.executePendingTransactions();
            }
        }

        private Companion() {
        }
    }

    @RequiresApi(29)
    public static final class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        @OOXIXo
        public static final Companion Companion = new Companion((IIXOooo) null);

        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @x0XOIxOo
            public final void registerIn(@OOXIXo Activity activity) {
                IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
                xoIox.oIX0oI(activity, new LifecycleCallbacks());
            }

            private Companion() {
            }
        }

        @x0XOIxOo
        public static final void registerIn(@OOXIXo Activity activity) {
            Companion.registerIn(activity);
        }

        public void onActivityCreated(@OOXIXo Activity activity, @oOoXoXO Bundle bundle) {
            IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
        }

        public void onActivityDestroyed(@OOXIXo Activity activity) {
            IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
        }

        public void onActivityPaused(@OOXIXo Activity activity) {
            IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
        }

        public void onActivityPostCreated(@OOXIXo Activity activity, @oOoXoXO Bundle bundle) {
            IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_CREATE);
        }

        public void onActivityPostResumed(@OOXIXo Activity activity) {
            IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_RESUME);
        }

        public void onActivityPostStarted(@OOXIXo Activity activity) {
            IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_START);
        }

        public void onActivityPreDestroyed(@OOXIXo Activity activity) {
            IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_DESTROY);
        }

        public void onActivityPrePaused(@OOXIXo Activity activity) {
            IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_PAUSE);
        }

        public void onActivityPreStopped(@OOXIXo Activity activity) {
            IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_STOP);
        }

        public void onActivityResumed(@OOXIXo Activity activity) {
            IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
        }

        public void onActivitySaveInstanceState(@OOXIXo Activity activity, @OOXIXo Bundle bundle) {
            IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
            IIX0o.x0xO0oo(bundle, "bundle");
        }

        public void onActivityStarted(@OOXIXo Activity activity) {
            IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
        }

        public void onActivityStopped(@OOXIXo Activity activity) {
            IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
        }
    }

    private final void dispatch(Lifecycle.Event event) {
        if (Build.VERSION.SDK_INT < 29) {
            Companion companion = Companion;
            Activity activity = getActivity();
            IIX0o.oO(activity, TTDownloadField.TT_ACTIVITY);
            companion.dispatch$lifecycle_runtime_release(activity, event);
        }
    }

    @x0XOIxOo
    public static final void dispatch$lifecycle_runtime_release(@OOXIXo Activity activity, @OOXIXo Lifecycle.Event event) {
        Companion.dispatch$lifecycle_runtime_release(activity, event);
    }

    private final void dispatchCreate(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onCreate();
        }
    }

    private final void dispatchResume(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onResume();
        }
    }

    private final void dispatchStart(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onStart();
        }
    }

    @OOXIXo
    @xxIXOIIO(name = "get")
    public static final ReportFragment get(@OOXIXo Activity activity) {
        return Companion.get(activity);
    }

    @x0XOIxOo
    public static final void injectIfNeededIn(@OOXIXo Activity activity) {
        Companion.injectIfNeededIn(activity);
    }

    public void onActivityCreated(@oOoXoXO Bundle bundle) {
        super.onActivityCreated(bundle);
        dispatchCreate(this.processListener);
        dispatch(Lifecycle.Event.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        dispatch(Lifecycle.Event.ON_DESTROY);
        this.processListener = null;
    }

    public void onPause() {
        super.onPause();
        dispatch(Lifecycle.Event.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        dispatchResume(this.processListener);
        dispatch(Lifecycle.Event.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        dispatchStart(this.processListener);
        dispatch(Lifecycle.Event.ON_START);
    }

    public void onStop() {
        super.onStop();
        dispatch(Lifecycle.Event.ON_STOP);
    }

    public final void setProcessListener(@oOoXoXO ActivityInitializationListener activityInitializationListener) {
        this.processListener = activityInitializationListener;
    }
}
