package OxxIIOOXO;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.io.IOException;

public class o00 {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static final JsonReader.oIX0oI f202oIX0oI = JsonReader.oIX0oI.oIX0oI("nm", DateFormatUtils.MIN, "hd");

    public static MergePaths oIX0oI(JsonReader jsonReader) throws IOException {
        String str = null;
        MergePaths.MergePathsMode mergePathsMode = null;
        boolean z = false;
        while (jsonReader.XO()) {
            int Oo2 = jsonReader.Oo(f202oIX0oI);
            if (Oo2 == 0) {
                str = jsonReader.OOXIXo();
            } else if (Oo2 == 1) {
                mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.xxIXOIIO());
            } else if (Oo2 != 2) {
                jsonReader.IXxxXO();
                jsonReader.Oxx0xo();
            } else {
                z = jsonReader.Oxx0IOOO();
            }
        }
        return new MergePaths(str, mergePathsMode, z);
    }
}
