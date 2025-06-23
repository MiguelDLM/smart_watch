package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor;

import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DWAttribute;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DWForm;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DebugAbbrevEntry;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.CompilationUnitContext;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Charsets;
import com.google.firebase.crashlytics.buildtools.utils.io.ByteReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class DefaultAttributesReader<T> implements AttributesReader<T> {
    private final AttributeProcessor<T> attributeProcessor;
    private final CompilationUnitContext.Header cuHeader;
    private final long debugStrOffset;
    private final ByteReader reader;
    private final ReferenceBytesConverter referenceBytesConverter;

    /* renamed from: com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.DefaultAttributesReader$1, reason: invalid class name */
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
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.REF1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.REF2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.REF4.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.REF8.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.REF_UDATA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.REF_ADDR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.SEC_OFFSET.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.BLOCK1.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.BLOCK2.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.BLOCK4.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.BLOCK.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.EXPRLOC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.DATA1.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.DATA2.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.DATA4.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.DATA8.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.REF_SIG8.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.SDATA.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.UDATA.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.FLAG.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.FLAG_PRESENT.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.STRING.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[DWForm.STRP.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
        }
    }

    public DefaultAttributesReader(ByteReader byteReader, CompilationUnitContext.Header header, ReferenceBytesConverter referenceBytesConverter, AttributeProcessor<T> attributeProcessor, long j) {
        this.reader = byteReader;
        this.cuHeader = header;
        this.referenceBytesConverter = referenceBytesConverter;
        this.attributeProcessor = attributeProcessor;
        this.debugStrOffset = j;
    }

    private static void processDebugInfoEntryAttribute(ByteReader byteReader, CompilationUnitContext.Header header, ReferenceBytesConverter referenceBytesConverter, DebugAbbrevEntry.Attribute attribute, AttributeProcessor attributeProcessor, long j) throws IOException {
        int i;
        switch (AnonymousClass1.$SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWForm[attribute.form.ordinal()]) {
            case 1:
                attributeProcessor.processAttribute(attribute.name, byteReader.readLong(header.addressSize));
                return;
            case 2:
                attributeProcessor.processAttribute(attribute.name, referenceBytesConverter.asLongValue(byteReader.readBytes(1)) + header.offset);
                return;
            case 3:
                attributeProcessor.processAttribute(attribute.name, referenceBytesConverter.asLongValue(byteReader.readBytes(2)) + header.offset);
                return;
            case 4:
                attributeProcessor.processAttribute(attribute.name, referenceBytesConverter.asLongValue(byteReader.readBytes(4)) + header.offset);
                return;
            case 5:
                attributeProcessor.processAttribute(attribute.name, referenceBytesConverter.asLongValue(byteReader.readBytes(8)) + header.offset);
                return;
            case 6:
                attributeProcessor.processAttribute(attribute.name, byteReader.readULEB128() + header.offset);
                return;
            case 7:
                DWAttribute dWAttribute = attribute.name;
                if (header.version < 3) {
                    i = header.addressSize;
                } else {
                    i = header.referenceSize;
                }
                attributeProcessor.processAttribute(dWAttribute, byteReader.readLong(i));
                return;
            case 8:
                attributeProcessor.processAttribute(attribute.name, byteReader.readLong(header.referenceSize));
                return;
            case 9:
                attributeProcessor.processAttribute(attribute.name, attribute.form, readBytesWithBlockSize(byteReader, 1));
                return;
            case 10:
                attributeProcessor.processAttribute(attribute.name, attribute.form, readBytesWithBlockSize(byteReader, 2));
                return;
            case 11:
                attributeProcessor.processAttribute(attribute.name, attribute.form, readBytesWithBlockSize(byteReader, 4));
                return;
            case 12:
            case 13:
                attributeProcessor.processAttribute(attribute.name, attribute.form, readBytesWithBlockSize(byteReader));
                return;
            case 14:
                attributeProcessor.processAttribute(attribute.name, attribute.form, byteReader.readBytes(1));
                return;
            case 15:
                attributeProcessor.processAttribute(attribute.name, attribute.form, byteReader.readBytes(2));
                return;
            case 16:
                attributeProcessor.processAttribute(attribute.name, attribute.form, byteReader.readBytes(4));
                return;
            case 17:
            case 18:
                attributeProcessor.processAttribute(attribute.name, attribute.form, byteReader.readBytes(8));
                return;
            case 19:
                attributeProcessor.processAttribute(attribute.name, byteReader.readSLEB128());
                return;
            case 20:
                attributeProcessor.processAttribute(attribute.name, byteReader.readULEB128());
                return;
            case 21:
                attributeProcessor.processAttribute(attribute.name, byteReader.readLong(1));
                return;
            case 22:
                attributeProcessor.processAttribute(attribute.name, 1L);
                return;
            case 23:
                attributeProcessor.processAttribute(attribute.name, byteReader.readNullTerminatedString(Charsets.UTF_8));
                return;
            case 24:
                attributeProcessor.processAttribute(attribute.name, readStringFromTable(byteReader, header.referenceSize, j));
                return;
            default:
                attributeProcessor.processAttribute(attribute.name, 0L);
                return;
        }
    }

    private static byte[] readBytesWithBlockSize(ByteReader byteReader, int i) throws IOException {
        return byteReader.readBytes(byteReader.readInt(i));
    }

    private static String readStringFromTable(ByteReader byteReader, int i, long j) throws IOException {
        long readLong = byteReader.readLong(i);
        long currentOffset = byteReader.getCurrentOffset();
        byteReader.seek(j + readLong);
        String readNullTerminatedString = byteReader.readNullTerminatedString(Charsets.UTF_8);
        byteReader.seek(currentOffset);
        return readNullTerminatedString;
    }

    @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.AttributesReader
    public T readAttributes(List<DebugAbbrevEntry.Attribute> list) throws IOException {
        Iterator<DebugAbbrevEntry.Attribute> it = list.iterator();
        while (it.hasNext()) {
            processDebugInfoEntryAttribute(this.reader, this.cuHeader, this.referenceBytesConverter, it.next(), this.attributeProcessor, this.debugStrOffset);
        }
        return this.attributeProcessor.finishProcessingAttributes();
    }

    private static byte[] readBytesWithBlockSize(ByteReader byteReader) throws IOException {
        return byteReader.readBytes(byteReader.readULEB128());
    }
}
