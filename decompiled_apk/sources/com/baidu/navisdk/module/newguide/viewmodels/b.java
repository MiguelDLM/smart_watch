package com.baidu.navisdk.module.newguide.viewmodels;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes7.dex */
public class b {

    /* loaded from: classes7.dex */
    public static class a extends ViewModelProvider.NewInstanceFactory {

        /* renamed from: a, reason: collision with root package name */
        private Bundle f7360a;
        private Application b;

        public a(@NonNull Application application, Bundle bundle) {
            this.f7360a = bundle;
            this.b = application;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            if (AndroidViewModel.class.isAssignableFrom(cls)) {
                try {
                    return cls.getConstructor(Application.class, Bundle.class).newInstance(this.b, this.f7360a);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e);
                } catch (InstantiationException e2) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e2);
                } catch (NoSuchMethodException e3) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e3);
                } catch (InvocationTargetException e4) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e4);
                }
            }
            return (T) super.create(cls);
        }
    }

    public static a a(FragmentActivity fragmentActivity, Bundle bundle) {
        return new a(a(fragmentActivity), bundle);
    }

    public static ViewModelProvider b(FragmentActivity fragmentActivity, Bundle bundle) {
        return new ViewModelProvider(fragmentActivity.getViewModelStore(), a(fragmentActivity, bundle));
    }

    private static Application a(Activity activity) {
        Application application = activity.getApplication();
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }
}
