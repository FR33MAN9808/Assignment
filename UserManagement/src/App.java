import java.util.List;
import java.util.Scanner;

import controller.UserController;
import dao.UserDAO;
import dto.User;

public class App {
    public static void main(String[] args) throws Exception {
        showUserMenu();
    }

    public static void showUserMenu() {
        Scanner sc = new Scanner(System.in);
        UserController userController = new UserController();

        String userSelected = "";

        do {
            System.out.println("**************************************");
            System.out.println("1: Register a user");
            System.out.println("2: Get All Users");
            System.out.println("3: Delete a User");
            System.out.println("4: Update a user");
            System.out.println("5: Get a user by ID");
            System.out.println("6: Get user based on ID and password");
            System.out.println("7: EXIT");
            System.out.println("**************************************");

            userSelected = sc.nextLine();

            switch (userSelected) {
                case "1":
                System.out.println("Enter User Name: ");
                String userName = sc.nextLine();

                System.out.println("Enter User Email: ");
                String userEmail = sc.nextLine();

                System.out.println("Enter User Password: ");
                String userPassword = sc.nextLine();

                System.out.println("Enter User age: ");
                int userAge = sc.nextInt();

                User user = new User(userName, userEmail, userPassword, userAge);
                userController.insert(user);
                break;

                case "2": 
                System.out.println("---------------------");
                displayUserList(userController.getUserList());
                System.out.println("---------------------");
                break;

                case "3":

                System.out.println("---------------------");
                displayUserList(userController.getUserList());
                System.out.println("---------------------");
                
                System.out.println("Enter User Id you want to delete : ");
                int id = sc.nextInt();
                userController.delete(id);

                System.out.println("------AFTER DELETING---------");
                displayUserList(userController.getUserList());
                System.out.println("---------------------");

                // Implement Update User
                case "4":

                System.out.println("---------------------");
                displayUserList(userController.getUserList());
                System.out.println("---------------------");
                //Get updated value.
                System.out.println("Enter User Id you want to update : ");
                int update_id = sc.nextInt();
                sc.nextLine();

                System.out.println("Updated Name : ");
                String update_name = sc.nextLine();

                System.out.println("Updated Email : ");
                String update_email = sc.nextLine();

                System.out.println("Updated Password : ");
                String update_pw = sc.nextLine();

                System.out.println("Updated Age : ");
                int updated_age = sc.nextInt();

                User tempUser = new User(update_name,update_email,update_pw,updated_age);
                tempUser.setId(update_id);
                userController.update(tempUser);
                break;
                // ASSIGNMENT IS
                // Implemenet USER BY ID
                case "5":

                System.out.println("---------------------");
                displayUserList(userController.getUserList());
                System.out.println("---------------------");

                System.out.println("Enter user ID you want to find : ");
                int userId = sc.nextInt();
                
                break;

                // Implement getUserBasedByIDandPassword
                case "6":

                System.out.println("---------------------");
                displayUserList(userController.getUserList());
                System.out.println("---------------------");

                System.out.println("Enter user email you want to find : ");
                String user_email = sc.nextLine();

                System.out.println("Enter user password you want to find : ");
                String user_pw = sc.nextLine();

                userController.getUserByEmailAndPassword(user_email, user_pw);
            }
        } while (!userSelected.equals("7")); 
        sc.close();
    }


 public static void displayUserList(List<User> users) {
    for (User user: users) {
        user.getUserInfo();
    }
 }
}
