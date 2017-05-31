package com.cruelbb.business.common.utils;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

/**
 * logback 封装
 *
 * @author wangbingyuan
 */
public class Logutil {

  private static Logger logger = null;

  private Logutil() {

  }

  private static Logger getLogger(String name) {
    return (Logger) LoggerFactory.getLogger(name);
  }

  public static void info(String msg) {
    synchronized (Logutil.class) {
      Logutil.logger = getLogger(getCurrentClassName());
      Logutil.logger.info(msg);
    }
  }

  public static String getCurrentClassName() {
    String classname = "";

    StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
    for (int i = 0; i < stacks.length; i++) {
      if (stacks[i].getClassName().equals(Logutil.class.getName())) {
        if (!(stacks[i + 1].getClassName().equals(Logutil.class.getName()))) {
          classname = stacks[i + 1].getClassName();
        }
      }
    }
    return classname;
  }
}
