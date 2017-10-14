package xin.soren.micelle.common;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import xin.soren.micelle.exception.EncryptException;
import xin.soren.micelle.exception.ExceptionCodeConst;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Base64.class)
public class CommonUtilsTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private String srcBase64String = "123456";
	private String destBase64String = "MTIzNDU2";

	@Test
	public void base64EncodeTestOk() {
		String v = CommonUtils.base64Encode(srcBase64String);
		Assert.assertEquals(v, destBase64String);
	}

	@SuppressWarnings("unchecked")
	@Test(expected = EncryptException.class)
	public void base64EncodeTestFail() {
		PowerMockito.mockStatic(Base64.class);
		PowerMockito.when(Base64.encodeBase64(Mockito.any(byte[].class))).thenThrow(UnsupportedEncodingException.class);

		String v = CommonUtils.base64Encode(srcBase64String);
	}

	@Test
	public void base64DecodeTestOk() {
		String v = CommonUtils.base64Decode(destBase64String);
		Assert.assertEquals(v, srcBase64String);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void base64DecodeTestFail() {
		PowerMockito.mockStatic(Base64.class);
		PowerMockito.when(Base64.decodeBase64(Mockito.any(byte[].class))).thenThrow(UnsupportedEncodingException.class);

		thrown.expect(EncryptException.class);
		thrown.expectMessage("java.io.UnsupportedEncodingException");
		thrown.expect(Matchers.hasProperty("errorCode", Matchers.is(ExceptionCodeConst.S_ENCRYPT_ERROR)));

		CommonUtils.base64Decode(destBase64String);
	}
}
