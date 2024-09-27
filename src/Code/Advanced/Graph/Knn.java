package Code.Advanced.Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList; 
import java.util.Arrays;

public class KNN {
    
public static void main(String args[]) {
    //Manually update the values to sync with number of questions and number of users !!
      Integer numberOfQuestions = 8;
      Integer numberofUsers = 5;
      ArrayList<Integer[]> user2DData = new ArrayList<>();
      String filePath = "/uploads/tanglesUsers.csv";
      readUserData(user2DData, numberOfQuestions, filePath);
      System.out.println(Arrays.deepToString(user2DData.toArray()));
      Integer[][] result = new Integer[numberofUsers][2];
      processKNN(user2DData, result, numberOfQuestions);
  }
  
private static void processKNN(ArrayList<Integer[]> user2DData, Integer[][] result, Integer numberOfQuestions) {
    int userSize = user2DData.size();
    int nearestUser = -1;
    for(int currentUser=0; currentUser<userSize; currentUser++) {
        nearestUser = nearestNeighbour(currentUser,numberOfQuestions,user2DData);
        System.out.println("Closest user of " +currentUser+ " is " +nearestUser);
    }
}

private static Integer nearestNeighbour(Integer user, Integer numberOfQuestions, ArrayList<Integer[]> user2DData) {
    int numberOfUsers= user2DData.size();
    int temp =0;
    float currentScore=0, finalScore=100;
    int closetUser = -1;
    if(user>numberOfUsers || user<0) return -1;
    for(int i=0;i< user2DData.size(); i++) {
        if(i != user) {
            for(int j=0;j<numberOfQuestions;j++) {
            //compare user2DData[user] and user2DData[i] for score
            temp += Math.pow((user2DData.get(user)[j] - user2DData.get(i)[j]),2);
            }
            currentScore = (float)Math.sqrt(temp);
            //System.out.println("Score of user"+user+" to user"+i+" is "+currentScore);
            if(currentScore <= finalScore) {
                finalScore = currentScore;
                closetUser = i;
                //System.out.println("Closest user reset to" + i);
            }
        }
        temp=0;
    }
    return closetUser;
}
private static void readUserData(ArrayList<Integer[]> user2DData, Integer numberOfQuestions, String filePath) {
  BufferedReader objReader = null;
    
  try {
   String strCurrentLine;
   objReader = new BufferedReader(new FileReader(filePath));
   objReader.readLine();
   
   while ((strCurrentLine = objReader.readLine()) != null) {
    String[] splitArray = strCurrentLine.split(",");
    Integer[] currentUserData = new Integer[numberOfQuestions];
    for (int i = 0; i < splitArray.length-1; i++) {
        currentUserData[i] = Integer.parseInt(splitArray[i+1]);
     }
    user2DData.add(currentUserData);
   }
  } catch (IOException e) {
   e.printStackTrace();
  } finally {
    try{
    if (objReader != null)
     objReader.close();
      }
      catch(IOException e) {
   e.printStackTrace();
    }
   }
}
}