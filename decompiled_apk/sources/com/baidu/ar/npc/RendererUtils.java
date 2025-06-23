package com.baidu.ar.npc;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes7.dex */
public class RendererUtils {
    private static final int FLOAT_SIZE_BYTES = 4;
    private static final String FRAGMENT_SHADER = "precision mediump float;\nuniform sampler2D tex_sampler;\nvarying vec2 v_texcoord;\nvoid main() {\n  gl_FragColor = texture2D(tex_sampler, v_texcoord);\n}\n";
    private static final String VERTEX_SHADER = "attribute vec4 a_position;\nattribute vec2 a_texcoord;\nvarying vec2 v_texcoord;\nvoid main() {\n  gl_Position = a_position;\n  v_texcoord = a_texcoord;\n}\n";
    private static final float[] TEX_VERTICES = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] POS_VERTICES = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* loaded from: classes7.dex */
    public static class RenderContext {
        private int posCoordHandle;
        private FloatBuffer posVertices;
        private int shaderProgram;
        private int texCoordHandle;
        private int texSamplerHandle;
        private FloatBuffer texVertices;
    }

    public static int createFBO(int i, int i2, int i3, int i4) {
        int[] iArr = new int[1];
        GLES20.glGenRenderbuffers(1, iArr, 0);
        GLES20.glBindRenderbuffer(36161, iArr[0]);
        GLES20.glRenderbufferStorage(36161, i4, i2, i3);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        GLES20.glBindFramebuffer(36160, iArr2[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, iArr[0]);
        GLES20.glBindFramebuffer(36160, 0);
        return iArr2[0];
    }

    public static RenderContext createProgram() {
        int loadShader;
        int loadShader2 = loadShader(35633, VERTEX_SHADER);
        if (loadShader2 == 0 || (loadShader = loadShader(35632, FRAGMENT_SHADER)) == 0) {
            return null;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, loadShader2);
            GLES20.glAttachShader(glCreateProgram, loadShader);
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(glCreateProgram);
                GLES20.glDeleteProgram(glCreateProgram);
                throw new RuntimeException("Could not link program: " + glGetProgramInfoLog);
            }
        }
        RenderContext renderContext = new RenderContext();
        renderContext.texSamplerHandle = GLES20.glGetUniformLocation(glCreateProgram, "tex_sampler");
        renderContext.texCoordHandle = GLES20.glGetAttribLocation(glCreateProgram, "a_texcoord");
        renderContext.posCoordHandle = GLES20.glGetAttribLocation(glCreateProgram, "a_position");
        renderContext.texVertices = createVerticesBuffer(TEX_VERTICES);
        renderContext.posVertices = createVerticesBuffer(POS_VERTICES);
        renderContext.shaderProgram = glCreateProgram;
        return renderContext;
    }

    public static int createTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private static FloatBuffer createVerticesBuffer(float[] fArr) {
        if (fArr.length == 8) {
            FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            asFloatBuffer.put(fArr).position(0);
            return asFloatBuffer;
        }
        throw new RuntimeException("Number of vertices should be four.");
    }

    private static int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
                GLES20.glDeleteShader(glCreateShader);
                throw new RuntimeException("Could not compile shader " + i + ":" + glGetShaderInfoLog);
            }
        }
        return glCreateShader;
    }

    public static void renderTexture(RenderContext renderContext, int i, int i2, int i3) {
        GLES20.glViewport(0, 0, i2, i3);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(renderContext.shaderProgram);
        GLES20.glDisable(2929);
        GLES20.glDisable(3042);
        GLES20.glVertexAttribPointer(renderContext.texCoordHandle, 2, 5126, false, 0, (Buffer) renderContext.texVertices);
        GLES20.glEnableVertexAttribArray(renderContext.texCoordHandle);
        GLES20.glVertexAttribPointer(renderContext.posCoordHandle, 2, 5126, false, 0, (Buffer) renderContext.posVertices);
        GLES20.glEnableVertexAttribArray(renderContext.posCoordHandle);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniform1i(renderContext.texSamplerHandle, 0);
        GLES20.glDrawArrays(5, 0, 4);
    }

    public static int createTexture(Bitmap bitmap) {
        int createTexture = createTexture();
        GLES20.glBindTexture(3553, createTexture);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        return createTexture;
    }

    public static int createTexture(int i, int i2) {
        int createTexture = createTexture();
        GLES20.glBindTexture(3553, createTexture);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        return createTexture;
    }
}
