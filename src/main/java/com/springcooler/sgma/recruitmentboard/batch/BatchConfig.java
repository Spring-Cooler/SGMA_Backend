package com.springcooler.sgma.recruitmentboard.batch;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private RecruitmentBoardUpdateTasklet recruitmentBoardUpdateTasklet;

//    1 @Autowired
//    private JobBuilderFactory jobBuilderFactory;


//    2 @Autowired
//    private StepBuilderFactory stepBuilderFactory;



//    1 @Bean
//    public Job postStatusUpdateJob(JobRepository jobRepository, Step step) {
//        return jobBuilderFactory.get("postStatusUpdateJob")
//                .start(step)
//                .build();
//    }
    @Bean
    public Job myJob(JobRepository jobRepository, Step step) {
        return new JobBuilder("myJob", jobRepository)
                .start(step)
                .build();
    }


    @Bean
    public Step myStep(JobRepository jobRepository, Tasklet myTasklet, PlatformTransactionManager transactionManager) {
        return new StepBuilder("myStep", jobRepository)
                .tasklet(myTasklet, transactionManager) // or .chunk(chunkSize, transactionManager)
                .build();
    }


//    @Bean
//    public Step postStatusUpdateStep(PlatformTransactionManager transactionManager) {
//        return stepBuilderFactory.get("postStatusUpdateStep")
//                .tasklet(recruitmentBoardUpdateTasklet, transactionManager)
//                .build();
//    }

}
