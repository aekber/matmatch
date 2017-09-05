package com.matmatch.assignment.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.matmatch.assignment.dto.UserInfoDTO;
import com.matmatch.assignment.entity.UserInfo;

public class UserInfoMapper
{
    public static UserInfo makeUserDO(UserInfoDTO userDTO)
    {
        return new UserInfo(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail());
    }

    public static UserInfoDTO makeUserDTO(UserInfo userDO)
    {
        UserInfoDTO.UserInfoDTOBuilder userInfoDTOBuilder = UserInfoDTO.newBuilder()
            .setId(userDO.getId())
            .setFirstName(userDO.getFirst_name())
            .setLastName(userDO.getLast_name())
        	.setEmail(userDO.getEmail());

        return userInfoDTOBuilder.createUserInfoDTO();
    }

    public static List<UserInfoDTO> makeUserDTOList(Collection<UserInfo> users)
    {
        return users.stream()
                      .map(UserInfoMapper::makeUserDTO)
                      .collect(Collectors.toList());
    }
}
