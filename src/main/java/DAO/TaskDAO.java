/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;

/**
 *
 * @author WENDERSON
 */
public interface TaskDAO<T>  {

    void save(T t);

    void update(T t);

    void removeById(int id);

    List<T> getAll(int id);

    T findOne(int id);
}
