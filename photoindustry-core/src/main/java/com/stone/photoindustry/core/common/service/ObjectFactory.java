package com.stone.photoindustry.core.common.service;

import org.apache.ibatis.javassist.tools.rmi.ObjectNotFoundException;

public interface ObjectFactory<T>
{

	T getObject(Object qualifier) throws ObjectNotFoundException;
}
