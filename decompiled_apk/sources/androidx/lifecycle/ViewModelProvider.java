package androidx.lifecycle;

import XO0OX.x0XOIxOo;
import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nViewModelProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewModelProvider.kt\nandroidx/lifecycle/ViewModelProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,375:1\n1#2:376\n*E\n"})
/* loaded from: classes.dex */
public class ViewModelProvider {

    @OXOo.OOXIXo
    private final CreationExtras defaultCreationExtras;

    @OXOo.OOXIXo
    private final Factory factory;

    @OXOo.OOXIXo
    private final ViewModelStore store;

    /* loaded from: classes.dex */
    public interface Factory {

        @OXOo.OOXIXo
        public static final Companion Companion = Companion.$$INSTANCE;

        /* loaded from: classes.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            @x0XOIxOo
            @OXOo.OOXIXo
            public final Factory from(@OXOo.OOXIXo ViewModelInitializer<?>... initializers) {
                IIX0o.x0xO0oo(initializers, "initializers");
                return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(initializers, initializers.length));
            }
        }

        @OXOo.OOXIXo
        <T extends ViewModel> T create(@OXOo.OOXIXo Class<T> cls);

        @OXOo.OOXIXo
        <T extends ViewModel> T create(@OXOo.OOXIXo Class<T> cls, @OXOo.OOXIXo CreationExtras creationExtras);
    }

    /* loaded from: classes.dex */
    public static class NewInstanceFactory implements Factory {

        @OXOo.OOXIXo
        public static final Companion Companion = new Companion(null);

        @OXOo.OOXIXo
        @XO0OX.XO
        public static final CreationExtras.Key<String> VIEW_MODEL_KEY = Companion.ViewModelKeyImpl.INSTANCE;

        @OXOo.oOoXoXO
        private static NewInstanceFactory sInstance;

        /* loaded from: classes.dex */
        public static final class Companion {

            /* loaded from: classes.dex */
            public static final class ViewModelKeyImpl implements CreationExtras.Key<String> {

                @OXOo.OOXIXo
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

            @OXOo.OOXIXo
            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            public final NewInstanceFactory getInstance() {
                if (NewInstanceFactory.sInstance == null) {
                    NewInstanceFactory.sInstance = new NewInstanceFactory();
                }
                NewInstanceFactory newInstanceFactory = NewInstanceFactory.sInstance;
                IIX0o.ooOOo0oXI(newInstanceFactory);
                return newInstanceFactory;
            }

            private Companion() {
            }
        }

