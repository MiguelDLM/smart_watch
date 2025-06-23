package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.util;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.Contract;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.ThreadingBehavior;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes10.dex */
public final class PublicSuffixListParser {
    public PublicSuffixList parse(Reader reader) throws IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(reader);
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                if (!readLine.isEmpty() && !readLine.startsWith("//")) {
                    if (readLine.startsWith(FileUtils.FILE_EXTENSION_SEPARATOR)) {
                        readLine = readLine.substring(1);
                    }
                    boolean startsWith = readLine.startsWith("!");
                    if (startsWith) {
                        readLine = readLine.substring(1);
                    }
                    if (startsWith) {
                        arrayList2.add(readLine);
                    } else {
                        arrayList.add(readLine);
                    }
                }
            } else {
                return new PublicSuffixList(DomainType.UNKNOWN, arrayList, arrayList2);
            }
        }
    }

    public List<PublicSuffixList> parseByType(Reader reader) throws IOException {
        ArrayList arrayList = new ArrayList(2);
        BufferedReader bufferedReader = new BufferedReader(reader);
        while (true) {
            DomainType domainType = null;
            ArrayList arrayList2 = null;
            ArrayList arrayList3 = null;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (!readLine.isEmpty()) {
                        if (readLine.startsWith("//")) {
                            if (domainType == null) {
                                if (readLine.contains("===BEGIN ICANN DOMAINS===")) {
                                    domainType = DomainType.ICANN;
                                } else if (readLine.contains("===BEGIN PRIVATE DOMAINS===")) {
                                    domainType = DomainType.PRIVATE;
                                }
                            } else if (readLine.contains("===END ICANN DOMAINS===") || readLine.contains("===END PRIVATE DOMAINS===")) {
                                break;
                            }
                        } else if (domainType != null) {
                            if (readLine.startsWith(FileUtils.FILE_EXTENSION_SEPARATOR)) {
                                readLine = readLine.substring(1);
                            }
                            boolean startsWith = readLine.startsWith("!");
                            if (startsWith) {
                                readLine = readLine.substring(1);
                            }
                            if (startsWith) {
                                if (arrayList3 == null) {
                                    arrayList3 = new ArrayList();
                                }
                                arrayList3.add(readLine);
                            } else {
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                }
                                arrayList2.add(readLine);
                            }
                        }
                    }
                } else {
                    return arrayList;
                }
            }
            if (arrayList2 != null) {
                arrayList.add(new PublicSuffixList(domainType, arrayList2, arrayList3));
            }
        }
    }
}
