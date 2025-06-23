package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor;

import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DWAttribute;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DWForm;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.CompilationUnitContext;

/* loaded from: classes10.dex */
public class CompileUnitAttributeProcessor implements AttributeProcessor<CompilationUnitContext.EntryData> {
    private long lowPc;
    private final ReferenceBytesConverter referenceBytesConverter;
    private long stmtList;

    /* renamed from: com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.CompileUnitAttributeProcessor$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWAttribute;

        static {
            int[] iArr = new int[DWAttribute.values().length];
            $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWAttribute = iArr;
            try {
                iArr[DWAttribute.STMT_LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWAttribute[DWAttribute.LOW_PC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public CompileUnitAttributeProcessor(ReferenceBytesConverter referenceBytesConverter) {
        this.referenceBytesConverter = referenceBytesConverter;
    }

    @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.AttributeProcessor
    public void processAttribute(DWAttribute dWAttribute, String str) {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.AttributeProcessor
    public CompilationUnitContext.EntryData finishProcessingAttributes() {
        return new CompilationUnitContext.EntryData(Long.valueOf(this.lowPc), Long.valueOf(this.stmtList));
    }

    @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.AttributeProcessor
    public void processAttribute(DWAttribute dWAttribute, DWForm dWForm, byte[] bArr) {
        if (AnonymousClass1.$SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWAttribute[dWAttribute.ordinal()] != 1) {
            return;
        }
        this.stmtList = this.referenceBytesConverter.asLongValue(bArr);
    }

    @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.AttributeProcessor
    public void processAttribute(DWAttribute dWAttribute, long j) {
        int i = AnonymousClass1.$SwitchMap$com$google$firebase$crashlytics$buildtools$ndk$internal$dwarf$DWAttribute[dWAttribute.ordinal()];
        if (i == 1) {
            this.stmtList = j;
        } else {
            if (i != 2) {
                return;
            }
            this.lowPc = j;
        }
    }
}
