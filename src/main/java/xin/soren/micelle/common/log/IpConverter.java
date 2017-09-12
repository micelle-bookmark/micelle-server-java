package xin.soren.micelle.common.log;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.MessageFormat;
import java.util.Enumeration;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 日志中的 ip 关键字
 * @author yangsonglin
 * @date 2017年8月31日 上午11:01:16
 * @version V2.0
 */
@Slf4j
@Component
public class IpConverter extends ClassicConverter {

	/**
	 * 服务器ip
	 */
	private static String serverIp;

	@Override
	public String convert(ILoggingEvent arg0) {
		if (StringUtils.isBlank(serverIp)) {
			serverIp = getMyIp2();
			log.info(MessageFormat.format("获取到 server.ip={0}", serverIp));
		}
		return serverIp;
	}

	/**
	 * 获取服务器ip
	 * 
	 * @return
	 */
	private String getMyIp() {
		String localip = null;// 本地IP，如果没有配置外网IP则返回它
		String netip = null;// 外网IP
		try {
			Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress ip = null;
			boolean finded = false;// 是否找到外网IP
			while (netInterfaces.hasMoreElements() && !finded) {
				NetworkInterface ni = netInterfaces.nextElement();
				Enumeration<InetAddress> address = ni.getInetAddresses();
				while (address.hasMoreElements()) {
					ip = address.nextElement();
					if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
						netip = ip.getHostAddress();
						finded = true;
						break;
					} else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
							&& ip.getHostAddress().indexOf(":") == -1) {// 内网IP
						localip = ip.getHostAddress();
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}

		String reutnIp = "";
		if (netip != null && !"".equals(netip)) {
			reutnIp = netip;
		} else {
			reutnIp = localip;
		}
		return reutnIp;
	}

	/**
	 * 获取服务器ip
	 * 
	 * @return
	 */
	private String getMyIp2() {
		String host = "";
		try {
			host = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return host;
	}
}
