package com.sifli.siflidfu;

import java.util.Comparator;

/* loaded from: classes11.dex */
public class OTAImageComparator implements Comparator<OTAFile> {
    @Override // java.util.Comparator
    public int compare(OTAFile oTAFile, OTAFile oTAFile2) {
        return Integer.compare(oTAFile.getImageID(), oTAFile2.getImageID());
    }
}
