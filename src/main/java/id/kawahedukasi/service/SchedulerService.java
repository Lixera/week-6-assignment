package id.kawahedukasi.service;

import io.quarkus.scheduler.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.time.LocalDateTime;

@ApplicationScoped
public class SchedulerService {
    @Inject
    MailService mailService;

    Logger logger = LoggerFactory.getLogger(SchedulerService.class);
    @Scheduled(every = "1h")
    public void generatedKawahedukasi(){
        logger.info("KawahEdukasi_{}", LocalDateTime.now());
    }

    @Scheduled(cron = "5 30 16 12 * ? *")
    public void scheduleSendDataItem() throws IOException {
        mailService.sendExcelToEmail("arahmantha@gmail.com");
        logger.info("SEND EMAIL SUCCESS");
    }
}
