package com.example.acsnoteuitests.utils;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import junit.framework.TestCase;

import com.robotium.solo.Solo;

public class Utils extends TestCase {

	private Solo solo;
	private Context context;
	public int MEDIUM_TIMEOUT = 3000; // medium timeout
	public static final String COLOR_ACTIVITY = "NPD_ColorClass";
	public static final String HOME_ACTIVITY = "NPD_Home";
	public static final String SETTINGS_ACTIVITY = "NPD_Preference";
	

	public Utils(Solo solo, Context context) {
		this.solo = solo;
		this.context = context;

	}

	public void printAllCurrentViews() {
		ArrayList<View> view = solo.getCurrentViews();
		Resources res = solo.getCurrentActivity().getResources();

		if (view.size() == 0) {
			Log.i("Robotium",
					"ERROR! Size of array is 0 in utils.printAllCurrentViews!");
		}
		Log.i("Robotium", "--- Start printing ---");
		Log.i("Robotium", "Activity = "
				+ solo.getCurrentActivity().getLocalClassName());
		for (int i = 0; i < view.size(); i++) {
			if (view.get(i).getId() != -1) {
				String resourceName = res.getResourceEntryName(view.get(i)
						.getId());
				if (((view.get(i) instanceof TextView) || (view.get(i) instanceof EditText))
						&& (view.get(i).isShown() == true)) {
					TextView textView = (TextView) view.get(i);
					String resource = view.get(i).getClass().toString();
					Log.i("Robotium", "Resource = " + resource
							+ " | ResourceName = " + resourceName
							+ " | text = " + textView.getText());
				} else {
					String resource = view.get(i).getClass().toString();
					Log.i("Robotium", "Resource = " + resource
							+ " | ResourceName = " + resourceName);
				}
			}
		}
		Log.i("Robotium", "--- End printing ---");
	}

	public void clickOnViewByName(String viewName) {
		solo.clickOnView(getViewByName(viewName));
	}

	public View getViewByName(String viewName) {
		ArrayList<View> view = solo.getCurrentViews();
		Resources res = solo.getCurrentActivity().getResources();
		for (int i = 0; i < view.size(); i++) {
			if (view.get(i).getId() != -1) {
				String name = res.getResourceEntryName(view.get(i).getId());
				if (name.equals(viewName)) {
					return (View) view.get(i);
				}
			}
		}
		String errorMessage = "!!! View by name: \"" + viewName
				+ "\" Not found.";
		printAllCurrentViews();
		assertTrue(errorMessage, false);
		return null; // Code will not reach here
	}

	public void checkText(String searchedText, int minimumNumberOfMatches,
			int timeout) {
		assertTrue("!!! Text: \"" + searchedText + "\" was not found in "
				+ timeout + "msec.",
				solo.waitForText(searchedText, minimumNumberOfMatches, timeout));
	}

	public void checkText(String searchedText) {
		checkText(searchedText, 1, MEDIUM_TIMEOUT);
	}

	public void clickOnText(String searchedText) {
		checkText(searchedText, 1, MEDIUM_TIMEOUT);
		solo.clickOnText(searchedText);
	}

}
