package cabinet.repository;
import cabinet.Medic;
import cabinet.Oftalmolog;
import cabinet.Programare;
import cabinet.config.DatabaseConfiguration;

import java.sql.*;
import java.util.ArrayList;

public class ProgramareRepository {

    public void createTable() {
        //creare tabela
        String createTableSql = "CREATE TABLE IF NOT EXISTS programari" +
                "(id int PRIMARY KEY AUTO_INCREMENT, nume_client varchar(30)," +
                "data_programare varchar(30), ora_programare varchar(30), specialitatea varchar(30), nume_medic varchar(30), cost double "+
                " ,id_medic int, id_client int , CONSTRAINT FK_Medici FOREIGN KEY(id_medic) REFERENCES medici(id),CONSTRAINT FK_Clienti FOREIGN KEY(id_client) REFERENCES clienti(id))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //inserare programare
    public void insertProgramare(Programare programare) {
        String insertClientSql = "INSERT INTO programari(nume_client,data_programare,ora_programare,specialitatea,nume_medic,cost,id_medic,id_client) VALUES(?,?,?,?,?,?,?,?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertClientSql);
            preparedStatement.setString(1, programare.getNumeClient());
            preparedStatement.setString(2, programare.getDataProgramare());
            preparedStatement.setString(3,programare.getOraProgramare());
            preparedStatement.setString(4,programare.getSpecialitatea());
            preparedStatement.setString(5,programare.getNumeMedic());
            preparedStatement.setDouble(6,programare.getCost());
            preparedStatement.setInt(7,programare.getIdMedic());
            preparedStatement.setInt(8,programare.getIdClient());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //preluarea unei programari dupa id
    public Programare getProgramareById(int id) {
        String selectSql = "SELECT * FROM programari WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToProgramare(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Programare mapToProgramare(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Programare(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getDouble(7),resultSet.getInt(8),resultSet.getInt(9));
        }
        return null;
    }

    public ArrayList<Programare> getAllProgs(){
        ArrayList<Programare> programares = new ArrayList<Programare>();

        String selectSql = "SELECT * FROM programari";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Programare programare = new Programare(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getDouble(7),resultSet.getInt(8),resultSet.getInt(9));
                programares.add(programare);
            }
            return programares;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateDataOraProgramare(String data,String ora, int id) {
        String updateNameSql = "UPDATE programari SET data_programare=?, ora_programare=? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, data);
            preparedStatement.setString(2,ora);
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProgramare(int id){
        String deleteSql = "delete from programari WHERE id=?";

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
