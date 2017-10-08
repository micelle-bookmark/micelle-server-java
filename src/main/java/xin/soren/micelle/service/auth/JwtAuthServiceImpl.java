package xin.soren.micelle.service.auth;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Description: 认证服务默认实现类
 * @author soren
 * @date 2017年9月29日 下午2:41:37
 *
 */
@Service
@ConfigurationProperties(prefix = "jwt")
@Data
@Slf4j
public class JwtAuthServiceImpl implements AuthService {

	private String secret;
	private String id;

	@PostConstruct
	public void init() {
		log.info("使用 JWT 配置: secret={}, id={}", secret, id);
	}

	private SecretKey key() {
		byte[] encodedKey = Base64.decodeBase64(secret);
		return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
	}

	@Override
	public String create(String subject, long ttlMillis) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		SecretKey key = key();
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).signWith(signatureAlgorithm,
				key);
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		return builder.compact();
	}

	@Override
	public String parse(String jwt) {
		SecretKey key = key();
		try {
			Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();
			return claims.getSubject();
		} catch (ExpiredJwtException e) {
			return null;
		} catch (SignatureException e) {
			return null;
		} catch (UnsupportedJwtException | MalformedJwtException e) {
			return null;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
}
