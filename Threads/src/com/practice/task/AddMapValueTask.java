package com.practice.task;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class AddMapValueTask implements Runnable {
	Map<String, String> cm;

	public AddMapValueTask(Map<String, String> cm2) {
		super();
		this.cm = cm2;
	}

	@Override
	public void run() {
		int i=0;
		while(true)
		{
			
			cm.put("hi"+(i++), i+"");
		}

	}

}
