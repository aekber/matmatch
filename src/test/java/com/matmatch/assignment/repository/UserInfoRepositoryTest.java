package com.matmatch.assignment.repository;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.matmatch.assignment.ApplicationTest;
import com.matmatch.assignment.dao.UserInfoRepository;
import com.matmatch.assignment.entity.UserInfo;

public class UserInfoRepositoryTest extends ApplicationTest
{

    private static final String NAME = "titos";
    private static final String GENDER = "male";


    @Autowired
    private UserInfoRepository userInfoRepository;


    @Test
    public void testUserInfoByNameAndGender()
    {
        List<UserInfo> userInfoList = userInfoRepository.findByNameAndGender(NAME, GENDER);
        Assert.assertThat(userInfoList, hasSize(1));
    }
   
}