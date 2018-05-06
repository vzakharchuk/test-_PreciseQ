package base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * test_PreciseQ
 * <p>
 * Created by Vadym on 05.05.18 in the package base.
 */
public class TestNGListenerImpl extends BaseTestClass implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test started!");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test passed!");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test failed!");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test skipped!");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {}

    @Override
    public void onStart(ITestContext iTestContext) {}

    @Override
    public void onFinish(ITestContext iTestContext) {}
}
