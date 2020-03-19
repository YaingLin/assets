package com.ossjk.asset.base.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ossjk.asset.common.util.CommonUtil;
import com.ossjk.asset.common.util.Constant;
import com.ossjk.asset.common.vo.DwzResultBean;
import com.ossjk.asset.system.entity.User;

public class BaseController {

	protected User getCurrentEmp() {
		return (User) getRequest().getSession().getAttribute(Constant.SESSION_USER_KEY);
	}

	/**
	 * 得到request对象
	 */
	protected HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		return request;
	}

	/**
	 * 响应DWZ成功的Ajax请求
	 *
	 * @return
	 */
	protected Object ajaxSuccess() {
		return ajaxDone(Constant.DWZRESULT_STATUSCODE_SUCCESS, Constant.DWZRESULT_MESSAGE_SUCCESS);
	}

	/**
	 * 响应DWZ成功的Ajax请求
	 *
	 * @param message
	 *            提示消息
	 * @return
	 */
	protected Object ajaxSuccess(String message) {
		return ajaxDone(Constant.DWZRESULT_STATUSCODE_SUCCESS, message);
	}

	/**
	 * 响应DWZ成功的Ajax请求
	 *
	 * @param message
	 *            提示消息
	 * @param content
	 *            返回前端内容
	 * @return
	 */
	protected Object ajaxSuccess(String message, Object content) {
		return ajaxDone(Constant.DWZRESULT_STATUSCODE_SUCCESS, message, content);
	}

	/**
	 * 响应DWZ成功的Ajax请求
	 *
	 * @param content
	 *            返回前端内容
	 * @return
	 */
	protected Object ajaxSuccess(Object content) {
		return ajaxDone(Constant.DWZRESULT_STATUSCODE_SUCCESS, Constant.DWZRESULT_MESSAGE_SUCCESS, content);
	}

	/**
	 * 响应DWZ失败的Ajax请求
	 *
	 * @return
	 */
	protected Object ajaxError() {
		return ajaxDone(Constant.DWZRESULT_STATUSCODE_ERROR, Constant.DWZRESULT_MESSAGE_ERROR);
	}

	/**
	 * 响应DWZ失败的Ajax请求
	 *
	 * @param message
	 *            提示消息
	 * @return
	 */
	protected Object ajaxError(String message) {
		return ajaxDone(Constant.DWZRESULT_STATUSCODE_ERROR, message);
	}

	/**
	 * 响应DWZ失败的Ajax请求
	 *
	 * @param message
	 *            提示消息
	 * @param content
	 *            返回前端内容
	 * @return
	 */
	protected Object ajaxError(String message, Object content) {
		return ajaxDone(Constant.DWZRESULT_STATUSCODE_ERROR, message, content);
	}

	/**
	 * 响应DWZ失败的Ajax请求
	 *
	 * @param content
	 *            返回前端内容
	 * @return
	 */
	protected Object ajaxError(Object content) {
		return ajaxDone(Constant.DWZRESULT_STATUSCODE_ERROR, Constant.DWZRESULT_MESSAGE_ERROR, content);
	}

	/**
	 * 响应DWZ的Ajax请求
	 *
	 * @param statusCode
	 *            statusCode:{ok:200, error:300, timeout:301}.
	 * @param message
	 *            提示消息
	 */
	protected Object ajaxDone(String statusCode, String message) {
		return getResultBean(statusCode, message);
	}

	/**
	 * 响应DWZ的Ajax请求
	 *
	 * @param statusCode
	 *            statusCode:{ok:200, error:300, timeout:301}.
	 * @param message
	 *            提示消息
	 * @param content
	 *            返回前端内容
	 */
	protected Object ajaxDone(String statusCode, String message, Object content) {
		return getResultBean(statusCode, message, content);
	}

	/**
	 * 根据request对象，获取页面提交过来的DWZ框架的AjaxDone响应参数值.
	 *
	 * @param statusCode
	 *            状态码.
	 * @param message
	 *            操作结果提示消息.
	 * @return DwzParam :封装好的DwzParam对象 .
	 */
	protected DwzResultBean getResultBean(String statusCode, String message) {
		// 获取DWZ Ajax响应参数值,并构造成参数对象
		HttpServletRequest req = getRequest();
		String navTabId = req.getParameter("navTabId");
		String dialogId = req.getParameter("dialogId");
		String callbackType = req.getParameter("callbackType");
		String forwardUrl = req.getParameter("forwardUrl");
		String rel = req.getParameter("rel");
		return new DwzResultBean(statusCode, message, navTabId, dialogId, callbackType, forwardUrl, rel, null, null);
	}

	/**
	 * 根据request对象，获取页面提交过来的DWZ框架的AjaxDone响应参数值.
	 *
	 * @param statusCode
	 *            状态码.
	 * @param message
	 *            操作结果提示消息.
	 * @param content
	 *            返回前端内容.
	 * @return DwzParam :封装好的DwzParam对象 .
	 */
	protected DwzResultBean getResultBean(String statusCode, String message, Object content) {
		// 获取DWZ Ajax响应参数值,并构造成参数对象
		HttpServletRequest req = getRequest();
		String navTabId = req.getParameter("navTabId");
		String dialogId = req.getParameter("dialogId");
		String callbackType = req.getParameter("callbackType");
		String forwardUrl = req.getParameter("forwardUrl");
		String rel = req.getParameter("rel");
		return new DwzResultBean(statusCode, message, navTabId, dialogId, callbackType, forwardUrl, rel, null, content);
	}

	@ExceptionHandler(Exception.class)
	public Object exception(Exception e, HttpServletRequest request, HttpServletResponse response) throws IOException {
		e.printStackTrace();
		request.setAttribute("exception", e);
		if (isAjax(request) || request.getParameter("ajax") != null) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(JSON.toJSONString(ajaxError(e.getMessage())));
			return null;
		}
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("statusCode", 300);
		mav.addObject("message", e.getMessage());
		return mav;
	}

	public static boolean isAjax(HttpServletRequest request) {
		if (request != null && "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With")))
			return true;
		return false;
	}

	/**
	 * 获取访问者IP
	 * <p>
	 * 在一般情况下使用Request.getRemoteAddr()即可，但是经过nginx等反向代理软件后，这个方法会失效。
	 * <p>
	 * 本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)， 如果还不存在则调用Request
	 * .getRemoteAddr()。
	 *
	 * @param request
	 * @return
	 */
	protected String getAddr() throws Exception {
		HttpServletRequest request = getRequest();

		String ip = request.getHeader("X-Real-IP");
		if (!CommonUtil.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!CommonUtil.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			return request.getRemoteAddr();
		}
	}
}
