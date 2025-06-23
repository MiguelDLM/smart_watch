package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.aq;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes11.dex */
final class d {
    private static final Pattern aDa = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern aDb = Pattern.compile("GET /(.*) HTTP");
    public final long aDc;
    public final boolean aDd;
    public final String uri;

    private d(String str) {
        boolean z;
        aq.gR(str);
        long eI = eI(str);
        this.aDc = Math.max(0L, eI);
        if (eI >= 0) {
            z = true;
        } else {
            z = false;
        }
        this.aDd = z;
        this.uri = eJ(str);
    }

    public static d b(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                sb.append(readLine);
                sb.append('\n');
            } else {
                return new d(sb.toString());
            }
        }
    }

    private static long eI(String str) {
        Matcher matcher = aDa.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private static String eJ(String str) {
        Matcher matcher = aDb.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public final String toString() {
        return "GetRequest{rangeOffset=" + this.aDc + ", partial=" + this.aDd + ", uri='" + this.uri + "'}";
    }
}
