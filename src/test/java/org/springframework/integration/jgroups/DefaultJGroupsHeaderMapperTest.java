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
package org.springframework.integration.jgroups;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.MapAssert.entry;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

import org.jgroups.Message;
import org.jgroups.Message.Flag;
import org.jgroups.stack.IpAddress;
import org.junit.Test;
import org.springframework.integration.MessageHeaders;
import org.springframework.integration.jgroups.DefaultJGroupsHeaderMapper;

public class DefaultJGroupsHeaderMapperTest {

	@Test
	public void should_map_to_src_address() throws Exception {
		DefaultJGroupsHeaderMapper headerMapper = new DefaultJGroupsHeaderMapper();

		IpAddress src = new IpAddress(Inet4Address.getByName("192.168.0.1"), 6666);

		Message source = new Message(null, src, null);

		Map<String, Object> headers = headerMapper.toHeaders(source);

		assertThat(headers).includes(entry("src", src));
	}

	@Test
	public void should_map_to_dest_address() throws Exception {
		DefaultJGroupsHeaderMapper headerMapper = new DefaultJGroupsHeaderMapper();

		IpAddress dest = new IpAddress(Inet4Address.getByName("192.168.0.1"), 6666);

		Message source = new Message(dest, null, null);

		Map<String, Object> headers = headerMapper.toHeaders(source);

		assertThat(headers).includes(entry("dest", dest));
	}

	@Test
	public void should_map_to_OOB_flag() {
		DefaultJGroupsHeaderMapper headerMapper = new DefaultJGroupsHeaderMapper();

		Message source = new Message(null, null, null);

		source.setFlag(Flag.OOB);

		Map<String, Object> headers = headerMapper.toHeaders(source);

		assertThat(headers).includes(entry("OOB", true));

	}

	@Test
	public void should_map_to_DONT_BUNDLE_flag() {
		DefaultJGroupsHeaderMapper headerMapper = new DefaultJGroupsHeaderMapper();

		Message source = new Message(null, null, null);

		source.setFlag(Flag.DONT_BUNDLE);

		Map<String, Object> headers = headerMapper.toHeaders(source);

		assertThat(headers).includes(entry("DONT_BUNDLE", true));

	}

	@Test
	public void should_map_to_NO_FC_flag() {
		DefaultJGroupsHeaderMapper headerMapper = new DefaultJGroupsHeaderMapper();

		Message source = new Message(null, null, null);

		source.setFlag(Flag.NO_FC);

		Map<String, Object> headers = headerMapper.toHeaders(source);

		assertThat(headers).includes(entry("NO_FC", true));

	}

	@Test
	public void should_map_to_SCOPED_flag() {
		DefaultJGroupsHeaderMapper headerMapper = new DefaultJGroupsHeaderMapper();

		Message source = new Message(null, null, null);

		source.setFlag(Flag.SCOPED);

		Map<String, Object> headers = headerMapper.toHeaders(source);

		assertThat(headers).includes(entry("SCOPED", true));

	}

	@Test
	public void should_map_to_NO_RELIABILITY_flag() {
		DefaultJGroupsHeaderMapper headerMapper = new DefaultJGroupsHeaderMapper();

		Message source = new Message(null, null, null);

		source.setFlag(Flag.NO_RELIABILITY);

		Map<String, Object> headers = headerMapper.toHeaders(source);

		assertThat(headers).includes(entry("NO_RELIABILITY", true));

	}

	@Test
	public void should_map_to_NO_TOTAL_ORDER_flag() {
		DefaultJGroupsHeaderMapper headerMapper = new DefaultJGroupsHeaderMapper();

		Message source = new Message(null, null, null);

		source.setFlag(Flag.NO_TOTAL_ORDER);

		Map<String, Object> headers = headerMapper.toHeaders(source);

		assertThat(headers).includes(entry("NO_TOTAL_ORDER", true));

	}

	@Test
	public void should_map_to_NO_RELAY_flag() {
		DefaultJGroupsHeaderMapper headerMapper = new DefaultJGroupsHeaderMapper();

		Message source = new Message(null, null, null);

		source.setFlag(Flag.NO_RELAY);

		Map<String, Object> headers = headerMapper.toHeaders(source);

		assertThat(headers).includes(entry("NO_RELAY", true));

	}

	@Test
	public void should_map_to_RSVP_flag() {
		DefaultJGroupsHeaderMapper headerMapper = new DefaultJGroupsHeaderMapper();

		Message source = new Message(null, null, null);

		source.setFlag(Flag.RSVP);

		Map<String, Object> headers = headerMapper.toHeaders(source);

		assertThat(headers).includes(entry("RSVP", true));

	}
	
	@Test
	public void should_map_from_OOB_flag(){
		DefaultJGroupsHeaderMapper headerMapper = new DefaultJGroupsHeaderMapper();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("OOB", true);
		MessageHeaders headers = new MessageHeaders(map);
		
		Message target = new Message();
		headerMapper.fromHeaders(headers, target);
		
		assertThat(target.isFlagSet(Flag.OOB));
	}

}
