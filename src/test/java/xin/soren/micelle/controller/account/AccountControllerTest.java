package xin.soren.micelle.controller.account;

import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import xin.soren.micelle.controller.AuthTokenHelper;
import xin.soren.micelle.controller.AuthTokenInterceptor;
import xin.soren.micelle.gateway.user.UserApiSerivce;
import xin.soren.micelle.gateway.user.UserLoginBO;

//@RunWith(PowerMockRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
// @RunWith(PowerMockRunner.class)
// @PowerMockRunnerDelegate(SpringRunner.class)
// @WebMvcTest(value = AccountController.class)
public class AccountControllerTest {
	// @Rule
	// public PowerMockRule powerMockRule = new PowerMockRule();

	// @Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@MockBean
	private UserApiSerivce userApiSerivce;

	@MockBean
	private AuthTokenInterceptor authTokenInterceptor;

	@Before() // 这个方法在每个方法执行之前都会执行一遍
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); // 初始化MockMvc对象
		MockitoAnnotations.initMocks(this);// 初始化，如果想使用@Mock, @Spy,
											// @InjectMocks等注解时，需要进行初始化后才能使用
	}

	// @Autowired
	// ObjectMapper objectMapper;

	// @Before
	// public void setup() {
	// // Setup MockMVC to use our Spring Configuration
	// this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	// MockitoAnnotations.initMocks(this);
	// }

	@PrepareForTest(AuthTokenHelper.class)
	@Test
	public void testLogoutSuccess() throws Exception {
		// PowerMockito.mockStatic(AuthTokenHelper.class);
		// PowerMockito.when(AuthTokenHelper.getAuthSubject()).thenReturn(new
		// AuthSubject(1L));

		given(userApiSerivce.login(Mockito.any(), Mockito.any())).willReturn(new UserLoginBO());
		given(authTokenInterceptor.preHandle(Mockito.any(), Mockito.any(), Mockito.any())).willReturn(true);

		// mockMvc.perform(post("/api/logout").contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print())
		// .andExpect(status().is2xxSuccessful());
	}
}
