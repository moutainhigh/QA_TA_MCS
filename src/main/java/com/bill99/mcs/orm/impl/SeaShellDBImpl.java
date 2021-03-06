package com.bill99.mcs.orm.impl;

import com.bill99.mcs.common.dto.Deal;
import com.bill99.mcs.common.dto.Entry;
import com.bill99.mcs.common.dto.PaymentOrder;
import com.bill99.mcs.common.dto.TAcctTxn;
import com.bill99.mcs.orm.SeaShellDBService;
import com.bill99.qa.framework.jdbc.TaDbHandller;

import java.util.List;

/**
 * Description: seashell数据库基础服务实现
 * Author: zhenfeng.liu
 * Date: 2017/10/18 15:13
 */
public class SeaShellDBImpl implements SeaShellDBService {
    private TaDbHandller taSeashellDbHandller;
    private String username;
    private String password;

    public void setTaSeashellDbHandller(TaDbHandller taSeashellDbHandller) {
        this.taSeashellDbHandller = taSeashellDbHandller;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public List <TAcctTxn> queryTAcctTxnInfo (TAcctTxn tAcctTxn) {
        return taSeashellDbHandller.queryForList("TAcctTxn.getTAcctTxn", tAcctTxn);
    }

    @Override
    public List<PaymentOrder> queryPaymentOrderInfo(PaymentOrder paymentOrder) {
        System.err.println("返回列表size:"+taSeashellDbHandller.queryForList("PaymentOrder.getPaymentOrder", paymentOrder).size());
        return taSeashellDbHandller.queryForList("PaymentOrder.getPaymentOrder", paymentOrder);
    }

    @Override
    public List<Deal> queryDealInfo(Deal deal) {
        return taSeashellDbHandller.queryForList("Deal.getDeal", deal);
    }

    @Override
    public List<Entry> queryEntryInfo(Entry entry) {
        return taSeashellDbHandller.queryForList("Entry.getEntry", entry);
    }

    @Override
    public List<Entry> queryEntryInfoByDealIds(List<String> dealIds) {
        return taSeashellDbHandller.queryForList("Entry.getEntryByDealIds", dealIds);
    }
}
