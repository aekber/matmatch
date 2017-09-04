package com.matmatch.assignment.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.matmatch.assignment.dto.UserInfoDTO;
import com.matmatch.assignment.entity.UserInfo;

public class UserInfoMapper
{
    public static UserInfo makeDriverDO(UserInfoDTO driverDTO)
    {
        return new UserInfo(driverDTO.getFirstName(), driverDTO.getLastName(), driverDTO.getEmail());
    }

    public static UserInfoDTO makeDriverDTO(UserInfo driverDO)
    {
        UserInfoDTO.UserInfoDTOBuilder userInfoDTOBuilder = UserInfoDTO.newBuilder()
            .setId(driverDO.getId())
            .setFirstName(driverDO.getFirst_name())
            .setLastName(driverDO.getLast_name())
        	.setEmail(driverDO.getEmail());

        return userInfoDTOBuilder.createUserInfoDTO();
    }

    public static List<UserInfoDTO> makeDriverDTOList(Collection<UserInfo> drivers)
    {
        return drivers.stream()
                      .map(UserInfoMapper::makeDriverDTO)
                      .collect(Collectors.toList());
    }
}
