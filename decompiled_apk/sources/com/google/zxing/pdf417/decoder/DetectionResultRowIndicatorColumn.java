package com.google.zxing.pdf417.decoder;

import com.google.zxing.ResultPoint;

/* loaded from: classes10.dex */
final class DetectionResultRowIndicatorColumn extends DetectionResultColumn {
    private final boolean isLeft;

    public DetectionResultRowIndicatorColumn(BoundingBox boundingBox, boolean z) {
        super(boundingBox);
        this.isLeft = z;
    }

    private void adjustIncompleteIndicatorColumnRowNumbers(BarcodeMetadata barcodeMetadata) {
        ResultPoint topRight;
        ResultPoint bottomRight;
        BoundingBox boundingBox = getBoundingBox();
        if (this.isLeft) {
            topRight = boundingBox.getTopLeft();
        } else {
            topRight = boundingBox.getTopRight();
        }
        if (this.isLeft) {
            bottomRight = boundingBox.getBottomLeft();
        } else {
            bottomRight = boundingBox.getBottomRight();
        }
        int imageRowToCodewordIndex = imageRowToCodewordIndex((int) bottomRight.getY());
        Codeword[] codewords = getCodewords();
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        for (int imageRowToCodewordIndex2 = imageRowToCodewordIndex((int) topRight.getY()); imageRowToCodewordIndex2 < imageRowToCodewordIndex; imageRowToCodewordIndex2++) {
            Codeword codeword = codewords[imageRowToCodewordIndex2];
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
                int rowNumber = codeword.getRowNumber() - i;
                if (rowNumber == 0) {
                    i2++;
                } else {
                    if (rowNumber == 1) {
                        i3 = Math.max(i3, i2);
                        i = codeword.getRowNumber();
                    } else if (codeword.getRowNumber() >= barcodeMetadata.getRowCount()) {
                        codewords[imageRowToCodewordIndex2] = null;
                    } else {
                        i = codeword.getRowNumber();
                    }
                    i2 = 1;
                }
            }
        }
    }

    private void removeIncorrectCodewords(Codeword[] codewordArr, BarcodeMetadata barcodeMetadata) {
        for (int i = 0; i < codewordArr.length; i++) {
            Codeword codeword = codewordArr[i];
            if (codeword != null) {
                int value = codeword.getValue() % 30;
                int rowNumber = codeword.getRowNumber();
                if (rowNumber > barcodeMetadata.getRowCount()) {
                    codewordArr[i] = null;
                } else {
                    if (!this.isLeft) {
                        rowNumber += 2;
                    }
                    int i2 = rowNumber % 3;
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 == 2 && value + 1 != barcodeMetadata.getColumnCount()) {
                                codewordArr[i] = null;
                            }
                        } else if (value / 3 != barcodeMetadata.getErrorCorrectionLevel() || value % 3 != barcodeMetadata.getRowCountLowerPart()) {
                            codewordArr[i] = null;
                        }
                    } else if ((value * 3) + 1 != barcodeMetadata.getRowCountUpperPart()) {
                        codewordArr[i] = null;
                    }
                }
            }
        }
    }

    private void setRowNumbers() {
        for (Codeword codeword : getCodewords()) {
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
            }
        }
    }

    public void adjustCompleteIndicatorColumnRowNumbers(BarcodeMetadata barcodeMetadata) {
        ResultPoint topRight;
        ResultPoint bottomRight;
        boolean z;
        Codeword[] codewords = getCodewords();
        setRowNumbers();
        removeIncorrectCodewords(codewords, barcodeMetadata);
        BoundingBox boundingBox = getBoundingBox();
        if (this.isLeft) {
            topRight = boundingBox.getTopLeft();
        } else {
            topRight = boundingBox.getTopRight();
        }
        if (this.isLeft) {
            bottomRight = boundingBox.getBottomLeft();
        } else {
            bottomRight = boundingBox.getBottomRight();
        }
        int imageRowToCodewordIndex = imageRowToCodewordIndex((int) bottomRight.getY());
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        for (int imageRowToCodewordIndex2 = imageRowToCodewordIndex((int) topRight.getY()); imageRowToCodewordIndex2 < imageRowToCodewordIndex; imageRowToCodewordIndex2++) {
            Codeword codeword = codewords[imageRowToCodewordIndex2];
            if (codeword != null) {
                int rowNumber = codeword.getRowNumber() - i;
                if (rowNumber == 0) {
                    i2++;
                } else {
                    if (rowNumber == 1) {
                        i3 = Math.max(i3, i2);
                        i = codeword.getRowNumber();
                    } else if (rowNumber >= 0 && codeword.getRowNumber() < barcodeMetadata.getRowCount() && rowNumber <= imageRowToCodewordIndex2) {
                        if (i3 > 2) {
                            rowNumber *= i3 - 2;
                        }
                        if (rowNumber >= imageRowToCodewordIndex2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        for (int i4 = 1; i4 <= rowNumber && !z; i4++) {
                            if (codewords[imageRowToCodewordIndex2 - i4] != null) {
                                z = true;
                            } else {
                                z = false;
                            }
                        }
                        if (z) {
                            codewords[imageRowToCodewordIndex2] = null;
                        } else {
                            i = codeword.getRowNumber();
                        }
                    } else {
                        codewords[imageRowToCodewordIndex2] = null;
                    }
                    i2 = 1;
                }
            }
        }
    }

    public BarcodeMetadata getBarcodeMetadata() {
        Codeword[] codewords = getCodewords();
        BarcodeValue barcodeValue = new BarcodeValue();
        BarcodeValue barcodeValue2 = new BarcodeValue();
        BarcodeValue barcodeValue3 = new BarcodeValue();
        BarcodeValue barcodeValue4 = new BarcodeValue();
        for (Codeword codeword : codewords) {
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
                int value = codeword.getValue() % 30;
                int rowNumber = codeword.getRowNumber();
                if (!this.isLeft) {
                    rowNumber += 2;
                }
                int i = rowNumber % 3;
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            barcodeValue.setValue(value + 1);
                        }
                    } else {
                        barcodeValue4.setValue(value / 3);
                        barcodeValue3.setValue(value % 3);
                    }
                } else {
                    barcodeValue2.setValue((value * 3) + 1);
                }
            }
        }
        if (barcodeValue.getValue().length != 0 && barcodeValue2.getValue().length != 0 && barcodeValue3.getValue().length != 0 && barcodeValue4.getValue().length != 0 && barcodeValue.getValue()[0] > 0 && barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] >= 3 && barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] <= 90) {
            BarcodeMetadata barcodeMetadata = new BarcodeMetadata(barcodeValue.getValue()[0], barcodeValue2.getValue()[0], barcodeValue3.getValue()[0], barcodeValue4.getValue()[0]);
            removeIncorrectCodewords(codewords, barcodeMetadata);
            return barcodeMetadata;
        }
        return null;
    }

    public int[] getRowHeights() {
        int rowNumber;
        BarcodeMetadata barcodeMetadata = getBarcodeMetadata();
        if (barcodeMetadata == null) {
            return null;
        }
        adjustIncompleteIndicatorColumnRowNumbers(barcodeMetadata);
        int rowCount = barcodeMetadata.getRowCount();
        int[] iArr = new int[rowCount];
        for (Codeword codeword : getCodewords()) {
            if (codeword != null && (rowNumber = codeword.getRowNumber()) < rowCount) {
                iArr[rowNumber] = iArr[rowNumber] + 1;
            }
        }
        return iArr;
    }

    public boolean isLeft() {
        return this.isLeft;
    }

    @Override // com.google.zxing.pdf417.decoder.DetectionResultColumn
    public String toString() {
        return "IsLeft: " + this.isLeft + '\n' + super.toString();
    }
}
