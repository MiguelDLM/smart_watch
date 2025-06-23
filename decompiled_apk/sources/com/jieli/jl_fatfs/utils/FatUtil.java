package com.jieli.jl_fatfs.utils;

import com.jieli.jl_fatfs.model.CallInfo;
import com.jieli.jl_rcsp.constant.WatchError;
import com.jieli.jl_rcsp.util.WatchFileUtil;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class FatUtil {
    public static byte[] getCallInfoData(List<CallInfo> list) {
        if (list != null && !list.isEmpty()) {
            byte[] bArr = new byte[list.size() * 40];
            Iterator<CallInfo> it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                byte[] bytes = it.next().getBytes();
                if (bytes != null) {
                    System.arraycopy(bytes, 0, bArr, i, bytes.length);
                    i += bytes.length;
                }
            }
            return bArr;
        }
        return new byte[20];
    }

    public static String getFatFilePath(String str) {
        return getFatFilePath("/", str);
    }

    public static String getFatFsErrorCodeMsg(int i) {
        return WatchError.getErrorDesc(WatchError.fatfsToWatchErr(i));
    }

    public static String getFatFsName(String str) {
        return getFatFsName(12, str);
    }

    public static List<CallInfo> parseCallInfoList(byte[] bArr) {
        if (bArr != null && bArr.length >= 40) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (bArr.length - i >= 40) {
                String trim = new String(bArr, i, 20).trim();
                String trim2 = new String(bArr, i + 20, 20).trim();
                i += 40;
                arrayList.add(new CallInfo(trim, trim2));
            }
            return arrayList;
        }
        return null;
    }

    public static String getFatFilePath(String str, String str2) {
        String fileName = WatchFileUtil.getFileName(str2);
        if (fileName == null || str == null) {
            return null;
        }
        String fatFsName = getFatFsName(fileName);
        if (str.equalsIgnoreCase(fatFsName)) {
            return str;
        }
        if (str.equalsIgnoreCase("/")) {
            return str + fatFsName;
        }
        return str + "/" + fatFsName;
    }

    public static String getFatFsName(int i, String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (str.length() > i) {
            int lastIndexOf = str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR);
            if (lastIndexOf != -1) {
                String substring = str.substring(0, lastIndexOf);
                String substring2 = str.substring(lastIndexOf + 1);
                int length = (i - 1) - substring2.length();
                if (length > substring.length()) {
                    length = substring.length();
                }
                str = substring.substring(0, length).replaceAll("\\.", "_") + FileUtils.FILE_EXTENSION_SEPARATOR + substring2;
            } else {
                str = str.substring(0, i);
            }
        }
        return str.toUpperCase();
    }
}
