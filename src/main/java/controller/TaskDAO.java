/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Task;

/**
 *
 * @author WENDERSON
 */
public class TaskDAO {

    public void save(Task task) {
    }

    public void update(Task task) {
    }

    public void removeById(int id) {

        String sql = "DELETE FROM tasks WHERE id = ?";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

        } catch (Exception ex) {

        }

    }

    public List<Task> getAll() {
        return null;
    }
}
