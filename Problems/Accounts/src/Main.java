// you need to filter List<Account> accounts

List<Account> nonEmptyAccounts = filter(accounts, account -> account.getBalance() > 0 );// write your code here

List<Account> accountsWithTooMuchMoney = filter(accounts, account -> account.getBalance() >= 100_000_000
        & account.isLocked() == false );// write your code here

// just an example
// List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
// List<Integer> evenNumbers = filter(numbers, number -> number % 2 == 0);