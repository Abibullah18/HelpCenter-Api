//package com.Help.Center.Controller;
//
//import org.springframework.data.domain.Page;
//
//public class Pagination {
//
//	private Long totalCount;
//	private int pageSize;
//	private int totalpage;
//	private int pageNo;
//	private Boolean isFirst;
//	private Boolean isLast;
//	public Long getTotalCount() {
//		return totalCount;
//	}
//	public void setTotalCount(Long totalCount) {
//		this.totalCount = totalCount;
//	}
//	public int getPageSize() {
//		return pageSize;
//	}
//	public void setPageSize(int pageSize) {
//		this.pageSize = pageSize;
//	}
//	public int getTotalpage() {
//		return totalpage;
//	}
//	public void setTotalpage(int totalpage) {
//		this.totalpage = totalpage;
//	}
//	public int getPageNo() {
//		return pageNo;
//	}
//	public void setPageNo(int pageNo) {
//		this.pageNo = pageNo;
//	}
//	public Boolean getIsFirst() {
//		return isFirst;
//	}
//	public void setIsFirst(Boolean isFirst) {
//		this.isFirst = isFirst;
//	}
//	public Boolean getIsLast() {
//		return isLast;
//	}
//	public void setIsLast(Boolean isLast) {
//		this.isLast = isLast;
//	}
//
//	public static <T> Pagination createPagination(Page<T>page){
//		Pagination pagination=new Pagination();
//
//		pagination.setIsFirst(page.isFirst());
//		pagination.setIsLast(page.isLast());
//		pagination.setPageNo(page.getNumber());
//		pagination.setPageSize(page.getSize());
//		pagination.setTotalCount(page.getTotalElements());
//		pagination.setTotalpage(page.getTotalPages());
//		return pagination ;
//
//	}
//
//
//
//}
