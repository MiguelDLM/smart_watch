package OIIXOxo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import oI0X0.ooOOo0oXI;
import org.apache.log4j.helpers.oI0IIXIo;
import xIoXXXIXo.IIXOooo;
import xIoXXXIXo.OxI;

/* loaded from: classes6.dex */
public class oOoXoXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public OxI f1643I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f1644II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public OutputStream f1645oIX0oI;

    public oOoXoXO(OxI oxI, OutputStream outputStream, String str, boolean z) throws IOException {
        this.f1644II0xO0 = str;
        this.f1643I0Io = oxI;
        this.f1645oIX0oI = outputStream;
        if (str == null || !str.equals("UnicodeBig")) {
            this.f1644II0xO0 = "UTF8";
        }
        if (z) {
            oIX0oI();
        } else {
            II0xO0();
        }
    }

    public final void II0xO0() throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.f1645oIX0oI, this.f1644II0xO0));
            bufferedWriter.write("<?xml version=\"1.0\" ?>");
            bufferedWriter.newLine();
            bufferedWriter.write("<!DOCTYPE workbook SYSTEM \"workbook.dtd\">");
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write("<workbook>");
            bufferedWriter.newLine();
            for (int i = 0; i < this.f1643I0Io.IIXOooo(); i++) {
                IIXOooo o002 = this.f1643I0Io.o00(i);
                bufferedWriter.write("  <sheet>");
                bufferedWriter.newLine();
                bufferedWriter.write("    <name><![CDATA[" + o002.getName() + "]]></name>");
                bufferedWriter.newLine();
                for (int i2 = 0; i2 < o002.OxxIIOOXO(); i2++) {
                    bufferedWriter.write("    <row number=\"" + i2 + "\">");
                    bufferedWriter.newLine();
                    xIoXXXIXo.I0Io[] x0o2 = o002.x0o(i2);
                    for (int i3 = 0; i3 < x0o2.length; i3++) {
                        if (x0o2[i3].getType() != xIoXXXIXo.Oxx0IOOO.f34234II0xO0) {
                            bufferedWriter.write("      <col number=\"" + i3 + "\">");
                            bufferedWriter.write(oI0IIXIo.f33271oIX0oI + x0o2[i3].IIX0o() + oI0IIXIo.f33269II0xO0);
                            bufferedWriter.write("</col>");
                            bufferedWriter.newLine();
                        }
                    }
                    bufferedWriter.write("    </row>");
                    bufferedWriter.newLine();
                }
                bufferedWriter.write("  </sheet>");
                bufferedWriter.newLine();
            }
            bufferedWriter.write("</workbook>");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.toString());
        }
    }

    public final void oIX0oI() throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.f1645oIX0oI, this.f1644II0xO0));
            bufferedWriter.write("<?xml version=\"1.0\" ?>");
            bufferedWriter.newLine();
            bufferedWriter.write("<!DOCTYPE workbook SYSTEM \"formatworkbook.dtd\">");
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write("<workbook>");
            bufferedWriter.newLine();
            for (int i = 0; i < this.f1643I0Io.IIXOooo(); i++) {
                IIXOooo o002 = this.f1643I0Io.o00(i);
                bufferedWriter.write("  <sheet>");
                bufferedWriter.newLine();
                bufferedWriter.write("    <name><![CDATA[" + o002.getName() + "]]></name>");
                bufferedWriter.newLine();
                for (int i2 = 0; i2 < o002.OxxIIOOXO(); i2++) {
                    bufferedWriter.write("    <row number=\"" + i2 + "\">");
                    bufferedWriter.newLine();
                    xIoXXXIXo.I0Io[] x0o2 = o002.x0o(i2);
                    for (int i3 = 0; i3 < x0o2.length; i3++) {
                        if (x0o2[i3].getType() == xIoXXXIXo.Oxx0IOOO.f34234II0xO0 && x0o2[i3].xoIox() == null) {
                        }
                        oI0X0.X0o0xo xoIox2 = x0o2[i3].xoIox();
                        bufferedWriter.write("      <col number=\"" + i3 + "\">");
                        bufferedWriter.newLine();
                        bufferedWriter.write("        <data>");
                        bufferedWriter.write(oI0IIXIo.f33271oIX0oI + x0o2[i3].IIX0o() + oI0IIXIo.f33269II0xO0);
                        bufferedWriter.write("</data>");
                        bufferedWriter.newLine();
                        if (x0o2[i3].xoIox() != null) {
                            bufferedWriter.write("        <format wrap=\"" + xoIox2.xXxxox0I() + "\"");
                            bufferedWriter.newLine();
                            bufferedWriter.write("                align=\"" + xoIox2.oI0IIXIo().II0xO0() + "\"");
                            bufferedWriter.newLine();
                            bufferedWriter.write("                valign=\"" + xoIox2.OxxIIOOXO().II0xO0() + "\"");
                            bufferedWriter.newLine();
                            bufferedWriter.write("                orientation=\"" + xoIox2.OOXIXo().oIX0oI() + "\"");
                            bufferedWriter.write(">");
                            bufferedWriter.newLine();
                            oI0X0.Oxx0IOOO XIxXXX0x02 = xoIox2.XIxXXX0x0();
                            bufferedWriter.write("          <font name=\"" + XIxXXX0x02.getName() + "\"");
                            bufferedWriter.newLine();
                            bufferedWriter.write("                point_size=\"" + XIxXXX0x02.xoXoI() + "\"");
                            bufferedWriter.newLine();
                            bufferedWriter.write("                bold_weight=\"" + XIxXXX0x02.XOxIOxOx() + "\"");
                            bufferedWriter.newLine();
                            bufferedWriter.write("                italic=\"" + XIxXXX0x02.OI0() + "\"");
                            bufferedWriter.newLine();
                            bufferedWriter.write("                underline=\"" + XIxXXX0x02.o00().oIX0oI() + "\"");
                            bufferedWriter.newLine();
                            bufferedWriter.write("                colour=\"" + XIxXXX0x02.O0xOxO().XO() + "\"");
                            bufferedWriter.newLine();
                            bufferedWriter.write("                script=\"" + XIxXXX0x02.XX().oIX0oI() + "\"");
                            bufferedWriter.write(" />");
                            bufferedWriter.newLine();
                            if (xoIox2.X0IIOO() != oI0X0.XO.f31449xxIXOIIO || xoIox2.getPattern() != ooOOo0oXI.f31567oxoX) {
                                bufferedWriter.write("          <background colour=\"" + xoIox2.X0IIOO().XO() + "\"");
                                bufferedWriter.newLine();
                                bufferedWriter.write("                      pattern=\"" + xoIox2.getPattern().oIX0oI() + "\"");
                                bufferedWriter.write(" />");
                                bufferedWriter.newLine();
                            }
                            oI0X0.I0Io i0Io = oI0X0.I0Io.f31371oxoX;
                            oI0X0.oxoX oOXoIIIo2 = xoIox2.oOXoIIIo(i0Io);
                            oI0X0.oxoX oxox = oI0X0.oxoX.f31584oxoX;
                            if (oOXoIIIo2 != oxox || xoIox2.oOXoIIIo(oI0X0.I0Io.f31369X0o0xo) != oxox || xoIox2.oOXoIIIo(oI0X0.I0Io.f31370XO) != oxox || xoIox2.oOXoIIIo(oI0X0.I0Io.f31368Oxx0IOOO) != oxox) {
                                bufferedWriter.write("          <border top=\"" + xoIox2.oOXoIIIo(i0Io).oIX0oI() + "\"");
                                bufferedWriter.newLine();
                                bufferedWriter.write("                  bottom=\"" + xoIox2.oOXoIIIo(oI0X0.I0Io.f31369X0o0xo).oIX0oI() + "\"");
                                bufferedWriter.newLine();
                                bufferedWriter.write("                  left=\"" + xoIox2.oOXoIIIo(oI0X0.I0Io.f31370XO).oIX0oI() + "\"");
                                bufferedWriter.newLine();
                                bufferedWriter.write("                  right=\"" + xoIox2.oOXoIIIo(oI0X0.I0Io.f31368Oxx0IOOO).oIX0oI() + "\"");
                                bufferedWriter.write(" />");
                                bufferedWriter.newLine();
                            }
                            if (!xoIox2.xI().XxX0x0xxx().equals("")) {
                                bufferedWriter.write("          <format_string string=\"");
                                bufferedWriter.write(xoIox2.xI().XxX0x0xxx());
                                bufferedWriter.write("\" />");
                                bufferedWriter.newLine();
                            }
                            bufferedWriter.write("        </format>");
                            bufferedWriter.newLine();
                        }
                        bufferedWriter.write("      </col>");
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write("    </row>");
                    bufferedWriter.newLine();
                }
                bufferedWriter.write("  </sheet>");
                bufferedWriter.newLine();
            }
            bufferedWriter.write("</workbook>");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.toString());
        }
    }
}
