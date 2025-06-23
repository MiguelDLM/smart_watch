package com.baidu.ar;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* loaded from: classes7.dex */
public class j {
    private static final float[] dT;
    private static final short[] ed = {0, 1, 2, 0, 2, 3};
    private static final float[] ee = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
    private static final float[] ef = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
    private static final float[] eg = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    private FloatBuffer dU;
    private FloatBuffer dV;
    private ShortBuffer dW;
    private final int dX;
    private int dY;
    private int dZ;
    private int ea = -1;
    private int eb = -1;
    private int ec;
    private int eh;
    private int mHeight;
    private int mWidth;

    static {
        float[] fArr = new float[16];
        dT = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public j(int i, int i2) {
        this.eh = i;
        float[] fArr = ee;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.dU = asFloatBuffer;
        asFloatBuffer.put(fArr);
        this.dU.position(0);
        short[] sArr = ed;
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(sArr.length * 2);
        allocateDirect2.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect2.asShortBuffer();
        this.dW = asShortBuffer;
        asShortBuffer.put(sArr);
        this.dW.position(0);
        float[] fArr2 = eg;
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(fArr2.length * 4);
        allocateDirect3.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect3.asFloatBuffer();
        this.dV = asFloatBuffer2;
        asFloatBuffer2.put(fArr2);
        this.dV.position(0);
        int a2 = a(35633, "attribute vec4 vPosition;\nuniform mat4 uMVPMatrix;uniform mat4 uTextureMatrix;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvoid main()\n{\n  gl_Position = uMVPMatrix * vPosition;\n  textureCoordinate = (uTextureMatrix * inputTextureCoordinate).xy;\n}");
        String str = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, textureCoordinate );\n}";
        if (i2 != 0) {
            if (i2 == 1) {
                str = "precision mediump float;\nuniform sampler2D s_texture;\nvarying vec2 textureCoordinate;\nvoid main()\n{\n  gl_FragColor = texture2D(s_texture, textureCoordinate);\n}";
            } else if (i2 == 2) {
                str = "precision mediump float;\nuniform sampler2D s_texture;\nvarying vec2 textureCoordinate;\nvoid main()\n{\n  vec4 vCameraColor = texture2D(s_texture, textureCoordinate);\n  float fGrayColor = (0.3*vCameraColor.r + 0.59*vCameraColor.g + 0.11*vCameraColor.b);\n  gl_FragColor = vec4(fGrayColor, fGrayColor, fGrayColor, 1.0);\n}";
            }
        }
        int a3 = a(35632, str);
        int glCreateProgram = GLES20.glCreateProgram();
        this.dX = glCreateProgram;
        GLES20.glAttachShader(glCreateProgram, a2);
        GLES20.glAttachShader(glCreateProgram, a3);
        GLES20.glLinkProgram(glCreateProgram);
    }

    private int a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    public void c(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public void a(float[] fArr, float[] fArr2, int i, int i2) {
        if (fArr == null) {
            fArr = dT;
        }
        if (fArr2 == null) {
            fArr2 = dT;
        }
        GLES20.glBindFramebuffer(36160, i2);
        GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
        GLES20.glClear(16384);
        GLES20.glClearColor(1.0f, 1.0f, 0.0f, 1.0f);
        if (-1 == i) {
            return;
        }
        GLES20.glUseProgram(this.dX);
        this.ea = GLES20.glGetUniformLocation(this.dX, "uTextureMatrix");
        this.eb = GLES20.glGetUniformLocation(this.dX, "s_texture");
        this.ec = GLES20.glGetUniformLocation(this.dX, "uMVPMatrix");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.eh, i);
        GLES20.glUniform1i(this.eb, 0);
        int i3 = this.ec;
        if (i3 >= 0) {
            GLES20.glUniformMatrix4fv(i3, 1, false, fArr, 0);
        }
        int i4 = this.ea;
        if (i4 >= 0) {
            GLES20.glUniformMatrix4fv(i4, 1, false, fArr2, 0);
        }
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.dX, "vPosition");
        this.dY = glGetAttribLocation;
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(this.dY, 2, 5126, false, 8, (Buffer) this.dU);
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.dX, "inputTextureCoordinate");
        this.dZ = glGetAttribLocation2;
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        GLES20.glVertexAttribPointer(this.dZ, 2, 5126, false, 8, (Buffer) this.dV);
        GLES20.glDrawElements(4, ed.length, 5123, this.dW);
        GLES20.glDisableVertexAttribArray(this.dY);
        GLES20.glDisableVertexAttribArray(this.dZ);
        GLES20.glBindTexture(this.eh, 0);
        GLES20.glUseProgram(0);
        GLES20.glBindFramebuffer(36160, 0);
    }
}
