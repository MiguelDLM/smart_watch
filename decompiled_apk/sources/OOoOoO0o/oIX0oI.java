package OOoOoO0o;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import oxO.oxoX;

/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final String f1774IIXOooo = "javax.net.ssl.trustStore";

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final String f1776O0xOxO = "ssl.TrustManagerFactory.algorithm";

    /* renamed from: OxI, reason: collision with root package name */
    public static final String f1779OxI = "ssl.KeyManagerFactory.algorithm";

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final String f1781Oxx0xo = "javax.net.ssl.keyStore";

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final String f1782OxxIIOOXO = "javax.net.ssl.keyStorePassword";

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final String f1783X0IIOO = "TLS";

    /* renamed from: o00, reason: collision with root package name */
    public static final String f1788o00 = "javax.net.ssl.trustStorePassword";

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final String f1789oI0IIXIo = "javax.net.ssl.keyStoreType";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f1793oxoX = "org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory";

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final String f1797xoXoI = "javax.net.ssl.trustStoreType";

    /* renamed from: xxX, reason: collision with root package name */
    public static final String f1799xxX = "{xor}";

    /* renamed from: I0Io, reason: collision with root package name */
    public oxoX f1800I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Properties f1801II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Hashtable f1802oIX0oI;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f1784X0o0xo = "com.ibm.ssl.protocol";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f1787XO = "com.ibm.ssl.contextProvider";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f1780Oxx0IOOO = "com.ibm.ssl.keyStore";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f1773II0XooXoX = "com.ibm.ssl.keyStorePassword";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final String f1798xxIXOIIO = "com.ibm.ssl.keyStoreType";

    /* renamed from: xoIox, reason: collision with root package name */
    public static final String f1796xoIox = "com.ibm.ssl.keyStoreProvider";

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final String f1777OOXIXo = "com.ibm.ssl.keyManager";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final String f1791oOoXoXO = "com.ibm.ssl.trustStore";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final String f1792ooOOo0oXI = "com.ibm.ssl.trustStorePassword";

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final String f1794x0XOIxOo = "com.ibm.ssl.trustStoreType";

    /* renamed from: oO, reason: collision with root package name */
    public static final String f1790oO = "com.ibm.ssl.trustStoreProvider";

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final String f1795x0xO0oo = "com.ibm.ssl.trustManager";

    /* renamed from: Oo, reason: collision with root package name */
    public static final String f1778Oo = "com.ibm.ssl.enabledCipherSuites";

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final String f1775IXxxXO = "com.ibm.ssl.clientAuthentication";

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final String[] f1785XI0IXoo = {f1784X0o0xo, f1787XO, f1780Oxx0IOOO, f1773II0XooXoX, f1798xxIXOIIO, f1796xoIox, f1777OOXIXo, f1791oOoXoXO, f1792ooOOo0oXI, f1794x0XOIxOo, f1790oO, f1795x0xO0oo, f1778Oo, f1775IXxxXO};

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final byte[] f1786XIxXXX0x0 = {-99, -89, -39, Byte.MIN_VALUE, 5, -72, -119, -100};

    public oIX0oI() {
        this.f1800I0Io = null;
        this.f1802oIX0oI = new Hashtable();
    }

    public static String X0IIOO(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        byte[] xxX2 = xxX(cArr);
        for (int i = 0; i < xxX2.length; i++) {
            byte b = xxX2[i];
            byte[] bArr = f1786XIxXXX0x0;
            xxX2[i] = (byte) ((b ^ bArr[i % bArr.length]) & 255);
        }
        StringBuffer stringBuffer = new StringBuffer(f1799xxX);
        stringBuffer.append(new String(II0xO0.II0xO0(xxX2)));
        return stringBuffer.toString();
    }

    public static String XI0IXoo(String[] strArr) {
        if (strArr != null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < strArr.length; i++) {
                stringBuffer.append(strArr[i]);
                if (i < strArr.length - 1) {
                    stringBuffer.append(',');
                }
            }
            return stringBuffer.toString();
        }
        return null;
    }

    public static char[] XxX0x0xxx(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = new char[bArr.length / 2];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            int i3 = i + 1;
            int i4 = bArr[i] & 255;
            i += 2;
            cArr[i2] = (char) (i4 + ((bArr[i3] & 255) << 8));
            i2++;
        }
        return cArr;
    }

    public static boolean o00() throws LinkageError, ExceptionInInitializerError {
        try {
            Class.forName("javax.net.ssl.SSLServerSocketFactory");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static char[] oxoX(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] oIX0oI2 = II0xO0.oIX0oI(str.substring(5));
            for (int i = 0; i < oIX0oI2.length; i++) {
                byte b = oIX0oI2[i];
                byte[] bArr = f1786XIxXXX0x0;
                oIX0oI2[i] = (byte) ((b ^ bArr[i % bArr.length]) & 255);
            }
            return XxX0x0xxx(oIX0oI2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String[] xXxxox0I(String str) {
        if (str == null) {
            return null;
        }
        Vector vector = new Vector();
        int indexOf = str.indexOf(44);
        int i = 0;
        while (indexOf > -1) {
            vector.add(str.substring(i, indexOf));
            i = indexOf + 1;
            indexOf = str.indexOf(44, i);
        }
        vector.add(str.substring(i));
        String[] strArr = new String[vector.size()];
        vector.toArray(strArr);
        return strArr;
    }

    public static byte[] xxX(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        byte[] bArr = new byte[cArr.length * 2];
        int i = 0;
        int i2 = 0;
        while (i < cArr.length) {
            int i3 = i2 + 1;
            char c = cArr[i];
            bArr[i2] = (byte) (c & 255);
            i2 += 2;
            i++;
            bArr[i3] = (byte) ((c >> '\b') & 255);
        }
        return bArr;
    }

    public SSLSocketFactory I0Io(String str) throws MqttSecurityException {
        String str2;
        String str3;
        SSLContext x0xO0oo2 = x0xO0oo(str);
        oxoX oxox = this.f1800I0Io;
        if (oxox != null) {
            if (str != null) {
                str2 = str;
            } else {
                str2 = "null (broker defaults)";
            }
            if (Oxx0IOOO(str) != null) {
                str3 = x0XOIxOo(str, f1778Oo, null);
            } else {
                str3 = "null (using platform-enabled cipher suites)";
            }
            oxox.OOXIXo(f1793oxoX, "createSocketFactory", "12020", new Object[]{str2, str3});
        }
        return x0xO0oo2.getSocketFactory();
    }

    public String II0XooXoX(String str) {
        return x0XOIxOo(str, f1787XO, null);
    }

    public final void II0xO0(Properties properties) {
        String property = properties.getProperty(f1773II0XooXoX);
        if (property != null && !property.startsWith(f1799xxX)) {
            properties.put(f1773II0XooXoX, X0IIOO(property.toCharArray()));
        }
        String property2 = properties.getProperty(f1792ooOOo0oXI);
        if (property2 != null && !property2.startsWith(f1799xxX)) {
            properties.put(f1792ooOOo0oXI, X0IIOO(property2.toCharArray()));
        }
    }

    public String IIXOooo(String str) {
        return x0XOIxOo(str, f1794x0XOIxOo, null);
    }

    public String IXxxXO(String str) {
        return x0XOIxOo(str, f1795x0xO0oo, f1776O0xOxO);
    }

    public void O0xOxO(Properties properties, String str) throws IllegalArgumentException {
        oIX0oI(properties);
        Properties properties2 = this.f1801II0xO0;
        if (str != null) {
            properties2 = (Properties) this.f1802oIX0oI.get(str);
        }
        if (properties2 == null) {
            properties2 = new Properties();
        }
        II0xO0(properties);
        properties2.putAll(properties);
        if (str != null) {
            this.f1802oIX0oI.put(str, properties2);
        } else {
            this.f1801II0xO0 = properties2;
        }
    }

    public char[] OOXIXo(String str) {
        String x0XOIxOo2 = x0XOIxOo(str, f1773II0XooXoX, f1782OxxIIOOXO);
        if (x0XOIxOo2 != null) {
            if (x0XOIxOo2.startsWith(f1799xxX)) {
                return oxoX(x0XOIxOo2);
            }
            return x0XOIxOo2.toCharArray();
        }
        return null;
    }

    public String Oo(String str) {
        return x0XOIxOo(str, f1784X0o0xo, null);
    }

    public final boolean OxI(String str) {
        String[] strArr;
        int i = 0;
        while (true) {
            strArr = f1785XI0IXoo;
            if (i < strArr.length && !strArr[i].equals(str)) {
                i++;
            }
        }
        if (i >= strArr.length) {
            return false;
        }
        return true;
    }

    public String[] Oxx0IOOO(String str) {
        return xXxxox0I(x0XOIxOo(str, f1778Oo, null));
    }

    public String Oxx0xo(String str) {
        return x0XOIxOo(str, f1791oOoXoXO, f1774IIXOooo);
    }

    public String OxxIIOOXO(String str) {
        return x0XOIxOo(str, f1790oO, null);
    }

    public boolean X0o0xo(String str) {
        String x0XOIxOo2 = x0XOIxOo(str, f1775IXxxXO, null);
        if (x0XOIxOo2 != null) {
            return Boolean.valueOf(x0XOIxOo2).booleanValue();
        }
        return false;
    }

    public boolean XIxXXX0x0(String str) {
        if (str != null) {
            if (this.f1802oIX0oI.remove(str) != null) {
                return true;
            }
        } else if (this.f1801II0xO0 != null) {
            this.f1801II0xO0 = null;
            return true;
        }
        return false;
    }

    public Properties XO(String str) {
        Object obj;
        if (str == null) {
            obj = this.f1801II0xO0;
        } else {
            obj = this.f1802oIX0oI.get(str);
        }
        return (Properties) obj;
    }

    public char[] oI0IIXIo(String str) {
        String x0XOIxOo2 = x0XOIxOo(str, f1792ooOOo0oXI, f1788o00);
        if (x0XOIxOo2 != null) {
            if (x0XOIxOo2.startsWith(f1799xxX)) {
                return oxoX(x0XOIxOo2);
            }
            return x0XOIxOo2.toCharArray();
        }
        return null;
    }

    public final void oIX0oI(Properties properties) throws IllegalArgumentException {
        for (String str : properties.keySet()) {
            if (!OxI(str)) {
                StringBuffer stringBuffer = new StringBuffer(String.valueOf(str));
                stringBuffer.append(" is not a valid IBM SSL property key.");
                throw new IllegalArgumentException(stringBuffer.toString());
            }
        }
    }

    public final String oO(String str, String str2) {
        Properties properties;
        String str3 = null;
        if (str != null) {
            properties = (Properties) this.f1802oIX0oI.get(str);
        } else {
            properties = null;
        }
        if (properties != null && (str3 = properties.getProperty(str2)) != null) {
            return str3;
        }
        Properties properties2 = this.f1801II0xO0;
        if (properties2 == null || (str3 = properties2.getProperty(str2)) != null) {
        }
        return str3;
    }

    public String oOoXoXO(String str) {
        return x0XOIxOo(str, f1796xoIox, null);
    }

    public String ooOOo0oXI(String str) {
        return x0XOIxOo(str, f1798xxIXOIIO, f1789oI0IIXIo);
    }

    public final String x0XOIxOo(String str, String str2, String str3) {
        String oO2 = oO(str, str2);
        if (oO2 != null) {
            return oO2;
        }
        if (str3 != null) {
            return System.getProperty(str3);
        }
        return oO2;
    }

    public final SSLContext x0xO0oo(String str) throws MqttSecurityException {
        SSLContext sSLContext;
        String str2;
        String str3;
        KeyManager[] keyManagerArr;
        TrustManager[] trustManagerArr;
        TrustManagerFactory trustManagerFactory;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        KeyManagerFactory keyManagerFactory;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20 = str;
        String Oo2 = Oo(str);
        if (Oo2 == null) {
            Oo2 = "TLS";
        }
        oxoX oxox = this.f1800I0Io;
        if (oxox != null) {
            if (str20 == null) {
                str19 = "null (broker defaults)";
            } else {
                str19 = str20;
            }
            oxox.OOXIXo(f1793oxoX, "getSSLContext", "12000", new Object[]{str19, Oo2});
        }
        String II0XooXoX2 = II0XooXoX(str);
        try {
            if (II0XooXoX2 == null) {
                sSLContext = SSLContext.getInstance(Oo2);
            } else {
                sSLContext = SSLContext.getInstance(Oo2, II0XooXoX2);
            }
            oxoX oxox2 = this.f1800I0Io;
            if (oxox2 != null) {
                if (str20 == null) {
                    str18 = "null (broker defaults)";
                } else {
                    str18 = str20;
                }
                oxox2.OOXIXo(f1793oxoX, "getSSLContext", "12001", new Object[]{str18, sSLContext.getProvider().getName()});
            }
            String x0XOIxOo2 = x0XOIxOo(str20, f1780Oxx0IOOO, null);
            if (x0XOIxOo2 == null) {
                x0XOIxOo2 = x0XOIxOo(str20, f1780Oxx0IOOO, f1781Oxx0xo);
            }
            oxoX oxox3 = this.f1800I0Io;
            if (oxox3 != null) {
                if (str20 == null) {
                    str16 = "null (broker defaults)";
                } else {
                    str16 = str20;
                }
                if (x0XOIxOo2 == null) {
                    str17 = "null";
                } else {
                    str17 = x0XOIxOo2;
                }
                oxox3.OOXIXo(f1793oxoX, "getSSLContext", "12004", new Object[]{str16, str17});
            }
            char[] OOXIXo2 = OOXIXo(str);
            oxoX oxox4 = this.f1800I0Io;
            if (oxox4 != null) {
                if (str20 == null) {
                    str14 = "null (broker defaults)";
                } else {
                    str14 = str20;
                }
                if (OOXIXo2 == null) {
                    str15 = "null";
                } else {
                    str15 = X0IIOO(OOXIXo2);
                }
                oxox4.OOXIXo(f1793oxoX, "getSSLContext", "12005", new Object[]{str14, str15});
            }
            String ooOOo0oXI2 = ooOOo0oXI(str);
            if (ooOOo0oXI2 == null) {
                ooOOo0oXI2 = KeyStore.getDefaultType();
            }
            oxoX oxox5 = this.f1800I0Io;
            if (oxox5 == null) {
                str2 = "null (broker defaults)";
            } else {
                if (str20 == null) {
                    str12 = "null (broker defaults)";
                } else {
                    str12 = str20;
                }
                if (ooOOo0oXI2 == null) {
                    str2 = "null (broker defaults)";
                    str13 = "null";
                } else {
                    str13 = ooOOo0oXI2;
                    str2 = "null (broker defaults)";
                }
                oxox5.OOXIXo(f1793oxoX, "getSSLContext", "12006", new Object[]{str12, str13});
            }
            String defaultAlgorithm = KeyManagerFactory.getDefaultAlgorithm();
            String oOoXoXO2 = oOoXoXO(str);
            String xxIXOIIO2 = xxIXOIIO(str);
            if (xxIXOIIO2 != null) {
                defaultAlgorithm = xxIXOIIO2;
            }
            if (x0XOIxOo2 == null || ooOOo0oXI2 == null || defaultAlgorithm == null) {
                str3 = "null";
                keyManagerArr = null;
            } else {
                try {
                    KeyStore keyStore = KeyStore.getInstance(ooOOo0oXI2);
                    keyStore.load(new FileInputStream(x0XOIxOo2), OOXIXo2);
                    if (oOoXoXO2 != null) {
                        keyManagerFactory = KeyManagerFactory.getInstance(defaultAlgorithm, oOoXoXO2);
                    } else {
                        keyManagerFactory = KeyManagerFactory.getInstance(defaultAlgorithm);
                    }
                    oxoX oxox6 = this.f1800I0Io;
                    if (oxox6 == null) {
                        str3 = "null";
                    } else {
                        if (str20 == null) {
                            str3 = "null";
                            str10 = str2;
                        } else {
                            str10 = str20;
                            str3 = "null";
                        }
                        oxox6.OOXIXo(f1793oxoX, "getSSLContext", "12010", new Object[]{str10, defaultAlgorithm});
                        oxoX oxox7 = this.f1800I0Io;
                        if (str20 != null) {
                            str11 = str20;
                        } else {
                            str11 = str2;
                        }
                        oxox7.OOXIXo(f1793oxoX, "getSSLContext", "12009", new Object[]{str11, keyManagerFactory.getProvider().getName()});
                    }
                    keyManagerFactory.init(keyStore, OOXIXo2);
                    keyManagerArr = keyManagerFactory.getKeyManagers();
                } catch (FileNotFoundException e) {
                    throw new MqttSecurityException(e);
                } catch (IOException e2) {
                    throw new MqttSecurityException(e2);
                } catch (KeyStoreException e3) {
                    throw new MqttSecurityException(e3);
                } catch (UnrecoverableKeyException e4) {
                    throw new MqttSecurityException(e4);
                } catch (CertificateException e5) {
                    throw new MqttSecurityException(e5);
                }
            }
            String Oxx0xo2 = Oxx0xo(str);
            oxoX oxox8 = this.f1800I0Io;
            if (oxox8 != null) {
                if (str20 != null) {
                    str8 = str20;
                } else {
                    str8 = str2;
                }
                if (Oxx0xo2 != null) {
                    str9 = Oxx0xo2;
                } else {
                    str9 = str3;
                }
                oxox8.OOXIXo(f1793oxoX, "getSSLContext", "12011", new Object[]{str8, str9});
            }
            char[] oI0IIXIo2 = oI0IIXIo(str);
            oxoX oxox9 = this.f1800I0Io;
            if (oxox9 != null) {
                if (str20 != null) {
                    str6 = str20;
                } else {
                    str6 = str2;
                }
                if (oI0IIXIo2 != null) {
                    str7 = X0IIOO(oI0IIXIo2);
                } else {
                    str7 = str3;
                }
                oxox9.OOXIXo(f1793oxoX, "getSSLContext", "12012", new Object[]{str6, str7});
            }
            String IIXOooo2 = IIXOooo(str);
            if (IIXOooo2 == null) {
                IIXOooo2 = KeyStore.getDefaultType();
            }
            oxoX oxox10 = this.f1800I0Io;
            if (oxox10 != null) {
                if (str20 != null) {
                    str5 = str20;
                } else {
                    str5 = str2;
                }
                if (IIXOooo2 != null) {
                    str3 = IIXOooo2;
                }
                oxox10.OOXIXo(f1793oxoX, "getSSLContext", "12013", new Object[]{str5, str3});
            }
            String defaultAlgorithm2 = TrustManagerFactory.getDefaultAlgorithm();
            String OxxIIOOXO2 = OxxIIOOXO(str);
            String IXxxXO2 = IXxxXO(str);
            if (IXxxXO2 != null) {
                defaultAlgorithm2 = IXxxXO2;
            }
            if (Oxx0xo2 != null && IIXOooo2 != null && defaultAlgorithm2 != null) {
                try {
                    KeyStore keyStore2 = KeyStore.getInstance(IIXOooo2);
                    keyStore2.load(new FileInputStream(Oxx0xo2), oI0IIXIo2);
                    if (OxxIIOOXO2 != null) {
                        trustManagerFactory = TrustManagerFactory.getInstance(defaultAlgorithm2, OxxIIOOXO2);
                    } else {
                        trustManagerFactory = TrustManagerFactory.getInstance(defaultAlgorithm2);
                    }
                    oxoX oxox11 = this.f1800I0Io;
                    if (oxox11 != null) {
                        if (str20 != null) {
                            str4 = str20;
                        } else {
                            str4 = str2;
                        }
                        oxox11.OOXIXo(f1793oxoX, "getSSLContext", "12017", new Object[]{str4, defaultAlgorithm2});
                        oxoX oxox12 = this.f1800I0Io;
                        if (str20 == null) {
                            str20 = str2;
                        }
                        oxox12.OOXIXo(f1793oxoX, "getSSLContext", "12016", new Object[]{str20, trustManagerFactory.getProvider().getName()});
                    }
                    trustManagerFactory.init(keyStore2);
                    trustManagerArr = trustManagerFactory.getTrustManagers();
                } catch (FileNotFoundException e6) {
                    throw new MqttSecurityException(e6);
                } catch (IOException e7) {
                    throw new MqttSecurityException(e7);
                } catch (KeyStoreException e8) {
                    throw new MqttSecurityException(e8);
                } catch (CertificateException e9) {
                    throw new MqttSecurityException(e9);
                }
            } else {
                trustManagerArr = null;
            }
            sSLContext.init(keyManagerArr, trustManagerArr, null);
            return sSLContext;
        } catch (KeyManagementException e10) {
            throw new MqttSecurityException(e10);
        } catch (NoSuchAlgorithmException e11) {
            throw new MqttSecurityException(e11);
        } catch (NoSuchProviderException e12) {
            throw new MqttSecurityException(e12);
        }
    }

    public String xoIox(String str) {
        String oO2 = oO(str, f1780Oxx0IOOO);
        if (oO2 != null) {
            return oO2;
        }
        return System.getProperty(f1781Oxx0xo);
    }

    public void xoXoI(Properties properties, String str) throws IllegalArgumentException {
        oIX0oI(properties);
        Properties properties2 = new Properties();
        properties2.putAll(properties);
        II0xO0(properties2);
        if (str != null) {
            this.f1802oIX0oI.put(str, properties2);
        } else {
            this.f1801II0xO0 = properties2;
        }
    }

    public String xxIXOIIO(String str) {
        return x0XOIxOo(str, f1777OOXIXo, f1779OxI);
    }

    public oIX0oI(oxoX oxox) {
        this();
        this.f1800I0Io = oxox;
    }
}
