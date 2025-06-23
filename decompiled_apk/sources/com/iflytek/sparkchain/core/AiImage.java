package com.iflytek.sparkchain.core;

/* loaded from: classes10.dex */
public class AiImage extends a {
    public static String ENCODING_BMP = "bmp";
    public static String ENCODING_DEFAULT = "jpg";
    public static String ENCODING_JPEG = "jpeg";
    public static String ENCODING_JPG = "jpg";
    public static String ENCODING_PNG = "png";
    public static String ENCODING_TIFF = "tiff";
    public static String ENCODING_WEBP = "webp";

    /* loaded from: classes10.dex */
    public static class Holder extends AiDataHolder<Holder, AiImage> {
        private String encoding;

        private Holder(String str) {
            super(new AiImage(), str);
            this.encoding = AiImage.ENCODING_DEFAULT;
        }

        public Holder encoding(String str) {
            this.encoding = (String) update(this.encoding, str);
            return this;
        }

        @Override // com.iflytek.sparkchain.core.AiDataHolder
        public void paramSync(int i) {
            sync(i, "encoding", this.encoding.getBytes());
        }

        @Override // com.iflytek.sparkchain.core.AiDataHolder
        public c type() {
            return c.IMAGE;
        }
    }

    public static Holder get(String str) {
        return new Holder(str);
    }
}
