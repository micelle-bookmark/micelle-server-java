package xin.soren.micelle.common;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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

import xin.soren.micelle.common.exception.EncryptException;
import xin.soren.micelle.common.exception.ExceptionCodeConst;

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
		/**
		 * https://blogs.msdn.microsoft.com/testing123/2009/02/06/email-address-test-cases/
		 */
		@SuppressWarnings("serial")
		List<String> emails = new ArrayList<String>() {
			{
				add("5@qq.com");
				add("email@domain.com");
				add("firstname.lastname@domain.com");
				add("email@subdomain.domain.com");
				add("firstname+lastname@domain.com");
				add("email@123.123.123.123");
				add("email@[123.123.123.123]");
				add("\"email\"@domain.com");
				add("1234567890@domain.com");
				add("email@domain-one.com");
				add("_______@domain.com");
				add("email@domain.name");
				add("email@domain.co.jp");
				add("firstname-lastname@domain.com");
			}
		};

		for (String email : emails) {
			Assert.assertTrue(CommonUtils.isValidEmail(email));
		}
	}

	@Test
	public void isValidEmailTestFail() {
		@SuppressWarnings("serial")
		List<String> emails = new ArrayList<String>() {
			{
				add(null);
				add("");
				add("4");
				add("5@.com");
				add("@qq.com");
				add("5@qq.");
				add("plainaddress");
				add("#@%^%#$@#$@#.com");
				add("@domain.com");
				// add("Joe Smith <email@domain.com>");
				add("email.domain.com");
				// add("email@domain@domain.com");
				// add(".email@domain.com");
				add("email.@domain.com");
				// add("email..email@domain.com");
				add("あいうえお@domain.com");
				// add("email@domain.com (Joe Smith)");
				add("email@domain");
				add("email@-domain.com");
				// add("email@domain.web");
				// add("email@111.222.333.44444");
				add("email@domain..com");
			}
		};

		for (String email : emails) {
			Assert.assertFalse(CommonUtils.isValidEmail(email));
		}
	}

	@Test
	public void isValidUrlTestOk() {
		/**
		 * https://daringfireball.net/misc/2010/07/url-matching-regex-test-data.text
		 */
		@SuppressWarnings("serial")
		List<String> urls = new ArrayList<String>() {
			{
				add("https://www.tuya.com");
				add("http://www.tuya.com");
				add("ftp://www.tuya.com");
				add("ftp://www.tuya.com.aa");
				add("ftp://www.tuya.com.aa?");
				add("http://foo.com/blah_blah");
				add("http://foo.com/blah_blah/");
				add("http://foo.com/blah_blah_(wikipedia)");
				add("http://foo.com/more_(than)_one_(parens)");
				add("http://foo.com/blah_(wikipedia)#cite-1");
				add("http://foo.com/blah_(wikipedia)_blah#cite-1");
				add("http://foo.com/unicode_(✪)_in_parens");
				add("http://foo.com/(something)?after=parens");
				add("http://foo.com/blah_blah.");
				add("http://foo.com/blah_blah/.");
				add("http://foo.com/blah_blah,");
				add("http://www.extinguishedscholar.com/wpglob/?p=364.");
				// add("http://✪df.ws/1234");
				// add("http://➡.ws/䨹");
				// add("www.c.ws/䨹");
				add("http://example.com/something?with,commas,in,url, but not at end");
				add("http://www.asianewsphoto.com/(S(neugxif4twuizg551ywh3f55))/Web_ENG/View_DetailPhoto.aspx?PicId=752");
				add("http://www.asianewsphoto.com/(S(neugxif4twuizg551ywh3f55))");
				add("http://lcweb2.loc.gov/cgi-bin/query/h?pp/horyd:@field(NUMBER+@band(thc+5a46634))");
			}
		};

		for (String url : urls) {
			Assert.assertTrue(CommonUtils.isValidUrl(url));
		}
	}

	@Test
	public void isValidUrlTestFail() {
		@SuppressWarnings("serial")
		List<String> urls = new ArrayList<String>() {
			{
				add(null);
				add("");
				add("6:00p");
				add("filename.txt");
				// add("http://example.com/quotes-are-“part”");
				add("✪df.ws/1234");
				add("example.com");
				add("example.com/");
			}
		};

		for (String url : urls) {
			System.out.println(url);
			Assert.assertFalse(CommonUtils.isValidUrl(url));
		}
	}
}
