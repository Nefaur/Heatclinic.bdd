package com.heatclinic.pages;



public class PageManager {

	private static PageManager instance;
	private HomePage home;
	private LoginPage login;
	private MemberPage member;
	private SearchFunction search;
	private ProductPage product;
	private CartPage cart;
	private CheckoutPage checkOut;

	private PageManager() {
	}
	
	public static PageManager getInstance() {
		return	(instance==null)? instance=new PageManager():instance;
		}
	
		public HomePage getHome() {
			return (home==null)? home=new HomePage():home;
		}
			
		public LoginPage getLogin() {
			return (login==null)? login=new LoginPage():login;
		}
	
		public MemberPage getMember() {
			return (member==null)? member=new MemberPage():member;
		}
		
		public SearchFunction getSearch() {
			return (search==null)? search=new SearchFunction():search;
		}
		
		public ProductPage getProductPage() {
			return (product==null)? product=new ProductPage():product;
		}
		
		public CartPage getCartPage() {
			return (cart==null)? cart=new CartPage():cart;
		}
		
		public CheckoutPage getCheckoutPage() {
			return (checkOut==null)? checkOut=new CheckoutPage():checkOut;
		}
		
		public void closePages() {
			home=null;
			login=null;
			member=null;
			search=null;
			product=null;
			cart=null;
			checkOut=null;
		}
}
