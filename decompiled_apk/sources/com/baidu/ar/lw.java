package com.baidu.ar;

import java.text.DecimalFormat;
import java.util.Map;

/* loaded from: classes7.dex */
public class lw {
    public static String d(Map map) {
        String format;
        DecimalFormat decimalFormat = new DecimalFormat("0.00000");
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : map.keySet()) {
            if ((map.get(str) instanceof Float) || (map.get(str) instanceof Double)) {
                format = decimalFormat.format(map.get(str));
            } else {
                boolean z = map.get(str) instanceof Boolean;
                Object obj = map.get(str);
                format = z ? ((Boolean) obj).booleanValue() ? "true" : "false" : String.valueOf(obj);
            }
            stringBuffer.append(format);
        }
        stringBuffer.append("313d1d593314c7bff96422b0f29432d9c50a");
        return kp.cp(stringBuffer.toString());
    }
}
