package androidx.lifecycle;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
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
import kotlinx.coroutines.flow.Oxx0IOOO;
import kotlinx.coroutines.flow.xoIox;
import kotlinx.coroutines.flow.xoXoI;

@XX({"SMAP\nSavedStateHandle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandle.kt\nandroidx/lifecycle/SavedStateHandle\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,450:1\n361#2,3:451\n364#2,4:455\n1#3:454\n*S KotlinDebug\n*F\n+ 1 SavedStateHandle.kt\nandroidx/lifecycle/SavedStateHandle\n*L\n198#1:451,3\n198#1:455,4\n*E\n"})
public final class SavedStateHandle {
    /* access modifiers changed from: private */
    @OOXIXo
    public static final Class<? extends Object>[] ACCEPTABLE_CLASSES = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @OOXIXo
    private static final String KEYS = "keys";
    @OOXIXo
    private static final String VALUES = "values";
    /* access modifiers changed from: private */
    @OOXIXo
    public final Map<String, xoIox<Object>> flows;
    @OOXIXo
    private final Map<String, SavingStateLiveData<?>> liveDatas;
    /* access modifiers changed from: private */
    @OOXIXo
    public final Map<String, Object> regular;
    @OOXIXo
    private final SavedStateRegistry.SavedStateProvider savedStateProvider;
    @OOXIXo
    private final Map<String, SavedStateRegistry.SavedStateProvider> savedStateProviders;

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final SavedStateHandle createHandle(@oOoXoXO Bundle bundle, @oOoXoXO Bundle bundle2) {
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(SavedStateHandle.KEYS);
                ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(SavedStateHandle.VALUES);
                if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                    throw new IllegalStateException("Invalid bundle passed as restored state");
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int size = parcelableArrayList.size();
                for (int i = 0; i < size; i++) {
                    Object obj = parcelableArrayList.get(i);
                    IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlin.String");
                    linkedHashMap.put((String) obj, parcelableArrayList2.get(i));
                }
                return new SavedStateHandle(linkedHashMap);
            } else if (bundle2 == null) {
                return new SavedStateHandle();
            } else {
                HashMap hashMap = new HashMap();
                for (String next : bundle2.keySet()) {
                    IIX0o.oO(next, "key");
                    hashMap.put(next, bundle2.get(next));
                }
                return new SavedStateHandle(hashMap);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean validateValue(@oOoXoXO Object obj) {
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

    public SavedStateHandle(@OOXIXo Map<String, ? extends Object> map) {
        IIX0o.x0xO0oo(map, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.regular = linkedHashMap;
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new OOXIXo(this);
        linkedHashMap.putAll(map);
    }

    @x0XOIxOo
    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final SavedStateHandle createHandle(@oOoXoXO Bundle bundle, @oOoXoXO Bundle bundle2) {
        return Companion.createHandle(bundle, bundle2);
    }

    private final <T> MutableLiveData<T> getLiveDataInternal(String str, boolean z, T t) {
        MutableLiveData<T> mutableLiveData;
        SavingStateLiveData savingStateLiveData;
        SavingStateLiveData<?> savingStateLiveData2 = this.liveDatas.get(str);
        if (savingStateLiveData2 instanceof MutableLiveData) {
            mutableLiveData = savingStateLiveData2;
        } else {
            mutableLiveData = null;
        }
        if (mutableLiveData != null) {
            return mutableLiveData;
        }
        if (this.regular.containsKey(str)) {
            savingStateLiveData = new SavingStateLiveData(this, str, this.regular.get(str));
        } else if (z) {
            this.regular.put(str, t);
            savingStateLiveData = new SavingStateLiveData(this, str, t);
        } else {
            savingStateLiveData = new SavingStateLiveData(this, str);
        }
        this.liveDatas.put(str, savingStateLiveData);
        return savingStateLiveData;
    }

    /* access modifiers changed from: private */
    public static final Bundle savedStateProvider$lambda$0(SavedStateHandle savedStateHandle) {
        IIX0o.x0xO0oo(savedStateHandle, "this$0");
        for (Map.Entry next : o0.OX00O0xII(savedStateHandle.savedStateProviders).entrySet()) {
            savedStateHandle.set((String) next.getKey(), ((SavedStateRegistry.SavedStateProvider) next.getValue()).saveState());
        }
        Set<String> keySet = savedStateHandle.regular.keySet();
        ArrayList arrayList = new ArrayList(keySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String next2 : keySet) {
            arrayList.add(next2);
            arrayList2.add(savedStateHandle.regular.get(next2));
        }
        return BundleKt.bundleOf(Xo0.oIX0oI(KEYS, arrayList), Xo0.oIX0oI(VALUES, arrayList2));
    }

    @MainThread
    public final void clearSavedStateProvider(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "key");
        this.savedStateProviders.remove(str);
    }

    @MainThread
    public final boolean contains(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "key");
        return this.regular.containsKey(str);
    }

    @MainThread
    @oOoXoXO
    public final <T> T get(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "key");
        try {
            return this.regular.get(str);
        } catch (ClassCastException unused) {
            remove(str);
            return null;
        }
    }

