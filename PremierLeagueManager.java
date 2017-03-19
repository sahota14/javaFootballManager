/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package w1424988;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.Collections;
/**
 *
 * @author mandeepsahota
 */
public class PremierLeagueManager implements LeagueManager  {
    Scanner input = new Scanner(System.in);
    String menu = "";
    char menuselect;
    
    ArrayList<FootballClub> footballClub = new ArrayList<FootballClub>();
   // ArrayList<Match> match = new ArrayList<Match>();
    public void Menu(){
        boolean manager = true;
        while(manager){
            System.out.println("Enter a to add NEW TEAM");         
            System.out.println("Enter d to DELETE A TEAM");           
            System.out.println("Enter m to add a PLAYED MATCH");
            System.out.println("Enter c to view CALENDER");
            System.out.println("Enter s to view STATISTICS");
            System.out.println("Enter t to view PREMIER LEAGUE TABLE");
            System.out.println("Enter z to STOP");
            
          menu = input.next().toLowerCase();
            menuselect = menu.charAt(0);
          switch (menuselect) {
              case 'a':createTeam(); //addMatch(); 
                  break;
              
              case 'd':deleteTeam();
                  break;
              case 'm':addMatch();
                  break;
              case 's':displayStats();
                  break;
              case 't':displayTable();
                  break;
              case 'c':calender();
                  break;
              case 'z':manager = false;
                  break;
        
          }
        }
    }
    
    public void createTeam(){
        System.out.println("Enter team name:");
        String name = input.next();
        System.out.println("Enter team location:");
        String location= input.next();
        
        
     footballClub.add(new FootballClub(name,location));
     
   //
     
     
    } 
    
    public void addMatch(){
        
        System.out.println("enter the name of the first team:");
        String team1 = input.next();
        
        System.out.println("enter the number of goals scored:");
        int scored = input.nextInt();
        
        System.out.println("enter the goals conceded:");
        int taken = input.nextInt();
        
       
        
        System.out.println("enter the name of the opposing team");
        String team2 = input.next();
        
        System.out.println("enter day of match");
        int day = input.nextInt();
        
        System.out.println("enter month of match");
        int month = input.nextInt();
        
        System.out.println("enter year of match");
        int year = input.nextInt();
        
       
        
        
        
        for(int i = 0; i<footballClub.size(); i++){
            if(footballClub.get(i).Name.toLowerCase().equals(team1.toLowerCase())){
                footballClub.get(i).goals(scored, taken);
                footballClub.get(i).playedMatches();
            }
           
            if(footballClub.get(i).Name.toLowerCase().equals(team2.toLowerCase())){
                footballClub.get(i).goals(taken, scored);
                footballClub.get(i).playedMatches();
            }
            //goals scored by team one are the goals which were conceded by team 2 and vice versa
            
            footballClub.get(i).matchDate(day,month,year);
        }
        
        
        
    }
    
    
    
    public void deleteTeam(){
        System.out.println("Enter name of the team you want to delete:");
        String teamName = input.next().toLowerCase();
        for(int i = 0; i<footballClub.size(); i++){
            if(footballClub.get(i).Name.toLowerCase().equals(teamName)){
                footballClub.remove(i);
                System.out.println("deleted");
                                        
            }
    }   
}
 
    public void displayStats(){
        System.out.println("Enter team name stats you wish to see:");
        String statname = input.next();
        for(int i=0; i<footballClub.size(); i++){
            if(statname.equals(footballClub.get(i).Name)) {
                System.out.println("Name: " + footballClub.get(i).Name);
                System.out.println("Location: " + footballClub.get(i).Location);
                System.out.println("wins: " + footballClub.get(i).wins);
                System.out.println("defeats: " + footballClub.get(i).defeats);
                System.out.println("draws: " + footballClub.get(i).draws);
                System.out.println("goals scored: " + footballClub.get(i).totalGoalsScored);
                System.out.println("goals conceeded: " + footballClub.get(i).totalGoalsConceded);
                System.out.println("points: " + footballClub.get(i).points);
                System.out.println("matches played: " + footballClub.get(i).matchesPlayed);
                
            }
            
        }
    }
    
