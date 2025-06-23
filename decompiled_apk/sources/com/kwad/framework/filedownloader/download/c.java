package com.kwad.framework.filedownloader.download;

import com.kwad.framework.filedownloader.download.ConnectTask;

/* loaded from: classes11.dex */
public final class c implements Runnable {
    private final String Wx;
    private final boolean agT;
    private final int agw;
    private final ConnectTask ahs;
    private final f aht;
    private e ahu;
    final int ahv;
    private volatile boolean kH;

    /* loaded from: classes11.dex */
    public static class a {
        private String Wx;
        private Boolean ahq;
        private f aht;
        private final ConnectTask.a ahw = new ConnectTask.a();
        private Integer ahx;

        public final a a(f fVar) {
            this.aht = fVar;
            return this;
        }

        public final a b(com.kwad.framework.filedownloader.download.a aVar) {
            this.ahw.a(aVar);
            return this;
        }

        public final a bd(boolean z) {
            this.ahq = Boolean.valueOf(z);
            return this;
        }

        public final a bl(String str) {
            this.ahw.bi(str);
            return this;
        }

        public final a bm(String str) {
            this.ahw.bj(str);
            return this;
        }

        public final a bn(String str) {
            this.Wx = str;
            return this;
        }

        public final a bt(int i) {
            this.ahw.bs(i);
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.d.b bVar) {
            this.ahw.a(bVar);
            return this;
        }

        public final a d(Integer num) {
            this.ahx = num;
            return this;
        }

        public final c wj() {
            if (this.aht != null && this.Wx != null && this.ahq != null && this.ahx != null) {
                ConnectTask vR = this.ahw.vR();
                return new c(vR.agw, this.ahx.intValue(), vR, this.aht, this.ahq.booleanValue(), this.Wx, (byte) 0);
            }
            throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.b("%s %s %B", this.aht, this.Wx, this.ahq));
        }
    }

    public /* synthetic */ c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str, byte b) {
        this(i, i2, connectTask, fVar, z, str);
    }

    public final void pause() {
        this.kH = true;
        e eVar = this.ahu;
        if (eVar != null) {
            eVar.pause();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016c A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.c.run():void");
    }

    public final void vo() {
        pause();
    }

    private c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str) {
        this.agw = i;
        this.ahv = i2;
        this.kH = false;
        this.aht = fVar;
        this.Wx = str;
        this.ahs = connectTask;
        this.agT = z;
    }
}
