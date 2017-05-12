package test.springmybatis.mapper;

import java.util.List;

import test.springmybatis.po.Role;

public interface Mapper {

  List<Role> getRole();

  int setRole(Role role);
}
