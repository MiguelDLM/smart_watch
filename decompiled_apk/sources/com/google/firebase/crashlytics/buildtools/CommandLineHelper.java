package com.google.firebase.crashlytics.buildtools;

import com.google.firebase.crashlytics.buildtools.Obfuscator;
import com.google.firebase.crashlytics.buildtools.api.SymbolFileService;
import com.google.firebase.crashlytics.buildtools.log.CrashlyticsLogger;
import com.google.firebase.crashlytics.buildtools.ndk.NativeSymbolGenerator;
import com.google.firebase.crashlytics.buildtools.ndk.internal.breakpad.BreakpadSymbolFileService;
import com.google.firebase.crashlytics.buildtools.ndk.internal.breakpad.BreakpadSymbolGenerator;
import com.google.firebase.crashlytics.buildtools.ndk.internal.csym.CsymSymbolFileService;
import com.google.firebase.crashlytics.buildtools.ndk.internal.csym.NdkCSymGenerator;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.VisibleForTesting;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.CommandLine;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.DefaultParser;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.Options;
import com.google.firebase.crashlytics.buildtools.utils.FileUtils;
import com.kuaishou.weapon.p0.bq;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

/* loaded from: classes10.dex */
public class CommandLineHelper {
    private final CommandLine cmd;
    private static final String[] VALID_COMMANDS = {CrashlyticsOptions.OPT_HELP, CrashlyticsOptions.OPT_INJECT_MAPPING_FILE_ID, CrashlyticsOptions.OPT_UPLOAD_MAPPING_FILE, CrashlyticsOptions.OPT_GENERATE_NATIVE_SYMBOLS, CrashlyticsOptions.OPT_UPLOAD_NATIVE_SYMBOLS};
    private static final Pattern GOOGLE_APP_ID_PATTERN = Pattern.compile("(\\d+):(\\d+):(\\w+):(\\p{XDigit}+)");

    public CommandLineHelper(CommandLine commandLine) {
        this.cmd = commandLine;
    }

    private void configureWebApi() {
        Buildtools.setWebApi(Buildtools.createWebApi());
        Package r0 = CommandLineHelper.class.getPackage();
        String implementationTitle = r0.getImplementationTitle();
        String implementationVersion = r0.getImplementationVersion();
        if (this.cmd.hasOption(CrashlyticsOptions.OPT_CLIENT_NAME)) {
            implementationTitle = this.cmd.getOptionValue(CrashlyticsOptions.OPT_CLIENT_NAME);
        }
        if (this.cmd.hasOption(CrashlyticsOptions.OPT_CLIENT_VERSION)) {
            implementationVersion = this.cmd.getOptionValue(CrashlyticsOptions.OPT_CLIENT_VERSION);
        }
        Buildtools.getInstance().setBuildtoolsClientInfo(implementationTitle, implementationVersion);
    }

    private static SymbolFileService createSymbolFileService(CommandLine commandLine) throws IllegalArgumentException {
        String optionValue = commandLine.getOptionValue(CrashlyticsOptions.OPT_SYMBOL_GENERATOR_TYPE, "breakpad");
        if ("breakpad".equals(optionValue)) {
            return new BreakpadSymbolFileService();
        }
        if (CrashlyticsOptions.SYMBOL_GENERATOR_CSYM.equals(optionValue)) {
            return new CsymSymbolFileService();
        }
        throwInvalidSymbolGeneratorMode(optionValue);
        return null;
    }

    private static NativeSymbolGenerator createSymbolGenerator(CommandLine commandLine) throws IllegalArgumentException, IOException {
        String optionValue = commandLine.getOptionValue(CrashlyticsOptions.OPT_SYMBOL_GENERATOR_TYPE, "breakpad");
        if ("breakpad".equals(optionValue)) {
            return new BreakpadSymbolGenerator(resolveDumpSymsBinary(commandLine));
        }
        if (CrashlyticsOptions.SYMBOL_GENERATOR_CSYM.equals(optionValue)) {
            return new NdkCSymGenerator();
        }
        throwInvalidSymbolGeneratorMode(optionValue);
        return null;
    }

