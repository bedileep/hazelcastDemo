package com.cgi;

import java.util.Map;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelCastMain {

	public static void main(String[] args) {

		HazelcastInstance hz = Hazelcast.newHazelcastInstance();
		
		
		Map<String, String> employees = hz.getMap("default");
		
		for(int i=10;i<1000;i++) {
			employees.put(""+i, "emp"+i);
		}
				
		}
	
}
