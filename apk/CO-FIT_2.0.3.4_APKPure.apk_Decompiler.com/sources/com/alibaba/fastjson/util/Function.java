package com.alibaba.fastjson.util;

public interface Function<ARG, V> {
    V apply(ARG arg);
}
