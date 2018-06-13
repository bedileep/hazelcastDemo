package com.cgi;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

public class HazelCastClientMain {

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.getGroupConfig().setName("POC");
		clientConfig.getGroupConfig().setPassword("dev-pass"); 
		//clientConfig.addAddress("127.0.0.1:5702");
		HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
		//System.out.println("end point is: "+client.getLocalEndpoint().getSocketAddress());
        Map<String, String> empMap = client.getMap( "employees" );
        Set<String> persons = client.getSet("persons");
        List<String> countries = client.getList("countries");
        System.out.println( "***************Map Size: " + empMap.size()+"***************" );
        for(Map.Entry<String, String> entry : empMap.entrySet()) {
        	System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        
        System.out.println("***************Set Size: " + persons.size()+"***************");
        for (String s : persons) {
        	System.out.println("Person = " + s);
        }
        System.out.println("***************List Size: " + countries.size()+"***************");
        for(String s : countries) {
        	System.out.println("Country "+ s);
        }
	}

}
