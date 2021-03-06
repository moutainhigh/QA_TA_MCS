package com.bill99.fi.test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import shelper.iffixture.HttpFixture;

import com.bill99.qa.framework.testcase.BaseTestCase;
import com.bill99.fi.access.http.DoSubmit;
import com.bill99.fi.common.helper.ParameterDispose;
import com.bill99.fi.common.helper.ParameterSignMsg;
import com.bill99.fi.common.helper.ParameterSource;
import com.bill99.fi.orm.dao.LogDbCheck;
import com.bill99.fi.orm.mng.GatewayDbCheck;
import com.bill99.fi.service.gateway.GatewayPageSubmit;
import com.bill99.fi.service.payments.PaymentController;

public class DepositCardClickFirstPay extends BaseTestCase {

	@Autowired
	private DoSubmit doSubmit;
	@Autowired
	private GatewayPageSubmit gatewayPageSubmit;

	@Autowired
	private PaymentController paymentController;
	@Autowired
	private ParameterSignMsg parameterSignMsg;
	@Autowired
	private GatewayDbCheck gatewayDbCheck;
	@Autowired
	private LogDbCheck logDbCheck;

	@Test(description = "网关3.0储蓄卡快捷首次支付", dataProvider = "depositCardClickFirstPay", timeOut = 120000, enabled = true)
	public void depositCardClickFirstPay(Map<String, String> data) {
		Reporter.start("当前测试--------：" + data.get("name") + "开始！");
		// 添加一些字段的默认值
		ParameterDispose.addDefaultValue(data);
		if (data.get("signMsg").equals("")) {

			data.put("signMsg", parameterSignMsg.SignMsg(
					ParameterSource.gatewayParameter, data));
		}

		// 网关提交
		HttpFixture query = doSubmit.gatewaySubmit(data);
		// 选择支付方式
		gatewayPageSubmit.selectPayType(query, data);
		//选择银行———目的是恢复首次支付
		gatewayPageSubmit.selectDepositPayBank(query, data);
		//快捷支付
		boolean payResult = paymentController.gateway3DepositPay(query, data);
		if (payResult) {
			Reporter.log("+++++++++++提交成功+++++++++++");
			Reporter.log(data.get("name"),gatewayDbCheck.checkGatewayCNPDeal(data, 1)&& logDbCheck.notifyLogDbCkeck(data));

		} else {
			Reporter.log(data.get("name"), payResult);
		}
		System.out.println("data！！！！！！！！！！！！！！！！！！！！！！"+data);

		Reporter.end("当前测试--------：" + data.get("name") + "结束！");
				
	}


	@BeforeClass
	public void beforeClass() {

	}

	@AfterClass
	public void afterClass() {

	}

	@DataProvider(name = "depositCardClickFirstPay")
	public Iterator<Object[]> data4test() throws IOException {
		return ExcelProviderByEnv(this, "depositCardClickFirstPay");
	}

}
