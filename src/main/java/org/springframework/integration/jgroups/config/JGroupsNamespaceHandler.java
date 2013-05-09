/**
 * Copyright 2013 Jaroslaw Palka<jaroslaw.palka@symentis.pl>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.integration.jgroups.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class JGroupsNamespaceHandler extends NamespaceHandlerSupport{

	public void init() {
		registerBeanDefinitionParser("inbound-channel-adapter", new JGroupsInboundChannelAdapterParser());
		registerBeanDefinitionParser("outbound-channel-adapter", new JGroupsOutboundChannelAdapterParser());
		
		registerBeanDefinitionParser("cluster", new JGroupsClusterAdapterParser());
	}

}
