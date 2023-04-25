package com.market.proj.marketProj.config;

import com.market.proj.marketProj.Entity.Product;
import com.market.proj.marketProj.Entity.Transaction;
import com.market.proj.marketProj.Service.*;
import com.market.proj.marketProj.dto.ChatRoom;
import com.market.proj.marketProj.repository.UserRepository;
import com.market.proj.marketProj.task.TransactionTask;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

@Slf4j
@Component
@RequiredArgsConstructor
public class MarketCommendLineRunner implements CommandLineRunner {
    private final ProductService productService;
    private final BiddingService biddingService;
    private final TransactionService transactionService;
    private final ChatService chatService;

    @Override
    public void run(String... args) throws Exception {
        log.info("MarketCommendLineRunner: run()");
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        List<Product> productList = productService.findByIsEndFalse();
        for (Product product : productList) {
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("productIdx", product.getIdx());
            jobDataMap.put("productService", productService);
            jobDataMap.put("biddingService", biddingService);
            jobDataMap.put("transactionService", transactionService);
            jobDataMap.put("chatService", chatService);

            JobDetail jobDetail = newJob(TransactionTask.class)
                    //job Data 주입
                    .usingJobData(jobDataMap)
                    .build();
            Date date = Date.from(product.getEndTime().atZone(ZoneId.systemDefault()).toInstant());
            Trigger trigger = newTrigger()
                    .startAt(date)
                    .build();

            // JobDetail과 Trigger 정보로 스케줄링

            scheduler.scheduleJob(jobDetail, trigger);

            log.info("Product: {}", product);
        }

        List<Transaction> transactionList = transactionService.findAll();
        for(Transaction t : transactionList){
            if(t.getChatRoomId() != null){
                chatService.roomRegistration(t.getChatRoomId(), t.getTransactionProductIdx().toString());
            }

        }
    }
}
