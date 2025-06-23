package com.bomdic.gomoreedgekit.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class GMFitnessInput {
    private final int equipment;
    private final int fitnessType;
    private final int handedness;
    private final int posture;
    private final int source;

    @OOXIXo
    private final String trainingInfo;
    private final int venue;

    public GMFitnessInput() {
        this(0, 0, 0, 0, 0, 0, null, 127, null);
    }

    public static /* synthetic */ GMFitnessInput copy$default(GMFitnessInput gMFitnessInput, int i, int i2, int i3, int i4, int i5, int i6, String str, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = gMFitnessInput.fitnessType;
        }
        if ((i7 & 2) != 0) {
            i2 = gMFitnessInput.posture;
        }
        int i8 = i2;
        if ((i7 & 4) != 0) {
            i3 = gMFitnessInput.handedness;
        }
        int i9 = i3;
        if ((i7 & 8) != 0) {
            i4 = gMFitnessInput.source;
        }
        int i10 = i4;
        if ((i7 & 16) != 0) {
            i5 = gMFitnessInput.equipment;
        }
        int i11 = i5;
        if ((i7 & 32) != 0) {
            i6 = gMFitnessInput.venue;
        }
        int i12 = i6;
        if ((i7 & 64) != 0) {
            str = gMFitnessInput.trainingInfo;
        }
        return gMFitnessInput.copy(i, i8, i9, i10, i11, i12, str);
    }

    public final int component1() {
        return this.fitnessType;
    }

    public final int component2() {
        return this.posture;
    }

    public final int component3() {
        return this.handedness;
    }

    public final int component4() {
        return this.source;
    }

    public final int component5() {
        return this.equipment;
    }

    public final int component6() {
        return this.venue;
    }

    @OOXIXo
    public final String component7() {
        return this.trainingInfo;
    }

    @OOXIXo
    public final GMFitnessInput copy(int i, int i2, int i3, int i4, int i5, int i6, @OOXIXo String trainingInfo) {
        IIX0o.x0xO0oo(trainingInfo, "trainingInfo");
        return new GMFitnessInput(i, i2, i3, i4, i5, i6, trainingInfo);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GMFitnessInput)) {
            return false;
        }
        GMFitnessInput gMFitnessInput = (GMFitnessInput) obj;
        return this.fitnessType == gMFitnessInput.fitnessType && this.posture == gMFitnessInput.posture && this.handedness == gMFitnessInput.handedness && this.source == gMFitnessInput.source && this.equipment == gMFitnessInput.equipment && this.venue == gMFitnessInput.venue && IIX0o.Oxx0IOOO(this.trainingInfo, gMFitnessInput.trainingInfo);
    }

    public final int getEquipment() {
        return this.equipment;
    }

    public final int getFitnessType() {
        return this.fitnessType;
    }

    public final int getHandedness() {
        return this.handedness;
    }

    public final int getPosture() {
        return this.posture;
    }

    public final int getSource() {
        return this.source;
    }

    @OOXIXo
    public final String getTrainingInfo() {
        return this.trainingInfo;
    }

    public final int getVenue() {
        return this.venue;
    }

    public int hashCode() {
        return (((((((((((this.fitnessType * 31) + this.posture) * 31) + this.handedness) * 31) + this.source) * 31) + this.equipment) * 31) + this.venue) * 31) + this.trainingInfo.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "GMFitnessInput(fitnessType=" + this.fitnessType + ", posture=" + this.posture + ", handedness=" + this.handedness + ", source=" + this.source + ", equipment=" + this.equipment + ", venue=" + this.venue + ", trainingInfo=" + this.trainingInfo + oIX0oI.I0Io.f4095I0Io;
    }

    public GMFitnessInput(int i, int i2, int i3, int i4, int i5, int i6, @OOXIXo String trainingInfo) {
        IIX0o.x0xO0oo(trainingInfo, "trainingInfo");
        this.fitnessType = i;
        this.posture = i2;
        this.handedness = i3;
        this.source = i4;
        this.equipment = i5;
        this.venue = i6;
        this.trainingInfo = trainingInfo;
    }

    public /* synthetic */ GMFitnessInput(int i, int i2, int i3, int i4, int i5, int i6, String str, int i7, IIXOooo iIXOooo) {
        this((i7 & 1) != 0 ? 0 : i, (i7 & 2) != 0 ? 0 : i2, (i7 & 4) != 0 ? 0 : i3, (i7 & 8) != 0 ? 0 : i4, (i7 & 16) != 0 ? 0 : i5, (i7 & 32) == 0 ? i6 : 0, (i7 & 64) != 0 ? "" : str);
    }
}
