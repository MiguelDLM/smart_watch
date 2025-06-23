package androidx.emoji2.text;

import androidx.emoji2.text.FontRequestEmojiCompatConfig;

public final /* synthetic */ class XO implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ FontRequestEmojiCompatConfig.FontRequestMetadataLoader f391XO;

    public /* synthetic */ XO(FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader) {
        this.f391XO = fontRequestMetadataLoader;
    }

    public final void run() {
        this.f391XO.loadInternal();
    }
}
