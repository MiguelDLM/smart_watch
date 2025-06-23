package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.oxoX;

/* loaded from: classes13.dex */
public final class BleMusicControl extends BleWritable {

    @OOXIXo
    private final String mContent;

    @OOXIXo
    private final MusicAttr mMusicAttr;

    @OOXIXo
    private final MusicEntity mMusicEntity;

    public BleMusicControl(@OOXIXo MusicEntity mMusicEntity, @OOXIXo MusicAttr mMusicAttr, @OOXIXo String mContent) {
        IIX0o.x0xO0oo(mMusicEntity, "mMusicEntity");
        IIX0o.x0xO0oo(mMusicAttr, "mMusicAttr");
        IIX0o.x0xO0oo(mContent, "mContent");
        this.mMusicEntity = mMusicEntity;
        this.mMusicAttr = mMusicAttr;
        this.mContent = mContent;
    }

    public static /* synthetic */ BleMusicControl copy$default(BleMusicControl bleMusicControl, MusicEntity musicEntity, MusicAttr musicAttr, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            musicEntity = bleMusicControl.mMusicEntity;
        }
        if ((i & 2) != 0) {
            musicAttr = bleMusicControl.mMusicAttr;
        }
        if ((i & 4) != 0) {
            str = bleMusicControl.mContent;
        }
        return bleMusicControl.copy(musicEntity, musicAttr, str);
    }

    @OOXIXo
    public final MusicEntity component1() {
        return this.mMusicEntity;
    }

    @OOXIXo
    public final MusicAttr component2() {
        return this.mMusicAttr;
    }

    @OOXIXo
    public final String component3() {
        return this.mContent;
    }

    @OOXIXo
    public final BleMusicControl copy(@OOXIXo MusicEntity mMusicEntity, @OOXIXo MusicAttr mMusicAttr, @OOXIXo String mContent) {
        IIX0o.x0xO0oo(mMusicEntity, "mMusicEntity");
        IIX0o.x0xO0oo(mMusicAttr, "mMusicAttr");
        IIX0o.x0xO0oo(mContent, "mContent");
        return new BleMusicControl(mMusicEntity, mMusicAttr, mContent);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mMusicEntity.getMEntity());
        writeInt8(this.mMusicAttr.getMAttr());
        BleWritable.writeString$default(this, this.mContent, null, 2, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleMusicControl)) {
            return false;
        }
        BleMusicControl bleMusicControl = (BleMusicControl) obj;
        return this.mMusicEntity == bleMusicControl.mMusicEntity && this.mMusicAttr == bleMusicControl.mMusicAttr && IIX0o.Oxx0IOOO(this.mContent, bleMusicControl.mContent);
    }

    @OOXIXo
    public final String getMContent() {
        return this.mContent;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        byte[] bytes = this.mContent.getBytes(oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        return bytes.length + 2;
    }

    @OOXIXo
    public final MusicAttr getMMusicAttr() {
        return this.mMusicAttr;
    }

    @OOXIXo
    public final MusicEntity getMMusicEntity() {
        return this.mMusicEntity;
    }

    public int hashCode() {
        return (((this.mMusicEntity.hashCode() * 31) + this.mMusicAttr.hashCode()) * 31) + this.mContent.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "BleMusicControl(mMusicEntity=" + this.mMusicEntity + ", mMusicAttr=" + this.mMusicAttr + ", mContent='" + this.mContent + "')";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BleMusicControl(@OOXIXo MusicEntity musicEntity, @OOXIXo MusicAttr musicAttr, @OOXIXo List<String> contents) {
        this(musicEntity, musicAttr, CollectionsKt___CollectionsKt.OoIXo(contents, ",", null, null, 0, null, null, 62, null));
        IIX0o.x0xO0oo(musicEntity, "musicEntity");
        IIX0o.x0xO0oo(musicAttr, "musicAttr");
        IIX0o.x0xO0oo(contents, "contents");
    }
}
