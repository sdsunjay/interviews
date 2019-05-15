# import random module
import random

def create_board():
    board = []
    for i in  range(0, 5):
        board.append(["0"] *5)
    return board

def print_board(board):
    for i in board:
        print(" ".join(i))

def random_row(board):
    return random.randint(0,len(board)-1)

def random_col(board):
    return random.randint(0, len(board[0])-1)

def guess(board, ship_row, ship_col):

    tries = 0
    while(tries < 3):
        print("Turn: " + str(tries+1))
        guess_row = int(input("Guess Row: "))
        while guess_row < 0 or guess_row > 4:
            print("Oops, that's not even in the ocean")
            guess_row = int(input("Guess Row: "))

        guess_col = int(input("Guess Col: "))
        while guess_col < 0 or guess_col > 4:
            print("Oops, that's not even in the ocean")
            guess_col = int(input("Guess Col: "))
        # print(ship_row)
        # print(ship_col)
        if guess_row == ship_row and guess_col == ship_col:
            print("Congratulations! You have hit my battleship!")
            break
            # ship_row = random_row(board)
            # ship_col = random_col(board)
        else:
            if guess_row == ship_row:
                print("You missed my battleship! (row is correct)")
            elif guess_col == ship_col:
                print("You missed my battleship! (col is correct)")
            else:
                print("You missed my battleship!")

            if board[guess_row][guess_col] == "X":
                print("You've guessed that one already!")
                tries-=1
            if tries == 3:
                print("Game Over")

            board[guess_row][guess_col] = "X"
            print_board(board)
        tries+=1
    return 0

def main():
    board = create_board()
    print_board(board)
    ship_row = random_row(board)
    ship_col = random_col(board)
    guess(board, ship_row, ship_col)

if __name__ == '__main__':
    # use test_main to create tables and genres
    # test_main()
    main()
