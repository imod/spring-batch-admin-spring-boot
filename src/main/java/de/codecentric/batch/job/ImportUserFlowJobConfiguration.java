package de.codecentric.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// FIXME without this configuration everything is fine and all jobs can be loaded
@Configuration
public class ImportUserFlowJobConfiguration {

	@Bean
	public Step importUserJobStep(StepBuilderFactory stepBuilderFactory, Job importUserJob) {
		return stepBuilderFactory.get("importUserJobStep").job(importUserJob).build();
	}

	@Bean
	public Job importUserFlowJob(JobBuilderFactory jobBuilderFactory, Step importUserJobStep) {
		return jobBuilderFactory.get("importUserFlowJob").incrementer(new RunIdIncrementer()).flow(importUserJobStep).end().build();
	}

}
