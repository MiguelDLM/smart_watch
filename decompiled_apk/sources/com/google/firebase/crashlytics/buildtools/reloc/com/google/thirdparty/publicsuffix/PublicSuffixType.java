package com.google.firebase.crashlytics.buildtools.reloc.com.google.thirdparty.publicsuffix;

import OoIXo.oOoXoXO;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.Beta;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;

@Beta
@GwtCompatible
/* loaded from: classes10.dex */
public enum PublicSuffixType {
    PRIVATE(':', ','),
    REGISTRY(oOoXoXO.f2346I0Io, '?');

    private final char innerNodeCode;
    private final char leafNodeCode;

    PublicSuffixType(char c, char c2) {
        this.innerNodeCode = c;
        this.leafNodeCode = c2;
    }

    public static PublicSuffixType fromCode(char c) {
        for (PublicSuffixType publicSuffixType : values()) {
            if (publicSuffixType.getInnerNodeCode() == c || publicSuffixType.getLeafNodeCode() == c) {
                return publicSuffixType;
            }
        }
        throw new IllegalArgumentException("No enum corresponding to given code: " + c);
    }

    public static PublicSuffixType fromIsPrivate(boolean z) {
        if (z) {
            return PRIVATE;
        }
        return REGISTRY;
    }

    public char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    public char getLeafNodeCode() {
        return this.leafNodeCode;
    }
}
