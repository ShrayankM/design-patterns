package org.example.questions.notification;

public class StringUtil {

	/**
	 * This function will convert the message template into actual message by replacing placeholders
	 * with actual values The number of parameters in placeHolders and values array must be the same.
	 *
	 * @param messageTemplate Message with placeHolders with `` eg Exception is `message` for `id`
	 * @param placeHolders Placeholders in message template without ` eg. new String[]{"message","id"}
	 * @param values Values to be replaced in place of placeholders eg. new Object[]{"sample message",
	 *        storeId}
	 * @return
	 */
	public static String getFinalMessage(String messageTemplate, String[] placeHolders, Object[] values) {
		String message = messageTemplate;
		if (placeHolders.length != values.length) {
			throw new RuntimeException("Placeholders and actual values must be of equal length");
		}
		int length = placeHolders.length;
		for (int i = 0; i < length; i++) {
			message = message.replace("`" + placeHolders[i] + "`", values[i] == null ? "" : values[i].toString());
		}

		return message;

	}

}
