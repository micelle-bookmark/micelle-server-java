package xin.soren.micelle.common;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.tuple.Pair;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import xin.soren.micelle.exception.EncryptException;
import xin.soren.micelle.exception.ExceptionCodeConst;

@RunWith(PowerMockRunner.class)
public class CommonUtilsTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private String srcBase64String = "123456";
	private String destBase64String = "MTIzNDU2";

	private String srcMd5String = "123456";
	private String pwd = "123";
	private String salt = "456";
	private String destMd5String = "e10adc3949ba59abbe56e057f20f883e";

	// @BeforeClass
	// static public void BeforeClass() {
	// PowerMockito.mockStatic(CommonUtils.class);
	// PowerMockito.mockStatic(Base64.class);
	// }

	// @Before
	// public void before() {
	// PowerMockito.mockStatic(CommonUtils.class);
	// PowerMockito.mockStatic(Base64.class);
	// }

	@Test
	public void base64EncodeTestOk() {
		String v = CommonUtils.base64Encode(srcBase64String);
		Assert.assertEquals(v, destBase64String);
	}

	@PrepareForTest(Base64.class)
	@SuppressWarnings("unchecked")
	@Test(expected = EncryptException.class)
	public void base64EncodeTestFail() {
		PowerMockito.mockStatic(Base64.class);
		PowerMockito.when(Base64.encodeBase64(Mockito.any(byte[].class))).thenThrow(UnsupportedEncodingException.class);

		CommonUtils.base64Encode(srcBase64String);
		Assert.fail();
	}

	@Test
	public void base64DecodeTestOk() {
		String v = CommonUtils.base64Decode(destBase64String);
		Assert.assertEquals(v, srcBase64String);
	}

	@PrepareForTest(Base64.class)
	@SuppressWarnings("unchecked")
	@Test
	public void base64DecodeTestFail() {
		PowerMockito.mockStatic(Base64.class);
		PowerMockito.when(Base64.decodeBase64(Mockito.any(byte[].class))).thenThrow(UnsupportedEncodingException.class);

		thrown.expect(EncryptException.class);
		thrown.expectMessage("java.io.UnsupportedEncodingException");
		thrown.expect(Matchers.hasProperty("errorCode", Matchers.is(ExceptionCodeConst.S_ENCRYPT_ERROR)));

		CommonUtils.base64Decode(destBase64String);
		Assert.fail();
	}

	@Test
	public void md5TestOk() {
		String v = CommonUtils.md5(srcMd5String);
		Assert.assertEquals(v, destMd5String);
	}

	// @SuppressWarnings("unchecked")
	// @Test
	// @PrepareForTest(CommonUtils.class)
	// public void md5TestFail() throws NoSuchAlgorithmException {
	// PowerMockito.mockStatic(MessageDigest.class);
	// // mockStatic
	// PowerMockito.when(MessageDigest.getInstance("MD5")).thenThrow(NoSuchAlgorithmException.class);
	//
	// thrown.expect(EncryptException.class);
	//
	// CommonUtils.md5(srcMd5String);
	// Assert.fail();
	// }

	@Test
	public void encryptTestOk() {
		String v = CommonUtils.encrypt(pwd, salt);
		Assert.assertEquals(v, destMd5String);
	}

	@PrepareForTest(CommonUtils.class)
	@Test
	public void encryptPairTestOk() {

		PowerMockito.spy(CommonUtils.class);
		PowerMockito.when(CommonUtils.uuid()).then(new Answer<String>() {
			@Override
			public String answer(InvocationOnMock invocation) {
				// System.out.println("answer");
				return salt;
			}
		});
		// PowerMockito.when(CommonUtils.uuid()).thenReturn(salt);

		String s = CommonUtils.uuid();
		Assert.assertEquals(salt, s);

		Pair<String, String> v = CommonUtils.encrypt(pwd);
		Assert.assertEquals(v.getLeft(), destMd5String);
		Assert.assertEquals(v.getRight(), salt);
	}

	@Test
	public void isValidEmailTestOk() {

	}

	@Test
	public void isValidEmailTestFail() {

	}

	@Test
	public void isValidUrlTestOk() {

	}

	@Test
	public void isValidUrlTestFail() {

	}
}
