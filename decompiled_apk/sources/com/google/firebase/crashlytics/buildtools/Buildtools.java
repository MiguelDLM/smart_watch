package com.google.firebase.crashlytics.buildtools;

import com.google.firebase.crashlytics.buildtools.api.FirebaseMappingFileService;
import com.google.firebase.crashlytics.buildtools.api.RestfulWebApi;
import com.google.firebase.crashlytics.buildtools.api.SymbolFileService;
import com.google.firebase.crashlytics.buildtools.api.WebApi;
import com.google.firebase.crashlytics.buildtools.api.net.proxy.DefaultProxyFactory;
import com.google.firebase.crashlytics.buildtools.buildids.BuildIdInfoCollector;
import com.google.firebase.crashlytics.buildtools.buildids.BuildIdsWriter;
import com.google.firebase.crashlytics.buildtools.log.ConsoleLogger;
import com.google.firebase.crashlytics.buildtools.log.CrashlyticsLogger;
import com.google.firebase.crashlytics.buildtools.mappingfiles.MappingFileIdReader;
import com.google.firebase.crashlytics.buildtools.mappingfiles.MappingFileIdWriter;
import com.google.firebase.crashlytics.buildtools.ndk.NativeSymbolGenerator;
import com.google.firebase.crashlytics.buildtools.ndk.internal.CodeMappingException;
import com.google.firebase.crashlytics.buildtools.ndk.internal.csym.CsymSymbolFileService;
import com.google.firebase.crashlytics.buildtools.ndk.internal.csym.NdkCSymGenerator;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter.TrueFileFilter;
import com.google.firebase.crashlytics.buildtools.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

/* loaded from: classes10.dex */
public class Buildtools {
    protected static final String BASE_API_URL_PROP = "crashlytics.webApiUrl";
    protected static final String CODEMAPPING_API_URL_PROP = "crashlytics.cmApiUrl";
    public static final String DUMMY_MAPPING_ID = "00000000000000000000000000000000";
    private static final String UNSTRIPPED_NATIVE_LIBS_DIR_ERR_MSG = "Either specify the correct unstrippedNativeLibsDir or disable Crashlytics symbol uploading.";
    private static Buildtools instance;
    private static CrashlyticsLogger logger = new ConsoleLogger(CrashlyticsLogger.Level.INFO);
    private static WebApi sharedWebApi;

    public Buildtools(WebApi webApi) {
        logD("Crashlytics Buildtools initialized.");
        setWebApi(webApi);
        Package r2 = getClass().getPackage();
        setBuildtoolsClientInfo(r2.getImplementationTitle(), r2.getImplementationVersion());
    }

    public static WebApi createWebApi() {
        return new RestfulWebApi(System.getProperty(CODEMAPPING_API_URL_PROP, WebApi.DEFAULT_CODEMAPPING_API_URL), new DefaultProxyFactory());
    }

    public static String generateMappingFileId() {
        return UUID.randomUUID().toString().replace(HelpFormatter.DEFAULT_OPT_PREFIX, "").toLowerCase();
    }

