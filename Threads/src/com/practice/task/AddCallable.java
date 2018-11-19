package com.practice.task;

import java.util.concurrent.Callable;

public class AddCallable implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		
		return 2+3;
	}

}
