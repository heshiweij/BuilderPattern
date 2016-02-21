package cn.ifavor.builderpattern;

public class AlertDialog {
    private String title;
    private String message;
    private int buttonCount;

    private AlertDialog() {
        // empty
    }

    /** 获取标题 */
    public String getTitle() {
        return title;
    }

    /** 获取信息 */
    public String getMessage() {
        return message;
    }

    /** 获取按钮数 */
    public int getButtonCount() {
        return buttonCount;
    }

    /** 显示 */
    public void show(){
        System.out.println("show");
    }

    /** 建造者 */
    public static class Builder{
        private AlertDialog entity = new AlertDialog();

        public Builder(boolean isContext){
            if (!isContext){
                throw new RuntimeException("必须有上下文");
            }
        }

        /** 设置标题 */
        public Builder setTitle(String title) {
            entity.title = title;
            return this;
        }

        /** 设置内容 */
        public Builder setMessage(String message) {
            entity.message = message;
            return this;
        }

        /** 设置按钮数 */
        public Builder setButtonCount(int buttonCount) {
            entity.buttonCount = buttonCount;
            return this;
        }

        /** 交付结果 */
        public AlertDialog create(){
            return entity;
        }
    }

}
