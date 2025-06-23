package kotlin.text;

import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes6.dex */
public final class oO {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Regex f29577II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oO f29578oIX0oI = new oO();

    static {
        String str = "[eE][+-]?(\\p{Digit}+)";
        f29577II0xO0 = new Regex("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + (HexStringBuilder.COMMENT_BEGIN_CHAR + "(\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + str + ")?)|(\\.((\\p{Digit}+))(" + str + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)" + HexStringBuilder.COMMENT_END_CHAR) + ")[pP][+-]?(\\p{Digit}+)" + HexStringBuilder.COMMENT_END_CHAR) + ")[fFdD]?))[\\x00-\\x20]*");
    }
}
