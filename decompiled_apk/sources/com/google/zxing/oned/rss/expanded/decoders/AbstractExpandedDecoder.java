package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
import com.tencent.connect.common.II0xO0;

/* loaded from: classes10.dex */
public abstract class AbstractExpandedDecoder {
    private final GeneralAppIdDecoder generalDecoder;
    private final BitArray information;

    public AbstractExpandedDecoder(BitArray bitArray) {
        this.information = bitArray;
        this.generalDecoder = new GeneralAppIdDecoder(bitArray);
    }

    public static AbstractExpandedDecoder createDecoder(BitArray bitArray) {
        if (bitArray.get(1)) {
            return new AI01AndOtherAIs(bitArray);
        }
        if (!bitArray.get(2)) {
            return new AnyAIDecoder(bitArray);
        }
        int extractNumericValueFromBitArray = GeneralAppIdDecoder.extractNumericValueFromBitArray(bitArray, 1, 4);
        if (extractNumericValueFromBitArray != 4) {
            if (extractNumericValueFromBitArray != 5) {
                int extractNumericValueFromBitArray2 = GeneralAppIdDecoder.extractNumericValueFromBitArray(bitArray, 1, 5);
                if (extractNumericValueFromBitArray2 != 12) {
                    if (extractNumericValueFromBitArray2 != 13) {
                        switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(bitArray, 1, 7)) {
                            case 56:
                                return new AI013x0x1xDecoder(bitArray, "310", "11");
                            case 57:
                                return new AI013x0x1xDecoder(bitArray, "320", "11");
                            case 58:
                                return new AI013x0x1xDecoder(bitArray, "310", II0xO0.f26825XoIxOXIXo);
                            case 59:
                                return new AI013x0x1xDecoder(bitArray, "320", II0xO0.f26825XoIxOXIXo);
                            case 60:
                                return new AI013x0x1xDecoder(bitArray, "310", "15");
                            case 61:
                                return new AI013x0x1xDecoder(bitArray, "320", "15");
                            case 62:
                                return new AI013x0x1xDecoder(bitArray, "310", II0xO0.f26886xIXX);
                            case 63:
                                return new AI013x0x1xDecoder(bitArray, "320", II0xO0.f26886xIXX);
                            default:
                                throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(bitArray)));
                        }
                    }
                    return new AI01393xDecoder(bitArray);
                }
                return new AI01392xDecoder(bitArray);
            }
            return new AI01320xDecoder(bitArray);
        }
        return new AI013103decoder(bitArray);
    }

    public final GeneralAppIdDecoder getGeneralDecoder() {
        return this.generalDecoder;
    }

    public final BitArray getInformation() {
        return this.information;
    }

    public abstract String parseInformation() throws NotFoundException, FormatException;
}
