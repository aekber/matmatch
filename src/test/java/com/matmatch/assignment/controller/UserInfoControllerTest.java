package com.matmatch.assignment.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.matmatch.assignment.Application;
import com.matmatch.assignment.entity.Gender;
import com.matmatch.assignment.entity.UserInfo;
import com.matmatch.assignment.service.UserInfoService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest
public class UserInfoControllerTest
{

    private static final String NAME = "tito";
    private static final String GENDER = "male";
    
    private MockMvc mvc;

    @Mock
    private UserInfoService userInfoService;

    @InjectMocks
    private UserInfoController userInfoController;


    @BeforeClass
    public static void setUp()
    {
        MockitoAnnotations.initMocks(UserInfoController.class);
    }

    @Before
    public void init()
    {
        mvc = MockMvcBuilders.standaloneSetup(userInfoController).dispatchOptions(true).build();
    }

    @Test
    public void testSearchByNameAndGender() throws Exception {
        List<UserInfo> users = Arrays.asList(new UserInfo(11l,"Titos","Stroud","tstrouda@t-online.de",Gender.Male,"108.18.60.114"));

        when(userInfoService.findByNameAndGender(NAME, GENDER)).thenReturn(users);

        mvc.perform(get("/v1/userinfo/search/name/tito/gender/male"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(11)))
                .andExpect(jsonPath("$[0].firstName", is("Titos")))
                .andExpect(jsonPath("$[0].lastName", is("Stroud")))
                .andExpect(jsonPath("$[0].email", is("tstrouda@t-online.de")));

        verify(userInfoService, times(1)).findByNameAndGender(NAME, GENDER);
        verifyNoMoreInteractions(userInfoService);
    }

}
