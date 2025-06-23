package OoOoXO0;

import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes6.dex */
public class o00 implements OxxIIOOXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f2628I0Io;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static /* synthetic */ Class f2629X0o0xo;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final oxO.oxoX f2630oxoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Timer f2631II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Ox0XO.II0xO0 f2632oIX0oI;

    /* loaded from: classes6.dex */
    public class oIX0oI extends TimerTask {

        /* renamed from: Oo, reason: collision with root package name */
        public static final String f2633Oo = "PingTask.run";

        public oIX0oI() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            o00.f2630oxoX.OOXIXo(o00.f2628I0Io, f2633Oo, "660", new Object[]{new Long(System.currentTimeMillis())});
            o00.this.f2632oIX0oI.oOoXoXO();
        }

        public /* synthetic */ oIX0oI(o00 o00Var, oIX0oI oix0oi) {
            this();
        }
    }

    static {
        Class<o00> cls = f2629X0o0xo;
        if (cls == null) {
            cls = o00.class;
            f2629X0o0xo = cls;
        }
        String name = cls.getName();
        f2628I0Io = name;
        f2630oxoX = oxO.X0o0xo.oIX0oI(oxO.X0o0xo.f33551oIX0oI, name);
    }

    @Override // OoOoXO0.OxxIIOOXO
    public void init(Ox0XO.II0xO0 iI0xO0) {
        if (iI0xO0 != null) {
            this.f2632oIX0oI = iI0xO0;
            return;
        }
        throw new IllegalArgumentException("ClientComms cannot be null.");
    }

    @Override // OoOoXO0.OxxIIOOXO
    public void schedule(long j) {
        this.f2631II0xO0.schedule(new oIX0oI(this, null), j);
    }

    @Override // OoOoXO0.OxxIIOOXO
    public void start() {
        String clientId = this.f2632oIX0oI.o00().getClientId();
        f2630oxoX.OOXIXo(f2628I0Io, "start", "659", new Object[]{clientId});
        StringBuffer stringBuffer = new StringBuffer("MQTT Ping: ");
        stringBuffer.append(clientId);
        Timer timer = new Timer(stringBuffer.toString());
        this.f2631II0xO0 = timer;
        timer.schedule(new oIX0oI(this, null), this.f2632oIX0oI.XI0IXoo());
    }

    @Override // OoOoXO0.OxxIIOOXO
    public void stop() {
        f2630oxoX.OOXIXo(f2628I0Io, "stop", "661", null);
        Timer timer = this.f2631II0xO0;
        if (timer != null) {
            timer.cancel();
        }
    }
}
