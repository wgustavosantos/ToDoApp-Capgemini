/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author WENDERSON
 */
public class TaskDAO {

    public void save(Task task) {

        String sql = "INSERT INTO task(idProject, name, description, completed "
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
            stmt.setDate(7, new Date(task.getCreatedAt().getTime()));
            stmt.setDate(8, new Date(task.getUpdatedAt().getTime()));
            //Executa a sql para inserir os dados
            stmt.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a tarefa " + ex.getMessage(), ex);
        } finally {
            //Fecha as conexoes
            ConnectionFactory.closeConnection(conn, stmt);
        }

    }

    public void update(Task task) {

        String sql = "UPDATE task SET idProject = ?, name = ?, description = ?, "
                + "completed = ?, notes = ?, deadline = ?,"
                + " createdAt = ?, updatedAt = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            //Cria uma conexao com o banco
            conn = ConnectionFactory.getConnection();
            //Cria um PreparedStatment, classe usada para executar a query
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, task.getIdProject());
            stmt.setString(2, task.getName());
            stmt.setString(3, task.getDescription());
            stmt.setBoolean(4, task.isCompleted());
            stmt.setString(5, task.getNotes());
            stmt.setDate(6, new java.sql.Date(task.getDeadline().getTime()));
            stmt.setDate(7, new java.sql.Date(task.getCreatedAt().getTime()));
            stmt.setDate(8, new java.sql.Date(task.getUpdatedAt().getTime()));
            stmt.setInt(9, task.getId());
            stmt.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro em atualizar a tarefa", ex);
        }
    }

    public void removeById(int id) {

        String sql = "DELETE FROM task WHERE id = ?";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar a tarefa", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }

    public List<Task> getAll(int idProject) {
        String sql = "SELECT * FROM task WHERE idProject = ?";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null; //Classe que vai recuperar os dados do banco de dados

        List<Task> tasks = new ArrayList<>();

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProject);
            rset = stmt.executeQuery();
            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {

                Task task = new Task();

                task.setId(rset.getInt("id"));
                task.setIdProject(rset.getInt("idProject"));
                task.setName(rset.getString("name"));
                task.setDescription(rset.getString("description"));
                task.setIsCompleted(rset.getBoolean("completed"));
                task.setNotes(rset.getString("notes"));
                task.setDeadline(rset.getDate("deadline"));
                task.setCreatedAt(rset.getDate("createdAt"));
                task.setCreatedAt(rset.getDate("updatedAt"));

                //Adiciono o contato recuperado, a lista de contatos
                tasks.add(task);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao inserir a tarefa", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rset);
        }
        //Lista de tarefas que foi carregada do banco de dados
        return tasks;
    }
}
