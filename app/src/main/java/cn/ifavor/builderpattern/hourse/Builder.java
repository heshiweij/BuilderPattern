package cn.ifavor.builderpattern.hourse;

/**
 * 建造者接口
 * @author HSW
 *
 */
public interface Builder {

    /**
     * 建造窗户
     */
    public void mkWindow();

    /**
     * 建造房屋
     */
    public void mkFloor();

    /**
     * 获取房间
     */
    public Room getRoom();
}

