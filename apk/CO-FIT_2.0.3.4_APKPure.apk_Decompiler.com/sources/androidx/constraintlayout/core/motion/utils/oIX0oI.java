package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;

public final /* synthetic */ class oIX0oI {
    static {
        String str = TypedValues.AttributesType.NAME;
    }

    public static int II0xO0(int i) {
        if (i == 100) {
            return 2;
        }
        if (i == 101) {
            return 8;
        }
        switch (i) {
            case 301:
            case 302:
                return 2;
            case 303:
            case 304:
            case 305:
            case 306:
            case 307:
            case 308:
            case 309:
            case 310:
            case 311:
            case 312:
            case 313:
            case 314:
            case 315:
            case 316:
                return 4;
            case 317:
            case 318:
                return 8;
            default:
                return -1;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int oIX0oI(java.lang.String r2) {
        /*
            r2.hashCode()
            r0 = -1
            int r1 = r2.hashCode()
            switch(r1) {
                case -1310311125: goto L_0x0102;
                case -1249320806: goto L_0x00f6;
                case -1249320805: goto L_0x00ea;
                case -1249320804: goto L_0x00de;
                case -1225497657: goto L_0x00d2;
                case -1225497656: goto L_0x00c6;
                case -1225497655: goto L_0x00ba;
                case -1001078227: goto L_0x00ae;
                case -987906986: goto L_0x00a0;
                case -987906985: goto L_0x0092;
                case -908189618: goto L_0x0084;
                case -908189617: goto L_0x0077;
                case -880905839: goto L_0x006a;
                case -4379043: goto L_0x005d;
                case 92909918: goto L_0x0050;
                case 97692013: goto L_0x0043;
                case 579057826: goto L_0x0036;
                case 803192288: goto L_0x0029;
                case 1167159411: goto L_0x001c;
                case 1941332754: goto L_0x000e;
                default: goto L_0x000b;
            }
        L_0x000b:
            r2 = -1
            goto L_0x010d
        L_0x000e:
            java.lang.String r1 = "visibility"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0018
            goto L_0x000b
        L_0x0018:
            r2 = 19
            goto L_0x010d
        L_0x001c:
            java.lang.String r1 = "pivotTarget"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0025
            goto L_0x000b
        L_0x0025:
            r2 = 18
            goto L_0x010d
        L_0x0029:
            java.lang.String r1 = "pathRotate"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0032
            goto L_0x000b
        L_0x0032:
            r2 = 17
            goto L_0x010d
        L_0x0036:
            java.lang.String r1 = "curveFit"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x003f
            goto L_0x000b
        L_0x003f:
            r2 = 16
            goto L_0x010d
        L_0x0043:
            java.lang.String r1 = "frame"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x004c
            goto L_0x000b
        L_0x004c:
            r2 = 15
            goto L_0x010d
        L_0x0050:
            java.lang.String r1 = "alpha"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0059
            goto L_0x000b
        L_0x0059:
            r2 = 14
            goto L_0x010d
        L_0x005d:
            java.lang.String r1 = "elevation"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0066
            goto L_0x000b
        L_0x0066:
            r2 = 13
            goto L_0x010d
        L_0x006a:
            java.lang.String r1 = "target"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0073
            goto L_0x000b
        L_0x0073:
            r2 = 12
            goto L_0x010d
        L_0x0077:
            java.lang.String r1 = "scaleY"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0080
            goto L_0x000b
        L_0x0080:
            r2 = 11
            goto L_0x010d
        L_0x0084:
            java.lang.String r1 = "scaleX"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x008e
            goto L_0x000b
        L_0x008e:
            r2 = 10
            goto L_0x010d
        L_0x0092:
            java.lang.String r1 = "pivotY"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x009c
            goto L_0x000b
        L_0x009c:
            r2 = 9
            goto L_0x010d
        L_0x00a0:
            java.lang.String r1 = "pivotX"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x00aa
            goto L_0x000b
        L_0x00aa:
            r2 = 8
            goto L_0x010d
        L_0x00ae:
            java.lang.String r1 = "progress"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x00b8
            goto L_0x000b
        L_0x00b8:
            r2 = 7
            goto L_0x010d
        L_0x00ba:
            java.lang.String r1 = "translationZ"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x00c4
            goto L_0x000b
        L_0x00c4:
            r2 = 6
            goto L_0x010d
        L_0x00c6:
            java.lang.String r1 = "translationY"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x00d0
            goto L_0x000b
        L_0x00d0:
            r2 = 5
            goto L_0x010d
        L_0x00d2:
            java.lang.String r1 = "translationX"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x00dc
            goto L_0x000b
        L_0x00dc:
            r2 = 4
            goto L_0x010d
        L_0x00de:
            java.lang.String r1 = "rotationZ"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x00e8
            goto L_0x000b
        L_0x00e8:
            r2 = 3
            goto L_0x010d
        L_0x00ea:
            java.lang.String r1 = "rotationY"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x00f4
            goto L_0x000b
        L_0x00f4:
            r2 = 2
            goto L_0x010d
        L_0x00f6:
            java.lang.String r1 = "rotationX"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0100
            goto L_0x000b
        L_0x0100:
            r2 = 1
            goto L_0x010d
        L_0x0102:
            java.lang.String r1 = "easing"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x010c
            goto L_0x000b
        L_0x010c:
            r2 = 0
        L_0x010d:
            switch(r2) {
                case 0: goto L_0x014a;
                case 1: goto L_0x0147;
                case 2: goto L_0x0144;
                case 3: goto L_0x0141;
                case 4: goto L_0x013e;
                case 5: goto L_0x013b;
                case 6: goto L_0x0138;
                case 7: goto L_0x0135;
                case 8: goto L_0x0132;
                case 9: goto L_0x012f;
                case 10: goto L_0x012c;
                case 11: goto L_0x0129;
                case 12: goto L_0x0126;
                case 13: goto L_0x0123;
                case 14: goto L_0x0120;
                case 15: goto L_0x011d;
                case 16: goto L_0x011a;
                case 17: goto L_0x0117;
                case 18: goto L_0x0114;
                case 19: goto L_0x0111;
                default: goto L_0x0110;
            }
        L_0x0110:
            return r0
        L_0x0111:
            r2 = 302(0x12e, float:4.23E-43)
            return r2
        L_0x0114:
            r2 = 318(0x13e, float:4.46E-43)
            return r2
        L_0x0117:
            r2 = 316(0x13c, float:4.43E-43)
            return r2
        L_0x011a:
            r2 = 301(0x12d, float:4.22E-43)
            return r2
        L_0x011d:
            r2 = 100
            return r2
        L_0x0120:
            r2 = 303(0x12f, float:4.25E-43)
            return r2
        L_0x0123:
            r2 = 307(0x133, float:4.3E-43)
            return r2
        L_0x0126:
            r2 = 101(0x65, float:1.42E-43)
            return r2
        L_0x0129:
            r2 = 312(0x138, float:4.37E-43)
            return r2
        L_0x012c:
            r2 = 311(0x137, float:4.36E-43)
            return r2
        L_0x012f:
            r2 = 314(0x13a, float:4.4E-43)
            return r2
        L_0x0132:
            r2 = 313(0x139, float:4.39E-43)
            return r2
        L_0x0135:
            r2 = 315(0x13b, float:4.41E-43)
            return r2
        L_0x0138:
            r2 = 306(0x132, float:4.29E-43)
            return r2
        L_0x013b:
            r2 = 305(0x131, float:4.27E-43)
            return r2
        L_0x013e:
            r2 = 304(0x130, float:4.26E-43)
            return r2
        L_0x0141:
            r2 = 310(0x136, float:4.34E-43)
            return r2
        L_0x0144:
            r2 = 309(0x135, float:4.33E-43)
            return r2
        L_0x0147:
            r2 = 308(0x134, float:4.32E-43)
            return r2
        L_0x014a:
            r2 = 317(0x13d, float:4.44E-43)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.oIX0oI.oIX0oI(java.lang.String):int");
    }
}
