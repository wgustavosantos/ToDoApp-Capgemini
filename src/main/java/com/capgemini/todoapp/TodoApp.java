/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.capgemini.todoapp;

import controller.ProjectDAO;
import controller.TaskDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Project;
import model.Task;

/**
 *
 * @author WENDERSON
 */
public class TodoApp {

    public static void main(String[] args) {

        ProjectDAO projectDAO = new ProjectDAO();
        TaskDAO taskDAO = new TaskDAO();
        Project project = new Project();
        Task task = new Task();
        
//        project.setName("Projeto de teste");
//        project.setDescription("Descricao de teste");
//        project.setCreatedAt(new Date());
//        project.setUpdatedAt(new Date());
//        
//        projectDAO.save(project);
//        
//        project.setId(1);
//        project.setName("Projeto com nome atualizado");
//        projectDAO.update(project);
//        
//        List<Project> projetos = new ArrayList<>();
//        projetos = projectDAO.getAll();
//        
//        for (Project projeto : projetos) {
//            System.out.println(projeto.toString());
//            System.out.println("-------------------------------------------");
//        }
//        
//        projectDAO.removeById(2);
//
//        task.setName("Task de teste");
//        task.setNotes("notas de teste");
//        task.setIsCompleted(false);
//        task.setDescription("Descricao de teste");
//        task.setDeadline(new Date());
//        task.setCreatedAt(new Date());
//        task.setUpdatedAt(new Date());
//        task.setIdProject(1);
//        
//        taskDAO.save(task);
//        
//        task.setId(1);
//        task.setIdProject(1);
//        task.setName("nome atualizado");
//        task.setIsCompleted(true);
//        
//        taskDAO.update(task);
        List<Task> tasks = new ArrayList<>();
        tasks = taskDAO.getAll(1);
        
        for (Task taskss : tasks) {
            System.out.println(taskss.toString());
            System.out.println("-------------------------------------------");
        }
        
        taskDAO.removeById(1);
        
    }
}
