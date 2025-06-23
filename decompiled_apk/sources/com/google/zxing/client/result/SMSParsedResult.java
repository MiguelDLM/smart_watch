package com.google.zxing.client.result;

import kotlin.text.XIxXXX0x0;

/* loaded from: classes10.dex */
public final class SMSParsedResult extends ParsedResult {
    private final String body;
    private final String[] numbers;
    private final String subject;
    private final String[] vias;

    public SMSParsedResult(String str, String str2, String str3, String str4) {
        super(ParsedResultType.SMS);
        this.numbers = new String[]{str};
        this.vias = new String[]{str2};
        this.subject = str3;
        this.body = str4;
    }

    public String getBody() {
        return this.body;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder sb = new StringBuilder(100);
        ParsedResult.maybeAppend(this.numbers, sb);
        ParsedResult.maybeAppend(this.subject, sb);
        ParsedResult.maybeAppend(this.body, sb);
        return sb.toString();
    }

    public String[] getNumbers() {
        return this.numbers;
    }

    public String getSMSURI() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append("sms:");
        boolean z2 = true;
        boolean z3 = true;
        for (int i = 0; i < this.numbers.length; i++) {
            if (z3) {
                z3 = false;
            } else {
                sb.append(',');
            }
            sb.append(this.numbers[i]);
            String[] strArr = this.vias;
            if (strArr != null && strArr[i] != null) {
                sb.append(";via=");
                sb.append(this.vias[i]);
            }
        }
        if (this.body != null) {
            z = true;
        } else {
            z = false;
        }
        if (this.subject == null) {
            z2 = false;
        }
        if (z || z2) {
            sb.append('?');
            if (z) {
                sb.append("body=");
                sb.append(this.body);
            }
            if (z2) {
                if (z) {
                    sb.append(XIxXXX0x0.f29558oxoX);
                }
                sb.append("subject=");
                sb.append(this.subject);
            }
        }
        return sb.toString();
    }

    public String getSubject() {
        return this.subject;
    }

    public String[] getVias() {
        return this.vias;
    }

    public SMSParsedResult(String[] strArr, String[] strArr2, String str, String str2) {
        super(ParsedResultType.SMS);
        this.numbers = strArr;
        this.vias = strArr2;
        this.subject = str;
        this.body = str2;
    }
}
