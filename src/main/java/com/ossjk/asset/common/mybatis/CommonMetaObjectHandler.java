package com.ossjk.asset.common.mybatis;

import org.apache.ibatis.reflection.MetaObject;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.ossjk.asset.common.util.CommonUtil;

public class CommonMetaObjectHandler extends MetaObjectHandler {

	public void insertFill(MetaObject metaObject) {
		setFieldValByName("crtm", CommonUtil.date1(), metaObject);
		setFieldValByName("mdtm", CommonUtil.date1(), metaObject);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		setFieldValByName("mdtm", CommonUtil.date1(), metaObject);
	}

}
