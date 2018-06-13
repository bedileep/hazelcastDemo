package com.cgi;

import java.util.List;
import java.util.Map;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelCastListBackup {

	public static void main(String[] args) {

		HazelcastInstance member1 = Hazelcast.newHazelcastInstance();
		HazelcastInstance member2 = Hazelcast.newHazelcastInstance();
		
		List<String> names = member1.getList("CustomerNames");
			names.add("Cust Name 1");
			names.add("Cust Name 2");
			names.add("Cust Name 3");
			names.add("Cust Name 4");
			names.add("Cust Name 5");
			
		System.out.println("Number of nodes in cluser : "+ Hazelcast.getAllHazelcastInstances().size());
		
		/*try {
			System.out.println("adding a delay");
			Thread.sleep(60000);
			System.out.println("back to execution");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		member1.shutdown();
		
		System.out.println("Number of nodes in cluser after shutdown: "+ Hazelcast.getAllHazelcastInstances().size());
		
		List<String> namesRestored = member2.getList("CustomerNames");
		
		for(String name : namesRestored) {
			System.out.println(name);
		}
		
	}

}
