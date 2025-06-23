package androidx.lifecycle;

import XO0OX.x0XOIxOo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Xo0;
import kotlin.collections.XoI0Ixx0;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.flow.xoXoI;

@XX({"SMAP\nSavedStateHandle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandle.kt\nandroidx/lifecycle/SavedStateHandle\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,450:1\n361#2,3:451\n364#2,4:455\n1#3:454\n*S KotlinDebug\n*F\n+ 1 SavedStateHandle.kt\nandroidx/lifecycle/SavedStateHandle\n*L\n198#1:451,3\n198#1:455,4\n*E\n"})
/* loaded from: classes.dex */
public final class SavedStateHandle {

    @OXOo.OOXIXo
    private static final String KEYS = "keys";

    @OXOo.OOXIXo
    private static final String VALUES = "values";

    @OXOo.OOXIXo
    private final Map<String, kotlinx.coroutines.flow.xoIox<Object>> flows;

    @OXOo.OOXIXo
    private final Map<String, SavingStateLiveData<?>> liveDatas;

    @OXOo.OOXIXo
    private final Map<String, Object> regular;

    @OXOo.OOXIXo
    private final SavedStateRegistry.SavedStateProvider savedStateProvider;

    @OXOo.OOXIXo
    private final Map<String, SavedStateRegistry.SavedStateProvider> savedStateProviders;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final Class<? extends Object>[] ACCEPTABLE_CLASSES = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final SavedStateHandle createHandle(@OXOo.oOoXoXO Bundle bundle, @OXOo.oOoXoXO Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new SavedStateHandle();
                }
                HashMap hashMap = new HashMap();
                for (String key : bundle2.keySet()) {
                    IIX0o.oO(key, "key");
                    hashMap.put(key, bundle2.get(key));
                }
                return new SavedStateHandle(hashMap);
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(SavedStateHandle.KEYS);
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(SavedStateHandle.VALUES);
            if (parcelableArrayList != null && parcelableArrayList2 != null && parcelableArrayList.size() == parcelableArrayList2.size()) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int size = parcelableArrayList.size();
                for (int i = 0; i < size; i++) {
                    Object obj = parcelableArrayList.get(i);
                    IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlin.String");
                    linkedHashMap.put((String) obj, parcelableArrayList2.get(i));
                }
                return new SavedStateHandle(linkedHashMap);
            }
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean validateValue(@OXOo.oOoXoXO Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : SavedStateHandle.ACCEPTABLE_CLASSES) {
                IIX0o.ooOOo0oXI(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }

        private Companion() {
        }
    }

    public SavedStateHandle(@OXOo.OOXIXo Map<String, ? extends Object> initialState) {
        IIX0o.x0xO0oo(initialState, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.regular = linkedHashMap;
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.OOXIXo
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle saveState() {
                Bundle savedStateProvider$lambda$0;
                savedStateProvider$lambda$0 = SavedStateHandle.savedStateProvider$lambda$0(SavedStateHandle.this);
                return savedStateProvider$lambda$0;
            }
        };
        linkedHashMap.putAll(initialState);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final SavedStateHandle createHandle(@OXOo.oOoXoXO Bundle bundle, @OXOo.oOoXoXO Bundle bundle2) {
        return Companion.createHandle(bundle, bundle2);
    }

    private final <T> MutableLiveData<T> getLiveDataInternal(String str, boolean z, T t) {
        SavingStateLiveData<?> savingStateLiveData;
        SavingStateLiveData<?> savingStateLiveData2;
        SavingStateLiveData<?> savingStateLiveData3 = this.liveDatas.get(str);
        if (savingStateLiveData3 instanceof MutableLiveData) {
            savingStateLiveData = savingStateLiveData3;
        } else {
            savingStateLiveData = null;
        }
        if (savingStateLiveData != null) {
            return savingStateLiveData;
        }
        if (this.regular.containsKey(str)) {
            savingStateLiveData2 = new SavingStateLiveData<>(this, str, this.regular.get(str));
        } else if (z) {
            this.regular.put(str, t);
            savingStateLiveData2 = new SavingStateLiveData<>(this, str, t);
        } else {
            savingStateLiveData2 = new SavingStateLiveData<>(this, str);
        }
        this.liveDatas.put(str, savingStateLiveData2);
        return savingStateLiveData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle savedStateProvider$lambda$0(SavedStateHandle this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        for (Map.Entry entry : o0.OX00O0xII(this$0.savedStateProviders).entrySet()) {
            this$0.set((String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
        }
        Set<String> keySet = this$0.regular.keySet();
        ArrayList arrayList = new ArrayList(keySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : keySet) {
            arrayList.add(str);
            arrayList2.add(this$0.regular.get(str));
        }
        return BundleKt.bundleOf(Xo0.oIX0oI(KEYS, arrayList), Xo0.oIX0oI(VALUES, arrayList2));
    }

    @MainThread
    public final void clearSavedStateProvider(@OXOo.OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        this.savedStateProviders.remove(key);
    }

    @MainThread
    public final boolean contains(@OXOo.OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        return this.regular.containsKey(key);
    }

    @OXOo.oOoXoXO
    @MainThread
    public final <T> T get(@OXOo.OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        try {
            return (T) this.regular.get(key);
        } catch (ClassCastException unused) {
            remove(key);
            return null;
        }
    }

    @OXOo.OOXIXo
    @MainThread
    public final <T> MutableLiveData<T> getLiveData(@OXOo.OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        MutableLiveData<T> liveDataInternal = getLiveDataInternal(key, false, null);
        IIX0o.x0XOIxOo(liveDataInternal, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T of androidx.lifecycle.SavedStateHandle.getLiveData>");
        return liveDataInternal;
    }

    @OXOo.OOXIXo
    @MainThread
    public final <T> kotlinx.coroutines.flow.IIXOooo<T> getStateFlow(@OXOo.OOXIXo String key, T t) {
        IIX0o.x0xO0oo(key, "key");
        Map<String, kotlinx.coroutines.flow.xoIox<Object>> map = this.flows;
        kotlinx.coroutines.flow.xoIox<Object> xoiox = map.get(key);
        if (xoiox == null) {
            if (!this.regular.containsKey(key)) {
                this.regular.put(key, t);
            }
            xoiox = xoXoI.oIX0oI(this.regular.get(key));
            this.flows.put(key, xoiox);
            map.put(key, xoiox);
        }
        kotlinx.coroutines.flow.IIXOooo<T> ooOOo0oXI2 = kotlinx.coroutines.flow.Oxx0IOOO.ooOOo0oXI(xoiox);
        IIX0o.x0XOIxOo(ooOOo0oXI2, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of androidx.lifecycle.SavedStateHandle.getStateFlow>");
        return ooOOo0oXI2;
    }

    @OXOo.OOXIXo
    @MainThread
    public final Set<String> keys() {
        return XoI0Ixx0.XIxXXX0x0(XoI0Ixx0.XIxXXX0x0(this.regular.keySet(), this.savedStateProviders.keySet()), this.liveDatas.keySet());
    }

    @OXOo.oOoXoXO
    @MainThread
    public final <T> T remove(@OXOo.OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        T t = (T) this.regular.remove(key);
        SavingStateLiveData<?> remove = this.liveDatas.remove(key);
        if (remove != null) {
            remove.detach();
        }
        this.flows.remove(key);
        return t;
    }

    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.savedStateProvider;
    }

    @MainThread
    public final <T> void set(@OXOo.OOXIXo String key, @OXOo.oOoXoXO T t) {
        SavingStateLiveData<?> savingStateLiveData;
        IIX0o.x0xO0oo(key, "key");
        if (Companion.validateValue(t)) {
            SavingStateLiveData<?> savingStateLiveData2 = this.liveDatas.get(key);
            if (savingStateLiveData2 instanceof MutableLiveData) {
                savingStateLiveData = savingStateLiveData2;
            } else {
                savingStateLiveData = null;
            }
            if (savingStateLiveData != null) {
                savingStateLiveData.setValue(t);
            } else {
                this.regular.put(key, t);
            }
            kotlinx.coroutines.flow.xoIox<Object> xoiox = this.flows.get(key);
            if (xoiox != null) {
                xoiox.setValue(t);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't put value with type ");
        IIX0o.ooOOo0oXI(t);
        sb.append(t.getClass());
        sb.append(" into saved state");
        throw new IllegalArgumentException(sb.toString());
    }

    @MainThread
    public final void setSavedStateProvider(@OXOo.OOXIXo String key, @OXOo.OOXIXo SavedStateRegistry.SavedStateProvider provider) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(provider, "provider");
        this.savedStateProviders.put(key, provider);
    }

    @OXOo.OOXIXo
    @MainThread
    public final <T> MutableLiveData<T> getLiveData(@OXOo.OOXIXo String key, T t) {
        IIX0o.x0xO0oo(key, "key");
        return getLiveDataInternal(key, true, t);
    }

    /* loaded from: classes.dex */
    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {

        @OXOo.oOoXoXO
        private SavedStateHandle handle;

        @OXOo.OOXIXo
        private String key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavingStateLiveData(@OXOo.oOoXoXO SavedStateHandle savedStateHandle, @OXOo.OOXIXo String key, T t) {
            super(t);
            IIX0o.x0xO0oo(key, "key");
            this.key = key;
            this.handle = savedStateHandle;
        }

        public final void detach() {
            this.handle = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(T t) {
            SavedStateHandle savedStateHandle = this.handle;
            if (savedStateHandle != null) {
                savedStateHandle.regular.put(this.key, t);
                kotlinx.coroutines.flow.xoIox xoiox = (kotlinx.coroutines.flow.xoIox) savedStateHandle.flows.get(this.key);
                if (xoiox != null) {
                    xoiox.setValue(t);
                }
            }
            super.setValue(t);
        }

        public SavingStateLiveData(@OXOo.oOoXoXO SavedStateHandle savedStateHandle, @OXOo.OOXIXo String key) {
            IIX0o.x0xO0oo(key, "key");
            this.key = key;
            this.handle = savedStateHandle;
        }
    }

    public SavedStateHandle() {
        this.regular = new LinkedHashMap();
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.OOXIXo
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle saveState() {
                Bundle savedStateProvider$lambda$0;
                savedStateProvider$lambda$0 = SavedStateHandle.savedStateProvider$lambda$0(SavedStateHandle.this);
                return savedStateProvider$lambda$0;
            }
        };
    }
}
