package com.google.firebase.crashlytics.buildtools.reloc.com.google.thirdparty.publicsuffix;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Joiner;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Lists;

@GwtCompatible
/* loaded from: classes10.dex */
final class TrieParser {
    private static final Joiner PREFIX_JOINER = Joiner.on("");

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        if (r3 != ',') goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
    
        if (r2 >= r0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
    
        r2 = r2 + doParseTrieToBuilder(r9, r10, r2, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005c, code lost:
    
        if (r10.charAt(r2) == '?') goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
    
        if (r10.charAt(r2) != ',') goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
    
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int doParseTrieToBuilder(java.util.List<java.lang.CharSequence> r9, java.lang.CharSequence r10, int r11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap.Builder<java.lang.String, com.google.firebase.crashlytics.buildtools.reloc.com.google.thirdparty.publicsuffix.PublicSuffixType> r12) {
        /*
            int r0 = r10.length()
            r1 = 0
            r2 = r11
            r3 = 0
        L7:
            r4 = 58
            r5 = 33
            r6 = 44
            r7 = 63
            if (r2 >= r0) goto L25
            char r3 = r10.charAt(r2)
            r8 = 38
            if (r3 == r8) goto L25
            if (r3 == r7) goto L25
            if (r3 == r5) goto L25
            if (r3 == r4) goto L25
            if (r3 != r6) goto L22
            goto L25
        L22:
            int r2 = r2 + 1
            goto L7
        L25:
            java.lang.CharSequence r8 = r10.subSequence(r11, r2)
            java.lang.CharSequence r8 = reverse(r8)
            r9.add(r1, r8)
            if (r3 == r5) goto L38
            if (r3 == r7) goto L38
            if (r3 == r4) goto L38
            if (r3 != r6) goto L4b
        L38:
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Joiner r4 = com.google.firebase.crashlytics.buildtools.reloc.com.google.thirdparty.publicsuffix.TrieParser.PREFIX_JOINER
            java.lang.String r4 = r4.join(r9)
            int r5 = r4.length()
            if (r5 <= 0) goto L4b
            com.google.firebase.crashlytics.buildtools.reloc.com.google.thirdparty.publicsuffix.PublicSuffixType r5 = com.google.firebase.crashlytics.buildtools.reloc.com.google.thirdparty.publicsuffix.PublicSuffixType.fromCode(r3)
            r12.put(r4, r5)
        L4b:
            int r2 = r2 + 1
            if (r3 == r7) goto L66
            if (r3 == r6) goto L66
        L51:
            if (r2 >= r0) goto L66
            int r3 = doParseTrieToBuilder(r9, r10, r2, r12)
            int r2 = r2 + r3
            char r3 = r10.charAt(r2)
            if (r3 == r7) goto L64
            char r3 = r10.charAt(r2)
            if (r3 != r6) goto L51
        L64:
            int r2 = r2 + 1
        L66:
            r9.remove(r1)
            int r2 = r2 - r11
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.buildtools.reloc.com.google.thirdparty.publicsuffix.TrieParser.doParseTrieToBuilder(java.util.List, java.lang.CharSequence, int, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap$Builder):int");
    }

    public static ImmutableMap<String, PublicSuffixType> parseTrie(CharSequence charSequence) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            i += doParseTrieToBuilder(Lists.newLinkedList(), charSequence, i, builder);
        }
        return builder.build();
    }

    private static CharSequence reverse(CharSequence charSequence) {
        return new StringBuilder(charSequence).reverse();
    }
}
