package com.iflytek.sparkchain.media.speech;

import XXO0.oIX0oI;
import com.iflytek.sparkchain.media.ifla.a;
import com.iflytek.sparkchain.utils.constants.ErrorCode;
import com.tenmeter.smlibrary.utils.FileUtils;

/* loaded from: classes10.dex */
public class SpeechError extends Exception {
    protected static final int TIP_ENGINE_NOT_INSTALLED = 29;
    public static final int TIP_ERROR_ALREADY_EXIST = 66;
    protected static final int TIP_ERROR_AUDIO_RECORD = 9;
    public static final int TIP_ERROR_AUTHID_NOT_AVAILABLE = 71;
    protected static final int TIP_ERROR_BROWSER_NOT_INSTALLED = 26;
    protected static final int TIP_ERROR_CLIENT = 8;
    protected static final int TIP_ERROR_EMPTY_UTTERANCE = 13;
    protected static final int TIP_ERROR_ENGINE_INIT_FAIL = 28;
    protected static final int TIP_ERROR_EXIST_UNLISTED_WORD = 42;
    protected static final int TIP_ERROR_FACE_IMAGE_FULL_LEFT = 44;
    protected static final int TIP_ERROR_FACE_IMAGE_FULL_RIGHT = 45;
    protected static final int TIP_ERROR_FACE_INVALID_MODEL = 51;
    protected static final int TIP_ERROR_FACE_OCCULTATION = 50;
    protected static final int TIP_ERROR_FILE_ACCESS = 14;
    protected static final int TIP_ERROR_FUSION_ENOUGH_DATA = 54;
    protected static final int TIP_ERROR_FUSION_INVALID_INPUT_TYPE = 52;
    protected static final int TIP_ERROR_FUSION_NO_ENOUGH_DATA = 53;
    public static final int TIP_ERROR_GROUP_EMPTY = 68;
    protected static final int TIP_ERROR_ILLUMINATION = 49;
    protected static final int TIP_ERROR_IMAGE_CLOCKWISE_WHIRL = 46;
    protected static final int TIP_ERROR_IMAGE_COUNTET_CLOCKWISE_WHIRL = 47;
    protected static final int TIP_ERROR_INSUFFICIENT_PERMISSIONS = 4;
    protected static final int TIP_ERROR_INTERRUPT = 27;
    protected static final int TIP_ERROR_INVALID_DATA = 20;
    protected static final int TIP_ERROR_INVALID_ENCODING = 12;
    protected static final int TIP_ERROR_INVALID_GRAMMAR = 21;
    protected static final int TIP_ERROR_INVALID_LOCAL_RESOURCE = 22;
    protected static final int TIP_ERROR_INVALID_PARAM = 7;
    protected static final int TIP_ERROR_INVALID_RESULT = 5;
    protected static final int TIP_ERROR_IN_USE = 19;
    public static final int TIP_ERROR_IVP_EXTRA_RGN_SOPPORT = 56;
    public static final int TIP_ERROR_IVP_GENERAL = 55;
    public static final int TIP_ERROR_IVP_MUCH_NOISE = 58;
    public static final int TIP_ERROR_IVP_NO_ENOUGH_AUDIO = 63;
    public static final int TIP_ERROR_IVP_TEXT_NOT_MATCH = 62;
    public static final int TIP_ERROR_IVP_TOO_LOW = 59;
    public static final int TIP_ERROR_IVP_TRUNCATED = 57;
    public static final int TIP_ERROR_IVP_UTTER_TOO_SHORT = 61;
    public static final int TIP_ERROR_IVP_ZERO_AUDIO = 60;
    protected static final int TIP_ERROR_LOGIN = 18;
    protected static final int TIP_ERROR_LOGIN_INVALID_PWD = 24;
    protected static final int TIP_ERROR_LOGIN_INVALID_USER = 23;
    protected static final int TIP_ERROR_MEMORY_WRANING = 16;
    public static final int TIP_ERROR_MODEL_IS_CREATING = 65;
    public static final int TIP_ERROR_MODEL_NOT_FOUND = 64;
    protected static final int TIP_ERROR_NET_EXPECTION = 3;
    protected static final int TIP_ERROR_NOISY_OR_SHORT_AUDIO = 36;
    protected static final int TIP_ERROR_NOT_FACE_IMAGE = 43;
    protected static final int TIP_ERROR_NOT_PAPER_DATA = 37;
    protected static final int TIP_ERROR_NO_CONTENT = 34;
    public static final int TIP_ERROR_NO_GROUP = 67;
    protected static final int TIP_ERROR_NO_MATCH = 10;
    protected static final int TIP_ERROR_NO_PICTURE = 33;
    public static final int TIP_ERROR_NO_USER = 69;
    protected static final int TIP_ERROR_OTHER_DATA_EXCEPTION = 40;
    public static final int TIP_ERROR_OVERFLOW_IN_GROUP = 70;
    protected static final int TIP_ERROR_PERMISSION_DENIED = 25;
    protected static final int TIP_ERROR_PLAY_MEDIA = 15;
    protected static final int TIP_ERROR_SERVER_CONNECT = 6;
    protected static final int TIP_ERROR_SILENT_OR_LOW_VOLUME = 35;
    protected static final int TIP_ERROR_SPEECH_TIMEOUT = 11;
    protected static final int TIP_ERROR_TEXT_OVERFLOW = 17;
    protected static final int TIP_ERROR_VALID_IMAGE_SIZE = 48;
    protected static final int TIP_ERROR_WRONG_AUDIO_FORMAT = 39;
    protected static final int TIP_ERROR_WRONG_PAPER_CONTENT = 38;
    protected static final int TIP_ERROR_WRONG_PAPER_FORMAT = 41;
    protected static final int TIP_INVALID_AUTHORIZATION = 32;
    protected static final int TIP_LOCAL_ENGINE_ERROR = 30;
    protected static final int TIP_NO_NETWORK = 1;
    protected static final int TIP_RESULT_TIMEOUT = 2;
    protected static final int TIP_SCRIPT_ERROR = 31;
    private static final long serialVersionUID = 4434424251478985596L;
    private String mDescription;
    private int mErrorCode;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0119, code lost:
    
        if (r7 == 11503) goto L116;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SpeechError(int r7) {
        /*
            Method dump skipped, instructions count: 590
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sparkchain.media.speech.SpeechError.<init>(int):void");
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorDescription() {
        return this.mDescription;
    }

    public String getHtmlDescription(boolean z) {
        String str = this.mDescription + "...";
        if (!z) {
            return str;
        }
        return ((str + "<br>(") + a.b(0) + ":") + this.mErrorCode + oIX0oI.I0Io.f4095I0Io;
    }

    public String getPlainDescription(boolean z) {
        String str = this.mDescription;
        if (!z) {
            return str;
        }
        return ((str + FileUtils.FILE_EXTENSION_SEPARATOR) + oIX0oI.I0Io.f4096II0xO0 + a.b(0) + ":") + this.mErrorCode + oIX0oI.I0Io.f4095I0Io;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getPlainDescription(true);
    }

    public SpeechError(int i, String str) {
        this(i);
    }

    public SpeechError(Exception exc) {
        this.mDescription = "";
        this.mErrorCode = ErrorCode.ERROR_UNKNOWN;
        this.mDescription = exc.toString();
    }

    public SpeechError(Throwable th, int i) {
        this(i);
        initCause(th);
    }
}
