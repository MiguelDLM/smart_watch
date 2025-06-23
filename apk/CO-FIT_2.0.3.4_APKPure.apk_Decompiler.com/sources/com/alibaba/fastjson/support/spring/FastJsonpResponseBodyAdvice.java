package com.alibaba.fastjson.support.spring;

import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.openalliance.ad.constant.bn;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
@Order(Integer.MIN_VALUE)
@Deprecated
public class FastJsonpResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    private static final Pattern CALLBACK_PARAM_PATTERN = Pattern.compile("[0-9A-Za-z_\\.]*");
    public static final String[] DEFAULT_JSONP_QUERY_PARAM_NAMES = {bn.f.L, "jsonp"};
    private final String[] jsonpQueryParamNames;

    public FastJsonpResponseBodyAdvice() {
        this.jsonpQueryParamNames = DEFAULT_JSONP_QUERY_PARAM_NAMES;
    }

    public Object beforeBodyWrite(Object obj, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> cls, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        MappingFastJsonValue orCreateContainer = getOrCreateContainer(obj);
        beforeBodyWriteInternal(orCreateContainer, mediaType, methodParameter, serverHttpRequest, serverHttpResponse);
        return orCreateContainer;
    }

    public void beforeBodyWriteInternal(MappingFastJsonValue mappingFastJsonValue, MediaType mediaType, MethodParameter methodParameter, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        HttpServletRequest servletRequest = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest();
        String[] strArr = this.jsonpQueryParamNames;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String parameter = servletRequest.getParameter(strArr[i]);
            if (parameter == null || !isValidJsonpQueryParam(parameter)) {
                i++;
            } else {
                mappingFastJsonValue.setJsonpFunction(parameter);
                return;
            }
        }
    }

    public MediaType getContentType(MediaType mediaType, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return new MediaType(MimeTypes.BASE_TYPE_APPLICATION, "javascript");
    }

    public MappingFastJsonValue getOrCreateContainer(Object obj) {
        if (obj instanceof MappingFastJsonValue) {
            return (MappingFastJsonValue) obj;
        }
        return new MappingFastJsonValue(obj);
    }

    public boolean isValidJsonpQueryParam(String str) {
        return CALLBACK_PARAM_PATTERN.matcher(str).matches();
    }

    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> cls) {
        return FastJsonHttpMessageConverter.class.isAssignableFrom(cls);
    }

    public FastJsonpResponseBodyAdvice(String... strArr) {
        Assert.isTrue(!ObjectUtils.isEmpty(strArr), "At least one query param name is required");
        this.jsonpQueryParamNames = strArr;
    }
}
