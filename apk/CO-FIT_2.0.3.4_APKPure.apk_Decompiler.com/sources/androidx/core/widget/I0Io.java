package androidx.core.widget;

public final /* synthetic */ class I0Io implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ContentLoadingProgressBar f385XO;

    public /* synthetic */ I0Io(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f385XO = contentLoadingProgressBar;
    }

    public final void run() {
        this.f385XO.showOnUiThread();
    }
}
