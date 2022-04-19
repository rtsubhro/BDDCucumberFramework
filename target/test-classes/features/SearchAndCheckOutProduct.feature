Feature: Search, Add to Cart And Check Out Products 

@CheckoutTest
Scenario Outline: Search Product using shortname and Add to Cart and Checkout Product 
	Given User is on GreenKart Landing Page 
	When User searches for a product with shortname <Name> and actual product name is extracted 
	And User increments the Quantity <Increment> times and Adds to Cart 
	And User clicks on Cart 
	And User Proceeds to Checkout 
	And Product Name and Quantity on Checkout Page are extracted 
	Then Product Name on both Landing Page and Checkout Page should match 
	And Quantity on Checkout Page should equal <Increment> plus One 
	And Apply button should be visible on Checkout Page
	And Place Order button should be visible on Checkout Page 
	
	Examples: 
		|Name|Increment|
		|Tom|3|
		|Beet|2|	