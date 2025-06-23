package com.tencent.bugly.proguard;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.iflytek.sparkchain.plugins.map.tools.MapPlugin;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes13.dex */
public final class a {
    public static String a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int size = arrayList.size();
            String str = MapPlugin.MapSearchTool;
            if (i < size) {
                String str2 = arrayList.get(i);
                if (!str2.equals("java.lang.Integer") && !str2.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                    if (!str2.equals("java.lang.Boolean") && !str2.equals(TypedValues.Custom.S_BOOLEAN)) {
                        if (!str2.equals("java.lang.Byte") && !str2.equals("byte")) {
                            String str3 = "double";
                            if (!str2.equals("java.lang.Double") && !str2.equals("double")) {
                                boolean equals = str2.equals("java.lang.Float");
                                str3 = TypedValues.Custom.S_FLOAT;
                                if (!equals && !str2.equals(TypedValues.Custom.S_FLOAT)) {
                                    if (!str2.equals("java.lang.Long") && !str2.equals("long")) {
                                        str3 = "short";
                                        if (!str2.equals("java.lang.Short") && !str2.equals("short")) {
                                            if (!str2.equals("java.lang.Character")) {
                                                if (str2.equals("java.lang.String")) {
                                                    str = TypedValues.Custom.S_STRING;
                                                } else if (str2.equals("java.util.List")) {
                                                    str = "list";
                                                } else if (!str2.equals("java.util.Map")) {
                                                    str = str2;
                                                }
                                            } else {
                                                throw new IllegalArgumentException("can not support java.lang.Character");
                                            }
                                        }
                                    } else {
                                        str = "int64";
                                    }
                                }
                            }
                            str = str3;
                        } else {
                            str = "char";
                        }
                    } else {
                        str = "bool";
                    }
                } else {
                    str = "int32";
                }
                arrayList.set(i, str);
                i++;
            } else {
                Collections.reverse(arrayList);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    String str4 = arrayList.get(i2);
                    if (str4.equals("list")) {
                        int i3 = i2 - 1;
                        arrayList.set(i3, "<" + arrayList.get(i3));
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str4.equals(MapPlugin.MapSearchTool)) {
                        int i4 = i2 - 1;
                        arrayList.set(i4, "<" + arrayList.get(i4) + ",");
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str4.equals("Array")) {
                        int i5 = i2 - 1;
                        arrayList.set(i5, "<" + arrayList.get(i5));
                        arrayList.set(0, arrayList.get(0) + ">");
                    }
                }
                Collections.reverse(arrayList);
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next());
                }
                return stringBuffer.toString();
            }
        }
    }
}
