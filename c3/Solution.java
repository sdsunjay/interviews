// Requirements:
// 1. Users can only borrow up to 3 books for up to 10 days
// 2. Users can only renew each borrowed book up to 2 times
// 3. Each book title will have many copies with a unique barcode. For example, the title "Harry Potter 1" can have 5 copies with different barcode

// User Stories:
// 1. User checks out the book called "Harry Potter 1" with barcode '1234' on January 1st
// 2. User renews it 5 days after he borrowed the book on January 5th
// 3. User returns the book on January 15th

// Question:
// Design the data model around the library book reservation system that works for the user stories above




  User
    numBooksCheckOut
    moneyOwed
    payFine(moneyPaid)

    id
    checkout(title)
      // check if they already have 3 books checkout already
      if(numBooksCheckOut < 3) {
        // check if the library has the book
        book = Library.checkExists(title);

        //check if the book has stock (enough copies available)
        if (book) {
          bookCopies = book.getBookCopies();
        }

        // get the first available copy
        do while (bookCopies as bookCopy && !availableCopy) {
          if(System.bookCanCheckout(bookCopy) {
            availableCopy = bookCopy
          }
        }

        if (availableCopy) {

          // add a new record with the checkout type
          // update the numBooksCheckOut
        }
      }


  Book
    Id
    Title
    function getBookCopies()
        //return all bookCopies

  BookCopy
    BookId -> Book.id
    Barcode

  Library
    function checkExists(title)
    has_many books
    has_many users

  System
    BookCopy_id
    User_id
    ActionDate
    ActionType = enum("return", "checkout", "renew")

    function bookCanCheckout(bookCopyId){
      checkouts = the checkout records

      returns = get the return records
      return returns.count == checkouts.count
    }

    // cron job
    function updateFines(user_id){
     checkouts = the checkout records where the due date has past
     returns = get all the return records
     fine = 0
     if (returns.count != checkouts.count)
      numOverdue = checkOuts.count - returns.count
      for each book that is overdue
        bookNumDaysOverdue = computeDaysOverDue(bookduedate, todaysdate)
        fine+= 2* bookNumDaysOverdue

    return fine

    }



  Renew
    book_id user_id

    // before we insert into Renew, check that this user and this book, hasnt been renew more than twice
    // after insert, update dueDate



