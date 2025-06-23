package com.alibaba.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexerBase;

public class JSONPatch {

    /* renamed from: com.alibaba.fastjson.JSONPatch$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.alibaba.fastjson.JSONPatch$OperationType[] r0 = com.alibaba.fastjson.JSONPatch.OperationType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType = r0
                com.alibaba.fastjson.JSONPatch$OperationType r1 = com.alibaba.fastjson.JSONPatch.OperationType.add     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alibaba.fastjson.JSONPatch$OperationType r1 = com.alibaba.fastjson.JSONPatch.OperationType.replace     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.alibaba.fastjson.JSONPatch$OperationType r1 = com.alibaba.fastjson.JSONPatch.OperationType.remove     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.alibaba.fastjson.JSONPatch$OperationType r1 = com.alibaba.fastjson.JSONPatch.OperationType.copy     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.alibaba.fastjson.JSONPatch$OperationType r1 = com.alibaba.fastjson.JSONPatch.OperationType.move     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.alibaba.fastjson.JSONPatch$OperationType r1 = com.alibaba.fastjson.JSONPatch.OperationType.test     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPatch.AnonymousClass1.<clinit>():void");
        }
    }

    @JSONType(orders = {"op", "from", "path", "value"})
    public static class Operation {
        public String from;
        public String path;
        @JSONField(name = "op")
        public OperationType type;
        public Object value;
    }

    public enum OperationType {
        add,
        remove,
        replace,
        move,
        copy,
        test
    }

    public static String apply(String str, String str2) {
        return JSON.toJSONString(apply(JSON.parse(str, Feature.OrderedField), str2));
    }

    private static boolean isObject(String str) {
        if (str == null) {
            return false;
        }
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (JSONLexerBase.isWhitespace(charAt)) {
                i++;
            } else if (charAt == '{') {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.alibaba.fastjson.JSONPatch$Operation[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object apply(java.lang.Object r10, java.lang.String r11) {
        /*
            boolean r0 = isObject(r11)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0015
            com.alibaba.fastjson.JSONPatch$Operation[] r0 = new com.alibaba.fastjson.JSONPatch.Operation[r2]
            java.lang.Class<com.alibaba.fastjson.JSONPatch$Operation> r3 = com.alibaba.fastjson.JSONPatch.Operation.class
            java.lang.Object r11 = com.alibaba.fastjson.JSON.parseObject((java.lang.String) r11, r3)
            com.alibaba.fastjson.JSONPatch$Operation r11 = (com.alibaba.fastjson.JSONPatch.Operation) r11
            r0[r1] = r11
            goto L_0x001e
        L_0x0015:
            java.lang.Class<com.alibaba.fastjson.JSONPatch$Operation[]> r0 = com.alibaba.fastjson.JSONPatch.Operation[].class
            java.lang.Object r11 = com.alibaba.fastjson.JSON.parseObject((java.lang.String) r11, r0)
            r0 = r11
            com.alibaba.fastjson.JSONPatch$Operation[] r0 = (com.alibaba.fastjson.JSONPatch.Operation[]) r0
        L_0x001e:
            int r11 = r0.length
            r3 = 0
        L_0x0020:
            if (r3 >= r11) goto L_0x00a4
            r4 = r0[r3]
            java.lang.String r5 = r4.path
            com.alibaba.fastjson.JSONPath r5 = com.alibaba.fastjson.JSONPath.compile(r5)
            int[] r6 = com.alibaba.fastjson.JSONPatch.AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType
            com.alibaba.fastjson.JSONPatch$OperationType r7 = r4.type
            int r7 = r7.ordinal()
            r6 = r6[r7]
            switch(r6) {
                case 1: goto L_0x009b;
                case 2: goto L_0x0095;
                case 3: goto L_0x0091;
                case 4: goto L_0x0053;
                case 5: goto L_0x0053;
                case 6: goto L_0x0038;
                default: goto L_0x0037;
            }
        L_0x0037:
            goto L_0x00a0
        L_0x0038:
            java.lang.Object r10 = r5.eval(r10)
            if (r10 != 0) goto L_0x0048
            java.lang.Object r10 = r4.value
            if (r10 != 0) goto L_0x0043
            r1 = 1
        L_0x0043:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r1)
            return r10
        L_0x0048:
            java.lang.Object r11 = r4.value
            boolean r10 = r10.equals(r11)
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            return r10
        L_0x0053:
            java.lang.String r6 = r4.from
            com.alibaba.fastjson.JSONPath r6 = com.alibaba.fastjson.JSONPath.compile(r6)
            java.lang.Object r7 = r6.eval(r10)
            com.alibaba.fastjson.JSONPatch$OperationType r8 = r4.type
            com.alibaba.fastjson.JSONPatch$OperationType r9 = com.alibaba.fastjson.JSONPatch.OperationType.move
            if (r8 != r9) goto L_0x008d
            boolean r6 = r6.remove(r10)
            if (r6 == 0) goto L_0x006a
            goto L_0x008d
        L_0x006a:
            com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "json patch move error : "
            r11.append(r0)
            java.lang.String r0 = r4.from
            r11.append(r0)
            java.lang.String r0 = " -> "
            r11.append(r0)
            java.lang.String r0 = r4.path
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x008d:
            r5.set(r10, r7)
            goto L_0x00a0
        L_0x0091:
            r5.remove(r10)
            goto L_0x00a0
        L_0x0095:
            java.lang.Object r4 = r4.value
            r5.patchAdd(r10, r4, r2)
            goto L_0x00a0
        L_0x009b:
            java.lang.Object r4 = r4.value
            r5.patchAdd(r10, r4, r1)
        L_0x00a0:
            int r3 = r3 + 1
            goto L_0x0020
        L_0x00a4:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPatch.apply(java.lang.Object, java.lang.String):java.lang.Object");
    }
}
