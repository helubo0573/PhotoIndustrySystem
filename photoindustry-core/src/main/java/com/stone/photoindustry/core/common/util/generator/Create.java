
package com.stone.photoindustry.core.common.util.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Create
{
	final static String url = "jdbc:mysql://localhost:3306/photoindustry_system?useUnicode=true&characterEncoding=utf8";
	final static String MysqlUser = "root";
	final static String mysqlPassword = "123";
	final static String classAuthor = "stone";		
	final static String database = "photoindustry_system";
	final static String commonName = "com.stone.photoindustry.core.common";	// 公共包路径 (例如 BaseDao、 BaseService、 BaseServiceImpl)
	final static String mapperpath = "mappers/";				// Mapper文件存储地址 默认在resources中
	//以下是需要配置的参数
	//表名
	final static String table = "user";
	//类说明
	final static String functionName = "用户表";
	//包路径
	final static String packageName = "com.stone.photoindustry";
	//module名称
	final static String moduleName = "core";
	// 类名前缀
	final static String classNamePrefix = "User";
	public static final Logger logger = LoggerFactory.getLogger(Create.class);

	public static void main(String[] args){
		logger.info("start");
		Create ot = new Create();
		ot.test();
	}

	public void test()
	{
		
		try
		{
			MybatisGenerate.generateCode("mysql", url, MysqlUser, mysqlPassword, database, table, commonName, packageName, mapperpath, moduleName, classAuthor, functionName, classNamePrefix);
		} catch (Exception e)
		{
			logger.error(e.getMessage(), e);
		}
	}

}
