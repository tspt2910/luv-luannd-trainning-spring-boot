package com.jp.api.utils;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * Translator code to message
 *
 */
@AllArgsConstructor
@Component
public class ErrorTranslator {
	
	private final MessageSource msg;
	
	
	/**
	 * Get message from message properties.
	 *
	 * @param code message code
	 *
	 * @return message get from Message properties
	 */
	public String translate(String code, Object... args) {
		return msg.getMessage(code, args, LocaleContextHolder.getLocale());
	}
	
}
