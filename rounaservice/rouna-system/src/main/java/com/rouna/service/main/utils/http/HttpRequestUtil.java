package com.rouna.service.main.utils.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;


public class HttpRequestUtil {
    static Logger logger = Logger.getLogger(HttpRequestUtil.class);
    private static HttpClient httpclient;

    public static String getHeaderValue(HttpClient httpClient, String url, String body, Map<String, String> headerMap, String headerKey) {

        logger.info("HttpRequestUitl excute metod begin!...........");
        logger.info("url:---------" + url);
        logger.info("body:---------" + body);
        HttpRequestBase base = null;
        HttpResponse httpResponse = null;
        HttpResponseVO response = new HttpResponseVO();
        String headerValue = null;
        try {
            StringEntity entity;
            base = new HttpPost(url);
            if (body != null && !body.equals("")) {
                entity = new StringEntity(body, "utf-8");
                ((HttpPost) base).setEntity(entity);
            }
            if (null != base) {
                base = setHeaders((HttpRequestBase) base, headerMap);
            }
            logger.info("httpclient excute begin!...........");
            httpResponse = httpClient.execute((HttpUriRequest) base);
            logger.info("httpclient excute end!...........");
            Integer resultCode = httpResponse.getStatusLine().getStatusCode();
            logger.info("resultCode:---------" + resultCode);
            headerValue = httpResponse.getFirstHeader(headerKey).getValue();
            EntityUtils.consume(httpResponse.getEntity());
        } catch (Exception var13) {
            logger.error("http request error! url:" + url, var13);
        } finally {
            if (base != null) {
                abortMethodConnection((HttpRequestBase) base);
            }
            logger.info("HttpRequestUitl excute metod end!...........");
        }
        return headerValue;
    }


    private static HttpRequestBase setHeaders(HttpRequestBase base, Map<String, String> headerMap) {
        base.setHeader("User-Agent", "Mozilla/4.0");
        base.setHeader("Content-type", "application/json");
        base.setHeader("Accept", "application/json");
        if (headerMap != null) {
            Iterator iterator = headerMap.keySet().iterator();

            while (iterator.hasNext()) {
                String name = ((String) iterator.next()).toString();
                String value = (String) headerMap.get(name);
                if (name != null) {
                    base.setHeader(name, value);
                }
            }
        }

        return base;
    }

    private static void abortMethodConnection(HttpRequestBase base) {
        base.abort();
    }


    public static synchronized HttpClient getClient() {
        if (httpclient == null) {
            RequestConfig config = RequestConfig.custom().setConnectTimeout(20000).setSocketTimeout(60000).build();
            httpclient = HttpClientBuilder.create().setMaxConnTotal(200).setMaxConnPerRoute(100).setUserAgent("Mozilla/5.0 (Windows NT 6.1)").setDefaultRequestConfig(config).disableAutomaticRetries().build();
        }

        return httpclient;
    }


    public static HttpClient getSSLClient() {
        try {
            SSLContext sslContext = (new SSLContextBuilder()).loadTrustMaterial((KeyStore) null, new TrustStrategy() {
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException var2) {
            logger.error("http getSSLClient error! ex:" + var2.getMessage());

        } catch (NoSuchAlgorithmException var3) {
            logger.error("http getSSLClient error! ex:" + var3.getMessage());

        } catch (KeyStoreException var4) {
            logger.error("http getSSLClient error! ex:" + var4.getMessage());

        }

        return HttpClients.createDefault();
    }
}
