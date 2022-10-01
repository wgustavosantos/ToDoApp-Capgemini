/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author WENDERSON
 */
public class TaskTableModel extends AbstractTableModel {

    String[] columns = {"Nome", "Descrição", "Prazo", "Tarefa Concluída", "Editar", "Concluir"};
    List<Task> tasks = new ArrayList<>();

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 3;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(tasks.isEmpty()){
            return Object.class;
        }
        
        return this.getValueAt(0, columnIndex).getClass();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        tasks.get(rowIndex).setIsCompleted((boolean)aValue);
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                
        return switch (columnIndex) {
            case 0 -> tasks.get(rowIndex).getName();
            case 1 -> tasks.get(rowIndex).getDescription();
            case 2 -> sdf.format(tasks.get(rowIndex).getDeadline());
            case 3 -> tasks.get(rowIndex).isCompleted();
            case 4 -> "";
            case 5 -> "";
            default -> "Dados não encontrados";
        };
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
