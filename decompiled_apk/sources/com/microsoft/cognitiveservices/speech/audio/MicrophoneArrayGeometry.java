package com.microsoft.cognitiveservices.speech.audio;

import com.microsoft.cognitiveservices.speech.util.Contracts;

/* loaded from: classes11.dex */
public class MicrophoneArrayGeometry {
    private int beamformingEndAngle;
    private int beamformingStartAngle;
    private MicrophoneArrayType microphoneArrayType;
    private MicrophoneCoordinates[] microphoneCoordinates;

    public MicrophoneArrayGeometry(MicrophoneArrayType microphoneArrayType, int i, int i2, MicrophoneCoordinates[] microphoneCoordinatesArr) {
        Contracts.throwIfNull(microphoneCoordinatesArr, "microphoneCoordinates");
        if (i < 0) {
            throw new IllegalArgumentException("beamformingStartAngle cannot be negative");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("beamformingEndAngle cannot be negative");
        }
        this.microphoneArrayType = microphoneArrayType;
        this.beamformingStartAngle = i;
        this.beamformingEndAngle = i2;
        this.microphoneCoordinates = new MicrophoneCoordinates[microphoneCoordinatesArr.length];
        for (int i3 = 0; i3 < microphoneCoordinatesArr.length; i3++) {
            this.microphoneCoordinates[i3] = new MicrophoneCoordinates(microphoneCoordinatesArr[i3]);
        }
    }

    public int getBeamformingEndAngle() {
        return this.beamformingEndAngle;
    }

    public int getBeamformingStartAngle() {
        return this.beamformingStartAngle;
    }

    public MicrophoneArrayType getMicrophoneArrayType() {
        return this.microphoneArrayType;
    }

    public MicrophoneCoordinates[] getMicrophoneCoordinates() {
        int length = this.microphoneCoordinates.length;
        MicrophoneCoordinates[] microphoneCoordinatesArr = new MicrophoneCoordinates[length];
        for (int i = 0; i < length; i++) {
            microphoneCoordinatesArr[i] = new MicrophoneCoordinates(this.microphoneCoordinates[i]);
        }
        return microphoneCoordinatesArr;
    }

    public MicrophoneArrayGeometry(MicrophoneArrayType microphoneArrayType, MicrophoneCoordinates[] microphoneCoordinatesArr) {
        Contracts.throwIfNull(microphoneCoordinatesArr, "microphoneCoordinates");
        this.microphoneArrayType = microphoneArrayType;
        this.beamformingStartAngle = 0;
        this.beamformingEndAngle = microphoneArrayType == MicrophoneArrayType.Linear ? 180 : 360;
        this.microphoneCoordinates = new MicrophoneCoordinates[microphoneCoordinatesArr.length];
        for (int i = 0; i < microphoneCoordinatesArr.length; i++) {
            this.microphoneCoordinates[i] = new MicrophoneCoordinates(microphoneCoordinatesArr[i]);
        }
    }
}
