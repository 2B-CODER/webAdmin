package com.yunva.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public  abstract class BaseRepository {

	@Qualifier("sqlSessionTemplate")
	@Autowired
	protected SqlSessionTemplate template;

	protected SqlSessionTemplate getTemplate() {
		return template;
	}

	protected void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}
}


