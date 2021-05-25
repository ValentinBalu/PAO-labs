package cabinet.repository;

import cabinet.Client;
import cabinet.Medic;
import cabinet.config.DatabaseConfiguration;

import java.sql.*;
import java.util.ArrayList;

public class MedicRepository {
    //creare tabela
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS medici" +
                "(id int PRIMARY KEY AUTO_INCREMENT, nume varchar(30)," +
                " varsta int, specialitatea varchar(30), tura int)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //inserare medic
    public void insertMedic(Medic medic) {
        String insertClientSql = "INSERT INTO medici(nume,varsta,specialitatea,tura) VALUES(?,?,?,?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertClientSql);
            preparedStatement.setString(1, medic.getNume());
            preparedStatement.setInt(2, medic.getVarsta());
            preparedStatement.setString(3,medic.getSpecialitate());
            preparedStatement.setInt(4,medic.getTura());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //preluarea unui medic dupa id
    public Medic getMedicById(int id) {
        String selectSql = "SELECT * FROM medici WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToMedic(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Medic mapToMedic(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Medic(resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4),resultSet.getInt(5));
        }
        return null;
    }

    public ArrayList<Medic> getAllMedics(){
        ArrayList<Medic> medici = new ArrayList<Medic>();

        String selectSql = "SELECT * FROM medici";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Medic medic = new Medic(resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4),resultSet.getInt(5));
                medici.add(medic);
            }
            return medici;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateTuraAge(int tura, int id) {
        String updateNameSql = "UPDATE medici SET tura=? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setInt(1, tura);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMedic(int id){
        String deleteSql = "delete from medici WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
