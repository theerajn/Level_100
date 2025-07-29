public class RealDataAccess implements DataAccess {
    @Override
    public void viewData() {
        System.out.println("Data: Confidential company report");
    }

    @Override
    public void deleteData() {
        System.out.println("Data deleted successfully!");
    }
}
