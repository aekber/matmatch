package com.matmatch.assignment.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.matmatch.assignment.dao.UserInfoRepository;
import com.matmatch.assignment.entity.UserInfo;
import com.matmatch.assignment.exception.EntityNotFoundException;
import com.matmatch.assignment.util.DataLoader;

/**
 * Service class
 */
@Service
public class DefaultUserInfoService implements UserInfoService
{

    @Autowired
    private UserInfoRepository userInfoRepository;
    
    @Autowired
    private DataLoader dataLoader;

    @Value("${eko.csvfile.name}")
    private String fileName;
    
    @PostConstruct
    public void init()
    {   
        //csv file loaded and inserted db in here
        List<UserInfo> userInfoList = dataLoader.loadObjectList(UserInfo.class, fileName);        
        userInfoRepository.save(userInfoList);
    }

    @Override
    public List<UserInfo> findByNameAndGender(String name, String gender) throws EntityNotFoundException
    {
        List<UserInfo> resultList = userInfoRepository.findByNameAndGender(name.toLowerCase(), gender.toLowerCase());
        if(resultList.size() == 0){
            throw new EntityNotFoundException("No result found.");
        }
        
        return resultList;
    }

}
