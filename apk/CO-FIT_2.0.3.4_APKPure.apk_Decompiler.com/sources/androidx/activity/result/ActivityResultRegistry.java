package androidx.activity.result;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.MainThread;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.huawei.openalliance.ad.constant.bn;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.XoX;
import kotlin.sequences.SequencesKt__SequencesKt;

@XX({"SMAP\nActivityResultRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultRegistry.kt\nandroidx/activity/result/ActivityResultRegistry\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,422:1\n123#2,2:423\n*S KotlinDebug\n*F\n+ 1 ActivityResultRegistry.kt\nandroidx/activity/result/ActivityResultRegistry\n*L\n380#1:423,2\n*E\n"})
public abstract class ActivityResultRegistry {
    @OOXIXo
    private static final Companion Companion = new Companion((IIXOooo) null);
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
    private final transient Map<String, CallbackAndContract<?>> keyToCallback = new LinkedHashMap();
    @OOXIXo
    private final Map<String, LifecycleContainer> keyToLifecycleContainers = new LinkedHashMap();
    /* access modifiers changed from: private */
    @OOXIXo
    public final Map<String, Integer> keyToRc = new LinkedHashMap();
    /* access modifiers changed from: private */
    @OOXIXo
    public final List<String> launchedKeys = new ArrayList();
    @OOXIXo
    private final Map<String, Object> parsedPendingResults = new LinkedHashMap();
    @OOXIXo
    private final Bundle pendingResults = new Bundle();
    @OOXIXo
    private final Map<Integer, String> rcToKey = new LinkedHashMap();

    public static final class CallbackAndContract<O> {
        @OOXIXo
        private final ActivityResultCallback<O> callback;
        @OOXIXo
        private final ActivityResultContract<?, O> contract;

