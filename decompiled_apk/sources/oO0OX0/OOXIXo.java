package oO0OX0;

import java.io.IOException;
import java.io.Writer;

@Deprecated
/* loaded from: classes6.dex */
public class OOXIXo extends I0Io {
    @Override // oO0OX0.I0Io
    public boolean XO(int i, Writer writer) throws IOException {
        if (i >= 55296 && i <= 57343) {
            return true;
        }
        return false;
    }
}
