public class son extends father{
    @Override
    public void doGet() {
        System.out.println("son get run");
    }

    @Override
    public void doPost() {
        System.out.println("son post run");
    }
}
