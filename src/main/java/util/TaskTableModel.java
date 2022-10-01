/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

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
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 1:
                return tasks.get(rowIndex).getName();

            case 2:
                return tasks.get(rowIndex).getDescription();

            case 3:
                return tasks.get(rowIndex).getDeadline();
            case 4:
                return tasks.get(rowIndex).isCompleted();
            case 5:
                return "";
            case 6:
                return "";

            default:
                return "Dados não encontrados";

        }
    }

}
