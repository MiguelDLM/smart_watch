package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.utils;

import OoOoXO0.xoXoI;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.routing.RouteInfo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.TextUtils;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Stack;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes10.dex */
public class URIUtils {
    private URIUtils() {
    }

    @Deprecated
    public static URI createURI(String str, String str2, int i, String str3, String str4, String str5) throws URISyntaxException {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            if (str != null) {
                sb.append(str);
                sb.append("://");
            }
            sb.append(str2);
            if (i > 0) {
                sb.append(':');
                sb.append(i);
            }
        }
        if (str3 == null || !str3.startsWith("/")) {
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        }
        if (str3 != null) {
            sb.append(str3);
        }
        if (str4 != null) {
            sb.append('?');
            sb.append(str4);
        }
        if (str5 != null) {
            sb.append('#');
            sb.append(str5);
        }
        return new URI(sb.toString());
    }

    public static HttpHost extractHost(URI uri) {
        int indexOf;
        if (uri == null || !uri.isAbsolute()) {
            return null;
        }
        int port = uri.getPort();
        String host = uri.getHost();
        if (host == null && (host = uri.getAuthority()) != null) {
            int indexOf2 = host.indexOf(64);
            if (indexOf2 >= 0) {
                int i = indexOf2 + 1;
                if (host.length() > i) {
                    host = host.substring(i);
                } else {
                    host = null;
                }
            }
            if (host != null && (indexOf = host.indexOf(58)) >= 0) {
                int i2 = indexOf + 1;
                int i3 = 0;
                for (int i4 = i2; i4 < host.length() && Character.isDigit(host.charAt(i4)); i4++) {
                    i3++;
                }
                if (i3 > 0) {
                    try {
                        port = Integer.parseInt(host.substring(i2, i3 + i2));
                    } catch (NumberFormatException unused) {
                    }
                }
                host = host.substring(0, indexOf);
            }
        }
        String scheme = uri.getScheme();
        if (TextUtils.isBlank(host)) {
            return null;
        }
        try {
            return new HttpHost(host, port, scheme);
        } catch (IllegalArgumentException unused2) {
            return null;
        }
    }

    public static URI normalizeSyntax(URI uri) throws URISyntaxException {
        if (!uri.isOpaque() && uri.getAuthority() != null) {
            Args.check(uri.isAbsolute(), "Base URI must be absolute");
            URIBuilder uRIBuilder = new URIBuilder(uri);
            String path = uRIBuilder.getPath();
            if (path != null && !path.equals("/")) {
                String[] split = path.split("/");
                Stack stack = new Stack();
                for (String str : split) {
                    if (!str.isEmpty() && !FileUtils.FILE_EXTENSION_SEPARATOR.equals(str)) {
                        if ("..".equals(str)) {
                            if (!stack.isEmpty()) {
                                stack.pop();
                            }
                        } else {
                            stack.push(str);
                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                Iterator it = stack.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                    sb.append(str2);
                }
                if (path.lastIndexOf(47) == path.length() - 1) {
                    sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                }
                uRIBuilder.setPath(sb.toString());
            }
            if (uRIBuilder.getScheme() != null) {
                uRIBuilder.setScheme(uRIBuilder.getScheme().toLowerCase(Locale.ROOT));
            }
            if (uRIBuilder.getHost() != null) {
                uRIBuilder.setHost(uRIBuilder.getHost().toLowerCase(Locale.ROOT));
            }
            return uRIBuilder.build();
        }
        return uri;
    }

    public static URI resolve(URI uri, String str) {
        return resolve(uri, URI.create(str));
    }

    public static URI rewriteURI(URI uri, HttpHost httpHost, boolean z) throws URISyntaxException {
        Args.notNull(uri, "URI");
        if (uri.isOpaque()) {
            return uri;
        }
        URIBuilder uRIBuilder = new URIBuilder(uri);
        if (httpHost != null) {
            uRIBuilder.setScheme(httpHost.getSchemeName());
            uRIBuilder.setHost(httpHost.getHostName());
            uRIBuilder.setPort(httpHost.getPort());
        } else {
            uRIBuilder.setScheme(null);
            uRIBuilder.setHost(null);
            uRIBuilder.setPort(-1);
        }
        if (z) {
            uRIBuilder.setFragment(null);
        }
        if (TextUtils.isEmpty(uRIBuilder.getPath())) {
            uRIBuilder.setPath("/");
        }
        return uRIBuilder.build();
    }

    public static URI rewriteURIForRoute(URI uri, RouteInfo routeInfo) throws URISyntaxException {
        if (uri == null) {
            return null;
        }
        if (routeInfo.getProxyHost() != null && !routeInfo.isTunnelled()) {
            if (!uri.isAbsolute()) {
                return rewriteURI(uri, routeInfo.getTargetHost(), true);
            }
            return rewriteURI(uri);
        }
        if (uri.isAbsolute()) {
            return rewriteURI(uri, null, true);
        }
        return rewriteURI(uri);
    }

    public static URI resolve(URI uri, URI uri2) {
        URI resolve;
        Args.notNull(uri, "Base URI");
        Args.notNull(uri2, "Reference URI");
        String aSCIIString = uri2.toASCIIString();
        if (aSCIIString.startsWith(LocationInfo.NA)) {
            String aSCIIString2 = uri.toASCIIString();
            int indexOf = aSCIIString2.indexOf(63);
            if (indexOf > -1) {
                aSCIIString2 = aSCIIString2.substring(0, indexOf);
            }
            return URI.create(aSCIIString2 + aSCIIString);
        }
        if (aSCIIString.isEmpty()) {
            String aSCIIString3 = uri.resolve(URI.create(xoXoI.f2670oxoX)).toASCIIString();
            resolve = URI.create(aSCIIString3.substring(0, aSCIIString3.indexOf(35)));
        } else {
            resolve = uri.resolve(uri2);
        }
        try {
            return normalizeSyntax(resolve);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static URI rewriteURI(URI uri, HttpHost httpHost) throws URISyntaxException {
        return rewriteURI(uri, httpHost, false);
    }

    public static URI rewriteURI(URI uri) throws URISyntaxException {
        Args.notNull(uri, "URI");
        if (uri.isOpaque()) {
            return uri;
        }
        URIBuilder uRIBuilder = new URIBuilder(uri);
        if (uRIBuilder.getUserInfo() != null) {
            uRIBuilder.setUserInfo(null);
        }
        if (TextUtils.isEmpty(uRIBuilder.getPath())) {
            uRIBuilder.setPath("/");
        }
        if (uRIBuilder.getHost() != null) {
            uRIBuilder.setHost(uRIBuilder.getHost().toLowerCase(Locale.ROOT));
        }
        uRIBuilder.setFragment(null);
        return uRIBuilder.build();
    }

    public static URI resolve(URI uri, HttpHost httpHost, List<URI> list) throws URISyntaxException {
        URIBuilder uRIBuilder;
        Args.notNull(uri, "Request URI");
        if (list != null && !list.isEmpty()) {
            uRIBuilder = new URIBuilder(list.get(list.size() - 1));
            String fragment = uRIBuilder.getFragment();
            for (int size = list.size() - 1; fragment == null && size >= 0; size--) {
                fragment = list.get(size).getFragment();
            }
            uRIBuilder.setFragment(fragment);
        } else {
            uRIBuilder = new URIBuilder(uri);
        }
        if (uRIBuilder.getFragment() == null) {
            uRIBuilder.setFragment(uri.getFragment());
        }
        if (httpHost != null && !uRIBuilder.isAbsolute()) {
            uRIBuilder.setScheme(httpHost.getSchemeName());
            uRIBuilder.setHost(httpHost.getHostName());
            uRIBuilder.setPort(httpHost.getPort());
        }
        return uRIBuilder.build();
    }
}
