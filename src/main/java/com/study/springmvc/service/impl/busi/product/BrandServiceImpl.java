package com.study.springmvc.service.impl.busi.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.study.springmvc.common.constant.common.CommonStatus;
import com.study.springmvc.common.exception.BusiException;
import com.study.springmvc.controller.command.busi.product.BrandCommand;
import com.study.springmvc.dal.faces.busi.product.BrandDao;
import com.study.springmvc.dal.model.busi.company.CompanyModel;
import com.study.springmvc.dal.model.busi.product.BrandModel;
import com.study.springmvc.service.faces.busi.company.CompanyService;
import com.study.springmvc.service.faces.busi.product.BrandService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandDao brandDao;
	
	@Autowired
	private CompanyService companyService;

	public Long insert(BrandCommand command){
		BrandModel record=new BrandModel(command);
		List<BrandModel> result=brandDao.selectByBrandNameAndBrandCode(record.getBrandCode(), 
				record.getBrandName(),CommonStatus.getNoDeteleStatus());
		if(!CollectionUtils.isEmpty(result)){
			for(BrandModel bm: result){
				if(bm.getBrandCode().equals(record.getBrandCode())){
					log.error("品牌编码【{}】已经存在！",record.getBrandCode());
					throw new BusiException("品牌编码已经存在");
				}else if(bm.getBrandName().equals(record.getBrandName())){
					log.error("品牌名称【{}】已经存在！",record.getBrandName());
					throw new BusiException("品牌名称已经存在");
				}
			}
		}
		if(record.getCompanyId()!=null){
			CompanyModel cp=companyService.selectByPrimaryKey(record.getCompanyId(), CommonStatus.getNoDeteleStatus());
			if(cp==null){
				log.error("品牌关联的公司【id={}】不存在！",record.getCompanyId());
				throw new BusiException("品牌关联的公司不存在");
			}
			List<BrandModel> cpBm=brandDao.selectByCompanyId(record.getCompanyId(),CommonStatus.getNoDeteleStatus());
			if(!CollectionUtils.isEmpty(cpBm)){
				log.error("品牌关联的公司【id={}】已经关联了品牌【{}】！",record.getCompanyId(),cpBm.get(0).getBrandName());
				throw new BusiException("品牌关联的公司已经有关联品牌了");
			}
		}
		record.setBrandStatus(CommonStatus.ENABLED);
		brandDao.insert(record);
		return command.getId();
	}

	public BrandModel selectByPrimaryKey(Long id){
		return brandDao.selectByPrimaryKey(id,null);
	}

	public Long updateByPrimaryKeySelective(BrandCommand command){
		BrandModel record=new BrandModel(command);
		BrandModel checkM=brandDao.selectByPrimaryKey(record.getId(),null);
		if(checkM==null){
			log.error("品牌【id={}】不存在！",record.getCompanyId());
			throw new BusiException("更新的品牌信息非法：品牌不存在");
		}
		if(CommonStatus.DETELE.equals(checkM.getBrandStatus())){
			log.error("品牌【id={},name={}】已删除，不允许更新操作！",record.getId(),record.getBrandName());
			throw new BusiException("该品牌已被删除");
		}
		brandDao.updateByPrimaryKeySelective(record);
		return command.getId();
	}

	@Override
	public void deleteByPrimaryKey(Long id) {
		BrandModel checkM=brandDao.selectByPrimaryKey(id,null);
		if(checkM==null){
			log.error("品牌【id={}】不存在！",id,null);
			throw new BusiException("数据非法：品牌信息不存在");
		}
		if(CommonStatus.DETELE.equals(checkM.getBrandStatus())){
			log.error("品牌【id={},name={}】已删除，不用重复删除！",checkM.getId(),checkM.getBrandName());
			throw new BusiException("该品牌已被删除");
		}
		BrandModel record=new BrandModel();
		record.setId(id);
		record.setBrandStatus(CommonStatus.DETELE);
		brandDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<BrandModel> selectByPage(String brandName, String brandCode, CommonStatus status, Long companyId,
			Integer offset, Integer limit) {
		List<CommonStatus> brandStatus=new ArrayList<CommonStatus>();
		if(status==null){
			brandStatus.addAll(CommonStatus.getNoDeteleStatus());
		}else{
			brandStatus.add(status);
		}
		return brandDao.selectByPage(brandName, brandCode, brandStatus, companyId, offset, limit);
	}
}
