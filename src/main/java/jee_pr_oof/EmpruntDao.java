package jee_pr_oof;

import java.sql.*;
import java.util.ArrayList;

public class EmpruntDao {
    private Connection connection;

    public EmpruntDao() {
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bibliotheque";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertEmprunt(Emprunt emprunt) {
        String sql = "INSERT INTO emprunt (client, CIN, Telephone, livre, prix, date_emprunt, date_retour) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emprunt.getNom());
            statement.setString(2, emprunt.getCin());
            statement.setString(3, emprunt.getTel());
            statement.setString(4, emprunt.getLivre());
            statement.setDouble(5, emprunt.getPrix());
            statement.setDate(6, emprunt.getDateEmprunt());
            statement.setDate(7, emprunt.getDateRetour());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Emprunt> getEmprunts() throws SQLException {
        ArrayList<Emprunt> emprunts = new ArrayList<>();

        PreparedStatement ps = connection.prepareStatement("SELECT * FROM emprunt");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Emprunt emprunt = new Emprunt(
                /**    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("cin"),
                    rs.getString("tel"),
                    rs.getString("livre"),
                    rs.getDouble("prix"),
                    rs.getDate("date_emp"),
                    rs.getDate("date_ret")*/
            );
            emprunts.add(emprunt);
        }

        rs.close();
        ps.close();
        connection.close();

        return emprunts;
    }
}
