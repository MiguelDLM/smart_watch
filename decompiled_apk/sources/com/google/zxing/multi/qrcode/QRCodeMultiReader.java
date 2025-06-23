package com.google.zxing.multi.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.multi.qrcode.detector.MultiDetector;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public final class QRCodeMultiReader extends QRCodeReader implements MultipleBarcodeReader {
    private static final Result[] EMPTY_RESULT_ARRAY = new Result[0];
    private static final ResultPoint[] NO_POINTS = new ResultPoint[0];

    /* loaded from: classes10.dex */
    public static final class SAComparator implements Serializable, Comparator<Result> {
        private SAComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Result result, Result result2) {
            Map<ResultMetadataType, Object> resultMetadata = result.getResultMetadata();
            ResultMetadataType resultMetadataType = ResultMetadataType.STRUCTURED_APPEND_SEQUENCE;
            return Integer.compare(((Integer) resultMetadata.get(resultMetadataType)).intValue(), ((Integer) result2.getResultMetadata().get(resultMetadataType)).intValue());
        }
    }

    private static List<Result> processStructuredAppend(List<Result> list) {
        Iterator<Result> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getResultMetadata().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                ArrayList arrayList = new ArrayList();
                ArrayList<Result> arrayList2 = new ArrayList();
                for (Result result : list) {
                    arrayList.add(result);
                    if (result.getResultMetadata().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                        arrayList2.add(result);
                    }
                }
                Collections.sort(arrayList2, new SAComparator());
                StringBuilder sb = new StringBuilder();
                int i = 0;
                int i2 = 0;
                for (Result result2 : arrayList2) {
                    sb.append(result2.getText());
                    i += result2.getRawBytes().length;
                    Map<ResultMetadataType, Object> resultMetadata = result2.getResultMetadata();
                    ResultMetadataType resultMetadataType = ResultMetadataType.BYTE_SEGMENTS;
                    if (resultMetadata.containsKey(resultMetadataType)) {
                        Iterator it2 = ((Iterable) result2.getResultMetadata().get(resultMetadataType)).iterator();
                        while (it2.hasNext()) {
                            i2 += ((byte[]) it2.next()).length;
                        }
                    }
                }
                byte[] bArr = new byte[i];
                byte[] bArr2 = new byte[i2];
                int i3 = 0;
                int i4 = 0;
                for (Result result3 : arrayList2) {
                    System.arraycopy(result3.getRawBytes(), 0, bArr, i3, result3.getRawBytes().length);
                    i3 += result3.getRawBytes().length;
                    Map<ResultMetadataType, Object> resultMetadata2 = result3.getResultMetadata();
                    ResultMetadataType resultMetadataType2 = ResultMetadataType.BYTE_SEGMENTS;
                    if (resultMetadata2.containsKey(resultMetadataType2)) {
                        for (byte[] bArr3 : (Iterable) result3.getResultMetadata().get(resultMetadataType2)) {
                            System.arraycopy(bArr3, 0, bArr2, i4, bArr3.length);
                            i4 += bArr3.length;
                        }
                    }
                }
                Result result4 = new Result(sb.toString(), bArr, NO_POINTS, BarcodeFormat.QR_CODE);
                if (i2 > 0) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(bArr2);
                    result4.putMetadata(ResultMetadataType.BYTE_SEGMENTS, arrayList3);
                }
                arrayList.add(result4);
                return arrayList;
            }
        }
        return list;
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        for (DetectorResult detectorResult : new MultiDetector(binaryBitmap.getBlackMatrix()).detectMulti(map)) {
            try {
                DecoderResult decode = getDecoder().decode(detectorResult.getBits(), map);
                ResultPoint[] points = detectorResult.getPoints();
                if (decode.getOther() instanceof QRCodeDecoderMetaData) {
                    ((QRCodeDecoderMetaData) decode.getOther()).applyMirroredCorrection(points);
                }
                Result result = new Result(decode.getText(), decode.getRawBytes(), points, BarcodeFormat.QR_CODE);
                List<byte[]> byteSegments = decode.getByteSegments();
                if (byteSegments != null) {
                    result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
                }
                String eCLevel = decode.getECLevel();
                if (eCLevel != null) {
                    result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
                }
                if (decode.hasStructuredAppend()) {
                    result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(decode.getStructuredAppendSequenceNumber()));
                    result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(decode.getStructuredAppendParity()));
                }
                arrayList.add(result);
            } catch (ReaderException unused) {
            }
        }
        if (arrayList.isEmpty()) {
            return EMPTY_RESULT_ARRAY;
        }
        List<Result> processStructuredAppend = processStructuredAppend(arrayList);
        return (Result[]) processStructuredAppend.toArray(new Result[processStructuredAppend.size()]);
    }
}