    public static synchronized Buildtools getInstance() {
        Buildtools buildtools;
        synchronized (Buildtools.class) {
            try {
                if (instance == null) {
                    instance = new Buildtools(createWebApi());
                }
                buildtools = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return buildtools;
    }

    public static CrashlyticsLogger getLogger() {
        return logger;
    }

    public static WebApi getWebApi() {
        return sharedWebApi;
    }

    public static void logD(String str) {
        logger.logD(str);
    }

    public static void logE(String str, Throwable th) {
        logger.logE(str, th);
    }

    public static void logI(String str) {
        logger.logI(str);
    }

    public static void logV(String str) {
        logger.logV(str);
    }

    public static void logW(String str) {
        logger.logW(str, null);
    }

    public static void main(String[] strArr) {
        CommandLineHelper.main(strArr);
    }

    public static void setLogger(CrashlyticsLogger crashlyticsLogger) {
        logger = crashlyticsLogger;
    }

    public static void setWebApi(WebApi webApi) {
        if (!WebApi.DEFAULT_CODEMAPPING_API_URL.equals(webApi.getCodeMappingApiUrl())) {
            logW("Using overridden Crashlytics host: " + webApi.getCodeMappingApiUrl(), null);
        }
        sharedWebApi = webApi;
    }

    public void generateNativeSymbolFiles(File file, File file2) throws IOException {
        generateNativeSymbolFiles(file, file2, new NdkCSymGenerator());
    }

    public boolean injectBuildIdsIntoResource(File file, File file2) throws IOException {
        BuildIdInfoCollector buildIdInfoCollector = new BuildIdInfoCollector();
        if (file.exists()) {
            if (file.isFile() && FileUtils.isZipFile(file)) {
                logD("Skipping zip file: " + file.getAbsolutePath());
                return true;
            }
            new BuildIdsWriter(file2).writeBuildIds(buildIdInfoCollector.collect(file));
            return true;
        }
        throw new IOException(String.format("Unstripped native library path does not exist: %s. %s", file.getAbsolutePath(), UNSTRIPPED_NATIVE_LIBS_DIR_ERR_MSG));
    }

    public boolean injectMappingFileIdIntoResource(File file, String str) throws IOException {
        logD(String.format("Injecting mappingFileId into file [mappingFileId: %1$s; file:  %2$s]", str, file));
        if (str.equals(MappingFileIdReader.create(file).getMappingFileId())) {
            logD("mappingFileId was NOT updated; correct value already present.");
            return false;
        }
        new MappingFileIdWriter(file).writeMappingFileId(str);
        return true;
    }

    public void setBuildtoolsClientInfo(String str, String str2) {
        getWebApi().setClientType(str);
        getWebApi().setClientVersion(str2);
        getWebApi().setUserAgent(str + "/" + str2);
    }

    public void uploadMappingFile(File file, File file2, AppBuildInfo appBuildInfo, Obfuscator obfuscator) throws IOException {
        logD("Extracting mappingFileId from resource file: " + file2.getAbsolutePath());
        if (file2.isFile()) {
            String mappingFileId = MappingFileIdReader.create(file2).getMappingFileId();
            if (mappingFileId != null && !mappingFileId.isEmpty()) {
                uploadMappingFile(file, mappingFileId, appBuildInfo, obfuscator);
                return;
            }
            throw new IllegalArgumentException("Resource file does not contain a valid mapping file id: " + file2.getAbsolutePath());
        }
        throw new IllegalArgumentException("Resource file is not valid: " + file2.getAbsolutePath());
    }

    public void uploadNativeSymbolFiles(File file, String str) throws IOException {
        uploadNativeSymbolFiles(file, str, new CsymSymbolFileService());
    }

    public static void logW(String str, Throwable th) {
        logger.logW(str, th);
    }

    public void generateNativeSymbolFiles(File file, File file2, NativeSymbolGenerator nativeSymbolGenerator) throws IOException {
        Collection<File> singleton;
        if (file.exists()) {
            if (file.isFile() && FileUtils.isZipFile(file)) {
                File file3 = new File(file2, "unzippedLibsCache");
                logD("Zipped input file detected: " + file.getAbsolutePath() + "; unzipping to temp location: " + file3.getAbsolutePath());
                try {
                    try {
                        com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.FileUtils.deleteQuietly(file3);
                        FileUtils.verifyDirectory(file3);
                        FileUtils.unzipArchive(file, file3);
                        generateNativeSymbolFiles(file3, file2, nativeSymbolGenerator);
                        return;
                    } catch (Exception e) {
                        throw e;
                    }
                } finally {
                    logD("Cleaning up unzip target dir: " + file3.getAbsolutePath());
                    com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.FileUtils.deleteQuietly(file3);
                }
            }
            logD("Generating native symbol files for " + file.getAbsolutePath() + "; writing output to: " + file2.getAbsolutePath());
            if (file.isDirectory()) {
                singleton = com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.FileUtils.listFiles(file, NativeSymbolGenerator.SO_FILE_FILTER, TrueFileFilter.INSTANCE);
            } else {
                singleton = Collections.singleton(file);
            }
            if (!singleton.isEmpty()) {
                logD("" + singleton.size() + " native libraries found at " + file);
                FileUtils.verifyDirectory(file2);
                try {
                    for (File file4 : singleton) {
                        File generateSymbols = nativeSymbolGenerator.generateSymbols(file4, file2);
                        if (generateSymbols == null) {
                            logW(String.format("Null symbol file generated for %s", file4.getAbsolutePath()));
                        } else {
                            logD(String.format("Generated symbol file: %s (%,d bytes)", generateSymbols.getAbsolutePath(), Long.valueOf(generateSymbols.length())));
                        }
                    }
                    return;
                } catch (CodeMappingException e2) {
                    throw new IOException(e2);
                }
            }
            throw new IOException(String.format("No native libraries found at %s. %s", file.getAbsolutePath(), UNSTRIPPED_NATIVE_LIBS_DIR_ERR_MSG));
        }
        throw new IOException(String.format("Unstripped native library path does not exist: %s. %s", file.getAbsolutePath(), UNSTRIPPED_NATIVE_LIBS_DIR_ERR_MSG));
    }

    public void uploadNativeSymbolFiles(File file, String str, SymbolFileService symbolFileService) throws IOException {
        logD("Uploading native symbol files from directory: " + file.getAbsolutePath());
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                symbolFileService.uploadNativeSymbolFile(getWebApi(), file2, str);
                logD("Crashlytics symbol file uploaded successfully; deleting local file: " + file2.getAbsolutePath());
                file2.delete();
            }
            return;
        }
        throw new IOException("Crashlytics native symbol files directory does not exist: " + file.getAbsolutePath());
    }

    public void injectMappingFileIdIntoResource(File file) throws IOException {
        injectMappingFileIdIntoResource(file, generateMappingFileId());
    }

    public void uploadMappingFile(File file, String str, AppBuildInfo appBuildInfo, Obfuscator obfuscator) throws IOException {
        logD(String.format("Uploading Mapping File [mappingFile: %1$s; mappingFileId: %2$s;packageName: %3$s; googleAppId: %4$s]", file.getAbsolutePath(), str, appBuildInfo.getPackageName(), appBuildInfo.getGoogleAppId()));
        new FirebaseMappingFileService(getWebApi()).uploadMappingFile(file, str, appBuildInfo, obfuscator);
        logI(String.format("Mapping file uploaded: %1$s", file.toString()));
    }
}
