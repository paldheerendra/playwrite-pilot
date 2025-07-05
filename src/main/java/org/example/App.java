package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class App {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            //Browser browser = playwright.chromium().launch(); //By default it's headless
            Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            //page.navigate("https://playwright.dev");
            page.navigate("https://google.com");
            System.out.println(page.title());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/screenshots/google_title.png")));
            browser.close();
            playwright.close();
        }
    }
}
