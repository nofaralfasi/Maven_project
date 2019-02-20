# Parking-Lot
Project: Parking Lot - Parking Lot

Background to the project, which includes a description of the problem that the project came to solve:
Tracking the status of parking spaces in the parking lot. Status can be: Save, Busy, Busy.
The problem: There are a limited number of parking spaces in the parking lot, which we have to accommodate according to their requests.
The project will manage parking spaces for its customers, while maintaining the parking rules so that there will not be two cars parked adjacent to each other, in order to avoid blocking situations.

Project Goals:
Ongoing management of the parking lot: Providing parking space for customers at the parking lot, reserving parking status in the parking lot, and at any given time keeping the number of places reserved and the number of places available.
It is possible to park in a certain parking location only if the place is available, and in addition, all the places adjacent to it (including diagonals) are available.

Description Project Planning:
Objects representing the parking spaces.
2. Object representing the parking lot. This object will preserve in the two-dimensional array the parking spaces in the parking lot.
3. Main Menu Displays the actions that the user can choose to perform, receive his selection and set it up.
4. A function that receives a location in the parking lot, and checks whether it is available to store in it.
5. Recursive function that calculates the available parking spaces in the row that the user chooses in the parking lot.
6. An object representing a parking space. This object will retain its location in the parking lot (column and column), and its current status (Busy, Busy or Save).

Description of app usage scenarios - at least two different usage scenarios:
1. The user chooses to park his car in the parking lot.
The program will ask him to enter his name and the place where he wants to shop. The program will calculate and print an appropriate notice to the user informing him whether the parking is available or not.
2. The user chooses to reserve parking space in the parking lot. The program will ask you to choose a parking space, and you will receive it from the user. The program will calculate and print an appropriate notice to the user informing him whether or not the parking space can be reserved for him.
3. The user chooses to park his car in a parking space reserved for another customer.
The program will check that the name of the customer who saved the parking space is not compatible with the current customer, and will print a suitable message.
4. The user chooses to remove his vehicle from a parking location. The system recognizes the parking space (column and row) from the user and makes the relevant changes.
