import java.util.HashMap;
import java.util.List;

class ElevatorSystem {
    List<Floor> floorList;
    List<ElevatorCar> elevatorCarList;

    stopElevator();

    initializeElevator();
}

class ElevatorCar {
    ButtonPannel buttonPannel;
    Door door;
    int currentFloor;

    int getCurrentFloor();

    boolean isMoving;
    boolean isMovingUp;
    int startFloor;
    int endFloor;
}

class Floor {
    int floorNo;
    ButtonPannel buttonPannel;

    void callElevator(int floorNo, ButtonPannel buttonPannel);
}

interface ButtonPanel {
    sendNotificationToDespatcher();
}

class InsideButtonPanel {
    HashMap<Integer, String> m;

    sendNotificationToDespatcher(int currentFloor, int targetFloor, boolean calCUlate);
}

class OutsideButtonPanel {
    boolean isMovingUp;

    sendNotificationToDespatcher(null,int targetFloor, boolean isMovingUp);
}

class Door {
    boolean isOpen;

    void openDoor();

    void closeDoor();
}

--------------------------------------------------------------------------------------------------------------------------------

class ElevatorCar {
    ButtonPannel buttonPannel;
    Door door;
    boolean isMoving;
    boolean isMovingUp;
    int currentFloor;
    int startFloor;
    int endFloor;

    void moveToFloor(int floorMoveTo);
}

interface ButtonPannel {
    boolean sendInstructionToDispatcher(int currentFloor, int destinationFloor, boolean isMovingUp);
}

class OutSideButtonPanel implements ButtonPannel {
    boolean isMovingUp;

    boolean sendInstructionToDispatcher(null,int currentFloor, boolean isMovingUp);
}

class InsideButtonPanel implements ButtonPannel {
//    boolean isMovingUp;

    //we have to set that we have to stop at targetfloor so floorStatus[target]=true and floorStatus[currentFloor]=false;
    //we have to pass this to dispatcher unit within sendInstructionToDispatcher() methode
    map<int, boolean> floorStatus;

    boolean sendInstructionToDispatcher(int currentFloor, int destinationFloor, boolean calculateMovingUp);
}

class Door {
    boolean isOpen;

    boolean closeTheDoor();

    boolean openTheDoor();
}

class ElevatorSystem {
    List<Elevator> allElevator;
    List<Floor> allFloor;

    startElevetorSystem();

    //we can target any elevator and stop it
    stopSystem();
}

class Floor {
    int currentFloor;
    ButtonPannel buttonPannel;

    callEleveator(int currentFloor, ButtonPannel buttonPannel);
}


// C++ program to demonstrate
// SCAN Disk Scheduling algorithm

//#include<bits/stdc++.h>
//        using namespace std;
//
//        int size=8;
//        int disk_size=200;
//
//        void SCAN(int arr[],int head,string direction)
//        {
//        int seek_count=0;
//        int distance,cur_track;
//        vector<int>left,right;
//        vector<int>seek_sequence;
//
//        // appending end values
//        // which has to be visited
//        // before reversing the direction
//        if(direction=="left")
//        left.push_back(0);
//        else if(direction=="right")
//        right.push_back(disk_size-1);
//
//        for(int i=0;i<size; i++){































































































































































































































































































































































































































































































//        if(arr[i]<head)
//        left.push_back(arr[i]);
//        if(arr[i]>head)
//        right.push_back(arr[i]);
//        }
//
//        // sorting left and right vectors
//        std::sort(left.begin(),left.end());
//        std::sort(right.begin(),right.end());
//
//        // run the while loop two times.
//        // one by one scanning right
//        // and left of the head
//        int run=2;
//        while(run--){
//        if(direction=="left"){
//        for(int i=left.size()-1;i>=0;i--){
//        cur_track=left[i];
//
//        // appending current track to seek sequence
//        seek_sequence.push_back(cur_track);
//
//        // calculate absolute distance
//        distance=abs(cur_track-head);
//
//        // increase the total count
//        seek_count+=distance;
//
//        // accessed track is now the new head
//        head=cur_track;
//        }
//        direction="right";
//        }
//        else if(direction=="right"){
//        for(int i=0;i<right.size();i++){
//        cur_track=right[i];
//        // appending current track to seek sequence
//        seek_sequence.push_back(cur_track);
//
//        // calculate absolute distance
//        distance=abs(cur_track-head);
//
//        // increase the total count
//        seek_count+=distance;
//
//        // accessed track is now new head
//        head=cur_track;
//        }
//        direction="left";
//        }
//        }
//
//        cout<<"Total number of seek operations = "
//        <<seek_count<<endl;
//
//        cout<<"Seek Sequence is"<<endl;
//
//        for(int i=0;i<seek_sequence.size();i++){
//        cout<<seek_sequence[i]<<endl;
//        }
//        }
//
//// Driver code
//        int main()
//        {
//
//        // request array
//        int arr[size]={176,79,34,60,
//        92,11,41,114};
//        int head=50;
//        string direction="left";
//
//        SCAN(arr,head,direction);
//
//        return 0;
//        }
