package com.acn.base;

import java.net.URL;

import com.acn.utils.JsonParser;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverManager {

	private static final ThreadLocal<AndroidDriver> driver = new ThreadLocal<AndroidDriver>();

	public static AndroidDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(AndroidDriver driver1) {
		driver.set(driver1);
	}

	public static void initializeDriver(String deviceID) throws Exception {

		AndroidDriver driver;

		JSONObject deviceObj = new JSONObject(JsonParser.parse("Devices.json").getJSONObject(deviceID).toString());

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, deviceObj.getString("platform_name"));
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, deviceObj.getString("platform_version"));
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceObj.getString("device_name"));
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, deviceObj.getString("automation_name"));
		cap.setCapability(MobileCapabilityType.UDID, deviceObj.getString("device_udid"));
		cap.setCapability(MobileCapabilityType.APP, deviceObj.getString("app_loc"));
		cap.setCapability("appActivity", "com.tollway.MainActivity");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(url, cap);

//		if (deviceObj.getString("platform_name") == "Android") {
//			driver = new AndroidDriver(url, cap);
//		} else {
//			driver = new AndroidDriver(url, cap);
//		}
		setDriver(driver);
	}
}
