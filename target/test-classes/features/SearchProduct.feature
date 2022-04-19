Feature: Search and Order Products 

@ProductTest 
Scenario Outline: Search Product using shortname on both Landing Page and Top Deals Page 
	Given User is on GreenKart Landing Page 
	When User searches for a product with shortname <Name> and actual product name is extracted 
	And User also searches for a product on Top Deals page with the same shortname <Name> and actual product name is extracted 
	Then actual product name on both Landing Page and Top Deals Page should match 
	
	Examples: 
	
		|Name|
		|Tom|
		|Beet|