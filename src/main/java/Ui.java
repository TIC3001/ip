import java.util.Scanner;

public class Ui {
    private Scanner in = new Scanner(System.in);
    public void printlogo(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }
    public void greetInfo() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }
    public void exitInfo(){
        System.out.println("----------------\n"+"Bye. Hope to see you again soon!");
    }
    public String getInput(Scanner in) throws DukeException{
        String s=in.nextLine().trim();

       if(s.equals("todo") | s.equals("deadline") | s.equals("event"))
            throw new DukeException("OOPS!!! The description of a "+s+" cannot be empty");
        else if(!s.startsWith("todo") & !s.startsWith("deadline") & !s.startsWith("event")
                & !s.equals("List") & !s.equals("done") & !s.equals("bye"))
            throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
        else if(s.startsWith("event") & !s.contains("/at"))
            throw new DukeException("OOPS!!! The date of event cannot be empty");
        else if(s.startsWith("deadline") & !s.contains("/by"))
           throw new DukeException("OOPS!!! The date of deadline cannot be empty");
        return s;
    }
    public void printList(Task [] tasks,int size){
        System.out.println("-----------");
        for (int i = 0;i<size;i++){
            System.out.println((i+1)+"."+ "["+tasks[i].getStatusIcon()+"] "+
                    tasks[i].description);
        }
        System.out.println("-----------");
    }
    public void printTask(String str,int count){
        System.out.println("--------------\nGot it. I've added this task: " + "\n"+str);
        System.out.println("Now you have "+count+" in the list.\n-------------------");
    }
    public void printMsg(Task t){
        System.out.println( "-----------------\n"+"Nice! I've marked this task as done:\n"+"["+t.getStatusIcon()+"] "+
                t.description);
    }
    public void printError(Exception e){
        System.out.println("--------------\n"+e+"\n-------------------");
    }
}
