Feature: Web app navigation testing 
Background: 
	Given  I open ab.onliner.by 
	
	# As a user
	# I want to open main page
Scenario: Open Main page of ab.onliner.by 
	Then  I see main logo "Автобарахолка" 
		
	# As a guest
	# I want to open another subsection
	# And see main logo of subsection correct
Scenario: Open subsection of section autobaraholka 
	When  I click on section "Мото" 
	Then  I see main section moto logo "Мотобарахолка" 
