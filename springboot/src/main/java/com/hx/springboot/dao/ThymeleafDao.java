package com.hx.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ThymeleafDao {
	
	@Select("SELECT * FROM [dms].[user]")
	List<Map<String, Object>> queryList();
	
	@Select("SELECT * FROM [dms].[user] WHERE id = #{id}")
	Map<String, Object> queryUserById(int id);

	@Insert("INSERT INTO [dms].[user] VALUES(#{user.name}, #{user.address})")
	void saveUser(@Param(value = "user")Map<String, Object> user);

	@Delete("DELETE FROM [dms].[user] WHERE id = #{id}")
	void deleteUser(int id);

	@Update("UPDATE [dms].[user] SET name = #{user.name}, address = #{user.address} WHERE id = #{user.id}")
	void updateUser(@Param(value = "user")Map<String, Object> user);
	
}
