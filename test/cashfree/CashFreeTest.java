package test.cashfree;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import javax.jws.soap.SOAPBinding.Use;
import javax.smartcardio.ATR;

class Slot {
    int start;
    int end;
    String date;

    Slot(String date, String start, String end) {
        this.start = Integer.parseInt(start.split(":")[0]+start.split(":")[1]);
        this.end = Integer.parseInt(end.split(":")[0]+end.split(":")[1]);
        this.date = date;
        roundOffSlotTimings();
    }

    Slot(String date, int start, int end) {
        this.start = start;
        this.end = end;
        this.date = date;
        roundOffSlotTimings();
    }

    void roundOffSlotTimings() {

        if(start % 100 != 0 || start % 100 != 30) {
            // add 
            int extraTime = start % 100;
            if(extraTime < 30 ) {
                start = start + (30-extraTime);
            } else{
                start = start + (60-extraTime);
            }
        }

        if(end % 100 != 0 || end % 100 != 30) {
            // add 
            int extraTime = end % 100;
            if(extraTime < 30 ) {
                end = end + (30-extraTime);
            } else{
                end = end + (60-extraTime);
            }
        }

    }

    void print() {
        int shour = start / 00;
        int sminute = start % 00;
        int ehour = start / 00;
        int eminute = start % 00;
        System.out.println("Start Time: "+shour+":"+sminute+ "  End Time: "+ehour+":"+eminute);
    }

}


class User{
    String name;


    User(String name) {
        this.name = name;
    }
}

class Event{
    User user;
    List<Slot> bookedSlots;

    Event(User user, List<Slot> bookedSlots   ){
        this.user= user;
        this.bookedSlots = bookedSlots;

    }
}


class EvnetManagers {
    List<Event> events;

    int[] slots = new int[18];
    

    List<Slot> findAvailableSlots() {

        // mapping 0-> 9, 1-> 930, 2-> 10, 1030-900 (130/30) = 4
        
        /*
        
            900 - 900 = 0
            930 - 900 / 30 = 1
            (1000 - 900 -30) / 30 = 2
            (1030 - 900 -60) / 30 = 3
            (1100 - 900 -90) / 30 = 4
            (1130 - 900 +120) / 30 = 5
 
 
        */
        for(Event user: events) {
            for(Slot s: user.bookedSlots) {             
                int index1 = (s.start - 900) / 30;           
                slots[index1] = -1;
                int index2 = (s.end - 900) / 30;           
                slots[index2] = -1;
            
            // mask in beetween
                if(index2 -index1 > 1) {
                    for(int i=0; i < (index2-index1) ; i ++) {
                        slots[++index1] = -1; 
                    }
                }  
            }
        }

        // print available slots
        List<Slot> results = new ArrayList<>();

        for(int i: slots) {
            if(i != -1) {
                results.add(new Slot(null, (i*30) +900, (i*30) +930));
            }
        }

        return results;
    }

    
}


public class CashFreeTest {
    
    public static void main(String[] args) {
        Slot s1 = new Slot("2024-01-10", "9:30", "10:00");
        Slot s2 = new Slot("2024-01-10", "", "");
        Slot s3 = new Slot("2024-01-10", "", "");

        User user1 = new User("Test 1");
        Event event = new Event(user1, Arrays.asList(s1,s2,s3));

        Slot s4 = new Slot("2024-01-10", "", "");
        Slot s5 = new Slot("2024-01-10", "", "");
        Slot s6 = new Slot("2024-01-10", "", "");

        User user2 = new User("Test 2");
        Event event2 = new Event(user2, Arrays.asList(s4,s5,s6));


        Slot s7 = new Slot("2024-01-10", "", "");
        Slot s8 = new Slot("2024-01-10", "", "");
        Slot s9 = new Slot("2024-01-10", "", "");


        User user3 = new User("Test 3");
        Slot s10 = new Slot("2024-01-10", "", "");
        Slot s11 = new Slot("2024-01-10", "", "");


        User user4 = new User("Test 4");
        Slot s12 = new Slot("2024-01-10", "", "");
        Slot s13 = new Slot("2024-01-10", "", "");
    }
    
    
    /*
    ///  Calendar scheduler which maintains the calendar schedules for different people.  
    It should suggest all the available slots for all the attendees for the given meeting duration 
   //  Note that time is rounded off to the next 30min i.e., 09:55 is rounded to 10:00 
   /*
   slot: 30 min
    time: 9  to 18
    total slots: 18 slots
    
    map:  "1030": true
{


// [1030, 1100] [1130, 1230] 

  events: [
  {
    user: "Tom cruise",
    events: [
      { date: "2023-06-28", start: "10:30", end: "10:55" },
      { date: "2023-06-28", start: "11:30", end: "12:20" },    
      { date: "2023-06-28", start: "14:45", end: "15:45" },    
      { date: "2023-06-28", start: "16:00", end: "16:45" }
    ]
  },
  {
    user: "Robert Downey Jr",
    events: [
      { date: "2023-06-28", start: "09:30", end: "09:55" },
      { date: "2023-06-28", start: "11:30", end: "12:00" }
    ]
  },
  {
    user: "Jason Statham",
    events: [
      { date: "2023-06-28", start: "10:30", end: "12:55" },    
      { date: "2023-06-28", start: "14:45", end: "15:45" },    
      { date: "2023-06-28", start: "15:00", end: "15:45" }
    ]
  }
  ]
}
    */
}



public class CashFreeTest {
    
}
