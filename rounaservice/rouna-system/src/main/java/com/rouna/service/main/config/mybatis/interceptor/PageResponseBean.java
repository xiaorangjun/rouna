package com.rouna.service.main.config.mybatis.interceptor;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class PageResponseBean<T> {

	private int page = 1; // 当前页码
	private int pageSize = 10;

	private long records;// 总记录数，设置为“-1”表示不查询总数
	private List<T> rows = new ArrayList<T>();//数据
	private int first;
	private int last;

	public PageResponseBean() {
		this.pageSize = -1;
	}


	/**
	 * 构造方法
	 *
	 * @param page   当前页码
	 * @param pageSize 分页大小
	 */
	public PageResponseBean(int page, int pageSize) {
		this(page, pageSize, 0);
	}

	/**
	 * 构造方法
	 *
	 * @param page   当前页码
	 * @param pageSize 分页大小
	 * @param count    数据条数
	 */
	public PageResponseBean(int page, int pageSize, long count) {
		this(page, pageSize, count, new ArrayList<T>());
	}

	/**
	 * 构造方法
	 *
	 * @param page   当前页码
	 * @param pageSize 分页大小
	 * @param count    数据条数
	 * @param list     本页数据对象列表
	 */
	public PageResponseBean(int page, int pageSize, long count, List<T> list) {
		this.setRecords(count);
		this.setPage(page);
		this.pageSize = pageSize;
		this.rows = list;
	}

	/**
	 * 初始化参数
	 */
	public void initialize() {

		this.first = 1;
		this.last = (int) (records / (this.pageSize < 1 ? 20 : this.pageSize) + first - 1);

		if (this.records % this.pageSize != 0 || this.last == 0) {
			this.last++;
		}

		if (this.last < this.first) {
			this.last = this.first;
		}

		if (this.page < this.first) {// 如果当前页小于首页
			this.page = this.first;
		}

		if (this.page > this.last) {// 如果当前页大于尾页
			this.page = this.last;
		}

	}


	/**
	 * 获取设置总数
	 *
	 * @return
	 */
	public long getRecords() {
		return records;
	}

	/**
	 * 设置数据总数
	 *
	 * @param records
	 */
	public void setRecords(long records) {
		this.records = records;
		if (pageSize >= records) {
			//page = 1;
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * 获取页面大小
	 *
	 * @return
	 */
	@JsonIgnore
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置页面大小（最大500）
	 *
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize <= 0 ? 10 : pageSize;// > 500 ? 500 : pageSize;
	}

	/**
	 * 首页索引
	 *
	 * @return
	 */
	@JsonIgnore
	public int getFirst() {
		return first;
	}

	/**
	 * 尾页索引
	 *
	 * @return
	 */
	@JsonIgnore
	public int getLast() {
		return last;
	}

	/**
	 * 获取页面总数
	 *
	 * @return getLast();
	 */
	@JsonIgnore
	public int getTotalPage() {
		return getLast();
	}

	@JsonIgnore
	public int getTotal() {
		return getLast();
	}

	/**
	 * 获取本页数据对象列表
	 *
	 * @return List<T>
	 */
	public List<T> getRows() {
		return rows;
	}

	/**
	 * 设置本页数据对象列表
	 *
	 * @param rows
	 */
	public PageResponseBean<T> setRows(List<T> rows) {

		this.rows = rows;
		initialize();
		return this;

	}


	/**
	 * 是否进行总数统计
	 *
	 * @return this.count==-1
	 */
	@JsonIgnore
	public boolean isNotCount() {
		return this.records == -1;
	}

	/**
	 * 获取 Hibernate FirstResult
	 */
	@JsonIgnore
	public int getFirstResult() {
		int firstResult = (getPage() - 1) * getPageSize();
		if (firstResult >= getRecords()) {
			//firstResult = 0;
		}
		return firstResult;
	}

	/**
	 * 获取 Hibernate MaxResults
	 */
	@JsonIgnore
	public int getMaxResults() {
		return getPageSize();
	}





}
