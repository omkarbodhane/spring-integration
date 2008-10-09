/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

import org.springframework.transaction.annotation.Transactional;

/**
 * Annotation that can be specified at method-level alongside a Message Endpoint
 * annotation (e.g. @Splitter, @ChannelAdapter, etc.) in order to provide the
 * polling metadata and scheduling information for that endpoint.
 * 
 * @author Mark Fisher
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Poller {

	int interval();

	long initialDelay() default 0;

	boolean fixedRate() default false;

	TimeUnit timeUnit() default TimeUnit.MILLISECONDS;

	int maxMessagesPerPoll() default -1;

	Transactional transactionAttributes() default @Transactional;

	String transactionManager() default "";

	String[] adviceChain() default {};

}
