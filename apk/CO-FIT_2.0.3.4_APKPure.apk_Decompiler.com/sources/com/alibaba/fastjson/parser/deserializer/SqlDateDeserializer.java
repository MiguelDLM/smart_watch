package com.alibaba.fastjson.parser.deserializer;

public class SqlDateDeserializer extends AbstractDateDeserializer implements ObjectDeserializer {
    public static final SqlDateDeserializer instance = new SqlDateDeserializer();
    public static final SqlDateDeserializer instance_timestamp = new SqlDateDeserializer(true);
    private boolean timestamp = false;

    public SqlDateDeserializer() {
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:33|34) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r5 = java.lang.Long.parseLong(r6);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0075 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T cast(com.alibaba.fastjson.parser.DefaultJSONParser r3, java.lang.reflect.Type r4, java.lang.Object r5, java.lang.Object r6) {
        /*
            r2 = this;
            boolean r0 = r2.timestamp
            if (r0 == 0) goto L_0x0009
            java.lang.Object r3 = r2.castTimestamp(r3, r4, r5, r6)
            return r3
        L_0x0009:
            r4 = 0
            if (r6 != 0) goto L_0x000d
            return r4
        L_0x000d:
            boolean r5 = r6 instanceof java.util.Date
            if (r5 == 0) goto L_0x001d
            java.sql.Date r3 = new java.sql.Date
            java.util.Date r6 = (java.util.Date) r6
            long r4 = r6.getTime()
            r3.<init>(r4)
            goto L_0x003c
        L_0x001d:
            boolean r5 = r6 instanceof java.math.BigDecimal
            if (r5 == 0) goto L_0x002d
            java.sql.Date r3 = new java.sql.Date
            java.math.BigDecimal r6 = (java.math.BigDecimal) r6
            long r4 = com.alibaba.fastjson.util.TypeUtils.longValue(r6)
            r3.<init>(r4)
            goto L_0x003c
        L_0x002d:
            boolean r5 = r6 instanceof java.lang.Number
            if (r5 == 0) goto L_0x003d
            java.sql.Date r3 = new java.sql.Date
            java.lang.Number r6 = (java.lang.Number) r6
            long r4 = r6.longValue()
            r3.<init>(r4)
        L_0x003c:
            return r3
        L_0x003d:
            boolean r5 = r6 instanceof java.lang.String
            if (r5 == 0) goto L_0x0086
            java.lang.String r6 = (java.lang.String) r6
            int r5 = r6.length()
            if (r5 != 0) goto L_0x004a
            return r4
        L_0x004a:
            com.alibaba.fastjson.parser.JSONScanner r4 = new com.alibaba.fastjson.parser.JSONScanner
            r4.<init>(r6)
            boolean r5 = r4.scanISO8601DateIfMatch()     // Catch:{ all -> 0x005e }
            if (r5 == 0) goto L_0x0060
            java.util.Calendar r3 = r4.getCalendar()     // Catch:{ all -> 0x005e }
            long r5 = r3.getTimeInMillis()     // Catch:{ all -> 0x005e }
            goto L_0x0079
        L_0x005e:
            r3 = move-exception
            goto L_0x0082
        L_0x0060:
            java.text.DateFormat r3 = r3.getDateFormat()     // Catch:{ all -> 0x005e }
            java.util.Date r3 = r3.parse(r6)     // Catch:{ ParseException -> 0x0075 }
            java.sql.Date r5 = new java.sql.Date     // Catch:{ ParseException -> 0x0075 }
            long r0 = r3.getTime()     // Catch:{ ParseException -> 0x0075 }
            r5.<init>(r0)     // Catch:{ ParseException -> 0x0075 }
            r4.close()
            return r5
        L_0x0075:
            long r5 = java.lang.Long.parseLong(r6)     // Catch:{ all -> 0x005e }
        L_0x0079:
            r4.close()
            java.sql.Date r3 = new java.sql.Date
            r3.<init>(r5)
            return r3
        L_0x0082:
            r4.close()
            throw r3
        L_0x0086:
            com.alibaba.fastjson.JSONException r3 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "parse error : "
            r4.append(r5)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer.cast(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:54|55) */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r5 = java.lang.Long.parseLong(r6);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x00c3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T castTimestamp(com.alibaba.fastjson.parser.DefaultJSONParser r3, java.lang.reflect.Type r4, java.lang.Object r5, java.lang.Object r6) {
        /*
            r2 = this;
            r4 = 0
            if (r6 != 0) goto L_0x0004
            return r4
        L_0x0004:
            boolean r5 = r6 instanceof java.util.Date
            if (r5 == 0) goto L_0x0014
            java.sql.Timestamp r3 = new java.sql.Timestamp
            java.util.Date r6 = (java.util.Date) r6
            long r4 = r6.getTime()
            r3.<init>(r4)
            return r3
        L_0x0014:
            boolean r5 = r6 instanceof java.math.BigDecimal
            if (r5 == 0) goto L_0x0024
            java.sql.Timestamp r3 = new java.sql.Timestamp
            java.math.BigDecimal r6 = (java.math.BigDecimal) r6
            long r4 = com.alibaba.fastjson.util.TypeUtils.longValue(r6)
            r3.<init>(r4)
            return r3
        L_0x0024:
            boolean r5 = r6 instanceof java.lang.Number
            if (r5 == 0) goto L_0x0034
            java.sql.Timestamp r3 = new java.sql.Timestamp
            java.lang.Number r6 = (java.lang.Number) r6
            long r4 = r6.longValue()
            r3.<init>(r4)
            return r3
        L_0x0034:
            boolean r5 = r6 instanceof java.lang.String
            if (r5 == 0) goto L_0x00d4
            java.lang.String r6 = (java.lang.String) r6
            int r5 = r6.length()
            if (r5 != 0) goto L_0x0041
            return r4
        L_0x0041:
            com.alibaba.fastjson.parser.JSONScanner r4 = new com.alibaba.fastjson.parser.JSONScanner
            r4.<init>(r6)
            int r5 = r6.length()     // Catch:{ all -> 0x009c }
            r0 = 19
            if (r5 <= r0) goto L_0x009e
            r5 = 4
            char r5 = r6.charAt(r5)     // Catch:{ all -> 0x009c }
            r1 = 45
            if (r5 != r1) goto L_0x009e
            r5 = 7
            char r5 = r6.charAt(r5)     // Catch:{ all -> 0x009c }
            if (r5 != r1) goto L_0x009e
            r5 = 10
            char r5 = r6.charAt(r5)     // Catch:{ all -> 0x009c }
            r1 = 32
            if (r5 != r1) goto L_0x009e
            r5 = 13
            char r5 = r6.charAt(r5)     // Catch:{ all -> 0x009c }
            r1 = 58
            if (r5 != r1) goto L_0x009e
            r5 = 16
            char r5 = r6.charAt(r5)     // Catch:{ all -> 0x009c }
            if (r5 != r1) goto L_0x009e
            char r5 = r6.charAt(r0)     // Catch:{ all -> 0x009c }
            r0 = 46
            if (r5 != r0) goto L_0x009e
            java.lang.String r5 = r3.getDateFomartPattern()     // Catch:{ all -> 0x009c }
            int r0 = r5.length()     // Catch:{ all -> 0x009c }
            int r1 = r6.length()     // Catch:{ all -> 0x009c }
            if (r0 == r1) goto L_0x009e
            java.lang.String r0 = com.alibaba.fastjson.JSON.DEFFAULT_DATE_FORMAT     // Catch:{ all -> 0x009c }
            if (r5 != r0) goto L_0x009e
            java.sql.Timestamp r3 = java.sql.Timestamp.valueOf(r6)     // Catch:{ all -> 0x009c }
            r4.close()
            return r3
        L_0x009c:
            r3 = move-exception
            goto L_0x00d0
        L_0x009e:
            r5 = 0
            boolean r5 = r4.scanISO8601DateIfMatch(r5)     // Catch:{ all -> 0x009c }
            if (r5 == 0) goto L_0x00ae
            java.util.Calendar r3 = r4.getCalendar()     // Catch:{ all -> 0x009c }
            long r5 = r3.getTimeInMillis()     // Catch:{ all -> 0x009c }
            goto L_0x00c7
        L_0x00ae:
            java.text.DateFormat r3 = r3.getDateFormat()     // Catch:{ all -> 0x009c }
            java.util.Date r3 = r3.parse(r6)     // Catch:{ ParseException -> 0x00c3 }
            java.sql.Timestamp r5 = new java.sql.Timestamp     // Catch:{ ParseException -> 0x00c3 }
            long r0 = r3.getTime()     // Catch:{ ParseException -> 0x00c3 }
            r5.<init>(r0)     // Catch:{ ParseException -> 0x00c3 }
            r4.close()
            return r5
        L_0x00c3:
            long r5 = java.lang.Long.parseLong(r6)     // Catch:{ all -> 0x009c }
        L_0x00c7:
            r4.close()
            java.sql.Timestamp r3 = new java.sql.Timestamp
            r3.<init>(r5)
            return r3
        L_0x00d0:
            r4.close()
            throw r3
        L_0x00d4:
            com.alibaba.fastjson.JSONException r3 = new com.alibaba.fastjson.JSONException
            java.lang.String r4 = "parse error"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer.castTimestamp(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public int getFastMatchToken() {
        return 2;
    }

    public SqlDateDeserializer(boolean z) {
    }
}
