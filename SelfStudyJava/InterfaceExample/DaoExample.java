package InterfaceExample;

public class DaoExample {
    
    public static void dbWork(DataAccessObject dao){
        dao.select();
        dao.insert();
        dao.update();
        dao.delete();
    }

    public static void main(String[] args) {
        dbWork(new OracleDao());
        dbWork(new MySqlDao());
    }

    // 알아서 잘 하도록 ㅇㅇ
}
