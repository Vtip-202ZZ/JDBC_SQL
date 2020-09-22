package zza_jdbc_mysql;

import java.sql.*;

public class ZZA_JDBC_MySQL {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Подключение к базе данных
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/animal", "root", "PassW0rd++");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM animal");

            // Вывод начальных данных
            System.out.println("Список животных:");
            while (rs.next()) {
                System.out.println(rs.getString("animal") + ": " + rs.getString("class"));
            }

           System.out.println("\nУдаление буквы `а` из названий животных");
            rs.beforeFirst();
            while (rs.next()) {
                String oldAnimal = rs.getString("animal");
                String newAnimal = changeAnimal(oldAnimal);
                rs.updateString("animal", newAnimal);
                rs.updateRow();
            }

            System.out.println("\nКонечный список животных:");
            rs.beforeFirst();
            while (rs.next()) {
                System.out.println(rs.getString("animal") + ": " + rs.getString("class"));
            }
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    private static String changeAnimal(String animal) {
        return animal.replace("а", "");
    }
}
