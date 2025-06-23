package ox0;

import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.log4j.II0xO0;
import org.apache.log4j.oI0IIXIo;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class oIX0oI extends II0xO0 implements org.apache.log4j.oIX0oI {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f33525II0XooXoX = "jdbc:odbc:myDB";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public String f33532xxIXOIIO = TournamentShareDialogURIBuilder.f10996me;

    /* renamed from: xoIox, reason: collision with root package name */
    public String f33531xoIox = "mypassword";

    /* renamed from: OOXIXo, reason: collision with root package name */
    public Connection f33526OOXIXo = null;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public String f33528oOoXoXO = "";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f33529ooOOo0oXI = 1;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public ArrayList f33530x0XOIxOo = new ArrayList(this.f33529ooOOo0oXI);

    /* renamed from: oO, reason: collision with root package name */
    public ArrayList f33527oO = new ArrayList(this.f33529ooOOo0oXI);

    public String IIX0o() {
        return this.f33531xoIox;
    }

    @Override // org.apache.log4j.II0xO0
    public void IIXOooo(LoggingEvent loggingEvent) {
        this.f33530x0XOIxOo.add(loggingEvent);
        if (this.f33530x0XOIxOo.size() >= this.f33529ooOOo0oXI) {
            XIxXXX0x0();
        }
    }

    public void IO(String str) {
        this.f33532xxIXOIIO = str;
    }

    public void IoOoX(String str) {
        try {
            Class.forName(str);
        } catch (Exception e) {
            this.f33162oxoX.OxxIIOOXO("Failed to load driver", e, 0);
        }
    }

    public void X00IoxXI(String str) {
        this.f33525II0XooXoX = str;
    }

    public void XI0IXoo(String str) throws SQLException {
        Statement statement = null;
        try {
            Connection XxX0x0xxx2 = XxX0x0xxx();
            statement = XxX0x0xxx2.createStatement();
            statement.executeUpdate(str);
            statement.close();
            X0IIOO(XxX0x0xxx2);
        } catch (SQLException e) {
            if (statement != null) {
                statement.close();
            }
            throw e;
        }
    }

    public void XIxXXX0x0() {
        this.f33527oO.ensureCapacity(this.f33530x0XOIxOo.size());
        Iterator it = this.f33530x0XOIxOo.iterator();
        while (it.hasNext()) {
            try {
                LoggingEvent loggingEvent = (LoggingEvent) it.next();
                XI0IXoo(xXxxox0I(loggingEvent));
                this.f33527oO.add(loggingEvent);
            } catch (SQLException e) {
                this.f33162oxoX.OxxIIOOXO("Failed to excute sql", e, 2);
            }
        }
        this.f33530x0XOIxOo.removeAll(this.f33527oO);
        this.f33527oO.clear();
    }

    public void Xx000oIo(String str) {
        this.f33528oOoXoXO = str;
        if (Oxx0xo() == null) {
            oxoX(new oI0IIXIo(str));
        } else {
            ((oI0IIXIo) Oxx0xo()).xoIox(str);
        }
    }

    public Connection XxX0x0xxx() throws SQLException {
        if (!DriverManager.getDrivers().hasMoreElements()) {
            IoOoX("sun.jdbc.odbc.JdbcOdbcDriver");
        }
        if (this.f33526OOXIXo == null) {
            this.f33526OOXIXo = DriverManager.getConnection(this.f33525II0XooXoX, this.f33532xxIXOIIO, this.f33531xoIox);
        }
        return this.f33526OOXIXo;
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public void close() {
        XIxXXX0x0();
        try {
            Connection connection = this.f33526OOXIXo;
            if (connection != null && !connection.isClosed()) {
                this.f33526OOXIXo.close();
            }
        } catch (SQLException e) {
            this.f33162oxoX.OxxIIOOXO("Error closing connection", e, 0);
        }
        this.f33158Oxx0IOOO = true;
    }

    @Override // org.apache.log4j.II0xO0
    public void finalize() {
        close();
    }

    public void oOXoIIIo(String str) {
        this.f33531xoIox = str;
    }

    public void oo(int i) {
        this.f33529ooOOo0oXI = i;
        this.f33530x0XOIxOo.ensureCapacity(i);
        this.f33527oO.ensureCapacity(this.f33529ooOOo0oXI);
    }

    public String oo0xXOI0I() {
        return this.f33532xxIXOIIO;
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public boolean ooOOo0oXI() {
        return true;
    }

    public String ooXIXxIX() {
        return this.f33528oOoXoXO;
    }

    public String xI() {
        return this.f33525II0XooXoX;
    }

    public String xXxxox0I(LoggingEvent loggingEvent) {
        return Oxx0xo().oIX0oI(loggingEvent);
    }

    public int xxX() {
        return this.f33529ooOOo0oXI;
    }

    public void X0IIOO(Connection connection) {
    }
}
