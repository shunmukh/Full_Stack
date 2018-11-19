package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.practice.task.AddCallable;
import com.practice.task.DivCallable;

public class ThreadExecutorWithCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService serv = Executors.newFixedThreadPool(2);
		
		Future<Integer> f1 = serv.submit(new AddCallable());
		Future<Integer> f2 = serv.submit(new DivCallable());
		
		System.out.println(f1.get());
		System.out.println(f2.get());
		
		List<Callable<Integer>> tasks = new ArrayList<>();
		tasks.add(new AddCallable());
		tasks.add(new DivCallable());
		List<Future<Integer>> lf = serv.invokeAll(tasks,120,TimeUnit.SECONDS);
		
		for(Future<Integer> f :lf)
		{
			System.out.println(f.get());
		}
		
		serv.shutdown();

	}

}
