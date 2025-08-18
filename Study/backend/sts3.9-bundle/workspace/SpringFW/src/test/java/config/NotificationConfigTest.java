package config;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.NotificationService;
import mylab.notification.di.annot.SmsNotificationService;
import mylab.notification.di.annot.config.NotificationConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class,loader= AnnotationConfigContextLoader.class
)
public class NotificationConfigTest {

    @Autowired
    NotificationManager notificationManager;
    @Autowired
    EmailNotificationService emailService;
    @Autowired
    SmsNotificationService smsService;

    @Test
    public void testNotificationManager() {
        // NotificationManager 인스턴스 생성

        assertNotNull(notificationManager.getEmailService());
        assertEquals("smtp.gmail.com", emailService.getSmtpServer());
        assertEquals(587, emailService.getPort());

        assertNotNull(notificationManager.getSmsService());
        assertEquals("SKT", smsService.getProvider());

        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");


        
    }
}
