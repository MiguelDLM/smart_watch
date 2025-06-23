package com.alimm.tanx.core.ad.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.tanx.core.ad.listener.bean.IMaterialBean;

public class CreativeItem extends BaseBean implements IMaterialBean {
    @JSONField(name = "action_text")
    private String actionText;
    @JSONField(name = "adv_logo")
    private String advLogo;
    @JSONField(name = "adv_name")
    private String advName;
    private String description;
    @JSONField(name = "img_url_height")
    private String imageHeight;
    @JSONField(name = "img_url_md5")
    private String imageMd5;
    @JSONField(name = "img_size")
    private String imageSize;
    @JSONField(name = "img_url")
    private String imageUrl;
    @JSONField(name = "img_url_width")
    private String imageWidth;
    @JSONField(name = "img_height")
    private String imgHeight;
    @JSONField(name = "img_sm")
    private String imgSm;
    @JSONField(name = "img_sm_height")
    private String imgSmHeight;
    @JSONField(name = "img_sm_md5")
    private String imgSmMd5;
    @JSONField(name = "img_sm_width")
    private String imgSmWidth;
    @JSONField(name = "img_width")
    private String imgWidth;
    @JSONField(name = "title")
    private String title;
    @JSONField(name = "video")
    private String video;
    @JSONField(name = "video_duration")
    private String videoDuration;
    @JSONField(name = "video_height")
    private String videoHeight;
    @JSONField(name = "video_md5")
    private String videoMd5;
    @JSONField(name = "video_width")
    private String videoWidth;

    public String getActionText() {
        return this.actionText;
    }

    public String getAdvLogo() {
        return this.advLogo;
    }

    public String getAdvName() {
        return this.advName;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImageHeight() {
        return this.imageHeight;
    }

    public String getImageMd5() {
        return this.imageMd5;
    }

    public String getImageSize() {
        return this.imageSize;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImageWidth() {
        return this.imageWidth;
    }

    public String getImgHeight() {
        return this.imgHeight;
    }

    public String getImgSm() {
        return this.imgSm;
    }

    public String getImgSmHeight() {
        return this.imgSmHeight;
    }

    public String getImgSmMd5() {
        return this.imgSmMd5;
    }

    public String getImgSmWidth() {
        return this.imgSmWidth;
    }

    public String getImgWidth() {
        return this.imgWidth;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVideo() {
        return this.video;
    }

    public String getVideoDuration() {
        return this.videoDuration;
    }

    public String getVideoHeight() {
        return this.videoHeight;
    }

    public String getVideoMd5() {
        return this.videoMd5;
    }

    public String getVideoWidth() {
        return this.videoWidth;
    }

    public void setActionText(String str) {
        this.actionText = str;
    }

    public void setAdvLogo(String str) {
        this.advLogo = str;
    }

    public void setAdvName(String str) {
        this.advName = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setImageHeight(String str) {
        this.imageHeight = str;
    }

    public void setImageMd5(String str) {
        this.imageMd5 = str;
    }

    public void setImageSize(String str) {
        this.imageSize = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setImageWidth(String str) {
        this.imageWidth = str;
    }

    public void setImgHeight(String str) {
        this.imgHeight = str;
    }

    public void setImgSm(String str) {
        this.imgSm = str;
    }

    public void setImgSmHeight(String str) {
        this.imgSmHeight = str;
    }

    public void setImgSmMd5(String str) {
        this.imgSmMd5 = str;
    }

    public void setImgSmWidth(String str) {
        this.imgSmWidth = str;
    }

    public void setImgWidth(String str) {
        this.imgWidth = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVideo(String str) {
        this.video = str;
    }

    public void setVideoDuration(String str) {
        this.videoDuration = str;
    }

    public void setVideoHeight(String str) {
        this.videoHeight = str;
    }

    public void setVideoMd5(String str) {
        this.videoMd5 = str;
    }

    public void setVideoWidth(String str) {
        this.videoWidth = str;
    }
}
