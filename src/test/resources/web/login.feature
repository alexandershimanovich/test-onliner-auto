Feature: Web app login testing 
Background: 
	Given I open ab.onliner.by 
	And I click button Entry 
	
	# As a user
	# I want to login
Scenario: Correct Login 
	And I enter credentials "test.test33@mail.ru" and "Qwerty1234" 
	And I click button Submit 
	Then I redirect to profile page with title "Профиль" 
	
	# As a user
	# I want to login but with uncorrect credentials
	# And see error message	
Scenario: UnCorrect Login 
	When I enter uncorrect credentials "test@mail.ru" and "Qwerty1234" 
	And I click button Submit 
	Then I see error message uncorrect login or password 
	
	# As a user
	# I want to register
	# And I click button Register and redirect to register page
Scenario: Registering is available 
	When I click button 'Register on onliner' 
	Then I redirect to register page and see button "Зарегистрироваться" 
	
	# As a user
	# I want to recover my password with correct Credentials
	# And I click button Recover password and redirect to recover page
Scenario: Recovering with correct credential is available 
	When I click button 'I dont remember password' 
	And I enter correct email "test.test33@mail.ru" and click button 'Further' 
	Then I see success recover message
	
	# As a user
	# I want to recover my password with uncorrect Credentials
	# And I click button Recover password and redirect to recover page
Scenario: Recovering with un correct credential is available 
	When I click button 'I dont remember password' 
	And I enter uncorrect email "test@mail.ru" and click button 'Further' 
	Then I see error recover message