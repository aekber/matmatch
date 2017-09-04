package com.matmatch.assignment.service;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.matmatch.assignment.ApplicationTest;
import com.matmatch.assignment.dao.UserInfoRepository;
import com.matmatch.assignment.entity.Gender;
import com.matmatch.assignment.entity.UserInfo;
import com.matmatch.assignment.exception.EntityNotFoundException;

public class UserInfoServiceTest extends ApplicationTest
{
    private static final String NAME = "titos";
    private static final String GENDER = "male";
    
    private static final String FAKE_NAME = "blabla";
    private static final String FAKE_GENDER = "blablabla";
    
    @Mock
    private UserInfoRepository userInfoRepository;

    @InjectMocks
    private DefaultUserInfoService userInfoService;


    @BeforeClass
    public static void setUp()
    {
        MockitoAnnotations.initMocks(DefaultUserInfoService.class);
    }


    @Test
    public void testFindByNameAndGender()throws EntityNotFoundException
    {
        List<UserInfo> list = new ArrayList<>();
        UserInfo mockUserInfo = new UserInfo(11l,"Titos","Stroud","tstrouda@t-online.de",Gender.Male,"108.18.60.114");
        list.add(mockUserInfo);
        
        when(userInfoRepository.findByNameAndGender(NAME, GENDER)).thenReturn(list);
        userInfoService.findByNameAndGender(NAME, GENDER);
        verify(userInfoRepository, times(1)).findByNameAndGender(anyString(), anyString());
    }
    
    @Test(expected = EntityNotFoundException.class)
    public void testUserInfoNotFound() throws EntityNotFoundException
    {
        userInfoService.findByNameAndGender(FAKE_NAME, FAKE_GENDER);
    }

}