package com.catering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.awt.Desktop;
import java.net.URI;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
@EnableTransactionManagement
public class CateringApplication {

    public static void main(String[] args) {
        // Set system properties for better desktop integration
        System.setProperty("java.awt.headless", "false");
        
        // Start Spring Boot application
        SpringApplication app = new SpringApplication(CateringApplication.class);
        app.setHeadless(false);
        app.run(args);
        
        // Open browser automatically after startup delay
        openBrowserAfterStartup();
    }
    
    private static void openBrowserAfterStartup() {
        Executors.newSingleThreadScheduledExecutor().schedule(() -> {
            try {
                String url = "http://localhost:8080";
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    if (desktop.isSupported(Desktop.Action.BROWSE)) {
                        desktop.browse(new URI(url));
                        System.out.println("✅ Browser opened automatically: " + url);
                    }
                } else {
                    System.out.println("🌐 Please open your browser and navigate to: " + url);
                }
            } catch (Exception e) {
                System.err.println("❌ Could not open browser automatically. Please navigate to: http://localhost:8080");
                System.err.println("Error: " + e.getMessage());
            }
        }, 10, TimeUnit.SECONDS);
    }
}

