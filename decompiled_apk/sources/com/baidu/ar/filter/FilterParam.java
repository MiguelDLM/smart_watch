package com.baidu.ar.filter;

import com.garmin.fit.xOxOoo;

/* loaded from: classes7.dex */
public interface FilterParam {

    /* renamed from: com.baidu.ar.filter.FilterParam$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] ru;

        static {
            int[] iArr = new int[MeshFilter.values().length];
            ru = iArr;
            try {
                iArr[MeshFilter.highlight.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public enum AdvanceBeautyFilter implements FilterParam {
        retouch("retouch"),
        eyeball("eyeball"),
        eyemazing("eyemazing"),
        teeth("teeth");

        private final String mParamName;

        AdvanceBeautyFilter(String str) {
            this.mParamName = str;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public FilterNode getFilterNode() {
            return FilterNode.advanceBeautyFilter;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public String getParamName() {
            return this.mParamName;
        }
    }

    /* loaded from: classes7.dex */
    public enum FaceFilter implements FilterParam {
        babyFace("babyFace"),
        webCelebrityFace("cyberstarFace"),
        normalFace("naturalFace"),
        eye("eyeScale"),
        thinFace("faceThin"),
        chinHeight("chinHeight"),
        chinWidth("chinWidth"),
        faceWidth("faceWidth"),
        jawAngleWidth("jawEdgeWidth"),
        eyeDistance("eyeDistance"),
        eyeAngle("eyeAngle"),
        eyebrowDistance("eyebrowDistance"),
        mouthWidth("mouthWidth"),
        threeCounts("faceLength"),
        upCount("upperCountHeight"),
        middleCount("middleCountHeight"),
        downCount("lowerCountHeight"),
        noseWingWidth("noseWingWidth"),
        noseBridgeWidth("noseBridgeWidth"),
        noseWidth("noseWidth"),
        noseLength("noseLength"),
        cheekboneWidth("cheekboneWidth"),
        beautyJsonPath("json_path"),
        beautyJsonStr("json_str"),
        kneadJsonStr("knead_json_str"),
        beautyDebugDrawMode("face_beauty_filter/debug_draw_mode"),
        beautyReset("reset"),
        faceThinLR("faceThinLR"),
        faceThinC("faceThinC"),
        faceThinLRC("faceThinLRC"),
        faceThinLRCU("faceThinLRCU"),
        faceThinCRadius("faceThinCRadius"),
        faceThinLRRadius("faceThinLRRadius"),
        faceThinCCloseRadius("faceThinCCloseRadius"),
        faceThinCUpRadius("faceThinCUpRadius"),
        faceWidthRatio("faceWidthRatio"),
        faceWidth1Ratio("faceWidth1Ratio"),
        faceWidth2Ratio("faceWidth2Ratio"),
        faceWidthCURatio("faceWidthCURatio"),
        faceWidthCRatio("faceWidthCRatio"),
        faceWidthRadius("faceWidthRadius"),
        faceWidth1Radius("faceWidth1Radius"),
        faceWidth2Radius("faceWidth2Radius"),
        faceWidthCURadius("faceWidthCURadius"),
        faceWidthCRadius("faceWidthCRadius"),
        customLandmarkIndex("customLandmarkIndex"),
        globalScaleValue("globalScaleValue");

        private String mParamName;

        FaceFilter(String str) {
            this.mParamName = str;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public FilterNode getFilterNode() {
            return FilterNode.faceFilter;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public String getParamName() {
            return this.mParamName;
        }
    }

    /* loaded from: classes7.dex */
    public enum LutFilter implements FilterParam {
        lutFile("global_path"),
        lutIntensity("global_intensity");

        private String mParamName;

        LutFilter(String str) {
            this.mParamName = str;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public FilterNode getFilterNode() {
            return FilterNode.lutFilter;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public String getParamName() {
            return this.mParamName;
        }
    }

    /* loaded from: classes7.dex */
    public enum MakeupFilter implements FilterParam {
        lipsMask("lips_mask"),
        cheeks("cheeks"),
        eyebrow("eyebrow"),
        eyelash("eyelash"),
        eyeliner("eyeliner"),
        eyeshadow("eyeshadow"),
        highlight("highlight"),
        eyeball("eyeball"),
        lips("lips"),
        allMakeups("all_makeups"),
        beautyMakeupFilter("beauty_makeup_filter");

        private String mParamName;

        MakeupFilter(String str) {
            this.mParamName = str;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public FilterNode getFilterNode() {
            return FilterNode.makeupFilter;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public String getParamName() {
            return this.mParamName;
        }
    }

    /* loaded from: classes7.dex */
    public enum MeshFilter implements FilterParam {
        highlight(xOxOoo.f15467XI0IXoo);

        private String paramName;

        MeshFilter(String str) {
            this.paramName = str;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public FilterNode getFilterNode() {
            return AnonymousClass1.ru[ordinal()] != 1 ? FilterNode.unknown : FilterNode.highlightFilter;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public String getParamName() {
            return this.paramName;
        }
    }

    /* loaded from: classes7.dex */
    public enum SkinFilter implements FilterParam {
        whitenFile("res_path"),
        smooth("intensity_smooth"),
        whiten("intensity_white"),
        sharpness("intensity_sharpness"),
        enableFaceSmooth("use_face_mask_to_smooth"),
        enableFaceWhiten("use_face_mask_to_whiten"),
        blackEyeCircle("face_cover/intensity_red"),
        laughLine("face_cover/intensity_green");

        private String mParamName;

        SkinFilter(String str) {
            this.mParamName = str;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public FilterNode getFilterNode() {
            return FilterNode.skinFilter;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public String getParamName() {
            return this.mParamName;
        }
    }

    /* loaded from: classes7.dex */
    public enum TuneColorFilter implements FilterParam {
        toneFile("tone_curve_res_path"),
        brightness("intensity_brightness"),
        contrast("intensity_contrast"),
        saturation("intensity_saturation"),
        rgbPoints("rgb_curve_composite_points"),
        redPoints("red_curve_points"),
        greenPoints("green_curve_points"),
        bluePoints("blue_curve_points"),
        curve("intensity_curve"),
        hazeAtom("haze_atom"),
        hazeBlend("haze_blend");

        private final String mParamName;

        TuneColorFilter(String str) {
            this.mParamName = str;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public FilterNode getFilterNode() {
            return FilterNode.tuneColorFilter;
        }

        @Override // com.baidu.ar.filter.FilterParam
        public String getParamName() {
            return this.mParamName;
        }
    }

    FilterNode getFilterNode();

    String getParamName();
}
