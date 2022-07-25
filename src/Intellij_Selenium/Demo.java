package Intellij_Selenium;

import com.beust.jcommander.internal.Lists;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import java.util.List;

public class Demo {


    public static void main(String[] args) {

        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("./testng.xml");
        testng.setTestSuites(suites);
        testng.run();

    }
}
