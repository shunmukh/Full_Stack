package com.practice.task;

import java.util.concurrent.Callable;

public class DivCallable implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		
		return 4/2;
	}

}
