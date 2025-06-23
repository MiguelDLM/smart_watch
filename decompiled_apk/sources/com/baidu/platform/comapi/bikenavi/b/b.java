package com.baidu.platform.comapi.bikenavi.b;

/* loaded from: classes8.dex */
class b implements com.baidu.platform.comapi.wnplatform.tts.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9540a;

    public b(a aVar) {
        this.f9540a = aVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.tts.b
    public int getTTSState() {
        return this.f9540a.b();
    }

    @Override // com.baidu.platform.comapi.wnplatform.tts.b
    public int playTTSText(String str, int i, int i2) {
        int a2;
        a2 = this.f9540a.a(str, i2);
        return a2;
    }
}
