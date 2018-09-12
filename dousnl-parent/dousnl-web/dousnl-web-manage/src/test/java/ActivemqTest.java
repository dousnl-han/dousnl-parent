import javax.jms.JMSException;

import org.dousnl.shiro.domain.User;
import org.dousnl.util.ActiveMqUtil;

import com.alibaba.fastjson.JSON;

public class ActivemqTest {

	public static void main(String[] args) {
		User u=new User(4,"xiaoming","xiaoming",4);
		String msg=JSON.toJSONString(u);
		try {
			ActiveMqUtil.creatQueue("save.user", msg);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
