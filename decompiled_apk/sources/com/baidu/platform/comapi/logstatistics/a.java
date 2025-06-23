package com.baidu.platform.comapi.logstatistics;

import com.tenmeter.smlibrary.utils.FileUtils;

/* loaded from: classes8.dex */
public class a {
    public String appendLogTag(String str, String str2, String str3) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && str3 != null && str3.length() > 0) {
            return str + FileUtils.FILE_EXTENSION_SEPARATOR + str2 + FileUtils.FILE_EXTENSION_SEPARATOR + str3;
        }
        return "";
    }
}
