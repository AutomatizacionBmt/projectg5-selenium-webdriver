package com.company.cucumber.stepdefs;

import com.company.base.BaseTest;
import com.company.pages.RedmineLandingPage;

public class BaseStepdefs {

    protected RedmineLandingPage currentPage;

    public BaseStepdefs(){
        currentPage = new RedmineLandingPage(BaseTest.getDriver());
    }
}
