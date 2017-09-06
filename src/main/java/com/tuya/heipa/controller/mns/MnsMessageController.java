package com.tuya.heipa.controller.mns;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v2.0")
@Slf4j
public class MnsMessageController {
	@RequestMapping(value = "/mns/notifications", method = RequestMethod.POST)
	public Object postNotifications(HttpServletRequest request, HttpServletResponse response) {
		log.debug(MessageFormat.format("处理MNS通知, {0}", request.getRequestURL().toString()));
		return null;
	}
}
