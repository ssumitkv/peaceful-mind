package test.skylo;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class SkyloTest {
    



}



class Building{
    List
}

class User{

}

interface Room{
    String location = null;
}

class ConferenceRoom implements Room{
    Map<String, Meeting> scheduledMeeting;  // key: date-slot_id  2025-01-01-0
    List<Slot> slots;
}

class Slot{
    int id;
    LocalTime start;
    LocalTime end;
    Status  status;
}

class Meeting {
    User user;
    List<Integer> slots; // slots: 0: 00:00 to 00:30
}


// APIs
/*
    1. List of Available/All rooms filter type [conerence/ meeting room]
        GET:

        url: /rooms
        query param:
            type: 
            filters: 
                roomId: 
                status: "AVAILABLE/ BUSY"
                date: ""
                slotId (optional): 

        headder: JWT (Barer token)

    2. book




 */
