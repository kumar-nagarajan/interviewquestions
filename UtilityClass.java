package Panthers5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.channels.InterruptedByTimeoutException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.Base;

public class UtilityClass extends Base {

	protected static String currentPageTitle = "";
	protected static String pagetitle = "";
	String fluentWait = "60";
	String popupFluentWait = "30";
	String pagefluentwait = "150";
	public String operatingSystem = null;
	
	// in this class we write our reusable methods.
	// any methods we will use more than once we will store them here in
	// static methods.

	/**
	 * This method returns date and time as a string
	 * 
	 * @return
	 */
	public static String screenShotName() {

		Date date = new Date();
		String screenShot = date.toString().replace(":", "_").replace(" ", "_");
		return screenShot;

	}

	public static void takeScreenShot() {

		String location = System.getProperty("user.dir") + "\\output\\screenshots\\";
		String screenShotFileName = screenShotName() + ".png";

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(file, new File(location + screenShotFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception in execution");
		}

	}

	/**
	 * This method will select the value from static Dropdown by visible value
	 * 
	 * @param element
	 * @param text
	 */
	public static void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	/**
	 * This method will select value from static Dropdown by index
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method will select value from static dropdown by value
	 * 
	 * @param element
	 * @param value
	 */
	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);

	}

	/**
	 * This method accepts alerts
	 */
	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method will switch webdriver from parent window to child
	 */
	public static void switchToWindow() {

		Set<String> WindowsHandles = driver.getWindowHandles();
		Iterator<String> it = WindowsHandles.iterator();

		String window = it.next();
		driver.switchTo().window(window);

	}

	/**
	 * This method will clear the text using Keys.Control method
	 * 
	 * @param ele
	 */
	public static void clearTextUsingSendKeys(WebElement ele) {
		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(Keys.DELETE);

	}

	/*
	 * This method will clear the value from input text field
	 */
	public static void clearText(WebElement ele) {
		ele.clear();

	}

	/*
	 * This method will scrollPage down using JSExecutor interface
	 */
	public static void scrollPageDownWithJS() {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

	// click on element using JSExeutor

	public static void clickElementWithJS(WebDriver driver, WebElement element, String enterSuccessMessage, String failedErrorMessage) {
		String test = Thread.currentThread().getStackTrace()[2].getClassName();
		String ClassName = test.substring(test.lastIndexOf('.') + 1);
		int line = Thread.currentThread().getStackTrace()[2].getLineNumber();
		String testlog = ClassName + " " + line + " - ";
		String stars = testlog.replaceAll("(?s).", "*");
		WebElement web = null;
		boolean found = false;
		final long startTime = System.currentTimeMillis();
		logger.info("Taking screenshot ClickJs - Existing Function ");
		
			while((System.currentTimeMillis() - startTime) < 15000) {
			try {
				fluentWait(driver, element);
                highLightElement(driver, element);
		        JavascriptExecutor js = ((JavascriptExecutor) driver);
         		js.executeScript("arguments[0].click();", element);
         		found = true;
		        logger.info(enterSuccessMessage);
        }catch(NoSuchElementException e) {
        	catchURLHtmlCookies("ClickonElementFail");
        	logger.warn(failedErrorMessage + " : -->EXCEPTION2 : Application Error :- No Such Element Exception");
        	startPage("STACK TRACE START");
        	logger.warn(ExceptionUtils.getStackFrames(e));
        	endPage("STACK TRACE END");
        	logger.fatal(failedErrorMessage + " : --> EXCEPTION3: Application Error:= No Such Element Exception");
        	
           }catch(ElementNotVisibleException enve) {
        	   StringWriter sw = new StringWriter();
        	   PrintWriter pw = new PrintWriter(sw);
        	   enve.printStackTrace();
        	   logger.debug(sw.toString());
        	   
           	catchURLHtmlCookies("ClickonElementFail");
           	logger.warn(failedErrorMessage + " : -->EXCEPTION2 : Application Error :- No Such Element Exception");
           	startPage("STACK TRACE START");
           	logger.warn(ExceptionUtils.getStackFrames(e));
           	endPage("STACK TRACE END");
           	logger.fatal(failedErrorMessage + " : --> EXCEPTION3: Application Error:= No Such Element Exception");
        	   
           }catch(StaleElementReferenceException sere) {
        	   clickOnElement(driver, element, enterSuccessMessage, failedErrorMessage);
           }catch(TimeOutException toe) {
        	   StringWriter sw = new StringWriter();
        	   PrintWriter pw = new PrintWriter(sw);
        	   enve.printStackTrace();
        	   logger.debug(sw.toString());
        	   
           	catchURLHtmlCookies("ClickonElementFail");
           	logger.warn(failedErrorMessage + " : -->EXCEPTION2 : Application Error :- No Such Element Exception");
           	startPage("STACK TRACE START");
           	logger.warn(ExceptionUtils.getStackFrames(e));
           	endPage("STACK TRACE END");
           	logger.fatal(failedErrorMessage + " : --> Time out Exception Occured: Application Error:= No Such Element Exception");

           }
			}
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			String foundSuccess =" : : Element found after waiting for " + totalTime + " milliseconds .";
			if(found) {
				loggerInfoSwitch(stars);
				loggerInfoSwitch("*" + testlog + enterSuccessMessage + foundSuccess);
			}else {
				loggerInfoSwich("Failed to find element after " + totalTime + " milliseconds.");
			}
			loggerInfoSwitch(stars);
			return web;
			}


	}

	private static void endPage(String endPageName) {
		loggerDebugSwitch("STARTED : : :" + endPageName + " . . . .");
		
	}

	private static void startPage(String startPageName) {
		loggerDebugSwitch("STARTED : : :" + startPageName + " . . . .");
		
	}

	private static void loggerDebugSwitch(String message) {
		logger.debug(message);
		logger.debug(message);
	}

	private static void loggerInfoSwitch(String Message, String Status) {
		logger.debug(Message);

	}
	
	private void loggerInfoSwitch(String Message) {
		logger.debug(Message);

	}


	public  static void catchURLHtmlCookies(String string) {
		logger.warn("The page failed in this URL:" + driver.getCurrentUrl());
		printCookies();
		}

	private static void printCookies() {
		try {
			Set<Cookie> testCookie = driver.manage().getCookies();
			Iterator<Cookie> iter = testCookie.iterator();
			logger.trace("####### Start of Cookie Information ######");
			while (iter.hasNext()) {
				Cookie C = iter.next();
				logger.trace("Name:" + C.getName() + "=" + C.getValue() + "," + "Domain:" + C.getDomain());
			}
			logger.trace("###### End of Cookie Information #####");
		} catch (Exception e) {
			logger.debug(ExceptionUtils.getStackTrace(e));
		}
	}

	private static void throwError() {
		// TODO Auto-generated method stub

	}
	
	public void throwEnvironmentErrorByElement(WebDriver driver, WebElement element, int Seconds) throws FileNotFoundException{
		if(isElementPresent(driver, element, Seconds)) {
			String EnvironmentalErrorMsg = element.getText();
			FileNotFoundException myException = new FileNotFoundException("Environment Error :: " + EnvironmentalErrorMsg);
			startPage("STACK TRACE START");
			logger.warn(ExceptionUtils.getStackTrace(myException));
			endPage("STACK TRACE START");
			throw myException;
		}
		}

	private boolean isElementPresent(WebDriver driver, WebElement element, int seconds) {
		final long startTime = System.currentTimeMillis();
		long endTime = 0;
		long totalTime;
		try {
			logger.debug("Started fluent wait for element :" + element.toString());
			popfluentWait(driver, element, seconds);
			if (element.isDisplayed() && element.isEnabled()){
				endTime = System.currentTimeMillis();
				totalTime = endTime - startTime;
				logger.debug("Inside if - Total time taken for fluent wait" + totalTime + "Millis as"
						+ (totalTime / 1000) % 60 + "Seconds");
				return true;
			} else {
				endTime = System.currentTimeMillis();
				totalTime = endTime - startTime;
				logger.debug("Inside if - Total time taken for fluent wait" + totalTime + "Millis as"
						+ (totalTime / 1000) % 60 + "Seconds");
				return false;
			}
		} catch (Exception e) {
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			logger.debug("Inside if - Total time taken for fluent wait" + totalTime + "Millis as"
					+ (totalTime / 1000) % 60 + "Seconds");
		}
		return false;
	}

	// sendKeys using JSExecutor
	// we can use SendKeys with JSExecutor if WebElement has either one of ID, Name,
	// or Class attributes

	public static void sendKeysWithJS(String element, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('" + element + "').value='" + value + "'");

	}

	// how to select calendar date using JS Executor

	public static void selectCalendarDateWithJS(String date, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','" + date + "');", element);

	}

	/**
	 * This method will return text of element
	 * 
	 * @param ele
	 * @return
	 */
	public static String getText(WebElement ele) {
		String ElementText = ele.getText();
		return ElementText;
	}

	/**
	 * This method will drag and drop using Actions class
	 * 
	 * @param sourceElement
	 * @param targetElement
	 */
	public static void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceElement, targetElement);

	}

	public static boolean isElementDisplayed(WebElement element) {
		if (element.isDisplayed())
			return true;
		else
			return false;

	}

	public void getVerifyPageTitle(WebElement webelement, String PageTitle) {
		if (isElementPresent(webelement, 10)) {
			currentPageTitle = pagetitle;
			logger.info("Current Page: " + currentPageTitle);

		}
	}

	private boolean isElementPresent(WebElement element, int seconds) {
		try {
			popfluentWait(driver, element, seconds);
			if (element.isDisplayed() && element.isEnabled()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isElementPresent_New(WebDriver driver, WebElement element, int Seconds) throws IOException, InterruptedException {
		final long startTime = System.currentTimeMillis();
		long endTime = 0;
		long totalTime;
		
		popfluentWait(driver, element, Seconds);
		if(element.isDisplayed() && element.isEnabled()) {
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			logger.debug("Inside else - Total time taken for fluent wait " +totalTime +"Millis as" +(totalTime /1000) % 60 + "Seconds" + "This Element is present");
			return true;
		}else {
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			logger.debug("Inside else - Total time taken for fluent wait " +totalTime +"Millis as" +(totalTime /1000) % 60 + "Seconds" + "This Element is present");
			return false;
		}
		}
	
	public boolean isElementPresentMessage(WebDriver driver, WebElement element, int Seconds, String enterSuccessMessage, String failedErrorMessage) {
		final long startTime = System.currentTimeMillis();
		long endTime = 0;
		long totalTime;
		try {
		popfluentWait(driver, element, Seconds);
		if(element.isDisplayed() && element.isEnabled()) {
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			logger.debug("Inside else - Total time taken for fluent wait " +totalTime +"Millis as" +(totalTime /1000) % 60 + "Seconds" + "This Element is present");
			logger.pass(enterSuccessMessage + totalTime);
			return true;
		}else {
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			logger.debug("Inside else - Total time taken for fluent wait " +totalTime +"Millis as" +(totalTime /1000) % 60 + "Seconds" + "This Element is present");
			logger.fail(failedErrorMessage + totalTime);

			return false;
		}
		}catch(Exception e) {
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			logger.debug("Inside else - Total time taken for fluent wait " +totalTime +"Millis as" +(totalTime /1000) % 60 + "Seconds" + "This Element is present");
			logger.fail(failedErrorMessage + totalTime);
			return false;

		}
		}
	
	public abstract class DateFormat extends Format{
		
		protected Calendar calendar;
		
		protected NumberFormat numberFormat;
		
		
	}
	public SimpleDateFormat(String pattern) {
		this(pattern, Locale.getDefault(Locals.Category.FORMAT));
			}
	
	public SimpleDateFormat(String pattern, Locale locale) {
		{
			if(pattern == null || locale == null) {
				throw new NullPointerException();
			}
			initializeCalender(locale);
			this.pattern = pattern;
			this.formatData = DateFormatSymblos.getInstanceRef(locale);
			this.locale = locale;
			initialize(locale);
		}
	}
	
	public SimpleDateFormat(String pattern ,  DateFormatSmbols formatSymblos) {
		if(pattern == null || formatSymbols == null) {
			throw new NullPointerException();
		}
		this.pattern = pattern;
		this.formatData = (DateFormatSymbols)formatSymblos.clone();
		this.locale = Locale.getDefault(Locals.Category.FORMAT);
		initializeCalendar(this.Locale);
		initialize(this.locale);
		useDateFormatSymbols = true;

	}
	
	private void initialize(Locale loc) {
		compiledPattern = compile(Pattern);
		numberFormat = cachedNumberFormatData.get(loc);
		if(numberFormat == null) {
			numberFormat = NumberFormat.getIntegerInstance(loc);
			numberFormat.setGroupingUsed(false);
			cachedNumberFormatData.putIfAbsent(loc,numberFormat );
		}
		numberFormat = (NumberFormat)numberFormat.clone();
		initializeDefaultCentury();
	}

	private void initializeDefaultCentury() {
		// TODO Auto-generated method stub
		
	}

	private void initializeCalendar(Locale loc) {
		if(calender == null) {
			assert loc != null;
			calendar = Calendar.getInstance(TimeZone.getDefault(), loc);
		}
	}
	
	
	public String dateTime() {
		DateFormat dateFormat =  new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		loggerInfoSwitch("Currentdate and time is " + date1);
		return date1;


		
	public boolean isMobileElementPresent(WebDriver driver, WebElement element, int Seconds) throws IOException, InterruptedException {
		final long startTime = System.currentTimeMillis();
		long endTime = 0;
		long totalTime;
		try {
		popfluentWait(driver, element, Seconds);
		if(element.isDisplayed() && element.isEnabled()) {
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			logger.debug("Inside else - Total time taken for fluent wait " +totalTime +"Millis as" +(totalTime /1000) % 60 + "Seconds" + "This Element is present");
			return true;
		}else {
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			logger.debug("Inside else - Total time taken for fluent wait " +totalTime +"Millis as" +(totalTime /1000) % 60 + "Seconds" + "This Element is present");
			return false;
		}
		}catch(Exception e) {
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			logger.debug("Inside else - Total time taken for fluent wait " +totalTime +"Millis as" +(totalTime /1000) % 60 + "Seconds" + "This Element is present");
			return false;

		}
		}

	public void scrollTo(WebElement element) throws InterruptedException{
		
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		
		logger.debug("Scroll to is set for x : " + x + " And y" + y + "Moving y to -150");
		JavascriptExecutor jse = (JavascriptExecutor) this.driver;
		jse.executeScript("window.scrollTo(" + x + " , " + (y-150) + ")" , " ");
	}

	public void waitForFlexLoadIconToDisappearNSAWhatIf() throws InterruptedByTimeoutException, FileNotFoundException {
		long startTime = System.currentTimeMillis();
		try {
			logger.info("-------waitForFlexLoadIconToDisappear-------");
			if (isElementPresent("//img[@alt='loading/]", 5)) {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
				wait.withTimeout(Duration.ofSeconds(180)).pollingEvery(Duration.ofMillis(2))
						.ignoring(org.openqa.selenium.NoSuchElementException.class);
				wait.withMessage("APP Error: Waites 180 secs for load image to no longer be visible");
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='loading/]")));
				long endTime = System.currentTimeMillis();
				long totalTime = endTime - startTime;
				logger.debug(
						"Total secs taken for flex loading icon to disapper after visibility in ms : " + totalTime);
			} else {
				long endTime = System.currentTimeMillis();
				long totalTime = endTime - startTime;
				logger.debug("Waited but flex loading icon did not appear in ms " + totalTime);
			}
		} catch (Exception e) {
			logger.debug("Handling no such element exception");
			throw e;
		}

	}

	private boolean isElementPresent(String xpath, int seconds) {
		final long startTime = System.currentTimeMillis();
		long endTime = 0;
		long totalTime;
		try {
			popfluentWait(this.driver, xpath, seconds);
			if (this.driver.findElement(By.xpath(xpath)).isDisplayed()
					&& this.driver.findElement(By.xpath(xpath)).isEnabled()) {
				endTime = System.currentTimeMillis();
				totalTime = endTime - startTime;
				logger.debug("Inside if - Total time taken for fluent wait" + totalTime + "Millis as"
						+ (totalTime / 1000) % 60 + "Seconds");
				return true;
			} else {
				endTime = System.currentTimeMillis();
				totalTime = endTime - startTime;
				logger.debug("Inside if - Total time taken for fluent wait" + totalTime + "Millis as"
						+ (totalTime / 1000) % 60 + "Seconds");
				return false;
			}
		} catch (Exception e) {
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			logger.debug("Inside if - Total time taken for fluent wait" + totalTime + "Millis as"
					+ (totalTime / 1000) % 60 + "Seconds");
		}
		return false;
	}

	private void popfluentWait(WebDriver driver, String xpath, int seconds) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(seconds)).pollingEvery(Duration.ofMillis(250))
				.ignoring(NoSuchElementException.class).ignoring(ElementNotVisibleException.class)
				.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

	}
	
	public Integer fluentWait150() {
		return Integer.parseInt(this.pagefluentwait.trim());
	}
		

	public void popfluentWait(WebDriver driver, WebElement element, int seconds) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(seconds)).pollingEvery(Duration.ofMillis(250))
				.ignoring(NoSuchElementException.class).ignoring(ElementNotVisibleException.class)
				.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public WebElement clickOnElement(WebDriver driver, WebElement element, String enterSuccessMessage, String failedErrorMessage, String takeScreenshot)
	                    throws InterruptedException, FileNotFoundException{
		String test = Thread.currentThread().getStackTrace()[2].getClassName();
		String ClassName = test.substring(test.lastIndexOf('.') + 1);
		int line = Thread.currentThread().getStackTrace()[2].getLineNumber();
		String testlog = ClassName + " " + line + " - ";
		String stars = testlog.replaceAll("(?s).", "*");
		WebElement web = null;
		boolean found = false;
		final long startTime = System.currentTimeMillis();
		logger.debug("The value of screenshot:" + takeScreenshot);
		return web;
		
		if("Y".equalsIgnoreCase(takeScreenshot)) {
			logger.debug("New function with takescreenshot parameter");
			logger.info("Taking screenshot of the page, before clicking:");
		}
		while((System.currentTimeMillis() - startTime) < 15000) {
			try {
				fluentWait(driver, element);
                highLightElement(driver, element);
                      try {
                    	  JSClick(element, enterSuccessMessage, failedErrorMessage);
                      }catch(Exception e) {
                    	  e.printStackTrace();
	                  }
                      found = true;
                      logger.pass(enterSuccessMessage);
                      break;
			} catch(NoSuchElementException e1) {
				catchURLHtmlCookies("ClickonElementFail");
				logger.fatal(failedErrorMessage + " --> EXCEPTION2 : Application Error :- No such Element Exception");
				startPage("STACK TRACE START");
				logger.warn(ExceptionUtils.getStackTrace(e1));
				endPage("STACK TRACE END");
				logger.fatal(failedErrorMessage + ":--> EXCEPTION3: Application Error :- No such Element Exception ");
	           }catch(ElementNotVisibleException enve) {
	        	   StringWriter sw = new StringWriter();
	        	   PrintWriter pw = new PrintWriter(sw);
	        	   enve.printStackTrace(pw);
	        	   logger.debug(sw.toString());
	        	   
	           	catchURLHtmlCookies("ClickonElementFail");
	           	logger.warn(failedErrorMessage + " : -->EXCEPTION2 : Application Error :- No Such Element Exception");
	           	startPage("STACK TRACE START");
	           	logger.warn(ExceptionUtils.getStackFrames(e1));
	           	endPage("STACK TRACE END");
	           	logger.fatal(failedErrorMessage + " : --> EXCEPTION3: Application Error:= No Such Element Exception");
	        	   
	           }catch(StaleElementReferenceException sere) {
	        	   clickOnElement(driver, element, enterSuccessMessage, failedErrorMessage);
	           }catch(TimeOutException toe) {
	        	   StringWriter sw = new StringWriter();
	        	   PrintWriter pw = new PrintWriter(sw);
	        	   toe.printStackTrace();
	        	   logger.debug(sw.toString());
	        	   
	           	catchURLHtmlCookies("ClickonElementFail");
	           	logger.warn(failedErrorMessage + " : -->EXCEPTION2 : Application Error :- No Such Element Exception");
	           	startPage("STACK TRACE START");
	           	logger.warn(ExceptionUtils.getStackFrames(e));
	           	endPage("STACK TRACE END");
	           	logger.fatal(failedErrorMessage + " : --> Time out Exception Occured: Application Error:= No Such Element Exception");

	           }
				}
				long endTime = System.currentTimeMillis();
				long totalTime = endTime - startTime;
				String foundSuccess =" : : Element found after waiting for " + totalTime + " milliseconds .";
				if(found) {
					loggerInfoSwitch(stars);
					loggerInfoSwitch("*" + testlog + enterSuccessMessage + foundSuccess);
				}else {
					loggerInfoSwich("Failed to find element after " + totalTime + " milliseconds.");
				}
				loggerInfoSwitch(stars);
				return web;
				}


			private void clickOnElement(WebDriver driver, WebElement element, String enterSuccessMessage,String failedErrorMessage)
			      throws InterruptedException, FileNotFoundException{
				String test = Thread.currentThread().getStackTrace()[2].getClassName();
				String ClassName = test.substring(test.lastIndexOf('.') + 1);
				int line = Thread.currentThread().getStackTrace()[2].getLineNumber();
				String testlog = ClassName + " " + line + " - ";
				String stars = testlog.replaceAll("(?s).", "*");
				WebElement web = null;
				boolean found = false;
				final long startTime = System.currentTimeMillis();
				logger.info("Taking Screenshot of the page before clicking element:" ,true);
				while((System.currentTimeMillis() - startTime) < 15000) {
					try {
						fluentWait(driver, element);
		                highLightElement(driver, element);
		                      try {
		                    	  JSClick(element, SuccessMessage, failedErrorMessage);
		                      }catch(Exception e) {
		                    	  e.printStackTrace();
			                  }
		                      found = true;
		                      logger.pass(enterSuccessMessage);
		                      break;
					} catch(NoSuchElementException e1) {
						catchURLHtmlCookies("ClickonElementFail");
						logger.fatal(failedErrorMessage + " --> EXCEPTION2 : Application Error :- No such Element Exception");
						startPage("STACK TRACE START");
						logger.warn(ExceptionUtils.getStackTrace(e1));
						endPage("STACK TRACE END");
						logger.fatal(failedErrorMessage + ":--> EXCEPTION3: Application Error :- No such Element Exception ");
			           }catch(ElementNotVisibleException enve) {
			        	   StringWriter sw = new StringWriter();
			        	   PrintWriter pw = new PrintWriter(sw);
			        	   enve.printStackTrace(pw);
			        	   logger.debug(sw.toString());
			        	   
			           	catchURLHtmlCookies("ClickonElementFail");
			           	logger.warn(failedErrorMessage + " : -->EXCEPTION2 : Application Error :- No Such Element Exception");
			           	startPage("STACK TRACE START");
			           	logger.warn(ExceptionUtils.getStackFrames(enve));
			           	endPage("STACK TRACE END");
			           	logger.fatal(failedErrorMessage + " : --> EXCEPTION3: Application Error:= No Such Element Exception");
			        	   
			           }catch(StaleElementReferenceException sere) {
			        	   clickOnElement(driver, element, enterSuccessMessage, failedErrorMessage);
			           }catch(TimeOutException toe) {
			        	   
			        	   StringWriter sw = new StringWriter();
			        	   PrintWriter pw = new PrintWriter(sw);
			        	   toe.printStackTrace();
			        	   logger.debug(sw.toString());
			        	   
			           	catchURLHtmlCookies("ClickonElementFail");
			           	logger.warn(failedErrorMessage + " : -->EXCEPTION2 : Application Error :- No Such Element Exception");
			           	startPage("STACK TRACE START");
			           	logger.warn(ExceptionUtils.getStackFrames(toe));
			           	endPage("STACK TRACE END");
			           	logger.fatal(failedErrorMessage + " : --> Time out Exception Occured: Application Error:= No Such Element Exception");

			           }
						}
						long endTime = System.currentTimeMillis();
						long totalTime = endTime - startTime;
						String foundSuccess =" : : Element found after waiting for " + totalTime + " milliseconds .";
						if(found) {
							loggerInfoSwitch(stars);
							loggerInfoSwitch("*" + testlog + enterSuccessMessage + foundSuccess);
						}else {
							loggerInfoSwich("Failed to find element after " + totalTime + " milliseconds.");
						}
						loggerInfoSwitch(stars);
						return web;
						}

	private void JSClick(WebElement element, String SuccessMessage, String failedErrorMessage) {
			try {
				JavascriptExecutor executor = (JavascriptExecutor) this.driver;
				executor.executeScript("arguments[0].scrollIntoView(true);", element);
				highLightElement(this.driver, element);
				executor.executeScript("arguments[0].click();", element);
				logger.debug(SuccessMessage, true);
			}catch(Exception e) {
				logger.debug("SCRIPT ERROR :: Unable to JSClick in Element" +element);
				throwError("SCRIPT ERROR :: Unable to JSClick on Element" +element);
			}
	}

	private void throwError(String errorMsg) throws InterruptedException {
            InterruptedException e = new InterruptedException(errorMsg);
            loggerErrorSwitch(errorMsg);
            throw e;
	}

	private void loggerErrorSwitch(String Message) {
            logger.debug(Message);		
	}

	public void highLightElement(WebDriver driver, WebElement element) {
		fluentWait(driver, element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].setAttribute('style','border: solid 5px yellow')", element);
			staticWait(1);
			js.executeScript("arguments[0].setAttribute('style',border: solid 5px yellow')", element);
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}

	}

	private void staticWait(int Seconds) {
		// TODO Auto-generated method stub

	}

	private void fluentWait(WebDriver driver, WebElement element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(Integer.parseInt(fluentWait.trim()))).pollingEvery(Duration.ofMillis(250))
				.ignoring(NoSuchElementException.class).ignoring(ElementNotVisibleException.class)
				.ignoring(StaleElementReferenceException.class);
		wait.withMessage("APP Error :: Expected Element not found OR BlankPage");
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	public void setElement(WebElement element, String text) {
		int attempt = 0;
		while(attempt<10) {
			try {
				WebDriverWait wait = new WebDriverWait(this.driver, 30);
				wait.until(ExpectedConditions.visibilityOf(element));
				element.clear();
				element.sendKeys(text);
				element.sendKeys(Keys.TAB);
				loggerInfoSwitch("Entered text on" + element + ";" + text);
				break;
			}catch(StaleElementReferenceException e) {
				attempt ++;
		}
	}
}
	
	public void setENTERKey(WebElement element) {
		try {
			fluentwait(this.driver, element);
			element.sendKeys(Keys.RETURN);
		} catch(StaleElementReferenceException e) {
			setENTERKey(element);
		}
	}

	public void setTABKey(WebElement element) {
		try {
			fluentWait(this.driver, element);
			element.sendKeys(Keys.TAB);
		} catch(StaleElementReferenceException e) {
			setTABKey(element);
		}
	}
	
	public void selectList(WebElement webbySelect ,  String valueToSelect) {
		try {
			Select slt = new Select(webbySelect);
			slt.selectByValue(valueToSelect);
			logger.debug("Selected value from List " + webbySelect + "value as" +valueToSelect );
			staticSleeper(1);
		}catch(NoSuchElementException e) {
		
		}catch (Exception e) {
			Thread.currentThread().interrupt();
		
		}
	}
	
	public void setDropDownByValue(WebElement element, String value) {
		try {
			Select dropdown = new Select(reInitiateWebElement(element));
			dropdown.selectByVisibleText(value);
			logger.debug("Selected value from dropdown " + element.toString() + "value :" + value);
		}catch (StaleElementReferenceException e) {
			setDropDownByValue(element, value);
		}
	}
	private WebElement reInitiateWebElement(WebElement element) {
		boolean result = false;
		int attempts = 0;
		while(attempts < 10) {
			try {
				isElementPresent(element);
			}catch(StaleElementReferenceException e) {				
		}
		attempts++;
	}
		return element;
	}

	private void isElementPresent(WebElement element) {
		// TODO Auto-generated method stub
		
	}

	private void fluentwait(WebDriver driver, WebElement element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement fluentWaitClickableClear(WebDriver driver, WebElement element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(Integer.parseInt(this.fluentWait.trim()))).pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class)
				.ignoring(ElementNotVisibleException.class).ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public void waitForPageToBeLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
		@Override
		public Boolean apply(WebDriver driver) {
			return ((JavascriptExecutor)driver).executeScript("return document.readystate").toString().equals("complete");
		}
		};
		try {
			WebDriverWait wait =  new WebDriverWait(this.driver , 100);
			wait.until(expectation);
		}catch(Exception error) {
			logger.fatal("APP ERROR: Timeout waiting for Page Load Request to complete");
		}
																																																											}
	
	public WebElement setElementNoClear(WebDriver driver, WebElement element, String text, String enterSuccessMessage, String failedErrorMessage) 
							throws InterruptedException{
		String test = Thread.currentThread().getStackTrace()[2].getClassName();
		String ClassName = test.substring(test.lastIndexOf('.') + 1);
		int line = Thread.currentThread().getStackTrace()[2].getLineNumber();
		String testlog = ClassName + " " + line + " - ";
		String stars = testlog.replaceAll("(?s).", "*");
		WebElement web = null;
		boolean found = false;
		final long startTime = System.currentTimeMillis();
		logger.info("Taking screenshot ClickJs - Existing Function ");
		
			while((System.currentTimeMillis() - startTime) < 15000) {
			try {
				fluentWait(driver, element);
                highLightElement(driver, element);
                element.sendKeys(text);
                staticSleeper(4);
                try {
                	element.sendKeys(Keys.TAB);
                }catch(Exception e) {
                	logger.warn(ExceptionUtils.getStackTrace(e));
                }
                logger.pass(enterSuccessMessage);
                found=true;
                break;
                
	        }catch(NoSuchElementException e) {
	        	   StringWriter sw = new StringWriter();
	        	   PrintWriter pw = new PrintWriter(sw);
	        	   e.printStackTrace();
	        	   logger.debug(sw.toString());

	        	catchURLHtmlCookies("setElementFail");
	        	logger.warn(failedErrorMessage + " : -->EXCEPTION2 : Application Error :- No Such Element Exception");
	        	startPage("STACK TRACE START");
	        	logger.warn(ExceptionUtils.getStackFrames(e));
	        	endPage("STACK TRACE END");
	        	logger.fatal(failedErrorMessage + " : --> EXCEPTION3: Application Error:= No Such Element Exception");
	        	
	           }catch(ElementNotVisibleException enve) {
	        	   StringWriter sw = new StringWriter();
	        	   PrintWriter pw = new PrintWriter(sw);
	        	   enve.printStackTrace();
	        	   logger.debug(sw.toString());
	        	   
	           	catchURLHtmlCookies("setElementFail");
	           	logger.warn(failedErrorMessage + " : -->EXCEPTION2 : Application Error :- Element Not Visible Exception");
	           	startPage("STACK TRACE START");
	           	logger.warn(ExceptionUtils.getStackFrames(enve));
	           	endPage("STACK TRACE END");
	           	logger.fatal(failedErrorMessage + " : --> EXCEPTION3: Application Error:= Element not visible Exception");
	        	   
	           }catch(StaleElementReferenceException sere) {
	        	   	setElementNoClear(driver,element,text,enterSuccessMessage, failedErrorMessage);
	           }catch(TimeoutException toe) {
	        	   StringWriter sw = new StringWriter();
	        	   PrintWriter pw = new PrintWriter(sw);
	        	   toe.printStackTrace();
	        	   logger.debug(sw.toString());
	        	   
	           	catchURLHtmlCookies("setElementFail");
	           	logger.warn(failedErrorMessage + " : -->EXCEPTION2 : Application Error :- Time out Exception");
	           	startPage("STACK TRACE START");
	           	logger.warn(ExceptionUtils.getStackFrames(toe));
	           	endPage("STACK TRACE END");
	           	logger.fatal(failedErrorMessage + " : --> Time out Exception Occured: Application Error:= may be bcoz of xpath changes");

	           }
				}
				long endTime = System.currentTimeMillis();
				long totalTime = endTime - startTime;
				String foundSuccess =" : : Element found after waiting for " + totalTime + " milliseconds .";
				if(found) {
					loggerInfoSwitch(stars);
					loggerInfoSwitch("*" + testlog + enterSuccessMessage + foundSuccess);
				}else {
					loggerInfoSwitch("Failed to find element after " + totalTime + " milliseconds.");
				}
				loggerInfoSwitch(stars);
				return web;
				}

	private void staticSleeper(int seconds) {
		long startTime = System.currentTimeMillis();
		try {
			Thread.sleep(seconds * 1000);
			logger.debug("Static  time requested in Seconds : " + seconds);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			logger.debug("Static  time requested in Seconds : " + seconds);
		}catch(Exception e) {
			Thread.currentThread().interrupt();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace();
			logger.debug(sw.toString());
		}
	}
	
	public boolean isMobileFlow(Map<String, String> table) {
		boolean isMobileFlow = false;
		this.operatingSystem = System.getProperty("os.name");
		if(this.operatingSystem != null) {
			if(this.operatingSystem.toUpperCase().contains("MAC") && (!this.operatingSystem.toUpperCase().contains("WINDOWS"))) {
				isMobileFlow = true;
			}else if (System.getProperty("isMobileFlow") != null && System.getProperty("isMobileFlow").toUpperCase().contains("YES")) {
				isMobileFlow = true;
			}
		}
			return isMobileFlow;

	}
	
	public WebDriver getFriver() {
		return this.driver;
	}
	
	public boolean switchToNativeView() {
		logger.debug("Switching to Native View");
		boolean switchedtoNativeView = false;
		try {
			if(((IOSDriver<?>)this.driver).getContext().equalsIgnoreCase("NATIVE_APP")){
				logger.debug("Current Default Context is NATIVE_APP, hence not switching again");
				switchedtoNativeView = true;
			}else {
				try {
					logger.debug("The Current View is " + ((IOSDriver<?>)this.driver).getContext()+ ", hence switching to Native View");
					((IOSDriver<?>)this.driver).context("NATIVE_APP");
					switchedtoNativeView = true;
				}catch(Exception e){
					logger.debug("Couldn't Switch to Native View : + e.getMessage()");
					}
				return switchedtoNativeView;
			}
		}catch(Exception e) {
			try {
				logger.debug("Went into SwitchNative exception block so trying to switch to native again");
				((IOSDriver<?>)this.driver).context("NATIVE_APP");
				switchedtoNativeView = true;
			}catch(Exception e) {
				logger.debug("Couldn't Switch to Native View : + e.getMessage()");
				switchedtoNativeView = false;
			}
		}
		return switchedtoNativeView;
	}
	
	
	}
