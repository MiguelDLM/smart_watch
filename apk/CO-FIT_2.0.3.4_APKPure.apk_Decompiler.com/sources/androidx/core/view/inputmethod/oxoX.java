package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.inputmethod.InputConnectionCompat;

public final /* synthetic */ class oxoX implements InputConnectionCompat.OnCommitContentListener {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ View f377oIX0oI;

    public /* synthetic */ oxoX(View view) {
        this.f377oIX0oI = view;
    }

    public final boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
        return InputConnectionCompat.lambda$createOnCommitContentListenerUsingPerformReceiveContent$0(this.f377oIX0oI, inputContentInfoCompat, i, bundle);
    }
}
