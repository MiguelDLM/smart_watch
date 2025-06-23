package xXo;

import com.univocity.parsers.common.DataProcessingException;

/* loaded from: classes13.dex */
public class XO extends OxxIIOOXO<Character> {
    public XO() {
    }

    @Override // xXo.OxxIIOOXO
    /* renamed from: OOXIXo, reason: merged with bridge method [inline-methods] */
    public Character X0o0xo(String str) {
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        throw new DataProcessingException('\'' + str + "' is not a character");
    }

    public XO(Character ch, String str) {
        super(ch, str);
    }
}
