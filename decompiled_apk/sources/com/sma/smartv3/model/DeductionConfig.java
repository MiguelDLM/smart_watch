package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class DeductionConfig extends JsonFieldContainer implements Serializable {
    private final int openAI_ChatPoints;
    private final int openAI_ImgPoints;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public DeductionConfig() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.model.DeductionConfig.<init>():void");
    }

    public static /* synthetic */ DeductionConfig copy$default(DeductionConfig deductionConfig, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = deductionConfig.openAI_ImgPoints;
        }
        if ((i3 & 2) != 0) {
            i2 = deductionConfig.openAI_ChatPoints;
        }
        return deductionConfig.copy(i, i2);
    }

    public final int component1() {
        return this.openAI_ImgPoints;
    }

    public final int component2() {
        return this.openAI_ChatPoints;
    }

    @OOXIXo
    public final DeductionConfig copy(int i, int i2) {
        return new DeductionConfig(i, i2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeductionConfig)) {
            return false;
        }
        DeductionConfig deductionConfig = (DeductionConfig) obj;
        return this.openAI_ImgPoints == deductionConfig.openAI_ImgPoints && this.openAI_ChatPoints == deductionConfig.openAI_ChatPoints;
    }

    public final int getOpenAI_ChatPoints() {
        return this.openAI_ChatPoints;
    }

    public final int getOpenAI_ImgPoints() {
        return this.openAI_ImgPoints;
    }

    public int hashCode() {
        return (this.openAI_ImgPoints * 31) + this.openAI_ChatPoints;
    }

    @OOXIXo
    public String toString() {
        return "DeductionConfig(openAI_ImgPoints=" + this.openAI_ImgPoints + ", openAI_ChatPoints=" + this.openAI_ChatPoints + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ DeductionConfig(int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public DeductionConfig(int i, int i2) {
        this.openAI_ImgPoints = i;
        this.openAI_ChatPoints = i2;
    }
}
