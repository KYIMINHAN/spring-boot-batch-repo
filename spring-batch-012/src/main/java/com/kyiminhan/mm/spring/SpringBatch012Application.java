package com.kyiminhan.mm.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class SpringBatch012Application.<BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since 2019/06/24 <BR>
 *        spring-batch-012 system <BR>
 *        com.kyiminhan.mm.spring <BR>
 *        SpringBatch012Application.java <BR>
 */
@SpringBootApplication
public class SpringBatch012Application implements CommandLineRunner {

	/** The job launcher. */
	@Autowired
	private JobLauncher jobLauncher;

	/** The job. */
	@Autowired
	private Job job;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String... args) {
		SpringApplication.run(SpringBatch012Application.class, args);
	}

	/**
	 * Run.
	 *
	 * @param args the args
	 * @throws Exception the exception
	 */
	@Override
	public void run(final String... args) throws Exception {
		final JobParameters jobParameters = new JobParametersBuilder()
				.addString("jobID", String.valueOf(System.currentTimeMillis())).toJobParameters();
		this.jobLauncher.run(this.job, jobParameters);
	}
}