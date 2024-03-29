package com.stone.photoindustry.core.common.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

@SuppressWarnings("deprecation")
public class HttpsUtil
{

	private static final Logger logger = Logger.getLogger(HttpsUtil.class);

	public static final String HTTPS_PROTOCOL_SCHEME = "https";

	public static final int DEFAULT_PORT_NUMBER_FOR_HTTPS = 443;

	private static final String CHARSET = "UTF-8";

	private static final int TIMEOUT = 60000;

	public static String postClient(String postUrl, Map<String, String> requestParams)
	{
		return postClient(postUrl, requestParams, CHARSET, TIMEOUT);
	}

	public static String postClient(String postUrl, Map<String, String> requestParams, int timeout)
	{
		return postClient(postUrl, requestParams, CHARSET, timeout);
	}

	@SuppressWarnings("resource")
	public static String postClient(String postUrl, Map<String, String> requestParams, String charset, int timeout)
	{
		HttpClient httpClient = new DefaultHttpClient();

		try
		{
			SSLContext ctx = SSLContext.getInstance(SSLSocketFactory.TLS);
			ctx.init(null, new TrustManager[] { new HttpsX509TrustManager() }, null);
			SSLSocketFactory sslSocketFactory = new SSLSocketFactory(ctx);

			httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme(HttpsUtil.HTTPS_PROTOCOL_SCHEME, sslSocketFactory, HttpsUtil.DEFAULT_PORT_NUMBER_FOR_HTTPS));

			HttpPost httpPost = new HttpPost(postUrl);
			// 设置请求和传输时长
			Builder builder = RequestConfig.custom();
			builder.setSocketTimeout(timeout);
			builder.setConnectTimeout(timeout);
			RequestConfig config = builder.build();
			httpPost.setConfig(config);
			// 初始化请求参数
			List<NameValuePair> formParams = convert2NameValuePair(requestParams);
			if (!formParams.isEmpty())
			{
				httpPost.setEntity(new UrlEncodedFormEntity(formParams, charset));
			}
			// 发送请求
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			String responseContent = "";
			if (entity != null)
			{
				responseContent = EntityUtils.toString(entity, charset);
				entity.consumeContent();
			}
			logger.info("HtppsUtil发送请求状态码为：" + response.getStatusLine().getStatusCode() + "通知参数:" + responseContent);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
			{
				if (StringUtil.isBlank(responseContent))
				{
					// 请求成功，但无参数返回
					return "3000";
				}

				return responseContent;
			} else
			{
				// 请求状态不为200
				return "3001";
			}
		} catch (NoSuchAlgorithmException noSuex)
		{
			logger.info("请求发送失败，NoSuchAlgorithmException原因：", noSuex);
			// 请求出现异常
			return "3003";
		} catch (KeyManagementException keyMaEx)
		{
			logger.info("请求发送失败，KeyManagementException原因：秘钥异常", keyMaEx);
			// 请求出现异常
			return "3003";
		} catch (UnsupportedEncodingException unsuEx)
		{
			logger.info("请求发送失败，UnsupportedEncodingException原因：", unsuEx);
			// 请求出现异常
			return "3003";
		} catch (ClientProtocolException clPrEx)
		{
			logger.info("请求发送失败，ClientProtocolException原因：", clPrEx);
			// 请求出现异常
			return "3003";
		} catch (SocketTimeoutException e)
		{
			logger.info("请求发送失败，SocketTimeoutException原因：", e);
			// 请求超时
			return "3002";
		} catch (IOException ioEx)
		{
			logger.info("请求发送失败，ClientProtocolException原因：", ioEx);
			// 请求出现异常
			return "3003";
		} finally
		{
			httpClient.getConnectionManager().shutdown();
		}
	}

	private static List<NameValuePair> convert2NameValuePair(Map<String, String> requestParams)
	{
		if (requestParams == null || requestParams.isEmpty())
		{
			return null;
		}

		List<NameValuePair> formParams = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> entry : requestParams.entrySet())
		{
			formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		return formParams;
	}

	private static class HttpsX509TrustManager implements X509TrustManager
	{
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException
		{
			// 不校验服务器端证书，什么都不做，视为通过检查
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException
		{
			// 不校验服务器端证书，什么都不做，视为通过检查
		}

		public X509Certificate[] getAcceptedIssuers()
		{
			return new X509Certificate[] {};
		}
	}

	public static String getClient(String postUrl)
	{
		return getClient(postUrl, CHARSET, TIMEOUT);
	}

	@SuppressWarnings("resource")
	public static String getClient(String postUrl, String charset, int timeout)
	{
		HttpClient httpClient = new DefaultHttpClient();

		try
		{
			SSLContext ctx = SSLContext.getInstance(SSLSocketFactory.TLS);
			ctx.init(null, new TrustManager[] { new HttpsX509TrustManager() }, null);
			SSLSocketFactory sslSocketFactory = new SSLSocketFactory(ctx);

			httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme(HttpsUtil.HTTPS_PROTOCOL_SCHEME, sslSocketFactory, HttpsUtil.DEFAULT_PORT_NUMBER_FOR_HTTPS));

			HttpGet httpGet = new HttpGet(postUrl);

			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();

			String responseContent = "";
			if (entity != null)
			{
				responseContent = EntityUtils.toString(entity, charset);
				entity.consumeContent();
			}

			return responseContent;
		} catch (NoSuchAlgorithmException noSuex)
		{
			logger.info("请求发送失败，NoSuchAlgorithmException原因：", noSuex);
			// 请求出现异常
			return "3003";
		} catch (KeyManagementException keyMaEx)
		{
			logger.info("请求发送失败，KeyManagementException原因：", keyMaEx);
			// 请求出现异常
			return "3003";
		} catch (UnsupportedEncodingException unsuEx)
		{
			logger.info("请求发送失败，UnsupportedEncodingException原因：", unsuEx);
			// 请求出现异常
			return "3003";
		} catch (ClientProtocolException clPrEx)
		{
			logger.info("请求发送失败，ClientProtocolException原因：", clPrEx);
			// 请求出现异常
			return "3003";
		} catch (IOException ioEx)
		{
			logger.info("请求发送失败，ClientProtocolException原因：", ioEx);
			// 请求出现异常
			return "3003";
		} finally
		{
			httpClient.getConnectionManager().shutdown();
		}
	}

	public static String postStrClient(String postUrl, String jonStr)
	{
		return postStrClient(postUrl, jonStr, CHARSET, TIMEOUT);
	}

	public static String postStrClient(String postUrl, String jonStr, int timeout)
	{
		return postStrClient(postUrl, jonStr, CHARSET, timeout);
	}

	@SuppressWarnings("resource")
	public static String postStrClient(String postUrl, String jonStr, String charset, int timeout)
	{
		HttpClient httpClient = new DefaultHttpClient();
		try
		{
			SSLContext ctx = SSLContext.getInstance(SSLSocketFactory.TLS);
			ctx.init(null, new TrustManager[] { new HttpsX509TrustManager() }, null);
			SSLSocketFactory sslSocketFactory = new SSLSocketFactory(ctx);
			sslSocketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);// 运行所有的hostname验证
			httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme(HttpsUtil.HTTPS_PROTOCOL_SCHEME, sslSocketFactory, HttpsUtil.DEFAULT_PORT_NUMBER_FOR_HTTPS));

			HttpPost httpPost = new HttpPost(postUrl);
			// 设置请求和传输时长
			Builder builder = RequestConfig.custom();
			builder.setSocketTimeout(timeout);
			builder.setConnectTimeout(timeout);
			RequestConfig config = builder.build();
			httpPost.setConfig(config);
			httpPost.setHeader(HTTP.USER_AGENT, "httpcomponents");
			httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
			StringEntity stringEntiry = new StringEntity(jonStr, "utf-8");
			httpPost.setEntity(stringEntiry);

			// 发送请求
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			String responseContent = "";
			if (entity != null)
			{
				responseContent = EntityUtils.toString(entity, charset);
				entity.consumeContent();
			}
			logger.info("HtppsUtil发送请求状态码为：" + response.getStatusLine().getStatusCode() + "通知参数:" + responseContent);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
			{
				if (StringUtil.isBlank(responseContent))
				{
					// 请求成功，但无参数返回
					return "3000";
				}

				return responseContent;
			} else
			{
				// 请求状态不为200
				return "3001";
			}
		} catch (NoSuchAlgorithmException noSuex)
		{
			logger.info("请求发送失败，NoSuchAlgorithmException原因：", noSuex);
			// 请求出现异常
			return "3003";
		} catch (KeyManagementException keyMaEx)
		{
			logger.info("请求发送失败，KeyManagementException原因：秘钥异常", keyMaEx);
			// 请求出现异常
			return "3003";
		} catch (UnsupportedEncodingException unsuEx)
		{
			logger.info("请求发送失败，UnsupportedEncodingException原因：", unsuEx);
			// 请求出现异常
			return "3003";
		} catch (ClientProtocolException clPrEx)
		{
			logger.info("请求发送失败，ClientProtocolException原因：", clPrEx);
			// 请求出现异常
			return "3003";
		} catch (SocketTimeoutException e)
		{
			logger.info("请求发送失败，SocketTimeoutException原因：", e);
			// 请求超时
			return "3002";
		} catch (IOException ioEx)
		{
			logger.info("请求发送失败，ClientProtocolException原因：", ioEx);
			// 请求出现异常
			return "3003";
		} finally
		{
			httpClient.getConnectionManager().shutdown();
		}
	}

}
