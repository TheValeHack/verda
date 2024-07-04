import Controllers.Data;
import Models.CobaModel;
import java.util.List;

public class App {
    public static void main(String[] args) {
        displayUsers();
    }

    private static void displayUsers() {
        List<CobaModel> users = Data.getUsers();
        for (CobaModel user : users) {
            System.out.println(user);
        }
    }
}
