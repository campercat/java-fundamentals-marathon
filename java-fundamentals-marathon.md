## Getting Started

```no-highlight
et get java-fundamentals-marathon
cd java-fundamentals-marathon
idea .
```

In this challenge, we're going to create a command line cash register.

## User Stories

## Start With Money in the Drawer

```no-highlight
As a cashier
I want to start with a certain amount of money
So that I can provide customers with change
```

Acceptance Criteria:

- When I launch the cash register, it asks me how much money I have
- I should store the user's input in a variable

## Require a Value

```no-highlight
As a cashier
I want to receive an error message
If I don't specify a value for the register's starting amount
```

Acceptance Criteria:

- If I enter a blank value, the register outputs an error and then terminates

## Prompt Until a Value is Supplied

```no-highlight
As a cashier
I want to be asked to supply a starting value continuously
So that I can launch the program successfully
```

Acceptance Criteria:

- If I continue to provide blanks for our starting cash register value, I am repeatedly asked to specify a value

## Balance Last Night's Receipts!

```no-highlight
As a cashier
I want to take my coworker's outstanding receipts from last night (after the cash register was closed up)
And update my available balance in the drawer
```

Acceptance Criteria:

- Read in `outstandingReceipts.txt` and calculate the updated register balance by adding all of the additional payments found in the file to the starting balance provided previously
- Display the updated register balance to the cashier

## Ask How Much the Order Cost

```no-highlight
As a cashier
I want to be asked how much the customer's order is
So that I can use it later to calculate change due
```

Acceptance Criteria:

- After supplying a starting cash value and seeing the updated value after balancing last night's receipts, I'm asked how much the customer's order is
- If I enter a blank value, I am asked again to specify the customer's order cost

## Clean Up Our Code

```no-highlight
As a developer
I want to remove repetition from my code
To keep it as DRY as possible!
```

Acceptance Criteria:

- We're now doing the same kind of prompting twice. Refactor your code to make this more DRY!

Implementation Detail:

- Extract a method `getMoneyValue` that takes a single argument, the `prompt`, and returns a `double`
- The method should continuously ask for a value until one is supplied
- Refactor existing functionality to utilize this method

## Ask How Much Cash the Customer Provided

```no-highlight
As a cashier
I want to supply how much the customer provided
So that I can later calculate the change
```

Acceptance Criteria:

- After supplying the customer's order cost, I'm asked how much cash the customer provided
- If I enter a blank value I am asked again to specify the cash the customer provided

Implementation Detail:

- Use the previously established `getMoneyValue` method to make this work

## Ensure the Customer Provided Enough Cash

```no-highlight
As a cashier
I want to be alerted if the customer didn't provide enough money
So that I can request more funds
```

Acceptance Criteria:

- The customer has to provide at least as much as the order costs
- If the customer does not provide enough, continuously prompt the cashier to enter a larger amount

## Output the Change

```no-highlight
As a cashier
I want to know the amount due back to the customer
So that I don't have to do mental math
```

Acceptance Criteria:

- Calculate the amount of money due back to the customer
- Provide that value back to the cashier so they know how much to give back to the customer

## Handle for the Change Due Exceeding Amount in Register

```no-highlight
As a cashier
I want to be alerted if I can't provide enough cash
So that I don't process the customer's order
```

Acceptance Criteria:

- If I don't have enough change in the register, continuously ask that the customer provide cash closer to the amount due

## Non-core User Stories

### Write a `receipt.txt`

```no-highlight
As a cashier
I want to log the transaction details
So that the customer can have a permanent record
```

Acceptance Criteria:

- The amount due, the cash provided, and the change provided is logged to a `receipt.txt` file

### Loop to Process Another Order

```no-highlight
As a cashier
I want to process another order
So that I can continue to process orders
```

Acceptance Criteria:

- After the cashier has been presented with the change due, add the cash paid to the total amount in the register
- After the cashier has been presented with the change due, ask them for another order total so they can process the change due

### Exit the Register Program

```no-highlight
As a cashier
I want to terminate my session at the end of my shift
So that no one fraudulently processes orders
```

- Change the behavior so that after the cashier has been presented for the change due, they're asked if they have another order for processing.
- Instruct the user that typing "exit" will exit the program.
- If the user types "exit", the program should terminate. Otherwise, it should continue asking for order information.
