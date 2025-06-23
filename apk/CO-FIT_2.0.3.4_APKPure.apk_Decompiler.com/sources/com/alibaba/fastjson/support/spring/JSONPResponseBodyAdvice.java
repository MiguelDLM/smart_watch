package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.support.spring.annotation.ResponseJSONP;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
@Order(Integer.MIN_VALUE)
public class JSONPResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    public final Log logger = LogFactory.getLog(getClass());

    /* JADX WARNING: type inference failed for: r11v9, types: [java.lang.annotation.Annotation] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object beforeBodyWrite(java.lang.Object r8, org.springframework.core.MethodParameter r9, org.springframework.http.MediaType r10, java.lang.Class<? extends org.springframework.http.converter.HttpMessageConverter<?>> r11, org.springframework.http.server.ServerHttpRequest r12, org.springframework.http.server.ServerHttpResponse r13) {
        /*
            r7 = this;
            java.lang.Class<com.alibaba.fastjson.support.spring.annotation.ResponseJSONP> r11 = com.alibaba.fastjson.support.spring.annotation.ResponseJSONP.class
            java.lang.annotation.Annotation r0 = r9.getMethodAnnotation(r11)
            com.alibaba.fastjson.support.spring.annotation.ResponseJSONP r0 = (com.alibaba.fastjson.support.spring.annotation.ResponseJSONP) r0
            if (r0 != 0) goto L_0x0015
            java.lang.Class r0 = r9.getContainingClass()
            java.lang.annotation.Annotation r11 = r0.getAnnotation(r11)
            r0 = r11
            com.alibaba.fastjson.support.spring.annotation.ResponseJSONP r0 = (com.alibaba.fastjson.support.spring.annotation.ResponseJSONP) r0
        L_0x0015:
            r11 = r12
            org.springframework.http.server.ServletServerHttpRequest r11 = (org.springframework.http.server.ServletServerHttpRequest) r11
            javax.servlet.http.HttpServletRequest r11 = r11.getServletRequest()
            java.lang.String r0 = r0.callback()
            java.lang.String r11 = r11.getParameter(r0)
            boolean r0 = com.alibaba.fastjson.util.IOUtils.isValidJsonpQueryParam(r11)
            if (r0 != 0) goto L_0x0049
            org.apache.commons.logging.Log r0 = r7.logger
            boolean r0 = r0.isDebugEnabled()
            if (r0 == 0) goto L_0x0048
            org.apache.commons.logging.Log r0 = r7.logger
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid jsonp parameter value:"
            r1.append(r2)
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r0.debug(r11)
        L_0x0048:
            r11 = 0
        L_0x0049:
            com.alibaba.fastjson.JSONPObject r6 = new com.alibaba.fastjson.JSONPObject
            r6.<init>(r11)
            r6.addParameter(r8)
            r0 = r7
            r1 = r6
            r2 = r10
            r3 = r9
            r4 = r12
            r5 = r13
            r0.beforeBodyWriteInternal(r1, r2, r3, r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.support.spring.JSONPResponseBodyAdvice.beforeBodyWrite(java.lang.Object, org.springframework.core.MethodParameter, org.springframework.http.MediaType, java.lang.Class, org.springframework.http.server.ServerHttpRequest, org.springframework.http.server.ServerHttpResponse):java.lang.Object");
    }

    public void beforeBodyWriteInternal(JSONPObject jSONPObject, MediaType mediaType, MethodParameter methodParameter, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
    }

    public MediaType getContentType(MediaType mediaType, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return FastJsonHttpMessageConverter.APPLICATION_JAVASCRIPT;
    }

    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> cls) {
        if (FastJsonHttpMessageConverter.class.isAssignableFrom(cls)) {
            Class<ResponseJSONP> cls2 = ResponseJSONP.class;
            if (methodParameter.getContainingClass().isAnnotationPresent(cls2) || methodParameter.hasMethodAnnotation(cls2)) {
                return true;
            }
        }
        return false;
    }
}