    @MainThread
    @OOXIXo
    public final <T> MutableLiveData<T> getLiveData(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "key");
        MutableLiveData<T> liveDataInternal = getLiveDataInternal(str, false, (Object) null);
        IIX0o.x0XOIxOo(liveDataInternal, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T of androidx.lifecycle.SavedStateHandle.getLiveData>");
        return liveDataInternal;
    }

    @MainThread
    @OOXIXo
    public final <T> kotlinx.coroutines.flow.IIXOooo<T> getStateFlow(@OOXIXo String str, T t) {
        IIX0o.x0xO0oo(str, "key");
        Map<String, xoIox<Object>> map = this.flows;
        xoIox<Object> xoiox = map.get(str);
        if (xoiox == null) {
            if (!this.regular.containsKey(str)) {
                this.regular.put(str, t);
            }
            xoiox = xoXoI.oIX0oI(this.regular.get(str));
            this.flows.put(str, xoiox);
            map.put(str, xoiox);
        }
        kotlinx.coroutines.flow.IIXOooo<T> ooOOo0oXI2 = Oxx0IOOO.ooOOo0oXI(xoiox);
        IIX0o.x0XOIxOo(ooOOo0oXI2, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of androidx.lifecycle.SavedStateHandle.getStateFlow>");
        return ooOOo0oXI2;
    }

    @MainThread
    @OOXIXo
    public final Set<String> keys() {
        return XoI0Ixx0.XIxXXX0x0(XoI0Ixx0.XIxXXX0x0(this.regular.keySet(), this.savedStateProviders.keySet()), this.liveDatas.keySet());
    }

    @MainThread
    @oOoXoXO
    public final <T> T remove(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "key");
        T remove = this.regular.remove(str);
        SavingStateLiveData remove2 = this.liveDatas.remove(str);
        if (remove2 != null) {
            remove2.detach();
        }
        this.flows.remove(str);
        return remove;
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.savedStateProvider;
    }

    @MainThread
    public final <T> void set(@OOXIXo String str, @oOoXoXO T t) {
        MutableLiveData mutableLiveData;
        IIX0o.x0xO0oo(str, "key");
        if (Companion.validateValue(t)) {
            SavingStateLiveData<?> savingStateLiveData = this.liveDatas.get(str);
            if (savingStateLiveData instanceof MutableLiveData) {
                mutableLiveData = savingStateLiveData;
            } else {
                mutableLiveData = null;
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(t);
            } else {
                this.regular.put(str, t);
            }
            xoIox xoiox = this.flows.get(str);
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
    public final void setSavedStateProvider(@OOXIXo String str, @OOXIXo SavedStateRegistry.SavedStateProvider savedStateProvider2) {
        IIX0o.x0xO0oo(str, "key");
        IIX0o.x0xO0oo(savedStateProvider2, "provider");
        this.savedStateProviders.put(str, savedStateProvider2);
    }

    @MainThread
    @OOXIXo
    public final <T> MutableLiveData<T> getLiveData(@OOXIXo String str, T t) {
        IIX0o.x0xO0oo(str, "key");
        return getLiveDataInternal(str, true, t);
    }

    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {
        @oOoXoXO
        private SavedStateHandle handle;
        @OOXIXo
        private String key;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavingStateLiveData(@oOoXoXO SavedStateHandle savedStateHandle, @OOXIXo String str, T t) {
            super(t);
            IIX0o.x0xO0oo(str, "key");
            this.key = str;
            this.handle = savedStateHandle;
        }

        public final void detach() {
            this.handle = null;
        }

        public void setValue(T t) {
            SavedStateHandle savedStateHandle = this.handle;
            if (savedStateHandle != null) {
                savedStateHandle.regular.put(this.key, t);
                xoIox xoiox = (xoIox) savedStateHandle.flows.get(this.key);
                if (xoiox != null) {
                    xoiox.setValue(t);
                }
            }
            super.setValue(t);
        }

        public SavingStateLiveData(@oOoXoXO SavedStateHandle savedStateHandle, @OOXIXo String str) {
            IIX0o.x0xO0oo(str, "key");
            this.key = str;
            this.handle = savedStateHandle;
        }
    }

    public SavedStateHandle() {
        this.regular = new LinkedHashMap();
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new OOXIXo(this);
    }
}
