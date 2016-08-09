package com.yunva.dao.pictures;

import com.yunva.repository.BaseRepository;
import com.yunva.model.Page;
import com.yunva.util.PageData;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PicturesDao extends BaseRepository {



	/*
	* 新增
	*/
	public void save(PageData pd)throws Exception{
		template.insert("PicturesMapper.save", pd);
	}
	
	/*
	* 删除
	*/
	public void delete(PageData pd)throws Exception{
		template.delete("PicturesMapper.delete", pd);
	}
	
	/*
	* 修改
	*/
	public void edit(PageData pd)throws Exception{
		template.update("PicturesMapper.edit", pd);
	}
	
	/*
	*列表
	*/
	public List<PageData> list(Page page)throws Exception{
		return template.selectList("PicturesMapper.datalistPage", page);
	}
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return template.selectList("PicturesMapper.listAll", pd);
	}
	
	/*
	* 通过id获取数据
	*/
	public PageData findById(PageData pd)throws Exception{
		return template.selectOne("PicturesMapper.findById", pd);
	}
	
	/*
	* 批量删除
	*/
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		template.delete("PicturesMapper.deleteAll", ArrayDATA_IDS);
	}
	
	/*
	* 批量获取
	*/
	public List<PageData> getAllById(String[] ArrayDATA_IDS)throws Exception{
		return template.selectList("PicturesMapper.getAllById", ArrayDATA_IDS);
	}
	
	/*
	* 删除图片
	*/
	public void delTp(PageData pd)throws Exception{
		template.update("PicturesMapper.delTp", pd);
	}
	
}

