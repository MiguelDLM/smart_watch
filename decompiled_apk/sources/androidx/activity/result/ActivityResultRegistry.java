package androidx.activity.result;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.MainThread;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.os.BundleCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.XoX;
import kotlin.random.Random;
import kotlin.sequences.SequencesKt__SequencesKt;

@XX({"SMAP\nActivityResultRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultRegistry.kt\nandroidx/activity/result/ActivityResultRegistry\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,422:1\n123#2,2:423\n*S KotlinDebug\n*F\n+ 1 ActivityResultRegistry.kt\nandroidx/activity/result/ActivityResultRegistry\n*L\n380#1:423,2\n*E\n"})
/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {

    @OOXIXo
    private static final Companion Companion = new Companion(null);
    private static final int INITIAL_REQUEST_CODE_VALUE = 65536;

    @OOXIXo
    private static final String KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS = "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS";

    @OOXIXo
    private static final String KEY_COMPONENT_ACTIVITY_PENDING_RESULTS = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";

    @OOXIXo
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";

    @OOXIXo
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_RCS = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";

    @OOXIXo
    private static final String LOG_TAG = "ActivityResultRegistry";

    @OOXIXo
    private final Map<Integer, String> rcToKey = new LinkedHashMap();

    @OOXIXo
    private final Map<String, Integer> keyToRc = new LinkedHashMap();

    @OOXIXo
    private final Map<String, LifecycleContainer> keyToLifecycleContainers = new LinkedHashMap();

    @OOXIXo
    private final List<String> launchedKeys = new ArrayList();

    @OOXIXo
    private final transient Map<String, CallbackAndContract<?>> keyToCallback = new LinkedHashMap();

    @OOXIXo
    private final Map<String, Object> parsedPendingResults = new LinkedHashMap();

    @OOXIXo
    private final Bundle pendingResults = new Bundle();

    /* loaded from: classes.dex */
    public static final class CallbackAndContract<O> {

        @OOXIXo
        private final ActivityResultCallback<O> callback;

        @OOXIXo
        private final ActivityResultContract<?, O> contract;

        public CallbackAndContract(@OOXIXo ActivityResultCallback<O> callback, @OOXIXo ActivityResultContract<?, O> contract) {
            IIX0o.x0xO0oo(callback, "callback");
            IIX0o.x0xO0oo(contract, "contract");
            this.callback = callback;
            this.contract = contract;
        }

        @OOXIXo
        public final ActivityResultCallback<O> getCallback() {
            return this.callback;
        }

        @OOXIXo
        public final ActivityResultContract<?, O> getContract() {
            return this.contract;
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    @XX({"SMAP\nActivityResultRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultRegistry.kt\nandroidx/activity/result/ActivityResultRegistry$LifecycleContainer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,422:1\n1855#2,2:423\n*S KotlinDebug\n*F\n+ 1 ActivityResultRegistry.kt\nandroidx/activity/result/ActivityResultRegistry$LifecycleContainer\n*L\n402#1:423,2\n*E\n"})
    /* loaded from: classes.dex */
    public static final class LifecycleContainer {

        @OOXIXo
        private final Lifecycle lifecycle;

        @OOXIXo
        private final List<LifecycleEventObserver> observers;

        public LifecycleContainer(@OOXIXo Lifecycle lifecycle) {
            IIX0o.x0xO0oo(lifecycle, "lifecycle");
            this.lifecycle = lifecycle;
            this.observers = new ArrayList();
        }

        public final void addObserver(@OOXIXo LifecycleEventObserver observer) {
            IIX0o.x0xO0oo(observer, "observer");
            this.lifecycle.addObserver(observer);
            this.observers.add(observer);
        }

        public final void clearObservers() {
            Iterator<T> it = this.observers.iterator();
            while (it.hasNext()) {
                this.lifecycle.removeObserver((LifecycleEventObserver) it.next());
            }
            this.observers.clear();
        }

        @OOXIXo
        public final Lifecycle getLifecycle() {
            return this.lifecycle;
        }
    }

    private final void bindRcKey(int i, String str) {
        this.rcToKey.put(Integer.valueOf(i), str);
        this.keyToRc.put(str, Integer.valueOf(i));
    }

    private final <O> void doDispatch(String str, int i, Intent intent, CallbackAndContract<O> callbackAndContract) {
        ActivityResultCallback<O> activityResultCallback;
        if (callbackAndContract != null) {
            activityResultCallback = callbackAndContract.getCallback();
        } else {
            activityResultCallback = null;
        }
        if (activityResultCallback != null && this.launchedKeys.contains(str)) {
            callbackAndContract.getCallback().onActivityResult(callbackAndContract.getContract().parseResult(i, intent));
            this.launchedKeys.remove(str);
        } else {
            this.parsedPendingResults.remove(str);
            this.pendingResults.putParcelable(str, new ActivityResult(i, intent));
        }
    }

    private final int generateRandomNumber() {
        for (Number number : SequencesKt__SequencesKt.oOoXoXO(new Oox.oIX0oI<Integer>() { // from class: androidx.activity.result.ActivityResultRegistry$generateRandomNumber$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final Integer invoke() {
                return Integer.valueOf(Random.Default.nextInt(2147418112) + 65536);
            }
        })) {
            if (!this.rcToKey.containsKey(Integer.valueOf(number.intValue()))) {
                return number.intValue();
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void register$lambda$1(ActivityResultRegistry activityResultRegistry, String str, ActivityResultCallback activityResultCallback, ActivityResultContract activityResultContract, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        IIX0o.x0xO0oo(lifecycleOwner, "<anonymous parameter 0>");
        IIX0o.x0xO0oo(event, "event");
        if (Lifecycle.Event.ON_START == event) {
            activityResultRegistry.keyToCallback.put(str, new CallbackAndContract<>(activityResultCallback, activityResultContract));
            if (activityResultRegistry.parsedPendingResults.containsKey(str)) {
                Object obj = activityResultRegistry.parsedPendingResults.get(str);
                activityResultRegistry.parsedPendingResults.remove(str);
                activityResultCallback.onActivityResult(obj);
            }
            ActivityResult activityResult = (ActivityResult) BundleCompat.getParcelable(activityResultRegistry.pendingResults, str, ActivityResult.class);
            if (activityResult != null) {
                activityResultRegistry.pendingResults.remove(str);
                activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.getResultCode(), activityResult.getData()));
                return;
            }
            return;
        }
        if (Lifecycle.Event.ON_STOP == event) {
            activityResultRegistry.keyToCallback.remove(str);
        } else if (Lifecycle.Event.ON_DESTROY == event) {
            activityResultRegistry.unregister$activity_release(str);
        }
    }

    private final void registerKey(String str) {
        if (this.keyToRc.get(str) != null) {
            return;
        }
        bindRcKey(generateRandomNumber(), str);
    }

    @MainThread
    public final boolean dispatchResult(int i, int i2, @oOoXoXO Intent intent) {
        String str = this.rcToKey.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        doDispatch(str, i2, intent, this.keyToCallback.get(str));
        return true;
    }

    @MainThread
    public abstract <I, O> void onLaunch(int i, @OOXIXo ActivityResultContract<I, O> activityResultContract, I i2, @oOoXoXO ActivityOptionsCompat activityOptionsCompat);

    public final void onRestoreInstanceState(@oOoXoXO Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS);
        ArrayList<String> stringArrayList = bundle.getStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS);
        if (stringArrayList != null && integerArrayList != null) {
            ArrayList<String> stringArrayList2 = bundle.getStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS);
            if (stringArrayList2 != null) {
                this.launchedKeys.addAll(stringArrayList2);
            }
            Bundle bundle2 = bundle.getBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS);
            if (bundle2 != null) {
                this.pendingResults.putAll(bundle2);
            }
            int size = stringArrayList.size();
            for (int i = 0; i < size; i++) {
                String str = stringArrayList.get(i);
                if (this.keyToRc.containsKey(str)) {
                    Integer remove = this.keyToRc.remove(str);
                    if (!this.pendingResults.containsKey(str)) {
                        XoX.OOXIXo(this.rcToKey).remove(remove);
                    }
                }
                Integer num = integerArrayList.get(i);
                IIX0o.oO(num, "rcs[i]");
                int intValue = num.intValue();
                String str2 = stringArrayList.get(i);
                IIX0o.oO(str2, "keys[i]");
                bindRcKey(intValue, str2);
            }
        }
    }

    public final void onSaveInstanceState(@OOXIXo Bundle outState) {
        IIX0o.x0xO0oo(outState, "outState");
        outState.putIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS, new ArrayList<>(this.keyToRc.values()));
        outState.putStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS, new ArrayList<>(this.keyToRc.keySet()));
        outState.putStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS, new ArrayList<>(this.launchedKeys));
        outState.putBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS, new Bundle(this.pendingResults));
    }

    @OOXIXo
    public final <I, O> ActivityResultLauncher<I> register(@OOXIXo final String key, @OOXIXo LifecycleOwner lifecycleOwner, @OOXIXo final ActivityResultContract<I, O> contract, @OOXIXo final ActivityResultCallback<O> callback) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(lifecycleOwner, "lifecycleOwner");
        IIX0o.x0xO0oo(contract, "contract");
        IIX0o.x0xO0oo(callback, "callback");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (!lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            registerKey(key);
            LifecycleContainer lifecycleContainer = this.keyToLifecycleContainers.get(key);
            if (lifecycleContainer == null) {
                lifecycleContainer = new LifecycleContainer(lifecycle);
            }
            lifecycleContainer.addObserver(new LifecycleEventObserver() { // from class: androidx.activity.result.I0Io
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                    ActivityResultRegistry.register$lambda$1(ActivityResultRegistry.this, key, callback, contract, lifecycleOwner2, event);
                }
            });
            this.keyToLifecycleContainers.put(key, lifecycleContainer);
            return new ActivityResultLauncher<I>() { // from class: androidx.activity.result.ActivityResultRegistry$register$2
                @Override // androidx.activity.result.ActivityResultLauncher
                public ActivityResultContract<I, ?> getContract() {
                    return (ActivityResultContract<I, ?>) contract;
                }

                @Override // androidx.activity.result.ActivityResultLauncher
                public void launch(I i, ActivityOptionsCompat activityOptionsCompat) {
                    Map map;
                    List list;
                    List list2;
                    map = ActivityResultRegistry.this.keyToRc;
                    Object obj = map.get(key);
                    Object obj2 = contract;
                    if (obj != null) {
                        int intValue = ((Number) obj).intValue();
                        list = ActivityResultRegistry.this.launchedKeys;
                        list.add(key);
                        try {
                            ActivityResultRegistry.this.onLaunch(intValue, contract, i, activityOptionsCompat);
                            return;
                        } catch (Exception e) {
                            list2 = ActivityResultRegistry.this.launchedKeys;
                            list2.remove(key);
                            throw e;
                        }
                    }
                    throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + obj2 + " and input " + i + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
                }

                @Override // androidx.activity.result.ActivityResultLauncher
                public void unregister() {
                    ActivityResultRegistry.this.unregister$activity_release(key);
                }
            };
        }
        throw new IllegalStateException(("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.").toString());
    }

    @MainThread
    public final void unregister$activity_release(@OOXIXo String key) {
        Integer remove;
        IIX0o.x0xO0oo(key, "key");
        if (!this.launchedKeys.contains(key) && (remove = this.keyToRc.remove(key)) != null) {
            this.rcToKey.remove(remove);
        }
        this.keyToCallback.remove(key);
        if (this.parsedPendingResults.containsKey(key)) {
            Log.w(LOG_TAG, "Dropping pending result for request " + key + ": " + this.parsedPendingResults.get(key));
            this.parsedPendingResults.remove(key);
        }
        if (this.pendingResults.containsKey(key)) {
            Log.w(LOG_TAG, "Dropping pending result for request " + key + ": " + ((ActivityResult) BundleCompat.getParcelable(this.pendingResults, key, ActivityResult.class)));
            this.pendingResults.remove(key);
        }
        LifecycleContainer lifecycleContainer = this.keyToLifecycleContainers.get(key);
        if (lifecycleContainer != null) {
            lifecycleContainer.clearObservers();
            this.keyToLifecycleContainers.remove(key);
        }
    }

    @MainThread
    public final <O> boolean dispatchResult(int i, O o) {
        String str = this.rcToKey.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        CallbackAndContract<?> callbackAndContract = this.keyToCallback.get(str);
        if ((callbackAndContract != null ? callbackAndContract.getCallback() : null) == null) {
            this.pendingResults.remove(str);
            this.parsedPendingResults.put(str, o);
            return true;
        }
        ActivityResultCallback<?> callback = callbackAndContract.getCallback();
        IIX0o.x0XOIxOo(callback, "null cannot be cast to non-null type androidx.activity.result.ActivityResultCallback<O of androidx.activity.result.ActivityResultRegistry.dispatchResult>");
        if (!this.launchedKeys.remove(str)) {
            return true;
        }
        callback.onActivityResult(o);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OOXIXo
    public final <I, O> ActivityResultLauncher<I> register(@OOXIXo final String key, @OOXIXo final ActivityResultContract<I, O> contract, @OOXIXo ActivityResultCallback<O> callback) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(contract, "contract");
        IIX0o.x0xO0oo(callback, "callback");
        registerKey(key);
        this.keyToCallback.put(key, new CallbackAndContract<>(callback, contract));
        if (this.parsedPendingResults.containsKey(key)) {
            Object obj = this.parsedPendingResults.get(key);
            this.parsedPendingResults.remove(key);
            callback.onActivityResult(obj);
        }
        ActivityResult activityResult = (ActivityResult) BundleCompat.getParcelable(this.pendingResults, key, ActivityResult.class);
        if (activityResult != null) {
            this.pendingResults.remove(key);
            callback.onActivityResult(contract.parseResult(activityResult.getResultCode(), activityResult.getData()));
        }
        return new ActivityResultLauncher<I>() { // from class: androidx.activity.result.ActivityResultRegistry$register$3
            @Override // androidx.activity.result.ActivityResultLauncher
            public ActivityResultContract<I, ?> getContract() {
                return (ActivityResultContract<I, ?>) contract;
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void launch(I i, ActivityOptionsCompat activityOptionsCompat) {
                Map map;
                List list;
                List list2;
                map = ActivityResultRegistry.this.keyToRc;
                Object obj2 = map.get(key);
                Object obj3 = contract;
                if (obj2 != null) {
                    int intValue = ((Number) obj2).intValue();
                    list = ActivityResultRegistry.this.launchedKeys;
                    list.add(key);
                    try {
                        ActivityResultRegistry.this.onLaunch(intValue, contract, i, activityOptionsCompat);
                        return;
                    } catch (Exception e) {
                        list2 = ActivityResultRegistry.this.launchedKeys;
                        list2.remove(key);
                        throw e;
                    }
                }
                throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + obj3 + " and input " + i + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void unregister() {
                ActivityResultRegistry.this.unregister$activity_release(key);
            }
        };
    }
}
