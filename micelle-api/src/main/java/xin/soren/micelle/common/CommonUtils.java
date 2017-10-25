package xin.soren.micelle.common;

import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import xin.soren.micelle.exception.EncryptException;

/**
 * 
 * @Description: 公共方法
 * @author soren
 * @date 2017年9月24日 上午9:48:08
 *
 */
@Data
@Slf4j
public class CommonUtils {
	private static final String UTF8 = "UTF-8";
	private static final String MD5 = "md5";

	/**
	 * 
	 * @Description: 获取 JoinPoint 上指定的 annotation
	 * @param jp
	 * @param aspectClass
	 * @return
	 * @Throws
	 * @Date 2017年9月24日 上午9:59:58
	 */
	static public <T extends Annotation> T getAspect(JoinPoint jp, Class<T> aspectClass) {
		log.debug("getAspectValue, jp={}, aspectClass={}", jp, aspectClass);

		Signature signature = jp.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method targetMethod = methodSignature.getMethod();
		return targetMethod.getAnnotation(aspectClass);
	}

	/**
	 * 
	 * @Description: base64 编码字符串
	 * @param arg
	 * @return
	 * @Throws
	 * @Date 2017年10月11日 下午2:15:44
	 */
	public static String base64Encode(String arg) {
		try {
			return new String(Base64.encodeBase64(arg.getBytes(UTF8)));
		} catch (UnsupportedEncodingException e) {
			log.error("base64编码错误, {}", ExceptionUtils.getStackTrace(e));
			throw new EncryptException(e.toString());
		}
	}

	/**
	 * 
	 * @Description: base64 解码字符串
	 * @param arg
	 * @return
	 * @Throws
	 * @Date 2017年10月11日 下午2:16:30
	 */
	public static String base64Decode(String arg) {
		try {
			return new String(Base64.decodeBase64(arg.getBytes(UTF8)));
		} catch (UnsupportedEncodingException e) {
			log.error("base64解码错误, {}", ExceptionUtils.getStackTrace(e));
			throw new EncryptException(e.toString());
		}
	}

	/**
	 * 
	 * @Description: 计算字符串的 md5 值
	 * @param arg
	 * @return
	 * @Throws
	 * @Date 2017年10月11日 下午2:19:18
	 */
	public static String md5(String arg) {
		byte[] bs = arg.getBytes();
		try {
			MessageDigest digest = MessageDigest.getInstance(MD5);
			digest.update(bs);
			return Hex.encodeHexString(digest.digest());
		} catch (NoSuchAlgorithmException e) {
			log.error("md5编码错误, {}", ExceptionUtils.getStackTrace(e));
			throw new EncryptException(e.toString());
		}
	}

	/**
	 * 
	 * @Description: 获取一个 UUID
	 * @return
	 * @Throws
	 * @Date 2017年10月17日 下午1:53:17
	 */
	public static String uuid() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 
	 * @Description: 加密
	 * @param pwd
	 * @param salt
	 * @return
	 * @Throws
	 * @Date 2017年10月11日 下午2:21:16
	 */
	public static String encrypt(String pwd, String salt) {
		return md5(pwd + salt);
	}

	/**
	 * 
	 * @Description: 加密密码
	 * @param pwd
	 * @return
	 * @Throws
	 * @Date 2017年10月11日 下午4:42:02
	 */
	public static Pair<String, String> encrypt(String pwd) {
		String salt = uuid();
		String md5Pwd = encrypt(pwd, salt);
		return Pair.of(md5Pwd, salt);
	}

	// private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
	// .compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
	// Pattern.CASE_INSENSITIVE);
	/**
	 * http://emailregex.com/
	 */
	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(
			"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")"
					+ "@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",
			Pattern.CASE_INSENSITIVE);

	/**
	 * 
	 * @Description: 是否有效的 Email 地址
	 * @param email
	 * @return
	 * @Throws
	 * @Date 2017年10月11日 下午4:43:58
	 */
	public static boolean isValidEmail(String email) {
		if (email == null) {
			return false;
		}

		return VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
	}

	// private static final Pattern VALID_URL_ADDRESS_REGEX = Pattern.compile(
	// "^(http://|https://)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$",
	// Pattern.CASE_INSENSITIVE);
	private static final Pattern VALID_URL_ADDRESS_REGEX = Pattern.compile(
			"^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", Pattern.CASE_INSENSITIVE);

	/**
	 * 
	 * @Description: 是否是有效的 URL 地址
	 * @param url
	 * @return
	 * @Throws
	 * @Date 2017年10月11日 下午4:44:11
	 */
	public static boolean isValidUrl(String url) {
		if (url == null) {
			return false;
		}

		return VALID_URL_ADDRESS_REGEX.matcher(url).find();
	}
}
