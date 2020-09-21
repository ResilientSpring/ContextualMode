package android_9.development.cookbook.contextualmode;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    ActionMode mActionMode, mActionMode2;

    // For long click on ImageView
    private ActionMode.Callback2 mActionModeCallback = new
            ActionMode.Callback2() {
                @Override
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    mode.getMenuInflater().inflate(R.menu.context_menu, menu);
                    return true;
                }

                @Override
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return false;
                }

                @Override
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.menu_cast:
                            Toast.makeText(MainActivity.this, "Cast", Toast.LENGTH_SHORT).show();
                            mode.finish();
                            return true;
                        case R.id.menu_print:
                            Toast.makeText(MainActivity.this, "Print", Toast.LENGTH_SHORT).show();
                            mode.finish();
                            return true;
                        default:
                            return false;

                    }
                }

                @Override
                public void onDestroyActionMode(ActionMode mode) {
                    mActionMode = null;
                }
            };

    // For long click on textView
    private ActionMode.Callback2 mActionMode2Callback = new
            ActionMode.Callback2() {
                // Called when the action mode is created; startActionMode() was called
                @Override
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {

                    // Inflate a menu resource providing context menu items
                    mode.getMenuInflater().inflate(R.menu.context_menu, menu);
                    return true;
                }

                // Called each time the action mode is shown. Always called after onCreateActionMode, but
                // may be called multiple times if the mode is invalidated.
                @Override
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return false;  // Return false if nothing is done
                }

                // Called when the user selects a contextual menu item
                @Override
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.menu_cast:
                            Toast.makeText(MainActivity.this, "Cast", Toast.LENGTH_SHORT).show();
                            mode.finish();
                            return true;
                        case R.id.menu_print:
                            Toast.makeText(MainActivity.this, "Print", Toast.LENGTH_SHORT).show();
                            mode.finish();
                            return true;
                        default:
                            return false;

                    }
                }

                // Called when the user exits the action mode
                @Override
                public void onDestroyActionMode(ActionMode mode) {
                    mActionMode = null;
                }

                @Override
                public void onGetContentRect(ActionMode mode, View view, Rect outRect) {
                    super.onGetContentRect(mode, view, outRect);
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setOnLongClickListener(new View.OnLongClickListener() {

            public boolean onLongClick(View view) {
                if (mActionMode != null) return false;

                mActionMode = startActionMode(mActionModeCallback, ActionMode.TYPE_FLOATING);
                return true;
            }
        });

        TextView textView = findViewById(R.id.textview1);
        textView.setOnLongClickListener(new View.OnLongClickListener() {

            public boolean onLongClick(View view) {
                if (mActionMode != null) return false;

                mActionMode = startActionMode(mActionMode2Callback, ActionMode.TYPE_FLOATING);
                view.setSelected(true);
                return true;
            }
        });
    }

}