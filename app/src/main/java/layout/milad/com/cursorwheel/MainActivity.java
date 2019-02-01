package layout.milad.com.cursorwheel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import github.hellocsl.cursorwheel.CursorWheelLayout;
import layout.milad.com.cursorwheel.Data.ImageData;
import layout.milad.com.cursorwheel.Data.MenuItemData;
import layout.milad.com.cursorwheel.adapter.WheelImageAdapter;

public class MainActivity extends AppCompatActivity implements CursorWheelLayout.OnMenuSelectedListener {

    private CursorWheelLayout wheel_image;
    private List<ImageData> listImage;
    private List<MenuItemData> listText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();

        loadData();

        wheel_image.setOnMenuSelectedListener(this);

    }

    private void loadData() {


        listImage = new ArrayList<>();
        listImage.add(new ImageData(R.drawable.yellow, "Yellow"));
        listImage.add(new ImageData(R.drawable.blue, "Blue"));
        listImage.add(new ImageData(R.drawable.red, "Red"));
        listImage.add(new ImageData(R.drawable.green, "Green"));
        listImage.add(new ImageData(R.drawable.white, "White"));
        listImage.add(new ImageData(R.drawable.pink, "pink"));

        WheelImageAdapter imageAdapter = new WheelImageAdapter(getBaseContext(), listImage);
        wheel_image.setAdapter(imageAdapter);

    }

    private void initViews() {
        wheel_image = findViewById(R.id.wheel_image);
    }

    @Override
    public void onItemSelected(CursorWheelLayout parent, View view, int pos) {

        if (parent.getId() == R.id.wheel_image)
            Toast.makeText(getBaseContext(), "Selected : " + listImage.get(pos).imageDescription, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "nothing", Toast.LENGTH_SHORT).show();
    }
}


