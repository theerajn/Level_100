// Client code to test DBConfig Singleton
public class SingletonMain {
    public static void main(String[] args) {
        try {
            // Accessing the single DBConfig instance
            DBConfig config = DBConfig.getInstance();

            System.out.println("DB URL: " + config.getDbUrl());
            System.out.println("Username: " + config.getUsername());
            System.out.println("Password: " + config.getPassword());
        } catch (Exception e) {
            System.err.println("Error accessing DBConfig: " + e.getMessage());
        }
    }
}
