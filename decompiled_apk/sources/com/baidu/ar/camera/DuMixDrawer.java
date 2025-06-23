package com.baidu.ar.camera;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* loaded from: classes7.dex */
public class DuMixDrawer {
    private static float[] nb = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
    private static float[] nc = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    private int dX;
    private FloatBuffer mS;
    private FloatBuffer mT;
    private ShortBuffer mV;
    private int nd;
    private int ne;
    private final String mQ = "attribute vec4 vPosition;uniform mat4 uMVPMatrix;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){gl_Position = uMVPMatrix * vPosition;textureCoordinate = inputTextureCoordinate;}";
    private final String mR = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 textureCoordinate;\nuniform samplerExternalOES inputTexture;\nvoid main() {  gl_FragColor = texture2D( inputTexture, textureCoordinate );\n}";
    private int[] mU = new int[1];
    private int[] mW = new int[1];
    private int dY = -1;
    private int dZ = -1;
    private int mX = -1;
    private int mY = -1;
    private short[] mZ = {0, 1, 2, 0, 2, 3};
    private final int na = 8;

    public DuMixDrawer(int i, int i2) {
        this.nd = i;
        this.ne = i2;
        cz();
    }

    private int a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    private void cz() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(nb.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.mS = asFloatBuffer;
        asFloatBuffer.put(nb);
        this.mS.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(nc.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        this.mT = asFloatBuffer2;
        asFloatBuffer2.put(nc);
        this.mT.position(0);
        GLES20.glGenBuffers(1, this.mU, 0);
        GLES20.glBindBuffer(34962, this.mU[0]);
        GLES20.glBufferData(34962, (nb.length * 4) + (nc.length * 4), null, 35044);
        GLES20.glBufferSubData(34962, 0, nb.length * 4, this.mS);
        GLES20.glBufferSubData(34962, nb.length * 4, nc.length * 4, this.mT);
        GLES20.glBindBuffer(34962, 0);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(this.mZ.length * 2);
        allocateDirect3.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect3.asShortBuffer();
        this.mV = asShortBuffer;
        asShortBuffer.put(this.mZ);
        this.mV.position(0);
        GLES20.glGenBuffers(1, this.mW, 0);
        GLES20.glBindBuffer(34963, this.mW[0]);
        GLES20.glBufferData(34963, this.mZ.length * 2, null, 35044);
        GLES20.glBufferSubData(34963, 0, this.mZ.length * 2, this.mV);
        GLES20.glBindBuffer(34963, 0);
        int a2 = a(35633, "attribute vec4 vPosition;uniform mat4 uMVPMatrix;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){gl_Position = uMVPMatrix * vPosition;textureCoordinate = inputTextureCoordinate;}");
        int a3 = a(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 textureCoordinate;\nuniform samplerExternalOES inputTexture;\nvoid main() {  gl_FragColor = texture2D( inputTexture, textureCoordinate );\n}");
        int glCreateProgram = GLES20.glCreateProgram();
        this.dX = glCreateProgram;
        GLES20.glAttachShader(glCreateProgram, a2);
        GLES20.glAttachShader(this.dX, a3);
        GLES20.glLinkProgram(this.dX);
        GLES20.glUseProgram(this.dX);
    }

    public void destroyGL() {
        GLES20.glUseProgram(0);
        GLES20.glFinish();
        GLES20.glDisableVertexAttribArray(this.dY);
        GLES20.glDisableVertexAttribArray(this.dZ);
        int[] iArr = this.mU;
        GLES20.glDeleteBuffers(iArr.length, iArr, 0);
        int[] iArr2 = this.mW;
        GLES20.glDeleteBuffers(iArr2.length, iArr2, 0);
    }

    public void draw(float[] fArr) {
        if (this.mY == -1) {
            this.mY = GLES20.glGetUniformLocation(this.dX, "inputTexture");
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(this.ne, this.nd);
            GLES20.glUniform1i(this.mY, 0);
        }
        if (this.mX == -1) {
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.dX, "uMVPMatrix");
            this.mX = glGetUniformLocation;
            GLES20.glUniformMatrix4fv(glGetUniformLocation, 1, false, fArr, 0);
        }
        if (this.dY == -1 || this.dZ == -1) {
            GLES20.glBindBuffer(34962, this.mU[0]);
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.dX, "vPosition");
            this.dY = glGetAttribLocation;
            GLES20.glEnableVertexAttribArray(glGetAttribLocation);
            GLES20.glVertexAttribPointer(this.dY, 2, 5126, false, 8, 0);
            int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.dX, "inputTextureCoordinate");
            this.dZ = glGetAttribLocation2;
            GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
            GLES20.glVertexAttribPointer(this.dZ, 2, 5126, false, 8, nb.length * 4);
            GLES20.glBindBuffer(34962, 0);
        }
        GLES20.glBindBuffer(34963, this.mW[0]);
        GLES20.glDrawElements(4, this.mZ.length, 5123, 0);
        GLES20.glBindBuffer(34963, 0);
    }
}
