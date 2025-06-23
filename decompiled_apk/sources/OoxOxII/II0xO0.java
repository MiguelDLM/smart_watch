package OoxOxII;

import com.sun.jdmk.comm.HtmlAdaptorServer;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import org.apache.log4j.x0xO0oo;

/* loaded from: classes6.dex */
public class II0xO0 {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static /* synthetic */ Class f2708II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static x0xO0oo f2709oIX0oI;

    static {
        Class cls = f2708II0xO0;
        if (cls == null) {
            cls = oIX0oI("org.apache.log4j.jmx.Agent");
            f2708II0xO0 = cls;
        }
        f2709oIX0oI = x0xO0oo.xo0x(cls);
    }

    public static /* synthetic */ Class oIX0oI(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public void II0xO0() {
        MBeanServer createMBeanServer = MBeanServerFactory.createMBeanServer();
        HtmlAdaptorServer htmlAdaptorServer = new HtmlAdaptorServer();
        try {
            f2709oIX0oI.oo0xXOI0I("Registering HtmlAdaptorServer instance.");
            createMBeanServer.registerMBean(htmlAdaptorServer, new ObjectName("Adaptor:name=html,port=8082"));
            f2709oIX0oI.oo0xXOI0I("Registering HierarchyDynamicMBean instance.");
            createMBeanServer.registerMBean(new oxoX(), new ObjectName("log4j:hiearchy=default"));
            htmlAdaptorServer.start();
        } catch (Exception e) {
            f2709oIX0oI.x0XOIxOo("Problem while regitering MBeans instances.", e);
        }
    }
}
