package mojospy.covid19screen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("mojospy.covid19screen.mapper")
@EnableScheduling
@SpringBootApplication
public class Covid19ScreenApplication {
    public static void main(String[] args) {
        SpringApplication.run(Covid19ScreenApplication.class, args);
    }
}