    private void executeGenerateSymbols() throws IOException {
        boolean z;
        File file;
        String optionValue = this.cmd.getOptionValue(CrashlyticsOptions.OPT_NATIVE_UNSTRIPPED_LIB);
        String optionValue2 = this.cmd.getOptionValue(CrashlyticsOptions.OPT_NATIVE_UNSTRIPPED_LIBS_DIR);
        boolean z2 = false;
        if (optionValue != null) {
            z = true;
        } else {
            z = false;
        }
        if (optionValue2 != null) {
            z2 = true;
        }
        if (z2 ^ z) {
            File file2 = new File(getOptionValueOrThrow(this.cmd, CrashlyticsOptions.OPT_CSYM_CACHE_DIR));
            FileUtils.verifyDirectory(file2);
            if (z) {
                file = new File(optionValue);
            } else {
                file = new File(optionValue2);
            }
            Buildtools.getInstance().generateNativeSymbolFiles(file, file2, createSymbolGenerator(this.cmd));
            return;
        }
        throw new IllegalArgumentException("generateNativeSymbols requires either 1) unstrippedLibrary or 2) unstrippedLibrariesDir");
    }

    private void executeInjectMappingFileId() throws IOException {
        String optionValueOrThrow = getOptionValueOrThrow(this.cmd, CrashlyticsOptions.OPT_INJECT_MAPPING_FILE_ID);
        if (this.cmd.hasOption(CrashlyticsOptions.OPT_MAPPING_FILE_ID)) {
            Buildtools.getInstance().injectMappingFileIdIntoResource(new File(optionValueOrThrow), getOptionValueOrThrow(this.cmd, CrashlyticsOptions.OPT_MAPPING_FILE_ID));
        } else {
            Buildtools.getInstance().injectMappingFileIdIntoResource(new File(optionValueOrThrow));
        }
    }

    private void executeUploadMappingFile() throws IOException {
        File file = new File(getOptionValueOrThrow(this.cmd, CrashlyticsOptions.OPT_UPLOAD_MAPPING_FILE));
        String optionValueOrThrow = getOptionValueOrThrow(this.cmd, CrashlyticsOptions.OPT_GOOGLE_APP_ID);
        validateGoogleAppId(optionValueOrThrow);
        AppBuildInfo appBuildInfo = new AppBuildInfo(this.cmd.getOptionValue(CrashlyticsOptions.OPT_ANDROID_APPLICATION_ID, (String) null), optionValueOrThrow, null);
        Obfuscator obfuscator = new Obfuscator(Obfuscator.Vendor.PROGUARD, bq.e);
        if (this.cmd.hasOption(CrashlyticsOptions.OPT_MAPPING_FILE_ID) && !this.cmd.hasOption(CrashlyticsOptions.OPT_RESOURCE_FILE)) {
            Buildtools.getInstance().uploadMappingFile(file, getOptionValueOrThrow(this.cmd, CrashlyticsOptions.OPT_MAPPING_FILE_ID), appBuildInfo, obfuscator);
        } else {
            if (this.cmd.hasOption(CrashlyticsOptions.OPT_RESOURCE_FILE) && !this.cmd.hasOption(CrashlyticsOptions.OPT_MAPPING_FILE_ID)) {
                Buildtools.getInstance().uploadMappingFile(file, new File(getOptionValueOrThrow(this.cmd, CrashlyticsOptions.OPT_RESOURCE_FILE)), appBuildInfo, obfuscator);
                return;
            }
            throw new IllegalArgumentException("When executing uploadMappingFile, use either mappingFileId or resourceFile (but not both).");
        }
    }

    private void executeUploadSymbols() throws IOException {
        File file = new File(getOptionValueOrThrow(this.cmd, CrashlyticsOptions.OPT_CSYM_CACHE_DIR));
        FileUtils.verifyDirectory(file);
        String optionValueOrThrow = getOptionValueOrThrow(this.cmd, CrashlyticsOptions.OPT_GOOGLE_APP_ID);
        validateGoogleAppId(optionValueOrThrow);
        Buildtools.getInstance().uploadNativeSymbolFiles(file, optionValueOrThrow, createSymbolFileService(this.cmd));
    }

