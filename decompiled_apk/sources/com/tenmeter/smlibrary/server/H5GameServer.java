package com.tenmeter.smlibrary.server;

import android.content.Context;
import com.tenmeter.smlibrary.utils.KLog;
import fi.iki.elonen.NanoHTTPD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes13.dex */
public class H5GameServer extends NanoHTTPD {
    private static final int PORT = 0;
    public static String WEB_ROOT = "";
    private Context mContext;

    public H5GameServer(Context context) throws IOException {
        super(0);
        this.mContext = context;
        start();
        KLog.i("H5GameServer start");
    }

    private NanoHTTPD.Response render200(String str, File file) {
        try {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, NanoHTTPD.getMimeTypeForFile(str), new FileInputStream(file), file.length());
        } catch (FileNotFoundException e) {
            return render500(e.getMessage());
        }
    }

    private NanoHTTPD.Response render301(String str) {
        NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.REDIRECT, NanoHTTPD.MIME_HTML, null);
        newFixedLengthResponse.addHeader("Location", str);
        return newFixedLengthResponse;
    }

    private NanoHTTPD.Response render404() {
        return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.NOT_FOUND, NanoHTTPD.MIME_HTML, null);
    }

    private NanoHTTPD.Response render500(String str) {
        return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.INTERNAL_ERROR, "text/plain", str);
    }

    @Override // fi.iki.elonen.NanoHTTPD
    public NanoHTTPD.Response serve(NanoHTTPD.IHTTPSession iHTTPSession) {
        String uri = iHTTPSession.getUri();
        if (!uri.endsWith("/index.html") && !uri.endsWith("/index.htm")) {
            File file = new File(WEB_ROOT, uri);
            if (file.exists()) {
                if (file.isFile()) {
                    return render200(uri, file);
                }
                if (uri.endsWith("/")) {
                    File file2 = new File(file, "index.html");
                    if (file2.exists()) {
                        return render200(uri + "index.html", file2);
                    }
                    return render404();
                }
                return render301(uri + "/");
            }
            return render404();
        }
        return render301("./");
    }

    public H5GameServer(int i) {
        super(i);
    }

    public H5GameServer(String str, int i) {
        super(str, i);
    }
}
