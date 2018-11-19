package com.practice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.practice.task.AddTask;

public class ThreadPoolExecutorExample {

	public static void main(String[] args) {
		
		ThreadPoolExecutor te = new ThreadPoolExecutor(2, 2, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
		te.submit(new AddTask());
		te.submit(new AddTask());
		te.setRejectedExecutionHandler(new RejectedExecutionHandler() {
			
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				System.out.println(r+"rejected"+executor.toString());
				
			}
		});
		te.shutdown();

		ThreadPoolEx ex = new ThreadPoolEx(2, 2, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
		ex.execute(new AddTask());
		ex.execute(new AddTask());
		ex.execute(new AddTask());
		ex.execute(new AddTask());
		ex.shutdown();
		
	}

	public static class ThreadPoolEx extends ThreadPoolExecutor
	{

		@Override
		public void shutdown() {
			// TODO Auto-generated method stub
			System.out.println("Before shutdown");
			super.shutdown();
		}

		@Override
		protected void beforeExecute(Thread t, Runnable r) {
			// TODO Auto-generated method stub
			super.beforeExecute(t, r);
			System.out.println(t+"Before Execute");
		}

		@Override
		protected void afterExecute(Runnable r, Throwable t) {
			// TODO Auto-generated method stub
			System.out.println(t+"After Execute");
			super.afterExecute(r, t);
			
		}

		public ThreadPoolEx(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
				BlockingQueue<Runnable> workQueue) {
			super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
			// TODO Auto-generated constructor stub
		}
		
	}
	
	
}
