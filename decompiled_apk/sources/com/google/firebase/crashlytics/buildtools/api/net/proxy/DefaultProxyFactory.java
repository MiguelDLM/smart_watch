package com.google.firebase.crashlytics.buildtools.api.net.proxy;

import com.google.firebase.crashlytics.buildtools.Buildtools;
import java.io.IOException;
import o0oIxXOx.XIxXXX0x0;

/* loaded from: classes10.dex */
public class DefaultProxyFactory implements ProxyFactory {
    private static final ProxySettings DEFAULT_PROXY_SETTINGS = new ProxySettings(null, null, null, null);
    private static final String OVERRIDE_DEBUG_MSG_FMT = "Found proxy override specified in %s. [host=%s; port=%d; username=%s; pw=HIDDEN]";

    /* renamed from: com.google.firebase.crashlytics.buildtools.api.net.proxy.DefaultProxyFactory$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$crashlytics$buildtools$api$net$proxy$ProtocolScheme;

        static {
            int[] iArr = new int[ProtocolScheme.values().length];
            $SwitchMap$com$google$firebase$crashlytics$buildtools$api$net$proxy$ProtocolScheme = iArr;
            try {
                iArr[ProtocolScheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$api$net$proxy$ProtocolScheme[ProtocolScheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private ProxySettings createFromEnvironment(ProtocolScheme protocolScheme) throws NumberFormatException {
        String str;
        int i = AnonymousClass1.$SwitchMap$com$google$firebase$crashlytics$buildtools$api$net$proxy$ProtocolScheme[protocolScheme.ordinal()];
        if (i != 1) {
            if (i != 2) {
                str = null;
            } else {
                str = System.getenv().get(Constants.HTTPS_PROXY_ENV);
            }
        } else {
            str = System.getenv().get(Constants.HTTP_PROXY_ENV);
        }
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        if (split.length == 3) {
            String substring = split[1].substring(2);
            Integer valueOf = Integer.valueOf(Integer.parseInt(split[2]));
            Buildtools.logD(String.format(OVERRIDE_DEBUG_MSG_FMT, "environment variable", substring, valueOf, null));
            return new ProxySettings(substring, valueOf, null, null);
        }
        throw new IllegalArgumentException("Could not parse proxy string from environment variable value: " + str + "; expected: http[s]://host:port");
    }

    private ProxySettings createFromProperties(ProtocolScheme protocolScheme) throws NumberFormatException {
        String property;
        String property2;
        String property3;
        String property4;
        int i = AnonymousClass1.$SwitchMap$com$google$firebase$crashlytics$buildtools$api$net$proxy$ProtocolScheme[protocolScheme.ordinal()];
        Integer num = null;
        if (i != 1) {
            if (i != 2) {
                property = null;
                property2 = null;
                property3 = null;
                property4 = null;
            } else {
                property = System.getProperty(Constants.HTTPS_PROXY_HOST_PROP);
                property2 = System.getProperty(Constants.HTTPS_PROXY_PORT_PROP);
                property3 = System.getProperty(Constants.HTTPS_PROXY_USER_PROP);
                property4 = System.getProperty(Constants.HTTPS_PROXY_PASSWORD_PROP);
            }
        } else {
            property = System.getProperty(Constants.HTTP_PROXY_HOST_PROP);
            property2 = System.getProperty(Constants.HTTP_PROXY_PORT_PROP);
            property3 = System.getProperty(Constants.HTTP_PROXY_USER_PROP);
            property4 = System.getProperty(Constants.HTTP_PROXY_PASSWORD_PROP);
        }
        if (property == null && property2 == null && property3 == null && property4 == null) {
            return null;
        }
        if (property2 != null) {
            num = Integer.valueOf(Integer.parseInt(property2));
        }
        Buildtools.logD(String.format(OVERRIDE_DEBUG_MSG_FMT, XIxXXX0x0.f31177x0xO0oo, property, num, property3));
        return new ProxySettings(property, num, property3, property4);
    }

    @Override // com.google.firebase.crashlytics.buildtools.api.net.proxy.ProxyFactory
    public ProxySettings create(ProtocolScheme protocolScheme) throws IOException {
        ProxySettings createFromProperties = createFromProperties(protocolScheme);
        if (createFromProperties == null) {
            createFromProperties = createFromEnvironment(protocolScheme);
        }
        if (createFromProperties == null) {
            return DEFAULT_PROXY_SETTINGS;
        }
        return createFromProperties;
    }
}
