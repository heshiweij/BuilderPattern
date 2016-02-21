package cn.ifavor.builderpattern;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import cn.ifavor.builderpattern.hourse.Builder;
import cn.ifavor.builderpattern.hourse.Designer;
import cn.ifavor.builderpattern.hourse.Floor;
import cn.ifavor.builderpattern.hourse.Room;
import cn.ifavor.builderpattern.hourse.RoomBuilder;
import cn.ifavor.builderpattern.hourse.Window;

public class MainActivity extends AppCompatActivity {

    SimpleDraweeView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        //  Fresco 配置演示
        FrescoDemo();


        //  User 代码演示
		/*User.Builder builder = new User.Builder();
         User user = builder.setName("corn").setAge(100).setAddress("广州")
         .build();

		User.Builder builder = new User.Builder().setAddress("address").setName("Name").setAge(20);
		User user = builder.build();*/

        // AlertDialog 代码示例
        new AlertDialog.Builder(true)
                .setTitle("Title")
                .setMessage("Message")
                .setButtonCount(2)
                .create()
                .show();

        // 建造房子 代码示例
		Builder builder = new RoomBuilder();
		Designer design = new Designer();
		design.command(builder);

		Room room = builder.getRoom();
		Window window = room.getWindow();
		Floor floor = room.getFloor();
    }

    /**
     * Fresco 配置演示
     */
    private void FrescoDemo() {
        sv = (SimpleDraweeView) findViewById(R.id.sv);

        // 配置参数
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setFailureImage(ContextCompat.getDrawable(this, R.mipmap.icon_failure), ScalingUtils.ScaleType.CENTER_CROP)
                .build();

        sv.setHierarchy(hierarchy);

        // 加载图片
        loadImage();
    }

    /**
     * 加载图片
     */
    private void loadImage() {
        // 加载图片
        String successUrl = "http://i13.tietuku.com/540906624cdcf629.png";

        // 加载图片
        // 代码定制 - 启用重试图片显示
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(successUrl))
                .setTapToRetryEnabled(true)
                .setOldController(sv.getController())
                .build();

        sv.setController(controller);
    }


}
