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
import model.Project;
import util.ConnectionFactory;

/**
 *
 * @author WENDERSON
 */
public class ProjectDAO {

    public void save(Project project) {
        String sql = "INSERT INTO project (name, description, createdAt, "
                + "updatedAt) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            //Cria uma conexao com o banco
            conn = ConnectionFactory.getConnection();
            //Cria um PreparedStatment, classe usada para executar a query
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, project.getName());
            stmt.setString(2, project.getDescription());
            stmt.setDate(3, new Date(project.getCreatedAt().getTime()));
            stmt.setDate(4, new Date(project.getUpdatedAt().getTime()));

            //Executa a sql para insercao dos dados
            stmt.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar o projeto", ex);
        } finally {
            //Fecha as conex�es
            ConnectionFactory.closeConnection(conn, stmt);
        }

    }

    public void update(Project project) {

        String sql = "UPDATE project SET name = ?, description = ?, createdAt = ?,"
                + " updatedAt = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            //Cria uma conexao com o banco
            conn = ConnectionFactory.getConnection();
            //Cria um PreparedStatment, classe usada para executar a query
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, project.getName());
            stmt.setString(2, project.getDescription());
            stmt.setDate(3, new java.sql.Date(project.getCreatedAt().getTime()));
            stmt.setDate(4, new java.sql.Date(project.getUpdatedAt().getTime()));
            stmt.setInt(4, project.getId());

            //Executa a sql para insercao dos dados
            stmt.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro em atualizar o projeto", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }

    public List<Project> getAll() {
        String sql = "SELECT * FROM project";

        List<Project> projects = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            rset = stmt.executeQuery();

            //Enquanto existir dados no banco de dados, faca
            while (rset.next()) {

                Project project = new Project();

                project.setId(rset.getInt("id"));
                project.setName(rset.getString("name"));
                project.setDescription(rset.getString("description"));
                project.setCreatedAt(rset.getDate("createdAt"));
                project.setCreatedAt(rset.getDate("updatedAt"));

                //Adiciono o contato recuperado, a lista de contatos
                projects.add(project);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao buscar os projetos", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
        return projects;
    }

    public void removeById(int id) {

        String sql = "DELETE FROM project WHERE id = ?";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar o projeto", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }

    }

}
