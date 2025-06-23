package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Charsets;
import com.google.firebase.crashlytics.buildtools.utils.io.ByteReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes10.dex */
public class DebugLineStateMachine {
    private static final int EXTENDED_OPCODE = 0;
    private boolean _dwarf64 = false;
    private static final DebugLineOpcode[] STANDARD_OPCODES = {null, new StandardOpcodeCopy(), new StandardOpcodeAdvancePC(), new StandardOpcodeAdvanceLine(), new StandardOpcodeSetFile(), new StandardOpcodeSetColumn(), new StandardOpcodeNegateStatement(), new StandardOpcodeSetBasicBlock(), new StandardOpcodeConstAddPC(), new StandardOpcodeFixedAdvancePC(), new StandardOpcodeSetPrologueEnd(), new StandardOpcodeSetEpilogueBegin(), new StandardOpcodeSetIsa()};
    private static final DebugLineOpcode[] EXTENDED_OPCODES = {null, new ExtendedOpcodeEndSequence(), new ExtendedOpcodeSetAddress(), new ExtendedOpcodeDefineFile(), new ExtendedOpcodeSetDiscriminator()};

    /* JADX WARN: Multi-variable type inference failed */
    private DebugLineContext configureContext(ByteReader byteReader, long j, int i) throws IOException {
        int i2;
        byte b;
        boolean z;
        int readInt = byteReader.readInt(2);
        if (this._dwarf64) {
            i2 = 8;
        } else {
            i2 = 4;
        }
        long readLong = byteReader.readLong(i2);
        byte readByte = byteReader.readByte();
        if (readInt >= 4) {
            b = byteReader.readByte();
        } else {
            b = 1;
        }
        if (byteReader.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        byte readByte2 = byteReader.readByte();
        byte readByte3 = byteReader.readByte();
        int readByte4 = byteReader.readByte();
        byte[] bArr = new byte[readByte4];
        for (int i3 = 1; i3 < readByte4; i3++) {
            bArr[i3] = byteReader.readByte();
        }
        DebugLineContext debugLineContext = new DebugLineContext(new DebugLineHeader(j, readInt, readLong, readByte, b, z, readByte2, readByte3, readByte4, bArr), new DebugLineRegisters(z), i);
        String readNullTerminatedString = byteReader.readNullTerminatedString(Charsets.UTF_8);
        while (readNullTerminatedString.length() > 0) {
            debugLineContext.defineDirectory(readNullTerminatedString);
            readNullTerminatedString = byteReader.readNullTerminatedString(Charsets.UTF_8);
        }
        String readNullTerminatedString2 = byteReader.readNullTerminatedString(Charsets.UTF_8);
        while (readNullTerminatedString2.length() > 0) {
            debugLineContext.defineFile(readNullTerminatedString2, byteReader.readULEB128(), byteReader.readULEB128(), byteReader.readULEB128());
            readNullTerminatedString2 = byteReader.readNullTerminatedString(Charsets.UTF_8);
        }
        return debugLineContext;
    }

    private static DebugLineOpcode getOpcode(int i, DebugLineOpcode[] debugLineOpcodeArr) throws DwarfException {
        if (i >= 0 && i < debugLineOpcodeArr.length) {
            return debugLineOpcodeArr[i];
        }
        throw new DwarfException("Unknown opcode: " + i);
    }

    private static boolean processOpcode(DebugLineContext debugLineContext, ByteReader byteReader) throws IOException, DwarfException {
        DebugLineOpcode opcode;
        int readInt = byteReader.readInt(1);
        if (readInt >= 0) {
            if (readInt >= debugLineContext.header.opcodeBase) {
                opcode = new SpecialOpcode(readInt);
            } else if (readInt == 0) {
                byteReader.readULEB128();
                opcode = getOpcode(byteReader.readInt(1), EXTENDED_OPCODES);
            } else {
                opcode = getOpcode(readInt, STANDARD_OPCODES);
            }
            return opcode.process(debugLineContext, byteReader);
        }
        throw new DwarfException("Could not process opcode " + readInt);
    }

    private static List<DebugLineEntry> readCompilationUnit(DebugLineContext debugLineContext, ByteReader byteReader, long j) throws IOException, DwarfException {
        LinkedList linkedList = new LinkedList();
        while (byteReader.getCurrentOffset() < j) {
            if (processOpcode(debugLineContext, byteReader)) {
                DebugLineRegisters debugLineRegisters = debugLineContext.reg;
                linkedList.add(new DebugLineEntry(debugLineRegisters.address, debugLineContext.getFileInfo(debugLineRegisters.file).name, debugLineContext.reg.line));
            }
            DebugLineRegisters debugLineRegisters2 = debugLineContext.reg;
            if (debugLineRegisters2.isEndSequence) {
                debugLineRegisters2.reset();
            }
        }
        return linkedList;
    }

    private long readInitialLength(ByteReader byteReader) throws IOException {
        long readLong = byteReader.readLong(4);
        if (readLong == -1) {
            this._dwarf64 = true;
            return byteReader.readLong(8);
        }
        return readLong;
    }

    public List<DebugLineEntry> runForIndex(ByteReader byteReader, int i, long j, int i2) throws IOException, DwarfException {
        for (int i3 = 0; i3 < i; i3++) {
            if (byteReader.getCurrentOffset() < j) {
                byteReader.seek(readInitialLength(byteReader) + byteReader.getCurrentOffset());
            } else {
                throw new DwarfException("Unable to set appropriate line number section offset");
            }
        }
        return runFromCurrentOffset(byteReader, i2);
    }

    public List<DebugLineEntry> runFromCurrentOffset(ByteReader byteReader, int i) throws IOException, DwarfException {
        long readInitialLength = readInitialLength(byteReader);
        return readCompilationUnit(configureContext(byteReader, readInitialLength, i), byteReader, byteReader.getCurrentOffset() + readInitialLength);
    }
}
