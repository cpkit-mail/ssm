package com.ssm.page.model;

import java.util.Date;

public class PageModel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_name
     *
     * @mbg.generated
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.phone
     *
     * @mbg.generated
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.gender
     *
     * @mbg.generated
     */
    private String gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.delete_flg
     *
     * @mbg.generated
     */
    private String deleteFlg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.group_id
     *
     * @mbg.generated
     */
    private Integer groupId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.create_user_id
     *
     * @mbg.generated
     */
    private Integer createUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.create_user_name
     *
     * @mbg.generated
     */
    private String createUserName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.update_user_id
     *
     * @mbg.generated
     */
    private Integer updateUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.update_user_name
     *
     * @mbg.generated
     */
    private String updateUserName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_name
     *
     * @return the value of user.user_name
     *
     * @mbg.generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_name
     *
     * @param userName the value for user.user_name
     *
     * @mbg.generated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.name
     *
     * @return the value of user.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.name
     *
     * @param name the value for user.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.phone
     *
     * @return the value of user.phone
     *
     * @mbg.generated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.phone
     *
     * @param phone the value for user.phone
     *
     * @mbg.generated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.gender
     *
     * @return the value of user.gender
     *
     * @mbg.generated
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.gender
     *
     * @param gender the value for user.gender
     *
     * @mbg.generated
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.delete_flg
     *
     * @return the value of user.delete_flg
     *
     * @mbg.generated
     */
    public String getDeleteFlg() {
        return deleteFlg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.delete_flg
     *
     * @param deleteFlg the value for user.delete_flg
     *
     * @mbg.generated
     */
    public void setDeleteFlg(String deleteFlg) {
        this.deleteFlg = deleteFlg == null ? null : deleteFlg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.group_id
     *
     * @return the value of user.group_id
     *
     * @mbg.generated
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.group_id
     *
     * @param groupId the value for user.group_id
     *
     * @mbg.generated
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.create_user_id
     *
     * @return the value of user.create_user_id
     *
     * @mbg.generated
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.create_user_id
     *
     * @param createUserId the value for user.create_user_id
     *
     * @mbg.generated
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.create_user_name
     *
     * @return the value of user.create_user_name
     *
     * @mbg.generated
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.create_user_name
     *
     * @param createUserName the value for user.create_user_name
     *
     * @mbg.generated
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.create_time
     *
     * @return the value of user.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.create_time
     *
     * @param createTime the value for user.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.update_user_id
     *
     * @return the value of user.update_user_id
     *
     * @mbg.generated
     */
    public Integer getUpdateUserId() {
        return updateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.update_user_id
     *
     * @param updateUserId the value for user.update_user_id
     *
     * @mbg.generated
     */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.update_user_name
     *
     * @return the value of user.update_user_name
     *
     * @mbg.generated
     */
    public String getUpdateUserName() {
        return updateUserName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.update_user_name
     *
     * @param updateUserName the value for user.update_user_name
     *
     * @mbg.generated
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.update_time
     *
     * @return the value of user.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.update_time
     *
     * @param updateTime the value for user.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}