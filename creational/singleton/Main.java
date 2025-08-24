// Client code to test DBConfig Singleton
public class Main {
    public static void main(String[] args) {
        // Accessing the single DBConfig instance
        DBConfig config = DBConfig.getInstance();

        System.out.println("DB URL: " + config.getDbUrl());
        System.out.println("Username: " + config.getUsername());
        System.out.println("Password: " + config.getPassword());
    }
}
