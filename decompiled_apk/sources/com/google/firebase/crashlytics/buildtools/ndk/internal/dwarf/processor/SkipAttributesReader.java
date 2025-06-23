package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor;

import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DWForm;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DebugAbbrevEntry;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.CompilationUnitContext;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Charsets;
import com.google.firebase.crashlytics.buildtools.utils.io.ByteReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class SkipAttributesReader implements AttributesReader<Void> {
    private final CompilationUnitContext.Header cuHeader;
    private final ByteReader reader;

    /* renamed from: com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.SkipAttributesReader$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm;

        static {
            int[] iArr = new int[DWForm.values().length];
            $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm = iArr;
            try {
                iArr[DWForm.ADDR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.FLAG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.DATA1.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.REF1.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.REF2.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.DATA2.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.REF4.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.DATA4.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.REF8.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.DATA8.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.REF_SIG8.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.UDATA.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.REF_UDATA.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.REF_ADDR.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.SEC_OFFSET.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.STRP.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.BLOCK1.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.BLOCK2.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.BLOCK4.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.BLOCK.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.EXPRLOC.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.SDATA.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.STRING.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.FLAG_PRESENT.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
        }
    }

    public SkipAttributesReader(ByteReader byteReader, CompilationUnitContext.Header header) {
        this.reader = byteReader;
        this.cuHeader = header;
    }

    private static byte[] readBytesWithBlockSize(ByteReader byteReader, int i) throws IOException {
        return byteReader.readBytes(byteReader.readInt(i));
    }

    private static void skipDebugInfoEntryAttribute(ByteReader byteReader, DebugAbbrevEntry.Attribute attribute, CompilationUnitContext.Header header) throws IOException {
        int i;
        switch (AnonymousClass1.$SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[attribute.form.ordinal()]) {
            case 1:
                byteReader.readLong(header.addressSize);
                return;
            case 2:
            case 3:
            case 4:
                byteReader.readBytes(1);
                return;
            case 5:
            case 6:
                byteReader.readBytes(2);
                return;
            case 7:
            case 8:
                byteReader.readBytes(4);
                return;
            case 9:
            case 10:
            case 11:
                byteReader.readBytes(8);
                return;
            case 12:
            case 13:
                byteReader.readULEB128();
                return;
            case 14:
                if (header.version < 3) {
                    i = header.addressSize;
                } else {
                    i = header.referenceSize;
                }
                byteReader.readBytes(i);
                return;
            case 15:
            case 16:
                byteReader.readBytes(header.referenceSize);
                return;
            case 17:
                readBytesWithBlockSize(byteReader, 1);
                return;
            case 18:
                readBytesWithBlockSize(byteReader, 2);
                return;
            case 19:
                readBytesWithBlockSize(byteReader, 4);
                return;
            case 20:
            case 21:
                readBytesWithBlockSize(byteReader);
                return;
            case 22:
                byteReader.readSLEB128();
                return;
            case 23:
                byteReader.readNullTerminatedString(Charsets.UTF_8);
                return;
            default:
                return;
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.AttributesReader
    public /* bridge */ /* synthetic */ Void readAttributes(List list) throws IOException {
        return readAttributes2((List<DebugAbbrevEntry.Attribute>) list);
    }

    @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.AttributesReader
    /* renamed from: readAttributes, reason: avoid collision after fix types in other method */
    public Void readAttributes2(List<DebugAbbrevEntry.Attribute> list) throws IOException {
        Iterator<DebugAbbrevEntry.Attribute> it = list.iterator();
        while (it.hasNext()) {
            skipDebugInfoEntryAttribute(this.reader, it.next(), this.cuHeader);
        }
        return null;
    }

    private static byte[] readBytesWithBlockSize(ByteReader byteReader) throws IOException {
        return byteReader.readBytes(byteReader.readULEB128());
    }
}
