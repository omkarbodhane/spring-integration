/*
 * Copyright 2002-2010 the original author or authors.
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

package org.springframework.integration.router;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.integration.core.Message;
import org.springframework.integration.core.MessageChannel;
import org.springframework.util.Assert;

/**
 * A Message Router that sends Messages to a statically configured list of
 * recipients. The recipients are provided as a list of {@link MessageChannel}
 * instances. For dynamic recipient lists, consider instead using the @Router
 * annotation or extending {@link AbstractChannelNameResolvingMessageRouter}. 
 * 
 * @author Mark Fisher
 */
public class RecipientListRouter extends AbstractMessageRouter implements InitializingBean {

	private volatile List<MessageChannel> channels;


	public void setChannels(List<MessageChannel> channels) {
		this.channels = channels;
	}

	public void afterPropertiesSet() {
		Assert.notEmpty(this.channels, "a non-empty channel list is required");
	}

	@Override
	protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
		return new ArrayList<MessageChannel>(this.channels);
	}

}