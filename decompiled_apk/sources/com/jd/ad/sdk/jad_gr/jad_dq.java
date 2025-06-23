package com.jd.ad.sdk.jad_gr;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser;
import com.jd.ad.sdk.logger.Logger;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* loaded from: classes10.dex */
public class jad_dq {
    public ByteBuffer jad_bo;
    public jad_cp jad_cp;
    public final byte[] jad_an = new byte[256];
    public int jad_dq = 0;

    public final boolean jad_an() {
        return this.jad_cp.jad_bo != 0;
    }

    @NonNull
    public jad_cp jad_bo() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this.jad_bo != null) {
            if (jad_an()) {
                return this.jad_cp;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append((char) jad_cp());
            }
            if (!sb.toString().startsWith("GIF")) {
                this.jad_cp.jad_bo = 1;
            } else {
                this.jad_cp.jad_fs = this.jad_bo.getShort();
                this.jad_cp.jad_jt = this.jad_bo.getShort();
                int jad_cp = jad_cp();
                jad_cp jad_cpVar = this.jad_cp;
                if ((jad_cp & 128) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                jad_cpVar.jad_hu = z;
                jad_cpVar.jad_iv = (int) Math.pow(2.0d, (jad_cp & 7) + 1);
                this.jad_cp.jad_jw = jad_cp();
                jad_cp jad_cpVar2 = this.jad_cp;
                jad_cp();
                jad_cpVar2.getClass();
                if (this.jad_cp.jad_hu && !jad_an()) {
                    jad_cp jad_cpVar3 = this.jad_cp;
                    jad_cpVar3.jad_an = jad_an(jad_cpVar3.jad_iv);
                    jad_cp jad_cpVar4 = this.jad_cp;
                    jad_cpVar4.jad_kx = jad_cpVar4.jad_an[jad_cpVar4.jad_jw];
                }
            }
            if (!jad_an()) {
                boolean z5 = false;
                while (!z5 && !jad_an() && this.jad_cp.jad_cp <= Integer.MAX_VALUE) {
                    int jad_cp2 = jad_cp();
                    if (jad_cp2 != 33) {
                        if (jad_cp2 != 44) {
                            if (jad_cp2 != 59) {
                                this.jad_cp.jad_bo = 1;
                            } else {
                                z5 = true;
                            }
                        } else {
                            jad_cp jad_cpVar5 = this.jad_cp;
                            if (jad_cpVar5.jad_dq == null) {
                                jad_cpVar5.jad_dq = new jad_bo();
                            }
                            jad_cpVar5.jad_dq.jad_an = this.jad_bo.getShort();
                            this.jad_cp.jad_dq.jad_bo = this.jad_bo.getShort();
                            this.jad_cp.jad_dq.jad_cp = this.jad_bo.getShort();
                            this.jad_cp.jad_dq.jad_dq = this.jad_bo.getShort();
                            int jad_cp3 = jad_cp();
                            if ((jad_cp3 & 128) != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            int pow = (int) Math.pow(2.0d, (jad_cp3 & 7) + 1);
                            jad_bo jad_boVar = this.jad_cp.jad_dq;
                            if ((jad_cp3 & 64) != 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            jad_boVar.jad_er = z3;
                            if (z2) {
                                jad_boVar.jad_kx = jad_an(pow);
                            } else {
                                jad_boVar.jad_kx = null;
                            }
                            this.jad_cp.jad_dq.jad_jw = this.jad_bo.position();
                            jad_cp();
                            jad_er();
                            if (!jad_an()) {
                                jad_cp jad_cpVar6 = this.jad_cp;
                                jad_cpVar6.jad_cp++;
                                jad_cpVar6.jad_er.add(jad_cpVar6.jad_dq);
                            }
                        }
                    } else {
                        int jad_cp4 = jad_cp();
                        if (jad_cp4 != 1) {
                            if (jad_cp4 != 249) {
                                if (jad_cp4 != 254 && jad_cp4 == 255) {
                                    jad_dq();
                                    StringBuilder sb2 = new StringBuilder();
                                    for (int i2 = 0; i2 < 11; i2++) {
                                        sb2.append((char) this.jad_an[i2]);
                                    }
                                    if (sb2.toString().equals("NETSCAPE2.0")) {
                                        do {
                                            jad_dq();
                                            byte[] bArr = this.jad_an;
                                            if (bArr[0] == 1) {
                                                byte b = bArr[1];
                                                byte b2 = bArr[2];
                                                this.jad_cp.getClass();
                                            }
                                            if (this.jad_dq > 0) {
                                            }
                                        } while (!jad_an());
                                    }
                                }
                            } else {
                                this.jad_cp.jad_dq = new jad_bo();
                                jad_cp();
                                int jad_cp5 = jad_cp();
                                jad_bo jad_boVar2 = this.jad_cp.jad_dq;
                                int i3 = (jad_cp5 & 28) >> 2;
                                jad_boVar2.jad_jt = i3;
                                if (i3 == 0) {
                                    jad_boVar2.jad_jt = 1;
                                }
                                if ((jad_cp5 & 1) != 0) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                jad_boVar2.jad_fs = z4;
                                short s = this.jad_bo.getShort();
                                if (s < 2) {
                                    s = 10;
                                }
                                jad_bo jad_boVar3 = this.jad_cp.jad_dq;
                                jad_boVar3.jad_iv = s * 10;
                                jad_boVar3.jad_hu = jad_cp();
                                jad_cp();
                            }
                        }
                        jad_er();
                    }
                }
                jad_cp jad_cpVar7 = this.jad_cp;
                if (jad_cpVar7.jad_cp < 0) {
                    jad_cpVar7.jad_bo = 1;
                }
            }
            return this.jad_cp;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public final int jad_cp() {
        try {
            return this.jad_bo.get() & 255;
        } catch (Exception unused) {
            this.jad_cp.jad_bo = 1;
            return 0;
        }
    }

    public final void jad_dq() {
        int jad_cp = jad_cp();
        this.jad_dq = jad_cp;
        if (jad_cp <= 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            try {
                i2 = this.jad_dq;
                if (i >= i2) {
                    return;
                }
                i2 -= i;
                this.jad_bo.get(this.jad_an, i, i2);
                i += i2;
            } catch (Exception e) {
                if (Log.isLoggable(GifHeaderParser.TAG, 3)) {
                    Logger.d(GifHeaderParser.TAG, "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.jad_dq, e);
                }
                this.jad_cp.jad_bo = 1;
                return;
            }
        }
    }

    public final void jad_er() {
        int jad_cp;
        do {
            jad_cp = jad_cp();
            this.jad_bo.position(Math.min(this.jad_bo.position() + jad_cp, this.jad_bo.limit()));
        } while (jad_cp > 0);
    }

    @Nullable
    public final int[] jad_an(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.jad_bo.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = bArr[i3] & 255;
                int i5 = i3 + 2;
                int i6 = bArr[i3 + 1] & 255;
                i3 += 3;
                int i7 = i2 + 1;
                iArr[i2] = (i6 << 8) | (i4 << 16) | ViewCompat.MEASURED_STATE_MASK | (bArr[i5] & 255);
                i2 = i7;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable(GifHeaderParser.TAG, 3)) {
                Logger.d(GifHeaderParser.TAG, "Format Error Reading Color Table", e);
            }
            this.jad_cp.jad_bo = 1;
        }
        return iArr;
    }
}
