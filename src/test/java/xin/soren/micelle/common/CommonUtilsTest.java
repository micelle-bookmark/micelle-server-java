package xin.soren.micelle.common;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import xin.soren.micelle.exception.EncryptException;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Base64.class)
public class CommonUtilsTest {
	@Test
	public void base64EncodeTestOk() {
		String srcString = "123456";
		String destString = "MTIzNDU2";

		String v = CommonUtils.base64Encode(srcString);
		Assert.assertEquals(v, destString);
	}

	@Test(expected = EncryptException.class)
	public void base64EncodeTestFail() {
		PowerMockito.mockStatic(Base64.class);
		PowerMockito.when(Base64.encodeBase64(Mockito.any(byte[].class))).thenThrow(UnsupportedEncodingException.class);

		String v = CommonUtils.base64Encode("123456");
	}
}