        public CallbackAndContract(@OOXIXo ActivityResultCallback<O> activityResultCallback, @OOXIXo ActivityResultContract<?, O> activityResultContract) {
            IIX0o.x0xO0oo(activityResultCallback, bn.f.L);
            IIX0o.x0xO0oo(activityResultContract, "contract");
            this.callback = activityResultCallback;
            this.contract = activityResultContract;
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

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    @XX({"SMAP\nActivityResultRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultRegistry.kt\nandroidx/activity/result/ActivityResultRegistry$LifecycleContainer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,422:1\n1855#2,2:423\n*S KotlinDebug\n*F\n+ 1 ActivityResultRegistry.kt\nandroidx/activity/result/ActivityResultRegistry$LifecycleContainer\n*L\n402#1:423,2\n*E\n"})
    public static final class LifecycleContainer {
        @OOXIXo
        private final Lifecycle lifecycle;
        @OOXIXo
        private final List<LifecycleEventObserver> observers = new ArrayList();

        public LifecycleContainer(@OOXIXo Lifecycle lifecycle2) {
            IIX0o.x0xO0oo(lifecycle2, RequestParameters.SUBRESOURCE_LIFECYCLE);
            this.lifecycle = lifecycle2;
        }

        public final void addObserver(@OOXIXo LifecycleEventObserver lifecycleEventObserver) {
            IIX0o.x0xO0oo(lifecycleEventObserver, "observer");
            this.lifecycle.addObserver(lifecycleEventObserver);
            this.observers.add(lifecycleEventObserver);
        }

        public final void clearObservers() {
            for (LifecycleEventObserver removeObserver : this.observers) {
                this.lifecycle.removeObserver(removeObserver);
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
        if (activityResultCallback == null || !this.launchedKeys.contains(str)) {
            this.parsedPendingResults.remove(str);
            this.pendingResults.putParcelable(str, new ActivityResult(i, intent));
            return;
        }
        callbackAndContract.getCallback().onActivityResult(callbackAndContract.getContract().parseResult(i, intent));
        this.launchedKeys.remove(str);
    }

    private final int generateRandomNumber() {
        for (Number number : SequencesKt__SequencesKt.oOoXoXO(ActivityResultRegistry$generateRandomNumber$1.INSTANCE)) {
            if (!this.rcToKey.containsKey(Integer.valueOf(number.intValue()))) {
                return number.intValue();
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    /* access modifiers changed from: private */
    public static final void register$lambda$1(ActivityResultRegistry activityResultRegistry, String str, ActivityResultCallback activityResultCallback, ActivityResultContract activityResultContract, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        IIX0o.x0xO0oo(lifecycleOwner, "<anonymous parameter 0>");
        IIX0o.x0xO0oo(event, NotificationCompat.CATEGORY_EVENT);
        if (Lifecycle.Event.ON_START == event) {
            activityResultRegistry.keyToCallback.put(str, new CallbackAndContract(activityResultCallback, activityResultContract));
            if (activityResultRegistry.parsedPendingResults.containsKey(str)) {
                Object obj = activityResultRegistry.parsedPendingResults.get(str);
                activityResultRegistry.parsedPendingResults.remove(str);
                activityResultCallback.onActivityResult(obj);
            }
            ActivityResult activityResult = (ActivityResult) BundleCompat.getParcelable(activityResultRegistry.pendingResults, str, ActivityResult.class);
            if (activityResult != null) {
                activityResultRegistry.pendingResults.remove(str);
                activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.getResultCode(), activityResult.getData()));
            }
        } else if (Lifecycle.Event.ON_STOP == event) {
            activityResultRegistry.keyToCallback.remove(str);
        } else if (Lifecycle.Event.ON_DESTROY == event) {
            activityResultRegistry.unregister$activity_release(str);
        }
    }

    private final void registerKey(String str) {
        if (this.keyToRc.get(str) == null) {
            bindRcKey(generateRandomNumber(), str);
        }
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
        if (bundle != null) {
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
    }

    public final void onSaveInstanceState(@OOXIXo Bundle bundle) {
        IIX0o.x0xO0oo(bundle, "outState");
        bundle.putIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS, new ArrayList(this.keyToRc.values()));
        bundle.putStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS, new ArrayList(this.keyToRc.keySet()));
        bundle.putStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS, new ArrayList(this.launchedKeys));
        bundle.putBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS, new Bundle(this.pendingResults));
    }

    @OOXIXo
    public final <I, O> ActivityResultLauncher<I> register(@OOXIXo String str, @OOXIXo LifecycleOwner lifecycleOwner, @OOXIXo ActivityResultContract<I, O> activityResultContract, @OOXIXo ActivityResultCallback<O> activityResultCallback) {
        IIX0o.x0xO0oo(str, "key");
        IIX0o.x0xO0oo(lifecycleOwner, "lifecycleOwner");
        IIX0o.x0xO0oo(activityResultContract, "contract");
        IIX0o.x0xO0oo(activityResultCallback, bn.f.L);
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (!lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            registerKey(str);
            LifecycleContainer lifecycleContainer = this.keyToLifecycleContainers.get(str);
            if (lifecycleContainer == null) {
                lifecycleContainer = new LifecycleContainer(lifecycle);
            }
            lifecycleContainer.addObserver(new I0Io(this, str, activityResultCallback, activityResultContract));
            this.keyToLifecycleContainers.put(str, lifecycleContainer);
            return new ActivityResultRegistry$register$2(this, str, activityResultContract);
        }
        throw new IllegalStateException(("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.").toString());
    }

    @MainThread
    public final void unregister$activity_release(@OOXIXo String str) {
        Integer remove;
        IIX0o.x0xO0oo(str, "key");
        if (!this.launchedKeys.contains(str) && (remove = this.keyToRc.remove(str)) != null) {
            this.rcToKey.remove(remove);
        }
        this.keyToCallback.remove(str);
        if (this.parsedPendingResults.containsKey(str)) {
            Log.w(LOG_TAG, "Dropping pending result for request " + str + ": " + this.parsedPendingResults.get(str));
            this.parsedPendingResults.remove(str);
        }
        if (this.pendingResults.containsKey(str)) {
            Log.w(LOG_TAG, "Dropping pending result for request " + str + ": " + ((ActivityResult) BundleCompat.getParcelable(this.pendingResults, str, ActivityResult.class)));
            this.pendingResults.remove(str);
        }
        LifecycleContainer lifecycleContainer = this.keyToLifecycleContainers.get(str);
        if (lifecycleContainer != null) {
            lifecycleContainer.clearObservers();
            this.keyToLifecycleContainers.remove(str);
        }
    }

    @MainThread
    public final <O> boolean dispatchResult(int i, O o) {
        String str = this.rcToKey.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        CallbackAndContract callbackAndContract = this.keyToCallback.get(str);
        if ((callbackAndContract != null ? callbackAndContract.getCallback() : null) == null) {
            this.pendingResults.remove(str);
            this.parsedPendingResults.put(str, o);
            return true;
        }
        ActivityResultCallback callback = callbackAndContract.getCallback();
        IIX0o.x0XOIxOo(callback, "null cannot be cast to non-null type androidx.activity.result.ActivityResultCallback<O of androidx.activity.result.ActivityResultRegistry.dispatchResult>");
        if (!this.launchedKeys.remove(str)) {
            return true;
        }
        callback.onActivityResult(o);
        return true;
    }

    @OOXIXo
    public final <I, O> ActivityResultLauncher<I> register(@OOXIXo String str, @OOXIXo ActivityResultContract<I, O> activityResultContract, @OOXIXo ActivityResultCallback<O> activityResultCallback) {
        IIX0o.x0xO0oo(str, "key");
        IIX0o.x0xO0oo(activityResultContract, "contract");
        IIX0o.x0xO0oo(activityResultCallback, bn.f.L);
        registerKey(str);
        this.keyToCallback.put(str, new CallbackAndContract(activityResultCallback, activityResultContract));
        if (this.parsedPendingResults.containsKey(str)) {
            Object obj = this.parsedPendingResults.get(str);
            this.parsedPendingResults.remove(str);
            activityResultCallback.onActivityResult(obj);
        }
        ActivityResult activityResult = (ActivityResult) BundleCompat.getParcelable(this.pendingResults, str, ActivityResult.class);
        if (activityResult != null) {
            this.pendingResults.remove(str);
            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.getResultCode(), activityResult.getData()));
        }
        return new ActivityResultRegistry$register$3(this, str, activityResultContract);
    }
}
