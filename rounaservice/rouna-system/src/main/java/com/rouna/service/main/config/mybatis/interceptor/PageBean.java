package com.rouna.service.main.config.mybatis.interceptor;



public class PageBean {
    private String sortOrder="DESC";//普通字段排序顺序
    private String sortField; //普通排序字段
	private Integer page = 1; // 当前页码
	private Integer pageSize = 10; // 页面大小，设置为“-1”表示不进行分页（分页无效）

	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getSortField() {
		return sortField;
	}
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
