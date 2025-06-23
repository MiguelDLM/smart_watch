package OxxIIOOXO;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.io.IOException;

/* loaded from: classes.dex */
public class o00 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final JsonReader.oIX0oI f3099oIX0oI = JsonReader.oIX0oI.oIX0oI("nm", DateFormatUtils.MIN, "hd");

    public static MergePaths oIX0oI(JsonReader jsonReader) throws IOException {
        String str = null;
        MergePaths.MergePathsMode mergePathsMode = null;
        boolean z = false;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f3099oIX0oI);
            if (Oo2 != 0) {
                if (Oo2 != 1) {
                    if (Oo2 != 2) {
                        jsonReader.IXxxXO();
                        jsonReader.Oxx0xo();
                    } else {
                        z = jsonReader.Oxx0IOOO();
                    }
                } else {
                    mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.xxIXOIIO());
                }
            } else {
                str = jsonReader.OOXIXo();
            }
        }
        return new MergePaths(str, mergePathsMode, z);
    }
}
