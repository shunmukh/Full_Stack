package com.practice;

import com.practice.task.AddTask;
import com.practice.task.DivTask;

public class ThreadMultiTask {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(System.currentTimeMillis());
		new Thread(new AddTask()).start();
		new Thread(new DivTask()).start();
		new Thread(new AddTask()).start();
		new Thread(new DivTask()).start();
		new Thread(new AddTask()).start();
		new Thread(new DivTask()).start();
		System.out.println(System.currentTimeMillis());
	}

}
