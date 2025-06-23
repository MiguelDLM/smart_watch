package o0oIxXOx;

import java.util.Objects;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/* loaded from: classes6.dex */
public final class oI0IIXIo extends oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final oI0IIXIo f31185I0Io = new oI0IIXIo();

    @Override // o0oIxXOx.OxxIIOOXO
    public String lookup(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(oIX0oI.f31186II0xO0, 2);
        if (split.length == 2) {
            String str2 = split[0];
            String str3 = split[1];
            try {
                ScriptEngine engineByName = new ScriptEngineManager().getEngineByName(str2);
                if (engineByName != null) {
                    return Objects.toString(engineByName.eval(str3), null);
                }
                throw new IllegalArgumentException("No script engine named " + str2);
            } catch (Exception e) {
                throw oOoXoXO.II0xO0(e, "Error in script engine [%s] evaluating script [%s].", str2, str3);
            }
        }
        throw oOoXoXO.oIX0oI("Bad script key format [%s]; expected format is EngineName:Script.", str);
    }
}
