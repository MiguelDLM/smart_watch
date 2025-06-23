package com.facebook.share;

import OXOo.oOoXoXO;

/* loaded from: classes8.dex */
public interface Sharer {

    /* loaded from: classes8.dex */
    public static final class Result {

        @oOoXoXO
        private final String postId;

        public Result(@oOoXoXO String str) {
            this.postId = str;
        }

        @oOoXoXO
        public final String getPostId() {
            return this.postId;
        }
    }

    boolean getShouldFailOnDataError();

    void setShouldFailOnDataError(boolean z);
}
