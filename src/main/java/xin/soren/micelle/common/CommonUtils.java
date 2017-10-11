package xin.soren.micelle.common;

import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.tuple.Pair;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

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
	 * @throws UnsupportedEncodingException
	 * @Throws
	 * @Date 2017年10月11日 下午2:15:44
	 */
	public static String base64Encode(String arg) throws UnsupportedEncodingException {
		return new String(Base64.encodeBase64(arg.getBytes(UTF8)));
	}

	/**
	 * 
	 * @Description: base64 解码字符串
	 * @param arg
	 * @return
	 * @throws UnsupportedEncodingException
	 * @Throws
	 * @Date 2017年10月11日 下午2:16:30
	 */
	public static String base64Decode(String arg) throws UnsupportedEncodingException {
		return new String(Base64.decodeBase64(arg.getBytes(UTF8)));
	}

	/**
	 * 
	 * @Description: 计算字符串的 md5 值
	 * @param arg
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @Throws
	 * @Date 2017年10月11日 下午2:19:18
	 */
	public static String md5(String arg) throws NoSuchAlgorithmException {
		byte[] bs = arg.getBytes();
		MessageDigest digest = MessageDigest.getInstance(MD5);
		digest.update(bs);
		return Hex.encodeHexString(digest.digest());
	}

	/**
	 * 
	 * @Description: 加密
	 * @param pwd
	 * @param salt
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @Throws
	 * @Date 2017年10月11日 下午2:21:16
	 */
	public static String encrypt(String pwd, String salt) throws NoSuchAlgorithmException {
		return md5(pwd + salt);
	}

	public static Pair<String, String> encrypt(String pwd) throws NoSuchAlgorithmException {
		String salt = UUID.randomUUID().toString();
		String md5Pwd = encrypt(pwd, salt);
		return Pair.of(md5Pwd, salt);
	}
}
