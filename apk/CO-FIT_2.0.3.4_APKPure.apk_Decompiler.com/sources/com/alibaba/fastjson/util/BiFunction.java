package com.alibaba.fastjson.util;

public interface BiFunction<T, U, R> {
    R apply(T t, U u);
}
