package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Model.ModelList;
import Model.Student;
import View.View;

public class Controller {

    private iGetModel model;
    private iGetView view;
    private List<Student> students = new ArrayList<>();
    private HashMap<Long,Student> hashMapStudents = new HashMap<Long,Student>();

    public Controller(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
    }


    private boolean testData(List<Student> students, HashMap<Long,Student> hashMapStudents)
    {
        if(students.size()>0 || hashMapStudents.size()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void update()
    {
            students = model.getAllStudents();
            if(testData(students, hashMapStudents))
            {
                view.printAllStudents(students);
            }
            else
            {
                System.out.println("Список студентов пуст!");
            }
        }

    public void run()
    {
        if (view.getClass().getName().equals("View.View"))
        {
            Command com = Command.NONE;
            boolean getNewIteration = true;
            while(getNewIteration)
            {
                String command = view.prompt("Введите команду:");
                com = Command.valueOf(command.toUpperCase());
                switch(com)
                {
                    case EXIT:
                        getNewIteration=false;
                        System.out.println("Выход из программы!");
                        break;
                    case LIST:
                        view.printAllStudents(model.getAllStudents());
                        break;
                    case DELETE:
                        System.out.println("Введите номер студенческого билета студента:");
                        Scanner in = new Scanner(System.in);
                        int a = in.nextInt();

                        model.removeStudent(a);
                        view.printAllStudents(model.getAllStudents());
                        break;
                        /* int count = 0;
                        for (Student student : students) {
                            if (student.getId() == a)
                            {
                                System.out.println(student + " удален");
                                students.remove(count);
                            }
                            else
                            {
                                System.out.println(student.getId());
                            }
                            count +=1;
                            } */
                            
                }

            }
        }
        if (view.getClass().getName().equals("View.ViewEng"))
        {
            Command com = Command.NONE;
            boolean getNewIteration = true;
            while(getNewIteration)
            {
                String command = view.prompt("Enter the command:");
                com = Command.valueOf(command.toUpperCase());
                switch(com)
                {
                    case EXIT:
                        getNewIteration=false;
                        System.out.println("Exiting the program!");
                        break;
                    case LIST:
                        view.printAllStudents(model.getAllStudents());
                        break;
                }

            }
        }
    }

    
}
