package layout.milad.com.cursorwheel.adapter;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;

import github.hellocsl.cursorwheel.CursorWheelLayout;
import layout.milad.com.cursorwheel.Data.MenuItemData;
import layout.milad.com.cursorwheel.R;

public class WheelTextAdapter extends CursorWheelLayout.CycleWheelAdapter {


    private Context context;
    private List<MenuItemData> menuItemData;
    private LayoutInflater inflater;
    private int gravity;

    public WheelTextAdapter(Context context, List<MenuItemData> menuItemData) {
        this.context = context;
        this.menuItemData = menuItemData;
        gravity = Gravity.CENTER;
        inflater = LayoutInflater.from(context);
    }

    public WheelTextAdapter(Context context, List<MenuItemData> menuItemData, int gravity) {
        this.context = context;
        this.menuItemData = menuItemData;
        this.gravity = gravity;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return menuItemData.size();
    }

    @Override
    public View getView(View parent, int position) {

        MenuItemData itemData = getItem(position);
        View root = inflater.inflate(R.layout.wheel_text_layout, null, false);
        TextView textView = root.findViewById(R.id.id_wheel_menu_item_tv);
        textView.setVisibility(View.VISIBLE);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        textView.setText(itemData.title);
        if (textView.getLayoutParams() instanceof FrameLayout.LayoutParams)
            ((FrameLayout.LayoutParams) textView.getLayoutParams()).gravity = gravity;
        if (position==4)
            textView.setTextColor(ActivityCompat.getColor(context,R.color.red));
        return root;
    }

    @Override
    public MenuItemData getItem(int position) {
        return menuItemData.get(position);
    }
}
