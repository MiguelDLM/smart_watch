package xI0OXooO;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.xXOx;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class oI0IIXIo implements xoXoI<CharSequence> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final Pattern f34129oIX0oI = Pattern.compile("(\\w)+");

    @Override // xI0OXooO.xoXoI
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public CharSequence[] oIX0oI(CharSequence charSequence) {
        xoIxX.XI0IXoo(xXOx.IIX0(charSequence), "Invalid text", new Object[0]);
        Matcher matcher = f34129oIX0oI.matcher(charSequence);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            arrayList.add(matcher.group(0));
        }
        return (CharSequence[]) arrayList.toArray(new String[0]);
    }
}
