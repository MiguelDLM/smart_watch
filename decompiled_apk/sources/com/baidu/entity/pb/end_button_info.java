package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* loaded from: classes7.dex */
public final class end_button_info extends MessageMicro {
    public static final int BACKGROUND_COLOR_FIELD_NUMBER = 8;
    public static final int BORDER_COLOR_FIELD_NUMBER = 7;
    public static final int BTN_TITLE_FIELD_NUMBER = 1;
    public static final int CITYID_FIELD_NUMBER = 6;
    public static final int CNAME_FIELD_NUMBER = 5;
    public static final int END_INPUT_FIELD_NUMBER = 2;
    public static final int SHOW_POINT_FIELD_NUMBER = 3;
    public static final int UID_FIELD_NUMBER = 4;
    private int backgroundColor_;
    private int borderColor_;
    private ByteStringMicro btnTitle_;
    private int cachedSize;
    private int cityid_;
    private ByteStringMicro cname_;
    private ByteStringMicro endInput_;
    private boolean hasBackgroundColor;
    private boolean hasBorderColor;
    private boolean hasBtnTitle;
    private boolean hasCityid;
    private boolean hasCname;
    private boolean hasEndInput;
    private boolean hasShowPoint;
    private boolean hasUid;
    private yellow_tip_point showPoint_;
    private ByteStringMicro uid_;

