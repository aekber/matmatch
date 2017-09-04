package com.matmatch.assignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.matmatch.assignment.entity.UserInfo;

/**
 * 
 * @author ekber
 * 
 * DAO class
 *
 */
public interface UserInfoRepository extends CrudRepository<UserInfo, Long>
{
    @Query(value = "SELECT * FROM USER_INFO u WHERE ( LOWER(u.FIRST_NAME) LIKE %?1% or LOWER(u.LAST_NAME) LIKE %?1% ) AND LOWER(u.GENDER) = ?2", nativeQuery = true)
    public List<UserInfo> findByNameAndGender(@Param("name") String name, @Param("gender") String gender);
}
