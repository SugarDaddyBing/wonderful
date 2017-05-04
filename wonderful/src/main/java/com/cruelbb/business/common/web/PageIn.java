package com.cruelbb.business.common.web;

import java.io.Serializable;
import java.text.MessageFormat;
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

  /**
   * 排序规则
   */
  private String order;

  /**
   * 就是排序列和排序规则的组合啦
   */
  private String orderby;

  public PageIn(Map<String, Object> params) {
    putAll(params);

    this.page = Integer.parseInt(params.get("page").toString());
    this.limit = Integer.parseInt(params.get("limit").toString());
    this.sort = StringUtils.defaultIfBlank(params.get("sort").toString(), StringUtils.EMPTY);
    this.order = StringUtils.defaultIfBlank(params.get("order").toString(), StringUtils.EMPTY);
    this.orderby = sort.length() == 0 ? StringUtils.EMPTY : MessageFormat.format("{0}.{1}", sort, order);
  }

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

  public String getOrderby() {
    return orderby;
  }

  public void setOrderby(String orderby) {
    this.orderby = orderby;
  }

}
