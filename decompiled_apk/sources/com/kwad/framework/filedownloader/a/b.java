package com.kwad.framework.filedownloader.a;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* loaded from: classes11.dex */
public interface b {
    void addHeader(String str, String str2);

    String bg(String str);

    void execute();

    InputStream getInputStream();

    int getResponseCode();

    Map<String, List<String>> vG();

    Map<String, List<String>> vH();

    void vI();
}
