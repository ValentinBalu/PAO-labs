package tema;
//2
public class Room {
    private int roomNumber;

    private String roomType;

    private int roomFloor;

    public Room(int roomNumber,String roomType, int roomFloor) {
        this.roomNumber = roomNumber;
        this.roomType=roomType;
        this.roomFloor=roomFloor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(int roomFloor) {
        this.roomFloor = roomFloor;
    }

    public String toString(){
        return "Room("+
                "RoomNumber "+roomNumber+
                ", roomFloor "+ roomFloor +'\''+
                ", roomType " +roomType + '\''+
                "}";
    }
}
