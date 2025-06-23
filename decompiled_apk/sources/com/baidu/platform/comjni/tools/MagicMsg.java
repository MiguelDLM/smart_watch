package com.baidu.platform.comjni.tools;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* loaded from: classes8.dex */
public class MagicMsg extends MessageMicro {
    public byte[] buffer;

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        return 0;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        return 0;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public MessageMicro mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return null;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
    }
}
