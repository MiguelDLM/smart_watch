package androidx.core.widget;

public final /* synthetic */ class oxoX implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ContentLoadingProgressBar f388XO;

    public /* synthetic */ oxoX(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f388XO = contentLoadingProgressBar;
    }

    public final void run() {
        this.f388XO.hideOnUiThread();
    }
}
