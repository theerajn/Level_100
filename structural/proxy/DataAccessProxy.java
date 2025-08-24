// Proxy class to control access to RealDataAccess
public class DataAccessProxy implements DataAccess {
    private RealDataAccess realDataAccess;
    private String role;

    public DataAccessProxy(String role) {
        this.realDataAccess = new RealDataAccess();
        this.role = role;
    }

    @Override
    public void viewData() {
        // Everyone can view the data
        realDataAccess.viewData();
    }

    @Override
    public void deleteData() {
        // Only admin can delete the data
        if (role.equalsIgnoreCase("admin")) {
            realDataAccess.deleteData();
        } else {
            System.out.println("Access denied. Only admins can delete data.");
        }
    }
}
