package com.practice;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.practice.task.AddMapValueTask;
import com.practice.task.ForEachTask;

public class ConcurrenMapExample {

	public static void main(String[] args) {
		
		ConcurrentMap< String, String> cm = new ConcurrentHashMap<>();
		//Map<String, String> cm = new HashMap<String, String>();
		ThreadPoolExecutor ex = new ThreadPoolExecutor(2, 2, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
		ex.submit(new AddMapValueTask(cm));
		ex.submit(new ForEachTask(cm));
		
		
		
		
	}

}
