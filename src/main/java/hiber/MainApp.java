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

        Car car1 = new Car("Toyota", 2021);
        User user1 = new User("Svyat", "Pro", "123@mail.com", car1);
        userService.add(user1);

        Car car2 = new Car("Honda", 2019);
        User user2 = new User("Vanya", "Pupkin", "123@mail.com", car2);
        userService.add(user2);

        User foundUser = userService.findUserByCarModelAndSeries("Honda", 2019);
        System.out.println("Искомый пользователь это ");
        //System.out.println(foundUser.getId());
        System.out.println(foundUser.getFirstName());
        System.out.println(foundUser.getLastName());
        System.out.println(foundUser.getEmail());



//        List<User> users = userService.listUsers();
//        for (User user : users) {
//            System.out.println("Id = " + user.getId());
//            System.out.println("Имя = " + user.getFirstName());
//            System.out.println("Фамилия = " + user.getLastName());
//            System.out.println("Email = " + user.getEmail());
//            System.out.println("Машина = " + user.getCar());
//            System.out.println();
//        }

        context.close();
    }
}
