package x0;

import com.octopus.ad.internal.utilities.HttpErrorCode;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

/* loaded from: classes11.dex */
public class xI {

    /* renamed from: I0Io, reason: collision with root package name */
    public ByteArrayOutputStream f33788I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f33789II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public HttpErrorCode f33790X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public boolean f33791oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public Map<String, List<String>> f33792oxoX;

    public xI() {
    }

    public ByteArrayOutputStream I0Io() {
        return this.f33788I0Io;
    }

    public void II0XooXoX(ByteArrayOutputStream byteArrayOutputStream) {
        this.f33788I0Io = byteArrayOutputStream;
    }

    public Map<String, List<String>> II0xO0() {
        return this.f33792oxoX;
    }

    public void Oxx0IOOO(Map<String, List<String>> map) {
        this.f33792oxoX = map;
    }

    public boolean X0o0xo() {
        return this.f33791oIX0oI;
    }

    public void XO(HttpErrorCode httpErrorCode) {
        this.f33790X0o0xo = httpErrorCode;
    }

    public HttpErrorCode oIX0oI() {
        return this.f33790X0o0xo;
    }

    public String oxoX() {
        return this.f33789II0xO0;
    }

    public void xoIox(boolean z) {
        this.f33791oIX0oI = z;
    }

    public void xxIXOIIO(String str) {
        this.f33789II0xO0 = str;
    }

    public xI(boolean z, String str, Map<String, List<String>> map) {
        this.f33791oIX0oI = z;
        this.f33789II0xO0 = str;
        this.f33792oxoX = map;
    }

    public xI(boolean z, ByteArrayOutputStream byteArrayOutputStream, Map<String, List<String>> map) {
        this.f33791oIX0oI = z;
        this.f33788I0Io = byteArrayOutputStream;
        this.f33792oxoX = map;
    }
}
