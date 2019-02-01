package layout.milad.com.cursorwheel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import github.hellocsl.cursorwheel.CursorWheelLayout;
import layout.milad.com.cursorwheel.Data.ImageData;
import layout.milad.com.cursorwheel.R;

public class WheelImageAdapter extends CursorWheelLayout.CycleWheelAdapter {

    private Context context;
    private List<ImageData> menuItemData;
    private LayoutInflater inflater;


    public WheelImageAdapter(Context context, List<ImageData> menuItemData) {
        this.context = context;
        this.menuItemData = menuItemData;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return menuItemData.size();
    }

    @Override
    public View getView(View parent, int position) {
        ImageData data = getItem(position);
        View root = inflater.inflate(R.layout.wheel_image_layout, null, false);
        ImageView imageView = root.findViewById(R.id.id_wheel_menu_item_iv);
        imageView.setImageResource(data.imageResource);
        return root;
    }

    @Override
    public ImageData getItem(int position) {
        return menuItemData.get(position);
    }
}
