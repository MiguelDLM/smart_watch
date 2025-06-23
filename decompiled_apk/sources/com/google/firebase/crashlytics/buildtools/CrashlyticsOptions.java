package com.google.firebase.crashlytics.buildtools;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.Option;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.Options;

/* loaded from: classes10.dex */
public final class CrashlyticsOptions {
    public static final String OPT_ANDROID_APPLICATION_ID = "androidApplicationId";
    public static final String OPT_CLIENT_NAME = "clientName";
    public static final String OPT_CLIENT_VERSION = "clientVersion";
    public static final String OPT_CSYM_CACHE_DIR = "symbolFileCacheDir";
    public static final String OPT_DUMP_SYMS_BINARY = "dumpSymsBinary";
    public static final String OPT_GENERATE_NATIVE_SYMBOLS = "generateNativeSymbols";
    public static final String OPT_GOOGLE_APP_ID = "googleAppId";
    public static final String OPT_HELP = "help";
    public static final String OPT_INJECT_MAPPING_FILE_ID = "injectMappingFileIdIntoResource";
    public static final String OPT_MAPPING_FILE_ID = "mappingFileId";
    public static final String OPT_NATIVE_UNSTRIPPED_LIB = "unstrippedLibrary";
    public static final String OPT_NATIVE_UNSTRIPPED_LIBS_DIR = "unstrippedLibrariesDir";
    public static final String OPT_OBFUSCATOR_NAME = "obfuscatorName";
    public static final String OPT_OBFUSCATOR_VERSION = "obfuscationVersion";
    public static final String OPT_QUIET = "quiet";
    public static final String OPT_RESOURCE_FILE = "resourceFile";
    public static final String OPT_SYMBOL_GENERATOR_TYPE = "symbolGenerator";
    public static final String OPT_UPLOAD_MAPPING_FILE = "uploadMappingFile";
    public static final String OPT_UPLOAD_NATIVE_SYMBOLS = "uploadNativeSymbols";
    public static final String OPT_VERBOSE = "verbose";
    public static final String SYMBOL_GENERATOR_BREAKPAD = "breakpad";
    public static final String SYMBOL_GENERATOR_CSYM = "csym";
    public static final String SYMBOL_GENERATOR_DEFAULT = "breakpad";

    private CrashlyticsOptions() {
    }

    public static Options createOptions() {
        Options options = new Options();
        options.addOption(new Option(OPT_VERBOSE, "Verbose command line output"));
        options.addOption(new Option(OPT_QUIET, "Silent command line output"));
        options.addOption(new Option(OPT_HELP, "Display command help."));
        options.addOption(Option.builder(OPT_CLIENT_NAME).desc("Override the client name sent to Crashlytics in the User-Agent string.").hasArg().argName(OPT_CLIENT_NAME).build());
        options.addOption(Option.builder(OPT_CLIENT_VERSION).desc("Override the client version sent to Crashlytics in the User-Agent string.").hasArg().argName(OPT_CLIENT_VERSION).build());
        options.addOption(Option.builder(OPT_INJECT_MAPPING_FILE_ID).desc("Inject the provided mappingFileId as an Android resource into resourceFile. If not specified, a random mappingFileId will be generated.").hasArg().argName(OPT_RESOURCE_FILE).build());
        options.addOption(Option.builder(OPT_MAPPING_FILE_ID).desc("ID to uniquely identifying the mapping file associated with this build.").hasArg().argName(OPT_MAPPING_FILE_ID).build());
        options.addOption(Option.builder(OPT_RESOURCE_FILE).desc("Android XML resource file, in which to (optionally) locate the mapping file id when using uploadMappingFile").hasArg().argName(OPT_RESOURCE_FILE).build());
        options.addOption(Option.builder(OPT_UPLOAD_MAPPING_FILE).desc("Upload mappingFile with the associated mappingFileId.").hasArg().argName("mappingFile").build());
        options.addOption(Option.builder(OPT_OBFUSCATOR_NAME).desc("Optionally specify an obfuscator vendor identifier for use with obfuscationVersion").hasArg().argName(OPT_OBFUSCATOR_NAME).build());
        options.addOption(Option.builder(OPT_OBFUSCATOR_VERSION).desc("Optionally specify an obfuscator version for use with obfuscatorName").hasArg().argName("obfuscatorVersion").build());
        options.addOption(Option.builder(OPT_GENERATE_NATIVE_SYMBOLS).desc("Generate native symbol mappings to be later uploaded with uploadNativeSymbols").build());
        options.addOption(Option.builder(OPT_UPLOAD_NATIVE_SYMBOLS).desc("Upload native symbol files generated with generateNativeSymbols to Crashlytics.").build());
        options.addOption(Option.builder(OPT_NATIVE_UNSTRIPPED_LIB).desc("Unstripped native library file containing debug symbols").hasArg().argName("unstrippedNativeLib").build());
        options.addOption(Option.builder(OPT_NATIVE_UNSTRIPPED_LIBS_DIR).desc("Directory path containing subdirs with unstripped native libraries.").hasArg().argName("unstrippedNativeLibsDir").build());
        options.addOption(Option.builder(OPT_CSYM_CACHE_DIR).desc("Directory to store Crashlytics symbol files generated from unstripped NDK libraries.").hasArg().argName(OPT_CSYM_CACHE_DIR).build());
        options.addOption(Option.builder(OPT_SYMBOL_GENERATOR_TYPE).desc("Mode for native symbol generation. Must be one of [breakpad,csym]").hasArg().argName("nativeSymbolGenerator").build());
        options.addOption(Option.builder(OPT_DUMP_SYMS_BINARY).desc("Path to dump_syms.bin, used with the symbolGenerator=breakpad option. If not specified, the bundled dump_syms.bin will be extracted to the local .crashlytics directory and used by default.").hasArg().argName(OPT_DUMP_SYMS_BINARY).build());
        options.addOption(Option.builder(OPT_GOOGLE_APP_ID).desc("Google App Id, generally found in google-services.json").hasArg().argName(OPT_GOOGLE_APP_ID).build());
        options.addOption(Option.builder(OPT_ANDROID_APPLICATION_ID).desc("Android application id as declared in the Android Manifest.").hasArg().argName("AndroidAppId").build());
        return options;
    }
}
