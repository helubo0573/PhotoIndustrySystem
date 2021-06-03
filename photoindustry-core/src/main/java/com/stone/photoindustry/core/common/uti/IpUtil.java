package com.stone.photoindustry.core.common.uti;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IpUtil
{

	public static final Logger logger = LoggerFactory.getLogger(IpUtil.class);

	@Resource
	private WebServiceContext wsContext;

	public static String getRemortIP(HttpServletRequest request)
	{
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("X-Real-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getRemoteAddr();
		}

		// 这里主要是获取本机的ip,可有可无
		if ("127.0.0.1".equals(ip) || ip.endsWith("0:0:0:0:0:0:1"))
		{
			// 根据网卡取本机配置的IP
			InetAddress inet = null;
			try
			{
				inet = InetAddress.getLocalHost();
			} catch (UnknownHostException e)
			{
				logger.error(e.getMessage(), e);
			}
			if (inet != null)
			{
				ip = inet.getHostAddress();
			}
			return ip;
		}
		if (ip.length() > 0)
		{
			String[] ipArray = ip.split(",");
			if (ipArray != null && ipArray.length > 1)
			{
				return ipArray[0];
			}
			return ip;
		}

		return "";
	}

}
