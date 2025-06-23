package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.common.HttpMethod;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.alibaba.sdk.android.oss.common.utils.HttpUtil;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.model.GeneratePresignedUrlRequest;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.log4j.spi.LocationInfo;

public class ObjectURLPresigner {
    private ClientConfiguration conf;
    private OSSCredentialProvider credentialProvider;
    private URI endpoint;

    public ObjectURLPresigner(URI uri, OSSCredentialProvider oSSCredentialProvider, ClientConfiguration clientConfiguration) {
        this.endpoint = uri;
        this.credentialProvider = oSSCredentialProvider;
        this.conf = clientConfiguration;
    }

    private String buildCanonicalHost(URI uri, String str, ClientConfiguration clientConfiguration) {
        String str2;
        String str3;
        String host = uri.getHost();
        String path = uri.getPath();
        int port = uri.getPort();
        if (port != -1) {
            str2 = String.valueOf(port);
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            str3 = host + ":" + str2;
        } else {
            str3 = host;
        }
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            if (OSSUtils.isOssOriginHost(host)) {
                str3 = str + FileUtils.FILE_EXTENSION_SEPARATOR + host;
            } else if (!OSSUtils.isInCustomCnameExcludeList(host, clientConfiguration.getCustomCnameExcludeList())) {
                try {
                    z = OSSUtils.isValidateIP(host);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (clientConfiguration.isPathStyleAccessEnable()) {
                z = true;
            } else {
                str3 = str + FileUtils.FILE_EXTENSION_SEPARATOR + host;
            }
        }
        if (clientConfiguration.isCustomPathPrefixEnable() && path != null) {
            str3 = str3 + path;
        }
        if (!z) {
            return str3;
        }
        return str3 + "/" + str;
    }

    public String presignConstrainedURL(GeneratePresignedUrlRequest generatePresignedUrlRequest) throws ClientException {
        OSSFederationToken oSSFederationToken;
        String str;
        String bucketName = generatePresignedUrlRequest.getBucketName();
        String key = generatePresignedUrlRequest.getKey();
        String valueOf = String.valueOf((DateUtil.getFixedSkewedTimeMillis() / 1000) + generatePresignedUrlRequest.getExpiration());
        HttpMethod method = generatePresignedUrlRequest.getMethod() != null ? generatePresignedUrlRequest.getMethod() : HttpMethod.GET;
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(method);
        requestMessage.setBucketName(bucketName);
        requestMessage.setObjectKey(key);
        requestMessage.setHeaders(generatePresignedUrlRequest.getHeaders());
        requestMessage.getHeaders().put("Date", valueOf);
        if (generatePresignedUrlRequest.getContentType() != null && !generatePresignedUrlRequest.getContentType().trim().equals("")) {
            requestMessage.getHeaders().put("Content-Type", generatePresignedUrlRequest.getContentType());
        }
        if (generatePresignedUrlRequest.getContentMD5() != null && !generatePresignedUrlRequest.getContentMD5().trim().equals("")) {
            requestMessage.getHeaders().put("Content-MD5", generatePresignedUrlRequest.getContentMD5());
        }
        if (generatePresignedUrlRequest.getQueryParameter() != null && generatePresignedUrlRequest.getQueryParameter().size() > 0) {
            for (Map.Entry next : generatePresignedUrlRequest.getQueryParameter().entrySet()) {
                requestMessage.getParameters().put(next.getKey(), next.getValue());
            }
        }
        if (generatePresignedUrlRequest.getProcess() != null && !generatePresignedUrlRequest.getProcess().trim().equals("")) {
            requestMessage.getParameters().put(RequestParameters.X_OSS_PROCESS, generatePresignedUrlRequest.getProcess());
        }
        OSSCredentialProvider oSSCredentialProvider = this.credentialProvider;
        if (oSSCredentialProvider instanceof OSSFederationCredentialProvider) {
            oSSFederationToken = ((OSSFederationCredentialProvider) oSSCredentialProvider).getValidFederationToken();
            requestMessage.getParameters().put(RequestParameters.SECURITY_TOKEN, oSSFederationToken.getSecurityToken());
        } else if (oSSCredentialProvider instanceof OSSStsTokenCredentialProvider) {
            oSSFederationToken = ((OSSStsTokenCredentialProvider) oSSCredentialProvider).getFederationToken();
            requestMessage.getParameters().put(RequestParameters.SECURITY_TOKEN, oSSFederationToken.getSecurityToken());
        } else {
            oSSFederationToken = null;
        }
        String buildCanonicalString = OSSUtils.buildCanonicalString(requestMessage);
        OSSCredentialProvider oSSCredentialProvider2 = this.credentialProvider;
        if ((oSSCredentialProvider2 instanceof OSSFederationCredentialProvider) || (oSSCredentialProvider2 instanceof OSSStsTokenCredentialProvider)) {
            str = OSSUtils.sign(oSSFederationToken.getTempAK(), oSSFederationToken.getTempSK(), buildCanonicalString);
        } else if (oSSCredentialProvider2 instanceof OSSPlainTextAKSKCredentialProvider) {
            str = OSSUtils.sign(((OSSPlainTextAKSKCredentialProvider) oSSCredentialProvider2).getAccessKeyId(), ((OSSPlainTextAKSKCredentialProvider) this.credentialProvider).getAccessKeySecret(), buildCanonicalString);
        } else if (oSSCredentialProvider2 instanceof OSSCustomSignerCredentialProvider) {
            str = ((OSSCustomSignerCredentialProvider) oSSCredentialProvider2).signContent(buildCanonicalString);
        } else {
            throw new ClientException("Unknown credentialProvider!");
        }
        String substring = str.split(":")[0].substring(4);
        String str2 = str.split(":")[1];
        String buildCanonicalHost = buildCanonicalHost(this.endpoint, bucketName, this.conf);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Expires", valueOf);
        linkedHashMap.put(RequestParameters.OSS_ACCESS_KEY_ID, substring);
        linkedHashMap.put(RequestParameters.SIGNATURE, str2);
        linkedHashMap.putAll(requestMessage.getParameters());
        String paramToQueryString = HttpUtil.paramToQueryString(linkedHashMap, "utf-8");
        return this.endpoint.getScheme() + "://" + buildCanonicalHost + "/" + HttpUtil.urlEncode(key, "utf-8") + LocationInfo.NA + paramToQueryString;
    }

    public String presignPublicURL(String str, String str2) {
        String buildCanonicalHost = buildCanonicalHost(this.endpoint, str, this.conf);
        return this.endpoint.getScheme() + "://" + buildCanonicalHost + "/" + HttpUtil.urlEncode(str2, "utf-8");
    }

    public String presignConstrainedURL(String str, String str2, long j) throws ClientException {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(str, str2);
        generatePresignedUrlRequest.setExpiration(j);
        return presignConstrainedURL(generatePresignedUrlRequest);
    }
}
