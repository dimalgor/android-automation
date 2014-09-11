package com.example.acsnoteuitests.exectests;

import com.example.acsnoteuitests.testimpl.TestSuiteImpl_1_Menu;
import com.robotium.solo.Solo;

public class TestSuite_1_Menu extends BaseTest
{
    private TestSuiteImpl_1_Menu menu;

    public TestSuite_1_Menu() throws ClassNotFoundException
    {
        super();
    }

    @Override
    protected void setUp() throws Exception
    {
        solo = new Solo(getInstrumentation(), getActivity());
        context = this.getInstrumentation().getContext();
        menu = new TestSuiteImpl_1_Menu(solo, context);
    }

    @Override
    public void tearDown() throws Exception
    {
    	solo.finishOpenedActivities();
    }

    public void test_01_allNotesMenu()
    {
        menu.allNotesMenu();
    }
    
    public void test_02_categoryItems()
    {
        menu.categoryItems();
    }
    
    public void test_03_settings()
    {
        menu.settingsItems();
    }
    
    public void test_04_sortNotesMode()
    {
        menu.sortNotesMode();
    }
}
