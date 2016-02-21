package cn.ifavor.builderpattern.hourse;

public class Designer {

    /**
     * 命令 Builder
     * @param builder
     */
    public void command(Builder builder){
        // 建造房屋
        builder.mkWindow();

        // 建造地板
        builder.mkFloor();
    }
}