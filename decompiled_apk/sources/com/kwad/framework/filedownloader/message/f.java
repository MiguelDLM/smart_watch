package com.kwad.framework.filedownloader.message;

import com.kwad.framework.filedownloader.download.d;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.message.a;
import com.kwad.framework.filedownloader.message.d;
import com.kwad.framework.filedownloader.message.h;
import java.io.File;

/* loaded from: classes11.dex */
public class f {
    public static MessageSnapshot a(int i, File file, boolean z) {
        long length = file.length();
        if (length > 2147483647L) {
            if (z) {
                return new d.a(i, true, length);
            }
            return new d.b(i, true, length);
        }
        if (z) {
            return new h.a(i, true, (int) length);
        }
        return new h.b(i, true, (int) length);
    }

    public static MessageSnapshot e(com.kwad.framework.filedownloader.a aVar) {
        if (aVar.uF()) {
            return new d.e(aVar.getId(), aVar.ux(), aVar.uy());
        }
        return new h.e(aVar.getId(), aVar.getSmallFileSoFarBytes(), aVar.getSmallFileTotalBytes());
    }

    public static MessageSnapshot t(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.uz() == -3) {
            return new a.C0830a(messageSnapshot);
        }
        throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.b("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.uz())));
    }

    public static MessageSnapshot a(int i, long j, long j2, boolean z) {
        if (j2 > 2147483647L) {
            if (z) {
                return new d.i(i, j, j2);
            }
            return new d.j(i, j, j2);
        }
        if (z) {
            return new h.i(i, (int) j, (int) j2);
        }
        return new h.j(i, (int) j, (int) j2);
    }

    public static MessageSnapshot a(int i, long j, Throwable th) {
        if (j > 2147483647L) {
            return new d.C0831d(i, j, th);
        }
        return new h.d(i, (int) j, th);
    }

    public static MessageSnapshot a(byte b, com.kwad.framework.filedownloader.d.c cVar, d.a aVar) {
        MessageSnapshot dVar;
        MessageSnapshot cVar2;
        IllegalStateException illegalStateException;
        int id = cVar.getId();
        if (b == -4) {
            throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.b("please use #catchWarn instead %d", Integer.valueOf(id)));
        }
        if (b == -3) {
            if (cVar.uF()) {
                return new d.b(id, false, cVar.getTotal());
            }
            return new h.b(id, false, (int) cVar.getTotal());
        }
        if (b != -1) {
            if (b == 1) {
                if (cVar.uF()) {
                    return new d.f(id, cVar.wP(), cVar.getTotal());
                }
                return new h.f(id, (int) cVar.wP(), (int) cVar.getTotal());
            }
            if (b == 2) {
                String filename = cVar.uv() ? cVar.getFilename() : null;
                if (cVar.uF()) {
                    cVar2 = new d.c(id, aVar.wu(), cVar.getTotal(), cVar.wQ(), filename);
                } else {
                    cVar2 = new h.c(id, aVar.wu(), (int) cVar.getTotal(), cVar.wQ(), filename);
                }
                return cVar2;
            }
            if (b == 3) {
                if (cVar.uF()) {
                    return new d.g(id, cVar.wP());
                }
                return new h.g(id, (int) cVar.wP());
            }
            if (b != 5) {
                if (b != 6) {
                    String b2 = com.kwad.framework.filedownloader.f.f.b("it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b));
                    com.kwad.framework.filedownloader.f.d.d(f.class, "it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b));
                    if (aVar.getException() != null) {
                        illegalStateException = new IllegalStateException(b2, aVar.getException());
                    } else {
                        illegalStateException = new IllegalStateException(b2);
                    }
                    if (cVar.uF()) {
                        return new d.C0831d(id, cVar.wP(), illegalStateException);
                    }
                    return new h.d(id, (int) cVar.wP(), illegalStateException);
                }
                return new MessageSnapshot.b(id);
            }
            if (cVar.uF()) {
                dVar = new d.h(id, cVar.wP(), aVar.getException(), aVar.uD());
            } else {
                dVar = new h.C0832h(id, (int) cVar.wP(), aVar.getException(), aVar.uD());
            }
        } else if (cVar.uF()) {
            dVar = new d.C0831d(id, cVar.wP(), aVar.getException());
        } else {
            dVar = new h.d(id, (int) cVar.wP(), aVar.getException());
        }
        return dVar;
    }
}
