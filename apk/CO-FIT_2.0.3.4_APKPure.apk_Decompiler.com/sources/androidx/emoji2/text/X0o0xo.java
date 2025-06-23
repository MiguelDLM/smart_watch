package androidx.emoji2.text;

import androidx.emoji2.text.FontRequestEmojiCompatConfig;

public final /* synthetic */ class X0o0xo implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ FontRequestEmojiCompatConfig.FontRequestMetadataLoader f390XO;

    public /* synthetic */ X0o0xo(FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader) {
        this.f390XO = fontRequestMetadataLoader;
    }

    public final void run() {
        this.f390XO.createMetadata();
    }
}
