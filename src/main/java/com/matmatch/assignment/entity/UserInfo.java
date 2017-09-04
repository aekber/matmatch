package com.matmatch.assignment.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserInfo implements Serializable
{

    private static final long serialVersionUID = -1517227443933280218L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String email;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
    
    @Column(nullable = false)
    private String ip_address;


    private UserInfo()
    {
    }

    public UserInfo(String first_name, String last_name, String email)
    {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public UserInfo(Long id, String first_name, String last_name, String email, Gender gender, String ip_address)
    {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.ip_address = ip_address;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFirst_name()
    {
        return first_name;
    }

    public void setFirst_name(String first_name)
    {
        this.first_name = first_name;
    }

    public String getLast_name()
    {
        return last_name;
    }

    public void setLast_name(String last_name)
    {
        this.last_name = last_name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public String getIp_address()
    {
        return ip_address;
    }

    public void setIp_address(String ip_address)
    {
        this.ip_address = ip_address;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((ip_address == null) ? 0 : ip_address.hashCode());
        result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserInfo other = (UserInfo) obj;
        if (email == null)
        {
            if (other.email != null)
                return false;
        }
        else if (!email.equals(other.email))
            return false;
        if (first_name == null)
        {
            if (other.first_name != null)
                return false;
        }
        else if (!first_name.equals(other.first_name))
            return false;
        if (gender == null)
        {
            if (other.gender != null)
                return false;
        }
        else if (!gender.equals(other.gender))
            return false;
        if (id == null)
        {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (ip_address == null)
        {
            if (other.ip_address != null)
                return false;
        }
        else if (!ip_address.equals(other.ip_address))
            return false;
        if (last_name == null)
        {
            if (other.last_name != null)
                return false;
        }
        else if (!last_name.equals(other.last_name))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "UserInfoDO [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", gender=" + gender + ", ip_address=" + ip_address + "]";
    }
    
}
