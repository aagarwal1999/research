# Research
Research Code I did during Junior Year high school and Freshman Year College. 

The idea of this project was to solve this Conjecture 2 in this paper found below: 

http://www.sciencedirect.com/science/article/pii/S0022404907001284

The code is not well documented at the moment, but I plan to do so soon. This project is currently in progress so updates will be made. 


Note: In the Sequence Class, I have an attribute Matrix. This is not the caley table of the graph, rather it is a mathematical construction specific to that sequence. This matrix allows for the calculation of the ordered sum-set of the sequence. Each row in the matrix is a group element, and each row is a length. The value in matrix[i][j] is 1 if there exists a sequence of length i that equals the value j.

The algorithm involved in solving this problem invovles iteratively calculating this matrix and only adding on values that do not yield a zero-sum of length n where n is the order of the dihedral group. 
