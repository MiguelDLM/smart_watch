package com.kwad.framework.filedownloader.message;

/* loaded from: classes11.dex */
public interface a {

    /* renamed from: com.kwad.framework.filedownloader.message.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0830a extends MessageSnapshot implements a {
        private final MessageSnapshot aib;

        public C0830a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.getId());
            if (messageSnapshot.uz() == -3) {
                this.aib = messageSnapshot;
                return;
            }
            throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.b("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.uz())));
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte uz() {
            return (byte) 4;
        }

        @Override // com.kwad.framework.filedownloader.message.a
        public final MessageSnapshot wB() {
            return this.aib;
        }
    }

    MessageSnapshot wB();
}
