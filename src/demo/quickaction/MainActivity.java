package demo.quickaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import demo.quickaction.QuickAction.OnClickQuickActionListener;

public class MainActivity extends Activity {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private final int ID_FIND = 0;
	private final int ID_INFO = 1;
	private final int ID_CLEAR = 2;
	private final int ID_OK = 3;

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Public Methods
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Popup window
		final QuickAction window = new QuickAction(this);

		ActionItem findItem = new ActionItem(this, "Find", ID_FIND,
				R.drawable.menu_search);
		ActionItem infoItem = new ActionItem(this, "Info", ID_INFO,
				R.drawable.menu_info);
		ActionItem clearItem = new ActionItem(this, "Clear", ID_CLEAR,
				R.drawable.menu_eraser);
		ActionItem okItem = new ActionItem(this, "Ok", ID_OK,
				R.drawable.menu_ok);

		window.addQuickActionItem(findItem);
		window.addQuickActionItem(infoItem);
		window.addQuickActionItem(clearItem);
		window.addQuickActionItem(okItem);

		window.setOnClickQuickActionListener(new OnClickQuickActionListener() {

			@Override
			public void OnClickQuickAction(int actionId) {
				String name = new String();

				switch (actionId) {
				case ID_FIND:
					name = "查找";
					break;

				case ID_INFO:
					name = "信息";
					break;

				case ID_CLEAR:
					name = "清理";
					break;

				case ID_OK:
					name = "成功";
					break;
				}

				Toast.makeText(getBaseContext(), name, Toast.LENGTH_SHORT)
						.show();
			}
		});

		// // Action Item
		// Button view = new Button(this);
		// view.setText("俺是Popup Window");
		// view.setGravity(Gravity.CENTER);
		// view.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View arg0) {
		// Toast.makeText(getBaseContext(), "click", Toast.LENGTH_SHORT).show();
		// window.dismiss();
		// }
		// });
		// window.addQuickAction(view);

		// 左上
		setOnclick(window, R.id.btn_left_top);
		setOnclick(window, R.id.btn_center_top);
		setOnclick(window, R.id.btn_right_top);
		setOnclick(window, R.id.btn_center_left);
		setOnclick(window, R.id.btn_center_right);
		setOnclick(window, R.id.btn_left_bottom);
		setOnclick(window, R.id.btn_center_bottom);
		setOnclick(window, R.id.btn_right_bottom);

	}

	private void setOnclick(final QuickAction window, int resourceId) {
		final Button button = (Button) findViewById(resourceId);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if (null != window) {
					window.show(button);
				}
			}
		});
	}

	// ===========================================================
	// Private Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}