public class DataAccessProxy implements DataAccess {
    private RealDataAccess realDataAccess;
    private String role;

    public DataAccessProxy(String role) {
        this.realDataAccess = new RealDataAccess();
        this.role = role;
    }

    @Override
    public void viewData() {
        realDataAccess.viewData(); // Everyone can view
    }

    @Override
    public void deleteData() {
        if (role.equalsIgnoreCase("admin")) {
            realDataAccess.deleteData();
        } else {
            System.out.println("Access denied. Only admins can delete data.");
        }
    }
}
