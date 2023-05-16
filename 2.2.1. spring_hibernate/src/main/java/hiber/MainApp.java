package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Alexandr", "Alex", "alex@g.ru");
      User user2 = new User("Vladislav", "Vlad", "vlad@g.ru");

      Car car1 = new Car("Lada", 2201);
      Car car2 = new Car("KIA", 112);

      user1.setCar(car1);
      user2.setCar(car2);

      userService.add(user1);
      userService.add(user2);




      context.close();
   }
}
