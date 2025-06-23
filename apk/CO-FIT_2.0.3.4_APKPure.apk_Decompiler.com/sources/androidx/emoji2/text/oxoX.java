package androidx.emoji2.text;

import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompatInitializer;
import java.util.concurrent.ThreadPoolExecutor;

public final /* synthetic */ class oxoX implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f393IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback f394Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ EmojiCompatInitializer.BackgroundDefaultLoader f395XO;

    public /* synthetic */ oxoX(EmojiCompatInitializer.BackgroundDefaultLoader backgroundDefaultLoader, EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
        this.f395XO = backgroundDefaultLoader;
        this.f394Oo = metadataRepoLoaderCallback;
        this.f393IXxxXO = threadPoolExecutor;
    }

    public final void run() {
        this.f395XO.lambda$load$0(this.f394Oo, this.f393IXxxXO);
    }
}
