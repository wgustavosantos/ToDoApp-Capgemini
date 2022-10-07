    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import model.Task;

/**
 *
 * @author WENDERSON
 */
public interface TaskDAO  {

    void save(Task t);

    void update(Task t);

    void removeById(int id);

    List<Task> getAll(int id);

    Task findOne(int id);
}
