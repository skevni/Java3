package ru.geekbrains.sklyarov.java3core.homework7;

public class ForTest {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before suite");
    }

    @Test(priority = 3)
    public void calcAnything() {
        System.out.println("calcAnything: priority=" + 3);

    }
    @Test(priority = 3)
    public void calcAnything2() {
        System.out.println("calcAnything2: priority=" + 3);
    }

    @Test(priority = 1)
    public void calcAnythingHighPriority() {
        System.out.println("calcAnythingHighPriority: priority=" + 1);
    }

    @Test(priority = 10)
    public void calcAnythingLowPriority() {
        System.out.println("calcAnythingLowPriority: priority=" + 10);
    }

//    @Test(priority = 11)
//    public void calcAnythingBug() {
//        System.out.println("calcAnythingBug: priority=" + 11);
//    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("After suite");
    }
}
