package com.tenmeter.smlibrary.utils.launcher;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;

/* loaded from: classes13.dex */
public class LauncherImpl<I, O> implements Launcher<I, O> {
    private ActivityResultContract<I, O> contract;
    private ActivityResultLauncher<I> launcher1;
    private ActivityResultRegistry registry;

    public LauncherImpl(ActivityResultRegistry activityResultRegistry, ActivityResultContract<I, O> activityResultContract) {
        this.registry = activityResultRegistry;
        this.contract = activityResultContract;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResult() {
        ActivityResultLauncher<I> activityResultLauncher = this.launcher1;
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
        }
    }

    @Override // com.tenmeter.smlibrary.utils.launcher.Launcher
    @Nullable
    public ActivityResultLauncher<I> getLauncher() {
        return this.launcher1;
    }

    @Override // com.tenmeter.smlibrary.utils.launcher.Launcher
    public void launch(I i, @Nullable ActivityOptionsCompat activityOptionsCompat, final ActivityResultCallback<O> activityResultCallback) {
        ActivityResultLauncher<I> register = this.registry.register("com.template.app#activity-result-launcher#" + hashCode(), this.contract, new ActivityResultCallback<O>() { // from class: com.tenmeter.smlibrary.utils.launcher.LauncherImpl.1
            @Override // androidx.activity.result.ActivityResultCallback
            public void onActivityResult(O o) {
                activityResultCallback.onActivityResult(o);
                LauncherImpl.this.onResult();
            }
        });
        this.launcher1 = register;
        if (register != null) {
            register.launch(i, activityOptionsCompat);
        }
    }

    @Override // com.tenmeter.smlibrary.utils.launcher.Launcher
    public void launch(I i, ActivityResultCallback<O> activityResultCallback) {
        launch(i, null, activityResultCallback);
    }
}
