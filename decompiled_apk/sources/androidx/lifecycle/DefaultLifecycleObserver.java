package androidx.lifecycle;

/* loaded from: classes.dex */
public interface DefaultLifecycleObserver extends LifecycleObserver {
    void onCreate(@OXOo.OOXIXo LifecycleOwner lifecycleOwner);

    void onDestroy(@OXOo.OOXIXo LifecycleOwner lifecycleOwner);

    void onPause(@OXOo.OOXIXo LifecycleOwner lifecycleOwner);

    void onResume(@OXOo.OOXIXo LifecycleOwner lifecycleOwner);

    void onStart(@OXOo.OOXIXo LifecycleOwner lifecycleOwner);

    void onStop(@OXOo.OOXIXo LifecycleOwner lifecycleOwner);
}
