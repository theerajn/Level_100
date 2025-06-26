public class DBConfig {
    private static volatile DBConfig instance;
    private final String dbUrl;
    private final String username;
    private final String password;

    private DBConfig() {
        dbUrl = "jdbc:mysql://localhost:3333/mydb";
        username = "admin";
        password = "mypassword";
    }

    public static DBConfig getInstance() {
        if (instance == null) {
            synchronized (DBConfig.class) {
                if (instance == null) {
                    instance = new DBConfig();
                }
            }
        }
        return instance;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
