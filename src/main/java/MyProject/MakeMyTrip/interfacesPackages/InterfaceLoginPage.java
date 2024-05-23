package MyProject.MakeMyTrip.interfacesPackages;

public interface InterfaceLoginPage {

    public void verifyLoginPage();
	
	default void verifyPersonalAccountType() {
		System.out.println("This is verify personal account type");
		
	};
	
	default void verifyMyBizAccountType() {
		System.out.println("This is verify my biz account type");
	}
	
	public void loginWithPersonalAccountType();
	
	public void mobileVerifycontinueButton();
	
	public void verifyLoginPerAccouErrorMessage();
	
	public void loginWithMyBizAccountType();
	
	public void emailVerifyContinueButton();
	
	public void verifyEmailIdErrorMessage();

}
