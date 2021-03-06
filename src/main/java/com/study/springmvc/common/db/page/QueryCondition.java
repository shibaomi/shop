package com.study.springmvc.common.db.page;

import java.util.HashMap;
import java.util.Map;

import com.study.springmvc.common.constant.common.OrderEnum;

import lombok.Data;

public @Data class QueryCondition {
	
	/**
	 * 总条数
	 */
    private int totalCount = 0;
    
    /**
     * 总页数
     */
    private int totalPage;
    
    /**
	 * 每页大小
	 */
    private int pageSize = 10;
    
    /**
	 * 当前页数，从1开始
	 */
    private int currPage = 1;
    
    /**
	 * 排序字段
	 */
    private String orderField;
    /**
     * 排序方向
     */
    private OrderEnum orderDirection = OrderEnum.DESC;
    
    /**
     * 当前页开始数
     */
    private int startIndex;
    
    /**
     * 本页结束条数
     */
    private int endIndex;
    
    /**
     * 查询条件
     */
    private Map<String,Object> queryCondition=new HashMap<String,Object>();
    
	public void setPageSize(int pageSize) {
		if(pageSize<0){
			pageSize=10;
		}
		this.pageSize = pageSize;
	}

	public void setCurrPage(int currPage) {
		if(currPage<1){
			currPage=1;
		}
		this.currPage = currPage;
	}

	public int getStartIndex() {
		this.startIndex=(this.currPage-1)*this.pageSize;
		if(this.startIndex<1)
			this.startIndex=0;
		return startIndex;
	}
	
	public int getEndIndex() {
		this.endIndex=this.currPage*this.pageSize;
		if(this.endIndex<0)
			this.endIndex=0;
		return endIndex;
	}
}
