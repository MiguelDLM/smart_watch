package org.apache.log4j.spi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Hashtable;
import org.apache.log4j.Level;
import org.apache.log4j.Oxx0xo;
import org.apache.log4j.OxxIIOOXO;

/* loaded from: classes6.dex */
public class LoggingEvent implements Serializable {
    static final String TO_LEVEL = "toLevel";
    static /* synthetic */ Class class$org$apache$log4j$Level = null;
    static final long serialVersionUID = -868428216207166145L;
    public final String categoryName;
    public final transient String fqnOfCategoryClass;
    public transient OxxIIOOXO level;
    private LocationInfo locationInfo;
    private transient org.apache.log4j.X0o0xo logger;
    private Hashtable mdcCopy;
    private transient Object message;
    private String ndc;
    private String renderedMessage;
    private String threadName;
    private ThrowableInformation throwableInfo;
    public final long timeStamp;
    private static long startTime = System.currentTimeMillis();
    static final Integer[] PARAM_ARRAY = new Integer[1];
    static final Class[] TO_LEVEL_PARAMS = {Integer.TYPE};
    static final Hashtable methodCache = new Hashtable(3);
    private boolean ndcLookupRequired = true;
    private boolean mdcCopyLookupRequired = true;

    public LoggingEvent(String str, org.apache.log4j.X0o0xo x0o0xo, OxxIIOOXO oxxIIOOXO, Object obj, Throwable th) {
        this.fqnOfCategoryClass = str;
        this.logger = x0o0xo;
        this.categoryName = x0o0xo.xxX();
        this.level = oxxIIOOXO;
        this.message = obj;
        if (th != null) {
            this.throwableInfo = new ThrowableInformation(th);
        }
        this.timeStamp = System.currentTimeMillis();
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static long getStartTime() {
        return startTime;
    }

    private void readLevel(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int readInt = objectInputStream.readInt();
        try {
            String str = (String) objectInputStream.readObject();
            if (str == null) {
                this.level = Level.toLevel(readInt);
                return;
            }
            Hashtable hashtable = methodCache;
            Method method = (Method) hashtable.get(str);
            if (method == null) {
                method = org.apache.log4j.helpers.II0XooXoX.XO(str).getDeclaredMethod(TO_LEVEL, TO_LEVEL_PARAMS);
                hashtable.put(str, method);
            }
            Integer[] numArr = PARAM_ARRAY;
            numArr[0] = new Integer(readInt);
            this.level = (Level) method.invoke(null, numArr);
        } catch (Exception e) {
            org.apache.log4j.helpers.xxIXOIIO.II0XooXoX("Level deserialization failed, reverting to default.", e);
            this.level = Level.toLevel(readInt);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        readLevel(objectInputStream);
        if (this.locationInfo == null) {
            this.locationInfo = new LocationInfo(null, null);
        }
    }

    private void writeLevel(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.level.toInt());
        Class<?> cls = this.level.getClass();
        Class<?> cls2 = class$org$apache$log4j$Level;
        if (cls2 == null) {
            cls2 = class$("org.apache.log4j.Level");
            class$org$apache$log4j$Level = cls2;
        }
        if (cls == cls2) {
            objectOutputStream.writeObject(null);
        } else {
            objectOutputStream.writeObject(cls.getName());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        getThreadName();
        getRenderedMessage();
        getNDC();
        getMDCCopy();
        getThrowableStrRep();
        objectOutputStream.defaultWriteObject();
        writeLevel(objectOutputStream);
    }

    public Level getLevel() {
        return (Level) this.level;
    }

    public LocationInfo getLocationInformation() {
        if (this.locationInfo == null) {
            this.locationInfo = new LocationInfo(new Throwable(), this.fqnOfCategoryClass);
        }
        return this.locationInfo;
    }

    public String getLoggerName() {
        return this.categoryName;
    }

    public Object getMDC(String str) {
        Object obj;
        Hashtable hashtable = this.mdcCopy;
        if (hashtable != null && (obj = hashtable.get(str)) != null) {
            return obj;
        }
        return org.apache.log4j.IXxxXO.oIX0oI(str);
    }

    public void getMDCCopy() {
        if (this.mdcCopyLookupRequired) {
            this.mdcCopyLookupRequired = false;
            Hashtable I0Io2 = org.apache.log4j.IXxxXO.I0Io();
            if (I0Io2 != null) {
                this.mdcCopy = (Hashtable) I0Io2.clone();
            }
        }
    }

    public Object getMessage() {
        Object obj = this.message;
        if (obj != null) {
            return obj;
        }
        return getRenderedMessage();
    }

    public String getNDC() {
        if (this.ndcLookupRequired) {
            this.ndcLookupRequired = false;
            this.ndc = Oxx0xo.I0Io();
        }
        return this.ndc;
    }

    public String getRenderedMessage() {
        Object obj;
        if (this.renderedMessage == null && (obj = this.message) != null) {
            if (obj instanceof String) {
                this.renderedMessage = (String) obj;
            } else {
                xxIXOIIO XIxXXX0x02 = this.logger.XIxXXX0x0();
                if (XIxXXX0x02 instanceof oOoXoXO) {
                    this.renderedMessage = ((oOoXoXO) XIxXXX0x02).XO().oxoX(this.message);
                } else {
                    this.renderedMessage = this.message.toString();
                }
            }
        }
        return this.renderedMessage;
    }

    public String getThreadName() {
        if (this.threadName == null) {
            this.threadName = Thread.currentThread().getName();
        }
        return this.threadName;
    }

    public ThrowableInformation getThrowableInformation() {
        return this.throwableInfo;
    }

    public String[] getThrowableStrRep() {
        ThrowableInformation throwableInformation = this.throwableInfo;
        if (throwableInformation == null) {
            return null;
        }
        return throwableInformation.getThrowableStrRep();
    }

    public LoggingEvent(String str, org.apache.log4j.X0o0xo x0o0xo, long j, OxxIIOOXO oxxIIOOXO, Object obj, Throwable th) {
        this.fqnOfCategoryClass = str;
        this.logger = x0o0xo;
        this.categoryName = x0o0xo.xxX();
        this.level = oxxIIOOXO;
        this.message = obj;
        if (th != null) {
            this.throwableInfo = new ThrowableInformation(th);
        }
        this.timeStamp = j;
    }
}
