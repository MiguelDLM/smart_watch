package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HTTP;
import java.io.Serializable;
import java.nio.CharBuffer;

/* loaded from: classes10.dex */
public final class CharArrayBuffer implements CharSequence, Serializable {
    private static final long serialVersionUID = -6208952725094867135L;
    private char[] buffer;
    private int len;

    public CharArrayBuffer(int i) {
        Args.notNegative(i, "Buffer capacity");
        this.buffer = new char[i];
    }

    private void expand(int i) {
        char[] cArr = new char[Math.max(this.buffer.length << 1, i)];
        System.arraycopy(this.buffer, 0, cArr, 0, this.len);
        this.buffer = cArr;
    }

    public void append(char[] cArr, int i, int i2) {
        int i3;
        if (cArr == null) {
            return;
        }
        if (i < 0 || i > cArr.length || i2 < 0 || (i3 = i + i2) < 0 || i3 > cArr.length) {
            throw new IndexOutOfBoundsException("off: " + i + " len: " + i2 + " b.length: " + cArr.length);
        }
        if (i2 == 0) {
            return;
        }
        int i4 = this.len + i2;
        if (i4 > this.buffer.length) {
            expand(i4);
        }
        System.arraycopy(cArr, i, this.buffer, this.len, i2);
        this.len = i4;
    }

    public char[] buffer() {
        return this.buffer;
    }

    public int capacity() {
        return this.buffer.length;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.buffer[i];
    }

    public void clear() {
        this.len = 0;
    }

    public void ensureCapacity(int i) {
        if (i <= 0) {
            return;
        }
        int length = this.buffer.length;
        int i2 = this.len;
        if (i > length - i2) {
            expand(i2 + i);
        }
    }

    public int indexOf(int i, int i2, int i3) {
        if (i2 < 0) {
            i2 = 0;
        }
        int i4 = this.len;
        if (i3 > i4) {
            i3 = i4;
        }
        if (i2 > i3) {
            return -1;
        }
        while (i2 < i3) {
            if (this.buffer[i2] == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.len == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (this.len == this.buffer.length) {
            return true;
        }
        return false;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.len;
    }

    public void setLength(int i) {
        if (i >= 0 && i <= this.buffer.length) {
            this.len = i;
            return;
        }
        throw new IndexOutOfBoundsException("len: " + i + " < 0 or > buffer len: " + this.buffer.length);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        if (i >= 0) {
            if (i2 <= this.len) {
                if (i <= i2) {
                    return CharBuffer.wrap(this.buffer, i, i2);
                }
                throw new IndexOutOfBoundsException("beginIndex: " + i + " > endIndex: " + i2);
            }
            throw new IndexOutOfBoundsException("endIndex: " + i2 + " > length: " + this.len);
        }
        throw new IndexOutOfBoundsException("Negative beginIndex: " + i);
    }

    public String substring(int i, int i2) {
        if (i >= 0) {
            if (i2 <= this.len) {
                if (i <= i2) {
                    return new String(this.buffer, i, i2 - i);
                }
                throw new IndexOutOfBoundsException("beginIndex: " + i + " > endIndex: " + i2);
            }
            throw new IndexOutOfBoundsException("endIndex: " + i2 + " > length: " + this.len);
        }
        throw new IndexOutOfBoundsException("Negative beginIndex: " + i);
    }

    public String substringTrimmed(int i, int i2) {
        if (i >= 0) {
            if (i2 <= this.len) {
                if (i <= i2) {
                    while (i < i2 && HTTP.isWhitespace(this.buffer[i])) {
                        i++;
                    }
                    while (i2 > i && HTTP.isWhitespace(this.buffer[i2 - 1])) {
                        i2--;
                    }
                    return new String(this.buffer, i, i2 - i);
                }
                throw new IndexOutOfBoundsException("beginIndex: " + i + " > endIndex: " + i2);
            }
            throw new IndexOutOfBoundsException("endIndex: " + i2 + " > length: " + this.len);
        }
        throw new IndexOutOfBoundsException("Negative beginIndex: " + i);
    }

    public char[] toCharArray() {
        int i = this.len;
        char[] cArr = new char[i];
        if (i > 0) {
            System.arraycopy(this.buffer, 0, cArr, 0, i);
        }
        return cArr;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return new String(this.buffer, 0, this.len);
    }

    public int indexOf(int i) {
        return indexOf(i, 0, this.len);
    }

    public void append(String str) {
        if (str == null) {
            str = "null";
        }
        int length = str.length();
        int i = this.len + length;
        if (i > this.buffer.length) {
            expand(i);
        }
        str.getChars(0, length, this.buffer, this.len);
        this.len = i;
    }

    public void append(CharArrayBuffer charArrayBuffer, int i, int i2) {
        if (charArrayBuffer == null) {
            return;
        }
        append(charArrayBuffer.buffer, i, i2);
    }

    public void append(CharArrayBuffer charArrayBuffer) {
        if (charArrayBuffer == null) {
            return;
        }
        append(charArrayBuffer.buffer, 0, charArrayBuffer.len);
    }

    public void append(char c) {
        int i = this.len + 1;
        if (i > this.buffer.length) {
            expand(i);
        }
        this.buffer[this.len] = c;
        this.len = i;
    }

    public void append(byte[] bArr, int i, int i2) {
        int i3;
        if (bArr == null) {
            return;
        }
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) < 0 || i3 > bArr.length) {
            throw new IndexOutOfBoundsException("off: " + i + " len: " + i2 + " b.length: " + bArr.length);
        }
        if (i2 == 0) {
            return;
        }
        int i4 = this.len;
        int i5 = i2 + i4;
        if (i5 > this.buffer.length) {
            expand(i5);
        }
        while (i4 < i5) {
            this.buffer[i4] = (char) (bArr[i] & 255);
            i++;
            i4++;
        }
        this.len = i5;
    }

    public void append(ByteArrayBuffer byteArrayBuffer, int i, int i2) {
        if (byteArrayBuffer == null) {
            return;
        }
        append(byteArrayBuffer.buffer(), i, i2);
    }

    public void append(Object obj) {
        append(String.valueOf(obj));
    }
}
