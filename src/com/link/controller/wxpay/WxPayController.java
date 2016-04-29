package com.link.controller.wxpay;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.link.common.util.PlaseaUtil;
import com.link.common.util.PropUtil;
import com.link.common.util.WeiXinJsUtil;
import com.link.common.util.XmlUtil;
import com.link.service.weixin.WeixinInfoService;
import com.link.weixin.wxpay.UnifiedPayOrder;
import com.link.weixin.wxpay.WxPayInfo;
import com.link.weixin.wxpay.WxPayUtil;

@Controller
public class WxPayController {

	
	private static String APPID = PropUtil.getValue("weixinAppid");
	private static final Logger logger = Logger.getLogger(WxPayController.class);
	
	@Autowired
	private WeixinInfoService weixinInfoService;
	
	
	@RequestMapping(value="/wxpay/payTest.htm")
	public String wxPayTest(HttpServletRequest request){
		WeiXinJsUtil.fetchConfig(request);
		
		return "/wxpay/pay-test.html";
	}
	
	@RequestMapping(value="/wxpay/payReturn.htm")
	public String payReturn(HttpServletRequest request){
		WeiXinJsUtil.fetchConfig(request);
		
		return "/wxpay/pay-return.html";
	}
	
	
	@RequestMapping(value="/wxpay/wxPayBuildOrder.htm")
	@ResponseBody
	public Map wxPayBuildOrder(HttpServletRequest request){
		
		Map resultMap = new HashMap();
		
		String mch_id = PropUtil.getValue("mch_id");
		String notify_url = PropUtil.getValue("notify_url");
		String api_key = PropUtil.getValue("api_key");
		String weixinAppid = PropUtil.getValue("weixinAppid");
		String nonceStr = UUID.randomUUID().toString().replaceAll("-", "");
		
		//Integer userId = PlaseaUtil.getIntValueFromSession(request, "userId");
		//TWeixinInfo weixin = weixinInfoService.getWxByUserId(userId);
		String openId = PlaseaUtil.getStringValueFromSession(request, "openId");
		
		UnifiedPayOrder  order = new UnifiedPayOrder();
		
		order.setAppid(weixinAppid);
		order.setBody("fejife");
		order.setMch_id(mch_id);
		order.setNonce_str(nonceStr);
		order.setNotify_url(notify_url);
		//o n
		order.setOut_trade_no("10111111");
		order.setSpbill_create_ip(request.getRemoteAddr());
		order.setTotal_fee(1);
		order.setTrade_type("JSAPI");
		order.setOpenid(openId);
		order.setSign(WxPayUtil.getSign(order));
		
		String resultXml = WxPayUtil.unifiedOrder(order);
		logger.info("下单返回结果："+resultXml);
		
		
		
		Map result = XmlUtil.parsemXml(resultXml);
		if(result.containsKey("return_code")){
			if(result.get("return_code").equals("SUCCESS")){
				if(result.containsKey("result_code")){
					if(result.get("result_code").equals("SUCCESS")){
						resultMap.put("prepay_id", result.get("prepay_id"));
						
						WxPayInfo payInfo = new WxPayInfo();
						payInfo.setAppId(weixinAppid);
						payInfo.setNonceStr(UUID.randomUUID().toString().replaceAll("-", ""));
						String packageInfo="prepay_id="+result.get("prepay_id");
						payInfo.setPackage2(packageInfo);
						payInfo.setSignType("MD5");
						String timeStamp = String.valueOf(System.currentTimeMillis());
						payInfo.setTimeStamp(timeStamp);
						
						String paySign = WxPayUtil.getPaySign(payInfo);
						payInfo.setPaySign(paySign);
						logger.info("支付签名信息："+payInfo.toString());
						logger.info("支付签名结果："+paySign);
						resultMap.put("payInfo", payInfo);
						
						resultMap.put("resultCode", "00");
					}
				}
			}
		}
		
		
			
		
		return resultMap;
	}
	
	
	
	
	
	
}
