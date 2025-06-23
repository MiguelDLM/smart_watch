package me.devilsen.czxing.code;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes6.dex */
public class CodeResult {
    private final BarcodeFormat format;
    private int[] points;
    private int scanType;
    private final String text;

    public CodeResult(BarcodeFormat barcodeFormat, String str) {
        this.format = barcodeFormat;
        this.text = str;
    }

    private String getPointsString() {
        if (this.points == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = this.points.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i++;
            sb.append(r1[i2]);
            sb.append("  ");
            if (i % 2 == 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public BarcodeFormat getFormat() {
        return this.format;
    }

    public int[] getPoints() {
        return this.points;
    }

    public int getScanType() {
        return this.scanType;
    }

    public String getText() {
        return this.text;
    }

    public void setPoint(int[] iArr) {
        this.points = iArr;
    }

    public String toString() {
        return "text: " + this.text + "\nformat: " + getFormat() + "\nscanType: " + getScanType() + "\npoints: " + getPointsString();
    }

    public CodeResult(BarcodeFormat barcodeFormat, String str, int[] iArr) {
        this.format = barcodeFormat;
        this.text = str;
        this.points = iArr;
    }

    public CodeResult(String str, int i, int[] iArr, int i2) {
        this.text = str;
        if (i < 0) {
            this.format = BarcodeFormat.QR_CODE;
        } else {
            this.format = BarcodeFormat.valueOf(i);
        }
        this.points = iArr;
        this.scanType = i2;
    }
}
