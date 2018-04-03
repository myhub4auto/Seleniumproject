package log;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import incarnushis.Admin;
import incarnushis.DriverConnection;

public class incarnus {

	static WebDriver driver = null;
	static WebDriverWait wait = null;
	static Actions action = null;

	public static void main(String[] args) throws Exception {
		DriverConnection.Initialise();
		driver = DriverConnection.getDriver();
		wait = DriverConnection.getWait();
		action = DriverConnection.getAction();
		Admin.login();
		// preRegistration(false);
		// preRegistration(true);
		// bulkregistration();
		// billing();
		// myprofile();
		// mrdstorage();
        //clinicaldatamaster();
        //orderconfiguration();
        billingconfiguration();
        appointment();

	}

	public static void bulkregistration() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bulkregistration")));
		driver.findElement(By.id("bulkregistration")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[ngf-select]")).sendKeys("C:\\Users\\incarnus10\\Downloads\\Patients (11).xlsx");

	}

	public static void preRegistration(Boolean SaveData) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("preregistration")));
		driver.findElement(By.id("preregistration")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registerFormselectedTitle")));
		driver.findElement(By.cssSelector("#registerFormselectedTitle input[type=\"search\"]")).sendKeys("m");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".md-autocomplete-suggestions-container")));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("md-virtual-repeat-container")));
		driver.findElement(By.cssSelector("#registerFormselectedTitle input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#registerFormselectedTitle input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("firstname")).sendKeys("obama");
		driver.findElement(By.id("middlename")).sendKeys("gowda");
		driver.findElement(By.id("lastname")).sendKeys("k");
		driver.findElement(By.id("newPatientisdobestimated")).click();
		driver.findElement(By.id("age")).sendKeys("28");

		driver.findElement(By.id("nationalid")).sendKeys("18775744646");
		action.moveToElement(driver.findElement(By.id("newPatientnatidexpirtydate")));
		action.click();
		action.sendKeys("18-12-2017");
		action.perform();

		driver.findElement(By.id("address")).sendKeys("23");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registerFormselectedArea")));
		driver.findElement(By.cssSelector("#registerFormselectedArea input[type=\"search\"]")).sendKeys("V");
		driver.findElement(By.cssSelector("#registerFormselectedArea input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#registerFormselectedArea input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("phone")).sendKeys("6568979");
		driver.findElement(By.id("mobile")).sendKeys("638512164");
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		if (SaveData) {
			driver.findElement(By.id("registerFormsaveData")).click();
		} else {
			driver.findElement(By.id("registerFormcancelData")).click();
		}

	}

	public static void billing() throws InterruptedException {
		Deposits(false);
		Thread.sleep(2000);
		Deposits(true);
		Thread.sleep(2000);
		driver.findElement(By.id("applicationhome")).click();
		System.out.println(6);
		cashierworklist();
		billhistory();
	}

	public static void Deposits(Boolean SaveData) throws InterruptedException {
		System.out.println("Inside Deposit");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deposit")));
		driver.findElement(By.id("deposit")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggleSearchAll")));
		driver.findElement(By.id("toggleSearchAll")).click();

		driver.findElement(By.id("depositsPatientWidget")).click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("depositsPatientWidgetMgsHasParamsSearchInput0")));
		driver.findElement(By.id("depositsPatientWidgetMgsHasParamsSearchInput0")).sendKeys("a");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("depositsPatientWidgetMgsGridOneRow0")));

		driver.findElement(By.id("depositsPatientWidgetMgsGridOneRow0")).click();
		driver.findElement(By.id("depositType")).click();
		driver.findElement(By.id("depositTypeOptions2")).click();
		driver.findElement(By.id("depositEncounter")).click();
		driver.findElement(By.id("depositEncounterOptions0")).click();
		driver.findElement(By.id("depositPayMod")).click();
		driver.findElement(By.id("depositPayMod1")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("depositpaidamount")));
		driver.findElement(By.id("depositpaidamount")).sendKeys(String.valueOf(25000));
		driver.findElement(By.id("depositCurrency")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("depositCurrencyOptions0")));
		driver.findElement(By.id("depositCurrencyOptions0")).click();
		driver.findElement(By.id("depositsDenominationWidgetDialogDisplay")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CQty0")));
		driver.findElement(By.id("CQty0")).sendKeys(String.valueOf(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CQty1")));
		driver.findElement(By.id("CQty1")).sendKeys(String.valueOf(10));
		driver.findElement(By.id("saveDenom")).click();
		driver.findElement(By.id("depositpaidby")).sendKeys("abdul");
		driver.findElement(By.id("depositcomments")).sendKeys("General");
		driver.findElement(By.id("depositinternalcomments")).sendKeys("money deposited succesfully");
		if (SaveData) {
			driver.findElement(By.id("saveDeposit")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("printreportclose")));
			driver.findElement(By.id("printreportclose")).click();
		} else {
			driver.findElement(By.id("cancelDepositsScreen")).click();
			driver.findElement(By.cssSelector("md-dialog-actions button:nth-child(2)")).click();
		}

	}

	public static void cashierworklist() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cashiorworklist")));
		driver.findElement(By.id("cashiorworklist")).click();

		medicaldischarge();
		bills();
		// deposits();
	}

	public static void medicaldischarge() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CWMDCdischargedVisits0")));
		driver.findElement(By.id("CWMDCdischargedVisits0")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CWMDCbillinginprogressLock")));
		driver.findElement(By.id("CWMDCbillinginprogressLock")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("CWMDCallocateBill")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("goToOrder")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ordersMdGridSelect")).click();
		driver.findElement(By.id("ordersMdGridSelectMgsNoParamsSearchInput")).sendKeys("Hematocrit");
		Thread.sleep(1000);
		driver.findElement(By.id("ordersMdGridSelectMgsGridOneRow0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("loginpassword")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.id("ordersMdGridSelectMgsNoParamsSearchInput")).sendKeys(Keys.ESCAPE);
		driver.findElement(By.id("orderDetailsTabSave")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("goToGenerateBill")));
		driver.findElement(By.id("goToGenerateBill")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("amount0")).sendKeys("560");
		driver.findElement(By.id("settleBill")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("printreportclose")));
		driver.findElement(By.id("printreportclose")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("goToCW")).click();

	}

	public static void bills() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("billsTabText")));
		driver.findElement(By.id("billsTabText")).click();
		driver.findElement(By.id("enablePatientBanner0")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("viewBill")));
		driver.findElement(By.id("viewBill")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("goToCW")));
		driver.findElement(By.id("goToCW")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("enablePatientBanner0")));
		driver.findElement(By.id("enablePatientBanner0")).click();
		driver.findElement(By.id("reprintBill")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("printreportclose")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("cancelBill")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("cancelBill0")).click();
		driver.findElement(By.id("cancelReasonUid")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("cancelReasonUidOptions1")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("checkAndCancelBills")).click();
		driver.findElement(By.id("enablePatientBanner0")).click();
		driver.findElement(By.id("reprintBill")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("printreportclose")));
		driver.findElement(By.id("printreportclose")).click();
		driver.findElement(By.id("viewBill")).click();
		driver.findElement(By.id("goToCW")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("enablePatientBanner0")));
		driver.findElement(By.id("enablePatientBanner0")).click();
		driver.findElement(By.id("goToBillHistory")).click();
		driver.findElement(By.id("reprintBill0")).click();
		driver.findElement(By.id("printreportclose")).click();
		driver.findElement(By.id("viewBill0")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("goToCW")));
		driver.findElement(By.id("goToCW")).click();

	}

	// public static void deposits() throws InterruptedException{
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("depositsTabText")));
	// driver.findElement(By.id("depositsTabText")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.id("applicationhome")).click();

	// }

	public static void billhistory() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("billhistory")));
		driver.findElement(By.id("billhistory")).click();
		// Thread.sleep(1000);
		// driver.findElement(By.id("toggleSearchAll")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("billHistoryPatientWidgetMgsSelector")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("billHistoryPatientWidgetMgsHasParamsSearchInput0")));
		driver.findElement(By.id("billHistoryPatientWidgetMgsHasParamsSearchInput0")).click();
		driver.findElement(By.id("billHistoryPatientWidgetMgsHasParamsSearchInput0")).sendKeys("a");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("billHistoryPatientWidgetMgsGridOneRow12")));
		driver.findElement(By.id("billHistoryPatientWidgetMgsGridOneRow12")).click();
		driver.findElement(By.id("billsTabSpan")).click();
		driver.findElement(By.id("reprintBill0")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("printreportclose")));
		driver.findElement(By.id("printreportclose")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("applicationhome")).click();

	}

	public static void myprofile() throws InterruptedException {
		changepassword(false);
		Thread.sleep(1000);
		driver.findElement(By.id("applicationhome")).click();
		changepassword(true);
		Thread.sleep(1000);
		driver.findElement(By.id("applicationhome")).click();
		lockpage();
	}

	public static void changepassword(Boolean Savedata) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("changepassword")));
		driver.findElement(By.id("changepassword")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("passwordcurrentpassword")).click();
		driver.findElement(By.id("passwordcurrentpassword")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.id("passwordnewpassword")).click();
		driver.findElement(By.id("passwordnewpassword")).sendKeys("admin#1");
		Thread.sleep(1000);
		driver.findElement(By.id("passwordconfirmpassword")).click();
		driver.findElement(By.id("passwordconfirmpassword")).sendKeys("admin#1");
		Thread.sleep(1000);
		if (Savedata) {
			driver.findElement(By.id("saveData")).click();
		} else {
			driver.findElement(By.id("cancelData")).click();
			driver.findElement(By.cssSelector("md-dialog-actions button:nth-child(2)")).click();
		}

	}

	public static void lockpage() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lockpage")));
		driver.findElement(By.id("lockpage")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("userpassword")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void mrdstorage() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mrdstorage")));
		driver.findElement(By.id("mrdstorage")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("mrdstoragecode")).click();
		driver.findElement(By.id("mrdstoragecode")).sendKeys("opchart1");
		Thread.sleep(2000);
		driver.findElement(By.id("mrdstoragename")).click();
		driver.findElement(By.id("mrdstoragename")).sendKeys("opchart1");
		Thread.sleep(2000);
		driver.findElement(By.id("mrdstorageincludeall")).click();
		driver.findElement(By.id("searchMrdstorage")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("clearMrdstorage")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("createMrdstorage")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("mrdStorageDetailisAutoGenerate")).click();
		driver.findElement(By.id("mrdStorageDetailcode")).click();
		driver.findElement(By.id("mrdStorageDetailcode")).sendKeys("opchart7");
		driver.findElement(By.id("mrdStorageDetailname")).click();
		driver.findElement(By.id("mrdStorageDetailname")).sendKeys("opchart7");
		driver.findElement(By.id("mrdStorageDetaildescription")).click();
		driver.findElement(By.id("mrdStorageDetaildescription")).sendKeys("opchart");
		action.moveToElement(driver.findElement(By.id("mrdStorageDetailactivetoid")));
		action.click();
		action.sendKeys("31-12-2016");
		action.perform();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectedlocation")));
		driver.findElement(By.cssSelector("#selectedlocation input[type=\"search\"]")).sendKeys("Main Building");
		driver.findElement(By.cssSelector("#selectedlocation input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#selectedlocation input[type=\"search\"]")).sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selecteddepartment")));
		driver.findElement(By.cssSelector("#selecteddepartment input[type=\"search\"]")).sendKeys("Orthopaedics");
		driver.findElement(By.cssSelector("#selecteddepartment input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#selecteddepartment input[type=\"search\"]")).sendKeys(Keys.RETURN);

		driver.findElement(By.id("selecteddepartment")).click();
		driver.findElement(By.id("selecteddepartment")).sendKeys("orthopaedics");
		driver.findElement(By.id("mrdStorageDetailactiverecordperiod")).click();
		driver.findElement(By.id("mrdStorageDetailactiverecordperiod")).sendKeys("35");
		driver.findElement(By.id("mrdStorageDetailarchiveperiod")).click();
		driver.findElement(By.id("mrdStorageDetailarchiveperiod")).sendKeys("45");
		Thread.sleep(3000);
		driver.findElement(By.id("ftdfiletypeuid")).click();
		driver.findElement(By.id("ftdfiletypeuid0")).click();
		driver.findElement(By.id("ftdduration")).click();
		driver.findElement(By.id("ftdduration")).sendKeys("25");
		Thread.sleep(3000);
		driver.findElement(By.id("deleteFileType")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("addFileType")).click();
		driver.findElement(By.id("saveData")).click();
	}

	public static void clinicaldatamaster() throws InterruptedException {
//		 cchpi();
//		 diagnosis();
//		 procedure();
//		 imagelibrary();
//		 formtemplate();
		 certtemplate();
		notetemplate();
	}

	public static void cchpi() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cchpi")));
		Thread.sleep(1000);
		driver.findElement(By.id("cchpi")).click();
		Thread.sleep(1000);
		cchpiMastersModify(false);
		Thread.sleep(1000);
		cchpimasters(false);
		cchpimasters(true);
		Thread.sleep(1000);
		driver.findElement(By.id("cchpisettab")).click();
		cchpigroupsmodify(false);
		Thread.sleep(1000);
		cchpigroups(false);
		cchpigroups(true);
		driver.findElement(By.id("applicationhome")).click();

	}

	public static void cchpiMastersModify(Boolean SaveData) throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.id("code")).sendKeys("cchpi26");
		driver.findElement(By.id("name")).sendKeys("atonic");
		driver.findElement(By.id("includeall")).click();
		driver.findElement(By.id("searchbtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("modifybtn0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("locallangdescdet")).clear();
		driver.findElement(By.id("locallangdescdet")).sendKeys("eng");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectedTemplate")));
		driver.findElement(By.cssSelector("#selectedTemplate input[type=\"search\"]")).click();
		driver.findElement(By.cssSelector("#selectedTemplate input[type=\"search\"]")).clear();
		driver.findElement(By.cssSelector("#selectedTemplate input[type=\"search\"]")).sendKeys("HIV FORM");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#selectedTemplate input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#selectedTemplate input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("savebtnd")).click();
		driver.findElement(By.id("code")).sendKeys("cchpi26");
		Thread.sleep(1000);
		driver.findElement(By.id("clearbtn")).click();
	}

	public static void cchpimasters(Boolean SaveData) throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.id("newbtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("namedet")).sendKeys("nausea");
		driver.findElement(By.id("descriptiondet")).sendKeys("nausea");
		driver.findElement(By.id("locallangdescdet")).sendKeys("eng");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectedTemplate")));
		driver.findElement(By.cssSelector("#selectedTemplate input[type=\"search\"]")).sendKeys("HIV FORM");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#selectedTemplate input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#selectedTemplate input[type=\"search\"]")).sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bodysites")));
		driver.findElement(By.cssSelector("#bodysites input[type=\"search\"]")).sendKeys("Right Eye");
		driver.findElement(By.cssSelector("#bodysites input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#bodysites input[type=\"search\"]")).sendKeys(Keys.RETURN);
		action.moveToElement(driver.findElement(By.id("activetodetid")));
		action.click();
		action.sendKeys("31-12-2017");
		action.perform();
		Thread.sleep(1000);
		if (SaveData) {
			driver.findElement(By.id("savebtnd")).click();
		} else {
			driver.findElement(By.id("cancelbtnd")).click();
		}
	}

	public static void cchpigroupsmodify(Boolean SaveData) throws InterruptedException {
		driver.findElement(By.id("codeset")).sendKeys("CCHPISET1");
		driver.findElement(By.id("nameset")).sendKeys("CCHPISET1");
		driver.findElement(By.id("includeallset")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("searchsetbtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modifysebtn0")));
		driver.findElement(By.id("modifysebtn0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("locallangdesc")).click();
		driver.findElement(By.id("locallangdesc")).clear();
		driver.findElement(By.id("locallangdesc")).sendKeys("eng");
		driver.findElement(By.id("savebtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("cchpisettab")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("codeset")).sendKeys("CCHPISET1");
		driver.findElement(By.id("nameset")).sendKeys("CCHPISET1");
		driver.findElement(By.id("includeallset")).click();
		driver.findElement(By.id("searchsetbtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("clearsetbtn")).click();
	}

	public static void cchpigroups(Boolean SaveData) throws InterruptedException {

		Thread.sleep(1000);
		if (!SaveData) {
			driver.findElement(By.id("cchpisettab")).click();
		}
		Thread.sleep(1000);
		driver.findElement(By.id("newsetbtn")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selecteddeptid")));
		driver.findElement(By.id("selecteddeptid")).click();
		driver.findElement(By.cssSelector("#selecteddeptid input[type=\"search\"]")).sendKeys("Orthopaedics");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#selecteddeptid input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#selecteddeptid input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("name")).sendKeys("cchpi2");
		driver.findElement(By.id("description")).sendKeys("cchpi2");
		driver.findElement(By.id("locallangdesc")).sendKeys("cchpi2");
		driver.findElement(By.id("bodysite")).click();
		driver.findElement(By.id("bodysite2")).click();
		action.moveToElement(driver.findElement(By.id("activetoid")));
		action.click();
		action.sendKeys("31-12-2017");
		action.perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectedCchpi")));
		driver.findElement(By.cssSelector("#selectedCchpi input[type=\"search\"]")).sendKeys("Abdominal tenderness");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#selectedCchpi input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#selectedCchpi input[type=\"search\"]")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);

		if (SaveData) {
			driver.findElement(By.id("savebtn")).click();
		} else {
			driver.findElement(By.id("cancelbtn")).click();
			driver.findElement(By.cssSelector("md-dialog-actions button:nth-child(2)")).click();

		}

		Thread.sleep(2000);

	}

	public static void diagnosis() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diagnosis")));
		Thread.sleep(1000);
		driver.findElement(By.id("diagnosis")).click();
		Thread.sleep(1000);
		diagnosisModify(false);
		Thread.sleep(1000);
		diagnosis(false);
		diagnosis(true);
		driver.findElement(By.id("problemsettab")).click();
		Diagnosisgroupmodify(false);
		Thread.sleep(1000);
		Diagnosisgroup(false);
		Diagnosisgroup(true);
		driver.findElement(By.id("medicaltab")).click();
		medicalhistorygroupsmodify(false);
		Thread.sleep(1000);
		medicalhistorygroups(false);
		medicalhistorygroups(true);
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void diagnosisModify(Boolean SaveData) throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.id("code")).sendKeys("M1309");
		driver.findElement(By.id("codingschm")).click();
		driver.findElement(By.id("codingschmopt0")).click();
		driver.findElement(By.id("includeall")).click();
		driver.findElement(By.id("searchbtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("modfybtn0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("namedet")).clear();
		driver.findElement(By.id("namedet")).sendKeys("Polyarthritis");
		Thread.sleep(1000);
		driver.findElement(By.id("savebtndet")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("clearbtn")).click();
	}

	public static void diagnosis(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("newbtn")).click();
		driver.findElement(By.id("namedet")).sendKeys("Polyarthritis");
		driver.findElement(By.id("descriptiondet")).sendKeys("polyarthritis");
		driver.findElement(By.id("locallangdescdet")).sendKeys("eng");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectedParPro")));
		driver.findElement(By.cssSelector("#selectedParPro input[type=\"search\"]"))
				.sendKeys("Abdominal and pelvic pain");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#selectedParPro input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#selectedParPro input[type=\"search\"]")).sendKeys(Keys.RETURN);
		if (SaveData) {
			driver.findElement(By.id("savebtndet")).click();
		} else {
			driver.findElement(By.id("cancelbtndet")).click();

		}

		Thread.sleep(1000);
	}

	// Diagnosis group
	public static void Diagnosisgroupmodify(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("codeset")).sendKeys("DIAG001");

		driver.findElement(By.id("nameset")).sendKeys("KIDNEY RELATED");
		driver.findElement(By.id("includeallset")).click();
		driver.findElement(By.id("searchsetbtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("modifysetbtn0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("locallangdescdet")).click();
		driver.findElement(By.id("locallangdescdet")).clear();
		driver.findElement(By.id("locallangdescdet")).sendKeys("eng");
		driver.findElement(By.id("savebtnde")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("clearsetbtn")).click();
	}

	public static void Diagnosisgroup(Boolean SaveData) throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.id("newsetbtn")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectedDept")));
		driver.findElement(By.cssSelector("#selectedDept input[type=\"search\"]")).sendKeys("Obstetrics & Gynaecology");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#selectedDept input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#selectedDept input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("namedet")).sendKeys("soriasis");
		driver.findElement(By.id("descriptiondet")).sendKeys("soria");
		driver.findElement(By.id("locallangdescdet")).sendKeys("eng");
		driver.findElement(By.id("activetodetid")).click();
		driver.findElement(By.id("activetodetid")).sendKeys("31-01-1991");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectedPro")));
		driver.findElement(By.cssSelector("#selectedPro input[type=\"search\"]"))
				.sendKeys("ABO incompatibility reaction");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#selectedPro input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#selectedPro input[type=\"search\"]")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectedPro")));
		driver.findElement(By.cssSelector("#selectedPro input[type=\"search\"]"))
				.sendKeys("Abdomen malignant neoplasm");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#selectedPro input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#selectedPro input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("removebtn1")).click();
		if (SaveData) {
			driver.findElement(By.id("savebtnde")).click();
		} else {
			driver.findElement(By.id("cancelbtnde")).click();

		}
		Thread.sleep(1000);
	}

	// medicalhistorygroups
	public static void medicalhistorygroupsmodify(Boolean SaveData) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("codehis")).sendKeys("HISTORYSET");
		Thread.sleep(1000);
		driver.findElement(By.id("namehis")).sendKeys("HISTORY SET");
		driver.findElement(By.id("includeallhis")).click();
		driver.findElement(By.id("searchhisbtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("modifyhisbtn0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("locallangdescdet")).click();
		driver.findElement(By.id("locallangdescdet")).clear();
		driver.findElement(By.id("locallangdescdet")).sendKeys("eng");
		driver.findElement(By.id("savebtndet")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("clearhisbtn")).click();
	}

	public static void medicalhistorygroups(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("newhisbtn")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectedDept")));
		driver.findElement(By.cssSelector("#selectedDept input[type=\"search\"]")).sendKeys("Obstetrics & Gynaecology");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#selectedDept input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#selectedDept input[type=\"search\"]")).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		driver.findElement(By.id("namedet")).click();
		driver.findElement(By.id("namedet")).sendKeys("hist");
		driver.findElement(By.id("descriptiondet")).sendKeys("hist");
		driver.findElement(By.id("locallangdescdet")).sendKeys("eng");
		driver.findElement(By.id("activetodetid")).sendKeys("10-12-2018");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectedProblem")));
		driver.findElement(By.cssSelector("#selectedProblem input[type=\"search\"]")).sendKeys("Abdominal actinomycosis");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#selectedProblem input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#selectedProblem input[type=\"search\"]")).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		if (SaveData) {
			driver.findElement(By.id("savebtndet")).click();
		} else {
			driver.findElement(By.id("cencelbtndet")).click();

		}

	}

	public static void procedure() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("procedure")));
		driver.findElement(By.id("procedure")).click();
		Thread.sleep(1000);
		proceduremodify(false);
		Thread.sleep(1000);
		procedure(false);
		procedure(true);
		Thread.sleep(1000);
		driver.findElement(By.id("prosettab")).click();
		Thread.sleep(1000);
		proceduregroupmodify(false);
		Thread.sleep(1000);
		proceduregroup(false);
		proceduregroup(true);
		Thread.sleep(1000);
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void proceduremodify(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("code")).sendKeys("112");
		driver.findElement(By.id("includeall")).click();
		driver.findElement(By.id("searchbtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("modfybtn0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("locallangdescde")).click();
		driver.findElement(By.id("locallangdescde")).clear();
		driver.findElement(By.id("locallangdescde")).sendKeys("Eng");
		driver.findElement(By.id("savebtnde")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("clearbtn")).click();
	}

	public static void procedure(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("newbtn")).click();
		driver.findElement(By.id("namede")).sendKeys("Biopsy of scalp");
		driver.findElement(By.id("descriptionde")).sendKeys("Biopsy of scalp");
		driver.findElement(By.id("locallangdescde")).sendKeys("eng");
		driver.findElement(By.id("activetodeid")).click();
		driver.findElement(By.id("activetodeid")).clear();
		action.moveToElement(driver.findElement(By.id("activetodeid")));
		action.click();
		action.sendKeys("31-12-2018");
		action.perform();
		Thread.sleep(1000);
		driver.findElement(By.id("planningtype")).click();
		driver.findElement(By.id("planningtypop0")).click();
		driver.findElement(By.id("criticality")).click();
		driver.findElement(By.id("criticalop0")).click();
		driver.findElement(By.id("anaesthesia")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("anaesthesia0")).click();
		driver.findElement(By.id("bodysite")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("bodysite1")).click();
		driver.findElement(By.id("laterality")).click();
		driver.findElement(By.id("laterality0")).click();
		driver.findElement(By.id("standardduration")).sendKeys("2");
		driver.findElement(By.id("templatetype0")).click();
		driver.findElement(By.id("templatetype01")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("template0")));
		driver.findElement(By.cssSelector("#template0 input[type=\"search\"]")).sendKeys("USG Check List");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#template0 input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#template0 input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("addtmpbtn")).click();
		driver.findElement(By.id("deletebtn1")).click();
		if (SaveData) {
			driver.findElement(By.id("savebtnde")).click();
		} else {
			driver.findElement(By.id("cancelbtnde")).click();

		}

		Thread.sleep(1000);
	}

	// Proceduregroup
	public static void proceduregroupmodify(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("codeset")).sendKeys("test");
		driver.findElement(By.id("nameset")).sendKeys("test");
		Thread.sleep(1000);
		driver.findElement(By.id("includeallset")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("searchbtnset")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("modifysetbtn0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("locallangdescde")).click();
		driver.findElement(By.id("locallangdescde")).clear();
		driver.findElement(By.id("locallangdescde")).sendKeys("eng");
		driver.findElement(By.id("savebtnde")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("codeset")).click();
		driver.findElement(By.id("codeset")).clear();
		driver.findElement(By.id("codeset")).sendKeys("test");
		driver.findElement(By.id("codeset")).click();
		driver.findElement(By.id("codeset")).clear();
		driver.findElement(By.id("nameset")).sendKeys("test");
		driver.findElement(By.id("includeallset")).click();
		driver.findElement(By.id("searchbtnset")).click();
		driver.findElement(By.id("clearbtnset")).click();
	}

	public static void proceduregroup(Boolean SaveData) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("newbtnset")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("department")));
		driver.findElement(By.cssSelector("#department input[type=\"search\"]")).click();
		driver.findElement(By.cssSelector("#department input[type=\"search\"]")).sendKeys("Orthopaedics");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#department input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#department input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("namede")).sendKeys("Incision on scalp");
		driver.findElement(By.id("descriptionde")).sendKeys("Incision on scalp");
		driver.findElement(By.id("locallangdescde")).sendKeys("eng");
		action.moveToElement(driver.findElement(By.id("activetodeid")));
		action.click();
		action.sendKeys("31-12-2018");
		action.perform();
		if (SaveData) {
			driver.findElement(By.id("savebtnde")).click();
		} else {
			driver.findElement(By.id("cancelbtnde")).click();

		}

	}

	public static void imagelibrary() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagelibrary")));
		driver.findElement(By.id("imagelibrary")).click();
		Thread.sleep(1000);
		imagelibrarymodify(false);
		Thread.sleep(1000);
		imagelibrary(false);
		imagelibrary(true);
		Thread.sleep(1000);
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void imagelibrarymodify(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("code")).sendKeys("WOUND1");
		driver.findElement(By.id("name")).sendKeys("Wound");
		driver.findElement(By.id("includeall")).click();
		driver.findElement(By.id("searchbtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("modfybtn0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("locallangdescdet")).click();
		driver.findElement(By.id("locallangdescdet")).clear();
		driver.findElement(By.id("locallangdescdet")).sendKeys("eng");
		driver.findElement(By.id("savebtnde")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("clearbtn")).click();
	}

	public static void imagelibrary(Boolean SaveData) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("newbtn")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectedDept")));
		driver.findElement(By.id("selectedDept")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#selectedDept input[type=\"search\"]")).sendKeys("Orthopaedics");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#selectedDept input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#selectedDept input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("namedet")).sendKeys("wound2");
		driver.findElement(By.id("descriptiondet")).sendKeys("wound2");
		driver.findElement(By.id("locallangdescdet")).sendKeys("eng");
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("activetode")));
		action.click();
		action.sendKeys("31-12-2017");
		action.perform();
		driver.findElement(By.cssSelector("input[ngf-select]")).sendKeys("C:\\Users\\incarnus10\\Desktop\\w2.jpg");
		if (SaveData) {
			driver.findElement(By.id("savebtnde")).click();
		} else {
			driver.findElement(By.id("cancelbtnde")).click();

		}

	}

	public static void formtemplate() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formtemplate")));
		driver.findElement(By.id("formtemplate")).click();
		Thread.sleep(1000);
		formtemplatemodify(false);
		Thread.sleep(1000);
		formtemplate(false);
		formtemplate(true);
		Thread.sleep(1000);
	}

	public static void formtemplatemodify(Boolean SaveDta) throws InterruptedException {

		driver.findElement(By.id("code")).sendKeys("FORM002");
		driver.findElement(By.id("name")).sendKeys("Headache Template");
		driver.findElement(By.id("includeall")).click();
		driver.findElement(By.id("searchbtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("modfybtn0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("activetoid")).click();
		driver.findElement(By.id("activetoid")).clear();
		action.moveToElement(driver.findElement(By.id("activetoid")));
		action.click();
		action.sendKeys("31-12-2017");
		action.perform();
		Thread.sleep(1000);
		driver.findElement(By.id("savebtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("code")).sendKeys("FORM002");
		driver.findElement(By.id("name")).sendKeys("Headache Template");
		driver.findElement(By.id("includeall")).click();
		driver.findElement(By.id("searchbtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("previewbtn0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("backbtn")).click();
		driver.findElement(By.id("code")).sendKeys("FORM002");
		driver.findElement(By.id("name")).sendKeys("Headache Template");
		driver.findElement(By.id("includeall")).click();
		driver.findElement(By.id("searchbtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("downbtn0")).click();
	}

	public static void formtemplate(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("newbtn")).click();
		driver.findElement(By.id("name")).sendKeys("headache");
		driver.findElement(By.id("description")).sendKeys("headache");
		driver.findElement(By.id("locallangdesc")).sendKeys("eng");
		driver.findElement(By.id("activetoid")).click();
		driver.findElement(By.id("activetoid")).clear();

		action.moveToElement(driver.findElement(By.id("activetoid")));
		action.click();
		action.sendKeys("31-12-2017");
		action.perform();
		driver.findElement(By.id("formtype")).click();
		driver.findElement(By.id("formtype0")).click();
		driver.findElement(By.id("formtitle")).sendKeys("Headache");
		driver.findElement(By.id("addsecbtn")).click();
		driver.findElement(By.id("secname1")).sendKeys("cchpi");
		Thread.sleep(2000);
		driver.findElement(By.id("addattr1")).sendKeys(Keys.ESCAPE);
		driver.findElement(By.id("addattr1")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("namedet")).sendKeys("Gen");
		driver.findElement(By.id("displaytext")).sendKeys("2");
		driver.findElement(By.id("locallangtext")).sendKeys("eng");
		driver.findElement(By.id("mandatory")).click();
		driver.findElement(By.id("widthper")).sendKeys("5");
		driver.findElement(By.id("defaultvalue")).sendKeys("1");
		driver.findElement(By.id("script")).sendKeys("gen");
		driver.findElement(By.id("savebtn")).click();
		driver.findElement(By.id("addsecbtn1")).click();
		driver.findElement(By.id("delbtn2")).click();
		driver.findElement(By.cssSelector("md-dialog-actions button:nth-child(2)")).click();
		driver.findElement(By.id("showfld1")).click();
		if (SaveData) {
			driver.findElement(By.id("savebtn")).click();
		} else {
			driver.findElement(By.id("cancelbtn")).click();

		}

	}

	public static void certtemplate() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("certtemplate")));
		driver.findElement(By.id("certtemplate")).click();
		Thread.sleep(1000);
		certtemplatemodify(false);
		Thread.sleep(1000);
		certtemplate(false);
		certtemplate(true);
		Thread.sleep(1000);
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void certtemplatemodify(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("CERTCode")).sendKeys("CERT1");
		driver.findElement(By.id("CERTName")).sendKeys("MED CERT STANDARD");
		driver.findElement(By.id("CERTIncInactive")).click();
		driver.findElement(By.id("CERTSearchBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("CERTModifyBtn0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("CERTCActivetoid")).click();
		driver.findElement(By.id("CERTCActivetoid")).clear();
		action.moveToElement(driver.findElement(By.id("CERTCActivetoid")));
		action.click();
		action.sendKeys("31-12-2017");
		action.perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CERTCRestrictDeptsAutoComp")));
		driver.findElement(By.cssSelector("#CERTCRestrictDeptsAutoComp input[type=\"search\"]"))
				.sendKeys("Orthopaedics");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#CERTCRestrictDeptsAutoComp input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#CERTCRestrictDeptsAutoComp input[type=\"search\"]")).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		driver.findElement(By.id("CERTCSaveBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("CERTCode")).sendKeys("CERT1");
		driver.findElement(By.id("CERTName")).sendKeys("MED CERT STANDARD");
		driver.findElement(By.id("CERTIncInactive")).click();
		driver.findElement(By.id("CERTSearchBtn")).click();
		driver.findElement(By.id("CERTClearBtn")).click();
	}

	public static void certtemplate(Boolean SaveData) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("CERTNewBtn")).click();
		driver.findElement(By.id("CERTCName")).sendKeys("medcert");
		driver.findElement(By.id("CERTCDescription")).sendKeys("medcert");
		driver.findElement(By.id("CERTCLocallang")).sendKeys("eng");
		action.moveToElement(driver.findElement(By.id("CERTCActiveto")));
		action.click();
		action.sendKeys("31-12-2017");
		action.perform();
		driver.findElement(By.id("CERTCPageType")).click();
		driver.findElement(By.id("CERTCPageTypeOption1")).click();
		driver.findElement(By.id("CERTCPageOrt")).click();
		driver.findElement(By.id("CERTCPageOrtOption0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("CERTCExpandBtn0")).click();
		driver.findElement(By.id("dataset01")).click();
		Thread.sleep(1000);
		
		if (SaveData) {
			driver.findElement(By.id("CERTCSaveBtn")).click();
		} else {
			driver.findElement(By.id("CERTCCancelBtn")).click();
			driver.findElement(By.cssSelector("md-dialog-actions button:nth-child(2)")).click();

		}

	}

	public static void notetemplate() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notetemplate")));
		driver.findElement(By.id("notetemplate")).click();
		Thread.sleep(1000);
		notetemplatemodify(false);
		Thread.sleep(1000);
		notetemplate(false);
		notetemplate(true);
		Thread.sleep(1000);
		 driver.findElement(By.id("applicationhome")).click();
	}

	public static void notetemplatemodify(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("code")).sendKeys("NOT001");
		driver.findElement(By.id("name")).sendKeys("General Exam 1");
		driver.findElement(By.id("includeall")).click();
		driver.findElement(By.id("searchbtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("modybtn0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("activetoid")).click();
		driver.findElement(By.id("activetoid")).clear();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.id("activetoid")));
		action.click();
		action.sendKeys("31-12-2017");
		action.perform();
		Thread.sleep(1000);
		driver.findElement(By.id("savebtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("code")).sendKeys("NOT001");
		driver.findElement(By.id("name")).sendKeys("General Exam 1");
		driver.findElement(By.id("includeall")).click();
		driver.findElement(By.id("searchbtn")).click();
		driver.findElement(By.id("clearbtn")).click();
	}

	public static void notetemplate(Boolean SaveData) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("newbtn")).click();
		driver.findElement(By.id("name")).sendKeys("General Exam 3");
		driver.findElement(By.id("description")).sendKeys("General Exam 3");
		driver.findElement(By.id("locallangdesc")).sendKeys("eng");
		action.moveToElement(driver.findElement(By.id("activetoid")));
		action.click();
		action.sendKeys("31-12-2017");
		action.perform();
		driver.findElement(By.id("notetype")).click();
		driver.findElement(By.id("notetypeop0")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelectorAll('#textangulartag > div > div')[2].innerHTML='Test asd'");
		
//		driver.findElement(By.cssSelector("#textangulartag")).click();
		driver.findElement(By.id("textangulartag")).click();

		 if (SaveData) {
			 driver.findElement(By.id("savebtn")).click();
		 }else{
			 driver.findElement(By.id("cancelbtn")).click();
			 driver.findElement(By.cssSelector("md-dialog-actions button:nth-child(2)")).click();
		 }
	}

	public static void orderconfiguration() throws InterruptedException {
		agemaster();
		frequencymaster();
		sigcode();
		ordercategory();
		orderitem();
		orderresultitem();
		orderset();
		orderroute();
	}

	public static void agemaster() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("agemaster")));
		Thread.sleep(1000);
		driver.findElement(By.id("agemaster")).click();
		Thread.sleep(1000);
		agemastermodify(false);
		Thread.sleep(1000);
		agemaster(false);
		agemaster(true);
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void agemastermodify(Boolean SaveData) throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.id("agemasterFormcode")).click();
		driver.findElement(By.id("agemasterFormcode")).sendKeys("adult");
		driver.findElement(By.id("agemasterFormname")).click();
		driver.findElement(By.id("agemasterFormname")).sendKeys("adult");
		driver.findElement(By.id("agemasterFormincludeall")).click();
		driver.findElement(By.id("agemasterFormSearch")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("agemasterFormModify0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("agemasterFormLanguageDesc")).click();
		driver.findElement(By.id("agemasterFormLanguageDesc")).clear();
		driver.findElement(By.id("agemasterFormLanguageDesc")).sendKeys("Thai");
		driver.findElement(By.id("agemasterFormSave")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("agemasterFormClear")).click();
		Thread.sleep(1000);
	}

	public static void agemaster(Boolean SaveData) throws InterruptedException {
		driver.findElement(By.id("agemasterFormNew")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("agemasterFormName")).sendKeys("adult");
		driver.findElement(By.id("agemasterFormLanguageDesc")).sendKeys("eng");
		driver.findElement(By.id("agemasterFormDescription")).sendKeys("adult");
		driver.findElement(By.id("agemasterFormFrom")).sendKeys("13");
		Thread.sleep(1000);
		driver.findElement(By.id("agemasterFormFromunit")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("agemasterFormFromunitOption0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("agemasterFormTo")).sendKeys("18");
		driver.findElement(By.id("agemasterFormTounit")).click();
		driver.findElement(By.id("agemasterFormTounitOption0")).click();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("agemasterFormActivetoid")));
		action.click();
		action.sendKeys("31-12-2016");
		action.perform();
		if (SaveData) {
			driver.findElement(By.id("agemasterFormSave")).click();
		} else {
			driver.findElement(By.id("agemasterFormCancel")).click();
		}
		Thread.sleep(1000);
	}

	public static void frequencymaster() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frequencymaster")));
		Thread.sleep(1000);
		driver.findElement(By.id("frequencymaster")).click();
		Thread.sleep(1000);
		frequencymastermodify(false);
		Thread.sleep(1000);
		frequencymaster(false);
		frequencymaster(true);
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void frequencymastermodify(Boolean SaveData) throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.id("frequenctMasterFormCode")).click();
		driver.findElement(By.id("frequenctMasterFormCode")).sendKeys("1-2 times daily");
		driver.findElement(By.id("frequenctMasterFormName")).click();
		driver.findElement(By.id("frequenctMasterFormName")).sendKeys("1-2 times daily");
		Thread.sleep(1000);
		driver.findElement(By.id("frequenctMasterFormSelectedfreqtype")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("select_option_19")).click();
		driver.findElement(By.id("frequenctMasterFormAll")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("frequenctMasterFormSearch")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("frequenctMasterFormModify0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("frequencymasteractivetoid")).clear();
		action.moveToElement(driver.findElement(By.id("frequencymasteractivetoid")));
		action.click();
		action.sendKeys("31-12-2018");
		action.perform();
		driver.findElement(By.id("saveData")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("frequenctMasterFormCode")).click();
		driver.findElement(By.id("frequenctMasterFormCode")).sendKeys("1-2 times daily");
		driver.findElement(By.id("frequenctMasterFormClear")).click();
	}

	public static void frequencymaster(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("frequenctMasterFormNew")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("frequencymastername")).click();
		driver.findElement(By.id("frequencymastername")).sendKeys("1-2 times daily");
		driver.findElement(By.id("frequencymasterdescription")).click();
		driver.findElement(By.id("frequencymasterdescription")).sendKeys("1-2 times daily");
		driver.findElement(By.id("frequencymasterlocallangdesc")).click();
		driver.findElement(By.id("frequencymasterlocallangdesc")).sendKeys("eng");
		driver.findElement(By.id("frequencymastertype")).click();
		driver.findElement(By.id("frequencymastertypeOptions0")).click();
		driver.findElement(By.id("frequencymasterallordercategories")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frequencymasterallowedordercategories")));
		driver.findElement(By.cssSelector("#frequencymasterallowedordercategories input[type=\"search\"]"))
				.sendKeys("Blood Bank");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#frequencymasterallowedordercategories input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#frequencymasterallowedordercategories input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		driver.findElement(By.id("timingvalue0")).click();
		driver.findElement(By.id("timingvalue0")).sendKeys("01:10PM");
		action.moveToElement(driver.findElement(By.id("frequencymasteractivetoid")));
		action.click();
		action.sendKeys("31-12-2018");
		action.perform();
		if (SaveData) {
			driver.findElement(By.id("saveData")).click();
		} else {
			driver.findElement(By.id("cancelData")).click();
		}

		Thread.sleep(1000);
	}

	public static void sigcode() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sigcode")));
		Thread.sleep(1000);
		driver.findElement(By.id("sigcode")).click();
		Thread.sleep(1000);
		sigcodemodify(false);
		Thread.sleep(1000);
		sigcode(false);
		Thread.sleep(1000);
		sigcode(true);
		Thread.sleep(1000);
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void sigcodemodify(Boolean SaveData) throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.id("sigcodeFormCode")).click();
		driver.findElement(By.id("sigcodeFormCode")).sendKeys("I or i");
		Thread.sleep(1000);
		driver.findElement(By.id("sigcodeFormName")).click();
		driver.findElement(By.id("sigcodeFormName")).sendKeys("1 (roman numeral)");
		driver.findElement(By.id("sigcodeFormAll")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("sigcodeFormSearch")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("sigcodeFormModify0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("sigcodelocallangdesc")).click();
		driver.findElement(By.id("sigcodelocallangdesc")).clear();
		driver.findElement(By.id("sigcodelocallangdesc")).sendKeys("eng");
		driver.findElement(By.id("saveData")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("sigcodeFormClear")).click();
	}

	public static void sigcode(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("sigcodeFormNew")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("sigcodename")).click();
		driver.findElement(By.id("sigcodename")).sendKeys("bid");
		driver.findElement(By.id("sigcodedescription")).sendKeys("bid");
		driver.findElement(By.id("sigcodelocallangdesc")).sendKeys("eng");
		Thread.sleep(2000);
		driver.findElement(By.id("sigcode.type")).click();
		driver.findElement(By.id("sigcodetypeOption2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectedReference")));
		driver.findElement(By.cssSelector("#selectedReference input[type=\"search\"]")).sendKeys("Vaginal");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#selectedReference input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#selectedReference input[type=\"search\"]")).sendKeys(Keys.RETURN);
		action.moveToElement(driver.findElement(By.id("sigcodeactivetoid")));
		action.click();
		action.sendKeys("31-12-2018");
		action.perform();
		if (SaveData) {
			driver.findElement(By.id("saveData")).click();
		} else {
			driver.findElement(By.id("cancelData")).click();
		}

	}

	public static void ordercategory() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ordercategory")));
		Thread.sleep(1000);
		driver.findElement(By.id("ordercategory")).click();
		Thread.sleep(1000);
		ordercategorymodify(false);
		Thread.sleep(1000);
		ordercategory(false);
		ordercategory(true);
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void ordercategorymodify(Boolean SaveData) throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.id("ordercategoryFormCode")).sendKeys("BB");
		driver.findElement(By.id("ordercategoryFormName")).sendKeys("bloodbank");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("categoryselectedparentcategory")));
		driver.findElement(By.cssSelector("#categoryselectedparentcategory input[type=\"search\"]"))
				.sendKeys("LABORATORY");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#categoryselectedparentcategory input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#categoryselectedparentcategory input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		driver.findElement(By.id("ordercategoryFormAll")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ordercategoryFormSearch")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ordercategoryFormModify0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ordercategorylocallangdesc")).click();
		driver.findElement(By.id("ordercategorylocallangdesc")).clear();
		driver.findElement(By.id("ordercategorylocallangdesc")).sendKeys("eng");
		driver.findElement(By.id("saveData")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ordercategoryFormCode")).sendKeys("BB");
		driver.findElement(By.id("ordercategoryFormName")).sendKeys("bloodbank");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("categoryselectedparentcategory")));
		driver.findElement(By.cssSelector("#categoryselectedparentcategory input[type=\"search\"]")).clear();
		driver.findElement(By.cssSelector("#categoryselectedparentcategory input[type=\"search\"]"))
				.sendKeys("LABORATORY");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#categoryselectedparentcategory input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#categoryselectedparentcategory input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		driver.findElement(By.id("ordercategoryFormClear")).click();
	}

	public static void ordercategory(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("ordercategoryFormNew")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ordercategoryname")).click();
		driver.findElement(By.id("ordercategoryname")).sendKeys("juice");
		driver.findElement(By.id("ordercategorylocallangdesc")).sendKeys("eng");
		driver.findElement(By.id("ordercategorydescription")).sendKeys("juice");
		Thread.sleep(1000);
		driver.findElement(By.id("ordercategoryordercattype")).click();
		driver.findElement(By.id("ordercategoryordercattypeOptions4")).click();
		driver.findElement(By.id("ordercategorybillingtype")).click();
		driver.findElement(By.id("ordercategorybillingtypeOption0")).click();
		driver.findElement(By.id("ordercategoryissubcategory")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectedparentCategory")));
		driver.findElement(By.cssSelector("#selectedparentCategory input[type=\"search\"]")).sendKeys("Diet");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#selectedparentCategory input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#selectedparentCategory input[type=\"search\"]")).sendKeys(Keys.RETURN);
		action.moveToElement(driver.findElement(By.id("ordercategoryactiveto")));
		action.click();
		action.sendKeys("31-12-2016");
		action.perform();
		if (SaveData) {
			driver.findElement(By.id("saveData")).click();
		} else {
			driver.findElement(By.id("cancelData")).click();
		}
		Thread.sleep(1000);
	}

	public static void orderitem() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderitem")));
		Thread.sleep(1000);
		driver.findElement(By.id("orderitem")).click();
		Thread.sleep(1000);
		orderitemmodify(false);
		Thread.sleep(1000);
		orderitem(false);
		orderitem(true);
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void orderitemmodify(Boolean SaveData) throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.id("orderitemFormCode")).sendKeys("10000010");
		driver.findElement(By.id("orderitemFormName")).sendKeys("Paraffin PT");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderitemFormSelectedOrderCategory")));
		driver.findElement(By.cssSelector("#orderitemFormSelectedOrderCategory input[type=\"search\"]"))
				.sendKeys("PHYSICAL THERAPY");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#orderitemFormSelectedOrderCategory input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#orderitemFormSelectedOrderCategory input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderitemFormSelectedOrderSubCategory")));
		driver.findElement(By.cssSelector("#orderitemFormSelectedOrderSubCategory input[type=\"search\"]"))
				.sendKeys("Rehab Services");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#orderitemFormSelectedOrderSubCategory input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#orderitemFormSelectedOrderSubCategory input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		driver.findElement(By.id("orderitemFormAll")).click();
		driver.findElement(By.id("orderitemFormSearch")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("orderitemFormModify0")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("orderitemFormActivetoid")).clear();
		driver.findElement(By.id("orderitemFormActivetoid")).sendKeys("10-01-2017");
		driver.findElement(By.id("orderitemFormSave")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("orderitemFormCode")).sendKeys("10000010");
		driver.findElement(By.id("orderitemFormName")).sendKeys("Paraffin PT");
		driver.findElement(By.id("orderitemFormClear")).click();
	}

	public static void orderitem(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("orderitemFormNew")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("orderitemFormName")).sendKeys("CT");
		driver.findElement(By.id("orderitemFormLocallangdesc")).sendKeys("eng");
		driver.findElement(By.id("orderitemFormDescription")).sendKeys("ct");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderitemFormSelectedOrderCategory")));
		driver.findElement(By.cssSelector("#orderitemFormSelectedOrderCategory input[type=\"search\"]"))
				.sendKeys("RADIOLOGY");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#orderitemFormSelectedOrderCategory input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#orderitemFormSelectedOrderCategory input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderitemFormSelectedOrderSubCategory")));
		driver.findElement(By.cssSelector("#orderitemFormSelectedOrderSubCategory input[type=\"search\"]"))
				.sendKeys("CT");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#orderitemFormSelectedOrderSubCategory input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#orderitemFormSelectedOrderSubCategory input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		driver.findElement(By.id("orderitemFormMinqty")).sendKeys("10");
		driver.findElement(By.id("orderitemFormMaxqty")).sendKeys("20");
		driver.findElement(By.id("orderitemFormDefaultpriorityuid")).click();
		driver.findElement(By.id("orderitemFormDefaultpriorityuidOption0")).click();
		driver.findElement(By.id("orderitemFormRestrictencounter")).click();
		driver.findElement(By.id("orderitemFormRestrictencounterOption0")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderitemFormRestrictfrequencies")));
		driver.findElement(By.cssSelector("#orderitemFormRestrictfrequencies input[type=\"search\"]"))
				.sendKeys("2-3 times daily");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#orderitemFormRestrictfrequencies input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#orderitemFormRestrictfrequencies input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		driver.findElement(By.id("orderitemFormRestrictgender")).click();
		driver.findElement(By.id("orderitemFormRestrictgenderOption1")).click();
		driver.findElement(By.id("orderitemFormRestrictagegroup"));
		driver.findElement(By.id("orderitemFormRestrictagegroupOption1"));
		action.moveToElement(driver.findElement(By.id("orderitemFormActivetoid")));
		action.click();
		action.sendKeys("31-12-2017");
		action.perform();
		driver.findElement(By.id("orderitemFormAdd")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderitemFormSelectedResultItem")));
		driver.findElement(By.cssSelector("#orderitemFormSelectedResultItem input[type=\"search\"]"))
				.sendKeys("Compatibility test");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#orderitemFormSelectedResultItem input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#orderitemFormSelectedResultItem input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		// driver.findElement(By.id("orderitemFormDisplayorder")).click();
		// driver.findElement(By.id("orderitemFormDisplayorder")).sendKeys("3");
		driver.findElement(By.id("orderitemFormAddressAdd0")).click();
		driver.findElement(By.id("orderitemFormRemove1")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderitemFormSelectedOtherOrder")));
		driver.findElement(By.cssSelector("#orderitemFormSelectedOtherOrder input[type=\"search\"]"))
				.sendKeys("Cold pack PT");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#orderitemFormSelectedOtherOrder input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#orderitemFormSelectedOtherOrder input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderitemFormSelectedCheckList")));
		driver.findElement(By.cssSelector("#orderitemFormSelectedCheckList input[type=\"search\"]"))
				.sendKeys("USG Check List");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#orderitemFormSelectedCheckList input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#orderitemFormSelectedCheckList input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		driver.findElement(By.id("orderitemFormItemAdd")).click();
		driver.findElement(By.id("orderitemFormInstructiontypeuid")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("orderitemFormInstructionOption0")).click();
		driver.findElement(By.id("orderitemFormInstructionuid")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("orderitemFormInstructionOption0")).click();
		driver.findElement(By.id("orderitemFormInstructiontext")).sendKeys("need infusionpump");
		driver.findElement(By.id("orderitemFormItemAdd")).click();
		driver.findElement(By.id("orderitemFormDelete1")).click();
		if (SaveData) {
			driver.findElement(By.id("orderitemFormSave")).click();
		} else {
			driver.findElement(By.id("orderitemFormCancel")).click();
			driver.findElement(By.cssSelector("md-dialog-actions button:nth-child(2)")).click();
		}

		Thread.sleep(1000);

	}

	public static void orderresultitem() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderresultitem")));
		Thread.sleep(1000);
		driver.findElement(By.id("orderresultitem")).click();
		Thread.sleep(1000);
		orderresultitemmodify(false);
		Thread.sleep(1000);
		orderresultitem(false);
		orderresultitem(true);
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void orderresultitemmodify(Boolean SaveData) throws InterruptedException {
		driver.findElement(By.id("orderresultitemFormCode")).sendKeys("6000001");
		driver.findElement(By.id("orderresultitemFormName")).sendKeys("EKG 12 Leads");
		driver.findElement(By.id("orderresultitemFormAll")).click();
		driver.findElement(By.id("orderresultitemFormSearch")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("orderresultitemFormModify0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("orderresultitemFormLocallangdesc")).click();
		driver.findElement(By.id("orderresultitemFormLocallangdesc")).clear();
		driver.findElement(By.id("orderresultitemFormLocallangdesc")).sendKeys("eng");
		driver.findElement(By.id("orderresultitemFormSave")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("orderresultitemFormClear")).click();
	}

	public static void orderresultitem(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("orderresultitemFormNew")).click();
		driver.findElement(By.id("orderresultitemFormName")).sendKeys("hamogloban");
		driver.findElement(By.id("orderresultitemFormDescription")).sendKeys("hamo");
		driver.findElement(By.id("orderresultitemFormLocallangdesc")).sendKeys("eng");
		driver.findElement(By.id("orderresultitemFormShorttext")).sendKeys("hameo");
		driver.findElement(By.id("orderresultitemFormResulttype")).click();
		driver.findElement(By.id("orderresultitemFormResulttypeOption3")).click();
		driver.findElement(By.id("orderresultitemFormuomuid")).click();
		driver.findElement(By.id("orderresultitemFormuomuidOption")).click();
		driver.findElement(By.id("orderresultitemFormPrecision")).sendKeys("5");
		driver.findElement(By.id("orderresultitemFormValueexpression")).sendKeys("60");
		driver.findElement(By.id("orderresultitemFormCharttype")).click();
		driver.findElement(By.id("orderresultitemFormCharttypeOption1")).click();
		driver.findElement(By.id("orderresultitemFormChartparameter")).click();
		driver.findElement(By.id("orderresultitemFormChartparameterOption1")).click();
		driver.findElement(By.id("orderresultitemFormDisplayorder")).sendKeys("6");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderresultitemFormSelectedAge")));
		driver.findElement(By.cssSelector("#orderresultitemFormSelectedAge input[type=\"search\"]"))
				.sendKeys("GERIATRIC");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#orderresultitemFormSelectedAge input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#orderresultitemFormSelectedAge input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		driver.findElement(By.id("orderresultitemFormGenderuid")).click();
		driver.findElement(By.id("orderresultitemForm")).click();
		driver.findElement(By.id("orderresultitemFormNormalrangestart")).sendKeys("5");
		driver.findElement(By.id("orderresultitemFormNormalrangeend")).sendKeys("10");
		driver.findElement(By.id("orderresultitemFormPanicrangestart")).sendKeys("4");
		driver.findElement(By.id("orderresultitemFormPanicrangeend")).sendKeys("11");
		driver.findElement(By.id("orderresultitemFormAdd")).click();
		driver.findElement(By.id("orderresultitemFormDelete")).click();
		// driver.findElement(By.id("orderresultitemFormActiveto")).click();
		action.moveToElement(driver.findElement(By.id("orderresultitemFormActiveto")));
		action.click();
		action.sendKeys("31-12-2017");
		action.perform();
		if (SaveData) {
			driver.findElement(By.id("orderresultitemFormSave")).click();
		} else {
			driver.findElement(By.id("orderresultitemFormCancel")).click();
			driver.findElement(By.cssSelector("md-dialog-actions button:nth-child(2)")).click();
		}
		Thread.sleep(1000);
	}

	public static void orderset() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderset")));
		Thread.sleep(1000);
		driver.findElement(By.id("orderset")).click();
		Thread.sleep(1000);
		ordersetmodify(false);
		Thread.sleep(1000);
		orderset(false);
		orderset(true);
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void ordersetmodify(Boolean SaveData) throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.id("ordersetFormCode")).sendKeys("002/1");
		driver.findElement(By.id("ordersetFormName")).sendKeys("panendoscope");
		driver.findElement(By.id("ordersetFormAll")).click();
		driver.findElement(By.id("ordersetFormSearch")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ordersetFormModify0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("orderitemFormLocallangdesc")).click();
		driver.findElement(By.id("orderitemFormLocallangdesc")).clear();
		driver.findElement(By.id("orderitemFormLocallangdesc")).sendKeys("eng");
		driver.findElement(By.id("orderitemFormSave")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ordersetFormCode")).sendKeys("002/1");
		driver.findElement(By.id("ordersetFormName")).sendKeys("panendoscope");
		driver.findElement(By.id("ordersetFormAll")).click();
		driver.findElement(By.id("ordersetFormSearch")).click();
		driver.findElement(By.id("ordersetFormClear")).click();
	}

	public static void orderset(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("ordersetFormNew")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("orderitemFormName")).sendKeys("pain");
		driver.findElement(By.id("orderitemFormLocallangdesc")).sendKeys("eng");
		driver.findElement(By.id("orderitemFormDescription")).sendKeys("pain");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderitemFormSelectedOrderCategory")));
		driver.findElement(By.cssSelector("#orderitemFormSelectedOrderCategory input[type=\"search\"]"))
				.sendKeys("MEDICATION");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#orderitemFormSelectedOrderCategory input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#orderitemFormSelectedOrderCategory input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderitemFormSelectedOrderSubCategory")));
		driver.findElement(By.cssSelector("#orderitemFormSelectedOrderSubCategory input[type=\"search\"]"))
				.sendKeys("Injections");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#orderitemFormSelectedOrderSubCategory input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#orderitemFormSelectedOrderSubCategory input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		driver.findElement(By.id("orderitemFormRestrictencounter")).click();
		driver.findElement(By.id("orderitemFormRestrictencounterOption0")).click();
		// driver.findElement(By.id("orderitemFormRestrictdepartments")).sendKeys("cardiology");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderitemFormRestrictdepartments")));
		driver.findElement(By.cssSelector("#orderitemFormRestrictdepartments input[type=\"search\"]"))
				.sendKeys("PAEDIATRICS");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#orderitemFormRestrictdepartments input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#orderitemFormRestrictdepartments input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		action.moveToElement(driver.findElement(By.id("orderitemFormActiveto")));
		action.click();
		action.sendKeys("31-12-2018");
		action.perform();
		driver.findElement(By.id("addorderitemdetail")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderinstructionFormSelectedOrderItem")));
		driver.findElement(By.cssSelector("#orderinstructionFormSelectedOrderItem input[type=\"search\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#orderinstructionFormSelectedOrderItem input[type=\"search\"]"))
				.sendKeys("Ultrasound PT");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#orderinstructionFormSelectedOrderItem input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#orderinstructionFormSelectedOrderItem input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		Thread.sleep(1000);

		action.moveToElement(driver.findElement(By.id("orderinstructionFormActivetoid")));
		action.click();
		action.sendKeys("31-12-2018");
		action.perform();
		Thread.sleep(1000);
		driver.findElement(By.id("orderinstructionFormSave")).click();
		Thread.sleep(1000);
		if (SaveData) {
			driver.findElement(By.id("orderitemFormSave")).click();
		} else {
			driver.findElement(By.id("orderitemFormCancel")).click();
			driver.findElement(By.cssSelector("md-dialog-actions button:nth-child(2)")).click();
		}

		Thread.sleep(1000);

	}

	public static void orderroute() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderroute")));
		Thread.sleep(1000);
		driver.findElement(By.id("orderroute")).click();
		Thread.sleep(1000);
		orderroutemodify(false);
		Thread.sleep(1000);
		orderroute(false);
		orderroute(true);
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void orderroutemodify(Boolean SaveData) throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.id("orderrouteFormCode")).sendKeys("GLOBAL");
		driver.findElement(By.id("orderrouteFormIsglobalsetting")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderrouteFormSelectedDepartment")));
		driver.findElement(By.cssSelector("#orderrouteFormSelectedDepartment input[type=\"search\"]"))
				.sendKeys("CLINICAL LAB");
		driver.findElement(By.cssSelector("#orderrouteFormSelectedDepartment input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#orderrouteFormSelectedDepartment input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		driver.findElement(By.id("orderrouteFormAll")).click();
		driver.findElement(By.id("orderrouteFormSearch")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("orderrouteFormModify0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("orderrouteFormActivetoid")).click();
		driver.findElement(By.id("orderrouteFormActivetoid")).clear();
		driver.findElement(By.id("orderrouteFormActivetoid")).sendKeys("10-01-2018");
		driver.findElement(By.id("orderrouteFormSave")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("orderrouteFormClear")).click();
		Thread.sleep(1000);
	}

	public static void orderroute(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("orderrouteFormNew")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("orderrouteFormIsglobalsetting")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderrouteFormSelectedDepartment")));
		driver.findElement(By.cssSelector("#orderrouteFormSelectedDepartment input[type=\"search\"]"))
				.sendKeys("CLINICAL LAB");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#orderrouteFormSelectedDepartment input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#orderrouteFormSelectedDepartment input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		action.moveToElement(driver.findElement(By.id("orderrouteFormActivetoid")));
		action.click();
		action.sendKeys("01-11-2017");
		action.perform();
		driver.findElement(By.id("orderrouteFormAdd")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("routemapFormSelectedOrderCategory")));
		driver.findElement(By.cssSelector("#routemapFormSelectedOrderCategory input[type=\"search\"]"))
				.sendKeys("LABORATORY");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#routemapFormSelectedOrderCategory input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#routemapFormSelectedOrderCategory input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("routemapFormSelectedOrderSubCategory")));
		driver.findElement(By.cssSelector("#routemapFormSelectedOrderSubCategory input[type=\"search\"]"))
				.sendKeys("Microbiology");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#routemapFormSelectedOrderSubCategory input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#routemapFormSelectedOrderSubCategory input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		driver.findElement(By.id("routemapFormPriorityuid")).click();
		driver.findElement(By.id("routemapFormPriorityuidOption0")).click();
		driver.findElement(By.id("routemapFormDow")).click();
		driver.findElement(By.id("routemapFormIsdefault")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("routemapFormSelectedDepartment")));
		driver.findElement(By.cssSelector("#routemapFormSelectedDepartment input[type=\"search\"]"))
				.sendKeys("CLINICAL LAB");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#routemapFormSelectedDepartment input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#routemapFormSelectedDepartment input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		action.moveToElement(driver.findElement(By.id("routemapFormActivetoid")));
		action.click();
		action.sendKeys("01-11-2017");
		action.perform();
		driver.findElement(By.id("routemapFormSave")).click();
		Thread.sleep(1000);
		if (SaveData) {
			driver.findElement(By.id("orderrouteFormSave")).click();
		} else {
			driver.findElement(By.id("orderrouteFormCancel")).click();
			driver.findElement(By.cssSelector("md-dialog-actions button:nth-child(2)")).click();
			Thread.sleep(1000);
		}

	}

	public static void billingconfiguration() throws InterruptedException {
//		 billinggroups();
//		 payors();
//		 payoragreement();
//		 TPA();
//		 Tariffmaster();
//		 Taxes();
		 billingparameters();
		 currencyexchangerate();
		autochargeorders();
	}

	public static void billinggroups() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("billinggroup")));
		Thread.sleep(1000);
		driver.findElement(By.id("billinggroup")).click();
		Thread.sleep(1000);
		billinggroupsmodify(false);
		Thread.sleep(1000);
		billinggroups(false);
		Thread.sleep(1000);
		billinggroups(true);
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void billinggroupsmodify(Boolean SaveData) throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.id("BGCode")).sendKeys("1");
		driver.findElement(By.id("BGName")).sendKeys("1.1.1 Drugs and Parenteral Nutrition");
		driver.findElement(By.id("BGInclInactive")).click();
		driver.findElement(By.id("BGSearch")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BGModifyBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BGDetailActiveToid")).click();
		driver.findElement(By.id("BGDetailActiveToid")).clear();
		action.moveToElement(driver.findElement(By.id("BGDetailActiveToid")));
		action.click();
		action.sendKeys("01-11-2017");
		action.perform();

		driver.findElement(By.id("BGDetailSaveBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BGCode")).sendKeys("1.1.1");
		driver.findElement(By.id("BGSearch")).click();
		driver.findElement(By.id("BGClear")).click();
	}

	public static void billinggroups(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("BGNew")).click();
		driver.findElement(By.id("BGDetailCode")).sendKeys("2");
		driver.findElement(By.id("BGDetailName")).sendKeys("1.1.11 Acupuncture");
		driver.findElement(By.id("BGDetailDesc")).sendKeys("1.1.11 Acupuncture");
		driver.findElement(By.id("BGDetailLocalLang")).sendKeys("eng");
		driver.findElement(By.id("BGDetailIsSub")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BGDetailParentGrp")));
		driver.findElement(By.cssSelector("#BGDetailParentGrp input[type=\"search\"]")).sendKeys("1.1.11 Acupuncture");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#BGDetailParentGrp input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#BGDetailParentGrp input[type=\"search\"]")).sendKeys(Keys.RETURN);
		if (SaveData) {
			driver.findElement(By.id("BGDetailSaveBtn")).click();
		} else {
			driver.findElement(By.id("BGDetailCancelBtn")).click();
			driver.findElement(By.cssSelector("md-dialog-actions button:nth-child(2)")).click();
			Thread.sleep(1000);
		}

	}

	public static void payors() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payors")));
		Thread.sleep(1000);
		driver.findElement(By.id("payors")).click();
		Thread.sleep(1000);
		payorsmodify(false);
		Thread.sleep(1000);
		payors(false);
		payors(true);
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void payorsmodify(Boolean SaveData) throws InterruptedException {
		driver.findElement(By.id("PYRCode")).sendKeys("1010107102");
		driver.findElement(By.id("PYRName")).sendKeys("april");
		driver.findElement(By.id("PYRInclInactive")).click();
		driver.findElement(By.id("PYRSearchBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("PYRModifyBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("PYRDetailName")).click();
		driver.findElement(By.id("PYRDetailName")).clear();
		driver.findElement(By.id("PYRDetailName")).sendKeys("april");
		driver.findElement(By.id("PYRDetailPyrType")).click();
		driver.findElement(By.id("PYRDetailPyrTypeOptions0")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PYRDetailArea")));
		driver.findElement(By.id("PYRDetailArea")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#PYRDetailArea input[type=\"search\"]")).clear();
		driver.findElement(By.cssSelector("#PYRDetailArea input[type=\"search\"]")).sendKeys("A Hi");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#PYRDetailArea input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#PYRDetailArea input[type=\"search\"]")).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		driver.findElement(By.id("PADetailSaveBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("PYRCode")).sendKeys("1010104101");
		driver.findElement(By.id("PYRInclInactive")).click();
		driver.findElement(By.id("PYRSearchBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("PYRClearBtn")).click();
	}

	public static void payors(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("PYRNewBtn")).click();
		driver.findElement(By.id("PYRDetailCode")).sendKeys("500");
		driver.findElement(By.id("PYRDetailName")).sendKeys("lifeinsurance");
		driver.findElement(By.id("PYRDetailDesc")).sendKeys("lifeinsurance");
		driver.findElement(By.id("PYRDetailContctPersn")).sendKeys("lifeinsurance");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PYRDetailBillTmplts")));
		driver.findElement(By.cssSelector("#PYRDetailBillTmplts input[type=\"search\"]")).sendKeys("Patient Detail Bill");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#PYRDetailBillTmplts input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#PYRDetailBillTmplts input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("PYRDetailAddress")).sendKeys("22");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PYRDetailArea")));
		driver.findElement(By.cssSelector("#PYRDetailArea input[type=\"search\"]")).sendKeys("Da To");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#PYRDetailArea input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#PYRDetailArea input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("PYRDetailWorkPhone")).sendKeys("65432");
		Thread.sleep(1000);
		driver.findElement(By.id("PYRDetailEmailPhone")).sendKeys("life@gmail.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PYRDetailAscTpa0")));
		driver.findElement(By.cssSelector("#PYRDetailAscTpa0 input[type=\"search\"]")).sendKeys("SELFPAY");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#PYRDetailAscTpa0 input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#PYRDetailAscTpa0 input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("PYRDetailAscTpaAddBtn0")).click();
		driver.findElement(By.id("PYRDetailAscTpaDelBtn1")).click();
		driver.findElement(By.id("PYRDetailAlertMsg0")).sendKeys("document needed");
		driver.findElement(By.id("PYRDetailAscTpaAddBtn0")).click();
		driver.findElement(By.id("PYRDetailAscTpaDelBtn1")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PYRDetailAscPayAgr0")));
		driver.findElement(By.cssSelector("#PYRDetailAscPayAgr0 input[type=\"search\"]"))
				.sendKeys("OPD 10% Discount Invoice");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#PYRDetailAscPayAgr0 input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#PYRDetailAscPayAgr0 input[type=\"search\"]")).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		driver.findElement(By.id("PYRDetailAscPayAgrAddBtn0")).click();
		driver.findElement(By.id("PYRDetailAscPayAgrDelBtn1")).click();
		driver.findElement(By.id("PADetailDocName0")).sendKeys("smith");
		driver.findElement(By.id("PADetailDocIsMand0")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PADetailDocClaimFrTemplate0")));
		driver.findElement(By.cssSelector("#PADetailDocClaimFrTemplate0 input[type=\"search\"]"))
				.sendKeys("OPD 10% Discount Invoice");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#PADetailDocClaimFrTemplate0 input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#PADetailDocClaimFrTemplate0 input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("PADetailDocAddBtn0")).click();
		driver.findElement(By.id("PADetailDocDelBtn1")).click();
		Thread.sleep(1000);
		if (SaveData) {
			driver.findElement(By.id("PADetailSaveBtn")).click();
		} else {
			driver.findElement(By.id("PADetailCancelBtn")).click();
			driver.findElement(By.cssSelector("md-dialog-actions button:nth-child(2)")).click();
			Thread.sleep(1000);
		}

	}

	private static void payoragreement() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payoragreement")));
		Thread.sleep(1000);
		driver.findElement(By.id("payoragreement")).click();
		Thread.sleep(1000);
		payoragreementmodify(false);
		Thread.sleep(1000);
		payoragreement(true);
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void payoragreementmodify(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("PACode")).sendKeys("OPD1");
		driver.findElement(By.id("PAName")).sendKeys("OPD Discount 10%");
		driver.findElement(By.id("PAInclInactive")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("PASearchBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("PAModifyBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("paBillType")).click();
		driver.findElement(By.id("paBillType0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("paEncounterType")).click();
		driver.findElement(By.id("paEncounterTypeOptions0")).click();
		driver.findElement(By.id("PADetailNextBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PADetailInclBGAutoComp0")));
		driver.findElement(By.id("PADetailInclBGAutoComp0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("inclusionLimitsMaxLim0")).clear();
		driver.findElement(By.id("inclusionLimitsMaxLim0")).sendKeys("3");
		driver.findElement(By.id("PADetailBGCopayAmt0")).clear();
		driver.findElement(By.id("PADetailBGCopayAmt0")).sendKeys("100");
		driver.findElement(By.id("PADetailBGCopayPerc0")).clear();
		driver.findElement(By.id("PADetailBGCopayPerc0")).sendKeys("10");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PADetailExclBGAutoComp")));
		driver.findElement(By.cssSelector("#PADetailExclBGAutoComp input[type=\"search\"]")).clear();
		driver.findElement(By.cssSelector("#PADetailExclBGAutoComp input[type=\"search\"]"))
				.sendKeys("1.1.11 Acupuncture");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#PADetailExclBGAutoComp input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#PADetailExclBGAutoComp input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("PADetailNextBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("groupdisctariff0")).click();
		driver.findElement(By.id("groupdisctariff0Options2")).click();
		driver.findElement(By.id("itemdisctariff0")).click();
		driver.findElement(By.id("itemdisctariffOptions1")).click();
		driver.findElement(By.id("PADetailNextBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("homegroup0")));
		driver.findElement(By.cssSelector("#homegroup0 input[type=\"search\"]")).click();
		driver.findElement(By.cssSelector("#homegroup0 input[type=\"search\"]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#homegroup0 input[type=\"search\"]")).sendKeys("1");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#homegroup0 input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#homegroup0 input[type=\"search\"]")).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		driver.findElement(By.id("homegroupDuration0")).clear();
		driver.findElement(By.id("homegroupDuration0")).sendKeys("2");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("homeitem0")));
		driver.findElement(By.cssSelector("#homeitem0 input[type=\"search\"]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#homeitem0 input[type=\"search\"]")).sendKeys("u");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#homeitem0 input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#homeitem0 input[type=\"search\"]")).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		driver.findElement(By.id("homeitemDuration0")).clear();
		driver.findElement(By.id("homeitemDuration0")).sendKeys("4");
		driver.findElement(By.id("PADetailNextBtn")).click();
		driver.findElement(By.cssSelector("input[ngf-select]")).sendKeys("C:\\Users\\incarnus10\\Desktop\\vijay.txt");
		driver.findElement(By.id("PADetailFinishBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("PACode")).sendKeys("OPD1");
		driver.findElement(By.id("PAName")).sendKeys("OPD Discount 10%");
		driver.findElement(By.id("PAInclInactive")).click();
		driver.findElement(By.id("PASearchBtn")).click();
		driver.findElement(By.id("PAClearBtn")).click();
	}

	public static void payoragreement(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("PANewBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("PADetailCode")).sendKeys("0001");
		driver.findElement(By.id("PADetailName")).sendKeys("bupay");
		driver.findElement(By.id("PADetailDesc")).sendKeys("bupay");
		driver.findElement(By.id("paBillType")).click();
		driver.findElement(By.id("paBillType1")).click();
		driver.findElement(By.id("PADetailNextBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PADetailInclBGAutoComp0")));
		driver.findElement(By.cssSelector("#PADetailInclBGAutoComp0 input[type=\"search\"]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#PADetailInclBGAutoComp0 input[type=\"search\"]")).sendKeys("1");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#PADetailInclBGAutoComp0 input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#PADetailInclBGAutoComp0 input[type=\"search\"]")).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		driver.findElement(By.id("inclusionLimitsMaxLim0")).sendKeys("5");
		driver.findElement(By.id("PADetailBGCopayAmt0")).sendKeys("100");
		driver.findElement(By.id("PADetailBGCopayPerc0")).sendKeys("10");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PADetailExclBGAutoComp")));
		driver.findElement(By.cssSelector("#PADetailExclBGAutoComp input[type=\"search\"]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#PADetailExclBGAutoComp input[type=\"search\"]")).sendKeys("1");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#PADetailExclBGAutoComp input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#PADetailExclBGAutoComp input[type=\"search\"]")).sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PADetailExclOrderItmAutoComp")));
		driver.findElement(By.cssSelector("#PADetailExclOrderItmAutoComp input[type=\"search\"]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#PADetailExclOrderItmAutoComp input[type=\"search\"]")).sendKeys("1");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#PADetailExclOrderItmAutoComp input[type=\"search\"]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#PADetailExclOrderItmAutoComp input[type=\"search\"]"))
				.sendKeys(Keys.RETURN);
		driver.findElement(By.id("PADetailNextBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("groupdisctariff0")).click();
		driver.findElement(By.id("groupdisctariff0Options1")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("groupdisc0")));
		driver.findElement(By.cssSelector("#groupdisc0 input[type=\"search\"]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#groupdisc0 input[type=\"search\"]")).sendKeys("1");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#groupdisc0 input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#groupdisc0 input[type=\"search\"]")).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		driver.findElement(By.id("groupDisAmount0")).sendKeys("100");
		driver.findElement(By.id("groupDisPercent0")).sendKeys("10");
		driver.findElement(By.id("itemdisctariff0")).click();
		driver.findElement(By.id("itemdisctariffOptions1")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("itemdisc0")));
		driver.findElement(By.cssSelector("#itemdisc0 input[type=\"search\"]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#itemdisc0 input[type=\"search\"]")).sendKeys("H");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#itemdisc0 input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#itemdisc0 input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("PADetailNextBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("homegroup0")));
		driver.findElement(By.cssSelector("#homegroup0 input[type=\"search\"]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#homegroup0 input[type=\"search\"]")).sendKeys("1");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#homegroup0 input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#homegroup0 input[type=\"search\"]")).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		driver.findElement(By.id("homegroupDuration0")).sendKeys("10");
		driver.findElement(By.id("PADetailHomeGrpMaxQty0")).sendKeys("25");
		driver.findElement(By.id("PADetailHomeGrpMaxPrc0")).sendKeys("25");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("homeitem0")));
		driver.findElement(By.cssSelector("#homeitem0 input[type=\"search\"]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#homeitem0 input[type=\"search\"]")).sendKeys("S");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#homeitem0 input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#homeitem0 input[type=\"search\"]")).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		driver.findElement(By.id("homeitemDuration0")).sendKeys("5");
		driver.findElement(By.id("PADetailHomeItmMaxQty0")).sendKeys("25");
		driver.findElement(By.id("PADetailHomeItmMaxPrc0")).sendKeys("25");
		driver.findElement(By.id("PADetailHomeItmAddBtn0")).click();
		driver.findElement(By.id("PADetailHomeItmDelBtn1")).click();
		driver.findElement(By.id("PADetailNextBtn")).click();
		driver.findElement(By.cssSelector("input[ngf-select]")).sendKeys("C:\\Users\\incarnus10\\Desktop\\vijay.txt");
		driver.findElement(By.id("paAlert0")).sendKeys("paydocuments");
		driver.findElement(By.id("PADetailClaimPerc")).sendKeys("7");
		driver.findElement(By.id("PADetailFinishBtn")).click();
		driver.findElement(By.id("applicationhome")).click();

	}

	public static void TPA() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tpa")));
		Thread.sleep(1000);
		driver.findElement(By.id("tpa")).click();
		Thread.sleep(1000);
		TPAmodify(false);
		Thread.sleep(1000);
		TPA(false);
		TPA(true);
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void TPAmodify(Boolean SaveData) throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.id("tpaCode")).sendKeys("I003");
		driver.findElement(By.id("tpaName")).sendKeys("SELFPAY");
		driver.findElement(By.id("tpaInclInactive")).click();
		driver.findElement(By.id("tpaSearchBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("tpaModifyBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tpaDetailArea")));
		driver.findElement(By.cssSelector("#tpaDetailArea input[type=\"search\"]")).click();
		driver.findElement(By.cssSelector("#tpaDetailArea input[type=\"search\"]")).clear();
		driver.findElement(By.cssSelector("#tpaDetailArea input[type=\"search\"]")).sendKeys("Sa");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#tpaDetailArea input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#tpaDetailArea input[type=\"search\"]")).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		driver.findElement(By.id("tpaDetailSaveBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("tpaName")).sendKeys("SELFPAY");
		driver.findElement(By.id("tpaInclInactive")).click();
		driver.findElement(By.id("tpaSearchBtn")).click();
		driver.findElement(By.id("tpaClearBtn")).click();
	}

	public static void TPA(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("tpaNewBtn")).click();
		driver.findElement(By.id("tpaDetailCode")).sendKeys("a01");
		driver.findElement(By.id("tpaDetailName")).sendKeys("SELFPAY");
		driver.findElement(By.id("tpaDetailDesc")).sendKeys("selfpay");
		driver.findElement(By.id("tpaDetailContctPersn")).sendKeys("adam");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tpaDetailArea")));
		driver.findElement(By.cssSelector("#tpaDetailArea input[type=\"search\"]")).sendKeys("A Sa");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#tpaDetailArea input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#tpaDetailArea input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("tpaDetailWorkPhone")).sendKeys("654789");
		driver.findElement(By.id("tpaDetailEmail")).sendKeys("S@gmail.com");
		if (SaveData) {
			driver.findElement(By.id("tpaDetailSaveBtn")).click();
		} else {
			driver.findElement(By.id("tpaDetailCancelBtn")).click();
			driver.findElement(By.cssSelector("md-dialog-actions button:nth-child(2)")).click();
			Thread.sleep(1000);
		}

	}

	public static void Tariffmaster() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tariff")));
		Thread.sleep(1000);
		driver.findElement(By.id("tariff")).click();
		Thread.sleep(1000);
		Tariffmastermodify(false);
		Thread.sleep(1000);
		Tariffmaster(false);
		Tariffmaster(true);
		Thread.sleep(1000);
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void Tariffmastermodify(Boolean SaveeData) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tariffBillingGroup")));
		driver.findElement(By.cssSelector("#tariffBillingGroup input[type=\"search\"]")).click();
		driver.findElement(By.cssSelector("#tariffBillingGroup input[type=\"search\"]")).sendKeys("1");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#tariffBillingGroup input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#tariffBillingGroup input[type=\"search\"]")).sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tariffBillingSubGroup")));
		driver.findElement(By.cssSelector("#tariffBillingSubGroup input[type=\"search\"]")).sendKeys("1");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#tariffBillingSubGroup input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#tariffBillingSubGroup input[type=\"search\"]")).sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tariffOrderItem")));
		driver.findElement(By.cssSelector("#tariffOrderItem input[type=\"search\"]")).sendKeys("v");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#tariffOrderItem input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#tariffOrderItem input[type=\"search\"]")).sendKeys(Keys.RETURN);
		// driver.findElement(By.id("tariffSearchByOrderSet")).click();
		driver.findElement(By.id("tariffInclInactive")).click();
		driver.findElement(By.id("tariffSearchBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("tariffModifyBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("tariffCurrency")).click();
		driver.findElement(By.id("tariffCurrency2")).click();
		driver.findElement(By.id("tariffSaveBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("tariffClearBtn")).click();
	}

	public static void Tariffmaster(Boolean SaveData) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("tariffNewBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("tariffItemType")).click();
		driver.findElement(By.id("tariffItemTypeOptions0")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tariffOrderItem")));
		driver.findElement(By.cssSelector("#tariffOrderItem input[type=\"search\"]")).click();
		driver.findElement(By.cssSelector("#tariffOrderItem input[type=\"search\"]")).sendKeys("v");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#tariffOrderItem input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#tariffOrderItem input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("tariffChargeCode")).sendKeys("1111");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tariffBillingGroup")));
		driver.findElement(By.cssSelector("#tariffBillingGroup input[type=\"search\"]")).sendKeys("1");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#tariffBillingGroup input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#tariffBillingGroup input[type=\"search\"]")).sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tariffBillingSubGroup")));
		driver.findElement(By.cssSelector("#tariffBillingSubGroup input[type=\"search\"]")).sendKeys("1");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#tariffBillingSubGroup input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#tariffBillingSubGroup input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("tariffUnitPrice")).sendKeys("10");
		driver.findElement(By.id("tariffMinPrice")).sendKeys("5");
		driver.findElement(By.id("tariffMaxPrice")).sendKeys("15");
		driver.findElement(By.id("tariffCostPrice")).sendKeys("15");
		driver.findElement(By.id("tariffCurrency")).click();
		driver.findElement(By.id("tariffCurrency2")).click();
		action.moveToElement(driver.findElement(By.id("tariffActiveToid")));
		action.click();
		action.sendKeys("01-11-2018");
		action.perform();
		Thread.sleep(1000);
		if (SaveData) {
			driver.findElement(By.id("tariffSaveBtn")).click();
		} else {
			driver.findElement(By.id("tariffCancelBtn")).click();
			driver.findElement(By.cssSelector("md-dialog-actions button:nth-child(2)")).click();
			Thread.sleep(1000);
		}

	}

	public static void Taxes() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taxes")));
		Thread.sleep(1000);
		driver.findElement(By.id("taxes")).click();
		Thread.sleep(1000);
		Taxesmodify(false);
		Thread.sleep(1000);
		Taxes(false);
		Taxes(true);
		driver.findElement(By.id("taxRulesTab")).click();
		Thread.sleep(1000);
		Taxrulesmodify(false);
		Thread.sleep(1000);
		Taxrules(false);
		Taxrules(true);
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void Taxesmodify(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("taxCode")).sendKeys("SR");
		driver.findElement(By.id("taxName")).sendKeys("Standard Rate Input");
		driver.findElement(By.id("taxInclInactive")).click();
		driver.findElement(By.id("taxSearchBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("taxModifyBtn")).click();
		driver.findElement(By.id("taxDetailTaxType")).click();
		driver.findElement(By.id("taxDetailTaxTypeOptions0")).click();
		driver.findElement(By.id("taxDetailTaxBeforDisc")).click();
		driver.findElement(By.id("taxDetailSaveBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("taxCode")).sendKeys("SR");
		driver.findElement(By.id("taxName")).sendKeys("Standard Rate Input");
		driver.findElement(By.id("taxInclInactive")).click();
		driver.findElement(By.id("taxSearchBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("taxClearBtn")).click();
	}

	public static void Taxes(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("taxNewBtn")).click();
		driver.findElement(By.id("taxDetailCode")).sendKeys("187");
		driver.findElement(By.id("taxDetailName")).sendKeys("zerorate");
		driver.findElement(By.id("taxDetailDesc")).sendKeys("zerorate");
		driver.findElement(By.id("taxDetailTaxPerc")).sendKeys("8");
		if (SaveData) {
			driver.findElement(By.id("taxDetailSaveBtn")).click();
		} else {
			driver.findElement(By.id("taxDetailCancelBtn")).click();
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
	}

	public static void Taxrulesmodify(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("taxRulCode")).sendKeys("OPDRULE1");
		driver.findElement(By.id("taxRulName")).sendKeys("OPD Rule 1");
		driver.findElement(By.id("taxRulInclInactive")).click();
		driver.findElement(By.id("taxRulSearchBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("taxRulModifyBtn")).click();
		driver.findElement(By.id("taxRulDetailSaveBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("taxRulClearBtn")).click();
	}

	public static void Taxrules(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("taxRulNewBtn")).click();
		driver.findElement(By.id("taxRulDetailCode")).sendKeys("193");
		driver.findElement(By.id("taxRulDetailName")).sendKeys("opd1");
		driver.findElement(By.id("taxRulDetailDesc")).sendKeys("opd1");
		driver.findElement(By.id("taxRulDetailVstType")).click();
		driver.findElement(By.id("taxRulDetailVstTypeOptions2")).click();
		driver.findElement(By.id("taxRulDetailActiveTo")).click();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.id("taxRulDetailActiveTo")));
		action.click();
		action.sendKeys("01-11-2017");
		action.perform();
		Thread.sleep(2000);
		driver.findElement(By.id("billinggroupsSpan")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taxRulDetailBg0")));
		driver.findElement(By.cssSelector("#taxRulDetailBg0 input[type=\"search\"]")).sendKeys("1");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#taxRulDetailBg0 input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#taxRulDetailBg0 input[type=\"search\"]")).sendKeys(Keys.RETURN);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taxRulDetailBgTax0")));
		driver.findElement(By.cssSelector("#taxRulDetailBgTax0 input[type=\"search\"]")).sendKeys("s");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#taxRulDetailBgTax0 input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#taxRulDetailBgTax0 input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("billingsubgroupsSpan")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taxRulDetailBsg0")));
		driver.findElement(By.cssSelector("#taxRulDetailBsg0 input[type=\"search\"]")).sendKeys("1");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#taxRulDetailBsg0 input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#taxRulDetailBsg0 input[type=\"search\"]")).sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taxRulDetailBsgTax0")));
		driver.findElement(By.cssSelector("#taxRulDetailBsgTax0 input[type=\"search\"]")).sendKeys("s");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#taxRulDetailBsgTax0 input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#taxRulDetailBsgTax0 input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("orderitemsSpan")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taxRulDetailOrdItm0")));
		driver.findElement(By.cssSelector("#taxRulDetailOrdItm0 input[type=\"search\"]")).sendKeys("1");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#taxRulDetailOrdItm0 input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#taxRulDetailOrdItm0 input[type=\"search\"]")).sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taxRulDetailOrdItmTax0")));
		driver.findElement(By.cssSelector("#taxRulDetailOrdItmTax0 input[type=\"search\"]")).sendKeys("s");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#taxRulDetailOrdItmTax0 input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#taxRulDetailOrdItmTax0 input[type=\"search\"]")).sendKeys(Keys.RETURN);
		if (SaveData) {
			driver.findElement(By.id("taxRulDetailSaveBtn")).click();
		} else {
			driver.findElement(By.id("taxRulDetailCancelBtn")).click();
			Thread.sleep(1000);
		}

	}

	public static void billingparameters() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("billingparams")));
		driver.findElement(By.id("billingparams")).click();
		Thread.sleep(1000);
		billingparametersmodify(false);
		driver.findElement(By.id("billingparams")).click();
		billingparametersmodify(true);
	}

	public static void billingparametersmodify(Boolean SaveData) throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.id("paramCurrency")).click();
		System.out.println("1");
		driver.findElement(By.id("paramCurrencyOptions2")).click();
		System.out.println("2");
		driver.findElement(By.id("paramPaymod")).click();
		System.out.println("3");
		driver.findElement(By.id("paramPaymod2")).click();
		System.out.println("4");
		Thread.sleep(1000);
		driver.findElement(By.id("roundOffAt")).click();
		System.out.println("6");
		driver.findElement(By.id("roundOffAtOptions0")).click();
		System.out.println("7");
		Thread.sleep(1000);
		driver.findElement(By.id("roundOffLevel")).click();
		System.out.println("8");
		driver.findElement(By.id("roundOffLevelOptions0")).click();
		System.out.println("9");
		driver.findElement(By.id("paramMaxPercBillSpecDisc")).click();
		driver.findElement(By.id("paramMaxPercBillSpecDisc")).clear();
		driver.findElement(By.id("paramMaxPercBillSpecDisc")).sendKeys("90");
		if (SaveData) {
			driver.findElement(By.id("paramSaveBtn")).click();
		} else {
			driver.findElement(By.id("closeBillingParams")).click();
			Thread.sleep(1000);
		}

	}

	public static void currencyexchangerate() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currencyexchangerate")));
		driver.findElement(By.id("currencyexchangerate")).click();
		System.out.println(1);
		Thread.sleep(1000);
		currencyexchangeratemodify(false);
		System.out.println(2);
		Thread.sleep(1000);

		currencyexchangerate(false);
		System.out.println(3);
		currencyexchangerate(true);
		System.out.println(4);
		Thread.sleep(5000);
		driver.findElement(By.id("applicationhome")).click();
		System.out.println(10);
	}

	public static void currencyexchangeratemodify(Boolean SaveData) throws InterruptedException {
		driver.findElement(By.id("CERActiveFromid")).click();
		driver.findElement(By.id("CERActiveFromid")).clear();
		action.moveToElement(driver.findElement(By.id("CERActiveFromid")));
		action.click();
		action.sendKeys("17-01-2017");
		action.perform();
		Thread.sleep(1000);
		driver.findElement(By.id("CERSearchBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("CERModifyBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("CERDetailValue1")).clear();
		driver.findElement(By.id("CERDetailValue1")).sendKeys("57");
		driver.findElement(By.id("CERDetailSaveBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("CERClearBtn")).click();
	}

	public static void currencyexchangerate(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("CERNewBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("CERDetailValue0")).clear();
		driver.findElement(By.id("CERDetailValue0")).sendKeys("45");
		driver.findElement(By.id("CERDetailValue1")).clear();
		driver.findElement(By.id("CERDetailValue1")).sendKeys("55");
		driver.findElement(By.id("CERDetailValue2")).clear();
		driver.findElement(By.id("CERDetailValue2")).sendKeys("65");
		driver.findElement(By.id("CERDetailValue3")).clear();
		driver.findElement(By.id("CERDetailValue3")).sendKeys("75");
		driver.findElement(By.id("CERDetailValue4")).clear();
		driver.findElement(By.id("CERDetailValue4")).sendKeys("95");
		if (SaveData) {
			driver.findElement(By.id("CERDetailSaveBtn")).click();
		} else {
			driver.findElement(By.id("CERDetailCancelBtn")).click();
			driver.findElement(By.cssSelector("md-dialog-actions button:nth-child(2)")).click();
			Thread.sleep(1000);
		}

	}

	public static void autochargeorders() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("autochargeorders")));
		driver.findElement(By.id("autochargeorders")).click();
		Thread.sleep(1000);
		autochargeordersmodify(false);
		Thread.sleep(1000);
		autochargeorders(false);
		autochargeorders(true);
		Thread.sleep(1000);
		driver.findElement(By.id("applicationhome")).click();
	}

	public static void autochargeordersmodify(Boolean SaveData) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ACDeptsAutoComp")));
		driver.findElement(By.cssSelector("#ACDeptsAutoComp input[type=\"search\"]")).sendKeys("o");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#ACDeptsAutoComp input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#ACDeptsAutoComp input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("ACInclInactive")).click();
		driver.findElement(By.id("ACSearchBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ACModifyBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ACDetailsOrderItem")));
		driver.findElement(By.cssSelector("#ACDetailsOrderItem input[type=\"search\"]")).click();
		driver.findElement(By.cssSelector("#ACDetailsOrderItem input[type=\"search\"]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#ACDetailsOrderItem input[type=\"search\"]")).sendKeys("v");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#ACDetailsOrderItem input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#ACDetailsOrderItem input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("ACDetailsSaveBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ACClearBtn")).click();
	}

	public static void autochargeorders(Boolean SaveData) throws InterruptedException {

		driver.findElement(By.id("ACNewBtn")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ACDetailsDept")));
		driver.findElement(By.cssSelector("#ACDetailsDept  input[type=\"search\"]"))
				.sendKeys("Obstetrics & Gynaecology");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#ACDetailsDept input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#ACDetailsDept  input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("ACDetailsENType")).click();
		driver.findElement(By.id("ACDetailsENTypeOptions0")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ACDetailsOrderItem")));
		driver.findElement(By.cssSelector("#ACDetailsOrderItem input[type=\"search\"]")).click();
		driver.findElement(By.cssSelector("#ACDetailsOrderItem input[type=\"search\"]")).clear();
		driver.findElement(By.cssSelector("#ACDetailsOrderItem input[type=\"search\"]")).sendKeys("v");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#ACDetailsOrderItem  input[type=\"search\"]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector("#ACDetailsOrderItem input[type=\"search\"]")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("ACDetailsStartTime")).sendKeys("10:10AM");
		driver.findElement(By.id("ACDetailsEndTime")).sendKeys("10:10PM");
		action.moveToElement(driver.findElement(By.id("ACDetailsActiveTo")));
		action.click();
		action.sendKeys("01-11-2017");
		action.perform();
		if (SaveData) {
			driver.findElement(By.id("ACDetailsSaveBtn")).click();
		}
		 else {
			driver.findElement(By.id("ACDetailsCancelBtn")).click();
			Thread.sleep(1000);
		}
		
	}
	
	
	