package org.example.questions.notification;

import java.util.List;

public class OrderTemplate implements Template {
	private final static String orderTemplate = "Hi `name` your order-id `order-id` is confirmed";

	@Override
	public String returnTemplate(List<String> templateData) {
		return StringUtil.getFinalMessage(orderTemplate,
				new String[] {"name", "order-id"},
				new String[] {templateData.get(0), templateData.get(1)});
	}
}
