package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes13.dex */
public class l implements e {

    /* renamed from: a, reason: collision with root package name */
    private final i f26296a;
    private final com.ss.android.socialbase.downloader.model.e b;
    private final e c;

    public l(DownloadInfo downloadInfo, b bVar, i iVar) throws BaseException {
        this.f26296a = iVar;
        this.b = a(downloadInfo, iVar);
        this.c = new h(bVar, this);
    }

    public e a() {
        return this.c;
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) throws IOException {
        this.b.a(aVar.f26287a, 0, aVar.c);
        this.f26296a.b(aVar.c);
    }

    public void c() throws IOException {
        this.b.c();
    }

    public void d() {
        com.ss.android.socialbase.downloader.i.f.a(this.b);
    }

    public i e() {
        return this.f26296a;
    }

    private com.ss.android.socialbase.downloader.model.e a(DownloadInfo downloadInfo, i iVar) throws BaseException {
        com.ss.android.socialbase.downloader.model.e a2 = com.ss.android.socialbase.downloader.i.f.a(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("flush_buffer_size_byte", -1));
        try {
            a2.a(iVar.e());
            return a2;
        } catch (IOException e) {
            throw new BaseException(1054, e);
        }
    }

    public void b() throws IOException {
        this.b.b();
    }
}
