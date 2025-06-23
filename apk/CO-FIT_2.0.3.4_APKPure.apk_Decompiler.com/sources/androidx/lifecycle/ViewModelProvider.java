package androidx.lifecycle;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import XO0OX.x0XOIxOo;
import XO0OX.xoIox;
import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import com.google.android.exoplayer2.util.MimeTypes;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nViewModelProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewModelProvider.kt\nandroidx/lifecycle/ViewModelProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,375:1\n1#2:376\n*E\n"})
public class ViewModelProvider {
    @OOXIXo
    private final CreationExtras defaultCreationExtras;
    @OOXIXo
    private final Factory factory;
    @OOXIXo
    private final ViewModelStore store;

    public interface Factory {
        @OOXIXo
        public static final Companion Companion = Companion.$$INSTANCE;

        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            @x0XOIxOo
            @OOXIXo
            public final Factory from(@OOXIXo ViewModelInitializer<?>... viewModelInitializerArr) {
                IIX0o.x0xO0oo(viewModelInitializerArr, "initializers");
                return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
            }
        }

        @OOXIXo
        <T extends ViewModel> T create(@OOXIXo Class<T> cls);

        @OOXIXo
        <T extends ViewModel> T create(@OOXIXo Class<T> cls, @OOXIXo CreationExtras creationExtras);
    }

    public static class NewInstanceFactory implements Factory {
        @OOXIXo
        public static final Companion Companion = new Companion((IIXOooo) null);
        @XO
        @OOXIXo
        public static final CreationExtras.Key<String> VIEW_MODEL_KEY = Companion.ViewModelKeyImpl.INSTANCE;
        /* access modifiers changed from: private */
        @oOoXoXO
        public static NewInstanceFactory sInstance;

        public static final class Companion {

            public static final class ViewModelKeyImpl implements CreationExtras.Key<String> {
                @OOXIXo
                public static final ViewModelKeyImpl INSTANCE = new ViewModelKeyImpl();

                private ViewModelKeyImpl() {
                }
            }

            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @x0XOIxOo
            public static /* synthetic */ void getInstance$annotations() {
            }

            @OOXIXo
            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            public final NewInstanceFactory getInstance() {
                if (NewInstanceFactory.sInstance == null) {
                    NewInstanceFactory.sInstance = new NewInstanceFactory();
                }
                NewInstanceFactory access$getSInstance$cp = NewInstanceFactory.sInstance;
                IIX0o.ooOOo0oXI(access$getSInstance$cp);
                return access$getSInstance$cp;
            }

            private Companion() {
            }
        }

        @OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final NewInstanceFactory getInstance() {
            return Companion.getInstance();
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return oOoXoXO.II0xO0(this, cls, creationExtras);
        }

        @OOXIXo
        public <T extends ViewModel> T create(@OOXIXo Class<T> cls) {
            IIX0o.x0xO0oo(cls, "modelClass");
            try {
                T newInstance = cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
                IIX0o.oO(newInstance, "{\n                modelC…wInstance()\n            }");
                return (ViewModel) newInstance;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class OnRequeryFactory {
        public void onRequery(@OOXIXo ViewModel viewModel) {
            IIX0o.x0xO0oo(viewModel, "viewModel");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @xoIox
    public ViewModelProvider(@OOXIXo ViewModelStore viewModelStore, @OOXIXo Factory factory2) {
        this(viewModelStore, factory2, (CreationExtras) null, 4, (IIXOooo) null);
        IIX0o.x0xO0oo(viewModelStore, "store");
        IIX0o.x0xO0oo(factory2, "factory");
    }

    @MainThread
    @OOXIXo
    public <T extends ViewModel> T get(@OOXIXo Class<T> cls) {
        IIX0o.x0xO0oo(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public static class AndroidViewModelFactory extends NewInstanceFactory {
        @XO
        @OOXIXo
        public static final CreationExtras.Key<Application> APPLICATION_KEY = Companion.ApplicationKeyImpl.INSTANCE;
        @OOXIXo
        public static final Companion Companion = new Companion((IIXOooo) null);
        @OOXIXo
        public static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
        /* access modifiers changed from: private */
        @oOoXoXO
        public static AndroidViewModelFactory sInstance;
        @oOoXoXO
        private final Application application;

        public static final class Companion {

            public static final class ApplicationKeyImpl implements CreationExtras.Key<Application> {
                @OOXIXo
                public static final ApplicationKeyImpl INSTANCE = new ApplicationKeyImpl();

                private ApplicationKeyImpl() {
                }
            }

            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @OOXIXo
            public final Factory defaultFactory$lifecycle_viewmodel_release(@OOXIXo ViewModelStoreOwner viewModelStoreOwner) {
                IIX0o.x0xO0oo(viewModelStoreOwner, "owner");
                if (viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory) {
                    return ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory();
                }
                return NewInstanceFactory.Companion.getInstance();
            }

            @x0XOIxOo
            @OOXIXo
            public final AndroidViewModelFactory getInstance(@OOXIXo Application application) {
                IIX0o.x0xO0oo(application, MimeTypes.BASE_TYPE_APPLICATION);
                if (AndroidViewModelFactory.sInstance == null) {
                    AndroidViewModelFactory.sInstance = new AndroidViewModelFactory(application);
                }
                AndroidViewModelFactory access$getSInstance$cp = AndroidViewModelFactory.sInstance;
                IIX0o.ooOOo0oXI(access$getSInstance$cp);
                return access$getSInstance$cp;
            }

            private Companion() {
            }
        }

        private AndroidViewModelFactory(Application application2, int i) {
            this.application = application2;
        }

        @x0XOIxOo
        @OOXIXo
        public static final AndroidViewModelFactory getInstance(@OOXIXo Application application2) {
            return Companion.getInstance(application2);
        }

        @OOXIXo
        public <T extends ViewModel> T create(@OOXIXo Class<T> cls, @OOXIXo CreationExtras creationExtras) {
            IIX0o.x0xO0oo(cls, "modelClass");
            IIX0o.x0xO0oo(creationExtras, "extras");
            if (this.application != null) {
                return create(cls);
            }
            Application application2 = (Application) creationExtras.get(APPLICATION_KEY);
            if (application2 != null) {
                return create(cls, application2);
            }
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }

        public AndroidViewModelFactory() {
            this((Application) null, 0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public AndroidViewModelFactory(@OOXIXo Application application2) {
            this(application2, 0);
            IIX0o.x0xO0oo(application2, MimeTypes.BASE_TYPE_APPLICATION);
        }

        @OOXIXo
        public <T extends ViewModel> T create(@OOXIXo Class<T> cls) {
            IIX0o.x0xO0oo(cls, "modelClass");
            Application application2 = this.application;
            if (application2 != null) {
                return create(cls, application2);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        private final <T extends ViewModel> T create(Class<T> cls, Application application2) {
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            try {
                T t = (ViewModel) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{application2});
                IIX0o.oO(t, "{\n                try {\n…          }\n            }");
                return t;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            }
        }
    }

    @xoIox
    public ViewModelProvider(@OOXIXo ViewModelStore viewModelStore, @OOXIXo Factory factory2, @OOXIXo CreationExtras creationExtras) {
        IIX0o.x0xO0oo(viewModelStore, "store");
        IIX0o.x0xO0oo(factory2, "factory");
        IIX0o.x0xO0oo(creationExtras, "defaultCreationExtras");
        this.store = viewModelStore;
        this.factory = factory2;
        this.defaultCreationExtras = creationExtras;
    }

    @MainThread
    @OOXIXo
    public <T extends ViewModel> T get(@OOXIXo String str, @OOXIXo Class<T> cls) {
        T t;
        IIX0o.x0xO0oo(str, "key");
        IIX0o.x0xO0oo(cls, "modelClass");
        T t2 = this.store.get(str);
        if (cls.isInstance(t2)) {
            Factory factory2 = this.factory;
            OnRequeryFactory onRequeryFactory = factory2 instanceof OnRequeryFactory ? (OnRequeryFactory) factory2 : null;
            if (onRequeryFactory != null) {
                IIX0o.ooOOo0oXI(t2);
                onRequeryFactory.onRequery(t2);
            }
            IIX0o.x0XOIxOo(t2, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return t2;
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.defaultCreationExtras);
        mutableCreationExtras.set(NewInstanceFactory.VIEW_MODEL_KEY, str);
        try {
            t = this.factory.create(cls, mutableCreationExtras);
        } catch (AbstractMethodError unused) {
            t = this.factory.create(cls);
        }
        this.store.put(str, t);
        return t;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewModelProvider(ViewModelStore viewModelStore, Factory factory2, CreationExtras creationExtras, int i, IIXOooo iIXOooo) {
        this(viewModelStore, factory2, (i & 4) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(@OOXIXo ViewModelStoreOwner viewModelStoreOwner) {
        this(viewModelStoreOwner.getViewModelStore(), AndroidViewModelFactory.Companion.defaultFactory$lifecycle_viewmodel_release(viewModelStoreOwner), ViewModelProviderGetKt.defaultCreationExtras(viewModelStoreOwner));
        IIX0o.x0xO0oo(viewModelStoreOwner, "owner");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(@OOXIXo ViewModelStoreOwner viewModelStoreOwner, @OOXIXo Factory factory2) {
        this(viewModelStoreOwner.getViewModelStore(), factory2, ViewModelProviderGetKt.defaultCreationExtras(viewModelStoreOwner));
        IIX0o.x0xO0oo(viewModelStoreOwner, "owner");
        IIX0o.x0xO0oo(factory2, "factory");
    }
}
