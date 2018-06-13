package com.cgi;

import java.util.concurrent.BlockingQueue;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelCastQueueInstance {

	public static void main(String[] args) {

		HazelcastInstance instance = Hazelcast.newHazelcastInstance();
		
		BlockingQueue<String> queue = instance.getQueue("queue");
		
		try {
		for(;;) {
			//queue.take();
			System.out.println("Message in the queue is : "+queue.take());
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
