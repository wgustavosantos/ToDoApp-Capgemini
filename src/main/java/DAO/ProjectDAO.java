/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import model.Project;

/**
 *
 * @author WENDERSON
 */
public interface ProjectDAO {
    
    void save(Project p);

    void update(Project t);

    void removeById(int id);

    List<Project> getAll();

}
