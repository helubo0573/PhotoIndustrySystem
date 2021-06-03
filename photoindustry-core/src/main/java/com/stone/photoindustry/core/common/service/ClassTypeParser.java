package com.stone.photoindustry.core.common.service;

public interface ClassTypeParser
{
	<T> T parse(String content, Class<T> valueType);
}
