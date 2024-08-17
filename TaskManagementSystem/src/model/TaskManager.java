package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskManager {
  private  static  TaskManager taskManager;

  private Map<String,Task> tasks;
  private Map<String, List<Task>> userTasks;

  public TaskManager(){
      tasks = new ConcurrentHashMap<>();
      userTasks = new ConcurrentHashMap<>();
  }
  public static TaskManager getTaskManager(){
      if(taskManager==null)return new TaskManager();
      return taskManager;
  }

  public void createTask(Task task){
     tasks.put(task.getId(),task);
     assignTaskToUser(task.getAssignedUser(),task);
     System.out.println("Task created: " + task.getId());
  }

  public void updateTask(Task updatedTask){
      Task existingTask = tasks.get(updatedTask.getId());
      if(existingTask!=null){
          existingTask.setDescription(updatedTask.getDescription());
          existingTask.setPriority(updatedTask.getPriority());
          existingTask.setTitle(updatedTask.getTitle());
          existingTask.setTaskStatus(updatedTask.getTaskStatus());
          existingTask.setDueDate(updatedTask.getDueDate());
          User newUser = updatedTask.getAssignedUser();
          User existingUser = updatedTask.getAssignedUser();
          if(!newUser.equals(existingUser)){
              unassignTaskToUser(existingUser,existingTask);
              assignTaskToUser(newUser,existingTask);
          }
      }
  }

  public void deleteTask(String taskId){
      Task task = tasks.get(taskId);
      if(taskId !=null){
          tasks.remove(taskId);
          unassignTaskToUser(task.getAssignedUser(),task);
      }
  }

  public List<Task> searchTasks(String keyword){
      List<Task> matchingTasks = new ArrayList<>();
      for(Task task: tasks.values()){
          if(task.getTitle().contains(keyword) ||
             task.getDescription().contains(keyword)){
              matchingTasks.add(task);
          }
      }
      return matchingTasks;
  }

  public List<Task> filterTasks(TaskStatus status, Date startDate, Date endDate, String priority){
      List<Task> filteredTasks = new ArrayList<>();
      for(Task task:tasks.values()){
          if(task.getTaskStatus().equals(status) &&
             task.getPriority().equals(priority) &&
             task.getDueDate().compareTo(startDate)>=0 &&
             task.getDueDate().compareTo(endDate)<=0
             ){
              filteredTasks.add(task);
           }
      }
      return filteredTasks;
  }

  public void markTaskAsCompleted(String taskId){
     Task task = tasks.get(taskId);
     if(task!=null){
         synchronized (task) {
             task.setTaskStatus(TaskStatus.COMPLETED);
         }
     }
  }

  public List<Task> getTaskHistory(User user){
     return  userTasks.getOrDefault(user.getUserId(),new ArrayList<>());
  }

  private  void assignTaskToUser(User user, Task task){
       userTasks.computeIfAbsent(user.getUserId(), k-> new ArrayList<>()).add(task);
  }

  private void unassignTaskToUser(User user, Task task){
      List<Task> tasks = userTasks.get(user.getUserId());
      if(tasks!=null){
          tasks.remove(task);
      }
  }

}
