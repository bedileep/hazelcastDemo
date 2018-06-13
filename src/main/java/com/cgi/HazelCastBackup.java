package com.cgi;

import java.util.Map;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelCastBackup {

	public static void main(String[] args) {

		HazelcastInstance member1 = Hazelcast.newHazelcastInstance();
		HazelcastInstance member2 = Hazelcast.newHazelcastInstance();
		
		Map<Integer, String> customers = member1.getMap("customers");
			customers.put(1, "Customer 1");
			customers.put(2, "Customer 2");
			customers.put(3, "Customer 3");
			customers.put(4, "Customer 4");
			customers.put(5, "Customer 5");
		
		System.out.println("Number of nodes in cluser : "+ Hazelcast.getAllHazelcastInstances().size());
		
		try {
			System.out.println("adding a delay");
			Thread.sleep(60000);
			System.out.println("back to execution");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		member1.shutdown();
		
		System.out.println("Number of nodes in cluser after shutdown: "+ Hazelcast.getAllHazelcastInstances().size());
		
		Map<Integer, String> customersRestored = member2.getMap("customers");
		
		for(String customer : customersRestored.values()) {
			System.out.println(customer);
		}
		
	}

}