    public void displayTable(){
        Collections.sort(footballClub);
        
        System.out.format("%15s%15s%15s%15s%15s%15s%15s%15s%15s%15s","name","location","wins","defeats","draws","scored","conceded","points","matches","goaldiff");
        System.out.println(" ");
        for(FootballClub fc: footballClub){
            System.out.format("%15s%15s%15s%15s%15s%15s%15s%15s%15s%15s",fc.Name,fc.Location,fc.wins,fc.defeats,fc.draws,fc.totalGoalsScored,fc.totalGoalsConceded,fc.points,fc.matchesPlayed,fc.goalDiff);
            System.out.println(" ");
        }
    }
    
    
    public void calender(){
        
                   
                Scanner in = new Scanner(System.in);
                
                
                System.out.print("Enter month name: ");
                int month = 0; 
                
                String monthtxt = in.next().toLowerCase();
                
                if(monthtxt.equals("january")){month = 1;}
                if(monthtxt.equals("february")){ month = 2;}
                if(monthtxt.equals("march")){ month = 3;}
                if(monthtxt.equals("april")){month = 4;}
                if(monthtxt.equals("may")){month = 5;}
                if(monthtxt.equals("june")){ month = 6;}
                if(monthtxt.equals("july")){ month = 7;}
                if(monthtxt.equals("august")){ month = 8;}
                if(monthtxt.equals("september")){month = 9;}
                if(monthtxt.equals("october")){ month = 10;}
                if(monthtxt.equals("november")){ month = 11;}
                if(monthtxt.equals("december")){ month = 12;}
                
                
                System.out.print("Enter year: ");
                int year = in.nextInt();
                
                        
                //gets calender month and year information
                
                
                Calendar matchCal = new GregorianCalendar();
 
                
                matchCal.clear();
                matchCal.set(year, month - 1, 1);
 
                
                System.out.println("\n"+ matchCal.getDisplayName(Calendar.MONTH, Calendar.LONG,Locale.UK) + " " + matchCal.get(Calendar.YEAR));
 
               
                int firstDay = matchCal.get(Calendar.DAY_OF_WEEK);
               
               
                int daysInMonth = matchCal.getActualMaximum(Calendar.DAY_OF_MONTH);
                
                //Prints Calender
                
                   int weekdays = 0;
             
                System.out.println("Su  Mo  Tu  We  Th  Fr  Sat");
              
                for (int day = 1; day < firstDay; day++) {
                        System.out.print("    ");
                        weekdays++;
                }
               
                for (int day = 1; day <= daysInMonth; day++) {                       
                        System.out.printf("%1$2d", day);                       
                        weekdays++;
                       
                        if (weekdays == 7) {                               
                                weekdays = 0;                                
                                System.out.println();
                                
                                    }
                        
                        else {
                                System.out.print("  ");
                                
                                }
                }
 
                
                System.out.println();
                
                // gets user input for day, month and year and sees if it equals the one entered in the add match
                
                System.out.println("enter day (as a digit) of match");
                int dayNew = input.nextInt();
                
                System.out.println("enter month (as a digit) of match");
                int monthNew = input.nextInt();
                
                System.out.println("enter year of match");              
                int yearNew = input.nextInt();
                
                // will compare the date entered above is equal to the one entered when the match was created
                for(int i=0; i<footballClub.size(); i++){
                if(dayNew == (footballClub.get(i).day) && monthNew == (footballClub.get(i).month) && yearNew == (footballClub.get(i).year)){
                    System.out.println( footballClub.get(i).Name );
                    System.out.println("Location: " + footballClub.get(i).Location);
                    System.out.println("wins: " + footballClub.get(i).wins);
                    System.out.println("defeats: " + footballClub.get(i).defeats);
                    System.out.println("draws: " + footballClub.get(i).draws);
                    System.out.println("goals scored: " + footballClub.get(i).totalGoalsScored);
                    System.out.println("goals conceeded: " + footballClub.get(i).totalGoalsConceded);
                    System.out.println("points: " + footballClub.get(i).points);
                    System.out.println("matches played: " + footballClub.get(i).matchesPlayed);
                    
                    
                }
                    }       
        
    }
    


      
        public void printCalendar(int daysInMonth, int firstDay) {
               
                
                int weekdays = 0;
             
                System.out.println("Su  Mo  Tu  We  Th  Fr  Sat");
              
                for (int day = 1; day < firstDay; day++) {
                        System.out.print("    ");
                        weekdays++;
                }
               
                for (int day = 1; day <= daysInMonth; day++) {                       
                        System.out.printf("%1$2d", day);                       
                        weekdays++;
                       
                        if (weekdays == 7) {                               
                                weekdays = 0;                                
                                System.out.println();
                                
                                    }
                        
                        else {
                                System.out.print("  ");
                                
                                }
                }
 
                // print a final new-line.
                System.out.println();
                
                System.out.println("enter day (as a digit) of match");
                int day = input.nextInt();
                
                System.out.println("enter month (as a digit) of match");
                int month = input.nextInt();
                
                System.out.println("enter year of match");              
                int year = input.nextInt();
                
                // will compare the date entered above is equal to the one entered when the match was created
                for(int i=0; i<footballClub.size(); i++){
                if(day == (footballClub.get(i).day) && month == (footballClub.get(i).month) && year == (footballClub.get(i).year)){
                    System.out.println( footballClub.get(i).Name );
                    System.out.println("Location: " + footballClub.get(i).Location);
                    System.out.println("wins: " + footballClub.get(i).wins);
                    System.out.println("defeats: " + footballClub.get(i).defeats);
                    System.out.println("draws: " + footballClub.get(i).draws);
                    System.out.println("goals scored: " + footballClub.get(i).totalGoalsScored);
                    System.out.println("goals conceeded: " + footballClub.get(i).totalGoalsConceded);
                    System.out.println("points: " + footballClub.get(i).points);
                    System.out.println("matches played: " + footballClub.get(i).matchesPlayed);
                    
                    
                }
                    }
        }
    
    
}
