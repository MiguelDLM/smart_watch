package okio.internal;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.szabh.smable3.entity.BleWatchFaceId;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import kotlin.OX00O0xII;
import kotlin.Xo0;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.II0xO0;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;
import okio.BufferedSource;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.ZipFileSystem;
import xX0ox.Oxx0IOOO;

@XX({"SMAP\nZipFiles.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ZipFiles.kt\nokio/internal/ZipFilesKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,459:1\n1045#2:460\n*S KotlinDebug\n*F\n+ 1 ZipFiles.kt\nokio/internal/ZipFilesKt\n*L\n156#1:460\n*E\n"})
/* loaded from: classes6.dex */
public final class ZipFilesKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        Path path = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
        Map<Path, ZipEntry> I0oOIX2 = o0.I0oOIX(Xo0.oIX0oI(path, new ZipEntry(path, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null)));
        for (ZipEntry zipEntry : CollectionsKt___CollectionsKt.xxx(list, new Comparator() { // from class: okio.internal.ZipFilesKt$buildIndex$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return Oxx0IOOO.oOoXoXO(((ZipEntry) t).getCanonicalPath(), ((ZipEntry) t2).getCanonicalPath());
            }
        })) {
            if (I0oOIX2.put(zipEntry.getCanonicalPath(), zipEntry) == null) {
                while (true) {
                    Path parent = zipEntry.getCanonicalPath().parent();
                    if (parent != null) {
                        ZipEntry zipEntry2 = I0oOIX2.get(parent);
                        if (zipEntry2 != null) {
                            zipEntry2.getChildren().add(zipEntry.getCanonicalPath());
                            break;
                        }
                        ZipEntry zipEntry3 = new ZipEntry(parent, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null);
                        I0oOIX2.put(parent, zipEntry3);
                        zipEntry3.getChildren().add(zipEntry.getCanonicalPath());
                        zipEntry = zipEntry3;
                    }
                }
            }
        }
        return I0oOIX2;
    }

    private static final Long dosDateTimeToEpochMillis(int i, int i2) {
        if (i2 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(((i >> 9) & 127) + 1980, ((i >> 5) & 15) - 1, i & 31, (i2 >> 11) & 31, (i2 >> 5) & 63, (i2 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String getHex(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(HexStringBuilder.DEFAULT_PREFIX);
        String num = Integer.toString(i, II0xO0.oIX0oI(16));
        IIX0o.oO(num, "toString(this, checkRadix(radix))");
        sb.append(num);
        return sb.toString();
    }

    /* JADX WARN: Finally extract failed */
    @OOXIXo
    public static final ZipFileSystem openZip(@OOXIXo Path zipPath, @OOXIXo FileSystem fileSystem, @OOXIXo oOoXoXO<? super ZipEntry, Boolean> predicate) throws IOException {
        BufferedSource buffer;
        IIX0o.x0xO0oo(zipPath, "zipPath");
        IIX0o.x0xO0oo(fileSystem, "fileSystem");
        IIX0o.x0xO0oo(predicate, "predicate");
        FileHandle openReadOnly = fileSystem.openReadOnly(zipPath);
        try {
            long size = openReadOnly.size() - 22;
            if (size >= 0) {
                long max = Math.max(size - 65536, 0L);
                do {
                    BufferedSource buffer2 = Okio.buffer(openReadOnly.source(size));
                    try {
                        if (buffer2.readIntLe() == END_OF_CENTRAL_DIRECTORY_SIGNATURE) {
                            EocdRecord readEocdRecord = readEocdRecord(buffer2);
                            String readUtf8 = buffer2.readUtf8(readEocdRecord.getCommentByteCount());
                            buffer2.close();
                            long j = size - 20;
                            if (j > 0) {
                                BufferedSource buffer3 = Okio.buffer(openReadOnly.source(j));
                                try {
                                    if (buffer3.readIntLe() == ZIP64_LOCATOR_SIGNATURE) {
                                        int readIntLe = buffer3.readIntLe();
                                        long readLongLe = buffer3.readLongLe();
                                        if (buffer3.readIntLe() == 1 && readIntLe == 0) {
                                            buffer = Okio.buffer(openReadOnly.source(readLongLe));
                                            try {
                                                int readIntLe2 = buffer.readIntLe();
                                                if (readIntLe2 == ZIP64_EOCD_RECORD_SIGNATURE) {
                                                    readEocdRecord = readZip64EocdRecord(buffer, readEocdRecord);
                                                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                                                    kotlin.io.II0xO0.oIX0oI(buffer, null);
                                                } else {
                                                    throw new IOException("bad zip: expected " + getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(readIntLe2));
                                                }
                                            } finally {
                                            }
                                        } else {
                                            throw new IOException("unsupported zip: spanned");
                                        }
                                    }
                                    oXIO0o0XI oxio0o0xi2 = oXIO0o0XI.f29392oIX0oI;
                                    kotlin.io.II0xO0.oIX0oI(buffer3, null);
                                } finally {
                                }
                            }
                            ArrayList arrayList = new ArrayList();
                            buffer = Okio.buffer(openReadOnly.source(readEocdRecord.getCentralDirectoryOffset()));
                            try {
                                long entryCount = readEocdRecord.getEntryCount();
                                for (long j2 = 0; j2 < entryCount; j2++) {
                                    ZipEntry readEntry = readEntry(buffer);
                                    if (readEntry.getOffset() < readEocdRecord.getCentralDirectoryOffset()) {
                                        if (predicate.invoke(readEntry).booleanValue()) {
                                            arrayList.add(readEntry);
                                        }
                                    } else {
                                        throw new IOException("bad zip: local file header offset >= central directory offset");
                                    }
                                }
                                oXIO0o0XI oxio0o0xi3 = oXIO0o0XI.f29392oIX0oI;
                                kotlin.io.II0xO0.oIX0oI(buffer, null);
                                ZipFileSystem zipFileSystem = new ZipFileSystem(zipPath, fileSystem, buildIndex(arrayList), readUtf8);
                                kotlin.io.II0xO0.oIX0oI(openReadOnly, null);
                                return zipFileSystem;
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } finally {
                                    kotlin.io.II0xO0.oIX0oI(buffer, th);
                                }
                            }
                        }
                        buffer2.close();
                        size--;
                    } finally {
                        buffer2.close();
                    }
                } while (size >= max);
                throw new IOException("not a zip: end of central directory signature not found");
            }
            throw new IOException("not a zip: size=" + openReadOnly.size());
        } finally {
        }
    }

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, oOoXoXO oooxoxo, int i, Object obj) throws IOException {
        if ((i & 4) != 0) {
            oooxoxo = new oOoXoXO<ZipEntry, Boolean>() { // from class: okio.internal.ZipFilesKt$openZip$1
                @Override // Oox.oOoXoXO
                @OOXIXo
                public final Boolean invoke(@OOXIXo ZipEntry it) {
                    IIX0o.x0xO0oo(it, "it");
                    return Boolean.TRUE;
                }
            };
        }
        return openZip(path, fileSystem, oooxoxo);
    }

    @OOXIXo
    public static final ZipEntry readEntry(@OOXIXo final BufferedSource bufferedSource) throws IOException {
        long j;
        long j2;
        IIX0o.x0xO0oo(bufferedSource, "<this>");
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == CENTRAL_FILE_HEADER_SIGNATURE) {
            bufferedSource.skip(4L);
            short readShortLe = bufferedSource.readShortLe();
            int i = readShortLe & OX00O0xII.f29066Oxx0xo;
            if ((readShortLe & 1) == 0) {
                int readShortLe2 = bufferedSource.readShortLe() & OX00O0xII.f29066Oxx0xo;
                Long dosDateTimeToEpochMillis = dosDateTimeToEpochMillis(bufferedSource.readShortLe() & OX00O0xII.f29066Oxx0xo, bufferedSource.readShortLe() & OX00O0xII.f29066Oxx0xo);
                long readIntLe2 = bufferedSource.readIntLe() & 4294967295L;
                final Ref.LongRef longRef = new Ref.LongRef();
                longRef.element = bufferedSource.readIntLe() & 4294967295L;
                final Ref.LongRef longRef2 = new Ref.LongRef();
                longRef2.element = bufferedSource.readIntLe() & 4294967295L;
                int readShortLe3 = bufferedSource.readShortLe() & OX00O0xII.f29066Oxx0xo;
                int readShortLe4 = bufferedSource.readShortLe() & OX00O0xII.f29066Oxx0xo;
                int readShortLe5 = bufferedSource.readShortLe() & OX00O0xII.f29066Oxx0xo;
                bufferedSource.skip(8L);
                final Ref.LongRef longRef3 = new Ref.LongRef();
                longRef3.element = bufferedSource.readIntLe() & 4294967295L;
                String readUtf8 = bufferedSource.readUtf8(readShortLe3);
                if (!StringsKt__StringsKt.xXo(readUtf8, (char) 0, false, 2, null)) {
                    if (longRef2.element == 4294967295L) {
                        j = 8;
                    } else {
                        j = 0;
                    }
                    if (longRef.element == 4294967295L) {
                        j2 = j + 8;
                    } else {
                        j2 = j;
                    }
                    if (longRef3.element == 4294967295L) {
                        j2 += 8;
                    }
                    final long j3 = j2;
                    final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    readExtra(bufferedSource, readShortLe4, new x0xO0oo<Integer, Long, oXIO0o0XI>() { // from class: okio.internal.ZipFilesKt$readEntry$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // Oox.x0xO0oo
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, Long l) {
                            invoke(num.intValue(), l.longValue());
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(int i2, long j4) {
                            if (i2 == 1) {
                                Ref.BooleanRef booleanRef2 = Ref.BooleanRef.this;
                                if (!booleanRef2.element) {
                                    booleanRef2.element = true;
                                    if (j4 >= j3) {
                                        Ref.LongRef longRef4 = longRef2;
                                        long j5 = longRef4.element;
                                        if (j5 == BleWatchFaceId.WATCHFACE_ID_INVALID) {
                                            j5 = bufferedSource.readLongLe();
                                        }
                                        longRef4.element = j5;
                                        Ref.LongRef longRef5 = longRef;
                                        longRef5.element = longRef5.element == BleWatchFaceId.WATCHFACE_ID_INVALID ? bufferedSource.readLongLe() : 0L;
                                        Ref.LongRef longRef6 = longRef3;
                                        longRef6.element = longRef6.element == BleWatchFaceId.WATCHFACE_ID_INVALID ? bufferedSource.readLongLe() : 0L;
                                        return;
                                    }
                                    throw new IOException("bad zip: zip64 extra too short");
                                }
                                throw new IOException("bad zip: zip64 extra repeated");
                            }
                        }
                    });
                    if (j3 > 0 && !booleanRef.element) {
                        throw new IOException("bad zip: zip64 extra required but absent");
                    }
                    return new ZipEntry(Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null).resolve(readUtf8), OxI.XO0o(readUtf8, "/", false, 2, null), bufferedSource.readUtf8(readShortLe5), readIntLe2, longRef.element, longRef2.element, readShortLe2, dosDateTimeToEpochMillis, longRef3.element);
                }
                throw new IOException("bad zip: filename contains 0x00");
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(i));
        }
        throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) throws IOException {
        int readShortLe = bufferedSource.readShortLe() & OX00O0xII.f29066Oxx0xo;
        int readShortLe2 = bufferedSource.readShortLe() & OX00O0xII.f29066Oxx0xo;
        long readShortLe3 = bufferedSource.readShortLe() & OX00O0xII.f29066Oxx0xo;
        if (readShortLe3 == (bufferedSource.readShortLe() & OX00O0xII.f29066Oxx0xo) && readShortLe == 0 && readShortLe2 == 0) {
            bufferedSource.skip(4L);
            return new EocdRecord(readShortLe3, 4294967295L & bufferedSource.readIntLe(), bufferedSource.readShortLe() & OX00O0xII.f29066Oxx0xo);
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final void readExtra(BufferedSource bufferedSource, int i, x0xO0oo<? super Integer, ? super Long, oXIO0o0XI> x0xo0oo) {
        long j = i;
        while (j != 0) {
            if (j >= 4) {
                int readShortLe = bufferedSource.readShortLe() & OX00O0xII.f29066Oxx0xo;
                long readShortLe2 = bufferedSource.readShortLe() & 65535;
                long j2 = j - 4;
                if (j2 >= readShortLe2) {
                    bufferedSource.require(readShortLe2);
                    long size = bufferedSource.getBuffer().size();
                    x0xo0oo.invoke(Integer.valueOf(readShortLe), Long.valueOf(readShortLe2));
                    long size2 = (bufferedSource.getBuffer().size() + readShortLe2) - size;
                    if (size2 >= 0) {
                        if (size2 > 0) {
                            bufferedSource.getBuffer().skip(size2);
                        }
                        j = j2 - readShortLe2;
                    } else {
                        throw new IOException("unsupported zip: too many bytes processed for " + readShortLe);
                    }
                } else {
                    throw new IOException("bad zip: truncated value in extra field");
                }
            } else {
                throw new IOException("bad zip: truncated header in extra field");
            }
        }
    }

    @OOXIXo
    public static final FileMetadata readLocalHeader(@OOXIXo BufferedSource bufferedSource, @OOXIXo FileMetadata basicMetadata) {
        IIX0o.x0xO0oo(bufferedSource, "<this>");
        IIX0o.x0xO0oo(basicMetadata, "basicMetadata");
        FileMetadata readOrSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, basicMetadata);
        IIX0o.ooOOo0oXI(readOrSkipLocalHeader);
        return readOrSkipLocalHeader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final FileMetadata readOrSkipLocalHeader(final BufferedSource bufferedSource, FileMetadata fileMetadata) {
        T t;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (fileMetadata != null) {
            t = fileMetadata.getLastModifiedAtMillis();
        } else {
            t = 0;
        }
        objectRef.element = t;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == LOCAL_FILE_HEADER_SIGNATURE) {
            bufferedSource.skip(2L);
            short readShortLe = bufferedSource.readShortLe();
            int i = readShortLe & OX00O0xII.f29066Oxx0xo;
            if ((readShortLe & 1) == 0) {
                bufferedSource.skip(18L);
                int readShortLe2 = bufferedSource.readShortLe() & OX00O0xII.f29066Oxx0xo;
                bufferedSource.skip(bufferedSource.readShortLe() & 65535);
                if (fileMetadata == null) {
                    bufferedSource.skip(readShortLe2);
                    return null;
                }
                readExtra(bufferedSource, readShortLe2, new x0xO0oo<Integer, Long, oXIO0o0XI>() { // from class: okio.internal.ZipFilesKt$readOrSkipLocalHeader$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // Oox.x0xO0oo
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, Long l) {
                        invoke(num.intValue(), l.longValue());
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* JADX WARN: Type inference failed for: r0v13, types: [T, java.lang.Long] */
                    /* JADX WARN: Type inference failed for: r0v17, types: [T, java.lang.Long] */
                    /* JADX WARN: Type inference failed for: r10v3, types: [T, java.lang.Long] */
                    public final void invoke(int i2, long j) {
                        if (i2 == 21589) {
                            if (j >= 1) {
                                byte readByte = BufferedSource.this.readByte();
                                boolean z = (readByte & 1) == 1;
                                boolean z2 = (readByte & 2) == 2;
                                boolean z3 = (readByte & 4) == 4;
                                BufferedSource bufferedSource2 = BufferedSource.this;
                                long j2 = z ? 5L : 1L;
                                if (z2) {
                                    j2 += 4;
                                }
                                if (z3) {
                                    j2 += 4;
                                }
                                if (j < j2) {
                                    throw new IOException("bad zip: extended timestamp extra too short");
                                }
                                if (z) {
                                    objectRef.element = Long.valueOf(bufferedSource2.readIntLe() * 1000);
                                }
                                if (z2) {
                                    objectRef2.element = Long.valueOf(BufferedSource.this.readIntLe() * 1000);
                                }
                                if (z3) {
                                    objectRef3.element = Long.valueOf(BufferedSource.this.readIntLe() * 1000);
                                    return;
                                }
                                return;
                            }
                            throw new IOException("bad zip: extended timestamp extra too short");
                        }
                    }
                });
                return new FileMetadata(fileMetadata.isRegularFile(), fileMetadata.isDirectory(), null, fileMetadata.getSize(), (Long) objectRef3.element, (Long) objectRef.element, (Long) objectRef2.element, null, 128, null);
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(i));
        }
        throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12L);
        int readIntLe = bufferedSource.readIntLe();
        int readIntLe2 = bufferedSource.readIntLe();
        long readLongLe = bufferedSource.readLongLe();
        if (readLongLe == bufferedSource.readLongLe() && readIntLe == 0 && readIntLe2 == 0) {
            bufferedSource.skip(8L);
            return new EocdRecord(readLongLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
        }
        throw new IOException("unsupported zip: spanned");
    }

    public static final void skipLocalHeader(@OOXIXo BufferedSource bufferedSource) {
        IIX0o.x0xO0oo(bufferedSource, "<this>");
        readOrSkipLocalHeader(bufferedSource, null);
    }
}
