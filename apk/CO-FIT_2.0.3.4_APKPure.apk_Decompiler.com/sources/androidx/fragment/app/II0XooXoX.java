package androidx.fragment.app;

import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.util.Consumer;

public final /* synthetic */ class II0XooXoX implements Consumer {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f397XO;

    public /* synthetic */ II0XooXoX(FragmentManager fragmentManager) {
        this.f397XO = fragmentManager;
    }

    public final void accept(Object obj) {
        this.f397XO.lambda$new$3((PictureInPictureModeChangedInfo) obj);
    }
}
