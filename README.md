Advanced Java Semester Project Proposal

Team Members - Parker Smith & Glynn Leininger

Project Name - Multiplayer Reflex Race

Project Description - Multiplayer Reflex Race is a spinoff of some traditional “party pack game”
  applications for various gaming consoles and mobile phones. It will incorporate a way for
  multiple connected users to race each other's reflex ability to respond to certain puzzles that
  appear on the client. Puzzle examples may include:
    ● A changing alphabet string that users have to interpret its order, and race to click when
      the alphabet order is correct
    ● An array of shapes that changes, users have to click when the array displays at least 5
      different types of shapes
    ● A maze puzzle that users have to race to determine whether or not point a is connected
      to point b
    ● Changing (simple) math equations that users have to race to click when the math
      equation is correct
    ● An array filled with + and - that changes every few seconds, and users have to race to
      click when there is “more + than -”

While the above puzzles are just examples of types of games, actual implementations will vary.
Many optimistically proposed ideas also include having a “party leader” that can select how
many games to play, or to play multiple games until any one user hits X amount of wins, etc.
Optimistically, an implementation of a “vote for your favorite game types” is also pursued, but
implementation of these additional features will vary in the final program (considering
implementation time). To reduce the network load of the server with multiple connected clients,
many elements of the program such as images will be distributed with the client program. The
server will then simply queue the client to display locally stored elements rather than
transmitting the elements over the network to multiple clients.

Projected Project Structure -
  Client
    ● GUI interface to allow users to see the puzzle and input their response/reaction
      either by GUI element or keyboard input (such as space bar or enter key)
    ● Show the number/names of players connected
    ● Add field for server IP/Password connection
    ● Allow users to type to each other throughout the game and at the end of each
      round
  Server
    ● Handling connected clients and sending the client’s username info to other
      connected players
    ● Choosing/managing the puzzle to be displayed to all clients
    ● Interpreting the winner of the puzzle based on the first user to respond/answer
      the puzzle.
    ● Displaying the winner to all connected players
    ● Responsible for managing the server chat functions (sending/receiving
      messages to/from clients)

Projected Challenges - This program will indeed have a few challenges. One of the largest
  challenges is going to be the concurrent management of multiple clients communication with the
  server, and multiple input/output streams for each client in regards to the chat client, game
  updates, winner updates, etc.; without compromising the performance of the server by running
  multiple infinite loops, for multiple threads, for each individual client.
