package xin.soren.micelle.controller.account;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import xin.soren.micelle.controller.AuthTokenInterceptor;
import xin.soren.micelle.gateway.user.UserApiSerivce;
import xin.soren.micelle.gateway.user.UserLoginBO;

@RunWith(SpringRunner.class)
// @WebMvcTest(value = AccountController.class)
@WebMvcTest(value = AccountController.class)
// @SpringBootTest
// @AutoConfigureMockMvc
public class AccountControllerTest {
	@Autowired
	private MockMvc mockMvc;

	// @Autowired
	// private WebApplicationContext wac;

	@MockBean
	private UserApiSerivce userApiSerivce;

	@MockBean
	private AuthTokenInterceptor authTokenInterceptor;

	// @Autowired
	// ObjectMapper objectMapper;

	// @Before
	// public void setup() {
	// // Setup MockMVC to use our Spring Configuration
	// this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	// MockitoAnnotations.initMocks(this);
	// }

	@Test
	public void testLogoutSuccess() throws Exception {
		given(userApiSerivce.login(Mockito.any(), Mockito.any())).willReturn(new UserLoginBO());
		given(authTokenInterceptor.preHandle(Mockito.any(), Mockito.any(), Mockito.any())).willReturn(true);

		mockMvc.perform(post("/api/logout").contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print())
				.andExpect(status().is2xxSuccessful());
	}
}
