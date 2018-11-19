package com.practice.task;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;

public class ForEachTask implements Runnable {
	Map<String, String> cm;
	public ForEachTask(Map<String, String> cm2) {
		super();
		this.cm = cm2;
	}

	@Override
	public void run() {

		for(Entry<String, String> e : cm.entrySet())
		{
			System.out.println(e.getKey()+"   "+e.getValue());
		}
		


	}

	

}
