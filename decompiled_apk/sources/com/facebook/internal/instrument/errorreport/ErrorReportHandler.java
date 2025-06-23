package com.facebook.internal.instrument.errorreport;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.errorreport.ErrorReportData;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.collections.o00;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class ErrorReportHandler {

    @OOXIXo
    public static final ErrorReportHandler INSTANCE = new ErrorReportHandler();
    private static final int MAX_ERROR_REPORT_NUM = 1000;

    private ErrorReportHandler() {
    }

    @x0XOIxOo
    public static final void enable() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            sendErrorReports();
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final File[] listErrorReportFiles() {
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        File instrumentReportDir = InstrumentUtility.getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: Xo0.xxIXOIIO
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                boolean m233listErrorReportFiles$lambda3;
                m233listErrorReportFiles$lambda3 = ErrorReportHandler.m233listErrorReportFiles$lambda3(file, str);
                return m233listErrorReportFiles$lambda3;
            }
        });
        IIX0o.oO(listFiles, "reportDir.listFiles { dir, name ->\n      name.matches(Regex(String.format(\"^%s[0-9]+.json$\", InstrumentUtility.ERROR_REPORT_PREFIX)))\n    }");
        return listFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listErrorReportFiles$lambda-3, reason: not valid java name */
    public static final boolean m233listErrorReportFiles$lambda3(File file, String name) {
        IIX0o.oO(name, "name");
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{InstrumentUtility.ERROR_REPORT_PREFIX}, 1));
        IIX0o.oO(format, "java.lang.String.format(format, *args)");
        return new Regex(format).matches(name);
    }

    @x0XOIxOo
    public static final void save(@oOoXoXO String str) {
        try {
            new ErrorReportData(str).save();
        } catch (Exception unused) {
        }
    }

    @x0XOIxOo
    public static final void sendErrorReports() {
        Utility utility = Utility.INSTANCE;
        if (Utility.isDataProcessingRestricted()) {
            return;
        }
        File[] listErrorReportFiles = listErrorReportFiles();
        final ArrayList arrayList = new ArrayList();
        int length = listErrorReportFiles.length;
        int i = 0;
        while (i < length) {
            File file = listErrorReportFiles[i];
            i++;
            ErrorReportData errorReportData = new ErrorReportData(file);
            if (errorReportData.isValid()) {
                arrayList.add(errorReportData);
            }
        }
        o00.OO0x0xX(arrayList, new Comparator() { // from class: Xo0.xoIox
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int m234sendErrorReports$lambda0;
                m234sendErrorReports$lambda0 = ErrorReportHandler.m234sendErrorReports$lambda0((ErrorReportData) obj, (ErrorReportData) obj2);
                return m234sendErrorReports$lambda0;
            }
        });
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < arrayList.size() && i2 < 1000; i2++) {
            jSONArray.put(arrayList.get(i2));
        }
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        InstrumentUtility.sendReports("error_reports", jSONArray, new GraphRequest.Callback() { // from class: Xo0.OOXIXo
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                ErrorReportHandler.m235sendErrorReports$lambda2(arrayList, graphResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendErrorReports$lambda-0, reason: not valid java name */
    public static final int m234sendErrorReports$lambda0(ErrorReportData errorReportData, ErrorReportData o2) {
        IIX0o.oO(o2, "o2");
        return errorReportData.compareTo(o2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendErrorReports$lambda-2, reason: not valid java name */
    public static final void m235sendErrorReports$lambda2(ArrayList validReports, GraphResponse response) {
        Boolean valueOf;
        IIX0o.x0xO0oo(validReports, "$validReports");
        IIX0o.x0xO0oo(response, "response");
        try {
            if (response.getError() == null) {
                JSONObject jsonObject = response.getJsonObject();
                if (jsonObject == null) {
                    valueOf = null;
                } else {
                    valueOf = Boolean.valueOf(jsonObject.getBoolean("success"));
                }
                if (IIX0o.Oxx0IOOO(valueOf, Boolean.TRUE)) {
                    Iterator it = validReports.iterator();
                    while (it.hasNext()) {
                        ((ErrorReportData) it.next()).clear();
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }
}
