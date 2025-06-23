package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.IndexSeekMap;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class SubtitleExtractor implements Extractor {
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    private static final int STATE_CREATED = 0;
    private static final int STATE_EXTRACTING = 2;
    private static final int STATE_FINISHED = 4;
    private static final int STATE_INITIALIZED = 1;
    private static final int STATE_RELEASED = 5;
    private static final int STATE_SEEKING = 3;
    private int bytesRead;
    private ExtractorOutput extractorOutput;
    private final Format format;
    private final SubtitleDecoder subtitleDecoder;
    private TrackOutput trackOutput;
    private final CueEncoder cueEncoder = new CueEncoder();
    private final ParsableByteArray subtitleData = new ParsableByteArray();
    private final List<Long> timestamps = new ArrayList();
    private final List<ParsableByteArray> samples = new ArrayList();
    private int state = 0;
    private long seekTimeUs = C.TIME_UNSET;

    public SubtitleExtractor(SubtitleDecoder subtitleDecoder, Format format) {
        this.subtitleDecoder = subtitleDecoder;
        this.format = format.buildUpon().setSampleMimeType(MimeTypes.TEXT_EXOPLAYER_CUES).setCodecs(format.sampleMimeType).build();
    }

    private void decode() throws IOException {
        try {
            SubtitleInputBuffer dequeueInputBuffer = this.subtitleDecoder.dequeueInputBuffer();
            while (dequeueInputBuffer == null) {
                Thread.sleep(5L);
                dequeueInputBuffer = this.subtitleDecoder.dequeueInputBuffer();
            }
            dequeueInputBuffer.ensureSpaceForWrite(this.bytesRead);
            dequeueInputBuffer.data.put(this.subtitleData.getData(), 0, this.bytesRead);
            dequeueInputBuffer.data.limit(this.bytesRead);
            this.subtitleDecoder.queueInputBuffer(dequeueInputBuffer);
            SubtitleOutputBuffer dequeueOutputBuffer = this.subtitleDecoder.dequeueOutputBuffer();
            while (dequeueOutputBuffer == null) {
                Thread.sleep(5L);
                dequeueOutputBuffer = this.subtitleDecoder.dequeueOutputBuffer();
            }
            for (int i = 0; i < dequeueOutputBuffer.getEventTimeCount(); i++) {
                byte[] encode = this.cueEncoder.encode(dequeueOutputBuffer.getCues(dequeueOutputBuffer.getEventTime(i)));
                this.timestamps.add(Long.valueOf(dequeueOutputBuffer.getEventTime(i)));
                this.samples.add(new ParsableByteArray(encode));
            }
            dequeueOutputBuffer.release();
        } catch (SubtitleDecoderException e) {
            throw ParserException.createForMalformedContainer("SubtitleDecoder failed.", e);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    private boolean readFromInput(ExtractorInput extractorInput) throws IOException {
        int capacity = this.subtitleData.capacity();
        int i = this.bytesRead;
        if (capacity == i) {
            this.subtitleData.ensureCapacity(i + 1024);
        }
        int read = extractorInput.read(this.subtitleData.getData(), this.bytesRead, this.subtitleData.capacity() - this.bytesRead);
        if (read != -1) {
            this.bytesRead += read;
        }
        long length = extractorInput.getLength();
        if ((length != -1 && this.bytesRead == length) || read == -1) {
            return true;
        }
        return false;
    }

    private boolean skipInput(ExtractorInput extractorInput) throws IOException {
        int i;
        if (extractorInput.getLength() != -1) {
            i = Ints.checkedCast(extractorInput.getLength());
        } else {
            i = 1024;
        }
        if (extractorInput.skip(i) == -1) {
            return true;
        }
        return false;
    }

    private void writeToOutput() {
        boolean z;
        int binarySearchFloor;
        Assertions.checkStateNotNull(this.trackOutput);
        if (this.timestamps.size() == this.samples.size()) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        long j = this.seekTimeUs;
        if (j == C.TIME_UNSET) {
            binarySearchFloor = 0;
        } else {
            binarySearchFloor = Util.binarySearchFloor((List<? extends Comparable<? super Long>>) this.timestamps, Long.valueOf(j), true, true);
        }
        while (binarySearchFloor < this.samples.size()) {
            ParsableByteArray parsableByteArray = this.samples.get(binarySearchFloor);
            parsableByteArray.setPosition(0);
            int length = parsableByteArray.getData().length;
            this.trackOutput.sampleData(parsableByteArray, length);
            this.trackOutput.sampleMetadata(this.timestamps.get(binarySearchFloor).longValue(), 1, length, 0, null);
            binarySearchFloor++;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        boolean z;
        if (this.state == 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.extractorOutput = extractorOutput;
        this.trackOutput = extractorOutput.track(0, 3);
        this.extractorOutput.endTracks();
        this.extractorOutput.seekMap(new IndexSeekMap(new long[]{0}, new long[]{0}, C.TIME_UNSET));
        this.trackOutput.format(this.format);
        this.state = 1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean z;
        int i;
        int i2 = this.state;
        if (i2 != 0 && i2 != 5) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        if (this.state == 1) {
            ParsableByteArray parsableByteArray = this.subtitleData;
            if (extractorInput.getLength() != -1) {
                i = Ints.checkedCast(extractorInput.getLength());
            } else {
                i = 1024;
            }
            parsableByteArray.reset(i);
            this.bytesRead = 0;
            this.state = 2;
        }
        if (this.state == 2 && readFromInput(extractorInput)) {
            decode();
            writeToOutput();
            this.state = 4;
        }
        if (this.state == 3 && skipInput(extractorInput)) {
            writeToOutput();
            this.state = 4;
        }
        if (this.state != 4) {
            return 0;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
        if (this.state == 5) {
            return;
        }
        this.subtitleDecoder.release();
        this.state = 5;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        boolean z;
        int i = this.state;
        if (i != 0 && i != 5) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.seekTimeUs = j2;
        if (this.state == 2) {
            this.state = 1;
        }
        if (this.state == 4) {
            this.state = 3;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return true;
    }
}
