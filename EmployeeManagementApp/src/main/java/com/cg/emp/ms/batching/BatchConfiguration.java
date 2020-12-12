package com.cg.emp.ms.batching;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.cg.emp.ms.model.Employeeee;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	// end::setup[]

	// tag::readerwriterprocessor[]
	@Bean
	public FlatFileItemReader<Employeeee> reader() {
		System.out.println("Reader");
		return new FlatFileItemReaderBuilder<Employeeee>().name("EmployeeeeItemReader")
				.resource(new ClassPathResource("sample-data.csv")).delimited()
				.names(new String[] { "empId","firstName", "lastName" , "email" , "salary" })
				.fieldSetMapper(new BeanWrapperFieldSetMapper<Employeeee>() {
					{
						setTargetType(Employeeee.class);
					}
				}).build();
	}

	@Bean
	public EmployeeeeItemProcessor processor() {
		System.out.println("Processor");
		return new EmployeeeeItemProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<Employeeee> writer(DataSource dataSource) {
		System.out.println("Writer");
		return new JdbcBatchItemWriterBuilder<Employeeee>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO Employeeee(eId,first_name, last_name,email,salary) VALUES (:empId ,:firstName, :lastName , :email , :salary)").dataSource(dataSource)
				.build();
	}
	// end::readerwriterprocessor[]

	// tag::jobstep[]
//	@Bean
//	public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
//		System.out.println("hi");
//		return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listener).flow(step1)
//				.end().build();
//	}

	@Bean
	public Step step1(JdbcBatchItemWriter<Employeeee> writer) {
		System.out.println("hi2");
		return stepBuilderFactory.get("step1").<Employeeee, Employeeee>chunk(10).reader(reader()).processor(processor())
				.writer(writer).build();
	}
	// end::jobstep[]

}
