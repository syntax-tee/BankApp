package com.bankapp.ogunladetaiye;

import com.bankapp.ogunladetaiye.model.UserAccount;
import com.bankapp.ogunladetaiye.repository.TransactionRepository;
import com.bankapp.ogunladetaiye.repository.UserRepository;
import com.bankapp.ogunladetaiye.utils.request.useraccount.NewUserRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BankAppTests {

    @Autowired
    private MockMvc mvc;

//    @Autowired
//    private UserAccount userAccount;
//
//    @Autowired
//    private Map<String, UserAccount> userAccountMap;
//
//    @Autowired
//    private Map<String, AccountStatement> accountStatementMap;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private TransactionRepository transactionRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testUserAccount() throws Exception {
        NewUserRequest request = new NewUserRequest();
        request.setAccountName("Taiye");
        request.setAccountPassword("password");

        UserAccount userAccount = new UserAccount(request.getAccountName(),request.getAccountPassword(),"12345678");

        when(userRepository.createAccount(request)).thenReturn(userAccount);

        mvc.perform(post("/create_account")
                .content(new ObjectMapper().writeValueAsString(userAccount))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.accountName", is("Taiye")))
                .andExpect((ResultMatcher) jsonPath("$.accountNumber", is("12345678")))
                .andExpect((ResultMatcher) jsonPath("$.accountPassword", is("password")));


        verify(userRepository, times(1)).createAccount(request);
    }
}
