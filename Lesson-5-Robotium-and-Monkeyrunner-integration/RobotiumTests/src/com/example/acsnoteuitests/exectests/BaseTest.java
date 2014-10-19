package com.example.acsnoteuitests.exectests;

import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

public class BaseTest extends ActivityInstrumentationTestCase2 {

	public static final String TARGET_PACKAGE_ID = "com.pendasylla.client.android";
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.pendasylla.client.android.NPD_Home";
	private static Class launcherActivityClass;
	protected Solo solo;
	protected Context context;

	static {
		try {
			launcherActivityClass = Class
					.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public BaseTest() throws ClassNotFoundException {
		super(TARGET_PACKAGE_ID, launcherActivityClass);
	}

}
