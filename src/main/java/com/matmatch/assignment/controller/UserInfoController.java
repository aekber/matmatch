package com.matmatch.assignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matmatch.assignment.dto.UserInfoDTO;
import com.matmatch.assignment.exception.EntityNotFoundException;
import com.matmatch.assignment.mapper.UserInfoMapper;
import com.matmatch.assignment.service.UserInfoService;

/**
 * All operations with a user will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/userinfo")
public class UserInfoController
{

    private final UserInfoService userInfoService;


    @Autowired
    public UserInfoController(final UserInfoService userInfoService)
    {
        this.userInfoService = userInfoService;
    }


    @GetMapping("/search/name/{name}/gender/{gender}")
    public List<UserInfoDTO> search(@Valid @PathVariable String name, @Valid @PathVariable String gender) throws EntityNotFoundException
    {
        return UserInfoMapper.makeDriverDTOList(userInfoService.findByNameAndGender(name, gender));
    }

}
