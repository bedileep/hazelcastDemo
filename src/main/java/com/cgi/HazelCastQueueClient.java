package com.cgi;

import java.util.Queue;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.HazelcastInstance;

public class HazelCastQueueClient {

	public static void main(String[] args) {

		ClientConfig config = new ClientConfig();
		
		GroupConfig grpConfig = new GroupConfig();
		grpConfig.setName("POC");
		grpConfig.setPassword("dev-pass");
		config.setGroupConfig(grpConfig);
		HazelcastInstance client = HazelcastClient.newHazelcastClient(config);
		
		Queue<String> queue = client.getQueue("queue");
		
		queue.add("Sent from Client..!!");
		
		client.shutdown();
		
	}

}
