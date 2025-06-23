package com.jd.ad.sdk.jad_gr;

import android.graphics.Bitmap;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_gr.jad_an;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* loaded from: classes10.dex */
public class jad_er implements jad_an {

    @ColorInt
    public int[] jad_an;
    public final jad_an.InterfaceC0685jad_an jad_cp;
    public ByteBuffer jad_dq;
    public byte[] jad_er;
    public short[] jad_fs;
    public byte[] jad_hu;
    public byte[] jad_iv;
    public byte[] jad_jt;

    @ColorInt
    public int[] jad_jw;
    public int jad_kx;
    public Bitmap jad_mz;
    public boolean jad_na;
    public int jad_ob;
    public int jad_pc;
    public int jad_qd;
    public int jad_re;

    @Nullable
    public Boolean jad_sf;

    @ColorInt
    public final int[] jad_bo = new int[256];

    @NonNull
    public Bitmap.Config jad_tg = Bitmap.Config.ARGB_8888;
    public jad_cp jad_ly = new jad_cp();

    public jad_er(@NonNull jad_an.InterfaceC0685jad_an interfaceC0685jad_an) {
        this.jad_cp = interfaceC0685jad_an;
    }

    @Override // com.jd.ad.sdk.jad_gr.jad_an
    public void clear() {
        com.jd.ad.sdk.jad_lw.jad_bo jad_boVar;
        com.jd.ad.sdk.jad_lw.jad_bo jad_boVar2;
        com.jd.ad.sdk.jad_lw.jad_bo jad_boVar3;
        this.jad_ly = null;
        byte[] bArr = this.jad_iv;
        if (bArr != null && (jad_boVar3 = ((com.jd.ad.sdk.jad_vg.jad_bo) this.jad_cp).jad_bo) != null) {
            jad_boVar3.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) bArr);
        }
        int[] iArr = this.jad_jw;
        if (iArr != null && (jad_boVar2 = ((com.jd.ad.sdk.jad_vg.jad_bo) this.jad_cp).jad_bo) != null) {
            jad_boVar2.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) iArr);
        }
        Bitmap bitmap = this.jad_mz;
        if (bitmap != null) {
            ((com.jd.ad.sdk.jad_vg.jad_bo) this.jad_cp).jad_an.jad_an(bitmap);
        }
        this.jad_mz = null;
        this.jad_dq = null;
        this.jad_sf = null;
        byte[] bArr2 = this.jad_er;
        if (bArr2 != null && (jad_boVar = ((com.jd.ad.sdk.jad_vg.jad_bo) this.jad_cp).jad_bo) != null) {
            jad_boVar.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) bArr2);
        }
    }

    @Override // com.jd.ad.sdk.jad_gr.jad_an
    public int jad_an() {
        return this.jad_kx;
    }

    @Override // com.jd.ad.sdk.jad_gr.jad_an
    public int jad_bo() {
        return this.jad_ly.jad_cp;
    }

    @Override // com.jd.ad.sdk.jad_gr.jad_an
    public int jad_cp() {
        return (this.jad_jw.length * 4) + this.jad_dq.limit() + this.jad_iv.length;
    }

    @Override // com.jd.ad.sdk.jad_gr.jad_an
    public int jad_dq() {
        int i;
        jad_cp jad_cpVar = this.jad_ly;
        int i2 = jad_cpVar.jad_cp;
        if (i2 > 0 && (i = this.jad_kx) >= 0) {
            if (i >= 0 && i < i2) {
                return jad_cpVar.jad_er.get(i).jad_iv;
            }
            return -1;
        }
        return 0;
    }

    @Override // com.jd.ad.sdk.jad_gr.jad_an
    @NonNull
    public ByteBuffer jad_er() {
        return this.jad_dq;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0101, code lost:
    
        if (r9.jad_jw == r7.jad_hu) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0052 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0008, B:6:0x000f, B:9:0x0043, B:13:0x004c, B:15:0x0052, B:16:0x005c, B:18:0x006d, B:19:0x0079, B:22:0x0082, B:24:0x0086, B:26:0x008e, B:27:0x00a4, B:31:0x00a8, B:33:0x00ac, B:35:0x00be, B:37:0x00c2, B:38:0x00c6, B:40:0x00ca, B:42:0x00ce, B:43:0x00d7, B:45:0x00de, B:47:0x00e2, B:49:0x00e6, B:51:0x00eb, B:54:0x00f1, B:56:0x00f5, B:58:0x00fd, B:60:0x0104, B:62:0x011c, B:64:0x0121, B:66:0x0125, B:70:0x012b, B:72:0x012f, B:73:0x0141, B:75:0x0152, B:77:0x015f, B:79:0x0167, B:80:0x016b, B:82:0x0171, B:83:0x0175, B:85:0x017b, B:86:0x0181, B:88:0x0198, B:90:0x01a0, B:93:0x01bc, B:142:0x01e4, B:98:0x01f7, B:100:0x0218, B:129:0x0243, B:109:0x0256, B:112:0x0261, B:114:0x026c, B:116:0x027e, B:120:0x0293, B:123:0x02a0, B:308:0x01cc, B:144:0x02c4, B:146:0x02cb, B:149:0x02d2, B:152:0x02e3, B:154:0x02ed, B:157:0x02fb, B:159:0x0301, B:161:0x030f, B:163:0x0313, B:165:0x0317, B:170:0x0321, B:172:0x032a, B:174:0x032e, B:177:0x0340, B:178:0x0521, B:180:0x0525, B:184:0x052c, B:186:0x0530, B:187:0x0536, B:188:0x054b, B:191:0x0334, B:198:0x034a, B:201:0x0361, B:203:0x0376, B:206:0x0380, B:216:0x039e, B:217:0x03a3, B:221:0x03ac, B:224:0x03b8, B:228:0x03c8, B:230:0x03d5, B:232:0x03df, B:235:0x03dc, B:242:0x04f8, B:243:0x03fa, B:245:0x0409, B:246:0x041a, B:248:0x041f, B:251:0x0428, B:253:0x0433, B:255:0x0457, B:260:0x0467, B:261:0x0469, B:263:0x046e, B:266:0x0475, B:268:0x0480, B:270:0x049a, B:278:0x04ba, B:280:0x04c4, B:283:0x04c1, B:287:0x04a4, B:301:0x050d, B:305:0x051b, B:306:0x0517, B:311:0x0155, B:312:0x007e, B:314:0x0565, B:316:0x056e, B:319:0x0017, B:321:0x001f, B:322:0x0041), top: B:3:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0530 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0008, B:6:0x000f, B:9:0x0043, B:13:0x004c, B:15:0x0052, B:16:0x005c, B:18:0x006d, B:19:0x0079, B:22:0x0082, B:24:0x0086, B:26:0x008e, B:27:0x00a4, B:31:0x00a8, B:33:0x00ac, B:35:0x00be, B:37:0x00c2, B:38:0x00c6, B:40:0x00ca, B:42:0x00ce, B:43:0x00d7, B:45:0x00de, B:47:0x00e2, B:49:0x00e6, B:51:0x00eb, B:54:0x00f1, B:56:0x00f5, B:58:0x00fd, B:60:0x0104, B:62:0x011c, B:64:0x0121, B:66:0x0125, B:70:0x012b, B:72:0x012f, B:73:0x0141, B:75:0x0152, B:77:0x015f, B:79:0x0167, B:80:0x016b, B:82:0x0171, B:83:0x0175, B:85:0x017b, B:86:0x0181, B:88:0x0198, B:90:0x01a0, B:93:0x01bc, B:142:0x01e4, B:98:0x01f7, B:100:0x0218, B:129:0x0243, B:109:0x0256, B:112:0x0261, B:114:0x026c, B:116:0x027e, B:120:0x0293, B:123:0x02a0, B:308:0x01cc, B:144:0x02c4, B:146:0x02cb, B:149:0x02d2, B:152:0x02e3, B:154:0x02ed, B:157:0x02fb, B:159:0x0301, B:161:0x030f, B:163:0x0313, B:165:0x0317, B:170:0x0321, B:172:0x032a, B:174:0x032e, B:177:0x0340, B:178:0x0521, B:180:0x0525, B:184:0x052c, B:186:0x0530, B:187:0x0536, B:188:0x054b, B:191:0x0334, B:198:0x034a, B:201:0x0361, B:203:0x0376, B:206:0x0380, B:216:0x039e, B:217:0x03a3, B:221:0x03ac, B:224:0x03b8, B:228:0x03c8, B:230:0x03d5, B:232:0x03df, B:235:0x03dc, B:242:0x04f8, B:243:0x03fa, B:245:0x0409, B:246:0x041a, B:248:0x041f, B:251:0x0428, B:253:0x0433, B:255:0x0457, B:260:0x0467, B:261:0x0469, B:263:0x046e, B:266:0x0475, B:268:0x0480, B:270:0x049a, B:278:0x04ba, B:280:0x04c4, B:283:0x04c1, B:287:0x04a4, B:301:0x050d, B:305:0x051b, B:306:0x0517, B:311:0x0155, B:312:0x007e, B:314:0x0565, B:316:0x056e, B:319:0x0017, B:321:0x001f, B:322:0x0041), top: B:3:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0008, B:6:0x000f, B:9:0x0043, B:13:0x004c, B:15:0x0052, B:16:0x005c, B:18:0x006d, B:19:0x0079, B:22:0x0082, B:24:0x0086, B:26:0x008e, B:27:0x00a4, B:31:0x00a8, B:33:0x00ac, B:35:0x00be, B:37:0x00c2, B:38:0x00c6, B:40:0x00ca, B:42:0x00ce, B:43:0x00d7, B:45:0x00de, B:47:0x00e2, B:49:0x00e6, B:51:0x00eb, B:54:0x00f1, B:56:0x00f5, B:58:0x00fd, B:60:0x0104, B:62:0x011c, B:64:0x0121, B:66:0x0125, B:70:0x012b, B:72:0x012f, B:73:0x0141, B:75:0x0152, B:77:0x015f, B:79:0x0167, B:80:0x016b, B:82:0x0171, B:83:0x0175, B:85:0x017b, B:86:0x0181, B:88:0x0198, B:90:0x01a0, B:93:0x01bc, B:142:0x01e4, B:98:0x01f7, B:100:0x0218, B:129:0x0243, B:109:0x0256, B:112:0x0261, B:114:0x026c, B:116:0x027e, B:120:0x0293, B:123:0x02a0, B:308:0x01cc, B:144:0x02c4, B:146:0x02cb, B:149:0x02d2, B:152:0x02e3, B:154:0x02ed, B:157:0x02fb, B:159:0x0301, B:161:0x030f, B:163:0x0313, B:165:0x0317, B:170:0x0321, B:172:0x032a, B:174:0x032e, B:177:0x0340, B:178:0x0521, B:180:0x0525, B:184:0x052c, B:186:0x0530, B:187:0x0536, B:188:0x054b, B:191:0x0334, B:198:0x034a, B:201:0x0361, B:203:0x0376, B:206:0x0380, B:216:0x039e, B:217:0x03a3, B:221:0x03ac, B:224:0x03b8, B:228:0x03c8, B:230:0x03d5, B:232:0x03df, B:235:0x03dc, B:242:0x04f8, B:243:0x03fa, B:245:0x0409, B:246:0x041a, B:248:0x041f, B:251:0x0428, B:253:0x0433, B:255:0x0457, B:260:0x0467, B:261:0x0469, B:263:0x046e, B:266:0x0475, B:268:0x0480, B:270:0x049a, B:278:0x04ba, B:280:0x04c4, B:283:0x04c1, B:287:0x04a4, B:301:0x050d, B:305:0x051b, B:306:0x0517, B:311:0x0155, B:312:0x007e, B:314:0x0565, B:316:0x056e, B:319:0x0017, B:321:0x001f, B:322:0x0041), top: B:3:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0086 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0008, B:6:0x000f, B:9:0x0043, B:13:0x004c, B:15:0x0052, B:16:0x005c, B:18:0x006d, B:19:0x0079, B:22:0x0082, B:24:0x0086, B:26:0x008e, B:27:0x00a4, B:31:0x00a8, B:33:0x00ac, B:35:0x00be, B:37:0x00c2, B:38:0x00c6, B:40:0x00ca, B:42:0x00ce, B:43:0x00d7, B:45:0x00de, B:47:0x00e2, B:49:0x00e6, B:51:0x00eb, B:54:0x00f1, B:56:0x00f5, B:58:0x00fd, B:60:0x0104, B:62:0x011c, B:64:0x0121, B:66:0x0125, B:70:0x012b, B:72:0x012f, B:73:0x0141, B:75:0x0152, B:77:0x015f, B:79:0x0167, B:80:0x016b, B:82:0x0171, B:83:0x0175, B:85:0x017b, B:86:0x0181, B:88:0x0198, B:90:0x01a0, B:93:0x01bc, B:142:0x01e4, B:98:0x01f7, B:100:0x0218, B:129:0x0243, B:109:0x0256, B:112:0x0261, B:114:0x026c, B:116:0x027e, B:120:0x0293, B:123:0x02a0, B:308:0x01cc, B:144:0x02c4, B:146:0x02cb, B:149:0x02d2, B:152:0x02e3, B:154:0x02ed, B:157:0x02fb, B:159:0x0301, B:161:0x030f, B:163:0x0313, B:165:0x0317, B:170:0x0321, B:172:0x032a, B:174:0x032e, B:177:0x0340, B:178:0x0521, B:180:0x0525, B:184:0x052c, B:186:0x0530, B:187:0x0536, B:188:0x054b, B:191:0x0334, B:198:0x034a, B:201:0x0361, B:203:0x0376, B:206:0x0380, B:216:0x039e, B:217:0x03a3, B:221:0x03ac, B:224:0x03b8, B:228:0x03c8, B:230:0x03d5, B:232:0x03df, B:235:0x03dc, B:242:0x04f8, B:243:0x03fa, B:245:0x0409, B:246:0x041a, B:248:0x041f, B:251:0x0428, B:253:0x0433, B:255:0x0457, B:260:0x0467, B:261:0x0469, B:263:0x046e, B:266:0x0475, B:268:0x0480, B:270:0x049a, B:278:0x04ba, B:280:0x04c4, B:283:0x04c1, B:287:0x04a4, B:301:0x050d, B:305:0x051b, B:306:0x0517, B:311:0x0155, B:312:0x007e, B:314:0x0565, B:316:0x056e, B:319:0x0017, B:321:0x001f, B:322:0x0041), top: B:3:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x007e A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0008, B:6:0x000f, B:9:0x0043, B:13:0x004c, B:15:0x0052, B:16:0x005c, B:18:0x006d, B:19:0x0079, B:22:0x0082, B:24:0x0086, B:26:0x008e, B:27:0x00a4, B:31:0x00a8, B:33:0x00ac, B:35:0x00be, B:37:0x00c2, B:38:0x00c6, B:40:0x00ca, B:42:0x00ce, B:43:0x00d7, B:45:0x00de, B:47:0x00e2, B:49:0x00e6, B:51:0x00eb, B:54:0x00f1, B:56:0x00f5, B:58:0x00fd, B:60:0x0104, B:62:0x011c, B:64:0x0121, B:66:0x0125, B:70:0x012b, B:72:0x012f, B:73:0x0141, B:75:0x0152, B:77:0x015f, B:79:0x0167, B:80:0x016b, B:82:0x0171, B:83:0x0175, B:85:0x017b, B:86:0x0181, B:88:0x0198, B:90:0x01a0, B:93:0x01bc, B:142:0x01e4, B:98:0x01f7, B:100:0x0218, B:129:0x0243, B:109:0x0256, B:112:0x0261, B:114:0x026c, B:116:0x027e, B:120:0x0293, B:123:0x02a0, B:308:0x01cc, B:144:0x02c4, B:146:0x02cb, B:149:0x02d2, B:152:0x02e3, B:154:0x02ed, B:157:0x02fb, B:159:0x0301, B:161:0x030f, B:163:0x0313, B:165:0x0317, B:170:0x0321, B:172:0x032a, B:174:0x032e, B:177:0x0340, B:178:0x0521, B:180:0x0525, B:184:0x052c, B:186:0x0530, B:187:0x0536, B:188:0x054b, B:191:0x0334, B:198:0x034a, B:201:0x0361, B:203:0x0376, B:206:0x0380, B:216:0x039e, B:217:0x03a3, B:221:0x03ac, B:224:0x03b8, B:228:0x03c8, B:230:0x03d5, B:232:0x03df, B:235:0x03dc, B:242:0x04f8, B:243:0x03fa, B:245:0x0409, B:246:0x041a, B:248:0x041f, B:251:0x0428, B:253:0x0433, B:255:0x0457, B:260:0x0467, B:261:0x0469, B:263:0x046e, B:266:0x0475, B:268:0x0480, B:270:0x049a, B:278:0x04ba, B:280:0x04c4, B:283:0x04c1, B:287:0x04a4, B:301:0x050d, B:305:0x051b, B:306:0x0517, B:311:0x0155, B:312:0x007e, B:314:0x0565, B:316:0x056e, B:319:0x0017, B:321:0x001f, B:322:0x0041), top: B:3:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x056e A[Catch: all -> 0x0014, TRY_LEAVE, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0008, B:6:0x000f, B:9:0x0043, B:13:0x004c, B:15:0x0052, B:16:0x005c, B:18:0x006d, B:19:0x0079, B:22:0x0082, B:24:0x0086, B:26:0x008e, B:27:0x00a4, B:31:0x00a8, B:33:0x00ac, B:35:0x00be, B:37:0x00c2, B:38:0x00c6, B:40:0x00ca, B:42:0x00ce, B:43:0x00d7, B:45:0x00de, B:47:0x00e2, B:49:0x00e6, B:51:0x00eb, B:54:0x00f1, B:56:0x00f5, B:58:0x00fd, B:60:0x0104, B:62:0x011c, B:64:0x0121, B:66:0x0125, B:70:0x012b, B:72:0x012f, B:73:0x0141, B:75:0x0152, B:77:0x015f, B:79:0x0167, B:80:0x016b, B:82:0x0171, B:83:0x0175, B:85:0x017b, B:86:0x0181, B:88:0x0198, B:90:0x01a0, B:93:0x01bc, B:142:0x01e4, B:98:0x01f7, B:100:0x0218, B:129:0x0243, B:109:0x0256, B:112:0x0261, B:114:0x026c, B:116:0x027e, B:120:0x0293, B:123:0x02a0, B:308:0x01cc, B:144:0x02c4, B:146:0x02cb, B:149:0x02d2, B:152:0x02e3, B:154:0x02ed, B:157:0x02fb, B:159:0x0301, B:161:0x030f, B:163:0x0313, B:165:0x0317, B:170:0x0321, B:172:0x032a, B:174:0x032e, B:177:0x0340, B:178:0x0521, B:180:0x0525, B:184:0x052c, B:186:0x0530, B:187:0x0536, B:188:0x054b, B:191:0x0334, B:198:0x034a, B:201:0x0361, B:203:0x0376, B:206:0x0380, B:216:0x039e, B:217:0x03a3, B:221:0x03ac, B:224:0x03b8, B:228:0x03c8, B:230:0x03d5, B:232:0x03df, B:235:0x03dc, B:242:0x04f8, B:243:0x03fa, B:245:0x0409, B:246:0x041a, B:248:0x041f, B:251:0x0428, B:253:0x0433, B:255:0x0457, B:260:0x0467, B:261:0x0469, B:263:0x046e, B:266:0x0475, B:268:0x0480, B:270:0x049a, B:278:0x04ba, B:280:0x04c4, B:283:0x04c1, B:287:0x04a4, B:301:0x050d, B:305:0x051b, B:306:0x0517, B:311:0x0155, B:312:0x007e, B:314:0x0565, B:316:0x056e, B:319:0x0017, B:321:0x001f, B:322:0x0041), top: B:3:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a8 A[Catch: all -> 0x0014, TRY_ENTER, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0008, B:6:0x000f, B:9:0x0043, B:13:0x004c, B:15:0x0052, B:16:0x005c, B:18:0x006d, B:19:0x0079, B:22:0x0082, B:24:0x0086, B:26:0x008e, B:27:0x00a4, B:31:0x00a8, B:33:0x00ac, B:35:0x00be, B:37:0x00c2, B:38:0x00c6, B:40:0x00ca, B:42:0x00ce, B:43:0x00d7, B:45:0x00de, B:47:0x00e2, B:49:0x00e6, B:51:0x00eb, B:54:0x00f1, B:56:0x00f5, B:58:0x00fd, B:60:0x0104, B:62:0x011c, B:64:0x0121, B:66:0x0125, B:70:0x012b, B:72:0x012f, B:73:0x0141, B:75:0x0152, B:77:0x015f, B:79:0x0167, B:80:0x016b, B:82:0x0171, B:83:0x0175, B:85:0x017b, B:86:0x0181, B:88:0x0198, B:90:0x01a0, B:93:0x01bc, B:142:0x01e4, B:98:0x01f7, B:100:0x0218, B:129:0x0243, B:109:0x0256, B:112:0x0261, B:114:0x026c, B:116:0x027e, B:120:0x0293, B:123:0x02a0, B:308:0x01cc, B:144:0x02c4, B:146:0x02cb, B:149:0x02d2, B:152:0x02e3, B:154:0x02ed, B:157:0x02fb, B:159:0x0301, B:161:0x030f, B:163:0x0313, B:165:0x0317, B:170:0x0321, B:172:0x032a, B:174:0x032e, B:177:0x0340, B:178:0x0521, B:180:0x0525, B:184:0x052c, B:186:0x0530, B:187:0x0536, B:188:0x054b, B:191:0x0334, B:198:0x034a, B:201:0x0361, B:203:0x0376, B:206:0x0380, B:216:0x039e, B:217:0x03a3, B:221:0x03ac, B:224:0x03b8, B:228:0x03c8, B:230:0x03d5, B:232:0x03df, B:235:0x03dc, B:242:0x04f8, B:243:0x03fa, B:245:0x0409, B:246:0x041a, B:248:0x041f, B:251:0x0428, B:253:0x0433, B:255:0x0457, B:260:0x0467, B:261:0x0469, B:263:0x046e, B:266:0x0475, B:268:0x0480, B:270:0x049a, B:278:0x04ba, B:280:0x04c4, B:283:0x04c1, B:287:0x04a4, B:301:0x050d, B:305:0x051b, B:306:0x0517, B:311:0x0155, B:312:0x007e, B:314:0x0565, B:316:0x056e, B:319:0x0017, B:321:0x001f, B:322:0x0041), top: B:3:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011c A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0008, B:6:0x000f, B:9:0x0043, B:13:0x004c, B:15:0x0052, B:16:0x005c, B:18:0x006d, B:19:0x0079, B:22:0x0082, B:24:0x0086, B:26:0x008e, B:27:0x00a4, B:31:0x00a8, B:33:0x00ac, B:35:0x00be, B:37:0x00c2, B:38:0x00c6, B:40:0x00ca, B:42:0x00ce, B:43:0x00d7, B:45:0x00de, B:47:0x00e2, B:49:0x00e6, B:51:0x00eb, B:54:0x00f1, B:56:0x00f5, B:58:0x00fd, B:60:0x0104, B:62:0x011c, B:64:0x0121, B:66:0x0125, B:70:0x012b, B:72:0x012f, B:73:0x0141, B:75:0x0152, B:77:0x015f, B:79:0x0167, B:80:0x016b, B:82:0x0171, B:83:0x0175, B:85:0x017b, B:86:0x0181, B:88:0x0198, B:90:0x01a0, B:93:0x01bc, B:142:0x01e4, B:98:0x01f7, B:100:0x0218, B:129:0x0243, B:109:0x0256, B:112:0x0261, B:114:0x026c, B:116:0x027e, B:120:0x0293, B:123:0x02a0, B:308:0x01cc, B:144:0x02c4, B:146:0x02cb, B:149:0x02d2, B:152:0x02e3, B:154:0x02ed, B:157:0x02fb, B:159:0x0301, B:161:0x030f, B:163:0x0313, B:165:0x0317, B:170:0x0321, B:172:0x032a, B:174:0x032e, B:177:0x0340, B:178:0x0521, B:180:0x0525, B:184:0x052c, B:186:0x0530, B:187:0x0536, B:188:0x054b, B:191:0x0334, B:198:0x034a, B:201:0x0361, B:203:0x0376, B:206:0x0380, B:216:0x039e, B:217:0x03a3, B:221:0x03ac, B:224:0x03b8, B:228:0x03c8, B:230:0x03d5, B:232:0x03df, B:235:0x03dc, B:242:0x04f8, B:243:0x03fa, B:245:0x0409, B:246:0x041a, B:248:0x041f, B:251:0x0428, B:253:0x0433, B:255:0x0457, B:260:0x0467, B:261:0x0469, B:263:0x046e, B:266:0x0475, B:268:0x0480, B:270:0x049a, B:278:0x04ba, B:280:0x04c4, B:283:0x04c1, B:287:0x04a4, B:301:0x050d, B:305:0x051b, B:306:0x0517, B:311:0x0155, B:312:0x007e, B:314:0x0565, B:316:0x056e, B:319:0x0017, B:321:0x001f, B:322:0x0041), top: B:3:0x0008 }] */
    @Override // com.jd.ad.sdk.jad_gr.jad_an
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized android.graphics.Bitmap jad_fs() {
        /*
            Method dump skipped, instructions count: 1418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_gr.jad_er.jad_fs():android.graphics.Bitmap");
    }

    public final Bitmap jad_hu() {
        Bitmap.Config config;
        Boolean bool = this.jad_sf;
        if (bool != null && !bool.booleanValue()) {
            config = this.jad_tg;
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        jad_an.InterfaceC0685jad_an interfaceC0685jad_an = this.jad_cp;
        Bitmap jad_bo = ((com.jd.ad.sdk.jad_vg.jad_bo) interfaceC0685jad_an).jad_an.jad_bo(this.jad_re, this.jad_qd, config);
        jad_bo.setHasAlpha(true);
        return jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_gr.jad_an
    public void jad_jt() {
        this.jad_kx = (this.jad_kx + 1) % this.jad_ly.jad_cp;
    }

    public void jad_an(@NonNull Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.jad_tg = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    public synchronized void jad_an(@NonNull jad_cp jad_cpVar, @NonNull ByteBuffer byteBuffer, int i) {
        try {
            if (i <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
            }
            int highestOneBit = Integer.highestOneBit(i);
            this.jad_ob = 0;
            this.jad_ly = jad_cpVar;
            this.jad_kx = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.jad_dq = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.jad_dq.order(ByteOrder.LITTLE_ENDIAN);
            this.jad_na = false;
            Iterator<jad_bo> it = jad_cpVar.jad_er.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().jad_jt == 3) {
                    this.jad_na = true;
                    break;
                }
            }
            this.jad_pc = highestOneBit;
            int i2 = jad_cpVar.jad_fs;
            this.jad_re = i2 / highestOneBit;
            int i3 = jad_cpVar.jad_jt;
            this.jad_qd = i3 / highestOneBit;
            this.jad_iv = ((com.jd.ad.sdk.jad_vg.jad_bo) this.jad_cp).jad_an(i2 * i3);
            jad_an.InterfaceC0685jad_an interfaceC0685jad_an = this.jad_cp;
            int i4 = this.jad_re * this.jad_qd;
            com.jd.ad.sdk.jad_lw.jad_bo jad_boVar = ((com.jd.ad.sdk.jad_vg.jad_bo) interfaceC0685jad_an).jad_bo;
            this.jad_jw = jad_boVar == null ? new int[i4] : (int[]) jad_boVar.jad_an(i4, int[].class);
        } catch (Throwable th) {
            throw th;
        }
    }
}