    private static String getOptionValueOrThrow(CommandLine commandLine, String str) throws IllegalArgumentException {
        String optionValue = commandLine.getOptionValue(str);
        if (optionValue != null) {
            return optionValue;
        }
        throw new IllegalArgumentException("Required argument missing: " + str);
    }

    public static void main(String[] strArr) {
        String str;
        boolean z = false;
        try {
            Buildtools.getLogger();
            int length = strArr.length;
            int i = 0;
            boolean z2 = false;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str2 = strArr[i];
                if (str2.equals("-verbose")) {
                    z = true;
                    break;
                } else {
                    if (str2.equals("-quiet")) {
                        z2 = true;
                    }
                    i++;
                }
            }
            if (z) {
                Buildtools.getLogger().setLevel(CrashlyticsLogger.Level.VERBOSE);
            } else if (z2) {
                Buildtools.getLogger().setLevel(CrashlyticsLogger.Level.ERROR);
            }
            Options createOptions = CrashlyticsOptions.createOptions();
            CommandLine parse = new DefaultParser().parse(createOptions, strArr);
            if (parse.hasOption(CrashlyticsOptions.OPT_HELP)) {
                new HelpFormatter().printHelp(Buildtools.class.getName(), createOptions);
            } else {
                new CommandLineHelper(parse).executeCommand();
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Crashlytics execution failed.");
            if (0 == 0) {
                str = " Run with -verbose for additional output.";
            } else {
                str = "";
            }
            sb.append(str);
            Buildtools.logE(sb.toString(), e);
            System.exit(-1);
        }
    }

    private static File resolveDumpSymsBinary(CommandLine commandLine) throws IllegalArgumentException, IOException {
        if (commandLine.hasOption(CrashlyticsOptions.OPT_DUMP_SYMS_BINARY)) {
            return new File(commandLine.getOptionValue(CrashlyticsOptions.OPT_DUMP_SYMS_BINARY));
        }
        File file = new File(".crashlytics");
        if (!file.isDirectory()) {
            if (!file.isFile()) {
                file.mkdir();
            } else {
                throw new IOException("Could not create Crashlytics directory, a file already exists at that location: " + file.getAbsolutePath());
            }
        }
        return BreakpadSymbolGenerator.extractDefaultDumpSymsBinary(file);
    }

    private static void throwInvalidSymbolGeneratorMode(String str) throws IllegalArgumentException {
        throw new IllegalArgumentException("Invalid argument for symbolGenerator (" + str + "), must be one of [breakpad, " + CrashlyticsOptions.SYMBOL_GENERATOR_CSYM + "]");
    }

    @VisibleForTesting
    public static void validateGoogleAppId(String str) {
        Preconditions.checkArgument(GOOGLE_APP_ID_PATTERN.matcher(str).matches(), "Google App ID parameter doesn't match the expected format. Check that the parameter has been passed in correctly.");
    }

    public void executeCommand() throws IOException {
        configureWebApi();
        int i = 0;
        for (String str : VALID_COMMANDS) {
            if (this.cmd.hasOption(str)) {
                i++;
            }
        }
        if (i == 1) {
            if (this.cmd.hasOption(CrashlyticsOptions.OPT_INJECT_MAPPING_FILE_ID)) {
                executeInjectMappingFileId();
                return;
            }
            if (this.cmd.hasOption(CrashlyticsOptions.OPT_UPLOAD_MAPPING_FILE)) {
                executeUploadMappingFile();
                return;
            } else if (this.cmd.hasOption(CrashlyticsOptions.OPT_GENERATE_NATIVE_SYMBOLS)) {
                executeGenerateSymbols();
                return;
            } else {
                if (this.cmd.hasOption(CrashlyticsOptions.OPT_UPLOAD_NATIVE_SYMBOLS)) {
                    executeUploadSymbols();
                    return;
                }
                return;
            }
        }
        throw new IllegalArgumentException("Exactly ONE valid command required. Use '-help' valid arguments.");
    }
}
