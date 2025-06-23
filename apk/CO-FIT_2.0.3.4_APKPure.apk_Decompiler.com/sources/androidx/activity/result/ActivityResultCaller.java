package androidx.activity.result;

import OXOo.OOXIXo;
import androidx.activity.result.contract.ActivityResultContract;

public interface ActivityResultCaller {
    @OOXIXo
    <I, O> ActivityResultLauncher<I> registerForActivityResult(@OOXIXo ActivityResultContract<I, O> activityResultContract, @OOXIXo ActivityResultCallback<O> activityResultCallback);

    @OOXIXo
    <I, O> ActivityResultLauncher<I> registerForActivityResult(@OOXIXo ActivityResultContract<I, O> activityResultContract, @OOXIXo ActivityResultRegistry activityResultRegistry, @OOXIXo ActivityResultCallback<O> activityResultCallback);
}
