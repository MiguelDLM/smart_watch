package com.alimm.tanx.core.orange.bean;

import com.alimm.tanx.core.ad.bean.BaseBean;
import java.util.HashMap;
import java.util.List;

public class OrangeBean extends BaseBean {
    public HashMap<String, Boolean> adSwitch = new HashMap<>();
    public HashMap<String, String> commonSwitch = new HashMap<>();
    public List<ExposureConfigBean> exposureConfig;
    public HashMap<String, String> feedInteractionParam = new HashMap<>();
    public H5CacheBean h5CacheBean;
    public HashMap<String, Boolean> imageSwitch = new HashMap<>();
    public HashMap<String, Boolean> installStatusSwitch = new HashMap<>();
    public HashMap<String, Long> threshold = new HashMap<>();
    public OrangeUtBean ut;
    public int version = 0;
    public List<WebConfigBean> webConfigBeanList;
    public HashMap<String, Boolean> webSuffixWhiteList = new HashMap<>();
}
