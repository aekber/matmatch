package com.matmatch.assignment.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfoDTO
{
    
    @JsonIgnore
    private Long id;

    @NotNull(message = "First name can not be null!")
    private String firstName;

    @NotNull(message = "Last name can not be null!")
    private String lastName;
    
    @NotNull(message = "Email can not be null!")
    private String email;


    private UserInfoDTO()
    {
    }


    private UserInfoDTO(Long id, String firstName, String lastName, String email)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public static UserInfoDTOBuilder newBuilder()
    {
        return new UserInfoDTOBuilder();
    }


    @JsonProperty
    public Long getId()
    {
        return id;
    }

    
	public String getFirstName()
    {
        return firstName;
    }


    public String getLastName()
    {
        return lastName;
    }


    public String getEmail()
    {
        return email;
    }




    public static class UserInfoDTOBuilder
    {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;


        public UserInfoDTOBuilder setId(Long id)
        {
            this.id = id;
            return this;
        }


        public UserInfoDTOBuilder setFirstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }


        public UserInfoDTOBuilder setLastName(String lastName)
        {
            this.lastName = lastName;
            return this;
        }


        public UserInfoDTOBuilder setEmail(String email) {
			this.email = email;
			return this;
		}


		public UserInfoDTO createUserInfoDTO()
        {
            return new UserInfoDTO(id, firstName, lastName, email);
        }

    }
}
