import java.sql.*;

public class Main {

    private static Connection connection;
    private static Statement stmt;

    static String testTable = "Test";

    //  Сделать методы для работы с БД (CREATE, UPDATE, DELETE, INSERT, SELECT)

    public static void main(String[] args) {
        try {
            connect();
            createNewTable(testTable);
            /*insert(testTable, "Bob1", 10);
            insert(testTable, "Bob2", 20);
            insert(testTable, "Bob3", 30);*/

//            select(testTable, 2);
//            delete(testTable, 1);
//            selectAll(testTable);

//            update(testTable, 2, "Rob", 2000);

            selectAll(testTable);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void selectAll(String table){
        String sql = "SELECT id, name, score FROM " + table;

        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  " " +
                        rs.getString("name") + " " +
                        rs.getInt("score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void select(String table, int id){

        String sql = "SELECT id, name, score FROM " + table + " WHERE id = " + id;

        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  " " +
                        rs.getString("name") + " " +
                        rs.getInt("score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insert(String table, String name, int score) {
        String sql = "INSERT INTO " + table + "(name, score) VALUES(?,?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, score);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(String table, int id) {
        String sql = "DELETE FROM " + table + " WHERE id = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(String table, int id, String name, int score) {
        String sql = "UPDATE " + table + " SET name = ? , score = ? WHERE id = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, score);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createNewTable(String tableName) {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (\n"
                + "id integer PRIMARY KEY, name text NOT NULL, score real);";

        try {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mydb.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}