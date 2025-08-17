package mylab.notification.di.annot.config;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.SmsNotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

@Configuration
@ComponentScan(basePackages = {"mylab.notification.di.annot"})
public class NotificationConfig {
    @Bean
    public EmailNotificationService emailNotificationService() {
        // 이메일 알림 서비스 설정
        String smtpServer = "smtp.gmail.com";
        int port = 587;
        return new EmailNotificationService(smtpServer, port);
    }
    @Bean
    public SmsNotificationService smsNotificationService() {
        // SMS 알림 서비스 설정
        String provider = "SKT";
        return new SmsNotificationService(provider);
    }
    @Bean
    public NotificationManager notificationManager() {
        // 알림 관리자 설정
        EmailNotificationService emailService = emailNotificationService();
        SmsNotificationService smsService = smsNotificationService();
        return new NotificationManager(emailService, smsService);
    }
}
