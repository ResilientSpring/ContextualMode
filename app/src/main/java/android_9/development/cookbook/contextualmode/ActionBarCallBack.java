package android_9.development.cookbook.contextualmode;

import android_9.development.cookbook.contextualmode.OnActionItemClickListener;
import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ActionBarCallBack extends ActionMode.Callback2 {
    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_cast:

                mode.finish();
                return true;
            case R.id.menu_print:

                mode.finish();
                return true;
            default:
                return false;

        }
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }

    @Override
    public void onGetContentRect(ActionMode mode, View view, Rect outRect) {
        super.onGetContentRect(mode, view, outRect);
    }


}
