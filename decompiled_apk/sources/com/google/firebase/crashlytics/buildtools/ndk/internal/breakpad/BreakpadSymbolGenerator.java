package com.google.firebase.crashlytics.buildtools.ndk.internal.breakpad;

import O0X.oIX0oI;
import com.google.firebase.crashlytics.buildtools.Buildtools;
import com.google.firebase.crashlytics.buildtools.ndk.NativeSymbolGenerator;
import com.google.firebase.crashlytics.buildtools.ndk.internal.CodeMappingException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes10.dex */
public class BreakpadSymbolGenerator implements NativeSymbolGenerator {
    private static final Set<PosixFilePermission> DUMP_SYMS_PERMISSIONS;
    private static final String OBJ_FILE = "dump_syms.obj";
    private static final String OS_LINUX = "linux";
    private static final String OS_MAC = "macos";
    private static final String OS_WINDOWS = "windows";
    private final File dumpSymsBin;

    static {
        PosixFilePermission posixFilePermission;
        PosixFilePermission posixFilePermission2;
        PosixFilePermission posixFilePermission3;
        PosixFilePermission posixFilePermission4;
        PosixFilePermission posixFilePermission5;
        PosixFilePermission posixFilePermission6;
        PosixFilePermission posixFilePermission7;
        PosixFilePermission posixFilePermission8;
        PosixFilePermission posixFilePermission9;
        posixFilePermission = PosixFilePermission.OWNER_READ;
        posixFilePermission2 = PosixFilePermission.GROUP_READ;
        posixFilePermission3 = PosixFilePermission.OTHERS_READ;
        posixFilePermission4 = PosixFilePermission.OWNER_WRITE;
        posixFilePermission5 = PosixFilePermission.GROUP_WRITE;
        posixFilePermission6 = PosixFilePermission.OTHERS_WRITE;
        posixFilePermission7 = PosixFilePermission.OWNER_EXECUTE;
        posixFilePermission8 = PosixFilePermission.GROUP_EXECUTE;
        posixFilePermission9 = PosixFilePermission.OTHERS_EXECUTE;
        DUMP_SYMS_PERMISSIONS = Collections.unmodifiableSet(new HashSet(Arrays.asList(posixFilePermission, posixFilePermission2, posixFilePermission3, posixFilePermission4, posixFilePermission5, posixFilePermission6, posixFilePermission7, posixFilePermission8, posixFilePermission9)));
    }

    public BreakpadSymbolGenerator(File file) {
        this.dumpSymsBin = file;
        Buildtools.logD("Breakpad symbol generator initialized: " + file.getAbsolutePath());
    }

    public static File extractDefaultDumpSymsBinary(File file) throws IOException {
        String str;
        Path path;
        String osForDumpSyms = getOsForDumpSyms();
        if (OS_WINDOWS.equals(osForDumpSyms)) {
            str = "dump_syms.exe";
        } else {
            str = "dump_syms.bin";
        }
        File file2 = new File(file, str);
        if (file2.exists()) {
            Buildtools.logD("Skipping dumpsyms extraction, file exists: " + file2.getAbsolutePath());
            return file2;
        }
        String str2 = "dump_syms/" + osForDumpSyms + "/dump_syms.bin";
        Buildtools.logD("Extracting dump_syms from " + str2 + " to " + file2.getAbsolutePath());
        extractResource(str2, file2);
        if (!OS_WINDOWS.equals(osForDumpSyms)) {
            path = file2.toPath();
            Files.setPosixFilePermissions(path, DUMP_SYMS_PERMISSIONS);
        } else {
            if (!file2.setExecutable(true)) {
                Buildtools.logW("File#setExecutable() failed for " + file2.getAbsolutePath() + "; library extracted without setting permissions.");
            }
            Buildtools.logD("Extracting object file to " + file);
            extractResource("dump_syms/windows/dump_syms.obj", new File(file, OBJ_FILE));
        }
        return file2;
    }

    private static void extractResource(String str, File file) throws IOException {
        InputStream resourceAsStream = BreakpadSymbolGenerator.class.getClassLoader().getResourceAsStream(str);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        IOUtils.copy(resourceAsStream, fileOutputStream);
        resourceAsStream.close();
        fileOutputStream.close();
    }

    private static String getOsForDumpSyms() throws IOException {
        String lowerCase = System.getProperty("os.name").toLowerCase();
        if (lowerCase.startsWith(OS_WINDOWS)) {
            return OS_WINDOWS;
        }
        if (lowerCase.startsWith("mac")) {
            return OS_MAC;
        }
        if (lowerCase.startsWith(OS_LINUX)) {
            return OS_LINUX;
        }
        throw new IOException("Cannot extract dump_syms, unexpected os.name: " + lowerCase);
    }

    @Override // com.google.firebase.crashlytics.buildtools.ndk.NativeSymbolGenerator
    public File generateSymbols(File file, File file2) throws IOException, CodeMappingException {
        ProcessBuilder redirectOutput;
        String moduleId;
        Path path;
        Path path2;
        StandardCopyOption standardCopyOption;
        Buildtools.logD("Crashlytics generating Breakpad Symbol file for: " + file.getAbsolutePath());
        File createTempFile = File.createTempFile(file.getName(), ".tmp", file2);
        Buildtools.logD("Extracting Breakpad symbols to temp file: " + createTempFile.getAbsolutePath());
        redirectOutput = new ProcessBuilder(this.dumpSymsBin.getAbsolutePath(), file.getAbsolutePath()).redirectOutput(createTempFile);
        Process start = redirectOutput.start();
        try {
            start.waitFor();
            if (start.exitValue() == 0) {
                BreakpadRecords createFromBreakpadFile = BreakpadRecords.createFromBreakpadFile(createTempFile);
                if (createFromBreakpadFile.getCodeId() != null) {
                    moduleId = createFromBreakpadFile.getCodeId();
                } else {
                    moduleId = createFromBreakpadFile.getModuleId();
                }
                Buildtools.logD("GNU Build Id for " + file.getAbsolutePath() + ": " + moduleId);
                String oIX0oI2 = oIX0oI.oIX0oI(file.getName(), createFromBreakpadFile.getArchitecture(), moduleId);
                StringBuilder sb = new StringBuilder();
                sb.append(oIX0oI2);
                sb.append(".sym");
                File file3 = new File(file2, sb.toString());
                Buildtools.logD("Renaming Breakpad symbol file to: " + file3.getAbsolutePath());
                path = createTempFile.toPath();
                path2 = file3.toPath();
                standardCopyOption = StandardCopyOption.REPLACE_EXISTING;
                Files.move(path, path2, standardCopyOption);
                return file3;
            }
            throw new IOException("Breakpad symbol generation failed (exit=" + start.exitValue() + "), see STDERR");
        } catch (InterruptedException e) {
            throw new IOException("Dump symbols was unexpectedly interrupted.", e);
        }
    }
}
