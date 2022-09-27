/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author WENDERSON
 */
public class TaskDAO {

    public void save(Task task) {

        String sql = "INSERT INTO tasks(idProject, name, description, completed "
                + ", notes, deadline, createdAt, updatedAt) VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            //Cria uma conex�o com o banco
            conn = ConnectionFactory.getConnection();
            //Cria um PreparedStatment, classe usada para executar a query
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, task.getIdProject());
            stmt.setString(2, task.getName());
            stmt.setString(3, task.getDescription());
            stmt.setBoolean(4, task.isCompleted());
            stmt.setString(5, task.getNotes());
            stmt.setDate(6, new Date(task.getDeadline().getTime()));

            //Executa a sql para inser��o dos dados
            stmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar a tarefa " + ex.getMessage(), ex);
        } finally {
            //Fecha as conex�es
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex);
            }
        }

    }

    public void update(Task task) {
    }

    public void removeById(int id) {

        String sql = "DELETE FROM tasks WHERE id = ?";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar a tarefa", ex);
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    public List<Task> getAll() {
        return null;
    }
}