    public end_button_info() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.btnTitle_ = byteStringMicro;
        this.endInput_ = byteStringMicro;
        this.showPoint_ = null;
        this.uid_ = byteStringMicro;
        this.cname_ = byteStringMicro;
        this.cityid_ = 0;
        this.borderColor_ = 0;
        this.backgroundColor_ = 0;
        this.cachedSize = -1;
    }

    public static end_button_info parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new end_button_info().mergeFrom(codedInputStreamMicro);
    }

    public final end_button_info clear() {
        clearBtnTitle();
        clearEndInput();
        clearShowPoint();
        clearUid();
        clearCname();
        clearCityid();
        clearBorderColor();
        clearBackgroundColor();
        this.cachedSize = -1;
        return this;
    }

    public end_button_info clearBackgroundColor() {
        this.hasBackgroundColor = false;
        this.backgroundColor_ = 0;
        return this;
    }

    public end_button_info clearBorderColor() {
        this.hasBorderColor = false;
        this.borderColor_ = 0;
        return this;
    }

    public end_button_info clearBtnTitle() {
        this.hasBtnTitle = false;
        this.btnTitle_ = ByteStringMicro.EMPTY;
        return this;
    }

    public end_button_info clearCityid() {
        this.hasCityid = false;
        this.cityid_ = 0;
        return this;
    }

    public end_button_info clearCname() {
        this.hasCname = false;
        this.cname_ = ByteStringMicro.EMPTY;
        return this;
    }

    public end_button_info clearEndInput() {
        this.hasEndInput = false;
        this.endInput_ = ByteStringMicro.EMPTY;
        return this;
    }

    public end_button_info clearShowPoint() {
        this.hasShowPoint = false;
        this.showPoint_ = null;
        return this;
    }

    public end_button_info clearUid() {
        this.hasUid = false;
        this.uid_ = ByteStringMicro.EMPTY;
        return this;
    }

    public int getBackgroundColor() {
        return this.backgroundColor_;
    }

    public int getBorderColor() {
        return this.borderColor_;
    }

    public ByteStringMicro getBtnTitle() {
        return this.btnTitle_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getCityid() {
        return this.cityid_;
    }

    public ByteStringMicro getCname() {
        return this.cname_;
    }

    public ByteStringMicro getEndInput() {
        return this.endInput_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int computeBytesSize = hasBtnTitle() ? CodedOutputStreamMicro.computeBytesSize(1, getBtnTitle()) : 0;
        if (hasEndInput()) {
            computeBytesSize += CodedOutputStreamMicro.computeBytesSize(2, getEndInput());
        }
        if (hasShowPoint()) {
            computeBytesSize += CodedOutputStreamMicro.computeMessageSize(3, getShowPoint());
        }
        if (hasUid()) {
            computeBytesSize += CodedOutputStreamMicro.computeBytesSize(4, getUid());
        }
        if (hasCname()) {
            computeBytesSize += CodedOutputStreamMicro.computeBytesSize(5, getCname());
        }
        if (hasCityid()) {
            computeBytesSize += CodedOutputStreamMicro.computeInt32Size(6, getCityid());
        }
        if (hasBorderColor()) {
            computeBytesSize += CodedOutputStreamMicro.computeInt32Size(7, getBorderColor());
        }
        if (hasBackgroundColor()) {
            computeBytesSize += CodedOutputStreamMicro.computeInt32Size(8, getBackgroundColor());
        }
        this.cachedSize = computeBytesSize;
        return computeBytesSize;
    }

    public yellow_tip_point getShowPoint() {
        return this.showPoint_;
    }

    public ByteStringMicro getUid() {
        return this.uid_;
    }

    public boolean hasBackgroundColor() {
        return this.hasBackgroundColor;
    }

    public boolean hasBorderColor() {
        return this.hasBorderColor;
    }

    public boolean hasBtnTitle() {
        return this.hasBtnTitle;
    }

    public boolean hasCityid() {
        return this.hasCityid;
    }

    public boolean hasCname() {
        return this.hasCname;
    }

    public boolean hasEndInput() {
        return this.hasEndInput;
    }

    public boolean hasShowPoint() {
        return this.hasShowPoint;
    }

    public boolean hasUid() {
        return this.hasUid;
    }

    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public end_button_info mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                setBtnTitle(codedInputStreamMicro.readBytes());
            } else if (readTag == 18) {
                setEndInput(codedInputStreamMicro.readBytes());
            } else if (readTag == 26) {
                yellow_tip_point yellow_tip_pointVar = new yellow_tip_point();
                codedInputStreamMicro.readMessage(yellow_tip_pointVar);
                setShowPoint(yellow_tip_pointVar);
            } else if (readTag == 34) {
                setUid(codedInputStreamMicro.readBytes());
            } else if (readTag == 42) {
                setCname(codedInputStreamMicro.readBytes());
            } else if (readTag == 48) {
                setCityid(codedInputStreamMicro.readInt32());
            } else if (readTag == 56) {
                setBorderColor(codedInputStreamMicro.readInt32());
            } else if (readTag == 64) {
                setBackgroundColor(codedInputStreamMicro.readInt32());
            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                return this;
            }
        }
    }

    public end_button_info setBackgroundColor(int i) {
        this.hasBackgroundColor = true;
        this.backgroundColor_ = i;
        return this;
    }

    public end_button_info setBorderColor(int i) {
        this.hasBorderColor = true;
        this.borderColor_ = i;
        return this;
    }

    public end_button_info setBtnTitle(ByteStringMicro byteStringMicro) {
        this.hasBtnTitle = true;
        this.btnTitle_ = byteStringMicro;
        return this;
    }

    public end_button_info setCityid(int i) {
        this.hasCityid = true;
        this.cityid_ = i;
        return this;
    }

    public end_button_info setCname(ByteStringMicro byteStringMicro) {
        this.hasCname = true;
        this.cname_ = byteStringMicro;
        return this;
    }

    public end_button_info setEndInput(ByteStringMicro byteStringMicro) {
        this.hasEndInput = true;
        this.endInput_ = byteStringMicro;
        return this;
    }

    public end_button_info setShowPoint(yellow_tip_point yellow_tip_pointVar) {
        if (yellow_tip_pointVar == null) {
            return clearShowPoint();
        }
        this.hasShowPoint = true;
        this.showPoint_ = yellow_tip_pointVar;
        return this;
    }

    public end_button_info setUid(ByteStringMicro byteStringMicro) {
        this.hasUid = true;
        this.uid_ = byteStringMicro;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasBtnTitle()) {
            codedOutputStreamMicro.writeBytes(1, getBtnTitle());
        }
        if (hasEndInput()) {
            codedOutputStreamMicro.writeBytes(2, getEndInput());
        }
        if (hasShowPoint()) {
            codedOutputStreamMicro.writeMessage(3, getShowPoint());
        }
        if (hasUid()) {
            codedOutputStreamMicro.writeBytes(4, getUid());
        }
        if (hasCname()) {
            codedOutputStreamMicro.writeBytes(5, getCname());
        }
        if (hasCityid()) {
            codedOutputStreamMicro.writeInt32(6, getCityid());
        }
        if (hasBorderColor()) {
            codedOutputStreamMicro.writeInt32(7, getBorderColor());
        }
        if (hasBackgroundColor()) {
            codedOutputStreamMicro.writeInt32(8, getBackgroundColor());
        }
    }

    public static end_button_info parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (end_button_info) new end_button_info().mergeFrom(bArr);
    }
}
