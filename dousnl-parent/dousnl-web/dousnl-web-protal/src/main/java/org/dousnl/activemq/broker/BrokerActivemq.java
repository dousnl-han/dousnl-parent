package org.dousnl.activemq.broker;

import org.apache.activemq.broker.BrokerService;

public class BrokerActivemq {

	public static void main(String[] args) throws Exception {
		BrokerService broker=new BrokerService();
		broker.addConnector("tcp://localhost:61616");
		broker.setBrokerName("broker1");
		broker.setUseJmx(true);
		broker.setPassiveSlave(false);
		broker.start();
	}

}
