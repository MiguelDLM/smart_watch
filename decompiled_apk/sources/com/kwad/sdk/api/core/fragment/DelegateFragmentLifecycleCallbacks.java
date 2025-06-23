package com.kwad.sdk.api.core.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;

/* loaded from: classes11.dex */
class DelegateFragmentLifecycleCallbacks extends FragmentManager.FragmentLifecycleCallbacks {
    private final KsFragmentManager.FragmentLifecycleCallbacks mBase;
    private final KsFragmentManager mFragmentManager;

    public DelegateFragmentLifecycleCallbacks(KsFragmentManager ksFragmentManager, KsFragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.mBase = fragmentLifecycleCallbacks;
        this.mFragmentManager = ksFragmentManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentActivityCreated(fragmentManager, fragment, bundle);
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentActivityCreated(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        super.onFragmentAttached(fragmentManager, fragment, context);
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentAttached(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), context);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentCreated(fragmentManager, fragment, bundle);
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentCreated(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentDestroyed(fragmentManager, fragment);
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentDestroyed(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentDetached(fragmentManager, fragment);
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentDetached(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentPaused(fragmentManager, fragment);
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentPaused(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPreAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        super.onFragmentPreAttached(fragmentManager, fragment, context);
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentPreAttached(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), context);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentPreCreated(fragmentManager, fragment, bundle);
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentPreCreated(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentResumed(fragmentManager, fragment);
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentResumed(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentSaveInstanceState(fragmentManager, fragment, bundle);
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentSaveInstanceState(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentStarted(fragmentManager, fragment);
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentStarted(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentStopped(fragmentManager, fragment);
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentStopped(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        super.onFragmentViewCreated(fragmentManager, fragment, view, bundle);
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentViewCreated(this.mFragmentManager, ((IDelegateFragment) fragment).getBase(), view, bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentViewDestroyed(fragmentManager, fragment);
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onFragmentViewDestroyed(this.mFragmentManager, ((IDelegateFragment) fragment).getBase());
        }
    }
}
