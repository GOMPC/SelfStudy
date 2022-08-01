package InterfaceExample;

public class MySqlDao implements DataAccessObject {

    @Override
    public void select() {
        System.out.println("MySql DB Select");
        
    }

    @Override
    public void insert() {
        System.out.println("MySql DB Insert");
        
    }

    @Override
    public void update() {
        System.out.println("MySql DB Update");
        
    }

    @Override
    public void delete() {
        System.out.println("MySql DB Delete");
        
    }
    
}
