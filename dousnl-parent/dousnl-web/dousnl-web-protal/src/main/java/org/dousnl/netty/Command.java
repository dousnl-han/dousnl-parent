package org.dousnl.netty;

import java.io.Serializable;

/**
 * @author hanliang
 *
 */
public class Command implements Serializable{

	private static final long serialVersionUID = -9222864144887837948L;

	private String actionName;
	
	private String actionDate;

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getActionDate() {
		return actionDate;
	}

	public void setActionDate(String actionDate) {
		this.actionDate = actionDate;
	}
	
}
