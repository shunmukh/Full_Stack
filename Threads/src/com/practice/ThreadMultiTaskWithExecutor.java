package com.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.practice.task.AddTask;
import com.practice.task.DivTask;

public class ThreadMultiTaskWithExecutor {

	public static void main(String[] args) {
	
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		service.execute(new AddTask());
		service.execute(new DivTask());
		service.execute(new AddTask());
		service.execute(new AddTask());
		service.execute(new DivTask());
		service.execute(new AddTask());
		
		service.shutdown();
		
	}

}
