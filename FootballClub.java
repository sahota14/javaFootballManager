/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package w1424988;

/**
 *
 * @author mandeepsahota
 */
public class FootballClub extends SportsClub implements Comparable<FootballClub> {
    
        int wins;
        int draws;
        int defeats;
        int totalGoalsScored;
        int totalGoalsConceded;
        int points;
        int matchesPlayed;
        int goalDiff;
        int day;
        int month;
        int year;
        
   
    
    public FootballClub(String name, String location){
        Name = name;
        Location = location;
        
        wins = 0;
        draws= 0;
        defeats = 0;
        points=0;
        matchesPlayed = 0;
        
        
        
    }
    
    public void goals(int goalsScored, int goalsConceded){
        
        if(goalsScored > goalsConceded){
            wins ++;
            points =points + 3;
        }
        
        if(goalsScored == goalsConceded){
            draws ++;
            points =points + 1;
        }
        
        if (goalsScored < goalsConceded){
            defeats ++;
            
        }
        
        totalGoalsScored = totalGoalsScored + goalsScored;
        totalGoalsConceded = totalGoalsConceded + goalsConceded; 
        
        goalDiff = totalGoalsScored - totalGoalsConceded;
        
    }
    
    public void playedMatches (){
        matchesPlayed ++;
        
    }
    
    public void matchDate(int dayNum, int monthNum, int yearNum){
        day = dayNum;
        month = monthNum;
        year = yearNum;
        
    }
    
        @Override
    public int compareTo(FootballClub fc) {
        if(points < fc.points){
            return 1;
        } else if (points > fc.points) {
            return -1;
        } else {
            return goalDifference(fc);
        }
    }

    public int goalDifference(FootballClub fc){
        if(totalGoalsScored - totalGoalsConceded > fc.totalGoalsScored - totalGoalsConceded){
            return 1;
        } else {
            return -1;
        }
    }
    
    
    
 
}
