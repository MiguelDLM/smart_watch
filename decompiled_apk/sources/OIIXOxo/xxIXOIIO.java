package OIIXOxo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import oI0X0.x0xO0oo;
import oIXoXx0.IIXOooo;
import oIXoXx0.O0xOxO;
import oIXoXx0.OxxIIOOXO;
import oIXoXx0.X0IIOO;
import oIXoXx0.o00;
import oIXoXx0.oI0IIXIo;
import oIXoXx0.oO;
import oIXoXx0.ooOOo0oXI;
import oIXoXx0.x0XOIxOo;
import oIXoXx0.xoXoI;
import xIoXXXIXo.OxI;

/* loaded from: classes6.dex */
public class xxIXOIIO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f1648I0Io = XxIIOXIXx.X0o0xo.Oxx0IOOO(xxIXOIIO.class);

    /* renamed from: II0xO0, reason: collision with root package name */
    public File f1649II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public File f1650oIX0oI;

    public xxIXOIIO(String str, String str2) {
        this.f1650oIX0oI = new File(str);
        this.f1649II0xO0 = new File(str2);
        f1648I0Io.oOoXoXO(Boolean.getBoolean("jxl.nowarnings"));
        f1648I0Io.xxIXOIIO("Input file:  " + str);
        f1648I0Io.xxIXOIIO("Output file:  " + str2);
    }

    public void II0xO0() throws IOException, BiffException, WriteException {
        f1648I0Io.xxIXOIIO("Reading...");
        OxI XIxXXX0x02 = OxI.XIxXXX0x0(this.f1650oIX0oI);
        f1648I0Io.xxIXOIIO("Copying...");
        X0IIOO oOoXoXO2 = OxI.oOoXoXO(this.f1649II0xO0, XIxXXX0x02);
        if (this.f1650oIX0oI.getName().equals("jxlrwtest.xls")) {
            oIX0oI(oOoXoXO2);
        }
        oOoXoXO2.xXxxox0I();
        oOoXoXO2.OOXIXo();
        f1648I0Io.xxIXOIIO("Done");
    }

    public final void oIX0oI(X0IIOO x0iioo) throws WriteException {
        f1648I0Io.xxIXOIIO("Modifying...");
        O0xOxO OxxIIOOXO2 = x0iioo.OxxIIOOXO("modified");
        oI0IIXIo xoIox2 = OxxIIOOXO2.xoIox(1, 3);
        xoXoI.II0xO0 iI0xO0 = xoXoI.f31719oI0IIXIo;
        xoIox2.xxX(new IIXOooo(new xoXoI(iI0xO0, 10, xoXoI.f31716OxI)));
        OxxIIOOXO2.xoIox(1, 4).xxX(new IIXOooo(new xoXoI(iI0xO0, 10, xoXoI.f31718o00, false, x0xO0oo.f31597X0o0xo)));
        OxxIIOOXO2.xoIox(1, 5).xxX(new IIXOooo(new xoXoI(iI0xO0, 10)));
        oI0IIXIo xoIox3 = OxxIIOOXO2.xoIox(1, 6);
        xIoXXXIXo.Oxx0IOOO type = xoIox3.getType();
        xIoXXXIXo.Oxx0IOOO oxx0IOOO = xIoXXXIXo.Oxx0IOOO.f34232I0Io;
        if (type == oxx0IOOO) {
            ooOOo0oXI ooooo0oxi = (ooOOo0oXI) xoIox3;
            ooooo0oxi.O00XxXI(ooooo0oxi.IoOoX() + " - mod");
        }
        OxxIIOOXO2.xoIox(1, 9).xxX(new IIXOooo(new oO("#.0000000")));
        OxxIIOOXO2.xoIox(1, 10).xxX(new IIXOooo(new oO("0.####E0")));
        OxxIIOOXO2.xoIox(1, 11).xxX(X0IIOO.f31668I0Io);
        oI0IIXIo xoIox4 = OxxIIOOXO2.xoIox(1, 12);
        xIoXXXIXo.Oxx0IOOO type2 = xoIox4.getType();
        xIoXXXIXo.Oxx0IOOO oxx0IOOO2 = xIoXXXIXo.Oxx0IOOO.f34240oxoX;
        if (type2 == oxx0IOOO2) {
            ((x0XOIxOo) xoIox4).O00XxXI(42.0d);
        }
        oI0IIXIo xoIox5 = OxxIIOOXO2.xoIox(1, 13);
        if (xoIox5.getType() == oxx0IOOO2) {
            x0XOIxOo x0xoixoo = (x0XOIxOo) xoIox5;
            x0xoixoo.O00XxXI(x0xoixoo.getValue() + 0.1d);
        }
        OxxIIOOXO2.xoIox(1, 16).xxX(new IIXOooo(new oIXoXx0.II0XooXoX("dd MMM yyyy HH:mm:ss")));
        oI0IIXIo xoIox6 = OxxIIOOXO2.xoIox(1, 17);
        IIXOooo iIXOooo = new IIXOooo(oIXoXx0.xxIXOIIO.f31734xoIox);
        xoIox6.xxX(iIXOooo);
        oI0IIXIo xoIox7 = OxxIIOOXO2.xoIox(1, 18);
        if (xoIox7.getType() == xIoXXXIXo.Oxx0IOOO.f34239oOoXoXO) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(1998, 1, 18, 11, 23, 28);
            ((oIXoXx0.xoIox) xoIox7).ox(calendar.getTime());
        }
        oI0IIXIo xoIox8 = OxxIIOOXO2.xoIox(1, 22);
        if (xoIox8.getType() == oxx0IOOO2) {
            ((x0XOIxOo) xoIox8).O00XxXI(6.8d);
        }
        oI0IIXIo xoIox9 = OxxIIOOXO2.xoIox(1, 29);
        if (xoIox9.getType() == oxx0IOOO) {
            ((ooOOo0oXI) xoIox9).O00XxXI("Modified string contents");
        }
        OxxIIOOXO2.O0Xx(34);
        OxxIIOOXO2.XOxIOxOx(38);
        OxxIIOOXO2.O0xOxO(9);
        OxxIIOOXO2.XIxXXX0x0(11);
        OxxIIOOXO2.XOxIOxOx(43);
        OxxIIOOXO2.O0Xx(43);
        for (o00 o00Var : OxxIIOOXO2.xII()) {
            if (o00Var.oIX0oI() == 1 && o00Var.II0xO0() == 39) {
                try {
                    o00Var.o0xxxXXxX(new URL("http://www.andykhan.com/jexcelapi/index.html"));
                } catch (MalformedURLException e) {
                    f1648I0Io.ooOOo0oXI(e.toString());
                }
            } else if (o00Var.oIX0oI() == 1 && o00Var.II0xO0() == 40) {
                o00Var.Ioxxx(new File("../jexcelapi/docs/overview-summary.html"));
            } else if (o00Var.oIX0oI() == 1 && o00Var.II0xO0() == 41) {
                o00Var.Ioxxx(new File("d:/home/jexcelapi/docs/jxl/package-summary.html"));
            } else if (o00Var.oIX0oI() == 1 && o00Var.II0xO0() == 44) {
                OxxIIOOXO2.o0(o00Var);
            }
        }
        oI0IIXIo xoIox10 = OxxIIOOXO2.xoIox(5, 30);
        IIXOooo iIXOooo2 = new IIXOooo(xoIox10.xoIox());
        iIXOooo2.O0(oI0X0.XO.f31402OOXIXo);
        xoIox10.xxX(iIXOooo2);
        OxxIIOOXO2.o00(new ooOOo0oXI(0, 49, "Modified merged cells"));
        ((x0XOIxOo) OxxIIOOXO2.xoIox(0, 70)).O00XxXI(9.0d);
        ((x0XOIxOo) OxxIIOOXO2.xoIox(0, 71)).O00XxXI(10.0d);
        ((x0XOIxOo) OxxIIOOXO2.xoIox(0, 73)).O00XxXI(4.0d);
        OxxIIOOXO2.o00(new oIXoXx0.oOoXoXO(1, 80, "ROUND(COS(original!B10),2)"));
        OxxIIOOXO2.o00(new oIXoXx0.oOoXoXO(1, 83, "value1+value2"));
        OxxIIOOXO2.o00(new oIXoXx0.oOoXoXO(1, 84, "AVERAGE(value1,value1*4,value2)"));
        OxxIIOOXO2.o00(new ooOOo0oXI(0, 88, "Some copied cells", iIXOooo));
        OxxIIOOXO2.o00(new ooOOo0oXI(0, 89, "Number from B9"));
        OxxIIOOXO2.o00(OxxIIOOXO2.xoIox(1, 9).XI0IXoo(1, 89));
        OxxIIOOXO2.o00(new ooOOo0oXI(0, 90, "Label from B4 (modified format)"));
        OxxIIOOXO2.o00(OxxIIOOXO2.xoIox(1, 3).XI0IXoo(1, 90));
        OxxIIOOXO2.o00(new ooOOo0oXI(0, 91, "Date from B17"));
        OxxIIOOXO2.o00(OxxIIOOXO2.xoIox(1, 16).XI0IXoo(1, 91));
        OxxIIOOXO2.o00(new ooOOo0oXI(0, 92, "Boolean from E16"));
        OxxIIOOXO2.o00(OxxIIOOXO2.xoIox(4, 15).XI0IXoo(1, 92));
        OxxIIOOXO2.o00(new ooOOo0oXI(0, 93, "URL from B40"));
        OxxIIOOXO2.o00(OxxIIOOXO2.xoIox(1, 39).XI0IXoo(1, 93));
        int i = 0;
        while (i < 6) {
            int i2 = i + 1;
            OxxIIOOXO2.o00(new x0XOIxOo(1, i + 94, i2 + (i / 8.0d)));
            i = i2;
        }
        OxxIIOOXO2.o00(new ooOOo0oXI(0, 100, "Formula from B27"));
        OxxIIOOXO2.o00(OxxIIOOXO2.xoIox(1, 26).XI0IXoo(1, 100));
        OxxIIOOXO2.o00(new ooOOo0oXI(0, 101, "A brand new formula"));
        OxxIIOOXO2.o00(new oIXoXx0.oOoXoXO(1, 101, "SUM(B94:B96)"));
        OxxIIOOXO2.o00(new ooOOo0oXI(0, 102, "A copy of it"));
        OxxIIOOXO2.o00(OxxIIOOXO2.xoIox(1, 101).XI0IXoo(1, 102));
        OxxIIOOXO2.oI0IIXIo(OxxIIOOXO2.oxoX(1));
        OxxIIOOXO2.X00IoxXI(new oIXoXx0.OxI(1.0d, 116.0d, 2.0d, 9.0d, new File("resources/littlemoretonhall.png")));
        OxxIIOOXO2.o00(new ooOOo0oXI(0, 151, "Added drop down validation"));
        oI0IIXIo iI0xO02 = new oIXoXx0.II0xO0(1, 151);
        OxxIIOOXO oxxIIOOXO = new OxxIIOOXO();
        ArrayList arrayList = new ArrayList();
        arrayList.add("The Fellowship of the Ring");
        arrayList.add("The Two Towers");
        arrayList.add("The Return of the King");
        oxxIIOOXO.IXxxXO(arrayList);
        iI0xO02.xxIXOIIO(oxxIIOOXO);
        OxxIIOOXO2.o00(iI0xO02);
        OxxIIOOXO2.o00(new ooOOo0oXI(0, 152, "Added number validation 2.718 < x < 3.142"));
        oIXoXx0.II0xO0 iI0xO03 = new oIXoXx0.II0xO0(1, 152);
        OxxIIOOXO oxxIIOOXO2 = new OxxIIOOXO();
        oxxIIOOXO2.OxxIIOOXO(2.718d, 3.142d, OxxIIOOXO.f31660IIXOooo);
        iI0xO03.xxIXOIIO(oxxIIOOXO2);
        OxxIIOOXO2.o00(iI0xO03);
        ((ooOOo0oXI) OxxIIOOXO2.xoIox(0, 156)).O00XxXI("Label text modified");
        OxxIIOOXO2.xoIox(0, 157).Io().oO("modified comment text");
        OxxIIOOXO2.xoIox(0, 158).Io().OOXIXo();
        oI0IIXIo xoIox11 = OxxIIOOXO2.xoIox(0, 172);
        OxxIIOOXO Io2 = xoIox11.Io();
        xIoXXXIXo.I0Io II0xO02 = Io2.II0XooXoX().II0xO0();
        OxxIIOOXO2.XX0(xoIox11);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("Stanley Featherstonehaugh Ukridge");
        arrayList2.add("Major Plank");
        arrayList2.add("Earl of Ickenham");
        arrayList2.add("Sir Gregory Parsloe-Parsloe");
        arrayList2.add("Honoria Glossop");
        arrayList2.add("Stiffy Byng");
        arrayList2.add("Bingo Little");
        Io2.IXxxXO(arrayList2);
        xoIox11.xxIXOIIO(Io2);
        OxxIIOOXO2.IXxxXO(xoIox11, II0xO02.oIX0oI() - xoIox11.oIX0oI(), 1);
    }
}
