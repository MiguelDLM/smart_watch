package com.alimm.tanx.core.orange.bean;

import com.alimm.tanx.core.ad.bean.BaseBean;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class OrangeBean extends BaseBean {
    public List<ExposureConfigBean> exposureConfig;
    public H5CacheBean h5CacheBean;
    public OrangeUtBean ut;
    public List<WebConfigBean> webConfigBeanList;
    public int version = 0;
    public HashMap<String, String> commonSwitch = new HashMap<>();
    public HashMap<String, Boolean> adSwitch = new HashMap<>();
    public HashMap<String, Long> threshold = new HashMap<>();
    public HashMap<String, Boolean> installStatusSwitch = new HashMap<>();
    public HashMap<String, String> feedInteractionParam = new HashMap<>();
    public HashMap<String, Boolean> imageSwitch = new HashMap<>();
    public HashMap<String, Boolean> webSuffixWhiteList = new HashMap<>();
}
