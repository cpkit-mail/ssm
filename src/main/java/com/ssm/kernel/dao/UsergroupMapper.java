package com.ssm.kernel.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ssm.kernel.model.Usergroup;

public interface UsergroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usergroup
     *
     * @mbg.generated
     */
    @Delete({
        "delete from usergroup",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usergroup
     *
     * @mbg.generated
     */
    @Insert({
        "insert into usergroup (id, group_name, ",
        "delete_flg, description, ",
        "create_user_id, create_user_name, ",
        "create_time, update_user_id, ",
        "update_user_name, update_time)",
        "values (#{id,jdbcType=INTEGER}, #{groupName,jdbcType=VARCHAR}, ",
        "#{deleteFlg,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{createUserId,jdbcType=INTEGER}, #{createUserName,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateUserId,jdbcType=INTEGER}, ",
        "#{updateUserName,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(Usergroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usergroup
     *
     * @mbg.generated
     */
    int insertSelective(Usergroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usergroup
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, group_name, delete_flg, description, create_user_id, create_user_name, create_time, ",
        "update_user_id, update_user_name, update_time",
        "from usergroup",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.ssm.kernel.dao.UsergroupMapper.BaseResultMap")
    Usergroup selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usergroup
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Usergroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usergroup
     *
     * @mbg.generated
     */
    @Update({
        "update usergroup",
        "set group_name = #{groupName,jdbcType=VARCHAR},",
          "delete_flg = #{deleteFlg,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "create_user_id = #{createUserId,jdbcType=INTEGER},",
          "create_user_name = #{createUserName,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_user_id = #{updateUserId,jdbcType=INTEGER},",
          "update_user_name = #{updateUserName,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Usergroup record);
}