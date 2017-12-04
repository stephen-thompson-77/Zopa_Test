# Zopa_Test

## Criteria

* Lowest rate for the amount being borrowed is returned to the customer
	* Test required to check rate of amount being borrowed by customer
* If no adequate loan is available, the user is informed
* Loans are over a 36 month period
* System is command-line application
* Details show monthly repayment amount
* Details show total repayment amount
* Repayments are displayed to 2 decimal places
* Rate of loan displayed to 1 decimal place
* Loan requests must be a £100 increment between £1000 and £15000 (inclusive)
	* Test required for increments less or greater than min and max amounts
	* Test required for incorrect increment values
* Read in spreadsheet 
	* Test required for non-valid values being read in
	
## Assumptions made

* Loans can be made up from multiple lenders as long as it is the best rate
* Repayments to each lender will be made at their indiviual rates and the amount paid back is dependent on the amount borrowed
* Loan amounts are rounded to the nearest 10
* Partial amounts from lenders can be used to make up the difference from requests
	* Note: When making up difference use majority from lower rate before higher rates
* Total monthly compound interest is calculated by taking the loan amount (L), multiplying it by 1 + interest rate (IR) divided by the number of times interest is compounded per year (CpY), then find the power of the total number of months (TM) or:
	* Total Monthly compound interest = L ( 1 + IR/CpY) ^ TM
	* In the example given this would be: 1232.93 = 1000 * ( 1 +  (0.07 / 12)) ^ 36
	* Monthly payments would be: 34.25

### Assumptions made off of example

* Monthly repayments will be shown as a consistent value each month

## Tasks

1. Create test plan with acceptance criteria
2. Create skeleton implmentations:
	* File factory (factory impl)
		* File manager (inter)
		* CSV manager (impl)
	* Loan request manager 
	* Entities
		* Loan - lenders list, totalRate, totalAmount
		* Lender - name, rate, amount
	* ZopaApp
3. Write tests using skeletons
	* Loan request manager
		* Optimal loan tests
		* Invalid loan tests
	* File factory
		* File manager
			* Invalid input tests
			* Valid input tests
	* ZopaApp
		* Validity input tests
		* Invalidity input tests
4. Add passable implementation code
	* return/use concreate values
5. Add implementation for taking and processing inputs at start of program
	* file name
	* amount to borrow
6. Add file reading implementation
	* create factory (future proofing)
	* read csv
	* grab data
7. Create optimal loan for requested amount based on rate logic.
8. Carry out functional testing
9. Fix and refactor where required.

## Functional Testing

### Acceptance criteria

Given I have a lender A with an amount of 350, a rate of 4% and another lender B with an amount of 540, a rate of 10% and a lender C with 260 with a rate of 5%, when I enter a loan request of 250, then I am given the loan at 4.0% from lender A.
Given I have a lender A with an amount of 350, a rate of 4% and another lender B with an amount of 540, a rate of 10% and a lender C with 260 with a rate of 5%, when I enter a loan request of 500, then I am given the loan at 9.0% from lender A and C.
Given I have a lender A with an amount of 350, a rate of 4% and another lender B with an amount of 540, a rate of 10% and a lender C with 260 with a rate of 5%, when I enter a loan request of 1500, then I am informed that it is not possible to complete.


	
