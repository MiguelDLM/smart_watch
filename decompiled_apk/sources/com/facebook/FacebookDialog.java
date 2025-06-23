package com.facebook;

import androidx.activity.result.contract.ActivityResultContract;
import com.facebook.CallbackManager;

/* loaded from: classes8.dex */
public interface FacebookDialog<CONTENT, RESULT> {
    boolean canShow(CONTENT content);

    @OXOo.OOXIXo
    ActivityResultContract<CONTENT, CallbackManager.ActivityResultParameters> createActivityResultContractForShowingDialog(@OXOo.oOoXoXO CallbackManager callbackManager);

    void registerCallback(@OXOo.OOXIXo CallbackManager callbackManager, @OXOo.OOXIXo FacebookCallback<RESULT> facebookCallback);

    void registerCallback(@OXOo.OOXIXo CallbackManager callbackManager, @OXOo.OOXIXo FacebookCallback<RESULT> facebookCallback, int i);

    void show(CONTENT content);
}
