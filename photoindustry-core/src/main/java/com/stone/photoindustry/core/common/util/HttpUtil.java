package com.stone.photoindustry.core.common.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.stone.photoindustry.core.common.constant.Constant;


public class HttpUtil
{

	private static final Logger logger = Logger.getLogger(HttpUtil.class);

	private static final String CHARSET = "UTF-8";

	private static final int TIMEOUT = 60000;

	private static Scanner scanner;

	public static String doGet(String url)
	{
		return send(url, null, false, "utf8");
	}

	public static String postClient(String clientURL, Map<String, String> params)
	{
		String resp = postClient(clientURL, params, CHARSET, TIMEOUT);
		return resp;
	}

	private static List<BasicNameValuePair> wrapParam(Map<String, String> params)
	{
		List<BasicNameValuePair> data = new ArrayList<BasicNameValuePair>();
		for (Entry<String, String> entry : params.entrySet())
		{
			String key = entry.getKey();
			String value = entry.getValue();
			data.add(new BasicNameValuePair(key, value));
		}
		return data;
	}

	public static String postClient(String clientURL, Map<String, String> params, String charset, int timeout)
	{
		HttpPost post = new HttpPost(clientURL);
		CloseableHttpClient client = HttpClients.createDefault();
		String result = "";
		try
		{
			// 参数封装
			List<BasicNameValuePair> paramsList = wrapParam(params);
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramsList, charset);

			// 设置请求和传输时长
			Builder builder = RequestConfig.custom();

			builder.setSocketTimeout(timeout);
			builder.setConnectTimeout(timeout);

			RequestConfig config = builder.build();

			post.setEntity(entity);
			post.setConfig(config);
			// 发起请求
			CloseableHttpResponse response = client.execute(post);
			HttpEntity httpEntity = response.getEntity();

			if (httpEntity != null)
			{
				result = EntityUtils.toString(httpEntity, charset);
			}
		} catch (SocketTimeoutException e)
		{
			result = initResult(Constant.TIMEOUT_CODE_VALUE, "请求超时");
			logger.info("请求发送失败，SocketTimeoutException原因：", e);
		} catch (ClientProtocolException e)
		{
			result = initResult(Constant.CLIENT_EXCEPTION_CODE_VALUE, "请求异常，ClientProtocolException");
			logger.info("请求发送失败，ClientProtocolException原因：", e);
		} catch (UnsupportedEncodingException e)
		{
			result = initResult(Constant.CLIENT_EXCEPTION_CODE_VALUE, "请求异常，UnsupportedEncodingException");
			logger.info("请求发送失败，UnsupportedEncodingException原因：", e);
		} catch (IOException e)
		{
			result = initResult(Constant.CLIENT_EXCEPTION_CODE_VALUE, "请求异常，IOException");
			logger.info("请求发送失败，IOException原因：", e);
		} finally
		{
			try
			{
				client.close();
				post.releaseConnection();
			} catch (IOException e)
			{
				result = initResult(Constant.CLIENT_EXCEPTION_CODE_VALUE, "请求异常");
				logger.info(e.toString(), e);
			}
		}
		return result;
	}

	public static String initResult(int code, String msg)
	{
		Map<String, Object> data = new HashMap<String, Object>();
		data.put(Constant.RESPONSE_CODE, code);
		data.put(Constant.RESPONSE_CODE_MSG, msg);
		return JSONObject.toJSONString(data);
	}

	public static String doPost(String url, Map<String, String> params)
	{
		return send(url, params, true, "UTF-8");
	}

	public static String send(String url, Map<String, String> params, boolean post, String readEncode)
	{
		InputStream input = null;
		try
		{
			URL realUrl = new URL(url);
			URLConnection connection = realUrl.openConnection();
			connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			connection.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");
			connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			connection.setRequestProperty("Connection", "keep-alive");
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.153 Safari/537.36 SE 2.X MetaSr 1.0");

			if (post)
			{
				connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				connection.setDoInput(true);
				connection.setDoOutput(true);
				((HttpURLConnection) connection).setRequestMethod("POST");

				if (params != null && !params.isEmpty())
				{
					StringBuilder sb = new StringBuilder();
					for (Entry<String, String> entry : params.entrySet())
					{
						String key = entry.getKey();
						String value = entry.getValue();
						sb.append(key + "=" + URLEncoder.encode(value, "UTF-8") + "&");
					}
					sb.deleteCharAt(sb.length() - 1);
					OutputStream out = connection.getOutputStream();
					out.write(sb.toString().getBytes("UTF-8"));
				}
			}

			input = connection.getInputStream();
			scanner = new Scanner(input, readEncode);
			scanner.useDelimiter("$");
			return scanner.next();
		} catch (Exception e)
		{
			logger.error(e.getMessage(), e);
		} finally
		{
			if (input != null)
			{
				try
				{
					input.close();
				} catch (IOException e)
				{
					logger.error(e.getMessage(), e);
				}
			}
		}
		return null;
	}

	public static String getHttpResponse(String targetURL)
	{
		String result = "";
		BufferedReader in = null;
		InputStreamReader isr = null;
		InputStream is = null;
		HttpURLConnection huc = null;
		try
		{
			URL url = new URL(targetURL);
			huc = (HttpURLConnection) url.openConnection();
			is = huc.getInputStream();
			isr = new InputStreamReader(is);
			in = new BufferedReader(isr);
			String line = null;
			while (((line = in.readLine()) != null))
			{
				if (line.length() == 0)
					continue;
				result += line;
			}
		} catch (Exception e)
		{
			logger.error(e.getMessage(), e);
		} finally
		{
			try
			{
				if (is != null)
					is.close();
				if (isr != null)
					isr.close();
				if (in != null)
					in.close();
				if (huc != null)
					huc.disconnect();
			} catch (Exception e)
			{
				logger.error(e.getMessage(), e);
			}
		}
		return result;
	}

	public static JSONObject postClient(String urlString, String jsonObject)
	{
		JSONObject returnJson = null;
		try
		{
			// 创建连接
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");// **注意点1**，需要此格式，后边这个字符集可以不设置
			connection.connect();
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			out.write(jsonObject.toString().getBytes("UTF-8"));// **注意点2**，需要此格式
			out.flush();
			out.close();
			// 读取响应
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));// **注意点3**，需要此格式
			String lines;
			StringBuffer sb = new StringBuffer("");
			while ((lines = reader.readLine()) != null)
			{
				sb.append(lines);
			}
			System.out.println("sb:" + sb);
			returnJson = JSONObject.parseObject(sb.toString());
			reader.close();
			// 断开连接
			connection.disconnect();
		} catch (MalformedURLException e)
		{
			logger.error(e.getMessage());
		} catch (UnsupportedEncodingException e)
		{
			logger.error(e.getMessage());
		} catch (IOException e)
		{
			logger.error(e.getMessage());
		}
		return returnJson;
	}
}
