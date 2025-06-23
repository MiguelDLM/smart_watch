package OxxIIOOXO;

import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class xoXoI {
    public static Mask oIX0oI(JsonReader jsonReader, com.airbnb.lottie.Oxx0IOOO oxx0IOOO) throws IOException {
        char c;
        char c2;
        jsonReader.I0Io();
        Mask.MaskMode maskMode = null;
        Oo.OOXIXo oOXIXo = null;
        Oo.Oxx0IOOO oxx0IOOO2 = null;
        boolean z = false;
        while (jsonReader.XO()) {
            String xoIox2 = jsonReader.xoIox();
            xoIox2.hashCode();
            switch (xoIox2.hashCode()) {
                case 111:
                    if (xoIox2.equals("o")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3588:
                    if (xoIox2.equals("pt")) {
                        c = 1;
                        break;
                    }
                    break;
                case 104433:
                    if (xoIox2.equals("inv")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3357091:
                    if (xoIox2.equals("mode")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            c = 65535;
            switch (c) {
                case 0:
                    oxx0IOOO2 = oxoX.II0XooXoX(jsonReader, oxx0IOOO);
                    break;
                case 1:
                    oOXIXo = oxoX.OOXIXo(jsonReader, oxx0IOOO);
                    break;
                case 2:
                    z = jsonReader.Oxx0IOOO();
                    break;
                case 3:
                    String OOXIXo2 = jsonReader.OOXIXo();
                    OOXIXo2.hashCode();
                    switch (OOXIXo2.hashCode()) {
                        case 97:
                            if (OOXIXo2.equals("a")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 105:
                            if (OOXIXo2.equals("i")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 110:
                            if (OOXIXo2.equals("n")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 115:
                            if (OOXIXo2.equals("s")) {
                                c2 = 3;
                                break;
                            }
                            break;
                    }
                    c2 = 65535;
                    switch (c2) {
                        case 0:
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                        case 1:
                            oxx0IOOO.oIX0oI("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                            break;
                        case 2:
                            maskMode = Mask.MaskMode.MASK_MODE_NONE;
                            break;
                        case 3:
                            maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            IIXOooo.XO.X0o0xo("Unknown mask mode " + xoIox2 + ". Defaulting to Add.");
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                    }
                default:
                    jsonReader.Oxx0xo();
                    break;
            }
        }
        jsonReader.X0o0xo();
        return new Mask(maskMode, oOXIXo, oxx0IOOO2, z);
    }
}