        @OXOo.OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final NewInstanceFactory getInstance() {
            return Companion.getInstance();
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return oOoXoXO.II0xO0(this, cls, creationExtras);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @OXOo.OOXIXo
        public <T extends ViewModel> T create(@OXOo.OOXIXo Class<T> modelClass) {
            IIX0o.x0xO0oo(modelClass, "modelClass");
            try {
                T newInstance = modelClass.getDeclaredConstructor(null).newInstance(null);
                IIX0o.oO(newInstance, "{\n                modelC…wInstance()\n            }");
                return newInstance;
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e3);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public static class OnRequeryFactory {
        public void onRequery(@OXOo.OOXIXo ViewModel viewModel) {
            IIX0o.x0xO0oo(viewModel, "viewModel");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ViewModelProvider(@OXOo.OOXIXo ViewModelStore store, @OXOo.OOXIXo Factory factory) {
        this(store, factory, null, 4, null);
        IIX0o.x0xO0oo(store, "store");
        IIX0o.x0xO0oo(factory, "factory");
    }

    @OXOo.OOXIXo
    @MainThread
    public <T extends ViewModel> T get(@OXOo.OOXIXo Class<T> modelClass) {
        IIX0o.x0xO0oo(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return (T) get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* loaded from: classes.dex */
    public static class AndroidViewModelFactory extends NewInstanceFactory {

        @OXOo.OOXIXo
        public static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";

        @OXOo.oOoXoXO
        private static AndroidViewModelFactory sInstance;

        @OXOo.oOoXoXO
        private final Application application;

        @OXOo.OOXIXo
        public static final Companion Companion = new Companion(null);

        @OXOo.OOXIXo
        @XO0OX.XO
        public static final CreationExtras.Key<Application> APPLICATION_KEY = Companion.ApplicationKeyImpl.INSTANCE;

        /* loaded from: classes.dex */
        public static final class Companion {

            /* loaded from: classes.dex */
            public static final class ApplicationKeyImpl implements CreationExtras.Key<Application> {

                @OXOo.OOXIXo
                public static final ApplicationKeyImpl INSTANCE = new ApplicationKeyImpl();

                private ApplicationKeyImpl() {
                }
            }

            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @OXOo.OOXIXo
            public final Factory defaultFactory$lifecycle_viewmodel_release(@OXOo.OOXIXo ViewModelStoreOwner owner) {
                IIX0o.x0xO0oo(owner, "owner");
                if (owner instanceof HasDefaultViewModelProviderFactory) {
                    return ((HasDefaultViewModelProviderFactory) owner).getDefaultViewModelProviderFactory();
                }
                return NewInstanceFactory.Companion.getInstance();
            }

            @x0XOIxOo
            @OXOo.OOXIXo
            public final AndroidViewModelFactory getInstance(@OXOo.OOXIXo Application application) {
                IIX0o.x0xO0oo(application, "application");
                if (AndroidViewModelFactory.sInstance == null) {
                    AndroidViewModelFactory.sInstance = new AndroidViewModelFactory(application);
                }
                AndroidViewModelFactory androidViewModelFactory = AndroidViewModelFactory.sInstance;
                IIX0o.ooOOo0oXI(androidViewModelFactory);
                return androidViewModelFactory;
            }

            private Companion() {
            }
        }

        private AndroidViewModelFactory(Application application, int i) {
            this.application = application;
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public static final AndroidViewModelFactory getInstance(@OXOo.OOXIXo Application application) {
            return Companion.getInstance(application);
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        @OXOo.OOXIXo
        public <T extends ViewModel> T create(@OXOo.OOXIXo Class<T> modelClass, @OXOo.OOXIXo CreationExtras extras) {
            IIX0o.x0xO0oo(modelClass, "modelClass");
            IIX0o.x0xO0oo(extras, "extras");
            if (this.application != null) {
                return (T) create(modelClass);
            }
            Application application = (Application) extras.get(APPLICATION_KEY);
            if (application != null) {
                return (T) create(modelClass, application);
            }
            if (!AndroidViewModel.class.isAssignableFrom(modelClass)) {
                return (T) super.create(modelClass);
            }
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }

        public AndroidViewModelFactory() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public AndroidViewModelFactory(@OXOo.OOXIXo Application application) {
            this(application, 0);
            IIX0o.x0xO0oo(application, "application");
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        @OXOo.OOXIXo
        public <T extends ViewModel> T create(@OXOo.OOXIXo Class<T> modelClass) {
            IIX0o.x0xO0oo(modelClass, "modelClass");
            Application application = this.application;
            if (application != null) {
                return (T) create(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        private final <T extends ViewModel> T create(Class<T> cls, Application application) {
            if (AndroidViewModel.class.isAssignableFrom(cls)) {
                try {
                    T newInstance = cls.getConstructor(Application.class).newInstance(application);
                    IIX0o.oO(newInstance, "{\n                try {\n…          }\n            }");
                    return newInstance;
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

    @XO0OX.xoIox
    public ViewModelProvider(@OXOo.OOXIXo ViewModelStore store, @OXOo.OOXIXo Factory factory, @OXOo.OOXIXo CreationExtras defaultCreationExtras) {
        IIX0o.x0xO0oo(store, "store");
        IIX0o.x0xO0oo(factory, "factory");
        IIX0o.x0xO0oo(defaultCreationExtras, "defaultCreationExtras");
        this.store = store;
        this.factory = factory;
        this.defaultCreationExtras = defaultCreationExtras;
    }

    @OXOo.OOXIXo
    @MainThread
    public <T extends ViewModel> T get(@OXOo.OOXIXo String key, @OXOo.OOXIXo Class<T> modelClass) {
        T t;
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(modelClass, "modelClass");
        T t2 = (T) this.store.get(key);
        if (modelClass.isInstance(t2)) {
            Object obj = this.factory;
            OnRequeryFactory onRequeryFactory = obj instanceof OnRequeryFactory ? (OnRequeryFactory) obj : null;
            if (onRequeryFactory != null) {
                IIX0o.ooOOo0oXI(t2);
                onRequeryFactory.onRequery(t2);
            }
            IIX0o.x0XOIxOo(t2, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return t2;
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.defaultCreationExtras);
        mutableCreationExtras.set(NewInstanceFactory.VIEW_MODEL_KEY, key);
        try {
            t = (T) this.factory.create(modelClass, mutableCreationExtras);
        } catch (AbstractMethodError unused) {
            t = (T) this.factory.create(modelClass);
        }
        this.store.put(key, t);
        return t;
    }

    public /* synthetic */ ViewModelProvider(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras, int i, IIXOooo iIXOooo) {
        this(viewModelStore, factory, (i & 4) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(@OXOo.OOXIXo ViewModelStoreOwner owner) {
        this(owner.getViewModelStore(), AndroidViewModelFactory.Companion.defaultFactory$lifecycle_viewmodel_release(owner), ViewModelProviderGetKt.defaultCreationExtras(owner));
        IIX0o.x0xO0oo(owner, "owner");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(@OXOo.OOXIXo ViewModelStoreOwner owner, @OXOo.OOXIXo Factory factory) {
        this(owner.getViewModelStore(), factory, ViewModelProviderGetKt.defaultCreationExtras(owner));
        IIX0o.x0xO0oo(owner, "owner");
        IIX0o.x0xO0oo(factory, "factory");
    }
}
