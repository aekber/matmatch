package com.matmatch.assignment.service;

import java.util.List;

import com.matmatch.assignment.entity.UserInfo;
import com.matmatch.assignment.exception.EntityNotFoundException;

public interface UserInfoService
{
    List<UserInfo> findByNameAndGender(String name, String gender) throws EntityNotFoundException;

}
