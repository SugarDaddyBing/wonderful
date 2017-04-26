package com.cruelbb.business.common.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class PageIn extends HashMap<String, Object> implements Serializable {

  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = 1L;

  /**
   * 当前页码
   */
  private int page;

  /**
   * 每页条数
   */
  private int limit;

  /**
   * 排序列
   */
  private String sort;

  public PageIn(Map<String, Object> params) {
    putAll(params);

    this.page = Integer.parseInt(params.get("page").toString());
    this.limit = Integer.parseInt(params.get("limit").toString());
    this.sort = StringUtils.defaultIfBlank(params.get("sort").toString(), StringUtils.EMPTY);
    this.order = StringUtils.defaultIfBlank(params.get("order").toString(), StringUtils.EMPTY);
  }

  /**
   * 排序规则
   */
  private String order;

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
  }

}
