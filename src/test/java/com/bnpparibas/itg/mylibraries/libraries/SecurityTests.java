package com.bnpparibas.itg.mylibraries.libraries;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("tp-spring-8")
@AutoConfigureMockMvc
public class SecurityTests {

    @Autowired
    private MockMvc mvc;


    @Test
    @DisplayName("blabla 1")
   // @WithMockUser("Toto")
    public void
    testIfSecure1k() throws Exception {
        mvc
                .perform(get("/unsecured/toto"))
                .andExpect(status().isOk());

    }
    @Test
    @DisplayName("blabla 2")
   // @WithMockUser("Toto")
    public void
    testIfSecure2() throws Exception {

        mvc
                .perform(get("/libraries"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("blabla 3")
   // @WithMockUser("Toto")
    public void
    testIfSecure3() throws Exception {

        mvc
                .perform(get("/zorro"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("blabla 4")
    // @WithMockUser("Toto")
    public void
    testIfSecure4() throws Exception {

        mvc
                .perform(get("/admin"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("blabla 5")
     @WithMockUser(authorities  ="ROLE_ADMIN")
    public void
    testIfSecure5() throws Exception {

        mvc
                .perform(get("/admin"))
                .andExpect(status().isOk());
    }
}
