package de.codecentric.batch.job;

import java.util.concurrent.FutureTask;

import org.springframework.batch.core.ItemProcessListener;

public class PersonItemProcessListener implements ItemProcessListener<Person, FutureTask<Person>> {

	@Override
	public void beforeProcess(Person item) {
		System.out.println("****PersonItemProcessListener.beforeProcess()");
	}

	@Override
	public void afterProcess(Person item, FutureTask<Person> result) {
		System.out.println("****PersonItemProcessListener.afterProcess()");
	}

	@Override
	public void onProcessError(Person item, Exception e) {
		System.out.println("****PersonItemProcessListener.onProcessError()");
	}

}
