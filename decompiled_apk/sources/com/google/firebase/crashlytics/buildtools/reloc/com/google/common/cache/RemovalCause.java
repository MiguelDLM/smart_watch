package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes10.dex */
public enum RemovalCause {
    EXPLICIT { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.RemovalCause.1
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return false;
        }
    },
    REPLACED { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.RemovalCause.2
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return false;
        }
    },
    COLLECTED { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.RemovalCause.3
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return true;
        }
    },
    EXPIRED { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.RemovalCause.4
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return true;
        }
    },
    SIZE { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.RemovalCause.5
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return true;
        }
    };

    public abstract boolean wasEvicted();
}
