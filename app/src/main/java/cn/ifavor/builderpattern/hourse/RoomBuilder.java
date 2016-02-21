package cn.ifavor.builderpattern.hourse;

/**
 * 房屋建造者
 * @author HSW
 *
 */
public class RoomBuilder implements Builder{
    private Room room = new Room();

    /** 具体创建窗户 */
    public void mkWindow() {

        Window window = new Window();
        room.setWindow(window);
    }

    /** 具体创建地板 */
    public void mkFloor() {

        Floor floor = new Floor();
        room.setFloor(floor);
    }

    /** 交付以创建好的房子 */
    public Room getRoom() {
        return room;
    }

}