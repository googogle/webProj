package com.market.proj.marketProj.task;

import com.market.proj.marketProj.Entity.Bidding;
import com.market.proj.marketProj.Entity.Product;
import com.market.proj.marketProj.Entity.Transaction;
import com.market.proj.marketProj.Service.BiddingService;
import com.market.proj.marketProj.Service.ChatService;
import com.market.proj.marketProj.Service.ProductService;
import com.market.proj.marketProj.Service.TransactionService;
import com.market.proj.marketProj.dto.ChatRoom;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TransactionTask implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        System.out.println("## Test Job Call!!");
        Long productIdx = (Long)context.getJobDetail().getJobDataMap().get("productIdx");
        ProductService productService = (ProductService)context.getJobDetail().getJobDataMap().get("productService");
        BiddingService biddingService = (BiddingService)context.getJobDetail().getJobDataMap().get("biddingService");
        TransactionService transactionService = (TransactionService)context.getJobDetail().getJobDataMap().get("transactionService");
        ChatService chatService = (ChatService)context.getJobDetail().getJobDataMap().get("chatService");

        Product product = productService.findProductEntityById(productIdx);
        product.setEnd(true);
        productService.save(product);
        Bidding topPriceBid = biddingService.findTopPriceBidding(productIdx);

        if(topPriceBid != null) {
            ChatRoom chatRoom = chatService.createRoom(productIdx.toString());
            Transaction transaction = Transaction.builder()
                    .transactionPrice(topPriceBid.getBiddingPrice())
                    .transactionSellerIdx(product.getUser().getIdx())
                    .transactionBuyerIdx(topPriceBid.getUser().getIdx())
                    .transactionProductIdx(productIdx)
                    .chatRoomId(chatRoom.getRoomId())
                    .build();
            Transaction tmp = transactionService.save(transaction);
            log.info("TransactionTask: execute.TransactionTmp = {} ", tmp);
        }

        else{
            Transaction transaction = Transaction.builder()
                    .transactionPrice(0)
                    .transactionSellerIdx(product.getUser().getIdx())
                    .transactionBuyerIdx(null)
                    .transactionProductIdx(productIdx)
                    .build();
            Transaction tmp = transactionService.save(transaction);
            log.info("TransactionTask: execute.TransactionTmp = {} ", tmp);
        }

    }
}
