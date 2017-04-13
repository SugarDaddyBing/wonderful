package com.cruelbb.common.utils;

import java.util.UUID;

public class GuidUtil {

  public static String newGuid() {
    String guid = UUID.randomUUID().toString();
    return guid.replace("-", "");
  }

  public static void main(String[] args) {
    System.out.println(newGuid());
  }
}
