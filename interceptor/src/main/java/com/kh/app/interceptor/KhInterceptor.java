package com.kh.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.plugin.Intercepts;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@
public class KhInterceptor implements HandlerInterceptor{

	/**
	 * 요청 처리 전
	 * true: handler 까지 넘김
	 * false: handler 까지 넘기지 않음 
	 * handler = Controller의 method
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("요청 처리전에 간섭");
		return true;
	}

	/**
	 * 요청 처리 직후
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("요청 처리 후에 간섭");
	}

	/**
	 * 사용자에게 출력되기 직전
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("결과 출력 전에 간섭");
	}

}
