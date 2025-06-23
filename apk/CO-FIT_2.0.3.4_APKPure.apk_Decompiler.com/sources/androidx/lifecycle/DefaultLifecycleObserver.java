package androidx.lifecycle;

import OXOo.OOXIXo;

public interface DefaultLifecycleObserver extends LifecycleObserver {
    void onCreate(@OOXIXo LifecycleOwner lifecycleOwner);

    void onDestroy(@OOXIXo LifecycleOwner lifecycleOwner);

    void onPause(@OOXIXo LifecycleOwner lifecycleOwner);

    void onResume(@OOXIXo LifecycleOwner lifecycleOwner);

    void onStart(@OOXIXo LifecycleOwner lifecycleOwner);

    void onStop(@OOXIXo LifecycleOwner lifecycleOwner);
}
